package com.legalnod.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.legalnod.daoimpl.AllFederalFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.AllStateAndFederalFormsAddCartPaymentSavingDAOImpl;
import com.legalnod.daoimpl.AllStateFormsDataSavingDAOImpl;
import com.legalnod.daoimpl.UsersInformationDAOImpl;
import com.legalnod.model.AllFederalFormsDataSaving;
import com.legalnod.model.AllStateAndFederalFormsAddCartPaymentSaving;
import com.legalnod.model.AllStateFormsDataSaving;
import com.legalnod.model.UsersInformation;
import com.legalnod.service.UsersInformationService;

/**
 * @author MurthyK
 *
 */
public class UsersInformationServiceImpl implements UsersInformationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersInformationServiceImpl.class);
    
    private String stateNameInSn = "stateNameInSn";
    private String typeOfRefDocumentInSn = "typeOfRefDocumentInSn";
    private String typeOfFederalFormInSn = "typeOfFederalFormInSn";
    private String formNameInSn = "formNameInSn";
    private String userChoiceInSn = "userChoiceInSn";
    private String userNameInSn = "userNameInSn";
    private String noOfDocInCartInSn = "noOfDocInCartInSn";    
    private String userIdsInSn = "userIdInSn";
    private String firstNamesInSn = "firstNameInSn";       
    private String statesName = "stateName";
    private String formsName = "formName";    
    private String usrFirstName = "firstName";    
    private String userUserName = "userName";
    private String loginPageRe = "loginPage";
    private String passwordHeading = "Password";
    private String usrPassword = "password";
    private String emailHeading = "Email";
    private String noOfDocumentsInCart = "noOfDocInCart";
    
    private String ipAddress = "https://www.legalnod.com/lnadmin/";
    
    
    @Autowired
    private UsersInformationDAOImpl userInfoDAOImpl;

    @Autowired
    private BusinessServicesServiceImpl busServiceDAOImpl;

    @Autowired
    private AllStateFormsDataSavingDAOImpl allStateFormsDataSavingDAOImpl;
    
    @Autowired
    private AllStateAndFederalFormsAddCartPaymentSavingDAOImpl allFormsAddCartPaymentSavingDAOImpl;
    
    @Autowired
    private AllFederalFormsDataSavingDAOImpl allFederalFormsSavingDAOImpl;    
    
    @Autowired
    private FederalFormsUpdateServiceImpl federalFormsUpdateServiceImpl;
    
    @Autowired
    private StateFormsServiceImpl stateFormsServiceImpl;
    

