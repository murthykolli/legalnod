package com.legalnod.serviceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.service.ContactUsService;

/**
 * @author MurthyK
 *
 */
public class ContactUsServiceImpl implements ContactUsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContactUsServiceImpl.class);
    
    private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";    
    private String userNameInSn = "userNameInSn";    
    private String contUsHeading = "ContactUs";
    private String contUsValue = "contactUs";

    @Override
    @Transactional
    public ModelAndView contactUsHome(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("contactUsHome...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("contactUsAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView(contUsValue);
        }
        return mav;
    }

    public ModelAndView contactInfoSaving(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("contactInfoSaving...Service");
        String contactName = request.getParameter("contactName");
        String contactEmail = request.getParameter("contactEmail");
        String contactComment = request.getParameter("contactComment");
        EmailSending userEmail = new EmailSending();
        ModelAndView mav;
        String aTo = "contactus@legalnod.com";        
        String type = "text/html";
        String aBody = "Hello" + "&nbsp;" + "<b>" + contactName + "</b>" + "<br>" + "<hr>";
        String body = "Name :" + "\t" + contactName + "\n"
                + "<br>" + "Email :" + "\t" + contactEmail + "\n"
                + "<br>" + "Comments :" + "\t" + contactComment + "\n";

        try {
            userEmail.sendEmail(aTo, "Contact Us", aBody + body, type, "contactus@legalnod.com");
        } catch (Exception ex) {
        	LOGGER.error("contactInfoSaving " + ex);
        }
        if (session.getAttribute("userNameInSn") != null) {
            mav = new ModelAndView("contactUsAL");
            mav.addObject(firstName, session.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, session.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView(contUsValue);
        }
        mav.addObject(contUsValue, contUsHeading);
        return mav;
    }

//	New window open Contact us
    @Override
    @Transactional
    public ModelAndView newWindowContactUsHome() {
    	LOGGER.debug("newWindowContactUsHome...Service");
    	String newWindowCon = "/contactus/new_Window_Contactus";
        ModelAndView mav = new ModelAndView(newWindowCon);
        return mav;
    }

    public ModelAndView newWindowContactInfoSaving(HttpServletRequest request) {
    	LOGGER.debug("newWindowContactInfoSaving...Service");
        String contactName = request.getParameter("contactName");
        String contactEmail = request.getParameter("contactEmail");
        String contactComment = request.getParameter("contactComment");
        EmailSending userEmail = new EmailSending();
        String aTo = "contactus@legalnod.com";        
        String type = "text/html";
        String aBody = "Hello" + "&nbsp;" + "<b>" + contactName + "</b>" + "<br>" + "<hr>";
        String body = "Name :" + "\t" + contactName + "\n"
                + "<br>" + "Email :" + "\t" + contactEmail + "\n"
                + "<br>" + "Comments :" + "\t" + contactComment + "\n";
        try {
            userEmail.sendEmail(aTo, "Contact Us", aBody + body, type, "contactus@legalnod.com");
        } catch (Exception ex) {
        	LOGGER.error("newWindowContactInfoSaving " + ex);
        }
        String contNewWindow = "/contactus/new_Window_Contactus";
        ModelAndView mav = new ModelAndView(contNewWindow);
        mav.addObject(contUsValue, contUsHeading);
        return mav;
    }

}
