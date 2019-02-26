package com.aem.velcro.core.servlets;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

import java.io.IOException;

import javax.jcr.Node;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SlingServlet(
		paths = "/bin/custo", 
		methods = "GET"
		)
public class RegisterServlet extends SlingSafeMethodsServlet {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		response.setContentType("text/html");
		
		ResourceResolver resolver = request.getResourceResolver();
		Resource resource = resolver.getResource("/content/project2Page/jcr:content");
		log.info("Resource is" + resource.getPath());
		log.info("Parent resource" + resource.getParent().toString());
		Node node = resource.adaptTo(Node.class);
		Session session = resolver.adaptTo(Session.class);
		
		
		try {
			log.info("Node path::" + node.getPath());
			node.setProperty("backend", "bbb");
			node.addNode("abc", "cq:PageContent");
			log.info("property added");
			log.info("Property added and value is::" + node.getProperties("backend").toString());
			try {
				response.getOutputStream().println(node.getPath()+"---"+node.getProperties("backend").toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.info(" Error is ::"+e.toString());
			}

			session.save();
			
		} catch (RepositoryException e) {
			log.info(" Error is ::"+e.toString());
		}

		log.info("Path is triggered");
	}
}
