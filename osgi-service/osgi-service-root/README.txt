The purpose of this example project is to show how to use OSGi services in Karaf using blueprint, Spring, and programmatically. It is assumed that bundles will always be created using Maven and the maven-bundle-plugin.

osgi-service-blueprint
Expose an OSGi service to be used by other bundles using blueprint.

osgi-service-activator
Expose an OSGi service to be used by other bundles using the low level Java API.

osgi-service-spring
Expose an OSGi service to be used by other bundles using Spring and the spring-osgi-service-adapter library.

osgi-service-use-blueprint
Consume the OSGi services exposed by our other bundles. Uses blueprint to get a reference to the services and wire it up with our bean that uses the services.

osgi-service-use-activator
Consume the OSGi services exposed by our other bundles. 
Uses the low level Java API in the Activator bean to get a reference to the services and use them.
Uses the low level API in an Activator to get references to the services. These references are tracked using a ServiceTracker. Ideally, the references to the services should be shared with the beans that need them.

osgi-service-use-spring
Consume the OSGi services exposed by our other bundles. Uses Spring to get a reference to the services and wire it up with our bean that uses the services.
Uses the spring-osgi-service-adapter library to prevent needing to write OSGi code in our java classes.

osgi-service-features
Builds the features.xml feature repository descriptor for the bundles created in this project.


Please read console_commands.txt for instructions on how to build and install this example project.


When the bundles are successfully deployed, some messages (System.out.println) should be printed to the console showing the OSGi services being used by the use-service bundles.


Deployed on Red Hat Fuse 6.3.


For questions, comments and requests you can contact MunChul Shin at mshin@redhat.com.



2016 October
