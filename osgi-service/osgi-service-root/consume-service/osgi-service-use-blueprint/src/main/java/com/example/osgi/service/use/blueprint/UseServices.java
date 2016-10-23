package com.example.osgi.service.use.blueprint;

import com.example.osgi.service.llapi.MyServiceLLAPI;
import com.example.osgi.service.blueprint.MyServiceBP;



public class UseServices  {
	
	private MyServiceBP myServiceBP;
	private MyServiceLLAPI myServiceLLAPI;

	public void useServices() {

		System.out.println("UseServices BP service value: " + myServiceBP.getValue());

		System.out.println("UseServices LLAPI service value: " + myServiceLLAPI.getValue());
	}

	public void setMyServiceBP(MyServiceBP myServiceBP) {
		System.out.println("setting BP service.");
		this.myServiceBP = myServiceBP;
		
		if (null != myServiceLLAPI) useServices();
	}
	
	public void setMyServiceLLAPI(MyServiceLLAPI myServiceLLAPI) {
		System.out.println("setting LLAPI service.");
		this.myServiceLLAPI = myServiceLLAPI;
		
		if (null != myServiceBP) useServices();
	}

}
