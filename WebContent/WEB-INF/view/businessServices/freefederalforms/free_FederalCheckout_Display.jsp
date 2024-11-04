<%--
    Document   : Free_FederalCheckout_Display
    Created on : 14 April, 2015, 05:13:12 PM
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
    <link rel="stylesheet" type="text/css" href="resources/css/datePicker.css" />
    <link rel="stylesheet" type="text/css" href="resources/css/nicebuttonsdisplay.css" />    
       
    <script type="text/javascript">
    function CheckFirstChar(key, txt) {
    if(key === 32 && txt.value.length<=0){
    return false;
    } else if(txt.value.length>0) {
    if(txt.value.charCodeAt(0) === 32) {
    txt.value=txt.value.substring(1,txt.value.length);
    return true;
    } }    
    return true;
    }
    
    $(window).ready(function(){
    $(".datepicker").datepicker({changeMonth: true,changeYear: true});
    });
     
    var selectId="";
    var dateId = "";
    function selectVal(sId){ selectId = sId; } 
    function dateVal(dId){ dateId = dId; }
    
    window.onload=function(){
    for(var i=0;i<100;i++){
    var attrTypeId = "attrTypeId"+i;
    var attrTypeVal = document.getElementById(attrTypeId).value;

    for(var j=0;j< 100;j++){
    var rbTypeId = "RB"+j;
    var sbTypeId = "SB"+j;
    var tdTypeId = "TD"+j;
    var cbTypeId = "CB"+j;
    if(attrTypeVal === rbTypeId || attrTypeVal === cbTypeId || attrTypeVal === "SB2" || attrTypeVal === "SB3" || attrTypeVal === "SB4"){
    var rbHide1 = "RbHideID"+i;
    $("#"+rbHide1).hide();
    break;
    }
    
    else if(attrTypeVal === sbTypeId){
    var sbHide = "SBHideID"+i;
    var sbStateID = "SBStateId"+i;
    if(attrTypeVal === "SB5" || attrTypeVal === "SB6"){
    $("#"+sbHide).hide();
    $("#"+sbStateID).show();
    break;
    } }
    
    else if(attrTypeVal === tdTypeId){
    var sbHide1 = "SBHideID"+i;
    var sbStateID1 = "SBStateId"+i;
    var tdDateID = "TDDateId"+i;
    $("#"+sbHide1).hide();
    $("#"+sbStateID1).hide();
    $("#"+tdDateID).show();
    break;
    } } } };
    
    function attributesEditIds(id){
    var saveId = "SaveModeId"+id;
    var editId = "EditModeId"+id;
    var EditValId = "EditValId"+id;
    var ReturnId = "ReturnId"+id;
    var datepickerId = "datepickerID"+id;
    $("."+saveId).show();
    $("."+editId).hide();
    if(document.getElementById(ReturnId).style.display === 'none')
    document.getElementById(datepickerId).value = document.getElementById(EditValId).innerHTML;
    return false;
    }
    
    function attributesSaveIds(id){    
    var saveId = "SaveModeId"+id;
    var editId = "EditModeId"+id;
    var attrNameId = "attrNameId"+id;
    var attrSBNameId = "attrSBNameId"+id;
    var attrInfoId = "attrInfoId"+id;
    var datepickerId = "datepickerID"+id;

    $("."+saveId).hide();
    $("."+editId).show();
    var attrbVal = document.getElementById(attrNameId).value;
    var attrType = document.getElementById(attrInfoId).value;
	var attrInfoVal = document.getElementById(attrInfoId).value;
    
    if(attrInfoVal === 'TF1' && (attrbVal.indexOf("'") !== -1 || attrbVal.indexOf('"') !== -1)){
    	alert("Your Legal Name doesn't accept single and double quotes");          
        } else{
    
    if(attrSBNameId === selectId){
    attrbVal = document.getElementById(attrSBNameId).value;
    }
    else if(dateId === datepickerId){
    attrbVal = document.getElementById(datepickerId).value;
    }
    if(attrbVal!==''){
    	attrbVal = attrbVal.replace("&","$,$");
    var attrName = attrbVal+" _ "+id+" _ "+attrType;
    newAjaxCall(attrName);    
    } }
    return false;
    }
    
    function newAjaxCall(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "freeFederalJSONModifiedValuesUpdate?legalName="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].JSonObj;					
					var splitedIdValue = value.split('&&');
				    if(splitedIdValue[0] !== "null"){
				    	var editValId = "EditValId"+splitedIdValue[1];
				        var returnId = "ReturnId"+splitedIdValue[1];
				        var returnValueId = "ReturnValId"+splitedIdValue[1];
				        document.getElementById(editValId).style.display = 'none';
				        document.getElementById(returnId).style.display = 'inline-block';
				        document.getElementById(returnValueId).innerHTML = splitedIdValue[0];
				        } else{
				        alert("Your Legal Name already exist");
				        } } } }); } 
    </script>
    </head>
        <body>    
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="nf-white-background" style="padding-bottom: 75px;">
		<div class="docCenter docCenter2">
		<div>
		<div class="row">
		
		<div class="col-md-12"><br>
		<div class="orderdisplay">
		<div class="orderdisplay-head">
		<h2> Document Review -</h2>
		<h2><img class="aln-st-img" src="resources/images/FormNameImage.png" alt="">&nbsp; Federal Tax ID (EIN) &nbsp;</h2>
		
		<div class="clearfix"></div>
		</div>		
		
        <%    
        if (null != session.getAttribute("Fed_Attr_Names_CheckOutList")) {
        ArrayList attNamesFedList = (ArrayList) session.getAttribute("Fed_Attr_Names_CheckOutList");
        if (null != attNamesFedList && attNamesFedList.size() > 0) {

        if (null != session.getAttribute("Fed_Attr_Values_CheckOutList")) {
        ArrayList attValueFedList = (ArrayList) session.getAttribute("Fed_Attr_Values_CheckOutList");
        if (null != attValueFedList && attValueFedList.size() > 0) {

        if (null != session.getAttribute("Fed_Attr_IDs_CheckOutList")) {
        ArrayList attIdFedList = (ArrayList) session.getAttribute("Fed_Attr_IDs_CheckOutList");
        if (null != attIdFedList && attIdFedList.size() > 0) {

        if (null != session.getAttribute("Fed_Attr_Type_CheckOutList")) {
        ArrayList attTypeFedList = (ArrayList) session.getAttribute("Fed_Attr_Type_CheckOutList");
        if (null != attTypeFedList && attTypeFedList.size() > 0) {
        %>
		
		<div class="order-display">	<br><br>	
		<table class="table table-striped">
		<tbody>
		<% for(int i=0,j=0;i<attNamesFedList.size() && j<attValueFedList.size();i++,j++){
        %>
        <tr class="tr-wd-adj"><td class="heding-text-adj" style="vertical-align:middle;"><%=attNamesFedList.get(i)%></td>
        <td class="EditModeId<%=attIdFedList.get(i)%> value-text-adj" style="vertical-align:middle;"><font id="EditValId<%=attIdFedList.get(i)%>"><%=attValueFedList.get(j)%></font><font style="display: none;" id="ReturnId<%=attIdFedList.get(i)%>"><b id="ReturnValId<%=attIdFedList.get(i)%>"></b></font> </td>
        <td class="EditModeId<%=attIdFedList.get(i)%>" style="vertical-align:middle;padding-left: 17px; width: 10%;"><button class="bt-edit-color" id="RbHideID<%=i%>" type="submit" onclick="return attributesEditIds('<%=attIdFedList.get(i)%>');" ><span style="vertical-align: middle;">Edit</span></button></td>
        <td class="SaveModeId<%=attIdFedList.get(i)%>" style="display: none;">
        <font id="SBHideID<%=i%>"><input id="attrNameId<%=attIdFedList.get(i)%>" type="text" name="attrName" value="<%=attValueFedList.get(j)%>" onkeyup = "CheckFirstChar(event.keyCode, this);loginEmailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></font>

        <font id="SBStateId<%=i%>" style="display: none;">
        <select id="attrSBNameId<%=attIdFedList.get(i)%>" name="attrName" onclick="selectVal('attrSBNameId<%=attIdFedList.get(i)%>')">
        <option value="<%=attValueFedList.get(j)%>"><%=attValueFedList.get(j)%></option>
        <option value="Alabama">Alabama</option> <option value="Alaska">Alaska</option> <option value="Arizona">Arizona</option> <option value="Arkansas">Arkansas</option> <option value="California">California</option> <option value="Colorado">Colorado</option> <option value="Connecticut">Connecticut</option> <option value="Delaware">Delaware</option> <option value="District of Columbia">District of Columbia</option>
        <option value="Florida">Florida</option> <option value="Georgia">Georgia</option> <option value="Hawaii">Hawaii</option> <option value="Idaho">Idaho</option> <option value="Illinois">Illinois</option> <option value="Indiana">Indiana</option> <option value="Iowa">Iowa</option> <option value="Kansas">Kansas</option> <option value="Kentucky">Kentucky</option> <option value="Louisiana">Louisiana</option> <option value="Maine">Maine</option>
        <option value="Maryland">Maryland</option> <option value="Massachusetts">Massachusetts</option> <option value="Michigan">Michigan</option> <option value="Minnesota">Minnesota</option> <option value="Mississippi">Mississippi</option> <option value="Missouri">Missouri</option> <option value="Montana">Montana</option> <option value="Nebraska">Nebraska</option> <option value="Nevada">Nevada</option> <option value="New Hampshire">New Hampshire</option>
        <option value="New Jersey">New Jersey</option> <option value="New Mexico">New Mexico</option> <option value="New York">New York</option> <option value="North Carolina">North Carolina</option> <option value="North Dakota">North Dakota</option> <option value="Ohio">Ohio</option> <option value="Oklahoma">Oklahoma</option> <option value="Oregon">Oregon</option> <option value="Pennsylvania">Pennsylvania</option> <option value="Rhode Island">Rhode Island</option>
        <option value="South Carolina">South Carolina</option> <option value="South Dakota">South Dakota</option> <option value="Tennessee">Tennessee</option> <option value="Texas">Texas</option> <option value="Utah">Utah</option> <option value="Vermont">Vermont</option> <option value="Virginia">Virginia</option> <option value="Washington">Washington</option> <option value="West Virginia">West Virginia</option> <option value="Wisconsin">Wisconsin</option> <option value="Wyoming">Wyoming</option>
        </select></font>
        
        <font id="TDDateId<%=i%>" style="display: none;"><input type="text" name="attrName" readonly="true" class="datepicker" id="datepickerID<%=attIdFedList.get(i)%>" onclick="dateVal('datepickerID<%=attIdFedList.get(i)%>')"/></font>
        <input type="checkbox"id="check<%=i%>" style="display: none;"name="attrName" value="<%=attValueFedList.get(j)%>" />
        <input id="RbValID<%=i%>" type="hidden" name="attrName" value="<%=attValueFedList.get(j)%>" /> &nbsp;<input id="attrInfoId<%=attIdFedList.get(i)%>" type="hidden" name="attrInfoId" value="<%=attTypeFedList.get(j)%>" /> &nbsp;<input id="attrTypeId<%=i%>" type="hidden" name="attrType" value="<%=attTypeFedList.get(j)%>" style="display: none;"/> </td>
        <td class="SaveModeId<%=attIdFedList.get(i)%>" width="10%" style="display: none; vertical-align: middle; padding-left: 15px;"><button type="submit" class="bt-ove-color" onclick="return attributesSaveIds('<%=attIdFedList.get(j)%>');" ><span style="vertical-align: middle;">Save</span></button></td></tr>
        
        <tr class="tr-whitespace-adj"><td></td></tr>
        <% } %>
		</tbody>
		</table>		
		
		<div style="margin-top: -15px;">
		<form action="freeFederalCheckoutDataModification" name="checkoutDisplayForm" id="pro-form" method="get">            
		
		<h4 class="pull-left">		            
		<button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return revertBack();" onMouseOver="document.getElementById('back-sub-but').src='resources/images/SSImgs/TextPointerWMOPreviousImg.png';" onMouseOut="document.getElementById('back-sub-but').src='resources/images/SSImgs/TextPointerPreViousImg.png';" ><img id="back-sub-but" src="resources/images/SSImgs/TextPointerPreViousImg.png" alt=""><span class="butt-va-mid">Back</span></button>
		</h4>
		
		<h4 class="pull-left" style="margin-left: 20px;">		            
		<button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return checkoutFormModification();" onMouseOver="document.getElementById('modi-sub-but').src='resources/images/SSImgs/FormEditMOImg.png';" onMouseOut="document.getElementById('modi-sub-but').src='resources/images/SSImgs/FormEditImg.png';" ><img id="modi-sub-but" src="resources/images/SSImgs/FormEditImg.png" alt=""><span class="butt-va-mid">Modify</span></button>
		</h4>
		
		<h4 class="pull-left" style="margin-left: 20px;">
		<button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return goToStateWithFedCheckout();" onMouseOver="document.getElementById('chek-sub-but').src='resources/images/SSImgs/CheckOutPaymentMOImg.png';" onMouseOut="document.getElementById('chek-sub-but').src='resources/images/SSImgs/CheckOutPaymentImg.png';" ><img id="chek-sub-but" src="resources/images/SSImgs/CheckOutPaymentImg.png" alt=""><span class="butt-va-mid">Checkout</span></button>		            
		</h4>
		
		<input type="hidden" name="freeFederalFormsCheckOutRef"/> 
        </form> 
        <div class="clearfix"></div>
		</div> </div>
		
		<div class="clearfix"></div>
		<% } } } } } } } } %>
		</div>
		
		<div class="ord-bottom-bg">
		<img src="resources/images/CornerFoldImg.png" alt="" class="img-responsive">
		</div> <!--   End alabama  -->
		</div> </div> </div> 
		
		<div class="clearfix"></div>
		</div> 
		</div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
		
		<script type="text/javascript">
		function revertBack(){
        document.checkoutDisplayForm.freeFederalFormsCheckOutRef.value = "BackMoving";
        }
        	
        function checkoutFormModification(){
        document.checkoutDisplayForm.freeFederalFormsCheckOutRef.value = "CheckoutModification";
        }
        	
        function goToStateWithFedCheckout(){
        document.checkoutDisplayForm.freeFederalFormsCheckOutRef.value = "CheckoutPayment";
        }
        </script>
 
 		<script type="text/javascript" src="resources/scripts/jquery.datePicker-min.js"></script>
        <script type="text/javascript" src="resources/scripts/json-minified.js" ></script>    	
        </body>
</html>