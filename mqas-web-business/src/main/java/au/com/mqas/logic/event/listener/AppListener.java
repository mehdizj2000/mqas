package au.com.mqas.logic.event.listener;

import org.springframework.context.ApplicationEvent;

public interface AppListener<T extends ApplicationEvent> {

	void handleRegistrationEvent(T event);
}
