    $c = 0;
    function prev(){ 
    var boxes = $(".box");
    window.scrollTo(0,0);
    $c -= 1;
    if($c < 0) $c = (boxes.length-1);
    if($c < boxes.length-1){ $("#SaveIBID").show(); $("#FinishIBID").hide();}
    if($c === 0){ $("#PreviousIBID").hide(); }
    progressCount = progressCount-1;
    $("#progress").attr("value", progressCount);
    for(var $i = 0; $i < boxes.length; $i++){ boxes[$i].style.display = "none"; }
    boxes[$c].style.display = "block";
    return false;
    }

    function save(){ 
    var res = true;    
    var flag = validation();
    if($c === 0){ $("input[name='fiveZeroOneFormPageValues']").val("form-div2");}
    else if($c === 1){ $("input[name='fiveZeroOneFormPageValues']").val("form-div3"); }
    else if($c === 2){ $("input[name='fiveZeroOneFormPageValues']").val("form-div4"); }
    else if($c === 3){ $("input[name='fiveZeroOneFormPageValues']").val("form-div5"); }
    else if($c === 4){ $("input[name='fiveZeroOneFormPageValues']").val("form-div6"); }
    else if($c === 5){ $("input[name='fiveZeroOneFormPageValues']").val("form-div7"); }
    else if($c === 6){ $("input[name='fiveZeroOneFormPageValues']").val("form-div8"); }
    else if($c === 7){ $("input[name='fiveZeroOneFormPageValues']").val("form-div9"); }
    else if($c === 8){ $("input[name='fiveZeroOneFormPageValues']").val("form-div10"); }
    else if($c === 9){ $("input[name='fiveZeroOneFormPageValues']").val("form-div11"); }
    else if($c === 10){ $("input[name='fiveZeroOneFormPageValues']").val("form-div12"); }
    else if($c === 11){ $("input[name='fiveZeroOneFormPageValues']").val("form-div13"); }
    else if($c === 12){ 
    $("input[name='fiveZeroOneFormPageValues']").val("form-div13");
    $("input[name='fiveZeroOneFinishOrderRef']").val("Finished");
    }
    if(flag === true){ 
    if($("input[name='attributeTextField1']").val() !== ""){ newAjaxCall();res = choiceReturn; }
    if(res === true){ $("form[name='fiveZeroOne']").submit(); }
    }
    return false;
    }

    function validation(){ 
    var name = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; var result = true;
    if(name.test($("input[name='attributeTextField1']").val())){ $("#attribute0").removeClass("redTestDisplay"); }
    else{ $("#attribute0").addClass("redTestDisplay"); result = false;
    }
    return result;
    }

    function attributeTextField1Validation(curObj){ 
    var nameReg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
    if(nameReg.test(curObj.value)){ $("#attribute0").removeClass("redTestDisplay");}
    else{ $("#attribute0").addClass("redTestDisplay");
    if(curObj.value === ""){ $("#attribute0").removeClass("redTestDisplay"); }
    } }

    var key;
    function numberonly(e, decimal) { 
    var keychar;
    if (window.event) key = window.event.keyCode;
    else if (e) key = e.which;
    else return true;
    keychar = String.fromCharCode(key);
    if ((key === null) || (key === 0) || (key === 8) ||  (key === 9) || (key === 13) || (key === 27) ) return true;
    else if ((("0123456789").indexOf(keychar) > -1)) return true;
    else if (decimal && (keychar === ".")) return true;
    else if (keychar === "-") return true;
    else return false;
    }

    function onlyForNumbers(e, decimal) {
        var ret; var keychar;
        if (window.event) {key = window.event.keyCode;}
        else if (e) { key = e.which; }
        else {ret= true;}
        keychar = String.fromCharCode(key);
        if (decimal.value === ".") {decimal.value="";}
        if ((key === null) || (key === 0) || (key === 8) || (key === 9) || (key === 13) || (key === 27) ) { ret= true; }
        else if ((("0123456789").indexOf(keychar) > -1)) {ret= true;}
        else if (keychar === "." && decimal.value.length === 0) ret=false;
        else if (keychar === "." && decimal.value.length > 0) ret=true;
        else return ret=false;
        return ret;
        }

    function CheckFirstChar(key, txt){ 
    if(key === 32 && txt.value.length <= 0) return false;
    else if(txt.value.length > 0){ 
    if(txt.value.charCodeAt(0) === 32){ 
    txt.value = txt.value.substring(1,txt.value.length);
    return true;
    } }
    return true;
    }
  
    function phoneFormat (e,input) { 
    evt = e || window.event; /* firefox uses reserved object e for event */
    var pressedkey = evt.which || evt.keyCode; var BlockedKeyCodes = new Array(0,8,27,13,9); //8 is backspace key
    var len = BlockedKeyCodes.length; var block = false; var str = '';
    for(var i = 0; i < len; i++){ 
    str = BlockedKeyCodes[i].toString();
    if (str.indexOf(pressedkey) >= 0 ) block = true;
    }
    if (block) return true;
    s = input.value;
    if (s.charAt(0) === '+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{ }ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var returnString = '';
    for(var i = 0; i < s.length; i++) { 
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length < 12 )) { 
    if (returnString.length === 3) returnString += '-';
    if (returnString.length === 7) returnString += '-';
    returnString += c;
    } }
    input.value = returnString;
    return false;
    }

    function zipplus4Format (e,input) { 
    evt = e || window.event; 
    var pressedkey = evt.which || evt.keyCode; var BlockedKeyCodes = new Array(0,8,27,13,9); //8 is backspace key
    var len = BlockedKeyCodes.length; var block = false; var str = '';
    for(var i = 0; i < len; i++){ 
    str = BlockedKeyCodes[i].toString();
    if (str.indexOf(pressedkey) >= 0 ) block = true;
    }
    if (block) return true;
    s = input.value;
    if (s.charAt(0) === '+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{ }ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var returnString = '';
    for(var i = 0; i < s.length; i++) { 
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length < 10 )) { 
    if (returnString.length === 5) returnString += '-';
    returnString += c;
    } }
    input.value = returnString;
    return false;
    }

    function tatalAmount(){ 
    var total1 = 0,total2 = 0,total3 = 0,total4 = 0,total5 = 0,total6 = 0,total7 = 0,total8 = 0,total9 = 0,total10 = 0,total11 = 0,total12 = 0,total13 = 0,total14 = 0,total15 = 0,
    total16 = 0,total17 = 0,total18 = 0,total19 = 0,total20 = 0,total21 = 0,total22 = 0, total23 = 0, total24 = 0, total25 = 0, total26 = 0, total27 = 0, total28 = 0, total29 = 0, total30 = 0;
    for(var i = 19; i <= 25; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total1 = parseFloat($("#attributeTextFieldNumber"+i).val())+total1; }
    if(total1 === 0){ $("#attributeTextFieldNumber26").val(""); }
    else{ $("#attributeTextFieldNumber26").val(total1); }
    }
    for(var i = 26; i <= 27; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total2 = parseFloat($("#attributeTextFieldNumber"+i).val())+total2; }
    if(total2 === 0){ $("#attributeTextFieldNumber28").val(""); }
    else{ $("#attributeTextFieldNumber28").val(total2); }
    }
    for(var i = 28; i <= 30; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total3 = parseFloat($("#attributeTextFieldNumber"+i).val())+total3; }
    if(total3 === 0){ $("#attributeTextFieldNumber31").val(""); }
    else{ $("#attributeTextFieldNumber31").val(total3); }
    }
    for(var i = 32; i <= 41; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total4 = parseFloat($("#attributeTextFieldNumber"+i).val())+total4; }
    if(total4 === 0){ $("#attributeTextFieldNumber42").val(""); }
    else{ $("#attributeTextFieldNumber42").val(total4); }
    }
    for(var i = 43; i <= 49; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total5 = parseFloat($("#attributeTextFieldNumber"+i).val())+total5; }
    if(total5 === 0){ $("#attributeTextFieldNumber50").val(""); }
    else{ $("#attributeTextFieldNumber50").val(total5); }
    }
    for(var i = 50; i <= 51; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total6 = parseFloat($("#attributeTextFieldNumber"+i).val())+total6; }
    if(total6 === 0){ $("#attributeTextFieldNumber52").val(""); }
    else{ $("#attributeTextFieldNumber52").val(total6); }
    }
    for(var i = 52; i <= 54; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total7 = parseFloat($("#attributeTextFieldNumber"+i).val())+total7; }
    if(total7 === 0){ $("#attributeTextFieldNumber55").val(""); }
    else{ $("#attributeTextFieldNumber55").val(total7); }
    }
    for(var i = 56; i <= 65; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total8 = parseFloat($("#attributeTextFieldNumber"+i).val())+total8; }
    if(total8 === 0){ $("#attributeTextFieldNumber66").val(""); }
    else{ $("#attributeTextFieldNumber66").val(total8); }
    }
    for(var i = 67; i <= 73; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total9 = parseFloat($("#attributeTextFieldNumber"+i).val())+total9; }
    if(total9 === 0){ $("#attributeTextFieldNumber74").val(""); }
    else{ $("#attributeTextFieldNumber74").val(total9); }
    }
    for(var i = 74; i <= 75; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total10 = parseFloat($("#attributeTextFieldNumber"+i).val())+total10; }
    if(total10 === 0){ $("#attributeTextFieldNumber76").val(""); }
    else{ $("#attributeTextFieldNumber76").val(total10); }
    }
    for(var i = 76; i <= 78; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total11 = parseFloat($("#attributeTextFieldNumber"+i).val())+total11; }
    if(total11 === 0){ $("#attributeTextFieldNumber79").val(""); }
    else{ $("#attributeTextFieldNumber79").val(total11); }
    }
    for(var i = 80; i <= 89; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total12 = parseFloat($("#attributeTextFieldNumber"+i).val())+total12; }
    if(total12 === 0){ $("#attributeTextFieldNumber90").val(""); }
    else{ $("#attributeTextFieldNumber90").val(total12); }
    }
    for(var i = 91; i <= 97; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total13 = parseFloat($("#attributeTextFieldNumber"+i).val())+total13; }
    if(total13 === 0){ $("#attributeTextFieldNumber98").val(""); }
    else{ $("#attributeTextFieldNumber98").val(total13); }
    }
    for(var i = 98; i <= 99; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total14 = parseFloat($("#attributeTextFieldNumber"+i).val())+total14; }
    if(total14 === 0){ $("#attributeTextFieldNumber100").val(""); }
    else{ $("#attributeTextFieldNumber100").val(total14); }
    }
    for(var i = 100; i <= 102; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total16 = parseFloat($("#attributeTextFieldNumber"+i).val())+total16; }
    if(total16 === 0){ $("#attributeTextFieldNumber103").val(""); }
    else{ $("#attributeTextFieldNumber103").val(total16); }
    }
    for(var i = 104; i <= 113; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total17 = parseFloat($("#attributeTextFieldNumber"+i).val())+total17; }
    if(total17 === 0){ $("#attributeTextFieldNumber114").val(""); }
    else{ $("#attributeTextFieldNumber114").val(total17); }
    }
    var attribute1 = $("#attributeTextFieldNumber19").val(); var attribute2 = $("#attributeTextFieldNumber43").val();
    var attribute3 = $("#attributeTextFieldNumber67").val(); var attribute4 = $("#attributeTextFieldNumber91").val();
    if(attribute1 === "") attribute1 = 0; if(attribute2 === "") attribute2 = 0;
    if(attribute3 === "") attribute3 = 0; if(attribute4 === "") attribute4 = 0;
    total18 = parseFloat(attribute1)+parseFloat(attribute2)+parseFloat(attribute3)+parseFloat(attribute4);
    if(total18 === 0){ $("#attributeTextFieldNumber115").val(""); }
    else{ $("#attributeTextFieldNumber115").val(total18); }
    var attribute5 = $("#attributeTextFieldNumber20").val(); var attribute6 = $("#attributeTextFieldNumber44").val();
    var attribute7 = $("#attributeTextFieldNumber68").val(); var attribute8 = $("#attributeTextFieldNumber92").val();
    if(attribute5 === "") attribute5 = 0; if(attribute6 === "") attribute6 = 0;
    if(attribute7 === "") attribute7 = 0; if(attribute8 === "") attribute8 = 0;
    total19 = parseFloat(attribute5)+parseFloat(attribute6)+parseFloat(attribute7)+parseFloat(attribute8);
    if(total19 === 0){ $("#attributeTextFieldNumber116").val(""); }
    else{ $("#attributeTextFieldNumber116").val(total19); }
    var attribute9 = $("#attributeTextFieldNumber21").val(); var attribute10 = $("#attributeTextFieldNumber45").val();
    var attribute11 = $("#attributeTextFieldNumber69").val(); var attribute12 = $("#attributeTextFieldNumber93").val();
    if(attribute9 === "") attribute9 = 0; if(attribute10 === "") attribute10 = 0;
    if(attribute11 === "") attribute11 = 0; if(attribute12 === "") attribute12 = 0;
    total20 = parseFloat(attribute9)+parseFloat(attribute10)+parseFloat(attribute11)+parseFloat(attribute12);
    if(total20 === 0){ $("#attributeTextFieldNumber117").val(""); }
    else{ $("#attributeTextFieldNumber117").val(total20); }
    var attribute13 = $("#attributeTextFieldNumber22").val(); var attribute14 = $("#attributeTextFieldNumber46").val();
    var attribute15 = $("#attributeTextFieldNumber70").val(); var attribute16 = $("#attributeTextFieldNumber94").val();
    if(attribute13 === "") attribute13 = 0; if(attribute14 === "") attribute14 = 0;
    if(attribute15 === "") attribute15 = 0; if(attribute16 === "") attribute16 = 0;
    total21 = parseFloat(attribute13)+parseFloat(attribute14)+parseFloat(attribute15)+parseFloat(attribute16);
    if(total21 === 0){ $("#attributeTextFieldNumber118").val(""); }
    else{ $("#attributeTextFieldNumber118").val(total21); }
    var attribute17 = $("#attributeTextFieldNumber23").val(); var attribute18 = $("#attributeTextFieldNumber47").val();
    var attribute19 = $("#attributeTextFieldNumber71").val(); var attribute20 = $("#attributeTextFieldNumber95").val();
    if(attribute17 === "") attribute17 = 0; if(attribute18 === "") attribute18 = 0;
    if(attribute19 === "") attribute19 = 0; if(attribute20 === "") attribute20 = 0;
    total22 = parseFloat(attribute17)+parseFloat(attribute18)+parseFloat(attribute19)+parseFloat(attribute20);
    if(total22 === 0){ $("#attributeTextFieldNumber119").val(""); }
    else{ $("#attributeTextFieldNumber119").val(total22); }
    var attribute21 = $("#attributeTextFieldNumber24").val(); var attribute22 = $("#attributeTextFieldNumber48").val();
    var attribute23 = $("#attributeTextFieldNumber72").val(); var attribute24 = $("#attributeTextFieldNumber96").val();
    if(attribute21 === "") attribute21 = 0; if(attribute22 === "") attribute22 = 0;
    if(attribute23 === "") attribute23 = 0; if(attribute24 === "") attribute24 = 0;
    total23 = parseFloat(attribute21)+parseFloat(attribute22)+parseFloat(attribute23)+parseFloat(attribute24);
    if(total23 === 0){ $("#attributeTextFieldNumber120").val(""); }
    else{ $("#attributeTextFieldNumber120").val(total23); }
    var attribute25 = $("#attributeTextFieldNumber25").val(); var attribute26 = $("#attributeTextFieldNumber49").val();
    var attribute27 = $("#attributeTextFieldNumber73").val(); var attribute28 = $("#attributeTextFieldNumber97").val();
    if(attribute25 === "") attribute25 = 0; if(attribute26 === "") attribute26 = 0;
    if(attribute27 === "") attribute27 = 0; if(attribute28 === "") attribute28 = 0;
    total24 = parseFloat(attribute25)+parseFloat(attribute26)+parseFloat(attribute27)+parseFloat(attribute28);
    if(total24 === 0){ $("#attributeTextFieldNumber121").val(""); }
    else{ $("#attributeTextFieldNumber121").val(total24); }
    var attribute29 = $("#attributeTextFieldNumber26").val(); var attribute30 = $("#attributeTextFieldNumber50").val();
    var attribute31 = $("#attributeTextFieldNumber74").val(); var attribute32 = $("#attributeTextFieldNumber98").val();
    if(attribute29 === "") attribute29 = 0; if(attribute30 === "") attribute30 = 0;
    if(attribute31 === "") attribute31 = 0; if(attribute32 === "") attribute32 = 0;
    total25 = parseFloat(attribute29)+parseFloat(attribute30)+parseFloat(attribute31)+parseFloat(attribute32);
    if(total25 === 0){ $("#attributeTextFieldNumber122").val(""); }
    else{ $("#attributeTextFieldNumber122").val(total25); }
    var attribute33 = $("#attributeTextFieldNumber27").val(); var attribute34 = $("#attributeTextFieldNumber51").val();
    var attribute35 = $("#attributeTextFieldNumber75").val(); var attribute36 = $("#attributeTextFieldNumber99").val();
    if(attribute33 === "") attribute33 = 0; if(attribute34 === "") attribute34 = 0;
    if(attribute35 === "") attribute35 = 0; if(attribute36 === "") attribute36 = 0;
    total26 = parseFloat(attribute33)+parseFloat(attribute34)+parseFloat(attribute35)+parseFloat(attribute36);
    if(total26 === 0){ $("#attributeTextFieldNumber123").val(""); }
    else{ $("#attributeTextFieldNumber123").val(total26); }
    var attribute37 = $("#attributeTextFieldNumber28").val(); var attribute38 = $("#attributeTextFieldNumber52").val();
    var attribute39 = $("#attributeTextFieldNumber76").val(); var attribute40 = $("#attributeTextFieldNumber100").val();
    if(attribute37 === "") attribute37 = 0; if(attribute38 === "") attribute38 = 0;
    if(attribute39 === "") attribute39 = 0; if(attribute40 === "") attribute40 = 0;
    total27 = parseFloat(attribute37)+parseFloat(attribute38)+parseFloat(attribute39)+parseFloat(attribute40);
    if(total27 === 0){ $("#attributeTextFieldNumber124").val(""); }
    else{ $("#attributeTextFieldNumber124").val(total27); }
    var attribute41 = $("#attributeTextFieldNumber29").val(); var attribute42 = $("#attributeTextFieldNumber53").val();
    var attribute43 = $("#attributeTextFieldNumber77").val(); var attribute44 = $("#attributeTextFieldNumber101").val();
    if(attribute41 === "") attribute41 = 0; if(attribute42 === "") attribute42 = 0;
    if(attribute43 === "") attribute43 = 0; if(attribute44 === "") attribute44 = 0;
    total28 = parseFloat(attribute41)+parseFloat(attribute42)+parseFloat(attribute43)+parseFloat(attribute44);
    if(total28 === 0){ $("#attributeTextFieldNumber125").val(""); }
    else{ $("#attributeTextFieldNumber125").val(total28); }
    var attribute45 = $("#attributeTextFieldNumber30").val(); var attribute46 = $("#attributeTextFieldNumber54").val();
    var attribute47 = $("#attributeTextFieldNumber78").val(); var attribute48 = $("#attributeTextFieldNumber102").val();
    if(attribute45 === "") attribute45 = 0; if(attribute46 === "") attribute46 = 0;
    if(attribute47 === "") attribute47 = 0; if(attribute48 === "") attribute48 = 0;
    total29 = parseFloat(attribute45)+parseFloat(attribute46)+parseFloat(attribute47)+parseFloat(attribute48);
    if(total29 === 0){ $("#attributeTextFieldNumber126").val(""); }
    else{ $("#attributeTextFieldNumber126").val(total29); }
    var attribute49 = $("#attributeTextFieldNumber31").val(); var attribute50 = $("#attributeTextFieldNumber55").val();
    var attribute51= $("#attributeTextFieldNumber79").val(); var attribute52 = $("#attributeTextFieldNumber103").val();
    if(attribute49 === "") attribute49 = 0; if(attribute50 === "") attribute50 = 0;
    if(attribute51 === "") attribute51 = 0; if(attribute52 === "") attribute52 = 0;
    total30 = parseFloat(attribute49)+parseFloat(attribute50)+parseFloat(attribute51)+parseFloat(attribute52);
    if(total30 === 0){ $("#attributeTextFieldNumber127").val(""); }
    else{ $("#attributeTextFieldNumber127").val(total30); }
    }

    function bsTotalAmount(){ 
    var total1 = 0, total2 = 0, total3 = 0;
    for(var i = 128; i <= 137; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total1 = parseFloat($("#attributeTextFieldNumber"+i).val())+total1; }
    if(total1 === 0){ $("#attributeTextFieldNumber138").val(""); }
    else{ $("#attributeTextFieldNumber138").val(total1); }
    }
    for(var i = 139; i <= 142; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total2 = parseFloat($("#attributeTextFieldNumber"+i).val())+total2; }
    if(total2 === 0){ $("#attributeTextFieldNumber143").val(""); }
    else{ $("#attributeTextFieldNumber143").val(total2); }
    }
    for(var i = 143; i <= 144; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total3 = parseFloat($("#attributeTextFieldNumber"+i).val())+total3; }
    if(total3 === 0){ $("#attributeTextFieldNumber145").val(""); }
    else{ $("#attributeTextFieldNumber145").val(total3); }
    }
    }

    function racialTotalAmount(){ 
    var total2 = 0, total3 = 0, total4 = 0, total5 = 0, total6 = 0, total7 = 0;
    var attribute6 = $("#attributeTextFieldNumber147").val(); var attribute7 = $("#attributeTextFieldNumber154").val();
    var attribute8 = $("#attributeTextFieldNumber161").val(); var attribute9 = $("#attributeTextFieldNumber168").val();
    var attribute10 = $("#attributeTextFieldNumber175").val();
    if(attribute6 === "") attribute6 = 0; if(attribute7 === "") attribute7 = 0;  
    if(attribute8 === "") attribute8 = 0; if(attribute9 === "") attribute9 = 0;  
    if(attribute10 === "") attribute10 = 0;
    total2 = parseFloat(attribute6)+parseFloat(attribute7)+parseFloat(attribute8)+parseFloat(attribute9)+parseFloat(attribute10);
    if(total2 === 0){ $("#attributeTextFieldNumber182").val(""); }
    else{ $("#attributeTextFieldNumber182").val(total2); }
    var attribute11 = $("#attributeTextFieldNumber148").val(); var attribute12 = $("#attributeTextFieldNumber155").val();
    var attribute13 = $("#attributeTextFieldNumber162").val(); var attribute14 = $("#attributeTextFieldNumber169").val();
    var attribute15 = $("#attributeTextFieldNumber176").val();
    if(attribute11 === "") attribute11 = 0; if(attribute12 === "") attribute12 = 0;  
    if(attribute13 === "") attribute13 = 0; if(attribute14 === "") attribute14 = 0;  
    if(attribute15 === "") attribute15 = 0;
    total3 = parseFloat(attribute11)+parseFloat(attribute12)+parseFloat(attribute13)+parseFloat(attribute14)+parseFloat(attribute15);
    if(total3 === 0){ $("#attributeTextFieldNumber183").val(""); }
    else{ $("#attributeTextFieldNumber183").val(total3); }
    var attribute16 = $("#attributeTextFieldNumber149").val(); var attribute17 = $("#attributeTextFieldNumber156").val();
    var attribute18 = $("#attributeTextFieldNumber163").val(); var attribute19 = $("#attributeTextFieldNumber170").val();
    var attribute20 = $("#attributeTextFieldNumber177").val();
    if(attribute16 === "") attribute16 = 0; if(attribute17 === "") attribute17 = 0;  
    if(attribute18 === "") attribute18 = 0; if(attribute19 === "") attribute19 = 0;  
    if(attribute20 === "") attribute20 = 0;
    total4 = parseFloat(attribute16)+parseFloat(attribute17)+parseFloat(attribute18)+parseFloat(attribute19)+parseFloat(attribute20);
    if(total4 === 0){ $("#attributeTextFieldNumber184").val(""); }
    else{ $("#attributeTextFieldNumber184").val(total4); }
    var attribute21 = $("#attributeTextFieldNumber150").val(); var attribute22 = $("#attributeTextFieldNumber157").val();
    var attribute23 = $("#attributeTextFieldNumber164").val(); var attribute24 = $("#attributeTextFieldNumber171").val();
    var attribute25 = $("#attributeTextFieldNumber178").val();
    if(attribute21 === "") attribute21 = 0; if(attribute22 === "") attribute22 = 0;  
    if(attribute23 === "") attribute23 = 0; if(attribute24 === "") attribute24 = 0;  
    if(attribute25 === "") attribute25 = 0;
    total5 = parseFloat(attribute21)+parseFloat(attribute22)+parseFloat(attribute23)+parseFloat(attribute24)+parseFloat(attribute25);
    if(total5 === 0){ $("#attributeTextFieldNumber185").val(""); }
    else{ $("#attributeTextFieldNumber185").val(total5); }
    var attribute26 = $("#attributeTextFieldNumber151").val(); var attribute27 = $("#attributeTextFieldNumber158").val();
    var attribute28 = $("#attributeTextFieldNumber165").val(); var attribute29 = $("#attributeTextFieldNumber172").val();
    var attribute30 = $("#attributeTextFieldNumber179").val();
    if(attribute26 === "") attribute26 = 0; if(attribute27 === "") attribute27 = 0;  
    if(attribute28 === "") attribute28 = 0; if(attribute29 === "") attribute29 = 0;  
    if(attribute30 === "") attribute30 = 0;
    total6 = parseFloat(attribute26)+parseFloat(attribute27)+parseFloat(attribute28)+parseFloat(attribute29)+parseFloat(attribute30);
    if(total6 === 0){ $("#attributeTextFieldNumber186").val(""); }
    else{ $("#attributeTextFieldNumber186").val(total6); }
    var attribute31 = $("#attributeTextFieldNumber152").val(); var attribute32 = $("#attributeTextFieldNumber159").val();
    var attribute33 = $("#attributeTextFieldNumber166").val(); var attribute34 = $("#attributeTextFieldNumber173").val();
    var attribute35 = $("#attributeTextFieldNumber180").val();
    if(attribute31 === "") attribute31 = 0; if(attribute32 === "") attribute32 = 0;  
    if(attribute33 === "") attribute33 = 0; if(attribute34 === "") attribute34 = 0;  
    if(attribute35 === "") attribute35 = 0;
    total7 = parseFloat(attribute31)+parseFloat(attribute32)+parseFloat(attribute33)+parseFloat(attribute34)+parseFloat(attribute35);
    if(total7 === 0){ $("#attributeTextFieldNumber187").val(""); }
    else{ $("#attributeTextFieldNumber187").val(total7); }
    }

    function racialTotalAmount1(){ 
    var total2 = 0, total3 = 0, total4 = 0, total5 = 0, total6 = 0, total7 = 0, total8 = 0, total9 = 0;
    var attribute6 = $("#attributeTextFieldNumber189").val(); var attribute7 = $("#attributeTextFieldNumber198").val();
    var attribute8 = $("#attributeTextFieldNumber207").val(); var attribute9 = $("#attributeTextFieldNumber216").val();
    var attribute10 = $("#attributeTextFieldNumber225").val();
    if(attribute6 === "") attribute6 = 0; if(attribute7 === "") attribute7 = 0;  
    if(attribute8 === "") attribute8 = 0; if(attribute9 === "") attribute9 = 0;  
    if(attribute10 === "") attribute10 = 0;
    total2 = parseFloat(attribute6)+parseFloat(attribute7)+parseFloat(attribute8)+parseFloat(attribute9)+parseFloat(attribute10);
    if(total2 === 0){ $("#attributeTextFieldNumber234").val(""); }
    else{ $("#attributeTextFieldNumber234").val(total2); }
    var attribute11 = $("#attributeTextFieldNumber190").val(); var attribute12 = $("#attributeTextFieldNumber199").val();
    var attribute13 = $("#attributeTextFieldNumber208").val(); var attribute14 = $("#attributeTextFieldNumber217").val();
    var attribute15 = $("#attributeTextFieldNumber226").val();
    if(attribute11 === "") attribute11 = 0; if(attribute12 === "") attribute12 = 0;  
    if(attribute13 === "") attribute13 = 0; if(attribute14 === "") attribute14 = 0;  
    if(attribute15 === "") attribute15 = 0;
    total3 = parseFloat(attribute11)+parseFloat(attribute12)+parseFloat(attribute13)+parseFloat(attribute14)+parseFloat(attribute15);
    if(total3 === 0){ $("#attributeTextFieldNumber235").val(""); }
    else{ $("#attributeTextFieldNumber235").val(total3); }
    var attribute16 = $("#attributeTextFieldNumber191").val(); var attribute17 = $("#attributeTextFieldNumber200").val();
    var attribute18 = $("#attributeTextFieldNumber209").val(); var attribute19 = $("#attributeTextFieldNumber218").val();
    var attribute20 = $("#attributeTextFieldNumber227").val();
    if(attribute16 === "") attribute16 = 0; if(attribute17 === "") attribute17 = 0;  
    if(attribute18 === "") attribute18 = 0; if(attribute19 === "") attribute19 = 0;  
    if(attribute20 === "") attribute20 = 0;
    total4 = parseFloat(attribute16)+parseFloat(attribute17)+parseFloat(attribute18)+parseFloat(attribute19)+parseFloat(attribute20);
    if(total4 === 0){ $("#attributeTextFieldNumber236").val(""); }
    else{ $("#attributeTextFieldNumber236").val(total4); }
    var attribute21 = $("#attributeTextFieldNumber192").val(); var attribute22 = $("#attributeTextFieldNumber201").val();
    var attribute23 = $("#attributeTextFieldNumber210").val(); var attribute24 = $("#attributeTextFieldNumber219").val();
    var attribute25 = $("#attributeTextFieldNumber228").val();
    if(attribute21 === "") attribute21 = 0; if(attribute22 === "") attribute22 = 0;  
    if(attribute23 === "") attribute23 = 0; if(attribute24 === "") attribute24 = 0;  
    if(attribute25 === "") attribute25 = 0;
    total5 = parseFloat(attribute21)+parseFloat(attribute22)+parseFloat(attribute23)+parseFloat(attribute24)+parseFloat(attribute25);
    if(total5 === 0){ $("#attributeTextFieldNumber237").val(""); }
    else{ $("#attributeTextFieldNumber237").val(total5); }
    var attribute26 = $("#attributeTextFieldNumber193").val(); var attribute27 = $("#attributeTextFieldNumber202").val();
    var attribute28 = $("#attributeTextFieldNumber211").val(); var attribute29 = $("#attributeTextFieldNumber220").val();
    var attribute30 = $("#attributeTextFieldNumber229").val();
    if(attribute26 === "") attribute26 = 0; if(attribute27 === "") attribute27 = 0;  
    if(attribute28 === "") attribute28 = 0; if(attribute29 === "") attribute29 = 0;  
    if(attribute30 === "") attribute30 = 0;
    total6 = parseFloat(attribute26)+parseFloat(attribute27)+parseFloat(attribute28)+parseFloat(attribute29)+parseFloat(attribute30);
    if(total6 === 0){ $("#attributeTextFieldNumber238").val(""); }
    else{ $("#attributeTextFieldNumber238").val(total6); }
    var attribute31 = $("#attributeTextFieldNumber194").val(); var attribute32 = $("#attributeTextFieldNumber203").val();
    var attribute33 = $("#attributeTextFieldNumber212").val(); var attribute34 = $("#attributeTextFieldNumber221").val();
    var attribute35 = $("#attributeTextFieldNumber230").val();
    if(attribute31 === "") attribute31 = 0; if(attribute32 === "") attribute32 = 0;  
    if(attribute33 === "") attribute33 = 0; if(attribute34 === "") attribute34 = 0;  
    if(attribute35 === "") attribute35 = 0;
    total7 = parseFloat(attribute31)+parseFloat(attribute32)+parseFloat(attribute33)+parseFloat(attribute34)+parseFloat(attribute35);
    if(total7 === 0){ $("#attributeTextFieldNumber239").val(""); }
    else{ $("#attributeTextFieldNumber239").val(total7); }
    var attribute36 = $("#attributeTextFieldNumber195").val(); var attribute37 = $("#attributeTextFieldNumber204").val();
    var attribute38 = $("#attributeTextFieldNumber213").val(); var attribute39 = $("#attributeTextFieldNumber222").val();
    var attribute40 = $("#attributeTextFieldNumber231").val();
    if(attribute36 === "") attribute36 = 0; if(attribute37 === "") attribute37 = 0;  
    if(attribute38 === "") attribute38 = 0; if(attribute39 === "") attribute39 = 0;  
    if(attribute40 === "") attribute40 = 0;
    total8 = parseFloat(attribute36)+parseFloat(attribute37)+parseFloat(attribute38)+parseFloat(attribute39)+parseFloat(attribute40);
    if(total8 === 0){ $("#attributeTextFieldNumber240").val(""); }
    else{ $("#attributeTextFieldNumber240").val(total8); }
    var attribute41 = $("#attributeTextFieldNumber196").val(); var attribute42 = $("#attributeTextFieldNumber205").val();
    var attribute43 = $("#attributeTextFieldNumber214").val(); var attribute44 = $("#attributeTextFieldNumber223").val();
    var attribute45 = $("#attributeTextFieldNumber232").val();
    if(attribute41 === "") attribute41 = 0; if(attribute42 === "") attribute42 = 0;  
    if(attribute43 === "") attribute43 = 0; if(attribute44 === "") attribute44 = 0;  
    if(attribute45 === "") attribute45 = 0;
    total9 = parseFloat(attribute41)+parseFloat(attribute42)+parseFloat(attribute43)+parseFloat(attribute44)+parseFloat(attribute45);
    if(total9 === 0){ $("#attributeTextFieldNumber241").val(""); }
    else{ $("#attributeTextFieldNumber241").val(total9); }
    }

    function revenueAmount(){ 
    var total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0, total6 = 0, total7 = 0, total8 = 0, total9 = 0,total10 = 0,total11 = 0,total12 = 0,total13 = 0,total14 = 0,total15 = 0,total16 = 0,total17 = 0,total18 = 0,total19 = 0;
    for(var i = 247; i <= 253; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total1 = parseFloat($("#attributeTextFieldNumber"+i).val())+total1; }
    if(total1 === 0){ $("#attributeTextFieldNumber254").val(""); }
    else{ $("#attributeTextFieldNumber254").val(total1); }
    }
    for(var i = 254; i <= 255; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){  total2 = parseFloat($("#attributeTextFieldNumber"+i).val())+total2; }
    if(total2 === 0){ $("#attributeTextFieldNumber256").val(""); }
    else{ $("#attributeTextFieldNumber256").val(total2); }
    }
    for(var i = 256; i <= 258; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total3 = parseFloat($("#attributeTextFieldNumber"+i).val())+total3;}
    if(total3 === 0){ $("#attributeTextFieldNumber259").val(""); }
    else{ $("#attributeTextFieldNumber259").val(total3); }
    }
    for(var i = 260; i <= 266; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total4 = parseFloat($("#attributeTextFieldNumber"+i).val())+total4; }
    if(total4 === 0){ $("#attributeTextFieldNumber267").val(""); }
    else{ $("#attributeTextFieldNumber267").val(total4); }
    }
    for(var i = 267; i <= 268; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total5 = parseFloat($("#attributeTextFieldNumber"+i).val())+total5; }
    if(total5 === 0){ $("#attributeTextFieldNumber269").val(""); }
    else{ $("#attributeTextFieldNumber269").val(total5); }
    }
    for(var i = 269; i <= 271; i++){ 
    if($("#attributeTextFieldNumber"+i).val() !== ""){ total6 = parseFloat($("#attributeTextFieldNumber"+i).val())+total6;}
    if(total6 === 0){ $("#attributeTextFieldNumber272").val(""); }
    else{ $("#attributeTextFieldNumber272").val(total6); }
    }
    var attribute1 = $("#attributeTextFieldNumber247").val(); var attribute2 = $("#attributeTextFieldNumber260").val();
    var attribute3 = $("#attributeTextFieldNumber248").val(); var attribute4 = $("#attributeTextFieldNumber261").val();
    var attribute5 = $("#attributeTextFieldNumber249").val(); var attribute6 = $("#attributeTextFieldNumber262").val();
    var attribute7 = $("#attributeTextFieldNumber250").val(); var attribute8 = $("#attributeTextFieldNumber263").val();
    var attribute9 = $("#attributeTextFieldNumber251").val(); var attribute10 = $("#attributeTextFieldNumber264").val();
    var attribute11 = $("#attributeTextFieldNumber252").val(); var attribute12 = $("#attributeTextFieldNumber265").val();
    var attribute13 = $("#attributeTextFieldNumber253").val(); var attribute14 = $("#attributeTextFieldNumber266").val();
    var attribute15 = $("#attributeTextFieldNumber254").val(); var attribute16 = $("#attributeTextFieldNumber267").val();
    var attribute17 = $("#attributeTextFieldNumber255").val(); var attribute18 = $("#attributeTextFieldNumber268").val();
    var attribute19 = $("#attributeTextFieldNumber256").val(); var attribute20 = $("#attributeTextFieldNumber269").val();
    var attribute21 = $("#attributeTextFieldNumber257").val(); var attribute22 = $("#attributeTextFieldNumber270").val();
    var attribute23 = $("#attributeTextFieldNumber258").val(); var attribute24 = $("#attributeTextFieldNumber271").val();
    var attribute25 = $("#attributeTextFieldNumber259").val(); var attribute26 = $("#attributeTextFieldNumber272").val();
    if(attribute1 === "") attribute1 = 0; if(attribute2 === "") attribute2 = 0;
    if(attribute3 === "") attribute3 = 0; if(attribute4 === "") attribute4 = 0;
    if(attribute5 === "") attribute5 = 0; if(attribute6 === "") attribute6 = 0;
    if(attribute7 === "") attribute7 = 0; if(attribute8 === "") attribute8 = 0;
    if(attribute9 === "") attribute9 = 0; if(attribute10 === "") attribute10 = 0;
    if(attribute11 === "") attribute11 = 0; if(attribute12 === "") attribute12 = 0;
    if(attribute13 === "") attribute13 = 0; if(attribute14 === "") attribute14 = 0;
    if(attribute15 === "") attribute15 = 0; if(attribute16 === "") attribute16 = 0;
    if(attribute17 === "") attribute17 = 0; if(attribute18 === "") attribute18 = 0;
    if(attribute19 === "") attribute19 = 0; if(attribute20 === "") attribute20 = 0;
    if(attribute21 === "") attribute21 = 0; if(attribute22 === "") attribute22 = 0;
    if(attribute23 === "") attribute23 = 0; if(attribute24 === "") attribute24 = 0;
    if(attribute25 === "") attribute25 = 0; if(attribute26 === "") attribute26 = 0;
    total7 = parseFloat(attribute1)+parseFloat(attribute2);
    if(total7 === 0){ $("#attributeTextFieldNumber273").val(""); }
    else{ $("#attributeTextFieldNumber273").val(total7); }
    total8 = parseFloat(attribute3)+parseFloat(attribute4);
    if(total8 === 0){ $("#attributeTextFieldNumber274").val(""); }
    else{ $("#attributeTextFieldNumber274").val(total8); }
    total9 = parseFloat(attribute5)+parseFloat(attribute6);
    if(total9 === 0){ $("#attributeTextFieldNumber275").val(""); }
    else{ $("#attributeTextFieldNumber275").val(total9); }
    total10 = parseFloat(attribute7)+parseFloat(attribute8);
    if(total10 === 0){ $("#attributeTextFieldNumber276").val(""); }
    else{ $("#attributeTextFieldNumber276").val(total10); }
    total11 = parseFloat(attribute9)+parseFloat(attribute10);
    if(total11 === 0){ $("#attributeTextFieldNumber277").val(""); }
    else{ $("#attributeTextFieldNumber277").val(total11); }
    total12 = parseFloat(attribute11)+parseFloat(attribute12);
    if(total12 === 0){ $("#attributeTextFieldNumber278").val(""); }
    else{ $("#attributeTextFieldNumber278").val(total12); }
    total13 = parseFloat(attribute13)+parseFloat(attribute14);
    if(total13 === 0){ $("#attributeTextFieldNumber279").val(""); }
    else{ $("#attributeTextFieldNumber279").val(total13); }
    total14 = parseFloat(attribute15)+parseFloat(attribute16);
    if(total14 === 0){ $("#attributeTextFieldNumber280").val(""); }
    else{ $("#attributeTextFieldNumber280").val(total14); }
    total15 = parseFloat(attribute17)+parseFloat(attribute18);
    if(total15 === 0){ $("#attributeTextFieldNumber281").val(""); }
    else{ $("#attributeTextFieldNumber281").val(total15); }
    total16 = parseFloat(attribute19)+parseFloat(attribute20);
    if(total16 === 0){ $("#attributeTextFieldNumber282").val(""); }
    else{ $("#attributeTextFieldNumber282").val(total16); }
    total17 = parseFloat(attribute21)+parseFloat(attribute22);
    if(total17 === 0){ $("#attributeTextFieldNumber283").val(""); }
    else{ $("#attributeTextFieldNumber283").val(total17); }
    total18 = parseFloat(attribute23)+parseFloat(attribute24);
    if(total18 === 0){ $("#attributeTextFieldNumber284").val(""); }
    else{ $("#attributeTextFieldNumber284").val(total18); }
    total19 = parseFloat(attribute25)+parseFloat(attribute26);
    if(total19 === 0){ $("#attributeTextFieldNumber285").val(""); }
    else{ $("#attributeTextFieldNumber285").val(total19); }
    }

    function radioHiding(elem){ 
    $("input[name="+elem.name+"]").each(function() {
    var radioClass = $(this).val();    
    if($("."+radioClass).length > 0){
    if($(this).is(':checked')){ $("."+radioClass).show();}
    else{ $("."+radioClass).hide();
    $("."+radioClass+" input[type = radio], "+"."+radioClass+" input[type = checkbox]").each(function() { 
    $(this).attr("checked",false); });
    $("."+radioClass+" input[type = text], "+"."+radioClass+" textarea, "+"."+radioClass+" select").each(function() { 
    $(this).val(""); });
    }}});
    //A
    if(elem.value === "no100"){ 
    $(".yes102, .yes103, .yes104, .yes105, .yes106, .yes107, .yes110, .yes111, .yes116, .yes119, .yes120, .yes121, .yes123").hide();
    $('#attributeTextAreaID69, #attributeTextAreaID70, #attributeTextAreaID71, #attributeTextAreaID72, #attributeTextAreaID74, #attributeTextAreaID75, #attributeTextAreaID76, #attributeTextAreaID77, #attributeTextAreaID78, #attributeTextAreaID79, #attributeTextAreaID80, #attributeTextAreaID81, #attributeTextAreaID82').val("");
    $('#yesRadioButtonID111, #noRadioButtonID111, #yesRadioButtonID112, #noRadioButtonID112, #yesRadioButtonID113, #noRadioButtonID113').prop('checked', false);
    }
    //B
    if(elem.value === "no124"){ 
    $(".yes125, .yes126, .yes127, .yes128, .yes130, .yes131, .yes132, .yes133, .yes134, .no135, .no136, .yes137, .yes138, .yes139, .yes140, .yes141, .yes142, .yes143, .yes144, .yes145, .yes146, .no147, .radio10, .radio11, .radio12, .radio13, .radio14, .radio15").hide();
    $('#attributeTextFiledID71, #attributeTextAreaID83, #attributeTextAreaID84, #attributeTextFiledID72, #attributeTextAreaID85, #attributeTextAreaID86, #attributeTextAreaID87, #attributeTextAreaID88, #attributeTextAreaID89, #attributeTextAreaID90, #attributeTextAreaID91, #attributeTextAreaID92, #attributeTextFieldNumber152, #attributeTextFieldNumber153, #attributeTextFieldNumber154').val("");
    $('#attributeTextFieldNumber168, #attributeTextFieldNumber169, #attributeTextFieldNumber155, #attributeTextFieldNumber156, #attributeTextFieldNumber157, #attributeTextFieldNumber158, #attributeTextFieldNumber159, #attributeTextFieldNumber160, #attributeTextFieldNumber161, #attributeTextFieldNumber162, #attributeTextFieldNumber163, #attributeTextFieldNumber164, #attributeTextFieldNumber165').val("");
    $('#attributeTextFieldNumber197, #attributeTextFieldNumber166, #attributeTextFieldNumber167, #attributeTextFieldNumber170, #attributeTextFieldNumber171, #attributeTextFieldNumber172, #attributeTextFieldNumber173, #attributeTextFieldNumber174, #attributeTextFieldNumber175, #attributeTextFieldNumber191, #attributeTextFieldNumber192, #attributeTextFieldNumber193, #attributeTextFieldNumber194').val("");
    $('#attributeTextFieldNumber195, #attributeTextFieldNumber176, #attributeTextFieldNumber177, #attributeTextFieldNumber178, #attributeTextFieldNumber179, #attributeTextFieldNumber180, #attributeTextFieldNumber223, #attributeTextFieldNumber224, #attributeTextFieldNumber225, #attributeTextFieldNumber226, #attributeTextFieldNumber227, #attributeTextFieldNumber228, #attributeTextFieldNumber229').val("");
    $('#attributeTextFieldNumber230, #attributeTextFieldNumber231, #attributeTextFieldNumber232, #attributeTextFieldNumber234, #attributeTextFieldNumber235, #attributeTextFieldNumber236, #attributeTextFieldNumber237, #attributeTextFieldNumber238, #attributeTextFieldNumber239, #attributeTextFieldNumber240, #attributeTextFieldNumber241').val("");   
    $('#attributeTextFieldNumber196, #attributeTextFieldNumber198, #attributeTextFieldNumber199, #attributeTextFieldNumber200, #attributeTextFieldNumber201, #attributeTextFieldNumber202, #attributeTextFieldNumber203, #attributeTextFieldNumber204, #attributeTextFieldNumber205, #attributeTextFieldNumber206, #attributeTextFieldNumber207, #attributeTextFieldNumber208, #attributeTextFieldNumber209').val("");
    $('#attributeTextFieldNumber210, #attributeTextFieldNumber211, #attributeTextFieldNumber212, #attributeTextFieldNumber213, #attributeTextFieldNumber214, #attributeTextFieldNumber215, #attributeTextFieldNumber216, #attributeTextFieldNumber217, #attributeTextFieldNumber218, #attributeTextFieldNumber219, #attributeTextFieldNumber220, #attributeTextFieldNumber221, #attributeTextFieldNumber222, #attributeTextAreaID94, #attributeTextAreaID95').val("");
    $('#yesRadioButtonID126, #noRadioButtonID126, #yesRadioButtonID127, #noRadioButtonID127, #yesRadioButtonID128, #noRadioButtonID128, #yesRadioButtonID129, #noRadioButtonID129, #yesRadioButtonID130, #noRadioButtonID130, #yesRadioButtonID131, #noRadioButtonID131, #yesRadioButtonID132, #noRadioButtonID132, #yesRadioButtonID133').prop('checked', false);
    $('#noRadioButtonID133, #materialCheckBoxID5, #yesRadioButtonID139, #noRadioButtonID139, #yesRadioButtonID140, #noRadioButtonID140, #yesRadioButtonID141, #noRadioButtonID141, #yesRadioButtonID143, #noRadioButtonID143, #yesRadioButtonID144, #noRadioButtonID144, #yesRadioButtonID145, #noRadioButtonID145').prop('checked', false);
    }
    if(elem.value === "no125"){ 
    $(".yes130, .yes131, .yes132, .yes133, .yes126, .yes127, .no127, .yes128").hide();
    $('#attributeTextFiledID71, #attributeTextAreaID83, #attributeTextAreaID86, #attributeTextAreaID87, #attributeTextAreaID88, #attributeTextAreaID89').val("");
    $('#yesRadioButtonID127, #noRadioButtonID127, #yesRadioButtonID128, #noRadioButtonID128').prop('checked', false);
    }
    if(elem.value === "no126"){ 
    $(".yes127").hide();$('#attributeTextAreaID83').val("");
    $('#yesRadioButtonID128, #noRadioButtonID128').prop('checked', false);
    }
    //C
    if(elem.value === "no148"){ 
    $(".no150, .no151, .no152, .no153, .yes154, .no155, .no156, .yes158, .yes159, .yes161, .yes162, .yes163, .yes164, .yes165, .no166, .yes167, .yes168, .no170, .yes170").hide();
    $('#attributeTextAreaID96, #attributeTextAreaID97, #attributeTextAreaID98, #attributeTextAreaID99, #attributeTextAreaID96, #attributeTextAreaID100, #attributeTextAreaID101, #attributeTextAreaID102, #attributeTextAreaID103, #attributeTextAreaID104, #attributeTextAreaID105, #attributeTextAreaID106').val("");
    $('#attributeTextAreaID107, #attributeTextAreaID108, #attributeTextAreaID109, #attributeTextAreaID110, #attributeTextAreaID111, #attributeTextAreaID112, #attributeTextAreaID113, #attributeTextAreaID114, #attributeTextAreaID115, #attributeTextAreaID116').val("");
    $('#yesRadioButtonID160, #noRadioButtonID160').prop('checked', false);
    }
    //D
    if(elem.value === "no171"){ 
    $(".yes172, .yes173, .yes174, .yes175, .no176, .no177, .yes178, .yes179, .yes180, .yes181, .yes182, .yes183, .yes184, .yes185, .no186").hide();
    $(".yes187, .yes188, .no188, .yes191, .yes192, .radio16, .radio17, .radio18").hide();
    $('#attributeTextFiledID85, #attributeTextFieldAddrID22, #attributeTextFieldAddrID23, #attributeTextFiledID86, #attributeSelectBoxID20, #attributeTextFieldZipCode19, #attributeTextFieldNumber243, #attributeTextFiledID87, #attributeTextFieldAddrID24, #attributeTextFieldAddrID25, #attributeTextFiledID88, #attributeSelectBoxID21').val("");
    $('#attributeTextFieldZipCode20, #attributeTextFieldNumber244, #attributeTextFiledID89, #attributeTextFieldAddrID26, #attributeTextFieldAddrID27, #attributeTextFiledID90, #attributeSelectBoxID22, #attributeTextFieldZipCode21, #attributeTextFieldNumber245, #attributeTextFiledID91, #attributeTextFieldAddrID28, #attributeTextFieldAddrID29').val("");
    $('#attributeTextFiledID92, #attributeSelectBoxID23, #attributeTextFieldZipCode22, #attributeTextFieldNumber246, #attributeTextAreaID120, #attributeTextAreaID121, #attributeTextAreaID122, #attributeTextAreaID123, #attributeTextAreaID124, #attributeTextAreaID125, #attributeTextAreaID126, #attributeTextAreaID127').val("");
    $('#attributeTextAreaID129, #attributeTextAreaID130, #attributeTextAreaID133, #attributeTextAreaID134, #attributeTextAreaID135, #attributeTextAreaID136, #attributeTextAreaID137, #attributeTextAreaID138, #attributeTextAreaID139, #attributeTextAreaID140, #attributeTextAreaID141').val("");
    $('#yesRadioButtonID173, #noRadioButtonID173, #yesRadioButtonID174, #noRadioButtonID174, #yesRadioButtonID175, #noRadioButtonID175, #yesRadioButtonID177, #noRadioButtonID177').prop('checked', false);
    }
    if(elem.value === "yes176"){ $(".no177").hide();$('#attributeTextAreaID120').val(""); }
    //E
    if(elem.value === "no193"){ $(".yes197, .no198").hide();$('#yesRadioButtonID198, #noRadioButtonID198, #yesRadioButtonID199, #noRadioButtonID199').prop('checked', false); }
    //F
    if(elem.value === "no205"){ 
    $(".yes206, .yes207, .yes208, .yes209, .no210, .yes210, .yes212, .yes213, .yes214, .yes215, .yes216, .yes217, .yes218, .yes219, .yes220, .yes221, .yes222, .yes223, .yes224, .yes225").hide();
    $('#attributeTextAreaID149, #attributeTextAreaID150, #attributeTextAreaID151, #attributeTextAreaID152, #attributeTextAreaID153, #attributeTextAreaID154, #attributeTextAreaID155, #attributeTextAreaID156, #attributeTextAreaID157, #attributeTextAreaID158, #attributeTextAreaID159, #attributeTextAreaID160, #attributeTextAreaID161, #attributeTextAreaID162, #attributeTextAreaID163, #attributeTextAreaID164').val("");
    $('#attributeTextAreaID165, #attributeTextAreaID166, #attributeTextAreaID167, #attributeTextAreaID168, #attributeTextAreaID169, #attributeTextAreaID170, #attributeTextAreaID171, #attributeTextAreaID172, #attributeTextAreaID173, #attributeTextAreaID174, #attributeTextAreaID175, #attributeTextAreaID176, #attributeTextAreaID177, #attributeTextAreaID178, #attributeTextAreaID209').val("");
    }
    //G
    if(elem.value === "no226"){ 
    $(".yes227, .yes228, .yes229, .yes230, .yes231, .yes232, .yes233, .yes234, .yes235, .yes236, .yes237, .yes238, .yes239, .yes240, .radio19, .radio20, .radio21").hide();
    $('#attributeTextAreaID179, #attributeTextAreaID180, #attributeTextAreaID181, #attributeTextAreaID183, #attributeTextAreaID184, #attributeTextFiledID97, #attributeTextFieldAddrID34, #attributeTextFieldAddrID35, #attributeTextFiledID98, #attributeSelectBoxID26, #attributeTextFieldZipCode25, #attributeTextFieldNumber288').val("");
    $('#attributeTextFieldNumber278, #attributeTextFiledID97, #attributeTextFieldAddrID34, #attributeTextFieldAddrID35, #attributeTextFiledID98, #attributeSelectBoxID26, #attributeTextFieldZipCode25, #attributeTextFieldNumber278, #attributeTextFiledID99, #attributeTextFieldAddrID36, #attributeTextFieldAddrID37').val("");
    $('#attributeTextFiledID100, #attributeSelectBoxID27, #attributeTextFieldZipCode26, #attributeTextFieldNumber289, #attributeTextFiledID101, #attributeTextFieldAddrID38, #attributeTextFieldAddrID39, #attributeTextFiledID102, #attributeSelectBoxID28, #attributeTextFieldZipCode27, #attributeTextFieldNumber290, #attributeTextFiledID103').val("");
    $('#attributeTextFieldAddrID40, #attributeTextFieldAddrID41, #attributeTextFiledID104, #attributeSelectBoxID29, #attributeTextFieldZipCode28, #attributeTextFieldNumber291, #attributeTextAreaID186, #attributeTextAreaID187, #attributeTextAreaID188, #attributeTextAreaID189, #attributeTextAreaID190, #attributeTextAreaID191, #attributeTextAreaID192').val("");
    $('#yesRadioButtonID232, #noRadioButtonID232, #yesRadioButtonID233, #noRadioButtonID233, #yesRadioButtonID234, #noRadioButtonID234').prop('checked', false);
    }
    //H
    if(elem.value === "no241"){ 
    $(".yes243, .yes247, .yes249, .yes251, .yes253, .yes254").hide();
    $('#attributeTextAreaID205, #attributeTextAreaID207, #attributeTextAreaID208').val("");
    $('#yesRadioButtonID248, #noRadioButtonID248, #yesRadioButtonID249, #noRadioButtonID249, #naRadioButtonID249, #yesRadioButtonID250, #noRadioButtonID250, #yesRadioButtonID251, #noRadioButtonID251, #naRadioButtonID251, #yesRadioButtonID252, #noRadioButtonID252, #yesRadioButtonID253, #noRadioButtonID253, #naRadioButtonID253, #yesRadioButtonID254, #noRadioButtonID254').prop('checked', false);
    }
    if(elem.value === "no247"){ $(".yes249, .yes251, .yes253, .yes254").hide(); }
    if(elem.value === "no51"){ $(".no52").hide();$("#attributeTextAreaID31").val(""); }
    if(elem.value === "no64"){ $(".no67").hide();$("#attributeTextAreaID45").val(""); }
    if(elem.value === "no75"){ $(".yes76, .yes77, .yes78, .yes79").hide();
    $("#attributeTextAreaID55, #attributeTextAreaID56, #attributeTextAreaID57, #attributeTextAreaID58").val("");
    }
    if(elem.value === "no247"){ 
    $('#yesRadioButtonID250, #noRadioButtonID250, #yesRadioButtonID252, #noRadioButtonID252').prop('checked', false);
    $('#attributeTextAreaID207, #attributeTextAreaID208').val("");
    }
    if(elem.value === "yes89"){ 
    $(".no89, .contribution, .yes95, .exefunctions, .yes96, .yes97").hide();
    $('#attributeTextFiledID67, #attributeTextAreaID65, #attributeTextAreaID66, #attributeTextAreaID67').val("");
    $('#yesRadioButtonID95, #noRadioButtonID95, #yesRadioButtonID96, #noRadioButtonID96, #yesRadioButtonID97, #noRadioButtonID97, #provCheckBoxID2').prop('checked', false);
    }
    else if(elem.value === "no89"){ $(".provisions").hide();$('#attributeTextFiledID105').val(""); }
    if(elem.value === "church" || elem.value === "school" || elem.value === "hospital" || elem.value === "organization" ||elem.value === "publicsafety" ||elem.value === "clgbenefit"||elem.value === "correctstatus"){ 
    $(".contribution, .yes95, .exefunctions, .yes96, .yes97").hide();
    $('#attributeTextFiledID67, #attributeTextAreaID65, #attributeTextAreaID66, #attributeTextAreaID67').val("");
    $('#yesRadioButtonID95, #noRadioButtonID95, #yesRadioButtonID96, #noRadioButtonID96, #yesRadioButtonID97, #noRadioButtonID97').prop('checked', false);
    }
    if(elem.value  === "contribution"){ 
    $(".exefunctions, .yes96, .yes97").hide();
    $('#attributeTextFiledID66, #attributeTextFiledID67').val("");
    $('#yesRadioButtonID96, #noRadioButtonID96, #yesRadioButtonID97, #noRadioButtonID97').prop('checked', false);
    }
    if(elem.value === "exefunctions"){ 
    $(".contribution, .yes95").hide();
    $('#attributeTextFiledID67, #attributeTextFiledID65, #attributeTextAreaID65').val("");
    $('#yesRadioButtonID95, #noRadioButtonID95').prop('checked', false);
    }
    if(elem.value === "yes15"){ $(".radio1").show(); }
    if((!($("#yesRadioButtonID16").prop("checked") || $("#noRadioButtonID16").prop("checked"))) && elem.value === "no15") { $(".radio1").hide(); }
    if(elem.value === "yes16"){ $(".radio2").show(); }
    if((!($("#yesRadioButtonID17").prop("checked") || $("#noRadioButtonID17").prop("checked"))) && elem.value === "no16") { $(".radio2").hide(); }
    if(elem.value === "yes17"){ $(".radio3").show(); }
    if((!($("#yesRadioButtonID18").prop("checked") || $("#noRadioButtonID18").prop("checked"))) && elem.value === "no17") { $(".radio3").hide(); }
    if(elem.value === "yes19"){ $(".radio4").show(); }
    if((!($("#yesRadioButtonID20").prop("checked") || $("#noRadioButtonID20").prop("checked"))) && elem.value === "no19") { $(".radio4").hide(); }
    if(elem.value === "yes20"){ $(".radio5").show(); }
    if((!($("#yesRadioButtonID21").prop("checked") || $("#noRadioButtonID21").prop("checked"))) && elem.value === "no20") { $(".radio5").hide(); }
    if(elem.value === "yes21"){ $(".radio6").show(); }
    if((!($("#yesRadioButtonID22").prop("checked") || $("#noRadioButtonID22").prop("checked"))) && elem.value === "no21") { $(".radio6").hide(); }
    if(elem.value === "yes23"){ $(".radio7").show(); }
    if((!($("#yesRadioButtonID24").prop("checked") || $("#noRadioButtonID24").prop("checked"))) && elem.value === "no23") { $(".radio7").hide(); }
    if(elem.value === "yes24"){ $(".radio8").show(); }
    if((!($("#yesRadioButtonID25").prop("checked") || $("#noRadioButtonID25").prop("checked"))) && elem.value === "no24") { $(".radio8").hide(); }
    if(elem.value === "yes25"){ $(".radio9").show(); }
    if((!($("#yesRadioButtonID26").prop("checked") || $("#noRadioButtonID26").prop("checked"))) && elem.value === "no25") { $(".radio9").hide(); }
    if(elem.value === "yes138"){ $(".radio10").show(); }
    if((!($("#yesRadioButtonID139").prop("checked") || $("#noRadioButtonID139").prop("checked"))) && elem.value === "no138") { $(".radio10").hide(); }
    if(elem.value === "yes139"){ $(".radio11").show(); }
    if((!($("#yesRadioButtonID140").prop("checked") || $("#noRadioButtonID140").prop("checked"))) && elem.value === "no139") { $(".radio11").hide(); }
    if(elem.value === "yes140"){ $(".radio12").show(); }
    if((!($("#yesRadioButtonID141").prop("checked") || $("#noRadioButtonID141").prop("checked"))) && elem.value === "no140") { $(".radio12").hide(); }
    if(elem.value === "yes142"){ $(".radio13").show(); }
    if((!($("#yesRadioButtonID143").prop("checked") || $("#noRadioButtonID143").prop("checked"))) && elem.value === "no142") { $(".radio13").hide(); }
    if(elem.value === "yes143"){ $(".radio14").show(); }
    if((!($("#yesRadioButtonID144").prop("checked") || $("#noRadioButtonID144").prop("checked"))) && elem.value === "no143") { $(".radio14").hide(); }
    if(elem.value === "yes144"){ $(".radio15").show(); }
    if((!($("#yesRadioButtonID145").prop("checked") || $("#noRadioButtonID145").prop("checked"))) && elem.value === "no144") { $(".radio15").hide(); }
    if(elem.value === "yes172"){ $(".radio16").show(); }
    if((!($("#yesRadioButtonID173").prop("checked") || $("#noRadioButtonID173").prop("checked"))) && elem.value === "no172") { $(".radio16").hide(); }
    if(elem.value === "yes173"){ $(".radio17").show(); }
    if((!($("#yesRadioButtonID174").prop("checked") || $("#noRadioButtonID174").prop("checked"))) && elem.value === "no173") { $(".radio17").hide(); }
    if(elem.value === "yes174"){ $(".radio18").show(); }
    if((!($("#yesRadioButtonID175").prop("checked") || $("#noRadioButtonID175").prop("checked"))) && elem.value === "no174") { $(".radio18").hide(); }
    if(elem.value === "yes231"){ $(".radio19").show(); }
    if((!($("#yesRadioButtonID232").prop("checked") || $("#noRadioButtonID232").prop("checked"))) && elem.value === "no231") { $(".radio19").hide(); }
    if(elem.value === "yes232"){ $(".radio20").show(); }
    if((!($("#yesRadioButtonID233").prop("checked") || $("#noRadioButtonID233").prop("checked"))) && elem.value === "no232") { $(".radio20").hide(); }
    if(elem.value === "yes233"){ $(".radio21").show(); }
    if((!($("#yesRadioButtonID234").prop("checked") || $("#noRadioButtonID234").prop("checked"))) && elem.value === "no233") { $(".radio21").hide(); }
    if(elem.value === "no31" || elem.value === "no32" || elem.value === "no33" || elem.value === "no34" || elem.value === "no35" || elem.value === "no36"){ $(".no").show(); }
    else if(elem.value === "yes31" || elem.value === "yes32" || elem.value === "yes33" || elem.value === "yes34" || elem.value === "yes35" || elem.value === "yes36"){ 
    if(!$("#noRadioButtonID31").prop("checked") && !$("#noRadioButtonID32").prop("checked") && !$("#noRadioButtonID33").prop("checked") && !$("#noRadioButtonID34").prop("checked") && !$("#noRadioButtonID35").prop("checked") && !$("#noRadioButtonID36").prop("checked")){ 
    $(".no").hide();$('#attributeTextAreaID10').val("");
    } }
    }

    $(document).ready(function(){ 
    $("#provCheckBoxID2").click(function(){ 
    $(".provisions").toggle("fast");
    if(!(this.checked))$('#attributeTextFiledID105').val("");
    }); });