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

import com.legalnod.daoimpl.AllStateAndFederalFormsAddCartPaymentSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsPaymentInfoSavingDAOImpl;
import com.legalnod.daoimpl.StateTaxFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.StateTaxFormsAttributesInfoDAOImpl;
import com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving;
import com.legalnod.model.AllStateFormsCheckoutPaymentAndUserContactSaving;
import com.legalnod.model.AllStateFormsDataSaving;
import com.legalnod.model.AllStateFormsPaymentInfoSaving;
import com.legalnod.model.Forms;
import com.legalnod.model.StateTaxFormsAttributesAndValuesSaving;
import com.legalnod.model.StateTaxFormsAttributesInfo;
import com.legalnod.service.StateTaxIdService;

public class StateTaxIdServiceImpl implements StateTaxIdService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StateTaxIdServiceImpl.class);

    private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
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
    
    private String stateTaxIdForm = "State Tax ID Forms";
    private String stTaxIdFormModification = "stateTaxIdFormModification";
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
    private String stiAttrbRequiredList = "STI_Attribute_Required_List";
    private String stiAttrbRadioStatusList = "STI_Attribute_RadioStatus_List";
    private String stiAttrbInnerRadioList = "STI_Attribute_InnerRadio_List";
    private String stiAttrbAddAnotherList = "STI_Attribute_AddAnother_List";
    private String stiAttrbNamesList = "STI_Attribute_Names_List";
    private String stiAttrbValuesList = "STI_Attribute_Values_List";    
    private String yes = "yes";
    private String no = "no";
    private String tf1 = "TF1";

    @Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;

    @Autowired
    private StateTaxFormsAttributesAndValuesSavingDAOImpl stateTaxAttrAndValuesSavingDAOImpl;

    @Autowired
    private StateTaxFormsAttributesInfoDAOImpl stateTaxFormsAttrInfoDAOImpl;

    @Autowired
    private StateFormsServiceImpl stateFormsServiceImpl;

    @Autowired
    private AllStateFormsPaymentInfoSavingDAOImpl allStateFormsPaymentSavingDAOImpl;

    @Autowired
    private AllStateAndFederalFormsAddCartPaymentSavingDAOImpl allFormsAddCartPaymentSavingDAOImpl;

    @Autowired
    private AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl allStateFormsCheckoutPaymentDAOImpl;

//	State Tax ID Form modification Service Implementation	
    @Override
    @Transactional
    public ModelAndView stateTaxIdFormDataSavingAndUpdatingInDB(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("stateTaxIdFormDataSavingAndUpdatingInDB...Service");
        JSONObject stateFormInfoObj = stateTaxFormsAttributesInfoFromJSP(req);
        ModelAndView mav;
//		Already Exit User choice when ever directly clicking enter with out using mouse
        List userAEChoiceList = allStateFormsDataSavingDAOImpl.allStateFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), req.getParameter(textField1));
        String alreadyExitChoice = null;
        if (!userAEChoiceList.isEmpty()) {
            AllStateFormsDataSaving stateFormsAEModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), req.getParameter(textField1));
            alreadyExitChoice = stateFormsAEModel.getUserChoice();
        }
        if (alreadyExitChoice != null && !alreadyExitChoice.equals(sn.getAttribute(userChoiceInSn))) {
            mav = new ModelAndView(stTaxIdFormModification);
            mav.addObject("AlreadyExitChoice", "AlreadyExitUserChoice");
        } else {
//			Data Saving to DB tables
            String formStatus = stateTaxIdFormStatusInDB(req, sn);
            String jsonStringObj = stateFormInfoObj.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Forms formsId = new Forms();
            formsId.setFormId((Integer) sn.getAttribute(formIdInSn));
            Timestamp currentDate = currentDate();
            if (sn.getAttribute(userChoiceInSn) == null) {
//				Only State tax id Forms Data saving in DB
                StateTaxFormsAttributesAndValuesSaving stiAttrAndValModel = new StateTaxFormsAttributesAndValuesSaving();
                stiAttrAndValModel.setUserId((Integer) sn.getAttribute(userIdInSn));
                stiAttrAndValModel.setForms(formsId);
                stiAttrAndValModel.setUserChoice(req.getParameter(textField1));
                stiAttrAndValModel.setCapturedInformation(jsonStringObj);
                stiAttrAndValModel.setCreatedDate(currentDate);
                stateTaxAttrAndValuesSavingDAOImpl.save(stiAttrAndValModel);                
//				Data Saving to All state forms data saving DB
                AllStateFormsDataSaving allStateFormsModel = new AllStateFormsDataSaving();
                allStateFormsModel.setUserName((String) sn.getAttribute(userNameInSn));
                allStateFormsModel.setTypeOfDocument(stateTaxIdForm);
                allStateFormsModel.setFormName((String) sn.getAttribute(formNameInSn));
                allStateFormsModel.setStateName((String) sn.getAttribute(stateNameInSn));
                allStateFormsModel.setUserChoice(req.getParameter(textField1));
                allStateFormsModel.setStatus(formStatus);
                allStateFormsModel.setCreatedDate(currentDate);
                allStateFormsModel.setPageVariableReference(req.getParameter(stateFormsPageValue));
                allStateFormsModel.setFormStatus(req.getParameter(stateFormHiddenVarb));
                allStateFormsDataSavingDAOImpl.save(allStateFormsModel);
            } else {
                StateTaxFormsAttributesAndValuesSaving stiAttrAndValModel = stateTaxAttrAndValuesSavingDAOImpl.findByStateTaxIdFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), (Integer) sn.getAttribute(formIdInSn), (String) sn.getAttribute(userChoiceInSn));
                stiAttrAndValModel.setUserChoice(req.getParameter(textField1));
                stiAttrAndValModel.setCapturedInformation(jsonStringObj);
                stiAttrAndValModel.setModifiedDate(currentDate);
                stateTaxAttrAndValuesSavingDAOImpl.merge(stiAttrAndValModel);
                AllStateFormsDataSaving stateFormsModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
                stateFormsModel.setUserChoice(req.getParameter(textField1));
                stateFormsModel.setStatus(formStatus);
                stateFormsModel.setModifiedDate(currentDate);
                stateFormsModel.setPageVariableReference(req.getParameter(stateFormsPageValue));
                stateFormsModel.setFormStatus(req.getParameter(stateFormHiddenVarb));
                allStateFormsDataSavingDAOImpl.merge(stateFormsModel);                
