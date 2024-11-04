<%-- 
    Document   : authorize_credit_card_Info
    Created on : 7 May, 2015, 11:21:53 AM
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
    
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=sessionTimeOut" />    
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
    <script type="text/javascript" src="resources/scripts/payment/payment_validation.js"></script>
    <link href="resources/css/build.css" rel="stylesheet">
   
           
        <script type="text/javascript">
    	$(document).ready(function(){
    	document.secureRedirectForm.elements['cardNumber'].focus();
    	var billFirstName = '<c:out value="${billFirstName}"/>'; var billLastName = '<c:out value="${billLastName}"/>'; var billAddress = '<c:out value="${billAddress}"/>';
    	var billCity = '<c:out value="${billCity}"/>'; var billState = '<c:out value="${billState}"/>'; var billZip = '<c:out value="${billZip}"/>';
    	var checkBoxStatus = '<c:out value="${checkBoxStatus}"/>';
    	
    	var shipFirstName = '<c:out value="${shipFirstName}"/>'; var shipLastName = '<c:out value="${shipLastName}"/>'; var shipAddress = '<c:out value="${shipAddress}"/>';
    	var shipCity = '<c:out value="${shipCity}"/>'; var shipState = '<c:out value="${shipState}"/>'; var shipZip = '<c:out value="${shipZip}"/>';
    	
    	if(checkBoxStatus === "on"){$("#chkCopyBill").attr("checked",true);}
    	
    	if(billFirstName !== null && billLastName !== null && billAddress !== null && billCity !== null && billState !== null && billZip !== null) {
    		$("[name=billFirstName]").val(billFirstName); $("[name=billLastName]").val(billLastName); $("[name=billAddress]").val(billAddress);
    		$("[name=billCity]").val(billCity); $("[name=billState]").val(billState); $("[name=billZip]").val(billZip);
    		
    		$("[name=shipFirstName]").val(shipFirstName); $("[name=shipLastName]").val(shipLastName); $("[name=shipAddress]").val(shipAddress);
    		$("[name=shipCity]").val(shipCity); $("[name=shipState]").val(shipState); $("[name=shipZip]").val(shipZip);
       	} });
     	</script>               
         
        <script type="text/javascript">        
        $(document).ready(function(){
        $("#chkCopyBill").click(function(){
        if($("#chkCopyBill").prop("checked")===true){
        $("#shipFName").val($("#billFName").val()); $("#shipLName").val($("#billLName").val()); $("#shipAddress").val($("#billAddress").val());
        $("#shipCity").val($("#billCity").val()); $("#shipState").val($("#billState").val()); $("#shipZip").val($("#billZip").val());
        
        if($("#shipFName").val() !== ""){ document.getElementById("shipFirstNameID").removeAttribute("class"); }
        
        if($("#shipLName").val() !== ""){ document.getElementById("shipLastNameID").removeAttribute("class"); }
        
        if($("#shipAddress").val() !== ""){ document.getElementById("shipAddressID").removeAttribute("class"); }
        
        if($("#shipCity").val() !== ""){ document.getElementById("shipCityID").removeAttribute("class"); }
        
        if($("#shipState").val() !== ""){ document.getElementById("shipStateID").removeAttribute("class"); }
        
        if($("#shipZip").val() !== ""){ document.getElementById("shipZipID").removeAttribute("class"); }        
        }
        
        else{
        $("#shipFName").val(""); $("#shipLName").val(""); $("#shipAddress").val(""); $("#shipCity").val(""); $("#shipState").val(""); $("#shipZip").val("");
        } }); });                               
        </script>
        
    </head>  
        <body>
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-man-backgnd" style="padding-bottom: 73px;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-12">
		<div><font id="myAccountText">Payment - <font id="myAccountCategory">Transaction</font></font></div> <br/>
		
		<div class="clearfix"></div>
		<div class="my-account-user-profile my-account-user-profile1">
		
		<div class="authorize">		
		<h2>Order Information </h2>		
		<h4 class="discrip"><b>Description:</b>	 Legal Documents  <span>Total: 	 US $<font color="#00a9f1">248.00</font></span></h4>
			
		<div class="payment">
		<h3>Payment</h3>
		<div class="form-box info1 target">
		
		<%
// Production KEY and ID info

        String apiLoginId = "2ZAg52nYHG5Z";
        String transactionKey = "7v5HRJc76ZW78As7";
      	
