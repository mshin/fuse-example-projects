package kit.starter.fuse.backend_service_1_0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackendServiceImpl implements BackendService {
	private static final String CLASS_NAME = BackendServiceImpl.class.getName();
	private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);
	
	@Override
    public BackendServiceResponse hitBackendWS(BackendServiceRequest parameters) {
		final String methodName = "hitBackendWS";
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Enter");
		
		String value = parameters.getSelectedValue();
		
		BackendServiceResponse response = new BackendServiceResponse();
		
		if (value == null) {
			String message = "selectedValue from Camel was null!";
			
			response.setFromWS(message);
			
			LOGGER.info(CLASS_NAME + "." + methodName + " - Exit ... " + message);
			
			return response;
		}
		
		boolean isValueStandard = false;
		
		for (int i = 0; i < 10; i++) {
			if (value.equals(String.valueOf(i))) {
				response.setFromWS(getMapping(String.valueOf(i)));
				isValueStandard = true;
				break;
			}
		}
		
		if (!isValueStandard) response.setFromWS("selectedValue was not 0-9.");
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Exit");
		
		return response;
    }
	
	private String getMapping(String s) {
		
		String input = String.valueOf(s);
		String output = "";
		
		if (input.equals("0")) output = "zero";
		else if (input.equals("1")) output = "un";
		else if (input.equals("2")) output = "deux";
		else if (input.equals("3")) output = "trois";
		else if (input.equals("4")) output = "quatre";
		else if (input.equals("5")) output = "cinq";
		else if (input.equals("6")) output = "six";
		else if (input.equals("7")) output = "sept";
		else if (input.equals("8")) output = "huit";
		else if (input.equals("9")) output = "neuf";
		return output;
	}
}
