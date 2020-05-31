package au.com.mqas.loader;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import au.com.mqas.loader.db.domain.AddressInfo;
import au.com.mqas.loader.item.processor.SolrAddressConverter;
import au.com.mqas.loader.item.writer.SolrAddressWriter;
import au.com.mqas.loader.solr.domain.SolrAddressInfo;
import au.com.mqas.loader.tasklet.ResetSolrAdapter;

@Configuration
@EnableBatchProcessing
public class BatchApplicationConfig {

	@Autowired
	private JobBuilderFactory jobBuilder;

	@Autowired
	private StepBuilderFactory stepBuilder;

	@Autowired
	private SolrAddressWriter solrIndexer;

	@Autowired
	private SolrAddressConverter solrAddressConverter;

	@Autowired
	private ResetSolrAdapter resetSolrAdapter;

	@Autowired
	private EntityManagerFactory emf;

	@Bean
	public Step resetTasklet() {
		// @formatter:off
 		return stepBuilder
 				.get("resetSolr")
 				.tasklet(resetSolrAdapter)
 			.build();
		// @formatter:on
	}

	@Bean
	public Step stepOne() {
		// @formatter:off
	 	return stepBuilder
	 		.get("stepOne")
	 		.<AddressInfo, SolrAddressInfo> chunk(1000)
	 		.reader(addressReader())
	 		.processor(solrAddressConverter)
	 		.writer(solrIndexer)
	 	.build();
		// @formatter:on
	}

	@Bean
	public ItemReader<AddressInfo> addressReader() {

		// @formatter:off
	 	return new JpaPagingItemReaderBuilder<AddressInfo>()
	 			.name("addReader")
	 			.entityManagerFactory(emf)
	 			.maxItemCount(2000)
	 			.queryString("select f from AddressInfo f")
	 			.pageSize(1000)
	 		.build();
		// @formatter:on	
	}

	@Bean
	public Job demoJob() {
		// @formatter:off
	 	return jobBuilder.get("demoJowdf3")
			.incrementer(new RunIdIncrementer())
			.start(resetTasklet())
			.next(stepOne())
		.build();
		// @formatter:on
	}

}
