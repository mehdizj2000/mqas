package au.com.mqas.transfer.data.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class PasswordDto {

	@NotEmpty(message = "Password is empty")
	private String password;

	@NotEmpty(message = "password confirmation is empty")
	private String passwordConfirmation;

}
