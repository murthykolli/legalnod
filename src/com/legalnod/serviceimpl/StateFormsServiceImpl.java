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

import com.legalnod.daoimpl.AbbrevationsDAOImpl;
import com.legalnod.daoimpl.AdditionalFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllFederalFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllStateAndFederalFormsAddCartPaymentSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsPaymentInfoSavingDAOImpl;
import com.legalnod.daoimpl.BusinessFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.BusinessFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.FederalFormsPriceInfoDAOImpl;
import com.legalnod.daoimpl.FormFederalAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.FormFederalDocumentsDataSavingDAOImpl;
import com.legalnod.daoimpl.PromoCodeWithBonusPriceInfoDAOImpl;
import com.legalnod.daoimpl.StateFormsPriceInfoDAOImpl;
import com.legalnod.daoimpl.StateTaxFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.StatesDAOImpl;
import com.legalnod.model.Abbrevations;
import com.legalnod.model.AdditionalFormsAttributesAndValuesSaving;
import com.legalnod.model.AllFederalFormsCheckoutPaymentAndUserContactSaving;
import com.legalnod.model.AllFederalFormsDataSaving;
import com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving;
import com.legalnod.model.AllStateFormsCheckoutPaymentAndUserContactSaving;
import com.legalnod.model.AllStateFormsDataSaving;
import com.legalnod.model.AllStateFormsPaymentInfoSaving;
import com.legalnod.model.BusinessFormsAttributesAndValuesSaving;
import com.legalnod.model.BusinessFormsAttributesInfo;
import com.legalnod.model.FormFederalAttributesAndValuesSaving;
import com.legalnod.model.FormFederalDocumentsDataSaving;
import com.legalnod.model.Forms;
import com.legalnod.model.StateTaxFormsAttributesAndValuesSaving;
import com.legalnod.service.StateFormsService;

public class StateFormsServiceImpl implements StateFormsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateFormsServiceImpl.class);
    
    private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";    
    private String userNameInSn = "userNameInSn";
    private String userName = "userName";
    private String userChoiceInSn = "userChoiceInSn";
    private String typeOfDocumentInSn = "typeOfDocumentInSn";
    private String formNameInSn = "formNameInSn";
    private String formName = "formName";
    private String stateNameInSn = "stateNameInSn";
    private String stateName = "stateName";
    private String formIdInSn = "formIdInSn";
    private String userIdInSn = "userIdInSn";
    private String attributeTextField1 = "attributeTextField1";    
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
    private String radioButStatus = "RadioButtonStatus";
    private String attReqiTypeIdsInSn = "attrReqTypeIdsInSn";
    private String stateFormHiddenVarb = "stateFormHiddenVar";
    private String stateFormsPageValue = "stateFormPageValues";    
    private String bsAttrbRequiredList = "Attribute_Required_List";
    private String bsAttrbRadioStatusList = "Attribute_RadioStatus_List";
    private String bsAttrbInnerRadioList = "Attribute_InnerRadio_List";
    private String bsAttrbAddAnotherList = "Attribute_AddAnother_List";
    private String bsAttrbNamesList = "Attribute_Names_List";
    private String bsAttrbValuesList = "Attribute_Values_List";    
    private String attribTextFieldAddr45 = "attributeTextFieldAddr45";
    private String additionalForm = "Additional Forms";
    private String stateTaxIdForm = "State Tax ID Forms";
    private String jSonUserChoice = "UserChoice";
    private String paymentFeeTotal = "paymentTotal";
    private String docPromoCode = "promoCode";
    private String regiAgentPriceInSn = "regAgentPriceInSn";
    private String formFedLegalNameInSn = "formFederalLegalNameInSn";
    private String invoiceNumbInSn = "invoiceNumberInSn";    
    private String jSonObject = "JSonObj";    
    private String penFedFormCount = "pendFedFormsCount";
    private String pendStateFormCount = "penStateFormsCount";
    private String compFedFormCount = "completedFedFormsCount";
    private String compStateFormCount = "comStateFormsCount";    
    private String yes = "yes";
    private String no = "no";
    private String tf1 = "TF1";

    @Autowired
    private BusinessFormsAttributesAndValuesSavingDAOImpl busFormAttrAndValDAOImpl;

    @Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;

    @Autowired
    private BusinessFormsAttributesInfoDAOImpl bsFormAndStateAttrInfoDAOImpl;

    @Autowired
    private ServiceByStateServiceImpl serviceByStateServiceImpl;

    @Autowired
    private AbbrevationsDAOImpl abbrevationsDAOImpl;

    @Autowired
    private AdditionalServiceImpl additionalServiceImpl;

    @Autowired
    private StateTaxIdServiceImpl stateTaxIdServiceImpl;

    @Autowired
    private AdditionalFormsAttributesAndValuesSavingDAOImpl addSerFormAttrAndValSavingDAOImpl;

    @Autowired
    private StateTaxFormsAttributesAndValuesSavingDAOImpl stateTaxAttrAndValuesSavingDAOImpl;
    
    @Autowired
    private StateFormsPriceInfoDAOImpl stateFormsPriceInfoDAOImpl;
    
    @Autowired
    private FederalFormsPriceInfoDAOImpl federalFormsPriceInfoDAOImpl;
    
    @Autowired
    private AllStateFormsPaymentInfoSavingDAOImpl allStateFormsPaymentSavingDAOImpl;
    
    @Autowired
    private PromoCodeWithBonusPriceInfoDAOImpl promoCodeBonusPriceDAOImpl;
    
    @Autowired
    private AllStateAndFederalFormsAddCartPaymentSavingDAOImpl allFormsAddCartPaymentSavingDAOImpl;
    
    @Autowired
    private AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl allStateFormsCheckoutPaymentDAOImpl;
    
    @Autowired
    private AllFederalFormsDataSavingDAOImpl allFederalFormsSavingDAOImpl;
    
    @Autowired
    private AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl allFedCheckoutPaymentAndContactDAOImpl;
    
    @Autowired
    private FederalFormsServiceImpl federalFormsServiceImpl;
    
    @Autowired
    private FormFederalDocumentsDataSavingDAOImpl formFederalDataSavingDAOImpl;
    
    @Autowired
    private FormFederalAttributesAndValuesSavingDAOImpl formFedAttrAndValuesSavingDAOImpl;
    
    @Autowired
    private BusinessServicesServiceImpl businessServicesServiceImpl;
    
    @Autowired
    private FreeFederalFormsServiceImpl freeFederalFormsServiceImpl;
    
    @Autowired
    private StatesDAOImpl statesDAOImpl;
    
    @Autowired
    private UsersInformationServiceImpl usersInformationServiceImpl;        

//	State Form modification Service Implementation
    @Override
    @Transactional
    public ModelAndView stateFormDataSavingAndUpdatingInDB(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("stateFormDataSavingAndUpdatingInDB...Service");        
        String regAgentPrice = registerAgentPriceTakeFromDB(req.getParameter("radioButton501"), req, sn);
        JSONObject stateFormInfoObj = stateFormsAllAttributesInfoFromJSP(req);
        ModelAndView mav;
//		Already Exit User choice when ever directly clicking enter with out using mouse        
        List userAEChoiceList = allStateFormsDataSavingDAOImpl.allStateFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), req.getParameter(attributeTextField1));
        String alreadyExitChoice = null;        
        if(!userAEChoiceList.isEmpty()){
        AllStateFormsDataSaving stateFormsAEModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), req.getParameter(attributeTextField1));        
        alreadyExitChoice = stateFormsAEModel.getUserChoice();        
        }              
        if (alreadyExitChoice != null && !alreadyExitChoice.equals(sn.getAttribute(userChoiceInSn))) {        	
            mav = new ModelAndView(newStateFormsCreation);
            mav.addObject("AlreadyExitChoice", "AlreadyExitUserChoice");
        } else {        	
        	String formStatus = stateFormStatusInDB(req, sn);        	
            String jsonStringObj = stateFormInfoObj.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Forms formsId = new Forms();
            formsId.setFormId((Integer) sn.getAttribute(formIdInSn));
            Timestamp currentDate = currentDate(); 
            if (sn.getAttribute(userChoiceInSn) == null) {
//				Only Business Forms Data saving in DB
                BusinessFormsAttributesAndValuesSaving busAttrAndValModel = new BusinessFormsAttributesAndValuesSaving();
                busAttrAndValModel.setUserId((Integer) sn.getAttribute(userIdInSn));
                busAttrAndValModel.setForms(formsId);
                busAttrAndValModel.setUserChoice(req.getParameter(attributeTextField1));
                busAttrAndValModel.setCapturedInformation(jsonStringObj);
                busAttrAndValModel.setCreatedDate(currentDate);
                busFormAttrAndValDAOImpl.save(busAttrAndValModel);
//				Data Saving to All state forms data saving DB			
                AllStateFormsDataSaving allStateFormsModel = new AllStateFormsDataSaving();
                allStateFormsModel.setUserName((String) sn.getAttribute(userNameInSn));
                allStateFormsModel.setTypeOfDocument(businessForm);
                allStateFormsModel.setFormName((String) sn.getAttribute(formNameInSn));
                allStateFormsModel.setStateName((String) sn.getAttribute(stateNameInSn));
                allStateFormsModel.setUserChoice(req.getParameter(attributeTextField1));
                allStateFormsModel.setStatus(formStatus);
                allStateFormsModel.setRegisteredAgentPrice(regAgentPrice);
                allStateFormsModel.setCreatedDate(currentDate);
                allStateFormsModel.setPageVariableReference(req.getParameter(stateFormsPageValue));
                allStateFormsModel.setFormStatus(req.getParameter(stateFormHiddenVarb));
                allStateFormsDataSavingDAOImpl.save(allStateFormsModel);
            } else {
                BusinessFormsAttributesAndValuesSaving attrAndValModel = busFormAttrAndValDAOImpl.findByBusinessFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), (Integer) sn.getAttribute(formIdInSn), (String) sn.getAttribute(userChoiceInSn));                
                attrAndValModel.setUserChoice(req.getParameter(attributeTextField1));
                attrAndValModel.setCapturedInformation(jsonStringObj);
                attrAndValModel.setModifiedDate(currentDate);
                busFormAttrAndValDAOImpl.merge(attrAndValModel);
                AllStateFormsDataSaving stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
                stateFormsModel.setUserChoice(req.getParameter(attributeTextField1));
                stateFormsModel.setStatus(formStatus);
                stateFormsModel.setRegisteredAgentPrice(regAgentPrice);
                stateFormsModel.setModifiedDate(currentDate);
                stateFormsModel.setPageVariableReference(req.getParameter(stateFormsPageValue));
                stateFormsModel.setFormStatus(req.getParameter(stateFormHiddenVarb));
                allStateFormsDataSavingDAOImpl.merge(stateFormsModel);
//              All related tables updating
                if(!(sn.getAttribute(userChoiceInSn)).equals(req.getParameter(attributeTextField1))) {
                mav = stateFormsAllRelatedOtherTablesUpdate(req, sn);
                }
            }            
            sn.setAttribute(userChoiceInSn, req.getParameter(attributeTextField1));
            if (req.getParameter(stateFormHiddenVarb) != null && ("Finished").equals(req.getParameter(stateFormHiddenVarb))) {
                mav = freeFederalFormsServiceImpl.busStateFormsFreeFedAndCheckouRedirection(req, sn);
            } else {
                mav = new ModelAndView(newStateFormsCreation);
            }
            mav.addObject(stateFormsPageValue, req.getParameter(stateFormsPageValue));
            sn.setAttribute(bsAttrbRequiredList, sn.getAttribute(bsAttrbRequiredList));
            sn.setAttribute(bsAttrbRadioStatusList, sn.getAttribute(bsAttrbRadioStatusList));
            sn.setAttribute(bsAttrbInnerRadioList, sn.getAttribute(bsAttrbInnerRadioList));
            sn.setAttribute(bsAttrbAddAnotherList, sn.getAttribute(bsAttrbAddAnotherList));
            sn.setAttribute(bsAttrbNamesList, sn.getAttribute(bsAttrbNamesList));
            sn.setAttribute(bsAttrbValuesList, sn.getAttribute(bsAttrbValuesList));
            sn.setAttribute(radioButStatus, sn.getAttribute(radioButStatus));            
            sn.setAttribute(typeOfDocumentInSn, businessForm);
        }        
        mav.addObject(attribTextFieldList, req.getAttribute(attribTextFieldList));
        mav.addObject(attribTextFieldAddrList, req.getAttribute(attribTextFieldAddrList));
        mav.addObject(attribTextFieldZipList, req.getAttribute(attribTextFieldZipList));
        mav.addObject(attribTextAreaList, req.getAttribute(attribTextAreaList));
        mav.addObject(attribSelectBoxList, req.getAttribute(attribSelectBoxList));
        mav.addObject(attribTextFieldDateList, req.getAttribute(attribTextFieldDateList));
        mav.addObject(radioButtList, req.getAttribute(radioButtList));
        mav.addObject(checkBoxesList, req.getAttribute(checkBoxesList));        
        mav.addObject(stateName, sn.getAttribute(stateNameInSn));
        mav.addObject(formName, sn.getAttribute(formNameInSn));
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }
    
