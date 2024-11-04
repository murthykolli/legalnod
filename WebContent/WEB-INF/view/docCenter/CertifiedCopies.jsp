<%-- 
    Document   : CertifiedCopies
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
		<div class="white-background" style="min-height: 598px;height: auto;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-3">
		
		<div class="left-accourdian" style="padding-bottom: 0px;">
		<h3>DOC CENTER</h3>
		<p><a class="com-buss" href="docCenter"> Compare Business Types  </a></p>
				
		<ul>
		<li><img src="resources/images/text-plus.gif"> <a href="LimitedLiabilityCompanyDoc"> Forming Your Business  </a></li>
		
		<li><img src="resources/images/text-plus.gif"> <a href="ForeignQualificationsDoc"> Managing Your Business  </a></li>
		
		<li><img src="resources/images/text-plus.gif"> <a href="NameAvailabilityCheckDoc"> Naming Services  </a></li>				
		<li><img src="resources/images/text-plus.gif"> <a href="TrademarkStateRegistrationForDoc"> Trademark  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="AnnualReportsDoc"> Compliance  </a></li>
		<li><img src="resources/images/text-minus.gif"> <a class="doc-active-header" href="docCenter"> Additional Services  </a>
		<ul>
		<li><a href="FederalTaxIDDoc">  Federal Tax ID (EIN) </a></li>
		<li><a href="StateTaxIDDoc">  State Tax ID </a></li>
		<li><a href="501c3ApplicationDoc">  501(c)(3) Application </a></li>
		<li><a href="CertificateOfGoodStandingForDoc">  Certificate of Good Standing </a></li>
		<li><a class="doc-active-header" href="#">  Certified Copies </a></li>
		<li><a href="ReinstatementOfBusinessForDoc">  Reinstatement of Business </a></li>
		<li><a href="RegisteredAgentForDoc">  Registered Agent </a></li> 
		</ul>	
		</li>		
		
		</ul>		
		</div><!-- left-accourdian -->
		</div>
		<div class="col-md-9">		
		<div class="comparebusiness">				
		<h2><span class="pull-left">Certified Copies</span>
		<a href="certifiedCopiesForBS" style="text-decoration: none; outline: none;" class="pull-right view-price" onMouseOver="this.style.color='#00a9f1';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOverImg.png';" onMouseOut="this.style.color='#1c1c1c';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOutImg.png';"><img class="pull-left" id="view-price" src="resources/images/SSImgs/PaymentDocMOutImg.png">&nbsp;View Pricing&nbsp;</a>
		</h2>

		<p>A <strong>Certified Copy</strong> is a true and exact copy of your company's official documents that have been filed with the Secretary of State.</p><br>		
		
		<div class="topbrdr">
		<p><strong>LegalNod</strong> can order a certified copy of any filed document on record with the Secretary of State for you!</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="certifiedCopiesForBS" method="get">
		<h4 class="pull-left" style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">Obtain Certified Copy</span></button></h4>
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