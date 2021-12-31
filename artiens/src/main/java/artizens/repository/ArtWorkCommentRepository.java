package artizens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.ArtWorkComment;

public interface ArtWorkCommentRepository extends JpaRepository<ArtWorkComment, Long>{

}
