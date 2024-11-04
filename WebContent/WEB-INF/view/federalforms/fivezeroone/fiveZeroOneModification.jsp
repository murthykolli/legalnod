<%--
    Document   : fiveZeroOneModification
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
    function convert(str){
        str = str.replace(/\&amp;/g,"&");
        str = str.replace(/\&gt;/g, ">");
        str = str.replace(/\&lt;/g, "<");
        str = str.replace(/\&quot;/g, '"');
        return str;
        }
    
    var $c=0;    
    window.onload=function(){
    var firstChAE = '<c:out value="${AlreadyExitChoice}"/>';
    if(firstChAE !== null && firstChAE === "AlreadyExitUserChoice"){
    alert("Your 501 App Name already Exist");
    }    
    document.getElementById("SaveIBID").style.display='block';    
    
    var formPageValues = '<c:out value="${fiveZeroOneFormPageValues}"/>';
    var boxes = $(".box");
    
    if(formPageValues===""){
    document.getElementById("form-div1").style.display='block';   
    }    
    for(var i=0;i<boxes.length;i++){
    if(formPageValues === boxes[i].id){
    document.getElementById(boxes[i].id).style.display='block'; 
    $c=i;
    if($c>=0){
    document.getElementById("PreviousIBID").style.display='block';
    }
    if($c===12){
    document.getElementById('SaveIBID').style.display='none';  
    document.getElementById('FinishIBID').style.display='block'; 
    }
    break;
    } }
    
    progressCount=$c;
    $("#progress").prop("value", progressCount);
    document.fiveZeroOne.elements['attributeTextField1'].focus();
    };
    
    $(window).ready(function(){
    $(".datepicker").datepicker({changeMonth: true,changeYear: true});
    });
    $(document).ready(function(){
    var hidingClassNames = '<c:out value="${RadioButtonStatus}"/>';
    hidingClassNames=hidingClassNames.replace("[","");
    hidingClassNames=hidingClassNames.replace("]","");
    if(hidingClassNames!==""){
    classList=hidingClassNames.split(", ");
    for(var cl1=0;cl1<classList.length;cl1++){
    $("."+classList[cl1]).hide();
    } }
   
    var attributeTextFieldList  = '<c:out value="${attributeTextFieldList}"/>';
    var attributeTextFieldZipList  = '<c:out value="${attributeTextFieldZipList}"/>';
    var attributeTextFieldDateList  = '<c:out value="${attributeTextFieldDateList}"/>';
    var attributeTextAreaList  = '<c:out value="${attributeTextAreaList}"/>';
    var attributeSelectBoxList  = '<c:out value="${attributeSelectBoxList}"/>';
    var radioButtonList  = '<c:out value="${radioButtonList}"/>';
    var checkBoxList  = '<c:out value="${checkBoxList}"/>';    
    
    attributeTextFieldList = attributeTextFieldList.replace(/\&amp;/g,"&");
    attributeTextFieldList = attributeTextFieldList.replace(/&#034;/g,"\"");
    attributeTextFieldList = attributeTextFieldList.replace(/&#039;/g,"'");
    attributeTextFieldList = attributeTextFieldList.replace(/&lt;/g,"<");
    attributeTextFieldList = attributeTextFieldList.replace(/&gt;/g,">");
    var attributeTextFieldList1 = attributeTextFieldList.split(",$,");
    for(var i = 0; i < attributeTextFieldList1.length; i++){
    $("[name=attributeTextField"+(i+1)+"]").val(convert(attributeTextFieldList1[i])) ;
    }
    
    var attributeTextFieldZipList1 = attributeTextFieldZipList.split(",$,");
    for(var i = 0; i < attributeTextFieldZipList1.length; i++){
    $("[name=attributeTextFieldZip"+(i+1)+"]").val(attributeTextFieldZipList1[i]) ;
    }
    
    var attributeTextFieldDateList1 = attributeTextFieldDateList.split(",$,");
    for(var i = 0; i < attributeTextFieldDateList1.length; i++){
    $("[name=attributeTextFieldDate"+(i+1)+"]").val(attributeTextFieldDateList1[i]) ;
    }
    
    attributeTextAreaList = attributeTextAreaList.replace(/\&amp;/g,"&");    
    attributeTextAreaList = attributeTextAreaList.replace(/&#034;/g,"\"");
    attributeTextAreaList = attributeTextAreaList.replace(/&#039;/g,"'");
    attributeTextAreaList = attributeTextAreaList.replace(/&lt;/g,"<");
    attributeTextAreaList = attributeTextAreaList.replace(/&gt;/g,">");
    var attributeTextAreaList1 = attributeTextAreaList.split(",$,");
    for(var i = 0; i < attributeTextAreaList1.length; i++){
    $("[name=attributeTextArea"+(i+1)+"]").val(attributeTextAreaList1[i]) ;
    }
    
    var attributeSelectBoxList1 = attributeSelectBoxList.split(",$,");
    for(var i = 0; i < attributeSelectBoxList1.length; i++){
    $("[name=attributeSelectBox"+(i+1)+"]").val(attributeSelectBoxList1[i]) ;
    }
    
    var radioButtonList1 = radioButtonList.split(",$,");    
    var radio;
    for(i = 0; i < radioButtonList1.length; i++){
    if(radioButtonList1[i] !== "") {
    radio = $("[name=radioButton"+[i+1]+"]");
    for(var j=0;j<radio.length;j++){
    if(radio[j].value === radioButtonList1[i]){
    radio[j].checked = true;
    $("."+radio[j].value).show();
    } } } }
    
    if(radioButtonList1[15] === "yes16" || radioButtonList1[15] === "no16"){ $(".radio1").show(); }
    if(radioButtonList1[14] === "yes15" || $("input[name='radioButton16']").is(':checked')){ $(".radio1").show(); }
    if(radioButtonList1[15] === "yes16" || $("input[name='radioButton17']").is(':checked')){ $(".radio2").show(); }
    if(radioButtonList1[16] === "yes17" || $("input[name='radioButton18']").is(':checked')){ $(".radio3").show(); }
    if(radioButtonList1[18] === "yes19" || $("input[name='radioButton20']").is(':checked')){ $(".radio4").show(); }
    if(radioButtonList1[19] === "yes20" || $("input[name='radioButton21']").is(':checked')){ $(".radio5").show(); }
    if(radioButtonList1[20] === "yes21" || $("input[name='radioButton22']").is(':checked')){ $(".radio6").show(); }
    if(radioButtonList1[22] === "yes23" || $("input[name='radioButton24']").is(':checked')){ $(".radio7").show(); }
    if(radioButtonList1[23] === "yes24" || $("input[name='radioButton25']").is(':checked')){ $(".radio8").show(); }
    if(radioButtonList1[24] === "yes25" || $("input[name='radioButton26']").is(':checked')){ $(".radio9").show(); }
    if(radioButtonList1[137] === "yes138" || $("input[name='radioButton139']").is(':checked')){ $(".radio10").show(); }
    if(radioButtonList1[138] === "yes139" || $("input[name='radioButton140']").is(':checked')){ $(".radio11").show(); }
    if(radioButtonList1[139] === "yes140" || $("input[name='radioButton141']").is(':checked')){ $(".radio12").show(); }
    if(radioButtonList1[141] === "yes142" || $("input[name='radioButton143']").is(':checked')){ $(".radio13").show(); }
    if(radioButtonList1[142] === "yes143" || $("input[name='radioButton144']").is(':checked')){ $(".radio14").show(); }
    if(radioButtonList1[143] === "yes144" || $("input[name='radioButton145']").is(':checked')){ $(".radio15").show(); }
    if(radioButtonList1[171] === "yes172" || $("input[name='radioButton173']").is(':checked')){ $(".radio16").show(); }
    if(radioButtonList1[172] === "yes173" || $("input[name='radioButton174']").is(':checked')){ $(".radio17").show(); }
    if(radioButtonList1[173] === "yes174" || $("input[name='radioButton175']").is(':checked')){ $(".radio18").show(); }
    if(radioButtonList1[228] === "yes231" || $("input[name='radioButton230']").is(':checked')){ $(".radio19").show(); }
    if(radioButtonList1[229] === "yes232" || $("input[name='radioButton231']").is(':checked')){ $(".radio20").show(); }
    if(radioButtonList1[230] === "yes233" || $("input[name='radioButton232']").is(':checked')){ $(".radio21").show(); }
    if(radioButtonList1[30] === "no31" || radioButtonList1[31] === "no32" || radioButtonList1[32] === "no33" || radioButtonList1[33] === "no34" || radioButtonList1[34] === "no35" || radioButtonList1[35] === "no36"){ $(".no").show(); }
    
    var check;
    var checkBox = checkBoxList.split(",$,");
    for(var l = 0; l < checkBox.length; l++){
    if(checkBox[l] !== ""){
    check = $("[name=checkBox"+[l+1]+"]");
    for(var k = 0; k < check.length; k++){
    if(checkBox[l].indexOf(check[k].value)!==-1){
    check[k].checked = true;
    } } } }
    if(checkBox[1]==="provisions"){
    $(".provisions").show();
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
    
    });
    
    function newAjaxCall(){
        if(document.fiveZeroOne.attributeTextField1.value !== ''){
        var fzoName = document.fiveZeroOne.attributeTextField1.value;
        newAjaxCallJson(fzoName);
        } } 

        var choiceReturn = true;
        function newAjaxCallJson(selectedData){    	
        	$.ajax({
    			type : 'POST',
    			url : "jSonFiveZeroOneName?documentName="+selectedData,
    			dataType : 'json',
    			async : true,
    			cache: false,
    			success : function(result) {
    				var return_result=JSON.stringify(result);				
    				var data=JSON.parse(return_result);				
    				
    				for(var i=0;i<data.length;i++){
    					var value = data[i].UserChoice;					
    					if(value !== null){					
    						alert("Your 501 App Name already Exist");
    						choiceReturn=false;
    					} else{
    						choiceReturn = true;
    					} } } }); }
        
        choiceReturn=true;
        function responseData(data){
        var myJsonObj = jsonParse(data);
        var value=myJsonObj.jsonResponse;
        if(value !== null){
        alert("Your 501 App Name already Exist");
        choiceReturn=false;
        } else{
        choiceReturn=true;
        } }
    </script>
    </head>   
        <body>        
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="fzo-white-background">
		<div class="docCenter docCenter2">
		<div>
		<div class="row">		
		<div class="col-md-9">
		<div class="progress-wrap">
		<p class="pro-bar-font">Start <span>Finished</span></p>
		<progress max="13" value="0" id="progress"></progress>
		</div>
		<div class="alabama">
		<div class="alabama-head">
		<h2>501(c)(3) Application</h2>
		
		<div class="clearfix"></div>
		</div>		
		
		<div class="principal frame-width">		
		<form action="fiveZeroOneFormModification" method="post" name="fiveZeroOne" id="pro-form" >
            <% if (null != session.getAttribute("FZO_Attr_Names")) {
            ArrayList attNamesCorpList = (ArrayList) session.getAttribute("FZO_Attr_Names");
            if (null != attNamesCorpList && attNamesCorpList.size() > 0) {
            
            if (null != session.getAttribute("FZO_Attr_Values")) {
            ArrayList attValueCorpList = (ArrayList) session.getAttribute("FZO_Attr_Values");
            if (null != attValueCorpList && attValueCorpList.size() > 0) {
            
            if (null != session.getAttribute("FZO_Attr_Req_List")) {
            ArrayList attRequiredList = (ArrayList) session.getAttribute("FZO_Attr_Req_List");
            if (null != attRequiredList && attRequiredList.size() > 0) {
            
            if (null != session.getAttribute("FZO_Attr_Status_List")) {
            ArrayList attStatusList = (ArrayList) session.getAttribute("FZO_Attr_Status_List");
            if (null != attStatusList && attStatusList.size() > 0) {
            %>

            <div id="form-div1" class="box"  style="display: none">
            <table id="form-table1" class="tab">
            <% int i=0,j=0;
            for(i=0,j=0;i<45 && i<attNamesCorpList.size() && j<45 && j<attValueCorpList.size();i++,j++){  %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table></div> 
            
            <%if(i>=45 && i<attNamesCorpList.size()) { %>
            <div id="form-div2" class="box" style="display: none">
            <table id="form-table2" class="tab">
            <% for(i=45,j=45;i<110 && i<attNamesCorpList.size() && j<110 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=110 && i<attNamesCorpList.size()){ %>
            <div id="form-div3" class="box" style="display: none">
            <table id="form-table3" class="tab"> 
            <% for(i=110,j=110;i<198 && i<attNamesCorpList.size() && j<198 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"  ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>

            <% } 
            if(i>=198 && i<attNamesCorpList.size()){ %>
            <div id="form-div4" class="box" style="display: none">
            <table id="form-table4" class="tab"> 
            <% for(i=198,j=198;i<237 && i<attNamesCorpList.size() && j<237 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>" ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=237 && i<attNamesCorpList.size()){ %>
            <div id="form-div5" class="box" style="display: none">
            <table id="form-table5" class="tab"> 
            <% for(i=237,j=237;i<302 && i<attNamesCorpList.size() && j<302 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"  ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=302 && i<attNamesCorpList.size()) { %>
            <div id="form-div6" class="box" style="display: none">
            <table id="form-table6" class="tab"> 
            <% for(i=302,j=302;i<364 && i<attNamesCorpList.size() && j<364 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"  ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=364 && i<attNamesCorpList.size()){ %>
            <div id="form-div7" class="box" style="display: none">
            <table id="form-table7" class="tab"> 
            <% for(i=364,j=364;i<414 && i<attNamesCorpList.size() && j<414 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>" ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=414 && i<attNamesCorpList.size()){ %>
            <div id="form-div8" class="box" style="display: none">
            <table id="form-table8" class="tab"> 
            <% for(i=414,j=414;i<477 && i<attNamesCorpList.size() && j<477 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>" ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=477 && i<attNamesCorpList.size()){ %>
            <div id="form-div9" class="box" style="display: none">
            <table id="form-table9" class="tab"> 
            <% for(i=477,j=477;i<503 && i<attNamesCorpList.size()&& j<503 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"  ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr>
            <% } %> </table> </div>
            
            <% } 
            if(i>=503 && i<attNamesCorpList.size()){ %>
            <div id="form-div10" class="box" style="display: none">
            <table id="form-table10" class="tab"> 
            <% for(i=503,j=503;i<693 && i<attNamesCorpList.size()&& j<693 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"  ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=693 && i<attNamesCorpList.size()){ %>
            <div id="form-div11" class="box" style="display: none">
            <table id="form-table11" class="tab"> 
            <% for(i=693,j=693;i<833 && i<attNamesCorpList.size()&& j<833 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>" ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=833 && i<attNamesCorpList.size()){ %>
            <div id="form-div12" class="box" style="display: none">
            <table id="form-table12" class="tab"> 
            <% for(i=833,j=833;i<953 && i<attNamesCorpList.size()&& j<953 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>" ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>
            
            <% } 
            if(i>=953 && i<attNamesCorpList.size()){ %>
            <div id="form-div13" class="box" style="display: none">
            <table id="form-table13" class="tab"> 
            <% for(i=953,j=953; i<attNamesCorpList.size()&& j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>" ><td class="<%=attRequiredList.get(i)%>"><font style="display: none;"></font><font style="display: none"></font><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>            
            <% } } } } } } } } } %>
            
            <input type="hidden" name="fiveZeroOneFormPageValues" />
            <input type="hidden" name="fiveZeroOneFinishOrderRef" />		
		
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
 
		<script type="text/javascript" src="resources/scripts/federalforms/fivezerooneapp.js"></script>
	    <script type="text/javascript" src="resources/scripts/jquery.datePicker-min.js"></script>
	    <script type="text/javascript" src="resources/scripts/json-minified.js"></script>
        </body>            
</html>