    function getDisplayElements(tab){
    var rows = tab.getElementsByTagName("tr"); var resultArray = new Array();
    for(var j = 0; j < rows.length; j++) {
    if(rows[j].style.display !== "none"){resultArray.push(rows[j]); }
    }
    return resultArray;
    }

    function prev(){
    window.scrollTo(0,0);
    var boxes = $(".box");
    var tabClass = $(".tab");
    pageProgressCount = pageProgressCount-1;
    $("#progress").attr("value", pageProgressCount);
    boxes[$c].style.display = "none";
    for(var i = $c-1; i >= 0; i--){
    var ele = getDisplayElements(document.getElementById(tabClass[i].id));
    if(ele.length > 0){$c = i; boxes[i].style.display = "block"; break;}
    }
    if($c < 0) $c = (boxes.length-1);
    if($c < boxes.length-1){ $("#SaveIBID").show(); $("#FinishIBID").hide();}
    if($c === 0){ $("#PreviousIBID").hide();}
    return false;
    }

    function save(){
    var flag; var res = true; var status = "";
    var boxes = $(".box");
    var tabClass = $(".tab");
    for(var k1 = $c+1; k1 < boxes.length; k1++){
    var ele = getDisplayElements(document.getElementById(tabClass[k1].id));
    if(ele.length > 0){
    status = true;
    document.lltAL.stateFormPageValues.value = boxes[k1].id; 
    break;
    } }
    if(status === ""){document.lltAL.stateFormPageValues.value = boxes[$c].id;  }
    if($c === 0){ flag = validation("form-table1");}
    else if($c === 1){ flag = validation("form-table2");}
    else if($c === 2){ flag = validation("form-table3");}
    else if($c === 3){ flag = validation("form-table4");}
    else if($c === 4){ flag = validation("form-table5");}
    else if($c === 5){ flag = validation("form-table6");}
    else if($c === 6){ flag = validation("form-table7");}
    else if($c === 7){ flag = validation("form-table8");}
    else if($c === 8){ flag = validation("form-table9");}
    else if($c === 9){ flag = validation("form-table10");}
    else if($c === 10){ flag = validation("form-table11");}
    else if($c === 11){ flag = validation("form-table12");}
    else if($c === 12){ flag = validation("form-table13");}
    else if($c === 13){ flag = validation("form-table14");}
    else if($c === 14){ flag = validation("form-table15");}
    else if($c === 15){ flag = validation("form-table16");}
    else if($c === 16){ flag = validation("form-table17");}
    if(flag === true){
    if($("input[name='textField1']").val() !== ""){ newAjaxCall(); res = choiceRetValue;}
    if(res === true && choiceRetValue === true){$("form[name='lltAL']").submit();}
    }
    return false;
    }