//	Registration Service Implementation methods
    
    @Override
    @Transactional
    public ModelAndView registrationHome() {
    	LOGGER.debug("registrationHome...Service"); 
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    public String mD5Encrypt(String password) {
    	LOGGER.debug("mD5Encrypt...Service");
    	String forPassword = password;
        try {        	
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());

            byte byteData[] = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            forPassword = sb.toString();
        } catch (NoSuchAlgorithmException exception) {
        	LOGGER.error("mD5Encrypt " + exception);
        }
        return forPassword;
    }

    @Override
    @Transactional
    public ModelAndView userDataSavingInDB(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("userDataSavingInDB...Service");
        String userName = request.getParameter(userUserName);
        String password = request.getParameter(usrPassword);        
        List regDataVal = userInfoDAOImpl.findByUserName(userName);
        ModelAndView mav = new ModelAndView();
        if (!regDataVal.isEmpty()) {
            mav = new ModelAndView("registrationPage");
            mav.addObject("regErrorPage", " E-mail already exists!");
        } else {
            String encrypPassword = mD5Encrypt(password);
            String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
            String passwordSalt = mD5Encrypt(encrypPassword + salt);
            java.util.Date date = new java.util.Date();
            Timestamp currentDate = new Timestamp(date.getTime());
            UsersInformation rgModel = new UsersInformation();
            rgModel.setUserName(userName);
            rgModel.setPassword(encrypPassword);
            rgModel.setPasswordSalt(passwordSalt);            
            rgModel.setTypeOfUser("U");
            rgModel.setCreatedDate(currentDate);
            userInfoDAOImpl.save(rgModel);
            UsersInformation userData = userInfoDAOImpl.findByUserInfoFromDB(userName);
            int userID = userData.getUserId();            
            int userNameIndex = (userName).indexOf("@");
            String firstName = (userName).substring(0, userNameIndex);
            
            mav = registredEmainlSendingToUser(request, session, userName, firstName);
            
            session.setAttribute(userIdsInSn, userID);
            session.setAttribute(userNameInSn, userName);
            session.setAttribute(firstNamesInSn, firstName);            
            if (session.getAttribute(stateNameInSn) != null && (String) session.getAttribute(formNameInSn) != null) {                
                if (("Business Services").equals(session.getAttribute(typeOfRefDocumentInSn))) {
                    mav = busServiceDAOImpl.newStateFormSelectionFromDB(request, session);
                } else if (("Additional Services").equals(session.getAttribute(typeOfRefDocumentInSn))) {
                    mav = busServiceDAOImpl.newAdditionalServiceFormSelectionFromDB(request, session);
                } else if (("State Tax ID").equals(session.getAttribute(typeOfRefDocumentInSn))) {
                    mav = busServiceDAOImpl.newStateTaxIdFormSelectionFromDB(request, session);
                }                                
                mav.addObject(statesName, session.getAttribute(stateNameInSn));
                mav.addObject(formsName, session.getAttribute(formNameInSn));                
            } else if (session.getAttribute("typeOfFederalFormInSn") != null) {
            	if (("Federal Tax ID").equals(session.getAttribute(typeOfFederalFormInSn))) {
                    mav = federalFormsUpdateServiceImpl.federalTaxIDFormUpdation(request, session);
                } else if (("S Corporation").equals(session.getAttribute(typeOfFederalFormInSn))) {
                    mav = federalFormsUpdateServiceImpl.sCorporationFormUpdation(request, session);
                } else if (("501 Application").equals(session.getAttribute(typeOfFederalFormInSn))) {
                    mav = federalFormsUpdateServiceImpl.fiveZeroOneFormUpdation(request, session);
                }            	
            } else {
                mav = new ModelAndView("editUserProfile");
            }
            mav.addObject(usrFirstName, firstName);
            mav.addObject(userUserName, userName);           
        }
        return mav;
    }
    
    public ModelAndView registredEmainlSendingToUser(HttpServletRequest request, HttpSession session, String userName, String firstName) {
    	LOGGER.debug("registredEmainlSendingToUser...Service");
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@legalnod.com";        
        ModelAndView mav;        
            String aTo = userName;
            String aSubject = "Legal Nod Info.";            
            String type = "text/html";            
            String body = "<body> <div style='margin-left: 10px;margin-top:10px;background: #f1f1f1;width: 850px;box-shadow: 3px 3px 0px #7e7e7e;height: 250px;color: black;'> "
                    + "<div style='background: #666666;height: 35px;width:851px;'>"
                    + "<font style='color: white;font-size:20px;font-family:Georgia; vertical-align: middle;'><b>&nbsp;&nbsp; <span style='vertical-align: middle; margin-top: 15px; position: absolute;'>LegalNod <font color='yellow'>-</font> Email</span></b></font> "
                    + "</div> "
                    + "<div style='margin-top: 5px; width: 850px; height: 220px;font: 1.1em/1.26em sans-serif;text-align: justify;'> <br/><br/>"
                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>Hello &nbsp;<font style=' color: #00a9f1;'>" + firstName + ",</font></b> <br/><br/><br/> "
                    + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; User ID &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + userName + " <br/><br/>"
                    + " <br/><br/><br/> "                    
                    + "</div><br/><br/></div>"
                    + "</body> ";            
            try {
                userEmail.sendEmail(aTo, aSubject, body, type, fromAdd);
            } catch (Exception ex) {
            	LOGGER.error("Sending Email Checking " + ex);
            }
            mav = new ModelAndView();            
        return mav;
    }

