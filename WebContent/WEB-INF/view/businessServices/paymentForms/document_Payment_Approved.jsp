
<%-- 
    Document   : document_Payment_Approved
    Created on : 22 April, 2014, 3:25:56 PM
    Author     : MurthyK
--%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<html>
    <head>
    <meta charset="UTF-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" />
	<meta name="description" content=""/>
    <meta name="keywords" content=""/>
    
    <meta http-equiv="refresh" content="<%= session.getMaxInactiveInterval()%>;url=/legalnod/sessionTimeOut" />    
    
    <script type="text/javascript">
    window.location.hash="";
    window.location.hash="";
    window.onhashchange=function(){window.location.hash="";}
    
    window.onload=function(){
    window.history.forward(1);
    };
    </script>
    </head>   
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-man-backgnd" style="padding-bottom: 73px;">
		<div class="docCenter">
		<div>
		<div class="row">
		<div class="col-md-10 frame-alimnt">
		<div><font id="addCartText">Payment - <font id="addCartDocCategory">Order Receipt</font></font></div>		
		<div class="clearfix"></div>
		<div class="payment-success-frame">		
		
		<div class="payment-success-head">
		<h3>Thank you for your order!</h3>		
		</div>		
		<div class="payment-success">
		<div class="dot-line-chefee-bar"></div>
				
		<p>You may print this receipt page for your records. A receipt has also been emailed to you.</p>
		
		<div class="box-frame-bar">
		<h2>Order Information</h2>
		<div class="clearfix"></div>
		</div>
		
		
		<table><tbody>
		<tr><td>Merchant: </td>  <td> LEGALNOD </td></tr>
		<tr><td>Description: </td>  <td> Legal Documents </td></tr>		
		</tbody> </table>
		<div class="solid-line-chefee-bar"></div>
		
		<table><tbody>
		<tr> <td> <b>Billing Address</b> </td>  <td> <b>Shipping Address</b> </td></tr>
		<tr> <td>${billFirstName} ${billLastName} </td>     		<td> ${shipFirstName} ${shipLastName}</td></tr>        
        <tr> <td>${billAddress} </td>                       		<td> ${shipAddress}</td></tr>
        <tr> <td>${billCity}, ${billState} ${billZip} </td>      	<td> ${shipCity}, ${shipState} ${shipZip}</td></tr>
		</tbody> </table>
		
		<div class="doubsolid-line-bar"></div>
		<div class="total-fee-adjmnt"><b>Total: US $ <font color="#00a9f1">${amount}</font></b></div>
		
		<div class="box-frame-bar" style="margin-top: 42px;">
		<h2>Payment</h2>
		<div class="clearfix"></div>
		</div>
		
		<table><tbody>
		<tr> <td>Transaction ID: </td>     		<td> ${transactionNumber}</td></tr>        
        <tr> <td>Authorization Code: </td>      <td> ${authCode}</td></tr>
        <tr> <td>Payment Method: </td>      	<td> ${accountNoWithType}</td></tr>
        <tr> <td>Payment Status: </td>      	<td> ${orderStatus}</td></tr>
		</tbody> </table>
		
		<div class="dot-line-chefee-bar" style="margin-top: 15px;"></div>		
		</div>         
                   
		<div class="clearfix"></div>
		</div> </div> </div> </div> 
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
		
        </body>   
</html>