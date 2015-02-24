/*
package kit.starter.fuse.exposed_camel_service_1_0;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.ProducerTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// -- !!IMPORTANT!! --
//If you are implementing this, make sure your route correctly handles marshalling
//and unmarshalling. template.requestBody(String sourceEndpoint, Object body) 
//should make the route message body the "Object body" argument, which would not 
//need to be unmarshalled. This implementation expects the route to return the
//Object representation of the SOAP message, not the marshalled (XML) message.
public class ExposedCamelServiceImpl implements ExposedCamelService{

	private static final String CLASS_NAME = ExposedCamelServiceImpl.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	private CamelContext camelContext;
	private String routeSourceEndpoint;
	
	@Override
	public ExposedCamelServiceResponse hitRoutes(ExposedCamelServiceRequest parameters) {
		final String methodName = "hitRoutes";
		LOGGER.info(CLASS_NAME + "." + methodName + " - Enter");
		
		ExposedCamelServiceResponse response = null;
		
		ProducerTemplate template = camelContext.createProducerTemplate();

		Object result = null;
		try {
			
			result = template.requestBody(routeSourceEndpoint, parameters);
			
		} catch (CamelExecutionException e) {
			// Update response with Error message
			LOGGER.error(CLASS_NAME + "." + methodName + " - Error during route transversal." + e);
			
			//Your WS should explicitly handle errors instead of putting error messages into a random field.
			response = new ExposedCamelServiceResponse();
			response.setYourValue(e.getMessage());
			
			LOGGER.info(CLASS_NAME + "." + methodName + " - Exit");
			return response;
		}
		
		if (result instanceof ExposedCamelServiceResponse) {
			response = (ExposedCamelServiceResponse) result;
		}			
		else {
			response = new ExposedCamelServiceResponse();
			String message = "";			
			LOGGER.error(CLASS_NAME + "." + methodName + " - " + message);
			response.setYourValue(message);
		}
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Exit");
		return response;
	}

	public CamelContext getCamelContext() {
		return camelContext;
	}

	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}

	public String getRouteSourceEndpoint() {
		return routeSourceEndpoint;
	}

	public void setRouteSourceEndpoint(String routeSourceEndpoint) {
		this.routeSourceEndpoint = routeSourceEndpoint;
	}
	
}
*/