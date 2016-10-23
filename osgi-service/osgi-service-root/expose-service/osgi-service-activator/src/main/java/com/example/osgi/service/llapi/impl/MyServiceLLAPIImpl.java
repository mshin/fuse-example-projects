package com.example.osgi.service.llapi.impl;

import com.example.osgi.service.llapi.MyServiceLLAPI;

public class MyServiceLLAPIImpl implements MyServiceLLAPI {

	@Override
	public String getValue() {

		return "Low level API OSGi service says hi!";
	}

}
