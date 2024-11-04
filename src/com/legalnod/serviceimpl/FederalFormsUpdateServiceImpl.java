package com.legalnod.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.daoimpl.AllFederalFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.FederalTaxIdFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.FederalTaxIdFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.FivezerooneAppFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.FivezerooneAppFormsAttributesInfoDAOImpl;
import com.legalnod.daoimpl.ScorporationFormsAttributesAndValuesSavingDAOImpl;
import com.legalnod.daoimpl.ScorporationFormsAttributesInfoDAOImpl;
import com.legalnod.model.AllFederalFormsDataSaving;
import com.legalnod.model.FederalTaxIdFormsAttributesAndValuesSaving;
import com.legalnod.model.FederalTaxIdFormsAttributesInfo;
import com.legalnod.model.FivezerooneAppFormsAttributesAndValuesSaving;
import com.legalnod.model.FivezerooneAppFormsAttributesInfo;
import com.legalnod.model.ScorporationFormsAttributesAndValuesSaving;
import com.legalnod.model.ScorporationFormsAttributesInfo;
import com.legalnod.service.FederalFormsUpdateService;

public class FederalFormsUpdateServiceImpl implements FederalFormsUpdateService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FederalFormsUpdateServiceImpl.class);
	
	private String firstName = "firstName";
    private String noOfDocInCart = "noOfDocInCart";
    private String firstNameInSn = "firstNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";    
    private String userNameInSn = "userNameInSn";    
    private String userChoiceInSn = "userChoiceInSn";
    private String federalTaxId = "Federal Tax ID";
    private String inProgress = "In Progress";
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
    private String logInPages = "loginPage";
    private String typeOfFedeFormInSn = "typeOfFederalFormInSn";
    private String newFedFormsCreation = "newFederalFormCreation";
    private String newSCorpFormsCreation = "newSCorpFormCreation";
    private String newFiveZeroOneFormsCreation = "newFiveZeroOneFormCreation";
    
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

//	Single Federal Form Creation And Updating Service
    @Override
    @Transactional
    public ModelAndView federalTaxIDFormUpdation(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("federalTaxIDFormUpdation...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
//    		Federal form: Names, Values and Required values take from DB
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
            sn.setAttribute("SFed_Attr_Names", attrNamesList);
            sn.setAttribute("SFed_Attr_Values", attrValueList);
            sn.setAttribute("SFed_Attr_Req_List", attrReqTypeList);
            sn.setAttribute("SFed_Attr_Status_List", attrStatusList);
//    		Federal forms Attribute Required type Ids take from DB 
            List<Object> attrReqTypeIdsList = (List<Object>) federalTaxAttrInfoDAOImpl.attributeReqTypeIDsList();
            int totalReqAttrCount = attrReqTypeIdsList.size();
            String attrReqTypeIds = attrReqTypeIdsList.toString();
            attrReqTypeIds = attrReqTypeIds.replace("[", "");
            attrReqTypeIds = attrReqTypeIds.replace("]", "");
//    		Radio Button Status take from DB 			
            List<Object> rbStatus = (List<Object>) federalTaxAttrInfoDAOImpl.federalFormRadioButtonStatus();
//    		Form Modification Code                
            List<AllFederalFormsDataSaving> fedTaxFormsModel = allFederalFormsSavingDAOImpl.findByallFederalFormsUserChoiceFromDB((String) sn.getAttribute(userNameInSn), federalTaxId, inProgress);
            String userChoiceInDB = null;
            for (AllFederalFormsDataSaving fedFormDataModel : fedTaxFormsModel) {
                userChoiceInDB = fedFormDataModel.getDocumentName();
            }
            if (userChoiceInDB != null) {
                List<FederalTaxIdFormsAttributesAndValuesSaving> busFedFormAttrAndValModel = federalFormsAttrAndValuesDAOImpl.findByallFederalFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), userChoiceInDB);
                String capturedInfoInDB = null;
                for (FederalTaxIdFormsAttributesAndValuesSaving federalFormAttrAndValModel : busFedFormAttrAndValModel) {
                    capturedInfoInDB = federalFormAttrAndValModel.getCapturedInformation();
                }
//              Formation From String to JSON
                JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);
                mav = federalTaxIDFormAttributesInfo(capInfoJsonObject, req);
                AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), federalTaxId, userChoiceInDB);
                String federalFormPageValues = federalFormsUpdateModel.getPageVariableReference();
                mav = new ModelAndView(newFedFormsCreation);
                sn.setAttribute(userChoiceInSn, userChoiceInDB);
                mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
                mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
                mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
                mav.addObject(radioButtList, req.getAttribute(radioButtList));
                mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));                
                mav.addObject("federalFormPageValues", federalFormPageValues);
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
        } else {
            mav = new ModelAndView(logInPages);
            sn.setAttribute(typeOfFedeFormInSn, federalTaxId);
            sn.setAttribute("stateNameInSn", null);
            sn.setAttribute("formNameInSn", null);
        }
        return mav;
    }
    
