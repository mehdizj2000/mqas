package au.com.mqas.logic.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import au.com.mqas.adapter.service.TokenService;
import au.com.mqas.adapter.service.UserInfoService;
import au.com.mqas.db.data.model.ResetPasswordToken;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.db.data.model.VerificationToken;
import au.com.mqas.logic.business.UserInfoBusiness;
import au.com.mqas.logic.business.mapper.ForgotPassMapper;
import au.com.mqas.logic.business.mapper.LoginUserMapper;
import au.com.mqas.logic.business.mapper.ResetPasswordMapper;
import au.com.mqas.logic.business.mapper.UserMapper;
import au.com.mqas.logic.event.RegistrationEvent;
import au.com.mqas.logic.event.ResetPassEvent;
import au.com.mqas.transfer.data.dto.ForgotPassDto;
import au.com.mqas.transfer.data.dto.LoginUserDto;
import au.com.mqas.transfer.data.dto.ResetPasswordDto;
import au.com.mqas.transfer.data.dto.UserDto;

@Component
public class UserInfoBusinessImpl implements UserInfoBusiness {

    private UserInfoService userInfoService;

    private TokenService<VerificationToken> verificationTokenService;

    private TokenService<ResetPasswordToken> resetPasswordTokenService;

    private UserMapper userMapper;

    private LoginUserMapper loginUserMapper;

    private ForgotPassMapper forgotPassMapper;

    private ResetPasswordMapper resetPasswordMapper;

    private ApplicationEventPublisher eventPublisher;

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

	VerificationToken verificationToken = verificationTokenService.createToken(savedUserInfo);

	RegistrationEvent registrationEvent = new RegistrationEvent(verificationToken);
	eventPublisher.publishEvent(registrationEvent);

	return userMapper.userInfoToUserDto(savedUserInfo);

    }

    @Override
    public UserDto enableUser(UserDto user) {
	UserInfo userInfo = getUserMapper().userDtoToUserInfo(user);

	UserInfo enabledUserInfo = userInfoService.enableUser(userInfo);

	return userMapper.userInfoToUserDto(enabledUserInfo);

    }

    @Override
    public UserDto verifyRegistrationToken(String token) {
	VerificationToken verificationToken = verificationTokenService.verifyToken(token);

	verificationTokenService.deleteToken(verificationToken);

	return userMapper.userInfoToUserDto(verificationToken.getUserInfo());
    }

    @Override
    public ResetPasswordDto verifyResetPasswordToken(String token) {
	ResetPasswordToken resetPasswordToken = resetPasswordTokenService.verifyToken(token);

//	resetPasswordTokenService.deleteToken(resetPasswordToken);

	ResetPasswordDto resetPasswordDto = resetPasswordMapper
		.userInfoToResetPasswordDto(resetPasswordToken.getUserInfo());
	resetPasswordDto.setPassword("");
	resetPasswordDto.setSecurityAnswer("");

	return resetPasswordDto;
    }

    @Override
    public void validateUserInfoForResetPassword(ForgotPassDto forgotPassDto) {

	UserInfo currentUserInfo = userInfoService.validateEmailAndBirthDay(forgotPassDto.getEmail(),
		forgotPassDto.getDateOfBirth());

	ResetPasswordToken resetPasswordToken = resetPasswordTokenService.createToken(currentUserInfo);

	ResetPassEvent event = new ResetPassEvent(resetPasswordToken);

	eventPublisher.publishEvent(event);

    }

    @Override
    public void resetPasswordForUser(ResetPasswordDto resetPassDto) {
	UserInfo userInfo = userInfoService.validateUserBySecurityAnswer(resetPassDto.getId(), resetPassDto.getEmail(),
		resetPassDto.getSecurityAnswer());
	
	userInfo.setPassword(resetPassDto.getPassword());
	
	userInfoService.saveUser(userInfo);
	
    }

    @Override
    public UserDto updatePassword(ForgotPassDto forgotPassDto) {
	// TODO Auto-generated method stub
	return null;
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

    public TokenService<VerificationToken> getVerificationTokenService() {
	return verificationTokenService;
    }

    @Autowired
    public void setVerificationTokenService(TokenService<VerificationToken> verificationTokenService) {
	this.verificationTokenService = verificationTokenService;
    }

    public ApplicationEventPublisher getEventPublisher() {
	return eventPublisher;
    }

    @Autowired
    public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
	this.eventPublisher = eventPublisher;
    }

    public ForgotPassMapper getForgotPassMapper() {
	return forgotPassMapper;
    }

    @Autowired
    public void setForgotPassMapper(ForgotPassMapper forgotPassMapper) {
	this.forgotPassMapper = forgotPassMapper;
    }

    public TokenService<ResetPasswordToken> getResetPasswordTokenService() {
	return resetPasswordTokenService;
    }

    @Autowired
    public void setResetPasswordTokenService(TokenService<ResetPasswordToken> resetPasswordTokenService) {
	this.resetPasswordTokenService = resetPasswordTokenService;
    }

    public ResetPasswordMapper getResetPasswordMapper() {
	return resetPasswordMapper;
    }

    @Autowired
    public void setResetPasswordMapper(ResetPasswordMapper resetPasswordMapper) {
	this.resetPasswordMapper = resetPasswordMapper;
    }

}
