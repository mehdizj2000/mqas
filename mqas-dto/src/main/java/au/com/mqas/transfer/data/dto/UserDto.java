package au.com.mqas.transfer.data.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @Getter(onMethod_ = {@JsonProperty(value = "first_name")})
    @NotNull
    @NotEmpty
    private String firstName;

    @Getter(onMethod_ = @JsonProperty(value = "last_name"))
    private String lastName;

    @Getter(onMethod_ = @Email)
    private String email;
    
//    private LocalDate dateOfBirth;

    @JsonIgnore
    private String password;
    
    @Getter(onMethod_ = @JsonProperty(value = "shipping_address"))
    private AddressDto shippingAddress;

}
