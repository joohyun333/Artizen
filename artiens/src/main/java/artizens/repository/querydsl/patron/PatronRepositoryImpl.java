package artizens.repository.querydsl.patron;

import java.util.List;

import javax.persistence.EntityManager;


import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static artizens.domain.QCreator.creator;
import static artizens.domain.QPatron.patron; 
import static artizens.domain.QReward.reward; 
import static artizens.domain.QPatronImages.patronImages;
import static artizens.domain.QRewardImages.rewardImages;


public class PatronRepositoryImpl implements PatronRepositoryQueryDsl{
	
	private final EntityManager entityManager;
	private final JPAQueryFactory queryFactory;
	
	public PatronRepositoryImpl(EntityManager em) {
		this.entityManager = em;
		this.queryFactory = new JPAQueryFactory(entityManager);
	}
	
	// patron 생성 일시 순으로 생성
	@Override
	public List<PatronCreatorDto> findAllPatornWithCreator(Pageable pageable){
		return queryFactory.
				select(Projections.constructor(PatronCreatorDto.class,
						patron.id,
						patron.title,
						patron.content,
						patron.createdDate,
						creator.nickName,
						creator.uploadFile.storeFileName))
				.from(patron)
				.leftJoin(patron.creator, creator)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.orderBy(patron.createdDate.desc())
				.fetch();
	}
	
	@Override
	public List<PatronImagesDto> findAllPatronImagesInPatron(List<Long> patronIds){
		return queryFactory.select(Projections.constructor(PatronImagesDto.class, 
				patronImages.patron.id,
				patronImages.uploadFile.storeFileName))
		.from(patronImages)
		.where(patronImages.patron.id.in(patronIds))
		.fetch();
	}
	
	@Override
	public List<PatronImagesDto> findPatronImagesInPatron(Long patronId) {
		return queryFactory.select(Projections.constructor(PatronImagesDto.class, 
				patronImages.patron.id,
				patronImages.uploadFile.storeFileName))
		.from(patronImages)
		.where(patronImages.patron.id.eq(patronId))
		.fetch();
	}
	
	@Override
	public PatronCreatorRewardDto findPersonalPatron(Long patronId) {
		return queryFactory.select(Projections.constructor(PatronCreatorRewardDto.class, 
				patron.id,
				patron.title,
				patron.content,
				creator.nickName,
				patron.createdDate,
				creator.uploadFile.storeFileName))
				.from(patron)
				.where(patron.id.eq(patronId))
				.leftJoin(patron.creator, creator)
				.fetchOne();
	}
	
	@Override
	public List<RewardDto> findRewardByPatron(Long patronId) {
		return queryFactory.select(Projections.constructor(RewardDto.class, 
				reward.id,
				reward.title,
				reward.content,
				reward.subject,
				reward.price))
				.from(reward)
				.where(reward.patron.id.eq(patronId))
				.fetch();
	}
	
	@Override
	public List<RewardImagesDto> findAllRewardImagesInPatron(List<Long> rewardIds) {
		return queryFactory.select(Projections.constructor(RewardImagesDto.class, 
				rewardImages.reward.id,
				rewardImages.uploadFile.storeFileName))
				.from(rewardImages)
				.where(rewardImages.reward.id.in(rewardIds))
				.fetch();
	}
}
