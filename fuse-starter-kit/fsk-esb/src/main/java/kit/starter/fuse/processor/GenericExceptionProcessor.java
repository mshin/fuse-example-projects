package kit.starter.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericExceptionProcessor implements Processor {
	private static final String CLASS_NAME = GenericExceptionProcessor.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		String methodName = "process";
		LOGGER.error(CLASS_NAME + "." + methodName + " - Error during route transversal. ");
	}

}
