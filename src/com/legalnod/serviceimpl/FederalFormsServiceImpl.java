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

import com.legalnod.daoimpl.AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllFederalFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllFederalFormsPaymentInfoSavingDAOImpl;
import com.legalnod.daoimpl.AllStateAndFederalFormsAddCartPaymentSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.FederalFormsPriceInfoDAOImpl;
import com.legalnod.daoimpl.FederalTaxIdFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.FederalTaxIdFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.FivezerooneAppFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.FivezerooneAppFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.PromoCodeWithBonusPriceInfoDAOImpl;
import com.legalnod.daoimpl.ScorporationFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.ScorporationFormsAttributesInfoDAOImpl;
import com.legalnod.model.AllFederalFormsCheckoutPaymentAndUserContactSaving;
import com.legalnod.model.AllFederalFormsDataSaving;
import com.legalnod.model.AllFederalFormsPaymentInfoSaving;
import com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving;
import com.legalnod.model.AllStateFormsDataSaving;
import com.legalnod.model.FederalTaxIdFormsAttributesAndValuesSaving;
import com.legalnod.model.FederalTaxIdFormsAttributesInfo;
import com.legalnod.model.FivezerooneAppFormsAttributesAndValuesSaving;
import com.legalnod.model.FivezerooneAppFormsAttributesInfo;
import com.legalnod.model.ScorporationFormsAttributesAndValuesSaving;
import com.legalnod.model.ScorporationFormsAttributesInfo;
import com.legalnod.service.FederalFormsService;

public class FederalFormsServiceImpl implements FederalFormsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FederalFormsServiceImpl.class);
    
    private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";    
    private String userNameInSn = "userNameInSn";    
    private String userChoiceInSn = "userChoiceInSn";
    private String typeOfDocumentInSn = "typeOfDocumentInSn";
    private String attributeTextField1 = "attributeTextField1";    
    private String federalTaxId = "Federal Tax ID";
    private String inProgress = "In Progress";
    private String readyForCheckout = "Ready for checkout";
    private String sCorporation = "S Corporation";
    private String fzoApplication = "501 Application";
    private String attrbTextFieldList = "attributeTextFieldList";
    private String attrbTextFieldDateList = "attributeTextFieldDateList";
    private String attrbSelectBoxList = "attributeSelectBoxList";
    private String radioButtList = "radioButtonList";
    private String ckBoxsList = "checkBoxList";
    private String attrbTextAreaList = "attributeTextAreaList";
    private String attrbTextFieldZipList = "attributeTextFieldZipList";    
    private String radioButtStatus = "RadioButtonStatus";
    private String attrbReqTypeIdsInSn = "attrReqTypeIdsInSn";
    private String totalReqAttrbCountInSn = "totalReqAttrCountInSn";    
    private String newFedFormsCreation = "newFederalFormCreation";
    private String newSCorpFormsCreation = "newSCorpFormCreation";
    private String newFiveZeroOneFormsCreation = "newFiveZeroOneFormCreation";    
    private String pendStateFormsCount = "pendingStateFormsCount";
    private String pendFedFormsCount = "pendingFedFormsCount";
    private String compStateFormsCount = "comStateFormsCount";
    private String compFedFormsCount = "completedFedFormsCount";
    private String jSonUserChoice = "UserChoice";
    private String documentsCombi = "documentsComb";
    private String formCount = "formsCount";
    private String jSonObjt = "JSonObj";
    private String tf1 = "TF1";
    private String yes = "yes";
    private String no = "no";    
    private String paymentFeeTotal = "paymentTotal";
    private String docPromoCode = "promoCode";
    private String invoiceNumInSn = "invoiceNumberInSn";    
    private String fzoAttrbNames = "FZO_Attr_Names";
    private String fzoAttrbValues = "FZO_Attr_Values";
    private String fzoAttrbReqList = "FZO_Attr_Req_List";
    private String fzoAttrbStatusList = "FZO_Attr_Status_List";    
    private String sfAttrbNames = "SFed_Attr_Names";
    private String sfAttrbValues = "SFed_Attr_Values";
    private String sfAttrbReqList = "SFed_Attr_Req_List";
    private String sfAttrbStatusList = "SFed_Attr_Status_List";    
    private String scAttrbNames = "SCorp_Attr_Names";
    private String scAttrbValues = "SCorp_Attr_Values";
    private String scAttrbReqList = "SCorp_Attr_Req_List";
    private String scAttrbStatusList = "SCorp_Attr_Status_List";
    private String fedFormPageValues = "federalFormPageValues";
    private String sCorpFormPageVal = "sCorpFormPageValues";    
    private String fzoFormPageVal = "fiveZeroOneFormPageValues";
    private String fedFinishOrderRef = "federalDocFinishOrderRef";
    private String scFinishOrderRef = "sCorpFinishOrderRef";
    private String fzoFinishOrderRef = "fiveZeroOneFinishOrderRef";
    private String alreadyHaveChoice = "AlreadyExitChoice";
    private String alreadyHaveUserChoice = "AlreadyExitUserChoice";
    private String finishedStatus = "Finished";
    private String allFedFormsRefType = "allFederalFormsRefType";
    
    
    @Autowired
    private FederalTaxIdFormsAttributesInfoDAOImpl federalTaxAttrInfoDAOImpl;

    @Autowired
    private AllFederalFormsDataSavingDAOImpl allFederalFormsSavingDAOImpl;

    @Autowired
    private FederalTaxIdFormsAttributesAndValuesSavingDAOImpl federalFormsAttrAndValuesDAOImpl;

    @Autowired
    private ScorporationFormsAttributesInfoDAOImpl sCorpAttrInfoDAOImpl;

    @Autowired
    private ScorporationFormsAttributesAndValuesSavingDAOImpl scorpoFormsAttrAndValuesDAOImpl;

    @Autowired
    private FivezerooneAppFormsAttributesInfoDAOImpl fiveZeroOneAttrInfoDAOImpl;

    @Autowired
    private FivezerooneAppFormsAttributesAndValuesSavingDAOImpl fiveZOFormsAttrAndValuesDAOImpl;

    @Autowired
    private AllFederalFormsPaymentInfoSavingDAOImpl allFederalFormsPaymentInfoDAOImpl;

    @Autowired
    private AllStateAndFederalFormsAddCartPaymentSavingDAOImpl allFormsAddCartPaymentSavingDAOImpl;

    @Autowired
    private AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl allFedCheckoutPaymentAndContactDAOImpl;

    @Autowired
    private BusinessServicesServiceImpl businessServicesServiceImpl;

    @Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;

    @Autowired
    private FederalFormsPriceInfoDAOImpl federalFormsPriceInfoDAOImpl;

    @Autowired
    private PromoCodeWithBonusPriceInfoDAOImpl promoCodeBonusPriceDAOImpl;
    
    @Autowired
    private StateFormsServiceImpl stateFormsServiceImpl;
    
    @Autowired
    private FederalFormsUpdateServiceImpl federalFormsUpdateServiceImpl;
    
    @Autowired
    private UsersInformationServiceImpl usersInformationServiceImpl;

//	Single Federal Form modification Service Implementation
    @Override
    @Transactional
    public ModelAndView singleFederalTaxDataModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("singleFederalTaxDataModification...Service");
        JSONObject stateFormInfoObj = federalFormsUpdateServiceImpl.singleFederalFormsAttributesInfoFromJSP(req);
        ModelAndView mav;
//		Already Exit User choice when ever directly clicking enter with out using mouse        
        List userAEChoiceList = allFederalFormsSavingDAOImpl.allFederalFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), federalTaxId, req.getParameter(attributeTextField1));
        String alreadyExitChoice = null;        
        if (!userAEChoiceList.isEmpty()) {
            AllFederalFormsDataSaving federalFormsAEModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), federalTaxId, req.getParameter(attributeTextField1));
            alreadyExitChoice = federalFormsAEModel.getDocumentName();            
        }        
        if (alreadyExitChoice != null  && !alreadyExitChoice.equals(sn.getAttribute(userChoiceInSn))) {
            mav = new ModelAndView(newFedFormsCreation);
            mav.addObject(alreadyHaveChoice, alreadyHaveUserChoice);
        } else {
        	String formStatus = federalTaxIDFormStatusInDB(req, sn);
            String jsonStringObj = stateFormInfoObj.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            if (sn.getAttribute(userChoiceInSn) == null) {
//				Only Federal Tax Id Forms Attributes And Values Saving in DB
                FederalTaxIdFormsAttributesAndValuesSaving fedTaxAttrAndValModel = new FederalTaxIdFormsAttributesAndValuesSaving();
                fedTaxAttrAndValModel.setUserName((String) sn.getAttribute(userNameInSn));
                fedTaxAttrAndValModel.setLegalName(req.getParameter(attributeTextField1));
                fedTaxAttrAndValModel.setCapturedInformation(jsonStringObj);
                fedTaxAttrAndValModel.setCreatedDate(currentDate);
                federalFormsAttrAndValuesDAOImpl.save(fedTaxAttrAndValModel);
//				Data Saving to All All Federal Forms Data Saving in DB			
                AllFederalFormsDataSaving allfedTaxFormsModel = new AllFederalFormsDataSaving();
                allfedTaxFormsModel.setUserName((String) sn.getAttribute(userNameInSn));
                allfedTaxFormsModel.setTypeOfDocument(federalTaxId);
                allfedTaxFormsModel.setDocumentName(req.getParameter(attributeTextField1));
                allfedTaxFormsModel.setStatus(formStatus);
                allfedTaxFormsModel.setCreatedDate(currentDate);
                allfedTaxFormsModel.setPageVariableReference(req.getParameter(fedFormPageValues));
                allFederalFormsSavingDAOImpl.save(allfedTaxFormsModel);
            } else {
                FederalTaxIdFormsAttributesAndValuesSaving fedAttrAndValModel = federalFormsAttrAndValuesDAOImpl.findByFederalTaxFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
                fedAttrAndValModel.setLegalName(req.getParameter(attributeTextField1));
                fedAttrAndValModel.setCapturedInformation(jsonStringObj);
                fedAttrAndValModel.setModifiedDate(currentDate);
                federalFormsAttrAndValuesDAOImpl.merge(fedAttrAndValModel);
                AllFederalFormsDataSaving fedTaxFormsModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), federalTaxId, (String) sn.getAttribute(userChoiceInSn));
                fedTaxFormsModel.setDocumentName(req.getParameter(attributeTextField1));
                fedTaxFormsModel.setStatus(formStatus);
                fedTaxFormsModel.setModifiedDate(currentDate);
                fedTaxFormsModel.setPageVariableReference(req.getParameter(fedFormPageValues));
                allFederalFormsSavingDAOImpl.merge(fedTaxFormsModel);
