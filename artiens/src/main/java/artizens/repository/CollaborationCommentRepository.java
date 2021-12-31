package artizens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.CollaborationComment;

public interface CollaborationCommentRepository extends JpaRepository<CollaborationComment, Long> {

}
