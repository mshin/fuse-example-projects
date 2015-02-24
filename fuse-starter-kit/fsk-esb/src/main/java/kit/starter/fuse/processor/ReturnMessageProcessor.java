package kit.starter.fuse.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ReturnMessageProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		exchange.getIn().setBody(exchange.getIn().getHeader("ecsResponse"));		
	}

}
