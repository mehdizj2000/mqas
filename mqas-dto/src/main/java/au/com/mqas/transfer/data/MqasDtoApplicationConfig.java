package au.com.mqas.transfer.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "au.com.mqas.dto")
public class MqasDtoApplicationConfig {

    public static void main(String[] args) {
	SpringApplication.run(MqasDtoApplicationConfig.class, args);

    }

}
