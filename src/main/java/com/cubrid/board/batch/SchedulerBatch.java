package com.cubrid.board.batch;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.cubrid.board.post.PostMapper;

@Component("quartzComp")
public class SchedulerBatch extends QuartzJobBean {
	
	@Autowired
	public PostMapper postMapper;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("quartz");
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		
		try {
			System.out.println(postMapper.sqlTest());
			postMapper.callProcedure();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