//	State Forms Register Agent Price Take From DB
    @Override
    @Transactional
    public String registerAgentPriceTakeFromDB(String regAgentValue, HttpServletRequest req, HttpSession sn) {
    	String regAgentPrice = null;
        if (regAgentValue != null && ("yes501").equals(regAgentValue)) {
            req.setAttribute(attribTextFieldAddr45, "LegalNod Registered Agent");
            List<Object> processingPrice = (List<Object>) federalFormsPriceInfoDAOImpl.federalFormPriceProperty("Registered Agent");      
            if(!processingPrice.isEmpty()){    	  
            	regAgentPrice = processingPrice.get(0).toString();    	  
            }            
        } else {
            req.setAttribute(attribTextFieldAddr45, "");
            regAgentPrice = null;
        }
        registerAgentPriceUpdateInPaymentTable(regAgentPrice, sn);
    	return regAgentPrice;
    }
    
//	State Forms Register Agent Price Update In Payment Table
    @Override
    @Transactional
    public ModelAndView registerAgentPriceUpdateInPaymentTable(String regAgentPrice, HttpSession sn) {
    	LOGGER.debug("registerAgentPriceUpdateInPaymentTable...Service");    	
    	ModelAndView mav = new ModelAndView();
        	List allStChPaymentAndUserContactList = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentRowVerification((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            if(!allStChPaymentAndUserContactList.isEmpty()){
            	AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            	String regAgentFee = allStCheckoutPaymentAndUserContact.getRegisteredAgentPrice();
            	String totalAmount = allStCheckoutPaymentAndUserContact.getAmount();            	
            	double totalAmountInDb = Double.parseDouble(totalAmount);
            	double regAgentFeeInDb = 0;
            	if(regAgentFee != null) {
                    if(regAgentPrice == null){
                    	regAgentFeeInDb = Double.parseDouble(regAgentFee);
                    	double totalDocPrice = totalAmountInDb - regAgentFeeInDb;
                        String totalDocAmount = String.format("%1$.2f", totalDocPrice);                        
                        allStCheckoutPaymentAndUserContact.setAmount(totalDocAmount);
                        allStCheckoutPaymentAndUserContact.setRegisteredAgentPrice(regAgentPrice);
                        allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);                        
                        AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                        allStateFormsPaymentInfoSaving.setTotalFee(totalDocAmount);
                        allStateFormsPaymentInfoSaving.setRegisteredAgentPrice(regAgentPrice);
                        allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);                        
                        AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));                        
                        allStateAndFedAddCartPayment.setAmount(totalDocAmount);                        
                        allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);                    	
                    } 
            	} else{
                    	if(regAgentPrice != null){
                        	regAgentFeeInDb = Double.parseDouble(regAgentPrice);
                        	double totalDocPrice = totalAmountInDb + regAgentFeeInDb;
                            String totalDocAmount = String.format("%1$.2f", totalDocPrice);                            
                            allStCheckoutPaymentAndUserContact.setAmount(totalDocAmount);
                            allStCheckoutPaymentAndUserContact.setRegisteredAgentPrice(regAgentPrice);
                            allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);                            
                            AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                            allStateFormsPaymentInfoSaving.setTotalFee(totalDocAmount);
                            allStateFormsPaymentInfoSaving.setRegisteredAgentPrice(regAgentPrice);
                            allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);                            
                            AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));                        
                            allStateAndFedAddCartPayment.setAmount(totalDocAmount);                        
                            allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);                    	
                        }
                    }
            }        
    	return mav;
    }
    
//	State Forms Attributes Data take from JSP
    @Override
    @Transactional
    public JSONObject stateFormsFiveAttributesInfoFromJSP(HttpServletRequest req) {
        LOGGER.debug("stateFormsFiveAttributesInfoFromJSP...Service");
        JSONObject stateFormInfoObj = new JSONObject();
        String attributeTextFieldList = null;
        String[] attributeTextField = new String[161];
        for (int i = 1; i < attributeTextField.length; i++) {
            attributeTextField[i] = req.getParameter("attributeTextField" + i);
            attributeTextFieldList = attributeTextFieldList + attributeTextField[i] + ",$,";
            stateFormInfoObj.put(i, attributeTextField[i]);            
        }
        attributeTextFieldList = attributeTextFieldList.replace("null", "");
        String attributeTextFieldAddrList = null;
        String[] attributeTextFieldAddr = new String[46];
        for (int j = 1; j < attributeTextFieldAddr.length; j++) {
            if (j == 45) {
                attributeTextFieldAddrList = attributeTextFieldAddrList + req.getAttribute(attribTextFieldAddr45);
                stateFormInfoObj.put(j + 160, req.getAttribute(attribTextFieldAddr45));                
            } else {
                attributeTextFieldAddr[j] = req.getParameter("attributeTextFieldAddr" + j);
                attributeTextFieldAddrList = attributeTextFieldAddrList + attributeTextFieldAddr[j] + ",$,";
                stateFormInfoObj.put(j + 160, attributeTextFieldAddr[j]);                
            }
        }
        attributeTextFieldAddrList = attributeTextFieldAddrList.replace("null", "");
        String attributeTextFieldZipList = null;
        String[] attributeTextFieldZip = new String[81];
        for (int k = 1; k < attributeTextFieldZip.length; k++) {
            attributeTextFieldZip[k] = req.getParameter("attributeTextFieldZip" + k);
            attributeTextFieldZipList = attributeTextFieldZipList + attributeTextFieldZip[k] + ",$,";
            stateFormInfoObj.put(k + 205, attributeTextFieldZip[k]);            
        }
        attributeTextFieldZipList = attributeTextFieldZipList.replace("null", "");
        String attributeTextAreaList = null;
        String[] attributeTextArea = new String[41];
        for (int l = 1; l < attributeTextArea.length; l++) {
            attributeTextArea[l] = req.getParameter("attributeTextArea" + l);
            attributeTextAreaList = attributeTextAreaList + attributeTextArea[l] + ",$,";
            stateFormInfoObj.put(l + 285, attributeTextArea[l]);            
        }
        attributeTextAreaList = attributeTextAreaList.replace("null", "");
        attributeTextAreaList = attributeTextAreaList.replaceAll("[\n\r]", " ");
        String attributeSelectBoxList = null;
        String[] attributeSelectBox = new String[51];
        for (int n = 1; n < attributeSelectBox.length; n++) {
            attributeSelectBox[n] = req.getParameter("attributeSelectBox" + n);
            attributeSelectBoxList = attributeSelectBoxList + attributeSelectBox[n] + ",$,";
            stateFormInfoObj.put(n + 325, attributeSelectBox[n]);            
        }
        attributeSelectBoxList = attributeSelectBoxList.replace("null", "");        
        req.setAttribute(attribTextFieldList, attributeTextFieldList);
        req.setAttribute(attribTextFieldAddrList, attributeTextFieldAddrList);
        req.setAttribute(attribTextFieldZipList, attributeTextFieldZipList);
        req.setAttribute(attribTextAreaList, attributeTextAreaList);
        req.setAttribute(attribSelectBoxList, attributeSelectBoxList);
        return stateFormInfoObj;
    }

//		State Forms All Attributes Data take from JSP
	    @Override
	    @Transactional
	    public JSONObject stateFormsAllAttributesInfoFromJSP(HttpServletRequest req) {
	        LOGGER.debug("stateFormsAllAttributesInfoFromJSP...Service");
	        JSONObject stateFormInfoObj = stateFormsFiveAttributesInfoFromJSP(req);	
	        String attributeTextFieldDateList = null;
	        String[] attributeTextFieldDate = new String[41];
	        for (int m = 1; m < attributeTextFieldDate.length; m++) {
	            attributeTextFieldDate[m] = req.getParameter("attributeTextFieldDate" + m);
	            attributeTextFieldDateList = attributeTextFieldDateList + attributeTextFieldDate[m] + ",$,";
	            stateFormInfoObj.put(m + 375, attributeTextFieldDate[m]);            
	        }
	        attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");	
	        String checkBoxList = null;
	        String[] checkBox = new String[21];
	        for (int p = 1; p < checkBox.length; p++) {
	            String checkSingele = req.getParameter("checkBox" + p);
	            if (checkSingele != null) {
	                String[] checkBoxVal = req.getParameterValues("checkBox" + p);
	                String ddynamicCheckValue = "";
	                for (int q = 0; q < checkBoxVal.length; q++) {
	                    ddynamicCheckValue = ddynamicCheckValue + ", " + checkBoxVal[q];
	                }
	                ddynamicCheckValue = ddynamicCheckValue.replaceFirst(", ", "");
	                checkBoxList = checkBoxList + ddynamicCheckValue + ",$,";
	                stateFormInfoObj.put(p + 415, ddynamicCheckValue);
	            } else {
	                checkBoxList = checkBoxList + checkSingele + ",$,";
	                stateFormInfoObj.put(p + 415, checkSingele);                
	            }
	        }
	        checkBoxList = checkBoxList.replace("null", "");	
	        String radioButtonList = null;
	        String[] radioButton = new String[601];
	        for (int o = 1; o < radioButton.length; o++) {
	            radioButton[o] = req.getParameter("radioButton" + o);
	            radioButtonList = radioButtonList + radioButton[o] + ",$,";
	            stateFormInfoObj.put(o + 435, radioButton[o]);            
	        }
	        radioButtonList = radioButtonList.replace("null", "");	        
	        req.setAttribute(attribTextFieldList, req.getAttribute(attribTextFieldList));
	        req.setAttribute(attribTextFieldAddrList, req.getAttribute(attribTextFieldAddrList));
	        req.setAttribute(attribTextFieldZipList, req.getAttribute(attribTextFieldZipList));
	        req.setAttribute(attribTextAreaList, req.getAttribute(attribTextAreaList));
	        req.setAttribute(attribSelectBoxList, req.getAttribute(attribSelectBoxList));
	        req.setAttribute(attribTextFieldDateList, attributeTextFieldDateList);
	        req.setAttribute(checkBoxesList, checkBoxList);
	        req.setAttribute(radioButtList, radioButtonList);
	        return stateFormInfoObj;
	    }
	    
//  	State Form Status
		@Override
		@Transactional
		public String stateFormStatusInDB(HttpServletRequest req, HttpSession sn) {
			  LOGGER.debug("stateFormStatusInDB...Service");
		      String formStatus = null;
		      JSONObject stateFormInfoObj = stateFormsAllAttributesInfoFromJSP(req);
		      int reqAttrCount = 0;
		      String[] attributeIdsString = ((String) sn.getAttribute(attReqiTypeIdsInSn)).split(", ");
		      int totalReqAttrCount = attributeIdsString.length;		
		      for (int i = 0; i < attributeIdsString.length; i++) {
		          String attrIdInStr = attributeIdsString[i];
		          int attrIdInt = Integer.parseInt(attrIdInStr);		
		          String jSonObjVal = (String) stateFormInfoObj.get(attrIdInt);
		          if (jSonObjVal != null && jSonObjVal != "") {
		              reqAttrCount = reqAttrCount + 1;
		          }
		      }		      
		      if (totalReqAttrCount == reqAttrCount) {
		          formStatus = "Ready for checkout";
		      } else {
		          formStatus = "In Progress";
		      }
		      return formStatus;
		}
		  
