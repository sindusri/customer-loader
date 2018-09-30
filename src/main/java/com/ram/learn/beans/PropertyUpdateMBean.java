package com.ram.learn.beans;

import javax.annotation.ManagedBean;

import org.springframework.jmx.export.annotation.ManagedOperation;

@ManagedBean
public class PropertyUpdateMBean {

	@ManagedOperation
	private String getPropertyValue(String property) {
		return System.getProperties().getProperty(property);
	}

	@ManagedOperation
	private Boolean setPropertyValue(String propety, String value) {
		String previousValue = System.setProperty(propety, value);
		if (null != previousValue) {
			return true;
		}
		return false;
	}

}
