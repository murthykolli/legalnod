/**
 * 
 */
package com.legalnod.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author MurthyK
 *
 */
public interface CustomDocumentService {
	
	public ModelAndView customDocument(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView reqDocInfoSending(HttpServletRequest request, HttpSession session);
	
	public ModelAndView newWindowCustomDocument(HttpServletRequest req, HttpSession sn);
	
	public ModelAndView newWindowReqDocInfoSending(HttpServletRequest request);

}
