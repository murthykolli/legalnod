<%--
    Document   : S_Corporation
    Created on : 20 February, 2014, 2:59:35 PM
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
    <link rel="stylesheet" type="text/css" href="resources/css/popupwindow.css" />
    
    <script type="text/javascript">
    function validation(){    	
    	var formName = "S Corporation";        
        var result=true;        
        if(formName !== ""){        
    	newAjaxPriceCall(formName);
    	result = false;
        }
        return result;
        }
    
    function newAjaxPriceCall(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonFederalFormsSelectionForPrice?formCategoty="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {				
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);		
				$.lz.Alert({type:"",title:"<img class='aln-st-img' src='resources/images/smallFormNameImg.png'> S Corporation",
						    content:"<font color='#9400D3'>LegalNod </font>Process fee <font style='margin-left: 62px;'>:</font> <font style='color:#00A9F1; margin-left: 63px;font-size: 15px;'><font color='#000'>$ </font><b>"+data[0].jFedPriceList+"</b></font><br> " +
						   "Our process fee is the lowest.  If you find any other low price, we will reduce <font color='#228B22'><b>5%</b></font> on our process fee. <br><br>", effect:"slideDown,bigger",formID:"sCorpFormId"});
				} }); }
    </script>
    </head>    
        <body>
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-background" style="min-height: 580px;height: auto;">
		<div class="servicesbystate">
		<div>
		<div class="services-left">
		<h2 class="busServHeading"> S Corporation</h2>
		<p class="bs-dropdown-LMText"> Learn more about S Corporations at the  &nbsp;<a href="SCorpDoc" onMouseOver="this.style.color='#3c3c3c';" onMouseOut="this.style.color='#00a9f1';">DOC CENTER</a></p>
		
		<div style="margin-left: 0px;margin-top: 0px;">
		<div id="BackgroundShowID" style="margin-left: 140px; margin-top: -280px;  width: auto;position: absolute;color:#00a9f1;font: bold 1.2em/1.25em Georgia;white-space: nowrap;display: none;">
		<div style="margin-left: 35px;margin-top: 12px;width:200px;" id="showImage"></div> </div></div>
		<div class="price-box bus-drodown">
		 
		<p class="bsDollarSymbol">$</p>
		<p class="bsPrice">49</p>
		<p class="bsStateFeeText">&nbsp; </p> </div>
		<div class="bsarrowstext">
		<p><img id="dropdown-federal" src="resources/images/SSImgs/TextPointerImg.png"><a href="FederalTaxIDDoc" onMouseOver="document.getElementById('dropdown-federal').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onMouseOut="document.getElementById('dropdown-federal').src='resources/images/SSImgs/TextPointerImg.png';">  Apply for your Federal Tax ID (EIN) for <font class="text-doc">FREE</font> when you <br>form your business with us </a></p>
		<p><img id="dropdown-doccenter" src="resources/images/SSImgs/TextPointerImg.png"><a href="docCenter" onMouseOver="document.getElementById('dropdown-doccenter').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onMouseOut="document.getElementById('dropdown-doccenter').src='resources/images/SSImgs/TextPointerImg.png';">  Learn more and compare types of businesses at the <br><font class="text-doc">DOC CENTER</font></a></p>
		<p><img id="dropdown-newreqdoc" src="resources/images/SSImgs/TextPointerImg.png"><a href="newRequestDoc" target="_blank" onMouseOver="document.getElementById('dropdown-newreqdoc').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onMouseOut="document.getElementById('dropdown-newreqdoc').src='resources/images/SSImgs/TextPointerImg.png';"><font class="bs-text-adj">  Look no further and request a Custom Document</font></a></p>
		</div> </div>  
		
		<div class="state-doucment-inner">
		<div class="dropdown-documents dropdown-micro">
		<h2>S Corp Formation</h2>
		<div class="form-selected">		
		<form name="sCorpFormName" id="sCorpFormId" action="sCorpFormCreation" method="get">
		<table class="form-group">
		<tbody>
		<tr><td><input type="hidden" name="typeOfDocument" value="SCorporation" /></td></tr>  
		
		<tr><td><h4 class="pull-left" style="height: 35px;">
		<button class="submit-button" type="submit" onclick="return validation();" onMouseOver="document.getElementById('ser-by-state-but').src='resources/images/SSImgs/GetStartedMOImg.png';" onMouseOut="document.getElementById('ser-by-state-but').src='resources/images/SSImgs/GetStartedImg.png';" ><img id="ser-by-state-but" src="resources/images/SSImgs/GetStartedImg.png" alt=""><span class="butt-va-mid">Get Started</span></button></h4>
		</td></tr></tbody></table>
		</form>
		</div> </div><br>
		<p class="ser-text-font"> &nbsp;<br> All available services for your state might not be displayed here. Please select <a href="servicesByState" onmouseout="this.style.color='#00a9f1';" onmouseover="this.style.color='blue';" style="color: #00a9f1;text-decoration: underline;outline: none;">Services by State</a> to view all.</p>
		</div>
		
		<div class="clearfix"></div>		
		</div>
				
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
 
 		<script type="text/javascript" src="resources/scripts/popupwindow.js"></script>
 		</body>        
</html>