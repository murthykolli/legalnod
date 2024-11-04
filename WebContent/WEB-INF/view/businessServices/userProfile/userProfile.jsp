<%--
    Document   : userProfile
    Created on : 27 February, 2014, 12:51:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html> 

    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="description" content=""/>
    <meta name="keywords" content=""/>
    
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=sessionTimeOut" />
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
       
    <script type="text/javascript">
    function validation(){
    var email = document.changeEmail.newEmail.value;
    var confirmEmail = document.changeEmail.confirmEmail.value;
    var reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;    
    var result = true;
    if(reg.test(email)){
    document.getElementById("emaillabel").removeAttribute("class");
    } else{
    document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
    result = false;
    }    
    if(email!==confirmEmail || confirmEmail===""){
    document.getElementById("confEmaillabel").setAttribute("class","redTestDisplay");
    result = false;
    } else{
    document.getElementById("confEmaillabel").removeAttribute("class");
    }        
    return result;
    }

    function emailValidation(){
    var reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var email = document.changeEmail.newEmail.value;
    if(reg.test(email)){
    document.getElementById("emaillabel").removeAttribute("class");
    } else{
    document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
    if(email === ""){
    document.getElementById("emaillabel").removeAttribute("class");
    } } }
    
    function confirmEmailValidation(){
    var reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var confirmEmail = document.changeEmail.confirmEmail.value;
    var email = document.changeEmail.newEmail.value;
    if(email === confirmEmail){
    document.getElementById("confEmaillabel").removeAttribute("class");
    } else{
    document.getElementById("confEmaillabel").setAttribute("class","redTestDisplay");
    if(confirmEmail === ""){
    document.getElementById("confEmaillabel").removeAttribute("class");
    } } }

    //Password Validation    
    function cPwdValidation(){
    var currentPass = document.changePwdForm.currentPassword.value;
    var newPass = document.changePwdForm.newPassword.value;
    var reEnterPass = document.changePwdForm.reenterPassword.value;
    var reg1 = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    var result = true;
    if(reg1.test(currentPass)){
    document.getElementById("currPwdLabel").removeAttribute("class");
    } else{
    document.getElementById("currPwdLabel").setAttribute("class","redTestDisplay");
    result = false;
    }
    
    if(reg1.test(newPass)){
    document.getElementById("pwdLabel").removeAttribute("class");
    } else{
    document.getElementById("pwdLabel").setAttribute("class","redTestDisplay");
    result = false;
    }
    
    if(newPass !== reEnterPass || reEnterPass === ""){
    document.getElementById("confPwdLabel").setAttribute("class","redTestDisplay");
    result = false;
    } else{
    document.getElementById("confPwdLabel").removeAttribute("class");
    }
    return result;
    }

    function currPassValidation1(){
    var reg = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    var currentPass = document.changePwdForm.currentPassword.value;
    if(reg.test(currentPass)){
    document.getElementById("currPwdLabel").removeAttribute("class");
    } else{
    document.getElementById("currPwdLabel").setAttribute("class","redTestDisplay");
    if(currentPass === ""){
    document.getElementById("currPwdLabel").removeAttribute("class");
    }; }; }

    function passValidation1(){
    var reg = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
    var newPass = document.changePwdForm.newPassword.value;
    if(reg.test(newPass)){
    document.getElementById("pwdLabel").removeAttribute("class");    
    } else{
    document.getElementById("pwdLabel").setAttribute("class","redTestDisplay");    
    }

    if(newPass === ""){
    document.getElementById("pwdLabel").removeAttribute("class");    
    }; }

    function confPassValidation1(){
    var newPass=document.changePwdForm.newPassword.value;
    var reEnterPass=document.changePwdForm.reenterPassword.value;
    if(newPass === reEnterPass){
    document.getElementById("confPwdLabel").removeAttribute("class");
    } else{
    document.getElementById("confPwdLabel").setAttribute("class","redTestDisplay");
    if(reEnterPass === ""){
    document.getElementById("confPwdLabel").removeAttribute("class");
    }; }; }

    function passwdvalidation(){
        var reg1 = /^(?=.*[\d!@#$%\^*()_\-+=\[{\]};:|\./])(?=.*[a-z0-9]).{8,30}$/;
        var newPassword = document.changePwdForm.newPassword.value;
        if(!(reg1.test(newPassword))){
        document.changePwdForm.newPassword.value = "" ;
        alert("Password must be a minimum of 8 characters with at least one digit or special character");
        }; }

    function CheckFirstChar(key, txt){ if(key === 32 && txt.value.length<=0){ return false; }
    else if(txt.value.length>0){ if(txt.value.charCodeAt(0) === 32){ txt.value=txt.value.substring(1,txt.value.length); return true; } } return true; }
    </script>

	<c:if test="${not empty passMessage}">    
    <script type="text/javascript">
    window.alert("Your new Password has been saved"); 
    </script>    
    </c:if>
    
    <c:if test="${not empty emailMessage}">    
    <script type="text/javascript">
    window.alert("Your new Email Address has been saved"); 
    </script>    
    </c:if>   

    </head>
    
    	<body>    	  
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-background backgr-adj">
		<div class="docCenter" style="padding-bottom: 107px">
		<div>
		<div class="row">
		<div class="col-md-12">
		<div class="col-md-6"><font id="myAccountText">My Account - <font id="myAccountCategory">User Profile</font></font></div>
		
		<div class="col-md-6">		
		<form action="businessServices" method="get">
        <table id="userProfileRefValID" align="right" style="display: none;">        
        <tr><td><h4 class="pull-right">
        <button class="ord-wt-bg-sub-but" type="submit" onMouseOver="document.getElementById('newdoc-sub-but').src='resources/images/SSImgs/NewDocCreationMOImg.png';" onMouseOut="document.getElementById('newdoc-sub-but').src='resources/images/SSImgs/NewDocCreationImg.png';" ><img id="newdoc-sub-but" src="resources/images/SSImgs/NewDocCreationImg.png" alt=""><span class="butt-va-mid">Create New Document</span></button> 
        </h4></td></tr>
        </table>
        </form>		
		</div> </div> </div>
		
		<div class="row">
		<div class="col-md-12">		
		<div class="editUserProfile">
		<a href="editUserProfile"><font class="myAccountCurrentTab">&nbsp;User Profile&nbsp;</font></a>
		</div>
		<div class="clearfix"></div>
		<div class="my-account-user-profile">
		
		
		<div class="edit-Email">
		<h2>Email Address</h2>
		
		<p class="usr-pro-text">&nbsp;&nbsp;Current Email Address:	  &nbsp;${userName}</p>
		
		<div class="Edit-Email-Address"  id="btttn1">
		<p><a class="Smallbutton" id="showInfo" data-target=".info1">Edit Email Address</a></p>
		
		<div id="show-email" class="form-box info1 target" style="display: none;">
		<form action="changeUserEmailAddress" name="changeEmail" autocomplete="off" method="post">
		<div class="form-group">
		<table><tbody>
		<c:if test="${not empty changeEmailError}">
        <tr><td><font style="color: #c00002;font-size: 14px;font-weight:normal;height: 10px;position:absolute;margin-top:5px;"><img src="resources/images/warning.gif" width="18" height="12"/>
        ${changeEmailError}</font></td></tr>                
        <script type="text/javascript"> $(document).ready(function(){ $("#show-email").show(); }); </script>
        <tr style="height:30px;"></tr> </c:if>
        
        <tr class="smallFormLabel"><td id="emaillabel">Email Address* </td></tr> 
        <tr style="height:7px;"></tr>   
		<tr><td class="input-incwd"><input type="text" id="newEmail" name="newEmail" autocomplete="off" onkeyup = "CheckFirstChar(event.keyCode, this);emailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="emailValidation()"></td></tr>
        <tr style="height:18px;"></tr>
				
		<tr class="smallFormLabel"><td id="confEmaillabel">Re-enter New Address*</td></tr>
		<tr style="height:7px;"></tr>
        <tr><td class="input-incwd"><input type="text" name="confirmEmail" autocomplete="off" id="conEmail" onkeyup = "CheckFirstChar(event.keyCode, this);confirmEmailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="confirmEmailValidation()"></td></tr>
        <tr style="height:20px;"></tr>
            
        <tr><td><h4 class="pull-left" style="height: 35px; margin-bottom: -10px">		            
		<button class="submit-button" type="submit" onclick="return validation();" onMouseOver="document.getElementById('email-sub-but').src='resources/images/SSImgs/SaveEmailMOImg.png';" onMouseOut="document.getElementById('email-sub-but').src='resources/images/SSImgs/SaveEmailImg.png';" ><img id="email-sub-but" src="resources/images/SSImgs/SaveEmailImg.png" alt=""><span class="butt-va-mid">Save Changes</span></button>
		</h4></td></tr> 
		</tbody></table>
		</div>		
		</form>		
		<div class="clearfix"></div>
		</div> </div> </div> 
		
		<div class="edit-Email">		
		<h2>Password</h2>		
		<p class="usr-pro-text">&nbsp;&nbsp;Current Password:	  &nbsp;***********</p>		
		<div class="Edit-Email-Address" id="btttn">
		<p><a class="Smallbutton" id="showInfo" data-target=".info">Edit Password</a></p>
		
		<div id="show-password" class="form-box info target" style="display: none;">
		<form action="changePassword" name="changePwdForm" autocomplete="off" method="post">
		<div class="form-group">
		<table><tbody>
		
		<c:if test="${not empty changePasswordError}">
        <tr><td><font style="color: #c00002;font-size: 14px;font-weight:normal;height: 10px;position:absolute;margin-top:5px;"><img src="resources/images/warning.gif" width="18" height="12"/>
        ${changePasswordError}</font></td></tr>
        <script type="text/javascript"> $(document).ready(function(){ $("#show-password").show(); }); </script>
        <tr style="height:32px;"></tr> </c:if>
            
		<tr class="smallFormLabel"><td id="currPwdLabel">Current Password*</td></tr>
		<tr style="height:7px;"></tr>
		<tr><td class="input-incwd"><input type="password" id="currentPassword" name="currentPassword" autocomplete="off" onkeyup = "CheckFirstChar(event.keyCode, this);currPassValidation1();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="currPassValidation1();"></td></tr>
        <tr style="height:18px;"></tr>
		
		<tr class="smallFormLabel"><td id="pwdLabel">New Password*</td></tr>
		<tr style="height:7px;"></tr>
        <tr><td class="input-incwd"><input type="password" id="newPassword" name="newPassword" autocomplete="off" onkeyup = "CheckFirstChar(event.keyCode, this);passValidation1();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="passValidation1();" onchange="passwdvalidation();"></td></tr>
        <tr style="height:18px;"></tr>
            
        <tr class="smallFormLabel"><td id="confPwdLabel">Re-enter New Password*</td>
        <tr style="height:7px;"></tr>
        <tr><td class="input-incwd"><input type="password" name="reenterPassword" autocomplete="off" id="reenterPassword" onkeyup = "CheckFirstChar(event.keyCode, this);confPassValidation1();" onkeydown = "return CheckFirstChar(event.keyCode, this);" onblur="confPassValidation1();"></td></tr>
        <tr style="height: 20px;"></tr>
        
		<tr><td><h4 class="pull-left" style="height: 35px; margin-bottom: -10px">		            
		<button class="submit-button" type="submit" onclick="return cPwdValidation();" onMouseOver="document.getElementById('pass-sub-but').src='resources/images/SSImgs/PasswordSavingMOImg.png';" onMouseOut="document.getElementById('pass-sub-but').src='resources/images/SSImgs/PasswordSavingImg.png';" ><img id="pass-sub-but" src="resources/images/SSImgs/PasswordSavingImg.png" alt=""><span class="butt-va-mid">Save Changes</span></button>
		</h4></td></tr>
		</tbody></table>
		</div>		
		</form>		
		<div class="clearfix"></div>
		</div>
		
		</div> </div> </div> </div> </div> </div> 
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
		
		<script type="text/javascript">
		$(document).ready(function () {
    	var $targets = $('.target');
    	$('#btttn .Smallbutton').click(function () {
        var $target = $($(this).data('target')).slideToggle();
        document.changeEmail.elements['newEmail'].focus();
    	document.changePwdForm.elements['currentPassword'].focus();
        $targets.not($target).hide();        
    	}); }); 
		</script>
		
		<script type="text/javascript">
		$(document).ready(function () {
    	var $targets = $('.target');
    	$('#btttn1 .Smallbutton').click(function () {
        var $target = $($(this).data('target')).slideToggle();
        document.changeEmail.elements['newEmail'].focus();
    	document.changePwdForm.elements['currentPassword'].focus();
        $targets.not($target).hide();
   		}); }); 
		</script>
		
		<script type="text/javascript">
	    $(document).ready(function(){    
	    var userProfileStRefVal = '<c:out value="${userProfileSateRefVal}"/>';
	    var userProfileFedRefVal = '<c:out value="${userProfileFedRefVal}"/>';
	    if((userProfileStRefVal > 0) || (userProfileFedRefVal > 0)){
	    	document.getElementById("userProfileRefValID").style.display='none';    	
	    } else{
	    	document.getElementById("userProfileRefValID").style.display='block';
	    }; });
	    </script>		
		
    </body>    
</html>