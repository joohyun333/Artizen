package artizens.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import artizens.domain.UserProfile;

@Transactional
@SpringBootTest
public class UserProfileServiceTest {
	@Autowired EntityManager em;
	@Autowired UserProfileService userProfileService;
	
	@Test
	public void 회원가입() {
		UserProfile userProfile = UserProfile.createUser("email@email.com", "1234", "dlwngus");
		em.persist(userProfile);
		String joinTrue = userProfileService.join("email@email.com", "1234", "dlwngus");
		Assertions.assertThat(joinTrue).isEqualTo("alreadyEmail");
	}
	
}