//	 	State Forms All Related Other Tables Update		    
		@Override
		@Transactional
		public ModelAndView stateFormsAllRelatedOtherTablesUpdate(HttpServletRequest req, HttpSession sn) {
			  LOGGER.debug("stateFormsAllRelatedOtherTablesUpdate...Service");
			  ModelAndView mav = new ModelAndView();
			  Timestamp currentDate = currentDate();			  
			  List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              if(!allStateFormsPaymentList.isEmpty()){
              AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              allStateFormsPaymentInfoSaving.setUserChoice(req.getParameter(attributeTextField1));
              allStateFormsPaymentInfoSaving.setUpdatedDate(currentDate);
              allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);
              }              
              List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              if(!allFormsAddCartPaymentList.isEmpty()){
              AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              String combValue = req.getParameter(attributeTextField1)+", "+sn.getAttribute(formNameInSn)+", "+sn.getAttribute(stateNameInSn)+".";
              allStateAndFedAddCartPayment.setUserChoice(req.getParameter(attributeTextField1));
              allStateAndFedAddCartPayment.setSelectedDocumentsName(combValue);
              allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);              
              AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              allStCheckoutPaymentAndUserContact.setUserChoice(req.getParameter(attributeTextField1));
              allStCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
              allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
              }              
              List formFederalUserChoice = formFederalDataSavingDAOImpl.stateFormsUserChoiceTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
              if(!formFederalUserChoice.isEmpty()){
              FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.stateFormsUserChoiceUpdationInFormFedDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
              formFederalUpdateModel.setUserChoice(req.getParameter(attributeTextField1));                
              formFederalDataSavingDAOImpl.merge(formFederalUpdateModel);              
              FormFederalAttributesAndValuesSaving freeFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.stateFormsUserChoiceUpdateInAttrAndValuesDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));            	
          	  freeFedAttrAndValModel.setUserChoice(req.getParameter(attributeTextField1));            	
              formFedAttrAndValuesSavingDAOImpl.merge(freeFedAttrAndValModel);
              }		       
		  return mav;
		  }
  
//  	Pending State forms Service only    
		@Override
		@Transactional
		public ModelAndView pendingStateFormsOnly(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("pendingStateFormsOnly...Service");
        ModelAndView mav = new ModelAndView();
        List<AllStateFormsDataSaving> pendStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));        
        int pendStateFormsCount = pendStateFormsSavingInfoList.size();
        if (!pendStateFormsSavingInfoList.isEmpty()) {
            List<AllStateFormsDataSaving> pendStateFormSavingList = new ArrayList<AllStateFormsDataSaving>();
            for (AllStateFormsDataSaving pendStateFormsInfo : pendStateFormsSavingInfoList) {
                AllStateFormsDataSaving pndStateFormsInfoModel = new AllStateFormsDataSaving();
                pndStateFormsInfoModel.setStateName(pendStateFormsInfo.getStateName());
                pndStateFormsInfoModel.setFormName(pendStateFormsInfo.getFormName());
                pndStateFormsInfoModel.setUserChoice(pendStateFormsInfo.getUserChoice());
                pndStateFormsInfoModel.setTypeOfDocument(pendStateFormsInfo.getTypeOfDocument());
                Timestamp lastEditedDate = null;
                if (pendStateFormsInfo.getModifiedDate() != null) {
                    lastEditedDate = pendStateFormsInfo.getModifiedDate();
                } else {
                    lastEditedDate = pendStateFormsInfo.getCreatedDate();
                }
                pndStateFormsInfoModel.setCreatedDate(lastEditedDate);
                pendStateFormSavingList.add(pndStateFormsInfoModel);
            }            
            mav = new ModelAndView("userMyAccountRedirection");
            mav.addObject("pendStateFormSavingList", pendStateFormSavingList);
            mav.addObject("pendStateFormsCount", pendStateFormsCount);
        }
        return mav;
    }
    
//  My Account page redirection
    @Override
    @Transactional
    public ModelAndView stateFormUserMyAccountRedirection(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("stateFormUserMyAccountRedirection...Service");
        ModelAndView mav = new ModelAndView();
        List<AllStateFormsDataSaving> pendStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));        
        int pendingStateFormsCount = pendStateFormsSavingInfoList.size();         
        List<AllFederalFormsDataSaving> penFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.federalFormsSavingDataTakeFromDB((String) sn.getAttribute(userNameInSn));
        int pendingFedFormsCount = penFederalFormsSavingInfoList.size();        
        List<AllStateFormsDataSaving> comStateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.completedStateFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));        
        int comStateFormsCount = comStateFormsSavingInfiList.size();        
        List<AllFederalFormsDataSaving> comFederalFormsSavingInfiList = allFederalFormsSavingDAOImpl.completedFederalFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));
        int completedFedFormsCount = comFederalFormsSavingInfiList.size();        
        if(sn.getAttribute(userNameInSn) != null){
        if (!pendStateFormsSavingInfoList.isEmpty()) {
            mav = pendingStateFormsOnly(req, sn);            
        } else if (pendStateFormsSavingInfoList.isEmpty() && !comStateFormsSavingInfiList.isEmpty()) {
        	mav = completedStateFormsForUserDataDisplay(req, sn);        	
        } else if (!penFederalFormsSavingInfoList.isEmpty()) {
        	mav = federalFormsServiceImpl.pendingFederalFormsRedirection(req, sn);        	
        } else if (penFederalFormsSavingInfoList.isEmpty() && !comFederalFormsSavingInfiList.isEmpty()) {
        	mav = federalFormsServiceImpl.completedFederalFormsForUserDataDisplay(req, sn);        	
        } else {
            mav = businessServicesServiceImpl.userProfileHome(req, sn);
        }
        } else{
        	mav = usersInformationServiceImpl.logInHome(req, sn);
        }
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject("pendingStateFormsCount", pendingStateFormsCount);
        mav.addObject("pendingFedFormsCount", pendingFedFormsCount);
        mav.addObject(compStateFormCount, comStateFormsCount);
        mav.addObject(compFedFormCount, completedFedFormsCount);
        return mav;
    }

//	All State forms data operation service
    @Override
    @Transactional
    public ModelAndView allStateFormsDataOperations(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("allStateFormsDataOperations...Service");
        String stateFormsRefType = (String) req.getParameter("allStateFormsRefType");
        String sfCombValue = (String) req.getParameter("formName");
        if (sfCombValue != null) {
            String[] combValue = sfCombValue.split(",&, ");
            sn.setAttribute(stateNameInSn, combValue[0]);
            sn.setAttribute(formNameInSn, combValue[1]);
            sn.setAttribute(userChoiceInSn, combValue[2]);
            sn.setAttribute(typeOfDocumentInSn, combValue[3]);
        }
        ModelAndView mav = new ModelAndView();
        if(sn.getAttribute(userNameInSn) != null) {
        if (("FormModification").equals(stateFormsRefType)) {
            mav = allStateFormsDataOperationsModification(req, sn);            
        } else if (("FormFinishOrder").equals(stateFormsRefType)) {
            mav = allStateFormsDataOperationsFinishOrder(req, sn);            
        } else if (("FormDeletion").equals(stateFormsRefType)) {
        	mav = allStateFormsRelatedTablesDataDeletion(req, sn);        	
        } else if (("NewFormCreation").equals(stateFormsRefType)) {	        
	        mav = serviceByStateServiceImpl.serviceByStateHome(req, sn);	            
        } 
        } else{
    		mav = usersInformationServiceImpl.logInHome(req, sn);
    	}
        return mav;
    }
    
