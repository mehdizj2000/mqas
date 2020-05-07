package au.com.mqas.data.repo;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.mqas.data.JpaConfig;
import au.com.mqas.db.data.model.Address;
import au.com.mqas.db.data.model.UserInfo;
import au.com.mqas.db.data.model.VerificationToken;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = { JpaConfig.class })
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Slf4j
class VerificationTokenRepoTest {

	@Autowired
	private VerificationTokenRepo verificationTokenRepo;

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Test
	void testFindByToken() {
//	fail("Not yet implemented");
	}

	@Test
//    @Rollback(false)
	void testSave() {
		Address address1 = new Address();
		address1.setAddressLine1("1/57 South Street");
		address1.setAddressLine2("");
		address1.setTown("Rydalmere");
		address1.setPostCode("2116");
		address1.setState("NSW");
		address1.setCountry("Australia");

		UserInfo info1 = new UserInfo();
		info1.setEmail("mehdi34@gmail.com");
		info1.setFirstName("Mehdi1");
		info1.setLastName("Jorshari1");
		info1.setPassword("7845121");
		info1.setDateOfBirth(LocalDate.of(1979, 9, 21));
		info1.setShippingAddress(address1);
		info1.setSecurityQuestion("nsdghdgfhdgfhdgfhgdfhgdfhg");
		info1.setSecurityAnswer("jhdfsjh");

		userInfoRepo.save(info1);

		VerificationToken verificationToken1 = new VerificationToken();
		verificationToken1.setUserInfo(info1);

		verificationTokenRepo.save(verificationToken1);

	}

}