//	Single Federal Form Attributes Info
    @Override
    @Transactional
    public ModelAndView federalTaxIDFormAttributesInfo(JSONObject capInfoJsonObject, HttpServletRequest req) {
        LOGGER.debug("federalTaxIDFormAttributesInfo...Service");
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
        req.setAttribute(attrbTextFieldList, attributeTextFieldList);
        req.setAttribute(attrbTextFieldDateList, attributeTextFieldDateList);
        req.setAttribute(attrbSelectBoxList, attributeSelectBoxList);
        req.setAttribute(radioButtList, radioButtonList);
        req.setAttribute(ckBoxsList, checkBoxList);        
        return mav;
    }

//	S Corporation Form Creation And Updating Service
    @Override
    @Transactional
    public ModelAndView sCorporationFormUpdation(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("sCorporationFormUpdation...Service");
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
//    		S Corporation form: Names, Values and Required values take from DB
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
            sn.setAttribute("SCorp_Attr_Names", attrNamesList);
            sn.setAttribute("SCorp_Attr_Values", attrValueList);
            sn.setAttribute("SCorp_Attr_Req_List", attrReqTypeList);
            sn.setAttribute("SCorp_Attr_Status_List", attrStatusList);
//    		Federal forms Attribute Required type Ids take from DB 
            List<Object> attrReqTypeIdsList = (List<Object>) sCorpAttrInfoDAOImpl.attributeReqTypeIDsList();
            int totalReqAttrCount = attrReqTypeIdsList.size();
            String attrReqTypeIds = attrReqTypeIdsList.toString();
            attrReqTypeIds = attrReqTypeIds.replace("[", "");
            attrReqTypeIds = attrReqTypeIds.replace("]", "");
//    		Radio Button Status take from DB 			
            List<Object> rbStatus = (List<Object>) sCorpAttrInfoDAOImpl.sCorporationFormRadioButtonStatus();
//    		Form Modification Code                
            List<AllFederalFormsDataSaving> fedFormsModel = allFederalFormsSavingDAOImpl.findByallFederalFormsUserChoiceFromDB((String) sn.getAttribute(userNameInSn), sCorporation, inProgress);
            String userChoiceInDB = null;
            for (AllFederalFormsDataSaving fedFormDataModel : fedFormsModel) {
                userChoiceInDB = fedFormDataModel.getDocumentName();
            }
            if (userChoiceInDB != null) {
                List<ScorporationFormsAttributesAndValuesSaving> busSCorpFormAttrAndValModel = scorpoFormsAttrAndValuesDAOImpl.findByallSCorpFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), userChoiceInDB);
                String capturedInfoInDB = null;
                for (ScorporationFormsAttributesAndValuesSaving sCorpFormAttrAndValModel : busSCorpFormAttrAndValModel) {
                    capturedInfoInDB = sCorpFormAttrAndValModel.getCapturedInformation();
                }
