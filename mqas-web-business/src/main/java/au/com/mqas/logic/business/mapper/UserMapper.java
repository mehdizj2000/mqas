package au.com.mqas.logic.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.transfer.data.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userInfoToUserDto(UserInfo userInfo);

    List<UserDto> userInfosToUserDtos(List<UserInfo> userInfo);

    UserInfo userDtoToUserInfo(UserDto userDto);

}
