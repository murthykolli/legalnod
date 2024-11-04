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

import com.legalnod.daoimpl.AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.BusinessFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.BusinessFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.FederalTaxIdFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.FormFederalAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.FormFederalDocumentsDataSavingDAOImpl;
import com.legalnod.model.AllStateFormsCheckoutPaymentAndUserContactSaving;
import com.legalnod.model.AllStateFormsDataSaving;
import com.legalnod.model.BusinessFormsAttributesAndValuesSaving;
import com.legalnod.model.FederalTaxIdFormsAttributesInfo;
import com.legalnod.model.FormFederalAttributesAndValuesSaving;
import com.legalnod.model.FormFederalDocumentsDataSaving;
import com.legalnod.model.Forms;
import com.legalnod.service.FreeFederalFormsService;

public class FreeFederalFormsServiceImpl implements FreeFederalFormsService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FreeFederalFormsServiceImpl.class);
	
	private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";    
    private String userNameInSn = "userNameInSn";    
    private String userChoiceInSn = "userChoiceInSn";    
    private String formNameInSn = "formNameInSn";
    private String formName = "formName";
    private String stateNameInSn = "stateNameInSn";
    private String stateName = "stateName";    
    private String userIdInSn = "userIdInSn";
    private String attributeTextField1 = "attributeTextField1";    
    private String attribTextFieldList = "attributeTextFieldList";
    private String attribTextFieldDateList = "attributeTextFieldDateList";
    private String attribSelectBoxList = "attributeSelectBoxList";
    private String radioButtList = "radioButtonList";
    private String checkBoxesList = "checkBoxList";
    private String freeFedAttrTextFieldList = "freeFedAttributeTextFieldList";
    private String freeFedAttrTextFieldDateList = "freeFedAttributeTextFieldDateList";
    private String freeFedAttrSelectBoxList = "freeFedAttributeSelectBoxList";
    private String freeFedRBList = "freeFedRadioButtonList";
    private String freeFedCBList = "freeFedCheckBoxList";    
    private String ffLegalNameInSn = "freeLegalNameInSn";
    private String freeFedTaxModification = "freeFederalTaxIdModification";
    private String freeFedFormPageValue = "freeFederalFormPageValues";
    private String freeFedRadioButtStatus = "FreeFedRadioButtonStatus";
    private String attrbReqTypeIdsInSn = "attrReqTypeIdsInSn";
    private String totalReqAttrbCountInSn = "totalReqAttrCountInSn";
    private String freeFedDocFinishOrderRef = "freeFederalDocFinishOrderRef";
    private String ffAttrbNames = "SFed_Attr_Names";
    private String ffAttrbValues = "SFed_Attr_Values";
    private String ffAttrbReqList = "SFed_Attr_Req_List";
    private String ffAttrbStatusList = "SFed_Attr_Status_List";
    private String tf1 = "TF1";
    private String yes = "yes";
    private String no = "no";    
    
    @Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;

    @Autowired
    private BusinessFormsAttributesInfoDAOImpl bsFormAndStateAttrInfoDAOImpl;

    @Autowired
    private BusinessFormsAttributesAndValuesSavingDAOImpl bsFormAndStateValDAOImpl;

    @Autowired
    private AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl allStateFormsCheckoutPaymentDAOImpl;
    
    @Autowired
    private FederalTaxIdFormsAttributesInfoDAOImpl federalTaxAttrInfoDAOImpl;
    
    @Autowired
    private FormFederalDocumentsDataSavingDAOImpl formFederalDataSavingDAOImpl;
    
    @Autowired
    private FormFederalAttributesAndValuesSavingDAOImpl formFedAttrAndValuesSavingDAOImpl;
    
    @Autowired
    private StateFormsServiceImpl stateFormsServiceImpl;

//	Business Service State forms free federal and check out redirection Service Implementation 
    @Override
    @Transactional
    public ModelAndView busStateFormsFreeFedAndCheckouRedirection(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("busStateFormsFreeFedAndCheckouRedirection...Service");
        ModelAndView mav = new ModelAndView();        
//		Form Federal tax status getting from DB
        String formFederalStatus = takeFormFederalStatusFromDB(sn);        
        if(formFederalStatus != null && ("Yes").equals(formFederalStatus)){
        	List<FormFederalDocumentsDataSaving> formFedTaxModel = formFederalDataSavingDAOImpl.findByFreeFederalFormsLegalNameFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String legalNameInDB = null;
            if(!formFedTaxModel.isEmpty()){
            for (FormFederalDocumentsDataSaving formFederalDataModel : formFedTaxModel) {
            	legalNameInDB = formFederalDataModel.getLegalName();
            }
            }
            if(legalNameInDB != null){            	
            	sn.setAttribute(ffLegalNameInSn, legalNameInDB);
            	mav = freeFederalTaxCheckoutModification(req, sn);
            } else{
        	mav = new ModelAndView("freeFederalTaxIdRedirection");
            }
        } else {
        	mav = stateFormsServiceImpl.businessStateFormsCheckouDataDisplay(req, sn);
        }
        return mav;
    }
    