//              Formation From String to JSON
                JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);                
                mav = sCorporationFormAttributesInfo(capInfoJsonObject, req);
                AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), sCorporation, userChoiceInDB);
                String sCorpFormPageValues = federalFormsUpdateModel.getPageVariableReference();
                mav = new ModelAndView(newSCorpFormsCreation);
                sn.setAttribute(userChoiceInSn, userChoiceInDB);
                mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
                mav.addObject(attrbTextAreaList, req.getAttribute(attrbTextAreaList));
                mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
                mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
                mav.addObject(radioButtList, req.getAttribute(radioButtList));
                mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));                
                mav.addObject("sCorpFormPageValues", sCorpFormPageValues);
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
        } else {
            mav = new ModelAndView(logInPages);
            sn.setAttribute(typeOfFedeFormInSn, sCorporation);
            sn.setAttribute("stateNameInSn", null);
            sn.setAttribute("formNameInSn", null);
        }
        return mav;
    }
    
//		S Corporation Form Attributes Info
	    @Override
	    @Transactional
	    public ModelAndView sCorporationFormAttributesInfo(JSONObject capInfoJsonObject, HttpServletRequest req) {
	        LOGGER.debug("sCorporationFormAttributesInfo...Service");
	        ModelAndView mav = new ModelAndView();
	        String attributeTextFieldList = null;
            for (int i = 1; i <= 66; i++) {
                String keyVal = String.valueOf(i);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                attributeTextFieldList = attributeTextFieldList + jSonObjVal + ",$,";
            }
            attributeTextFieldList = attributeTextFieldList.replace("null", "");
            String attributeTextFieldDateList = null;
            for (int j = 67; j <= 73; j++) {
                String keyVal = String.valueOf(j);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                attributeTextFieldDateList = attributeTextFieldDateList + jSonObjVal + ",$,";
            }
            attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");
            String attributeTextAreaList = null;
            for (int k = 74; k <= 75; k++) {
                String keyVal = String.valueOf(k);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                jSonObjVal = jSonObjVal.replaceAll("[\n\r]", " ");
                attributeTextAreaList = attributeTextAreaList + jSonObjVal + ",$,";
            }
            attributeTextAreaList = attributeTextAreaList.replace("null", "");
            String attributeSelectBoxList = null;
            for (int n = 76; n <= 98; n++) {
                String keyVal = String.valueOf(n);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                attributeSelectBoxList = attributeSelectBoxList + jSonObjVal + ",$,";
            }
            attributeSelectBoxList = attributeSelectBoxList.replace("null", "");
            String radioButtonList = null;
            for (int k = 99; k <= 113; k++) {
                String keyVal = String.valueOf(k);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                radioButtonList = radioButtonList + jSonObjVal + ",$,";
            }
            radioButtonList = radioButtonList.replace("null", "");
            String checkBoxList = null;
            for (int p = 114; p <= 119; p++) {
                String keyVal = String.valueOf(p);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                checkBoxList = checkBoxList + jSonObjVal + ",$,";
            }
            checkBoxList = checkBoxList.replace("null", "");            
	        req.setAttribute(attrbTextFieldList, attributeTextFieldList);
	        req.setAttribute(attrbTextAreaList, attributeTextAreaList);
	        req.setAttribute(attrbTextFieldDateList, attributeTextFieldDateList);
	        req.setAttribute(attrbSelectBoxList, attributeSelectBoxList);
	        req.setAttribute(radioButtList, radioButtonList);
	        req.setAttribute(ckBoxsList, checkBoxList);
	        return mav;
	    }