// Sandbox KEY and ID info

        //String apiLoginId = "6u3ZLR7x7";
        //String transactionKey = "6P7wx43vdX4yUX8N";
        
        String amount = (String)session.getAttribute("allDocTotalAmount");        
        %>
        		
		<form name="secureRedirectForm" id="secureRedirectFormID" action="paymentTransactionGateway" method="post">
		<div class="form-group">
		    <label for="inputEmail3" class="col-sm-2 control-label">&nbsp;</label>
		    <div class="col-sm-10" style="left: 54px; top: 5px; position: relative;">
		      <img src="resources/images/cardimgs/V.gif" alt="">
		      <img src="resources/images/cardimgs/MC.gif" alt="">
		      <img src="resources/images/cardimgs/Disc.gif" alt="">
		    </div>
		</div><br><br>		  
		  
		<table align="center" style="left: -23px; position: relative;"><tbody>
		
		<c:if test="${not empty cardMessageErrorText}">
        <tr><td></td><td><font style="color: #c00002;font-size: 14px;height: 10px;margin-top:0px;"><img src="resources/images/warning.gif" width="18" height="12"/>
        ${cardMessageErrorText}</font></td></tr>
        </c:if>
            
		<tr class="che-frm-adjs"><td id="cardNumberID" style="width: 140px; text-align: right;">Card Number*:&nbsp;</td>
			<td><input type="text" name="cardNumber" autocomplete="off" onCopy="return false" onPaste="return false" maxlength="16" onblur="cardNumberValidation();" onkeyup = "cardNumberValidation();" onkeypress="return numeralsOnly(event);" onchange="return getCreditCardType();"></td>  
		    <td class="ch-sm-fnt-ad" style="width: 270px;white-space: nowrap;"><span> &nbsp;&nbsp;(enter number without spaces or dashes)</span></td></tr>		  
		  
		<tr class="che-frm-adjs"><td id="expirationDateID" style="width: 140px; text-align: right;">Expiration Date*:&nbsp;</td>
			<td><input type="text" name="expirationDate" autocomplete="off" onCopy="return false" onPaste="return false" maxlength="4" onblur="expirationDateValidation();" onkeyup = "expirationDateValidation();" onkeypress="return numeralsOnly(event);"></td>
		    <td class="ch-sm-fnt-ad"><span> &nbsp;&nbsp;(mmyy)</span></td></tr>
		  
		<tr class="che-frm-adjs"><td id="cardCodeID" style="width: 140px; text-align: right;">Card Code*:&nbsp;</td>
		   	<td><input type="text" name="cardCode" autocomplete="off" maxlength="4" onblur="cardCodeValidation();" onkeyup = "cardCodeValidation();" onkeypress="return numeralsOnly(event);"></td>
		   	<td class="ch-sm-fnt-ad"><span>&nbsp;&nbsp;<a onclick="javascript:return PopupLink(this);" style="color:blue;outline: none;text-decoration: underline;" target="_blank" href="https://account.authorize.net/help/Miscellaneous/Pop-up_Terms/Virtual_Terminal/Card_Code.htm" onmouseout="this.style.color='blue';" onmouseover="this.style.color='#00a9f1';">What's this?</a></span></td></tr>		    
		</tbody></table>		  
		  
 <!-- Billing Address -->
		
		<h3>Billing Address</h3>
		<table align="center"> <tbody>
		<tr class="che-frm-adjs">
		 	<td id="billFirstNameID" style="width: 140px; text-align: right;">First Name*:&nbsp;</td>
		    <td><input type="text" id="billFName" style="width: 250px;" name="billFirstName" onblur="billFirstNameValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);billFirstNameValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td>		    
		  	<td id="billLastNameID" style="width: 140px; text-align: right;">Last Name*:&nbsp;</td>
		    <td><input type="text" id="billLName" style="width: 175px;" name="billLastName" onblur="billLastNameValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);billLastNameValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td></tr>
		</tbody></table>
		
		   
		<table align="center"> <tbody> 
		<tr class="che-frm-adjs"><td id="billAddressID" style="width: 140px; text-align: right;">Address*:&nbsp;</td>
			<td><input type="text" id="billAddress" name="billAddress" style="width: 565px;" onblur="billAddressValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);billAddressValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td></tr>
		    
		<tr class="che-frm-adjs"><td id="billCityID" style="width: 140px; text-align: right;">City*:&nbsp;</td>
		    <td><input type="text" id="billCity" name="billCity" style="width: 565px;" onblur="billCityValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);billCityValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td></tr>
		</tbody></table>
		
		    
		<table align="center"> <tbody>
		<tr class="che-frm-adjs"><td id="billStateID" style="width: 140px; text-align: right;">State/Province*:&nbsp;</td>
		    <td class="selectbox-look"><select id="billState" style="width: 250px;border-radius: 2px;box-shadow: 3px 3px 1px gray;" name="billState" onchange="billStateValidation();">
			<option value="">------------- Select State ------------</option>
			<c:forEach var="statesList" items="${stateList}">
			<option value="${statesList.stateName}">${statesList.stateName}</option>
			</c:forEach>	        
			</select></td>
		  	<td id="billZipID" class="che-td-adjs1" style="width: 140px; text-align: right;">Zip Code*:&nbsp;</td>
		    <td class="che-td-adjs3"><input type="text" id="billZip" style="width: 175px;" name="billZip" maxlength="5" onblur="billZipValidation();" onkeyup = "billZipValidation();" onkeypress="return numeralsOnly(event);"></td></tr>
		</tbody></table>
			  
