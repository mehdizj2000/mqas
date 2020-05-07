package au.com.mqas.solr.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import au.com.mqas.solr.domain.AddressInfo;

public interface AddressInfoRepo extends SolrCrudRepository<AddressInfo, String> {

	@Query(requestHandler = "/selectAddress", value = "*?0*")
	Page<AddressInfo> getAddressInfo(String str, Pageable pageable);

	@Query(requestHandler = "/selectAddress", value = "?0*")
	Page<AddressInfo> getAddressInfo1(String str, Pageable pageable);

}
