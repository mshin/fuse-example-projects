package kit.starter.fuse.processor;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBPreProcessor implements Processor {
	private static final String CLASS_NAME = DBPreProcessor.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		LOGGER.info("body: " + exchange.getIn().getBody());

		LOGGER.info("responseHeader: " + exchange.getIn().getHeader("ecsResponse"));
		LOGGER.info("source header: " + exchange.getIn().getHeader("ecsRequest"));
		LOGGER.info("selectedValueHeader: " + exchange.getIn().getHeader("selectedValue"));
		
		String selectedValue = exchange.getIn().getHeader("selectedValue", String.class);
		List<Object> queryParameters = new ArrayList<Object>();
		queryParameters.add(Integer.valueOf(selectedValue));
	    
		LOGGER.info("headers: " + exchange.getIn().getHeaders());
		
	    exchange.getIn().setBody(queryParameters);
	}
}
