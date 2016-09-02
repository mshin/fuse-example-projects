package com.example.cxfrj.rest;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.cxfrj.rest.model.RestModel;
import com.example.cxfrj.service.BusinessService;

public class CxfRestJsonServiceImpl implements CxfRestJsonService {

	private static final String CLASS_NAME = CxfRestJsonServiceImpl.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);

	private BusinessService businessService;
	
	@Override
	public Response getModels() {
		return businessService.getModels();
	}
	@Override
	public Response getModel(Integer id) {
		return businessService.getModel(id);
	}
	@Override
	public Response createModel(RestModel restModel) {
		return businessService.createModel(restModel);
	}
	@Override
	public Response deleteModel(Integer id) {
		return businessService.deleteModel(id);
	}

	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}


}
