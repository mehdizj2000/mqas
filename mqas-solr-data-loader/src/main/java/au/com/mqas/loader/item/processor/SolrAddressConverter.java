package au.com.mqas.loader.item.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import au.com.mqas.loader.db.domain.AddressInfo;
import au.com.mqas.loader.mapper.AddressMapper;
import au.com.mqas.loader.solr.domain.SolrAddressInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SolrAddressConverter implements ItemProcessor<AddressInfo, SolrAddressInfo> {

	@Autowired
	private AddressMapper addressMapper;

	@Override
	public SolrAddressInfo process(AddressInfo item) throws Exception {
		return addressMapper.dbAddressToSolrAddress(item);
	}

}
