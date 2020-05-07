package au.com.mqas.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "au.com.mqas")
public class MqasWebApplicationConfig {

	public static void main(String[] args) {
		SpringApplication.run(MqasWebApplicationConfig.class, args);
	}

}
