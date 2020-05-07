package au.com.mqas.adapter.service;

import java.util.List;

import au.com.mqas.db.data.model.AccessKey;
import au.com.mqas.db.data.model.AccessLevel;
import au.com.mqas.db.data.model.UserInfo;

public interface AccessKeyService {

	AccessKey saveAccessKey(AccessKey accessKey);

	List<AccessKey> listAllAccessKeysForUser(UserInfo user);

	List<AccessLevel> listAllAccessLevels();

	AccessLevel getAccessLevelById(Long id);

}
