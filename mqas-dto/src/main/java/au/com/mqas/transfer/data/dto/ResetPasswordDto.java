package au.com.mqas.transfer.data.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import au.com.mqas.transfer.validation.PasswordMatcher;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@PasswordMatcher
public class ResetPasswordDto extends PasswordDto {

	private Long id;

	@Email
	@NotEmpty(message = "Email is empty")
	private String email;

	@NotEmpty(message = "security question is empty")
	@Size(min = 5, max = 25, message = "question is long or short")
	private String securityQuestion;

	@NotEmpty(message = "security answer is empty")
	@Size(min = 2, max = 10, message = "answer is long")
	private String securityAnswer;

}
