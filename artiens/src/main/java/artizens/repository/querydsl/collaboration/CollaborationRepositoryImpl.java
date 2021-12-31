package artizens.repository.querydsl.collaboration;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;

import static artizens.domain.QCreator.creator;
import static artizens.domain.QCollaboration.collaboration;
import static artizens.domain.QCollaborationArtWork.collaborationArtWork;


public class CollaborationRepositoryImpl implements CollaborationRepositoryQueryDsl{
	
	private final EntityManager entityManager;
	private final JPAQueryFactory queryFactory;
	
	public CollaborationRepositoryImpl(EntityManager em) {
		this.entityManager = em;
		this.queryFactory = new JPAQueryFactory(entityManager);
	}
	
	@Override
	public List<CollaborationArtWorkDto> findAllColArtWorkByCollaboration(Pageable pageable, Long collaborationId) {
		return queryFactory
				.select(Projections.constructor(CollaborationArtWorkDto.class,
						collaborationArtWork.id,
						collaborationArtWork.title,
						collaborationArtWork.storeFileName,
						creator.id,
						creator.uploadFile.storeFileName,
						collaborationArtWork.registerDate,
						creator.nickName))
				.from(collaborationArtWork)
				.where(collaborationArtWork.collaboration.id.eq(collaborationId))
				.leftJoin(collaborationArtWork.creator, creator)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
	}
	@Override
	public List<CollaborationArtWorkDto> findAllColWinnerArtWorkByCollaboration(Pageable pageable, Long collaborationId) {
		return queryFactory
				.select(Projections.constructor(CollaborationArtWorkDto.class,
						collaborationArtWork.id,
						collaborationArtWork.title,
						collaborationArtWork.storeFileName,
						creator.id,
						creator.uploadFile.storeFileName,
						collaborationArtWork.registerDate,
						creator.nickName))
				.from(collaborationArtWork)
				.where(collaborationArtWork.collaboration.id.eq(collaborationId).and(collaborationArtWork.winner.eq(true)))
				.leftJoin(collaborationArtWork.creator, creator)
				.offset(pageable.getOffset())
				.limit(pageable.getPageSize())
				.fetch();
	}
	
	@Override
	public CollaborationInfoDto findCollaborationById(Long collaborationId) {
		return queryFactory
				.select(Projections.constructor(CollaborationInfoDto.class,
						collaboration.id,
						collaboration.title,
						creator.id,
						creator.nickName,
						creator.uploadFile.storeFileName,
						collaboration.registerDate,
						collaboration.deadlineDate,
						collaboration.evaluate))
				.from(collaboration)
				.where(collaboration.id.eq(collaborationId))
				.leftJoin(collaboration.creator, creator)
				.fetchOne();
	}
	
	
}