//	select No in free federal form home Service Implementation 
    @Override
    @Transactional
    public ModelAndView goToBusStateFormCheckoutDataDisplay(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("goToBusStateFormCheckoutDataDisplay...Service");        
        ModelAndView mav = new ModelAndView();
        	mav = stateFormsServiceImpl.businessStateFormsCheckouDataDisplay(req, sn);        
        return mav;
    }
    
//	select Yes in free federal form home Service Implementation 
    @Override
    @Transactional
    public ModelAndView freeFederalTaxIdFormCreation(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("freeFederalTaxIdFormCreation...Service");
    	ModelAndView mav = new ModelAndView();
//	Federal form: Names, Values and Required values take from DB
    List<FederalTaxIdFormsAttributesInfo> federalTaxAttrList = federalTaxAttrInfoDAOImpl.federalFormDynamicFormShowHideData();
    List attrNamesList = new ArrayList();
    List attrValueList = new ArrayList();
    List attrReqTypeList = new ArrayList();
    List attrStatusList = new ArrayList();
    for (FederalTaxIdFormsAttributesInfo federalTaxAttrInfo : federalTaxAttrList) {
        String attrbName = String.valueOf(federalTaxAttrInfo.getAttributeFieldName());
        String attrbValue = String.valueOf(federalTaxAttrInfo.getAttributeValue());
        attrNamesList.add(attrbName.replace("null", ""));
        attrValueList.add(attrbValue.replace("null", ""));
        attrReqTypeList.add(federalTaxAttrInfo.getRequiredType());
        attrStatusList.add(federalTaxAttrInfo.getStatus());
    }
    sn.setAttribute(ffAttrbNames, attrNamesList);
    sn.setAttribute(ffAttrbValues, attrValueList);
    sn.setAttribute(ffAttrbReqList, attrReqTypeList);
    sn.setAttribute(ffAttrbStatusList, attrStatusList);
//	Federal forms Attribute Required type Ids take from DB 
    List<Object> attrReqTypeIdsList = (List<Object>) federalTaxAttrInfoDAOImpl.attributeReqTypeIDsList();
    int totalReqAttrCount = attrReqTypeIdsList.size();
    String attrReqTypeIds = attrReqTypeIdsList.toString();
    attrReqTypeIds = attrReqTypeIds.replace("[", "");
    attrReqTypeIds = attrReqTypeIds.replace("]", "");
//	Radio Button Status take from DB 			
    List<Object> rbStatus = (List<Object>) federalTaxAttrInfoDAOImpl.federalFormRadioButtonStatus();
//	Form Modification Code                
    List<FormFederalDocumentsDataSaving> formFedTaxModel = formFederalDataSavingDAOImpl.findByFreeFederalFormsLegalNameFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
    String legalNameInDB = null;
    if(!formFedTaxModel.isEmpty()){
    for (FormFederalDocumentsDataSaving formFederalDataModel : formFedTaxModel) {
    	legalNameInDB = formFederalDataModel.getLegalName();
    }
    }
    if (legalNameInDB != null) {
        List<FormFederalAttributesAndValuesSaving> formFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.formFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), legalNameInDB);
        String capturedInfoInDB = null;
        for (FormFederalAttributesAndValuesSaving formFederalAttrAndValDataModel : formFedAttrAndValModel) {
            capturedInfoInDB = formFederalAttrAndValDataModel.getCapturedInformation();
        }
//      Formation From String to JSON
        JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);        
        mav = freeFederalTaxIdAttributesInfoSelection(capInfoJsonObject, req);
        FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.formFederalFormsDataTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), legalNameInDB);
        String freeFederalFormPageValues = formFederalUpdateModel.getPageVariableReference();
        mav = new ModelAndView(freeFedTaxModification);
        sn.setAttribute(ffLegalNameInSn, legalNameInDB);        
        mav.addObject(freeFedAttrTextFieldList, req.getAttribute(attribTextFieldList));
        mav.addObject(freeFedAttrTextFieldDateList, req.getAttribute(attribTextFieldDateList));
        mav.addObject(freeFedAttrSelectBoxList, req.getAttribute(attribSelectBoxList));
        mav.addObject(freeFedRBList, req.getAttribute(radioButtList));
        mav.addObject(freeFedCBList, req.getAttribute(checkBoxesList));        
        mav.addObject(freeFedFormPageValue, freeFederalFormPageValues);
    } else {
        mav = new ModelAndView(freeFedTaxModification);
        sn.setAttribute(ffLegalNameInSn, null);
    }    
    mav.addObject(freeFedRadioButtStatus, rbStatus);
    sn.setAttribute(freeFedRadioButtStatus, rbStatus);
    sn.setAttribute(attrbReqTypeIdsInSn, attrReqTypeIds);
    sn.setAttribute(totalReqAttrbCountInSn, totalReqAttrCount);
    mav.addObject(firstName, sn.getAttribute(firstNameInSn));
    mav.addObject("firstChoice", sn.getAttribute(userChoiceInSn));
    mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));         
    return mav;
    }
    
