package au.com.mqas.loader.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import au.com.mqas.loader.db.domain.AddressInfo;
import au.com.mqas.loader.solr.domain.SolrAddressInfo;

@Mapper(componentModel = "spring")
public interface AddressMapper {

	SolrAddressInfo dbAddressToSolrAddress(AddressInfo addressInfo);
	
	AddressInfo solrAddressToDbAddress(SolrAddressInfo solrAddressInfo);
	
	List<SolrAddressInfo> dbAddressListToSolrAddressList(List<AddressInfo> addressInfo);
	
	List<AddressInfo> solrAddressListToDbAddressList(List<SolrAddressInfo> solrAddressInfo);
	
}
