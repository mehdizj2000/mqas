package au.com.mqas.adapter.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import au.com.mqas.db.data.model.UserInfo;

public interface UserInfoService {

	List<UserInfo> listAllUsers();

	void deleteUser(UserInfo userInfo);

	UserInfo findUserById(Long uid);

	UserInfo saveUser(UserInfo existingUser);

	UserInfo enableUser(UserInfo userInfo);

	Optional<UserInfo> findByEmail(String email);

	UserInfo validateEmailAndBirthDay(String email, LocalDate birthDate);

	UserInfo validateUserBySecurityAnswer(Long id, String email, String secAnswer);

}
