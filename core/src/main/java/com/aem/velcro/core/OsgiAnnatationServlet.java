package com.aem.velcro.core;

import javax.servlet.Servlet;

import org.osgi.service.component.annotations.Component;

@Component(
			service=Servlet.class,
			property={"paths=/bin/select",
			"methaod=GET"}
			)

public class OsgiAnnatationServlet {

}
