package au.com.mqas.transfer.data.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;



import au.com.mqas.transfer.validation.PasswordMatcher;
import lombok.Data;

@Data
@PasswordMatcher
public class LoginUserDto {

    @Email
    @NotEmpty(message = "Email is empty")
    private String email;

//    private LocalDate dateOfBirth;

    @NotEmpty(message = "Password is empty")
    private String password;

    @NotEmpty(message = "password confirmation is empty")
    private String passwordConfirmation;

}