//	501 Form Creation And Updating Service
    @Override
    @Transactional
    public ModelAndView fiveZeroOneFormUpdation(HttpServletRequest req, HttpSession sn) {
        LOGGER.debug("sCorporationFormUpdation...Service");        
        ModelAndView mav;
        if (sn.getAttribute(userNameInSn) != null) {
//    		S Corporation form: Names, Values and Required values take from DB
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
            sn.setAttribute("FZO_Attr_Names", attrNamesList);
            sn.setAttribute("FZO_Attr_Values", attrValueList);
            sn.setAttribute("FZO_Attr_Req_List", attrReqTypeList);
            sn.setAttribute("FZO_Attr_Status_List", attrStatusList);
//    		Federal forms Attribute Required type Ids take from DB 
            List<Object> attrReqTypeIdsList = (List<Object>) fiveZeroOneAttrInfoDAOImpl.attributeReqTypeIDsList();
            int totalReqAttrCount = attrReqTypeIdsList.size();
            String attrReqTypeIds = attrReqTypeIdsList.toString();
            attrReqTypeIds = attrReqTypeIds.replace("[", "");
            attrReqTypeIds = attrReqTypeIds.replace("]", "");
//    		Radio Button Status take from DB 			
            List<Object> rbStatus = (List<Object>) fiveZeroOneAttrInfoDAOImpl.fiveZeroOneFormRadioButtonStatus();
//    		Form Modification Code                
            List<AllFederalFormsDataSaving> fedFormsModel = allFederalFormsSavingDAOImpl.findByallFederalFormsUserChoiceFromDB((String) sn.getAttribute(userNameInSn), fzoApplication, inProgress);
            String userChoiceInDB = null;
            for (AllFederalFormsDataSaving fedFormDataModel : fedFormsModel) {
                userChoiceInDB = fedFormDataModel.getDocumentName();
            }
            if (userChoiceInDB != null) {
                List<FivezerooneAppFormsAttributesAndValuesSaving> busFZOFormAttrAndValModel = fiveZOFormsAttrAndValuesDAOImpl.findByallFZOFormsCapturedInfoFromDB((String) sn.getAttribute(userNameInSn), userChoiceInDB);
                String capturedInfoInDB = null;
                for (FivezerooneAppFormsAttributesAndValuesSaving fZOFormAttrAndValModel : busFZOFormAttrAndValModel) {
                    capturedInfoInDB = fZOFormAttrAndValModel.getCapturedInformation();
                }
//              Formation From String to JSON
                JSONObject capInfoJsonObject = convertFromStringToJSONFormat(capturedInfoInDB);                               
                mav = fiveZeroOneFormAttributesInfo(capInfoJsonObject, req);
                AllFederalFormsDataSaving federalFormsUpdateModel = allFederalFormsSavingDAOImpl.findByallFederalFormsDataFromDB((String) sn.getAttribute(userNameInSn), fzoApplication, userChoiceInDB);
                String fiveZeroOneFormPageValues = federalFormsUpdateModel.getPageVariableReference();
                mav = new ModelAndView(newFiveZeroOneFormsCreation);
                sn.setAttribute(userChoiceInSn, userChoiceInDB);
                mav.addObject(attrbTextFieldList, req.getAttribute(attrbTextFieldList));
                mav.addObject(attrbTextFieldZipList, req.getAttribute(attrbTextFieldZipList));
                mav.addObject(attrbTextFieldDateList, req.getAttribute(attrbTextFieldDateList));
                mav.addObject(attrbTextAreaList, req.getAttribute(attrbTextAreaList));
                mav.addObject(attrbSelectBoxList, req.getAttribute(attrbSelectBoxList));
                mav.addObject(radioButtList, req.getAttribute(radioButtList));
                mav.addObject(ckBoxsList, req.getAttribute(ckBoxsList));                
                mav.addObject("fiveZeroOneFormPageValues", fiveZeroOneFormPageValues);
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
        } else {
            mav = new ModelAndView(logInPages);
            sn.setAttribute(typeOfFedeFormInSn, fzoApplication);
            sn.setAttribute("stateNameInSn", null);
            sn.setAttribute("formNameInSn", null);
        }
        return mav;
    }
    
//		501 Form Attributes Info
	    @Override
	    @Transactional
	    public ModelAndView fiveZeroOneFormAttributesInfo(JSONObject capInfoJsonObject, HttpServletRequest req) {
	        LOGGER.debug("fiveZeroOneFormAttributesInfo...Service");
	        ModelAndView mav = new ModelAndView();
	        String attributeTextFieldList = null;
            for (int i = 1; i <= 430; i++) {
                String keyVal = String.valueOf(i);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                attributeTextFieldList = attributeTextFieldList + jSonObjVal + ",$,";
            }
            attributeTextFieldList = attributeTextFieldList.replace("null", "");
            String attributeTextFieldZipList = null;
            for (int j = 431; j <= 460; j++) {
                String keyVal = String.valueOf(j);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                attributeTextFieldZipList = attributeTextFieldZipList + jSonObjVal + ",$,";
            }
            attributeTextFieldZipList = attributeTextFieldZipList.replace("null", "");
            String attributeTextFieldDateList = null;
            for (int k = 461; k <= 474; k++) {
                String keyVal = String.valueOf(k);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                attributeTextFieldDateList = attributeTextFieldDateList + jSonObjVal + ",$,";
            }
            attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");
            String attributeTextAreaList = null;
            for (int l = 475; l <= 682; l++) {
                String keyVal = String.valueOf(l);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                jSonObjVal = jSonObjVal.replaceAll("[\n\r]", " ");
                attributeTextAreaList = attributeTextAreaList + jSonObjVal + ",$,";
            }
            attributeTextAreaList = attributeTextAreaList.replace("null", "");
            String attributeSelectBoxList = null;
            for (int m = 683; m <= 711; m++) {
                String keyVal = String.valueOf(m);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                attributeSelectBoxList = attributeSelectBoxList + jSonObjVal + ",$,";
            }
            attributeSelectBoxList = attributeSelectBoxList.replace("null", "");
            String radioButtonList = null;
            for (int n = 712; n <= 964; n++) {
                String keyVal = String.valueOf(n);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                radioButtonList = radioButtonList + jSonObjVal + ",$,";
            }
            radioButtonList = radioButtonList.replace("null", "");
            String checkBoxList = null;
            for (int o = 965; o <= 970; o++) {
                String keyVal = String.valueOf(o);
                String jSonObjVal = (String) capInfoJsonObject.get(keyVal);
                checkBoxList = checkBoxList + jSonObjVal + ",$,";
            }
            checkBoxList = checkBoxList.replace("null", "");	        
	        req.setAttribute(attrbTextFieldList, attributeTextFieldList);
	        req.setAttribute(attrbTextFieldZipList, attributeTextFieldZipList);
	        req.setAttribute(attrbTextFieldDateList, attributeTextFieldDateList);
	        req.setAttribute(attrbTextAreaList, attributeTextAreaList);
	        req.setAttribute(attrbSelectBoxList, attributeSelectBoxList);
	        req.setAttribute(radioButtList, radioButtonList);
	        req.setAttribute(ckBoxsList, checkBoxList);
	        return mav;
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
	    
//		All Federal Attributes Info Methods Single Federal Tax ID Form Attributes info from JSP
	    @Override
	    @Transactional
	    public JSONObject singleFederalFormsAttributesInfoFromJSP(HttpServletRequest req) {
	        LOGGER.debug("singleFederalFormsAttributesInfoFromJSP...Service");
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
	        req.setAttribute(attrbTextFieldList, attributeTextFieldList);
	        req.setAttribute(attrbTextFieldDateList, attributeTextFieldDateList);
	        req.setAttribute(attrbSelectBoxList, attributeSelectBoxList);
	        req.setAttribute(radioButtList, radioButtonList);
	        req.setAttribute(ckBoxsList, checkBoxList);	        
	        return stateFormInfoObj;
	    }
	    
//		S Corporation Form Attributes info from JSP
	    @Override
	    @Transactional
	    public JSONObject sCorporationFormsAttributesInfoFromJSP(HttpServletRequest req) {
	        LOGGER.debug("sCorporationFormsAttributesInfoFromJSP...Service");
	        JSONObject stateFormInfoObj = new JSONObject();
	        String attributeTextFieldList = null;
	        String[] attributeTextField = new String[67];
	        for (int i = 1; i < attributeTextField.length; i++) {
	            attributeTextField[i] = req.getParameter("attributeTextField" + i);
	            attributeTextFieldList = attributeTextFieldList + attributeTextField[i] + ",$,";
	            stateFormInfoObj.put(i, attributeTextField[i]);            
	        }
	        attributeTextFieldList = attributeTextFieldList.replace("null", "");
	        String attributeTextFieldDateList = null;
	        String[] attributeTextFieldDate = new String[8];
	        for (int j = 1; j < attributeTextFieldDate.length; j++) {
	            attributeTextFieldDate[j] = req.getParameter("attributeTextFieldDate" + j);
	            attributeTextFieldDateList = attributeTextFieldDateList + attributeTextFieldDate[j] + ",$,";
	            stateFormInfoObj.put(j + 66, attributeTextFieldDate[j]);            
	        }
	        attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");
	        String attributeTextAreaList = null;
	        String[] attributeTextArea = new String[3];
	        for (int k = 1; k < attributeTextArea.length; k++) {
	            attributeTextArea[k] = req.getParameter("attributeTextArea" + k);
	            attributeTextAreaList = attributeTextAreaList + attributeTextArea[k] + ",$,";
	            stateFormInfoObj.put(k + 73, attributeTextArea[k]);            
	        }
	        attributeTextAreaList = attributeTextAreaList.replace("null", "");
	        attributeTextAreaList = attributeTextAreaList.replaceAll("[\n\r]", " ");
	        String attributeSelectBoxList = null;
	        String[] attributeSelectBox = new String[24];
	        for (int n = 1; n < attributeSelectBox.length; n++) {
	            attributeSelectBox[n] = req.getParameter("attributeSelectBox" + n);
	            attributeSelectBoxList = attributeSelectBoxList + attributeSelectBox[n] + ",$,";
	            stateFormInfoObj.put(n + 75, attributeSelectBox[n]);            
	        }
	        attributeSelectBoxList = attributeSelectBoxList.replace("null", "");
	        String radioButtonList = null;
	        String[] radioButton = new String[16];
	        for (int m = 1; m < radioButton.length; m++) {
	            radioButton[m] = req.getParameter("radioButton" + m);
	            radioButtonList = radioButtonList + radioButton[m] + ",$,";
	            stateFormInfoObj.put(m + 98, radioButton[m]);            
	        }
	        radioButtonList = radioButtonList.replace("null", "");
	        String checkBoxList = null;
	        String[] checkBox = new String[7];
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
	                stateFormInfoObj.put(p + 113, ddynamicCheckValue);
	            } else {
	                checkBoxList = checkBoxList + checkSingele + ",$,";
	                stateFormInfoObj.put(p + 113, checkSingele);                
	            }
	        }
	        checkBoxList = checkBoxList.replace("null", "");
	        req.setAttribute(attrbTextFieldList, attributeTextFieldList);
	        req.setAttribute(attrbTextFieldDateList, attributeTextFieldDateList);
	        req.setAttribute(attrbTextAreaList, attributeTextAreaList);
	        req.setAttribute(attrbSelectBoxList, attributeSelectBoxList);
	        req.setAttribute(radioButtList, radioButtonList);
	        req.setAttribute(ckBoxsList, checkBoxList);        
	        return stateFormInfoObj;
	    }	    
	    
