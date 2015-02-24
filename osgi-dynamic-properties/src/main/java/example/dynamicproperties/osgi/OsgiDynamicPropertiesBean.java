package example.dynamicproperties.osgi;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OsgiDynamicPropertiesBean {
    private static final long serialVersionUID = 1L;
    private static final transient Logger LOG = LoggerFactory.getLogger(OsgiDynamicPropertiesBean.class);

    // don't need to instantiate here because a default map should have been created in applicationContext.
    private ConcurrentHashMap<String, String> dynamicPropertiesMap = new ConcurrentHashMap<String, String>();

    
    // Properties callback method that receives updates from the Config Admin Service when properties change
    public void updateCallback(Map<String, String> properties) {
        LOG.info("Property change request received with Dictionary values: {}", properties);
        dynamicPropertiesMap.putAll(properties);  
    }

    public Map<String, String> getDynamicPropertiesMap() {
        return dynamicPropertiesMap;
    }

    public void setDynamicPropertiesMap(
            ConcurrentHashMap<String, String> dynamicPropertiesMap) {
        this.dynamicPropertiesMap = dynamicPropertiesMap;
    }

}
