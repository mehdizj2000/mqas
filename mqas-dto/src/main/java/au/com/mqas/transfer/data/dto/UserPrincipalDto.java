package au.com.mqas.transfer.data.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPrincipalDto extends User {

	private static final long serialVersionUID = 180212215206943733L;

	private String displayName;

	public UserPrincipalDto(String username, String displayName, String password, boolean enabled,
			boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

		this.displayName = displayName;

	}

}
