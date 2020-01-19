package au.com.mqas.data;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import au.com.mqas.data.repo.AddressRepo;
import au.com.mqas.data.repo.UserInfoRepo;
import au.com.mqas.domain.model.Address;
import au.com.mqas.domain.model.UserInfo;

@SpringBootApplication
@ComponentScan(basePackages = "au.com.mqas.data")
public class ApplicationConfig implements CommandLineRunner {

    private UserInfoRepo userInfoRepo;

    private AddressRepo addressRepo;

    public static void main(String[] args) {
	SpringApplication.run(ApplicationConfig.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

	UserInfo info1 = new UserInfo();
	info1.setEmail("mehdi1@gmail.com");
	info1.setFirstName("Mehdi1");
	info1.setLastName("Jorshari1");
	info1.setPassword("7845121");
	
	UserInfo info2 = new UserInfo();
	info2.setEmail("mehdi2@gmail.com");
	info2.setFirstName("Mehdi1");
	info2.setLastName("Jorshar2");
	info2.setPassword("7845122");
	
	UserInfo info3 = new UserInfo();
	info3.setEmail("mehdi3@gmail.com");
	info3.setFirstName("Mehdi3");
	info3.setLastName("Jorshari3");
	info3.setPassword("7845123");
	
	UserInfo info4 = new UserInfo();
	info4.setEmail("mehdi4@gmail.com");
	info4.setFirstName("Mehdi4");
	info4.setLastName("Jorshari4");
	info4.setPassword("7845124");
	
	UserInfo info5 = new UserInfo();
	info5.setEmail("mehdi5@gmail.com");
	info5.setFirstName("Mehdi5");
	info5.setLastName("Jorshari5");
	info5.setPassword("7845125");
	

	userInfoRepo.saveAll(Arrays.asList(info1,info2,info3,info4,info5));

	Address address1 = new Address();
	address1.setAddrresLine1("1/57 South Street");
	address1.setAddressLine2("");
	address1.setTown("Rydalmere");
	address1.setPostCode("2116");
	address1.setState("NSW");
	address1.setCountry("Australia");
	address1.setUserInfo(info1);
	
	Address address2 = new Address();
	address2.setAddrresLine1("2/57 South Street");
	address2.setAddressLine2("");
	address2.setTown("Rydalmere");
	address2.setPostCode("2116");
	address2.setState("NSW");
	address2.setCountry("Australia");
	address2.setUserInfo(info2);
	
	Address address3 = new Address();
	address3.setAddrresLine1("3/57 South Street");
	address3.setAddressLine2("");
	address3.setTown("Rydalmere");
	address3.setPostCode("2116");
	address3.setState("NSW");
	address3.setCountry("Australia");
	address3.setUserInfo(info3);
	
	Address address4 = new Address();
	address4.setAddrresLine1("4/57 South Street");
	address4.setAddressLine2("");
	address4.setTown("Rydalmere");
	address4.setPostCode("2116");
	address4.setState("NSW");
	address4.setCountry("Australia");
	address4.setUserInfo(info4);
	
	Address address5 = new Address();
	address5.setAddrresLine1("5/57 South Street");
	address5.setAddressLine2("");
	address5.setTown("Rydalmere");
	address5.setPostCode("2116");
	address5.setState("NSW");
	address5.setCountry("Australia");
	address5.setUserInfo(info5);

	addressRepo.saveAll(Arrays.asList(address1,address2,address3,address4,address5));

    }

    public UserInfoRepo getUserInfoRepo() {
	return userInfoRepo;
    }

    @Autowired
    public void setUserInfoRepo(UserInfoRepo userInfoRepo) {
	this.userInfoRepo = userInfoRepo;
    }

    public AddressRepo getAddressRepo() {
	return addressRepo;
    }

    @Autowired
    public void setAddressRepo(AddressRepo addressRepo) {
	this.addressRepo = addressRepo;
    }

}
