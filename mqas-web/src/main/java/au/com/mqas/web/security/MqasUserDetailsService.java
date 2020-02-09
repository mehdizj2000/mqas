package au.com.mqas.web.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import au.com.mqas.adapter.service.UserInfoService;
import au.com.mqas.db.data.model.UserInfo;

@Component
public class MqasUserDetailsService implements UserDetailsService {

    private UserInfoService userInfoService;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
	Optional<UserInfo> userOpt = userInfoService.findByEmail(email);
	UserInfo userInfo = userOpt
		.orElseThrow(() -> new UsernameNotFoundException("No User Found with email: " + email));
	return new User(userInfo.getEmail(), userInfo.getPassword(), userInfo.getIsActive(), true, true, true,
		getAuthorities("ROLE_USER"));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
	return Arrays.asList(new SimpleGrantedAuthority(role));
    }

    public UserInfoService getUserInfoService() {
	return userInfoService;
    }

    @Autowired
    public void setUserInfoService(UserInfoService userInfoService) {
	this.userInfoService = userInfoService;
    }

}
