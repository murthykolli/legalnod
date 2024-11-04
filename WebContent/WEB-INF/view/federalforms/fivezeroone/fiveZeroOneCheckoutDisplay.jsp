<%--
    Document   : fiveZeroOneCheckoutDisplay
    Created on : 3 April, 2015, 12:13:12 AM
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
    var tAreaId = "";
    
    function selectVal(sId){ selectId = sId; } 
    function dateVal(dId){ dateId = dId; } 
    function textAreaVal(taId){ tAreaId = taId; }
    
    window.onload=function(){
        for(var i=0;i<980;i++){
        var attrTypeId = "attrTypeId"+i;
        var attrTypeVal = document.getElementById(attrTypeId).value;
        var attrSubTypeVal=document.getElementById("attrSubTypeId"+i).value;

        for(var j=0;j< 460;j++){
        var rbTypeId = "RB"+j;
        var cbTypeId = "CB"+j;
        var tdTypeId = "TD"+j;
        var sbTypeId = "SB"+j;
        var taTypeId = "TA"+j;
        var tfnTypeId="TFN"+j;
        
        if(attrTypeVal === rbTypeId || attrTypeVal === cbTypeId || attrSubTypeVal === tfnTypeId){
        var rbHide1 = "RbHideID"+i;
        $("#"+rbHide1).hide();
        break;
        }
    
    else if(attrTypeVal === sbTypeId){
    var sbHide = "SBHideID"+i;
    var sbStateID = "SBStateId"+i;
    $("#"+sbHide).hide();
    $("#"+sbStateID).show();
    break;
    }
    
    else if(attrTypeVal === tdTypeId){
    var sbHide1 = "SBHideID"+i;
    var sbStateID1 = "SBStateId"+i;
    var tdDateID = "TDDateId"+i;
    $("#"+sbHide1).hide();
    $("#"+sbStateID1).hide();
    $("#"+tdDateID).show();
    break;
    }
    
    else if(attrTypeVal === taTypeId){
        var sbHide2 = "SBHideID"+i;
        var sbStateID2 = "SBStateId"+i;
        var textAreaID = "TATextAreaId"+i;
        $("#"+sbHide2).hide();
        $("#"+sbStateID2).hide();
        $("#"+textAreaID).show();
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
    if($("#attrInfoId"+id).val().contains("TA")){
    var data=$("#textAreaID"+id).val();
    $("#textAreaID"+id).val("").focus().val(data);
    }
    return false;
    }
    
    function attributesSaveIds(id){
    var saveId = "SaveModeId"+id;
    var editId = "EditModeId"+id;
    var attrNameId = "attrNameId"+id;
    var attrSBNameId = "attrSBNameId"+id;
    var attrInfoId = "attrInfoId"+id;
    var datepickerId = "datepickerID"+id;
    var textAreaId = "textAreaID"+id;

    $("."+saveId).hide();
    $("."+editId).show();
    var attrbVal = document.getElementById(attrNameId).value;
    var attrType = document.getElementById(attrInfoId).value;
    var attrInfoVal = document.getElementById(attrInfoId).value;
    
    if(attrInfoVal === 'TF1' && (attrbVal.indexOf("'") !== -1 || attrbVal.indexOf('"') !== -1)){
    	alert("Your 501 App Name doesn't accept single and double quotes");        
        } else{
    if(attrSBNameId === selectId){
    attrbVal = document.getElementById(attrSBNameId).value;
    }
    else if(dateId === datepickerId){
    attrbVal = document.getElementById(datepickerId).value;
    }
    else if(tAreaId === textAreaId){
        attrbVal = document.getElementById(textAreaId).value;
        attrbVal = attrbVal.replace(/\r?\n/g, ' ');
        }
    
    if(attrbVal !== ''){
    	attrbVal = attrbVal.replace("&","$,$");
    	var attrName = attrbVal+" _ "+id+" _ "+attrType;
        newAjaxCall(attrName);
    } }
    return false;
    }
    
    function newAjaxCall(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "fzoJSonModifiedValuesUpdate?documentName="+selectedData,
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
				        alert("Your 501 App Name already exist");
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
		<h2><img class="aln-st-img" src="resources/images/FormNameImage.png" alt="">&nbsp; 501(c)(3) Application &nbsp;</h2>
		
		<div class="clearfix"></div>
		</div>		
		
        <%
        if (null != session.getAttribute("FZO_Attr_Names_CheckOutList")) {
        ArrayList attNamesFZOList = (ArrayList) session.getAttribute("FZO_Attr_Names_CheckOutList");
        if (null != attNamesFZOList && attNamesFZOList.size() > 0) {

        if (null != session.getAttribute("FZO_Attr_Values_CheckOutList")) {
        ArrayList attValueFZOList = (ArrayList) session.getAttribute("FZO_Attr_Values_CheckOutList");
        if (null != attValueFZOList && attValueFZOList.size() > 0) {

        if (null != session.getAttribute("FZO_Attr_IDs_CheckOutList")) {
        ArrayList attIdsFZOList = (ArrayList) session.getAttribute("FZO_Attr_IDs_CheckOutList");
        if (null != attIdsFZOList && attIdsFZOList.size() > 0) {

        if (null != session.getAttribute("FZO_Attr_Type_CheckOutList")) {
        ArrayList attTypeFZOList = (ArrayList) session.getAttribute("FZO_Attr_Type_CheckOutList");
        if (null != attTypeFZOList && attTypeFZOList.size() > 0) {

        if (null != session.getAttribute("FZO_Attr_Sub_Type_CheckOutList")) {
        ArrayList attSubTypeFZOList = (ArrayList) session.getAttribute("FZO_Attr_Sub_Type_CheckOutList");
        if (null != attSubTypeFZOList && attSubTypeFZOList.size() > 0) {
        %>
		
		<div class="order-display">	<br><br>	
		<table class="table table-striped">
		<tbody>
		<% for(int i=0,j=0;i<attNamesFZOList.size() && j<attValueFZOList.size();i++,j++) { %>
		
        <tr class="tr-wd-adj"><td class="heding-text-adj" style="vertical-align:middle;"><%=attNamesFZOList.get(i)%></td>
        <td class="EditModeId<%=attIdsFZOList.get(i)%> value-text-adj" style="vertical-align:middle;"><font id="EditValId<%=attIdsFZOList.get(i)%>"><%=attValueFZOList.get(j)%></font><font style="display: none;" id="ReturnId<%=attIdsFZOList.get(i)%>"><b id="ReturnValId<%=attIdsFZOList.get(i)%>"></b></font> </td>
        <td class="EditModeId<%=attIdsFZOList.get(i)%>" style="vertical-align:middle;padding-left: 17px; width: 10%;"><button class="bt-edit-color" id="RbHideID<%=i%>" type="submit" onclick="return attributesEditIds('<%=attIdsFZOList.get(i)%>');" ><span style="vertical-align: middle;">Edit</span></button></td>
        <td class="SaveModeId<%=attIdsFZOList.get(i)%>" style="display: none;">
        <font id="SBHideID<%=i%>"><input id="attrNameId<%=attIdsFZOList.get(i)%>" type="text" name="attrName" value="<%=attValueFZOList.get(j)%>" onkeyup = "CheckFirstChar(event.keyCode, this);loginEmailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></font>

        <font id="SBStateId<%=i%>" style="display: none;">
        <select id="attrSBNameId<%=attIdsFZOList.get(i)%>" name="attrName" onclick="selectVal('attrSBNameId<%=attIdsFZOList.get(i)%>')">
        <option value="<%=attValueFZOList.get(j)%>"><%=attValueFZOList.get(j)%></option>
        <option value="Alabama">Alabama</option> <option value="Alaska">Alaska</option> <option value="Arizona">Arizona</option> <option value="Arkansas">Arkansas</option> <option value="California">California</option> <option value="Colorado">Colorado</option> <option value="Connecticut">Connecticut</option> <option value="Delaware">Delaware</option> <option value="District of Columbia">District of Columbia</option>
        <option value="Florida">Florida</option> <option value="Georgia">Georgia</option> <option value="Hawaii">Hawaii</option> <option value="Idaho">Idaho</option> <option value="Illinois">Illinois</option> <option value="Indiana">Indiana</option> <option value="Iowa">Iowa</option> <option value="Kansas">Kansas</option> <option value="Kentucky">Kentucky</option> <option value="Louisiana">Louisiana</option> <option value="Maine">Maine</option>
        <option value="Maryland">Maryland</option> <option value="Massachusetts">Massachusetts</option> <option value="Michigan">Michigan</option> <option value="Minnesota">Minnesota</option> <option value="Mississippi">Mississippi</option> <option value="Missouri">Missouri</option> <option value="Montana">Montana</option> <option value="Nebraska">Nebraska</option> <option value="Nevada">Nevada</option> <option value="New Hampshire">New Hampshire</option>
        <option value="New Jersey">New Jersey</option> <option value="New Mexico">New Mexico</option> <option value="New York">New York</option> <option value="North Carolina">North Carolina</option> <option value="North Dakota">North Dakota</option> <option value="Ohio">Ohio</option> <option value="Oklahoma">Oklahoma</option> <option value="Oregon">Oregon</option> <option value="Pennsylvania">Pennsylvania</option> <option value="Rhode Island">Rhode Island</option>
        <option value="South Carolina">South Carolina</option> <option value="South Dakota">South Dakota</option> <option value="Tennessee">Tennessee</option> <option value="Texas">Texas</option> <option value="Utah">Utah</option> <option value="Vermont">Vermont</option> <option value="Virginia">Virginia</option> <option value="Washington">Washington</option> <option value="West Virginia">West Virginia</option> <option value="Wisconsin">Wisconsin</option> <option value="Wyoming">Wyoming</option>
        </select></font>

		<font id="TATextAreaId<%=i%>" style="display: none;"><textarea name="attrName" id="textAreaID<%=attIdsFZOList.get(i)%>" onkeyup="CheckFirstChar(event.keyCode, this);" onkeydown="return CheckFirstChar(event.keyCode, this);" onfocus="textAreaVal('textAreaID<%=attIdsFZOList.get(i)%>');"><%=attValueFZOList.get(j)%></textarea></font>
		
        <font id="TDDateId<%=i%>" style="display: none;"><input type="text" name="attrName" readonly="true"  class="datepicker" id="datepickerID<%=attIdsFZOList.get(i)%>" onclick="dateVal('datepickerID<%=attIdsFZOList.get(i)%>')"/></font>
        <input type="checkbox"id="check<%=i%>" style="display: none;"name="attrName" value="<%=attValueFZOList.get(j)%>" />
        <input id="RbValID<%=i%>" type="hidden" name="attrName" value="<%=attValueFZOList.get(j)%>" /> <input id="attrInfoId<%=attIdsFZOList.get(i)%>" type="hidden" name="attrInfoId" value="<%=attTypeFZOList.get(j)%>" /> &nbsp;<input id="attrTypeId<%=i%>" type="hidden" name="attrType" value="<%=attTypeFZOList.get(j)%>" style="display: none;"/> &nbsp;<input id="attrSubTypeId<%=i%>" type="hidden" name="attrType" value="<%=attSubTypeFZOList.get(j)%>" style="display: none;"/> </td>
        <td class="SaveModeId<%=attIdsFZOList.get(i)%>" width="10%" style="display: none; vertical-align: middle; padding-left: 15px;"><button class="bt-ove-color" type="submit" onclick="return attributesSaveIds('<%=attIdsFZOList.get(j)%>');" ><span style="vertical-align: middle;">Save</span></button></td></tr>
        
        <tr class="tr-whitespace-adj"><td></td></tr>
        <% } %>
		</tbody>
		</table>		
		
		<div style="margin-top: -15px;">
		<form action="fiveZeroOneCheckoutDataModification" name="checkoutDisplayForm" id="pro-form" method="get">            
				
		<h4 class="pull-left">		            
		<button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return checkoutFormModification();" onMouseOver="document.getElementById('modi-sub-but').src='resources/images/SSImgs/FormEditMOImg.png';" onMouseOut="document.getElementById('modi-sub-but').src='resources/images/SSImgs/FormEditImg.png';" ><img id="modi-sub-but" src="resources/images/SSImgs/FormEditImg.png" alt=""><span class="butt-va-mid">Modify</span></button>
		</h4>
		
		<h4 class="pull-left" style="margin-left: 20px;">		            
		<button class="ord-wt-bg-sub-but btn-height" type="submit" onclick="return goToCheckout();" onMouseOver="document.getElementById('chek-sub-but').src='resources/images/SSImgs/CheckOutPaymentMOImg.png';" onMouseOut="document.getElementById('chek-sub-but').src='resources/images/SSImgs/CheckOutPaymentImg.png';" ><img id="chek-sub-but" src="resources/images/SSImgs/CheckOutPaymentImg.png" alt=""><span class="butt-va-mid">Checkout</span></button>
		</h4>
		
		<input type="hidden" name="federalFormsCheckOutRef"/> 
        </form> 
        <div class="clearfix"></div>
		</div> </div>
		
		<div class="clearfix"></div>
		<% } } } } } } } } } } %>
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
		function checkoutFormModification(){
        document.checkoutDisplayForm.federalFormsCheckOutRef.value = "CheckoutModification";
        }
        	
        function goToCheckout(){
        document.checkoutDisplayForm.federalFormsCheckOutRef.value = "CheckoutPayment";
        }
        </script>
 
 		<script type="text/javascript" src="resources/scripts/jquery.datePicker-min.js"></script>
        <script type="text/javascript" src="resources/scripts/json-minified.js" ></script>    	
        </body>
</html>