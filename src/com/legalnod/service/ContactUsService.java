package com.legalnod.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;


/**
 * @author MurthyK
 *
 */

public interface ContactUsService {
	
	public ModelAndView contactUsHome(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView contactInfoSaving(HttpServletRequest request, HttpSession session);
	
	public ModelAndView newWindowContactUsHome();
	
	public ModelAndView newWindowContactInfoSaving(HttpServletRequest request);
	
	

}