//	LogIn Service Implementation methods    
    @Override
    @Transactional
    public ModelAndView logInHome(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("logInHome...Service");
        ModelAndView mav = new ModelAndView("loginPage");
        session.setAttribute(userNameInSn, null);
        session.setAttribute(stateNameInSn, null);
        session.setAttribute(formNameInSn, null);
        session.setAttribute(userChoiceInSn, null);
        return mav;
    }

    @Override
    @Transactional
    public ModelAndView userDataRetriveFromDB(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("userDataRetriveFromDB...Service");
        String userName = request.getParameter(userUserName);
        String password = request.getParameter(usrPassword);
        LOGGER.info("userName : "+userName+"password : "+password);        
        String typeOfRefDocument = (String) session.getAttribute("typeOfRefDocumentInSn");
        String typeOfFederalForm = (String) session.getAttribute("typeOfFederalFormInSn");
        String encrypPassword = mD5Encrypt(password);
        String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String passwordSalt = mD5Encrypt(encrypPassword + salt);
        List<UsersInformation> userDataList = userInfoDAOImpl.findByUserInfoProperty(userName, passwordSalt);
        ModelAndView mav = null;
        if (!userDataList.isEmpty()) {
            int uID = 0;
            String usrName = null;
            String typeOfUser = null;
            for (UsersInformation usersInformation : userDataList) {
                uID = usersInformation.getUserId();
                usrName = usersInformation.getUserName();
                typeOfUser = usersInformation.getTypeOfUser();
            }
            if(("U").equals(typeOfUser)){
            int userNameIndex = (usrName).indexOf("@");
            String firstName = (usrName).substring(0, userNameIndex);            
            session.setAttribute(userIdsInSn, uID);
            session.setAttribute(userNameInSn, usrName);
            session.setAttribute(firstNamesInSn, firstName);            
//    		Number of documents added to Document Car  
            List<AllStateAndFederalFormsAddCartPaymentSaving> allFormsAddCartPaymentDataList = allFormsAddCartPaymentSavingDAOImpl.allStateAndFederalFormsAddCartPaymentDataTakeFromDB(userName);
            int noOfDocInCart = allFormsAddCartPaymentDataList.size();            
            if (session.getAttribute("stateNameInSn") != null && session.getAttribute("formNameInSn") != null) {
            	mav = allStateFormsRedirection(typeOfRefDocument, request, session);                
                mav.addObject(statesName, session.getAttribute(stateNameInSn));
                mav.addObject(formsName, session.getAttribute(formNameInSn));                
            } else if (typeOfFederalForm != null){
            	mav = allFederalFormsRedirection(typeOfFederalForm, request, session);            	
            	session.setAttribute("typeOfFederalFormInSn", null);
            } else {
            	List<AllStateFormsDataSaving> pendStateFormsSavingInfoList = allStateFormsDataSavingDAOImpl.stateFormsSavingDataFromDB(userName);                 
                List<AllFederalFormsDataSaving> penFederalFormsSavingInfoList = allFederalFormsSavingDAOImpl.federalFormsSavingDataTakeFromDB(userName);                
                List<AllStateFormsDataSaving> comStateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.completedStateFormsForUSerDataFromDB(userName);                
                List<AllFederalFormsDataSaving> comFederalFormsSavingInfiList = allFederalFormsSavingDAOImpl.completedFederalFormsForUSerDataFromDB(userName);                
                if (pendStateFormsSavingInfoList.isEmpty() && penFederalFormsSavingInfoList.isEmpty() && comStateFormsSavingInfiList.isEmpty() && comFederalFormsSavingInfiList.isEmpty()) {
                    mav = new ModelAndView("editUserProfile");
                } else{
                	mav = stateFormsServiceImpl.stateFormUserMyAccountRedirection(request, session);
                }                
            }
            mav.addObject(usrFirstName, firstName);
            mav.addObject(userUserName, userName);            
            mav.addObject(noOfDocumentsInCart, noOfDocInCart);
            session.setAttribute("noOfDocInCartInSn", noOfDocInCart);            
        } else if(("A").equals(typeOfUser)){
        	mav = redirectToAdminModule(session, uID);
        } else if(("I").equals(typeOfUser)){
        	mav = new ModelAndView(loginPageRe);
            mav.addObject("errorPage", " The account is inactivated.");
        }
        } else {
            mav = new ModelAndView(loginPageRe);
            mav.addObject("errorPage", " Invalid ID or Password.");
        }
        mav.addObject("messageData", userDataList);
        return mav;
    }
    
    @RequestMapping(value = "/redirect", method = RequestMethod.POST)
    public ModelAndView redirectToAdminModule(HttpSession session, int userId) {    	
    	String projectUrl = ipAddress+"adminHome?param=" + userId;    	
        return new ModelAndView("redirect:" + projectUrl);
    }
    
