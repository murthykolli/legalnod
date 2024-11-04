package com.legalnod.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

/**
 * @author MurthyK
 *
 */

public interface DocCenterService {	
	
	public ModelAndView docCenterHome(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedLiabilityCompanyDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedPartnershipDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedLiabilityPartnershipDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView professionalCorpDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nonProfitCorpDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView cCorpDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView sCorpDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView soleProprietorshipForBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView generalPartnershipForBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView foreignQualificationsDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView amendmentsChangesDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView dissolutionsTerminationsDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameChangeDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView conversionsDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameAvailabilityCheckDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameReservationDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView doingBusinessAsDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView trademarkStateRegistrationForDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView annualReportsDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView initialReportsDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView federalTaxIDDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView stateTaxIDDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView fzoApplicationDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView certificateOfGoodStandingForDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView certifiedCopiesForDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView reinstatementOfBusinessForDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView registeredAgentForDoc(HttpServletRequest req, HttpSession sn);
	
//	New window open Service
	
	public ModelAndView docCenterComBusHome(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedLiabilityCompanyNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedPartnershipNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView limitedLiabilityPartnershipNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView professionalCorpNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nonProfitCorpNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView cCorpNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView sCorpNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView soleProprietorshipForNewBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView generalPartnershipForNewBS(HttpServletRequest req, HttpSession sn);

	public ModelAndView foreignQualificationsNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView amendmentsChangesNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView dissolutionsTerminationsNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameChangeNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView conversionsNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameAvailabilityCheckNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView nameReservationNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView doingBusinessAsNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView trademarkStateRegistrationForNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView annualReportsNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView initialReportsNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView federalTaxIDNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView stateTaxIDNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView fzoApplicationNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView certificateOfGoodStandingForNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView certifiedCopiesForNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView reinstatementOfBusinessForNewDoc(HttpServletRequest req, HttpSession sn);

	public ModelAndView registeredAgentForNewDoc(HttpServletRequest req, HttpSession sn);

}