//	Free Federal Tax Id Forms Attributes Info Selection
    @Override
    @Transactional
    public ModelAndView freeFederalTaxIdAttributesInfoSelection(JSONObject capInfoJsonObject, HttpServletRequest req) {
        LOGGER.debug("freeFederalTaxIdAttributesInfoSelection...Service");
        ModelAndView mav = new ModelAndView();        
        String attributeTextFieldList = null;
        for (int i = 1; i <= 44; i++) {
            String keyVal = String.valueOf(i);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeTextFieldList = attributeTextFieldList + jSonObjVal + ",$,";
        }
        attributeTextFieldList = attributeTextFieldList.replace("null", "");
        String attributeTextFieldDateList = null;
        for (int j = 45; j <= 46; j++) {
            String keyVal = String.valueOf(j);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeTextFieldDateList = attributeTextFieldDateList + jSonObjVal + ",$,";
        }
        attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");
        String radioButtonList = null;
        for (int k = 47; k <= 54; k++) {
            String keyVal = String.valueOf(k);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            radioButtonList = radioButtonList + jSonObjVal + ",$,";
        }
        radioButtonList = radioButtonList.replace("null", "");
        String keyVal1 = String.valueOf(55);
        String jSonObjVal1 = (String) capInfoJsonObject.get(keyVal1);
        String checkBoxList = jSonObjVal1 + ",$,";
        checkBoxList = checkBoxList.replace("null", "");
        String attributeSelectBoxList = null;
        for (int k = 56; k <= 62; k++) {
            String keyVal = String.valueOf(k);
            String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
            attributeSelectBoxList = attributeSelectBoxList + jSonObjVal + ",$,";
        }
        attributeSelectBoxList = attributeSelectBoxList.replace("null", "");        
        req.setAttribute(attribTextFieldList, attributeTextFieldList);
        req.setAttribute(attribTextFieldDateList, attributeTextFieldDateList);
        req.setAttribute(attribSelectBoxList, attributeSelectBoxList);
        req.setAttribute(radioButtList, radioButtonList);
        req.setAttribute(checkBoxesList, checkBoxList);             
        return mav;
    }
    
//	Free Federal Form modification Service Implementation
    @Override
    @Transactional
    public ModelAndView freeFederalTaxDataModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("freeFederalTaxDataModification...Service");       
        JSONObject stateFormInfoObj = freeFederalFormsAttributesInfoFromJSP(req);        
        ModelAndView mav;                
