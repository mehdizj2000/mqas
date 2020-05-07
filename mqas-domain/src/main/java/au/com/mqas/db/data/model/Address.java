package au.com.mqas.db.data.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Address extends AbstractItem {

	private String addressLine1;

	private String addressLine2;

	private String town;

	private String postCode;

	private String state;

	private String country;

	@OneToOne(mappedBy = "shippingAddress")
//	@JoinColumn(name = "fk_user_id")
	private UserInfo userInfo;

}
