package com.example.cxfrj.rest.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestModel {
	
	@JsonProperty
	private Integer id;
	@JsonProperty
	private String name;
	@JsonProperty
	private Integer count;
	@JsonProperty
	private Map<String, Object> map;
	@JsonProperty
	private List<String> list;
	
	public RestModel(){

	}

	public RestModel(Integer id, String name, Integer count,
			Map<String, Object> map, List<String> list) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.map = map;
		this.list = list;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}
