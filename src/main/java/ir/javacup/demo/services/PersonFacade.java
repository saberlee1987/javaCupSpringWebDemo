package ir.javacup.demo.services;

import ir.javacup.demo.domain.api.*;
import ir.javacup.demo.domain.excemptions.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonFacade {

    private final PersonService personService;

    public PersonSaveResponse savePerson(PersonSaveRequest request) {
        request.setPersonId(null);
        personService.checkRulesForSaveOrUpdatePerson(request);
        return personService.savePerson(request);
    }

    public PersonDto updatePerson(PersonSaveRequest request) {
        if (request.getPersonId() == null) {
            throw new BusinessException("personId is required");
        }
        personService.checkRulesForSaveOrUpdatePerson(request);
        return personService.updatePerson(request);
    }

    public PersonDto getPersonById(Long personId) {
        return personService.getPersonById(personId);
    }

    public PersonResponseList getAllPersons() {
        return personService.getAllPersons();
    }

    public PersonDeleteResponse deletePersonById(Long personId) {
        personService.checkPersonExist(personId);
        return personService.deletePersonById(personId);
    }
}
