package kit.starter.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LDAPPostProcessor implements Processor {
	private static final String CLASS_NAME = LDAPPostProcessor.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		LOGGER.info("in " + CLASS_NAME);
	}
}
