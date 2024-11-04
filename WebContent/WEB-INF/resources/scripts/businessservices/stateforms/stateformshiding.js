    //function for show hiding for radio button
    function radioHiding(elem){    
    var result = false; var totalStatus = ""; var tabClass = $(".tab");
    var radioList = ""; var subRadioList = "";
    var status = elem.parentNode.previousSibling.innerHTML;
    if(status !== "null"){
    totalStatus = status.split(";");
    radioList = totalStatus[0].split("#");
    subRadioList = totalStatus[1].split("$"); 
    }
    $("input[name="+elem.name+"]").each(function() {
    var radioClass = $(this).val();
    if($("."+radioClass).length > 0){
    result = true;
    if($(this).is(':checked')){ $("."+radioClass).show(); }
    else { 
    $("."+radioClass).hide();
    $("."+radioClass+" input[type=radio]").each(function() {
    //Code for add another radio button
    if(this.parentNode.previousSibling.className === "no"){
    if($("input[name="+this.name+"]").is(':checked')){
    $(this).closest('tr').show(); $(this).closest('tr').prev('tr').show(); $(this).closest('tr').prev('tr').prev('tr').show(); }
    else {
    $(this).closest('tr').hide(); $(this).closest('tr').prev('tr').hide(); $(this).closest('tr').prev('tr').prev('tr').hide(); }
    }    
    else { $(this).attr("checked",false); }
    });
    $("."+radioClass+" input[type = checkbox]").each(function() { $(this).attr("checked",false); });
    $("."+radioClass+" input[type = text], ."+radioClass+" textarea, ."+radioClass+" select").each(function() { $(this).val(""); });
    }
    }
    //Code for inner radio buttons show hide
    if(radioList.length > 0){
    for(var a=0; a < radioList.length; a++) {
    if(radioClass === radioList[a] && $(this).is(':checked')){
    var innRad = subRadioList[a].split(",");
    for(var b = 0; b < innRad.length; b++) {
    $("."+innRad[b]).hide();
    $("."+innRad[b]+" input[type = radio], ."+innRad[b]+" input[type = checkbox]").each(function() { $(this).attr("checked",false); });
    $("."+innRad[b]+" input[type = text], ."+innRad[b]+" textarea, ."+innRad[b]+" select").each(function() { $(this).val(""); });
    }
    break;
    } } }
    }); 
    if(result === true){
   //Code for next, save and previous buttons displaying after show hide
    for(var j = $c+1; j < tabClass.length; j++){
    var ele = getDisplayElements(document.getElementById(tabClass[j].id));
    if(ele.length > 0){ $("#SaveIBID").show(); $("#FinishIBID").hide(); break;}
    else if(ele.length === 0){ $("#FinishIBID").show(); $("#SaveIBID").hide(); }
    }
    //code for progressbar moving
    maxProgressCount = 0;
    $(".tab").each(function() {
    var ele1 = getDisplayElements(document.getElementById(this.id));
    if(ele1.length > 0){ maxProgressCount = maxProgressCount+1; } 
    });
    $("#progress").prop("max", maxProgressCount);
    }
    }
    
    
    function rb207ShowHide(elem){
    if(elem.value === "commregagent") {
    $(".noncommregagent, .no2").hide(); $(".commregagent").show();
    $(".noncommregagent input[type = text], .no input[type = text]").val("");
    $(".noncommregagent input[type=radio]").attr("checked",false);
    } else if(elem.value === "noncommregagent" || elem.value === "officewithentity"){
    $(".noncommregagent").show(); $(".commregagent").hide();
    $(".commregagent input[type = text]").val("");
    }
    }
    
    function rb372ShowHide(elem){
    if(elem.value === "shareholders"){
    $(".shareholders, .shadervotgroup").show();
    $(".votinggroup, .yes26, .yes27, .yes28, .yes29").hide();
    $(".votinggroup input[type = text],.yes26 input[type = text], .yes27 input[type = text], .yes28 input[type = text], .yes29 input[type = text]").val("");
    $(".votinggroup input[type=radio],.yes26 input[type=radio], .yes27 input[type=radio], .yes28 input[type=radio]").attr("checked",false);
    } else if(elem.value === "shadervotgroup"){
    $(".shareholders, .votinggroup, .shadervotgroup").show();
    } else if(elem.value === "votinggroup"){
    $(".shareholders, .votinggroup").show();
    $(".shadervotgroup").hide();
    $(".shadervotgroup input[type = text]").val("");
    } else if(elem.value === "incorporators"){
    $(".shadervotgroup, .shareholders, .votinggroup, .yes21, .yes22, .yes23, .yes24, .yes25, .yes26, .yes27, .yes28, .yes29").hide();
    $(".shadervotgroup input[type = text], .shareholders input[type = text], .votinggroup input[type = text]").val("");
    $(".yes21 input[type = text], .yes22 input[type = text], .yes23 input[type = text], .yes24 input[type = text], .yes25 input[type = text]").val("");
    $(".yes26 input[type = text], .yes27 input[type = text], .yes28 input[type = text], .yes29 input[type = text]").val("");
    $(".shareholders input[type=radio], .votinggroup input[type=radio]").attr("checked",false);
    $(".yes21 input[type=radio], .yes22 input[type=radio], .yes23 input[type=radio], .yes24 input[type=radio]").attr("checked",false);
    $(".yes26 input[type=radio], .yes27 input[type=radio], .yes28 input[type=radio]").attr("checked",false);
    }
    }
    
    function rb398ShowHide(elem){
    if(elem.value === "shadervotgroup") {
    $(".shareholders, .votinggroup").show();
    } else if(elem.value === "shareholders"){
    $(".shareholders").show(); $(".votinggroup, .yes26, .yes27, .yes28, .yes29").hide();
    $(".votinggroup input[type=radio], .yes26 input[type=radio], .yes27 input[type=radio], .yes28 input[type=radio]").attr("checked",false);
    $(".votinggroup input[type = text], .yes26 input[type = text], .yes27 input[type = text], .yes28 input[type = text], .yes29 input[type = text]").val("");
    } else if(elem.value === "votinggroup"){
    $(".votinggroup").show(); $(".shareholders").hide();
    $(".shareholders input[type = text]").val("");
    } else if(elem.value === "incorporator") {
    $(".shareholders, .votinggroup, .yes26, .yes27, .yes28, .yes29").hide();
    $(".votinggroup input[type=radio], .yes26 input[type=radio], .yes27 input[type=radio], .yes28 input[type=radio]").attr("checked",false);
    $(".shareholders input[type = text], .votinggroup input[type = text], .yes26 input[type = text], .yes27 input[type = text], .yes28 input[type = text], .yes29 input[type = text]").val("");
    }
    }