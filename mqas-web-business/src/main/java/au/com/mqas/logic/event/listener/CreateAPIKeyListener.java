package au.com.mqas.logic.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import au.com.mqas.db.data.model.AccessKey;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.logic.event.CreateAPIKeyEvent;

@Component
public class CreateAPIKeyListener implements AppListener<CreateAPIKeyEvent> {

	private JavaMailSender javaMailSender;

	@Value("${mqas.web.url}")
	private String webURL;

	@Override
	@EventListener
	public void handleRegistrationEvent(CreateAPIKeyEvent event) {
		AccessKey token = event.getAccessKey();
		UserInfo user = token.getUserInfo();

		final String recipientAddress = user.getEmail();
		final String subject = "API Key";
		final String confirmationUrl = webURL + "token/instruction/" + token.getKey();
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText("Please check the API key generated for you. Please follow instruction \r\n" + confirmationUrl);
		javaMailSender.send(email);
	}

	public JavaMailSender getJavaMailSender() {
		return javaMailSender;
	}

	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

}
