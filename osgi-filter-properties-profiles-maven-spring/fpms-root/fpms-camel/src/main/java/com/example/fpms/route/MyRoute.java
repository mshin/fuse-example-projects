package com.example.fpms.route;

import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ValueBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;

import com.example.fpms.processor.ProcessorBean;


public class MyRoute extends RouteBuilder {

	private static final String MY_SERVICE = "cxfrs:bean:myService";

	private ProcessorBean processorBean;

	public void setProcessorBean(ProcessorBean processorBean) {
		this.processorBean = processorBean;
	}

	@Override
	public void configure() throws Exception {
		ValueBuilder operationHeader = header(CxfConstants.OPERATION_NAME);

		Predicate getObject = operationHeader.isEqualTo("getObject");
		Predicate getValue = operationHeader.isEqualTo("getObjectValue");

		from(MY_SERVICE)
			.routeId("MyChoice Route")
			.choice()
				.when(getObject)
					.bean(processorBean, "getObject")
				.when(getValue)
					.bean(processorBean, "getObjectValue")
				.otherwise()
					.to("direct:other");

		from("direct:other")
			.id("CBR to Other")
			.setBody(constant("Unrecognized request: " + operationHeader.toString()));
	}

}
