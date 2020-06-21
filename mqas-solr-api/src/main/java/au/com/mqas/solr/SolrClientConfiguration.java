package au.com.mqas.solr;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient.Builder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.SolrPageRequest;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories
public class SolrClientConfiguration {

	@Value("${gnaf.zk-servers}")
	List<String> zkServers;

	@Bean
	public SolrClient solrClient() {
		Builder builder = new CloudSolrClient.Builder(zkServers, Optional.empty());
		return builder.build();
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient solrClient) {
		return new SolrTemplate(solrClient);
	}

	@Bean
	public Pageable pageable() {
		return new SolrPageRequest(0, 10);
	}

}
