package artizens;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.querydsl.jpa.impl.JPAQueryFactory;

import artizens.ArtiensApplication;
import artizens.domain.Creator;
import artizens.domain.QCreator;
import artizens.domain.QReward;
import artizens.domain.Reward;

import static artizens.domain.QCreator.creator;

@Transactional
@SpringBootTest(classes = ArtiensApplication.class)
class ArtiensApplicationTests {
	
	@PersistenceContext
	EntityManager em;
	
	@Test
	void contextLoads() {
		Reward reward = new Reward();

		JPAQueryFactory query = new JPAQueryFactory(em);
		QReward reward2 = new QReward("h");

		Reward result = query
				.selectFrom(reward2)
				.fetchOne();
		
		Assertions.assertThat(result).isEqualTo(reward);
		Assertions.assertThat(result.getId()).isEqualTo(reward.getId());
	}

}
