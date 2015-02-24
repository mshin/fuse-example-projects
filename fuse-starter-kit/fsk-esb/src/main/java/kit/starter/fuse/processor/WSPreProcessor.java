package kit.starter.fuse.processor;

import kit.starter.fuse.backend_service_1_0.*;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WSPreProcessor implements Processor {
	private static final String CLASS_NAME = WSPreProcessor.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	@Override
	public void process(Exchange exchange) throws Exception {		
		
		exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "hitBackendWS");
		exchange.getIn().setHeader(CxfConstants.OPERATION_NAMESPACE, "http://backend_service_1_0.fuse.starter.kit/");
		
		String selectedValue = exchange.getIn().getHeader("selectedValue", String.class);
		
		BackendServiceRequest backendWSRequest = new BackendServiceRequest();
		backendWSRequest.setSelectedValue(selectedValue);

		LOGGER.info("headers: " + exchange.getIn().getHeaders());
				
		//this works
//	    exchange.getIn().setBody(new Object[]{backendWSRequest});
		
		//and this works
//		java.util.List<Object> list = new java.util.ArrayList<Object>();		
//		list.add(backendWSRequest);
//	    exchange.getIn().setBody(list);
		
	    //and so does this
	    exchange.getIn().setBody(backendWSRequest);
	}
}
