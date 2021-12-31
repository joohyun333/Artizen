package artizens.repository.querydsl.reward;

import java.util.List;

import org.springframework.data.domain.Pageable;


public interface RewardRepositoryQueryDsl {
	// 모든 Reward 조회
	List<RewardCreatorDto> findAllRewardWithCreator(Pageable pageable); 
	
	// 아이템별로 Reward 조회
	List<RewardCreatorDto> findByRewardItemWithCreator(Pageable pageable, String itemName);
	
	// reward id로 reward image 추출
	List<RewardImageDto> findRewardImages(List<Long> rewardIds);
}
