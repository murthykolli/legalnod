<%--
	Document : completed_StateForms__for_Admin
	Created on : 12 April, 2014, 2:59:35 PM
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
    <link rel="stylesheet" href="resources/css/admintablelayout.css" type="text/css" />
    
	<script type="text/javascript">
    $(document).ready(function(){
    	var pendingFedFormsCount = '<c:out value="${pendFedFormsCount}"/>';
    	var pendStateFormsCount = '<c:out value="${penStateFormsCount}"/>';
    	var completedFedFormsCount = '<c:out value="${completedFedFormsCount}"/>';
    	var comStateFormsCount = '<c:out value="${comFormsAdminCount}"/>';
    	
    	if(pendingFedFormsCount > 0 && completedFedFormsCount > 0){
        	$("#PendingFederalFormsID").show();
        } else if(pendingFedFormsCount > 0 && completedFedFormsCount <= 0){
        	$("#PendingFederalFormsID").show();
        } else if(completedFedFormsCount > 0 && pendingFedFormsCount <= 0){
        	$("#CompletedFedFormsID").show();
        } 
        
        if(comStateFormsCount > 0){        	
        	$("#CompletedStateFormsID").show();        	
        }
        
        if(pendStateFormsCount > 0){        	
        	$("#PendingStateFormsID").show();	
        }
    });
    	
    </script>
    
    <script type="text/javascript">
    $(document).ready(function(){
    var orderReceived = '<c:out value="${orderReceived}"/>';
    var orderProcessed = '<c:out value="${orderProcessed}"/>';
    var eSignature = '<c:out value="${eSignature}"/>';
    var docFiled = '<c:out value="${docFiled}"/>';
    var docAccepted = '<c:out value="${docAccepted}"/>';
    var docEmailed = '<c:out value="${docEmailed}"/>';
    
    if(orderReceived === "Done"){
    document.getElementById("Img1").style.display="block";
    }
    if(orderProcessed === "Done"){
    document.getElementById("Img2").style.display="block";
    }
    if(eSignature === "Done"){
    document.getElementById("Img3").style.display="block";
    }
    if(docFiled === "Done"){
    document.getElementById("Img4").style.display="block";
    }
    if(docAccepted === "Done"){
    document.getElementById("Img5").style.display="block";
    }
    if(docEmailed === "Done"){
    document.getElementById("Img6").style.display="block";
    }
    });
    </script>
    </head>    
        <body>
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-man-backgnd" style="padding-bottom: 73px;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-12">
		<div><font id="myAccountDocText">My Account - <font id="myAccountDocCategory">Completed State Forms</font></font></div>
		
		<div id="PendingStateFormsID" class="pending-federal-form" style="display: none;">
		<a href="userMyAccountRedirection"><font class="pendingfederal">&nbsp;Pending State Forms&nbsp;</font></a> </div>
		
		<div id="CompletedStateFormsID" class="editUserProfile" style="display: none;">
		<a href="#"><font class="myAccountCurrentTab">&nbsp;Completed State Forms&nbsp;</font></a> </div>
		
		<div id="PendingFederalFormsID" class="pending-federal-form" style="display: none;">
		<a href="pendingFederalFormsRedirection"><font class="pendingfederal">&nbsp;Pending Federal Forms&nbsp;</font></a> </div>
		
		<div id="CompletedFedFormsID" class="pending-federal-form" style="display: none;">
		<a href="completedFederalFormsForUser"><font class="pendingfederal">&nbsp;Completed Federal Forms&nbsp;</font></a> </div>
		
		<div class="clearfix"></div>
		<div class="my-account-pending-stats">
		<form action="completedStateFormsForUser" name="allStateFormsName" id="Documentform" method="get">		
		<h3 class="comp-adm-head-text">ORDER&nbsp;<b class="comp-adm-number">#${invoiceNum}</b>&nbsp;STATUS</h3>
		
		<div class="pendingfederal-box">		
        
        
        <table class="admtabframe"><tbody>
        <tr class="odd"><td class="tbl-td-width">Order received </td><td class="img-wdt"><b id="Img1" style="display: none"><img src="resources/images/approvedstatusImg.png" height="23" width="23"/></b></td><td>${orderReceivedCreatedDate}</td></tr>
        <tr class="even"><td class="tbl-td-width">Order processed </td><td class="img-wdt"><b id="Img2" style="display: none"><img src="resources/images/approvedstatusImg.png" height="23" width="23"/></b></td><td>${orderProcessedCreatedDate}</td></tr>
        <tr class="odd"><td class="tbl-td-width">If required, document mailed to you for your signature </td><td class="img-wdt"><b style="display: none" id="Img3"><img src="resources/images/approvedstatusImg.png" height="23" width="23"/></b></td><td>${eSignatureCreatedDate}</td></tr>
        <tr class="even"><td class="tbl-td-width">Document completed and filed </td><td class="img-wdt"><b id="Img4" style="display: none"><img src="resources/images/approvedstatusImg.png" height="23" width="23"/></b></td><td>${docFiledCreatedDate}</td></tr>
        <tr class="odd"><td class="tbl-td-width">Document accepted </td><td class="img-wdt"><b id="Img5" style="display: none"><img src="resources/images/approvedstatusImg.png" height="23" width="23"/></b></td><td>${docAcceptedCreatedDate}</td></tr>
        <tr class="even"><td class="tbl-td-width">Document mailed to you </td><td class="img-wdt"><b id="Img6" style="display: none"><img src="resources/images/approvedstatusImg.png" height="23" width="23"/></b></td><td>${docEmailedCreatedDate}</td></tr>
        </tbody></table>
        
		
		</div>
		
		<div align="center" style="margin-top: 50px;margin-left: 15px;">
		
		<h4 class="btnn3">		            
		<button class="white-bg-sub-but" type="submit" onclick="return edit();" onMouseOver="document.getElementById('uview-sub-but').src='resources/images/SSImgs/ViewOrderStatusMOImg.png';" onMouseOut="document.getElementById('uview-sub-but').src='resources/images/SSImgs/ViewOrderStatusImg.png';" ><img id="uview-sub-but" src="resources/images/SSImgs/ViewOrderStatusImg.png" alt=""><span class="butt-va-mid">View Order Status</span></button> </h4>		
				
		<div class="clearfix"></div>
		</div>		
        </form>
        <font color="white" id="text" size="3"></font>
		            
		<div class="clearfix"></div>
		</div> </div> </div> </div> 
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
			       
        </body>        
</html>