//	All State Forms related tables Data deletion
    @Override
    @Transactional
    public ModelAndView allStateFormsRelatedTablesDataDeletion(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("allStateFormsRelatedTablesDataDeletion...Service");
    	ModelAndView mav = new ModelAndView();
//    	Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
        if ((businessForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            BusinessFormsAttributesAndValuesSaving attrAndValModel = busFormAttrAndValDAOImpl.findByBusinessFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            busFormAttrAndValDAOImpl.delete(attrAndValModel);
            List formFederalUserChoice = formFederalDataSavingDAOImpl.stateFormsUserChoiceTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            if(!formFederalUserChoice.isEmpty()){
            FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.stateFormsUserChoiceUpdationInFormFedDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            formFederalDataSavingDAOImpl.delete(formFederalUpdateModel);            
            FormFederalAttributesAndValuesSaving freeFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.stateFormsUserChoiceUpdateInAttrAndValuesDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));            	
            formFedAttrAndValuesSavingDAOImpl.delete(freeFedAttrAndValModel);
            }
        } else if ((additionalForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            AdditionalFormsAttributesAndValuesSaving attrAndValModel = addSerFormAttrAndValSavingDAOImpl.findByAddSerFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            addSerFormAttrAndValSavingDAOImpl.delete(attrAndValModel);
        } else if ((stateTaxIdForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            StateTaxFormsAttributesAndValuesSaving attrAndValModel = stateTaxAttrAndValuesSavingDAOImpl.findByStateTaxIdFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            stateTaxAttrAndValuesSavingDAOImpl.delete(attrAndValModel);
        }
//      All related tables deletion
        mav = allStateFormsOperationsRelatedTableDeletion(req, sn);
        mav = stateFormUserMyAccountRedirection(req, sn);
    	return mav;
    }
    
//	All State Forms Data Operations Modification
    @Override
    @Transactional
    public ModelAndView allStateFormsDataOperationsModification(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("allStateFormsDataOperationsModification...Service");
    	ModelAndView mav = new ModelAndView();    	
    	if ((businessForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            mav = businessStateFormsDataModification(req, sn);
        } else if ((additionalForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            mav = additionalServiceImpl.additionalServiceFormsDataModification(req, sn);
        } else if ((stateTaxIdForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            mav = stateTaxIdServiceImpl.stateTaxIdFormsDataModification(req, sn);
        }
    	return mav;
    }
    
//	All State Forms Data Operations Finish Order
    @Override
    @Transactional
    public ModelAndView allStateFormsDataOperationsFinishOrder(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("allStateFormsDataOperationsFinishOrder...Service");
    	ModelAndView mav = new ModelAndView();    	
    	if ((businessForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {        	
        	List<FormFederalDocumentsDataSaving> formFedTaxModel = formFederalDataSavingDAOImpl.findByFreeFederalFormsLegalNameFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String legalNameInDB = null;
            if(!formFedTaxModel.isEmpty()){
            for (FormFederalDocumentsDataSaving formFederalDataModel : formFedTaxModel) {
            	legalNameInDB = formFederalDataModel.getLegalName();
            }
            }                
            if(legalNameInDB != null){
            	mav = freeFederalFormsServiceImpl.stateFormsWithFreeFederalCheckouDataDisplay(req, sn);
            } else{
            	mav = businessStateFormsCheckouDataDisplay(req, sn);
            }
            sn.setAttribute("freeLegalNameInSn", legalNameInDB);        	
        } else if ((additionalForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            mav = additionalServiceImpl.additionalServiceFormsCheckouDataDisplay(req, sn);
        } else if ((stateTaxIdForm).equals((String) sn.getAttribute(typeOfDocumentInSn))) {
            mav = stateTaxIdServiceImpl.stateTaxIdFormsCheckouDataDisplay(req, sn);
        }
    	return mav;
    }
    
//	All State Forms Data Operations Related Tables Deletion
    @Override
    @Transactional
    public ModelAndView allStateFormsOperationsRelatedTableDeletion(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("allStateFormsOperationsRelatedTableDeletion...Service");
    	ModelAndView mav = new ModelAndView();    	
    	List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        if(!allStateFormsPaymentList.isEmpty()){
        	AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            allStateFormsPaymentSavingDAOImpl.delete(allStateFormsPaymentInfoSaving);
        }            
        List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));            
        if(!allFormsAddCartPaymentList.isEmpty()){
        	AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            allFormsAddCartPaymentSavingDAOImpl.delete(allStateAndFedAddCartPayment);
            AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            allStateFormsCheckoutPaymentDAOImpl.delete(allStCheckoutPaymentAndUserContact);
        }
        List allStAndFedAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataTakeFromDB((String) sn.getAttribute(userNameInSn));
        sn.setAttribute(noOfDocInCartInSn, allStAndFedAddCartPaymentList.size());
        AllStateFormsDataSaving allStateFormsDataSaving = allStateFormsDataSavingDAOImpl.allStateFormsDeletionInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        Timestamp currentDate = currentDate();
        allStateFormsDataSaving.setStatus("Deleted");
        allStateFormsDataSaving.setDeleteDate(currentDate);
        allStateFormsDataSavingDAOImpl.merge(allStateFormsDataSaving);
    	return mav;
    }    
    
//	All State forms Checkout redirection service
    @Override
    @Transactional
    public ModelAndView checkoutDataRedirection(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("checkoutDataRedirection...Service");
        ModelAndView mav = new ModelAndView();
        if (("CheckoutModification").equals((String) req.getParameter("stateFormsCheckOutRef"))) {
            mav = businessStateFormsDataModification(req, sn);
        } else if (("CheckoutPayment").equals((String) req.getParameter("stateFormsCheckOutRef"))) {
        	mav = stateFormsCheckoutPaymentDataSaving(req, sn);            
        }
        return mav;
    }

//  Checkout State form modification Service
    @Override
    @Transactional
    public ModelAndView businessStateFormsDataModification(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("businessStateFormsDataModification...Service");
        ModelAndView mav = new ModelAndView();
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);        
//		Required values take from DB
        List<BusinessFormsAttributesInfo> busFormAttrList = bsFormAndStateAttrInfoDAOImpl.stateFormDynamicFormShowHideData(formId);
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
        sn.setAttribute(bsAttrbRequiredList, attRequiredList);
        sn.setAttribute(bsAttrbRadioStatusList, attRadioStatusList);
        sn.setAttribute(bsAttrbInnerRadioList, innerRadioList);
        sn.setAttribute(bsAttrbAddAnotherList, addAnotherList);
//	    State form attribute fields and values take from DB this is simple join method
        List<Object> formFieldsAndValues = (List<Object>) bsFormAndStateAttrInfoDAOImpl.busStateFormsDynamicFieldsAndValues(formId);
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
        sn.setAttribute(bsAttrbNamesList, attNames);
        sn.setAttribute(bsAttrbValuesList, attValue);
//		State forms Attribute Required type Ids take from DB 
        List<Object> attrReqTypeIdsList = (List<Object>) bsFormAndStateAttrInfoDAOImpl.attributeReqTypeIDsList(formId);
        String attrReqTypeIds = attrReqTypeIdsList.toString();
        attrReqTypeIds = attrReqTypeIds.replace("[", "");
        attrReqTypeIds = attrReqTypeIds.replace("]", "");
//		Radio Button Status take from DB 			
        List<Object> radioButtonStatus = (List<Object>) bsFormAndStateAttrInfoDAOImpl.stateFormRadioButtonStatus(formId);
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<BusinessFormsAttributesAndValuesSaving> busStFormAttrAndValModel = busFormAttrAndValDAOImpl.findByallStateFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (BusinessFormsAttributesAndValuesSaving stateFormAttrAndValModel : busStFormAttrAndValModel) {
                capturedInfoInDB = stateFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);
            mav = businessServicesServiceImpl.newStateFormAttributesInfoSelection(capInfoJsonObject, req);
            AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String stateFormPageValues = stateFormsUpdateModel.getPageVariableReference();
            mav = new ModelAndView(newStateFormsCreation);
            sn.setAttribute(userChoiceInSn, sn.getAttribute(userChoiceInSn));            
            mav.addObject(attribTextFieldList, req.getAttribute(attribTextFieldList));
            mav.addObject(attribTextFieldAddrList, req.getAttribute(attribTextFieldAddrList));
            mav.addObject(attribTextFieldZipList, req.getAttribute(attribTextFieldZipList));
            mav.addObject(attribTextAreaList, req.getAttribute(attribTextAreaList));
            mav.addObject(attribTextFieldDateList, req.getAttribute(attribTextFieldDateList));
            mav.addObject(attribSelectBoxList, req.getAttribute(attribSelectBoxList));
            mav.addObject(radioButtList, req.getAttribute(radioButtList));
            mav.addObject(checkBoxesList, req.getAttribute(checkBoxesList));            
            mav.addObject(stateName, sn.getAttribute(stateNameInSn));
            mav.addObject(formName, sn.getAttribute(formNameInSn));
            mav.addObject(stateFormsPageValue, stateFormPageValues);
        }
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject(radioButStatus, radioButtonStatus);
        sn.setAttribute(formIdInSn, formId);
        sn.setAttribute(radioButStatus, radioButtonStatus);
        sn.setAttribute(attReqiTypeIdsInSn, attrReqTypeIds);
        sn.setAttribute(stateNameInSn, sn.getAttribute(stateNameInSn));
        sn.setAttribute(formNameInSn, sn.getAttribute(formNameInSn));
        return mav;
    }
   
//	all state Forms Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView businessStateFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("businessStateFormsCheckouDataDisplay...Service");
        ModelAndView mav = new ModelAndView();
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Required values take from DB		
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<BusinessFormsAttributesAndValuesSaving> busStFormAttrAndValModel = busFormAttrAndValDAOImpl.findByallStateFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (BusinessFormsAttributesAndValuesSaving stateFormAttrAndValModel : busStFormAttrAndValModel) {
                capturedInfoInDB = stateFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);            
//			State forms Ids take from DB 			
            List attrNamesList = new ArrayList();
            List attrFieldIdsList = new ArrayList();
            List attrTypeList = new ArrayList();
            List<Object> formFieldsAndValuesIds = (List<Object>) bsFormAndStateAttrInfoDAOImpl.busStateFormsDynamicFieldsAndValuesIDs(formId);
            Iterator formFieldsAndValuesIdsIterator = formFieldsAndValuesIds.iterator();
            while (formFieldsAndValuesIdsIterator.hasNext()) {
                Object[] formFieldsAndValuesIdsObj = (Object[]) formFieldsAndValuesIdsIterator.next();
                String attrFieldId = String.valueOf(formFieldsAndValuesIdsObj[0]);                
                String attrNames = String.valueOf(formFieldsAndValuesIdsObj[2]);
                String attrType = String.valueOf(formFieldsAndValuesIdsObj[3]);
                attrFieldIdsList.add(attrFieldId);
                attrNamesList.add(attrNames + " ");
                attrTypeList.add(attrType);
            }
            String attrFieldIDListInString = attrFieldIdsList.toString();
            attrFieldIDListInString = attrFieldIDListInString.replace("[", "");
            attrFieldIDListInString = attrFieldIDListInString.replace("]", "");
            String attrNamesListInString = attrNamesList.toString();
            attrNamesListInString = attrNamesListInString.replace("[", "");
            attrNamesListInString = attrNamesListInString.replace("]", "");
            String attrTypeListInString = attrTypeList.toString();
            attrTypeListInString = attrTypeListInString.replace("[", "");
            attrTypeListInString = attrTypeListInString.replace("]", "");
            String[] attrFieldIDInString = attrFieldIDListInString.split(", ");
            String[] attrNamesInString = attrNamesListInString.split(" , ");
            String[] attrTypeInString = attrTypeListInString.split(", ");
            List attrSTNamesList = new ArrayList();
            List attrSTTypeList = new ArrayList();
            List attrSTValuesList = new ArrayList();
            List attrSTIdsList = new ArrayList();
            for (int i = 0; i < attrFieldIDInString.length; i++) {
                String attrFieldId = attrFieldIDInString[i];
                String attrNames = attrNamesInString[i];
                String attrTypes = attrTypeInString[i];
                String jSonObjVal = (String) capInfoJsonObject.get(attrFieldId);
                if (!("").equals(jSonObjVal)) {
                    String attrValue = jSonObjVal;
                    for (int k = 0; k < jSonObjVal.length() + 600; k++) {
                        String yesVal = yes + k;
                        String noVal = no + k;
                        if (yesVal.equals(jSonObjVal)) {
                            attrValue = jSonObjVal.replaceAll(yesVal, yes);
                        } else if (noVal.equals(jSonObjVal)) {
                            attrValue = jSonObjVal.replaceAll(noVal, no);
                        }
                    }
                    attrSTNamesList.add(attrNames);
                    attrSTTypeList.add(attrTypes);
                    attrSTValuesList.add(attrValue);
                    attrSTIdsList.add(attrFieldId);
                }
            }            
            mav = new ModelAndView("stateFormCheckoutDisplayCreation");
            sn.setAttribute("Attr_SF_Names_CheckOutList", attrSTNamesList);
            sn.setAttribute("Attr_SF_Type_CheckOutList", attrSTTypeList);
            sn.setAttribute("Attr_SF_Values_CheckOutList", attrSTValuesList);
            sn.setAttribute("Attr_IDs_SF_CheckOutList", attrSTIdsList);
            mav.addObject(stateName, sn.getAttribute(stateNameInSn));
            mav.addObject(formName, sn.getAttribute(formNameInSn));
        }    
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        sn.setAttribute(formIdInSn, formId);        
        sn.setAttribute(stateNameInSn, sn.getAttribute(stateNameInSn));
        sn.setAttribute(formNameInSn, sn.getAttribute(formNameInSn));
        return mav;
    }

//	Checkout Json calling updated Values in DB Service
    @Override
    @Transactional
    public JSONArray checkoutDataUpdationInDB(String updatedAttrVal, HttpSession sn) {
    	LOGGER.debug("checkoutDataUpdationInDB...Service");
        String[] roleName = updatedAttrVal.split(" _ ");
        String attrValue = roleName[0];
        String attrId = roleName[1];
        String attrType = roleName[2];
        attrValue = attrValue.replace("$,$", "&");        
        String modValue = null;        
//		userChoice checking in DB		
        int count = 0;
        if ((tf1).equals(attrType)) {            
            List userChoiceInDB = allStateFormsDataSavingDAOImpl.allStateFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), attrValue);
            count = userChoiceInDB.size();
        }
        if (count > 0 && (tf1).equals(attrType)) {
            if (sn.getAttribute(userChoiceInSn).equals(attrValue)) {
                modValue = attrValue;
                sn.setAttribute(userChoiceInSn, attrValue);
            } else {
                modValue = "null";
            }
        } else {
//			Form Id getting from DB
        	int formId = takeFormIdFromDB(sn);
//			Required values take from DB
            List<BusinessFormsAttributesAndValuesSaving> busStFormAttrAndValModel = busFormAttrAndValDAOImpl.findByallStateFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (BusinessFormsAttributesAndValuesSaving stateFormAttrAndValModel : busStFormAttrAndValModel) {
                capturedInfoInDB = stateFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);          
            capInfoJsonObject.remove(attrId);
            capInfoJsonObject.put(attrId, attrValue);
            String jsonStringObj = capInfoJsonObject.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate(); 
            BusinessFormsAttributesAndValuesSaving attrAndValuesModel = busFormAttrAndValDAOImpl.findByBusinessFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            attrAndValuesModel.setCapturedInformation(jsonStringObj);
            attrAndValuesModel.setModifiedDate(currentDate);
            busFormAttrAndValDAOImpl.merge(attrAndValuesModel);
            AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            if ((tf1).equals(attrType)) {                
                stateFormsUpdateModel.setUserChoice(attrValue);
                stateFormsUpdateModel.setModifiedDate(currentDate);
                allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);
                attrAndValuesModel.setUserChoice(attrValue);
                busFormAttrAndValDAOImpl.merge(attrAndValuesModel);                
//              All related tables updating
                checkoutDataRelatedDataUpdationInDB(attrValue, sn);
                sn.setAttribute(userChoiceInSn, attrValue);                
            } else{
            	stateFormsUpdateModel.setModifiedDate(currentDate);
            	allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);
            }
            modValue = attrValue;
        }
        String finalObj = modValue + "&&" + attrId;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObject, finalObj);
        forms.add(jsonObj);
        return forms;
    }
    
