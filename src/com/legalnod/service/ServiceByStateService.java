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
public interface ServiceByStateService {
	
	public ModelAndView serviceByStateHome(HttpServletRequest req, HttpSession sn);

}
