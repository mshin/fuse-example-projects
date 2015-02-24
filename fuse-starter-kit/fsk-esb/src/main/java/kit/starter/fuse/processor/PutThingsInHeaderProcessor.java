package kit.starter.fuse.processor;

import kit.starter.fuse.exposed_camel_service_1_0.*;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class PutThingsInHeaderProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		ExposedCamelServiceRequest request = exchange.getIn().getBody(ExposedCamelServiceRequest.class);
		
		String selectedValue = request.getSelectedValue();
		
		ExposedCamelServiceResponse response = new ExposedCamelServiceResponse();		
		
		response.setYourValue(selectedValue);
		
		exchange.getIn().setHeader("ecsResponse", response);
		exchange.getIn().setHeader("ecsRequest", request);
		exchange.getIn().setHeader("selectedValue", selectedValue);
		
	}

}