//		Already Exit User choice when ever directly clicking enter with out using mouse
        List userAEChoiceList = formFederalDataSavingDAOImpl.freeFederalFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), req.getParameter(attributeTextField1));        
        String alreadyExitChoice = null;        
        if (!userAEChoiceList.isEmpty()) {        	
        	FormFederalDocumentsDataSaving formFederalAEModel = formFederalDataSavingDAOImpl.formFederalFormsDataTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), req.getParameter(attributeTextField1));
            alreadyExitChoice = formFederalAEModel.getLegalName();            
        }        
        if (alreadyExitChoice != null && !alreadyExitChoice.equals(sn.getAttribute(ffLegalNameInSn))) {
            mav = new ModelAndView(freeFedTaxModification);
            mav.addObject("AlreadyExitChoice", "AlreadyExitUserChoice");
        } else {
        	String formStatus = freeFederalFormStatusInDB(req, sn);
            String jsonStringObj = stateFormInfoObj.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            if (sn.getAttribute(ffLegalNameInSn) == null) {
//				Only Free Federal Tax Id Forms Attributes And Values Saving in DB
            	FormFederalAttributesAndValuesSaving freeFedTaxAttrAndValModel = new FormFederalAttributesAndValuesSaving();
            	freeFedTaxAttrAndValModel.setUserName((String) sn.getAttribute(userNameInSn));
            	freeFedTaxAttrAndValModel.setFormName((String) sn.getAttribute(formNameInSn));
            	freeFedTaxAttrAndValModel.setStateName((String) sn.getAttribute(stateNameInSn));
            	freeFedTaxAttrAndValModel.setUserChoice((String) sn.getAttribute(userChoiceInSn));
            	freeFedTaxAttrAndValModel.setLegalName(req.getParameter(attributeTextField1));
            	freeFedTaxAttrAndValModel.setCapturedInformation(jsonStringObj);
            	freeFedTaxAttrAndValModel.setCreatedDate(currentDate);
            	formFedAttrAndValuesSavingDAOImpl.save(freeFedTaxAttrAndValModel);
//				Data Saving to All All Federal Forms Data Saving in DB			
            	FormFederalDocumentsDataSaving formFedSavingModel = new FormFederalDocumentsDataSaving();
            	formFedSavingModel.setUserName((String) sn.getAttribute(userNameInSn));
            	formFedSavingModel.setFormName((String) sn.getAttribute(formNameInSn));
            	formFedSavingModel.setStateName((String) sn.getAttribute(stateNameInSn));
            	formFedSavingModel.setUserChoice((String) sn.getAttribute(userChoiceInSn));
            	formFedSavingModel.setLegalName(req.getParameter(attributeTextField1));
            	formFedSavingModel.setStatus(formStatus);
            	formFedSavingModel.setCreatedDate(currentDate);
            	formFedSavingModel.setPageVariableReference(req.getParameter(freeFedFormPageValue));
            	formFederalDataSavingDAOImpl.save(formFedSavingModel);
            } else {
            	FormFederalAttributesAndValuesSaving freeFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.freeFederalTaxFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));
            	freeFedAttrAndValModel.setLegalName(req.getParameter(attributeTextField1));
            	freeFedAttrAndValModel.setUserChoice((String) sn.getAttribute(userChoiceInSn));
            	freeFedAttrAndValModel.setCapturedInformation(jsonStringObj);
            	freeFedAttrAndValModel.setModifiedDate(currentDate);
                formFedAttrAndValuesSavingDAOImpl.merge(freeFedAttrAndValModel);
                FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.formFederalFormsDataTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));                
                formFederalUpdateModel.setLegalName(req.getParameter(attributeTextField1));
                formFederalUpdateModel.setUserChoice((String) sn.getAttribute(userChoiceInSn));
                formFederalUpdateModel.setStatus(formStatus);
                formFederalUpdateModel.setModifiedDate(currentDate);
                formFederalUpdateModel.setPageVariableReference(req.getParameter(freeFedFormPageValue));
                formFederalDataSavingDAOImpl.merge(formFederalUpdateModel);                
            }
            AllStateFormsDataSaving stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), "Business Forms", (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
        	stateFormsModel.setFormFederalLegalname(req.getParameter(attributeTextField1));
        	stateFormsModel.setFederalStatus(formStatus);
        	allStateFormsDataSavingDAOImpl.merge(stateFormsModel);        	
            List allFreeFederalLegalNameList = allStateFormsCheckoutPaymentDAOImpl.freeFederalLegalNameTakeFromPaymentContactDB((String) sn.getAttribute(userNameInSn), "Business Forms", (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            if(!allFreeFederalLegalNameList.isEmpty()){            
            AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), "Business Forms", (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            allStCheckoutPaymentAndUserContact.setFormFedLegalname(req.getParameter(attributeTextField1));            
            allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
            }
            sn.setAttribute(ffLegalNameInSn, req.getParameter(attributeTextField1));
            if (req.getParameter(freeFedDocFinishOrderRef) != null && ("Finished").equals(req.getParameter(freeFedDocFinishOrderRef))) {                
                mav = stateFormsWithFreeFederalCheckouDataDisplay(req, sn);
            } else {
                mav = new ModelAndView(freeFedTaxModification);
            }
            mav.addObject(freeFedFormPageValue, req.getParameter(freeFedFormPageValue));
            sn.setAttribute(ffAttrbNames, sn.getAttribute(ffAttrbNames));
            sn.setAttribute(ffAttrbValues, sn.getAttribute(ffAttrbValues));
            sn.setAttribute(ffAttrbReqList, sn.getAttribute(ffAttrbReqList));
            sn.setAttribute(ffAttrbStatusList, sn.getAttribute(ffAttrbStatusList));
            sn.setAttribute(freeFedRadioButtStatus, sn.getAttribute(freeFedRadioButtStatus));                   
        }
        mav.addObject(freeFedAttrTextFieldList, req.getAttribute(attribTextFieldList));
        mav.addObject(freeFedAttrTextFieldDateList, req.getAttribute(attribTextFieldDateList));
        mav.addObject(freeFedAttrSelectBoxList, req.getAttribute(attribSelectBoxList));
        mav.addObject(freeFedRBList, req.getAttribute(radioButtList));
        mav.addObject(freeFedCBList, req.getAttribute(checkBoxesList));        
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }
    
//	Free Federal Forms Attributes Data take from JSP
    @Override
    @Transactional
    public JSONObject freeFederalFormsAttributesInfoFromJSP(HttpServletRequest req) {
        LOGGER.debug("freeFederalFormsAttributesInfoFromJSP...Service");
        JSONObject stateFormInfoObj = new JSONObject();        
        String attributeTextFieldList = null;
        String[] attributeTextField = new String[45];
        for (int i = 1; i < attributeTextField.length; i++) {
            attributeTextField[i] = req.getParameter("attributeTextField" + i);
            attributeTextFieldList = attributeTextFieldList + attributeTextField[i] + ",$,";
            stateFormInfoObj.put(i, attributeTextField[i]);            
        }
        attributeTextFieldList = attributeTextFieldList.replace("null", "");
        String attributeTextFieldDateList = null;
        String[] attributeTextFieldDate = new String[3];
        for (int j = 1; j < attributeTextFieldDate.length; j++) {
            attributeTextFieldDate[j] = req.getParameter("attributeTextFieldDate" + j);
            attributeTextFieldDateList = attributeTextFieldDateList + attributeTextFieldDate[j] + ",$,";
            stateFormInfoObj.put(j + 44, attributeTextFieldDate[j]);            
        }
        attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");
        String radioButtonList = null;
        String[] radioButton = new String[9];
        for (int k = 1; k < radioButton.length; k++) {
            radioButton[k] = req.getParameter("radioButton" + k);
            radioButtonList = radioButtonList + radioButton[k] + ",$,";
            stateFormInfoObj.put(k + 46, radioButton[k]);            
        }
        radioButtonList = radioButtonList.replace("null", "");
        String checkBoxList = null;
        String[] checkBox = new String[2];
        for (int l = 1; l < checkBox.length; l++) {
            checkBox[l] = req.getParameter("checkBox" + l);
            checkBoxList = checkBoxList + checkBox[l] + ",$,";
            stateFormInfoObj.put(l + 54, checkBox[l]);            
        }
        checkBoxList = checkBoxList.replace("null", "");
        String attributeSelectBoxList = null;
        String[] attributeSelectBox = new String[8];
        for (int n = 1; n < attributeSelectBox.length; n++) {
            attributeSelectBox[n] = req.getParameter("attributeSelectBox" + n);
            attributeSelectBoxList = attributeSelectBoxList + attributeSelectBox[n] + ",$,";
            stateFormInfoObj.put(n + 55, attributeSelectBox[n]);            
        }
        attributeSelectBoxList = attributeSelectBoxList.replace("null", "");        
        req.setAttribute(attribTextFieldList, attributeTextFieldList);
        req.setAttribute(attribTextFieldDateList, attributeTextFieldDateList);
        req.setAttribute(attribSelectBoxList, attributeSelectBoxList);
        req.setAttribute(radioButtList, radioButtonList);
        req.setAttribute(checkBoxesList, checkBoxList);
        return stateFormInfoObj;
    }
    
//  	Free Federal Form Status
		@Override
		@Transactional
		public String freeFederalFormStatusInDB(HttpServletRequest req, HttpSession sn) {
			  LOGGER.debug("freeFederalFormStatusInDB...Service");
		      String formStatus = null;
		      JSONObject stateFormInfoObj = freeFederalFormsAttributesInfoFromJSP(req);
		      int reqAttrCount = 0;
	            String[] attributeIdsString = ((String) sn.getAttribute(attrbReqTypeIdsInSn)).split(", ");
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
    
//	all state Forms with Free Federal tax Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView stateFormsWithFreeFederalCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("stateFormsWithFreeFederalCheckouDataDisplay...Service");
        ModelAndView mav = new ModelAndView();
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Required values take from DB		
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<BusinessFormsAttributesAndValuesSaving> busStFormAttrAndValModel = bsFormAndStateValDAOImpl.findByallStateFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
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
            mav = new ModelAndView("freeFederalWithStateFormCheckoutDisplayCreation");
            sn.setAttribute("Attr_SF_Names_CheckOutList", attrSTNamesList);
            sn.setAttribute("Attr_SF_Type_CheckOutList", attrSTTypeList);
            sn.setAttribute("Attr_SF_Values_CheckOutList", attrSTValuesList);
            sn.setAttribute("Attr_IDs_SF_CheckOutList", attrSTIdsList);
            mav.addObject(stateName, sn.getAttribute(stateNameInSn));
            mav.addObject(formName, sn.getAttribute(formNameInSn));
        }    
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        sn.setAttribute("formIdInSn", formId);        
        sn.setAttribute(stateNameInSn, sn.getAttribute(stateNameInSn));
        sn.setAttribute(formNameInSn, sn.getAttribute(formNameInSn));
        return mav;
    }
    
