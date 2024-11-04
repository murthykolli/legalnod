<%--
    Document : forgetPasswordWithSecurityPin
    Created on : 3 March, 2015, 2:59:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>        
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    
    <link rel="shortcut icon" href="/legalnod/resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
    
    <script type = "text/javascript">
    window.onload=function(){ document.secpin.elements['securityPin'].focus(); };
    function CheckFirstChar(key, txt){ if(key === 32 && txt.value.length<=0){ return false; } else if(txt.value.length>0){ if(txt.value.charCodeAt(0) === 32){ txt.value=txt.value.substring(1,txt.value.length); return true; } } return true; }
    
    function validation(){
    	var email=document.secpin.securityPin.value;
        var password=document.secpin.password.value;
        var confirmpass=document.secpin.confirmPassword.value;
        var reg =/^[a-zA-Z0-9]{8}$/;
        var reg1 = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
        var result = true;
        if(reg.test(email)){
        document.getElementById("secpinlabel").removeAttribute("class");
        } else{
        document.getElementById("secpinlabel").setAttribute("class","redTestDisplay");
        result=false;
        } 
        
        if(reg1.test(password)){
        document.getElementById("passlabel").removeAttribute("class");
        } else{
        document.getElementById("passlabel").setAttribute("class","redTestDisplay");
        result=false;
        } 
        if(password !== confirmpass || confirmpass === ""){
        document.getElementById("confPasslabel").setAttribute("class","redTestDisplay");
        result=false;
        } else{
        document.getElementById("confPasslabel").removeAttribute("class");
        } 
        return result;
        }

        function secpinValidation(){
        var reg = /^[a-zA-Z0-9]{8}$/;
        var email=document.secpin.securityPin.value;
        if(reg.test(email)){
        document.getElementById("secpinlabel").removeAttribute("class");
        } else{
        document.getElementById("secpinlabel").setAttribute("class","redTestDisplay");
        if(email===""){
        document.getElementById("secpinlabel").removeAttribute("class");
        }; }; }
        
        function passValidation(){
        var reg1 = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
        var password=document.secpin.password.value;
        if(reg1.test(password)){
        document.getElementById("passlabel").removeAttribute("class");
        } else{
        document.getElementById("passlabel").setAttribute("class","redTestDisplay");
        if(password===""){
        document.getElementById("passlabel").removeAttribute("class");
        }; }; }
        
        function confPassValidation(){
        var password=document.secpin.password.value;
        var confirmpass=document.secpin.confirmPassword.value;
        if(password===confirmpass){
        document.getElementById("confPasslabel").removeAttribute("class");
        } else{
        document.getElementById("confPasslabel").setAttribute("class","redTestDisplay");
        if(confirmpass===""){
        document.getElementById("confPasslabel").removeAttribute("class");
        }; }; }

        function passwdvalidation(){
        var reg1 = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
        var password = document.secpin.password.value;
        if(!(reg1.test(password))){
        document.secpin.password.value="" ;
        alert("Password must be a minimum of 8 characters with at least one digit or special character");
        }; }
        
        function removeLogOutMsg(){
        document.getElementById("logOutMsgId").style.display='none';
        }
        </script>
        </head>
        <body>
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">		
		<div class="col-md-12">		
		<div class="white-bg">
		<div class="col-md-12">
		<h2 class="text-right">New to LegalNod?</h2>
		<form action="registrationPage" method="get">
		<h4 class="pull-right" style="height: 35px;">				
		<button class="white-bg-sub-but" type="submit" onMouseOver="document.getElementById('login-reg-hover').src='resources/images/SSImgs/RegistrationMOImg.png';" onMouseOut="document.getElementById('login-reg-hover').src='resources/images/SSImgs/RegistrationImg.png';" ><img id="login-reg-hover" src="resources/images/SSImgs/RegistrationImg.png" alt=""><span class="butt-va-mid">Create an Account</span></button></h4></form>		
		
		<div class="clearfix"></div>
		</div>
		<div class="row">
		<div class="col-md-6">
		
		<div class="left-login" style="min-height:370px;">        
		        <div class="headingg">
		        <p id="smallFormHeading" style="margin-left: 37px;margin-top: 9px;position: absolute;">New Password PIN</p> </div>
		            <form action="forgetPasswordWithsecurityPinChecking" name="secpin" method="post">             
		            <table style="margin-top: 35px;margin-left: 35px;position: absolute;"> 
		            
		            <c:if test="${not empty forPassSeqPinErrorPage}"> <tr><td><font style="color: #c00002;font-size: 14px;height: 10px;position:absolute;margin-top:-25px;white-space: nowrap;"><img src="resources/images/warning.gif" width="18" height="12"/> ${forPassSeqPinErrorPage}</font></td></tr> </c:if>
                    <c:if test="${not empty secPinMessage}"> <tr id="logOutMsgId"><td><font style="font: 0.95em/1.25em sans-serif;white-space: nowrap;color:#c00002;position:absolute;margin-left: -18px;margin-top:-25px;width:270px;"> ${secPinMessage}</font></td></tr> </c:if> 
                    
		            <tbody><tr class="smallFormLabel"><td id="secpinlabel">Security PIN* </td></tr>
		            <tr style="height: 5px;"></tr>
		            <tr><td><input type="text" id="securityPin" name="securityPin" autocomplete="off" maxLength="8" onkeyup = "CheckFirstChar(event.keyCode, this);secpinValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="secpinValidation()" onclick="removeLogOutMsg();" ></td></tr> 
		            <tr style="height: 7px;"></tr>
		            <tr class="smallFormLabel"><td id="passlabel">New Password* </td></tr>
		            <tr style="height: 5px;"></tr>
		            <tr><td><input type="password" id="password" name="password" autocomplete="off" onkeyup = "CheckFirstChar(event.keyCode, this);passValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="passValidation()" onchange="passwdvalidation()" onclick="removeLogOutMsg();"></td></tr>
		            <tr style="height: 7px;"></tr>
		            <tr class="smallFormLabel"><td id="confPasslabel">Confirm Password*</td></tr>
            		<tr style="height: 5px;"></tr>
            		<tr><td><input type="password" name="confirmPassword" autocomplete="off" id="confirmPassword" onkeyup = "CheckFirstChar(event.keyCode, this);confPassValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="confPassValidation()" onclick="removeLogOutMsg();"></td></tr>
            		<tr style="height: 7px;"></tr>
		            <tr><td><h4 class="pull-left">		            
		            <button class="submit-button" type="submit" onclick="return validation();" onMouseOver="document.getElementById('pin-sub-but').src='resources/images/SSImgs/PasswordSavingMOImg.png';" onMouseOut="document.getElementById('pin-sub-but').src='resources/images/SSImgs/PasswordSavingImg.png';" ><img id="pin-sub-but" src="resources/images/SSImgs/PasswordSavingImg.png" alt=""><span class="butt-va-mid">Save Password</span></button>
					</h4></td></tr>
					</tbody></table>
		            </form> </div>
		  			</div>          
		            <div class="col-md-6">		            
		            <div class="right-login">
		        <p class="loginHeading">Log in so you can</p>            
		        <p class="loginHeading">
		        <font class="site-color">Get Started</font> and <font class="site-color">Save Your Work!</font></p>
		        <p class="pstyle">
		        <img src="resources/images/tickMarkImg.png"> <font style="font: 1.05em/1em sans-serif;margin-left:5px;">Save your work now, finish it later</font><br>
		        <img src="resources/images/tickMarkImg.png"> <font style="font: 1.05em/1em sans-serif;margin-left:5px;">Review your progress anytime</font><br>
		        <img src="resources/images/tickMarkImg.png"> <font style="font: 1.05em/1em sans-serif;margin-left:5px;">Store your documents securely</font><br>
		        <img src="resources/images/tickMarkImg.png"> <font style="font: 1.05em/1em sans-serif;margin-left:5px;">Work on multiple documents at a time</font><br> </p> </div>
		</div>		
		</div>	
		
		<div class="clearfix"></div>
		</div><!-- white Bg -->
		</div>
		</div>
		<!-- /.contaner -->	
		</div>
		<!-- row -->
        </body>    
</html>