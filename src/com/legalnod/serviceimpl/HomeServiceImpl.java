package com.legalnod.serviceimpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.service.HomeService;

/**
 * @author MurthyK
 *
 */

public class HomeServiceImpl implements HomeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeServiceImpl.class);

    @Override
    @Transactional
    public ModelAndView legalNodHome(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("legalNodHome...Service");        
        ModelAndView mav;
        if (sn.getAttribute("userNameInSn") != null) {            
            mav = new ModelAndView("legalNodHomeAL");
            mav.addObject("firstName", sn.getAttribute("firstNameInSn"));
            mav.addObject("noOfDocInCart", sn.getAttribute("noOfDocInCartInSn"));
        } else {
            mav = new ModelAndView("legalNodHome");
        }
        return mav;
    }
}
