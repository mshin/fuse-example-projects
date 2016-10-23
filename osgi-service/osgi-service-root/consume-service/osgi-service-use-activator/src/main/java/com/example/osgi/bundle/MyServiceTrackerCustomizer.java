package com.example.osgi.bundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MyServiceTrackerCustomizer<S, T> implements ServiceTrackerCustomizer<S, T> {
	
	private BundleContext context;
	
	public MyServiceTrackerCustomizer(BundleContext context) {
		this.context = context;
	}

	@Override
	public T addingService(ServiceReference<S> reference) {
		System.out.println("adding service");
		return (T) context.getService(reference);
	}

	@Override
	public void modifiedService(ServiceReference<S> reference, T service) {
		System.out.println("modified service");
		// removedService(reference, service);
		// addingService(reference);
	}

	@Override
	public void removedService(ServiceReference<S> reference, T service) {

		// THIS IS IMPORTANT
		System.out.println("ungotService: " + context.ungetService(reference));

		System.out.println("removed service");
	}

}
