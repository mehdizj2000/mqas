package au.com.mqas.loader.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import au.com.mqas.loader.db.domain.AddressInfo;
import au.com.mqas.loader.db.repo.AddressViewRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AddressInfoRepoTest {

	@Autowired
	private AddressViewRepo addressInfoRepo;

	@Test
	void testFindAllPageable() {
		
		Page<AddressInfo> page = addressInfoRepo.findAll(PageRequest.of(0, 50));
		assertNotNull(page);
		page.stream().map(ToStringBuilder::reflectionToString).collect(Collectors.toList()).forEach(log::info);
		log.info("===============================================");
		Page<AddressInfo> page2 = addressInfoRepo.findAll(PageRequest.of(1, 50));
		assertNotNull(page2);
		page2.stream().map(ToStringBuilder::reflectionToString).collect(Collectors.toList()).forEach(log::info);
	}

}
