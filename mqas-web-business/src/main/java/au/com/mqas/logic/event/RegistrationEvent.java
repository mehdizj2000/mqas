package au.com.mqas.logic.event;

import org.springframework.context.ApplicationEvent;

import au.com.mqas.db.data.model.VerificationToken;

public class RegistrationEvent extends ApplicationEvent {

    private static final long serialVersionUID = 8094621595641976901L;

    private VerificationToken verificationToken;

    public RegistrationEvent(VerificationToken verificationToken) {
	super(verificationToken);
	this.verificationToken = verificationToken;
    }

    public VerificationToken getVerificationToken() {
	return verificationToken;
    }

    public void setVerificationToken(VerificationToken verificationToken) {
	this.verificationToken = verificationToken;
    }

}