//              All related tables updating
                List allFederaslFormsPaymentList = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), federalTaxId, (String) sn.getAttribute(userChoiceInSn));
                if (!allFederaslFormsPaymentList.isEmpty()) {
                    AllFederalFormsPaymentInfoSaving allFedFormsPaymentInfoSaving = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), federalTaxId, (String) sn.getAttribute(userChoiceInSn));
                    allFedFormsPaymentInfoSaving.setLegalName(req.getParameter(attributeTextField1));
                    allFedFormsPaymentInfoSaving.setUpdatedDate(currentDate);
                    allFederalFormsPaymentInfoDAOImpl.merge(allFedFormsPaymentInfoSaving);
                }
                List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allOnlyFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), federalTaxId, (String) sn.getAttribute(userChoiceInSn));
                if (!allFormsAddCartPaymentList.isEmpty()) {
                    AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allFederalFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), federalTaxId, (String) sn.getAttribute(userChoiceInSn));
                    allStateAndFedAddCartPayment.setSelectedDocumentsName(req.getParameter(attributeTextField1));
                    allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
                    AllFederalFormsCheckoutPaymentAndUserContactSaving allFedCheckoutPaymentAndUserContact = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), federalTaxId, (String) sn.getAttribute(userChoiceInSn));
                    allFedCheckoutPaymentAndUserContact.setLegalName(req.getParameter(attributeTextField1));
                    allFedCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
                    allFedCheckoutPaymentAndContactDAOImpl.merge(allFedCheckoutPaymentAndUserContact);
                }
            }
            sn.setAttribute(userChoiceInSn, req.getParameter(attributeTextField1));
            if (req.getParameter(fedFinishOrderRef) != null && (finishedStatus).equals(req.getParameter(fedFinishOrderRef))) {
                mav = federalTaxIdFormsCheckouDataDisplay(req, sn);
            } else {
                mav = new ModelAndView(newFedFormsCreation);
            }
            mav.addObject(fedFormPageValues, req.getParameter(fedFormPageValues));
            sn.setAttribute(sfAttrbNames, sn.getAttribute(sfAttrbNames));
            sn.setAttribute(sfAttrbValues, sn.getAttribute(sfAttrbValues));
            sn.setAttribute(sfAttrbReqList, sn.getAttribute(sfAttrbReqList));
            sn.setAttribute(sfAttrbStatusList, sn.getAttribute(sfAttrbStatusList));
            sn.setAttribute(radioButtStatus, sn.getAttribute(radioButtStatus));            
            sn.setAttribute(typeOfDocumentInSn, federalTaxId);
        }        
        mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
        mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
        mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
        mav.addObject(radioButtList, req.getAttribute(radioButtList));
        mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));        
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }
	    
// 		Single Federal Tax ID Form Status
	    @Override
	    @Transactional
	    public String federalTaxIDFormStatusInDB(HttpServletRequest req, HttpSession sn) {
	    	LOGGER.debug("federalTaxIDFormStatusInDB...Service");
	        String formStatus = null;
	        JSONObject stateFormInfoObj = federalFormsUpdateServiceImpl.singleFederalFormsAttributesInfoFromJSP(req);
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
                formStatus = readyForCheckout;
            } else {
                formStatus = inProgress;
            }
	        return formStatus;
	    }

//	Federal Tax ID Legal Name Checking Service
    @Override
    @Transactional
    public JSONArray jSonFederalTaxLegalNameChecking(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("jSonFederalTaxLegalNameChecking...Service");        
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
//		Legal Name take from DB        
        List userChoiceList = allFederalFormsSavingDAOImpl.allFederalFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), federalTaxId, userFirstChoice);
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
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//all Federal Tax id Forms Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView federalTaxIdFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("federalTaxIdFormsCheckouDataDisplay...Service");
        ModelAndView mav = new ModelAndView();
//		Required values take from DB		
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<FederalTaxIdFormsAttributesAndValuesSaving> busFedFormAttrAndValModel = federalFormsAttrAndValuesDAOImpl.findByallFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (FederalTaxIdFormsAttributesAndValuesSaving federalFormAttrAndValModel : busFedFormAttrAndValModel) {
                capturedInfoInDB = federalFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);          
//	  		Federal Tax Ids take from DB 			
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
            mav = new ModelAndView("federalTaxFormCheckoutDisplayCreation");
            sn.setAttribute("Fed_Attr_Names_CheckOutList", attrFFNamesList);
            sn.setAttribute("Fed_Attr_Type_CheckOutList", attrFFTypeList);
            sn.setAttribute("Fed_Attr_Values_CheckOutList", attrFFValuesList);
            sn.setAttribute("Fed_Attr_IDs_CheckOutList", attrFFIdsList);
        }
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }

//S Corporation Form modification Service Implementation
    @Override
    @Transactional
    public ModelAndView sCorporationDataModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("sCorporationDataModification...Service");
        JSONObject stateFormInfoObj = federalFormsUpdateServiceImpl.sCorporationFormsAttributesInfoFromJSP(req);
        ModelAndView mav;
//		Already Exit User choice when ever directly clicking enter with out using mouse        
        List userAEChoiceList = allFederalFormsSavingDAOImpl.allFederalFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), sCorporation, req.getParameter(attributeTextField1));
        String alreadyExitChoice = null;        
        if (!userAEChoiceList.isEmpty()) {
            AllFederalFormsDataSaving federalFormsAEModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), sCorporation, req.getParameter(attributeTextField1));
            alreadyExitChoice = federalFormsAEModel.getDocumentName();            
        }        
        if (alreadyExitChoice != null  && !alreadyExitChoice.equals(sn.getAttribute(userChoiceInSn))) {
            mav = new ModelAndView(newSCorpFormsCreation);
            mav.addObject(alreadyHaveChoice, alreadyHaveUserChoice);
        } else {
        	String formStatus = sCorporationFormStatusInDB(req, sn);
            String jsonStringObj = stateFormInfoObj.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            if (sn.getAttribute(userChoiceInSn) == null) {
//				Only S Corporation Forms Attributes And Values Saving in DB
                ScorporationFormsAttributesAndValuesSaving sCorpAttrAndValModel = new ScorporationFormsAttributesAndValuesSaving();
                sCorpAttrAndValModel.setUserName((String) sn.getAttribute(userNameInSn));
                sCorpAttrAndValModel.setCorpName(req.getParameter(attributeTextField1));
                sCorpAttrAndValModel.setCapturedInformation(jsonStringObj);
                sCorpAttrAndValModel.setCreatedDate(currentDate);
                scorpoFormsAttrAndValuesDAOImpl.save(sCorpAttrAndValModel);
//				Data Saving to All All Federal Forms Data Saving in DB			
                AllFederalFormsDataSaving allfedTaxFormsModel = new AllFederalFormsDataSaving();
                allfedTaxFormsModel.setUserName((String) sn.getAttribute(userNameInSn));
                allfedTaxFormsModel.setTypeOfDocument(sCorporation);
                allfedTaxFormsModel.setDocumentName(req.getParameter(attributeTextField1));
                allfedTaxFormsModel.setStatus(formStatus);
                allfedTaxFormsModel.setCreatedDate(currentDate);
                allfedTaxFormsModel.setPageVariableReference(req.getParameter(sCorpFormPageVal));
                allFederalFormsSavingDAOImpl.save(allfedTaxFormsModel);
            } else {
                ScorporationFormsAttributesAndValuesSaving sCorpAttrAndValModel = scorpoFormsAttrAndValuesDAOImpl.findBySCorpFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
                sCorpAttrAndValModel.setCorpName(req.getParameter(attributeTextField1));
                sCorpAttrAndValModel.setCapturedInformation(jsonStringObj);
                sCorpAttrAndValModel.setModifiedDate(currentDate);
                scorpoFormsAttrAndValuesDAOImpl.merge(sCorpAttrAndValModel);
                AllFederalFormsDataSaving fedTaxFormsModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), sCorporation, (String) sn.getAttribute(userChoiceInSn));
                fedTaxFormsModel.setDocumentName(req.getParameter(attributeTextField1));
                fedTaxFormsModel.setStatus(formStatus);
                fedTaxFormsModel.setModifiedDate(currentDate);
                fedTaxFormsModel.setPageVariableReference(req.getParameter(sCorpFormPageVal));
                allFederalFormsSavingDAOImpl.merge(fedTaxFormsModel);
