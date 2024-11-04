<%--
    Document   : additionalServicesShow
    Created on : 20 February, 2014, 2:59:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<html>    
    <head>
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    
     <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=sessionTimeOut" />
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
    </head>
        <body>
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-background" style="min-height: 890px;height: auto;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-3">
		
		<div class="left-accourdian" style="padding-bottom: 320px;">
		<h3>BUSINESS SERVICES</h3>		
		<ul>
		<li><img src="resources/images/text-plus.gif"> <a href="businessServices"> Forming Your Business  </a></li>
		<li><img src="resources/images/text-plus.gif" alt=""> <a href="bsManagingYourBusiness"> Managing Your Business  </a></li>
		<li><img src="resources/images/text-plus.gif" alt=""> <a href="bsNamingYourBusiness"> Naming Services  </a></li>
		<li><img src="resources/images/text-plus.gif" alt=""> <a href="bsTrademark"> Trademark  </a></li>
		<li><img src="resources/images/text-plus.gif" alt=""> <a href="bsComplaints"> Compliance  </a></li>
		<li><img src="resources/images/text-minus.gif" alt=""> <a class="doc-active-header" href="minBsAdditionalServices"> Additional Services  </a>
		<ul>
		<li><a href="FederalTaxIDDoc">  Federal Tax ID (EIN)  </a></li>
		<li><a href="StateTaxIDDoc">  State Tax ID   </a></li>
		<li><a href="501c3ApplicationDoc">  501(c)(3) Application </a></li> 
		<li><a href="CertificateOfGoodStandingForDoc">  Certificate of Good Standing  </a></li>
		<li><a href="CertifiedCopiesForDoc">  Certified Copies  </a></li>
		<li><a href="ReinstatementOfBusinessForDoc">  Reinstatement of Business  </a></li>
		<li><a href="RegisteredAgentForDoc">  Registered Agent  </a></li>
		</ul>		
		
		</li>
		</ul>
		
		</div><!-- left-accourdian -->
		</div>
		<div class="col-md-9">
		<div class="comparebusiness">
		<h2>Additional Services </h2>
		
		<div class="formingyourbusiness">
		<ul> 
		<li> <div class="row">
		<div class="col-md-6 col-xs-5 text-right"><h4>Federal Tax ID (EIN) <small><img id="lern-more-img1" src="resources/images/SSImgs/LernMoreImg.png" alt=""> &nbsp;<a href="FederalTaxIDDoc" class="lern-more-text" onmouseover="this.style.color='#00a9f1';document.getElementById('lern-more-img1').src='resources/images/SSImgs/LernMoreMOImg.png';" onmouseout="this.style.color='#1c1c1c';document.getElementById('lern-more-img1').src='resources/images/SSImgs/LernMoreImg.png';">Learn More</a></small></h4></div>
		<div class="col-md-4 col-xs-4">
		<div class="price-box"><p class="bsDollarSymbol">$</p>
		<p class="bsPrice">19</p>		
		</div> </div>
		<div class="col-md-2 col-xs-3">
		<div class="start"><h4><a href="federalTaxIDForBS">START</a></h4></div>
		</div> </div> </li>
		
		<li> <div class="row">
		<div class="col-md-6 col-xs-5 text-right"><h4>State Tax ID <small><img id="lern-more-img2" src="resources/images/SSImgs/LernMoreImg.png" alt=""> &nbsp;<a href="StateTaxIDDoc" class="lern-more-text" onmouseover="this.style.color='#00a9f1';document.getElementById('lern-more-img2').src='resources/images/SSImgs/LernMoreMOImg.png';" onmouseout="this.style.color='#1c1c1c';document.getElementById('lern-more-img2').src='resources/images/SSImgs/LernMoreImg.png';">Learn More</a></small></h4></div>
		<div class="col-md-4 col-xs-4">
		<div class="price-box"><p class="bsDollarSymbol">$</p>
		<p class="bsPrice">39</p>
		<p class="bsStateFeeText"><b>+</b>   State Fees &nbsp; </p>
		</div> </div>
		<div class="col-md-2 col-xs-3">
		<div class="start"><h4><a href="asStateTaxID">START</a></h4></div>
		</div> </div> </li>
		
		<li> <div class="row">
		<div class="col-md-6 col-xs-5 text-right"><h4>501(c)(3) Application <small><img id="lern-more-img3" src="resources/images/SSImgs/LernMoreImg.png" alt=""> &nbsp;<a href="501c3ApplicationDoc" class="lern-more-text" onmouseover="this.style.color='#00a9f1';document.getElementById('lern-more-img3').src='resources/images/SSImgs/LernMoreMOImg.png';" onmouseout="this.style.color='#1c1c1c';document.getElementById('lern-more-img3').src='resources/images/SSImgs/LernMoreImg.png';">Learn More</a></small></h4></div>
		<div class="col-md-4 col-xs-4">
		<div class="price-box"><p class="bsDollarSymbol">$</p>
		<p class="bsPrice">119</p>
		</div> </div>
		<div class="col-md-2 col-xs-3">
		<div class="start"><h4><a href="fiveZeroOneApplicationForBS">START</a></h4></div>
		</div> </div> </li>
		
		<li> <div class="row">
		<div class="col-md-6 col-xs-5 text-right"><h4>Certificate of Good Standing <small><img id="lern-more-img4" src="resources/images/SSImgs/LernMoreImg.png" alt=""> &nbsp;<a href="CertificateOfGoodStandingForDoc" class="lern-more-text" onmouseover="this.style.color='#00a9f1';document.getElementById('lern-more-img4').src='resources/images/SSImgs/LernMoreMOImg.png';" onmouseout="this.style.color='#1c1c1c';document.getElementById('lern-more-img4').src='resources/images/SSImgs/LernMoreImg.png';">Learn More</a></small></h4></div>
		<div class="col-md-4 col-xs-4">
		<div class="price-box"><p class="bsDollarSymbol">$</p>
		<p class="bsPrice">39</p>
		<p class="bsStateFeeText"><b>+</b>   State Fees &nbsp; </p>
		</div> </div>
		<div class="col-md-2 col-xs-3">
		<div class="start"><h4><a href="certificateOfGoodStandingForBS">START</a></h4></div>
		</div> </div> </li>
		
		<li> <div class="row">
		<div class="col-md-6 col-xs-5 text-right"><h4>Certified Copies <small><img id="lern-more-img5" src="resources/images/SSImgs/LernMoreImg.png" alt=""> &nbsp;<a href="CertifiedCopiesForDoc" class="lern-more-text" onmouseover="this.style.color='#00a9f1';document.getElementById('lern-more-img5').src='resources/images/SSImgs/LernMoreMOImg.png';" onmouseout="this.style.color='#1c1c1c';document.getElementById('lern-more-img5').src='resources/images/SSImgs/LernMoreImg.png';">Learn More</a></small></h4></div>
		<div class="col-md-4 col-xs-4">
		<div class="price-box"><p class="bsDollarSymbol">$</p>
		<p class="bsPrice">39</p>
		<p class="bsStateFeeText"><b>+</b>   State Fees &nbsp; </p>
		</div> </div>
		<div class="col-md-2 col-xs-3">
		<div class="start"><h4><a href="certifiedCopiesForBS">START</a></h4></div>
		</div> </div> </li>
		
		<li> <div class="row">
		<div class="col-md-6 col-xs-5 text-right"><h4>Reinstatement of Business <small><img id="lern-more-img6" src="resources/images/SSImgs/LernMoreImg.png" alt=""> &nbsp;<a href="ReinstatementOfBusinessForDoc" class="lern-more-text" onmouseover="this.style.color='#00a9f1';document.getElementById('lern-more-img6').src='resources/images/SSImgs/LernMoreMOImg.png';" onmouseout="this.style.color='#1c1c1c';document.getElementById('lern-more-img6').src='resources/images/SSImgs/LernMoreImg.png';">Learn More</a></small></h4></div>
		<div class="col-md-4 col-xs-4">
		<div class="price-box"><p class="bsDollarSymbol">$</p>
		<p class="bsPrice">39</p>
		<p class="bsStateFeeText"><b>+</b>   State Fees &nbsp; </p>
		</div> </div>
		<div class="col-md-2 col-xs-3">
		<div class="start"><h4><a href="reinstatementOfBusinessForBS">START</a></h4></div>
		</div> </div> </li>
		
		<li> <div class="row">
		<div class="col-md-6 col-xs-5 text-right"><h4>Registered Agent <small><img id="lern-more-img7" src="resources/images/SSImgs/LernMoreImg.png" alt=""> &nbsp;<a href="RegisteredAgentForDoc" class="lern-more-text" onmouseover="this.style.color='#00a9f1';document.getElementById('lern-more-img7').src='resources/images/SSImgs/LernMoreMOImg.png';" onmouseout="this.style.color='#1c1c1c';document.getElementById('lern-more-img7').src='resources/images/SSImgs/LernMoreImg.png';">Learn More</a></small></h4></div>
		<div class="col-md-4 col-xs-4">
		<div class="price-box"><p class="bsDollarSymbol">$</p>
		<p class="bsPrice">99</p>
		<p class="bsStateFeeText"><br>   per year &nbsp; </p>
		</div> </div>
		<div class="col-md-2 col-xs-3">
		<div class="start"><h4><a href="registeredAgentForBS">START</a></h4></div>
		</div> </div> </li>		
		
		</ul> </div> 
		</div><!--   End comparebusiness  -->
		</div> </div> </div> 
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
        </body>        
</html>