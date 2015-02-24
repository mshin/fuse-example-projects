package kit.starter.fuse.controller;

import java.util.Map;

import kit.starter.fuse.bean.OsgiDynamicPropertiesBean;
import kit.starter.fuse.service.WSService;
import kit.starter.fuse.viewobject.ViewObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ExampleController {

	private static final String JSP_LOCATION = "example";
	private static final String CLASS_NAME = ExampleController.class.getName();
    private static final Logger LOGGER = LoggerFactory.getLogger(CLASS_NAME);

	@Autowired
	WSService wsService;
	
	@Autowired
	@Qualifier("osgiDynamicPropertiesBeanId")
	OsgiDynamicPropertiesBean osgiDynamicPropertiesBean;
	
	@RequestMapping(value = "/example", method = RequestMethod.GET)
	public String getPage(Model model) {
		
		final String methodName = "getPage";
		LOGGER.info(CLASS_NAME + "." + methodName + " - Enter");
		
		Map<String, String> map = osgiDynamicPropertiesBean.getDynamicPropertiesMap();
		LOGGER.info(map.toString());
		
		//These are two metadata values that find their way into the dynamic properties map.
		//We don't want these values showing up in the UI.
		map.remove("felix.fileinstall.filename");
		map.remove("service.pid");
		
		ViewObject viewObject = new ViewObject();
		viewObject.setDynamicSelectMap(map);
		
		model.addAttribute("viewObject", viewObject);
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Exit");
		
		return JSP_LOCATION;
	}
	
	@RequestMapping(value = "/example", method = RequestMethod.POST, params = "submitForm")
	public String submit(@ModelAttribute("viewObject") ViewObject viewObject, Model model) {
		
		final String methodName = "submit";
		LOGGER.info(CLASS_NAME + "." + methodName + " - Enter");
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - submitted value: " + viewObject.getSelectedValue());
		
		viewObject = wsService.submitRequest(viewObject);
		model.addAttribute("viewObject", viewObject);
		
		LOGGER.info(CLASS_NAME + "." + methodName + " - Exit");
		
		return JSP_LOCATION;
	}
}
