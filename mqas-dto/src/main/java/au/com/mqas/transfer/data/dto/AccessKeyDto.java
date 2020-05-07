package au.com.mqas.transfer.data.dto;

import java.time.ZonedDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccessKeyDto extends AbstractDto {

	private String key;
	private ZonedDateTime expiryDate;
	private AccessLevelDto accessLevel;

}
