/**
 *
 */
package com.legalnod.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.daoimpl.AdditionalFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.AdditionalFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.AllFederalFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.BusinessFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.BusinessFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.DropdownStateDAOImpl;
import com.legalnod.daoimpl.FederalFormsPriceInfoDAOImpl;
import com.legalnod.daoimpl.NameAvailabilityCheckSavingDAOImpl;
import com.legalnod.daoimpl.StateFormsPriceInfoDAOImpl;
import com.legalnod.daoimpl.StateTaxFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.StateTaxFormsAttributesInfoDAOImpl;
import com.legalnod.service.BusinessServicesService;
import com.legalnod.model.AdditionalFormsAttributesAndValuesSaving;
import com.legalnod.model.AdditionalFormsAttributesInfo;
import com.legalnod.model.AllFederalFormsDataSaving;
import com.legalnod.model.AllStateFormsDataSaving;
import com.legalnod.model.BusinessFormsAttributesAndValuesSaving;
import com.legalnod.model.BusinessFormsAttributesInfo;
import com.legalnod.model.FederalFormsPriceInfo;
import com.legalnod.model.Forms;
import com.legalnod.model.NameAvailabilityCheckSaving;
import com.legalnod.model.StateFormsPriceInfo;
import com.legalnod.model.StateTaxFormsAttributesAndValuesSaving;
import com.legalnod.model.StateTaxFormsAttributesInfo;

/**
 * @author MurthyK
 *
 */
public class BusinessServicesServiceImpl implements BusinessServicesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusinessServicesServiceImpl.class);
    
    private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";
    private String userNameInSn = "userNameInSn";
    private String userName = "userName";
    private String userChoiceInSn = "userChoiceInSn";    
    private String formNameInSn = "formNameInSn";
    private String formName = "formName";
    private String stateNameInSn = "stateNameInSn";
    private String stateName = "stateName";
    private String formIdInSn = "formIdInSn";
    private String userIdInSn = "userIdInSn";
    private String businessForm = "Business Forms";
    private String newStateFormsCreation = "newStateFormCreation";
    private String attribTextFieldList = "attributeTextFieldList";
    private String attribTextFieldAddrList = "attributeTextFieldAddrList";
    private String attribTextFieldZipList = "attributeTextFieldZipList";
    private String attribTextAreaList = "attributeTextAreaList";
    private String attribSelectBoxList = "attributeSelectBoxList";
    private String attribTextFieldDateList = "attributeTextFieldDateList";
    private String radioButtList = "radioButtonList";
    private String checkBoxesList = "checkBoxList";    
    private String additionalForm = "Additional Forms";
    private String addSerFormModification = "additionalSerFormModification";
    private String textFieldsList = "textFieldList";
    private String textAreasList = "textAreaList";
    private String dateFieldsList = "dateFieldList";
    private String selectBoxesList = "selectBoxList";
    private String zipCodesList = "zipCodeList";      
    private String radioButStatus = "RadioButtonStatus";
    private String attReqiTypeIdsInSn = "attrReqTypeIdsInSn";    
    private String stateFormsPageValue = "stateFormPageValues";
    private String stateTaxIdForm = "State Tax ID Forms";
    private String stTaxIdFormModification = "stateTaxIdFormModification";
    private String jSonFormName = "formname";
    private String jSonFormCategory = "formCategory";
        
    @Autowired
    private DropdownStateDAOImpl dropdownStateDAOImpl;

    @Autowired
    private NameAvailabilityCheckSavingDAOImpl nameCheckDAOImpl;

    @Autowired
    private BusinessFormsAttributesAndValuesSavingDAOImpl bsFormAndStateValDAOImpl;

    @Autowired
    private BusinessFormsAttributesInfoDAOImpl bsFormAndStateAttrInfoDAOImpl;

    @Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;
    
    @Autowired
    private AllFederalFormsDataSavingDAOImpl allFederalFormsSavingDAOImpl;

    @Autowired
    private AdditionalFormsAttributesInfoDAOImpl additionalFormsAttrInfoDAOImpl;

    @Autowired
    private AdditionalFormsAttributesAndValuesSavingDAOImpl addSerFormAttrAndValSavingDAOImpl;

    @Autowired
    private StateTaxFormsAttributesInfoDAOImpl stateTaxFormsAttrInfoDAOImpl;

    @Autowired
    private StateTaxFormsAttributesAndValuesSavingDAOImpl stateTaxFormsAttrAndValuesSavingDAOImpl;
    
    @Autowired
    private UsersInformationServiceImpl usersInformationServiceImpl;
    
    @Autowired
    private StateFormsPriceInfoDAOImpl stateFormsPriceInfoDAOImpl;
    
    @Autowired
    private FederalFormsPriceInfoDAOImpl federalFormsPriceInfoDAOImpl;

//	Business Services Home Pages Service Implementation Actions
    @Override
    @Transactional
    public ModelAndView userProfileHome(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("userProfileHome...Service");        
        List<AllStateFormsDataSaving> stateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.editUPStateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));
        List<AllFederalFormsDataSaving> federalFormsSavingInfoList = allFederalFormsSavingDAOImpl.editUPFederalFormsSavingDataTakeFromDB((String) sn.getAttribute(userNameInSn));
        int stCount = stateFormsSavingInfiList.size();
        int fedCount = federalFormsSavingInfoList.size();
        ModelAndView mav;
        if(sn.getAttribute(userNameInSn) != null){
        mav = new ModelAndView("editUserProfile");
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject("lastName", sn.getAttribute("lastNameInSn"));
        mav.addObject(userName, sn.getAttribute(userNameInSn));
        mav.addObject("userProfileSateRefVal", stCount);
        mav.addObject("userProfileFedRefVal", fedCount);
        } else{
        	mav = usersInformationServiceImpl.logInHome(req, sn);
        }
        return mav;        
    }

