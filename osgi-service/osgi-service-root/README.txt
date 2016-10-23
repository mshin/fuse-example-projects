The purpose of this example project is to show how to use OSGi services in Karaf using blueprint, spring, and programmatically. It is assumed that bundles will always be created using Maven and the maven-bundle-plugin.

osgi-service-blueprint
Expose an OSGi service to be used by other bundles using blueprint.

osgi-service-activator
Expose an OSGi service to be used by other bundles using the low level Java API.


osgi-service-use-blueprint
Consume the OSGi services exposed by our other bundles. Uses blueprint to get a reference to the services and wire it up with our bean that uses the services.

osgi-service-use-activator
Consume the OSGi services exposed by our other bundles. 
Uses the low level Java API in the bean one case to get a reference to the services and use them.
Uses the low level API in an Activator in the other case to get references to the services. These references are tracked using a ServiceTracker. Ideally, the references to the services should be shared with the beans that need them.



osgi-service-features
Builds the features.xml feature repository descriptor for the bundles created in this project.