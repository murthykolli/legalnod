<%--
    Document   : free_FederalTaxHome_Redirection
    Created on : 14 April, 2015, 2:59:35 PM
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
    <link href="resources/css/build.css" rel="stylesheet">
    
    <script type="text/javascript">
    $(function() {
    var $el = $('#fixdiv');
    var $window = $(window);
    var top = $el.parent().position().top;
    $window.bind("scroll resize", function() {
    var scrollTop = $window.scrollTop();
    if (scrollTop < top - 50) {
    $el.css({top: (top+50 - scrollTop) + "px",bottom: "auto"});
    } else if($(window).scrollTop() + $(window).height() > $(document).height()-120) {
    $el.css({top: "-220px", bottom: "auto" });
    } else {
    $el.css({top: 0, bottom: "auto" });
    } }).scroll();});    
    </script>
    </head>    
        <body>        
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="nf-white-background">
		<div class="docCenter docCenter2">
		<div>
		<div class="row">		
		<div class="col-md-9"><br>
		
		<div class="alabama" style="height: 300px;">
		<div class="alabama-head">
		<h2>Federal Tax ID (EIN)&nbsp;</h2>
		
		<div class="clearfix"></div>
		</div>		
		
		<div class="principal free-fed-frame-width">		
		<form action="federalTaxIDCreation" method="post" name="lltAL" id="pro-form" >
        
        <p>A <b>Federal Tax Identification Number</b> is also known as an <b>Employer Identification Number</b>. The EIN is a unique number issued by the Internal Revenue Service to business entities operating in the United States for identification purposes.</p><br>
        
        <p>Obtain your Federal Tax ID (EIN) for <font color="#00a9f1"><b>FREE</b></font> when you form your business with LegalNod!</p><br><br>
        
        <p>Do you want to apply for a Federal Tax ID?</p>
        
        <font class="radio radio-info radio-inline"><input type="radio" name="federalRadioButtonSel" value="Yes" onclick="window.location='freeFederalTaxFormCreation';"/> <label>Yes</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="radio" name="federalRadioButtonSel" value="No" onclick="window.location='goToStateFormCheckoutDataDisplay';" /> <label>No</label> </font>
        
		</form>		
		</div>
		<div class="clearfix"></div>
		</div>
		
		<div class="bottom-bg">
		<img src="resources/images/CornerFoldImg.png" alt="" class="img-responsive">
		</div> <!--   End alabama  -->
		</div>
		
		<div class="col-md-3">	
		<div class="fed-right-side1">
		<div id="fixdiv" class="fixed-right-side">			
		
		<div class="right-fixdiv">		
		<h2><a href="docCenterComBus" target="_blank" onmouseover="document.getElementById('doc-new-img').src='resources/images/SSImgs/DocCenterMOImg.png';" onmouseout="document.getElementById('doc-new-img').src='resources/images/SSImgs/DocCenterImg.png';" ><img id="doc-new-img" class="aln-st-img" src="resources/images/SSImgs/DocCenterImg.png" alt=""> Doc Center</a></h2>
		<p class="side-fx-font">Visit our Doc Center and learn more about each document.</p>		
		</div><!-- right-fixdiv -->		
		<div class="right-fixdiv">		
		<h2><img class="aln-st-img" src="resources/images/SSImgs/LiveSupportImg.png" alt=""> Live Support</h2>
		<p class="side-fx-font">Check out our Live Support tab at the top of the page. Leave us a message if you catch us offline.</p>		
		</div><!-- right-fixdiv -->
		<div class="right-fixdiv">		
		<h2><a href="contactUsNew" target="_blank"  onmouseover="document.getElementById('cont-new-img').src='resources/images/SSImgs/MessageUsMOImg.png';" onmouseout="document.getElementById('cont-new-img').src='resources/images/SSImgs/MessageUsImg.png';"><img id="cont-new-img" class="aln-st-img" src="resources/images/SSImgs/MessageUsImg.png" alt=""> Message Us</a></h2>		
		</div><!-- right-fixdiv -->
		</div><!-- fixed-right-side -->
		</div><!--  right-side1 -->
		</div> 
		
		</div> </div>
		<div class="clearfix"></div><br><br><br><br>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
        </body>        
</html>