//          	All related tables updating
                List allFederaslFormsPaymentList = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), sCorporation, (String) sn.getAttribute(userChoiceInSn));
                if (!allFederaslFormsPaymentList.isEmpty()) {
                    AllFederalFormsPaymentInfoSaving allFedFormsPaymentInfoSaving = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), sCorporation, (String) sn.getAttribute(userChoiceInSn));
                    allFedFormsPaymentInfoSaving.setLegalName(req.getParameter(attributeTextField1));
                    allFedFormsPaymentInfoSaving.setUpdatedDate(currentDate);
                    allFederalFormsPaymentInfoDAOImpl.merge(allFedFormsPaymentInfoSaving);
                }
                List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allOnlyFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), sCorporation, (String) sn.getAttribute(userChoiceInSn));
                if (!allFormsAddCartPaymentList.isEmpty()) {
                    AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allFederalFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), sCorporation, (String) sn.getAttribute(userChoiceInSn));
                    allStateAndFedAddCartPayment.setSelectedDocumentsName(req.getParameter(attributeTextField1));
                    allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
                    AllFederalFormsCheckoutPaymentAndUserContactSaving allFedCheckoutPaymentAndUserContact = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), sCorporation, (String) sn.getAttribute(userChoiceInSn));
                    allFedCheckoutPaymentAndUserContact.setLegalName(req.getParameter(attributeTextField1));
                    allFedCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
                    allFedCheckoutPaymentAndContactDAOImpl.merge(allFedCheckoutPaymentAndUserContact);
                }
            }
            sn.setAttribute(userChoiceInSn, req.getParameter(attributeTextField1));
            if (req.getParameter(scFinishOrderRef) != null && (finishedStatus).equals(req.getParameter(scFinishOrderRef))) {
                mav = sCorporationFormsCheckouDataDisplay(req, sn);
            } else {
                mav = new ModelAndView(newSCorpFormsCreation);
            }
            mav.addObject(sCorpFormPageVal, req.getParameter(sCorpFormPageVal));
            sn.setAttribute(scAttrbNames, sn.getAttribute(scAttrbNames));
            sn.setAttribute(scAttrbValues, sn.getAttribute(scAttrbValues));
            sn.setAttribute(scAttrbReqList, sn.getAttribute(scAttrbReqList));
            sn.setAttribute(scAttrbStatusList, sn.getAttribute(scAttrbStatusList));
            sn.setAttribute(radioButtStatus, sn.getAttribute(radioButtStatus));            
            sn.setAttribute(typeOfDocumentInSn, sCorporation);
        }        
        mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
        mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
        mav.addObject(attrbTextAreaList, req.getAttribute(attrbTextAreaList));
        mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));        
        mav.addObject(radioButtList, req.getAttribute(radioButtList));
        mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));        
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }
        
 // S Corporation Form Status
    @Override
    @Transactional
    public String sCorporationFormStatusInDB(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("sCorporationFormStatusInDB...Service");
        String formStatus = null;
        JSONObject stateFormInfoObj = federalFormsUpdateServiceImpl.sCorporationFormsAttributesInfoFromJSP(req);
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
            formStatus = readyForCheckout;
        } else {
            formStatus = inProgress;
        }
        return formStatus;
    }

//	S Corporation Name Checking Service
    @Override
    @Transactional
    public JSONArray jSonSCorporationNameChecking(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("jSonSCorporationNameChecking...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
//		S Corporation Name take from DB        
        List userChoiceList = allFederalFormsSavingDAOImpl.allFederalFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), sCorporation, userFirstChoice);
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
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//	all S Corporation Forms Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView sCorporationFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("sCorporationFormsCheckouDataDisplay...Service");
        ModelAndView mav = new ModelAndView();
//		Required values take from DB		
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<ScorporationFormsAttributesAndValuesSaving> busSCorpFormAttrAndValModel = scorpoFormsAttrAndValuesDAOImpl.findByallSCorpFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (ScorporationFormsAttributesAndValuesSaving sCorpFormAttrAndValModel : busSCorpFormAttrAndValModel) {
                capturedInfoInDB = sCorpFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);            
//			S Corporation Ids take from DB 			
            List attrNamesList = new ArrayList();
            List attrFieldIdsList = new ArrayList();
            List attrTypeList = new ArrayList();
            List<Object> formFieldsAndValuesIds = (List<Object>) sCorpAttrInfoDAOImpl.sCorpFormsDynamicFieldsAndValuesIDs();
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
                    for (int k = 0; k < jSonObjVal.length() + 30; k++) {
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
            mav = new ModelAndView("sCorpFormCheckoutDisplayCreation");
            sn.setAttribute("SCorp_Attr_Names_CheckOutList", attrFFNamesList);
            sn.setAttribute("SCorp_Attr_Type_CheckOutList", attrFFTypeList);
            sn.setAttribute("SCorp_Attr_Values_CheckOutList", attrFFValuesList);
            sn.setAttribute("SCorp_Attr_IDs_CheckOutList", attrFFIdsList);
        }
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }

//	501 Application Form modification Service Implementation
    @Override
    @Transactional
    public ModelAndView fiveZeroOneFormModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("fiveZeroOneFormModification...Service");
        JSONObject stateFormInfoObj = federalFormsUpdateServiceImpl.fiveZeroOneFormsAttributesInfoFromJSP(req);
        ModelAndView mav;
//		Already Exit User choice when ever directly clicking enter with out using mouse        
        List userAEChoiceList = allFederalFormsSavingDAOImpl.allFederalFormsAlreadyExittUserChoiceInDB((String) sn.getAttribute(userNameInSn), fzoApplication, req.getParameter(attributeTextField1));
        String alreadyExitChoice = null;        
        if (!userAEChoiceList.isEmpty()) {
            AllFederalFormsDataSaving federalFormsAEModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), fzoApplication, req.getParameter(attributeTextField1));
            alreadyExitChoice = federalFormsAEModel.getDocumentName();            
        }        
        if (alreadyExitChoice != null  && !alreadyExitChoice.equals(sn.getAttribute(userChoiceInSn))) {
            mav = new ModelAndView(newFiveZeroOneFormsCreation);
            mav.addObject(alreadyHaveChoice, alreadyHaveUserChoice);
        } else {
        	String formStatus = fiveZeroOneFormStatusInDB(req, sn);
            String jsonStringObj = stateFormInfoObj.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            if (sn.getAttribute(userChoiceInSn) == null) {
//				Only 501 Application Forms Attributes And Values Saving in DB
                FivezerooneAppFormsAttributesAndValuesSaving fzoAttrAndValModel = new FivezerooneAppFormsAttributesAndValuesSaving();
                fzoAttrAndValModel.setUserName((String) sn.getAttribute(userNameInSn));
                fzoAttrAndValModel.setAppName(req.getParameter(attributeTextField1));
                fzoAttrAndValModel.setCapturedInformation(jsonStringObj);
                fzoAttrAndValModel.setCreatedDate(currentDate);
                fiveZOFormsAttrAndValuesDAOImpl.save(fzoAttrAndValModel);
//				Data Saving to All All Federal Forms Data Saving in DB			
                AllFederalFormsDataSaving allfedTaxFormsModel = new AllFederalFormsDataSaving();
                allfedTaxFormsModel.setUserName((String) sn.getAttribute(userNameInSn));
                allfedTaxFormsModel.setTypeOfDocument(fzoApplication);
                allfedTaxFormsModel.setDocumentName(req.getParameter(attributeTextField1));
                allfedTaxFormsModel.setStatus(formStatus);
                allfedTaxFormsModel.setCreatedDate(currentDate);
                allfedTaxFormsModel.setPageVariableReference(req.getParameter(fzoFormPageVal));
                allFederalFormsSavingDAOImpl.save(allfedTaxFormsModel);
            } else {
                FivezerooneAppFormsAttributesAndValuesSaving fzoAttrAndValModel = fiveZOFormsAttrAndValuesDAOImpl.findByFZOFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
                fzoAttrAndValModel.setAppName(req.getParameter(attributeTextField1));
                fzoAttrAndValModel.setCapturedInformation(jsonStringObj);
                fzoAttrAndValModel.setModifiedDate(currentDate);
                fiveZOFormsAttrAndValuesDAOImpl.merge(fzoAttrAndValModel);
                AllFederalFormsDataSaving fedTaxFormsModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), fzoApplication, (String) sn.getAttribute(userChoiceInSn));
                fedTaxFormsModel.setDocumentName(req.getParameter(attributeTextField1));
                fedTaxFormsModel.setStatus(formStatus);
                fedTaxFormsModel.setModifiedDate(currentDate);
                fedTaxFormsModel.setPageVariableReference(req.getParameter(fzoFormPageVal));
                allFederalFormsSavingDAOImpl.merge(fedTaxFormsModel);
//        		All related tables updating
                List allFederaslFormsPaymentList = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), fzoApplication, (String) sn.getAttribute(userChoiceInSn));
                if (!allFederaslFormsPaymentList.isEmpty()) {
                    AllFederalFormsPaymentInfoSaving allFedFormsPaymentInfoSaving = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), fzoApplication, (String) sn.getAttribute(userChoiceInSn));
                    allFedFormsPaymentInfoSaving.setLegalName(req.getParameter(attributeTextField1));
                    allFedFormsPaymentInfoSaving.setUpdatedDate(currentDate);
                    allFederalFormsPaymentInfoDAOImpl.merge(allFedFormsPaymentInfoSaving);
                }
                List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allOnlyFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), fzoApplication, (String) sn.getAttribute(userChoiceInSn));
                if (!allFormsAddCartPaymentList.isEmpty()) {
                    AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allFederalFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), fzoApplication, (String) sn.getAttribute(userChoiceInSn));
                    allStateAndFedAddCartPayment.setSelectedDocumentsName(req.getParameter(attributeTextField1));
                    allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
                    AllFederalFormsCheckoutPaymentAndUserContactSaving allFedCheckoutPaymentAndUserContact = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), fzoApplication, (String) sn.getAttribute(userChoiceInSn));
                    allFedCheckoutPaymentAndUserContact.setLegalName(req.getParameter(attributeTextField1));
                    allFedCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
                    allFedCheckoutPaymentAndContactDAOImpl.merge(allFedCheckoutPaymentAndUserContact);
                }
            }
            sn.setAttribute(userChoiceInSn, req.getParameter(attributeTextField1));
            if (req.getParameter(fzoFinishOrderRef) != null && (finishedStatus).equals(req.getParameter(fzoFinishOrderRef))) {
                mav = fiveZeroOneFormsCheckouDataDisplay(req, sn);
            } else {
                mav = new ModelAndView(newFiveZeroOneFormsCreation);
            }
            mav.addObject(fzoFormPageVal, req.getParameter(fzoFormPageVal));
            sn.setAttribute(fzoAttrbNames, sn.getAttribute(fzoAttrbNames));
            sn.setAttribute(fzoAttrbValues, sn.getAttribute(fzoAttrbValues));
            sn.setAttribute(fzoAttrbReqList, sn.getAttribute(fzoAttrbReqList));
            sn.setAttribute(fzoAttrbStatusList, sn.getAttribute(fzoAttrbStatusList));
            sn.setAttribute(radioButtStatus, sn.getAttribute(radioButtStatus));
            sn.setAttribute(typeOfDocumentInSn, fzoApplication);
        }
        mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
        mav.addObject(attrbTextFieldZipList, req.getAttribute(attrbTextFieldZipList));
        mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
        mav.addObject(attrbTextAreaList, req.getAttribute(attrbTextAreaList));        
        mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
        mav.addObject(radioButtList, req.getAttribute(radioButtList));
        mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));        
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }
    
 // 501 Form Status
    @Override
    @Transactional
    public String fiveZeroOneFormStatusInDB(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("fiveZeroOneFormStatusInDB...Service");
        String formStatus = null;
        JSONObject stateFormInfoObj = federalFormsUpdateServiceImpl.fiveZeroOneFormsAttributesInfoFromJSP(req);
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
            formStatus = readyForCheckout;
        } else {
            formStatus = inProgress;
        }
        return formStatus;
    }

