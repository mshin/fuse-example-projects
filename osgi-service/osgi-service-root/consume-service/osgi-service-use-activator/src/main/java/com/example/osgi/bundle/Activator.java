package com.example.osgi.bundle;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.example.osgi.service.llapi.MyServiceLLAPI;
import com.example.osgi.service.use.activator.UseServices;
import com.example.osgi.service.blueprint.MyServiceBP;

public class Activator implements BundleActivator {

	private BundleContext context;
	private MyServiceBP serviceBP;
	private MyServiceLLAPI serviceLLAPI;

	private ServiceTracker<MyServiceLLAPI, MyServiceLLAPI> serviceTrackerLLAPI;
	private ServiceTracker<MyServiceBP, MyServiceBP> serviceTrackerBP;

	public void start(BundleContext context) throws Exception {
		this.context = context;
		System.out.println("Starting bundle");

		ServiceReference<?> serviceReference1 = context.getServiceReference(MyServiceBP.class.getName());
		MyServiceBP serviceBP = (MyServiceBP) context.getService(serviceReference1);

		ServiceReference<?> serviceReference2 = context.getServiceReference(MyServiceLLAPI.class.getName());
		MyServiceLLAPI serviceLLAPI = (MyServiceLLAPI) context.getService(serviceReference2);

		MyServiceTrackerCustomizer<MyServiceLLAPI, MyServiceLLAPI> customizer1 = 
				new MyServiceTrackerCustomizer<MyServiceLLAPI, MyServiceLLAPI>(context);
		serviceTrackerLLAPI = new ServiceTracker<MyServiceLLAPI, MyServiceLLAPI>(context,
				MyServiceLLAPI.class.getName(), customizer1);
		serviceTrackerLLAPI.open();

		MyServiceTrackerCustomizer<MyServiceBP, MyServiceBP> customizer2 = 
				new MyServiceTrackerCustomizer<MyServiceBP, MyServiceBP>(context);
		serviceTrackerBP = new ServiceTracker<MyServiceBP, MyServiceBP>(context, MyServiceBP.class.getName(),
				customizer2);
		serviceTrackerBP.open();

//		System.out.println("serviceBP: " + serviceBP.getValue());
//		System.out.println("serviceLLAPI: " + serviceLLAPI.getValue());
//
//		System.out.println("serviceBP: " + serviceBP);
//		System.out.println("serviceBPreference: " + serviceReference1);
//
//		System.out.println("serviceLLAPI: " + serviceLLAPI);
//		System.out.println("serviceBPreference: " + serviceReference2);

		new UseServices().useServices(serviceBP, serviceLLAPI);
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Stopping bundle");

		serviceTrackerLLAPI.close();
		serviceTrackerBP.close();
	}
}
