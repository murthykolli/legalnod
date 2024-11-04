package com.legalnod.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface AdditionalService {
	
	public ModelAndView additionalServiceFormDataSavingAndUpdatingInDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView additionalServiceFormsDataModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView additionalServiceFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public JSONArray jSonAdditionalServiceFirstChoiceChecking(String updatedAttrVal, HttpSession sn);
	
	public ModelAndView additionalServiceCheckoutDataRedirection(HttpServletRequest req, HttpSession sn);
	
	public JSONArray jSonASCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn);
	
	public Timestamp currentDate();
	
	public int takeFormIdFromDB(HttpSession sn);
	
//	Additional Service Form modification Service Implementation splitting methods	
	
	public JSONObject additionalServiceFormsFiveAttributesInfoFromJSP(HttpServletRequest req);
	
	public JSONObject addSerFormsAllAttributesInfoFromJSP(HttpServletRequest req, HttpSession sn);
	
	public String additionalServiceFormStatusInDB(HttpServletRequest req, HttpSession sn);
	
	public String additionalServiceFormRegistredAgentPrice(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView additionalServiceFormsModificationAttributesInfo(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView registerAgentPriceUpdateInPaymentTable(String regAgentPrice, HttpSession sn);
	
	public ModelAndView additionalFormsAllRelatedOtherTablesUpdate(HttpServletRequest req, HttpSession sn);
	
	
}
