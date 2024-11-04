    function validation(tableId){
    var name = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/; var result = true;
    var tdId = $("#textFieldID1").closest('tr').prev('tr').prev('tr').find('td').attr("id");
     if(name.test($("#textFieldID1").val())){ $("#"+tdId).removeClass("redTestDisplay"); }
    else{ $("#"+tdId).addClass("redTestDisplay"); result = false; }
    var lasttableid = "";
    $(".tab").each(function() {
    var ele = getDisplayElements(document.getElementById(this.id));
    if(ele.length > 0){ lasttableid = this.id; }
    });
    if(tableId === lasttableid){ $("input[name='stateFormHiddenVar']").val("Finished"); }
    return result;
    }

    function attributeTextField1Validation(curObj){
    var tdId = $(curObj).closest('tr').prev('tr').prev('tr').find('td').attr("id");
    var nameReg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
    if(nameReg.test(curObj.value)){$("#"+tdId).removeClass("redTestDisplay");}
    else{ $("#"+tdId).addClass("redTestDisplay");
    if(curObj.value === ""){$("#"+tdId).removeClass("redTestDisplay");}
    }
    }

    function CheckFirstChar(key, txt){
    if(key === 32 && txt.value.length <= 0){ return false; }
    else if(txt.value.length > 0){
    if(txt.value.charCodeAt(0) === 32){ txt.value=txt.value.substring(1,txt.value.length); return true; }
    }
    return true;
    }

    function phoneFormat (e,input) {
    evt = e || window.event; 
    var pressedkey = evt.which || evt.keyCode; var BlockedKeyCodes = new Array(0,8,27,13,9); //8 is backspace key
    var len = BlockedKeyCodes.length; var block = false; var str = '';
    for(i = 0; i < len; i++){
    str = BlockedKeyCodes[i].toString();
    if (str.indexOf(pressedkey) >=0 ) block = true;
    }
    if (block) return true;
    s = input.value;
    if (s.charAt(0) === '+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{}ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var i;
    var returnString = '';
    for(i = 0; i < s.length; i++) {
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length < 12 )) {
    if (returnString.length === 3) returnString +='-';
    if (returnString.length === 7) returnString +='-';
    returnString += c;
    }  }
    input.value = returnString;
    return false;
    }

    function zipplus4Format (e,input) {
    evt = e || window.event; 
    var pressedkey = evt.which || evt.keyCode; var BlockedKeyCodes = new Array(0,8,27,13,9); //8 is backspace key
    var len = BlockedKeyCodes.length; var block = false; var str = '';
    for(i = 0; i < len; i++){
    str = BlockedKeyCodes[i].toString();
    if (str.indexOf(pressedkey) >= 0 ) block = true;
    }
    if (block) return true;
    s = input.value;
    if (s.charAt(0) === '+') return false;
    filteredValues = '"`!@#$%^&*()_+|~-=\QWERT YUIOP{}ASDFGHJKL:ZXCVBNM<>?qwertyuiop[]asdfghjkl;zxcvbnm,./\\\'';
    var i;
    var returnString = '';
    for(i = 0; i < s.length; i++) {
    var c = s.charAt(i);
    if ((filteredValues.indexOf(c) === -1) & (returnString.length <  10 )) {
    if (returnString.length === 5) returnString +='-';
    returnString += c;
    } }
    input.value = returnString;
    return false;
    }

    function numeralsOnly(evt) {
    evt = (evt) ? evt : event;
    var charCode = (evt.charCode) ? evt.charCode : ((evt.keyCode) ? evt.keyCode :
    ((evt.which) ? evt.which : 0));
    if (charCode > 31 && (charCode < 48 || charCode > 57)) { return false; }
    return true;
    }
   
    function numberonly(e, decimal) {
    var key; var keychar;
    if (window.event) { key = window.event.keyCode; }
    else if (e) { key = e.which; }
    else { return true; }
    keychar = String.fromCharCode(key);
    if ((key === null) || (key === 0) || (key === 8) ||  (key === 9) || (key === 13) || (key === 27) ) { return true; }
    else if ((("0123456789").indexOf(keychar) > -1)) { return true; }
    else if (decimal && (keychar === ".")) { return true; }
    else if (keychar === "-") { return true; }
    else return false;
    }

    function onlyForNumbers(e, decimal) {
    var key; var keychar;
    if (window.event) { key = window.event.keyCode; }
    else if (e) { key = e.which; }
    else { return true; }
    keychar = String.fromCharCode(key);
    if ((key === null) || (key === 0) || (key === 8) ||  (key === 9) || (key === 13) || (key === 27) ) { return true; }
    else if ((("0123456789").indexOf(keychar) > -1)) { return true; }
    else if (decimal && (keychar === "." || keychar === "$" ||keychar === "," || keychar === "%")) { return true; }
    else if (keychar === "-") { return true; }
    else return false;
    }