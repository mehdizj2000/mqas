package au.com.mqas.loader.item.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.mqas.loader.solr.domain.SolrAddressInfo;
import au.com.mqas.loader.solr.repo.AddressInfoRepo;

@Component
public class SolrAddressWriter implements ItemWriter<SolrAddressInfo> {

	private AddressInfoRepo addressInfoRepo;

	@Override
	public void write(List<? extends SolrAddressInfo> items) throws Exception {
		addressInfoRepo.saveAll(items);
	}

	public AddressInfoRepo getAddressInfoRepo() {
		return addressInfoRepo;
	}

	@Autowired
	public void setAddressInfoRepo(AddressInfoRepo addressInfoRepo) {
		this.addressInfoRepo = addressInfoRepo;
	}

}
