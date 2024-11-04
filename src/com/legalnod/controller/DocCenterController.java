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

import com.legalnod.service.DocCenterService;

/**
 * @author MurthyK
 *
 */

@Controller
public class DocCenterController {
	
	@Autowired
	private DocCenterService dcService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DocCenterController.class);
	
//	Doc Center Pages Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/docCenter")
	@ResponseBody
	public ModelAndView docCenter(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("docCenter ...Controller");
		return dcService.docCenterHome(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/LimitedLiabilityCompanyDoc")
	@ResponseBody
	public ModelAndView limitedLiabilityCompanyDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedLiabilityCompanyDoc ...Controller");
		return dcService.limitedLiabilityCompanyDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/LimitedPartnershipDoc")
	@ResponseBody
	public ModelAndView limitedPartnershipDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedPartnershipDoc ...Controller");
		return dcService.limitedPartnershipDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/LimitedLiabilityPartnershipDoc")
	@ResponseBody
	public ModelAndView limitedLiabilityPartnershipDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedLiabilityPartnershipDoc ...Controller");
		return dcService.limitedLiabilityPartnershipDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ProfessionalCorpDoc")
	@ResponseBody
	public ModelAndView professionalCorpDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("professionalCorpDoc ...Controller");
		return dcService.professionalCorpDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NonProfitCorpDoc")
	@ResponseBody
	public ModelAndView nonProfitCorpDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nonProfitCorpDoc ...Controller");
		return dcService.nonProfitCorpDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/CCorpDoc")
	@ResponseBody
	public ModelAndView cCorpDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("cCorpDoc ...Controller");
		return dcService.cCorpDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/SCorpDoc")
	@ResponseBody
	public ModelAndView sCorpDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("sCorpDoc ...Controller");
		return dcService.sCorpDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/soleProprietorshipForBS")
	@ResponseBody
	public ModelAndView soleProprietorshipForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("soleProprietorshipForBS ...Controller");
		return dcService.soleProprietorshipForBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/generalPartnershipForBS")
	@ResponseBody
	public ModelAndView generalPartnershipForBS(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("generalPartnershipForBS ...Controller");
		return dcService.generalPartnershipForBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ForeignQualificationsDoc")
	@ResponseBody
	public ModelAndView foreignQualificationsDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("foreignQualificationsDoc ...Controller");
		return dcService.foreignQualificationsDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/AmendmentsChangesDoc")
	@ResponseBody
	public ModelAndView amendmentsChangesDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("amendmentsChangesDoc ...Controller");
		return dcService.amendmentsChangesDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/DissolutionsTerminationsDoc")
	@ResponseBody
	public ModelAndView dissolutionsTerminationsDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("dissolutionsTerminationsDoc ...Controller");
		return dcService.dissolutionsTerminationsDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NameChangeDoc")
	@ResponseBody
	public ModelAndView nameChangeDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameChangeDoc ...Controller");
		return dcService.nameChangeDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ConversionsDoc")
	@ResponseBody
	public ModelAndView conversionsDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("conversionsDoc ...Controller");
		return dcService.conversionsDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NameAvailabilityCheckDoc")
	@ResponseBody
	public ModelAndView nameAvailabilityCheckDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameAvailabilityCheckDoc ...Controller");
		return dcService.nameAvailabilityCheckDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NameReservationDoc")
	@ResponseBody
	public ModelAndView nameReservationDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameReservationDoc ...Controller");
		return dcService.nameReservationDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/DoingBusinessAsDoc")
	@ResponseBody
	public ModelAndView doingBusinessAsDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("doingBusinessAsDoc ...Controller");
		return dcService.doingBusinessAsDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/TrademarkStateRegistrationForDoc")
	@ResponseBody
	public ModelAndView trademarkStateRegistrationForDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("trademarkStateRegistrationForDoc ...Controller");
		return dcService.trademarkStateRegistrationForDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/AnnualReportsDoc")
	@ResponseBody
	public ModelAndView annualReportsDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("annualReportsDoc ...Controller");
		return dcService.annualReportsDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/InitialReportsDoc")
	@ResponseBody
	public ModelAndView initialReportsDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("initialReportsDoc ...Controller");
		return dcService.initialReportsDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/FederalTaxIDDoc")
	@ResponseBody
	public ModelAndView federalTaxIDDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("federalTaxIDDoc ...Controller");
		return dcService.federalTaxIDDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/StateTaxIDDoc")
	@ResponseBody
	public ModelAndView stateTaxIDDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("stateTaxIDDoc ...Controller");
		return dcService.stateTaxIDDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/501c3ApplicationDoc")
	@ResponseBody
	public ModelAndView fzoAppController(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("fzoAppController ...Controller");
		return dcService.fzoApplicationDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/CertificateOfGoodStandingForDoc")
	@ResponseBody
	public ModelAndView certificateOfGoodStandingForDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("certificateOfGoodStandingForDoc ...Controller");
		return dcService.certificateOfGoodStandingForDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/CertifiedCopiesForDoc")
	@ResponseBody
	public ModelAndView certifiedCopiesForDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("certifiedCopiesForDoc ...Controller");
		return dcService.certifiedCopiesForDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ReinstatementOfBusinessForDoc")
	@ResponseBody
	public ModelAndView reinstatementOfBusinessForDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("reinstatementOfBusinessForDoc ...Controller");
		return dcService.reinstatementOfBusinessForDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/RegisteredAgentForDoc")
	@ResponseBody
	public ModelAndView registeredAgentForDoc(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("registeredAgentForDoc ...Controller");
		return dcService.registeredAgentForDoc(req, sn);
	}
	
	
	
//	Doc Center Open New windows Pages Controller Actions
	
	@RequestMapping(method = RequestMethod.GET, value = "/docCenterComBus")
	@ResponseBody
	public ModelAndView docCenterComBus(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("docCenterComBus ...Controller");
		return dcService.docCenterComBusHome(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/LimitedLiabilityCompanyDocNW")
	@ResponseBody
	public ModelAndView limitedLiabilityCompanyDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedLiabilityCompanyDocNW ...Controller");
		return dcService.limitedLiabilityCompanyNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/LimitedPartnershipDocNW")
	@ResponseBody
	public ModelAndView limitedPartnershipDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedPartnershipDocNW ...Controller");
		return dcService.limitedPartnershipNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/LimitedLiabilityPartnershipDocNW")
	@ResponseBody
	public ModelAndView limitedLiabilityPartnershipDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("limitedLiabilityPartnershipDocNW ...Controller");
		return dcService.limitedLiabilityPartnershipNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ProfessionalCorpDocNW")
	@ResponseBody
	public ModelAndView professionalCorpDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("professionalCorpDocNW ...Controller");
		return dcService.professionalCorpNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NonProfitCorpDocNW")
	@ResponseBody
	public ModelAndView nonProfitCorpDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nonProfitCorpDocNW ...Controller");
		return dcService.nonProfitCorpNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/CCorpDocNW")
	@ResponseBody
	public ModelAndView cCorpDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("cCorpDocNW ...Controller");
		return dcService.cCorpNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/SCorpDocNW")
	@ResponseBody
	public ModelAndView sCorpDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("sCorpDocNW ...Controller");
		return dcService.sCorpNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/soleProprietorshipForBSNW")
	@ResponseBody
	public ModelAndView soleProprietorshipForBSNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug(" soleProprietorshipForBSNW...Controller");
		return dcService.soleProprietorshipForNewBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/generalPartnershipForBSNW")
	@ResponseBody
	public ModelAndView generalPartnershipForBSNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("generalPartnershipForBSNW ...Controller");
		return dcService.generalPartnershipForNewBS(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ForeignQualificationsDocNW")
	@ResponseBody
	public ModelAndView foreignQualificationsDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("foreignQualificationsDocNW ...Controller");
		return dcService.foreignQualificationsNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/AmendmentsChangesDocNW")
	@ResponseBody
	public ModelAndView amendmentsChangesDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("amendmentsChangesDocNW ...Controller");
		return dcService.amendmentsChangesNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/DissolutionsTerminationsDocNW")
	@ResponseBody
	public ModelAndView dissolutionsTerminationsDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("dissolutionsTerminationsDocNW ...Controller");
		return dcService.dissolutionsTerminationsNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NameChangeDocNW")
	@ResponseBody
	public ModelAndView nameChangeDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameChangeDocNW ...Controller");
		return dcService.nameChangeNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ConversionsDocNW")
	@ResponseBody
	public ModelAndView conversionsDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("conversionsDocNW ...Controller");
		return dcService.conversionsNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NameAvailabilityCheckDocNW")
	@ResponseBody
	public ModelAndView nameAvailabilityCheckDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameAvailabilityCheckDocNW ...Controller");
		return dcService.nameAvailabilityCheckNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/NameReservationDocNW")
	@ResponseBody
	public ModelAndView nameReservationDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("nameReservationDocNW ...Controller");
		return dcService.nameReservationNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/DoingBusinessAsDocNW")
	@ResponseBody
	public ModelAndView doingBusinessAsDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("doingBusinessAsDocNW ...Controller");
		return dcService.doingBusinessAsNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/TrademarkStateRegistrationDocNW")
	@ResponseBody
	public ModelAndView trademarkStateRegistrationDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("trademarkStateRegistrationDocNW ...Controller");
		return dcService.trademarkStateRegistrationForNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/AnnualReportsDocNW")
	@ResponseBody
	public ModelAndView annualReportsDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("annualReportsDocNW ...Controller");
		return dcService.annualReportsNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/InitialReportsDocNW")
	@ResponseBody
	public ModelAndView initialReportsDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("initialReportsDocNW ...Controller");
		return dcService.initialReportsNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/FederalTaxIDDocNW")
	@ResponseBody
	public ModelAndView federalTaxIDDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("federalTaxIDDocNW ...Controller");
		return dcService.federalTaxIDNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/StateTaxIdDocNW")
	@ResponseBody
	public ModelAndView stateTaxIdDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("stateTaxIdDocNW ...Controller");
		return dcService.stateTaxIDNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/501c3ApplicationDocNW")
	@ResponseBody
	public ModelAndView fZOApplicationDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("fZOApplicationDocNW ...Controller");
		return dcService.fzoApplicationNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/CertificateOfGoodStandingDocNW")
	@ResponseBody
	public ModelAndView certificateOfGoodStandingDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("certificateOfGoodStandingDocNW ...Controller");
		return dcService.certificateOfGoodStandingForNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/CertifiedCopiesDocNW")
	@ResponseBody
	public ModelAndView certifiedCopiesDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("certifiedCopiesDocNW ...Controller");
		return dcService.certifiedCopiesForNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ReinstatementOfBusinessDocNW")
	@ResponseBody
	public ModelAndView reinstatementOfBusinessDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("reinstatementOfBusinessDocNW ...Controller");
		return dcService.reinstatementOfBusinessForNewDoc(req, sn);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/RegisteredAgentDocNW")
	@ResponseBody
	public ModelAndView registeredAgentDocNW(HttpServletRequest req, HttpSession sn) {
		LOGGER.debug("registeredAgentDocNW ...Controller");
		return dcService.registeredAgentForNewDoc(req, sn);
	}
	

	

}