//	all state Forms Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView checkoutDataRelatedDataUpdationInDB(String attrValue, HttpSession sn) {
    	LOGGER.debug("checkoutDataRelatedDataUpdationInDB...Service");
        ModelAndView mav = new ModelAndView();
        Timestamp currentDate = currentDate();        
        List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        if(!allStateFormsPaymentList.isEmpty()){
        AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        allStateFormsPaymentInfoSaving.setUserChoice(attrValue);
        allStateFormsPaymentInfoSaving.setUpdatedDate(currentDate);
        allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);
        }        
        List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        if(!allFormsAddCartPaymentList.isEmpty()){
        AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        String combValue = attrValue+", "+sn.getAttribute(formNameInSn)+", "+sn.getAttribute(stateNameInSn)+".";
        allStateAndFedAddCartPayment.setUserChoice(attrValue);
        allStateAndFedAddCartPayment.setSelectedDocumentsName(combValue);
        allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);        
        AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        allStCheckoutPaymentAndUserContact.setUserChoice(attrValue);
        allStCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
        allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
        }        
        List formFederalUserChoice = formFederalDataSavingDAOImpl.stateFormsUserChoiceTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
        if(!formFederalUserChoice.isEmpty()){
        FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.stateFormsUserChoiceUpdationInFormFedDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
        formFederalUpdateModel.setUserChoice(attrValue);                
        formFederalDataSavingDAOImpl.merge(formFederalUpdateModel);        
        FormFederalAttributesAndValuesSaving freeFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.stateFormsUserChoiceUpdateInAttrAndValuesDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));            	
    	freeFedAttrAndValModel.setUserChoice(attrValue);            	
        formFedAttrAndValuesSavingDAOImpl.merge(freeFedAttrAndValModel);
        }
        return mav;
    }

//	Abbreviations add to First Choice Service
    @Override
    @Transactional
    public JSONArray firstChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn) {
    	LOGGER.debug("firstChoiceAbbreviationAddingToJSP...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
        userFirstChoice = userFirstChoice.replace("$,$", "&");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Abbreviations Status take from BusinessFormsAttributesInfo DB
        List<BusinessFormsAttributesInfo> abbrStatusList = bsFormAndStateAttrInfoDAOImpl.abbreviationStatusTakeFromDB(formId);
        String abbrStatus = null;
        for (BusinessFormsAttributesInfo abbrStList : abbrStatusList) {
            abbrStatus = abbrStList.getAbbrevationStatus();
        }
//		Replacement abbreviation take from Abbreviations DB
        List<Abbrevations> repAbbrList = abbrevationsDAOImpl.replacementAbbreviationTakeFromDB(formId);
        String repAbbrValue = null;
        for (Abbrevations repAbbrValueList : repAbbrList) {
            repAbbrValue = repAbbrValueList.getReplacementAbbrevation();
        }
//		Abbreviation Extinction Added Code
        String extinctionAddedUserChoice = abbreviationExtinctionAddedToUserChoice(userFirstChoice, abbrStatus, repAbbrValue, formId, sn);
//		User Choice take from DB       
        List userChoiceList = allStateFormsDataSavingDAOImpl.allStateFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), businessForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), extinctionAddedUserChoice);
        String userChoiceInDB = null;
        if (!userChoiceList.isEmpty()) {
            userChoiceInDB = extinctionAddedUserChoice;
        }
        if (userChoiceInDB != null && sn.getAttribute(userChoiceInSn) != null && sn.getAttribute(userChoiceInSn).equals(userChoiceInDB)) {            
                userChoiceInDB = "null";            
        }
        String finalObj = userChoiceInDB + "&&" + extinctionAddedUserChoice;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }
    
//	Abbreviation Extinction Added To User Choice
    @Override
    @Transactional
    public String abbreviationExtinctionAddedToUserChoice(String userFirstChoice, String abbrStatus, String repAbbrValue, int formId, HttpSession sn) {
    	LOGGER.debug("abbreviationExtinctionAddedToUserChoice...Service");    	
//		Abbreviation Names List take from Abbreviations DB
    	List<Object> abbreviationNamesList = (List<Object>) abbrevationsDAOImpl.abbreviationNamesListtakefromDB(formId);
    	String extinctionAddedUserChoice = null;        
        if ((!abbreviationNamesList.isEmpty()) && (abbrStatus != null)) {
            boolean choiceExt = false;
            String abbreviationNamesString = null;
            for (int i = 0; i < abbreviationNamesList.size(); i++) {
                Object abbreviationNamesObj = abbreviationNamesList.get(i);
                abbreviationNamesString = abbreviationNamesObj.toString();
                if (userFirstChoice.endsWith(abbreviationNamesString)) {
                    choiceExt = true;
                }
            }
            if (choiceExt == true) {
                extinctionAddedUserChoice = userFirstChoice;
            } else {
                extinctionAddedUserChoice = userFirstChoice + " " + String.valueOf(repAbbrValue);
            }
        } else {
            extinctionAddedUserChoice = userFirstChoice;
        }
    	return extinctionAddedUserChoice;
    }

