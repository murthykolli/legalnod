package com.legalnod.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface FreeFederalFormsService {
	
	public ModelAndView busStateFormsFreeFedAndCheckouRedirection(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView goToBusStateFormCheckoutDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView freeFederalTaxIdFormCreation(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView freeFederalTaxIdAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req);
	
	public ModelAndView freeFederalTaxDataModification(HttpServletRequest req, HttpSession sn);
	
	public JSONObject freeFederalFormsAttributesInfoFromJSP(HttpServletRequest req);
	
	public String freeFederalFormStatusInDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView stateFormsWithFreeFederalCheckouDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView freeFederalTaxIdFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView freeFederalWithStateFormscheckoutDataModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView freeFederalTaxCheckoutDataModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView freeFederalTaxCheckoutModification(HttpServletRequest req, HttpSession sn);
	
	public JSONArray freeJSONFederalTaxLegalNameChecking(String updatedAttrVal, HttpSession sn);
	
	public JSONArray freeFederalJSONCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn);
	
	public Timestamp currentDate();
	
	public int takeFormIdFromDB(HttpSession sn);
	
	public String takeFormFederalStatusFromDB(HttpSession sn);
	
	public JSONObject convertFromStringToJSONFormat(String capturedInfoInDB);
	
	

}
