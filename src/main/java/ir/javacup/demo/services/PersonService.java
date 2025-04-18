package ir.javacup.demo.services;

import ir.javacup.demo.domain.api.*;

public interface PersonService {
    PersonSaveResponse savePerson(PersonSaveParam person);
    PersonDto updatePerson(PersonSaveParam person);
    PersonDto getPersonById(Long id);
    PersonResponseList getAllPersons();
    PersonDeleteResponse deletePersonById(Long id);

}
