package au.com.mqas.loader;

import java.util.Arrays;
import java.util.Optional;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = "au.com.mqas.loader.solr.repo")
public class SolrClientConfig {

	@Bean
	public SolrClient solrClient() {
		Builder builder = new CloudSolrClient.Builder(Arrays.asList("node01:2181", "node02:2181", "node03:2181"),
				Optional.empty());
		return builder.build();
	}

	@Bean
	public SolrTemplate solrTemplate(SolrClient solrClient) {
		return new SolrTemplate(solrClient);
	}

}
