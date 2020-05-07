package au.com.mqas.adapter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.mqas.adapter.service.AccessKeyService;
import au.com.mqas.data.repo.AccessKeyRepo;
import au.com.mqas.data.repo.AccessLevelRepo;
import au.com.mqas.db.data.model.AccessKey;
import au.com.mqas.db.data.model.AccessLevel;
import au.com.mqas.db.data.model.UserInfo;

@Service
public class AccessKeyServiceImpl implements AccessKeyService {

	private AccessKeyRepo accessKeyRepo;

	private AccessLevelRepo accessLevelRepo;

	@Override
	public AccessKey saveAccessKey(AccessKey accessKey) {
		return accessKeyRepo.save(accessKey);
	}

	@Override
	public List<AccessKey> listAllAccessKeysForUser(UserInfo user) {
		return getAccessKeyRepo().findByUserInfo(user);
	}

	@Override
	public List<AccessLevel> listAllAccessLevels() {
		return getAccessLevelRepo().findAll();
	}

	@Override
	public AccessLevel getAccessLevelById(Long id) {
		return getAccessLevelRepo().getOne(id);
	}

	public AccessKeyRepo getAccessKeyRepo() {
		return accessKeyRepo;
	}

	@Autowired
	public void setAccessKeyRepo(AccessKeyRepo accessKeyRepo) {
		this.accessKeyRepo = accessKeyRepo;
	}

	public AccessLevelRepo getAccessLevelRepo() {
		return accessLevelRepo;
	}

	@Autowired
	public void setAccessLevelRepo(AccessLevelRepo accessLevelRepo) {
		this.accessLevelRepo = accessLevelRepo;
	}

}
