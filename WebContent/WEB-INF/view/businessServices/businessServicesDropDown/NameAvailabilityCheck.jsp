<%--
    Document   : NameAvailabilityCheck
    Created on : 20 February, 2014, 2:59:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content="LegalNod allows customers to check on the availability of a business name by comparing against the records. For business name search visit here www.legalnod.com"/>
	<meta name="keywords" content="Business Names Search"/>
	
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=sessionTimeOut" />
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
    
    <script type="text/javascript">
    function validation(){
    var reg=/^[A-Za-z 0-9][A-Za-z 0-9 -'+-?;@*#/_().&]*$/;
    var reg4 = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var stateName=document.nameAvlCheckFormName.stateName.value;
    var formName=document.nameAvlCheckFormName.formName.value;
    var comment=document.nameAvlCheckFormName.comment.value;
    var formNames=document.nameAvlCheckFormName.formNames.value;
    var contactEmail=document.nameAvlCheckFormName.contactEmail.value;
    var result=true;

    if(stateName!==""){
    document.getElementById("stateLabel").removeAttribute("class");
    } else{
    document.getElementById("stateLabel").setAttribute("class","redTestDisplay");
    result=false;
    }

    if(formName!==""){
    document.getElementById("formLabel").removeAttribute("class");
    } else{
    document.getElementById("formLabel").setAttribute("class","redTestDisplay");
    result=false;
    }

    if(comment !== ""){
    document.getElementById("descLabel").removeAttribute("class");
    } else{
    document.getElementById("descLabel").setAttribute("class","redTestDisplay");
    result=false;
    }

    if(reg.test(formNames)){
    document.getElementById("busNameLabel").removeAttribute("class");
    } else{
    document.getElementById("busNameLabel").setAttribute("class","redTestDisplay");
    result=false;
    }

    if(reg4.test(contactEmail)){
    document.getElementById("emaillabel").removeAttribute("class");
    } else{
    document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
    result=false;
    }
    return result;
    }

    function llcStateValidation(){
    var stateName = document.nameAvlCheckFormName.stateName.value;
    if(stateName !== ""){
    document.getElementById("stateLabel").removeAttribute("class");
    } else{
    document.getElementById("stateLabel").setAttribute("class","redTestDisplay");
    }; }

    function llcFormNameValidation(){
    var formName = document.nameAvlCheckFormName.formName.value;
    if(formName !== ""){
    document.getElementById("formLabel").removeAttribute("class");
    } else{
    document.getElementById("formLabel").setAttribute("class","redTestDisplay");
    }; }

    function llcDescValidation(){
    var comment = document.nameAvlCheckFormName.comment.value;    
    if(comment !== ""){
    document.getElementById("descLabel").removeAttribute("class");
    } else{
    document.getElementById("descLabel").setAttribute("class","redTestDisplay");
    if(comment === ""){
    document.getElementById("descLabel").removeAttribute("class");
    }; }; }

    function llcBusNameValidation(){
    var formNames = document.nameAvlCheckFormName.formNames.value;
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 -'+-?;@*#/_().&]*$/;
    if(reg.test(formNames)){
    document.getElementById("busNameLabel").removeAttribute("class");
    } else{
    document.getElementById("busNameLabel").setAttribute("class","redTestDisplay");
    if(formNames === ""){
    document.getElementById("busNameLabel").removeAttribute("class");
    }; }; }

    function contactEmailValidation(){
    var reg4 = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var contactEmail = document.nameAvlCheckFormName.contactEmail.value;
    if(reg4.test(contactEmail)){
    document.getElementById("emaillabel").removeAttribute("class");
    } else{
    document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
    if(contactEmail === ""){
    document.getElementById("emaillabel").removeAttribute("class");
    }; }; }

    function CheckFirstChar(key, txt){
    if(key === 32 && txt.value.length<=0){ return false; } else if(txt.value.length>0){
    if(txt.value.charCodeAt(0) === 32){ txt.value=txt.value.substring(1,txt.value.length); return true; } } return true; }
    </script>
    
    <c:if test="${not empty nameAvailabilityCheck}">    
    <script type="text/javascript">
    window.alert("Thank you for your Name Availability Check submission. We will notify you shortly to the email address we have on file for you regarding your submission."); 
    </script>    
    </c:if>

    <script type="text/javascript">
    window.onload = function(){
    rec();
    document.nameAvlCheckFormName.stateName.value = "";
    document.nameAvlCheckFormName.formName.value = "";
    document.nameAvlCheckFormName.comment.value = "";
    document.nameAvlCheckFormName.formNames.value = "";
    document.nameAvlCheckFormName.contactFName.value = "";
    document.nameAvlCheckFormName.contactLName.value = "";
    document.nameAvlCheckFormName.contactAddr2.value = "";
    document.nameAvlCheckFormName.contactCity.value = "";
    document.nameAvlCheckFormName.contactEmail.value = "";
    }
    </script>
    </head>    
        <body>
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">		
		<div class="col-md-12">		
		<div class="white-bg paddingg">		
		<div class="row">         
        <div class="col-md-10">
            
        <div class="left-name-ava-che">        
        <div class="headingg">
        <p id="smallFormHeading" style="margin-left: 37px; margin-top: 9px; position: absolute;">Name Availability Check</p> </div>
            <form name="nameAvlCheckFormName" id="nameAvlCheckFormId" action="nameAvailabilityCheckInfoSave" method="get">           
            <table style="margin-top: 25px;margin-left: 30px;position: absolute;"> <tbody>           
            
            <tr class="smallFormLabel"><td id="stateLabel">What State would you like to form your business?*</tr>
            <tr style="height: 5px;"></tr>
            <tr><td> <select id="stateName" name="stateName" onchange="return llcStateValidation();">
	        <option value="">----------Select State Name----------</option>
		    <c:forEach var="statesList" items="${stateList}"> <option value="${statesList.stateName}">${statesList.stateName}</option> </c:forEach> </select></td></tr>
            <tr style="height: 17px;"></tr>
            
            <tr class="smallFormLabel"><td id="formLabel">What type of company are you forming?*</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><select id="formName" name="formName" onchange="return llcFormNameValidation();">
	        <option value="">----------Select Company Name----------</option>
		    <c:forEach var="companyFormingsList" items="${companyFormingList}"> <option value="${companyFormingsList.companyForming}">${companyFormingsList.companyForming}</option> </c:forEach> </select></td></tr>
            <tr style="height: 17px;"></tr>
            
            <tr class="smallFormLabel"><td id="descLabel">Please provide a description of your business*:</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><textarea name="comment" style="width: 240px;height: 110px;border-radius: 5px;box-shadow: 3px 3px 1px gray;border: solid 1px #595959;" cols="35" rows="8" onblur="llcDescValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);llcDescValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></textarea></td></tr>
            <tr style="height: 7px;"></tr>
            
            <tr class="smallFormLabel"><td id="busNameLabel">What would you like the name of your business to be?*</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="formNames" onblur="llcBusNameValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);llcBusNameValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr>
            <tr style="height: 7px;"></tr>
            
            <tr class="smallFormLabel"><td>Alternate Name #1 (Optional):</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="contactFName" onkeyup = "CheckFirstChar(event.keyCode, this);" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr>
            <tr style="height: 7px;"></tr>
            
            <tr class="smallFormLabel"><td>Alternate Name #2 (Optional):</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="contactLName" onkeyup = "CheckFirstChar(event.keyCode, this);" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr>
            <tr style="height: 7px;"></tr>
            
            <tr class="smallFormLabel"><td>Alternate Name #3 (Optional):</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="contactAddr2" onkeyup = "CheckFirstChar(event.keyCode, this);" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr>
            <tr style="height: 7px;"></tr>
            
            <tr class="smallFormLabel"><td>Alternate Name #4 (Optional):</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="contactCity" onkeyup = "CheckFirstChar(event.keyCode, this);" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr>
            <tr style="height: 7px;"></tr>
            
            <tr class="smallFormLabel"><td id="emaillabel"> What email would you like us to contact you regarding your <br>Name Availability Check?*</td></tr>
            <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="contactEmail" onblur="contactEmailValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);contactEmailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr>
            <tr style="height: 20px;"></tr>
            
            <tr><td><input type="hidden" name="typeOfDocument" value="BusinessSerive" /></td></tr>
                                   
            <tr><td>            
            <h4 class="pull-left">
            <button class="submit-button" type="submit" onclick="return validation();" onMouseOver="document.getElementById('nac-sub-but').src='resources/images/SSImgs/SendButtonMOImg.png';" onMouseOut="document.getElementById('nac-sub-but').src='resources/images/SSImgs/SendButtonImg.png';" ><img id="nac-sub-but" src="resources/images/SSImgs/SendButtonImg.png" alt=""><span class="butt-va-mid">Send</span></button>
			</h4></td></tr> </tbody></table>
            <div class="clearfix"></div> </form>
            </div> </div>

		 </div>  
  		
		<div class="clearfix"></div>
		</div><!-- white Bg -->
		</div> </div>
		<!-- /.contaner -->		 
		</div>		
		<!-- row --> 
        </body>    
</html>