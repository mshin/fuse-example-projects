package com.example.osgi.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.example.osgi.service.llapi.MyServiceLLAPI;
import com.example.osgi.service.llapi.impl.MyServiceLLAPIImpl;

import java.util.Dictionary;
import java.util.Hashtable;

public class Activator implements BundleActivator {
	
	ServiceRegistration registration;

	public void start(BundleContext context) throws Exception {
		System.out.println("Starting bundle");
		
		//Can use properties file here as Properties is a Hashtable.
		Dictionary<String, String> dictionary = new Hashtable<String, String>();
		
		registration = context.registerService(MyServiceLLAPI.class.getName(), new MyServiceLLAPIImpl(), dictionary);
		
	}
	
	public void stop(BundleContext context) throws Exception {
		
		System.out.println("Stopping bundle");
		
		registration.unregister();
		
	}
}
