<%--
    Document   : ConversionsNew
    Created on : 16 March, 2015, 11:41:49 AM
    Author     : MurthyK
--%>

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>    
    <head>
    <title>Conversions | legalnod.com</title>
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="LegalNod offers business conversion document for you to convert your business from one type of entity into another entity."/>
    <meta name="keywords" content="business conversion document"/>
    
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
    <link rel="canonical" href="https://www.legalnod.com/legalnod/ConversionsDocNW"/>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
		<div class="white-background" style="padding-bottom: 60px;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-3">
		
		<div class="left-accourdian" style="padding-bottom: 115px;">
		<h3>DOC CENTER</h3>
		<p><a class="com-buss" href="docCenterComBus"> Compare Business Types  </a></p>
				
		<ul>
		<li><img src="resources/images/text-plus.gif"> <a href="LimitedLiabilityCompanyDocNW"> Forming Your Business  </a></li>
		
		<li><img src="resources/images/text-minus.gif"> <a class="doc-active-header" href="docCenterComBus"> Managing Your Business  </a>
		<ul>
		<li><a href="ForeignQualificationsDocNW">  Foreign Qualifications </a></li>
		<li><a href="AmendmentsChangesDocNW">  Amendments/Changes </a></li>
		<li><a href="DissolutionsTerminationsDocNW">  Dissolutions/Terminations </a></li> 
		<li><a href="NameChangeDocNW">  Name Change </a></li>
		<li><a class="doc-active-header" href="#">  Conversions </a></li>
		</ul>	
		</li>		
		
		<li><img src="resources/images/text-plus.gif"> <a href="NameAvailabilityCheckDocNW"> Naming Services  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="TrademarkStateRegistrationDocNW"> Trademark  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="AnnualReportsDocNW"> Compliance  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="FederalTaxIDDocNW"> Additional Services  </a></li>		
		
		</ul>		
		</div><!-- left-accourdian -->
		</div>
		<div class="col-md-9">		
		<div class="comparebusiness">				
		<h2><span class="pull-left">Conversions</span>
		<a href="#" style="text-decoration: none; outline: none;" class="pull-right view-price" onMouseOver="this.style.color='#00a9f1';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOverImg.png';" onMouseOut="this.style.color='#1c1c1c';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOutImg.png';"><img class="pull-left" id="view-price" src="resources/images/SSImgs/PaymentDocMOutImg.png">&nbsp;View Pricing&nbsp;</a>
		</h2>

		<p>Conversion allows you to convert your business from one type of entity into another entity. You may find it necessary to convert your entity type for various reasons including, tax purposes or for raising capital.</p>
		<p>Not all states support conversions. In states that don't support conversion, you will be required to dissolve your existing entity and form a new one, as well as obtain a new Federal Tax ID (EIN Number).</p>
		
		<p class="docCenterText" style="margin-left: 0px;margin-top: 15px;width: 640px;">
        <font size="3px;">States that support conversions:</font>&nbsp;
        
        <select id="stateNameId" name="stateName" style="height:25px;width:250px;background-color: white;border-color: #f4f4f4;border-radius: 2px;box-shadow: 3px 3px 1px gray;border: solid 1px #595959; -webkit-appearance: none;">
        <option value="">----------Select State Name----------</option>
	    <c:forEach var="statesList" items="${stateList}">
	    <option value="${statesList.stateName}">${statesList.stateName}</option>
	    </c:forEach>	        
	    </select></p>
        
        
		<div class="ul-li">
		<p><b>How to convert your business from one entity type to another*:</b></p>
		<ul>
		<li>File for a Conversion with appropriate state agency or</li>
		<li>Dissolve old entity and form a new one</li>
		</ul>		
		</div>
		
		<p style="text-align:right; font-style:italic">*Please note that your state's requirements may vary.</p>
		<div class="topbrdr">
		<div class="col-md-6">
		<p>If your state supports <strong>Conversions</strong>, filing for one is the easiest way to change your business from one entity type to another.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="#" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but1" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">File for a Conversion</span></button></h4>
		</form>
		</div>
		
		<div class="col-md-6">
		<p>If your state does not support Conversions, you will be required to <strong>dissolve</strong> your old business in order to change entity type.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="#" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but2" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">File for a Dissolution</span></button></h4>
		</form>
		</div>
		
		</div>			
		</div><!--   End comparebusiness  -->
		</div> </div> </div> 
		<div class="clearfix"></div>
		
		</div> </div> <!-- white Bg -->
		
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
		</script>
		</body>
</html>