package ir.javacup.demo.domain.mappers;

import ir.javacup.demo.domain.api.PersonDto;
import ir.javacup.demo.domain.api.PersonSaveRequest;
import ir.javacup.demo.domain.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper
public interface PersonMapper {
    PersonDto modelToDto(Person person);
    List<PersonDto> modelToDto(List<Person> persons);

    @Mapping(target = "id",source = "personId")
    Person requestDtoToModel(PersonSaveRequest personSaveRequest);

}