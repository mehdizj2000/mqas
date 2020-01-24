package au.com.mqas.business;

import java.util.List;

import au.com.mqas.transfer.data.dto.UserDto;

public interface UserInfoBusiness {

	List<UserDto> listAllUsers();

	void deleteUser(Long uid);

}
