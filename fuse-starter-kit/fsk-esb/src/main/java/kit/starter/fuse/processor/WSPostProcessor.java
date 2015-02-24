package kit.starter.fuse.processor;

import kit.starter.fuse.backend_service_1_0.BackendServiceResponse;
import kit.starter.fuse.exposed_camel_service_1_0.ExposedCamelServiceResponse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WSPostProcessor implements Processor {
	private static final String CLASS_NAME = WSPostProcessor.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		LOGGER.info("Body: " + exchange.getIn().getBody());
		BackendServiceResponse backendResponse = exchange.getIn().getBody(BackendServiceResponse.class);
		
		String value = backendResponse.getFromWS();
		LOGGER.info("value: " + value);
		
		ExposedCamelServiceResponse camelResponse = exchange.getIn().getHeader("ecsResponse", ExposedCamelServiceResponse.class);
		camelResponse.setFromWS(value);
	}
}
