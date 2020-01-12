package au.com.mqas.domain.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResetPasswordToken extends AbstractItem  {

	private String token;
	
	private LocalTime expiry;
	
	@OneToOne
	@JoinColumn(name = "fk_user_id")
	private UserInfo userInfo;
}