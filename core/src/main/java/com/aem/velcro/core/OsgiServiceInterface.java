package com.aem.velcro.core;




public interface OsgiServiceInterface {
	public void addNodeFromService(String path, String nodeName);
	public void addPropertyFromService(String path, String name, String value);
	public String getPropertyFromService(String path);
}
