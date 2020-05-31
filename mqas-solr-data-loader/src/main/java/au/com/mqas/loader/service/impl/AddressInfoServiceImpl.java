package au.com.mqas.loader.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import au.com.mqas.loader.db.domain.AddressInfo;
import au.com.mqas.loader.db.repo.AddressViewRepo;
import au.com.mqas.loader.service.AddressInfoService;

@Service
public class AddressInfoServiceImpl implements AddressInfoService {

	private AddressViewRepo addressRepo;

	@Override
	public List<AddressInfo> listAddresses() {
		return addressRepo.findAll(PageRequest.of(0, 50)).toList();
	}

	public AddressViewRepo getAddressRepo() {
		return addressRepo;
	}

	@Autowired
	public void setAddressRepo(AddressViewRepo addressRepo) {
		this.addressRepo = addressRepo;
	}

}
