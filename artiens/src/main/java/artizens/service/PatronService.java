package artizens.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import artizens.controller.PatronController;
import artizens.controller.dto.patron.PatronRegisterDto;
import artizens.domain.Creator;
import artizens.domain.Patron;
import artizens.domain.Reward;
import artizens.domain.UploadFile;
import artizens.domain.UserProfile;
import artizens.repository.CreatorRepository;
import artizens.repository.PatronRepository;
import artizens.repository.RewardRepository;
import artizens.repository.UserProfileRepository;
import artizens.repository.querydsl.patron.PatronCreatorDto;
import artizens.repository.querydsl.patron.PatronCreatorRewardDto;
import artizens.repository.querydsl.patron.PatronImagesDto;
import artizens.repository.querydsl.patron.RewardDto;
import artizens.repository.querydsl.patron.RewardImagesDto;
import artizens.web.aws.FileUploadService;

@Service
@Transactional(readOnly = true)
public class PatronService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PatronService.class);
	
	@Autowired PatronRepository patronRepository;
	@Autowired CreatorRepository creatorRepository;
	@Autowired RewardRepository rewardRepository;
	@Autowired UserProfileRepository userProfileRepository;
	
	@Autowired FileUploadService fileUploadService;
	@Autowired RewardService rewardService;
	
	
	public String patronRegisterCondition(Long userId) {
		//user의 id가 존재하는지 체크
		Optional<UserProfile> user = userProfileRepository.findById(userId);
		if (user == null) {
			return "noUser";
		}
		// user가 creator에 등록이 됐는지 체크
		List<Creator> creators = creatorRepository.findAllByUserProfileId(user.get().getId());
		if (creators.size() == 0) {
			return "noCreator";
		}
		// user가 creator로 등록이 됐으면서 Patron에 이미 등록이 됐는지 체크
		List<Patron> patrons = patronRepository.findAllByCreatorId(creators.get(0).getId());
		if (patrons.size() > 0 ) {
			return "alreadyPatorn";
		}
		return "accept";
	}
	
	@Transactional
	public String registerPatronAndReward(PatronRegisterDto patronRegisterDto) {
		
		// patron 이미지 aws s3 반환
		List<UploadFile> patronImages = new ArrayList<UploadFile>();
		if (patronRegisterDto.getPatronFiles().get(0).getSize() > 0) {
			patronImages = fileUploadService.uploadImages(patronRegisterDto.getPatronFiles());
		}
		else {
			patronImages.add(
					UploadFile.createUploadFile(
					"patronDefaultIm.JPG", 
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/0a334861-0a36-4df9-9b1a-9cb7a1118c17.JPG"
					));
		}
		
		List<Creator> creator = creatorRepository.findAllByNickName(patronRegisterDto.getPatronAuthor());
		if (creator.size() == 0) {
			return "fail";
		}
		// patron 저장
		Patron patron = patronRepository.save(Patron.createPatron(
				patronRegisterDto.getPatronTitle(),
				patronRegisterDto.getPatronContent(),
				creator.get(0),
				patronImages));
		
		// reward 이미지 aws s3 반환
		List<UploadFile> rewardImages = new ArrayList<UploadFile>();
		
		// 이미지가 없는 경우 default 이미지 input
		if (patronRegisterDto.getRewardFiles().get(0).getSize() > 0) {
			rewardImages = fileUploadService.uploadImages(patronRegisterDto.getRewardFiles());
		}
		else {
			rewardImages.add(
					UploadFile.createUploadFile(
					"rewardDefault.JPG", 
					"https://sunminki.s3.ap-northeast-2.amazonaws.com/c04a08bd-8ae3-44d8-9405-268e449eacdc.JPG"
					));
		}
		
		Reward reward = rewardService.registerReward(
				patronRegisterDto.getRewardTitle(), 
				patronRegisterDto.getRewardContent(),
				patronRegisterDto.getRewardPrice(), 
				patronRegisterDto.getRewardCategory(),
				patron,
				rewardImages);
		return "complete";
	}
	
	public Page<PatronCreatorDto> totalPatronView(Pageable pageable){
		// paging 적용 patron join creator 전체 
		List<PatronCreatorDto> patronResult = patronRepository.findAllPatornWithCreator(pageable);
		
		// patronResult의 id만 추출
		List<Long> patronIds = patronResult.stream().map(patronResults -> patronResults.getPatronId()).collect(Collectors.toList());
		
		// id 순서대로 image 추출 -> patronId 별로 grouping
		List<PatronImagesDto> patronImages = patronRepository.findAllPatronImagesInPatron(patronIds);
		Map<Long, List<PatronImagesDto>> patronImagesMap = patronImages.stream().collect(Collectors.groupingBy(PatronImagesDto::getPatronId));
		
		// PatronCreatorDto에 List<patronImage> 세팅
		patronResult.forEach(p -> p.setPatronStoredFiles((patronImagesMap.get(p.getPatronId()))));
		
		return new PageImpl<PatronCreatorDto>(patronResult, pageable, patronRepository.count());
	}
	
	public PatronCreatorRewardDto personalPatronView(Long patronId){
		PatronCreatorRewardDto patronResult = patronRepository.findPersonalPatron(patronId);
		if (patronResult == null) {
			return null;
		}
		List<PatronImagesDto> patronImages = patronRepository.findPatronImagesInPatron(patronResult.getPatronId());
		patronResult.setPatronImages(patronImages);
		
		List<RewardDto> rewardResult = patronRepository.findRewardByPatron(patronId);
		List<Long> rewardIds = rewardResult.stream().map(result -> result.getRewardId()).collect(Collectors.toList());
		List<RewardImagesDto> rewardImages = patronRepository.findAllRewardImagesInPatron(rewardIds);
		Map<Long, List<RewardImagesDto>> rewardImagesMap = rewardImages.stream().collect(Collectors.groupingBy(RewardImagesDto::getRewardId));
		rewardResult.forEach(r -> r.setRewardImages(rewardImagesMap.get(r.getRewardId())));
		
		patronResult.setRewards(rewardResult);
		
		return patronResult;
	}
	
}
