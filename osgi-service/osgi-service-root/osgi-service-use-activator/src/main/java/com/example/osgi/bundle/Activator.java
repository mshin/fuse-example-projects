package com.example.osgi.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.example.osgi.service.llapi.MyServiceLLAPI;
import com.example.osgi.service.blueprint.MyServiceBP;

import com.example.osgi.service.use.UseServices;


public class Activator implements BundleActivator {
	
	private BundleContext context;
	private MyServiceBP serviceBP;
	private MyServiceLLAPI serviceLLAPI;
	
	private ServiceTracker serviceTrackerLLAPI;
	private ServiceTracker serviceTrackerBP;

	public void start(BundleContext context) throws Exception {
		this.context = context;
		System.out.println("Starting bundle");
		
		ServiceReference<?> serviceReference1 = context.getServiceReference(MyServiceBP.class.getName());
		MyServiceBP serviceBP = (MyServiceBP) context.getService(serviceReference1);
		
		ServiceReference<?> serviceReference2 = context.getServiceReference(MyServiceLLAPI.class.getName());
		MyServiceLLAPI serviceLLAPI = (MyServiceLLAPI) context.getService(serviceReference2);
		
		MyServiceTrackerCustomizer customizer = new MyServiceTrackerCustomizer(context);
		serviceTrackerLLAPI = new ServiceTracker(context, MyServiceLLAPI.class.getName(), customizer);
		serviceTrackerLLAPI.open();
		
		serviceTrackerBP = new ServiceTracker(context, MyServiceBP.class.getName(), customizer);
		serviceTrackerBP.open();
		
		
		
		System.out.println("serviceBP: " + serviceBP.getValue());
		System.out.println("serviceLLAPI: " + serviceLLAPI.getValue());
		
		System.out.println("serviceBP: " + serviceBP);
		System.out.println("serviceBPreference: " + serviceReference1);
		
		System.out.println("serviceLLAPI: " + serviceLLAPI);
		System.out.println("serviceBPreference: " + serviceReference2);
		
		new UseServices().useServices();
	}
	
	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping bundle");
		
		serviceTrackerLLAPI.close();
		serviceTrackerBP.close();
	}
}
