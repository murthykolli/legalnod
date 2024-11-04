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
import com.legalnod.daoimpl.AllStateAndFederalFormsAddCartPaymentSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsPaymentInfoSavingDAOImpl;
import com.legalnod.daoimpl.FederalFormsPriceInfoDAOImpl;
import com.legalnod.model.AdditionalFormsAttributesAndValuesSaving;
import com.legalnod.model.AdditionalFormsAttributesInfo;
import com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving;
import com.legalnod.model.AllStateFormsCheckoutPaymentAndUserContactSaving;
import com.legalnod.model.AllStateFormsDataSaving;
import com.legalnod.model.AllStateFormsPaymentInfoSaving;
import com.legalnod.model.Forms;
import com.legalnod.service.AdditionalService;

public class AdditionalServiceImpl implements AdditionalService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdditionalServiceImpl.class);

    private String firstName = "firstName";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCart = "noOfDocInCart";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";
    private String userNameInSn = "userNameInSn";
    private String userChoiceInSn = "userChoiceInSn";
    private String typeOfDocumentInSn = "typeOfDocumentInSn";
    private String formNameInSn = "formNameInSn";
    private String formName = "formName";
    private String stateNameInSn = "stateNameInSn";
    private String stateName = "stateName";
    private String formIdInSn = "formIdInSn";
    private String userIdInSn = "userIdInSn";
    private String textField1 = "textField1";    
    private String additionalForm = "Additional Forms";
    private String addSerFormModification = "additionalSerFormModification";
    private String textFieldsList = "textFieldList";
    private String textAreasList = "textAreaList";
    private String dateFieldsList = "dateFieldList";
    private String selectBoxesList = "selectBoxList";
    private String zipCodesList = "zipCodeList";
    private String radioButtonsList = "radioButtonList";
    private String checkBoxsList = "checkBoxList";    
    private String radioButStatus = "RadioButtonStatus";
    private String attReqiTypeIdsInSn = "attrReqTypeIdsInSn";
    private String stateFormHiddenVarb = "stateFormHiddenVar";
    private String stateFormsPageValue = "stateFormPageValues";    
    private String asAttrbRequiredList = "AS_Attribute_Required_List";
    private String asAttrbRadioStatusList = "AS_Attribute_RadioStatus_List";
    private String asAttrbInnerRadioList = "AS_Attribute_InnerRadio_List";
    private String asAttrbAddAnotherList = "AS_Attribute_AddAnother_List";
    private String asAttrbNamesList = "AS_Attribute_Names_List";
    private String asAttrbValuesList = "AS_Attribute_Values_List";
    private String textField100 = "textField100";
    private String radioButton100 = "radioButton100";
    private String yes = "yes";
    private String no = "no";
    private String tf1 = "TF1";

    @Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;

    @Autowired
    private AdditionalFormsAttributesInfoDAOImpl additionalFormsAttrInfoDAOImpl;

    @Autowired
    private AdditionalFormsAttributesAndValuesSavingDAOImpl addSerFormAttrAndValSavingDAOImpl;

    @Autowired
    private StateFormsServiceImpl stateFormsServiceImpl;

    @Autowired
    private AllStateFormsPaymentInfoSavingDAOImpl allStateFormsPaymentSavingDAOImpl;

    @Autowired
    private AllStateAndFederalFormsAddCartPaymentSavingDAOImpl allFormsAddCartPaymentSavingDAOImpl;

    @Autowired
    private AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl allStateFormsCheckoutPaymentDAOImpl;

    @Autowired
    private FederalFormsPriceInfoDAOImpl federalFormsPriceInfoDAOImpl;

