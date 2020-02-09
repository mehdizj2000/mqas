package au.com.mqas.adapter.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import au.com.mqas.adapter.service.UserInfoService;
import au.com.mqas.adapter.service.exception.AddressException;
import au.com.mqas.adapter.service.exception.UserException;
import au.com.mqas.data.repo.AddressRepo;
import au.com.mqas.data.repo.UserInfoRepo;
import au.com.mqas.db.data.model.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoRepo userInfoRepo;

    private AddressRepo addressRepo;

//    private VerificationTokenRepo verificationTokenRepo;
//    
//    private UserUpdateTokenRepo userUpdateTokenRepo;

    @Override
    public List<UserInfo> listAllUsers() {
	return userInfoRepo.findAll();
    }

    @Override
    public void deleteUser(UserInfo userInfo) {
	userInfoRepo.delete(userInfo);
    }

    @Override
    public UserInfo findUserById(Long uid) {
	Optional<UserInfo> userOpt = userInfoRepo.findById(uid);
	return userOpt.orElseThrow(() -> new UserException("User with the provided id is not found"));
    }

    @Override
    public UserInfo saveUser(UserInfo userInfo) {

	if (userInfo.getId() != null) {
	    UserInfo existingUser = userInfoRepo.findById(userInfo.getId())
		    .orElseThrow(() -> new UserException("User with the provided id is not found"));
	    if(userInfo.getIsActive() == null)
		userInfo.setIsActive(existingUser.getIsActive());
	    if(userInfo.getPassword() == null)
		userInfo.setPassword(existingUser.getPassword());
	}
	if (userInfo.getShippingAddress() != null && userInfo.getShippingAddress().getId() != null)
	    addressRepo.findById(userInfo.getShippingAddress().getId())
		    .orElseThrow(() -> new AddressException("User with the provided id is not found"));

	UserInfo info = userInfoRepo.save(userInfo);
//	if(userInfo.getId() == null) {
//	    VerificationToken token = new VerificationToken();
//	    token.setUserInfo(info);
//	    verificationTokenRepo.save(token);
//	} else {
//	    UserUpdateToken token = new UserUpdateToken();
//	    token.setUserInfo(info);
//	    userUpdateTokenRepo.save(token);
//	}

	return info;
    }

    @Override
    public Optional<UserInfo> findByEmail(String email) {
	return userInfoRepo.findByEmail(email);
    }

    @Override
    public UserInfo enableUser(UserInfo userInfo) {
	userInfo.setIsActive(Boolean.TRUE);
	return userInfoRepo.save(userInfo);
    }

    public UserInfoRepo getUserInfoRepo() {
	return userInfoRepo;
    }

    @Autowired
    public void setUserInfoRepo(UserInfoRepo userInfoRepo) {
	this.userInfoRepo = userInfoRepo;
    }

    public AddressRepo getAddressRepo() {
	return addressRepo;
    }

    @Autowired
    public void setAddressRepo(AddressRepo addressRepo) {
	this.addressRepo = addressRepo;
    }

//    public VerificationTokenRepo getVerificationTokenRepo() {
//	return verificationTokenRepo;
//    }
//
//    @Autowired
//    public void setVerificationTokenRepo(VerificationTokenRepo verificationTokenRepo) {
//	this.verificationTokenRepo = verificationTokenRepo;
//    }
//
//    public UserUpdateTokenRepo getUserUpdateTokenRepo() {
//	return userUpdateTokenRepo;
//    }
//
//    @Autowired
//    public void setUserUpdateTokenRepo(UserUpdateTokenRepo userUpdateTokenRepo) {
//	this.userUpdateTokenRepo = userUpdateTokenRepo;
//    }

}
