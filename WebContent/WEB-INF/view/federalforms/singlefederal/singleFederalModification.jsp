<%--
    Document   : singleFederalModification
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
    <link rel="shortcut icon" href="resources/images/BrowserIcon/favicon.ico" type="image/x-icon" >
    <link href="resources/css/build.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="resources/css/datePicker.css" >    
	
    <style type="text/css">
    .progress-wrap { text-align: center; font-size: 10px; color: white; margin: 0 0 20px 0; }    
    progress { width: 100%; margin: 0 0 5px 0; -webkit-appearance: none; border-radius: 25px; background-color: white; }    
    progress::-webkit-progress-bar { background-color: white; border-radius: 25px; }    
    progress::-webkit-progress-value { background-color: #00A9F1; border-radius: 15px; height: 10px; }    
    progress::-moz-progress-bar { background-image: -moz-radial-gradient(left top, ellipse closest-side, #FFFFFF 0%, #00A9F1 100%); border-radius: 25px; height: 10px; }    
    #progress{ color: #00A9F1; border-radius: 25px; height: 12px; border:1px solid #3c3c3c; }
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
    window.onload=function(){ document.federaltax.elements['attributeTextField1'].focus(); };
    $(window).ready(function(){
    $(".datepicker").datepicker({changeMonth: true,changeYear: true});
    });
    
    $(document).ready(function(){
    var hidingClassNames = '<c:out value="${RadioButtonStatus}"/>';     
    hidingClassNames = hidingClassNames.replace("[","");
    hidingClassNames = hidingClassNames.replace("]","");
    if(hidingClassNames!==""){
    classList=hidingClassNames.split(", ");
    for(var cl1=0;cl1<classList.length;cl1++){
    $("."+classList[cl1]).hide();
    } }
    
    document.getElementById('SaveIBID').style.display='block';    
    var formPageValues = '<c:out value="${federalFormPageValues}"/>';    
    var boxes = $(".box");
    
    if(formPageValues === ""){
    document.getElementById("form-div1").style.display='block';   
    }   
    
    for(var i=0;i<boxes.length;i++){
    if(formPageValues === boxes[i].id){
    document.getElementById(boxes[i].id).style.display='block'; 
    $c=i;
    if($c>=0){
    document.getElementById("PreviousIBID").style.display='block';
    }
    if($c===3){
    document.getElementById('SaveIBID').style.display='none';  
    document.getElementById('FinishIBID').style.display='block'; 
    }
    break;
    } }
    
    progressCount=$c;
    $("#progress").prop("value", progressCount);
    
    var firstChAE = '<c:out value="${AlreadyExitChoice}"/>';
    if(firstChAE !== null && firstChAE === "AlreadyExitUserChoice"){
    alert("Your Legal Name already exist");
    }
    
    var attrTFList = '<c:out value="${attributeTextFieldList}"/>';	
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
    $("[name=attributeTextField"+(i+1)+"]").val(convert(attrTFList1[i])) ;
    }
    
    var attrTFDateList1 = attrTFDateList.split(",$,");
    for(var i=0;i<attrTFDateList1.length;i++){
    $("[name=attributeTextFieldDate"+(i+1)+"]").val(attrTFDateList1[i]) ;
    }
    
    var attrRButtonList1 = attrRButtonList.split(",$,");
    if(attrRButtonList1[0] === "Yes") { 
        $(".saddr").show(); 
        $("#radio1").prop("checked",true);
    } else if(attrRButtonList1[0] === "No"){
        $("#radio2").prop("checked",true);
    }
    if(attrRButtonList1[1] === "Yes") {
        $(".llc").show();
        $("#radio3").prop("checked",true);
    } else if(attrRButtonList1[1] === "No"){
        $("#radio4").prop("checked",true);
    }
    if(attrRButtonList1[2] === "Yes") {
        $("#radio9").prop("checked",true);
    } else if(attrRButtonList1[2] === "No"){
        $("#radio10").prop("checked",true);
    }
    if(attrRButtonList1[6] === "Yes"){
        $(".ein").show();
        $("#radio5").prop("checked",true);
    } else if(attrRButtonList1[6] === "No"){
        $("#radio6").prop("checked",true);
    }
    if(attrRButtonList1[7] === "Yes") {
        $(".hire").show();
        $("#radio7").prop("checked",true);
    } else if(attrRButtonList1[7] === "No"){
        $("#radio8").prop("checked",true);
    }
    
    var attrCheBoxList1 = attrCheBoxList.split(",$,");
    if(attrCheBoxList1[0] === "nonprofit") {
        $("#check1").prop("checked",true);
    }

    var attrSBoxList1 = attrSBoxList.split(",$,");
    for(var i=0;i<attrSBoxList1.length;i++){
    $("[name=attributeSelectBox"+(i+1)+"]").val(convert(attrSBoxList1[i]));
    }
    
    if($("[name=attributeSelectBox2]").val()==="Sole proprietor"){ $(".sole").show(); }
    if($("[name=attributeSelectBox2]").val()==="Corporation"){ $(".form").show(); }
    if($("[name=attributeSelectBox2]").val()==="Other nonprofit organization"){ $(".nonprofit").show(); }
    if($("[name=attributeSelectBox2]").val()==="Estate (SSN of decedent)"){ $(".ssn").show(); }
    if($("[name=attributeSelectBox2]").val()==="Plan administrator (TIN)"){ $(".admin").show(); }
    if($("[name=attributeSelectBox2]").val()==="Trust (TIN of grantor)"){ $(".trust").show(); }
    if($("[name=attributeSelectBox2]").val()==="Other"){ $(".anyother").show(); }
    if($("[name=attributeSelectBox3]").val()==="Started new business"){ $(".newbus").show(); }
    if($("[name=attributeSelectBox3]").val()==="Hired employees"){ $(".agric").show(); }
    if($("[name=attributeSelectBox3]").val()==="Banking purpose"){ $(".bank").show(); }
    if($("[name=attributeSelectBox3]").val()==="Changed type of organization"){ $(".neworg").show(); }
    if($("[name=attributeSelectBox3]").val()==="Created a trust"){ $(".trusttype").show(); }
    if($("[name=attributeSelectBox3]").val()==="Created a pension plan"){ $(".pension").show(); }
    if($("[name=attributeSelectBox3]").val()==="Other"){ $(".ifany").show(); }
    if($("[name=attributeSelectBox4]").val()==="Other"){ $(".sother").show(); }
    
//  progressBar
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
    if(document.federaltax.attributeTextField1.value!==''){
    var legalName = document.federaltax.attributeTextField1.value;
    newAjaxCallJson(legalName);
    } }

    var choiceRet = true;
    function newAjaxCallJson(selectedData){    	
    	$.ajax({
			type : 'POST',
			url : "jSonFederalTaxLegalName?documentName="+selectedData,
			dataType : 'json',
			async : true,
			cache: false,
			success : function(result) {
				var return_result=JSON.stringify(result);				
				var data=JSON.parse(return_result);				
				
				for(var i=0;i<data.length;i++){
					var value = data[i].UserChoice;					
					if(value !== null){					
						alert("Your Legal Name already exist");
						choiceRet=false;
					} else{
						choiceRet = true;
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
		<progress max="4" value="0" id="progress"></progress>
		</div>
		<div class="alabama">
		<div class="alabama-head">
		<h2>Federal Tax ID (EIN)</h2>
		
		<div class="clearfix"></div>
		</div>		
		
		<div class="principal frame-width">		
		<form action="singleFederalDataModification" method="post" name="federaltax" id="pro-form" >                                    
            <% if (null != session.getAttribute("SFed_Attr_Names")) {
            ArrayList attNamesCorpList = (ArrayList) session.getAttribute("SFed_Attr_Names");            
            if (null != attNamesCorpList && attNamesCorpList.size() > 0) {

            if (null != session.getAttribute("SFed_Attr_Values")) {
            ArrayList attValueCorpList = (ArrayList) session.getAttribute("SFed_Attr_Values");            
            if (null != attValueCorpList && attValueCorpList.size() > 0) {

            if (null != session.getAttribute("SFed_Attr_Req_List")) {
            ArrayList attRequiredList = (ArrayList) session.getAttribute("SFed_Attr_Req_List");            
            if (null != attRequiredList && attRequiredList.size() > 0) {

            if (null != session.getAttribute("SFed_Attr_Status_List")) {
            ArrayList attStatusList = (ArrayList) session.getAttribute("SFed_Attr_Status_List");            
            if (null != attStatusList && attStatusList.size() > 0) {
            %>

            <div id="form-div1" class="box"  style="display: none">
            <table id="form-table1" class="tab">
            <% int i=0,j=0;
            for(i=0,j=0;i<10 && i<attNamesCorpList.size() && j<10 && j<attValueCorpList.size();i++,j++){  %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"><td class="<%=attRequiredList.get(i)%>"><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>

            <%if(i>=10 && i<attNamesCorpList.size()) { %>
            <div id="form-div2" class="box" style="display: none">
            <table id="form-table2" class="tab">
            <% for(i=10,j=10;i<25 && i<attNamesCorpList.size() && j<25 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"><td class="<%=attRequiredList.get(i)%>"><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>

            <% } 
            if(i>=25 && i<attNamesCorpList.size()){ %>
            <div id="form-div3" class="box" style="display: none">
            <table id="form-table3" class="tab"> 
            <% for(i=25,j=25;i<53 && i<attNamesCorpList.size() && j<53 && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"><td class="<%=attRequiredList.get(i)%>"><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>

            <% } 
            if(i>=53 && i<attNamesCorpList.size()){ %>
            <div id="form-div4" class="box" style="display: none">
            <table id="form-table4" class="tab"> 
            <% for(i=53,j=53;i<attNamesCorpList.size() && j<attValueCorpList.size();i++,j++){ %>
            <tr class="<%=attStatusList.get(i)%>"><td id="attribute<%=i%>"><%=attNamesCorpList.get(i)%></td></tr><tr class="<%=attStatusList.get(i)%>" style=" height: 7px;"><td></td></tr>
            <tr class="<%=attStatusList.get(i)%>"><td class="<%=attRequiredList.get(i)%>"><%=attValueCorpList.get(j)%></td></tr> 
            <% } %> </table> </div>            
            <% } } } } } } } } } %>
            <input type="hidden" name="federalFormPageValues"/>
            <input type="hidden" name="federalDocFinishOrderRef" />		
		
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
 
        <script type="text/javascript" src="resources/scripts/federalforms/singlefedtax.js"></script>
    	<script type="text/javascript" src="resources/scripts/jquery.datePicker-min.js"></script>
    	<script type="text/javascript" src="resources/scripts/json-minified.js"></script>
        </body>        
</html>