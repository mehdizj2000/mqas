package au.com.mqas.logic.business.mapper;

import org.mapstruct.Mapper;

import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.transfer.data.dto.LoginUserDto;

@Mapper(componentModel = "spring")
public interface LoginUserMapper {
    
    UserInfo loginUserDtoToUserInfo(LoginUserDto loginUserDto);

}
