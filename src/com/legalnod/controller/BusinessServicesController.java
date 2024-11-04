/**
 * 
 */
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

import com.legalnod.service.BusinessServicesService;

/**
 * @author MurthyK
 *
 */

@Controller
public class BusinessServicesController {
	
	@Autowired
	private BusinessServicesService busSerService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BusinessServicesController.class);
	
//	Business Services User Profile Pages Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/editUserProfile")
	@ResponseBody
	public ModelAndView userProfileHomePage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("userProfileHomePage...Controller");
		return busSerService.userProfileHome(req, sn);
	}
	
//	Business Services Home Pages Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/minBsAdditionalServices")
	@ResponseBody
	public ModelAndView additionalServicesHidePage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("additionalServicesHidePage...Controller");
		return busSerService.busAdditionalServicesHide(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bsAdditionalServices")
	@ResponseBody
	public ModelAndView additionalServicesShowPage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("additionalServicesHidePage...Controller");
		return busSerService.busAdditionalServicesShow(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/minBsComplaints")
	@ResponseBody
	public ModelAndView complianceHidePage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("complianceHidePage...Controller");
		return busSerService.busComplianceHide(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bsComplaints")
	@ResponseBody
	public ModelAndView complianceShowPage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("complianceShowPage...Controller");
		return busSerService.busComplianceShow(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/minBsFormingYrBus")
	@ResponseBody
	public ModelAndView formingYourBusinessHidePage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("formingYourBusinessHidePage...Controller");
		return busSerService.busFormingYourBusinessHide(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/businessServices")
	@ResponseBody
	public ModelAndView formingYourBusinessShowPage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("formingYourBusinessShowPage...Controller");
		return busSerService.busFormingYourBusinessShow(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/minBsManagingYourBusiness")
	@ResponseBody
	public ModelAndView managingYourBusinessHidePage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("managingYourBusinessHidePage...Controller");
		return busSerService.busManagingYourBusinessHide(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bsManagingYourBusiness")
	@ResponseBody
	public ModelAndView managingYourBusinessShowPage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("managingYourBusinessShowPage...Controller");
		return busSerService.busManagingYourBusinessShow(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/minBsNamingYourBusiness")
	@ResponseBody
	public ModelAndView namingYourBusinessHidePage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("namingYourBusinessHidePage...Controller");
		return busSerService.busNamingYourBusinessHide(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bsNamingYourBusiness")
	@ResponseBody
	public ModelAndView namingYourBusinessShowPage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("namingYourBusinessShowPage...Controller");
		return busSerService.busNamingYourBusinessShow(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/minBsTrademark")
	@ResponseBody
	public ModelAndView trademarkHidePage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("trademarkHidePage...Controller");
		return busSerService.busTrademarkHide(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/bsTrademark")
	@ResponseBody
	public ModelAndView trademarkShowPage(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("trademarkShowPage...Controller");
		return busSerService.busTrademarkShow(req, sn);
	}
	
//	Business Services Drop down Pages Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/limitedLiabilityCompanyForBS")
	@ResponseBody
	public ModelAndView limitedLiabilityCompanyForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedLiabilityCompanyForBS...Controller");
		return busSerService.limitedLiabilityCompanyBS(req, sn);
	}	
	
	@RequestMapping(method = RequestMethod.GET, value = "/limitedPartnershipForBS")
	@ResponseBody
	public ModelAndView limitedPartnershipForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedPartnershipForBS...Controller");
		return busSerService.limitedPartnershipBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/limitedLiabilityPartnershipForBS")
	@ResponseBody
	public ModelAndView limitedLiabilityPartnershipForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedLiabilityPartnershipForBS...Controller");
		return busSerService.limitedLiabilityPartnershipBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/professionalCorporationForBS")
	@ResponseBody
	public ModelAndView professionalCorporationForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("professionalCorporationForBS...Controller");
		return busSerService.professionalCorpBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/nonProfitCorporationForBS")
	@ResponseBody
	public ModelAndView nonProfitCorporationForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nonProfitCorporationForBS...Controller");
		return busSerService.nonProfitCorpBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/cCorporationForBS")
	@ResponseBody
	public ModelAndView cCorporationForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("cCorporationForBS...Controller");
		return busSerService.cCorpBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/sCorporationForBS")
	@ResponseBody
	public ModelAndView sCorporationForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("sCorporationForBS...Controller");
		return busSerService.sCorpBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/foreignQualificationsForBS")
	@ResponseBody
	public ModelAndView foreignQualificationsForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("foreignQualificationsForBS...Controller");
		return busSerService.foreignQualificationsBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/amendmentsForBS")
	@ResponseBody
	public ModelAndView amendmentsForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("amendmentsForBS...Controller");
		return busSerService.amendmentsChangesBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/dissolutionsOrTerminationsForBS")
	@ResponseBody
	public ModelAndView dissolutionsOrTerminationsForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("dissolutionsOrTerminationsForBS...Controller");
		return busSerService.dissolutionsTerminationsBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/nameChangeForBS")
	@ResponseBody
	public ModelAndView nameChangeForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameChangeForBS...Controller");
		return busSerService.nameChangeBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/conversionsForBS")
	@ResponseBody
	public ModelAndView conversionsForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("conversionsForBS...Controller");
		return busSerService.conversionsBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/nameAvailabilityCheckForBS")
	@ResponseBody
	public ModelAndView nameAvailabilityCheckForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameAvailabilityCheckForBS...Controller");
		return busSerService.nameAvailabilityCheckBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/nameReservationForBS")
	@ResponseBody
	public ModelAndView nameReservationForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameReservationForBS...Controller");
		return busSerService.nameReservationBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/doingBusinessAsForBS")
	@ResponseBody
	public ModelAndView doingBusinessAsForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("doingBusinessAsForBS...Controller");
		return busSerService.doingBusinessAsBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/trademarkStateRegistrationForBS")
	@ResponseBody
	public ModelAndView trademarkStateRegistrationForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("trademarkStateRegistrationForBS...Controller");
		return busSerService.trademarkStateRegistrationForBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/annualReportsForBS")
	@ResponseBody
	public ModelAndView annualReportsForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("annualReportsForBS...Controller");
		return busSerService.annualReportsBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/initialReportsForBS")
	@ResponseBody
	public ModelAndView initialReportsForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("initialReportsForBS...Controller");
		return busSerService.initialReportsBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/federalTaxIDForBS")
	@ResponseBody
	public ModelAndView federalTaxIDForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("federalTaxIDForBS...Controller");
		return busSerService.federalTaxIDBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/asStateTaxID")
	@ResponseBody
	public ModelAndView asStateTaxID(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("asStateTaxID...Controller");
		return busSerService.stateTaxIDBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/fiveZeroOneApplicationForBS")
	@ResponseBody
	public ModelAndView fiveZeroOneApplicationForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("fiveZeroOneApplicationForBS...Controller");
		return busSerService.fzoApplicationBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/certificateOfGoodStandingForBS")
	@ResponseBody
	public ModelAndView certificateOfGoodStandingForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("certificateOfGoodStandingForBS...Controller");
		return busSerService.certificateOfGoodStandingForBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/certifiedCopiesForBS")
	@ResponseBody
	public ModelAndView certifiedCopiesForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("certifiedCopiesForBS...Controller");
		return busSerService.certifiedCopiesForBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reinstatementOfBusinessForBS")
	@ResponseBody
	public ModelAndView reinstatementOfBusinessForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("reinstatementOfBusinessForBS...Controller");
		return busSerService.reinstatementOfBusinessForBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/registeredAgentForBS")
	@ResponseBody
	public ModelAndView registeredAgentForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("registeredAgentForBS...Controller");
		return busSerService.registeredAgentForBS(req, sn);
	}
	
//	Dropdown Json calling select Form Name with State Name Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFormSelectionWithState")
	@ResponseBody
	public JSONArray jSonFormSelectionWithState(@RequestParam("stateName") String stateName) {
		LOGGER.debug("jSonFormSelectionWithState...Controller");
		LOGGER.info("stateName : "+stateName);
		return busSerService.selectFormNamesWithStateNameData(stateName);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFQFormSelectionWithState")
	@ResponseBody
	public JSONArray jSonFQFormSelectionWithState(@RequestParam("stateName") String stateName) {
		LOGGER.debug("jSonFQFormSelectionWithState...Controller");
		LOGGER.info("stateName : "+stateName);
		return busSerService.selectFormNamesWithStateNameFQData(stateName);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonCatSelectionWithState")
	@ResponseBody
	public JSONArray jSonCatSelectionWithState(@RequestParam("stateName") String stateName) {
		LOGGER.debug("jSonCatSelectionWithState...Controller");
		LOGGER.info("stateName : "+stateName);
		return busSerService.selectCategoryNamesWithStateNameData(stateName);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFormSelectionWithCatAndState")
	@ResponseBody
	public JSONArray jSonFormSelectionWithCatAndState(@RequestParam("stateName") String stateName) {
		LOGGER.debug("jSonFormSelectionWithCatAndState...Controller");
		LOGGER.info("stateName : "+stateName);
		return busSerService.selectFormNamesWithCatAndStateNameData(stateName);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonCatServiceByStateSelection")
	@ResponseBody
	public JSONArray jSonCatServiceByStateSelection(@RequestParam("stateName") String stateName) {
		LOGGER.debug("jSonCatServiceByStateSelection...Controller");
		LOGGER.info("stateName : "+stateName);
		return busSerService.serviceByStateCategorySelectionData(stateName);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFormServiceByStateSelection")
	@ResponseBody
	public JSONArray jSonFormServiceByStateSelection(@RequestParam("stateName") String stateName) {
		LOGGER.debug("jSonFormServiceByStateSelection...Controller");
		LOGGER.info("stateName : "+stateName);
		return busSerService.serviceByStateFormDataSelection(stateName);
		
	}
	
//	Footer Privacy Policy And Terms And Conditions Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/privacyPolicyPopup")
	@ResponseBody
	public ModelAndView privacyPolicyPopup() {
		LOGGER.debug("privacyPolicyPopup...Controller");
		return busSerService.privacyPolicyInfo();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/termsAndConditionsPopup")
	@ResponseBody
	public ModelAndView termsAndConditionsPopup() {
		LOGGER.debug("termsAndConditionsPopup...Controller");
		return busSerService.termsAndConditionsInfo();
	}
	
//	Name Availability Check Form Info saving Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/nameAvailabilityCheckInfoSave")
	@ResponseBody
	public ModelAndView nameAvailabilityCheckInfoSave(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameAvailabilityCheckInfoSave...Controller");
		return busSerService.nameAvailabilityCheckInfoSave(req, sn);
	}
	
//	New State Form Creation Controller
	
	@RequestMapping(method = RequestMethod.GET, value = "/newStateFormSelection")
	@ResponseBody
	public ModelAndView newStateFormSelection(HttpServletRequest req, HttpSession sn) {	
		LOGGER.debug("newStateFormSelection...Controller");
		return busSerService.newAllFormSelectionFromDB(req, sn);
	}
	
//	State Forms Json calling Standard Filing Fee and Processing Fees Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFormStateSelectionForPrice")
	@ResponseBody
	public JSONArray jSonFormStateSelectionForPrice(@RequestParam("formCategoty") String formCategoty, HttpSession sn) {
		LOGGER.debug("jSonFormStateSelectionForPrice...Controller");
		LOGGER.info("formCategoty : "+formCategoty);
		return busSerService.selectedFormStateSelectionForPrice(formCategoty, sn);		
	}
	
//	Federal Forms Json calling Processing Fees Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/jSonFederalFormsSelectionForPrice")
	@ResponseBody
	public JSONArray jSonFederalFormsSelectionForPrice(@RequestParam("formCategoty") String formCategoty, HttpSession sn) {
		LOGGER.debug("jSonFederalFormsSelectionForPrice...Controller");
		LOGGER.info("formCategoty : "+formCategoty);
		return busSerService.selectedFederalFormsSelectionForPrice(formCategoty, sn);
		
	}

}