//		Free Federal Tax id Forms Checkout Service Implementation 
      	@Override
      	@Transactional
      	public ModelAndView freeFederalTaxIdFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
      		LOGGER.debug("federalTaxIdFormsCheckouDataDisplay...Service");
          	ModelAndView mav = new ModelAndView();
//  		Required values take from DB		
          	if (sn.getAttribute(ffLegalNameInSn) != null) {
          	List<FormFederalAttributesAndValuesSaving> formFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.formFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));
              String capturedInfoInDB = null;
              for (FormFederalAttributesAndValuesSaving formFederalAttrAndValDataModel : formFedAttrAndValModel) {
                  capturedInfoInDB = formFederalAttrAndValDataModel.getCapturedInformation();
              }            
//            Formation From String to JSON
              JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);            
//  	  	  Federal Tax Ids take from DB 			
              List attrNamesList = new ArrayList();
              List attrFieldIdsList = new ArrayList();
              List attrTypeList = new ArrayList();
              List<Object> formFieldsAndValuesIds = (List<Object>) federalTaxAttrInfoDAOImpl.federalTaxFormsDynamicFieldsAndValuesIDs();
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
              List attrFFNamesList = new ArrayList();
              List attrFFTypeList = new ArrayList();
              List attrFFValuesList = new ArrayList();
              List attrFFIdsList = new ArrayList();
              for (int i = 0; i < attrFieldIDInString.length; i++) {
                  String attrFieldId = attrFieldIDInString[i];
                  String attrNames = attrNamesInString[i];
                  String attrTypes = attrTypeInString[i];
                  String jSonObjVal = (String) capInfoJsonObject.get(attrFieldId);
                  if (!("").equals(jSonObjVal)) {
                      String attrValue = jSonObjVal;
                      for (int k = 0; k < jSonObjVal.length() + 9; k++) {
                          String yesVal = yes + k;
                          String noVal = no + k;
                          if (yesVal.equals(jSonObjVal)) {
                              attrValue = jSonObjVal.replaceAll(yesVal, yes);
                          } else if (noVal.equals(jSonObjVal)) {
                              attrValue = jSonObjVal.replaceAll(noVal, no);
                          }
                      }
                      attrFFNamesList.add(attrNames);
                      attrFFTypeList.add(attrTypes);
                      attrFFValuesList.add(attrValue);
                      attrFFIdsList.add(attrFieldId);
                  }
              }
              mav = new ModelAndView("freeFederalCheckoutDisplayCreation");
              sn.setAttribute("Fed_Attr_Names_CheckOutList", attrFFNamesList);
              sn.setAttribute("Fed_Attr_Type_CheckOutList", attrFFTypeList);
              sn.setAttribute("Fed_Attr_Values_CheckOutList", attrFFValuesList);
              sn.setAttribute("Fed_Attr_IDs_CheckOutList", attrFFIdsList);
          }
          mav.addObject(firstName, sn.getAttribute(firstNameInSn));
          mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
          return mav;
      }
      
