package com.example.osgi.service.spring.impl;

import com.example.osgi.service.spring.MySpringOsgiService;

public class MySpringOsgiServiceImpl implements MySpringOsgiService {

	@Override
	public String getValue() {

		return "Spring OSGi service says hi!";
	}

}
