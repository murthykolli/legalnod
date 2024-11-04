package com.legalnod.serviceimpl;

import java.sql.Timestamp;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;


import com.legalnod.daoimpl.AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllFederalFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllStateAndFederalFormsAddCartPaymentSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.FormFederalDocumentsDataSavingDAOImpl;
import com.legalnod.daoimpl.StatesDAOImpl;
import com.legalnod.daoimpl.UserPaymentTransactionInfoSavingDAOImpl;
import com.legalnod.model.UserPaymentTransactionInfoSaving;
import com.legalnod.service.PaymentGatewayService;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


/**
 * @author MurthyK
 *
 */

public class PaymentGatewayServiceImpl implements PaymentGatewayService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentGatewayServiceImpl.class);
	
	@Autowired
    private AllStateFormsCheckoutPaymentAndUserContactSavingDAOImpl allStateFormsCheckoutPaymentDAOImpl;
	
	@Autowired
    private AllFederalFormsCheckoutPaymentAndUserContactSavingDAOImpl allFedCheckoutPaymentAndContactDAOImpl;
	
	@Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;
	
	@Autowired
    private AllFederalFormsDataSavingDAOImpl allFederalFormsSavingDAOImpl;
	
	@Autowired
    private FormFederalDocumentsDataSavingDAOImpl formFederalDataSavingDAOImpl;
	
	@Autowired
    private AllStateAndFederalFormsAddCartPaymentSavingDAOImpl allFormsAddCartPaymentSavingDAOImpl;
	
    @Autowired
    private UserPaymentTransactionInfoSavingDAOImpl userPaymentTransactionDAOImpl;
    
    @Autowired
    private StatesDAOImpl statesDAOImpl;
	
	@Override
    @Transactional
    public ModelAndView paymentResponseRevertBackFromBank(HttpServletRequest req, HttpSession sn) {
    	LOGGER.debug("paymentResponseRevertBackFromBank...Service");        
        String userName = (String) sn.getAttribute("userNameInSn");
        String firstName = (String) sn.getAttribute("firstNameInSn");
        ModelAndView mav;        
        	long cardNumber = Long.parseLong(req.getParameter("cardNumber"));        	
        	String expirationDate = req.getParameter("expirationDate");
        	Integer cardCode = Integer.parseInt(req.getParameter("cardCode"));
        	String apiLoginId = req.getParameter("apiLoginId");
        	String transactionKey = req.getParameter("transactionKey");        	
        	String  jSONObject = "{\"createTransactionRequest\": { \"merchantAuthentication\": { \"name\": "+"\""+apiLoginId+"\""+", \"transactionKey\": "+"\""+transactionKey+"\""+" }, " +
        			"\"refId\": \"\", \"transactionRequest\": { \"transactionType\": \"authCaptureTransaction\", \"amount\": "+"\""+req.getParameter("amount")+"\""+", \"payment\": { \"creditCard\": { \"cardNumber\": "+"\""+cardNumber+"\""+", \"expirationDate\": "+"\""+expirationDate+"\""+", \"cardCode\": "+"\""+cardCode+"\""+" } }, " +
        			"\"customer\": { \"email\": "+"\""+userName+"\""+" },"+
        			"\"billTo\": { \"firstName\": "+"\""+req.getParameter("billFirstName")+"\""+", \"lastName\": "+"\""+req.getParameter("billLastName")+"\""+", \"address\": "+"\""+req.getParameter("billAddress")+"\""+", \"city\": "+"\""+req.getParameter("billCity")+"\""+", \"state\": "+"\""+req.getParameter("billState")+"\""+", \"zip\": "+"\""+req.getParameter("billZip")+"\""+", \"country\": \"USA\" }, " +
        			"\"shipTo\": { \"firstName\": "+"\""+req.getParameter("shipFirstName")+"\""+",  \"lastName\": "+"\""+req.getParameter("shipLastName")+"\""+", \"address\": "+"\""+req.getParameter("shipAddress")+"\""+", \"city\": "+"\""+req.getParameter("shipCity")+"\""+", \"state\": "+"\""+req.getParameter("shipState")+"\""+", \"zip\": "+"\""+req.getParameter("shipZip")+"\""+", \"country\": \"USA\" } } } }";        	
//        	Payment GateWay Code
        	JSONObject jSonResObject1 = new JSONObject();
        	JSONObject jSonResObject2 = new JSONObject();                      
            String accountNoWithType = null;
            String authCode = null;
            String description = null;           
            long transactionNumber = 0;
//       API Rest Service Redirection   
         String responseBody = resBodyFromAPIToApplication(jSONObject);         
         responseBody = responseBody.replace("[", "");
         String responseBody1 = responseBody.replace("]", "");         
         String[] jSonStrObj = responseBody1.split(",\"messages\":");       
         if(jSonStrObj.length > 2) {
           String jSonRes1 = jSonStrObj[0].replace(":{", ":\"\",");
           jSonRes1 = jSonRes1+"}";
           jSonRes1 = jSonRes1.replace("﻿", "");           
           String jSonRes2 = jSonStrObj[1].replace("}", "");
           jSonRes2 = jSonRes2+"}";
           jSonRes2 = jSonRes2.replace("﻿", "");           
//         Formation From String to JSON           
           jSonResObject1 = convertFromStringToJSONFormat(jSonRes1);
           jSonResObject2 = convertFromStringToJSONFormat(jSonRes2);       
           String accountNumber = (String) jSonResObject1.get("accountNumber");
           String accountType = (String) jSonResObject1.get("accountType");
           authCode = (String) jSonResObject1.get("authCode");
           String transId = (String) jSonResObject1.get("transId");           
           transactionNumber = Long.parseLong(transId);           
           description = (String) jSonResObject2.get("description");
           accountNoWithType = accountType+" "+accountNumber;
           Timestamp currentDate = currentDate();           
           UserPaymentTransactionInfoSaving userPaymentTranModel = new UserPaymentTransactionInfoSaving();
           userPaymentTranModel.setUserName(userName);
           userPaymentTranModel.setCardNumber(accountNoWithType);
           userPaymentTranModel.setTransactionNumber(transactionNumber);
           userPaymentTranModel.setAuthorizationCode(authCode);
           userPaymentTranModel.setCardExpiryDate(expirationDate);
           userPaymentTranModel.setOrderStatus(description);
           userPaymentTranModel.setAmount(req.getParameter("amount"));
           userPaymentTranModel.setBillingFirstName(req.getParameter("billFirstName"));
           userPaymentTranModel.setBillingLastName(req.getParameter("billLastName"));
           userPaymentTranModel.setBillingAddress(req.getParameter("billAddress"));
           userPaymentTranModel.setBillingCity(req.getParameter("billCity"));
           userPaymentTranModel.setBillingStateName(req.getParameter("billState"));
           userPaymentTranModel.setBillingZip(req.getParameter("billZip"));
           userPaymentTranModel.setShipingFirstName(req.getParameter("shipFirstName"));
           userPaymentTranModel.setShipingLastName(req.getParameter("shipLastName"));
           userPaymentTranModel.setShipingAddress(req.getParameter("shipAddress"));
           userPaymentTranModel.setShipingCity(req.getParameter("shipCity"));            
           userPaymentTranModel.setShipingStateName(req.getParameter("shipState"));
           userPaymentTranModel.setShipingZip(req.getParameter("shipZip"));
           userPaymentTranModel.setCreatedDate(currentDate);           
           userPaymentTransactionDAOImpl.save(userPaymentTranModel);           
           UserPaymentTransactionInfoSaving userPaymentTransactionModel = userPaymentTransactionDAOImpl.paymentTransactionIdTakeFromDB(userName, transactionNumber);
   		   int userPaymentTranId = userPaymentTransactionModel.getUserPaymentTransactionInfoSavingId();    		
   		   allStateFormsCheckoutPaymentDAOImpl.transactionStatusUpdateInStateFormsPaymentContTable(userName,description,userPaymentTranId);
   		   allStateFormsDataSavingDAOImpl.transactionStatusUpdateInStateFormsSavingTable(userName,description);
   		   formFederalDataSavingDAOImpl.transactionStatusUpdateInFormFederalTable(userName,description);   		
   		   allFedCheckoutPaymentAndContactDAOImpl.transactionStatusUpdateInFederalFormsPaymentContTable(userName,description,userPaymentTranId);
   		   allFederalFormsSavingDAOImpl.transactionStatusUpdateInFederalFormsSavingTable(userName,description);   		
   		   allFormsAddCartPaymentSavingDAOImpl.stateAndFederalFormsAddCartPaymentDeletion(userName);   		
   		   List allStAndFedAddCartPaymentList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataTakeFromDB(userName);
   		   sn.setAttribute("noOfDocInCartInSn", allStAndFedAddCartPaymentList.size());
           mav = new ModelAndView("PaymentTransactionSuccess");
           mav.addObject("userName", userName);
	   	   mav.addObject("accountNoWithType", accountNoWithType);
	   	   mav.addObject("transactionNumber", transactionNumber);    		
	   	   mav.addObject("authCode", authCode);
	   	   mav.addObject("expirationDate", expirationDate);
	   	   mav.addObject("orderStatus", description);	   	              
         } else{
        	 String jSonRes1 = jSonStrObj[0].replace(":{", ":\"\",");
        	 if(jSonRes1.length() > 300 && jSonRes1.length() < 315){        		 
        		 mav = new ModelAndView("authorizeCreditCardRedirection");
                 mav.addObject("cardMessageErrorText", "Card Code is invalid.");
        	 } else{
        		 jSonRes1 = jSonRes1.replace("}", "");
            	 jSonRes1 = jSonRes1.replace(",{", ",");
            	 jSonRes1 = jSonRes1+"}";
            	 jSonRes1 = jSonRes1.replace("﻿", "");	 
             String jSonRes2 = jSonStrObj[1].replace(":{", ":\"\",");
             jSonRes2 = jSonRes2.replace("}}", "");
             jSonRes2 = jSonRes2.replace("﻿", "");             
//           Formation From String to JSON
             jSonResObject1 = convertFromStringToJSONFormat(jSonRes1);             
             jSonResObject2 = convertFromStringToJSONFormat(jSonRes2);             
             String errorText = (String) jSonResObject1.get("errorText");             
             mav = new ModelAndView("authorizeCreditCardRedirection");
             mav.addObject("cardMessageErrorText", errorText);
        	 }
        	 List statesList = statesDAOImpl.findByStateList();
             mav.addObject("stateList", statesList);
         }  
         	mav.addObject("amount", req.getParameter("amount"));
    		mav.addObject("billFirstName", req.getParameter("billFirstName"));
    		mav.addObject("billLastName", req.getParameter("billLastName"));
    		mav.addObject("billAddress", req.getParameter("billAddress"));
    		mav.addObject("billCity", req.getParameter("billCity"));
    		mav.addObject("billState", req.getParameter("billState"));
    		mav.addObject("billZip", req.getParameter("billZip"));
    		mav.addObject("shipFirstName", req.getParameter("shipFirstName"));
    		mav.addObject("shipLastName", req.getParameter("shipLastName"));
    		mav.addObject("shipAddress", req.getParameter("shipAddress"));
    		mav.addObject("shipCity", req.getParameter("shipCity"));
    		mav.addObject("shipState", req.getParameter("shipState"));
    		mav.addObject("shipZip", req.getParameter("shipZip"));
    		mav.addObject("firstName", firstName);
    		mav.addObject("checkBoxStatus", req.getParameter("checkbox"));
    		mav.addObject("noOfDocInCart", sn.getAttribute("noOfDocInCartInSn"));    		     
        return mav;
    }
	
