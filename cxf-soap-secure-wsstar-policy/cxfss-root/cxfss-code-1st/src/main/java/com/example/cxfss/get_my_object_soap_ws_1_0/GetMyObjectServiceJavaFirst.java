package com.example.cxfss.get_my_object_soap_ws_1_0;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.cxf.annotations.Policies;
import org.apache.cxf.annotations.Policy;

@WebService(targetNamespace = "http://get_my_object_soap_ws_1_0.cxfss.example.com/", name = "GetMyObjectServiceJavaFirst")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@Policies({ @Policy(uri = "META-INF/policies/UsernameTokenPolicy.xml", placement = Policy.Placement.SERVICE, includeInWSDL=true) })
public interface GetMyObjectServiceJavaFirst {

	@WebResult(name = "MyObjectResponse", targetNamespace = "", partName = "MyObjectResponse")
	@WebMethod(action = "http://get_my_object_soap_ws_1_0.cxfss.example.com/getMyObject")
	public MyObjectJavaFirst getMyObject();

	@WebResult(name = "valueResponse", targetNamespace = "", partName = "valueResponse")
	@WebMethod(action = "http://get_my_object_soap_ws_1_0.cxfss.example.com/getMyObjectValue")
	public String getMyObjectValue(
		@WebParam(partName = "key", name = "key", targetNamespace = "")
		java.lang.String key
	);
}