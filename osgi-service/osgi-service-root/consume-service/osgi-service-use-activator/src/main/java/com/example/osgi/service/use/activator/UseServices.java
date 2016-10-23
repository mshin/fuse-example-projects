package com.example.osgi.service.use.activator;

import com.example.osgi.service.blueprint.MyServiceBP;
import com.example.osgi.service.llapi.MyServiceLLAPI;

public class UseServices {

	public void useServices(MyServiceBP serviceBP, MyServiceLLAPI serviceLLAPI) {

		System.out.println("UseServices BP service value: " + serviceBP.getValue());
		System.out.println("UseServices LLAPI service value: " + serviceLLAPI.getValue());

	}

}
