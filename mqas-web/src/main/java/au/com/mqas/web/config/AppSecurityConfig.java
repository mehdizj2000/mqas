package au.com.mqas.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
	// @formatter:off
 		builder.inMemoryAuthentication()
 			.withUser("mehdi").password(passwordEncoder().encode("mehdi")).roles("USER");
		// @formatter:on		
    }

    // @formatter:off
 	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	    	.authorizeRequests()
	    	.antMatchers("/webjars/**", "/static/**").permitAll()
	    	.antMatchers("/", "/index", "/home").permitAll()
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

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder(15);
    }

}
