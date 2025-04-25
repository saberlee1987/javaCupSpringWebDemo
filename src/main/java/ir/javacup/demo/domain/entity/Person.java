package ir.javacup.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "persons")
public class Person implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName", length = 70)
    private String firstName;
    @Column(name = "lastName", length = 70)
    private String lastName;
    @Column(name = "nationalCode", length = 10, unique = true)
    private String nationalCode;
    @Column(name = "age")
    private Integer age;
    @Column(name = "mobile", length = 11)
    private String mobile;
    @Column(name = "email", length = 30)
    private String email;
}
