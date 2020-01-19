package au.com.mqas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.mqas.data.repo.UserInfoRepo;
import au.com.mqas.domain.model.UserInfo;
import au.com.mqas.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoRepo userInfoRepo;

    @Override
    public List<UserInfo> listAllUsers() {
	return userInfoRepo.findAll();
    }

    public UserInfoRepo getUserInfoRepo() {
	return userInfoRepo;
    }

    @Autowired
    public void setUserInfoRepo(UserInfoRepo userInfoRepo) {
	this.userInfoRepo = userInfoRepo;
    }

}
