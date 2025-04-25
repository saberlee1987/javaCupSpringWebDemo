package ir.javacup.demo.services;

import ir.javacup.demo.domain.api.*;
import ir.javacup.demo.domain.entity.Person;

public interface PersonService {
    PersonSaveResponse savePerson(PersonSaveRequest person);
    PersonDto updatePerson(PersonSaveRequest person);
    PersonDto getPersonById(Long id);
    PersonResponseList getAllPersons();
    PersonDeleteResponse deletePersonById(Long id);

    void checkRulesForSaveOrUpdatePerson(PersonSaveRequest personSaveRequest);
    Person checkPersonExist(Long personId);
}
