<%--
    Document   : SoleProprietorship
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
		<div class="white-background" style="min-height: 636px;height: auto;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-3">
		
		<div class="left-accourdian" style="padding-bottom: 0px;">
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
		<li><a href="SCorpDoc">  S Corporation </a></li>
		<li><a class="doc-active-header" href="#">  Sole Proprietorship </a></li>
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
		<h2><span class="pull-left">Sole Proprietorship</span>
		<a href="doingBusinessAsForBS" style="text-decoration: none; outline: none;" class="pull-right view-price" onMouseOver="this.style.color='#00a9f1';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOverImg.png';" onMouseOut="this.style.color='#1c1c1c';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOutImg.png';"><img class="pull-left" id="view-price" src="resources/images/SSImgs/PaymentDocMOutImg.png">&nbsp;View Pricing&nbsp;</a>
		</h2>

		<p>A <strong>Sole Proprietorship</strong> is a business entity that is owned and operated by one person. Generally there is no legal distinction between the owner and the business. A sole proprietor is personally liable for all business losses and debts and reports all business income and losses on his or her individual income tax return.</p>		
		<div class="ul-li">
		<p><b>How to form a Sole Proprietorship*:</b></p>
		<ul>
		<li>Register your business name if different from legal name</li>
		<li>Obtain necessary licenses and permits for your business</li>
		</ul>		
		</div>
		
		<p style="text-align:right; font-style:italic">*Please note that your state's requirements may vary.</p>
		<div class="topbrdr">
		<p>Filing a <strong>DBA (Doing Business As)</strong> allows you to register a business name for your sole proprietorship and conduct official business under that name. You will also be able to open a bank account under the business name.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="doingBusinessAsForBS" method="get">
		<h4 class="pull-left" style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">File a DBA</span></button></h4>
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