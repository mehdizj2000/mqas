package au.com.mqas.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

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
	    	.antMatchers("/webjars/**", "/static/**").permitAll()
	    	.antMatchers("/", "/index", "/home", "/register", "/user/confirmRegistration").permitAll()
	    	.antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
	    	.anyRequest().authenticated()
	    	.and()
	    	.formLogin().loginPage("/loginCustom").permitAll().loginProcessingUrl("/doLogin")
	    	.and()
	    	.logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/")
	    	.and()
	    	.csrf().disable()
	    	;
	}// @formatter:on 

    public UserDetailsService getUserDetailsService() {
	return userDetailsService;
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
	this.userDetailsService = userDetailsService;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	return bCryptPasswordEncoder;
    }

}
