package artizens.repository.querydsl.collaboration;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface CollaborationRepositoryQueryDsl {
	/**
	 * 참여작품들 가져오는 메서드
	 * @param pageable
	 * @return
	 */
	List<CollaborationArtWorkDto> findAllColArtWorkByCollaboration(Pageable pageable, Long collaborationId);
	
	/**
	 * 선정 작품들 가져오는 메서드
	 * @param pageable
	 * @return
	 */
	List<CollaborationArtWorkDto> findAllColWinnerArtWorkByCollaboration(Pageable pageable, Long collaborationId);

	
	CollaborationInfoDto findCollaborationById(Long collaborationId);
}
