package com.aem.velcro.core;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
			service = OsgiServices.class
		  )

public class OsgiServices {

	private OsgiAnnatationService servic;

	@Reference
	public void bindOsgiAnnatationService(OsgiAnnatationService service) {
		this.servic = service;
	}

	public void unbindOsgiAnnatationService(OsgiAnnatationService service) {
		this.servic = service;
	}
	public void method() {
		servic.testServices();;
	}
}
