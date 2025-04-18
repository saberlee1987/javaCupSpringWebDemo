package ir.javacup.demo.services.impl;

import ir.javacup.demo.domain.api.*;
import ir.javacup.demo.domain.mappers.PersonMapper;
import ir.javacup.demo.repository.PersonRepository;
import ir.javacup.demo.services.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    @Override
    public PersonSaveResponse savePerson(PersonSaveRequest person) {
        return null;
    }

    @Override
    public PersonDto updatePerson(PersonSaveRequest person) {
        return null;
    }

    @Override
    public PersonDto getPersonById(Long id) {
        return null;
    }

    @Override
    public PersonResponseList getAllPersons() {
        return null;
    }

    @Override
    public PersonDeleteResponse deletePersonById(Long id) {
        return null;
    }
}
