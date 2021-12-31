package artizens.repository.querydsl.patron;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface PatronRepositoryQueryDsl {
	
	List<PatronCreatorDto> findAllPatornWithCreator(Pageable pageable);
	
	List<PatronImagesDto> findAllPatronImagesInPatron(List<Long> patronIds);
	
	List<PatronImagesDto> findPatronImagesInPatron(Long patronId);
	
	PatronCreatorRewardDto findPersonalPatron(Long patronId);
	
	List<RewardDto> findRewardByPatron(Long patronId);
	
	List<RewardImagesDto> findAllRewardImagesInPatron(List<Long> rewardIds);
}
