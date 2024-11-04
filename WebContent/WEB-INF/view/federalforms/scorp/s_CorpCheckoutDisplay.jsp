<%--
    Document   : s_CorpCheckoutDisplay
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
    for(var i=0;i<150;i++){
    var attrTypeId = "attrTypeId"+i;
    var attrTypeVal = document.getElementById(attrTypeId).value;

    for(var j=0;j< 100;j++){
    var rbTypeId = "RB"+j;
    var sbTypeId = "SB"+j;
    var tdTypeId = "TD"+j;
    var cbTypeId = "CB"+j;
    var taTypeId = "TA"+j;
    
    if(attrTypeVal === rbTypeId || attrTypeVal === cbTypeId || attrTypeVal === "SB5" || attrTypeVal === "SB6" || attrTypeVal === "SB8" || attrTypeVal === "SB9" || attrTypeVal === "SB11" || attrTypeVal === "SB12" || attrTypeVal === "SB14" || attrTypeVal === "SB15" || attrTypeVal === "SB17" || attrTypeVal === "SB18" || attrTypeVal === "SB20" || attrTypeVal === "SB21"){
    var rbHide1 = "RbHideID"+i;
    $("#"+rbHide1).hide();
    break;
    }
    
    else if(attrTypeVal === sbTypeId){
    var sbHide = "SBHideID"+i;
    var sbStateID = "SBStateId"+i;
    if(attrTypeVal === "SB1" || attrTypeVal === "SB2" || attrTypeVal === "SB3" || attrTypeVal === "SB4" || attrTypeVal === "SB7" || attrTypeVal === "SB10" || attrTypeVal === "SB13" ||attrTypeVal === "SB16" ||attrTypeVal === "SB19" ||attrTypeVal === "SB22" ||attrTypeVal === "SB23"){
    $("#"+sbHide).hide();
    $("#"+sbStateID).show();
    break;
    } }

    else if(attrTypeVal === tdTypeId || attrTypeVal === "TF20" || attrTypeVal === "TF27" || attrTypeVal === "TF34" || attrTypeVal === "TF41" || attrTypeVal === "TF48"|| attrTypeVal === "TF55"){
    var sbHide1 = "SBHideID"+i;
    var sbStateID1 = "SBStateId"+i;
    var tdDateID = "TDDateId"+i;
    $("#"+sbHide1).hide();
    $("#"+sbStateID1).hide();
    $("#"+tdDateID).show();
    break;
    }
    
    else if(attrTypeVal === cbTypeId){
    var sbHide2 = "SBHideID"+i;
    var sbStateID2 = "SBStateId"+i;
    var tdDateID1 = "TDDateId"+i;
    $("#"+sbHide2).hide();
    $("#"+sbStateID2).hide();
    $("#"+tdDateID1).show();
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
    editId = "EditModeId"+id;
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
    	alert("Your S-Corporation Name doesn't accept single and double quotes"); 
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
			url : "sCorpJSonModifiedValuesUpdate?documentName="+selectedData,
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
				        alert("Your S-Corporation Name already exist");
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
		<h2><img class="aln-st-img" src="resources/images/FormNameImage.png" alt="">&nbsp; S Corporation &nbsp;</h2>
		
		<div class="clearfix"></div>
		</div>		
		
        <% 
        if (null != session.getAttribute("SCorp_Attr_Names_CheckOutList")) {
        ArrayList attNamesSCorpList = (ArrayList) session.getAttribute("SCorp_Attr_Names_CheckOutList");
        if (null != attNamesSCorpList && attNamesSCorpList.size() > 0) {

        if (null != session.getAttribute("SCorp_Attr_Values_CheckOutList")) {
        ArrayList attValueSCorpList = (ArrayList) session.getAttribute("SCorp_Attr_Values_CheckOutList");
        if (null != attValueSCorpList && attValueSCorpList.size() > 0) {

        if (null != session.getAttribute("SCorp_Attr_IDs_CheckOutList")) {
        ArrayList attIdsSCorpList = (ArrayList) session.getAttribute("SCorp_Attr_IDs_CheckOutList");
        if (null != attIdsSCorpList && attIdsSCorpList.size() > 0) {

        if (null != session.getAttribute("SCorp_Attr_Type_CheckOutList")) {
        ArrayList attTypesSCorpList = (ArrayList) session.getAttribute("SCorp_Attr_Type_CheckOutList");
        if (null != attTypesSCorpList && attTypesSCorpList.size() > 0) {
        %>
		
		<div class="order-display">	<br><br>	
		<table class="table table-striped">
		<tbody>
		<% for(int i=0,j=0;i<attNamesSCorpList.size() && j<attValueSCorpList.size();i++,j++) { %>
		
        <tr class="tr-wd-adj"><td class="heding-text-adj" style="vertical-align:middle;"><%=attNamesSCorpList.get(i)%></td>
        <td class="EditModeId<%=attIdsSCorpList.get(i)%> value-text-adj" style="vertical-align:middle;"><font id="EditValId<%=attIdsSCorpList.get(i)%>"><%=attValueSCorpList.get(j)%></font><font style="display: none;" id="ReturnId<%=attIdsSCorpList.get(i)%>"><b id="ReturnValId<%=attIdsSCorpList.get(i)%>"></b></font> </td>
        <td class="EditModeId<%=attIdsSCorpList.get(i)%>" style="vertical-align:middle;padding-left: 17px; width: 10%;"><button class="bt-edit-color" id="RbHideID<%=i%>" type="submit" onclick="return attributesEditIds('<%=attIdsSCorpList.get(i)%>');" ><span style="vertical-align: middle;">Edit</span></button></td>
        <td class="SaveModeId<%=attIdsSCorpList.get(i)%>" style="display: none;">
        <font id="SBHideID<%=i%>"><input id="attrNameId<%=attIdsSCorpList.get(i)%>" type="text" name="attrName" value="<%=attValueSCorpList.get(j)%>" onkeyup = "CheckFirstChar(event.keyCode, this);loginEmailValidation();" onkeydown = "return CheckFirstChar(event.keyCode, this);"/></font>

        <font id="SBStateId<%=i%>" style="display: none;">
        <select id="attrSBNameId<%=attIdsSCorpList.get(i)%>" name="attrName" onclick="selectVal('attrSBNameId<%=attIdsSCorpList.get(i)%>')">
        <option value="<%=attValueSCorpList.get(j)%>"><%=attValueSCorpList.get(j)%></option>
        <option value="Alabama">Alabama</option> <option value="Alaska">Alaska</option> <option value="Arizona">Arizona</option> <option value="Arkansas">Arkansas</option> <option value="California">California</option> <option value="Colorado">Colorado</option> <option value="Connecticut">Connecticut</option> <option value="Delaware">Delaware</option> <option value="District of Columbia">District of Columbia</option>
        <option value="Florida">Florida</option> <option value="Georgia">Georgia</option> <option value="Hawaii">Hawaii</option> <option value="Idaho">Idaho</option> <option value="Illinois">Illinois</option> <option value="Indiana">Indiana</option> <option value="Iowa">Iowa</option> <option value="Kansas">Kansas</option> <option value="Kentucky">Kentucky</option> <option value="Louisiana">Louisiana</option> <option value="Maine">Maine</option>
        <option value="Maryland">Maryland</option> <option value="Massachusetts">Massachusetts</option> <option value="Michigan">Michigan</option> <option value="Minnesota">Minnesota</option> <option value="Mississippi">Mississippi</option> <option value="Missouri">Missouri</option> <option value="Montana">Montana</option> <option value="Nebraska">Nebraska</option> <option value="Nevada">Nevada</option> <option value="New Hampshire">New Hampshire</option>
        <option value="New Jersey">New Jersey</option> <option value="New Mexico">New Mexico</option> <option value="New York">New York</option> <option value="North Carolina">North Carolina</option> <option value="North Dakota">North Dakota</option> <option value="Ohio">Ohio</option> <option value="Oklahoma">Oklahoma</option> <option value="Oregon">Oregon</option> <option value="Pennsylvania">Pennsylvania</option> <option value="Rhode Island">Rhode Island</option>
        <option value="South Carolina">South Carolina</option> <option value="South Dakota">South Dakota</option> <option value="Tennessee">Tennessee</option> <option value="Texas">Texas</option> <option value="Utah">Utah</option> <option value="Vermont">Vermont</option> <option value="Virginia">Virginia</option> <option value="Washington">Washington</option> <option value="West Virginia">West Virginia</option> <option value="Wisconsin">Wisconsin</option> <option value="Wyoming">Wyoming</option>
        </select></font>

		<font id="TATextAreaId<%=i%>" style="display: none;"><textarea name="attrName" id="textAreaID<%=attIdsSCorpList.get(i)%>" onkeyup="CheckFirstChar(event.keyCode, this);" onkeydown="return CheckFirstChar(event.keyCode, this);" onfocus="textAreaVal('textAreaID<%=attIdsSCorpList.get(i)%>');"><%=attValueSCorpList.get(j)%></textarea></font>
		
        <font id="TDDateId<%=i%>" style="display: none;"><input type="text" name="attrName" readonly="true" class="datepicker" id="datepickerID<%=attIdsSCorpList.get(i)%>" onclick="dateVal('datepickerID<%=attIdsSCorpList.get(i)%>')"/></font>
        <input type="checkbox"id="check<%=i%>" style="display: none;" name="attrName" value="<%=attValueSCorpList.get(j)%>" />
        <input id="RbValID<%=i%>" type="hidden" name="attrName" value="<%=attValueSCorpList.get(j)%>" /> &nbsp;<input id="attrInfoId<%=attIdsSCorpList.get(i)%>" type="hidden" name="attrInfoId" value="<%=attTypesSCorpList.get(j)%>" /> &nbsp;<input id="attrTypeId<%=i%>" type="hidden" name="attrType" value="<%=attTypesSCorpList.get(j)%>" style="display: none;"/> </td>
        <td class="SaveModeId<%=attIdsSCorpList.get(i)%>" width="10%" style="display: none; vertical-align: middle; padding-left: 15px;"><button class="bt-ove-color" type="submit" onclick="return attributesSaveIds('<%=attIdsSCorpList.get(j)%>');" ><span style="vertical-align: middle;">Save</span></button></td></tr>
        
        <tr class="tr-whitespace-adj"><td></td></tr>
        <% } %>
		</tbody>
		</table>		
		
		<div style="margin-top: -15px;">
		<form action="sCorpCheckoutDataModification" name="checkoutDisplayForm" id="pro-form" method="get">            
				
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