//	All State Forms Redirection
    @Override
    @Transactional
    public ModelAndView allStateFormsRedirection(String typeOfRefDocument, HttpServletRequest request, HttpSession session) {
        LOGGER.debug("allStateFormsRedirection...Service");
        ModelAndView mav = new ModelAndView();
        if (("Business Services").equals(typeOfRefDocument)) {
            mav = busServiceDAOImpl.newStateFormSelectionFromDB(request, session);
        } else if (("Additional Services").equals(typeOfRefDocument)) {
            mav = busServiceDAOImpl.newAdditionalServiceFormSelectionFromDB(request, session);
        } else if (("State Tax ID").equals(typeOfRefDocument)) {
            mav = busServiceDAOImpl.newStateTaxIdFormSelectionFromDB(request, session);
        }
        return mav;
    }
    
//	All Federal Forms Redirection
    @Override
    @Transactional
    public ModelAndView allFederalFormsRedirection(String typeOfFederalForm, HttpServletRequest request, HttpSession session) {
        LOGGER.debug("allFederalFormsRedirection...Service");
        ModelAndView mav = new ModelAndView();
        if("Federal Tax ID".equals(typeOfFederalForm)){
    		mav = federalFormsUpdateServiceImpl.federalTaxIDFormUpdation(request, session);
    	} else if("S Corporation".equals(typeOfFederalForm)){
    		mav = federalFormsUpdateServiceImpl.sCorporationFormUpdation(request, session);
    	} else if("501 Application".equals(typeOfFederalForm)){
    		mav = federalFormsUpdateServiceImpl.fiveZeroOneFormUpdation(request, session);
    	}
        return mav;
    }

//	LogOut Service Implementation methods
    @Override
    @Transactional
    public ModelAndView userLogOutRedirection(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("userLogOutRedirection...Service");
        ModelAndView mav = new ModelAndView(loginPageRe);
        mav.addObject("logOutMessage", "You have been successfully logged out.");
        session.setAttribute(userNameInSn, null);
        session.setAttribute(stateNameInSn, null);
        session.setAttribute(formNameInSn, null);
        session.setAttribute(userChoiceInSn, null);
        session.setAttribute(noOfDocInCartInSn, null);
        session.setAttribute(typeOfFederalFormInSn, null);
        session.removeAttribute(userNameInSn);
        session.setAttribute(firstNamesInSn, null);
        return mav;
    }

//	Session Time Out Service Implementation methods
    @Override
    @Transactional
    public ModelAndView userSessionTimeOutRedirection(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("userSessionTimeOutRedirection...Service");
        ModelAndView mav = new ModelAndView(loginPageRe);
        mav.addObject("logOutMessage", "Your session has expired.");
        session.setAttribute(userNameInSn, null);
        session.setAttribute(stateNameInSn, null);
        session.setAttribute(formNameInSn, null);
        session.setAttribute(userChoiceInSn, null);
        return mav;
    }

