<%--
    Document   : SCorporation
    Created on : 19 February, 2014, 2:59:35 PM
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
		<div class="white-background" style="min-height: 641px;height: auto;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-3">
		
		<div class="left-accourdian" style="padding-bottom: 5px;">
		<h3>DOC CENTER</h3>
		<p><a class="com-buss" href="docCenter"> Compare Business Types  </a></p>
		<ul>
		<li><img src="resources/images/text-minus.gif"> <a class="doc-active-header" href="docCenter"> Forming Your Business  </a>
		<ul>
		<li><a href="LimitedLiabilityCompanyDoc">  Limited Liability Company </a></li>
		<li><a href="LimitedPartnershipDoc">  Limited Partnership </a></li>
		<li><a href="LimitedLiabilityPartnershipDoc">  Limited Liability Partnership </a></li> 
		<li><a href="ProfessionalCorpDoc">  Professional Corporation </a></li>
		<li><a href="NonProfitCorpDoc">  Non-Profit Corporation </a></li>
		<li><a href="CCorpDoc">  C Corporation </a></li>
		<li><a class="doc-active-header" href="#">  S Corporation </a></li>
		<li><a href="soleProprietorshipForBS">  Sole Proprietorship </a></li>
		<li><a href="generalPartnershipForBS">  General Partnership </a></li>
		</ul>		
		
		</li>
		<li><img src="resources/images/text-plus.gif"> <a href="ForeignQualificationsDoc"> Managing Your Business  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="NameAvailabilityCheckDoc"> Naming Services  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="TrademarkStateRegistrationForDoc"> Trademark  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="AnnualReportsDoc"> Compliance  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="FederalTaxIDDoc"> Additional Services  </a></li>		
		
		</ul>		
		</div><!-- left-accourdian -->
		</div>
		<div class="col-md-9">		
		<div class="comparebusiness">				
		<h2><span class="pull-left">S Corporation</span>
		<a href="sCorporationForBS" style="text-decoration: none; outline: none;" class="pull-right view-price" onMouseOver="this.style.color='#00a9f1';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOverImg.png';" onMouseOut="this.style.color='#1c1c1c';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOutImg.png';"><img class="pull-left" id="view-price" src="resources/images/SSImgs/PaymentDocMOutImg.png">&nbsp;View Pricing&nbsp;</a>
		</h2>

		<p>In an <strong>S Corporation,</strong> the corporation's profits or losses are passed through to its shareholders. Shareholders are not subject to self-employment taxes in an S Corporation. In order to form an S Corporation, you must first create a regular corporation (also known as a C Corporation). Once a regular corporation has been created, the corporation must meet strict requirements set forth by the federal government and hold a valid election and file with the IRS to form an S Corporation.</p>		
		<div class="ul-li">
		<p><b>How to obtain S Corporation status*:</b></p>
		<ul>
		<li>Your business must be an existing domestic corporation</li>
		<li>The corporation must meet strict requirements</li>
		<li>File "Form 2553 Election by a Small Business Corporation" signed by all shareholders</li>
		</ul>		
		</div>
		
		<p style="text-align:right; font-style:italic">*Please note that your state's requirements may vary.</p>
		<div class="topbrdr">
		<div class="col-md-6">
		<p>In order to form an S Corporation, your business must be an <strong>existing corporation</strong>. Start by forming your corporation with us.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="cCorporationForBS" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but1" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">Form a Corporation</span></button></h4>
		</form>
		</div>
		
		<div class="col-md-6">
		<p>If your business is already an existing corporation, LegalNod can help you obtain <strong>S Corporation</strong> status.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="sCorporationForBS" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but2" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">S Corp Election</span></button></h4>
		</form>
		</div>
		
		</div>			
		</div><!--   End comparebusiness  -->
		</div> </div> </div> 
		<div class="clearfix"></div>
		
		</div> </div> </div> <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
        </body>    
</html>