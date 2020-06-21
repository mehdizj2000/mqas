package au.com.mqas.data.repo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

//import static org.junit.Assert.assertNotNull;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.mqas.data.JpaConfig;
import au.com.mqas.db.data.model.Address;
import au.com.mqas.db.data.model.Role;
import au.com.mqas.db.data.model.UserInfo;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = { JpaConfig.class })
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Slf4j
@Sql("/data.sql")
@Disabled
public class UserInfoRepoTest {

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Autowired
	private RoleRepo roleRepo;

	@Test
	public void retreiveRoles() {
		Optional<Role> adminRoleOpt = roleRepo.findByName("ROLE_ADMIN");
		Role adminRole = adminRoleOpt.orElseThrow(RuntimeException::new);
	}

	@Test
//    @Rollback(false)
	public void testSave() {

		Optional<Role> adminRoleOpt = roleRepo.findByName("ROLE_ADMIN");// save(newAdminRole);
		Role adminRole = adminRoleOpt.orElseThrow(RuntimeException::new);

		Optional<Role> userRoleOpt = roleRepo.findByName("ROLE_USER");// save(newUserRole);
		Role userRole = userRoleOpt.orElseThrow(RuntimeException::new);

		Address address1 = new Address();
		address1.setAddressLine1("1/57 South Street");
		address1.setAddressLine2("");
		address1.setTown("Rydalmere");
		address1.setPostCode("2116");
		address1.setState("NSW");
		address1.setCountry("Australia");

		Address address2 = new Address();
		address2.setAddressLine1("2/57 South Street");
		address2.setAddressLine2("");
		address2.setTown("Rydalmere");
		address2.setPostCode("2116");
		address2.setState("NSW");
		address1.setCountry("Australia");

		Address address3 = new Address();
		address3.setAddressLine1("3/57 South Street");
		address3.setAddressLine2("");
		address3.setTown("Rydalmere");
		address3.setPostCode("2116");
		address3.setState("NSW");
		address3.setCountry("Australia");

		Address address4 = new Address();
		address4.setAddressLine1("4/57 South Street");
		address4.setAddressLine2("");
		address4.setTown("Rydalmere");
		address4.setPostCode("2116");
		address4.setState("NSW");
		address4.setCountry("Australia");

		Address address5 = new Address();
		address5.setAddressLine1("5/57 South Street");
		address5.setAddressLine2("");
		address5.setTown("Rydalmere");
		address5.setPostCode("2116");
		address5.setState("NSW");
		address5.setCountry("Australia");

//		addressRepo.saveAll(Arrays.asList(address1, address2, address3, address4, address5));

		UserInfo info1 = new UserInfo();
		info1.setEmail("mehdi1@gmail.com");
		info1.setFirstName("Mehdi1");
		info1.setLastName("Jorshari1");
		info1.setPassword("7845121");
		info1.setDateOfBirth(LocalDate.of(1979, 9, 21));
		info1.setShippingAddress(address1);
		info1.setSecurityQuestion("nsdghdgfhdgfhdgfhgdfhgdfhg");
		info1.setSecurityAnswer("jhdfsjh");
		info1.addRole(userRole);

		UserInfo info2 = new UserInfo();
		info2.setEmail("mehdi2@gmail.com");
		info2.setFirstName("Mehdi2");
		info2.setLastName("Jorshar2");
		info2.setPassword("7845122");
		info2.setDateOfBirth(LocalDate.of(1979, 9, 21));
		info2.setShippingAddress(address2);
		info2.setSecurityQuestion("nsdghdgfhdgfhdgfhgdfhgdfhg");
		info2.setSecurityAnswer("jhdfsjh");
		info2.addRole(userRole);

		UserInfo info3 = new UserInfo();
		info3.setEmail("mehdi3@gmail.com");
		info3.setFirstName("Mehdi3");
		info3.setLastName("Jorshari3");
		info3.setPassword("7845123");
		info3.setDateOfBirth(LocalDate.of(1979, 9, 21));
		info3.setShippingAddress(address3);
		info3.setSecurityQuestion("nsdghdgfhdgfhdgfhgdfhgdfhg");
		info3.setSecurityAnswer("jhdfsjh");
		info3.addRole(userRole);

		UserInfo info4 = new UserInfo();
		info4.setEmail("mehdi4@gmail.com");
		info4.setFirstName("Mehdi4");
		info4.setLastName("Jorshari4");
		info4.setPassword("7845124");
		info4.setDateOfBirth(LocalDate.of(1979, 9, 21));
		info4.setShippingAddress(address4);
		info4.setSecurityQuestion("nsdghdgfhdgfhdgfhgdfhgdfhg");
		info4.setSecurityAnswer("jhdfsjh");
		info4.addRole(userRole);

		UserInfo info5 = new UserInfo();
		info5.setEmail("mehdi5@gmail.com");
		info5.setFirstName("Mehdi5");
		info5.setLastName("Jorshari5");
		info5.setPassword("7845125");
		info5.setDateOfBirth(LocalDate.of(1979, 9, 21));
		info5.setShippingAddress(address5);
		info5.setSecurityQuestion("nsdghdgfhdgfhdgfhgdfhgdfhg");
		info5.setSecurityAnswer("jhdfsjh");
		info5.addRole(adminRole);
		info5.addRole(userRole);

		userInfoRepo.saveAll(Arrays.asList(info1, info2, info3, info4, info5));

		userInfoRepo.delete(info1);

	}

}
