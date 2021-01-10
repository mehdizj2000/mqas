package au.com.mqas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import au.com.mqas.transfer.data.dto.AddressInfoDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AddressController {

	@Value("${mqas.solr.api.url}")
	private String apiUrl;

	private RestTemplate restTemplate;

	@GetMapping("/api/getAddress/{terms}")
	public ResponseEntity<AddressInfoDto[]> findAddress(@PathVariable(name = "terms") String terms) {
		
		
		ResponseEntity<AddressInfoDto[]> data = restTemplate.getForEntity(apiUrl + terms, AddressInfoDto[].class);

		return data;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	@Autowired
	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

}