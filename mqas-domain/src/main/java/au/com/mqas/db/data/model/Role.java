package au.com.mqas.db.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

	@Id
//    @GenericGenerator(name = "mqas_id_gen", strategy = "au.com.mqas.db.data.util.MqasIdGenerator")
//    @GeneratedValue(generator = "mqas_id_gen")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(name = "role_privilege", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
	private Set<Privilege> privileges;

	@Column(nullable = false, unique = true, updatable = false)
	private String name;

	public void addPrivilege(Privilege privilege) {
		if (privileges == null)
			privileges = new HashSet<Privilege>();
		privileges.add(privilege);
	}

}
