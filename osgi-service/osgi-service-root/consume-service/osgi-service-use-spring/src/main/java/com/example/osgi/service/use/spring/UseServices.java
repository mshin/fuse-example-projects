package com.example.osgi.service.use.spring;

import com.example.osgi.service.blueprint.MyServiceBP;
import com.example.osgi.service.llapi.MyServiceLLAPI;
import com.example.osgi.service.spring.MyNoInterfaceSpringOsgiService;
import com.example.osgi.service.spring.MySpringOsgiService;

public class UseServices {

	private MyServiceBP myServiceBP;
	private MyServiceLLAPI myServiceLLAPI;
	private MySpringOsgiService mySpringOsgiService;
	private MyNoInterfaceSpringOsgiService myNoInterfaceSpringOsgiService;

	public void useServices() {

		System.out.println("UseServices BP service value: " + myServiceBP.getValue());

		System.out.println("UseServices LLAPI service value: " + myServiceLLAPI.getValue());

		System.out.println("UseServices mySpringOsgiService value: " + mySpringOsgiService.getValue());

		System.out.println(
				"UseServices myNoInterfaceSpringOsgiService value: " + myNoInterfaceSpringOsgiService.getValue());
	}

	public void setMyServiceBP(MyServiceBP myServiceBP) {
		System.out.println("setting BP service.");
		this.myServiceBP = myServiceBP;
	}

	public void setMyServiceLLAPI(MyServiceLLAPI myServiceLLAPI) {
		System.out.println("setting LLAPI service.");
		this.myServiceLLAPI = myServiceLLAPI;
	}

	public void setMySpringOsgiService(MySpringOsgiService mySpringOsgiService) {
		System.out.println("setting Spring service.");
		this.mySpringOsgiService = mySpringOsgiService;
	}

	public void setMyNoInterfaceSpringOsgiService(MyNoInterfaceSpringOsgiService myNoInterfaceSpringOsgiService) {
		System.out.println("setting Spring no-interface service.");
		this.myNoInterfaceSpringOsgiService = myNoInterfaceSpringOsgiService;
	}

}
