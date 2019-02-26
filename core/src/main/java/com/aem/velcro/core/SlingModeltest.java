package com.aem.velcro.core;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class SlingModeltest {

	@Inject
	@Optional
	private String path;

	public String getPath() {
		return path;
	}

	public String getResorceType() {
		return resorceType;
	}

	@Inject
	@Optional
	@Named("sling:resourceType")
	private String resorceType;

}