// 		Free Federal With State Forms checkout Data Modification
      	@Override
      	@Transactional
      	public ModelAndView freeFederalWithStateFormscheckoutDataModification(HttpServletRequest req, HttpSession sn) {
      	LOGGER.debug("freeFederalWithStateFormscheckoutDataModification...Service");
          String stateAndFreeFedCheckOutRef = (String) req.getParameter("stateAndFreeFedCheckOutRef");          
          ModelAndView mav = new ModelAndView();          
          if (("CheckoutModification").equals(stateAndFreeFedCheckOutRef)) {
        	  mav = stateFormsServiceImpl.businessStateFormsDataModification(req, sn);
          } else if (("FormFederalCheckout").equals(stateAndFreeFedCheckOutRef)) {        	  
        	  mav = freeFederalTaxIdFormsCheckouDataDisplay(req, sn);
          }
          return mav;
      }
      
//   	Free Federal Checkout Data Modification
      	@Override
      	@Transactional
      	public ModelAndView freeFederalTaxCheckoutDataModification(HttpServletRequest req, HttpSession sn) {
      	LOGGER.debug("freeFederalWithStateFormscheckoutDataModification...Service");
          String freeFederalFormsCheckOutRef = (String) req.getParameter("freeFederalFormsCheckOutRef");          
          ModelAndView mav = new ModelAndView();          
          if (("BackMoving").equals(freeFederalFormsCheckOutRef)) {
        	  mav = stateFormsWithFreeFederalCheckouDataDisplay(req, sn);
          } else if (("CheckoutModification").equals(freeFederalFormsCheckOutRef)) {
        	  mav = freeFederalTaxCheckoutModification(req, sn);
          } else if (("CheckoutPayment").equals(freeFederalFormsCheckOutRef)) {
        	  mav = stateFormsServiceImpl.stateFormsCheckoutPaymentDataSaving(req, sn);   	  
          }
          return mav;
      }
      
