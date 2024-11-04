<%--
	Document : docCenterALHeader
	Created on : 20 March, 2014, 2:59:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
	<head>
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
	 
	<script>
	(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
	(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
	m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
	})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
	ga('create', 'UA-43742301-1', 'auto');
	ga('send', 'pageview');
	</script>
	</head>
		<body>
		<!-- Navigation -->
		<header>
		  <div class="container">
		    <div class="row">
		      <div class="col-md-3 col-xs-4 col-sm-12">
		        <div class="logo"> <a href="legalNodHome"><img src="resources/images/legalnodLogoImg.png" class="img-responsive"></a> </div>
		      </div>		      
		    <div class="col-md-9 col-xs-8 col-sm-12 text-right">
        	<div class="abb">
        	<span id="AddPaymentCartID" style="display: none;"><a href="stateAndFedFormsCartDocDisplay" class="" data-toggle="tooltip" data-placement="left" title="Documents Cart" onMouseOver="this.style.color='#00a9f1';document.getElementById('add-cart-img').src='resources/images/SSImgs/cartPaymentMOImg.png';" onMouseOut="this.style.color='#2c2c2c';document.getElementById('add-cart-img').src='resources/images/SSImgs/cartPaymentImg.png';"><i class="img-user"><font class="prodt" id="CartCountId"></font><img src="resources/images/SSImgs/cartPaymentImg.png" id="add-cart-img"></i></a></span>
         	<span><i class="img-user glyphicon glyphicon-phone-alt" id="usr-con-img"></i><a href="contactUs" onMouseOver="document.getElementById('usr-con-img').style.color='#3c3c3c';" onMouseOut="document.getElementById('usr-con-img').style.color='#00a9f1';">Contact Us</a></span>
          	<span><i class="img-user glyphicon glyphicon-cog" id="usr-pro-imh"></i><a href="editUserProfile" onMouseOver="document.getElementById('usr-pro-imh').style.color='#3c3c3c';" onMouseOut="document.getElementById('usr-pro-imh').style.color='#00a9f1';">User Profile</a></span>
            <span class="abc glyphicon glyphicon-headphones" id="li-supp"><i class="occIcon-25545-54803-1 live-sup" onMouseOver="document.getElementById('li-supp').style.color='#1c1c1c';" onMouseOut="document.getElementById('li-supp').style.color='#00a9f1';"></i></span>       
        	</div>
        	
	        <div class="top-login">
	        <p><i class="img-user"><img src="resources/images/logoutMO.png" id="log-out-img"></i><a href="logOut" onMouseOver="document.getElementById('log-out-img').src='resources/images/logout.png';" onMouseOut="document.getElementById('log-out-img').src='resources/images/logoutMO.png';">Logout</a></p>        
	        <p><i class="img-user"><img src="resources/images/SSImgs/MyAccountSavingImg.png" id="my-acco-img"></i><a href="userMyAccountRedirection" onMouseOver="document.getElementById('my-acco-img').src='resources/images/SSImgs/MyAccountSavingMOImg.png';" onMouseOut="document.getElementById('my-acco-img').src='resources/images/SSImgs/MyAccountSavingImg.png';">My Account </a></p>
	        <p class="font-bold"> Welcome  &nbsp;<span>${firstName}</span>&nbsp;&nbsp;</p>
	        </div>
      		</div>
		    </div>
		  </div>
		</header>
		<nav class="navbar navbar-inverse">
		  <div class="container">
		    <div class="collapse navbar-collapse js-navbar-collapse pull-right">
		      <ul id="menu" class="nav navbar-nav">
		        <li> <a href="legalNodHome">HOME</a> </li>
		        <li class="dropdown"> <a href="businessServices" class="dropdown-toggle">BUSINESS SERVICES </a> <span data-toggle="dropdown" class="caret"></span>
		          <ul class="dropdown-menu">
		            <li class="col-sm-4">
		              <div>
		                <ul>
		                  <li class="dropdown-header">FORMING YOUR BUSINESS</li>
		                  <li><a href="limitedLiabilityCompanyForBS">Limited Liability Company</a></li>
		                  <li><a href="limitedPartnershipForBS">Limited Partnership</a></li>
		                  <li><a href="limitedLiabilityPartnershipForBS">Limited Liability Partnership</a></li>
		                  <li><a href="cCorporationForBS">C Corporation/ General Corporation</a></li>
		                  <li><a href="sCorporationForBS">S Corporation</a></li>
		                  <li><a href="professionalCorporationForBS">Professional Corporation</a></li>
		                  <li><a href="nonProfitCorporationForBS">Non-Profit Corporation</a></li>
		                  <li><a href="soleProprietorshipForBS">Sole Proprietorship</a></li>
		                  <li><a href="generalPartnershipForBS">General Partnership</a></li>
		                  <li class="learnmore"><a href="docCenter">Learn More:<br>
		                    Compare Your Options</a></li>
		                </ul>
		              </div>
		            </li>
		            <li class="col-sm-4">
		              <div>
		                <ul>
		                  <li class="dropdown-header">MANAGING YOUR BUSINESS</li>
		                  <li><a href="foreignQualificationsForBS">Foreign Qualifications</a></li>
		                  <li><a href="amendmentsForBS">Amendments/ Changes</a></li>
		                  <li><a href="dissolutionsOrTerminationsForBS">Dissolutions/ Terminations</a></li>
		                  <li><a href="nameChangeForBS">Name Change</a></li>
		                  <li><a href="conversionsForBS">Conversions</a></li>
		                  <li class="divider"></li>
		                  <li class="dropdown-header">NAMING YOUR BUSINESS</li>
		                  <li><a href="nameAvailabilityCheckForBS">Name Availability Check</a></li>
		                  <li><a href="nameReservationForBS">Name Reservation</a></li>
		                  <li><a href="doingBusinessAsForBS">Doing Business As (DBA)</a></li>
		                  <li class="divider"></li>
		                  <li class="dropdown-header">TRADEMARK</li>
		                  <li><a href="trademarkStateRegistrationForBS">Trademark State Registration</a></li>
		                </ul>
		              </div>
		            </li>
		            <li class="col-sm-4">
		              <div>
		                <ul>
		                  <li class="dropdown-header">COMPLIANCE</li>
		                  <li><a href="annualReportsForBS">Annual Report</a></li>
		                  <li><a href="initialReportsForBS">Initial Report</a></li>
		                  <li class="divider"></li>
		                  <li class="dropdown-header">ADDITIONAL SERVICES</li>
		                  <li><a href="federalTaxIDForBS">Federal Tax ID (EIN)</a></li>
		                  <li><a href="asStateTaxID">State Tax ID</a></li>
		                  <li><a href="fiveZeroOneApplicationForBS">501(c)(3) Application</a></li>
		                  <li><a href="certificateOfGoodStandingForBS">Certificate of Good Standing</a></li>
		                  <li><a href="certifiedCopiesForBS">Certified Copies</a></li>
		                  <li><a href="reinstatementOfBusinessForBS">Reinstatement of Business</a></li>
		                  <li><a href="registeredAgentForBS">Registered Agent</a></li>
		                  <li class="divider"></li>
		                  <li class="request-doc"><a href="newRequestDoc" target="_blank" id="whatLookingForId">Can't Find What You're<br/>
		                    Looking For?<br>
		                    <span id="customDocId">REQUEST A DOCUMENT</span></a></li>
		                </ul>
		              </div>
		            </li>
		          </ul>
		        </li>
		        <li><a href="servicesByState">SERVICES BY STATE</a></li>
		        <li><a href="customDocument">CUSTOM DOCUMENT</a></li>
		        <li class="dropdown active"> <a href="docCenter" class="dropdown-toggle">DOC CENTER</a> <span data-toggle="dropdown" class="caret"></span>
		          <ul class="dropdown-menu-doc-Center doc-center">
		            <li><a href="docCenter">Compare Business Types</a></li>
		            <li><a href="LimitedLiabilityCompanyDoc">Forming Your Business</a></li>
		            <li><a href="ForeignQualificationsDoc">Managing Your Business</a></li>
		            <li><a href="NameAvailabilityCheckDoc">Naming Services</a></li>
		            <li><a href="TrademarkStateRegistrationForDoc">Trademark</a></li>
		            <li><a href="AnnualReportsDoc">Compliance</a></li>
		            <li><a href="FederalTaxIDDoc">Additional Services</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		    <!-- /.nav-collapse --> 		    
		  </div>
		</nav> <!-- Navigation -->
		<!-- jQuery --> 
		<script src="resources/js/jquery.js"></script> 
		<!-- Bootstrap Core JavaScript --> 
		<script src="resources/js/bootstrap.min.js"></script> 
		<!-- Navigation --> 
		<script src="resources/js/jquery.slicknav.js"></script> 
		<script type="text/javascript">
		$(document).ready(function(){		
		var cartDocCount = '<c:out value="${noOfDocInCart}"/>';
	    document.getElementById("CartCountId").innerHTML = cartDocCount;
	    if(cartDocCount > 0){
	    $("#AddPaymentCartID").show();    
	    } 
	    $('#menu').slicknav();
		});

		$(function () {
		$('[data-toggle="tooltip"]').tooltip();
		});
		</script>
		
		<script type="text/javascript">
		(function() {
		var occ = document.createElement('script'); occ.type = 'text/javascript'; occ.async = true;
		occ.src = 'resources/scripts/liveSupport.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(occ, s); })();
		</script>
		</body>
</html>