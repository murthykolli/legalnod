/**
 * 
 */
package com.legalnod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.service.ServiceByStateService;



/**
 * @author MurthyK
 *
 */

@Controller
public class ServiceByStateController {
	
	@Autowired
	private ServiceByStateService sbsService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceByStateController.class);
	
//	Home Page Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/servicesByState")
	public ModelAndView servicesByState(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("servicesByState ...Controller");
		return sbsService.serviceByStateHome(req, sn);
	}

}
