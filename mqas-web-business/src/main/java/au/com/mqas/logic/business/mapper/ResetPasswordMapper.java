package au.com.mqas.logic.business.mapper;

import org.mapstruct.Mapper;

import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.transfer.data.dto.ResetPasswordDto;

@Mapper(componentModel = "spring")
public interface ResetPasswordMapper {

	UserInfo resetPasswordDtoToUserInfo(ResetPasswordDto forgotPassDto);

	ResetPasswordDto userInfoToResetPasswordDto(UserInfo userInfo);

}
