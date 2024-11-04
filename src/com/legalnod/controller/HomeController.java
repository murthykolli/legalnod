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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.service.HomeService;


/**
 * @author MurthyK
 *
 */

@Controller
public class HomeController {	

	@Autowired
	private HomeService homeService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
//	Home Page Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/legalNodHome")
	@ResponseBody
	public ModelAndView legalNodHome(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("legalNodHome ...Controller");
		return homeService.legalNodHome(req, sn);
	}

}
