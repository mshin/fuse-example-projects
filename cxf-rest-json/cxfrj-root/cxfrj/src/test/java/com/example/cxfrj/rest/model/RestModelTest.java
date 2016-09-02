package com.example.cxfrj.rest.model;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestModelTest {

	@Test
	public void createJson() throws JsonProcessingException{
		ObjectMapper objectMapper = new ObjectMapper();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", "obj1");
		map.put("key2", "val2");
		
		RestModel restModel = new RestModel(1, "routeId1", 1, map, 
				Arrays.asList(new String[]{"a", "b", "c"}));

		String json = objectMapper.writeValueAsString(restModel);
		System.out.println(json);
	}
	
	@Test
	public void jsonToObject() throws JsonParseException, JsonMappingException, IOException{
		String json = "{\"id\":1,\"name\":\"routeId1\",\"count\":3,\"map\":{\"key2\":\"val2\",\"key1\":\"obj1\"},\"list\":[\"a\",\"b\",\"c\"]}";
		Reader reader = new StringReader(json);

		ObjectMapper objectMapper = new ObjectMapper();
		RestModel restModel = objectMapper.readValue(reader, RestModel.class);
		Map<String, Object> optionsMap = restModel.getMap();
		System.out.println(optionsMap);
	}
	
	
}