//	501 Application Name Checking Service
    @Override
    @Transactional
    public JSONArray jSonFiveZeroOneNameChecking(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("jSonFiveZeroOneNameChecking...Service");
        String userFirstChoice = updatedAttrVal;
        userFirstChoice = userFirstChoice.replaceAll("\\s+", " ");
//		501 Application Name take from DB        
        List userChoiceList = allFederalFormsSavingDAOImpl.allFederalFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), fzoApplication, userFirstChoice);
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
        jsonObj.put(jSonUserChoice, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//	all 501 Application Forms Checkout Service Implementation 
    @Override
    @Transactional
    public ModelAndView fiveZeroOneFormsCheckouDataDisplay(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("fiveZeroOneFormsCheckouDataDisplay...Service");
        ModelAndView mav = new ModelAndView();
//		Required values take from DB		
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<FivezerooneAppFormsAttributesAndValuesSaving> busFZOFormAttrAndValModel = fiveZOFormsAttrAndValuesDAOImpl.findByallFZOFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (FivezerooneAppFormsAttributesAndValuesSaving fZOFormAttrAndValModel : busFZOFormAttrAndValModel) {
                capturedInfoInDB = fZOFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);            
//			501 Application Ids take from DB 			
            List attrNamesList = new ArrayList();
            List attrFieldIdsList = new ArrayList();
            List attrTypeList = new ArrayList();
            List attrSubTypeList = new ArrayList();
            List<Object> formFieldsAndValuesIds = (List<Object>) fiveZeroOneAttrInfoDAOImpl.fiveZeroOneFormsDynamicFieldsAndValuesIDs();
            Iterator formFieldsAndValuesIdsIterator = formFieldsAndValuesIds.iterator();
            while (formFieldsAndValuesIdsIterator.hasNext()) {
                Object[] formFieldsAndValuesIdsObj = (Object[]) formFieldsAndValuesIdsIterator.next();
                String attrFieldId = String.valueOf(formFieldsAndValuesIdsObj[0]);
                String attrNames = String.valueOf(formFieldsAndValuesIdsObj[2]);
                String attrType = String.valueOf(formFieldsAndValuesIdsObj[3]);
                String attrSubType = String.valueOf(formFieldsAndValuesIdsObj[4]);
                attrFieldIdsList.add(attrFieldId);
                attrNamesList.add(attrNames + " ");
                attrTypeList.add(attrType);
                attrSubTypeList.add(attrSubType);
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
            String attrSubTypeListInString = attrSubTypeList.toString();
            attrSubTypeListInString = attrSubTypeListInString.replace("[", "");
            attrSubTypeListInString = attrSubTypeListInString.replace("]", "");
            String[] attrFieldIDInString = attrFieldIDListInString.split(", ");
            String[] attrNamesInString = attrNamesListInString.split(" , ");
            String[] attrTypeInString = attrTypeListInString.split(", ");
            String[] attrSubTypeInString = attrSubTypeListInString.split(", ");
            List attrFFNamesList = new ArrayList();
            List attrFFTypeList = new ArrayList();
            List attrFFValuesList = new ArrayList();
            List attrFFIdsList = new ArrayList();
            List attrFFSubTypeList = new ArrayList();
            for (int i = 0; i < attrFieldIDInString.length; i++) {
                String attrFieldId = attrFieldIDInString[i];
                String attrNames = attrNamesInString[i];
                String attrTypes = attrTypeInString[i];
                String attrSubTypes = attrSubTypeInString[i];
                String jSonObjVal = (String) capInfoJsonObject.get(attrFieldId);
                if (!("").equals(jSonObjVal)) {
                    String attrValue = jSonObjVal;
                    for (int k = 0; k < jSonObjVal.length() + 500; k++) {
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
                    attrFFSubTypeList.add(attrSubTypes);
                }
            }
            mav = new ModelAndView("fiveZeroOneFormCheckoutDisplayCreation");
            sn.setAttribute("FZO_Attr_Names_CheckOutList", attrFFNamesList);
            sn.setAttribute("FZO_Attr_Type_CheckOutList", attrFFTypeList);
            sn.setAttribute("FZO_Attr_Values_CheckOutList", attrFFValuesList);
            sn.setAttribute("FZO_Attr_IDs_CheckOutList", attrFFIdsList);
            sn.setAttribute("FZO_Attr_Sub_Type_CheckOutList", attrFFSubTypeList);
        }
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }

//	All Pending Federal forms retrieve from DB
    @Override
    @Transactional
    public ModelAndView pendingFederalFormsRedirection(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("pendingFederalFormsRedirection...Service");
        ModelAndView mav = new ModelAndView();
        List<AllFederalFormsDataSaving> penFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.federalFormsSavingDataTakeFromDB((String) sn.getAttribute(userNameInSn));        
        List<AllFederalFormsDataSaving> comFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.completedFederalFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));        
        List<AllStateFormsDataSaving> penStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));        
        List<AllStateFormsDataSaving> comStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.completedStateFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));        
        if (!penFederalFormsSavingInfoList.isEmpty()) {
            List<AllFederalFormsDataSaving> penFedFormSavingList = new ArrayList<AllFederalFormsDataSaving>();
            for (AllFederalFormsDataSaving penFederalFormsInfo : penFederalFormsSavingInfoList) {
                AllFederalFormsDataSaving penFederalFormsInfoModel = new AllFederalFormsDataSaving();
                penFederalFormsInfoModel.setTypeOfDocument(penFederalFormsInfo.getTypeOfDocument());
                penFederalFormsInfoModel.setDocumentName(penFederalFormsInfo.getDocumentName());
                Timestamp lastEditedDate = null;
                if (penFederalFormsInfo.getModifiedDate() != null) {
                    lastEditedDate = penFederalFormsInfo.getModifiedDate();
                } else {
                    lastEditedDate = penFederalFormsInfo.getCreatedDate();
                }
                penFederalFormsInfoModel.setCreatedDate(lastEditedDate);
                penFedFormSavingList.add(penFederalFormsInfoModel);
            }
            mav = new ModelAndView("pendingFederalFormsRedirection");
            mav.addObject("fedFormSavingList", penFedFormSavingList);
        } else if (penFederalFormsSavingInfoList.isEmpty() && !comFederalFormsSavingInfoList.isEmpty()) {
            mav = completedFederalFormsForUserDataDisplay(req, sn);
        } else if (!penStateFormsSavingInfoList.isEmpty() || !comStateFormsSavingInfoList.isEmpty()) {
            mav = stateFormsServiceImpl.stateFormUserMyAccountRedirection(req, sn);
        } else {
            mav = businessServicesServiceImpl.userProfileHome(req, sn);
        }
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject(formCount, penFederalFormsSavingInfoList.size());
        mav.addObject(pendStateFormsCount, penStateFormsSavingInfoList.size());
        mav.addObject(compFedFormsCount, comFederalFormsSavingInfoList.size());
        mav.addObject(compStateFormsCount, comStateFormsSavingInfoList.size());
        return mav;
    }

//	All Federal forms data operation service
    @Override
    @Transactional
    public ModelAndView allFederalFormsDataOperations(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("allFederalFormsDataOperations...Service");
        String documentsComb = (String) req.getParameter(documentsCombi);
        String[] documentsCombValue = documentsComb.split(",&, ");
        sn.setAttribute(typeOfDocumentInSn, documentsCombValue[0]);
        sn.setAttribute(userChoiceInSn, documentsCombValue[1]);
        ModelAndView mav = new ModelAndView();
        if(sn.getAttribute(userNameInSn) != null) {
        if (("FormModification").equals(req.getParameter(allFedFormsRefType))) {
            mav = allFederalFormsDataOperationsModification(documentsCombValue[0], req, sn);            
        } else if (("FormFinishOrder").equals(req.getParameter(allFedFormsRefType))) {
            mav = allFederalFormsDataOperationsFormFinishOrder(documentsCombValue[0], req, sn);            
        } else if (("FormDeletion").equals(req.getParameter(allFedFormsRefType))) {
        	mav = allFederalFormsRelatedTableDataDeletion(req, sn);            
        } else if (("NewFormCreation").equals(req.getParameter(allFedFormsRefType))) {
            mav = allFederalFormsDataOperationsNewFormCreation(documentsCombValue[0], req, sn);
        }        
	    } else{
			mav = usersInformationServiceImpl.logInHome(req, sn);
		}
        return mav;
    }
    
