<%--
	Document : stateFormModification
	Created on : 9 March, 2015, 2:59:35 PM
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
    <link href="resources/css/build.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/datePicker.css" />    
       
    <style type="text/css">
    .progress-wrap { text-align: center; font-size: 10px; color: white; margin: 0 0 20px 0; }       
    progress { width: 100%; margin: 0 0 5px 0; -webkit-appearance: none; border-radius: 25px; background-color: white; } 
    progress::-webkit-progress-bar { background-color: white; border-radius: 25px; } 
    progress::-webkit-progress-value { background-color: #00A9F1; border-radius: 15px; height: 10px; } 
    progress::-moz-progress-bar { background-image: -moz-radial-gradient(left top, ellipse closest-side, #FFFFFF 0%, #00A9F1 100%); border-radius: 25px; height: 10px; } 
    #progress{ color: #00A9F1; border-radius: 25px; height: 12px; border: 1px solid #3c3c3c; } 
    </style>
    <script type="text/javascript">
	function stopRKey(evt) {
  	var evt = (evt) ? evt : ((event) ? event : null);
  	var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null);
  	if ((evt.keyCode == 13) && ((node.type=="text") || (node.type=="radio") || (node.type=="checkbox")))  {return false;}
	}
	document.onkeypress = stopRKey;
	</script> 
	
    <script type="text/javascript">
    function enterClickBlockedInUserChoice(e) {
        e = e || window.event;
        var key = e.keyCode || e.charCode;
        return key !== 13; 
        }
    </script>

    <script type="text/javascript">    
    var $c =0;
    window.onload=function(){
    document.lltAL.elements['attributeTextField1'].focus();
    var alreadyExitChoice = '<c:out value="${AlreadyExitChoice}"/>';
    if((alreadyExitChoice !== null || alreadyExitChoice !== '') && alreadyExitChoice === "AlreadyExitUserChoice"){
    alert("Your First Choice already exist");
    } };
    
    $(window).ready(function(){
    $(".datepicker").datepicker({changeMonth: true,changeYear: true});
    });
    
    $(document).ready(function(){    	
    var hidingClassNames = '<c:out value="${RadioButtonStatus}"/>';
    hidingClassNames = hidingClassNames.replace("[","");
    hidingClassNames = hidingClassNames.replace("]","");    
    if(hidingClassNames !== ""){    
    classList=hidingClassNames.split(", ");
    for(var cl1=0;cl1<classList.length;cl1++){
    $("."+classList[cl1]).hide();
    } }
    
    var attrTFList = '<c:out value="${attributeTextFieldList}"/>';
	var attrTFAddrList = '<c:out value="${attributeTextFieldAddrList}"/>';
	var attrTFZipList = '<c:out value="${attributeTextFieldZipList}"/>';
	var attrTextAreaList = '<c:out value="${attributeTextAreaList}"/>';
	var attrTFDateList = '<c:out value="${attributeTextFieldDateList}"/>';
	var attrSBoxList = '<c:out value="${attributeSelectBoxList}"/>';
	var attrRButtonList = '<c:out value="${radioButtonList}"/>';
	var attrCheBoxList = '<c:out value="${checkBoxList}"/>';
	
	attrTFList = attrTFList.replace(/\&amp;/g,"&");
	attrTFList = attrTFList.replace(/&#034;/g,"\"");
	attrTFList = attrTFList.replace(/&#039;/g,"'");
	attrTFList = attrTFList.replace(/&lt;/g,"<");
	attrTFList = attrTFList.replace(/&gt;/g,">");
    var attrTFList1=attrTFList.split(",$,");
    for(var i=0;i<attrTFList1.length;i++){
    $("[name=attributeTextField"+(i+1)+"]").val(attrTFList1[i]) ;
    }

    var attrTFZipList1=attrTFZipList.split(",$,");
    for(var i=0;i<attrTFZipList1.length;i++){
    $("[name=attributeTextFieldZip"+(i+1)+"]").val(attrTFZipList1[i]) ;
    }

    attrTFAddrList=attrTFAddrList.replace(/\&amp;/g,"&");
    attrTFAddrList = attrTFAddrList.replace(/&#034;/g,"\"");
    attrTFAddrList = attrTFAddrList.replace(/&#039;/g,"'");
    attrTFAddrList = attrTFAddrList.replace(/&lt;/g,"<");
    attrTFAddrList = attrTFAddrList.replace(/&gt;/g,">");	
    var attrTFAddrList1=attrTFAddrList.split(",$,");
    for(var i=0;i<attrTFAddrList1.length;i++){
    $("[name=attributeTextFieldAddr"+(i+1)+"]").val(attrTFAddrList1[i]) ;
    }

    attrTextAreaList = attrTextAreaList.replace(/\&amp;/g,"&");    
    attrTextAreaList = attrTextAreaList.replace(/&#034;/g,"\"");
    attrTextAreaList = attrTextAreaList.replace(/&#039;/g,"'");
    attrTextAreaList = attrTextAreaList.replace(/&lt;/g,"<");
    attrTextAreaList = attrTextAreaList.replace(/&gt;/g,">");
    var attrTextAreaList1=attrTextAreaList.split(",$,");
    for(var i=0;i<attrTextAreaList1.length;i++){
    $("[name=attributeTextArea"+(i+1)+"]").val(attrTextAreaList1[i]) ;
    }

    var attrTFDateList1=attrTFDateList.split(",$,");
    for(var i=0;i<attrTFDateList1.length;i++){
    $("[name=attributeTextFieldDate"+(i+1)+"]").val(attrTFDateList1[i]) ;
    }

    var attrSBoxList1=attrSBoxList.split(",$,");
    for(var i=0;i<attrSBoxList1.length;i++){
    $("[name=attributeSelectBox"+(i+1)+"]").val(attrSBoxList1[i]) ;
    }

    var check;
    var cheBoxList=attrCheBoxList.split(",$,");
    for(var l=0;l<cheBoxList.length;l++){
    if(cheBoxList[l]!=="") {
    check =$("[name=checkBox"+[l+1]+"]");
    for(var k=0;k<check.length;k++){
    if(cheBoxList[l].indexOf(check[k].value)!==-1){
    check[k].checked=true;
    } } } }

    var radio;
    var attrRButtonList1=attrRButtonList.split(",$,");
    for(i=0;i<attrRButtonList1.length;i++){
    if(attrRButtonList1[i]!=="") {
    radio = $("[name=radioButton"+[i+1]+"]");
    for(var j=0;j<radio.length;j++){
    if(radio[j].value===attrRButtonList1[i]){
    radio[j].checked=true;
    $("."+radio[j].value).show();
    } } } }

    for(var c=0;c<classList.length;c++){    
    $("."+classList[c]).each(function() {
    if(this.childNodes[0].childNodes[1]){
    if(this.childNodes[0].childNodes[0].className==="no" && this.childNodes[0].childNodes[1].childNodes[0].type==="radio")  {
    var radName=this.childNodes[0].childNodes[1].childNodes[0].name;
    if($(this).css("display")!=="table-row"){
    if($("input[name="+radName+"]").is(':checked')){
    $(this).show(); $(this).prev('tr').show();$(this).prev('tr').prev('tr').show();
    } else{
    $(this).hide();$(this).prev('tr').hide();$(this).prev('tr').prev('tr').hide();
    } } } } }); }
     
    if(attrRButtonList1[206]!=="" && attrRButtonList1[206]==="officewithentity"){
    $(".noncommregagent").show();
    }
    
    if(attrRButtonList1[371]!==""){
    if(attrRButtonList1[371]==="shareholders"){
    $(".shadervotgroup").show();
    } else if(attrRButtonList1[371]==="shadervotgroup"){
    $(".shareholders").show();
    $(".votinggroup").show();
    }
    else if(attrRButtonList1[371]==="votinggroup"){
    $(".shareholders").show();
    } }
    
    if(attrRButtonList1[397]!=="" && attrRButtonList1[397]==="shadervotgroup"){
    $(".shareholders").show();
    $(".votinggroup").show();
    } 

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
    
    var boxes = $(".box"); var tabClass=$(".tab");    
    var formPageValues = '<c:out value="${stateFormPageValues}"/>';    
    if(formPageValues === ""){
    document.getElementById("form-div1").style.display='block';   
    }
    
    for(var i=0;i<boxes.length;i++){
    if(formPageValues === boxes[i].id){
    document.getElementById(boxes[i].id).style.display="block";
    $c=i;
    if($c>0){
    document.getElementById("PreviousIBID").style.display='block';
    }
    break;
    } }
      
    maxProgressCount=0;
    pageProgressCount=0;
    var lastDisplayedDiv="";
    for(var k1=0;k1<tabClass.length;k1++){
    var ele=getDisplayElements(document.getElementById(tabClass[k1].id));
    if(ele.length>0){
    maxProgressCount= maxProgressCount+1;   
    lastDisplayedDiv= boxes[k1].id;
    }
    
    if(boxes[k1].id===formPageValues){
    pageProgressCount=maxProgressCount-1; 
    }
    }
    $("#progress").prop("max",maxProgressCount);
    $("#progress").prop("value", pageProgressCount);
    
    document.getElementById("SaveIBID").style.display='block';
    if(lastDisplayedDiv===formPageValues || lastDisplayedDiv==="form-div1"){
    $("#SaveIBID").hide();
    $("#FinishIBID").show();
    }
    });
    </script>
    
    <script type="text/javascript">    
    function newAjaxCall(){
    if(document.lltAL.attributeTextField1.value !== ''){
    var userChoice1 = document.lltAL.attributeTextField1.value;
    userChoice1 = userChoice1.replace("&","$,$");
    newAjaxCallJson(userChoice1);
    } }
    
    var choiceRetValue=true;
    function newAjaxCallJson(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonFirstChoiceAbbreviationAdding?userChoice="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].UserChoice;					
					var splitedIdValue = value.split('&&');					
					if(splitedIdValue[0] !== "null"){
					document.lltAL.attributeTextField1.value = splitedIdValue[1];
					alert("Your First Choice already exist");
					choiceRetValue=false;
					} else{
					document.lltAL.attributeTextField1.value = splitedIdValue[1];
					choiceRetValue = true;
					} } } }); } 
    
    function newAjaxCallSecChoices(){
    if(document.lltAL.attributeTextField2.value !== ''){
    var userChoice2 = document.lltAL.attributeTextField2.value;
    userChoice2 = userChoice2.replace("&","$,$");
    newAjaxCallJson2(userChoice2);
    } }
    
    function newAjaxCallJson2(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonSecChoiceAbbreviationAdding?userChoice="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].UserChoice;					
					if(value !=="null"){
						document.lltAL.attributeTextField2.value = value;					
					} else{
						document.lltAL.attributeTextField2.value = value;
					} } } }); }

    function newAjaxCallThrChoices(){
    if(document.lltAL.attributeTextField3.value !== ''){
    var userChoice3 = document.lltAL.attributeTextField3.value;
    userChoice3 = userChoice3.replace("&","$,$");
    newAjaxCallJson3(userChoice3);
    } }

    function newAjaxCallJson3(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonThiChoiceAbbreviationAdding?userChoice="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].UserChoice;					
					if(value !=="null"){
						document.lltAL.attributeTextField3.value = value;				
					} else{
						document.lltAL.attributeTextField3.value = value;
					} } } }); }
    
    function newAjaxCallfortChoices(){
    if(document.lltAL.attributeTextField4.value !== ''){
    var userChoice4 = document.lltAL.attributeTextField4.value;
    userChoice4 = userChoice4.replace("&","$,$");
    newAjaxCallJson4(userChoice4);
    } }

    function newAjaxCallJson4(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonFourChoiceAbbreviationAdding?userChoice="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].UserChoice;					
					if(value !=="null"){
						document.lltAL.attributeTextField4.value = value;				
					} else{
						document.lltAL.attributeTextField4.value = value;
					} } } }); }
       
    function newAjaxCallfortAmendmentChoOne(){
    if(document.lltAL.attributeTextField103.value !== ''){
    var userChoice5 = document.lltAL.attributeTextField103.value;
    userChoice5 = userChoice5.replace("&","$,$");
    newAjaxCallJson5(userChoice5);
    } }
    
    function newAjaxCallJson5(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonFiveChoiceAbbreviationAdding?userChoice="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].UserChoice;					
					if(value !=="null"){
						document.lltAL.attributeTextField103.value = value;
					} else{
						document.lltAL.attributeTextField103.value = value;
					} } } }); }
    
    function newAjaxCallfortAmendmentChoTwo(){
    if(document.lltAL.attributeTextField104.value !== ''){
    var userChoice6 = document.lltAL.attributeTextField104.value;
    userChoice6 = userChoice6.replace("&","$,$");
    newAjaxCallJson6(userChoice6);
    } }
    
    function newAjaxCallJson6(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonSixChoiceAbbreviationAdding?userChoice="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].UserChoice;					
					if(value !=="null"){
						document.lltAL.attributeTextField104.value = value;
					} else{
						document.lltAL.attributeTextField104.value = value;
					} } } }); } 
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
		<div class="col-md-9">
		<div class="progress-wrap">
		<p class="pro-bar-font">Start <span>Finished</span></p>
		<progress max="0" value="0" id="progress"></progress>
		</div>
		<div class="alabama">
		<div class="alabama-head">
		<h2><img class="aln-st-img" src="resources/images/StateNameImage.png" alt="">&nbsp; ${stateName}  &nbsp;</h2>
		<h2><img class="aln-st-img" src="resources/images/FormNameImage.png" alt="">&nbsp; ${formName}</h2>
		
		<div class="clearfix"></div>
		</div>		
		
		<div class="principal frame-width">		
		<form action="stateFormDataSavingAndUpdatingInDB" method="post" name="lltAL" id="pro-form">
            <% if (null != session.getAttribute("Attribute_Names_List")) {
            ArrayList attNamesCorpList = (ArrayList) session.getAttribute("Attribute_Names_List");
            if (null != attNamesCorpList && attNamesCorpList.size() > 0) {

            if (null != session.getAttribute("Attribute_Values_List")) {
            ArrayList attValueCorpList = (ArrayList) session.getAttribute("Attribute_Values_List");
            if (null != attValueCorpList && attValueCorpList.size() > 0) {

            if (null != session.getAttribute("Attribute_Required_List")) {
            ArrayList attReqList = (ArrayList) session.getAttribute("Attribute_Required_List");
            if (null != attReqList && attReqList.size() > 0) {

            if (null != session.getAttribute("Attribute_RadioStatus_List")) {
            ArrayList attClassHidingList = (ArrayList) session.getAttribute("Attribute_RadioStatus_List");
            if (null != attClassHidingList && attClassHidingList.size() > 0) {

            if (null != session.getAttribute("Attribute_InnerRadio_List")) {
            ArrayList innerRadioList = (ArrayList) session.getAttribute("Attribute_InnerRadio_List");
            if (null != innerRadioList && innerRadioList.size() > 0) {      
            
            if (null != session.getAttribute("Attribute_AddAnother_List")) {
            ArrayList addanotherList = (ArrayList) session.getAttribute("Attribute_AddAnother_List");
            if (null != addanotherList && addanotherList.size() > 0) {
            %>            
            
            <div id="form-div1" class="box" style="display: none">
            <table id="form-table1" class="tab">
            <% int i=0,j=0;
            for(i=0,j=0;i<6 && i<attNamesCorpList.size() && j<6 && j<attValueCorpList.size();i++,j++){  %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <%if(i>=6 && i<attNamesCorpList.size()) { %>
            <div id="form-div2" class="box" style="display: none">
            <table id="form-table2" class="tab">
            <% for(i=6,j=6;i<21 && i<attNamesCorpList.size() && j<21 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=21 && i<attNamesCorpList.size()){ %>
            <div id="form-div3" class="box" style="display: none">
            <table id="form-table3" class="tab">
            <% for(i=21,j=21;i<36 && i<attNamesCorpList.size() && j<36 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=36 && i<attNamesCorpList.size()){ %>
            <div id="form-div4" class="box" style="display: none">
            <table id="form-table4" class="tab">
            <% for(i=36,j=36;i<51 && i<attNamesCorpList.size() && j<51 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=51 && i<attNamesCorpList.size()){ %>
            <div id="form-div5" class="box" style="display: none">
            <table id="form-table5" class="tab">
            <% for(i=51,j=51;i<66 && i<attNamesCorpList.size() && j<66 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=66 && i<attNamesCorpList.size()) { %>
            <div id="form-div6" class="box" style="display: none">
            <table id="form-table6" class="tab">
            <% for(i=66,j=66;i<81 && i<attNamesCorpList.size() && j<81 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=81 && i<attNamesCorpList.size()){ %>
            <div id="form-div7" class="box" style="display: none">
            <table id="form-table7" class="tab">
            <% for(i=81,j=81;i<96 && i<attNamesCorpList.size() && j<96 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=96 && i<attNamesCorpList.size()){ %>
            <div id="form-div8" class="box" style="display: none">
            <table id="form-table8" class="tab">
            <% for(i=96,j=96;i<111 && i<attNamesCorpList.size() && j<111 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=111 && i<attNamesCorpList.size()){ %>
            <div id="form-div9" class="box" style="display: none">
            <table id="form-table9" class="tab">
            <% for(i=111,j=111;i<126 && i<attNamesCorpList.size()&& j<126 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>

            <% } 
            if(i>=126 && i<attNamesCorpList.size()){ %>
            <div id="form-div10" class="box" style="display: none">
            <table id="form-table10" class="tab">
            <% for(i=126,j=126;i<141 && i<attNamesCorpList.size()&& j<141 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=141 && i<attNamesCorpList.size()){ %>
            <div id="form-div11" class="box" style="display: none">
            <table id="form-table11" class="tab">
            <% for(i=141,j=141;i<156 && i<attNamesCorpList.size()&& j<156 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=156 && i<attNamesCorpList.size()){ %>
            <div id="form-div12" class="box" style="display: none">
            <table id="form-table12" class="tab">
            <% for(i=156,j=156;i<171 && i<attNamesCorpList.size()&& j<171 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=171 && i<attNamesCorpList.size()){ %>
            <div id="form-div13" class="box" style="display: none">
            <table id="form-table13" class="tab">
            <% for(i=171,j=171;i<186 && i<attNamesCorpList.size()&& j<186 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=186 && i<attNamesCorpList.size()){ %>
            <div id="form-div14" class="box" style="display: none">
            <table id="form-table14" class="tab">
            <% for(i=186,j=186;i<201 && i<attNamesCorpList.size()&& j<201 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=201 && i<attNamesCorpList.size()){ %>
            <div id="form-div15" class="box" style="display: none">
            <table id="form-table15" class="tab">
            <% for(i=201,j=201;i<216 && i<attNamesCorpList.size()&& j<216 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=216 && i<attNamesCorpList.size()){ %>
            <div id="form-div16" class="box" style="display: none">
            <table id="form-table16" class="tab">
            <% for(i=216,j=216;i<231 && i<attNamesCorpList.size() && j<231 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <%  } %> </table> </div>

            <% } 
            if(i>=231 && i<attNamesCorpList.size()){ %>
            <div id="form-div17" class="box" style="display: none">
            <table id="form-table17" class="tab">
            <% for(i=231,j=231;i<246 && i<attNamesCorpList.size()&& j<246 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=246 && i<attNamesCorpList.size()){ %>
            <div id="form-div18" class="box" style="display: none">
            <table id="form-table18" class="tab">
            <% for(i=246,j=246;i<261 && i<attNamesCorpList.size()&& j<261 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=261 && i<attNamesCorpList.size()){ %>
            <div id="form-div19" class="box" style="display: none">
            <table id="form-table19" class="tab">
            <% for(i=261,j=261;i<276 && i<attNamesCorpList.size()&& j<276 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% }
            if(i>=276 && i<attNamesCorpList.size()){ %>
            <div id="form-div20" class="box" style="display: none">
            <table id="form-table20" class="tab">
            <% for(i=276,j=276;i<291 && i<attNamesCorpList.size()&& j<291 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } 
            if(i>=291 && i<attNamesCorpList.size()){ %>
            <div id="form-div21" class="box" style="display: none">
            <table id="form-table21" class="tab">
            <% for(i=291,j=291;i<306 && i<attNamesCorpList.size()&& j<306 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attClassHidingList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attClassHidingList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attClassHidingList.get(i)%>"><td class="<%=attReqList.get(i)%>"><font class="<%=addanotherList.get(i)%>" style="display: none;"><%=innerRadioList.get(i)%></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>

            <% } } } } } } } } } } } } } %>
        <input type="hidden" name="stateFormPageValues"/>		
		
		<h4 class="pull-left" style="display: none;" id="PreviousIBID">		            
		<button class="submit-button1 btn-height" type="submit" onclick="return prev();" onMouseOver="document.getElementById('prev-sub-but').src='resources/images/SSImgs/GetPreviousDocMOImg.png';" onMouseOut="document.getElementById('prev-sub-but').src='resources/images/SSImgs/GetPreviousDocImg.png';" ><img id="prev-sub-but" src="resources/images/SSImgs/GetPreviousDocImg.png" alt=""><span class="butt-va-mid">Previous</span></button>
		</h4>
		
		<h4 class="pull-right" style="display: none;" id="SaveIBID">
        <button class="submit-button1 btn-height" type="submit" onclick="return save();" onMouseOver="document.getElementById('next-sub-but').src='resources/images/SSImgs/GetNextDocMOImg.png';" onMouseOut="document.getElementById('next-sub-but').src='resources/images/SSImgs/GetNextDocImg.png';" ><span style="vertical-align: middle;">Next</span><img id="next-sub-but" style="padding-left: 10px;" src="resources/images/SSImgs/GetNextDocImg.png" alt=""></button>
		</h4>
		
		<h4 class="pull-right" style="display: none;" id="FinishIBID">		            
		<button class="submit-button1 btn-height" type="submit" onclick="return save();" onMouseOver="document.getElementById('finish-sub-but').src='resources/images/SSImgs/RegPointerWhiteImg.png';" onMouseOut="document.getElementById('finish-sub-but').src='resources/images/SSImgs/RegPointerBlueImg.png';" ><img id="finish-sub-but" src="resources/images/SSImgs/RegPointerBlueImg.png" alt=""><span class="butt-va-mid">Finish</span></button>
		</h4>
		</form>		
		</div>
		<div class="clearfix"></div>
		</div>
		
		<div class="bottom-bg">
		<img src="resources/images/CornerFoldImg.png" alt="" class="img-responsive">
		</div> <!--   End alabama  -->
		</div>
		
		<div class="col-md-3">	
		<div class=" right-side1">
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

        <script src="resources/scripts/jquery.datePicker-min.js" type="text/javascript"></script>
	    <script src="resources/scripts/businessservices/stateforms/stateformshiding.js" type="text/javascript"></script>
	    <script src="resources/scripts/json-minified.js" type="text/javascript"></script>
	    <script src="resources/scripts/businessservices/stateforms/stateformsfieldsvalidation.js" type="text/javascript"></script>
	    <script src="resources/scripts/businessservices/stateforms/stateformspagevalidation.js" type="text/javascript"></script>
        </body>        
</html>