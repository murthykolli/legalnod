<%--
    Document : forgetPasswordWithEmail
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
       
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />

    <script type="text/javascript">
    window.onload=function(){ document.forgotPass.elements['userName'].focus(); };
    function CheckFirstChar(key, txt){ if(key === 32 && txt.value.length<=0){ return false; } else if(txt.value.length>0){ if(txt.value.charCodeAt(0) === 32){ txt.value=txt.value.substring(1,txt.value.length); return true; } } return true; }
    function validation(){
        var email=document.forgotPass.userName.value;
        var reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
        var result = true;
        if(reg.test(email)){
        document.getElementById("emaillabel").removeAttribute("class");
        } else{
        document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
        result=false;
        }
        return result;
        }

        function emailValidation(){
        var reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
        var email=document.forgotPass.userName.value;
        if(reg.test(email)){
        document.getElementById("emaillabel").removeAttribute("class");
        } else{
        document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
        if(email===""){
        document.getElementById("emaillabel").removeAttribute("class");
        } } }
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
		
		<div class="left-login" style="min-height: 240px;">        
		        <div class="headingg">
		        <p id="smallFormHeading" style="margin-left: 37px;margin-top: 9px;position: absolute;">Forgot Password</p> </div>
		            <form action="forgetPasswordWithEmailChecking" name="forgotPass" method="post">             
		            <table style="margin-top: 35px;margin-left: 35px;position: absolute;"> 
		            
		            <c:if test="${not empty forPassErrorPage}"> <tr><td><font style="color: #c00002;font-size: 14px;height: 10px;position:absolute;margin-top:-25px;"><img src="resources/images/warning.gif" width="18" height="12"/> ${forPassErrorPage}</font></td></tr> </c:if>
            
		            <tbody><tr class="smallFormLabel"><td id="emaillabel">Email Address* </td></tr>
		            <tr style="height: 5px;"></tr>
		            <tr><td><input type="text" id="userName" name="userName" autocomplete="off" onkeyup = "CheckFirstChar(event.keyCode, this);emailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="emailValidation()" ></td></tr> 
		            <tr style="height: 14px;"></tr>
		            <tr><td><h4 class="pull-left">		            
		            <button class="submit-button" type="submit" onclick="return validation();" onMouseOver="document.getElementById('f-email-sub-but').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('f-email-sub-but').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="f-email-sub-but" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">Email me a Pin</span></button>
					</h4></td></tr> <tr style="height: 12px;"></tr>
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