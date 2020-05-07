package au.com.mqas.logic.business.mapper;

import org.mapstruct.Mapper;

import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.transfer.data.dto.ForgotPassDto;

@Mapper(componentModel = "spring")
public interface ForgotPassMapper {

	UserInfo forgotPassDtoToUserInfo(ForgotPassDto forgotPassDto);

}
