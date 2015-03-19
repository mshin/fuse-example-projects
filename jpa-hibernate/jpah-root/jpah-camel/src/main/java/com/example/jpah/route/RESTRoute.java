package com.example.jpah.route;

import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.builder.ValueBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;

import com.example.jpah.processors.ProcessorBean;

public class RESTRoute extends RouteBuilder{

	private static final String REST_SERVICE_1 = "cxfrs:bean:rsService1";
	
	private ProcessorBean processorBean;
    
    public void setProcessorBean(ProcessorBean processorBean) {
    	this.processorBean = processorBean;
    }
	
	@Override
	public void configure() throws Exception {
		ValueBuilder operationHeader = header(CxfConstants.OPERATION_NAME);

		Predicate headerIsCreate = operationHeader.isEqualTo("create");
		Predicate headerIsRead = operationHeader.isEqualTo("read");
		Predicate headerIsUpdate = operationHeader.isEqualTo("update");
		Predicate headerIsDelete = operationHeader.isEqualTo("delete");
		Predicate headerIsReadAll = operationHeader.isEqualTo("readAll");
		
		from(REST_SERVICE_1)
			.id("CBR Route")
			.choice()
				.when(headerIsCreate)
					.bean(processorBean, "create")
				.when(headerIsRead)
					.bean(processorBean, "read")
				.when(headerIsUpdate)
					.bean(processorBean, "update")
				.when(headerIsDelete)
					.bean(processorBean, "delete")
				.when(headerIsReadAll)
					.bean(processorBean, "readAll")
				.otherwise()
					.to("direct:other");
		
		from("direct:other")
		.id("CBR to Other")
		.setBody(constant("Unrecognized request: " + operationHeader.toString()));
	}

}