//	AStart Point of dditional Service Form modification Service Implementation	
    @Override
    @Transactional
    public ModelAndView additionalServiceFormDataSavingAndUpdatingInDB(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("additionalServiceFormDataSavingAndUpdatingInDB...Service");
        String regAgentPrice = additionalServiceFormRegistredAgentPrice(req, sn);
        JSONObject stateFormInfoObj = addSerFormsAllAttributesInfoFromJSP(req, sn);
        ModelAndView mav;
        //Already Exit User choice when ever directly clicking enter with out using mouse
        List userAEChoiceList = allStateFormsDataSavingDAOImpl.allStateFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), req.getParameter(textField1));
        String alreadyExitChoice = null;
        if (!userAEChoiceList.isEmpty()) {
            AllStateFormsDataSaving stateFormsAEModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), req.getParameter(textField1));
            alreadyExitChoice = stateFormsAEModel.getUserChoice();
        }
        if (alreadyExitChoice != null && !alreadyExitChoice.equals(sn.getAttribute(userChoiceInSn))) {
            mav = new ModelAndView(addSerFormModification);
            mav.addObject("AlreadyExitChoice", "AlreadyExitUserChoice");
        } else {
//			Data Saving to DB tables
            String formStatus = additionalServiceFormStatusInDB(req, sn);
            String jsonStringObj = stateFormInfoObj.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            int formId = takeFormIdFromDB(sn);
            Forms formsId = new Forms();
            formsId.setFormId(formId);
            Timestamp currentDate = currentDate();
            if (sn.getAttribute(userChoiceInSn) == null) {
//				Only Additional Service  Forms Data saving in DB
                AdditionalFormsAttributesAndValuesSaving addSerAttrAndValModel = new AdditionalFormsAttributesAndValuesSaving();
                addSerAttrAndValModel.setUserId((Integer) sn.getAttribute(userIdInSn));
                addSerAttrAndValModel.setForms(formsId);
                addSerAttrAndValModel.setUserChoice(req.getParameter(textField1));
                addSerAttrAndValModel.setCapturedInformation(jsonStringObj);
                addSerAttrAndValModel.setCreatedDate(currentDate);
                addSerFormAttrAndValSavingDAOImpl.save(addSerAttrAndValModel);
//				Data Saving to All state forms data saving DB
                AllStateFormsDataSaving allStateFormsModel = new AllStateFormsDataSaving();
                allStateFormsModel.setUserName((String) sn.getAttribute(userNameInSn));
                allStateFormsModel.setTypeOfDocument(additionalForm);
                allStateFormsModel.setFormName((String) sn.getAttribute(formNameInSn));
                allStateFormsModel.setStateName((String) sn.getAttribute(stateNameInSn));
                allStateFormsModel.setUserChoice(req.getParameter(textField1));
                allStateFormsModel.setStatus(formStatus);
                allStateFormsModel.setRegisteredAgentPrice(regAgentPrice);
                allStateFormsModel.setCreatedDate(currentDate);
                allStateFormsModel.setPageVariableReference(req.getParameter(stateFormsPageValue));
                allStateFormsModel.setFormStatus(req.getParameter(stateFormHiddenVarb));
                allStateFormsDataSavingDAOImpl.save(allStateFormsModel);
            } else {
                AdditionalFormsAttributesAndValuesSaving addAttrAndValModel = addSerFormAttrAndValSavingDAOImpl.findByAddSerFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
                addAttrAndValModel.setUserChoice(req.getParameter(textField1));
                addAttrAndValModel.setCapturedInformation(jsonStringObj);
                addAttrAndValModel.setModifiedDate(currentDate);
                addSerFormAttrAndValSavingDAOImpl.merge(addAttrAndValModel);
                AllStateFormsDataSaving stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
                stateFormsModel.setUserChoice(req.getParameter(textField1));
                stateFormsModel.setStatus(formStatus);
                stateFormsModel.setModifiedDate(currentDate);
                stateFormsModel.setRegisteredAgentPrice(regAgentPrice);
                stateFormsModel.setPageVariableReference(req.getParameter(stateFormsPageValue));
                stateFormsModel.setFormStatus(req.getParameter(stateFormHiddenVarb));
                allStateFormsDataSavingDAOImpl.merge(stateFormsModel);
//              All related tables updating
                if(!(sn.getAttribute(userChoiceInSn)).equals(req.getParameter(textField1))){		                	
                    mav = additionalFormsAllRelatedOtherTablesUpdate(req, sn); 
                }
            }
            sn.setAttribute(userChoiceInSn, req.getParameter(textField1));
            if (req.getParameter(stateFormHiddenVarb) != null && ("Finished").equals(req.getParameter(stateFormHiddenVarb))) {
                mav = additionalServiceFormsCheckouDataDisplay(req, sn);
            } else {
                mav = new ModelAndView(addSerFormModification);
            }
            mav.addObject(stateFormsPageValue, req.getParameter(stateFormsPageValue));
            sn.setAttribute(asAttrbRequiredList, sn.getAttribute(asAttrbRequiredList));
            sn.setAttribute(asAttrbRadioStatusList, sn.getAttribute(asAttrbRadioStatusList));
            sn.setAttribute(asAttrbInnerRadioList, sn.getAttribute(asAttrbInnerRadioList));
            sn.setAttribute(asAttrbAddAnotherList, sn.getAttribute(asAttrbAddAnotherList));
            sn.setAttribute(asAttrbNamesList, sn.getAttribute(asAttrbNamesList));
            sn.setAttribute(asAttrbValuesList, sn.getAttribute(asAttrbValuesList));
            sn.setAttribute(radioButStatus, sn.getAttribute(radioButStatus));
            sn.setAttribute(typeOfDocumentInSn, additionalForm);
        }
        mav.addObject(textFieldsList, req.getAttribute(textFieldsList));
        mav.addObject(textAreasList, req.getAttribute(textAreasList));
        mav.addObject(dateFieldsList, req.getAttribute(dateFieldsList));
        mav.addObject(selectBoxesList, req.getAttribute(selectBoxesList));
        mav.addObject(zipCodesList, req.getAttribute(zipCodesList));
        mav.addObject(radioButtonsList, req.getAttribute(radioButtonsList));
        mav.addObject(checkBoxsList, req.getAttribute(checkBoxsList));
        mav.addObject(stateName, (String) sn.getAttribute(stateNameInSn));
        mav.addObject(formName, (String) sn.getAttribute(formNameInSn));
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }
    
