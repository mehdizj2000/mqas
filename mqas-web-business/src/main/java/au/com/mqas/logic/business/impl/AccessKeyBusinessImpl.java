package au.com.mqas.logic.business.impl;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import au.com.mqas.adapter.service.AccessKeyService;
import au.com.mqas.adapter.service.UserInfoService;
import au.com.mqas.db.data.model.AccessKey;
import au.com.mqas.db.data.model.AccessLevel;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.logic.business.AccessKeyBusiness;
import au.com.mqas.logic.business.mapper.AccessKeyMapper;
import au.com.mqas.logic.business.mapper.AccessLevelMapper;
import au.com.mqas.logic.event.CreateAPIKeyEvent;
import au.com.mqas.transfer.data.dto.AccessKeyDto;
import au.com.mqas.transfer.data.dto.AccessLevelDto;

@Component
public class AccessKeyBusinessImpl implements AccessKeyBusiness {

	private AccessKeyService accessKeyService;

	private UserInfoService userInfoService;

	private AccessKeyMapper accessKeyMapper;

	private AccessLevelMapper accessLevelMapper;

	private ApplicationEventPublisher eventPublisher;

	@Override
	public List<AccessKeyDto> listUserKeysByEmail(String email) {

		Optional<UserInfo> optUserInfo = userInfoService.findByEmail(email);

		UserInfo info = optUserInfo.orElseThrow(RuntimeException::new);

		List<AccessKey> accessKeys = accessKeyService.listAllAccessKeysForUser(info);

		return accessKeyMapper.accessKeysToAccessKeyDtosList(accessKeys);
	}

	@Override
	public List<AccessLevelDto> listAccessLevelDtos() {
		List<AccessLevel> accessLevels = accessKeyService.listAllAccessLevels();

		return accessLevelMapper.accessLevelsToAccessLevelDtosList(accessLevels);
	}

	@Override
	public AccessLevelDto getAccessLevelDtoById(Long id) {
		AccessLevel accessLevel = accessKeyService.getAccessLevelById(id);

		return accessLevelMapper.accessLevelToAccessLevelDto(accessLevel);
	}

	@Override
	public void generateAPIKey(String username, Long prodId) {

		AccessKey accessKey = new AccessKey();
		AccessLevel accessLevel = accessKeyService.getAccessLevelById(prodId);
		accessKey.setAccessLevel(accessLevel);

		Optional<UserInfo> optUserInfo = userInfoService.findByEmail(username);
		UserInfo info = optUserInfo.orElseThrow(RuntimeException::new);
		accessKey.setUserInfo(info);

//	MessageDigest messageDigest =  null;
//	try {
//	    messageDigest = MessageDigest.getInstance("SHA-256");
//	} catch (NoSuchAlgorithmException e) {
//	    e.printStackTrace();
//	}

		UUID apiKey = UUID.randomUUID();
//	byte[] input = messageDigest.digest(apiKey.toString().getBytes());

		accessKey.setKey(apiKey.toString());
		accessKey.setExpiryDate(ZonedDateTime.now(ZoneId.of("UTC")).plusMonths(6l));

		AccessKey savedAccessKey = accessKeyService.saveAccessKey(accessKey);

		CreateAPIKeyEvent apiKeyEvent = new CreateAPIKeyEvent(savedAccessKey);
		eventPublisher.publishEvent(apiKeyEvent);

	}

	public AccessKeyService getAccessKeyService() {
		return accessKeyService;
	}

	@Autowired
	public void setAccessKeyService(AccessKeyService accessKeyService) {
		this.accessKeyService = accessKeyService;
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	@Autowired
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

	public AccessKeyMapper getAccessKeyMapper() {
		return accessKeyMapper;
	}

	@Autowired
	public void setAccessKeyMapper(AccessKeyMapper accessKeyMapper) {
		this.accessKeyMapper = accessKeyMapper;
	}

	public AccessLevelMapper getAccessLevelMapper() {
		return accessLevelMapper;
	}

	@Autowired
	public void setAccessLevelMapper(AccessLevelMapper accessLevelMapper) {
		this.accessLevelMapper = accessLevelMapper;
	}

	public ApplicationEventPublisher getEventPublisher() {
		return eventPublisher;
	}

	@Autowired
	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

}