//	All Federal Forms Related table Data deletion
    @Override
    @Transactional
    public ModelAndView allFederalFormsRelatedTableDataDeletion(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("allFederalFormsRelatedTableDataDeletion...Service");
        ModelAndView mav = new ModelAndView();
        if ((federalTaxId).equals(sn.getAttribute(typeOfDocumentInSn))) {
            FederalTaxIdFormsAttributesAndValuesSaving fedAttrAndValModel = federalFormsAttrAndValuesDAOImpl.findByFederalTaxFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            federalFormsAttrAndValuesDAOImpl.delete(fedAttrAndValModel);
        } else if ((sCorporation).equals(sn.getAttribute(typeOfDocumentInSn))) {
            ScorporationFormsAttributesAndValuesSaving sCorpAttrAndValModel = scorpoFormsAttrAndValuesDAOImpl.findBySCorpFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            scorpoFormsAttrAndValuesDAOImpl.delete(sCorpAttrAndValModel);
        } else if ((fzoApplication).equals(sn.getAttribute(typeOfDocumentInSn))) {
            FivezerooneAppFormsAttributesAndValuesSaving fzoAttrAndValModel = fiveZOFormsAttrAndValuesDAOImpl.findByFZOFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            fiveZOFormsAttrAndValuesDAOImpl.delete(fzoAttrAndValModel);
        }
//    	All related tables Deletion
        List allFederaslFormsPaymentList = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        if (!allFederaslFormsPaymentList.isEmpty()) {
            AllFederalFormsPaymentInfoSaving allFedFormsPaymentInfoSaving = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allFederalFormsPaymentInfoDAOImpl.delete(allFedFormsPaymentInfoSaving);
        }
        List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allOnlyFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        if (!allFormsAddCartPaymentList.isEmpty()) {
            AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allFederalFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allFormsAddCartPaymentSavingDAOImpl.delete(allStateAndFedAddCartPayment);
            AllFederalFormsCheckoutPaymentAndUserContactSaving allFedCheckoutPaymentAndUserContact = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allFedCheckoutPaymentAndContactDAOImpl.delete(allFedCheckoutPaymentAndUserContact);
        }
        List allStAndFedAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataTakeFromDB((String) sn.getAttribute(userNameInSn));
        sn.setAttribute(noOfDocInCartInSn, allStAndFedAddCartPaymentList.size());
        AllFederalFormsDataSaving allFederalFormsDataSaving = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        Timestamp currentDate = currentDate();
        allFederalFormsDataSaving.setStatus("Deleted");
        allFederalFormsDataSaving.setDeletedDate(currentDate);
        allFederalFormsSavingDAOImpl.merge(allFederalFormsDataSaving);
        mav = pendingFederalFormsRedirection(req, sn);
        return mav;
    }
    
//	All Federal Forms Data Operations Modification
    @Override
    @Transactional
    public ModelAndView allFederalFormsDataOperationsModification(String documentsCombValue, HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("allFederalFormsDataOperationsModification...Service");
        ModelAndView mav = new ModelAndView();
        if ((federalTaxId).equals(documentsCombValue)) {
            mav = federalTaxIDSelectedFormModification(req, sn);
        } else if ((sCorporation).equals(documentsCombValue)) {
            mav = sCorporationSelectedFormModification(req, sn);
        } else if ((fzoApplication).equals(documentsCombValue)) {
            mav = fiveZeroOneFormSelectedFormModification(req, sn);
        }
        return mav;
    }
    
//	All Federal Forms Data Operations Form Finish Order
    @Override
    @Transactional
    public ModelAndView allFederalFormsDataOperationsFormFinishOrder(String documentsCombValue, HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("allFederalFormsDataOperationsFormFinishOrder...Service");
        ModelAndView mav = new ModelAndView();
        if ((federalTaxId).equals(documentsCombValue)) {
            mav = federalTaxIdFormsCheckouDataDisplay(req, sn);
        } else if ((sCorporation).equals(documentsCombValue)) {
            mav = sCorporationFormsCheckouDataDisplay(req, sn);
        } else if ((fzoApplication).equals(documentsCombValue)) {
            mav = fiveZeroOneFormsCheckouDataDisplay(req, sn);
        }
        return mav;
    }
    
//	All Federal Forms Data Operations New Form Creation
    @Override
    @Transactional
    public ModelAndView allFederalFormsDataOperationsNewFormCreation(String documentsCombValue, HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("allFederalFormsDataOperationsNewFormCreation...Service");
        ModelAndView mav = new ModelAndView();
        if ((federalTaxId).equals(documentsCombValue)) {
            mav = federalFormsUpdateServiceImpl.federalTaxIDFormUpdation(req, sn);
        } else if ((sCorporation).equals(documentsCombValue)) {
            mav = federalFormsUpdateServiceImpl.sCorporationFormUpdation(req, sn);
        } else if ((fzoApplication).equals(documentsCombValue)) {
            mav = federalFormsUpdateServiceImpl.fiveZeroOneFormUpdation(req, sn);
        }
        return mav;
    }

//	Single Federal Selected Form Modification Only Service
    @Override
    @Transactional
    public ModelAndView federalTaxIDSelectedFormModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("federalTaxIDFormModification...Service");
        ModelAndView mav;
//		Federal form: Names, Values and Required values take from DB
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
        sn.setAttribute(sfAttrbNames, attrNamesList);
        sn.setAttribute(sfAttrbValues, attrValueList);
        sn.setAttribute(sfAttrbReqList, attrReqTypeList);
        sn.setAttribute(sfAttrbStatusList, attrStatusList);
//		Federal forms Attribute Required type Ids take from DB 
        List<Object> attrReqTypeIdsList = (List<Object>) federalTaxAttrInfoDAOImpl.attributeReqTypeIDsList();
        int totalReqAttrCount = attrReqTypeIdsList.size();
        String attrReqTypeIds = attrReqTypeIdsList.toString();
        attrReqTypeIds = attrReqTypeIds.replace("[", "");
        attrReqTypeIds = attrReqTypeIds.replace("]", "");
//		Radio Button Status take from DB 			
        List<Object> rbStatus = (List<Object>) federalTaxAttrInfoDAOImpl.federalFormRadioButtonStatus();
//			Form Modification Code
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<FederalTaxIdFormsAttributesAndValuesSaving> busFedFormAttrAndValModel = federalFormsAttrAndValuesDAOImpl.findByallFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (FederalTaxIdFormsAttributesAndValuesSaving federalFormAttrAndValModel : busFedFormAttrAndValModel) {
                capturedInfoInDB = federalFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);          
            mav = federalFormsUpdateServiceImpl.federalTaxIDFormAttributesInfo(capInfoJsonObject, req);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            String federalFormPageValues = federalFormsUpdateModel.getPageVariableReference();
            mav = new ModelAndView(newFedFormsCreation);
            sn.setAttribute(userChoiceInSn, sn.getAttribute(userChoiceInSn));
            mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
            mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
            mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
            mav.addObject(radioButtList, req.getAttribute(radioButtList));
            mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));            
            mav.addObject(fedFormPageValues, federalFormPageValues);
        } else {
            mav = new ModelAndView(newFedFormsCreation);
            sn.setAttribute(userChoiceInSn, null);
        }
        mav.addObject(radioButtStatus, rbStatus);
        sn.setAttribute(radioButtStatus, rbStatus);
        sn.setAttribute(attrbReqTypeIdsInSn, attrReqTypeIds);
        sn.setAttribute(totalReqAttrbCountInSn, totalReqAttrCount);
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }

//	S Corporation Selected Form Modification Service
    @Override
    @Transactional
    public ModelAndView sCorporationSelectedFormModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("sCorporationFormUpdation...Service");
        ModelAndView mav;
//		S Corporation form: Names, Values and Required values take from DB
        List<ScorporationFormsAttributesInfo> sCorpAttrList = sCorpAttrInfoDAOImpl.sCorporationFormDynamicFormShowHideData();
        List attrNamesList = new ArrayList();
        List attrValueList = new ArrayList();
        List attrReqTypeList = new ArrayList();
        List attrStatusList = new ArrayList();
        for (ScorporationFormsAttributesInfo sCorpAttrInfo : sCorpAttrList) {
            String attrbName = String.valueOf(sCorpAttrInfo.getAttributeFieldName());
            String attrbValue = String.valueOf(sCorpAttrInfo.getAttributeValue());
            attrNamesList.add(attrbName.replace("null", ""));
            attrValueList.add(attrbValue.replace("null", ""));
            attrReqTypeList.add(sCorpAttrInfo.getRequiredType());
            attrStatusList.add(sCorpAttrInfo.getStatus());
        }
        sn.setAttribute(scAttrbNames, attrNamesList);
        sn.setAttribute(scAttrbValues, attrValueList);
        sn.setAttribute(scAttrbReqList, attrReqTypeList);
        sn.setAttribute(scAttrbStatusList, attrStatusList);
//		Federal forms Attribute Required type Ids take from DB 
        List<Object> attrReqTypeIdsList = (List<Object>) sCorpAttrInfoDAOImpl.attributeReqTypeIDsList();
        int totalReqAttrCount = attrReqTypeIdsList.size();
        String attrReqTypeIds = attrReqTypeIdsList.toString();
        attrReqTypeIds = attrReqTypeIds.replace("[", "");
        attrReqTypeIds = attrReqTypeIds.replace("]", "");
//		Radio Button Status take from DB 			
        List<Object> rbStatus = (List<Object>) sCorpAttrInfoDAOImpl.sCorporationFormRadioButtonStatus();
//		Form Modification Code
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<ScorporationFormsAttributesAndValuesSaving> busSCorpFormAttrAndValModel = scorpoFormsAttrAndValuesDAOImpl.findByallSCorpFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (ScorporationFormsAttributesAndValuesSaving sCorpFormAttrAndValModel : busSCorpFormAttrAndValModel) {
                capturedInfoInDB = sCorpFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);          
            mav = federalFormsUpdateServiceImpl.sCorporationFormAttributesInfo(capInfoJsonObject, req);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            String sCorpFormPageValues = federalFormsUpdateModel.getPageVariableReference();
            mav = new ModelAndView(newSCorpFormsCreation);
            sn.setAttribute(userChoiceInSn, (String) sn.getAttribute(userChoiceInSn));
            mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
            mav.addObject(attrbTextAreaList, req.getAttribute(attrbTextAreaList));
            mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
            mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
            mav.addObject(radioButtList, req.getAttribute(radioButtList));
            mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));
            mav.addObject(sCorpFormPageVal, sCorpFormPageValues);
        } else {
            mav = new ModelAndView(newSCorpFormsCreation);
            sn.setAttribute(userChoiceInSn, null);
        }
        mav.addObject(radioButtStatus, rbStatus);
        sn.setAttribute(radioButtStatus, rbStatus);
        sn.setAttribute(attrbReqTypeIdsInSn, attrReqTypeIds);
        sn.setAttribute(totalReqAttrbCountInSn, totalReqAttrCount);
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }

