<%--
    Document   : customDocument
    Created on : 20 February, 2014, 2:59:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Request Document - New Request Document Creation | legalnod.com</title>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
    
<link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="resources/css/modern-business.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="resources/css/style.css" rel="stylesheet">
<!-- font CSS -->
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <c:if test="${not empty customDocument}">    
    <script type="text/javascript"> function rec(){window.alert('Thank you for requesting a document. We will get back to you shortly.');window.close();} </script>
    </c:if>
     
    <script type = "text/javascript">
    window.onload = function onloadfunction(){
    document.request.elements['name'].focus();
    rec();
    document.request.name.value="";
    document.request.email.value="";
    document.request.comment.value="";   
    document.request.phone.value=""; 
    };
    
    function CheckFirstChar(key, txt){ if(key === 32 && txt.value.length<=0){ return false; }
    else if(txt.value.length>0){ if(txt.value.charCodeAt(0) === 32){ txt.value=txt.value.substring(1,txt.value.length); return true; } } return true; }    
    function validation(){
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
    var reg1 =  /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var reg2=/^\(?(\d{3})\)?[-]?(\d{3})[-]?(\d{4})$/;
    var name=document.request.name.value;
    var email=document.request.email.value;
    var comment=document.request.comment.value;
    var phone=document.request.phone.value;
    var result = true;    
    if(reg.test(name)){
    document.getElementById("namelabel").removeAttribute("class");
    } else{
    document.getElementById("namelabel").setAttribute("class","redTestDisplay");
    result=false;
    } 
    if(reg1.test(email)){
    document.getElementById("emaillabel").removeAttribute("class");
    } else{
    document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
    result=false;
    } 
    if(comment!=""){
    document.getElementById("doclabel").removeAttribute("class");
    } else{
    document.getElementById("doclabel").setAttribute("class","redTestDisplay");
    result=false;
    } 
    if(reg2.test(phone) && phone!="000-000-0000"){
    document.getElementById("phonelabel").removeAttribute("class");
    } else{
    document.getElementById("phonelabel").setAttribute("class","redTestDisplay");
    result=false;
    } 
    if(reg.test(name) && reg1.test(email) && comment!=="" && reg2.test(phone) && phone!="000-000-0000"){
    rec();
    } 
    return result;
    }

    function nameValidation(){
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
    var name=document.request.name.value;
    if(reg.test(name)){
    document.getElementById("namelabel").removeAttribute("class");
    } else{
    document.getElementById("namelabel").setAttribute("class","redTestDisplay");
    if(name===""){
    document.getElementById("namelabel").removeAttribute("class");
    }; }; }

    function emailValidation(){
    var reg1 = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var email=document.request.email.value;
    if(reg1.test(email)){
    document.getElementById("emaillabel").removeAttribute("class");
    } else{
    document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
    if(email===""){
    document.getElementById("emaillabel").removeAttribute("class");
    }; }; }

    function phoneValidation(){
    var reg2=/^\(?(\d{3})\)?[-]?(\d{3})[-]?(\d{4})$/;
    var phone=document.request.phone.value;
    if(reg2.test(phone)){
    document.getElementById("phonelabel").removeAttribute("class");
    } else{
    document.getElementById("phonelabel").setAttribute("class","redTestDisplay");
    if(phone===""){
    document.getElementById("phonelabel").removeAttribute("class");
    }; }; }

    function documentValidation(){
    var comment=document.request.comment.value;
    if(comment!==""){
    document.getElementById("doclabel").removeAttribute("class");
    } else{
    document.getElementById("doclabel").setAttribute("class","redTestDisplay");
    if(comment===""){
    document.getElementById("doclabel").removeAttribute("class");
    }; }; }

    function phoneFormat (e,input) {
    evt = e || window.event; /* firefox uses reserved object e for event */
    var pressedkey = evt.which || evt.keyCode;
    var BlockedKeyCodes = new Array(0,8,27,13,9); //8 is backspace key
    var len = BlockedKeyCodes.length;
    var block = false;
    var str = '';
    for (i=0; i<len; i++){
    str=BlockedKeyCodes[i].toString();
    if (str.indexOf(pressedkey) >=0 ) block=true;
    }
    if (block) return true;
    s = input.value;
    if (s.charAt(0) ==='+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{}ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var i;
    var returnString = '';
    for (i = 0; i < s.length; i++) {
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length <  12 )) {
    if (returnString.length===3) returnString +='-';
    if (returnString.length==7) returnString +='-';
    returnString += c;
    }; }
    input.value = returnString;
    return false;
    }

    function numberonly(e, decimal) {
    var key;
    var keychar;
    if (window.event) {
    key = window.event.keyCode;
    } else if (e) {
    key = e.which;
    } else {
    return true;
    }    
    keychar = String.fromCharCode(key);
    if ((key===null) || (key===0) || (key===8) ||  (key===9) || (key===13) || (key===27) ) {
    return true;
    } else if ((("0123456789").indexOf(keychar) > -1)) {
    return true;
    } else if (decimal && (keychar === ".")) {
    return true;
    } else if (keychar === "-") {
    return true;
    } else
    return false;
    }
    </script>
