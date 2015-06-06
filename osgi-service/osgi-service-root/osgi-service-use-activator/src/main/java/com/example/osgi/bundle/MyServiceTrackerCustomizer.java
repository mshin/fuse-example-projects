package com.example.osgi.bundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MyServiceTrackerCustomizer implements ServiceTrackerCustomizer {
	
	private BundleContext context;
	
	public MyServiceTrackerCustomizer(BundleContext context) {
		this.context = context;
	}

	@Override
	public Object addingService(ServiceReference reference) {
		System.out.println("adding service");
		return context.getService(reference);
	}

	@Override
	public void modifiedService(ServiceReference reference, Object service) {
		System.out.println("modified service");
	    // removedService(reference, service);
	    // addingService(reference);		
	}

	@Override
	public void removedService(ServiceReference reference, Object service) {
		System.out.println("removed service");
		//THIS IS IMPORTANT
		System.out.println(context.ungetService(reference));
		
	}

}
