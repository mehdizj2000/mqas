package au.com.mqas.db.data.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserInfo extends AbstractItem {

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private LocalDate dateOfBirth; 

    private String password;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(columnDefinition = "fk_add_id")
    private Address shippingAddress;

}
