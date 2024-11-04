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

import com.legalnod.service.FederalFormsService;
import com.legalnod.service.FederalFormsUpdateService;

/**
 * @author MurthyK
 *
 */

@Controller
public class FederalFormsController {
	
	@Autowired
	private FederalFormsService federalFormsService;
	
	@Autowired
	private FederalFormsUpdateService federalFormsUpdateService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FederalFormsController.class);
	
//	Federal Form Creation Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/federalTaxIDNumberBusSer")
	@ResponseBody
	public ModelAndView federalTaxIDNumberBusSer(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("federalTaxIDNumberBusSer ...Controller");
		return federalFormsUpdateService.federalTaxIDFormUpdation(req, sn);
	}
	
//	Federal Form Creation Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/sCorpFormCreation")
	@ResponseBody
	public ModelAndView sCorpFormCreation(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("sCorpFormCreation ...Controller");
		return federalFormsUpdateService.sCorporationFormUpdation(req, sn);
	}
	
//	501 Form Creation Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/applyFiveZeroOneAppBusSer")
	@ResponseBody
	public ModelAndView applyFiveZeroOneAppBusSer(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("applyFiveZeroOneAppBusSer ...Controller");
		return federalFormsUpdateService.fiveZeroOneFormUpdation(req, sn);
	}
	
//	Federal Form modification Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/singleFederalDataModification")
	@ResponseBody
	public ModelAndView singleFederalDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("singleFederalDataModification ...Controller");
		return federalFormsService.singleFederalTaxDataModification(req, sn);
	}
	
//	Federal Form JSON Controller
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFederalTaxLegalName")
	@ResponseBody
	public JSONArray jSonFederalTaxLegalName(@RequestParam("documentName") String documentName, HttpSession sn) {
		LOGGER.debug("jSonFederalTaxLegalName...Controller");
		LOGGER.info("UserChoice Value: "+documentName);
		return federalFormsService.jSonFederalTaxLegalNameChecking(documentName, sn);
		
	}
	
//	S Corporation Form modification Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/sCorporationDataModification")
	@ResponseBody
	public ModelAndView sCorporationDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("sCorporationDataModification ...Controller");
		return federalFormsService.sCorporationDataModification(req, sn);
	}
	
//	S Corporation Form JSON Controller
	@RequestMapping(method = RequestMethod.POST, value = "/jSonSCorporationName")
	@ResponseBody
	public JSONArray jSonSCorporationName(@RequestParam("documentName") String documentName, HttpSession sn) {
		LOGGER.debug("jSonSCorporationName...Controller");
		LOGGER.info("UserChoice Value: "+documentName);
		return federalFormsService.jSonSCorporationNameChecking(documentName, sn);
		
	}
	
//	501 Form modification Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/fiveZeroOneFormModification")
	@ResponseBody
	public ModelAndView fiveZeroOneFormModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("fiveZeroOneFormModification ...Controller");
		return federalFormsService.fiveZeroOneFormModification(req, sn);
	}
	
//	501 Form JSON Controller
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFiveZeroOneName")
	@ResponseBody
	public JSONArray jSonFiveZeroOneName(@RequestParam("documentName") String documentName, HttpSession sn) {
		LOGGER.debug("jSonFiveZeroOneName...Controller");
		LOGGER.info("UserChoice Value: "+documentName);
		return federalFormsService.jSonFiveZeroOneNameChecking(documentName, sn);
		
	}
	
//	Pending Federal Form Saving Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/pendingFederalFormsRedirection")
	@ResponseBody
	public ModelAndView pendingFederalFormsRedirection(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("pendingFederalFormsRedirection ...Controller");
		return federalFormsService.pendingFederalFormsRedirection(req, sn);
	}
	
//	Pending Federal Form Data Operations Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/allFederalFormsDataOperations")
	@ResponseBody
	public ModelAndView allFederalFormsDataOperations(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("allFederalFormsDataOperations ...Controller");
		return federalFormsService.allFederalFormsDataOperations(req, sn);
	}
	
//	All Federal Forms Checkout Redirection Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/federalCheckoutDataModification")
	@ResponseBody
	public ModelAndView federalCheckoutDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("federalCheckoutDataModification ...Controller");
		return federalFormsService.federalTaxCheckoutDataRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sCorpCheckoutDataModification")
	@ResponseBody
	public ModelAndView sCorpCheckoutDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("sCorpCheckoutDataModification ...Controller");
		return federalFormsService.sCorporationCheckoutDataRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fiveZeroOneCheckoutDataModification")
	@ResponseBody
	public ModelAndView fiveZeroOneCheckoutDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("fiveZeroOneCheckoutDataModification ...Controller");
		return federalFormsService.fiveZeroOneCheckoutDataRedirection(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/federalFormsPomoCodeRedirection")
	@ResponseBody
	public ModelAndView federalFormsPomoCodeRedirection(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("federalFormsPomoCodeRedirection ...Controller");
		return federalFormsService.federalFormsCheckoutPaymentDataSaving(req, sn);
	}
	
//	Add to Cart Federal forms display Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/addToCartFederalFormsData")
	@ResponseBody
	public ModelAndView addToCartFederalFormsData(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("addToCartFederalFormsData ...Controller");
		return federalFormsService.addToCartAllFederalFormsData(req, sn);
	}
	
//	Checkout Federal Tax ID JSON calling for modified values Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/federalJSonModifiedValuesUpdate")
	@ResponseBody
	public JSONArray federalJSonModifiedValuesUpdate(@RequestParam("documentName") String documentName, HttpSession sn) {
		LOGGER.debug("federalJSonModifiedValuesUpdate ...Controller");
		LOGGER.info("userChoice : "+documentName);
		return federalFormsService.federalJSonCheckoutDataUpdationInDB(documentName, sn);
		
	}
	
//	Checkout SCorporation JSON calling for modified values Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/sCorpJSonModifiedValuesUpdate")
	@ResponseBody
	public JSONArray sCorpJSonModifiedValuesUpdate(@RequestParam("documentName") String documentName, HttpSession sn) {
		LOGGER.debug("sCorpJSonModifiedValuesUpdate ...Controller");
		LOGGER.info("userChoice : "+documentName);
		return federalFormsService.sCorpJSonCheckoutDataUpdationInDB(documentName, sn);
		
	}
	
//	Checkout 501 Application JSON calling for modified values Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/fzoJSonModifiedValuesUpdate")
	@ResponseBody
	public JSONArray fzoJSonModifiedValuesUpdate(@RequestParam("documentName") String documentName, HttpSession sn) {
		LOGGER.debug("fzoJSonModifiedValuesUpdate ...Controller");
		LOGGER.info("userChoice : "+documentName);
		return federalFormsService.fzoJSonCheckoutDataUpdationInDB(documentName, sn);
		
	}
	
//	Completed Federal forms for User Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/completedFederalFormsForUser")
	@ResponseBody
	public ModelAndView completedFederalFormsForUser(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("completedFederalFormsForUser ...Controller");
		return federalFormsService.completedFederalFormsForUserDataDisplay(req, sn);
	}
	
//	Completed Federal forms for Admin Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/completedFederalFormsForAdmin")
	@ResponseBody
	public ModelAndView completedFederalFormsForAdmin(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("completedFederalFormsForAdmin ...Controller");
		return federalFormsService.completedFederalFormsForAdminDataDisplay(req, sn);
	}

}