//	501 Selected Form Modification Service
    @Override
    @Transactional
    public ModelAndView fiveZeroOneFormSelectedFormModification(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("sCorporationFormUpdation...Service");
        ModelAndView mav;
//		501 form: Names, Values and Required values take from DB
        List<FivezerooneAppFormsAttributesInfo> fZOAttrList = fiveZeroOneAttrInfoDAOImpl.fiveZeroOneFormDynamicFormShowHideData();
        List attrNamesList = new ArrayList();
        List attrValueList = new ArrayList();
        List attrReqTypeList = new ArrayList();
        List attrStatusList = new ArrayList();
        for (FivezerooneAppFormsAttributesInfo fZOAttrInfo : fZOAttrList) {
            String attrbName = String.valueOf(fZOAttrInfo.getAttributeName());
            String attrbValue = String.valueOf(fZOAttrInfo.getAttributeValue());
            attrNamesList.add(attrbName.replace("null", ""));
            attrValueList.add(attrbValue.replace("null", ""));
            attrReqTypeList.add(fZOAttrInfo.getRequiredAttribute());
            attrStatusList.add(fZOAttrInfo.getStatus());
        }
        sn.setAttribute(fzoAttrbNames, attrNamesList);
        sn.setAttribute(fzoAttrbValues, attrValueList);
        sn.setAttribute(fzoAttrbReqList, attrReqTypeList);
        sn.setAttribute(fzoAttrbStatusList, attrStatusList);
//		501 forms Attribute Required type Ids take from DB 
        List<Object> attrReqTypeIdsList = (List<Object>) fiveZeroOneAttrInfoDAOImpl.attributeReqTypeIDsList();
        int totalReqAttrCount = attrReqTypeIdsList.size();
        String attrReqTypeIds = attrReqTypeIdsList.toString();
        attrReqTypeIds = attrReqTypeIds.replace("[", "");
        attrReqTypeIds = attrReqTypeIds.replace("]", "");
//		Radio Button Status take from DB 			
        List<Object> rbStatus = (List<Object>) fiveZeroOneAttrInfoDAOImpl.fiveZeroOneFormRadioButtonStatus();
//		Form Modification Code
        if (sn.getAttribute(userChoiceInSn) != null) {
            List<FivezerooneAppFormsAttributesAndValuesSaving> busFZOFormAttrAndValModel = fiveZOFormsAttrAndValuesDAOImpl.findByallFZOFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (FivezerooneAppFormsAttributesAndValuesSaving fZOFormAttrAndValModel : busFZOFormAttrAndValModel) {
                capturedInfoInDB = fZOFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);          
            mav = federalFormsUpdateServiceImpl.fiveZeroOneFormAttributesInfo(capInfoJsonObject, req);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            String fiveZeroOneFormPageValues = federalFormsUpdateModel.getPageVariableReference();
            mav = new ModelAndView(newFiveZeroOneFormsCreation);
            sn.setAttribute(userChoiceInSn, (String) sn.getAttribute(userChoiceInSn));            
            mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
            mav.addObject(attrbTextFieldZipList, req.getAttribute(attrbTextFieldZipList));
            mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
            mav.addObject(attrbTextAreaList, req.getAttribute(attrbTextAreaList));
            mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
            mav.addObject(radioButtList, req.getAttribute(radioButtList));
            mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));            
            mav.addObject(fzoFormPageVal, fiveZeroOneFormPageValues);
        } else {
            mav = new ModelAndView(newFiveZeroOneFormsCreation);
            sn.setAttribute(userChoiceInSn, null);
        }
        mav.addObject(radioButtStatus, rbStatus);
        sn.setAttribute(radioButtStatus, rbStatus);
        sn.setAttribute(attrbReqTypeIdsInSn, attrReqTypeIds);
        sn.setAttribute(totalReqAttrbCountInSn, totalReqAttrCount);
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        return mav;
    }

//	All Federal forms Checkout redirection service Federal Tax ID Checkout Redirection
    @Override
    @Transactional
    public ModelAndView federalTaxCheckoutDataRedirection(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("federalTaxCheckoutDataRedirection...Service");        
        ModelAndView mav = new ModelAndView();
        if (("CheckoutModification").equals(req.getParameter("federalFormsCheckOutRef"))) {
            mav = federalTaxIDSelectedFormModification(req, sn);
        } else if (("CheckoutPayment").equals(req.getParameter("federalFormsCheckOutRef"))) {
            mav = federalFormsCheckoutPaymentDataSaving(req, sn);
        }
        return mav;
    }

    //S Corporation Checkout Redirection
    @Override
    @Transactional
    public ModelAndView sCorporationCheckoutDataRedirection(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("federalTaxCheckoutDataRedirection...Service");        
        ModelAndView mav = new ModelAndView();
        if (("CheckoutModification").equals(req.getParameter("federalFormsCheckOutRef"))) {
            mav = sCorporationSelectedFormModification(req, sn);
        } else if (("CheckoutPayment").equals(req.getParameter("federalFormsCheckOutRef"))) {
            mav = federalFormsCheckoutPaymentDataSaving(req, sn);
        }
        return mav;
    }

//	501 Application Checkout Redirection
    @Override
    @Transactional
    public ModelAndView fiveZeroOneCheckoutDataRedirection(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("fiveZeroOneCheckoutDataRedirection...Service");       
        ModelAndView mav = new ModelAndView();
        if (("CheckoutModification").equals(req.getParameter("federalFormsCheckOutRef"))) {
            mav = fiveZeroOneFormSelectedFormModification(req, sn);
        } else if (("CheckoutPayment").equals(req.getParameter("federalFormsCheckOutRef"))) {
            mav = federalFormsCheckoutPaymentDataSaving(req, sn);
        }
        return mav;
    }

//  Check out Payment data saving
    @Override
    @Transactional
    public ModelAndView federalFormsCheckoutPaymentDataSaving(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("federalFormsCheckoutPaymentDataSaving...Service");
        ModelAndView mav;
//	  	Processing Price getting from DB 
        String processingFee = null;
        List<Object> processingPrice = (List<Object>) federalFormsPriceInfoDAOImpl.federalFormPriceProperty((String) sn.getAttribute(typeOfDocumentInSn));
        if (!processingPrice.isEmpty()) {
            processingFee = processingPrice.get(0).toString();
        }
        List allFederaslFormsPaymentList = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        Timestamp currentDate = currentDate();
//    	Invoice number generation
        String alphaNumerics = "1234567890";
        String t = "";
        for (int i = 0; i < 8; i++) {
            t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
        }
        String orderNumber = t;
        int invoiceNumber = Integer.parseInt(orderNumber);
        if (allFederaslFormsPaymentList.isEmpty()) {
//  	All Federal Forms Payment Info Saving    	 
            AllFederalFormsPaymentInfoSaving allFedFormsPaymentInfoSaving = new AllFederalFormsPaymentInfoSaving();
            int inialPrice = 0;
            allFedFormsPaymentInfoSaving.setUserName((String) sn.getAttribute(userNameInSn));
            allFedFormsPaymentInfoSaving.setLegalName((String) sn.getAttribute(userChoiceInSn));
            allFedFormsPaymentInfoSaving.setTypeOfDocument((String) sn.getAttribute(typeOfDocumentInSn));
            allFedFormsPaymentInfoSaving.setProcessingFee(processingFee);
            allFedFormsPaymentInfoSaving.setTotalFee(processingFee);
            allFedFormsPaymentInfoSaving.setCreatedDate(currentDate);
            allFedFormsPaymentInfoSaving.setBonusPrice(inialPrice);
            allFederalFormsPaymentInfoDAOImpl.save(allFedFormsPaymentInfoSaving);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            federalFormsUpdateModel.setOrderNumber(invoiceNumber);
            federalFormsUpdateModel.setOrderNumberDate(currentDate);
            allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
        }        
        int bonusPrice = 0;
        int oldBonusPrice = 0;
        if (req.getParameter(docPromoCode) != null) {
//			Bonus Price getting from DB        	
            List<Object> promoCodeBonusPrice = (List<Object>) promoCodeBonusPriceDAOImpl.promoCodeBonusPriceTakeFromDB(req.getParameter(docPromoCode));
            if (!promoCodeBonusPrice.isEmpty()) {
                String promoBonusPrice = promoCodeBonusPrice.get(0).toString();
                bonusPrice = Integer.parseInt(promoBonusPrice);
                oldBonusPrice = bonusPrice;
            }
        }
        AllFederalFormsPaymentInfoSaving allFedFormsPaymentInfoSaving = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        int dbBonusPrice = allFedFormsPaymentInfoSaving.getBonusPrice();
        bonusPrice = federalFormsBonusPriceTakeFromDB(bonusPrice, dbBonusPrice);        
        String processBonusPriceString = null;
        String promoCodeDB = null;
        String onlyBonusPriceString = null;
        if (bonusPrice != 0) {
            double onlyBonusPrice = Double.parseDouble(processingFee) * ((double) bonusPrice) * 0.01;
            double proceBonusPrice = Double.parseDouble(processingFee) - onlyBonusPrice;
            onlyBonusPriceString = String.format("%1$.2f", onlyBonusPrice);
            processBonusPriceString = String.format("%1$.2f", proceBonusPrice);
            promoCodeDB = federalFormsPromoCodeTakeFromDB(oldBonusPrice, req.getParameter(docPromoCode));
//  		All Federal Forms Payment Info updating
            AllFederalFormsPaymentInfoSaving allFedFormsPaymentModel = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allFedFormsPaymentModel.setProcessingFee(processBonusPriceString);
            allFedFormsPaymentModel.setTotalFee(processBonusPriceString);
            allFedFormsPaymentModel.setUpdatedDate(currentDate);
            allFedFormsPaymentModel.setBonusPrice(bonusPrice);
            allFederalFormsPaymentInfoDAOImpl.merge(allFedFormsPaymentModel);
            sn.setAttribute(paymentFeeTotal, processBonusPriceString);
        } else {
            sn.setAttribute(paymentFeeTotal, processingFee);
        }
        mav = new ModelAndView("federalFormCheckoutPayment");
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject("processingFee", processingFee);
        mav.addObject(docPromoCode, req.getParameter(docPromoCode));
        mav.addObject("onlyBonsPrice", onlyBonusPriceString);
        mav.addObject("totalBonusPrice", processBonusPriceString);
        mav.addObject("bonusPrice", bonusPrice);
        mav.addObject("dbBonusPrice", dbBonusPrice);
        mav.addObject("promoCodeDB", promoCodeDB);
        mav.addObject("typeOfDocument", (String) sn.getAttribute(typeOfDocumentInSn));
        sn.setAttribute(invoiceNumInSn, invoiceNumber);
        mav.addObject("paybleAmount", sn.getAttribute(paymentFeeTotal));
        return mav;
    }
    
