package com.example.osgi.bundle;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.example.osgi.service.llapi.MyServiceLLAPI;
import com.example.osgi.service.blueprint.MyServiceBP;


public class OsgiServices {

	private BundleContext context;
	
	private ServiceReference<MyServiceBP> myServiceBPReference;
	private ServiceReference<MyServiceLLAPI> myServiceLLAPIReference;
	
	private MyServiceBP myServiceBP;
	private MyServiceLLAPI myServiceLLAPI;


	public BundleContext getBundleContext() {
		return context;
	}

	/**
	 * Don't set this method to a variable. Please always call the method to get the reference to the service.
	 * @return
	 */
	public MyServiceBP getMyServiceBP() {
		return myServiceBP;
	}

	/**
	 * Don't set this method to a variable. Please always call the method to get the reference to the service.
	 * @return
	 */
	public MyServiceLLAPI getMyServiceLLAPI() {
		return myServiceLLAPI;
	}
	

	public ServiceReference<MyServiceBP> getMyServiceBPReference() {
		return myServiceBPReference;
	}

	public ServiceReference<MyServiceLLAPI> getMyServiceLLAPIReference() {
		return myServiceLLAPIReference;
	}

	//package level visibility
	void setMyServiceBPReference(
			ServiceReference<MyServiceBP> myServiceBPReference) {
		this.myServiceBPReference = myServiceBPReference;
	}

	void setMyServiceLLAPIReference(
			ServiceReference<MyServiceLLAPI> myServiceLLAPIReference) {
		this.myServiceLLAPIReference = myServiceLLAPIReference;
	}

	void setMyServiceBP(MyServiceBP myServiceBP) {
		this.myServiceBP = myServiceBP;
	}

	void setMyServiceLLAPI(MyServiceLLAPI myServiceLLAPI) {
		this.myServiceLLAPI = myServiceLLAPI;
	}
	
	public void init() {
		System.out.println("initializing " + this.getClass().getName() + "...");
		
		this.context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		
		this.setMyServiceBPReference(context.getServiceReference(MyServiceBP.class));
		this.setMyServiceBP(context.getService(this.getMyServiceBPReference()));
		
		this.setMyServiceLLAPIReference(context.getServiceReference(MyServiceLLAPI.class));
		this.setMyServiceLLAPI(context.getService(this.getMyServiceLLAPIReference()));
		
		System.out.println("serviceBP: " + this.getMyServiceBP());
		System.out.println("serviceBPreference: " + this.getMyServiceBPReference());
		
		System.out.println("serviceLLAPI: " + this.getMyServiceLLAPI());
		System.out.println("serviceLLAPIreference: " + this.getMyServiceLLAPIReference());
		
		System.out.println("Finished initializing " + this.getClass().getName() + ".");
	}
	
	public void close() {
		System.out.println("destroying " + this.getClass().getName() + "...");
		
		this.myServiceBP = null;
		this.myServiceLLAPI = null;
		context.ungetService(this.myServiceBPReference);
		context.ungetService(this.myServiceLLAPIReference);
		
		System.out.println("Finished destroying " + this.getClass().getName() + ".");
	}

}
