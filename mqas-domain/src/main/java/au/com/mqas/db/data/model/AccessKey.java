package au.com.mqas.db.data.model;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccessKey extends AbstractItem {

	@Column(name = "userKey")
	private String key;
	private ZonedDateTime expiryDate;

	@OneToOne
	@JoinColumn(name = "fk_access_level_id")
	private AccessLevel accessLevel;

	@ManyToOne
	@JoinColumn(name = "fk_user_id")
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	private UserInfo userInfo;

}
