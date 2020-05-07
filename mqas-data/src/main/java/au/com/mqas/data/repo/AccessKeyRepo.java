package au.com.mqas.data.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import au.com.mqas.db.data.model.AccessKey;
import au.com.mqas.db.data.model.UserInfo;

public interface AccessKeyRepo extends JpaRepository<AccessKey, Long> {

	List<AccessKey> findByUserInfo(UserInfo userInfo);

}
