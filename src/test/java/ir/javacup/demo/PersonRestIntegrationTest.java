package ir.javacup.demo;

import ir.javacup.demo.controller.api.PersonSaveRequest;
import ir.javacup.demo.domain.api.PersonSaveResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class PersonRestIntegrationTest {

	@LocalServerPort
	int serverPort;

	@Test
	public void test_person_save__rest_integration() throws Exception {
		PersonSaveRequest request = PersonSaveRequest.builder()
				.firstName("Ali")
				.lastName("Ahmadi")
				.nationalCode("1232323233")
				.build();
		final String url = "http://localhost:" + serverPort + "/person";
		TestRestTemplate restTemplate = new TestRestTemplate();
		PersonSaveResponse response = restTemplate.postForObject(url, request, PersonSaveResponse.class);
		assertTrue(response.getPersonId() > 0);
	}

}

