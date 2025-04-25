package ir.javacup.demo.repository;

import ir.javacup.demo.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findAllByNationalCode(String nationalCode);
}
