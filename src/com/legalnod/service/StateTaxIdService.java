package com.legalnod.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface StateTaxIdService {
	
	public ModelAndView stateTaxIdFormDataSavingAndUpdatingInDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView stateTaxIdFormsDataModification(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView stateTaxIdFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn);

	public JSONArray jSonStateTaxFirstChoiceChecking(String updatedAttrVal, HttpSession sn);
	
	public ModelAndView stateTaxIdCheckoutDataRedirection(HttpServletRequest req, HttpSession sn);
	
	public JSONArray jSonSTICheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn);
	
	public Timestamp currentDate();
	
	public int takeFormIdFromDB(HttpSession sn);
	
	public JSONObject stateTaxFormsAttributesInfoFromJSP(HttpServletRequest req);
	
	public String stateTaxIdFormStatusInDB(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView stateTaxIdFormsModificationAttributesInfo(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView stateTaxIdFormsAllRelatedOtherTablesUpdate(HttpServletRequest req, HttpSession sn);
	
	
}
