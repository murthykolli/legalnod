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
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.serviceimpl.UsersInformationServiceImpl;



/**
 * @author MurthyK
 *
 */

@Controller
public class UsersInformationController {
	
private static final Logger LOGGER = LoggerFactory.getLogger(UsersInformationController.class);
	
	@Autowired
	private UsersInformationServiceImpl userInfoServiceImpl;
	
//	Registration Controller methods
	
	@RequestMapping(method = RequestMethod.GET, value = "/registrationPage")
	public ModelAndView registrationPage() {
		LOGGER.debug("registrationPage ...Controller");
		return userInfoServiceImpl.registrationHome();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/userDataSavingInDB")
	public ModelAndView userDataSavingInDB(HttpServletRequest request, HttpSession session) {	
		LOGGER.debug("userDataSavingInDB ...Controller");
		return userInfoServiceImpl.userDataSavingInDB(request,session);
	}
	
//	Login Controller methods
	
	@RequestMapping(method = RequestMethod.GET, value = "/loginPage")	
	public ModelAndView loginPage(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("loginPage ...Controller");
		return userInfoServiceImpl.logInHome(request,session);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/loginRedirection")
	public ModelAndView loginRedirection(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("loginRedirection ...Controller");
		return userInfoServiceImpl.userDataRetriveFromDB(request,session);
	}
	
//	LogOut Controller methods
	
	@RequestMapping(method = RequestMethod.GET, value = "/logOut")
	public ModelAndView logOut(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("logOut ...Controller");
		return userInfoServiceImpl.userLogOutRedirection(request,session);
	}
	
	
//	Sessio time Out Controller methods
	
	@RequestMapping(method = RequestMethod.GET, value = "/sessionTimeOut")
	public ModelAndView sessionTimeOut(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("sessionTimeOut ...Controller");
		return userInfoServiceImpl.userSessionTimeOutRedirection(request,session);
	}
	
	
//	Forget Password With Email Controller methods
	
	@RequestMapping(method = RequestMethod.GET, value = "/lnForgetPass")	
	public ModelAndView lnForgetPass() {
		LOGGER.debug("lnForgetPass ...Controller");
		return userInfoServiceImpl.forgetPasswordWithEmail();
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/forgetPasswordWithEmailChecking")	
	public ModelAndView forgetPasswordWithEmailChecking(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("forgetPasswordWithEmailChecking ...Controller");
		return userInfoServiceImpl.forgetPasswordWithEmailChecking(request,session);
	}
	
//	Forget Password With Security Pin Controller methods
	
	@RequestMapping(method = RequestMethod.POST, value = "/forgetPasswordWithsecurityPinChecking")	
	public ModelAndView forgetPasswordWithsecurityPinChecking(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("forgetPasswordWithsecurityPinChecking ...Controller");
		return userInfoServiceImpl.forgetPasswordWithSecurityPin(request,session);
	}
	
//	User profile Controller
	
	@RequestMapping(method = RequestMethod.POST, value = "/changeUserEmailAddress")	
	public ModelAndView changeUserEmailAddress(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("changeUserEmailAddress ...Controller");
		return userInfoServiceImpl.changeUserEmailAddress(request,session);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/changePassword")	
	public ModelAndView changePassword(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("changePassword ...Controller");
		return userInfoServiceImpl.changePassword(request,session);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/editContactInfo")	
	public ModelAndView editContactInfo(HttpServletRequest request, HttpSession session) {
		LOGGER.debug("editContactInfo ...Controller");
		return userInfoServiceImpl.editContactInfo(request,session);
	}
	

}