package com.example.fpms.processor;

import org.apache.commons.dbcp.BasicDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ProcessorBean {

	private static final String CLASS_NAME = ProcessorBean.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);

	private String environment;
	private BasicDataSource datasource;

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setDatasource(BasicDataSource datasource) {
		this.datasource = datasource;
	}

	public String getObject() {
		LOGGER.info("Called getObject");
		return "In environment " + environment;
	}

	public String getObjectValue() {
		LOGGER.info("Called getObjectValue");
		return datasource.getUrl();
	}

}
