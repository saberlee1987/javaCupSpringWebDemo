package ir.javacup.demo.domain;

import ir.javacup.demo.domain.api.PersonSaveParam;

public interface PersonService {

	PersonSaveResult save(PersonSaveParam param);

}