//	Additional Service Registered Agent price
    @Override
    @Transactional
    public String additionalServiceFormRegistredAgentPrice(HttpServletRequest req, HttpSession sn) {
        String regAgentPrice = null;
        if (req.getParameter(radioButton100) != null && ("yes100").equals(req.getParameter(radioButton100))) {
            req.setAttribute(textField100, "LegalNod Registered Agent");
            List<Object> processingPrice = (List<Object>) federalFormsPriceInfoDAOImpl.federalFormPriceProperty("Registered Agent");
            if (!processingPrice.isEmpty()) {
                regAgentPrice = processingPrice.get(0).toString();
            }
        } else {
            req.setAttribute(textField100, "");
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
        	List allStChPaymentAndUserContactList = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentRowVerification((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            if(!allStChPaymentAndUserContactList.isEmpty()){
            	AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
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
                        AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                        allStateFormsPaymentInfoSaving.setTotalFee(totalDocAmount);
                        allStateFormsPaymentInfoSaving.setRegisteredAgentPrice(regAgentPrice);
                        allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);                        
                        AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));                        
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
                            AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                            allStateFormsPaymentInfoSaving.setTotalFee(totalDocAmount);
                            allStateFormsPaymentInfoSaving.setRegisteredAgentPrice(regAgentPrice);
                            allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);                            
                            AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));                        
                            allStateAndFedAddCartPayment.setAmount(totalDocAmount);                        
                            allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);                    	
                        }
                    }
            }        
    	return mav;
    }

