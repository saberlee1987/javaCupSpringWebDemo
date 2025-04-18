package ir.javacup.demo.services;

import ir.javacup.demo.domain.api.*;

public interface PersonService {
    PersonSaveResponse savePerson(PersonSaveRequest person);
    PersonDto updatePerson(PersonSaveRequest person);
    PersonDto getPersonById(Long id);
    PersonResponseList getAllPersons();
    PersonDeleteResponse deletePersonById(Long id);

}
