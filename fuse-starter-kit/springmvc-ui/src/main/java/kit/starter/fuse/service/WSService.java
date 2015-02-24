package kit.starter.fuse.service;

import kit.starter.fuse.exposed_camel_service_1_0.*;
import kit.starter.fuse.viewobject.ViewObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WSService {
	private static final String CLASS_NAME = WSService.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	@Autowired
	@Qualifier("exposedCamelWebserviceClient")
	ExposedCamelService exposedCamelService;
	
//	@Autowired
//	@Qualifier("backendWebserviceClientEndpoint")
//	kit.starter.fuse.backend_service_1_0.BackendService backendService;
	
	public ViewObject submitRequest(ViewObject vo) {
		final String methodName = "submitRequest";
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Enter");
		
		if (vo == null) {
			LOGGER.info(CLASS_NAME + "." + methodName + " - Somehow arg vo is null. Exit");
			return vo;
		}
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - selected value is: " +vo.getSelectedValue());
		
		ExposedCamelServiceRequest request = new ExposedCamelServiceRequest();
		request.setSelectedValue(vo.getSelectedValue());
		
//		LOGGER.info(CLASS_NAME + "." + methodName + " - Before calling webservice0");
//		
//		kit.starter.fuse.backend_service_1_0.BackendServiceRequest request0 = 
//				new kit.starter.fuse.backend_service_1_0.BackendServiceRequest();
//		request0.setSelectedValue(vo.getSelectedValue());
//		kit.starter.fuse.backend_service_1_0.BackendServiceResponse response0 = 
//				backendService.hitBackendWS(request0);
//		LOGGER.info(CLASS_NAME + "." + methodName + " - Response0: " + response0.getFromWS());
//		
//		LOGGER.info(CLASS_NAME + "." + methodName + " - After calling webservice0");
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Before calling webservice");
		
		ExposedCamelServiceResponse response = exposedCamelService.hitRoutes(request);
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - After calling webservice");
		
		vo.setYourValue(response.getYourValue());
		vo.setFromLDAP(response.getFromLDAP());
		vo.setFromDB(response.getFromDB());
		vo.setFromWS(response.getFromWS());
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Exit");
		
		return vo;
	}
}
