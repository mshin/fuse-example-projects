package com.example.osgi.service.use;

import com.example.osgi.bundle.OsgiServices;

public class UseServices  {
	
	private OsgiServices services;

	public void setServices(OsgiServices services) {
		this.services = services;
	}

	public void useServices() {
		
		System.out.println("Using Services...");
		
		System.out.println("UseServices BP service value: " + services.getMyServiceBP().getValue());
		System.out.println("UseServices LLAPI service value: " + services.getMyServiceLLAPI().getValue());

		System.out.println("serviceBP: " + services.getMyServiceBP());
		System.out.println("serviceBPreference: " + services.getMyServiceBPReference());
		
		System.out.println("serviceLLAPI: " + services.getMyServiceLLAPI());
		System.out.println("serviceLLAPIreference: " + services.getMyServiceLLAPIReference());
		
	}

}
