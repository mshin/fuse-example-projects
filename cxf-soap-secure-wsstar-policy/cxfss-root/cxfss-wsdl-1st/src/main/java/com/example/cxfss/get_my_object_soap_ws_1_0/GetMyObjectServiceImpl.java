package com.example.cxfss.get_my_object_soap_ws_1_0;

public class GetMyObjectServiceImpl implements GetMyObjectService {

	MyObject myObject = new MyObject();

	@Override
	public MyObject getMyObject() {

		MyObject.Map map = new MyObject.Map();

		MyObject.Map.Entry entry = new MyObject.Map.Entry();
		entry.setKey("key1");
		entry.setValue("value1");

		map.getEntry().add(entry);
		myObject.setMap(map);

		return myObject;
	}

	@Override
	public String getMyObjectValue(String key) {

		return getMyObjectValueImpl(key);

	}

	private String getMyObjectValueImpl(String key) {
		java.util.List<MyObject.Map.Entry> list = myObject.getMap().getEntry();

		return "value from key: " + key;
	}

}