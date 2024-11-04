package com.legalnod.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface StateFormsService {
	
//	State Forms modification Service Interface
	
	public ModelAndView stateFormDataSavingAndUpdatingInDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView stateFormUserMyAccountRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allStateFormsDataOperations(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView businessStateFormsDataModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView businessStateFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView checkoutDataRedirection(HttpServletRequest req, HttpSession sn);
	
	public JSONArray checkoutDataUpdationInDB(String updatedAttrVal, HttpSession sn);
	
	public JSONArray firstChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn);
	
	public JSONArray secondChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn);
	
	public JSONArray thirdChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn);
	
	public JSONArray fourthChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn);
	
	public JSONArray fifthChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn);
	
	public JSONArray sixthChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn);
	
	public ModelAndView stateFormsCheckoutPaymentDataSaving(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView addToCartAllStateFormsData(HttpServletRequest req, HttpSession sn);
	
	public JSONArray deletionDocumentsDataFromCart(String updatedAttrVal, HttpSession sn);
	
	public ModelAndView stateAndFedFormsCartDocDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public Timestamp currentDate();
	
	public int takeFormIdFromDB(HttpSession sn);
	
	public ModelAndView completedStateFormsForUserDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView completedStateFormsForAdminDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView pendingStateFormsOnly(HttpServletRequest req, HttpSession sn);
	
	public String registerAgentPriceTakeFromDB(String regAgentValue, HttpServletRequest req, HttpSession sn);
	
	public JSONObject stateFormsFiveAttributesInfoFromJSP(HttpServletRequest req);
	
	public JSONObject stateFormsAllAttributesInfoFromJSP(HttpServletRequest req);
	
	public String stateFormStatusInDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView stateFormsAllRelatedOtherTablesUpdate(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allStateFormsDataOperationsModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allStateFormsDataOperationsFinishOrder(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allStateFormsOperationsRelatedTableDeletion(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView checkoutDataRelatedDataUpdationInDB(String attrValue, HttpSession sn);
	
	public String abbreviationExtinctionAddedToUserChoice(String userFirstChoice, String abbrStatus, String repAbbrValue, int formId, HttpSession sn);
	
	public String stateFormsPromoCodeTakeFromDB(int oldBonusPrice, String promoCode);
	
	public JSONObject convertFromStringToJSONFormat(String capturedInfoInDB);
	
	public Integer stateFormsBonusPriceTakeFromDB(int bonusFee, int dbBonusPrice);
	
	public ModelAndView registerAgentPriceUpdateInPaymentTable(String regAgentPrice, HttpSession sn);
	
	public ModelAndView authorizeCreditCardRedirectionDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView allStateFormsRelatedTablesDataDeletion(HttpServletRequest req, HttpSession sn);
	
	

}
