package au.com.mqas.transfer.data.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import au.com.mqas.transfer.validation.PasswordMatcher;
import lombok.Data;

@Data
@PasswordMatcher
public class LoginUserDto {

    @Email
    @NotEmpty(message = "Email is empty")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @NotEmpty(message = "Password is empty")
    private String password;

    @NotEmpty(message = "password confirmation is empty")
    private String passwordConfirmation;

}
