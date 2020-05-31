package au.com.mqas.loader;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "au.com.mqas.loader.db.repo")
public class MqasJpaConfig {

}