//	Abbreviations add to Second Choice Service
    @Override
    @Transactional
    public JSONArray secondChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn) {
    	LOGGER.debug("secondChoiceAbbreviationAddingToJSP...Service");
        String userSecChoice = updatedAttrVal;
        userSecChoice = userSecChoice.replaceAll("\\s+", " ");
        userSecChoice = userSecChoice.replace("$,$", "&");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Abbreviations Status take from BusinessFormsAttributesInfo DB        
        List<BusinessFormsAttributesInfo> abbrStatusList = bsFormAndStateAttrInfoDAOImpl.abbreviationStatusForAllTakeFromDB(formId, "TF2");
        String abbrStatus = null;
        for (BusinessFormsAttributesInfo abbrStList : abbrStatusList) {
            abbrStatus = abbrStList.getAbbrevationStatus();
        }
//		Replacement abbreviation take from Abbreviations DB
        List<Abbrevations> repAbbrList = abbrevationsDAOImpl.replacementAbbreviationTakeFromDB(formId);
        String repAbbrValue = null;
        for (Abbrevations repAbbrValueList : repAbbrList) {
            repAbbrValue = repAbbrValueList.getReplacementAbbrevation();
        }
//		Abbreviation Names List take from Abbreviations DB
        List<Object> abbreviationNamesList = (List<Object>) abbrevationsDAOImpl.abbreviationNamesListtakefromDB(formId);
//		Abbreviation Extinction Added Code
        String extinctionAddedUserChoice = null;
        if ((!abbreviationNamesList.isEmpty()) && (abbrStatus != null)) {
            boolean choiceExt = false;
            String abbreviationNamesString = null;
            for (int i = 0; i < abbreviationNamesList.size(); i++) {
                Object abbreviationNamesObj = abbreviationNamesList.get(i);
                abbreviationNamesString = abbreviationNamesObj.toString();
                if (userSecChoice.endsWith(abbreviationNamesString)) {
                    choiceExt = true;
                }
            }
            if (choiceExt == true) {
                extinctionAddedUserChoice = userSecChoice;
            } else {
                extinctionAddedUserChoice = userSecChoice + " " + String.valueOf(repAbbrValue);
            }
        } else {
            extinctionAddedUserChoice = userSecChoice;
        }
        String finalObj = extinctionAddedUserChoice;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//	Abbreviations add to Third Choice Service
    @Override
    @Transactional
    public JSONArray thirdChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn) {
    	LOGGER.debug("thirdChoiceAbbreviationAddingToJSP...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
        userFirstChoice = userFirstChoice.replace("$,$", "&");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Abbreviations Status take from BusinessFormsAttributesInfo DB        
        List<BusinessFormsAttributesInfo> abbrStatusList = bsFormAndStateAttrInfoDAOImpl.abbreviationStatusForAllTakeFromDB(formId, "TF3");
        String abbrStatus = null;
        for (BusinessFormsAttributesInfo abbrStList : abbrStatusList) {
            abbrStatus = abbrStList.getAbbrevationStatus();
        }
//		Replacement abbreviation take from Abbreviations DB
        List<Abbrevations> repAbbrList = abbrevationsDAOImpl.replacementAbbreviationTakeFromDB(formId);
        String repAbbrValue = null;
        for (Abbrevations repAbbrValueList : repAbbrList) {
            repAbbrValue = repAbbrValueList.getReplacementAbbrevation();
        }
//		Abbreviation Names List take from Abbreviations DB
        List<Object> abbreviationNamesList = (List<Object>) abbrevationsDAOImpl.abbreviationNamesListtakefromDB(formId);
//		Abbreviation Extinction Added Code
        String extinctionAddedUserChoice = null;        
        if ((!abbreviationNamesList.isEmpty()) && (abbrStatus != null)) {
            boolean choiceExt = false;
            String abbreviationNamesString = null;
            for (int i = 0; i < abbreviationNamesList.size(); i++) {
                Object abbreviationNamesObj = abbreviationNamesList.get(i);
                abbreviationNamesString = abbreviationNamesObj.toString();
                if (userFirstChoice.endsWith(abbreviationNamesString)) {
                    choiceExt = true;
                }
            }
            if (choiceExt == true) {
                extinctionAddedUserChoice = userFirstChoice;
            } else {
                extinctionAddedUserChoice = userFirstChoice + " " + String.valueOf(repAbbrValue);
            }
        } else {
            extinctionAddedUserChoice = userFirstChoice;
        }
        String finalObj = extinctionAddedUserChoice;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//	Abbreviations add to Fourth Choice Service
    @Override
    @Transactional
    public JSONArray fourthChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn) {
    	LOGGER.debug("fourthChoiceAbbreviationAddingToJSP...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
        userFirstChoice = userFirstChoice.replace("$,$", "&");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Abbreviations Status take from BusinessFormsAttributesInfo DB        
        List<BusinessFormsAttributesInfo> abbrStatusList = bsFormAndStateAttrInfoDAOImpl.abbreviationStatusForAllTakeFromDB(formId, "TF4");
        String abbrStatus = null;
        for (BusinessFormsAttributesInfo abbrStList : abbrStatusList) {
            abbrStatus = abbrStList.getAbbrevationStatus();
        }
//		Replacement abbreviation take from Abbreviations DB
        List<Abbrevations> repAbbrList = abbrevationsDAOImpl.replacementAbbreviationTakeFromDB(formId);
        String repAbbrValue = null;
        for (Abbrevations repAbbrValueList : repAbbrList) {
            repAbbrValue = repAbbrValueList.getReplacementAbbrevation();
        }
//		Abbreviation Names List take from Abbreviations DB
        List<Object> abbreviationNamesList = (List<Object>) abbrevationsDAOImpl.abbreviationNamesListtakefromDB(formId);
//		Abbreviation Extinction Added Code
        String extinctionAddedUserChoice = null;        
        if ((!abbreviationNamesList.isEmpty()) && (abbrStatus != null)) {
            boolean choiceExt = false;
            String abbreviationNamesString = null;
            for (int i = 0; i < abbreviationNamesList.size(); i++) {
                Object abbreviationNamesObj = abbreviationNamesList.get(i);
                abbreviationNamesString = abbreviationNamesObj.toString();
                if (userFirstChoice.endsWith(abbreviationNamesString)) {
                    choiceExt = true;
                }
            }
            if (choiceExt == true) {
                extinctionAddedUserChoice = userFirstChoice;
            } else {
                extinctionAddedUserChoice = userFirstChoice + " " + String.valueOf(repAbbrValue);
            }
        } else {
            extinctionAddedUserChoice = userFirstChoice;
        }
        String finalObj = extinctionAddedUserChoice;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//	Abbreviations add to Fifth Choice Service
    @Override
    @Transactional
    public JSONArray fifthChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn) {
    	LOGGER.debug("fifthChoiceAbbreviationAddingToJSP...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
        userFirstChoice = userFirstChoice.replace("$,$", "&");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Abbreviations Status take from BusinessFormsAttributesInfo DB        
        List<BusinessFormsAttributesInfo> abbrStatusList = bsFormAndStateAttrInfoDAOImpl.abbreviationStatusForAllTakeFromDB(formId, "TFE103");
        String abbrStatus = null;
        for (BusinessFormsAttributesInfo abbrStList : abbrStatusList) {
            abbrStatus = abbrStList.getAbbrevationStatus();
        }
//		Replacement abbreviation take from Abbreviations DB			
        List<Abbrevations> repAbbrList = abbrevationsDAOImpl.replacementAbbreviationTakeFromDB(formId);
        String repAbbrValue = null;
        for (Abbrevations repAbbrValueList : repAbbrList) {
            repAbbrValue = repAbbrValueList.getReplacementAbbrevation();
        }
//		Abbreviation Names List take from Abbreviations DB
        List<Object> abbreviationNamesList = (List<Object>) abbrevationsDAOImpl.abbreviationNamesListtakefromDB(formId);
//		Abbreviation Extinction Added Code
        String extinctionAddedUserChoice = null;        
        if ((!abbreviationNamesList.isEmpty()) && (abbrStatus != null)) {
            boolean choiceExt = false;
            String abbreviationNamesString = null;
            for (int i = 0; i < abbreviationNamesList.size(); i++) {
                Object abbreviationNamesObj = abbreviationNamesList.get(i);
                abbreviationNamesString = abbreviationNamesObj.toString();
                if (userFirstChoice.endsWith(abbreviationNamesString)) {
                    choiceExt = true;
                }
            }
            if (choiceExt == true) {
                extinctionAddedUserChoice = userFirstChoice;
            } else {
                extinctionAddedUserChoice = userFirstChoice + " " + String.valueOf(repAbbrValue);
            }
        } else {
            extinctionAddedUserChoice = userFirstChoice;
        }
        String finalObj = extinctionAddedUserChoice;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//	Abbreviations add to Sixth Choice Service
    @Override
    @Transactional
    public JSONArray sixthChoiceAbbreviationAddingToJSP(String updatedAttrVal, HttpSession sn) {
    	LOGGER.debug("sixthChoiceAbbreviationAddingToJSP...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
        userFirstChoice = userFirstChoice.replace("$,$", "&");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//			Abbreviations Status take from BusinessFormsAttributesInfo DB        
        List<BusinessFormsAttributesInfo> abbrStatusList = bsFormAndStateAttrInfoDAOImpl.abbreviationStatusForAllTakeFromDB(formId, "TFE104");
        String abbrStatus = null;
        for (BusinessFormsAttributesInfo abbrStList : abbrStatusList) {
            abbrStatus = abbrStList.getAbbrevationStatus();
        }
//		Replacement abbreviation take from Abbreviations DB
        List<Abbrevations> repAbbrList = abbrevationsDAOImpl.replacementAbbreviationTakeFromDB(formId);
        String repAbbrValue = null;
        for (Abbrevations repAbbrValueList : repAbbrList) {
            repAbbrValue = repAbbrValueList.getReplacementAbbrevation();
        }
//		Abbreviation Names List take from Abbreviations DB
        List<Object> abbreviationNamesList = (List<Object>) abbrevationsDAOImpl.abbreviationNamesListtakefromDB(formId);
//		Abbreviation Extinction Added Code
        String extinctionAddedUserChoice = null;        
        if ((!abbreviationNamesList.isEmpty()) && (abbrStatus != null)) {
            boolean choiceExt = false;
            String abbreviationNamesString = null;
            for (int i = 0; i < abbreviationNamesList.size(); i++) {
                Object abbreviationNamesObj = abbreviationNamesList.get(i);
                abbreviationNamesString = abbreviationNamesObj.toString();
                if (userFirstChoice.endsWith(abbreviationNamesString)) {
                    choiceExt = true;
                }
            }
            if (choiceExt == true) {
                extinctionAddedUserChoice = userFirstChoice;
            } else {
                extinctionAddedUserChoice = userFirstChoice + " " + String.valueOf(repAbbrValue);
            }
        } else {
            extinctionAddedUserChoice = userFirstChoice;
        }
        String finalObj = extinctionAddedUserChoice;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }
    
//  Check out Payment data saving    
    @Override
    @Transactional
    public ModelAndView stateFormsCheckoutPaymentDataSaving(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("stateFormsCheckoutPaymentDataSaving...Service");
        ModelAndView mav;
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		All State forms price List take from DB
        List<Object> stateFormsPriceList = (List<Object>) stateFormsPriceInfoDAOImpl.allStateFormsPriceListTakeFromDB(formId);        
        		String processingFee = stateFormsPriceList.get(0).toString();
        		String stndFilingFee =  stateFormsPriceList.get(1).toString();        
//      Register Agent price take from DB       
        List<AllStateFormsDataSaving> regPriceList = allStateFormsDataSavingDAOImpl.allStateFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        String regAgentPriceInDB = null;
        String formFederalStatus = null;
        String formFederalLegalName = null;
        for (AllStateFormsDataSaving allSFDataModel : regPriceList) {
        	regAgentPriceInDB = allSFDataModel.getRegisteredAgentPrice();
        	formFederalStatus = allSFDataModel.getFederalStatus();
        	formFederalLegalName = allSFDataModel.getFormFederalLegalname();
        }        
        double regAgentFee = 0;
        if(regAgentPriceInDB != null){
        regAgentFee = Double.parseDouble(regAgentPriceInDB);    
        }        
        double processingFeeInDb = Double.parseDouble(processingFee);
        double stndFilingFeeInDb = Double.parseDouble(stndFilingFee);
        double totalPrice = processingFeeInDb + stndFilingFeeInDb + regAgentFee;
        String totalFee = String.format("%1$.2f", totalPrice);        
        List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        Timestamp currentDate = currentDate(); 
//      Invoice number generation
        String alphaNumerics = "1234567890";
        String t = "";
        for (int i = 0; i < 8; i++) {
        t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
        }
        String orderNumber = t;
        int invoiceNumber = Integer.parseInt(orderNumber);        
        if(allStateFormsPaymentList.isEmpty()){
//    		All State Forms Payment Info Saving
        	AllStateFormsPaymentInfoSaving allStateFormsPayment = new AllStateFormsPaymentInfoSaving();
        	int inialPrice = 0;
        	allStateFormsPayment.setUserName((String) sn.getAttribute(userNameInSn));
        	allStateFormsPayment.setStateName((String) sn.getAttribute(stateNameInSn));
        	allStateFormsPayment.setFormName((String) sn.getAttribute(formNameInSn));
        	allStateFormsPayment.setUserChoice((String) sn.getAttribute(userChoiceInSn));
        	allStateFormsPayment.setTypeOfDocument((String) sn.getAttribute(typeOfDocumentInSn));
        	allStateFormsPayment.setProcessingFee(processingFee);
        	allStateFormsPayment.setStandardFilingFee(stndFilingFee);
        	allStateFormsPayment.setTotalFee(totalFee);
        	allStateFormsPayment.setFormFedStatus(formFederalStatus);
        	allStateFormsPayment.setRegisteredAgentPrice(regAgentPriceInDB);
        	allStateFormsPayment.setCreatedDate(currentDate);
        	allStateFormsPayment.setBonusPrice(inialPrice);
        	allStateFormsPaymentSavingDAOImpl.save(allStateFormsPayment);        	
        	AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            stateFormsUpdateModel.setOrderNumber(invoiceNumber);
            stateFormsUpdateModel.setOrderNumberDate(currentDate);
            allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);
        } else{
        	AllStateFormsPaymentInfoSaving allStateFormsPaymentDataModel = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));        	 	
        	allStateFormsPaymentDataModel.setTotalFee(totalFee);
        	allStateFormsPaymentDataModel.setFormFedStatus(formFederalStatus);
        	allStateFormsPaymentDataModel.setRegisteredAgentPrice(regAgentPriceInDB);
        	allStateFormsPaymentDataModel.setUpdatedDate(currentDate);        	
        	allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentDataModel);        	
        }        
        int bonusPrice = 0;
        int oldBonusPrice = 0;
        if(req.getParameter(docPromoCode) != null){
//		Bonus Price getting from DB        	
        List<Object> promoCodeBonusPrice = (List<Object>) promoCodeBonusPriceDAOImpl.promoCodeBonusPriceTakeFromDB(req.getParameter(docPromoCode));
        if(!promoCodeBonusPrice.isEmpty()){
        String promoBonusPrice = promoCodeBonusPrice.get(0).toString();
        bonusPrice = Integer.parseInt(promoBonusPrice);
        oldBonusPrice = bonusPrice;
        }
        }		
        AllStateFormsPaymentInfoSaving allStateFormsPaymentPromoCode = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));        
        int dbBonusPrice = allStateFormsPaymentPromoCode.getBonusPrice();
        bonusPrice = stateFormsBonusPriceTakeFromDB(bonusPrice, dbBonusPrice);
               
        String onlyBonsPrice = null;
        String totalBonusPrice = null;
        String promoCodeDB = null;
        if(bonusPrice != 0){        	
            double onlyBonusPrice = processingFeeInDb*((double)bonusPrice)*0.01;
            double processBonusPrice = processingFeeInDb-onlyBonusPrice;
            String procesBonusPrice = String.format("%1$.2f", processBonusPrice);
            onlyBonsPrice = String.format("%1$.2f", onlyBonusPrice);                       
            double totalBunPrice = processBonusPrice + stndFilingFeeInDb + regAgentFee;        
            totalBonusPrice = String.format("%1$.2f", totalBunPrice);
            promoCodeDB = stateFormsPromoCodeTakeFromDB(oldBonusPrice, req.getParameter(docPromoCode));            
//    		All State Forms Payment Info updating
        	AllStateFormsPaymentInfoSaving allStateFormsPaymentModel = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));        	 
        	allStateFormsPaymentModel.setProcessingFee(procesBonusPrice);        	
        	allStateFormsPaymentModel.setTotalFee(totalBonusPrice);
        	allStateFormsPaymentModel.setFormFedStatus(formFederalStatus);
        	allStateFormsPaymentModel.setRegisteredAgentPrice(regAgentPriceInDB);
        	allStateFormsPaymentModel.setUpdatedDate(currentDate);
        	allStateFormsPaymentModel.setBonusPrice(bonusPrice);
        	allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentModel);        	
        	sn.setAttribute(paymentFeeTotal, totalBonusPrice);
        } else{
        	sn.setAttribute(paymentFeeTotal, totalFee);        
        }                
        mav = new ModelAndView("stateFormCheckoutPayment");
        mav.addObject(stateName, sn.getAttribute(stateNameInSn));
        mav.addObject(formName, sn.getAttribute(formNameInSn));
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));        
        mav.addObject("processingFee", processingFee);
        mav.addObject("stndFilingFee", stndFilingFee);
        mav.addObject("regAgentFee", regAgentPriceInDB);
        mav.addObject("formFederalStatus", formFederalStatus);
        mav.addObject("totalFee", totalFee);
        mav.addObject(docPromoCode, req.getParameter(docPromoCode));
        mav.addObject("onlyBonsPrice", onlyBonsPrice);
        mav.addObject("totalBonusPrice", totalBonusPrice);
        mav.addObject("bonusPrice", bonusPrice);        
        mav.addObject("dbBonusPrice", dbBonusPrice);
        mav.addObject("promoCodeDB", promoCodeDB);
        sn.setAttribute(regiAgentPriceInSn, regAgentPriceInDB);
        sn.setAttribute("formFederalStatusInSn", formFederalStatus);
        sn.setAttribute(formFedLegalNameInSn, formFederalLegalName);
        sn.setAttribute(invoiceNumbInSn, invoiceNumber);
        mav.addObject("paybleAmount", sn.getAttribute(paymentFeeTotal));
        return mav;
    }
    
