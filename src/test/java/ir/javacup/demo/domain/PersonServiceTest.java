package ir.javacup.demo.domain;

import ir.javacup.demo.domain.api.PersonSaveParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@DataJpaTest
@Transactional
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class PersonServiceTest {

	@Autowired
	PersonService personService;

	@TestConfiguration
	@ComponentScan("ir.javacup.demo")
	public static class PersonServiceTestConfiguration {
	}

	@Test
	public void test_person_save__service() {
		PersonSaveParam param = PersonSaveParam.builder()
				.firstName("Ahmad")
				.lastName("Rezayi")
				.nationalCode("1232323231")
				.build();
		PersonSaveResult result = personService.save(param);
		assertTrue(result.getPersonId() > 0);
	}

}