<!-- Shipping Address -->
		  
		<h3>Shipping Address</h3>
		<div class="form-group" style="margin-top: -12px;">
			<div class=" col-sm-10">
			    <div class="checkbox checkbox-info">
			    <input type="checkbox" name="checkbox" id="chkCopyBill"><label for="checkbox4" ><span style="margin-top: 1px; possition: absolute; font-weight: normal; vertical-align: middle;color: #000;">Shipping Address is same as Billing Address</span></label>
			    </div>
		    </div>
		</div>
		  
		<table align="center" style="margin-top: 27px;"> <tbody>
		<tr class="che-frm-adjs"><td id="shipFirstNameID" style="width: 140px; text-align: right;">First Name*:&nbsp;</td>
		    <td><input type="text" id="shipFName" style="width: 250px;" name="shipFirstName" onblur="shipFirstNameValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);shipFirstNameValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td>		    
		  	<td id="shipLastNameID" style="width: 140px; text-align: right;">Last Name*:&nbsp;</td>
		    <td><input type="text" id="shipLName" style="width: 175px;" name="shipLastName" onblur="shipLastNameValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);shipLastNameValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td></tr>
		</tbody></table>
		 
		  
		<table align="center"> <tbody>  
		<tr class="che-frm-adjs"><td id="shipAddressID" style="width: 140px; text-align: right;">Address*:&nbsp;</td>
		    <td><input type="text" id="shipAddress" style="width: 565px;" name="shipAddress" onblur="shipAddressValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);shipAddressValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td></tr>
		    
		<tr class="che-frm-adjs"><td id="shipCityID" style="width: 140px; text-align: right;">City*:&nbsp;</td>
		    <td><input type="text" id="shipCity" style="width: 565px;" name="shipCity" onblur="shipCityValidation();" onkeyup = "CheckFirstChar(event.keyCode, this);shipCityValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"></td></tr>
		</tbody></table>
		   
		   
		<table align="center"> <tbody> 
		<tr class="che-frm-adjs"><td id="shipStateID" style="width: 140px; text-align: right;">State/Province*:&nbsp;</td>
		    <td class="selectbox-look"><select id="shipState" style="width: 250px;border-radius: 2px;box-shadow: 3px 3px 1px gray;" name="shipState" onchange="shipStateValidation();">
			<option value="">------------- Select State ------------</option>
			<c:forEach var="statesList" items="${stateList}">
			<option value="${statesList.stateName}">${statesList.stateName}</option>
			</c:forEach>	        
			</select></td>
		  	<td id="shipZipID" style="width: 140px; text-align: right;">Zip Code*:&nbsp;</td>
		    <td><input type="text" id="shipZip" style="width: 175px;" name="shipZip" maxlength="5" onblur="shipZipValidation();" onkeyup = "shipZipValidation();" onkeypress="return numeralsOnly(event);"></td></tr>
		</tbody></table>
		  
		<div class="bott-line-st">&nbsp; </div>
		
		<h4 style="padding-top: 10px; padding-bottom: 10px;">
		<button onmouseout="document.getElementById('next-sub-but').src='resources/images/SSImgs/GetStartedImg.png';" onmouseover="document.getElementById('next-sub-but').src='resources/images/SSImgs/GetStartedMOImg.png';" onclick="return validation();" type="submit" class="ord-wt-bg-sub-but btn-height"><span style="vertical-align: middle; margin-top: 3px;">Pay Now </span><img alt="" style="padding-left: 10px;" src="resources/images/SSImgs/GetStartedImg.png" id="next-sub-but"></button>
		</h4>
		
		<input type='hidden' name='apiLoginId' value='<%=apiLoginId%>' />
	    <input type='hidden' name='transactionKey' value='<%=transactionKey%>' />
	    <input type='hidden' name='amount' value='<%=amount%>' />
		</form>
		
		<div class="clearfix"></div>
		</div> </div> </div> </div> </div> </div> </div> 
		
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
        </body>    
</html>