//		Free Federal Checkout Modification Service
      	@Override
      	@Transactional
      	public ModelAndView freeFederalTaxCheckoutModification(HttpServletRequest req, HttpSession sn) {
    	  LOGGER.debug("freeFederalTaxCheckoutModification...Service");
	      ModelAndView mav;
//  	  Federal form: Names, Values and Required values take from DB
          List<FederalTaxIdFormsAttributesInfo> federalTaxAttrList = federalTaxAttrInfoDAOImpl.federalFormDynamicFormShowHideData();
          List attrNamesList = new ArrayList();
          List attrValueList = new ArrayList();
          List attrReqTypeList = new ArrayList();
          List attrStatusList = new ArrayList();
          for (FederalTaxIdFormsAttributesInfo federalTaxAttrInfo : federalTaxAttrList) {
              String attrbName = String.valueOf(federalTaxAttrInfo.getAttributeFieldName());
              String attrbValue = String.valueOf(federalTaxAttrInfo.getAttributeValue());
              attrNamesList.add(attrbName.replace("null", ""));
              attrValueList.add(attrbValue.replace("null", ""));
              attrReqTypeList.add(federalTaxAttrInfo.getRequiredType());
              attrStatusList.add(federalTaxAttrInfo.getStatus());
          }
          sn.setAttribute(ffAttrbNames, attrNamesList);
          sn.setAttribute(ffAttrbValues, attrValueList);
          sn.setAttribute(ffAttrbReqList, attrReqTypeList);
          sn.setAttribute(ffAttrbStatusList, attrStatusList);
//  	  Federal forms Attribute Required type Ids take from DB 
          List<Object> attrReqTypeIdsList = (List<Object>) federalTaxAttrInfoDAOImpl.attributeReqTypeIDsList();
          int totalReqAttrCount = attrReqTypeIdsList.size();
          String attrReqTypeIds = attrReqTypeIdsList.toString();
          attrReqTypeIds = attrReqTypeIds.replace("[", "");
          attrReqTypeIds = attrReqTypeIds.replace("]", "");
//  	  Radio Button Status take from DB 			
          List<Object> rbStatus = (List<Object>) federalTaxAttrInfoDAOImpl.federalFormRadioButtonStatus();
//  	  Form Modification Code
          if (sn.getAttribute(ffLegalNameInSn) != null) {
        	  List<FormFederalAttributesAndValuesSaving> formFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.formFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));
              String capturedInfoInDB = null;
              for (FormFederalAttributesAndValuesSaving formFederalAttrAndValDataModel : formFedAttrAndValModel) {
                  capturedInfoInDB = formFederalAttrAndValDataModel.getCapturedInformation();
              }              
//            Formation From String to JSON
              JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);              
              mav = freeFederalTaxIdAttributesInfoSelection(capInfoJsonObject, req);              
              FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.formFederalFormsDataTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));
              String freeFederalFormPageValues = formFederalUpdateModel.getPageVariableReference();
              mav = new ModelAndView(freeFedTaxModification);
              sn.setAttribute(ffLegalNameInSn, sn.getAttribute(ffLegalNameInSn));
              mav.addObject(freeFedAttrTextFieldList, req.getAttribute(attribTextFieldList));
              mav.addObject(freeFedAttrTextFieldDateList, req.getAttribute(attribTextFieldDateList));
              mav.addObject(freeFedAttrSelectBoxList, req.getAttribute(attribSelectBoxList));
              mav.addObject(freeFedRBList, req.getAttribute(radioButtList));
              mav.addObject(freeFedCBList, req.getAttribute(checkBoxesList));
              mav.addObject(freeFedFormPageValue, freeFederalFormPageValues);
          } else {
              mav = new ModelAndView(freeFedTaxModification);
              sn.setAttribute(ffLegalNameInSn, null);
          }
          mav.addObject(freeFedRadioButtStatus, rbStatus);
          sn.setAttribute(freeFedRadioButtStatus, rbStatus);
          sn.setAttribute(attrbReqTypeIdsInSn, attrReqTypeIds);
          sn.setAttribute(totalReqAttrbCountInSn, totalReqAttrCount);
          mav.addObject(firstName, sn.getAttribute(firstNameInSn));
          mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
          return mav;
      }
      
//  	Free Federal Tax ID JSON modification JSP Legal Name Already Checking Service
      	@Override
      	@Transactional
      	public JSONArray freeJSONFederalTaxLegalNameChecking(String updatedAttrVal, HttpSession sn) {
    	  LOGGER.debug("freeJSONFederalTaxLegalNameChecking...Service");
	      String userFirstChoice = updatedAttrVal;
          userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
  //	  Legal Name take from DB
          List formFedSavingValuesList = formFederalDataSavingDAOImpl.freeFederalFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), userFirstChoice);                    
          String legalNameInDB = null;
          if (!formFedSavingValuesList.isEmpty()) {
        	  legalNameInDB = userFirstChoice;
          }
          if (legalNameInDB != null && sn.getAttribute(ffLegalNameInSn) != null && sn.getAttribute(ffLegalNameInSn).equals(legalNameInDB)) {
        	  legalNameInDB = null;
          }
          String finalObj = legalNameInDB;
          JSONArray forms = new JSONArray();
          JSONObject jsonObj = new JSONObject();
          jsonObj.put("UserChoice", finalObj);
          forms.add(jsonObj);
          return forms;
      }
      
