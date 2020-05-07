package au.com.mqas.logic.event;

import org.springframework.context.ApplicationEvent;

import au.com.mqas.db.data.model.AccessKey;

public class CreateAPIKeyEvent extends ApplicationEvent {

	private static final long serialVersionUID = 3739120609219816785L;

	private AccessKey accessKey;

	public CreateAPIKeyEvent(AccessKey accessKey) {
		super(accessKey);
		this.accessKey = accessKey;
	}

	public AccessKey getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(AccessKey accessKey) {
		this.accessKey = accessKey;
	}

}