//	Add to Cart state forms data saving    
    @Override
    @Transactional
    public Integer federalFormsBonusPriceTakeFromDB(int bonusFee, int dbBonusPrice) {
    	  LOGGER.debug("federalFormsBonusPriceTakeFromDB...Service");	  
    	  int bonusPrice = 0;
    	  if((dbBonusPrice > 0) && (bonusFee == 0 || dbBonusPrice == bonusFee)){
          	bonusPrice = dbBonusPrice;	
          } else{
          	bonusPrice = bonusFee;
          } 
        return bonusPrice;
    }
    
//  Federal Forms Promo Code Take From DB
    @Override
    @Transactional
    public String federalFormsPromoCodeTakeFromDB(int oldBonusPrice, String enteredPromocode) {
    	LOGGER.debug("federalFormsPromoCodeTakeFromDB...method");
    	String promoCodeDB = null;
    	if (oldBonusPrice > 0) {
            promoCodeDB = enteredPromocode;
        } else {
            promoCodeDB = null;
        }
    	return promoCodeDB;
    }    

//Add to Cart Federal forms data saving
    @Override
    @Transactional
    public ModelAndView addToCartAllFederalFormsData(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("addToCartAllStateFormsData...Service");        
        ModelAndView mav;
        List allFederalFormsPaymentList = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        Timestamp currentDate = currentDate();
        if (allFederalFormsPaymentList.isEmpty()) {
//  		All Federal Forms Checkout Payment Info Saving    	
            AllFederalFormsCheckoutPaymentAndUserContactSaving allFederalFormsCheckoutPaymentModel = new AllFederalFormsCheckoutPaymentAndUserContactSaving();            
            allFederalFormsCheckoutPaymentModel.setUserName((String) sn.getAttribute(userNameInSn));
            allFederalFormsCheckoutPaymentModel.setLegalName((String) sn.getAttribute(userChoiceInSn));
            allFederalFormsCheckoutPaymentModel.setFormStatus((String) sn.getAttribute(typeOfDocumentInSn));
            allFederalFormsCheckoutPaymentModel.setInvoiceNum((Integer) sn.getAttribute("invoiceNumberInSn"));
            allFederalFormsCheckoutPaymentModel.setAmount((String) sn.getAttribute("paymentTotal"));
            allFederalFormsCheckoutPaymentModel.setCreatedDate(currentDate);
            allFederalFormsCheckoutPaymentModel.setDocumentRefType("Federal Documents");
            allFederalFormsCheckoutPaymentModel.setAddToCart("Yes");
            allFedCheckoutPaymentAndContactDAOImpl.save(allFederalFormsCheckoutPaymentModel);
            int paymentId = allFederalFormsCheckoutPaymentModel.getAllFederalFormsCheckoutPaymentAndUserContactSavingId();
//        	All Federal Forms Add to Cart data saving        	
            AllStateAndFederalFormsAddCartPaymentSaving allFormsAddCartPaymentModel = new AllStateAndFederalFormsAddCartPaymentSaving();
            allFormsAddCartPaymentModel.setUserName((String) sn.getAttribute(userNameInSn));
            allFormsAddCartPaymentModel.setSelectedDocumentsName((String) sn.getAttribute(userChoiceInSn));
            allFormsAddCartPaymentModel.setTypeOfDocument((String) sn.getAttribute(typeOfDocumentInSn));
            allFormsAddCartPaymentModel.setAmount((String) sn.getAttribute("paymentTotal"));
            allFormsAddCartPaymentModel.setPaymentId(paymentId);
            allFormsAddCartPaymentModel.setDocumentRefType("Federal Documents");
            allFormsAddCartPaymentModel.setAddToCart("Yes");
            allFormsAddCartPaymentModel.setCreatedDate(currentDate);
            allFormsAddCartPaymentSavingDAOImpl.save(allFormsAddCartPaymentModel);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            federalFormsUpdateModel.setOrderNumber((Integer) sn.getAttribute("invoiceNumberInSn")); 
            federalFormsUpdateModel.setAddToCart("Yes");
            allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
        } else {
            AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allFederalFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allStateAndFedAddCartPayment.setAmount((String) sn.getAttribute("paymentTotal"));
            allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
            AllFederalFormsCheckoutPaymentAndUserContactSaving allFedCheckoutPaymentAndUserContact = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allFedCheckoutPaymentAndUserContact.setAmount((String) sn.getAttribute("paymentTotal"));
            allFedCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
            allFedCheckoutPaymentAndContactDAOImpl.merge(allFedCheckoutPaymentAndUserContact);
        }
//	  	Added Cart form info take from DB to Jsp
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
            docReferanceTypeList.add(allFormsAddCartPaymentData.getDocumentRefType() + " _ " + allFormsAddCartPaymentData.getPaymentId());
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
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, noOfDocsInCart);
        mav.addObject("totalAmount", totalPriceValue);
        sn.setAttribute("allDocTotalAmount", totalPriceValue);
        mav.addObject("userName", (String) sn.getAttribute(userNameInSn));
        sn.setAttribute(noOfDocInCartInSn, noOfDocsInCart);
        return mav;
    }

//  Federal Tax ID Checkout JSON calling updated Values in DB Service
    @Override
    @Transactional
    public JSONArray federalJSonCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("federalJSonCheckoutDataUpdationInDB...Service");       
        String[] roleName = updatedAttrVal.split(" _ ");
        String attrValue = roleName[0];
        String attrId = roleName[1];
        String attrType = roleName[2];
        attrValue = attrValue.replace("$,$", "&");
        String modValue = null;
//		userChoice checking in DB		
        int count = 0;
        if ((tf1).equals(attrType)) {
            List userChoiceInDB = allFederalFormsSavingDAOImpl.allFederalFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), attrValue);
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
//			Required values take from DB	    	
            List<FederalTaxIdFormsAttributesAndValuesSaving> busFedFormAttrAndValModel = federalFormsAttrAndValuesDAOImpl.findByallFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (FederalTaxIdFormsAttributesAndValuesSaving federalFormAttrAndValModel : busFedFormAttrAndValModel) {
                capturedInfoInDB = federalFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);          
            capInfoJsonObject.remove(attrId);
            capInfoJsonObject.put(attrId, attrValue);
            String jsonStringObj = capInfoJsonObject.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            FederalTaxIdFormsAttributesAndValuesSaving fedAttrAndValModel = federalFormsAttrAndValuesDAOImpl.findByFederalTaxFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            fedAttrAndValModel.setCapturedInformation(jsonStringObj);
            fedAttrAndValModel.setModifiedDate(currentDate);
            federalFormsAttrAndValuesDAOImpl.merge(fedAttrAndValModel);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            if ((tf1).equals(attrType)) {
                federalFormsUpdateModel.setDocumentName(attrValue);
                federalFormsUpdateModel.setModifiedDate(currentDate);
                allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
                fedAttrAndValModel.setLegalName(attrValue);
                federalFormsAttrAndValuesDAOImpl.merge(fedAttrAndValModel);
//              All related tables updating
                allFederalFormsRelatedTablesUpdationInDB(attrValue, sn);
                sn.setAttribute(userChoiceInSn, attrValue);
            } else {
                federalFormsUpdateModel.setModifiedDate(currentDate);
                allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
            }
            modValue = attrValue;
        }
        String finalObj = modValue + "&&" + attrId;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObjt, finalObj);
        forms.add(jsonObj);
        return forms;
    }
    
//  All Federal Forms Checkout Pages Related Tables Updation In DB
    @Override
    @Transactional
    public ModelAndView allFederalFormsRelatedTablesUpdationInDB(String attrValue, HttpSession sn) {
        LOGGER.debug("federalCheckoutFormsRelatedTablesUpdationInDB...Service");
        ModelAndView mav = new ModelAndView();
        Timestamp currentDate = currentDate();        
        List allFederaslFormsPaymentList = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentRowVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        if (!allFederaslFormsPaymentList.isEmpty()) {
            AllFederalFormsPaymentInfoSaving allFedFormsPaymentInfoSaving = allFederalFormsPaymentInfoDAOImpl.allFederalFormsPaymentModificationVerification((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allFedFormsPaymentInfoSaving.setLegalName(attrValue);
            allFedFormsPaymentInfoSaving.setUpdatedDate(currentDate);
            allFederalFormsPaymentInfoDAOImpl.merge(allFedFormsPaymentInfoSaving);
        }
        List allFormsAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allOnlyFederalFormsAddCartPaymentDataUpdateInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
        if (!allFormsAddCartPaymentList.isEmpty()) {
            AllStateAndFederalFormsAddCartPaymentSaving allStateAndFedAddCartPayment = allFormsAddCartPaymentSavingDAOImpl.allFederalFormsDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allStateAndFedAddCartPayment.setSelectedDocumentsName(attrValue);
            allFormsAddCartPaymentSavingDAOImpl.merge(allStateAndFedAddCartPayment);
            AllFederalFormsCheckoutPaymentAndUserContactSaving allFedCheckoutPaymentAndUserContact = allFedCheckoutPaymentAndContactDAOImpl.allFederalFormsCheckoutPaymentDataDeleteFromCart((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            allFedCheckoutPaymentAndUserContact.setLegalName(attrValue);
            allFedCheckoutPaymentAndUserContact.setModifiedDate(currentDate);
            allFedCheckoutPaymentAndContactDAOImpl.merge(allFedCheckoutPaymentAndUserContact);
        }
        return mav;
    }   

//  S Corporation Checkout JSON calling updated Values in DB Service
    @Override
    @Transactional
    public JSONArray sCorpJSonCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("federalJSonCheckoutDataUpdationInDB...Service");        
        String[] roleName = updatedAttrVal.split(" _ ");
        String attrValue = roleName[0];
        String attrId = roleName[1];
        String attrType = roleName[2];
        attrValue = attrValue.replace("$,$", "&");
        String modValue = null;
//		userChoice checking in DB		
        int count = 0;
        if ((tf1).equals(attrType)) {
            List userChoiceInDB = allFederalFormsSavingDAOImpl.allFederalFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), attrValue);
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
//			Required values take from DB	        
            List<ScorporationFormsAttributesAndValuesSaving> busSCorpFormAttrAndValModel = scorpoFormsAttrAndValuesDAOImpl.findByallSCorpFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (ScorporationFormsAttributesAndValuesSaving sCorpFormAttrAndValModel : busSCorpFormAttrAndValModel) {
                capturedInfoInDB = sCorpFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);            
            capInfoJsonObject.remove(attrId);
            capInfoJsonObject.put(attrId, attrValue);
            String jsonStringObj = capInfoJsonObject.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            ScorporationFormsAttributesAndValuesSaving sCorpAttrAndValModel = scorpoFormsAttrAndValuesDAOImpl.findBySCorpFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            sCorpAttrAndValModel.setCapturedInformation(jsonStringObj);
            sCorpAttrAndValModel.setModifiedDate(currentDate);
            scorpoFormsAttrAndValuesDAOImpl.merge(sCorpAttrAndValModel);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            if ((tf1).equals(attrType)) {
                federalFormsUpdateModel.setDocumentName(attrValue);
                federalFormsUpdateModel.setModifiedDate(currentDate);
                allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
                sCorpAttrAndValModel.setCorpName(attrValue);
                scorpoFormsAttrAndValuesDAOImpl.merge(sCorpAttrAndValModel);                
//              All related tables updating
                allFederalFormsRelatedTablesUpdationInDB(attrValue, sn);
                sn.setAttribute(userChoiceInSn, attrValue);
            } else {
                federalFormsUpdateModel.setModifiedDate(currentDate);
                allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
            }
            modValue = attrValue;
        }
        String finalObj = modValue + "&&" + attrId;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObjt, finalObj);
        forms.add(jsonObj);
        return forms;
    }