//   Additional Service Form Status
    @Override
    @Transactional
    public String additionalServiceFormStatusInDB(HttpServletRequest req, HttpSession sn) {
        String formStatus = null;
        JSONObject stateFormInfoObj = addSerFormsAllAttributesInfoFromJSP(req, sn);
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

//	Additional Service Data take from JSP
    @Override
    @Transactional
    public JSONObject additionalServiceFormsFiveAttributesInfoFromJSP(HttpServletRequest req) {
        LOGGER.debug("additionalServiceFormsInfoFromJSP...Service");
        JSONObject stateFormInfoObj = new JSONObject();
        String textFieldList = null;
        String[] textField = new String[151];
        for (int i = 1; i < textField.length; i++) {
            if (i == 100) {
                textFieldList = textFieldList + req.getAttribute(textField100) + ",$,";
                stateFormInfoObj.put(i, req.getAttribute(textField100));
            } else {
                textField[i] = req.getParameter("textField" + i);
                textFieldList = textFieldList + textField[i] + ",$,";
                stateFormInfoObj.put(i, textField[i]);
            }
        }
        textFieldList = textFieldList.replace("null", "");
        String textAreaList = null;
        String[] textArea = new String[21];
        for (int l = 1; l < textArea.length; l++) {
            textArea[l] = req.getParameter("textArea" + l);
            textAreaList = textAreaList + textArea[l] + ",$,";
            stateFormInfoObj.put(l + 150, textArea[l]);
        }
        textAreaList = textAreaList.replace("null", "");
        textAreaList = textAreaList.replaceAll("[\n\r]", " ");
        String dateFieldList = null;
        String[] dateField = new String[21];
        for (int m = 1; m < dateField.length; m++) {
            dateField[m] = req.getParameter("dateField" + m);
            dateFieldList = dateFieldList + dateField[m] + ",$,";
            stateFormInfoObj.put(m + 170, dateField[m]);
        }
        dateFieldList = dateFieldList.replace("null", "");
        String selectBoxList = null;
        String[] selectBox = new String[51];
        for (int n = 1; n < selectBox.length; n++) {
            selectBox[n] = req.getParameter("selectBox" + n);
            selectBoxList = selectBoxList + selectBox[n] + ",$,";
            stateFormInfoObj.put(n + 190, selectBox[n]);
        }
        selectBoxList = selectBoxList.replace("null", "");
        String zipCodeList = null;
        String[] zipCode = new String[41];
        for (int k = 1; k < zipCode.length; k++) {
            zipCode[k] = req.getParameter("zipCode" + k);
            zipCodeList = zipCodeList + zipCode[k] + ",$,";
            stateFormInfoObj.put(k + 240, zipCode[k]);
        }
        zipCodeList = zipCodeList.replace("null", "");
        req.setAttribute(textFieldsList, textFieldList);
        req.setAttribute(textAreasList, textAreaList);
        req.setAttribute(dateFieldsList, dateFieldList);
        req.setAttribute(selectBoxesList, selectBoxList);
        req.setAttribute(zipCodesList, zipCodeList);
        return stateFormInfoObj;
    }

//	Additional Service Data take from JSP
    @Override
    @Transactional
    public JSONObject addSerFormsAllAttributesInfoFromJSP(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("addSerFormsattributesCheckboxInfoFromJSP...Service");
        JSONObject stateFormInfoObj = additionalServiceFormsFiveAttributesInfoFromJSP(req);
        String radioButtonList = null;
        String[] radioButton = new String[151];
        for (int o = 1; o < radioButton.length; o++) {
            radioButton[o] = req.getParameter("radioButton" + o);
            radioButtonList = radioButtonList + radioButton[o] + ",$,";
            stateFormInfoObj.put(o + 280, radioButton[o]);
        }
        radioButtonList = radioButtonList.replace("null", "");
        String checkBoxList = null;
        String[] checkBox = new String[101];
        for (int p = 1; p < checkBox.length; p++) {
            String checkSingele = req.getParameter("checkBox" + p);
            if (checkSingele != null) {
                String[] checkBoxVal = req.getParameterValues("checkBox" + p);
                String ddynamicCheckValue = "";
                for (int q = 0; q < checkBoxVal.length; q++) {                	
                    ddynamicCheckValue = ddynamicCheckValue + ", " + checkBoxVal[q];                    
                    ddynamicCheckValue = ddynamicCheckValue.replace("(", "");
                    ddynamicCheckValue = ddynamicCheckValue.replace(")", "");                                       
                }                
                ddynamicCheckValue = ddynamicCheckValue.replaceFirst(", ", "");
                checkBoxList = checkBoxList + ddynamicCheckValue + ",$,";
                stateFormInfoObj.put(p + 430, ddynamicCheckValue);
            } else {
                checkBoxList = checkBoxList + checkSingele + ",$,";
                stateFormInfoObj.put(p + 430, checkSingele);
            }
        }
        checkBoxList = checkBoxList.replace("null", "");
        req.setAttribute(textFieldsList, req.getAttribute(textFieldsList));
        req.setAttribute(textAreasList, req.getAttribute(textAreasList));
        req.setAttribute(dateFieldsList, req.getAttribute(dateFieldsList));
        req.setAttribute(selectBoxesList, req.getAttribute(selectBoxesList));
        req.setAttribute(zipCodesList, req.getAttribute(zipCodesList));
        req.setAttribute(radioButtonsList, radioButtonList);
        req.setAttribute(checkBoxsList, checkBoxList);
        return stateFormInfoObj;
    }
      
//    Additional Forms All Related Other Tables Update		    
	  @Override
	  @Transactional
	  public ModelAndView additionalFormsAllRelatedOtherTablesUpdate(HttpServletRequest req, HttpSession sn) {
		  LOGGER.debug("additionalFormsAllRelatedOtherTablesUpdate...Service");
		  ModelAndView mav = new ModelAndView();
		  Timestamp currentDate = currentDate(); 		  
		  List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
          if (!allStateFormsPaymentList.isEmpty()) {
              AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              allStateFormsPaymentInfoSaving.setUserChoice(req.getParameter(textField1));
              allStateFormsPaymentInfoSaving.setUpdatedDate(currentDate);
              allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);
          }
          List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
          if (!allFormsAddCartPaymentList.isEmpty()) {
              AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              String combValue = req.getParameter(textField1) + ", " + (String) sn.getAttribute(formNameInSn) + ", " + sn.getAttribute(stateNameInSn) + ".";
              allStateAndFedAddCartPayment.setUserChoice(req.getParameter(textField1));
              allStateAndFedAddCartPayment.setSelectedDocumentsName(combValue);
              allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
              AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              allStCheckoutPaymentAndUserContact.setUserChoice(req.getParameter(textField1));
              allStCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
              allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
          }             	       
	  return mav;
	  }

