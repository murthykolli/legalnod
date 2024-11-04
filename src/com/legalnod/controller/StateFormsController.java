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

import com.legalnod.service.StateFormsService;
import com.legalnod.serviceimpl.FreeFederalFormsServiceImpl;

/**
 * @author MurthyK
 *
 */

@Controller
public class StateFormsController {
	
	@Autowired
	private StateFormsService stFormService;
	
	@Autowired
    private FreeFederalFormsServiceImpl freeFederalFormsServiceImpl;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StateFormsController.class);
	
//	State Form modification Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/stateFormDataSavingAndUpdatingInDB")
	@ResponseBody
	public ModelAndView stateFormDataSavingAndUpdatingInDB(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("stateFormDataSavingAndUpdatingInDB ...Controller");
		return stFormService.stateFormDataSavingAndUpdatingInDB(req, sn);
	}
	
//	Pending State Form Saving Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/userMyAccountRedirection")
	@ResponseBody
	public ModelAndView userMyAccountRedirection(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("userMyAccountRedirection ...Controller");
		return stFormService.stateFormUserMyAccountRedirection(req, sn);
	}
	
//	all Forms Data Operations Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/allStateFormsDataOperations")
	@ResponseBody
	public ModelAndView allStateFormsDataOperations(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("allStateFormsDataOperations ...Controller");
		return stFormService.allStateFormsDataOperations(req, sn);
	}
	
//	all Forms Check out Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/checkoutDataModification")
	@ResponseBody
	public ModelAndView checkoutDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("checkoutDataModification ...Controller");
		return stFormService.checkoutDataRedirection(req, sn);
	}
	
//	Checkout Json calling for modified values Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonModifiedValuesUpdate")
	@ResponseBody
	public JSONArray jSonModifiedValuesUpdate(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonModifiedValuesUpdate ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stFormService.checkoutDataUpdationInDB(userChoice, sn);
		
	}
	
//	Abbreviations add to First Choice Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFirstChoiceAbbreviationAdding")
	@ResponseBody
	public JSONArray jSonFirstChoiceAbbreviationAdding(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonFirstChoiceAbbreviationAdding ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stFormService.firstChoiceAbbreviationAddingToJSP(userChoice, sn);
		
	}
	
//	Abbreviations add to Second Choice Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonSecChoiceAbbreviationAdding")
	@ResponseBody
	public JSONArray jSonSecChoiceAbbreviationAdding(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonSecChoiceAbbreviationAdding ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stFormService.secondChoiceAbbreviationAddingToJSP(userChoice, sn);
		
	}
	
//	Abbreviations add to Third Choice Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonThiChoiceAbbreviationAdding")
	@ResponseBody
	public JSONArray jSonThiChoiceAbbreviationAdding(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonThiChoiceAbbreviationAdding ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stFormService.thirdChoiceAbbreviationAddingToJSP(userChoice, sn);
		
	}
	
//	Abbreviations add to Fourth Choice Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFourChoiceAbbreviationAdding")
	@ResponseBody
	public JSONArray jSonFourChoiceAbbreviationAdding(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonFourChoiceAbbreviationAdding ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stFormService.fourthChoiceAbbreviationAddingToJSP(userChoice, sn);
		
	}
	
//	Abbreviations add to Fifth Choice Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFiveChoiceAbbreviationAdding")
	@ResponseBody
	public JSONArray jSonFiveChoiceAbbreviationAdding(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonFiveChoiceAbbreviationAdding ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stFormService.fifthChoiceAbbreviationAddingToJSP(userChoice, sn);
		
	}
	
//	Abbreviations add to Six Choice Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonSixChoiceAbbreviationAdding")
	@ResponseBody
	public JSONArray jSonSixChoiceAbbreviationAdding(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("jSonSixChoiceAbbreviationAdding ...Controller");
		LOGGER.info("userChoice : "+userChoice);
		return stFormService.sixthChoiceAbbreviationAddingToJSP(userChoice, sn);
		
	}
	
//	all Forms Check out promocode bonus price Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/pomoCodeRedirection")
	@ResponseBody
	public ModelAndView pomoCodeRedirection(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("pomoCodeRedirection ...Controller");
		return stFormService.stateFormsCheckoutPaymentDataSaving(req, sn);
	}
	
//	Add to Cart state forms display Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/addToCartStateFormsData")
	@ResponseBody
	public ModelAndView addToCartStateFormsData(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("addToCartStateFormsData ...Controller");
		return stFormService.addToCartAllStateFormsData(req, sn);
	}
	
