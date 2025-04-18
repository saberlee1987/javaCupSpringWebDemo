package ir.javacup.demo.domain.api;

import lombok.Data;

import java.util.List;
@Data
public class PersonResponseList {
    private List<PersonDto> persons;
}
