package au.com.mqas.transfer.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AddressDto extends AbstractDto {

    @Getter(onMethod_ = @JsonProperty(value = "address_line_1"))
    private String addrresLine1;

    @Getter(onMethod_ = @JsonProperty(value = "address_line_2"))
    private String addressLine2;

    private String town;

    @Getter(onMethod_ = @JsonProperty(value = "post_code"))
    private String postCode;

    private String state;

    private String country;

}
