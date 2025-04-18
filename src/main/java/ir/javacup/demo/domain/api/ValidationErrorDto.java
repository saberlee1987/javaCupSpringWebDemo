package ir.javacup.demo.domain.api;

import lombok.Data;

@Data
public class ValidationErrorDto {
    private String fieldName;
    private String errorMessage;
}