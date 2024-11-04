package com.legalnod.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface FederalFormsUpdateService {
	
	public ModelAndView federalTaxIDFormUpdation(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView federalTaxIDFormAttributesInfo(JSONObject capInfoJsonObject, HttpServletRequest req);
	
	public ModelAndView sCorporationFormUpdation(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView sCorporationFormAttributesInfo(JSONObject capInfoJsonObject, HttpServletRequest req);
	
	public ModelAndView fiveZeroOneFormUpdation(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView fiveZeroOneFormAttributesInfo(JSONObject capInfoJsonObject, HttpServletRequest req);
	
	public JSONObject convertFromStringToJSONFormat(String capturedInfoInDB);
	
	public JSONObject singleFederalFormsAttributesInfoFromJSP(HttpServletRequest req);
	
	public JSONObject sCorporationFormsAttributesInfoFromJSP(HttpServletRequest req);
	
	public JSONObject fiveZeroOneFormsAttributesInfoFromJSP(HttpServletRequest req);

}
