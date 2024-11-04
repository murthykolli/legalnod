<%--
    Document   : NameReservation
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
		<div class="white-background" style="min-height: 632px;height: auto;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-3">
		
		<div class="left-accourdian" style="padding-bottom: 110px;">
		<h3>DOC CENTER</h3>
		<p><a class="com-buss" href="docCenter"> Compare Business Types  </a></p>
				
		<ul>
		<li><img src="resources/images/text-plus.gif"> <a href="LimitedLiabilityCompanyDoc"> Forming Your Business  </a></li>
		
		<li><img src="resources/images/text-plus.gif"> <a href="ForeignQualificationsDoc"> Managing Your Business  </a></li>
		
		<li><img src="resources/images/text-minus.gif"> <a class="doc-active-header" href="docCenter"> Naming Services  </a>
		<ul>
		<li><a href="NameAvailabilityCheckDoc">  Name Availability Check </a></li>
		<li><a class="doc-active-header" href="#">  Name Reservation </a></li>
		<li><a href="DoingBusinessAsDoc">  Doing Business As (DBA) </a></li> 
		</ul>	
		</li>		
		<li><img src="resources/images/text-plus.gif"> <a href="TrademarkStateRegistrationForDoc"> Trademark  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="AnnualReportsDoc"> Compliance  </a></li>
		<li><img src="resources/images/text-plus.gif"> <a href="FederalTaxIDDoc"> Additional Services  </a></li>		
		
		</ul>		
		</div><!-- left-accourdian -->
		</div>
		<div class="col-md-9">		
		<div class="comparebusiness">				
		<h2><span class="pull-left">Name Reservation</span>
		<a href="nameReservationForBS" style="text-decoration: none; outline: none;" class="pull-right view-price" onMouseOver="this.style.color='#00a9f1';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOverImg.png';" onMouseOut="this.style.color='#1c1c1c';document.getElementById('view-price').src='resources/images/SSImgs/PaymentDocMOutImg.png';"><img class="pull-left" id="view-price" src="resources/images/SSImgs/PaymentDocMOutImg.png">&nbsp;View Pricing&nbsp;</a>
		</h2>

		<p>To ensure that no one reserves or uses an available entity name before you file your business formation papers with the state, you can file a <strong>Name Reservation</strong> with the appropriate state agency to reserve the name.</p>		
		<p>The <strong>Name Availability Check</strong> allows you to check if your desired entity name is available. If the name you would like is already taken, you can submit more names to check availability. Name Availability Check alone does not guarantee that your desired name will not be secured by someone else before you file with the state.</p>
		<div class="ul-li">
		<p><b>How to Reserve a Name for your entity*:</b></p>
		<ul>
		<li>File a Name Reservation with appropriate state agency</li>
		</ul>		
		</div>
		
		<p style="text-align:right; font-style:italic">*Please note that your state's requirements may vary.</p>
		<div class="topbrdr">
		<div class="col-md-6">
		<p>Use LegalNod's <strong>FREE</strong> service to check the availability of your desired entity name. Submit up to 5 names at a time with us!</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="nameAvailabilityCheckForBS" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but1').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but1" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">Name Availability</span></button></h4>
		</form>
		</div>
		
		<div class="col-md-6">
		<p>Reserve your entity name to ensure availability at the time of filing your business formation papers!</p>
		
		<form name="docCenterFormName" id="docCenterFormId" action="nameReservationForBS" method="get">
		<h4 style="margin-top: 25px;height: 35px;">
		<button class="submit-butt-doc" type="submit" onMouseOver="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocMOImg.png';" onMouseOut="document.getElementById('doc-llc-sub-but2').src='resources/images/SSImgs/GetStartedDocImg.png';" ><img id="doc-llc-sub-but2" src="resources/images/SSImgs/GetStartedDocImg.png" alt=""><span class="butt-va-mid">Name Reservation</span></button></h4>
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