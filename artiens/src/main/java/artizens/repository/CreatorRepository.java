package artizens.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Creator;

public interface CreatorRepository extends JpaRepository<Creator, Long>{
	List<Creator> findAllByUserProfileId(Long userProfileId);
	List<Creator> findAllByNickName(String creatorNickName);
}
