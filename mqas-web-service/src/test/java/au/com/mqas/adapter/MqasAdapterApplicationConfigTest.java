package au.com.mqas.adapter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import au.com.mqas.adapter.service.UserInfoService;
import au.com.mqas.data.JpaConfig;
import au.com.mqas.data.MqasDataApplicationConfig;
import au.com.mqas.db.data.model.Address;
import au.com.mqas.db.data.model.UserInfo;

@SpringBootTest
@ContextConfiguration(classes = { MqasAdapterApplicationConfig.class, MqasDataApplicationConfig.class,
	JpaConfig.class })
class MqasAdapterApplicationConfigTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void testInsert() {

	UserInfo userInfo = new UserInfo();
	userInfo.setEmail("kazem@yahoo.com");
	userInfo.setFirstName("kazem");
	userInfo.setLastName("pool-lazem");
	userInfo.setPassword("123456");

	Address address = new Address();
	address.setAddressLine1("line1");
	address.setAddressLine2("line2");
	address.setCountry("Uganda");
	address.setPostCode("4545456765");
	address.setState("Goumba Goumba");
	address.setTown("Ghombol");

	userInfo.setShippingAddress(address);

	UserInfo savedUser = userInfoService.saveUser(userInfo);

	assertNotNull(savedUser);

    }

}
