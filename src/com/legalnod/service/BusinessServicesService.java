/**
 * 
 */
package com.legalnod.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author MurthyK
 *
 */
public interface BusinessServicesService {
	
//  Business Service User Profile Implements
	
	public ModelAndView userProfileHome(HttpServletRequest req, HttpSession sn);
	
//  Business Service Show Hide Implements	
	
	public ModelAndView busAdditionalServicesHide(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busAdditionalServicesShow(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busComplianceHide(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busComplianceShow(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busFormingYourBusinessHide(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busFormingYourBusinessShow(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busManagingYourBusinessHide(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busManagingYourBusinessShow(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busNamingYourBusinessHide(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busNamingYourBusinessShow(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busTrademarkHide(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView busTrademarkShow(HttpServletRequest req, HttpSession sn);
	
//  Business Service Drop downs Implements
	
	public ModelAndView limitedLiabilityCompanyBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedPartnershipBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedLiabilityPartnershipBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView professionalCorpBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView nonProfitCorpBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView cCorpBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView sCorpBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView foreignQualificationsBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView amendmentsChangesBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView dissolutionsTerminationsBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameChangeBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView conversionsBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameAvailabilityCheckBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameReservationBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView doingBusinessAsBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView trademarkStateRegistrationForBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView annualReportsBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView initialReportsBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView federalTaxIDBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView stateTaxIDBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView fzoApplicationBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView certificateOfGoodStandingForBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView certifiedCopiesForBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView reinstatementOfBusinessForBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView registeredAgentForBS(HttpServletRequest req, HttpSession sn);
	
//	Business Services Drop down Forms Selection using JSON Service Interface
	
	public JSONArray selectFormNamesWithStateNameData(String selectedCat);
	
	public JSONArray selectFormNamesWithStateNameFQData(String selectedCat);
	
	public JSONArray selectCategoryNamesWithStateNameData(String selectedCat);
	
	public JSONArray selectFormNamesWithCatAndStateNameData(String selectedCat);
	
	public JSONArray serviceByStateCategorySelectionData(String selectedStateName);
	
	public JSONArray serviceByStateFormDataSelection(String selectedCat);
	
	public ModelAndView newStateFormSelectionFromDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView newAllFormSelectionFromDB(HttpServletRequest req, HttpSession sn);
	
//	Name Availability Check Form Info saving Service Interface
	
	public ModelAndView nameAvailabilityCheckInfoSave(HttpServletRequest req, HttpSession sn);
	
//	Footer Privacy Policy And Terms And Conditions Service Interface
	
	public ModelAndView privacyPolicyInfo();
	
	public ModelAndView termsAndConditionsInfo();
	
//	Additional Sevice
	
	public ModelAndView newAdditionalServiceFormSelectionFromDB(HttpServletRequest req, HttpSession sn);
	
//	State Tax Id Sevice
	
	public ModelAndView newStateTaxIdFormSelectionFromDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView newStateFormAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req);
	
	public ModelAndView newAdditionalServiceAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req);
	
	public ModelAndView newStateTaxIdAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req);
	
	// Standard and Processing Fees
	
	public JSONArray selectedFormStateSelectionForPrice(String selectedCat, HttpSession sn);
	
	public JSONArray selectedFederalFormsSelectionForPrice(String selectedCat, HttpSession sn);
	
	public int takeFormIdFromDB(String stateName, String formName);
		
}
