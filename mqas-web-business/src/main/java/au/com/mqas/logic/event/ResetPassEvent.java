package au.com.mqas.logic.event;

import org.springframework.context.ApplicationEvent;

import au.com.mqas.db.data.model.ResetPasswordToken;

public class ResetPassEvent extends ApplicationEvent {

	private static final long serialVersionUID = 8094621595641976901L;

	private ResetPasswordToken resetPassToken;

	public ResetPassEvent(ResetPasswordToken resetPassToken) {
		super(resetPassToken);
		this.resetPassToken = resetPassToken;
	}

	public ResetPasswordToken getResetPassToken() {
		return resetPassToken;
	}

	public void setResetPassToken(ResetPasswordToken resetPassToken) {
		this.resetPassToken = resetPassToken;
	}

}