//	End point of Additional Service Form Modification
    @Override
    @Transactional
    public ModelAndView additionalServiceFormsDataModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("additionalServiceFormsDataModification...Service");
        ModelAndView mav = new ModelAndView();
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Required values take from DB
        List<AdditionalFormsAttributesInfo> addSerFormAttrList = additionalFormsAttrInfoDAOImpl.additionalServiceDynamicFormShowHideData(formId);
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
        sn.setAttribute(asAttrbRequiredList, attRequiredList);
        sn.setAttribute(asAttrbRadioStatusList, attRadioStatusList);
        sn.setAttribute(asAttrbInnerRadioList, innerRadioList);
        sn.setAttribute(asAttrbAddAnotherList, addAnotherList);
//		Additional Service form attribute fields and values take from DB this is simple join method
        List<Object> formFieldsAndValues = (List<Object>) additionalFormsAttrInfoDAOImpl.additionalServiceFormsDynamicFieldsAndValues(formId);
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
        sn.setAttribute(asAttrbNamesList, attNames);
        sn.setAttribute(asAttrbValuesList, attValue);
//		Additional Service forms Attribute Required type Ids take from DB 
        List<Object> attrReqTypeIdsList = (List<Object>) additionalFormsAttrInfoDAOImpl.addSerAttributeReqTypeIDsList(formId);
        String attrReqTypeIds = attrReqTypeIdsList.toString();
        attrReqTypeIds = attrReqTypeIds.replace("[", "");
        attrReqTypeIds = attrReqTypeIds.replace("]", "");