//	Forget Password With Email Service Implementation methods
    @Override
    @Transactional
    public ModelAndView forgetPasswordWithEmail() {
    	LOGGER.debug("forgetPasswordWithEmail...Service");
        ModelAndView mav = new ModelAndView();
        return mav;
    }

    public ModelAndView forgetPasswordWithEmailChecking(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("forgetPasswordWithEmailChecking...Service");
        String userName = request.getParameter("userName");
        LOGGER.info("userName : "+userName);
        EmailSending userEmail = new EmailSending();
        String fromAdd = "info@legalnod.com";
        List userDataVal = userInfoDAOImpl.findByUserName(userName);
        ModelAndView mav;
        if (!userDataVal.isEmpty()) {
            UsersInformation userData = userInfoDAOImpl.findByUserInfoFromDB(userName);            
            int userId = userData.getUserId();            
            int userNameIndex = (userName).indexOf("@");
            String firstName = (userName).substring(0, userNameIndex);
            String alphaNumerics = "ab1cde2fgh3ijk4mnp5qrs6tuv7wxy8zAB9CDEFGHIJKLMNPQRST0UVWXYZ";
            String t = "";
            for (int i = 0; i < 8; i++) {
                t += alphaNumerics.charAt((int) (Math.random() * alphaNumerics.length()));
            }
            String securityPin = t;
            java.util.Date date = new java.util.Date();
            Timestamp currentDate = new Timestamp(date.getTime());
            UsersInformation userInfo = userInfoDAOImpl.findById(userId);
            userInfo.setSecurityPin(securityPin);
            userInfo.setEmailSentDate(currentDate);
            userInfoDAOImpl.merge(userInfo);
            String aTo = userName;
            String aSubject = "Legal Nod Security Pin.";
            String spin = securityPin;
            String type = "text/html";            
                        
            String body = "<body><div style='width: 900px;'>"
                    + "<div style='background: white; margin-top:30px;'>"
                    + "<b style='font-size: 35px; font-family: Georgia; line-height: 1px;color: #00a9f1;'>Legal<font style='color: #595959; '>Nod</font></b><br>"
                    + "<b style='font-size: 12.5px; margin-left: 65px; font-family: Georgia; color: #292929; line-height: 0px; margin-top: -10px;'>for your legal needs</b><br> </div> <br>"
                    + "<div style='background: #595959; min-height: 25px; width: 900px; margin-top: 0px;'></div>"
                    + "<div style='background: #F2F2F2; min-height: 100px; width: 900px;'><br><br>"
                    + "<div style='background: white; border-bottom: 20px solid #A5A5A5; min-height: 50px; width: 700px; margin-left: 100px;border-radius: 20px 20px 0px 0px;'><br>"
                    + "<div style='color: #00A9F1; font: 19px/2em serif; margin-left: 20px;'><h3>Security Pin for resetting Password</h3></div>"
                    + "<font style='color: #1C1C1C; margin-left: 20px; font:bold 14px/2em sans-serif;'><b>Hello<font color='#00A9F1'>&nbsp; " + firstName + ",</font></b></font><br><br>"
                    + "<table style='margin-left:50px; color: #000; font-weight: normal; font: 14px/2em sans-serif; text-decoration: none;'>"
                    + "<tr><td>User ID</td><td style='color: #2c2c2c;text-decoration: none;'>:&nbsp;&nbsp;&nbsp; " + aTo + " </td></tr>"
                    + "<tr height='10px'><td></td><td></td></tr>"
                    + "<tr><td>Security Pin&nbsp;&nbsp;&nbsp;</td><td>:&nbsp;&nbsp;&nbsp; <b>" + spin + "</b></td></tr>"
                    + "<tr height='60px'><td></td><td></td></tr></table> </div>"
                    + "<div style='background: #595959; margin-left: 100px;min-height:110px; width:700px;'><font></font></div>"
                    + "</div> </div> </body>";
            
            
            try {
                userEmail.sendEmail(aTo, aSubject, body, type, fromAdd);
            } catch (Exception ex) {
            	LOGGER.error("forgetPasswordWithEmailChecking " + ex);
            }
            mav = new ModelAndView("forgetPasswordWithEmailChecking");
            session.setAttribute(userNameInSn, null);
            session.setAttribute("userIdSecInSn", userId);
            session.setAttribute("securityPinInSn", securityPin);            
            mav.addObject("secPinMessage", " A Security Pin has been sent to your e-mail");
        } else {
            mav = new ModelAndView("lnForgetPass");
            mav.addObject("forPassErrorPage", " E-mail ID not found!");
        }
        return mav;
    }

    public ModelAndView forgetPasswordWithSecurityPin(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("forgetPasswordWithSecurityPin...Service");        
        String snSecPin = (String) session.getAttribute("securityPinInSn");
        int snUserId = (Integer) session.getAttribute("userIdSecInSn");
        String secPin = request.getParameter("securityPin");
        String password = request.getParameter(usrPassword);
        LOGGER.info("snSecPin : "+snSecPin+"password : "+password+"snUserId : "+snUserId+"secPin : "+secPin);
        ModelAndView mav;
        if (snSecPin.equals(secPin)) {
            String encrypPassword = mD5Encrypt(password);
            String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
            String passwordSalt = mD5Encrypt(encrypPassword + salt);
            java.util.Date date = new java.util.Date();
            Timestamp currentDate = new Timestamp(date.getTime());
            UsersInformation userInfo = userInfoDAOImpl.findById(snUserId);
            userInfo.setPassword(encrypPassword);
            userInfo.setPasswordSalt(passwordSalt);
            userInfo.setLastPasswordChangedDate(currentDate);
            userInfoDAOImpl.merge(userInfo);
            mav = new ModelAndView(loginPageRe);
        } else {
            mav = new ModelAndView("forgetPasswordWithEmailChecking");
            mav.addObject("forPassSeqPinErrorPage", " Please enter correct Security Pin!");
        }
        return mav;
    }

