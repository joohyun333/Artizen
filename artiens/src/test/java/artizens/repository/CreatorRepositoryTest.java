package artizens.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import artizens.domain.Creator;
import artizens.domain.UserProfile;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CreatorRepositoryTest {
	
	@Autowired private UserProfileRepository userProfileRepository;
	@Autowired private CreatorRepository creatorRepository;
	
	private UserProfile createUserTest() {
		return UserProfile.createUser("email", "1234", "dlwngus");
	}
	
	private Creator createCreatorTest(UserProfile userProfile) {
		return Creator.createCreator("creatorName", "otherUri", userProfile);
	}
	
	@Test
	void findCreatorByUserProfileTest() {
		UserProfile userProfile = userProfileRepository.save(createUserTest());
		Creator creator = creatorRepository.save(createCreatorTest(userProfile));
		
		List<Creator> creators = creatorRepository.findAllByUserProfileId(userProfile.getId());
		Assertions.assertThat(creator).isEqualTo(creators.get(0));
	}

}