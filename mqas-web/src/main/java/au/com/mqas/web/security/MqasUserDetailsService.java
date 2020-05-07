package au.com.mqas.web.security;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import au.com.mqas.adapter.service.UserInfoService;
import au.com.mqas.db.data.model.Role;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.transfer.data.dto.UserPrincipalDto;

@Component
public class MqasUserDetailsService implements UserDetailsService {

	private UserInfoService userInfoService;

	@Override
	public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
		Optional<UserInfo> userOpt = userInfoService.findByEmail(email);
		UserInfo userInfo = userOpt
				.orElseThrow(() -> new UsernameNotFoundException("No User Found with email: " + email));
		String displayName = userInfo.getFirstName();
		return new UserPrincipalDto(userInfo.getEmail(), displayName, userInfo.getPassword(), userInfo.getIsActive(),
				true, true, true, getAuthorities(userInfo.getRoles()));
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Set<Role> roles) {
		return roles.stream().map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());
	}

	public UserInfoService getUserInfoService() {
		return userInfoService;
	}

	@Autowired
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
