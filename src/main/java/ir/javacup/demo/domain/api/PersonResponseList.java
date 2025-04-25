package ir.javacup.demo.domain.api;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Builder
@Data
public class PersonResponseList {
    private List<PersonDto> persons;
}
