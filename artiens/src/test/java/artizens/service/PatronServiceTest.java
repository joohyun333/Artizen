package artizens.service;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import artizens.domain.Creator;
import artizens.domain.UserProfile;
import artizens.repository.querydsl.patron.PatronCreatorDto;
import artizens.repository.querydsl.patron.PatronCreatorRewardDto;
import artizens.repository.querydsl.patron.PatronImagesDto;

@Transactional
@SpringBootTest
class PatronServiceTest {
	
	@Autowired PatronService patronService;
	@Autowired EntityManager em;
	
	
	private UserProfile createUserTest() {
		return UserProfile.createUser("email", "1234", "dlwngus");
	}
	
	private Creator createCreatorTest(UserProfile userProfile) {
		return Creator.createCreator("creatorNamd", "otherUri", userProfile);
	}
	
//	@Test
	void patronRegister권한확인() throws Exception {
		
		UserProfile userProfile = createUserTest();
		em.persist(userProfile);
		Creator creator = createCreatorTest(userProfile);
		em.persist(creator);
		
		String accept = patronService.patronRegisterCondition(userProfile.getId());
		
		Assertions.assertThat(accept).isEqualTo("accept");
	}
	
//	@Test 
	void patron전체_뷰_확인() {
		PageRequest pageRequest = PageRequest.of(0, 5);
		Page<PatronCreatorDto> result = patronService.totalPatronView(pageRequest);
		for (PatronCreatorDto patronCreatorDto : result) {
			System.out.println(patronCreatorDto.toString());
			for (String patronfile : patronCreatorDto.getPatronStoredFiles()) {
				System.out.println(patronfile);
			}
		}
	}
	
	@Test
	void patron_개인_뷰_확인() {
		PatronCreatorRewardDto result = patronService.personalPatronView(100L);
		Assertions.assertThat(result).isEqualTo(null);
	}
	
	
	

}