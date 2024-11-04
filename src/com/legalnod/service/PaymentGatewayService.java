package com.legalnod.service;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;

public interface PaymentGatewayService {
	
	public ModelAndView paymentResponseRevertBackFromBank(HttpServletRequest req, HttpSession sn);
	
	public JSONObject convertFromStringToJSONFormat(String jSonResponse);
	
	public String resBodyFromAPIToApplication(String jSONObject);
	
	public Timestamp currentDate();
	
}
