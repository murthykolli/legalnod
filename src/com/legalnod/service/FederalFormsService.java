package com.legalnod.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface FederalFormsService {	
	
	public ModelAndView singleFederalTaxDataModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView federalTaxIdFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView sCorporationDataModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView sCorporationFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView fiveZeroOneFormModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView fiveZeroOneFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allFederalFormsDataOperations(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView federalTaxIDSelectedFormModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView sCorporationSelectedFormModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView fiveZeroOneFormSelectedFormModification(HttpServletRequest req, HttpSession sn);
	
	
	public ModelAndView federalTaxCheckoutDataRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView sCorporationCheckoutDataRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView fiveZeroOneCheckoutDataRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView federalFormsCheckoutPaymentDataSaving(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView addToCartAllFederalFormsData(HttpServletRequest req, HttpSession sn);
	
	
//	Json Service
	public JSONArray jSonFederalTaxLegalNameChecking(String updatedAttrVal, HttpSession sn);

	public JSONArray jSonSCorporationNameChecking(String updatedAttrVal, HttpSession sn);
	
	public JSONArray jSonFiveZeroOneNameChecking(String updatedAttrVal, HttpSession sn);
	
	public ModelAndView pendingFederalFormsRedirection(HttpServletRequest req, HttpSession sn);
	
	
	public JSONArray federalJSonCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn);
	
	public JSONArray sCorpJSonCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn);
	
	public JSONArray fzoJSonCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn);
	
	public ModelAndView completedFederalFormsForUserDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView completedFederalFormsForAdminDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();	
		
	public String federalTaxIDFormStatusInDB(HttpServletRequest req, HttpSession sn);
	
	public String sCorporationFormStatusInDB(HttpServletRequest req, HttpSession sn);
	
	public String fiveZeroOneFormStatusInDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allFederalFormsDataOperationsModification(String documentsCombValue, HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allFederalFormsDataOperationsFormFinishOrder(String documentsCombValue, HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allFederalFormsDataOperationsNewFormCreation(String documentsCombValue, HttpServletRequest req, HttpSession sn);
	
	public String federalFormsPromoCodeTakeFromDB(int oldBonusPrice, String enteredPromocode);
	
	public ModelAndView allFederalFormsRelatedTablesUpdationInDB(String attrValue, HttpSession sn);
	
	public JSONObject convertFromStringToJSONFormat(String capturedInfoInDB);
	
	public Integer federalFormsBonusPriceTakeFromDB(int bonusFee, int dbBonusPrice);
	
	public ModelAndView allFederalFormsRelatedTableDataDeletion(HttpServletRequest req, HttpSession sn);

}
