package kit.starter.fuse.viewobject;

import java.util.Map;

public class ViewObject {
	private Map<String, String> dynamicSelectMap;
	private String selectedValue;
	private String yourValue;
	private String fromLDAP;
	private String fromDB;
	private String fromWS;
	
	public Map<String, String> getDynamicSelectMap() {
		return dynamicSelectMap;
	}
	public void setDynamicSelectMap(Map<String, String> dynamicSelectMap) {
		this.dynamicSelectMap = dynamicSelectMap;
	}
	public String getSelectedValue() {
		return selectedValue;
	}
	public void setSelectedValue(String selectedValue) {
		this.selectedValue = selectedValue;
	}
	public String getYourValue() {
		return yourValue;
	}
	public void setYourValue(String yourValue) {
		this.yourValue = yourValue;
	}
	public String getFromLDAP() {
		return fromLDAP;
	}
	public void setFromLDAP(String fromLDAP) {
		this.fromLDAP = fromLDAP;
	}
	public String getFromDB() {
		return fromDB;
	}
	public void setFromDB(String fromDB) {
		this.fromDB = fromDB;
	}
	public String getFromWS() {
		return fromWS;
	}
	public void setFromWS(String fromWS) {
		this.fromWS = fromWS;
	}	
	
}
