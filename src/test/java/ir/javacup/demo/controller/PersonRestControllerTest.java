package ir.javacup.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ir.javacup.demo.controller.api.PersonSaveRequest;
import ir.javacup.demo.domain.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class PersonRestControllerTest {

	@Autowired
	protected MockMvc mvc;

	@MockBean
	PersonService personService;

	@Test
	public void test_person_save__rest_controller() throws Exception {
		PersonSaveRequest request = PersonSaveRequest.builder()
				.firstName("Ali")
				.lastName("Ahmadi")
				.nationalCode("1232323233")
				.build();

		// mock service
		PersonSaveResult serviceResult = new PersonSaveResult();
		serviceResult.setPersonId(10);
		Mockito.when(personService.save(any())).thenReturn(serviceResult);

		mvc.perform(post("/person")
				.content(toJson(request))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.personId").value(serviceResult.getPersonId()));
	}

	protected String toJson(Object obj) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(obj);
	}

}