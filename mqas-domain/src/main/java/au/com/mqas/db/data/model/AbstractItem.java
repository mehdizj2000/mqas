package au.com.mqas.db.data.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.Column;
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

    @Column(updatable = false, nullable = false)
    private ZonedDateTime creationTime;

    private ZonedDateTime modifiedTime;

    @PrePersist
    public void preInsert() {
	if (creationTime == null)
	    creationTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC"));
    }

    @PreUpdate
    public void preUpdate() {
	if (modifiedTime == null)
	    modifiedTime = ZonedDateTime.now().withZoneSameInstant(ZoneId.of("UTC"));
    }

}