//  Add to Cart state forms data saving    
    @Override
    @Transactional
    public String stateFormsPromoCodeTakeFromDB(int oldBonusPrice, String promoCode) {
	  LOGGER.debug("stateFormsPromoCodeTakeFromDB...Service");	  
	  String promoCodeDB = null;
	  if(oldBonusPrice > 0){
      	promoCodeDB = promoCode;
      } else{
      	promoCodeDB = null;	
      }
      return promoCodeDB;
    }
  
//	Add to Cart state forms data saving  
    @Override
    @Transactional
    public Integer stateFormsBonusPriceTakeFromDB(int bonusFee, int dbBonusPrice) {
	  LOGGER.debug("stateFormsBonusPriceTakeFromDB...Service");	  
	  int bonusPrice = 0;
	  if((dbBonusPrice > 0) && (bonusFee == 0 || dbBonusPrice == bonusFee)){
      	bonusPrice = dbBonusPrice;	
      } else{
      	bonusPrice = bonusFee;
      } 
    return bonusPrice;
    }
        
//  Add to Cart state forms data saving    
    @Override
    @Transactional
    public ModelAndView addToCartAllStateFormsData(HttpServletRequest req, HttpSession sn) {
	LOGGER.debug("addToCartAllStateFormsData...Service");
    ModelAndView mav;
    List allStateFormsPaymentList = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));      
    Timestamp currentDate = currentDate(); 
    if(allStateFormsPaymentList.isEmpty()){
//  	All State Forms Checkout Payment Info Saving
  	  	AllStateFormsCheckoutPaymentAndUserContactSaving allStateFormsCheckoutPaymentModel = new AllStateFormsCheckoutPaymentAndUserContactSaving();          	
        	allStateFormsCheckoutPaymentModel.setUserName((String) sn.getAttribute(userNameInSn));
        	allStateFormsCheckoutPaymentModel.setStateName((String) sn.getAttribute(stateNameInSn));
        	allStateFormsCheckoutPaymentModel.setFormName((String) sn.getAttribute(formNameInSn));
        	allStateFormsCheckoutPaymentModel.setUserChoice((String) sn.getAttribute(userChoiceInSn));
        	allStateFormsCheckoutPaymentModel.setTypeOfDocument((String) sn.getAttribute(typeOfDocumentInSn));
        	allStateFormsCheckoutPaymentModel.setInvoiceNum((Integer) sn.getAttribute("invoiceNumberInSn"));
        	allStateFormsCheckoutPaymentModel.setAmount((String) sn.getAttribute("paymentTotal"));
        	allStateFormsCheckoutPaymentModel.setCreatedDate(currentDate);
        	allStateFormsCheckoutPaymentModel.setDocumentRefType("State Documents");
        	allStateFormsCheckoutPaymentModel.setAddToCart("Yes");
        	allStateFormsCheckoutPaymentModel.setFormFedLegalname((String) sn.getAttribute("formFederalLegalNameInSn"));
        	allStateFormsCheckoutPaymentModel.setRegisteredAgentPrice((String) sn.getAttribute("regAgentPriceInSn"));          	
        	allStateFormsCheckoutPaymentDAOImpl.save(allStateFormsCheckoutPaymentModel);
        	int paymentId = allStateFormsCheckoutPaymentModel.getAllStateFormsCheckoutPaymentAndUserContactSavingId();
//        	All State Forms Add to Cart data saving
        	String selectedDocumentsName = sn.getAttribute(userChoiceInSn)+", "+sn.getAttribute(formNameInSn)+", "+sn.getAttribute(stateNameInSn)+".";
        	AllStateAndFederalFormsAddCartPaymentSaving allFormsAddCartPaymentModel = new AllStateAndFederalFormsAddCartPaymentSaving();
        	allFormsAddCartPaymentModel.setUserName((String) sn.getAttribute(userNameInSn));
        	allFormsAddCartPaymentModel.setSelectedDocumentsName(selectedDocumentsName);
        	allFormsAddCartPaymentModel.setTypeOfDocument((String) sn.getAttribute(typeOfDocumentInSn));
        	allFormsAddCartPaymentModel.setAmount((String) sn.getAttribute("paymentTotal"));
        	allFormsAddCartPaymentModel.setPaymentId(paymentId);
        	allFormsAddCartPaymentModel.setDocumentRefType("State Documents");
        	allFormsAddCartPaymentModel.setAddToCart("Yes");
        	allFormsAddCartPaymentModel.setStateName((String) sn.getAttribute(stateNameInSn));
        	allFormsAddCartPaymentModel.setFormName((String) sn.getAttribute(formNameInSn));
        	allFormsAddCartPaymentModel.setUserChoice((String) sn.getAttribute(userChoiceInSn));
        	allFormsAddCartPaymentModel.setCreatedDate(currentDate);
        	allFormsAddCartPaymentSavingDAOImpl.save(allFormsAddCartPaymentModel);        	
        	AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            stateFormsUpdateModel.setAddToCart("Yes");
            stateFormsUpdateModel.setOrderNumber((Integer) sn.getAttribute("invoiceNumberInSn")); 
            allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);            
            if(sn.getAttribute("formFederalLegalNameInSn") != null){
          	FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.stateFormsUserChoiceUpdationInFormFedDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
          	formFederalUpdateModel.setAddToCart("Yes");
            formFederalDataSavingDAOImpl.merge(formFederalUpdateModel);              
          }
    } else{
  	  AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));          
        allStateAndFedAddCartPayment.setAmount((String) sn.getAttribute("paymentTotal"));
        allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);        
        AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
        allStCheckoutPaymentAndUserContact.setAmount((String) sn.getAttribute("paymentTotal"));          
        allStCheckoutPaymentAndUserContact.setRegisteredAgentPrice((String) sn.getAttribute("regAgentPriceInSn"));
        allStCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
        allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
    }    
//	Added Cart form info take from DB to Jsp
    List<AllStateAndFederalFormsAddCartPaymentSaving> allFormsAddCartPaymentDataList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataTakeFromDB((String) sn.getAttribute(userNameInSn));
    int noOfDocsInCart = allFormsAddCartPaymentDataList.size();    
    List selectedDocumentsList = new ArrayList();
    List formPriceList = new ArrayList();
    List docReferanceTypeList = new ArrayList();
    List typeOfDocumentList = new ArrayList();
    double totalAmount = 0;
    String totalPriceValue = null;
    for (AllStateAndFederalFormsAddCartPaymentSaving allFormsAddCartPaymentData : allFormsAddCartPaymentDataList) {
  	  selectedDocumentsList.add(allFormsAddCartPaymentData.getSelectedDocumentsName());
  	  formPriceList.add(allFormsAddCartPaymentData.getAmount());
  	  docReferanceTypeList.add(allFormsAddCartPaymentData.getDocumentRefType()+" _ "+allFormsAddCartPaymentData.getPaymentId());
  	  typeOfDocumentList.add(allFormsAddCartPaymentData.getTypeOfDocument());  	  
  	  String priceInstr = allFormsAddCartPaymentData.getAmount();
  	   double docAmount = Double.parseDouble(priceInstr); 
  	   totalAmount = totalAmount + docAmount;
  	   totalPriceValue = String.format("%1$.2f", totalAmount);
    }    
    sn.setAttribute("AddCartDoc_Names_List", selectedDocumentsList);
    sn.setAttribute("AddCartDoc_Price_List", formPriceList);
    sn.setAttribute("AddCartRef_Type_List", docReferanceTypeList);
    sn.setAttribute("AddCartDoc_Type_List", typeOfDocumentList);
    mav = new ModelAndView("addToCartStateForms");
    mav.addObject(stateName, sn.getAttribute(stateNameInSn));
    mav.addObject(formName, sn.getAttribute(formNameInSn));
    mav.addObject(firstName, sn.getAttribute(firstNameInSn));
    mav.addObject(noOfDocInCart, noOfDocsInCart);
    mav.addObject("totalAmount", totalPriceValue);
    sn.setAttribute("allDocTotalAmount", totalPriceValue);    
    mav.addObject(userName, sn.getAttribute(userNameInSn));
    sn.setAttribute(noOfDocInCartInSn, noOfDocsInCart);      
    return mav;
}
  
//	Deletion Documents Data From Cart Service  
    @Override
    @Transactional
    public JSONArray deletionDocumentsDataFromCart(String updatedAttrVal, HttpSession sn) {
	LOGGER.debug("deletionDocumentsDataFromCart...Service");    
    String[] cartCombValue = updatedAttrVal.split(" _ ");
    int docPaymentId = Integer.parseInt(cartCombValue[1]);
    String docRefType = cartCombValue[0];    
    String payUserChoice = null;
    String payTypeOfDocument = null;    
    if(("State Documents").equals(docRefType)){
    List<AllStateFormsCheckoutPaymentAndUserContactSaving> checkoutPaymentDataList = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentValuesTakeFromDB(docPaymentId);    
    String payStateName = null;
    String payFormName = null;    
    String payFormFedName = null;
    for (AllStateFormsCheckoutPaymentAndUserContactSaving checkoutPaymentData : checkoutPaymentDataList) {
    	payStateName = checkoutPaymentData.getStateName();
  	  payFormName = checkoutPaymentData.getFormName();
  	  payUserChoice = checkoutPaymentData.getUserChoice();
  	  payTypeOfDocument = checkoutPaymentData.getTypeOfDocument();
  	  payFormFedName = checkoutPaymentData.getFormFedLegalname();
    }    
    AllStateFormsCheckoutPaymentAndUserContactSaving stateFormsCheckoutPaymentModel = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), payTypeOfDocument, payStateName, payFormName, payUserChoice);
    allStateFormsCheckoutPaymentDAOImpl.delete(stateFormsCheckoutPaymentModel);
    AllStateAndFederalFormsAddCartPaymentSaving stateFormsAddCartModel = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), payTypeOfDocument, payStateName, payFormName, payUserChoice);
    allFormsAddCartPaymentSavingDAOImpl.delete(stateFormsAddCartModel);
    AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), payTypeOfDocument, payFormName, payStateName, payUserChoice);
    stateFormsUpdateModel.setAddToCart(null);            
    allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);
    if(payFormFedName != null){
    FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.stateFormsUserChoiceUpdationInFormFedDB((String) sn.getAttribute(userNameInSn), payFormName, payStateName, payUserChoice);
	  formFederalUpdateModel.setAddToCart(null);
    formFederalDataSavingDAOImpl.merge(formFederalUpdateModel);
    }      
    } else if(("Federal Documents").equals(docRefType)){
        List<AllFederalFormsCheckoutPaymentAndUserContactSaving> fedCheckoutPaymentDataList = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentValuesTakeFromDB(docPaymentId);          
        for (AllFederalFormsCheckoutPaymentAndUserContactSaving fedCheckoutPaymentData : fedCheckoutPaymentDataList) {        	  
      	  payUserChoice = fedCheckoutPaymentData.getLegalName();
      	  payTypeOfDocument = fedCheckoutPaymentData.getFormStatus();        	  
        }                  
        AllFederalFormsCheckoutPaymentAndUserContactSaving allFedCheckoutPaymentAndUserContact = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), payTypeOfDocument, payUserChoice);
        allFedCheckoutPaymentAndContactDAOImpl.delete(allFedCheckoutPaymentAndUserContact);        
        AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allFederalFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), payTypeOfDocument, payUserChoice);          
        allFormsAddCartPaymentSavingDAOImpl.delete(allStateAndFedAddCartPayment);        
        AllFederalFormsDataSaving federalFormsAEModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), payTypeOfDocument, payUserChoice);          
        federalFormsAEModel.setAddToCart(null);            
        allFederalFormsSavingDAOImpl.merge(federalFormsAEModel);        
        } 
    String finalObj = "";
    JSONArray forms = new JSONArray();
    JSONObject jsonObj = new JSONObject();
    jsonObj.put(jSonObject, finalObj);
    forms.add(jsonObj);
    return forms;
    }
    
