package artizens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Patron;
import artizens.repository.querydsl.patron.PatronRepositoryQueryDsl;

public interface PatronRepository extends JpaRepository<Patron, Long>, PatronRepositoryQueryDsl{
	
	List<Patron> findAllByCreatorId(Long creatorId);

}
