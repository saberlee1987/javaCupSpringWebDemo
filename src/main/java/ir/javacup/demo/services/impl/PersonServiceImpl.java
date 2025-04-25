package ir.javacup.demo.services.impl;

import ir.javacup.demo.domain.api.*;
import ir.javacup.demo.domain.entity.Person;
import ir.javacup.demo.domain.excemptions.BusinessException;
import ir.javacup.demo.domain.mappers.PersonMapper;
import ir.javacup.demo.repository.PersonRepository;
import ir.javacup.demo.services.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Override
    @Transactional
    public PersonSaveResponse savePerson(PersonSaveRequest request) {
        log.info("request save person ===> {}", request);
        Person person = personMapper.requestDtoToModel(request);
        personRepository.save(person);
        log.info("response save person ===> {}", person);
        return PersonSaveResponse.builder()
                .personId(person.getId())
                .build();
    }

    @Override
    @Transactional
    public PersonDto updatePerson(PersonSaveRequest request) {
        log.info("request update person ===> {}", request);
        Person person = personMapper.requestDtoToModel(request);
        personRepository.save(person);
        log.info("response update person ===> {}", person);
        return personMapper.modelToDto(person);
    }

    @Override
    public PersonDto getPersonById(Long personId) {
        Person person = checkPersonExist(personId);
        return personMapper.modelToDto(person);
    }

    @Override
    public PersonResponseList getAllPersons() {
        return PersonResponseList.builder()
                .persons(personMapper.modelToDto(personRepository.findAll()))
                .build();
    }

    @Override
    @Transactional
    public PersonDeleteResponse deletePersonById(Long personId) {
        log.info("request delete person ===> {}", personId);
        personRepository.deleteById(personId);
        return PersonDeleteResponse.builder()
                .code(0)
                .text("person deleted successfully")
                .build();
    }

    @Override
    public void checkRulesForSaveOrUpdatePerson(PersonSaveRequest personSaveRequest) {
        if (personSaveRequest.getPersonId() != null) {
            checkPersonExist(personSaveRequest.getPersonId());
        }
        checkPersonDuplicate(personSaveRequest.getNationalCode(), personSaveRequest.getPersonId());
    }

    private void checkPersonDuplicate(String nationalCode, Long personId) {
        List<Person> persons = personRepository.findAllByNationalCode(nationalCode);
        if (personId != null) {
            persons = persons.stream().filter(p -> !p.getId().equals(personId)).toList();
        }
        if (!persons.isEmpty()) {
            throw new BusinessException(String.format("person by nationalCode %s already exist", nationalCode));
        }
    }

    public Person checkPersonExist(Long personId) {

        if (personId == null) {
            throw new BusinessException("personId is required");
        }
        Optional<Person> personOptional = personRepository.findById(personId);
        if (personOptional.isEmpty()) {
            throw new BusinessException(String.format("person by id %d notfound", personId));
        }
        return personOptional.get();
    }
}