//	Free Federal Tax ID JSON Checkout Display Chart Legal Name Already Checking Service
    @Override
  	@Transactional
  	public JSONArray freeFederalJSONCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn) {
    	String[] roleName = updatedAttrVal.split(" _ ");
  	    String attrValue = roleName[0];
  	    String attrId = roleName[1];
  	    String attrType = roleName[2];
  	    attrValue = attrValue.replace("$,$", "&");  	
  	    String modValue = null;        
//		userChoice checking in DB		
  	    int freeFedCount = 0;  	   
  	    if ((tf1).equals(attrType)) {  	    	
  	    	List formFedSavingValuesList = formFederalDataSavingDAOImpl.freeFederalFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), attrValue);
  	        freeFedCount = formFedSavingValuesList.size();
  	    }  	  
  	    if (freeFedCount > 0 && (tf1).equals(attrType)) {
  	        if (sn.getAttribute(ffLegalNameInSn).equals(attrValue)) {
  	            modValue = attrValue;
  	            sn.setAttribute(ffLegalNameInSn, attrValue);
  	        } else {
  	            modValue = "null";
  	        }
  	    } else {  	
  	//		Required values take from DB
  	    	List<FormFederalAttributesAndValuesSaving> formFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.formFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));
            String capturedInfoInDB = null;
            for (FormFederalAttributesAndValuesSaving formFederalAttrAndValDataModel : formFedAttrAndValModel) {
                capturedInfoInDB = formFederalAttrAndValDataModel.getCapturedInformation();
            }  	        
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);            
  	        capInfoJsonObject.remove(attrId);
  	        capInfoJsonObject.put(attrId, attrValue);  	
  	        String jsonStringObj = capInfoJsonObject.toString();
  	        jsonStringObj = jsonStringObj.replace("null", "\"\"");
  	        Timestamp currentDate = currentDate();  	        
  	      FormFederalAttributesAndValuesSaving freeFedAttrAndValModel = formFedAttrAndValuesSavingDAOImpl.freeFederalTaxFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));  	                  
  	      freeFedAttrAndValModel.setCapturedInformation(jsonStringObj);
  	      freeFedAttrAndValModel.setModifiedDate(currentDate);
  	      formFedAttrAndValuesSavingDAOImpl.merge(freeFedAttrAndValModel);  	        
  	      FormFederalDocumentsDataSaving formFederalUpdateModel = formFederalDataSavingDAOImpl.formFederalFormsDataTakeFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));  	       	        
  	      if ((tf1).equals(attrType)) {                
  	       	formFederalUpdateModel.setLegalName(attrValue);
  	       	formFederalUpdateModel.setModifiedDate(currentDate);
  	       	formFederalDataSavingDAOImpl.merge(formFederalUpdateModel);  	
  	       	freeFedAttrAndValModel.setLegalName(attrValue);
  	        formFedAttrAndValuesSavingDAOImpl.merge(freeFedAttrAndValModel);  	            
  	        AllStateFormsDataSaving stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), "Business Forms", (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
  	        stateFormsModel.setFormFederalLegalname(attrValue);  	          
  	        allStateFormsDataSavingDAOImpl.merge(stateFormsModel);  	          
  	        List allFreeFederalLegalNameList = allStateFormsCheckoutPaymentDAOImpl.freeFederalLegalNameTakeFromDB((String) sn.getAttribute(userNameInSn), "Business Forms", (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn), (String) sn.getAttribute(ffLegalNameInSn));
            if(!allFreeFederalLegalNameList.isEmpty()){            
            AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), "Business Forms", (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
            allStCheckoutPaymentAndUserContact.setFormFedLegalname(attrValue);            
            allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
            }
            sn.setAttribute(ffLegalNameInSn, attrValue);   
  	        } else{
  	        	formFederalUpdateModel.setModifiedDate(currentDate);
  	        	formFederalDataSavingDAOImpl.merge(formFederalUpdateModel);
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

//		Convert From String Value To JSON Format
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

//	  current date
	  @Override
	  @Transactional
	  public Timestamp currentDate() {
	  	LOGGER.debug("currentDate...method");
	  	java.util.Date date = new java.util.Date();
	  	Timestamp currentDate = new Timestamp(date.getTime());    
	  	return currentDate;
	  }

//    Form Id getting from DB
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

//	  Form Federal Status getting from DB
	  @Override
	  @Transactional
	  public String takeFormFederalStatusFromDB(HttpSession sn) {
	  	LOGGER.debug("takeFormFederalStatusFromDB...method");
	  	List<Forms> stFormList = bsFormAndStateAttrInfoDAOImpl.stateFormsIdValueFromDB((String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn));	
	  	String formFederalStatus = null;
	  	for (Forms formsInfo : stFormList) {	    
	  		formFederalStatus = formsInfo.getFederalStatus();
	  	}	
	  	return formFederalStatus;
	  }
}
