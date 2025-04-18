package ir.javacup.demo.domain.api;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private Integer age;
    private String mobile;
    private String email;
}
