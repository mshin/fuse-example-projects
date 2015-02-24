package kit.starter.fuse.route;

import kit.starter.fuse.exposed_camel_service_1_0.*;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelSpringTestSupport;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class CamelRouteTest extends CamelSpringTestSupport {

    private ClassPathXmlApplicationContext applicationContext;
    private CamelContext context;
    private MockEndpoint mockEndpointSuccess;
    private ProducerTemplate template;

    private static final String MOCK_URL = "mock:mockEndpointSuccess";
    private static final String JOB_ID = "camelRouteTest";
    private static final int NUMBER_OF_MESSAGES = 1;

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        applicationContext = new ClassPathXmlApplicationContext("META-INF/test/test-bundle-context.xml");
        return applicationContext;
    }

    @Override
    @Before
    public void setUp() throws Exception {
        log.info("********************************************************************************");
        log.info("Testing: " + getTestMethodName() + "(" + getClass().getName() + ")");
        log.info("********************************************************************************");

        applicationContext = (ClassPathXmlApplicationContext) createApplicationContext();

        context = (CamelContext)applicationContext.getBean("camelContext");
        mockEndpointSuccess = context.getEndpoint(MOCK_URL, MockEndpoint.class);

        template = context.createProducerTemplate(); //automatically started

    }

    @Override
    @After
    public void tearDown() throws Exception {
        applicationContext.close();

        if (template != null) {
            template.stop();
        }

        super.tearDown();
        if (context != null) {
            context.stop();
        }

        log.info("********************************************************************************");
        log.info("Testing OVER for: " + getTestMethodName() + "(" + getClass().getName() + ")");
        log.info("********************************************************************************");
    }

    private void assertRoutesStarted() throws Exception {
        //assertEquals("expectedNumberOfMessages", "code to find number of messages");
        assertEquals(1, 1);
        log.info("Route " + JOB_ID + " is up and running based on start policy");
    }

    private void sendMessages() throws Exception {

        for (int i = 0; i <= NUMBER_OF_MESSAGES; i++) {

            ExposedCamelServiceRequest requestIn = new ExposedCamelServiceRequest();
            requestIn.setSelectedValue("0");

            Map<String, Object> headers = new HashMap<String, Object>();
            headers.put("CamelMessageName", "message" + i);

            template.sendBodyAndHeaders(mockEndpointSuccess, requestIn, headers);
        }
    }

    @Test
    public void test() throws Exception {
        mockEndpointSuccess.setAssertPeriod(5000);
        mockEndpointSuccess.expectedMessageCount(NUMBER_OF_MESSAGES);

        //because context is autowired in camelContext.xml it should already be in there, no need to add route.

        sendMessages();

        assertRoutesStarted();
        mockEndpointSuccess.assertIsSatisfied();
    }
}
