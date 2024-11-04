    $(function() {
    $( ".datepicker" ).datepicker({changeMonth: true,changeYear: true
    });});
    
    $(document).ready(function(){
    $("#radio1").click(function(){
    $(".sh1").show(); $(".sh2").hide();
    $('#text6, #text7, #text8, #select2').val("");
    });
    $("#radio2").click(function(){
    $(".sh1").hide();$(".sh2").show();
    $('#text2, #text3, #text4, #select1, #text5').val("");
    });
    $("#radio3").click(function(){
    $(".sh3").show(); $(".sh4").hide();
    document.scorpform.attributeTextFieldDate1.value = "";
    });
    $("#radio4").click(function(){ $(".sh3").hide();$(".sh4").show(); $('#text9').val(""); });
    $("#radio5").click(function(){ $(".sh5").show(); $(".sh6").hide();$(".sh7").show(); $('#text11').val(""); });
    $("#radio6").click(function(){ $(".sh5").hide();$(".sh6").show(); $(".sh7").show(); $('#text10').val(""); });
    $("#radio51").click(function(){
    $(".sh5").hide(); $(".sh6").hide(); $(".sh7").hide(); $(".sh7a").hide();
    $(".sh7b").hide(); $(".sh7c").hide(); $(".sh7d").hide(); $(".sh7e").hide();
    document.scorpform.checkBox1.checked = false; document.scorpform.checkBox2.checked = false;
    document.scorpform.checkBox3.checked = false; document.scorpform.checkBox4.checked = false;
    document.scorpform.checkBox5.checked = false; document.scorpform.attributeTextFieldDate4.value = "";
    document.scorpform.attributeTextFieldDate5.value = ""; document.scorpform.attributeTextFieldDate6.value = "";
    $('#text10, #text11, #attributeTextAreaID1').val("");
    $('#radio71, #radio72, #radio73, #radio7, #radio8, #radio9, #radio10, #radio11, #radio12, #radio13, #radio16, #radio17, #radio18').prop('checked', false);
    });
    $("#radio61").click(function(){
    $(".sh5").hide(); $(".sh6").hide(); $(".sh7").hide(); $(".sh7a").hide();
    $(".sh7b").hide(); $(".sh7c").hide(); $(".sh7d").hide(); $(".sh7e").hide();
    document.scorpform.attributeTextField10.value = ""; document.scorpform.attributeTextField11.value = "";
    document.scorpform.checkBox1.checked = false; document.scorpform.checkBox2.checked = false;
    document.scorpform.checkBox3.checked = false; document.scorpform.checkBox4.checked = false;
    document.scorpform.checkBox5.checked = false; document.scorpform.attributeTextFieldDate4.value = "";
    document.scorpform.attributeTextFieldDate5.value = ""; document.scorpform.attributeTextFieldDate6.value = "";
    $('#text10, #text11, #attributeTextAreaID1').val("");
    $('#radio71, #radio72, #radio73, #radio7, #radio8, #radio9, #radio10, #radio11, #radio12, #radio13, #radio16, #radio17, #radio18').prop('checked', false);
    });
    $("#radio7").click(function(){
    $(".sh7a").show(); $(".sh7b").hide();
    $(".sh7c").hide(); $(".sh7d").hide(); $(".sh7e").hide();
    document.scorpform.checkBox1.checked = false; document.scorpform.checkBox2.checked = false;
    document.scorpform.checkBox3.checked = false; document.scorpform.checkBox4.checked = false;
    document.scorpform.checkBox5.checked = false; document.scorpform.attributeTextFieldDate4.value = "";
    document.scorpform.attributeTextFieldDate5.value = ""; document.scorpform.attributeTextFieldDate6.value = "";
    $('#attributeTextAreaID1').val("");
    $(' #radio12, #radio13, #radio16, #radio17, #radio18').prop('checked', false);
    });
    $("#radio8").click(function(){
    $(".sh7a").hide(); $(".sh7b").show();
    $(".sh7d").hide(); $(".sh7e").hide();
    document.scorpform.checkBox4.checked = false; document.scorpform.checkBox5.checked = false;
    document.scorpform.attributeTextFieldDate4.value = ""; document.scorpform.attributeTextFieldDate5.value = "";
    document.scorpform.attributeTextFieldDate6.value = "";
    $(' #radio10, #radio11, #radio16, #radio17, #radio18').prop('checked', false);
    });
    $("#radio9").click(function(){
    $(".sh7a").hide(); $(".sh7b").hide();
    $(".sh7c").hide(); $(".sh7d").show();
    document.scorpform.checkBox1.checked = false; document.scorpform.checkBox2.checked = false;
    document.scorpform.checkBox3.checked = false; document.scorpform.attributeTextArea1.value = "";
    $('#attributeTextAreaID1').val("");
    $(' #radio10, #radio11, #radio12, #radio13').prop('checked', false);
    });
    $("#check1").click(function(){
    $(".sh7c").toggle("slow");
    if(!(this.checked)){  $('#attributeTextAreaID1').val(""); $('#radio12, #radio13').prop('checked', false);
    }
    });
    $("#check4").click(function(){
    $(".sh7e").toggle("slow");
    if(!(this.checked)){
    $('#radio16, #radio17, #radio18').prop('checked', false);
    document.scorpform.attributeTextFieldDate4.value = ""; document.scorpform.attributeTextFieldDate5.value = "";
    document.scorpform.attributeTextFieldDate6.value = "";
    }
    });
    $("#radio19").click(function(){ $(".share1").show();  $(".share11").show(); });
    $("#radio20").click(function(){
    $(".share1").hide();
    $('#text22, #text23, #text24, #text25, #text26, #text27, #text28,  #select7, #select8, #select9').val("");
    if(!($("#radio21").prop("checked") || $("#radio22").prop("checked")))$(".share11").hide();
    });
    $("#radio21").click(function(){ $(".share2").show();  $(".share22").show(); });
    $("#radio22").click(function(){
    $(".share2").hide();
    $('#text29, #text30, #text31, #text32, #text33, #text34, #text35, #select10, #select11, #select12').val("");
    if(!($("#radio23").prop("checked") || $("#radio24").prop("checked")))$(".share22").hide();
    });
    $("#radio23").click(function(){ $(".share3").show();  $(".share33").show(); });
    $("#radio24").click(function(){
    $(".share3").hide();
    $('#text36, #text37, #text38, #text39, #text40, #text41, #text42, #select13, #select14, #select15').val("");
    if(!($("#radio25").prop("checked") || $("#radio26").prop("checked")))$(".share33").hide();
    });
    $("#radio25").click(function(){$(".share4").show(); $(".share44").show(); });
    $("#radio26").click(function(){
    $(".share4").hide();
    $('#text43, #text44, #text45, #text46, #text47, #text48, #text49, #select16, #select17, #select18').val("");
    if(!($("#radio27").prop("checked") || $("#radio28").prop("checked")))$(".share44").hide();
    });
    $("#radio27").click(function(){ $(".share5").show(); });
    $("#radio28").click(function(){
    $(".share5").hide();
    $('#text50, #text51, #text52, #text53, #text54, #text55,  #text56,#select19, #select20, #select21').val("");
    });
    $("#radio29").click(function(){ $(".trust1").show(); });
    $("#radio30").click(function(){
    $(".trust1").hide();
    $('#text57, #text58, #text59, #text60,  #text61, #text62 , #text63, #text64, #text65, #text66, #select22, #select23, #datepickerID13').val("");
    });
    });

    $c = 0;
    function prev(){
    var boxes = $(".box");
    window.scrollTo(0,0);
    $c -=1;
    if($c < 0) $c = (boxes.length-1);
    if($c<boxes.length-1){ $("#SaveIBID").show(); $("#FinishIBID").hide();}
    if($c === 0){ $("#PreviousIBID").hide(); }
    progressCount = progressCount-1;
    $("#progress").attr("value", progressCount); 
    for(var $i = 0; $i < boxes.length; $i++){ boxes[$i].style.display = "none"; }
    boxes[$c].style.display = "block";
    return false;
    }

    function save(){
    var flag; var result = true;
    if($c === 0){
    flag = validation("form-div1"); $("input[name='sCorpFormPageValues']").val("form-div2");
    } else if($c === 1){
    flag = validation("form-div2"); $("input[name='sCorpFormPageValues']").val("form-div3");
    } else if($c === 2){
    flag = validation("form-div3"); $("input[name='sCorpFormPageValues']").val("form-div4");
    } else if($c === 3){
    flag = validation("form-div4"); $("input[name='sCorpFormPageValues']").val("form-div5");
    } else if($c === 4){
    flag = validation("form-div5"); $("input[name='sCorpFormPageValues']").val("form-div5");
    $("input[name='sCorpFinishOrderRef']").val("Finished");
    }
    if(flag === true){
    if($("input[name='attributeTextField1']").val() !== ""){ newAjaxCall(); result = choiceRet; }
    if(result === true){ $("form[name='scorpform']").submit(); }
    }
    return false;
    }

   function validation(id){
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
    var result = true;
    if(id === "form-div1"){
    if(reg.test($("input[name='attributeTextField1']").val())){ $("#corplabel").removeClass("redTestDisplay"); }
    else{ $("#corplabel").addClass("redTestDisplay"); result = false; } 
    }
    return result;
    }
      
    function nameValidation(){
    var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
    if(reg.test($("input[name='attributeTextField1']").val())){ $("#corplabel").removeClass("redTestDisplay"); }
    else{ $("#corplabel").addClass("redTestDisplay");
    }
    if($("input[name='attributeTextField1']").val() === ""){$("#corplabel").removeClass("redTestDisplay");}
    }

    function numberonly(e, decimal) {
    var key; var keychar;
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

    function CheckFirstChar(key, txt){
    if(key === 32 && txt.value.length <= 0) return false;
    else if(txt.value.length > 0){
    if(txt.value.charCodeAt(0) === 32){
    txt.value = txt.value.substring(1,txt.value.length);
    return true;
    }
    }
    return true;
    }
  
    function phoneFormat (e,input) {
    evt = e || window.event; 
    var pressedkey = evt.which || evt.keyCode; var BlockedKeyCodes = new Array(0,8,27,13,9); //8 is backspace key
    var len = BlockedKeyCodes.length; var block = false; var str = '';
    for(i=0; i<len; i++){
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
    if (returnString.length === 3) returnString += '-';
    if (returnString.length === 7) returnString += '-';
    returnString += c;
    } }
    input.value = returnString;
    return false;
    }