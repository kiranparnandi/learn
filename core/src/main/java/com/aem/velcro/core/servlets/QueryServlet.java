package com.aem.velcro.core.servlets;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.velcro.core.QueryBean;
import com.aem.velcro.core.QueryService;

@SlingServlet(
		paths = "/bin/query",
		methods = "Get")
public class QueryServlet extends SlingSafeMethodsServlet {
	@Reference
	QueryService service;
	protected final Logger log = LoggerFactory.getLogger(this.getClass());

	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
		response.setContentType("Text/Html");
List<QueryBean> tagList = service.getTagSearchresults("/content/screens/we-retail/apps/virtual-showroom/en/equipment", "we-retail:session/summer");
	 Iterator<QueryBean> itr = tagList.iterator();
	 while(itr.hasNext()){
		 log.info("in Servlet loop");
		 QueryBean bean = itr.next();
		 log.info("Path:"+bean.getPagePath());
		 try {
			response.getOutputStream().println("Path:"+bean.getPagePath()+"<br> Title:"+bean.getTitle()+"<br>")	;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		 log.info("Title:"+bean.getTitle());
		// log.info("Tags:"+bean.getTag());
		 
	 }
	
	}}