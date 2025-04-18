package ir.javacup.demo.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target(value = {ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE
,ElementType.PARAMETER,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NationalCodeValidator.class)
public @interface NationalCode {
    String message() default "Please Enter valid nationalCode";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
