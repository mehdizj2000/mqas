package au.com.mqas.data.domain;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private ZonedDateTime creationTime;

	private ZonedDateTime modifiedTime;

	@PrePersist
	public void preInsert() {
		creationTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC"));
	}

	@PreUpdate
	public void preUpdate() {
		modifiedTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC"));
	}

}
