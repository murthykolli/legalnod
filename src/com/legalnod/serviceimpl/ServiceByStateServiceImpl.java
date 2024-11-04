/**
 *
 */
package com.legalnod.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.daoimpl.DropdownStateDAOImpl;
import com.legalnod.service.ServiceByStateService;

/**
 * @author MurthyK
 *
 */
public class ServiceByStateServiceImpl implements ServiceByStateService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceByStateServiceImpl.class);
    @Autowired
    private DropdownStateDAOImpl dropdownStateDAOImpl;

    @Override
    @Transactional
    public ModelAndView serviceByStateHome(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("serviceByStateHome...Service");
        List statesList = dropdownStateDAOImpl.findByCategory("SBS");
        ModelAndView mav;
        if (sn.getAttribute("userNameInSn") != null) {
            mav = new ModelAndView("servicesByStateAL");
            mav.addObject("firstName", sn.getAttribute("firstNameInSn"));
            mav.addObject("noOfDocInCart", sn.getAttribute("noOfDocInCartInSn"));
        } else {
            mav = new ModelAndView("servicesByState");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }
}