//            	All related tables updating
                if(!(sn.getAttribute(userChoiceInSn)).equals(req.getParameter(textField1))){
                    mav = stateTaxIdFormsAllRelatedOtherTablesUpdate(req, sn); 
                }
            }
            sn.setAttribute(userChoiceInSn, req.getParameter(textField1));
            if (req.getParameter(stateFormHiddenVarb) != null && ("Finished").equals(req.getParameter(stateFormHiddenVarb))) {
                mav = stateTaxIdFormsCheckouDataDisplay(req, sn);
            } else {
                mav = new ModelAndView(stTaxIdFormModification);
            }
            mav.addObject(stateFormsPageValue, req.getParameter(stateFormsPageValue));
            sn.setAttribute(stiAttrbRequiredList, sn.getAttribute(stiAttrbRequiredList));
            sn.setAttribute(stiAttrbRadioStatusList, sn.getAttribute(stiAttrbRadioStatusList));
            sn.setAttribute(stiAttrbInnerRadioList, sn.getAttribute(stiAttrbInnerRadioList));
            sn.setAttribute(stiAttrbAddAnotherList, sn.getAttribute(stiAttrbAddAnotherList));
            sn.setAttribute(stiAttrbNamesList, sn.getAttribute(stiAttrbNamesList));
            sn.setAttribute(stiAttrbValuesList, sn.getAttribute(stiAttrbValuesList));
            sn.setAttribute(radioButStatus, sn.getAttribute(radioButStatus));
            sn.setAttribute(typeOfDocumentInSn, stateTaxIdForm);
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