//		Radio Button Status take from DB 			
        List<Object> radioButtonStatus = (List<Object>) additionalFormsAttrInfoDAOImpl.additionalServiceRadioButtonStatus(formId);
        mav = additionalServiceFormsModificationAttributesInfo(req, sn);
        AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
        String stateFormPageValues = stateFormsUpdateModel.getPageVariableReference();
        mav = new ModelAndView(addSerFormModification);
        mav.addObject(textFieldsList, req.getAttribute(textFieldsList));
        mav.addObject(textAreasList, req.getAttribute(textAreasList));
        mav.addObject(dateFieldsList, req.getAttribute(dateFieldsList));
        mav.addObject(selectBoxesList, req.getAttribute(selectBoxesList));
        mav.addObject(zipCodesList, req.getAttribute(zipCodesList));
        mav.addObject(radioButtonsList, req.getAttribute(radioButtonsList));
        mav.addObject(checkBoxsList, req.getAttribute(checkBoxsList));
        mav.addObject(stateName, (String) sn.getAttribute(stateNameInSn));
        mav.addObject(formName, (String) sn.getAttribute(formNameInSn));
        mav.addObject(stateFormsPageValue, stateFormPageValues);
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject(radioButStatus, radioButtonStatus);
        sn.setAttribute(formIdInSn, formId);
        sn.setAttribute(radioButStatus, radioButtonStatus);
        sn.setAttribute(attReqiTypeIdsInSn, attrReqTypeIds);
        sn.setAttribute(stateNameInSn, (String) sn.getAttribute(stateNameInSn));
        sn.setAttribute(formNameInSn, (String) sn.getAttribute(formNameInSn));
        return mav;
    }

//	Additional Service Form Modification Attributes info
    @Override
    @Transactional
    public ModelAndView additionalServiceFormsModificationAttributesInfo(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("additionalServiceFormsModificationAttributesInfo...Service");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
        ModelAndView mav = new ModelAndView();
        List<AdditionalFormsAttributesAndValuesSaving> addSerFormAttrAndValModel = addSerFormAttrAndValSavingDAOImpl.findByAddtionalSerViceFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
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
            LOGGER.error("additionalServiceFormsDataModification " + e);
        }
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
        req.setAttribute(radioButtonsList, radioButtonList);
        req.setAttribute(checkBoxsList, checkBoxList);
        return mav;
    }

//	Additional Service Forms Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView additionalServiceFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("additionalServiceFormsCheckouDataDisplay...Service");
        ModelAndView mav = new ModelAndView();
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Required values take from DB
        List<AdditionalFormsAttributesAndValuesSaving> addSerFormAttrAndValModel = addSerFormAttrAndValSavingDAOImpl.findByAddtionalSerViceFormsCapturedInfoFromDB((Integer) sn.getAttribute("userIdInSn"), formId, (String) sn.getAttribute(userChoiceInSn));
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
            LOGGER.error("additionalServiceFormsCheckouDataDisplay " + e);
        }
//		State forms Ids take from DB 			
        List attrNamesList = new ArrayList();
        List attrFieldIdsList = new ArrayList();
        List attrTypeList = new ArrayList();
        List<Object> formFieldsAndValuesIds = (List<Object>) additionalFormsAttrInfoDAOImpl.additionalServiceFormsDynamicFieldsAndValuesIDs(formId);
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
        mav = new ModelAndView("additionalServiceFormCheckoutDisplayCreation");
        sn.setAttribute("Attr_AS_Names_CheckOutList", attrSTNamesList);
        sn.setAttribute("Attr_AS_Type_CheckOutList", attrSTTypeList);
        sn.setAttribute("Attr_AS_Values_CheckOutList", attrSTValuesList);
        sn.setAttribute("Attr_IDs_AS_CheckOutList", attrSTIdsList);
        mav.addObject(stateName, (String) sn.getAttribute(stateNameInSn));
        mav.addObject(formName, (String) sn.getAttribute(formNameInSn));
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        sn.setAttribute(formIdInSn, formId);
        sn.setAttribute(stateNameInSn, sn.getAttribute(stateNameInSn));
        sn.setAttribute(formNameInSn, (String) sn.getAttribute(formNameInSn));
        return mav;
    }

//	Additional Service First Choice Checking Service
    @Override
    @Transactional
    public JSONArray jSonAdditionalServiceFirstChoiceChecking(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("jSonAdditionalServiceFirstChoiceChecking...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
//		User Choice take from DB        
        List userChoiceList = allStateFormsDataSavingDAOImpl.allStateFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), additionalForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), userFirstChoice);
        String userChoiceInDB = null;
        if (!userChoiceList.isEmpty()) {
            userChoiceInDB = userFirstChoice;
        }
        if (userChoiceInDB != null && sn.getAttribute(userChoiceInSn) != null && sn.getAttribute(userChoiceInSn).equals(userChoiceInDB)) {
            userChoiceInDB = null;
        }
        String finalObj = userChoiceInDB;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("UserChoice", finalObj);
        forms.add(jsonObj);
        return forms;
    }

