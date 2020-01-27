package au.com.mqas.transfer.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@JsonRootName(value = "user")
public class UserDto extends AbstractDto {

    @Getter(onMethod_ = @JsonProperty(value = "first_name"))
    private String firstName;

    @Getter(onMethod_ = @JsonProperty(value = "last_name"))
    private String lastName;

    private String email;

    @JsonIgnore
    private String password;

    @Getter(onMethod_ = @JsonProperty(value = "shipping_address"))
    private AddressDto shippingAddress;

}