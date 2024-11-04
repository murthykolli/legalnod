package com.legalnod.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public interface UsersInformationService {
	
	public ModelAndView registrationHome();
	
	public ModelAndView userDataSavingInDB(HttpServletRequest request, HttpSession session);
	
	public ModelAndView logInHome(HttpServletRequest request, HttpSession session);
	
	public ModelAndView userDataRetriveFromDB(HttpServletRequest request, HttpSession session);
	
	public ModelAndView userLogOutRedirection(HttpServletRequest request, HttpSession session);
	
	public ModelAndView userSessionTimeOutRedirection(HttpServletRequest request, HttpSession session);
	
	public ModelAndView forgetPasswordWithEmail();
	
	public ModelAndView forgetPasswordWithSecurityPin(HttpServletRequest request, HttpSession session);
	
//	User profile Service
	
	public ModelAndView changeUserEmailAddress(HttpServletRequest request, HttpSession session);
	
	public ModelAndView changePassword(HttpServletRequest request, HttpSession session);
	
	public ModelAndView editContactInfo(HttpServletRequest request, HttpSession session);
	
	public ModelAndView allStateFormsRedirection(String typeOfRefDocument, HttpServletRequest request, HttpSession session);
	
	public ModelAndView allFederalFormsRedirection(String typeOfFederalForm, HttpServletRequest request, HttpSession session);
	
	public ModelAndView redirectToAdminModule(HttpSession session, int userId);

}
