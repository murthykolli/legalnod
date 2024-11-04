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
import com.legalnod.service.DocCenterService;

/**
 * @author MurthyK
 *
 */
public class DocCenterServiceImpl implements DocCenterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DocCenterServiceImpl.class);
    
    private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";
    private String userNameInSn = "userNameInSn";
    private String allStateList = "stateList";
    
    @Autowired
    private DropdownStateDAOImpl dropdownStateDAOImpl;

    @Override
    @Transactional
    public ModelAndView docCenterHome(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("docCenterHome...Service");        
        ModelAndView mav;
        if (sn.getAttribute("userNameInSn") != null) {            
            mav = new ModelAndView("docCenterAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("docCenter");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedLiabilityCompanyDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedLiabilityCompanyDoc...Service");                
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("LimitedLiabilityCompanyDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("LimitedLiabilityCompanyDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedPartnershipDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedPartnershipDoc...Service");                
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("LimitedPartnershipDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("LimitedPartnershipDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedLiabilityPartnershipDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedLiabilityPartnershipDoc...Service");                
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("LimitedLiabilityPartnershipDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("LimitedLiabilityPartnershipDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView professionalCorpDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("professionalCorpDoc...Service");                
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("ProfessionalCorpDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("ProfessionalCorpDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nonProfitCorpDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nonProfitCorpDoc...Service");                
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("NonProfitCorpDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("NonProfitCorpDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView cCorpDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("cCorpDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("CCorpDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("CCorpDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView sCorpDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("sCorpDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("SCorpDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("SCorpDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView soleProprietorshipForBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("soleProprietorshipForBS...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("soleProprietorshipForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("soleProprietorshipForBS");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView generalPartnershipForBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("generalPartnershipForBS...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("generalPartnershipForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("generalPartnershipForBS");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView foreignQualificationsDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("foreignQualificationsDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("ForeignQualificationsDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("ForeignQualificationsDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView amendmentsChangesDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("amendmentsChangesDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("AmendmentsChangesDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("AmendmentsChangesDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView dissolutionsTerminationsDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("dissolutionsTerminationsDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("DissolutionsTerminationsDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("DissolutionsTerminationsDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameChangeDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameChangeDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("NameChangeDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("NameChangeDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView conversionsDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("conversionsDoc...Service");
        String documentCategory = "Conversions";
        List statesList = dropdownStateDAOImpl.findByCategory(documentCategory);
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("ConversionsDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("ConversionsDoc");
        }
        mav.addObject(allStateList, statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameAvailabilityCheckDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameAvailabilityCheckDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("NameAvailabilityCheckDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("NameAvailabilityCheckDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameReservationDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameReservationDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("NameReservationDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("NameReservationDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView doingBusinessAsDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("doingBusinessAsDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("DoingBusinessAsDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("DoingBusinessAsDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView trademarkStateRegistrationForDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("trademarkStateRegistrationForDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("TrademarkStateRegistrationForDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("TrademarkStateRegistrationForDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView annualReportsDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("annualReportsDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("AnnualReportsDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("AnnualReportsDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView initialReportsDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("initialReportsDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("InitialReportsDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("InitialReportsDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView federalTaxIDDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("federalTaxIDDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("FederalTaxIDDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("FederalTaxIDDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView stateTaxIDDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("stateTaxIDDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("StateTaxIDDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("StateTaxIDDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView fzoApplicationDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("fzoApplicationDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("501c3ApplicationDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("501c3ApplicationDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView certificateOfGoodStandingForDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("certificateOfGoodStandingForDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("CertificateOfGoodStandingForDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("CertificateOfGoodStandingForDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView certifiedCopiesForDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("certifiedCopiesForDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("CertifiedCopiesForDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("CertifiedCopiesForDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView reinstatementOfBusinessForDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("reinstatementOfBusinessForDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("ReinstatementOfBusinessForDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("ReinstatementOfBusinessForDoc");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registeredAgentForDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("registeredAgentForDoc...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("RegisteredAgentForDocAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("RegisteredAgentForDoc");
        }
        return mav;
    }

//	Open New window Doc center
    @Override
    @Transactional
    public ModelAndView docCenterComBusHome(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("docCenterComBusHome...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/CompareBusinessNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedLiabilityCompanyNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedLiabilityCompanyNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/LimitedLiabilityCompanyNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedPartnershipNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedPartnershipNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/LimitedPartnershipNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedLiabilityPartnershipNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedLiabilityPartnershipNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/LimitedLiabilityPartnershipNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView professionalCorpNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("professionalCorpNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/ProfessionalCorporationNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nonProfitCorpNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nonProfitCorpNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/Non_ProfitCorporationNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView cCorpNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("cCorpNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/C_CorporationNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView sCorpNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("sCorpNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/S_CorporationNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView soleProprietorshipForNewBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("soleProprietorshipForNewBS...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/SoleproprietorShipNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView generalPartnershipForNewBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("generalPartnershipForNewBS...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/GeneralPartnershipNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView foreignQualificationsNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("foreignQualificationsNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/ForeignQualificationsNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView amendmentsChangesNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("amendmentsChangesNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/AmendmentsChangesdocal");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView dissolutionsTerminationsNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("dissolutionsTerminationsNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/Dissolutions_TerminationsNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameChangeNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameChangeNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/NameChangeNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView conversionsNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("conversionsNewDoc...Service");        
        List statesList = dropdownStateDAOImpl.findByCategory("Conversions");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/ConversionsNew");
        mav.addObject(allStateList, statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameAvailabilityCheckNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameAvailabilityCheckNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/NameAvailabilityCheckNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameReservationNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameReservationNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/NameReservationNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView doingBusinessAsNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("doingBusinessAsNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/DoingBusinessAsNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView trademarkStateRegistrationForNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("trademarkStateRegistrationForNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/TrademarkStateRegistration");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView annualReportsNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("annualReportsNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/AnnualReportsNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView initialReportsNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("initialReportsNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/InitialReportsNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView federalTaxIDNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("federalTaxIDNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/FederalTaxIdNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView stateTaxIDNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("stateTaxIDNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/StateTaxIdNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView fzoApplicationNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("fzoApplicationNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/501c3_ApplicationNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView certificateOfGoodStandingForNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("certificateOfGoodStandingForNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/CertificateOfGoodStandingNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView certifiedCopiesForNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("certifiedCopiesForNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/CertifiedCopiesNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView reinstatementOfBusinessForNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("reinstatementOfBusinessForNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/ReinstatementOfBusinessNew");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registeredAgentForNewDoc(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("registeredAgentForNewDoc...Service");
        ModelAndView mav = new ModelAndView("/docCenter/docCenterNewWindow/RegisteredAgentNew");
        return mav;
    }

}
