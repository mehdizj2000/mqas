package au.com.mqas.logic.event.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import au.com.mqas.db.data.model.ResetPasswordToken;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.logic.event.ResetPassEvent;

@Component
public class ResetPasswordListener implements AppListener<ResetPassEvent> {

    private JavaMailSender javaMailSender;

    @Value("${mqas.web.url}")
    private String webURL;

    @Override
    @EventListener
    public void handleRegistrationEvent(ResetPassEvent event) {
	ResetPasswordToken token = event.getResetPassToken();
	UserInfo user = token.getUserInfo();

	final String recipientAddress = user.getEmail();
	final String subject = "Reset Password Verification";
	final String confirmationUrl = webURL + "user/verifyPassword?token=" + token.getToken();
	final SimpleMailMessage email = new SimpleMailMessage();
	email.setTo(recipientAddress);
	email.setSubject(subject);
	email.setText(
		"Please open the following URL to verify your account for reseting password: \r\n" + confirmationUrl);
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