//	Deletion Documents Data From Cart Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/deletionDocumentsFromCart")
	@ResponseBody
	public JSONArray deletionDocumentsFromCart(@RequestParam("userChoice") String userChoice, HttpSession sn) {
		LOGGER.debug("deletionDocumentsFromCart ...Controller");
		LOGGER.info("userChoice : "+userChoice);	
		return stFormService.deletionDocumentsDataFromCart(userChoice, sn);
		
	}
	
//	Add to Cart state forms display Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/stateAndFedFormsCartDocDisplay")
	@ResponseBody
	public ModelAndView stateAndFedFormsCartDocDisplay(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("stateAndFedFormsCartDocDisplay ...Controller");
		return stFormService.stateAndFedFormsCartDocDataDisplay(req, sn);
	}
	
//	completed state forms for User Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/completedStateFormsForUser")
	@ResponseBody
	public ModelAndView completedStateFormsForUser(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("completedStateFormsForUser ...Controller");
		return stFormService.completedStateFormsForUserDataDisplay(req, sn);
	}
	
//	completed state forms for Admin Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/completedStateFormsForAdmin")
	@ResponseBody
	public ModelAndView completedStateFormsForAdmin(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("completedStateFormsForAdmin ...Controller");
		return stFormService.completedStateFormsForAdminDataDisplay(req, sn);
	}
	
//	select No in free federal form home Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/goToStateFormCheckoutDataDisplay")
	@ResponseBody
	public ModelAndView goToStateFormCheckoutDataDisplay(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("goToStateFormCheckoutDataDisplay ...Controller");
		return freeFederalFormsServiceImpl.goToBusStateFormCheckoutDataDisplay(req, sn);
	}
	
//	select Yes in free federal form home Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/freeFederalTaxFormCreation")
	@ResponseBody
	public ModelAndView freeFederalTaxFormCreation(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("freeFederalTaxFormCreation ...Controller");
		return freeFederalFormsServiceImpl.freeFederalTaxIdFormCreation(req, sn);
	}
	
//	free Federal form Modification Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/freeFederalDataModification")
	@ResponseBody
	public ModelAndView freeFederalDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("freeFederalDataModification ...Controller");
		return freeFederalFormsServiceImpl.freeFederalTaxDataModification(req, sn);
	}
	
//	Free Federal With State Forms checkout Data Modification Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/freeFedWithStateFormscheckoutDataModification")
	@ResponseBody
	public ModelAndView freeFedWithStateFormscheckoutDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("freeFedWithStateFormscheckoutDataModification ...Controller");
		return freeFederalFormsServiceImpl.freeFederalWithStateFormscheckoutDataModification(req, sn);
	}
	
//	Free Federal Checkout Data Modification Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/freeFederalCheckoutDataModification")
	@ResponseBody
	public ModelAndView freeFederalCheckoutDataModification(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("freeFederalCheckoutDataModification ...Controller");
		return freeFederalFormsServiceImpl.freeFederalTaxCheckoutDataModification(req, sn);
	}
	
//	Modification Free Federal Form JSON Controller
	@RequestMapping(method = RequestMethod.POST, value = "/freeJSONFederalTaxLegalName")
	@ResponseBody
	public JSONArray jSonFederalTaxLegalName(@RequestParam("legalName") String legalName, HttpSession sn) {
		LOGGER.debug("freeJSONFederalTaxLegalName...Controller");
		LOGGER.info("legalName Value: "+legalName);
		return freeFederalFormsServiceImpl.freeJSONFederalTaxLegalNameChecking(legalName, sn);
		
	}
	
//	Checkout Free Federal Tax ID JSON calling Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/freeFederalJSONModifiedValuesUpdate")
	@ResponseBody
	public JSONArray freeFederalJSONModifiedValuesUpdate(@RequestParam("legalName") String legalName, HttpSession sn) {
		LOGGER.debug("freeFederalJSONModifiedValuesUpdate ...Controller");
		LOGGER.info("userChoice : "+legalName);
		return freeFederalFormsServiceImpl.freeFederalJSONCheckoutDataUpdationInDB(legalName, sn);
		
	}
	
//	Authorize.net Credit Card Redirection Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/authorizeCreditCardRedirection")
	@ResponseBody
	public ModelAndView authorizeCreditCardRedirection(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("authorizeCreditCardRedirection ...Controller");
		return stFormService.authorizeCreditCardRedirectionDisplay(req, sn);
	}
	
	
	

}