</head>
		<body>
		<!-- Navigation -->
		<header>
		  <div class="container">
		    <div class="row">
		      <div class="col-md-3 col-xs-4 col-sm-12">
		        <div class="logo"> <a href="#"><img src="resources/images/legalnodLogoImg.png" class="img-responsive"></a> </div>
		      </div>      
		    </div>
		  </div>
		</header>
		<nav class="navbar navbar-inverse">  
		</nav>
		<!-- Navigation -->

        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-background">
		<div class="customdocument">
		<div class="left-div" style="padding-bottom: 85px;">
		<h2> REQUEST A DOCUMENT</h2>
		
		<p> Legal Nod is continuously expanding its document database. However, if the document you are looking for is not yet available, you can make a request for it.</p>
		
		<p> We will get back to you in ONE BUSINESS DAY! You will be notified as to whether we can create a document for you at this time. If we decide to create your document, it will be ready for you in two to three business days.</p>
		
		<p> Requesting the document on your part and creating the document on our part will cost you nothing. You only pay for the document if you decide to purchase it!</p>
		
		<p><b style="color: #2c2c2c;"> Don't waste time searching for what you want! Make a request and have a document created just for you!</b></p>
		
		</div>
		<div class="right-div">
		<div class="form-box">
			<form name="request" id="requestFormId" action="newReqDocInfoSending" method="get">		
			<table class="form-group"> <tbody>
			<tr class="smallFormLabel"><td id="namelabel">Name</td></tr> <tr style="height: 5px;"></tr>
		    <tr><td><input type="text" name="name" onblur="nameValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);nameValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr><tr style="height: 10px;"></tr>
            <tr style="height: 5px;"><td></td></tr>
            <tr class="smallFormLabel"><td id="emaillabel">Email</td></tr> <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="email" onblur="emailValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);emailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr><tr style="height: 10px;"></tr>
            <tr style="height: 5px;"><td></td></tr>
            <tr class="smallFormLabel"><td id="phonelabel">Phone</td></tr> <tr style="height: 5px;"></tr>
            <tr><td><input type="text" name="phone" maxLength="12" id="ph" onchange="phoneValidation();" onblur="phoneValidation();" onkeyup="phoneValidation();return phoneFormat (event,ph)" onkeypress="return numberonly(event,false)"/></td></tr><tr style="height: 15px;"></tr>           
            <tr class="smallFormLabel"><td id="doclabel">Document Requested</td></tr>    
            <tr class="smallFormLabel"><td>(Please be as specific as possible)</td></tr>
            <tr><td> <textarea name="comment" cols="35" rows="8" onblur="documentValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);documentValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></textarea></td></tr><tr style="height: 10px;"></tr>
            </tbody></table>		
			<h4 class="custm-btn pull-right">
			<button class="white-bg-sub-but" type="submit" onclick="return validation();" onMouseOver="document.getElementById('cust-doc-but').src='resources/images/SSImgs/SendButtonMOImg.png';" onMouseOut="document.getElementById('cust-doc-but').src='resources/images/SSImgs/SendButtonImg.png';" ><img id="cust-doc-but" src="resources/images/SSImgs/SendButtonImg.png" alt=""><span class="butt-va-mid">Request</span></button></h4>
			</form> 

		</div> </div>		
		<div class="clearfix"></div>		
		</div> </div> 
		
		<!-- Footer coding start -->		
		<footer style="height: 120px;">		
		</footer>
		<!-- Footer coding end -->
		
		</div>
		</div>
		<!-- /.contaner -->	
		</div>
		<!-- row -->
		
		<!-- jQuery --> 
		<script src="resources/js/jquery.js"></script> 
		<!-- Bootstrap Core JavaScript --> 
		<script src="resources/js/bootstrap.min.js"></script> 
		<!-- Navigation --> 
		<script src="resources/js/jquery.slicknav.js"></script> 
		<script type="text/javascript">
		$(document).ready(function(){
		$('#menu').slicknav();
		});
		</script>
		</body>
</html>