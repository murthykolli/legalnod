<%--
	Document : serviceByState
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
    function showImage(image){
    document.getElementById("showImage").innerHTML = image;     
    if(image  !== ''){
    document.getElementById("BackgroundShowID").style.display='block';     
    } else{
    document.getElementById("BackgroundShowID").style.display='none';
    } }
    </script>

    <script type="text/javascript">    
    window.onload=function(){
    var stateName = document.serByStFormName.stateName.value;        
    if(stateName !== ""){
    llcStateValidation();
    } };
    
    function validation(){
    var stateName=document.serByStFormName.stateName.value;
    var formName=document.serByStFormName.formName.value;
    var serviceByDocCategory=document.serByStFormName.categoryName.value;
    var result=true;
    if(stateName!==""){
    document.getElementById("statelabel").removeAttribute("class");
    } else{
    document.getElementById("statelabel").setAttribute("class","redTestDisplay");
    result=false;
    }
    if(serviceByDocCategory!==""){
    document.getElementById("categorylabel").removeAttribute("class");
    } else{
    document.getElementById("categorylabel").setAttribute("class","redTestDisplay");
    result=false;
    }
    if(formName!==""){
    document.getElementById("doclabel").removeAttribute("class");
    } else{
    document.getElementById("doclabel").setAttribute("class","redTestDisplay");
    result=false;
    }
    
    if(stateName !== "" && formName !== ""){
    var selectedData = stateName+" _ "+formName;
    newAjaxPriceCall(selectedData);
    result = false;
    }
    return result;
    }

    function llcStateValidation(){
    var stateName=document.serByStFormName.stateName.value;
    if(stateName!==""){
    document.getElementById("statelabel").removeAttribute("class");    
    var selectedState = stateName;
    newAjaxCallForCategorySelection(selectedState);
    } else{
    document.getElementById("statelabel").setAttribute("class","redTestDisplay");
    } }

    function llcDocumentValidation(){
    var formName=document.serByStFormName.formName.value;
    if(formName!==""){
    document.getElementById("doclabel").removeAttribute("class");
    } else{
    document.getElementById("doclabel").setAttribute("class","redTestDisplay");
    } }

    function llcCategoiesValidation(){
    var serviceByDocCategory=document.serByStFormName.categoryName.value;
    if(serviceByDocCategory!==""){
    document.getElementById("categorylabel").removeAttribute("class");
    var stateName = document.serByStFormName.stateName.value;
    var selectedState = serviceByDocCategory+" _ "+stateName;
    newAjaxCallForFormSelection(selectedState);
    } else{
    document.getElementById("categorylabel").setAttribute("class","redTestDisplay");
    } }

    function selectTypeBeforeState(){
    if(document.serByStFormName.typeOfServiceName.value===""){
    alert("Please select a type of service first");
    } }

    function selectStateBeforeDocCategory(){
    if(document.serByStFormName.typeOfServiceName.value===""){
    alert("Please select a type of service first");
    } else if(document.serByStFormName.stateName.value===""){
    alert("Please select a state first");
    } }

    function selectDocCateBeforeForm(){
    if(document.serByStFormName.typeOfServiceName.value===""){
    alert("Please select a type of service first");
    } else if(document.serByStFormName.stateName.value===""){
    alert("Please select a state first");
    } else if(document.serByStFormName.categoryName.value===""){
    alert("Please select a document category first");
    } }
    
    function removeDuplicates(obj){    	 	
    var uniques=[];
    var stringify={};
    for(var i=0;i<obj.length;i++){        	
    var keys = Object.keys(obj[i]);        
    var str='';
    for(var j=0;j<keys.length;j++){       
    str+= JSON.stringify(keys[j]);
    str+= JSON.stringify(obj[i][keys[j]]);
    }
    if(!stringify.hasOwnProperty(str)){
    uniques.push(obj[i]);
    stringify[str]=true;
    } }
    uniques = JSON.stringify(uniques);        
    return uniques;
    }

    	function newAjaxCallForCategorySelection(selectedstate){   
    	$.ajax({
		type : 'POST',
		url : "jSonCatServiceByStateSelection?stateName="+selectedstate,
		dataType : 'json',
		async : true,
		cache: false,
		success : function(result) { 
		$('#categoryNameId').empty();
		var jsonStrObj = removeDuplicates(result);				
		var data = JSON.parse(jsonStrObj);
		var selectHeading = '--------Select Category Name--------';
		var firstVal = $('<option value="">'+selectHeading+'</option>');
		$('#categoryNameId').append(firstVal);
		for(var i=0;i<data.length;i++){
        var newOption = $("<option value='" + data[i].formCategory+ "'>" + data[i].formCategory + "</option>");        		
		$('#categoryNameId').append(newOption);		  		
		} } }); }
    
    	function newAjaxCallForFormSelection(selectedstate){   
    	$.ajax({
		type : 'POST',
		url : "jSonFormServiceByStateSelection?stateName="+selectedstate,
		dataType : 'json',
		async : true,
		cache: false,
		success : function(result) { 
		$('#formNameId').empty();
		var jsonStrObj = removeDuplicates(result);				
		var data = JSON.parse(jsonStrObj);
		var selectHeading = '----------Select Form Name----------';
		var firstVal = $('<option value="">'+selectHeading+'</option>');
		$('#formNameId').append(firstVal);
		for(var i=0;i<data.length;i++){
		var newOption = $("<option value='" + data[i].formName+ "'>" + data[i].formName + "</option>");
		$('#formNameId').append(newOption);		  		
		} } }); }
    
    	function getServiceState(state){
    	$("[name=stateName]").val(state);    	
        if(state !== ""){        
        llcStateValidation();
        } }
    	
    	function newAjaxPriceCall(selectedData){     	
        	$.ajax({
    			type : 'POST',
    			url : "jSonFormStateSelectionForPrice?formCategoty="+selectedData,
    			dataType : 'json',
    			async : true,
    			cache: false,
    			success : function(result) {
    				var return_result=JSON.stringify(result);				
    				var data=JSON.parse(return_result);	
    				var stateName=document.serByStFormName.stateName.value;
    			    var formName=document.serByStFormName.formName.value;
    				$.lz.Alert({type:"",title:"<img class='aln-st-img' src='resources/images/smallStateNameImg.png'> "+stateName+" &nbsp;&nbsp; <img class='aln-st-img' src='resources/images/smallFormNameImg.png'> "+formName+"",
    						    content:"<font color='#9400D3'>LegalNod </font>Process fee <font style='margin-left: 62px;'>:</font> <font style='color:#00A9F1; margin-left: 63px;font-size: 15px;'><font color='#000'>$ </font><b>"+data[0].jPriceList+"</b></font><br> " +
    						   "<font color='#9400D3'>State</font> Standard fee <font style='margin-left: 76px;'>:</font> <font style='color:#00A9F1; margin-left: 63px;font-size: 15px;'><font color='#000'>$ </font><b>"+data[1].jPriceList+"</b></font><br> " +
    						   "Our process fee is the lowest.  If you find any other low price, we will reduce <font color='#228B22'><b>5%</b></font> on our process fee. <br><br>", effect:"slideDown,bigger",formID:"servicesByStateFormId"});
    				} }); }
    </script>
    </head>
        <body>        
        <!-- Related Projects Row -->
		<div class="row body-grey">
		<div class="container">
		
		<div class="col-md-12">
		<div class="white-background">
		<div class="servicesbystate">
		<div>
		<div class="services-left">
		<h2 class="busServHeading"> Services by State</h2>
		<p class="bsLearnMoreText"> Learn more about each document at the   <a href="docCenter" onMouseOver="this.style.color='#3c3c3c';" onMouseOut="this.style.color='#00a9f1';">DOC CENTER</a></p>
		<table style="margin-left: 0px;margin-top: -60px;">
            <TR><TD align="center"><IMG style="margin-top: 80px;" height="258" border="0" src="resources/images/USAMapAll.png" alt="USA Map" usemap="#USMap">
            <MAP name=usmap>
            <AREA shape=POLY alt="Alabama" id=glow title="Alabama" coords=259,153,275,152,283,185,265,186,265,194,259,192 href="" onClick="getServiceState('Alabama');return false;" class="hintanchor" onMouseover="showImage('Alabama &nbsp')" onmouseout="showImage('')" >
            <AREA shape=POLY  alt="Alaska" id="Alaska-Alaska" title="Alaska" coords=73,191,101,191,112,230,89,229,80,248,63,225,75,218,68,198 href="" onClick="getServiceState('Alaska');return false;" class="hintanchor" onMouseover="showImage('Alaska &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Arizona" id="Arizona-Arizona" title="Arizona" coords=65,126,98,131,93,180,51,162 href="" onclick="getServiceState('Arizona');return false;" class="hintanchor" onMouseover="showImage('Arizona &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Arkansas" id="Arkansas-Arkansas" title="Arkansas" coords=210,140,237,139,243,147,234,174,209,173 href="" onclick="getServiceState('Arkansas');return false; " class="hintanchor" onMouseover="showImage('Arkansas &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="California" id="California-California" title="California" coords=4,63,30,70,22,96,54,142,48,159,33,155,25,141,13,129 href="" onclick="getServiceState('California');return false; " class="hintanchor" onMouseover="showImage('California &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Colorado" id="Colorado-Colorado" title="Colorado" coords=105,94,152,101,149,133,103,128 href="" onclick="getServiceState('Colorado');return false; " class="hintanchor" onMouseover="showImage('Colorado &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Connecticut" id="Connecticut-Connecticut" title="Connecticut" coords=362,123,384,123,384,135,363,135 href="" onclick="getServiceState('Connecticut');return false; " class="hintanchor" onMouseover="showImage('Connecticut &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Delaware" id="Delaware-Delaware" title="Delaware" coords=362,153,384,153,384,165,362,165 href="" onclick="getServiceState('Delaware');return false; " class="hintanchor" onMouseover="showImage('Delaware &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="District of Columbia" id="District of Columbia-District of Columbia" title="District of Columbia" coords=363,183,384,183,384,196,361,196 href="" onclick="getServiceState('District of Columbia'); return false;" class="hintanchor" onMouseover="showImage('District of Columbia &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Florida" id="Florida-Florida" title="Florida" coords=268,188,314,188,333,223,328,235,306,206,298,193,287,195 href="" onclick="getServiceState('Florida');return false; " class="hintanchor" onMouseover="showImage('Florida &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Georgia" id="Georgia-Georgia" title="Georgia" coords=277,151,293,149,315,172,311,186,286,184 href="" onclick="getServiceState('Georgia');return false; " class="hintanchor" onMouseover="showImage('Georgia &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Hawaii" id="Hawaii-Hawaii" title="Hawaii" coords=11,185,30,185,29,201,8,199 href="" onclick="getServiceState('Hawaii');return false; " class="hintanchor" onMouseover="showImage('Hawaii &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Idaho" id="Idaho-Idaho" title="Idaho" coords=67,12,73,14,77,47,87,61,96,57,90,79,53,71,64,40 href="" onclick="getServiceState('Idaho');return false; " class="hintanchor" onMouseover="showImage('Idaho &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Illinois" id="Illinois-Illinois" title="Illinois" coords=238,84,255,84,256,120,247,131,230,101 href="" onclick="getServiceState('Illinois');return false; " class="hintanchor" onMouseover="showImage('Illinois &nbsp')"  onmouseout="showImage('')">
            <AREA shape=POLY alt="Indiana" id="Indiana-Indiana" title="Indiana" coords=257,90,272,88,277,112,271,122,257,123 href="" onclick="getServiceState('Indiana');return false; " class="hintanchor" onMouseover="showImage('Indiana &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Iowa" id="Iowa-Iowa" title="Iowa" coords=195,75,229,75,238,90,228,100,199,100 href="" onclick="getServiceState('Iowa');return false; " class="hintanchor" onMouseover="showImage('Iowa &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Kansas" id="Kansas-Kansas" title="Kansas" coords=155,106,204,109,204,134,154,131 href="" onclick="getServiceState('Kansas');return false; " class="hintanchor" onMouseover="showImage('Kansas &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Kentucky" id="Kentucky-Kentucky" title="Kentucky" coords=262,125,283,114,296,116,296,129,247,137 href="" onclick="getServiceState('Kentucky');return false; " class="hintanchor" onMouseover="showImage('Kentucky &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Louisiana" id="Louisiana-Louisiana" title="Louisiana" coords=214,177,236,178,232,191,241,193,248,204,237,206,230,200,216,200,216,183 href="" onclick="getServiceState('Louisiana');return false; " class="hintanchor" onMouseover="showImage('Louisiana &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Maine" id="Maine-Maine" title="Maine" coords=365,18,375,15,385,34,365,53,362,35 href="" onclick="getServiceState('Maine');return false; " class="hintanchor" onMouseover="showImage('Maine &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Maryland" id="Maryland-Maryland" title="Maryland" coords=363,167,384,167,384,181,362,181 href="" onclick="getServiceState('Maryland');return false; " class="hintanchor" onMouseover="showImage('Maryland &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Massachusetts" id="Massachusetts-Massachusetts" title="Massachusetts" coords=362,108,384,108,384,121,362,121 href="" onclick="getServiceState('Massachusetts');return false; " class="hintanchor" onMouseover="showImage('Massachusetts &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Michigan" id="Michigan-Michigan" title="Michigan" coords=239,41,259,42,270,43,290,72,286,78,285,82,282,87,264,85,262,55 href="" onclick="getServiceState('Michigan');return false; " class="hintanchor" onMouseover="showImage('Michigan &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Minnesota" id="Minnesota-Minnesota" title="Minnesota" coords=194,25,231,35,216,53,226,72,195,71 href="" onclick="getServiceState('Minnesota');return false; " class="hintanchor" onMouseover="showImage('Minnesota &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Mississippi" id="Mississippi-Mississippi" title="Mississippi" coords=242,155,258,154,257,192,243,193,236,183 href="" onclick="getServiceState('Mississippi');return false; " class="hintanchor" onMouseover="showImage('Mississippi &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Missouri" id="Missouri-Missouri" title="Missouri" coords=203,102,229,102,248,136,208,139,209,115 href="" onclick="getServiceState('Missouri');return false; " class="hintanchor" onMouseover="showImage('Missouri &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Montana" id="Montana-Montana" title="Montana" coords=74,13,145,22,143,58,83,50  href="" onclick="getServiceState('Montana');return false; " class="hintanchor" onMouseover="showImage('Montana &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Nebraska" id="Nebraska-Nebraska" title="Nebraska" coords=142,77,195,85,199,107,155,103,153,96,141,93 href="" onclick="getServiceState('Nebraska');return false; " class="hintanchor" onMouseover="showImage('Nebraska &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Nevada" id="Nevada-Nevada" title="Nevada" coords=33,71,71,80,60,129,53,137,27,95 href="" onclick="getServiceState('Nevada');return false; " class="hintanchor" onMouseover="showImage('Nevada &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="New Hampshire" id="New Hampshire-New Hampshire" title="New Hampshire" coords=339,6,359,6,358,22,336,21  href="" onclick="getServiceState('New Hampshire');return false; " class="hintanchor" onMouseover="showImage('New Hampshire &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="New Jersey" id="New Jersey-New Jersey" title="New Jersey" coords=362,137,384,137,384,151,362,151 href="" onclick="getServiceState('New Jersey');return false; " class="hintanchor" onMouseover="showImage('New Jersey &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="New Mexico" id="New Mexico-New Mexico" title="New Mexico" coords=100,131,145,135,139,179,95,175 href="" onclick="getServiceState('New Mexico');return false; " class="hintanchor" onMouseover="showImage('New Mexico &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="New York" id="New York-New York" title="New York" coords=315,66,329,64,331,52,345,43,350,80,337,71,310,77 href="" onclick="getServiceState('New York');return false; " class="hintanchor" onMouseover="showImage('New York &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="North Carolina" id="North Carolina-North Carolina" title="North Carolina" coords=304,131,344,128,348,133,330,152,308,143,285,149,290,143 href="" onclick="getServiceState('North Carolina');return false; " class="hintanchor" onMouseover="showImage('North Carolina &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="North Dakota" id="North Dakota-North Dakota" title="North Dakota" coords=149,23,146,22,190,24,192,49,146,48 href="" onclick="getServiceState('North Dakota');return false; " class="hintanchor" onMouseover="showImage('North Dakota &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Ohio" id="Ohio-Ohio" title="Ohio" coords=289,88,305,84,303,104,293,113,278,111,275,87 href="" onclick="getServiceState('Ohio');return false; " class="hintanchor" onMouseover="showImage('Ohio &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Oklahoma" id="Oklahoma-Oklahoma" title="Oklahoma" coords=150,134,208,137,208,163,166,156,167,139 href="" onclick="getServiceState('Oklahoma');return false; " class="hintanchor" onMouseover="showImage('Oklahoma &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Oregon" id="Oregon-Oregon" title="Oregon" coords=16,27,63,41,50,70,3,57  href="" onclick="getServiceState('Oregon');return false; " class="hintanchor" onMouseover="showImage('Oregon &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Pennsylvania" id="Pennsylvania-Pennsylvania" title="Pennsylvania" coords=306,80,341,75,344,92,307,99 href="" onclick="getServiceState('Pennsylvania');return false; " class="hintanchor" onMouseover="showImage('Pennsylvania &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Rhode Island" id="Rhode Island-Rhode Island" title="Rhode Island" coords=363,92,384,92,384,106,362,106 href="" onclick="getServiceState('Rhode Island');return false; " class="hintanchor" onMouseover="showImage('Rhode Island &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="South Carolina" id="South Carolina-South Carolina" title="South Carolina" coords=297,150,307,145,330,154,315,170 href="" onclick="getServiceState('South Carolina');return false; " class="hintanchor" onMouseover="showImage('South Carolina &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="South Dakota" id="South Dakota-South Dakota" title="South Dakota" coords=146,51,191,52,192,81,143,74 href="" onclick="getServiceState('South Dakota');return false; " class="hintanchor" onMouseover="showImage('South Dakota &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Tennessee" id="Tennessee-Tennessee" title="Tennessee" coords=247,138,301,132,281,149,242,152 href="" onclick="getServiceState('Tennessee');return false; " class="hintanchor" onMouseover="showImage('Tennessee &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Texas" id="Texas-Texas" title="Texas" coords=146,139,166,141,165,160,204,170,214,201,184,217,183,237,152,199,133,203,115,181,144,181 href="" onclick="getServiceState('Texas');return false; " class="hintanchor" onMouseover="showImage('Texas &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Utah" id="Utah-Utah" title="Utah" coords=74,79,93,82,92,92,105,94,98,127,64,121 href="" onclick="getServiceState('Utah');return false; " class="hintanchor" onMouseover="showImage('Utah &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Vermont" id="Vermont-Vermont" title="Vermont" coords=311,17,332,17,330,33,309,31 href="" onclick="getServiceState('Vermont');return false; " class="hintanchor" onMouseover="showImage('Vermont &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Virginia" id="Virginia-Virginia" title="Virginia" coords=330,103,343,123,297,130,300,126,314,123,324,103 href="" onclick="getServiceState('Virginia');return false; " class="hintanchor" onMouseover="showImage('Virginia &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Washington" id="Washington-Washington" title="Washington" coords=25,11,39,2,65,11,59,36,16,22 href="" onclick="getServiceState('Washington');return false; " class="hintanchor" onMouseover="showImage('Washington &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="West Virginia" id="West Virginia-West Virginia" title="West Virginia" coords=308,101,313,103,315,106,321,100,322,103,316,111,309,121,301,124,297,117 href="" onclick="getServiceState('West Virginia');return false; " class="hintanchor" onMouseover="showImage('West Virginia &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY alt="Wisconsin" id="Wisconsin-Wisconsin" title="Wisconsin" coords=226,46,243,50,248,52,250,56,253,82,233,81,222,53 href="" onclick="getServiceState('Wisconsin');return false; " class="hintanchor" onMouseover="showImage('Wisconsin &nbsp')" onmouseout="showImage('')">
            <AREA shape=POLY  alt="Wyoming" id="Wyoming-Wyoming" title="Wyoming" coords=98,56,143,60,139,92,93,88 href="" onclick="getServiceState('Wyoming');return false; " class="hintanchor" onMouseover="showImage('Wyoming &nbsp')" onmouseout="showImage('')">
            </MAP></TD></TR> </table>

            <div style="margin-left: 0px;margin-top: 0px;">
            <div id="BackgroundShowID" style="margin-left: 80px; margin-top: -280px;  width: auto;position: absolute;color:#00a9f1;font: bold 1.2em/1.25em Georgia;white-space: nowrap;display: none;">
            <div align="center" style="margin-left: 25px;margin-top: 5px;width:200px;" id="showImage"></div> </div></div>
		  <div class="price-box">
		  <p class="text">Business Formation Starting From</p>
		  <p class="bsDollarSymbol">$</p>
		  <p class="bsPrice">49</p>
		  <p class="bsStateFeeText"><b>+</b>  State Filing Fee &nbsp;
		  <img id="filing-fee-img" src="resources/images/paymentQuesMarkImg.png" onmouseover="document.getElementById('filing-fee-img').src='resources/images/paymentQuesMarkMOImg.png';document.getElementById('st-file-fee').style.display='block';" onmouseout="document.getElementById('filing-fee-img').src='resources/images/paymentQuesMarkImg.png';document.getElementById('st-file-fee').style.display='none';" style="margin-left: 0px;margin-top: -1px;position:absolute;cursor: pointer;"> 
		  <img id="st-file-fee" class="st-filing-fee-img" src="resources/images/SSImgs/LNStandardFilingFeeImg.png">
		  </p>
		  </div> </div>

		<div class="state-documents">
		<h2>State Documents</h2>
		<div class="form-selected">		
		<form name="serByStFormName" id="servicesByStateFormId" action="newStateFormSelection" method="get">
		<table class="form-group">
		<tbody><tr><input type="hidden" name="typeOfServiceName" value="Business Services"></tr>
		<tr class="bigFormLabel"><td id="statelabel">Select State: </td></tr> <tr style="height: 5px;"></tr>
		<tr><td><select id="stateNameId" name="stateName" onchange="llcStateValidation();" onclick="selectTypeBeforeState();">
		<option value="">----------Select State Name----------</option>
		<c:forEach var="statesList" items="${stateList}"> <option value="${statesList.stateName}">${statesList.stateName}</option> </c:forEach>
		</select></td></tr> <tr style="height: 15px;"></tr>		
		
		<tr class="bigFormLabel"><td id="categorylabel">Select Doc Category: </td></tr> <tr style="height: 5px;"></tr>
		<tr><td><select id="categoryNameId" name="categoryName" onchange="llcCategoiesValidation();" onclick="selectStateBeforeDocCategory();">
		<option value="">--------Select Category Name--------</option>
		</select></td></tr> <tr style="height: 15px;"></tr>		
		
		<tr class="bigFormLabel"><td id="doclabel">I want to form a: </td></tr> <tr style="height: 5px;"></tr>
		<tr><td><select id="formNameId" name="formName" onchange="llcDocumentValidation();" onclick="selectDocCateBeforeForm();">
		<option value="">----------Select Form Name----------</option>
		</select></td></tr> <tr style="height: 25px;"></tr> 
		
		<tr><td><h4 class="pull-left">
		<button class="submit-button" type="submit" onclick="return validation();" onMouseOver="document.getElementById('ser-by-state-but').src='resources/images/SSImgs/GetStartedMOImg.png';" onMouseOut="document.getElementById('ser-by-state-but').src='resources/images/SSImgs/GetStartedImg.png';" ><img id="ser-by-state-but" src="resources/images/SSImgs/GetStartedImg.png" alt=""><span class="butt-va-mid">Get Started</span></button></h4>
		</td></tr></tbody></table>
		</form>
		</div> </div>

		<div class="clearfix"></div>	
		</div>
		<div class="col-md-12">
		<div class="bssidesinks">
		<p><a href="FederalTaxIDDoc" onmouseover="document.getElementById('sub-text-fedtax').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onmouseout="document.getElementById('sub-text-fedtax').src='resources/images/SSImgs/TextPointerImg.png';" ><img id="sub-text-fedtax" src="resources/images/SSImgs/TextPointerImg.png"> Apply for your Federal Tax ID (EIN) with us for <font class="text-doc">FREE</font> when you use our services to start your business! </a></p>
		<p><a href="docCenter" onmouseover="document.getElementById('sub-text-doccen').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onmouseout="document.getElementById('sub-text-doccen').src='resources/images/SSImgs/TextPointerImg.png';"><img id="sub-text-doccen" src="resources/images/SSImgs/TextPointerImg.png"> Learn more and compare types of businesses at the <font class="text-doc">DOC CENTER</font></a></p>
		<p><a href="newRequestDoc" target="_blank" onmouseover="document.getElementById('sub-text-custm').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onmouseout="document.getElementById('sub-text-custm').src='resources/images/SSImgs/TextPointerImg.png';"><img id="sub-text-custm" src="resources/images/SSImgs/TextPointerImg.png"> Request a document if you can't find what you're looking for!</a></p>	
		</div></div>
		<div class="clearfix"></div>
		</div> </div> </div>  <!--end col-md-12 --> 
		</div> <!-- /.contaner --> 
		</div> <!-- row -->
        <script type="text/javascript" src="resources/scripts/json-minified.js"></script>
        <script type="text/javascript" src="resources/scripts/popupwindow.js"></script>
        </body>         
</html>