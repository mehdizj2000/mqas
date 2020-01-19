package au.com.mqas.business.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import au.com.mqas.domain.model.UserInfo;
import au.com.mqas.transfer.data.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userInfoToUserDto(UserInfo userInfo);
    
    List<UserDto> userInfosToUserDtos(List<UserInfo> userInfo);

    UserInfo userDtoToUserInfo(UserDto userDto);

}
