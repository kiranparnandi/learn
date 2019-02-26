package com.aem.velcro.core.schedulers;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.velcro.core.OsgiServiceInterface;

@Component(
			immediate = true, 
			metatype = true, 
			label = "Schedular API", 
			description = "Scheduler class which triggers for every 1 minute"
			)
@Service(value = Runnable.class)
@Property(
			name = "scheduler.expression",
			value = " 0 0/1 * 1/1 * ? * "
		)
public class ShedularJob implements Runnable {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Reference
	OsgiServiceInterface osgiservice;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		log.info("in Run method");
		log.info("from schedular to service::"
				+ osgiservice.getPropertyFromService("/content/project2Page/jcr:content"));
	}

}
