package au.com.mqas.data.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

//import static org.junit.Assert.assertNotNull;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.mqas.domain.model.UserInfo;
import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Slf4j
public class UserInfoRepoTest {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Test
    public void testSave() {
	UserInfo userInfo = new UserInfo();
	userInfo.setEmail("Jamal.kabiri@yahoo.com");
	userInfo.setFirstName("Jamal");
	userInfo.setLastName("kabiri");
	userInfo.setPassword("784512963");

	UserInfo savedUser = userInfoRepo.save(userInfo);

	assertNotNull(savedUser);
	log.info(savedUser.toString());
    }

}
