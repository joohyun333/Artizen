package artizens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.CollaborationArtWorkComment;

public interface CollaborationArtWorkCommentRepository extends JpaRepository<CollaborationArtWorkComment, Long> {

}
