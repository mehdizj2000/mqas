package au.com.mqas.logic.business;

import java.util.List;

import au.com.mqas.transfer.data.dto.ForgotPassDto;
import au.com.mqas.transfer.data.dto.LoginUserDto;
import au.com.mqas.transfer.data.dto.ResetPasswordDto;
import au.com.mqas.transfer.data.dto.UserDto;

public interface UserInfoBusiness {

    List<UserDto> listAllUsers();

    void deleteUser(Long uid);

    UserDto findUserById(Long uid);

    UserDto saveUser(UserDto user);

    UserDto registerUser(LoginUserDto user);

    UserDto verifyRegistrationToken(String token);

    ResetPasswordDto verifyResetPasswordToken(String token);

    UserDto enableUser(UserDto user);

    UserDto updatePassword(ForgotPassDto forgotPassDto);

    void validateUserInfoForResetPassword(ForgotPassDto forgotPass);

    void resetPasswordForUser(ResetPasswordDto forgotPassDto);

}
