package au.com.mqas.logic.event.listener;

import java.util.Properties;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@SpringBootTest
@ContextConfiguration(classes = TestConf.class)
class UserRegistrationListenerTest {

//    @Autowired
	private JavaMailSender javaMailSender;

//    @Test
	void test() {
		final String recipientAddress = "zareimeh@gmail.com";
		final String subject = "Registration Confirmation";
		final String confirmationUrl = "some bullshit";
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText("Please open the following URL to verify your account: \r\n" + confirmationUrl);
		javaMailSender.send(email);
	}

}

@TestConfiguration
class TestConf {

	@Bean
	public JavaMailSenderImpl javaMailSender() {
		JavaMailSenderImpl impl = new JavaMailSenderImpl();
		impl.setHost("smtp.gmail.com");
		impl.setPassword("5963$Kjohn&");
		impl.setUsername("mehdi.z.jorshari@gmail.com");
		impl.setPort(587);
		impl.setProtocol("smtp");
//	    impl.setJavaMailProperties(Properties);
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", true);
		impl.setJavaMailProperties(properties);
		return impl;
	}

}
