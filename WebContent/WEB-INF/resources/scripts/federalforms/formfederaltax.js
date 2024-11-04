    $(document).ready(function(){ 
    $("#radio1").click(function(){ $(".saddr").show();});
    $("#radio2").click(function(){ 
    $(".saddr").hide();
    document.federaltax.attributeTextField6.value = "";
    document.federaltax.attributeTextField7.value = "";
    document.federaltax.attributeTextField8.value = "";
    document.federaltax.attributeSelectBox1.value = "";
    document.federaltax.attributeTextField42.value = "";
    });
    $("#radio3").click(function(){ $(".llc").show();});
    $("#radio4").click(function(){ 
    $(".llc").hide();
    document.federaltax.attributeTextField16.value = "";
    document.federaltax.radioButton3[0].checked = false;
    document.federaltax.radioButton3[1].checked = false;
    });
    $("#radio5").click(function(){ $(".ein").show(); });
    $("#radio6").click(function(){ $(".ein").hide();document.federaltax.attributeTextField40.value = "";});
    $("#radio7").click(function(){ $(".hire").show();});
    $("#radio8").click(function(){ $(".hire").hide();document.federaltax.checkBox1.checked = false;});
   
    $("#attributeSelectBoxID2").click(function(){ 
    if($("#attributeSelectBoxID2").val() === "Sole proprietor"){ $(".sole").show();}
    else{ $(".sole").hide();document.federaltax.attributeTextField17.value = "";}
    if($("#attributeSelectBoxID2").val() === "Corporation"){ $(".form").show();}
    else{ $(".form").hide();document.federaltax.attributeTextField18.value = "";}
    if($("#attributeSelectBoxID2").val() === "Other nonprofit organization"){ $(".nonprofit").show();}
    else{ $(".nonprofit").hide(); document.federaltax.attributeTextField19.value = ""; }
    if($("#attributeSelectBoxID2").val() === "Estate (SSN of decedent)"){ $(".ssn").show();}
    else{ $(".ssn").hide();document.federaltax.attributeTextField20.value = "";}
    if($("#attributeSelectBoxID2").val() === "Plan administrator (TIN)"){ $(".admin").show();}
    else{ $(".admin").hide();document.federaltax.attributeTextField21.value = "";}
    if($("#attributeSelectBoxID2").val() === "Trust (TIN of grantor)"){ $(".trust").show();}
    else{ $(".trust").hide();document.federaltax.attributeTextField22.value = "";}
    if($("#attributeSelectBoxID2").val() === "Other"){ $(".anyother").show();}
    else{ $(".anyother").hide();document.federaltax.attributeTextField23.value = "";}
    });
    $("#attributeSelectBoxID3").click(function(){ 
    if($("#attributeSelectBoxID3").val() === "Started new business"){ $(".newbus").show();}
    else{ $(".newbus").hide();document.federaltax.attributeTextField27.value = "";}
    if($("#attributeSelectBoxID3").val() === "Banking purpose"){ $(".bank").show();}
    else{ $(".bank").hide();document.federaltax.attributeTextField32.value = "";}
    if($("#attributeSelectBoxID3").val() === "Changed type of organization"){ $(".neworg").show();}
    else{ $(".neworg").hide();document.federaltax.attributeTextField33.value = "";}
    if($("#attributeSelectBoxID3").val() === "Created a trust"){ $(".trusttype").show();}
    else{ $(".trusttype").hide();document.federaltax.attributeTextField34.value = "";}
    if($("#attributeSelectBoxID3").val() === "Created a pension plan"){ $(".pension").show();}
    else{ $(".pension").hide();document.federaltax.attributeTextField35.value = "";}
    if($("#attributeSelectBoxID3").val() === "Other"){ $(".ifany").show();}
    else{ $(".ifany").hide();document.federaltax.attributeTextField36.value = "";}
    if($("#attributeSelectBoxID3").val() === "Hired employees"){ $(".agric").show();}
    else{ 
    $(".agric, .hire").hide();
    document.federaltax.attributeTextField29.value = ""; document.federaltax.attributeTextField30.value = "";
    document.federaltax.attributeTextField31.value = "";document.federaltax.radioButton8[0].checked = false;
    document.federaltax.radioButton8[1].checked = false;document.federaltax.checkBox1.checked = false;
    }
    });

    $("#attributeSelectBoxID4").click(function(){ 
    if($("#attributeSelectBoxID4").val() === "Other"){ $(".sother").show();}
    else{ $(".sother").hide(); document.federaltax.attributeTextField38.value = ""; }
    });});

    function validation(id){ 
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; var result = true;
    if(id === "form-div1"){ 
    if(reg.test($("input[name='attributeTextField1']").val())){ $("#namelabel").removeClass("redTestDisplay"); }
    else { $("#namelabel").addClass("redTestDisplay");result = false;}
    }
    return result;
    }
    
    function nameValidation(){ 
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
    if(reg.test($("input[name='attributeTextField1']").val())){ $("#namelabel").removeClass("redTestDisplay"); }
    else{ $("#namelabel").addClass("redTestDisplay");}
    if($("input[name='attributeTextField1']").val() === ""){ $("#namelabel").removeClass("redTestDisplay");}
    }

    function numberonly(e, decimal) { 
    var key; var keychar;
    if (window.event) key = window.event.keyCode;
    else if (e)key = e.which;
    else return true;
    keychar = String.fromCharCode(key);
    if ((key === null) || (key === 0) || (key === 8) ||  (key === 9) || (key === 13) || (key === 27) ) return true;
    else if ((("0123456789").indexOf(keychar) > -1)) return true;
    else if (decimal && (keychar === ".")) return true;
    else if (keychar === "-") return true;
    else return false;
    }

    function CheckFirstChar(key, txt){ 
    if(key === 32 && txt.value.length <= 0)return false;
    else if(txt.value.length > 0){ 
    if(txt.value.charCodeAt(0) === 32){ 
    txt.value = txt.value.substring(1,txt.value.length);
    return true;
    } }
    return true;
    }

    function ssnFormat(e,input) { 
    evt = e || window.event; var pressedkey = evt.which || evt.keyCode;
    var BlockedKeyCodes = new Array(0,8,27,13,9); var len = BlockedKeyCodes.length;
    var block = false; var str = '';
    for(i = 0; i < len; i++){ 
    str = BlockedKeyCodes[i].toString();
    if (str.indexOf(pressedkey) >= 0 ) block = true;
    }
    if (block) return true;
    s = input.value;
    if (s.charAt(0)  === '+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{ }ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var i; var returnString = '';
    for(i = 0; i < s.length; i++) { 
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length < 11 )) { 
    if (returnString.length === 3) returnString += '-';
    if (returnString.length === 6) returnString += '-';
    returnString += c;
    } }
    input.value = returnString;
    return false;
    }

    function einFormat(e,input) { 
    evt = e || window.event; var pressedkey = evt.which || evt.keyCode;
    var BlockedKeyCodes = new Array(0,8,27,13,9); var len = BlockedKeyCodes.length;
    var block = false; var str = '';
    for(i = 0; i < len; i++){ 
    str = BlockedKeyCodes[i].toString();
    if (str.indexOf(pressedkey) >= 0 ) block = true;
    }
    if (block) return true;
    s = input.value;
    if (s.charAt(0) === '+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{ }ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var i; var returnString = '';
    for(i = 0; i < s.length; i++) { 
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length < 11 )) { 
    if (returnString.length === 2) returnString += '-';
    returnString += c;
    }}
    input.value = returnString;
    return false;
    }

    $c = 0;
    function prev(){ 
    window.scrollTo(0,0);
    var boxes = $(".box");
    $c -= 1;
    if($c < 0) $c = (boxes.length-1);
    if($c < boxes.length-1){ $("#SaveIBID").show(); $("#FinishIBID").hide();}
    if($c === 0){ $("#PreviousIBID").hide();}
    progressCount = progressCount-1;
    $("#progress").attr("value", progressCount); 
    for(var $i = 0; $i < boxes.length; $i++){ boxes[$i].style.display = "none";}
    boxes[$c].style.display = "block";
    return false;
    }

    function save(){ 
    var flag;
    if($c === 0){
    flag = validation("form-div1"); $("input[name='freeFederalFormPageValues']").val("form-div2");
    } else if($c === 1){
    flag = validation("form-div2"); $("input[name='freeFederalFormPageValues']").val("form-div3");
    } else if($c === 2){
    flag = validation("form-div3"); $("input[name='freeFederalFormPageValues']").val("form-div4");
    } else if($c === 3){ 
    flag = validation("form-div4"); $("input[name='freeFederalFormPageValues']").val("form-div4");
    $("input[name='freeFederalDocFinishOrderRef']").val("Finished");
    }
    if(flag === true){ $("form[name='federaltax']").submit();}
    return false;
    }