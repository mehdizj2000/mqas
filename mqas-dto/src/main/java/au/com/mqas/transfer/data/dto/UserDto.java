package au.com.mqas.transfer.data.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

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

    @Getter(onMethod_ = { @JsonProperty(value = "first_name") })
    @NotEmpty
    private String firstName;

    @Getter(onMethod_ = @JsonProperty(value = "last_name"))
    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Past
    private LocalDate dateOfBirth;

    @JsonIgnore
    private String password;

    @Getter(onMethod_ = @JsonProperty(value = "shipping_address"))
    private AddressDto shippingAddress;

}
