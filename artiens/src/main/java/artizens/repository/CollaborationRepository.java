package artizens.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Collaboration;
import artizens.repository.querydsl.collaboration.CollaborationRepositoryQueryDsl;
public interface CollaborationRepository extends JpaRepository<Collaboration, Long>, CollaborationRepositoryQueryDsl{
}
