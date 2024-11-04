<%--
    Document   : NameChange
    Created on : 19 February, 2014, 2:59:35 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<html>    
    <head>
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="description" content="Planning for Corporate Name Change. LegalNod helps you to make a name change for your business by doing a free preliminary search."/>
    <meta name="keywords" content="business name change, corporate name change, corporation formation"/>
    
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=sessionTimeOut" />
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
    <link rel="canonical" href="https://www.legalnod.com/legalnod/NameChangeDoc"/>
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
		
		<div class="left-accourdian" style="padding-bottom: 122px;">
		<h3>DOC CENTER</h3>
		<p><a class="com-buss" href="docCenter"> Compare Business Types  </a></p>
				
		<ul>
		<li><img src="resources/images/text-plus.gif"> <a href="LimitedLiabilityCompanyDoc"> Forming Your Business  </a></li>
		
		<li><img src="resources/images/text-minus.gif"> <a class="doc-active-header" href="docCenter"> Managing Your Business  </a>
		<ul>
		<li><a href="ForeignQualificationsDoc">  Foreign Qualifications </a></li>
		<li><a href="AmendmentsChangesDoc">  Amendments/Changes </a></li>
		<li><a href="DissolutionsTerminationsDoc">  Dissolutions/Terminations </a></li> 
		<li><a class="doc-active-header" href="#">  Name Change </a></li>
		<li><a href="ConversionsDoc">  Conversions </a></li>
		</ul>	
		</li>		
		
		<li><img src="resources/images/text-plus.gif"> <a href="NameAvailabilityCheckDoc"> Naming Services  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="TrademarkStateRegistrationForDoc"> Trademark  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="AnnualReportsDoc"> Compliance  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="FederalTaxIDDoc"> Additional Services  </a></li>		
		
		</ul>		
		</div><!-- left-accourdian -->
		</div>
		<div class="col-md-9">		
		<div class="comparebusiness">				
		<h2><span class="pull-left">Name Change</span>
		<a href="nameChangeForBS" style="text-decoration: none; outline: none;" class="pull-right view-price" onMouseOver="this.style.color='#00a9f1';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOverImg.png';" onMouseOut="this.style.color='#1c1c1c';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOutImg.png';"><img class="pull-left" id="view-price" src="resources/images/SSImgs/PaymentDocMOutImg.png">&nbsp;View Pricing&nbsp;</a>
		</h2>

		<p>In order to make a Name Change for your business you will have to update the articles for your Corporation or LLC. An "Articles of Amendment" or "Certificate of Change" must be filed with the state of formation. Along with changing the name of your business, filing an amendment will give you the opportunity to make any additional necessary changes such as: addition or removal of members, managers, or officers, change in registered agent, change in address, and other entity details filed in the articles.</p>		
		<div class="ul-li">
		<p><b>How to make a Corporate Name Change*:</b></p>
		<ul>
		<li>Get approval from the state before using the new name</li>
		<li>If the name is unavailable, you must select another name</li>
		<li>File the Articles of Amendment or Certificate of Change</li>
		<li>Notify the IRS and other state agencies about the change</li>
		</ul>		
		</div>
		
		<p style="text-align:right; font-style:italic">*Please note that your state's requirements may vary.</p>
		<div class="topbrdr">
		<div class="col-md-6">
		<p>If you are filing an <strong>Amendment</strong> to change the name of your business, we do a <strong>Free Preliminary Search</strong> to check the availability of the name.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="amendmentsForBS" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but1" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">File an Amendment</span></button></h4>
		</form>
		</div>
		
		<div class="col-md-6">
		<p>If you want to do business under a different name, filing a <strong>DBA</strong> with the state/county where you plan to use the new name is an alternative option.</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="doingBusinessAsForBS" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but2" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">File a DBA</span></button></h4>
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