//	Convert From String Value To JSON Format
	@Override
	@Transactional
	public String resBodyFromAPIToApplication(String jSONObject) {
	    LOGGER.debug("resBodyFromAPIToApplication...Service");
	    String responseBody = null;
	    try {
    	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity(jSONObject, headers);
        RestTemplate template = new RestTemplate();        
// 		Calling KohlsRestAPI updateItemsInArrangement service
        ResponseEntity<String> result = template.exchange("https://api.authorize.net/xml/v1/request.api", HttpMethod.POST, entity, String.class);        
        responseBody = result.getBody();
        } catch (Exception exception) {
            LOGGER.error("SaveArrangements" + exception);
       }
	   return responseBody;
	} 
	
//		Convert From String Value To JSON Format
		@Override
		@Transactional
		public JSONObject convertFromStringToJSONFormat(String jSonResponse) {
		    LOGGER.debug("convertFromStringToJsonFormat...Service");
		JSONParser parser = new JSONParser();
		JSONObject jSONResObject = new JSONObject();
		try {		
		    jSONResObject = (JSONObject) parser.parse(jSonResponse);
		} catch (ParseException e) {
		    LOGGER.error("Convert String To Json Format is Fail " + e);
		}
		return jSONResObject;
		}
		
//		current date
		@Override
		@Transactional
		public Timestamp currentDate() {
			LOGGER.debug("currentDate...method");
			java.util.Date date = new java.util.Date();
			Timestamp currentDate = new Timestamp(date.getTime());    
			return currentDate;
		}
}