//	State Tax ID Form Attributes info from JSP
    @Override
    @Transactional
    public JSONObject stateTaxFormsAttributesInfoFromJSP(HttpServletRequest req) {
        LOGGER.debug("stateTaxFormsAttributesInfoFromJSP...Service");
        JSONObject stateFormInfoObj = new JSONObject();
        String textFieldList = null;
        String[] textField = new String[161];
        for (int i = 1; i < textField.length; i++) {
            textField[i] = req.getParameter("textField" + i);
            textFieldList = textFieldList + textField[i] + ",$,";
            textFieldList = textFieldList + req.getAttribute("textField100");
            stateFormInfoObj.put(i, textField[i]);
        }
        textFieldList = textFieldList.replace("null", "");
        String textAreaList = null;
        String[] textArea = new String[21];
        for (int l = 1; l < textArea.length; l++) {
            textArea[l] = req.getParameter("textArea" + l);
            textAreaList = textAreaList + textArea[l] + ",$,";
            stateFormInfoObj.put(l + 160, textArea[l]);
        }
        textAreaList = textAreaList.replace("null", "");
        textAreaList = textAreaList.replaceAll("[\n\r]", " ");
        String dateFieldList = null;
        String[] dateField = new String[51];
        for (int m = 1; m < dateField.length; m++) {
            dateField[m] = req.getParameter("dateField" + m);
            dateFieldList = dateFieldList + dateField[m] + ",$,";
            stateFormInfoObj.put(m + 180, dateField[m]);
        }
        dateFieldList = dateFieldList.replace("null", "");
        String selectBoxList = null;
        String[] selectBox = new String[31];
        for (int n = 1; n < selectBox.length; n++) {
            selectBox[n] = req.getParameter("selectBox" + n);
            selectBoxList = selectBoxList + selectBox[n] + ",$,";
            stateFormInfoObj.put(n + 230, selectBox[n]);
        }
        selectBoxList = selectBoxList.replace("null", "");
        String zipCodeList = null;
        String[] zipCode = new String[51];
        for (int k = 1; k < zipCode.length; k++) {
            zipCode[k] = req.getParameter("zipCode" + k);
            zipCodeList = zipCodeList + zipCode[k] + ",$,";
            stateFormInfoObj.put(k + 260, zipCode[k]);
        }
        zipCodeList = zipCodeList.replace("null", "");
        String radioButtonList = null;
        String[] radioButton = new String[301];
        for (int o = 1; o < radioButton.length; o++) {
            radioButton[o] = req.getParameter("radioButton" + o);
            radioButtonList = radioButtonList + radioButton[o] + ",$,";
            stateFormInfoObj.put(o + 310, radioButton[o]);
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
                }
                ddynamicCheckValue = ddynamicCheckValue.replaceFirst(", ", "");
                checkBoxList = checkBoxList + ddynamicCheckValue + ",$,";
                stateFormInfoObj.put(p + 610, ddynamicCheckValue);
            } else {
                checkBoxList = checkBoxList + checkSingele + ",$,";
                stateFormInfoObj.put(p + 610, checkSingele);
            }
        }
        checkBoxList = checkBoxList.replace("null", "");
        req.setAttribute(textFieldsList, textFieldList);
        req.setAttribute(textAreasList, textAreaList);
        req.setAttribute(dateFieldsList, dateFieldList);
        req.setAttribute(selectBoxesList, selectBoxList);
        req.setAttribute(zipCodesList, zipCodeList);
        req.setAttribute(radioButtonsList, radioButtonList);
        req.setAttribute(checkBoxsList, checkBoxList);
        return stateFormInfoObj;
    }

// State Tax ID Form Status
    @Override
    @Transactional
    public String stateTaxIdFormStatusInDB(HttpServletRequest req, HttpSession sn) {
        String formStatus = null;
        JSONObject stateFormInfoObj = stateTaxFormsAttributesInfoFromJSP(req);
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
    
//    State Tax Id Forms All Related Other Tables Update		    
	  @Override
	  @Transactional
	  public ModelAndView stateTaxIdFormsAllRelatedOtherTablesUpdate(HttpServletRequest req, HttpSession sn) {
		  LOGGER.debug("stateTaxIdFormsAllRelatedOtherTablesUpdate...Service");
		  ModelAndView mav = new ModelAndView();
		  Timestamp currentDate = currentDate();		  
		  List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
          if (!allStateFormsPaymentList.isEmpty()) {
              AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              allStateFormsPaymentInfoSaving.setUserChoice(req.getParameter(textField1));
              allStateFormsPaymentInfoSaving.setUpdatedDate(currentDate);
              allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);
          }
          List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
          if (!allFormsAddCartPaymentList.isEmpty()) {
              AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              String combValue = req.getParameter(textField1) + ", " + sn.getAttribute(formNameInSn) + ", " + sn.getAttribute(stateNameInSn) + ".";
              allStateAndFedAddCartPayment.setUserChoice(req.getParameter(textField1));
              allStateAndFedAddCartPayment.setSelectedDocumentsName(combValue);
              allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
              AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
              allStCheckoutPaymentAndUserContact.setUserChoice(req.getParameter(textField1));
              allStCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
              allStateFormsCheckoutPaymentDAOImpl.merge(allStCheckoutPaymentAndUserContact);
          }             	       
	  return mav;
	  }

//	State Tax ID form modification
    @Override
    @Transactional
    public ModelAndView stateTaxIdFormsDataModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("stateTaxIdFormsDataModification...Service");
        ModelAndView mav = new ModelAndView();
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Required values take from DB
        List<StateTaxFormsAttributesInfo> addSerFormAttrList = stateTaxFormsAttrInfoDAOImpl.stateTaxIdDynamicFormShowHideData(formId);
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
        sn.setAttribute(stiAttrbRequiredList, attRequiredList);
        sn.setAttribute(stiAttrbRadioStatusList, attRadioStatusList);
        sn.setAttribute(stiAttrbInnerRadioList, innerRadioList);
        sn.setAttribute(stiAttrbAddAnotherList, addAnotherList);