//  501 Application Checkout JSON calling updated Values in DB Service
    @Override
    @Transactional
    public JSONArray fzoJSonCheckoutDataUpdationInDB(String updatedAttrVal, HttpSession sn) {
        LOGGER.debug("federalJSonCheckoutDataUpdationInDB...Service");
        String[] roleName = updatedAttrVal.split(" _ ");
        String attrValue = roleName[0];
        String attrId = roleName[1];
        String attrType = roleName[2];
        attrValue = attrValue.replace("$,$", "&");
        String modValue = null;
//		userChoice checking in DB		
        int count = 0;
        if ((tf1).equals(attrType)) {
            List userChoiceInDB = allFederalFormsSavingDAOImpl.allFederalFormsCheckoutUserChoiceInDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), attrValue);
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
//			Required values take from DB
            List<FivezerooneAppFormsAttributesAndValuesSaving> busFZOFormAttrAndValModel = fiveZOFormsAttrAndValuesDAOImpl.findByallFZOFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            String capturedInfoInDB = null;
            for (FivezerooneAppFormsAttributesAndValuesSaving fZOFormAttrAndValModel : busFZOFormAttrAndValModel) {
                capturedInfoInDB = fZOFormAttrAndValModel.getCapturedInformation();
            }
//          Formation From String to JSON
            JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);            
            capInfoJsonObject.remove(attrId);
            capInfoJsonObject.put(attrId, attrValue);
            String jsonStringObj = capInfoJsonObject.toString();
            jsonStringObj = jsonStringObj.replace("null", "\"\"");
            Timestamp currentDate = currentDate();
            FivezerooneAppFormsAttributesAndValuesSaving fzoAttrAndValModel = fiveZOFormsAttrAndValuesDAOImpl.findByFZOFormsAttributesAndValuesFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(userChoiceInSn));
            fzoAttrAndValModel.setCapturedInformation(jsonStringObj);
            fzoAttrAndValModel.setModifiedDate(currentDate);
            fiveZOFormsAttrAndValuesDAOImpl.merge(fzoAttrAndValModel);
            AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), (String) sn.getAttribute(typeOfDocumentInSn), (String) sn.getAttribute(userChoiceInSn));
            if ((tf1).equals(attrType)) {
                federalFormsUpdateModel.setDocumentName(attrValue);
                federalFormsUpdateModel.setModifiedDate(currentDate);
                allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
                fzoAttrAndValModel.setAppName(attrValue);
                fiveZOFormsAttrAndValuesDAOImpl.merge(fzoAttrAndValModel);                
//              All related tables updating
                allFederalFormsRelatedTablesUpdationInDB(attrValue, sn);
                sn.setAttribute(userChoiceInSn, attrValue);
            } else {
                federalFormsUpdateModel.setModifiedDate(currentDate);
                allFederalFormsSavingDAOImpl.merge(federalFormsUpdateModel);
            }
            modValue = attrValue;
        }
        String finalObj = modValue + "&&" + attrId;
        JSONArray forms = new JSONArray();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put(jSonObjt, finalObj);
        forms.add(jsonObj);
        return forms;
    }

// 	Completed State Forms For User Data Display Service
    @Override
    @Transactional
    public ModelAndView completedFederalFormsForUserDataDisplay(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("completedFederalFormsForUserDataDisplay...Service");        
        ModelAndView mav = new ModelAndView();        
        if(sn.getAttribute(userNameInSn) != null) {
        List<AllFederalFormsDataSaving> comFederalFormsSavingInfiList = allFederalFormsSavingDAOImpl.completedFederalFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));        
        if (!comFederalFormsSavingInfiList.isEmpty()) {
            List<AllFederalFormsDataSaving> comFedFormSavingList = new ArrayList<AllFederalFormsDataSaving>();
            for (AllFederalFormsDataSaving comFederalFormsInfo : comFederalFormsSavingInfiList) {
                AllFederalFormsDataSaving comFederalFormsInfoModel = new AllFederalFormsDataSaving();
                comFederalFormsInfoModel.setTypeOfDocument(comFederalFormsInfo.getTypeOfDocument());
                comFederalFormsInfoModel.setDocumentName(comFederalFormsInfo.getDocumentName());
                comFederalFormsInfoModel.setOrderNumber(comFederalFormsInfo.getOrderNumber());
                Timestamp orderNumberDate = comFederalFormsInfo.getOrderNumberDate();
                comFederalFormsInfoModel.setOrderNumberDate(orderNumberDate);
                comFedFormSavingList.add(comFederalFormsInfoModel);
            }
            mav = new ModelAndView("completedFederalFormsForUser");
            mav.addObject("comFedFormSavingList", comFedFormSavingList);            
        }
        List<AllFederalFormsDataSaving> penFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.federalFormsSavingDataTakeFromDB((String) sn.getAttribute(userNameInSn));        
        List<AllStateFormsDataSaving> penStateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));        
        List<AllStateFormsDataSaving> comStateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.completedStateFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));        
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject(formCount, penFederalFormsSavingInfoList.size());
        mav.addObject(pendStateFormsCount, penStateFormsSavingInfiList.size());
        mav.addObject(pendFedFormsCount, penFederalFormsSavingInfoList.size());
        mav.addObject(compStateFormsCount, comStateFormsSavingInfiList.size());
        mav.addObject(compFedFormsCount, comFederalFormsSavingInfiList.size());
        } else{
    		mav = usersInformationServiceImpl.logInHome(req, sn);
    	}
        return mav;
    }

//	Completed Federal Forms For Admin Data Display Service
    @Override
    @Transactional
    public ModelAndView completedFederalFormsForAdminDataDisplay(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("completedStateFormsForAdminDataDisplay...Service");
        String asfCombValue = (String) req.getParameter(documentsCombi);
        String[] combValue = asfCombValue.split(",&, ");
        ModelAndView mav = new ModelAndView();
        List<AllFederalFormsCheckoutPaymentAndUserContactSaving> comFederalFormsSavingAdminList = allFedCheckoutPaymentAndContactDAOImpl.completedFederalFormsForAdminDataFromDB((String) sn.getAttribute(userNameInSn), combValue[0], combValue[1]);       
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
        if (!comFederalFormsSavingAdminList.isEmpty()) {
            for (AllFederalFormsCheckoutPaymentAndUserContactSaving comFederalFormsAdminInfo : comFederalFormsSavingAdminList) {
                invoiceNum = comFederalFormsAdminInfo.getInvoiceNum();
                orderReceived = comFederalFormsAdminInfo.getOrderReceived();
                orderReceivedCreatedDate = comFederalFormsAdminInfo.getOrderReceivedCreatedDate();
                orderProcessed = comFederalFormsAdminInfo.getOrderProcessed();
                orderProcessedCreatedDate = comFederalFormsAdminInfo.getOrderProcessedCreatedDate();
                eSignature = comFederalFormsAdminInfo.getSignature();
                eSignatureCreatedDate = comFederalFormsAdminInfo.getSignatureCreatedDate();
                docFiled = comFederalFormsAdminInfo.getDocFiled();
                docFiledCreatedDate = comFederalFormsAdminInfo.getDocFiledCreatedDate();
                docAccepted = comFederalFormsAdminInfo.getDocAccepted();
                docAcceptedCreatedDate = comFederalFormsAdminInfo.getDocAcceptedCreatedDate();
                docEmailed = comFederalFormsAdminInfo.getDocEmailed();
                docEmailedCreatedDate = comFederalFormsAdminInfo.getDocEmaileCreatedDate();
            }
            mav = new ModelAndView("completedFederalFormsForAdmin");
        }
        List<AllFederalFormsDataSaving> penFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.federalFormsSavingDataTakeFromDB((String) sn.getAttribute(userNameInSn));        
        List<AllStateFormsDataSaving> penStateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB((String) sn.getAttribute(userNameInSn));        
        List<AllStateFormsDataSaving> comStateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.completedStateFormsForUSerDataFromDB((String) sn.getAttribute(userNameInSn));        
        mav.addObject(firstName, sn.getAttribute(firstNameInSn));
        mav.addObject(noOfDocInCart, sn.getAttribute(noOfDocInCartInSn));
        mav.addObject(pendStateFormsCount, penStateFormsSavingInfiList.size());
        mav.addObject(pendFedFormsCount, penFederalFormsSavingInfoList.size());
        mav.addObject(compStateFormsCount, comStateFormsSavingInfiList.size());
        mav.addObject(compFedFormsCount, comFederalFormsSavingAdminList.size());
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
    
//	Convert From String Value To JSON Format
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

}
