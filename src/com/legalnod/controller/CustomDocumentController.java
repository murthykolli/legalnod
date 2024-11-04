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

import com.legalnod.service.CustomDocumentService;

/**
 * @author MurthyK
 *
 */

@Controller
public class CustomDocumentController {	

	@Autowired
	private CustomDocumentService cusDocService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomDocumentController.class);
	
//	Custom Documents Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/customDocument")
	@ResponseBody
	public ModelAndView customDocument(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("customDocument...Controller");
		return cusDocService.customDocument(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reqDocInfoSending")
	@ResponseBody
	public ModelAndView reqDocInfoSending(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("reqDocInfoSending...Controller");
		return cusDocService.reqDocInfoSending(req, sn);
	}
	
//	Custom Documents New window open Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/newRequestDoc")
	@ResponseBody
	public ModelAndView newRequestDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("newRequestDoc...Controller");
		return cusDocService.newWindowCustomDocument(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/newReqDocInfoSending")
	@ResponseBody
	public ModelAndView newReqDocInfoSending(HttpServletRequest req) {
		LOGGER.debug("newReqDocInfoSending...Controller");
		return cusDocService.newWindowReqDocInfoSending(req);
	}

}
