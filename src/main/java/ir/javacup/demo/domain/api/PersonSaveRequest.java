package ir.javacup.demo.domain.api;

import ir.javacup.demo.validations.NationalCode;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveRequest {
	private Long personId;
	@NotBlank(message = "{firstName.required}")
	@Size(max = 70,message = "{firstName.maxLength}")
	private String firstName;
	@NotBlank(message = "{lastName.required}")
	@Size(max = 70,message = "{lastName.maxLength}")
	private String lastName;
	@NotBlank(message = "{nationalCode.required}")
	@Size(max = 10,message = "{nationalCode.maxLength}")
	@NationalCode(message = "{nationalCode.format.invalid}")
	private String nationalCode;
	@NotNull(message = "{age.required}")
	@Digits(integer = 3,fraction = 0,message = "{age.maxLength}")
	private Integer age;
	@NotBlank(message = "{mobile.required}")
	@Size(max = 11,message = "{mobile.maxLength}")
	@Pattern(regexp = "09\\d{9}",message = "{mobile.format.invalid}")
	private String mobile;
	@NotBlank(message = "{email.required}")
	@Size(max = 30,message = "{email.maxLength}")
	@Email(message = "{email.format.invalid}")
	private String email;
}