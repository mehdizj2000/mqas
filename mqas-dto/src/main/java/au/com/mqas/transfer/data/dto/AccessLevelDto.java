package au.com.mqas.transfer.data.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AccessLevelDto extends AbstractDto {

	private String name;
	private String description;
	private Long reqPerMinute;
	private Long totalReq;

	private BigDecimal price;

}
