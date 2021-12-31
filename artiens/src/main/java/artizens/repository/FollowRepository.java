package artizens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long>{

}
