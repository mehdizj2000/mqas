package au.com.mqas.loader.solr.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import au.com.mqas.loader.solr.domain.SolrAddressInfo;

public interface AddressInfoRepo extends SolrCrudRepository<SolrAddressInfo, String> {

	@Query(requestHandler = "/selectAddress", value = "?0")
	Page<SolrAddressInfo> getAddressInfo(String str, Pageable pageable);

	@Query(requestHandler = "/selectAddress", value = "?0*")
	Page<SolrAddressInfo> getAddressInfo1(String str, Pageable pageable);

}
