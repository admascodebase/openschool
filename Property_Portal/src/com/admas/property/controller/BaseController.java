
package com.admas.property.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.admas.property.constant.WebAppConstants;
import com.admas.property.dto.FlowData;

/**
 * The Class BaseController.
 */

@Controller
public class BaseController extends AbstractController {

	/** The logger. */
	Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	/*@Autowired
	@Qualifier("userManagementServiceImpl")
	private IUserManagementService userManagementServiceImpl;*/


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();

		/*if (session.getAttribute(WebAppConstants.FLOWDATA) != null) {
			FlowData flowData = (FlowData) session
					.getAttribute(WebAppConstants.FLOWDATA);
			if ("false".equals(flowData.getSessionData("ISLOGEDIN"))
					|| flowData.getSessionData("ISLOGEDIN") == null) {

				flowData.setSessionData("ISLOGEDIN", "false");
			}
			session.setAttribute(WebAppConstants.FLOWDATA, flowData);
		} else {
			FlowData flowData = new FlowData();

			try {
				session.setMaxInactiveInterval(50 * 60);
				session.setAttribute(WebAppConstants.FLOWDATA, flowData);
				flowData.setSessionData("ISLOGEDIN", "false");
			} catch (Exception e) {
				logger.error("Got error while setting count ", e);
			}

		}
*/		return null;
	}

	/**
	 * Gets the nsi.
	 * @return the nsi
	 */

	public ModelAndView loginPage(FlowData flowData, HttpServletRequest request) {
		Map<String, Object> reqDtoObjects = new HashMap<String, Object>();
		Map<String, Object> resDtoObjects = new HashMap<String, Object>();
		logger.info("started loginPage method ");
		ModelAndView modelRoot = null;
		try {			
			String viewName = "";

			/*resDtoObjects = userManagementServiceImpl.login(flowData,
					reqDtoObjects, resDtoObjects);*/
			viewName = (String) resDtoObjects.get(WebAppConstants.VIEW_NAME);
			modelRoot = new ModelAndView(viewName);
			modelRoot.addAllObjects(resDtoObjects);
			request.getSession().setAttribute(WebAppConstants.FLOWDATA, null);
			return modelRoot;
		} catch (Exception ex) {
			logger.error("Exception in loginPage()", ex);
			modelRoot = new ModelAndView(
					(String) resDtoObjects.get(WebAppConstants.VIEW_NAME));

			return modelRoot;
		}
	}


	
	private void printHeader(HttpServletRequest request) {
		String headers = null;
		Enumeration e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			headers = (String) e.nextElement();
			if (headers != null) {
				logger.debug(headers + ":");
				logger.debug(request.getHeader(headers));
			}
		}
	}
	
	/**
	 * @return generated token
	 */
	public static String nextToken() {
		long seed = System.currentTimeMillis();
		Random r = new Random();
		r.setSeed(seed);
		String token = Long.toString(seed)
				+ Long.toString(Math.abs(r.nextLong()));
		// logger.debug(BaseController.class.getName() + ".nextToken :" +
		// token);
		return token;
	}	

}