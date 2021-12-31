package artizens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.ArtWork;

public interface ArtWorkRepository extends JpaRepository<ArtWork, Long>{

}
