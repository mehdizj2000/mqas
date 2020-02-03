package au.com.mqas.logic.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.mqas.adapter.service.UserInfoService;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.logic.business.UserInfoBusiness;
import au.com.mqas.logic.business.mapper.LoginUserMapper;
import au.com.mqas.logic.business.mapper.UserMapper;
import au.com.mqas.transfer.data.dto.LoginUserDto;
import au.com.mqas.transfer.data.dto.UserDto;

@Component
public class UserInfoBusinessImpl implements UserInfoBusiness {

    private UserInfoService userInfoService;

    private UserMapper userMapper;
    
    private LoginUserMapper loginUserMapper;

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

    @Override
    public UserDto findUserById(Long uid) {

	UserInfo info = userInfoService.findUserById(uid);
	return userMapper.userInfoToUserDto(info);

    }

    @Override
    public UserDto saveUser(UserDto user) {

	UserInfo newUserInfo = userMapper.userDtoToUserInfo(user);

	UserInfo savedUserInfo = userInfoService.saveUser(newUserInfo);

	return userMapper.userInfoToUserDto(savedUserInfo);
    }
    
    @Override
    public UserDto registerUser(LoginUserDto user) {

	UserInfo newUserInfo = getLoginUserMapper().loginUserDtoToUserInfo(user);

	UserInfo savedUserInfo = userInfoService.saveUser(newUserInfo);

	return userMapper.userInfoToUserDto(savedUserInfo);
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

    public LoginUserMapper getLoginUserMapper() {
	return loginUserMapper;
    }

    @Autowired
    public void setLoginUserMapper(LoginUserMapper loginUserMapper) {
	this.loginUserMapper = loginUserMapper;
    }

}
