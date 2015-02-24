package kit.starter.fuse.route;

import kit.starter.fuse.processor.*;

public class FuseStarterKitRouteBuilder extends org.apache.camel.builder.RouteBuilder {
    private String dataSourceBeanId;
    private String routeSourceEndpoint;

    public void setDataSourceBeanId(String dataSourceBeanId) {
        this.dataSourceBeanId = dataSourceBeanId;
    }
    
    public void setRouteSourceEndpoint(String routeSourceEndpoint) {
    	this.routeSourceEndpoint = routeSourceEndpoint;
    }

    @Override
    public void configure() throws Exception {

    //This will catch any uncaught Exceptions thrown by the route. Just comment in the processor and have it handle the exceptions.
    	onException (Exception.class)
//    		.process (new GenericExceptionProcessor())
            .continued (true);
    
    	from (routeSourceEndpoint)
            .id("fuseStartKitRouteId")
            .log("#1 Route log message cannot be the last statement in a route definition.")
            .process(new PutThingsInHeaderProcessor())
            .log("#2 Put things in header.")
    
//            .process(new LDAPPreProcessor())
//        .to("ldap:")
//        	.log("#3 read LDAP")
//            .process(new LDAPPostProcessor())
            
        	.process (new DBPreProcessor())       
        	.log("#4")
        .to("sql:select * from dbtable where id=# order by id?dataSourceRef=" + dataSourceBeanId)
            .log("#4 read DB")
            .process(new DBPostProcessor())
            
            .process(new WSPreProcessor())
        .to("cxf:bean:backendWebserviceClientEndpoint")
        	.log("#5 read WS")
            .process(new WSPostProcessor())
            
            .process(new ReturnMessageProcessor())
            ;
    }
}
