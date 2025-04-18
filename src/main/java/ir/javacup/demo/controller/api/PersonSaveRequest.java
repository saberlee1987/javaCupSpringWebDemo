package ir.javacup.demo.controller.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonSaveRequest {

	private String firstName;
	private String lastName;
	private String nationalCode;

}
