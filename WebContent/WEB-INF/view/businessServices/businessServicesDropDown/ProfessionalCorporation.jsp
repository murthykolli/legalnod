<%--
    Document   : ProfessionalCorporation
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
    window.onload=function(){
    	var stateName = document.busStateFormsName.stateName.value;        
        if(stateName !== ""){
    	llcStateValidation();
        } };
    
    function validation(){
    var stateName=document.busStateFormsName.stateName.value;
    var formName=document.busStateFormsName.formName.value;
    var result=true;
    if(stateName!==""){
    document.getElementById("statelabel").removeAttribute("class");
    } else{
    document.getElementById("statelabel").setAttribute("class","redTestDisplay");
    result=false;
    }
    if(formName!==""){
    document.getElementById("formlabel").removeAttribute("class");
    } else{
    document.getElementById("formlabel").setAttribute("class","redTestDisplay");
    result=false;
    }

    if(stateName !== "" && formName !== ""){
    var selectedData = stateName+" _ "+formName;
	newAjaxPriceCall(selectedData);
	result = false;
    }
    return result;
    }

    function llcFormNameValidation(){
    var formName=document.busStateFormsName.formName.value;
    if(formName!==""){
    document.getElementById("formlabel").removeAttribute("class");
    } else{
    document.getElementById("formlabel").setAttribute("class","redTestDisplay");
    } }

    function llcStateValidation(){
    var stateName = document.busStateFormsName.stateName.value;
    if(stateName !== ""){
    document.getElementById("statelabel").removeAttribute("class");
    var categoryName = "Professional Corporation";
    var selectedState = categoryName+" _ "+stateName;
    newAjaxCall(selectedState);
    } else{
    document.getElementById("statelabel").setAttribute("class","redTestDisplay");
    } }

    function showImage(image){
    document.getElementById("showImage").style.backgroundImage="url("+image+")";
    }

    function selectFormBeforeState(){
    var stateName=document.busStateFormsName.stateName.value;
    if(stateName === ""){
    alert("Please select a state first");
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

    function newAjaxCall(selectedstate){   
    	$.ajax({
			type : 'POST',
			url : "jSonFormSelectionWithState?stateName="+selectedstate,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) { 
				$('#formNameId').empty();				
				var jsonStrObj = removeDuplicates(result);				
				var data = JSON.parse(jsonStrObj);
				var selectHeading = '----------Select Form Name----------';
				var selectHeadingVal = $('<option value="">'+selectHeading+'</option>');
				$('#formNameId').append(selectHeadingVal);
				for(var i=0;i<data.length;i++){
        		var newOption = $("<option value='" + data[i].formname+ "'>" + data[i].formname + "</option>");        		
		  		$('#formNameId').append(newOption);		  		
				} } }); }
    
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
				var stateName = document.busStateFormsName.stateName.value;
				var formName = document.busStateFormsName.formName.value;
				$.lz.Alert({type:"",title:"<img class='aln-st-img' src='resources/images/smallStateNameImg.png'> "+stateName+" &nbsp;&nbsp; <img class='aln-st-img' src='resources/images/smallFormNameImg.png'> "+formName+"",
						    content:"<font color='#9400D3'>LegalNod </font>Process fee <font style='margin-left: 62px;'>:</font> <font style='color:#00A9F1; margin-left: 63px;font-size: 15px;'><font color='#000'>$ </font><b>"+data[0].jPriceList+"</b></font><br> " +
						   "<font color='#9400D3'>State</font> Standard fee <font style='margin-left: 76px;'>:</font> <font style='color:#00A9F1; margin-left: 63px;font-size: 15px;'><font color='#000'>$ </font><b>"+data[1].jPriceList+"</b></font><br> " +
						   "Our process fee is the lowest.  If you find any other low price, we will reduce <font color='#228B22'><b>5%</b></font> on our process fee. <br><br>", effect:"slideDown,bigger",formID:"stateFormsId"});
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
		<h2 class="busServHeading"> Professional Corporation</h2>
		<p class="bs-dropdown-LMText"> Learn more about Professional Corporations at the  &nbsp;<a href="ProfessionalCorpDoc" onMouseOver="this.style.color='#3c3c3c';" onMouseOut="this.style.color='#00a9f1';">DOC CENTER</a></p>
		
		<div style="margin-left: 0px;margin-top: 0px;">
		<div id="BackgroundShowID" style="margin-left: 140px; margin-top: -280px;  width: auto;position: absolute;color:#00a9f1;font: bold 1.2em/1.25em Georgia;white-space: nowrap;display: none;">
		<div style="margin-left: 35px;margin-top: 12px;width:200px;" id="showImage"></div> </div></div>
		<div class="price-box bus-drodown">
		 
		<p class="bsDollarSymbol">$</p>
		<p class="bsPrice">49</p>
		<p class="bsStateFeeText"><b>+</b>  State Filing Fee &nbsp;
		<img id="filing-fee-img" src="resources/images/paymentQuesMarkImg.png" onmouseover="document.getElementById('filing-fee-img').src='resources/images/paymentQuesMarkMOImg.png';document.getElementById('st-file-fee').style.display='block';" onmouseout="document.getElementById('filing-fee-img').src='resources/images/paymentQuesMarkImg.png';document.getElementById('st-file-fee').style.display='none';" style="margin-left: 0px;margin-top: -1px;position:absolute;cursor: pointer;"> 
		  <img id="st-file-fee" class="st-filing-fee-img bus-data-img" src="resources/images/SSImgs/LNStandardFilingFeeImg.png">
		</p> </div>		            
		<div class="bsarrowstext">
		<p><img id="dropdown-federal" src="resources/images/SSImgs/TextPointerImg.png"><a href="FederalTaxIDDoc" onMouseOver="document.getElementById('dropdown-federal').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onMouseOut="document.getElementById('dropdown-federal').src='resources/images/SSImgs/TextPointerImg.png';">  Apply for your Federal Tax ID (EIN) for <font class="text-doc">FREE</font> when you <br>form your business with us </a></p>
		<p><img id="dropdown-doccenter" src="resources/images/SSImgs/TextPointerImg.png"><a href="docCenter" onMouseOver="document.getElementById('dropdown-doccenter').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onMouseOut="document.getElementById('dropdown-doccenter').src='resources/images/SSImgs/TextPointerImg.png';">  Learn more and compare types of businesses at the <br><font class="text-doc">DOC CENTER</font></a></p>
		<p><img id="dropdown-newreqdoc" src="resources/images/SSImgs/TextPointerImg.png"><a href="newRequestDoc" target="_blank" onMouseOver="document.getElementById('dropdown-newreqdoc').src='resources/images/SSImgs/TextPointerGrayMOImg.png';" onMouseOut="document.getElementById('dropdown-newreqdoc').src='resources/images/SSImgs/TextPointerImg.png';"><font class="bs-text-adj">  Look no further and request a Custom Document</font></a></p>
		</div> </div>  
		
		<div class="state-doucment-inner">
		<div class="dropdown-documents dropdown-small">
		<h2>Prof Corp Formation</h2>
		<div class="form-selected">		
		<form name="busStateFormsName" id="stateFormsId" action="newStateFormSelection" method="get">
		<table class="form-group">
		<tbody><tr class="bigFormLabel"><td id="statelabel">Select State: </td></tr> <tr style="height: 5px;"></tr>
		<tr><td><select id="stateNameId" name="stateName" onchange="llcStateValidation();">
	        <option value="">----------Select State Name----------</option>
		    <c:forEach var="statesList" items="${stateList}"> <option value="${statesList.stateName}">${statesList.stateName}</option> </c:forEach>
		    </select></td></tr> <tr style="height: 15px;"></tr>		
		
		<tr class="bigFormLabel"><td id="formlabel">I want to form a: </td></tr> <tr style="height: 5px;"></tr>
		<tr><td><select id="formNameId" name="formName" onchange="llcFormNameValidation();" onclick="selectFormBeforeState();">
	        <option value="">----------Select Form Name----------</option>        
			</select></td></tr> <tr style="height: 25px;"></tr> 
		
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
 
		<script type="text/javascript" src="resources/scripts/json-minified.js"></script>
		<script type="text/javascript" src="resources/scripts/popupwindow.js"></script>
        </body>        
</html>