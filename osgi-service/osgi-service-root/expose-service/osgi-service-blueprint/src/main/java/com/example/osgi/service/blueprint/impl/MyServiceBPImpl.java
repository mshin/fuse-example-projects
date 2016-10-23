package com.example.osgi.service.blueprint.impl;

import com.example.osgi.service.blueprint.MyServiceBP;

public class MyServiceBPImpl implements MyServiceBP {

	@Override
	public String getValue() {

		return "Blueprint OSGi service says hi!";
	}

}
