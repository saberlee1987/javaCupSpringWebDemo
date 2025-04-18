package ir.javacup.demo.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NationalCodeValidator implements ConstraintValidator<NationalCode,String> {
    @Autowired
    private InputValidator inputValidator;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        return inputValidator.validateNationalCode(value);
    }
}
