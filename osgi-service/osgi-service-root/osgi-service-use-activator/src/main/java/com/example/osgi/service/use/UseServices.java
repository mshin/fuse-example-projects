package com.example.osgi.service.use;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import com.example.osgi.service.llapi.MyServiceLLAPI;
import com.example.osgi.service.blueprint.MyServiceBP;



public class UseServices  {

	public void useServices() {

		//if you can manage to pass the reference from the activator, even better.
		BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		
		ServiceReference<?> serviceReference1 = context.getServiceReference(MyServiceBP.class.getName());
		MyServiceBP serviceBP = (MyServiceBP) context.getService(serviceReference1);
		
		ServiceReference<?> serviceReference2 = context.getServiceReference(MyServiceLLAPI.class.getName());
		MyServiceLLAPI serviceLLAPI = (MyServiceLLAPI) context.getService(serviceReference2);

		
		System.out.println("UseServices BP service value: " + serviceBP.getValue());
		System.out.println("UseServices LLAPI service value: " + serviceLLAPI.getValue());

		System.out.println("serviceBP: " + serviceBP);
		System.out.println("serviceBPreference: " + serviceReference1);
		
		System.out.println("serviceLLAPI: " + serviceLLAPI);
		System.out.println("serviceBPreference: " + serviceReference2);
		
		System.out.println(context.ungetService(serviceReference1));
		System.out.println(context.ungetService(serviceReference2));
	}

}
