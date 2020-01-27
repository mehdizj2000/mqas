package au.com.mqas.adapter.service;

import java.util.List;

import au.com.mqas.db.data.model.UserInfo;

public interface UserInfoService {

    List<UserInfo> listAllUsers();

    void deleteUser(UserInfo userInfo);

    UserInfo findUserById(Long uid);

    UserInfo saveUser(UserInfo existingUser);

}
