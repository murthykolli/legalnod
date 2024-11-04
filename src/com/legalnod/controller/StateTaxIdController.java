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

import com.legalnod.service.StateTaxIdService;

/**
 * @author MurthyK
 *
 */

@Controller
public class StateTaxIdController {
	
	@Autowired
	private StateTaxIdService stateTaxIdService;	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StateTaxIdController.class);
	
//	State Tax ID Form modification Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/stateTaxIdFormModification")
	@ResponseBody
	public ModelAndView stateTaxIdFormModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("stateTaxIdFormModification ...Controller");
		return stateTaxIdService.stateTaxIdFormDataSavingAndUpdatingInDB(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonStateTaxFirstChoice")
	@ResponseBody
	public JSONArray jSonStateTaxFirstChoice(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonStateTaxFirstChoice ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stateTaxIdService.jSonStateTaxFirstChoiceChecking(userChoice, sn);
		
	}
	
//	State Tax ID Forms Check out Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/stateTaxIdCheckoutDataModification")
	@ResponseBody
	public ModelAndView stateTaxIdCheckoutDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("stateTaxIdCheckoutDataModification ...Controller");
		return stateTaxIdService.stateTaxIdCheckoutDataRedirection(req, sn);
	}
	
//	Checkout Json calling for modified values Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonSTIModifiedValuesUpdate")
	@ResponseBody
	public JSONArray jSonSTIModifiedValuesUpdate(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonSTIModifiedValuesUpdate ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stateTaxIdService.jSonSTICheckoutDataUpdationInDB(userChoice, sn);
		
	}

}