//		501 Form Attributes info from JSP
	    @Override
	    @Transactional
	    public JSONObject fiveZeroOneFormsAttributesInfoFromJSP(HttpServletRequest req) {
	        LOGGER.debug("fiveZeroOneFormsAttributesInfoFromJSP...Service");
	        JSONObject stateFormInfoObj = new JSONObject();
	        String attributeTextFieldList = null;
	        String[] attributeTextField = new String[431];
	        for (int i = 1; i < attributeTextField.length; i++) {
	            attributeTextField[i] = req.getParameter("attributeTextField" + i);
	            attributeTextFieldList = attributeTextFieldList + attributeTextField[i] + ",$,";
	            stateFormInfoObj.put(i, attributeTextField[i]);            
	        }
	        attributeTextFieldList = attributeTextFieldList.replace("null", "");
	        String attributeTextFieldZipList = null;
	        String[] attributeTextFieldZip = new String[31];
	        for (int j = 1; j < attributeTextFieldZip.length; j++) {
	            attributeTextFieldZip[j] = req.getParameter("attributeTextFieldZip" + j);
	            attributeTextFieldZipList = attributeTextFieldZipList + attributeTextFieldZip[j] + ",$,";
	            stateFormInfoObj.put(j + 430, attributeTextFieldZip[j]);            
	        }
	        attributeTextFieldZipList = attributeTextFieldZipList.replace("null", "");
	        String attributeTextFieldDateList = null;
	        String[] attributeTextFieldDate = new String[15];
	        for (int k = 1; k < attributeTextFieldDate.length; k++) {
	            attributeTextFieldDate[k] = req.getParameter("attributeTextFieldDate" + k);
	            attributeTextFieldDateList = attributeTextFieldDateList + attributeTextFieldDate[k] + ",$,";
	            stateFormInfoObj.put(k + 460, attributeTextFieldDate[k]);            
	        }
	        attributeTextFieldDateList = attributeTextFieldDateList.replace("null", "");
	        String attributeTextAreaList = null;
	        String[] attributeTextArea = new String[209];
	        for (int l = 1; l < attributeTextArea.length; l++) {
	            attributeTextArea[l] = req.getParameter("attributeTextArea" + l);
	            attributeTextAreaList = attributeTextAreaList + attributeTextArea[l] + ",$,";
	            stateFormInfoObj.put(l + 474, attributeTextArea[l]);            
	        }
	        attributeTextAreaList = attributeTextAreaList.replace("null", "");
	        attributeTextAreaList = attributeTextAreaList.replaceAll("[\n\r]", " ");
	        String attributeSelectBoxList = null;
	        String[] attributeSelectBox = new String[30];
	        for (int m = 1; m < attributeSelectBox.length; m++) {
	            attributeSelectBox[m] = req.getParameter("attributeSelectBox" + m);
	            attributeSelectBoxList = attributeSelectBoxList + attributeSelectBox[m] + ",$,";
	            stateFormInfoObj.put(m + 682, attributeSelectBox[m]);            
	        }
	        attributeSelectBoxList = attributeSelectBoxList.replace("null", "");
	        String radioButtonList = null;
	        String[] radioButton = new String[254];
	        for (int n = 1; n < radioButton.length; n++) {
	            radioButton[n] = req.getParameter("radioButton" + n);
	            radioButtonList = radioButtonList + radioButton[n] + ",$,";
	            stateFormInfoObj.put(n + 711, radioButton[n]);            
	        }
	        radioButtonList = radioButtonList.replace("null", "");
	        String checkBoxList = null;
	        String[] checkBox = new String[7];
	        for (int o = 1; o < checkBox.length; o++) {
	            String checkSingele = req.getParameter("checkBox" + o);
	            if (checkSingele != null) {
	                String[] checkBoxVal = req.getParameterValues("checkBox" + o);
	                String ddynamicCheckValue = "";
	                for (int p = 0; p < checkBoxVal.length; p++) {
	                    ddynamicCheckValue = ddynamicCheckValue + ", " + checkBoxVal[p];
	                }
	                ddynamicCheckValue = ddynamicCheckValue.replaceFirst(", ", "");
	                checkBoxList = checkBoxList + ddynamicCheckValue + ",$,";
	                stateFormInfoObj.put(o + 964, ddynamicCheckValue);
	            } else {
	                checkBoxList = checkBoxList + checkSingele + ",$,";
	                stateFormInfoObj.put(o + 964, checkSingele);                
	            }
	        }
	        checkBoxList = checkBoxList.replace("null", "");	        
	        req.setAttribute(attrbTextFieldList, attributeTextFieldList);
	        req.setAttribute(attrbTextFieldZipList, attributeTextFieldZipList);
	        req.setAttribute(attrbTextFieldDateList, attributeTextFieldDateList);
	        req.setAttribute(attrbTextAreaList, attributeTextAreaList);
	        req.setAttribute(attrbSelectBoxList, attributeSelectBoxList);
	        req.setAttribute(radioButtList, radioButtonList);
	        req.setAttribute(ckBoxsList, checkBoxList);
	        return stateFormInfoObj;
	    }
}