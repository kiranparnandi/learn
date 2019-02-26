package com.aem.velcro.core.servlets;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.velcro.core.OsgiService;
import com.aem.velcro.core.OsgiServiceInterface;

@SlingServlet(
				paths = "/bin/service",
				methods = "GET"
			 )

public class ServiceServlet extends SlingSafeMethodsServlet {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	@Reference
	OsgiServiceInterface service;

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		service.addNodeFromService("/content/project2Page/jcr:content", "service");
		service.addPropertyFromService("/content/project2Page/jcr:content", "service", "value");
	}
}
