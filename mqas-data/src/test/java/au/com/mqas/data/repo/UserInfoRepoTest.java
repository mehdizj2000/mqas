package au.com.mqas.data.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

//import static org.junit.Assert.assertNotNull;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.mqas.domain.model.Address;
import au.com.mqas.domain.model.UserInfo;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Slf4j
public class UserInfoRepoTest {

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Test
	@Rollback(false)
	public void testSave() {

		Address address1 = new Address();
		address1.setAddrresLine1("1/57 South Street");
		address1.setAddressLine2("");
		address1.setTown("Rydalmere");
		address1.setPostCode("2116");
		address1.setState("NSW");
		address1.setCountry("Australia");

		Address address2 = new Address();
		address2.setAddrresLine1("2/57 South Street");
		address2.setAddressLine2("");
		address2.setTown("Rydalmere");
		address2.setPostCode("2116");
		address2.setState("NSW");
		address2.setCountry("Australia");

		Address address3 = new Address();
		address3.setAddrresLine1("3/57 South Street");
		address3.setAddressLine2("");
		address3.setTown("Rydalmere");
		address3.setPostCode("2116");
		address3.setState("NSW");
		address3.setCountry("Australia");

		Address address4 = new Address();
		address4.setAddrresLine1("4/57 South Street");
		address4.setAddressLine2("");
		address4.setTown("Rydalmere");
		address4.setPostCode("2116");
		address4.setState("NSW");
		address4.setCountry("Australia");

		Address address5 = new Address();
		address5.setAddrresLine1("5/57 South Street");
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
		info1.setShippingAddress(address1);

		UserInfo info2 = new UserInfo();
		info2.setEmail("mehdi2@gmail.com");
		info2.setFirstName("Mehdi2");
		info2.setLastName("Jorshar2");
		info2.setPassword("7845122");
		info2.setShippingAddress(address2);

		UserInfo info3 = new UserInfo();
		info3.setEmail("mehdi3@gmail.com");
		info3.setFirstName("Mehdi3");
		info3.setLastName("Jorshari3");
		info3.setPassword("7845123");
		info3.setShippingAddress(address3);

		UserInfo info4 = new UserInfo();
		info4.setEmail("mehdi4@gmail.com");
		info4.setFirstName("Mehdi4");
		info4.setLastName("Jorshari4");
		info4.setPassword("7845124");
		info4.setShippingAddress(address4);

		UserInfo info5 = new UserInfo();
		info5.setEmail("mehdi5@gmail.com");
		info5.setFirstName("Mehdi5");
		info5.setLastName("Jorshari5");
		info5.setPassword("7845125");
		info5.setShippingAddress(address5);

		userInfoRepo.saveAll(Arrays.asList(info1, info2, info3, info4, info5));

//	UserInfo savedUser = userInfoRepo.save(info1);
//
//	assertNotNull(savedUser);
//	log.info(savedUser.toString());
	}

}