//	User profile Services
    public ModelAndView changeUserEmailAddress(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("changeUserEmailAddress...Service");
        String userName = (String) session.getAttribute("userNameInSn");
        int snUserId = (Integer) session.getAttribute(userIdsInSn);
        String firstName = (String) session.getAttribute(firstNamesInSn);        
        String emailAddress = request.getParameter("newEmail");
        List regDataVal = userInfoDAOImpl.findByEmailChangeProperty(emailAddress);
        ModelAndView mav;
        if (!regDataVal.isEmpty()) {
            mav = new ModelAndView("editUserProfile");
            mav.addObject("changeEmailError", " Email Address already exists!");
            mav.addObject("email", emailHeading);
            mav.addObject(userUserName, userName);
            mav.addObject(usrFirstName, firstName);
        } else {
            UsersInformation userInfo = userInfoDAOImpl.findById(snUserId);
            userInfo.setUserName(emailAddress);
            userInfoDAOImpl.merge(userInfo);
            int userNameIndex = (emailAddress).indexOf("@");
            String userFirstName = (emailAddress).substring(0, userNameIndex);            
            session.setAttribute(userNameInSn, emailAddress);
            mav = new ModelAndView("editUserProfile");
            mav.addObject("emailMessage", emailHeading);
            mav.addObject(userUserName, emailAddress);
            mav.addObject(usrFirstName, userFirstName);
            session.setAttribute(firstNamesInSn, userFirstName);
        }                
        List<AllStateFormsDataSaving> stateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.editUPStateFormsSavingDataFromDB((String) session.getAttribute(userNameInSn));
        List<AllFederalFormsDataSaving> federalFormsSavingInfoList = allFederalFormsSavingDAOImpl.editUPFederalFormsSavingDataTakeFromDB((String) session.getAttribute(userNameInSn));
        int stCount = stateFormsSavingInfiList.size();
        int fedCount = federalFormsSavingInfoList.size();        
        mav.addObject("userProfileSateRefVal", stCount);
        mav.addObject("userProfileFedRefVal", fedCount);
        mav.addObject(noOfDocumentsInCart, session.getAttribute(noOfDocInCartInSn));
        return mav;
    }

    public ModelAndView changePassword(HttpServletRequest request, HttpSession session) {
    	LOGGER.debug("changePassword...Service");
        String userName = (String) session.getAttribute("userNameInSn");
        int snUserId = (Integer) session.getAttribute(userIdsInSn);
        String firstName = (String) session.getAttribute(firstNamesInSn);        
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String encrypCurPassword = mD5Encrypt(currentPassword);
        String curPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String currentPasswordSalt = mD5Encrypt(encrypCurPassword + curPassSalt);
        String encrypNewPassword = mD5Encrypt(newPassword);
        String newPassSalt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        String newPasswordSalt = mD5Encrypt(encrypNewPassword + newPassSalt);
        UsersInformation userData = userInfoDAOImpl.findByUserInfoFromDB(userName);
        String oldPassSalt = userData.getPasswordSalt();
        ModelAndView mav;
        if (currentPasswordSalt.equals(oldPassSalt)) {
            UsersInformation userInfo = userInfoDAOImpl.findById(snUserId);
            userInfo.setPassword(encrypNewPassword);
            userInfo.setPasswordSalt(newPasswordSalt);
            userInfoDAOImpl.merge(userInfo);
            mav = new ModelAndView("editUserProfile");
            mav.addObject("passMessage", passwordHeading);
        } else {
            mav = new ModelAndView("editUserProfile");
            mav.addObject("changePasswordError", " Invalid Current Password");
            mav.addObject(usrPassword, passwordHeading);
        }
        mav.addObject(usrFirstName, firstName);        
        mav.addObject(userUserName, userName);
        List<AllStateFormsDataSaving> stateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.editUPStateFormsSavingDataFromDB((String) session.getAttribute(userNameInSn));
        List<AllFederalFormsDataSaving> federalFormsSavingInfoList = allFederalFormsSavingDAOImpl.editUPFederalFormsSavingDataTakeFromDB((String) session.getAttribute(userNameInSn));
        int stCount = stateFormsSavingInfiList.size();
        int fedCount = federalFormsSavingInfoList.size();        
        mav.addObject(noOfDocumentsInCart, session.getAttribute(noOfDocInCartInSn));
        mav.addObject("userProfileSateRefVal", stCount);
        mav.addObject("userProfileFedRefVal", fedCount);
        return mav;
    }

    public ModelAndView editContactInfo(HttpServletRequest request, HttpSession session) {    	
    	LOGGER.debug("editContactInfo...Service");
        String userName = (String) session.getAttribute("userNameInSn");
        int snUserId = (Integer) session.getAttribute(userIdsInSn);
        String firstName = request.getParameter(usrFirstName);        
        ModelAndView mav;
        UsersInformation userInfo = userInfoDAOImpl.findById(snUserId);
        userInfo.setFirstName(firstName);        
        userInfoDAOImpl.merge(userInfo);
        mav = new ModelAndView("editUserProfile");
        List<AllStateFormsDataSaving> stateFormsSavingInfiList = allStateFormsDataSavingDAOImpl.editUPStateFormsSavingDataFromDB((String) session.getAttribute(userNameInSn));
        List<AllFederalFormsDataSaving> federalFormsSavingInfoList = allFederalFormsSavingDAOImpl.editUPFederalFormsSavingDataTakeFromDB((String) session.getAttribute(userNameInSn));
        int stCount = stateFormsSavingInfiList.size();
        int fedCount = federalFormsSavingInfoList.size();        
        mav.addObject(noOfDocumentsInCart, session.getAttribute(noOfDocInCartInSn));
        mav.addObject("userProfileSateRefVal", stCount);
        mav.addObject("userProfileFedRefVal", fedCount);
        session.setAttribute(firstNamesInSn, firstName);        
        mav.addObject(usrFirstName, firstName);        
        mav.addObject(userUserName, userName);
        return mav;
    }
}