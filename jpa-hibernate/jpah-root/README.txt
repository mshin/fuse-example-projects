##########################################################################################
Working Example Project Demonstrating Use of JPA/Hibernate Deployed on the Fuse Karaf OSGi Container
##########################################################################################
Written by MunChul Shin
Intended for use by Red Hat Consulting
Initial release 2015

This project is to demonstrate the use of Hibernate with Camel/CXF deployed on Fuse. The Camel Hibernate and JPA components do not perform CRUD actions. The JPA Camel component (which has a host of issues associated with OpenJPA) can't read from the database. Unless one wants to use the JDBC Camel component, there are currently no better options for Camel if one wants to do CRUD actions with a database.

This application uses standard OSGi JPA implemented with Hibernate. Camel/CXF is used to create a REST interface with which a user can call the JPA classes to interact with the database. Spring is used to configure Camel and Hibernate. This project uses a combination of Autowiring (with Spring and JPA annotations) and Spring explicit wiring. 

The database used by default is Postgres, but a datasource stub for Mysql is provided as well. This application of course can work with any database; the developer will just have to do a little bit more work to configure a datasource for that other type of database.

If a persistence unit in persistence.xml other than the default postgres one is used, make sure to change @PersistenceContext(unitName="hibernate_with_postgres") in JPABaseDao to the new persistence unit.

The sql.ddl files for postgres and mysql are there just as a suggestion to get the user started if they want to explicitly create the database tables. By default, the application is configured to have Hibernate auto-generate the database tables.


######################
Notes and Instructions
######################

* Must use special Hibernate-core jar
There is a bug with Hibernate-core where it can't see the Entity classes as a bundle because it doesn't list them as a dependency. If the jar was not already packaged as a bundle, one could use the BND wrap: command to tell the bundle to dynamically import dependencies. Because it's already packaged as a bundle, we have to manually modify the manifest of the artifact.

Instructions:

1. Copy hibernate-core jar to a folder to work on it. 
Also make a backup in case you mess up.
org.hibernate/hibernate-core/4.3.6.Final

2. Extract the archive.

3. Copy META-INF/MANIFEST.MF (with folder) to . (the current directory).

4. Edit MANIFEST.MF by including osgi header on its own line:
DynamicImport-Package: *

5. Use jar command to edit the hibernate-core jar's manifest with the new one.
jar ufm hibernate-core-4.3.6.Final.jar META-INF/MANIFEST.MF
(jar -u update -f file -m update_manifest)

6. Re-extract that jar to check to make sure the manifest got updated.

7. Replace the jar org.hibernate/hibernate-core/4.3.6.Final in your local maven repository with the new one.
You might want to consider creating a custom location for the jar at something like: org.hibernate/hibernate-core/4.3.6.Final.Edited and changing your project's pom accordingly. Doing so will ensure the jar isn't erased accidentally by a Maven forced update (-U).

* Tested on Fuse 6.1. To update the version, just change the bom version in the parent pom.

* Project uses separate Hibernate bundles not found on server to facilitate using a custom Hibernate-core jar.

* Only Crud + readAll implemented by Camel REST CXF endpoints. More functions are implemented by the DAO implementation, you just need to hook REST up to them.

* To see list of available cxf webservices on fuse: http://localhost:8181/cxf

* For Hawtio Management console: http://localhost:8181

* The way this currently works, if a user tries to update and does not include the "id" field, a new record will be created.

* Suggest using Google Advanced Rest Client to test routes.

* Sample rest json payloads:

http://localhost:9001/rest/create
POST
application/json
{
	"username":"user",
	"password":"123456",
	"email":"a@b.com",
	"phoneNumber":"555-555-5555",
	"challengeQ1":"who",
	"challengeAns1":"you",
	"active":"true",
	"verified":"false",
	"foo":"bar"
}


http://localhost:9001/rest/read
GET


http://localhost:9001/rest/read/1
GET
(Use whatever id in the url you want to get that record.)


http://localhost:9001/rest/update
PUT
application/json
{
	"id":"1",
	"username":"user",
	"password":"123456betterP@ssword",
	"email":"changed@b.com",
	"phoneNumber":"555-555-5555",
	"challengeQ1":"WHAT CHANGED?",
	"challengeAns1":"I AM DIFFERENT.",
	"active":"true",
	"verified":"false",
	"foo":"baryon"
}


http://localhost:9001/rest/delete/1
DELETE



################################
Deploying to the Karaf Container
################################

1. Build the project using maven command:
mvn clean install
This must be done prior to creating the custom hibernate-core jar.
2. Start the Fuse Karaf container and get into the Karaf command line. The console is by default on port 8101.
3. Issue commands:

features:addurl mvn:com.example.jpah/jpah-features/__PROJECT_VERSION__/xml/features
(This will make the "Feature Repository" you defined in your features.xml file to visible to the Karaf server)

features:list | grep jpah
(This will display the new features you added to Karaf if the addurl was successful)

features:install jpah
(This will install the new features onto the server)

4. To uninstall, issue commands:
features:uninstall jpah jpah-commons
(Unlike installing where dependencies can be loaded on the fly, to uninstall, all installed features must be explicitly uninstalled)

features:removeurl mvn:com.example.jpah/jpah-features/__PROJECT_VERSION__/xml/features
(This will make the features.xml no longer visible to Karaf. This step is only necessary if modifications have been made to the features.xml file in your project)

5. Check localhost:8181/cxf to make sure your rest webservice is available.


####################
Questions & Comments
####################

You can reach MunChul Shin at mshin@redhat.com
