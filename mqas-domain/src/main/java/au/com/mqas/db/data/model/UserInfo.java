package au.com.mqas.db.data.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Table(name = "user")
@DynamicUpdate
@DynamicInsert
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserInfo extends AbstractItem {

	private String firstName;

	private String lastName;

	@Column(nullable = false, unique = true, updatable = false)
	private String email;

	@Column(nullable = false)
	private LocalDate dateOfBirth;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean isActive;

	@Column(nullable = false)
	private String securityQuestion;

	@Column(nullable = false)
	private String securityAnswer;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private Set<Role> roles;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(columnDefinition = "fk_add_id")
	private Address shippingAddress;

	public void addRole(Role role) {
		if (roles == null)
			roles = new HashSet<Role>();
		roles.add(role);
	}

	@PrePersist
	public void prePersist() {
		isActive = false;
	}

}
