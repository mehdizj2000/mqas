package au.com.mqas.data.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Configuration
@ComponentScan(basePackages = "au.com.mqas.data.repo")
@EntityScan(basePackages ="au.com.mqas.data.domain")
public class JpaConfig {

}
