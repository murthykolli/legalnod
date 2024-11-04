/**
 * 
 */
package com.legalnod.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.service.ContactUsService;

/**
 * @author MurthyK
 *
 */

@Controller
public class ContactUsController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsController.class);
	
	@Autowired
	private ContactUsService contactUsService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/contactUs")
	@ResponseBody
	public ModelAndView contactUs(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("contactUs...Controller");
		return contactUsService.contactUsHome(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/contactInfoSending")
	@ResponseBody
	public ModelAndView contactInfoSending(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("contactInfoSending...Controller");
		return contactUsService.contactInfoSaving(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/contactUsNew")
	@ResponseBody
	public ModelAndView contactUsNew(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("contactUsNew...Controller");
		return contactUsService.newWindowContactUsHome();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/newContactInfoSending")
	@ResponseBody
	public ModelAndView newContactInfoSending(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("newContactInfoSending...Controller");
		return contactUsService.newWindowContactInfoSaving(req);
	}

}