//	Business Services Home Pages Service Implementation Actions
    @Override
    @Transactional
    public ModelAndView busAdditionalServicesHide(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busAdditionalServicesHide...Service");                    
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {            
            mav = new ModelAndView("minBsAdditionalServicesAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("minBsAdditionalServices");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busAdditionalServicesShow(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busAdditionalServicesShow...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {                        
            mav = new ModelAndView("bsAdditionalServicesAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("bsAdditionalServices");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busComplianceHide(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busComplianceHide...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {                        
            mav = new ModelAndView("minBsComplaintsAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("minBsComplaints");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busComplianceShow(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busComplianceShow...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {                        
            mav = new ModelAndView("bsComplaintsAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("bsComplaints");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busFormingYourBusinessHide(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busFormingYourBusinessHide...Service");                
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {                        
            mav = new ModelAndView("minBsFormingYrBusAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("minBsFormingYrBus");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busFormingYourBusinessShow(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busFormingYourBusinessShow...Service");              
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {                        
            mav = new ModelAndView("businessServicesAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("businessServices");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busManagingYourBusinessHide(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busManagingYourBusinessHide...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {                        
            mav = new ModelAndView("minBsManagingYourBusinessAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("minBsManagingYourBusiness");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busManagingYourBusinessShow(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busManagingYourBusinessShow...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("bsManagingYourBusinessAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("bsManagingYourBusiness");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busNamingYourBusinessHide(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busNamingYourBusinessHide...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("minBsNamingYourBusinessAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("minBsNamingYourBusiness");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busNamingYourBusinessShow(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busNamingYourBusinessShow...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("bsNamingYourBusinessAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("bsNamingYourBusiness");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busTrademarkHide(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busTrademarkHide...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("minBsTrademarkAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("minBsTrademark");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView busTrademarkShow(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busTrademarkShow...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("bsTrademarkAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("bsTrademark");
        }
        return mav;
    }

//	Business Services Drop down Pages Service Implementation Actions
    @Override
    @Transactional
    public ModelAndView limitedLiabilityCompanyBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedLiabilityCompanyBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("LLC");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("limitedLiabilityCompanyForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("limitedLiabilityCompanyForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedPartnershipBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedPartnershipBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("LP");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("limitedPartnershipForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("limitedPartnershipForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView limitedLiabilityPartnershipBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("limitedLiabilityPartnershipBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("LLP");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("limitedLiabilityPartnershipForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("limitedLiabilityPartnershipForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView professionalCorpBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("professionalCorpBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("PC");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("professionalCorporationForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("professionalCorporationForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nonProfitCorpBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nonProfitCorpBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("NPC");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("nonProfitCorporationForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("nonProfitCorporationForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView cCorpBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("cCorpBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("CCorp");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("cCorporationForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("cCorporationForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView sCorpBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("sCorpBS...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("sCorporationForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("sCorporationForBS");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView foreignQualificationsBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("foreignQualificationsBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("FQ");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("foreignQualificationsForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("foreignQualificationsForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView amendmentsChangesBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("amendmentsChangesBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("AC");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("amendmentsForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("amendmentsForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView dissolutionsTerminationsBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("dissolutionsTerminationsBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("DT");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("dissolutionsOrTerminationsForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("dissolutionsOrTerminationsForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameChangeBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameChangeBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("NC");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("nameChangeForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("nameChangeForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView conversionsBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("conversionsBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("Conversions");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("conversionsForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("conversionsForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameAvailabilityCheckBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameAvailabilityCheckBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("NAC");
        List companyFormingList = dropdownStateDAOImpl.findByNameCheckListProperty();
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("nameAvailabilityCheckForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("nameAvailabilityCheckForBS");
        }
        mav.addObject("stateList", statesList);
        mav.addObject("companyFormingList", companyFormingList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView nameReservationBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameReservationBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("NR");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("nameReservationForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("nameReservationForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView doingBusinessAsBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("doingBusinessAsBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("DBA");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("doingBusinessAsForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("doingBusinessAsForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView trademarkStateRegistrationForBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("trademarkStateRegistrationForBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("Trademark");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("trademarkStateRegistrationForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("trademarkStateRegistrationForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView annualReportsBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("annualReportsBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("AR");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("annualReportsForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("annualReportsForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView initialReportsBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("initialReportsBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("IR");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("initialReportsForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("initialReportsForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView federalTaxIDBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("federalTaxIDBS...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("federalTaxIDForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("federalTaxIDForBS");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView stateTaxIDBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("stateTaxIDBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("StateTaxId");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("asStateTaxIDAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("asStateTaxID");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView fzoApplicationBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("fzoApplicationBS...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("fiveZeroOneApplicationForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("fiveZeroOneApplicationForBS");
        }
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView certificateOfGoodStandingForBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("certificateOfGoodStandingForBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("COGS");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("certificateOfGoodStandingForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("certificateOfGoodStandingForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView certifiedCopiesForBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("certifiedCopiesForBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("CC");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("certifiedCopiesForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("certifiedCopiesForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView reinstatementOfBusinessForBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("reinstatementOfBusinessForBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("ROB");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("reinstatementOfBusinessForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("reinstatementOfBusinessForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView registeredAgentForBS(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("registeredAgentForBS...Service");
        ModelAndView mav;
        List statesList = dropdownStateDAOImpl.findByCategory("RA");
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("registeredAgentForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("registeredAgentForBS");
        }
        mav.addObject("stateList", statesList);
        return mav;
    }

//	Dropdown Json calling select Form Name with State Name Service
    @Override
    @Transactional
    public JSONArray selectFormNamesWithStateNameData(String selectedCat) {
    	LOGGER.debug("selectFormNamesWithStateNameData...Service");
        String[] roleName = selectedCat.split(" _ ");
        List<Forms> formsList = dropdownStateDAOImpl.findByAllFormsListProperty(roleName[0], roleName[1]);
        JSONArray forms = new JSONArray();
        for (Forms form : formsList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(jSonFormName, form.getFormName());
            forms.add(jsonObj);
        }
        return forms;
    }

    @Override
    @Transactional
    public JSONArray selectFormNamesWithStateNameFQData(String selectedCat) {
    	LOGGER.debug("selectFormNamesWithStateNameFQData...Service");
        String[] roleName = selectedCat.split(" _ ");
        List<Forms> formsList = dropdownStateDAOImpl.findByFQFormsListProperty(roleName[0], roleName[1]);
        JSONArray forms = new JSONArray();
        for (Forms form : formsList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(jSonFormName, form.getFormName());
            forms.add(jsonObj);
        }
        return forms;
    }

    @Override
    @Transactional
    public JSONArray selectCategoryNamesWithStateNameData(String selectedCat) {
    	LOGGER.debug("selectCategoryNamesWithStateNameData...Service");
        String[] roleName = selectedCat.split(" _ ");
        List<Forms> formsList = dropdownStateDAOImpl.findByCategoriesListProperty(roleName[0], roleName[1]);
        JSONArray forms = new JSONArray();
        for (Forms form : formsList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(jSonFormCategory, form.getDocBusinessCategory());
            forms.add(jsonObj);
        }
        return forms;
    }

    @Override
    @Transactional
    public JSONArray selectFormNamesWithCatAndStateNameData(String selectedCat) {
    	LOGGER.debug("selectFormNamesWithCatAndStateNameData...Service");
        String[] roleName = selectedCat.split(" _ ");
        List<Forms> formsList = dropdownStateDAOImpl.findByFormsListWithCatAndStatesProperty(roleName[0], roleName[1]);
        JSONArray forms = new JSONArray();
        for (Forms form : formsList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(formName, form.getFormName());
            forms.add(jsonObj);
        }
        return forms;
    }

    @Override
    @Transactional
    public JSONArray serviceByStateCategorySelectionData(String selectedStateName) {
    	LOGGER.debug("serviceByStateCategorySelectionData...Service");
        List<Forms> formsList = dropdownStateDAOImpl.findServiceByStateCatategoryProperty(selectedStateName);
        JSONArray forms = new JSONArray();
        for (Forms form : formsList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(jSonFormCategory, form.getDocCategory());
            forms.add(jsonObj);
        }
        return forms;
    }

    @Override
    @Transactional
    public JSONArray serviceByStateFormDataSelection(String selectedCat) {
    	LOGGER.debug("serviceByStateFormDataSelection...Service");
        String[] roleName = selectedCat.split(" _ ");
        List<Forms> formsList = dropdownStateDAOImpl.findServiceByStateFormProperty(roleName[0], roleName[1]);
        JSONArray forms = new JSONArray();
        for (Forms form : formsList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(formName, form.getFormName());
            forms.add(jsonObj);
        }
        return forms;
    }

//	Footer Privacy Policy And Terms And Conditions Service Implementation
    @Override
    @Transactional
    public ModelAndView privacyPolicyInfo() {
    	LOGGER.debug("privacyPolicyInfo...Service");
        ModelAndView mav = new ModelAndView("/layouts/footer_PrivacyPolicy");
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView termsAndConditionsInfo() {
    	LOGGER.debug("privacyPolicyInfo...Service");
        ModelAndView mav = new ModelAndView("/layouts/footer_TermsAndConditions");
        return mav;
    }

//	Name Availability Check Form Info saving Service Implementation
    @Override
    @Transactional
    public ModelAndView nameAvailabilityCheckInfoSave(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("nameAvailabilityCheckInfoSave...Service");
        String businessState = req.getParameter(stateName);
        String companyForming = req.getParameter(formName);
        String description = req.getParameter("comment");
        String businessName = req.getParameter("formNames");
        String alternateName1 = req.getParameter("contactFName");
        String alternateName2 = req.getParameter("contactLName");
        String alternateName3 = req.getParameter("contactAddr2");
        String alternateName4 = req.getParameter("contactCity");
        String contactEmail = req.getParameter("contactEmail");
        LOGGER.info("businessState : "+businessState+"companyForming : "+companyForming+"description : "+description);
        LOGGER.info("businessName : "+businessName+"alternateName1 : "+alternateName1+"alternateName2 : "+alternateName2);
        LOGGER.info("alternateName3 : "+alternateName3+"alternateName4 : "+alternateName4+"contactEmail : "+contactEmail);
        java.util.Date date = new java.util.Date();
        Timestamp createdDate = new Timestamp(date.getTime());
        NameAvailabilityCheckSaving nameCheAvaModel = new NameAvailabilityCheckSaving();
        nameCheAvaModel.setUserEmail(contactEmail);
        nameCheAvaModel.setBusinessState(businessState);
        nameCheAvaModel.setCompanyForming(companyForming);
        nameCheAvaModel.setDescription(description);
        nameCheAvaModel.setBusinessName(businessName);
        nameCheAvaModel.setAlternateName1(alternateName1);
        nameCheAvaModel.setAlternateName2(alternateName2);
        nameCheAvaModel.setAlternateName3(alternateName3);
        nameCheAvaModel.setAlternateName4(alternateName4);
        nameCheAvaModel.setCreatedDate(createdDate);
        nameCheckDAOImpl.save(nameCheAvaModel);
        List statesList = dropdownStateDAOImpl.findByCategory("NAC");
        List companyFormingList = dropdownStateDAOImpl.findByNameCheckListProperty();
        ModelAndView mav;        
        EmailSending userEmail = new EmailSending();        
        String aTo = "contactus@legalnod.com";        
        String altName1 = null;
        String altName2 = null;
        String altName3 = null;
        String altName4 = null;        
        if(alternateName1 != null ){
        altName1 = "<b>Alternate Name #1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b> "+"<b>: </b>"+String.valueOf(alternateName1)+" <br/><br/> ";
        }
        if(alternateName2 != null ){
        altName2 = "<b>Alternate Name #2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b> "+"<b>: </b>"+String.valueOf(alternateName2)+" <br/><br/> ";
        }
        if(alternateName3 != null ){
        altName3 = "<b>Alternate Name #3&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b> "+"<b>: </b>"+String.valueOf(alternateName3)+" <br/><br/> ";
        }
        if(alternateName4 != null ){
        altName4 = "<b>Alternate Name #4&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b> "+"<b>: </b>"+String.valueOf(alternateName4)+" <br/><br/> ";
        }        
        String body = "<body> <div style='margin-left: 68px;margin-top:10px;background: #f1f1f1;width: 650px;box-shadow: 3px 3px 0px #7e7e7e;height:auto;'> "
                + "<div style='background: #666666;height: 35px;width:651px;margin-top:-3px;position:absolute;'>"
                + "<p style='margin-left: 20px; margin-top: 6px; text-align: justify; color: white;font-size:20px;font-family:Cambria;position:absolute;'> LegalNod <font color='yellow'>-</font> Name Availability Check</p> "
                + "</div> "
                + "<div style='margin-left: 20px; margin-top: 20px; width: 600px; height: auto;font: 1.0em/1.26em sans-serif;text-align: justify;'> <br/><br/><br/>"
                + "<b>State Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b> " + businessState + " <br/><br/> "
                + "<b>Type of Company&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b> " + companyForming + " <br/><br/> "
                + "<b>Business Description&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b> " + description + " <br/><br/> "
                + "<b>Name of your Business&nbsp;&nbsp;&nbsp;&nbsp; :</b> " + businessName + " <br/><br/> "
                + altName1+altName2+altName3+altName4
                +"<b>Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :</b> " +  contactEmail + " <br/><br/> "
                + "</div><br/><br/></div>"
                + "</body> ";
    String type = "text/html";    
    try {
        userEmail.sendEmail(aTo, "Name Availability Check", body, type, "nameavailabilitycheck@legalnod.com");
    } catch (Exception ex) {
    	LOGGER.error("Name Availability Check Saving " + ex);
    }        
        if (sn.getAttribute(userNameInSn) != null) {
            mav = new ModelAndView("nameAvailabilityCheckForBSAL");
            mav.addObject(firstName, sn.getAttribute(firstNameInSn));
            mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        } else {
            mav = new ModelAndView("nameAvailabilityCheckForBS");
        }
        mav.addObject("nameAvailabilityCheck", "NameAvailabilityCheck");
        mav.addObject("stateList", statesList);
        mav.addObject("companyFormingList", companyFormingList);
        return mav;
    }
    
//	New All Form Creation Service
    @Override
    @Transactional
    public ModelAndView newAllFormSelectionFromDB(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("newAllFormSelectionFromDB...Service");       
        ModelAndView mav = new ModelAndView();        
//    	Form Id getting from DB
        List<Forms> stFormId = bsFormAndStateAttrInfoDAOImpl.stateFormsIdValueFromDB(req.getParameter(stateName), req.getParameter(formName));
        int formId = 0; 
        String typeOfRefDocument = null;
        for (Forms formsInfo : stFormId) {
            formId = formsInfo.getFormId();
            typeOfRefDocument = formsInfo.getTypeOfDocument();
        }
        sn.setAttribute("typeOfRefDocumentInSn", typeOfRefDocument);
        sn.setAttribute("formIdInSn", formId);
        sn.setAttribute("stateNameInSn", req.getParameter(stateName));
        sn.setAttribute("formNameInSn", req.getParameter(formName));        
        if (sn.getAttribute(userNameInSn) != null) { 
        if (("Business Services").equals(typeOfRefDocument)) {
            mav = newStateFormSelectionFromDB(req, sn);
        } else if (("Additional Services").equals(typeOfRefDocument)) {
            mav = newAdditionalServiceFormSelectionFromDB(req, sn);
        } else if (("State Tax ID").equals(typeOfRefDocument)) {
            mav = newStateTaxIdFormSelectionFromDB(req, sn);
        }        
        } else {
            mav = new ModelAndView("loginPage");
        }
        mav.addObject(stateName, req.getParameter(stateName));
        mav.addObject(formName, req.getParameter(formName));
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));        
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }
   
//	New State Form Creation Service
    @Override
    @Transactional
    public ModelAndView newStateFormSelectionFromDB(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("newStateFormSelectionFromDB...Service");
        ModelAndView mav;        
//			Required values take from DB
            List<BusinessFormsAttributesInfo> busFormAttrList = bsFormAndStateAttrInfoDAOImpl.stateFormDynamicFormShowHideData((Integer) sn.getAttribute(formIdInSn));
            List attRequiredList = new ArrayList();
            List attRadioStatusList = new ArrayList();
            List innerRadioList = new ArrayList();
            List addAnotherList = new ArrayList();
            for (BusinessFormsAttributesInfo busFormsAttInfo : busFormAttrList) {
                attRequiredList.add(busFormsAttInfo.getRequiredType());
                attRadioStatusList.add(busFormsAttInfo.getRadioButtonStatus());
                innerRadioList.add(busFormsAttInfo.getRadioButtonIdStatus());
                addAnotherList.add(busFormsAttInfo.getAddAnotherRbstatus());
            }
            sn.setAttribute("Attribute_Required_List", attRequiredList);
            sn.setAttribute("Attribute_RadioStatus_List", attRadioStatusList);
            sn.setAttribute("Attribute_InnerRadio_List", innerRadioList);
            sn.setAttribute("Attribute_AddAnother_List", addAnotherList);
//		    State form attribute fields and values take from DB this is simple join method
            List<Object> formFieldsAndValues = (List<Object>) bsFormAndStateAttrInfoDAOImpl.busStateFormsDynamicFieldsAndValues((Integer) sn.getAttribute(formIdInSn));
            List attrId = new ArrayList();
            List attrType = new ArrayList();
            List attNames = new ArrayList();
            List attValue = new ArrayList();
            Iterator formFieldsAndValuesIterator = formFieldsAndValues.iterator();
            while (formFieldsAndValuesIterator.hasNext()) {
                Object[] formFieldsAndValuesObj = (Object[]) formFieldsAndValuesIterator.next();
                String attrbId = String.valueOf(formFieldsAndValuesObj[0]);
                String attrbType = String.valueOf(formFieldsAndValuesObj[1]);
                String attrbName = String.valueOf(formFieldsAndValuesObj[2]);
                String attrbValue = String.valueOf(formFieldsAndValuesObj[3]);
                attrId.add(attrbId);
                attrType.add(attrbType);
                attNames.add(attrbName.replace("null", ""));
                attValue.add(attrbValue.replace("null", ""));
            }

            sn.setAttribute("Attribute_Names_List", attNames);
            sn.setAttribute("Attribute_Values_List", attValue);
//			State forms Attribute Required type Ids take from DB 
            List<Object> attrReqTypeIdsList = (List<Object>) bsFormAndStateAttrInfoDAOImpl.attributeReqTypeIDsList((Integer) sn.getAttribute(formIdInSn));
            String attrReqTypeIds = attrReqTypeIdsList.toString();
            attrReqTypeIds = attrReqTypeIds.replace("[", "");
            attrReqTypeIds = attrReqTypeIds.replace("]", "");
//			Radio Button Status take from DB 			
            List<Object> radioButtonStatus = (List<Object>) bsFormAndStateAttrInfoDAOImpl.stateFormRadioButtonStatus((Integer) sn.getAttribute(formIdInSn));
//			Form Modification Code            
            List<AllStateFormsDataSaving> stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsUserChoiceFromDB((String)sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), "In Progress");
            String userChoiceInDB = null;
            for (AllStateFormsDataSaving stateFormDataModel : stateFormsModel) {
                userChoiceInDB = stateFormDataModel.getUserChoice();
            }
            if (userChoiceInDB != null) {
                List<BusinessFormsAttributesAndValuesSaving> busStFormAttrAndValModel = bsFormAndStateValDAOImpl.findByallStateFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), (Integer) sn.getAttribute(formIdInSn), userChoiceInDB);
                String capturedInfoInDB = null;
                for (BusinessFormsAttributesAndValuesSaving stateFormAttrAndValModel : busStFormAttrAndValModel) {
                    capturedInfoInDB = stateFormAttrAndValModel.getCapturedInformation();
                }
                JSONParser parser = new JSONParser();
                JSONObject capInfoJsonObject = new JSONObject();
                try {
                    Object parseObj = parser.parse(capturedInfoInDB);
                    capInfoJsonObject = (JSONObject) parseObj;
                } catch (ParseException e) {
                	LOGGER.error("newStateFormSelectionFromDB " + e);
                }
                mav = newStateFormAttributesInfoSelection(capInfoJsonObject, req);
                AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String)sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), userChoiceInDB);
                String stateFormPageValues = stateFormsUpdateModel.getPageVariableReference();
                mav = new ModelAndView(newStateFormsCreation);
                sn.setAttribute(userChoiceInSn, userChoiceInDB);
                mav.addObject(attribTextFieldList, req.getAttribute(attribTextFieldList));
                mav.addObject(attribTextFieldAddrList, req.getAttribute(attribTextFieldAddrList));
                mav.addObject(attribTextFieldZipList, req.getAttribute(attribTextFieldZipList));
                mav.addObject(attribTextAreaList, req.getAttribute(attribTextAreaList));
                mav.addObject(attribTextFieldDateList, req.getAttribute(attribTextFieldDateList));
                mav.addObject(attribSelectBoxList, req.getAttribute(attribSelectBoxList));
                mav.addObject(radioButtList, req.getAttribute(radioButtList));
                mav.addObject(checkBoxesList, req.getAttribute(checkBoxesList));                
                mav.addObject(stateFormsPageValue, stateFormPageValues);
            } else {
                mav = new ModelAndView(newStateFormsCreation);
                sn.setAttribute(userChoiceInSn, null);
            }            
            mav.addObject(radioButStatus, radioButtonStatus);            
            sn.setAttribute(radioButStatus, radioButtonStatus);
            sn.setAttribute(attReqiTypeIdsInSn, attrReqTypeIds);             
        return mav;
    }
    
//	New Business Services Forms Attributes Info Selection
    @Override
    @Transactional
    public ModelAndView newStateFormAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req) {
        LOGGER.debug("newStateFormAttributesInfoSelection...Service");
        ModelAndView mav = new ModelAndView();        
        String attributeTextFieldList = null;
        for (int i = 1; i <= 160; i++) {
            String keyVal = String.valueOf(i);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeTextFieldList = attributeTextFieldList + jSonObjVal + ",$,";
        }
        attributeTextFieldList = attributeTextFieldList.replace("null", "");
        String attributeTextFieldAddrList = null;
        for (int j = 161; j <= 205; j++) {
            String keyVal = String.valueOf(j);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeTextFieldAddrList = attributeTextFieldAddrList + jSonObjVal + ",$,";
        }
        attributeTextFieldAddrList = attributeTextFieldAddrList.replace("null", "");
        String attributeTextFieldZipList = null;
        for (int k = 206; k <= 285; k++) {
            String keyVal = String.valueOf(k);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeTextFieldZipList = attributeTextFieldZipList + jSonObjVal + ",$,";
        }
        attributeTextFieldZipList = attributeTextFieldZipList.replace("null", "");
        String attributeTextAreaList = null;
        for (int l = 286; l <= 325; l++) {
            String keyVal = String.valueOf(l);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            jSonObjVal = jSonObjVal.replaceAll("[\n\r]", " ");
            attributeTextAreaList = attributeTextAreaList + jSonObjVal + ",$,";
        }
        attributeTextAreaList = attributeTextAreaList.replace("null", "");
        String attributeSelectBoxList = null;
        for (int n = 326; n <= 375; n++) {
            String keyVal = String.valueOf(n);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeSelectBoxList = attributeSelectBoxList + jSonObjVal + ",$,";
        }
        attributeSelectBoxList = attributeSelectBoxList.replace("null", "");
        String attributeTextFieldDateList = null;
        for (int m = 376; m <= 415; m++) {
            String keyVal = String.valueOf(m);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeTextFieldDateList = attributeTextFieldDateList + jSonObjVal + ",$,";
        }
        attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");
        String checkBoxList = null;
        for (int p = 416; p <= 435; p++) {
            String keyVal = String.valueOf(p);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            checkBoxList = checkBoxList + jSonObjVal + ",$,";
        }
        checkBoxList = checkBoxList.replace("null", "");
        String radioButtonList = null;
        for (int o = 436; o <= 1035; o++) {
            String keyVal = String.valueOf(o);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            radioButtonList = radioButtonList + jSonObjVal + ",$,";
        }
        radioButtonList = radioButtonList.replace("null", "");        
        req.setAttribute(attribTextFieldList, attributeTextFieldList);
        req.setAttribute(attribTextFieldAddrList, attributeTextFieldAddrList);
        req.setAttribute(attribTextFieldZipList, attributeTextFieldZipList);
        req.setAttribute(attribTextAreaList, attributeTextAreaList);
        req.setAttribute(attribTextFieldDateList, attributeTextFieldDateList);
        req.setAttribute(attribSelectBoxList, attributeSelectBoxList);
        req.setAttribute(radioButtList, radioButtonList);
        req.setAttribute(checkBoxesList, checkBoxList);        
        return mav;
    }

//	New Additional Service Form Creation Service
    @Override
    @Transactional
    public ModelAndView newAdditionalServiceFormSelectionFromDB(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("newAdditionalServiceFormSelectionFromDB...Service");        
        ModelAndView mav;        
//			Required values take from DB
            List<AdditionalFormsAttributesInfo> addSerFormAttrList = additionalFormsAttrInfoDAOImpl.additionalServiceDynamicFormShowHideData((Integer) sn.getAttribute(formIdInSn));
            List attRequiredList = new ArrayList();
            List attRadioStatusList = new ArrayList();
            List innerRadioList = new ArrayList();
            List addAnotherList = new ArrayList();
            for (AdditionalFormsAttributesInfo asFormsAttInfo : addSerFormAttrList) {
                attRequiredList.add(asFormsAttInfo.getRequiredType());
                attRadioStatusList.add(asFormsAttInfo.getRadioButtonStatus());
                innerRadioList.add(asFormsAttInfo.getRadioButtonIdStatus());
                addAnotherList.add(asFormsAttInfo.getAddAnotherRbstatus());
            }
            sn.setAttribute("AS_Attribute_Required_List", attRequiredList);
            sn.setAttribute("AS_Attribute_RadioStatus_List", attRadioStatusList);
            sn.setAttribute("AS_Attribute_InnerRadio_List", innerRadioList);
            sn.setAttribute("AS_Attribute_AddAnother_List", addAnotherList);
//		    Additional Service form attribute fields and values take from DB this is simple join method
            List<Object> formFieldsAndValues = (List<Object>) additionalFormsAttrInfoDAOImpl.additionalServiceFormsDynamicFieldsAndValues((Integer) sn.getAttribute(formIdInSn));
            List attrId = new ArrayList();
            List attrType = new ArrayList();
            List attNames = new ArrayList();
            List attValue = new ArrayList();
            Iterator formFieldsAndValuesIterator = formFieldsAndValues.iterator();
            while (formFieldsAndValuesIterator.hasNext()) {
                Object[] formFieldsAndValuesObj = (Object[]) formFieldsAndValuesIterator.next();
                String attrbId = String.valueOf(formFieldsAndValuesObj[0]);
                String attrbType = String.valueOf(formFieldsAndValuesObj[1]);
                String attrbName = String.valueOf(formFieldsAndValuesObj[2]);
                String attrbValue = String.valueOf(formFieldsAndValuesObj[3]);
                attrId.add(attrbId);
                attrType.add(attrbType);
                attNames.add(attrbName.replace("null", ""));
                attValue.add(attrbValue.replace("null", ""));
            }
            sn.setAttribute("AS_Attribute_Names_List", attNames);
            sn.setAttribute("AS_Attribute_Values_List", attValue);
//			Additional Service forms Attribute Required type Ids take from DB 
            List<Object> attrReqTypeIdsList = (List<Object>) additionalFormsAttrInfoDAOImpl.addSerAttributeReqTypeIDsList((Integer) sn.getAttribute(formIdInSn));
            String attrReqTypeIds = attrReqTypeIdsList.toString();
            attrReqTypeIds = attrReqTypeIds.replace("[", "");
            attrReqTypeIds = attrReqTypeIds.replace("]", "");
//			Radio Button Status take from DB 			
            List<Object> radioButtonStatus = (List<Object>) additionalFormsAttrInfoDAOImpl.additionalServiceRadioButtonStatus((Integer) sn.getAttribute(formIdInSn));
//			Form Modification Code           
            List<AllStateFormsDataSaving> stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsUserChoiceFromDB((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), "In Progress");
            String userChoiceInDB = null;
            for (AllStateFormsDataSaving stateFormDataModel : stateFormsModel) {
                userChoiceInDB = stateFormDataModel.getUserChoice();
            }
            if (userChoiceInDB != null) {
                List<AdditionalFormsAttributesAndValuesSaving> addSerFormAttrAndValModel = addSerFormAttrAndValSavingDAOImpl.findByAddtionalSerViceFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), (Integer) sn.getAttribute(formIdInSn), userChoiceInDB);
                String capturedInfoInDB = null;
                for (AdditionalFormsAttributesAndValuesSaving addSerAttrAndValModel : addSerFormAttrAndValModel) {
                    capturedInfoInDB = addSerAttrAndValModel.getCapturedInformation();
                }
                JSONParser parser = new JSONParser();
                JSONObject capInfoJsonObject = new JSONObject();
                try {
                    Object parseObj = parser.parse(capturedInfoInDB);
                    capInfoJsonObject = (JSONObject) parseObj;
                } catch (ParseException e) {
                	LOGGER.error("newAdditionalServiceFormSelectionFromDB " + e);
                }
                mav = newAdditionalServiceAttributesInfoSelection(capInfoJsonObject, req);
                AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), userChoiceInDB);
                String stateFormPageValues = stateFormsUpdateModel.getPageVariableReference();
                mav = new ModelAndView(addSerFormModification);
                sn.setAttribute(userChoiceInSn, userChoiceInDB);                
                mav.addObject(textFieldsList, req.getAttribute(textFieldsList));
                mav.addObject(textAreasList, req.getAttribute(textAreasList));
                mav.addObject(dateFieldsList, req.getAttribute(dateFieldsList));
                mav.addObject(selectBoxesList, req.getAttribute(selectBoxesList));
                mav.addObject(zipCodesList, req.getAttribute(zipCodesList));
                mav.addObject(radioButtList, req.getAttribute(radioButtList));
                mav.addObject(checkBoxesList, req.getAttribute(checkBoxesList));                
                mav.addObject(stateFormsPageValue, stateFormPageValues);
            } else {
                mav = new ModelAndView(addSerFormModification);
                sn.setAttribute(userChoiceInSn, null);
            }            
            mav.addObject(radioButStatus, radioButtonStatus);            
            sn.setAttribute(radioButStatus, radioButtonStatus);
            sn.setAttribute(attReqiTypeIdsInSn, attrReqTypeIds);             
        return mav;
    }
        
//	New Additional Service Forms Attributes Info Selection
    @Override
    @Transactional
    public ModelAndView newAdditionalServiceAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req) {
        LOGGER.debug("newAdditionalServiceAttributesInfoSelection...Service");
        ModelAndView mav = new ModelAndView();        
        String textFieldList = null;
        for (int i = 1; i <= 150; i++) {
            String keyVal = String.valueOf(i);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            textFieldList = textFieldList + jSonObjVal + ",$,";
        }
        textFieldList = textFieldList.replace("null", "");
        String textAreaList = null;
        for (int l = 151; l <= 170; l++) {
            String keyVal = String.valueOf(l);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            jSonObjVal = jSonObjVal.replaceAll("[\n\r]", " ");
            textAreaList = textAreaList + jSonObjVal + ",$,";
        }
        textAreaList = textAreaList.replace("null", "");
        String dateFieldList = null;
        for (int m = 171; m <= 190; m++) {
            String keyVal = String.valueOf(m);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            dateFieldList = dateFieldList + jSonObjVal + ",$,";
        }
        dateFieldList = dateFieldList.replace("null", "");
        String selectBoxList = null;
        for (int n = 191; n <= 240; n++) {
            String keyVal = String.valueOf(n);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            selectBoxList = selectBoxList + jSonObjVal + ",$,";
        }
        selectBoxList = selectBoxList.replace("null", "");
        String zipCodeList = null;
        for (int k = 241; k <= 280; k++) {
            String keyVal = String.valueOf(k);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            zipCodeList = zipCodeList + jSonObjVal + ",$,";
        }
        zipCodeList = zipCodeList.replace("null", "");
        String radioButtonList = null;
        for (int o = 281; o <= 430; o++) {
            String keyVal = String.valueOf(o);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            radioButtonList = radioButtonList + jSonObjVal + ",$,";
        }
        radioButtonList = radioButtonList.replace("null", "");
        String checkBoxList = null;
        for (int p = 431; p <= 530; p++) {
            String keyVal = String.valueOf(p);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            checkBoxList = checkBoxList + jSonObjVal + ",$,";
        }
        checkBoxList = checkBoxList.replace("null", "");        
        req.setAttribute(textFieldsList, textFieldList);
        req.setAttribute(textAreasList, textAreaList);
        req.setAttribute(dateFieldsList, dateFieldList);
        req.setAttribute(selectBoxesList, selectBoxList);
        req.setAttribute(zipCodesList, zipCodeList);
        req.setAttribute(radioButtList, radioButtonList);
        req.setAttribute(checkBoxesList, checkBoxList);        
        return mav;
    }

//	New State Tax Id Form Creation Service
    @Override
    @Transactional
    public ModelAndView newStateTaxIdFormSelectionFromDB(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("newStateTaxIdFormSelectionFromDB...Service");
    	ModelAndView mav;
//			Required values take from DB
            List<StateTaxFormsAttributesInfo> addSerFormAttrList = stateTaxFormsAttrInfoDAOImpl.stateTaxIdDynamicFormShowHideData((Integer) sn.getAttribute(formIdInSn));
            List attRequiredList = new ArrayList();
            List attRadioStatusList = new ArrayList();
            List innerRadioList = new ArrayList();
            List addAnotherList = new ArrayList();
            for (StateTaxFormsAttributesInfo stiFormsAttInfo : addSerFormAttrList) {
                attRequiredList.add(stiFormsAttInfo.getRequiredType());
                attRadioStatusList.add(stiFormsAttInfo.getRadioButtonStatus());
                innerRadioList.add(stiFormsAttInfo.getRadioButtonIdStatus());
                addAnotherList.add(stiFormsAttInfo.getAddAnotherRbstatus());
            }
            sn.setAttribute("STI_Attribute_Required_List", attRequiredList);
            sn.setAttribute("STI_Attribute_RadioStatus_List", attRadioStatusList);
            sn.setAttribute("STI_Attribute_InnerRadio_List", innerRadioList);
            sn.setAttribute("STI_Attribute_AddAnother_List", addAnotherList);
//		    State Tax Id form attribute fields and values take from DB this is simple join method
            List<Object> formFieldsAndValues = (List<Object>) stateTaxFormsAttrInfoDAOImpl.stateTaxIdFormsDynamicFieldsAndValues((Integer) sn.getAttribute(formIdInSn));
            List attrId = new ArrayList();
            List attrType = new ArrayList();
            List attNames = new ArrayList();
            List attValue = new ArrayList();
            Iterator formFieldsAndValuesIterator = formFieldsAndValues.iterator();
            while (formFieldsAndValuesIterator.hasNext()) {
                Object[] formFieldsAndValuesObj = (Object[]) formFieldsAndValuesIterator.next();
                String attrbId = String.valueOf(formFieldsAndValuesObj[0]);
                String attrbType = String.valueOf(formFieldsAndValuesObj[1]);
                String attrbName = String.valueOf(formFieldsAndValuesObj[2]);
                String attrbValue = String.valueOf(formFieldsAndValuesObj[3]);
                attrId.add(attrbId);
                attrType.add(attrbType);
                attNames.add(attrbName.replace("null", ""));
                attValue.add(attrbValue.replace("null", ""));
            }
            sn.setAttribute("STI_Attribute_Names_List", attNames);
            sn.setAttribute("STI_Attribute_Values_List", attValue);
//			State Tax Id forms Attribute Required type Ids take from DB 
            List<Object> attrReqTypeIdsList = (List<Object>) stateTaxFormsAttrInfoDAOImpl.stateTaxIdAttributeReqTypeIDsList((Integer) sn.getAttribute(formIdInSn));
            String attrReqTypeIds = attrReqTypeIdsList.toString();
            attrReqTypeIds = attrReqTypeIds.replace("[", "");
            attrReqTypeIds = attrReqTypeIds.replace("]", "");
//			Radio Button Status take from DB 			
            List<Object> radioButtonStatus = (List<Object>) stateTaxFormsAttrInfoDAOImpl.stateTaxIdRadioButtonStatus((Integer) sn.getAttribute(formIdInSn));
//			Form Modification Code           
            List<AllStateFormsDataSaving> stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsUserChoiceFromDB((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), "In Progress");
            String userChoiceInDB = null;
            for (AllStateFormsDataSaving stateFormDataModel : stateFormsModel) {
                userChoiceInDB = stateFormDataModel.getUserChoice();
            }
            if (userChoiceInDB != null) {
                List<StateTaxFormsAttributesAndValuesSaving> stiFormAttrAndValModel = stateTaxFormsAttrAndValuesSavingDAOImpl.findByallStateTaxIdFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), (Integer) sn.getAttribute(formIdInSn), userChoiceInDB);
                String capturedInfoInDB = null;
                for (StateTaxFormsAttributesAndValuesSaving stateTaxFormAttrAndValModel : stiFormAttrAndValModel) {
                    capturedInfoInDB = stateTaxFormAttrAndValModel.getCapturedInformation();
                }
                JSONParser parser = new JSONParser();
                JSONObject capInfoJsonObject = new JSONObject();
                try {
                    Object parseObj = parser.parse(capturedInfoInDB);
                    capInfoJsonObject = (JSONObject) parseObj;
                } catch (ParseException e) {
                	LOGGER.error("newStateTaxIdFormSelectionFromDB " + e);
                }
                mav = newStateTaxIdAttributesInfoSelection(capInfoJsonObject, req);
                AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), userChoiceInDB);
                String stateFormPageValues = stateFormsUpdateModel.getPageVariableReference();
                mav = new ModelAndView(stTaxIdFormModification);
                sn.setAttribute(userChoiceInSn, userChoiceInDB);
                mav.addObject(textFieldsList, req.getAttribute(textFieldsList));
                mav.addObject(textAreasList, req.getAttribute(textAreasList));
                mav.addObject(dateFieldsList, req.getAttribute(dateFieldsList));
                mav.addObject(selectBoxesList, req.getAttribute(selectBoxesList));
                mav.addObject(zipCodesList, req.getAttribute(zipCodesList));
                mav.addObject(radioButtList, req.getAttribute(radioButtList));
                mav.addObject(checkBoxesList, req.getAttribute(checkBoxesList));                
                mav.addObject(stateFormsPageValue, stateFormPageValues);
            } else {
                mav = new ModelAndView(stTaxIdFormModification);
                sn.setAttribute(userChoiceInSn, null);
            }            
            mav.addObject(radioButStatus, radioButtonStatus);            
            sn.setAttribute(radioButStatus, radioButtonStatus);
            sn.setAttribute(attReqiTypeIdsInSn, attrReqTypeIds);
        return mav;
    }    
    
//	New State Tax Id Forms Attributes Info Selection
    @Override
    @Transactional
    public ModelAndView newStateTaxIdAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req) {
        LOGGER.debug("newStateTaxIdAttributesInfoSelection...Service");
        ModelAndView mav = new ModelAndView();        
        String textFieldList = null;
        for (int i = 1; i <= 160; i++) {
            String keyVal = String.valueOf(i);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            textFieldList = textFieldList + jSonObjVal + ",$,";
        }
        textFieldList = textFieldList.replace("null", "");
        String textAreaList = null;
        for (int l = 161; l <= 180; l++) {
            String keyVal = String.valueOf(l);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            jSonObjVal = jSonObjVal.replaceAll("[\n\r]", " ");
            textAreaList = textAreaList + jSonObjVal + ",$,";
        }
        textAreaList = textAreaList.replace("null", "");
        String dateFieldList = null;
        for (int m = 181; m <= 230; m++) {
            String keyVal = String.valueOf(m);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            dateFieldList = dateFieldList + jSonObjVal + ",$,";
        }
        dateFieldList = dateFieldList.replace("null", "");
        String selectBoxList = null;
        for (int n = 231; n <= 260; n++) {
            String keyVal = String.valueOf(n);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            selectBoxList = selectBoxList + jSonObjVal + ",$,";
        }
        selectBoxList = selectBoxList.replace("null", "");
        String zipCodeList = null;
        for (int k = 261; k <= 310; k++) {
            String keyVal = String.valueOf(k);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            zipCodeList = zipCodeList + jSonObjVal + ",$,";
        }
        zipCodeList = zipCodeList.replace("null", "");
        String radioButtonList = null;
        for (int o = 311; o <= 610; o++) {
            String keyVal = String.valueOf(o);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            radioButtonList = radioButtonList + jSonObjVal + ",$,";
        }
        radioButtonList = radioButtonList.replace("null", "");
        String checkBoxList = null;
        for (int p = 611; p <= 710; p++) {
            String keyVal = String.valueOf(p);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            checkBoxList = checkBoxList + jSonObjVal + ",$,";
        }
        checkBoxList = checkBoxList.replace("null", "");        
        req.setAttribute(textFieldsList, textFieldList);
        req.setAttribute(textAreasList, textAreaList);
        req.setAttribute(dateFieldsList, dateFieldList);
        req.setAttribute(selectBoxesList, selectBoxList);
        req.setAttribute(zipCodesList, zipCodeList);
        req.setAttribute(radioButtList, radioButtonList);
        req.setAttribute(checkBoxesList, checkBoxList);       
        return mav;
    }
    
//	State Forms Json calling Standard Filing Fee and Processing Fees Service Implementation
    @Override
    @Transactional
    public JSONArray selectedFormStateSelectionForPrice(String selectedCat, HttpSession sn) {
    	LOGGER.debug("selectedFormStateSelectionForPrice...Service");
        String[] roleName = selectedCat.split(" _ ");
        int formId = takeFormIdFromDB(roleName[0], roleName[1]);        
//		All State forms price List take from DB        
        List<StateFormsPriceInfo> priceList = stateFormsPriceInfoDAOImpl.allStateAndDocFormsPriceListTakeFromDB(formId);
        JSONArray forms = new JSONArray();
        for (StateFormsPriceInfo price : priceList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("jPriceList", price.getPrice());
            forms.add(jsonObj);
        }                    
        return forms;
    }
    
//	Federal Forms Json calling Processing Fees Service Implementation
    @Override
    @Transactional
    public JSONArray selectedFederalFormsSelectionForPrice(String selectedCat, HttpSession sn) {
    	LOGGER.debug("selectedFederalFormsSelectionForPrice...Service");    	
//		All State forms price List take from DB        
        List<FederalFormsPriceInfo> fedPriceList = federalFormsPriceInfoDAOImpl.allFederalFormsPriceListTakeFromDB(selectedCat);
        JSONArray fedForms = new JSONArray();
        for (FederalFormsPriceInfo price : fedPriceList) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("jFedPriceList", price.getPrice());
            fedForms.add(jsonObj);
        }                    
        return fedForms;
    }
    
//	Form Id getting from DB
	@Override
	@Transactional
	public int takeFormIdFromDB(String stateName, String formName) {
		LOGGER.debug("takeFormIdFromDB...method");		
		List<Forms> stFormId = bsFormAndStateAttrInfoDAOImpl.stateFormsIdValueFromDB(stateName, formName);
		int formId = 0;
		for (Forms formsInfo : stFormId) {
		    formId = formsInfo.getFormId();
		}	
		return formId;
	}

}
