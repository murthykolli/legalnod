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

import com.legalnod.service.PaymentGatewayService;

/**
 * @author MurthyK
 *
 */

@Controller
public class PaymentGatewayController {
	
	@Autowired
	private PaymentGatewayService paymentGatewayService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentGatewayController.class);
	
//	Payment Gateway Controller Actions
	
	@RequestMapping(method = RequestMethod.POST, value = "/paymentTransactionGateway")
	public ModelAndView paymentTransactionGateway(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("paymentTransactionGateway ...Controller");
		return paymentGatewayService.paymentResponseRevertBackFromBank(req, sn);
	}

}
