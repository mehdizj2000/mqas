package au.com.mqas.data.domain;

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
public class Address extends AbstractItem {

	private String addrresLine1;

	private String addressLine2;

	private String town;

	private String postCode;

	private String state;

	private String country;

	@OneToOne
	@JoinColumn(name = "fk_user_id")
	private UserInfo userInfo;

}
