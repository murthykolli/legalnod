<%-- 
    Document   : add_To_Cart_For_AllForms
    Created on : 27 Sep, 2015, 11:21:53 AM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
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
    var totalPrice = '<c:out value="${totalAmount}"/>';
    var formatPrice = totalPrice.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    $("#TotalDocPriceId").html(formatPrice);  
    });
    
    $(function () {
    $('[data-toggle="tooltip"]').tooltip();
    });
    
    function newAjaxCall(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "deletionDocumentsFromCart?userChoice="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {							
				window.location = 'stateAndFedFormsCartDocDisplay';
			    return true;								
			} }); } 
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
		<div><font id="addCartText">Selected Documents - <font id="addCartDocCategory">Cart Info</font></font></div><br>
		
		<div class="clearfix"></div>
		<div class="my-account-pending-stats">
		
		<form name="addCartFormName" id="addCartFormID" action="">
        <% if (null != session.getAttribute("AddCartDoc_Names_List")) {
           ArrayList addCartDocList = (ArrayList) session.getAttribute("AddCartDoc_Names_List");
           if (null != addCartDocList && addCartDocList.size() > 0) {

           if (null != session.getAttribute("AddCartDoc_Price_List")) {
           ArrayList addCartPriceList = (ArrayList) session.getAttribute("AddCartDoc_Price_List");
           if (null != addCartPriceList && addCartPriceList.size() > 0) { 

           if (null != session.getAttribute("AddCartRef_Type_List")) {
           ArrayList addCartRefTypeList = (ArrayList) session.getAttribute("AddCartRef_Type_List");
           if (null != addCartRefTypeList && addCartRefTypeList.size() > 0) { 

           if (null != session.getAttribute("AddCartDoc_Type_List")) {
           ArrayList addCartDocTypeList = (ArrayList) session.getAttribute("AddCartDoc_Type_List");
           if (null != addCartDocTypeList && addCartDocTypeList.size() > 0) {    
        %>
		<div class="pendingfederal-box"><br>       
        
        <table id="t001" class="payment-cart-frame"><tbody>
        <tr> <th class="tbl-th1-width">Index </th> <th class="tbl-th2-width">Selected Documents</th> <th class="tbl-th3-width">Document Type</th> <th class="tbl-th4-width">Price</th> <th class="tbl-th5-width"><img class="add-cart-sub-but" alt="" src="resources/images/SSImgs/DeleteImage.png"></th> </tr>
        
        <% for(int i=0;i<addCartDocList.size();i++){  %>
        <tr><td class="tbl-td1-width"><%=i+1%> </td> <td><%=addCartDocList.get(i)%></td> <td class="tbl-td3-width"><%=addCartDocTypeList.get(i)%></td> <td class="tbl-td4-width">$<%=addCartPriceList.get(i)%></td> <td class="tbl-td5-width"><img src="resources/images/delete.gif" style="cursor: pointer;" class="" data-toggle="tooltip" data-placement="top" title="This item will be removed from your shopping cart, however it will still be available to you under your 'My Account' tab." onclick="return newAjaxCall('<%=addCartRefTypeList.get(i)%>');"/></td> </tr>
                
        <% } %>
        
        <tr class="total-fee-tow"><td class="tbl-td1-totalwd"> </td> <td class="tbl-td2-totalwd"> &nbsp;</td> <td class="tbl-td3-totalwd"><b>Payable Amount</b></td> <td class="tbl-td4-totalwd"><b style="color: #00a9f1;">$<font id="TotalDocPriceId" style="margin-left: 2px;"></font></b></td> <td class="tbl-td5-totalwd"></td> </tr>
        
        </tbody></table>       
		</div>
		
		<% } } } } } } } }%>		
        </form>
        
        <form action="userMyAccountRedirection.action" method="get">
        <h4 class="pull-left">		            
		<button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return prev();" onMouseOver="document.getElementById('prev-sub-but').src='resources/images/SSImgs/AddtoCartMOImg.png';" onMouseOut="document.getElementById('prev-sub-but').src='resources/images/SSImgs/AddtoCartImg.png';" ><img id="prev-sub-but" src="resources/images/SSImgs/AddtoCartImg.png" alt=""><span class="butt-va-mid">Add more forms</span></button>
		</h4>
		</form>
		
		<% String amount = (String)session.getAttribute("allDocTotalAmount"); %>
		<FORM NAME='formName' ID='formID' ACTION='authorizeCreditCardRedirection' METHOD='POST'>
		<h4 class="pull-right">
        <button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return save();" onMouseOver="document.getElementById('next-sub-but').src='resources/images/SSImgs/CheckOutPaymentMOImg.png';" onMouseOut="document.getElementById('next-sub-but').src='resources/images/SSImgs/CheckOutPaymentImg.png';" ><span style="vertical-align: middle;">Checkout</span><img id="next-sub-but" style="padding-left: 10px;" src="resources/images/SSImgs/CheckOutPaymentImg.png" alt=""></button>
		</h4>
		<INPUT TYPE='HIDDEN' NAME='amount' VALUE='<%=amount%>'>
        </FORM>       
        
                   
		<div class="clearfix"></div>
		</div> </div> </div> </div> 
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
		
        <script type="text/javascript" src="resources/scripts/json-minified.js"></script>
        </body>   
</html>