<%--
    Document   : CCorporation
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
		<div class="white-background" style="padding-bottom: 60px;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-3">
		
		<div class="left-accourdian" style="padding-bottom: 105px;">
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
		<li><a class="doc-active-header" href="#">  C Corporation </a></li>
		<li><a href="SCorpDoc">  S Corporation </a></li>
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
		<h2><span class="pull-left">C Corporation</span>
		<a href="cCorporationForBS" style="text-decoration: none; outline: none;" class="pull-right view-price" onMouseOver="this.style.color='#00a9f1';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOverImg.png';" onMouseOut="this.style.color='#1c1c1c';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOutImg.png';"><img class="pull-left" id="view-price" src="resources/images/SSImgs/PaymentDocMOutImg.png">&nbsp;View Pricing&nbsp;</a>
		</h2>

		<p>A <strong>C Corporation</strong> is a regular corporation that limits personal liability for business debts. C corporations are taxed separately from its owners. This means that they are double taxation entities; the corporation pays tax on its income and its shareholders also pay tax on their income from the corporation. Creating and running a corporation requires following strict corporate formalities.</p>		
		<div class="ul-li">
		<p><b>How to form a C Corporation*:</b></p>
		<ul>
		<li>Choose a Corporate name</li>
		<li>File "Articles of Incorporation"</li>
		<li>Set up a Corporate Records Book</li>
		<li>Prepare Corporate Bylaws (<i>recommended but not legally required</i>)</li>
		<li>Appoint initial corporate Directors</li>
		<li>Issue Stock (<i>most small corporations are exempt</i>)</li>
		<li>Comply with Annual Report requirements</li>		
		<li>Obtain necessary licenses and permits for your business</li>		
		<li>Obtain a Federal Tax ID (EIN) from the IRS</li>				
		</ul>		
		</div>
		
		<p style="text-align:right; font-style:italic">*Please note that your states requirements may vary.</p>
		<div class="topbrdr">
		<p>When you form a C Corporation using LegalNods services, we offer you additional free services which include <strong>Business Name Availability Check</strong> as well as obtaining your <strong>Federal Tax ID (EIN)</strong> for your business.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="cCorporationForBS" method="get">
		<h4 class="pull-left" style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">Form a C Corporation</span></button></h4>
		</form>
		</div>			
		</div><!--   End comparebusiness  -->
		</div> </div> </div> 
		<div class="clearfix"></div>
		
		</div> </div> </div> <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
        </body>    
</html>