//		State Tax Id form attribute fields and values take from DB this is simple join method
        List<Object> formFieldsAndValues = (List<Object>) stateTaxFormsAttrInfoDAOImpl.stateTaxIdFormsDynamicFieldsAndValues(formId);
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
        sn.setAttribute(stiAttrbNamesList, attNames);
        sn.setAttribute(stiAttrbValuesList, attValue);
//		State Tax Id forms Attribute Required type Ids take from DB 
        List<Object> attrReqTypeIdsList = (List<Object>) stateTaxFormsAttrInfoDAOImpl.stateTaxIdAttributeReqTypeIDsList(formId);
        String attrReqTypeIds = attrReqTypeIdsList.toString();
        attrReqTypeIds = attrReqTypeIds.replace("[", "");
        attrReqTypeIds = attrReqTypeIds.replace("]", "");
//		Radio Button Status take from DB 			
        List<Object> radioButtonStatus = (List<Object>) stateTaxFormsAttrInfoDAOImpl.stateTaxIdRadioButtonStatus(formId);
        mav = stateTaxIdFormsModificationAttributesInfo(req, sn);
        AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
        String stateFormPageValues = stateFormsUpdateModel.getPageVariableReference();
        mav = new ModelAndView(stTaxIdFormModification);
        sn.setAttribute(userChoiceInSn, (String) sn.getAttribute(userChoiceInSn));
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

//	State Tax ID Form Modification Attributes info
    @Override
    @Transactional
    public ModelAndView stateTaxIdFormsModificationAttributesInfo(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("stateTaxIdFormsModificationAttributesInfo...Service");
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
        ModelAndView mav = new ModelAndView();
        List<StateTaxFormsAttributesAndValuesSaving> stiFormAttrAndValModel = stateTaxAttrAndValuesSavingDAOImpl.findByallStateTaxIdFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
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
            LOGGER.error("stateTaxIdFormsDataModification " + e);
        }
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
        req.setAttribute(radioButtonsList, radioButtonList);
        req.setAttribute(checkBoxsList, checkBoxList);
        return mav;
    }

//	State Tax ID Forms Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView stateTaxIdFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("stateTaxIdFormsCheckouDataDisplay...Service");
        ModelAndView mav = new ModelAndView();
//		Form Id getting from DB
        int formId = takeFormIdFromDB(sn);
//		Required values take from DB		
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<StateTaxFormsAttributesAndValuesSaving> stiFormAttrAndValModel = stateTaxAttrAndValuesSavingDAOImpl.findByallStateTaxIdFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
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
                LOGGER.error("stateTaxIdFormsCheckouDataDisplay " + e);
            }
//			State forms Ids take from DB 			
            List attrNamesList = new ArrayList();
            List attrFieldIdsList = new ArrayList();
            List attrTypeList = new ArrayList();
            List<Object> formFieldsAndValuesIds = (List<Object>) stateTaxFormsAttrInfoDAOImpl.stateTaxIdFormsDynamicFieldsAndValuesIDs(formId);
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
            mav = new ModelAndView("stateTaxIdFormCheckoutDisplayCreation");
            sn.setAttribute("Attr_STI_Names_CheckOutList", attrSTNamesList);
            sn.setAttribute("Attr_STI_Type_CheckOutList", attrSTTypeList);
            sn.setAttribute("Attr_STI_Values_CheckOutList", attrSTValuesList);
            sn.setAttribute("Attr_IDs_STI_CheckOutList", attrSTIdsList);
            mav.addObject(stateName, (String) sn.getAttribute(stateNameInSn));
            mav.addObject(formName, (String) sn.getAttribute(formNameInSn));
        }
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        sn.setAttribute(formIdInSn, formId);
        sn.setAttribute(stateNameInSn, (String) sn.getAttribute(stateNameInSn));
        sn.setAttribute(formNameInSn, (String) sn.getAttribute(formNameInSn));
        return mav;
    }

//	State Tax ID First Choice Checking Service
    @Override
    @Transactional
    public JSONArray jSonStateTaxFirstChoiceChecking(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("jSonStateTaxFirstChoiceChecking...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
//		User Choice take from DB        
        List userChoiceList = allStateFormsDataSavingDAOImpl.allStateFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), stateTaxIdForm, (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), userFirstChoice);
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