//	Add to Cart state forms data saving  
    @Override
    @Transactional
    public ModelAndView stateAndFedFormsCartDocDataDisplay(HttpServletRequest req, HttpSession sn) {
	LOGGER.debug("stateAndFedFormsCartDocDataDisplay...Service");    
//	  Added Cart form info take from DB to Jsp
    List<AllStateAndFederalFormsAddCartPaymentSaving> allFormsAddCartPaymentDataList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataTakeFromDB((String) sn.getAttribute(userNameInSn));
    int noOfDocsInCart = allFormsAddCartPaymentDataList.size();    
    List selectedDocumentsList = new ArrayList();
    List formPriceList = new ArrayList();
    List docReferanceTypeList = new ArrayList();
    List typeOfDocumentList = new ArrayList();
    double totalAmount = 0;
    String totalPriceValue = null;
    for (AllStateAndFederalFormsAddCartPaymentSaving allFormsAddCartPaymentData : allFormsAddCartPaymentDataList) {
  	  selectedDocumentsList.add(allFormsAddCartPaymentData.getSelectedDocumentsName());
  	  formPriceList.add(allFormsAddCartPaymentData.getAmount());
  	  docReferanceTypeList.add(allFormsAddCartPaymentData.getDocumentRefType()+" _ "+allFormsAddCartPaymentData.getPaymentId());
  	  typeOfDocumentList.add(allFormsAddCartPaymentData.getTypeOfDocument());  	  
  	  String priceInstr = allFormsAddCartPaymentData.getAmount();
  	   double docAmount = Double.parseDouble(priceInstr); 
  	   totalAmount = totalAmount + docAmount;
  	   totalPriceValue = String.format("%1$.2f", totalAmount);
    }
    ModelAndView mav;
    sn.setAttribute("AddCartDoc_Names_List", selectedDocumentsList);
    sn.setAttribute("AddCartDoc_Price_List", formPriceList);
    sn.setAttribute("AddCartRef_Type_List", docReferanceTypeList);
    sn.setAttribute("AddCartDoc_Type_List", typeOfDocumentList);
    if(noOfDocsInCart > 0){
    	mav = new ModelAndView("addToCartStateForms");
    } else{
    	mav = stateFormUserMyAccountRedirection(req, sn);
    }
    mav.addObject(firstName, sn.getAttribute(firstNameInSn));
    mav.addObject(noOfDocInCart, noOfDocsInCart);
    mav.addObject("totalAmount", totalPriceValue);    
    sn.setAttribute("allDocTotalAmount", totalPriceValue);    
    mav.addObject(userName, sn.getAttribute(userNameInSn));
    sn.setAttribute(noOfDocInCartInSn, noOfDocsInCart);    
    return mav;
}

//	Completed State Forms For User Data Display Service
    @Override
    @Transactional
    public ModelAndView completedStateFormsForUserDataDisplay(HttpServletRequest req, HttpSession sn) {
	LOGGER.debug("completedStateFormsForUserDataDisplay...Service");
    ModelAndView mav = new ModelAndView();
    if(sn.getAttribute(userNameInSn) != null) {
    List<AllStateFormsDataSaving> comStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.completedStateFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));
    int comStateFormsCount = comStateFormsSavingInfoList.size();    
    List<AllFederalFormsDataSaving> penFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.federalFormsSavingDataTakeFromDB((String) sn.getAttribute(userNameInSn));
    int pendFedFormsCount = penFederalFormsSavingInfoList.size();    
    List<AllStateFormsDataSaving> pndStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));    
    int penStateFormsCount = pndStateFormsSavingInfoList.size();    
    List<AllFederalFormsDataSaving> comFederalFormsSavingInfiList = allFederalFormsSavingDAOImpl.completedFederalFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));
    int completedFedFormsCount = comFederalFormsSavingInfiList.size();    
    if (!comStateFormsSavingInfoList.isEmpty()) {
        List<AllStateFormsDataSaving> completedFormSavingList = new ArrayList<AllStateFormsDataSaving>();
        for (AllStateFormsDataSaving comStateFormsInfo : comStateFormsSavingInfoList) {
            AllStateFormsDataSaving allComStateFormsInfoModel = new AllStateFormsDataSaving();
            allComStateFormsInfoModel.setStateName(comStateFormsInfo.getStateName());
            allComStateFormsInfoModel.setFormName(comStateFormsInfo.getFormName());
            allComStateFormsInfoModel.setUserChoice(comStateFormsInfo.getUserChoice());
            allComStateFormsInfoModel.setOrderNumber(comStateFormsInfo.getOrderNumber());
            allComStateFormsInfoModel.setTypeOfDocument(comStateFormsInfo.getTypeOfDocument());                       
            allComStateFormsInfoModel.setOrderNumberDate(comStateFormsInfo.getOrderNumberDate());
            completedFormSavingList.add(allComStateFormsInfoModel);
        }        
        mav = new ModelAndView("completedStateFormsForUser");
        mav.addObject("completedFormSavingList", completedFormSavingList);
        mav.addObject(compStateFormCount, comStateFormsCount);
    }	
    mav.addObject(firstName, sn.getAttribute(firstNameInSn));
    mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));    
    mav.addObject(penFedFormCount, pendFedFormsCount);
    mav.addObject(pendStateFormCount, penStateFormsCount);
    mav.addObject(compFedFormCount, completedFedFormsCount);
    } else{
		mav = usersInformationServiceImpl.logInHome(req, sn);
	}
    return mav;
    }

//	Completed State Forms For Admin Data Display Service
    @Override
    @Transactional
    public ModelAndView completedStateFormsForAdminDataDisplay(HttpServletRequest req, HttpSession sn) {
	LOGGER.debug("completedStateFormsForAdminDataDisplay...Service");  
	  String asfCombValue = (String) req.getParameter("documentName");  
	  String[] combValue = asfCombValue.split(",&, ");	  
	  ModelAndView mav = new ModelAndView();
	  List<AllStateFormsCheckoutPaymentAndUserContactSaving> comStateFormsSavingAdminList = allStateFormsCheckoutPaymentDAOImpl.completedStateFormsForAdminDataFromDB((String) sn.getAttribute(userNameInSn), combValue[0], combValue[1], combValue[2], combValue[3]);
	  int invoiceNum = 0;
	  String orderReceived = null;
	  Timestamp orderReceivedCreatedDate = null;
	  String orderProcessed = null;
	  Timestamp orderProcessedCreatedDate = null;
	  String eSignature = null;
	  Timestamp eSignatureCreatedDate = null;
	  String docFiled = null;
	  Timestamp docFiledCreatedDate = null;
	  String docAccepted = null;
	  Timestamp docAcceptedCreatedDate = null;
	  String docEmailed = null;
	  Timestamp docEmailedCreatedDate = null;	  
	  if (!comStateFormsSavingAdminList.isEmpty()) {      
      for (AllStateFormsCheckoutPaymentAndUserContactSaving comStateFormsAdminInfo : comStateFormsSavingAdminList) {          
    	  invoiceNum = comStateFormsAdminInfo.getInvoiceNum();
    	  orderReceived = comStateFormsAdminInfo.getOrderReceived();
    	  orderReceivedCreatedDate = comStateFormsAdminInfo.getOrderReceivedCreatedDate();
    	  orderProcessed = comStateFormsAdminInfo.getOrderProcessed();
    	  orderProcessedCreatedDate = comStateFormsAdminInfo.getOrderProcessedCreatedDate();
    	  eSignature = comStateFormsAdminInfo.getSignature();
    	  eSignatureCreatedDate = comStateFormsAdminInfo.getSignatureCreatedDate();
    	  docFiled = comStateFormsAdminInfo.getDocFiled();
    	  docFiledCreatedDate = comStateFormsAdminInfo.getDocFiledCreatedDate();
    	  docAccepted = comStateFormsAdminInfo.getDocAccepted();
    	  docAcceptedCreatedDate = comStateFormsAdminInfo.getDocAcceptedCreatedDate();
    	  docEmailed = comStateFormsAdminInfo.getDocEmailed();
    	  docEmailedCreatedDate = comStateFormsAdminInfo.getDocEmailedCreatedDate();    	           
      }        
      mav = new ModelAndView("completedStateFormsForAdmin");
	  }  
	  List<AllFederalFormsDataSaving> penFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.federalFormsSavingDataTakeFromDB((String) sn.getAttribute(userNameInSn));
	  List<AllStateFormsDataSaving> pndStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));    
	  List<AllFederalFormsDataSaving> comFederalFormsSavingInfiList = allFederalFormsSavingDAOImpl.completedFederalFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));
	  mav.addObject(firstName, sn.getAttribute(firstNameInSn));
	  mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));    
	  mav.addObject(penFedFormCount, penFederalFormsSavingInfoList.size());
	  mav.addObject(pendStateFormCount, pndStateFormsSavingInfoList.size());
	  mav.addObject(compFedFormCount, comFederalFormsSavingInfiList.size());
	  mav.addObject("comFormsAdminCount", comStateFormsSavingAdminList.size());  
	  mav.addObject("invoiceNum", invoiceNum);
	  mav.addObject("orderReceived", orderReceived);
	  mav.addObject("orderReceivedCreatedDate", orderReceivedCreatedDate);
	  mav.addObject("orderProcessed", orderProcessed);
	  mav.addObject("orderProcessedCreatedDate", orderProcessedCreatedDate);
	  mav.addObject("eSignature", eSignature);
	  mav.addObject("eSignatureCreatedDate", eSignatureCreatedDate);
	  mav.addObject("docFiled", docFiled);
	  mav.addObject("docFiledCreatedDate", docFiledCreatedDate);
	  mav.addObject("docAccepted", docAccepted);
	  mav.addObject("docAcceptedCreatedDate", docAcceptedCreatedDate);
	  mav.addObject("docEmailed", docEmailed);
	  mav.addObject("docEmailedCreatedDate", docEmailedCreatedDate);  
	  return mav;
	}

//	  Authorize.net Credit Card Redirection Service Implementation 
	  @Override
	  @Transactional
	  public ModelAndView authorizeCreditCardRedirectionDisplay(HttpServletRequest req, HttpSession sn) {
	  LOGGER.debug("authorizeCreditCardRedirectionDisplay...Service");
	  ModelAndView mav = new ModelAndView();
	  List statesList = statesDAOImpl.findByStateList();	  
	  mav = new ModelAndView("authorizeCreditCardRedirection");	  
	  sn.setAttribute("allDocTotalAmount", req.getParameter("amount"));
	  mav.addObject(firstName, sn.getAttribute(firstNameInSn));	  
	  mav.addObject("amount", req.getParameter("amount"));
	  mav.addObject(userName, sn.getAttribute(userNameInSn));
	  mav.addObject("firstChoice", sn.getAttribute(userChoiceInSn));
	  mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
	  mav.addObject("stateList", statesList);
	  return mav;
	  }

//	  Convert From String Value To JSON Format
	  @Override
	  @Transactional
	  public JSONObject convertFromStringToJSONFormat(String capturedInfoInDB) {
		  LOGGER.debug("convertFromStringToJsonFormat...Service");
		  JSONParser parser = new JSONParser();
		  JSONObject capInfoJsonObject = new JSONObject();	
		  try {
			  Object parseObj = parser.parse(capturedInfoInDB);
			  capInfoJsonObject = (JSONObject) parseObj;
		  } catch (ParseException e) {
			  LOGGER.error("Convert String To Json Format is Fail " + e);
		  }
		  return capInfoJsonObject;
	}  

//	current date
	@Override
	@Transactional
	public Timestamp currentDate() {
		LOGGER.debug("currentDate...method");
		java.util.Date date = new java.util.Date();
		Timestamp currentDate = new Timestamp(date.getTime());    
		return currentDate;
	}

//	Form Id getting from DB
	@Override
	@Transactional
	public int takeFormIdFromDB(HttpSession sn) {
		LOGGER.debug("takeFormIdFromDB...method");		
		List<Forms> stFormId = bsFormAndStateAttrInfoDAOImpl.stateFormsIdValueFromDB((String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn));
		int formId = 0;
		for (Forms formsInfo : stFormId) {
		    formId = formsInfo.getFormId();
		}	
		return formId;
	}

}
