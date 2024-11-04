package com.legalnod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.service.AdditionalService;


/**
 * @author MurthyK
 *
 */

@Controller
public class AdditionalServiceController {
	
	@Autowired
	private AdditionalService additionalService;	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdditionalServiceController.class);
	
//	Additional Service Form modification Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/additionalSerFormModification")
	@ResponseBody
	public ModelAndView additionalSerFormModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("additionalSerFormModification...Controller");
		return additionalService.additionalServiceFormDataSavingAndUpdatingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonAdditionalServiceFirstChoice")
	@ResponseBody
	public JSONArray jSonAdditionalServiceFirstChoice(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonAdditionalServiceFirstChoice...Controller");
		LOGGER.info("UserChoice Value: "+userChoice);
		return additionalService.jSonAdditionalServiceFirstChoiceChecking(userChoice, sn);
		
	}
	
//	Additional Service Forms Check out Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/additionalServiceCheckoutDataModification")
	@ResponseBody
	public ModelAndView additionalServiceCheckoutDataModification(HttpServletRequest req, HttpSession sn) {	
		LOGGER.debug("additionalServiceCheckoutDataModification...Controller");
		return additionalService.additionalServiceCheckoutDataRedirection(req, sn);
	}
	
//	Checkout Json calling for modified values Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonASModifiedValuesUpdate")
	@ResponseBody
	public JSONArray jSonASModifiedValuesUpdate(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonASModifiedValuesUpdate...Controller");
		LOGGER.info("UserChoice Value: "+userChoice);
		return additionalService.jSonASCheckoutDataUpdationInDB(userChoice, sn);
		
	}

}