//	State Tax Id forms Checkout redirection service
    @Override
    @Transactional
    public ModelAndView stateTaxIdCheckoutDataRedirection(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("stateTaxIdCheckoutDataRedirection...Service");
        String stateTaxCheckOutRef = (String) req.getParameter("stateTaxIdFormsCheckOutRef");
        ModelAndView mav = new ModelAndView();
        if (("STICheckoutModification").equals(stateTaxCheckOutRef)) {
            mav = stateTaxIdFormsDataModification(req, sn);
        } else if (("STICheckoutPayment").equals(stateTaxCheckOutRef)) {
            mav = stateFormsServiceImpl.stateFormsCheckoutPaymentDataSaving(req, sn);
        }
        return mav;
    }

//	State Tax Id Checkout Display JSON Values updated in DB Service
    @Override
    @Transactional
    public JSONArray jSonSTICheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("jSonSTICheckoutDataUpdationInDB...Service");
        String[] roleName = updatedAttrVal.split(" _ ");
        String attrValue = roleName[0];
        String attrId = roleName[1];
        String attrType = roleName[2];
        attrValue = attrValue.replace("$,$", "&");
        String modValue = null;
//		userChoice checking in DB		
        int count = 0;
        if ((tf1).equals(attrType)) {
            List userChoiceInDB = allStateFormsDataSavingDAOImpl.allStateFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), attrValue);
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
            List<StateTaxFormsAttributesAndValuesSaving> stiFormAttrAndValModel = stateTaxAttrAndValuesSavingDAOImpl.findByallStateTaxIdFormsCapturedInfoFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
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
                LOGGER.error("jSonSTICheckoutDataUpdationInDB " + e);
            }
            capInfoJsonObject.remove(attrId);
            capInfoJsonObject.put(attrId, attrValue);
            String jsonStringObj = capInfoJsonObject.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            StateTaxFormsAttributesAndValuesSaving stiAttrAndValModel = stateTaxAttrAndValuesSavingDAOImpl.findByStateTaxIdFormsAttributesAndValuesFromDB((Integer) sn.getAttribute(userIdInSn), formId, (String) sn.getAttribute(userChoiceInSn));
            stiAttrAndValModel.setCapturedInformation(jsonStringObj);
            stiAttrAndValModel.setModifiedDate(currentDate);
            stateTaxAttrAndValuesSavingDAOImpl.merge(stiAttrAndValModel);
            AllStateFormsDataSaving stateFormsUpdateModel = allStateFormsDataSavingDAOImpl.findByallStateFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(userChoiceInSn));
            if ((tf1).equals(attrType)) {
                stateFormsUpdateModel.setUserChoice(attrValue);
                stateFormsUpdateModel.setModifiedDate(currentDate);
                allStateFormsDataSavingDAOImpl.merge(stateFormsUpdateModel);
                stiAttrAndValModel.setUserChoice(attrValue);
                stateTaxAttrAndValuesSavingDAOImpl.merge(stiAttrAndValModel);
//              All related tables updating
                List allStateFormsPaymentList = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                if (!allStateFormsPaymentList.isEmpty()) {
                    AllStateFormsPaymentInfoSaving allStateFormsPaymentInfoSaving = allStateFormsPaymentSavingDAOImpl.allStateFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                    allStateFormsPaymentInfoSaving.setUserChoice(attrValue);
                    allStateFormsPaymentInfoSaving.setUpdatedDate(currentDate);
                    allStateFormsPaymentSavingDAOImpl.merge(allStateFormsPaymentInfoSaving);
                }
                List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                if (!allFormsAddCartPaymentList.isEmpty()) {
                    AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allStateFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
                    String combValue = attrValue + ", " + sn.getAttribute(formNameInSn) + ", " + sn.getAttribute(stateNameInSn) + ".";
                    allStateAndFedAddCartPayment.setUserChoice(attrValue);
                    allStateAndFedAddCartPayment.setSelectedDocumentsName(combValue);
                    allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
                    AllStateFormsCheckoutPaymentAndUserContactSaving allStCheckoutPaymentAndUserContact = allStateFormsCheckoutPaymentDAOImpl.allStateFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute("typeOfDocumentInSn"), (String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn), (String) sn.getAttribute(userChoiceInSn));
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
        List<Forms> stFormId = stateTaxFormsAttrInfoDAOImpl.stateTaxIdFormsIdValueFromDB((String) sn.getAttribute(stateNameInSn), (String) sn.getAttribute(formNameInSn));
        int formId = 0;
        for (Forms formsInfo : stFormId) {
            formId = formsInfo.getFormId();
        }
        return formId;
    }
}
