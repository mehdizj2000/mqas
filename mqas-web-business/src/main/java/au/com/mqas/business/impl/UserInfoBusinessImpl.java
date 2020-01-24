package au.com.mqas.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.mqas.business.UserInfoBusiness;
import au.com.mqas.business.mapper.UserMapper;
import au.com.mqas.domain.model.UserInfo;
import au.com.mqas.service.UserInfoService;
import au.com.mqas.transfer.data.dto.UserDto;

@Component
public class UserInfoBusinessImpl implements UserInfoBusiness {

	private UserInfoService userInfoService;

	private UserMapper userMapper;

	@Override
	public List<UserDto> listAllUsers() {

		List<UserInfo> userInfos = userInfoService.listAllUsers();

		return userMapper.userInfosToUserDtos(userInfos);

	}
	
	@Override
	public void deleteUser(Long uid) {
		UserInfo userInfo = new UserInfo();
		userInfo.setId(uid);
		
		userInfoService.deleteUser(userInfo);
		
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	@Autowired
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

}