//	Additional Service forms Checkout redirection service
    @Override
    @Transactional
    public ModelAndView additionalServiceCheckoutDataRedirection(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("additionalServiceCheckoutDataRedirection...Service");
        String addSerFormsCheckOutRef = (String) req.getParameter("addSerFormsCheckOutRef");
        ModelAndView mav = new ModelAndView();
        if (("ASCheckoutModification").equals(addSerFormsCheckOutRef)) {
            mav = additionalServiceFormsDataModification(req, sn);
        } else if (("ASCheckoutPayment").equals(addSerFormsCheckOutRef)) {
            mav = stateFormsServiceImpl.stateFormsCheckoutPaymentDataSaving(req, sn);
        }
        return mav;
    }

//	Additional Service Checkout Display JSON Values updated in DB Service
    @Override
    @Transactional
    public JSONArray jSonASCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("jSonASCheckoutDataUpdationInDB...Service");
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
            List<AdditionalFormsAttributesAndValuesSaving> addSerFormAttrAndValModel = addSerFormAttrAndValSavingDAOImpl.findByAddtionalSerViceFormsCapturedInfoFromDB((Integer) sn.getAttribute("userIdInSn"), formId, (String) sn.getAttribute(userChoiceInSn));
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
                LOGGER.error("jSonASCheckoutDataUpdationInDB " + e);
            }
            capInfoJsonObject.remove(attrId);
            capInfoJsonObject.put(attrId, attrValue);
            String jsonStringObj = capInfoJsonObject.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            AdditionalFormsAttributesAndValuesSaving addAttrAndValModel = addSerFormAttrAndValSavingDAOImpl.findByAddSerFormsAttributesAndValuesFromDB((Integer) sn.getAttribute("userIdInSn"), formId, (String) sn.getAttribute(userChoiceInSn));
            addAttrAndValModel.setCapturedInformation(jsonStringObj);
            addAttrAndValModel.setModifiedDate(currentDate);
            addSerFormAttrAndValSavingDAOImpl.merge(addAttrAndValModel);
            AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            if ((tf1).equals(attrType)) {
                stateFormsUpdateModel.setUserChoice(attrValue);
                stateFormsUpdateModel.setModifiedDate(currentDate);
                allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);
                addAttrAndValModel.setUserChoice(attrValue);
                addSerFormAttrAndValSavingDAOImpl.merge(addAttrAndValModel);
//              All related tables updating
                List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                if (!allStateFormsPaymentList.isEmpty()) {
                    AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                    allStateFormsPaymentInfoSaving.setUserChoice(attrValue);
                    allStateFormsPaymentInfoSaving.setUpdatedDate(currentDate);
                    allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);
                }
                List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                if (!allFormsAddCartPaymentList.isEmpty()) {
                    AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                    String combValue = attrValue + ", " + sn.getAttribute(formNameInSn) + ", " + sn.getAttribute(stateNameInSn) + ".";
                    allStateAndFedAddCartPayment.setUserChoice(attrValue);
                    allStateAndFedAddCartPayment.setSelectedDocumentsName(combValue);
                    allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
                    AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                    allStCheckoutPaymentAndUserContact.setUserChoice(attrValue);
                    allStCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
                    allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
                }
                sn.setAttribute(userChoiceInSn, attrValue);
            } else {
                stateFormsUpdateModel.setModifiedDate(currentDate);
                allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);
            }
            modValue = attrValue;
        }
        String finalObj = modValue + "&&" + attrId;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("JSonObj", finalObj);
        forms.add(jsonObj);
        return forms;
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
        List<Forms> stFormId = additionalFormsAttrInfoDAOImpl.additionalServiceFormsIdValueFromDB((String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn));
        int formId = 0;
        for (Forms formsInfo : stFormId) {
            formId = formsInfo.getFormId();
        }
        return formId;
    }

}