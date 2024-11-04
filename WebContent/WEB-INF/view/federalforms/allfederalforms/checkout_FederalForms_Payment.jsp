
<%--
    Document   : checkout_FederalForms_Payment
    Created on : 08 April, 2015, 05:18:38 PM
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
    
    <script type="text/javascript">
    window.onload=function() {    
    var promoCode = '<c:out value="${promoCode}"/>';    
    var onlyBonusPrice = '<c:out value="${onlyBonsPrice}"/>';    
    var totalBunPrice = '<c:out value="${totalBonusPrice}"/>';    
    var userEnterBonusPrice = '<c:out value="${promoCodeDB}"/>';
   
    if(userEnterBonusPrice !== null && userEnterBonusPrice !== promoCode){
    alert("The promo code you have entered is invalid. Please enter a valid promo code.");
    }
                
    if(onlyBonusPrice  > 0 && totalBunPrice  > 0){
    document.getElementById("BonusAmountDisplay").style.display='block';
    document.getElementById("DevideBarDisplay").style.display='block';
    } };    
    
    function promocodeValidation(){
        if(document.payment.promoCode.value === ""){
        alert("Please enter a promo code.");
        return false;
        }
        else{
        return true;     
        }    
        }
    
    function CheckFirstChar(key, txt){
    if(key === 32 && txt.value.length<=0){
    return false;
    }
    else if(txt.value.length>0){
    if(txt.value.charCodeAt(0) === 32){
    txt.value=txt.value.substring(1,txt.value.length);
    return true;
    }
    }
    return true;
    }
    </script>
    
    <% 
    String amount = (String)session.getAttribute("paymentTotal");    
    %> 
    </head>    
        <body>
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="nf-white-background" style="padding-bottom: 77px;">
		<div class="servicesbystate">
		<h3 class="check"> Checkout</h3>
		<div>
		<div class="services-left">
		<div class="checkout">
		
		<div class="check-out-head dotted-line-bar">
		<h3><img class="aln-st-img" src="resources/images/smallFormNameImg.png" alt="">&nbsp;${typeOfDocument}</h3>		
		<div class="clearfix"></div>
		</div><br>
		
		<ul>
		<li class="no-line-bar">Processing Fee &nbsp; <em><img id="process-que" src="resources/images/paymentQuesMarkImg.png" onMouseOver="document.getElementById('process-que').src='resources/images/paymentQuesMarkMOImg.png';" onMouseOut="document.getElementById('process-que').src='resources/images/paymentQuesMarkImg.png';" alt=""><i class="popup-box-font popup-box-adj">LegalNod's processing fee. </i></em> <span> $${processingFee}</span></li>
		<li id="BonusAmountDisplay" class="no-line-bar" style="display: none;">Discount  &nbsp;  <span> <font color="#008000"><b>-$${onlyBonsPrice}</b></font></span></li>		
		
		<li class="yes-line-bar"><h2> TOTAL Fee <span>$${paybleAmount}</span></h2></li>		
		</ul>
		
		<div class="form-box box-height-adj">
		<form action="federalFormsPomoCodeRedirection" name="payment" id="formID" method="get">
		<div class="form-group">
		<label>Promo Code</label>
		<input type="text" name="promoCode" id="bonus" onkeyup = "CheckFirstChar(event.keyCode, this);" onkeydown = "return CheckFirstChar(event.keyCode, this);" maxlength="60" style="width:235px;" >
		<h4 class="pull-right">
		<button class="promo-sub-but" style="margin-top: -15px;" type="submit" onclick="return promocodeValidation();" onMouseOver="document.getElementById('promo-sub-but').src='resources/images/SSImgs/PromocodeMOImg.png';" onMouseOut="document.getElementById('promo-sub-but').src='resources/images/SSImgs/PromocodeImg.png';" ><img id="promo-sub-but" src="resources/images/SSImgs/PromocodeImg.png" alt="">   &nbsp;Apply Promo Code</button>
		</h4>
		</div>		
		</form>
		</div>
		
		</div> </div> 
		
		<div class="row">		
		<div class="col-lg-4"><div class="abs-fed">
		<FORM NAME='formName' ID='formID' ACTION='addToCartFederalFormsData' METHOD='POST'>		
		<h4 class="pull-left">		            
		<button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return next();" onMouseOver="document.getElementById('modi-sub-but').src='resources/images/SSImgs/AddtoCartSmallMOImg.png';" onMouseOut="document.getElementById('modi-sub-but').src='resources/images/SSImgs/AddtoCartSmallImg.png';" ><img id="modi-sub-but" src="resources/images/SSImgs/AddtoCartSmallImg.png" alt=""><span class="butt-va-mid">Add to Cart</span></button>
		</h4>
		</FORM>
		</div></div> </div>
		
		</div>		
		<div class="clearfix"></div>
		</div> </div>
		</div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
        </body>        
</html>