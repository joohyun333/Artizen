package artizens.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import artizens.controller.UserProfileController;
import artizens.domain.Patron;
import artizens.domain.Reward;
import artizens.domain.UploadFile;
import artizens.repository.RewardRepository;
import artizens.repository.querydsl.patron.PatronImagesDto;
import artizens.repository.querydsl.reward.RewardCreatorDto;
import artizens.repository.querydsl.reward.RewardImageDto;

@Service
@Transactional(readOnly = true)
public class RewardService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RewardService.class);
	@Autowired RewardRepository rewardRepository;
	
	@Transactional
	public Reward registerReward(
			String title, 
			String content,
			int price,
			String subject, 
			Patron patron,
			List<UploadFile> rewardImages) {
		return rewardRepository.save(Reward.createReward(title, content, price, subject, patron, rewardImages));
	}
	
	public Page<RewardCreatorDto> totalRewardView(Pageable pageable){
		List<RewardCreatorDto> rewardResults = rewardRepository.findAllRewardWithCreator(pageable);
		List<Long> rewardResultsIds = rewardResults.stream().map(rewardResult -> rewardResult.getRewardId()).collect(Collectors.toList());
		List<RewardImageDto> rewardImageResults = rewardRepository.findRewardImages(rewardResultsIds);
		Map<Long, List<RewardImageDto>> rewardImageMap = rewardImageResults.stream().collect(Collectors.groupingBy(RewardImageDto::getRewardId));
		rewardResults.forEach(r -> r.setRewardFileName(rewardImageMap.get(r.getRewardId())));
		return new PageImpl<RewardCreatorDto>(rewardResults, pageable, rewardRepository.count());
	}
	
	public Page<RewardCreatorDto> RewardViewByItemName(Pageable pageable, String itemName){
		List<RewardCreatorDto> rewardResults = rewardRepository.findByRewardItemWithCreator(pageable, itemName);
		List<Long> rewardResultsIds = rewardResults.stream().map(rewardResult -> rewardResult.getRewardId()).collect(Collectors.toList());
		List<RewardImageDto> rewardImageResults = rewardRepository.findRewardImages(rewardResultsIds);
		Map<Long, List<RewardImageDto>> rewardImageMap = rewardImageResults.stream().collect(Collectors.groupingBy(RewardImageDto::getRewardId));
		rewardResults.forEach(r -> r.setRewardFileName(rewardImageMap.get(r.getRewardId())));
		return new PageImpl<RewardCreatorDto>(rewardResults, pageable, rewardRepository.countBySubject(itemName));
	}
	
}
