package artizens.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import artizens.domain.UserProfile;


public interface UserProfileRepository extends JpaRepository<UserProfile, Long>  {
	List<UserProfile> findByEmail(String email);
    List<UserProfile> findByName(String name);
    List<UserProfile> findByEmailAndName(String email, String name);
}
