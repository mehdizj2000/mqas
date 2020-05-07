package au.com.mqas.db.data.model;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class GenerateAPIAccessToken extends AbstractItem implements Token {

	@Column(updatable = false, nullable = false, unique = true)
	private String token;

	@Column(updatable = false)
	private LocalTime expiry;

	@OneToOne
	@JoinColumn(name = "fk_user_id")
	private UserInfo userInfo;

	@PrePersist
	public void prePersist() {
		token = UUID.randomUUID().toString();
		expiry = LocalTime.now(ZoneId.of("UTC")).plus(35, ChronoUnit.MINUTES);
	}

}
