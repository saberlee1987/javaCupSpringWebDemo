package ir.javacup.demo.controller.api;

import ir.javacup.demo.domain.api.PersonSaveRequest;
import ir.javacup.demo.domain.api.PersonSaveResponse;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonRestController {

	public PersonSaveResponse save(PersonSaveRequest request) {
		return null; // TODO implement
	}

}
