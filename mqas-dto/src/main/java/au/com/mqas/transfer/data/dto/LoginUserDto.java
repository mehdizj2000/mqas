package au.com.mqas.transfer.data.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import au.com.mqas.transfer.validation.PasswordMatcher;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@PasswordMatcher
public class LoginUserDto extends PasswordDto {

	@Email
	@NotEmpty(message = "Email is empty")
	private String email;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Past
	private LocalDate dateOfBirth;

	@NotEmpty(message = "security question is empty")
	@Size(min = 5, max = 25, message = "question is long or short")
	private String securityQuestion;

	@NotEmpty(message = "security answer is empty")
	@Size(min = 2, max = 10, message = "answer is long")
	private String securityAnswer;

}
