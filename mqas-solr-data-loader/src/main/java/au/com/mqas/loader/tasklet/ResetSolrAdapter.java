package au.com.mqas.loader.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.UnexpectedJobExecutionException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import au.com.mqas.loader.solr.repo.AddressInfoRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResetSolrAdapter implements Tasklet, InitializingBean {

	private AddressInfoRepo addressInfoRepo;

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		try {
			addressInfoRepo.deleteAll();
		} catch (RuntimeException re) {
			log.error("exception during solr index deletion", re);
			throw new UnexpectedJobExecutionException("exception during solr index deletion", re);
		}
		return RepeatStatus.FINISHED;
	}

	public AddressInfoRepo getAddressInfoRepo() {
		return addressInfoRepo;
	}

	@Autowired
	public void setAddressInfoRepo(AddressInfoRepo addressInfoRepo) {
		this.addressInfoRepo = addressInfoRepo;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Assert.notNull(addressInfoRepo, "Solr repository must be provided");
	}

}
