<%--
    Document : contactUs
    Created on : 20 February, 2014, 2:59:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Contact Us | Contact Info | legalnod.com</title>
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
    
    <c:if test="${not empty contactUs}">    
    <script type="text/javascript">
    function rec(){window.alert('Thank you for your comment(s) and/or question(s). We will get back to you shortly!');window.close();} 
    </script>    
    </c:if>

    <script type="text/javascript">
    window.onload = function onloadfunction(){
    document.addcontact.elements['contactName'].focus();	
    rec();
    };

    function validation(){
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
    var reg1 =  /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var name=document.addcontact.contactName.value;
    var email=document.addcontact.contactEmail.value;
    var comment=document.addcontact.contactComment.value;
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
    if(comment!==""){
    document.getElementById("doclabel").removeAttribute("class");
    } else{
    document.getElementById("doclabel").setAttribute("class","redTestDisplay");
    result=false;
    } 
    if(reg.test(name) && reg1.test(email) && comment!==""){
    rec();
    }    
    return result;
    }

    function nameValidation(){
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 -#/_().&amp;]*$/;
    var name=document.addcontact.contactName.value;
    if(reg.test(name)){
    document.getElementById("namelabel").removeAttribute("class");
    } else{
    document.getElementById("namelabel").setAttribute("class","redTestDisplay");
    }
    if(name===""){
    document.getElementById("namelabel").removeAttribute("class");
    }; }

    function emailValidation(){
    var reg1 = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.[A-Za-z]{2,}$/;
    var email=document.addcontact.contactEmail.value;
    if(reg1.test(email)){
    document.getElementById("emaillabel").removeAttribute("class");
    } else{
    document.getElementById("emaillabel").setAttribute("class","redTestDisplay");
    if(email===""){
    document.getElementById("emaillabel").removeAttribute("class");
    }; }; }

    function commentValidation(){
    var comment=document.addcontact.contactComment.value;
    if(comment!=""){
    document.getElementById("doclabel").removeAttribute("class");
    } else{
    document.getElementById("doclabel").setAttribute("class","redTestDisplay");
    if(comment===""){
    document.getElementById("doclabel").removeAttribute("class");
    }; }; }

    
    function CheckFirstChar(key, txt){
    if(key === 32 && txt.value.length<=0){ return false; }
    else if(txt.value.length>0){ if(txt.value.charCodeAt(0) === 32){ txt.value=txt.value.substring(1,txt.value.length); return true; } } return true; }
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
		<div class="white-bg">		
		<div class="row" style="margin-top: 50px;">
		<div class="col-md-6">
		
		<div class="left-login" style="min-height:460px;">
		        <div class="headingg">
		        <p id="smallFormHeading" style="margin-left: 37px;margin-top: 9px;position: absolute;">Contact Us</p> </div>
		            <form action="newContactInfoSending" name="addcontact" method="get">            
		            <table style="margin-top: 35px;margin-left: 35px;position: absolute;"> 
		            
		            <tbody><tr class="smallFormLabel"><td id="namelabel">Name</td></tr>
		            <tr style="height: 5px;"></tr>
		            <tr><td><input type="text" id="contactName" name="contactName" onblur="nameValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);nameValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr> 
		            <tr style="height: 7px;"></tr>
		            <tr class="smallFormLabel"><td id="emaillabel">Email</td></tr>
		            <tr style="height: 5px;"></tr>
		            <tr><td><input type="text" id="contactEmail" name="contactEmail" onblur="emailValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);emailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></td></tr>
		            <tr style="height: 7px;"></tr>
		            <tr class="smallFormLabel"><td id="doclabel">Comments and Questions</td></tr>
		            <tr style="height: 5px;"></tr>
		            <tr><td> <textarea id="contactComment" name="contactComment" cols="27" rows="5" onblur="commentValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);commentValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);" rows="8" cols="25" ></textarea></td></tr>
		            <tr style="height: 13px;"></tr>
		            <tr><td><h4 class="pull-left">		            
		            <button class="submit-button" type="submit" onclick="return validation();" onMouseOver="document.getElementById('cont-sub-but').src='resources/images/SSImgs/SendButtonMOImg.png';" onMouseOut="document.getElementById('cont-sub-but').src='resources/images/SSImgs/SendButtonImg.png';" ><img id="cont-sub-but" src="resources/images/SSImgs/SendButtonImg.png" alt=""><span class="butt-va-mid">Send</span></button>
					</h4></td></tr> 
		            </tbody></table>
		            </form> </div>
		  			</div>		            
		            
		        <div class="col-md-6">
		        <img src="resources/images/ContactCloudImg.png" align="right"/>		            
		        <div class="right-login" style="margin-top: 60px;">
		        <p class="loginHeading" style="white-space: nowrap;">Live Support</p>		        
		        <p class="contactus-text">LegalNod Live Support is here to assist you with any questions or concerns that you might have.</p>
		        <p class="contactus-text">Our live support tab is at the top of the page. If you find us offline, you may leave a message for us at any time and one of our representatives will get back to you as soon as possible.</p>
		        
		        <p class="loginHeading" style="margin-top: 20px;">Social Media</p>		        
		        <p class="pstyle">
		        <img src="resources/images/socialmedia/facebookImg.png"> <a class="con-hyper-text" target="_blank" href="https://www.facebook.com/legalnod" class="" data-toggle="tooltip" data-placement="right" title="Legalnod via facebook" onmouseover="this.style.color='blue';" onmouseout="this.style.color='#00a9f1';">www.facebook.com/legalnod</a><br>
		        <img src="resources/images/socialmedia/twitterImg.png"> <a class="con-hyper-text" target="_blank" href="https://www.twitter.com/legalnod" class="" data-toggle="tooltip" data-placement="right" title="Leglnod via twitter" onmouseover="this.style.color='blue';" onmouseout="this.style.color='#00a9f1';">www.twitter.com/legalnod</a><br>
		        <img src="resources/images/socialmedia/linkedinImg.png"> <a class="con-hyper-text" target="_blank" href="https://www.linkedin.com/in/silpayadla" class="" data-toggle="tooltip" data-placement="right" title="Legalnod via linkedin" onmouseover="this.style.color='blue';" onmouseout="this.style.color='#00a9f1';">www.linkedin.com/legalnod</a><br>
		        </p>
		        <p style="margin-top: 20px;"><font class="loginHeading">E-mail: </font><font style="color: #1c1c1c;font:normal 1.1em/1.5em sans-serif;">contactus@legalnod.com</font></p>
		        </div>	</div>	</div>			
		<div class="clearfix"></div>
		</div><!-- white Bg -->		
		<!-- Footer coding start -->		
		<footer style="height: 120px;">		
		</footer><!-- Footer coding end -->		
		</div> </div> <!-- /.contaner -->
		</div> <!-- row -->		
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
		
		$(function () {
		$('[data-toggle="tooltip"]').tooltip();
		});
		</script>
		</body>
</html>