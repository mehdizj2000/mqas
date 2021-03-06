package au.com.mqas.data;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@Configuration
@EntityScan(basePackages = "au.com.mqas.db.data.model")
public class JpaConfig {

}
