/**
 *
 */
package com.legalnod.serviceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.service.CustomDocumentService;

/**
 * @author MurthyK
 *
 */
public class CustomDocumentServiceImpl implements CustomDocumentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomDocumentServiceImpl.class);
    
    private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";    
    private String userNameInSn = "userNameInSn";
    private String customDocHeading = "CustomDocument";
    private String customDocValue = "customDocument";    
    
    @Override
    @Transactional
    public ModelAndView customDocument(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("customDocument...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("customDocumentAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject("noOfDocInCart", sn.getAttribute("noOfDocInCartInSn"));
        } else {
            mav = new ModelAndView(customDocValue);
        }
        return mav;
    }

    public ModelAndView reqDocInfoSending(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("reqDocInfoSending...Service");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String comment = request.getParameter("comment");        
        EmailSending userEmail = new EmailSending();        
        ModelAndView mav;
        String aTo = "contactus@legalnod.com";        
        String type = "text/html";
        String aBody = "Hello" + "&nbsp;" + "<b>" + name + "</b>" + "<br>" + "<hr>";
        String body = "Name :" + "\t" + name + "\n"
                + "<br>" + "Email :" + "\t" + email + "\n"
                + "<br>" + "Phone No :" + "\t" + phone + "\n"
                + "<br>" + "Comments :" + "\t" + comment + "\n";
        try {
            userEmail.sendEmail(aTo, "Custom Document", aBody + body, type, "requestdocument@legalnod.com");
        } catch (Exception ex) {
        	LOGGER.error("reqDocInfoSending " + ex);
        }
        if (session.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("customDocumentAL");
            mav.addObject(firstName, session.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, session.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView(customDocValue);
        }
        mav.addObject(customDocValue, customDocHeading);
        return mav;
    }

//	New window open custom document
    @Override
    @Transactional
    public ModelAndView newWindowCustomDocument(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("newWindowCustomDocument...Service");
        ModelAndView mav = new ModelAndView("/customDocument/new_Window_RequestDoc");
        return mav;
    }

    public ModelAndView newWindowReqDocInfoSending(HttpServletRequest request) {
    	LOGGER.debug("newWindowReqDocInfoSending...Service");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String comment = request.getParameter("comment");
        LOGGER.info("name : "+name+"email : "+email+"phone : "+phone+"comment : "+comment);       
        EmailSending userEmail = new EmailSending();        
        String aTo = "contactus@legalnod.com";        
        String type = "text/html";
        String aBody = "Hello" + "&nbsp;" + "<b>" + name + "</b>" + "<br>" + "<hr>";
        String body = "Name :" + "\t" + name + "\n"
                + "<br>" + "Email :" + "\t" + email + "\n"
                + "<br>" + "Phone No :" + "\t" + phone + "\n"
                + "<br>" + "Comments :" + "\t" + comment + "\n";
        try {
            userEmail.sendEmail(aTo, "Custom Document", aBody + body, type, "requestdocument@legalnod.com");
        } catch (Exception ex) {
        	LOGGER.error("newWindowReqDocInfoSending " + ex);
        }

        ModelAndView mav = new ModelAndView("/customDocument/new_Window_RequestDoc");
        mav.addObject(customDocValue, customDocHeading);
        return mav;
    }

}
