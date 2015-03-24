package com.example.cxfss.get_my_object_soap_ws_1_0;

public class GetMyObjectServiceJavaFirstImpl implements GetMyObjectServiceJavaFirst {
	
	@Override
	public MyObjectJavaFirst getMyObject() {
		
		MyObjectJavaFirst myObject = new MyObjectJavaFirst();
		myObject.getMap().put("key1", "value1");
		
		return myObject;
	}

	@Override
	public String getMyObjectValue(String key) {
		return "a key";
	}
}