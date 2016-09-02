package com.example.cxfrj.service;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.cxfrj.rest.model.RestModel;
import com.example.cxfrj.util.ResponseBuilder;

public class BusinessService {
	
	private static final String CLASS_NAME = BusinessService.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	private Map<Integer, RestModel> inMemoryMap = new HashMap<Integer, RestModel>();

	public Response getModels() {
		
		return ResponseBuilder.createOk(inMemoryMap);
	}

	public Response getModel(Integer id) {
		if (inMemoryMap.containsKey(id)) {
			return ResponseBuilder.createOk(inMemoryMap.get(id));
		} else {
			return ResponseBuilder.createNoContent();
		}
	}

	public Response createModel(RestModel restModel) {
		if (null != restModel && null != restModel.getId()) {
			inMemoryMap.put(restModel.getId(), restModel);
			return ResponseBuilder.createOk("created!");
		} else {
			return ResponseBuilder.createBadRequestError("Either restModel or restModel.id was null.");
		}
		
	}

	public Response deleteModel(Integer id) {
		if (inMemoryMap.containsKey(id)) {
			inMemoryMap.remove(id);
			return ResponseBuilder.createOk("Model with id " + id + " deleted.");
		} else {
			return ResponseBuilder.createOk("Model with id " + id + " not deleted because it did not exist.");
		}
	}
}
