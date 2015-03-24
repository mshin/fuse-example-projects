##########################################################################################
Working Example Project Demonstrating CXF SOAP Web Service Secured by WS* Policy Deployed on the Fuse Karaf OSGi Container
##########################################################################################
Written by MunChul Shin
Intended for use by Red Hat Consulting
Initial release 2015

This project is to demonstrate the use of CXF SOAP web services secured by ws* policies. The implementation is demonstrated in entirety using both the WSDL first and code first approaches. Sample SOAP payloads are included.

There are many ways to implement security on CXF web services. Using ws* policy to implement security is one of the more difficult ways to implement security for a WSDL based web service, but it provides the most interoperability with other SOAP implementations. Namely, it should allow secure CXF web services to work with .NET WCF web services.

WSDL first vs code first
Both writing SOAP web services WSDL first and code first are common. It is usually a matter of preference which method is used. WSDL first can be used for any SOAP implementation but is genrally more time consuming and error prone; Code first is usually faster but requires different code depending on the web service implementation and software language used.

######################
Notes and Instructions
######################

1. Build the project using Maven command:
mvn clean install

* By default, the built wsdl for the cxfss-code-1st module will be placed in the target directory. It should be manually copied over to:
src/main/resources/java_first_wsdl/GetMyObjectServiceJavaFirst.wsdl.
This will have to be done if changes are made to the webservice. 
In other words, if changes are made to the webservice definition, build the project, copy the wsdl over, then build the project again.

2. Deploy the code to the Karaf container.

3. Use SOAP UI (or another SOAP testing application) to test the service.
Sample xml payloads for SOAP UI are provided in the example project.

* The example uses a very basic version of WS* Policy. To use more complex security, please read the documentation on WS* Policy. Some stub code is provided in cxfss-wsdl-1st/src/main/resources/wsdl/GetMyObjectService.wsdl to get you started.

* To change the accepted username/password for the service, change the code in PasswordCallbackHandler.java.

################################
Deploying to the Karaf Container
################################

1. Start the Fuse Karaf container and get into the Karaf command line. The console is by default on port 8101.

2. Issue commands:

features:addurl mvn:com.example.cxfss/cxfss-features/1.0/xml/features
(This will make the "Feature Repository" you defined in your features.xml file to visible to the Karaf server)

features:list | grep cxfss
(This will display the new features you added to Karaf if the addurl was successful)

features:install cxfss
(This will install the new features onto the server)

3. To uninstall, issue commands:
features:uninstall cxfss cxfss-commons
(Unlike installing where dependencies can be loaded on the fly, to uninstall, all installed features must be explicitly uninstalled)

features:removeurl mvn:com.example.cxfss/cxfss-features/1.0/xml/features
(This will make the features.xml no longer visible to Karaf. This step is only necessary if modifications have been made to the features.xml file in your project)

4. Check localhost:8181/cxf to make sure your webservices are available.


####################
Questions & Comments
####################

You can reach MunChul Shin at mshin@redhat.com
