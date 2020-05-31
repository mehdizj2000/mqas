package au.com.mqas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	public AppSecurityConfig(UserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {

		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	inMemoryAuthentication().withUser("mehdi").password(passwordEncoder().encode("mehdi")).roles("USER");

	}

	// @formatter:off
 	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    	.authorizeRequests()
	    	.antMatchers("/webjars/**", "/css/**", "/js/**", "/images/**").permitAll()
	    	.antMatchers("/", "/index", "/home", "/register", "/user/confirmRegistration", "/user/resetPassword", "/user/verifyPassword", "/forgotPassword").permitAll()
	    	.antMatchers("/user/delete/*").hasRole("ADMIN")
	    	.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
	    	.anyRequest().authenticated()
	    	.and()
		    .formLogin().loginPage("/login").permitAll().loginProcessingUrl(
			    "/doLogin")/* .defaultSuccessUrl("/", true) */
	    	.and()
	    	.logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/")
	    	.and()
	    	.rememberMe()
	    	.and()
	    	.csrf().disable()
	    	;
	}// @formatter:on 

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

//    @Autowired
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//	this.userDetailsService = userDetailsService;
//    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
