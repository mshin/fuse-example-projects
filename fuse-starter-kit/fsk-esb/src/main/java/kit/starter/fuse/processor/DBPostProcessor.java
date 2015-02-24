package kit.starter.fuse.processor;

import java.util.List;
import java.util.Map;

import kit.starter.fuse.exposed_camel_service_1_0.ExposedCamelServiceResponse;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBPostProcessor implements Processor {
	private static final String CLASS_NAME = DBPostProcessor.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	@Override
	public void process(Exchange exchange) throws Exception {
		
		//If returning rows, return is a List<Map<String, Object>> 
		//where each list entry is a row, each map entry is key=column value=value.
		//If updating, then returns Integer number of updated rows. 
		
		LOGGER.info("db endpoint result: " + exchange.getIn().getBody());
		
		LOGGER.info("headers: " + exchange.getIn().getHeaders());
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> list = exchange.getIn().getBody(List.class);

		LOGGER.info("listSize: " + list.size() + " mapSize: " + list.get(0).size());
		
		String value = (String) list.get(0).get("NUMBER");
		
		LOGGER.info("value: " + value);
		
		ExposedCamelServiceResponse camelResponse = exchange.getIn().getHeader("ecsResponse", ExposedCamelServiceResponse.class);
		camelResponse.setFromDB(value);

	}
}
