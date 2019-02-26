package com.aem.velcro.core.wcmuse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;

public class GetDialogValues extends WCMUsePojo {
	protected final Logger log = LoggerFactory.getLogger(this.getClass());
	private String text;
	private String path;
	private String componentName;
	private String resourceType;

	public String getText() {
		return text;
	}

	public String getPath() {
		return path;
	}

	public String getComponentName() {
		return componentName; 
	}

	public String getResourceType() {
		return resourceType;
	}

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		text = getProperties().get("./text").toString();
		path = getProperties().get("./path").toString();
		componentName = getComponent().getName();
		resourceType = getPageProperties().get("./sling:resourceType", "NULL");
		log.info("Values from Dialog::" +text + path + componentName);
	}

}
