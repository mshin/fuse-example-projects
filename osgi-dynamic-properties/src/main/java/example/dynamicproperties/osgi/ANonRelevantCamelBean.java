package example.dynamicproperties.osgi;

import org.apache.camel.CamelContext;

/**
 * Created with IntelliJ IDEA.
 * User: AMENTRA-R9HDKGT
 * Date: 10/14/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ANonRelevantCamelBean {
    private CamelContext camelContext;

    public void aMethod() {
        camelContext.getRoute("");
    }
}
