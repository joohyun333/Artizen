package artizens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Reward;
import artizens.repository.querydsl.reward.RewardRepositoryQueryDsl;

public interface RewardRepository extends JpaRepository<Reward, Long>, RewardRepositoryQueryDsl{
	
	long countBySubject(String subject);
}
