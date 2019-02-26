package com.aem.velcro.core;

import org.apache.felix.scr.annotations.Reference;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;



@Component(
			immediate=true,
			service=OsgiAnnatationService.class
			)

public class OsgiAnnatationService {
	@Reference
	ResourceResolverFactory factory;
	
	public void  testServices() {}

}
