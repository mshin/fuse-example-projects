##########################################################################################
Working Example Project Demonstrating Maven Filter Properties, Maven profiles, and Spring Property Placeholders, Deployed on the Fuse Karaf OSGi Container
##########################################################################################
Written by MunChul Shin
Intended for use by Red Hat Consulting
Initial release 2015

This project is to demonstrate the use of Maven's property filtering capabilities with the maven-bundle-plugin. Spring property placeholders are used in conjunction with the Maven property filtering. 

Filtering properties is most often used when configuring a Maven project to be dynamically buildable based on the environment it is being deployed to. Such environments are usually local, dev, qa, int, and prod. When combining Maven property filtering with the maven-bundle-plugin, there is additional work that must be done to ensure all the filtered artifacts make it into the bundle. When maven filters the properties, the new properties are placed in the target directory. The maven-bundle-plugin must be explicitly told which artifacts to include in the bundle.

With Spring property filtering, the properties are not actually replaced in the Spring contexts. The actual values are read from the explicitly declared .properties files.

Files associated with maven property filtering:
fpms-root/fpms-camel/pom.xml
fpms-root/fpms-camel/src/main/filters/*
fpms-root/fpms-camel/src/main/resources/META-INF/properties/*

Files associated with Spring property placeholders:
fpms-root/fpms-camel/src/main/resources/META-INF/spring/*
fpms-root/fpms-camel/src/main/resources/META-INF/properties/*

######################
Notes and Instructions
######################

1. Build the project using Maven command:
mvn clean install

This will build the project with the "local" profile.

To build the project with one of profiles dev, qa, int, or prod, use one of the commands:
mvn clean install -P dev
mvn clean install -P qa
mvn clean install -P int
mvn clean install -P prod

* Built filtered resources will be placed in the target directory. Check these to make sure they have been filtered properly.

* If you wish to filter additional resources, they must be listed in the pom under filters, added to the bundle plugin "Include-Resource", and the actual file with the filter values added to src/main/filters/*. Under pom.xml build/resoruces, the locations that will be checked for filtering must be given. See the documentation for more details.

2. Deploy the code to the Karaf container.

3. Check the service at http://localhost:${port}/rest/url and http://localhost:${port}/rest/environment. Check localhost:8181/cxf to get the exact port number (it changes based on the profile used for filtering). You can just use a browser to do this. If you wish to check a different filtering, build with another profile and redeploy.

################################
Deploying to the Karaf Container
################################

1. Start the Fuse Karaf container and get into the Karaf command line. The console is by default on port 8101.

2. Issue commands:

features:addurl mvn:com.example.fpms/fpms-features/1.0/xml/features
(This will make the "Feature Repository" you defined in your features.xml file to visible to the Karaf server)

features:list | grep fpms
(This will display the new features you added to Karaf if the addurl was successful)

features:install fpms
(This will install the new features onto the server)

3. To uninstall, issue commands:
features:uninstall fpms fpms-commons
(Unlike installing where dependencies can be loaded on the fly, to uninstall, all installed features must be explicitly uninstalled)

features:removeurl mvn:com.example.fpms/fpms-features/1.0/xml/features
(This will make the features.xml no longer visible to Karaf. This step is only necessary if modifications have been made to the features.xml file in your project)

4. Check localhost:8181/cxf to make sure your webservices are available.


####################
Questions & Comments
####################

You can reach MunChul Shin at mshin@redhat.com
