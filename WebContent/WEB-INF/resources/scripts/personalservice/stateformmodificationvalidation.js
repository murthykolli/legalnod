 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
function displayNextPage(){
    var divEle="";
    var tabClass="";
    if(!document.getElementsByClassName){
    divEle = elemArray('div','box');
    tabClass=elemArray('table','tab');
    }else{
    divEle = document.getElementsByClassName("box");
    tabClass=document.getElementsByClassName("tab");
    }

    var resultVal=false;
    var lastdistable="";
    var lasttableid="";
    for(var k=0;k<divEle.length;k++){
    var divId=document.getElementById(divEle[k].id);
    var field=getElementsByTagNames('input,select,textarea',divId);
    var ele=getDisplayElements(document.getElementById(tabClass[k].id));
    if(ele.length>0){
    for(var q1=0;q1<field.length; q1++){
    var radioValue="";
    if(field[q1].type=="radio" || field[q1].type=="checkbox" ){
    var radioName=field[q1].name;
    for(var rad1=0;rad1<document.psStateFormName[radioName].length;rad1++){
    if(document.psStateFormName[radioName][rad1].checked){
    radioValue=document.psStateFormName[radioName][rad1].value;
    resultVal=true;
    }}
    if(radioValue==""){resultVal=false;
//    break;
    }else{resultVal=true; break;
    }}
    else{
    if(field[q1].value!=""){
    resultVal=true;
    break;
    }else if(field[q1].value==""){
    resultVal=false;
    //break;
    }}}}
    if(resultVal==false){
    document.getElementById(divEle[k].id).style.display="block";
    lastdistable=tabClass[k].id;
    $c=k;
    break;
    }else{
    document.getElementById(divEle[k].id).style.display="none";
    document.getElementById(divEle[k+1].id).style.display="block";
    lastdistable=tabClass[k+1].id;
    $c=k+1;
    }
    if($c>0){
    document.getElementById("PreviousIBID").style.display='block';
    document.getElementById("NextIBID").style.marginLeft='195px';
    document.getElementById("SaveIBID").style.marginLeft='322px';
     }
    if($c==divEle.length-1){
    document.getElementById("NextIBID").style.display='none';
    document.getElementById("SaveIBID").style.marginLeft='195px';

    }}
    for(var i1=0;i1<tabClass.length;i1++){
    var ele=getDisplayElements(document.getElementById(tabClass[i1].id));
    if(ele.length>0){
       lasttableid=tabClass[i1].id;
    }
}
    if(lastdistable==lasttableid){
    document.getElementById("NextIBID").style.display='none';
    document.getElementById("SaveIBID").style.marginLeft='195px';
    }
    if(lasttableid=="form-table1"){
    document.getElementById("NextIBID").style.display='none';
    document.getElementById("SaveIBID").style.marginLeft='10px';
    }
    }

function getDisplayElements(tab){
  var rows=tab.getElementsByTagName("tr");
  var resultArray = new Array();
  for(var j=0;j<rows.length;j++) {
  if(rows[j].style.display!="none"){
  resultArray.push(rows[j]);
     } }
  return resultArray;
  }

function elemArray(eleType,className){
var elmArray = new Array();
var dive=document.getElementById("pro-form").getElementsByTagName(eleType);
 for(var i=0;i<dive.length;i++){
if(dive[i].className==className){
elmArray.push(dive[i]);
}}
return elmArray;
}

function next(){
    var boxes="";
    var tabClass="";
    if(!document.getElementsByClassName){
    boxes = elemArray('div','box');
    tabClass=elemArray('table','tab');
    }else{
    boxes = document.getElementsByClassName("box");
    tabClass=document.getElementsByClassName("tab");
    }

    var flag;
    if($c==0)
        flag=validation("form-div1","form-table1");
    if($c==1)
        flag=validation("form-div2","form-table2");
    if($c==2)
        flag=validation("form-div3","form-table3");
    if($c==3)
        flag=validation("form-div4","form-table4");
    if($c==4)
        flag=validation("form-div5","form-table5");
    if($c==5)
        flag=validation("form-div6","form-table6");
    if($c==6)
        flag=validation("form-div7","form-table7");
    if($c==7)
        flag=validation("form-div8","form-table8");
    if($c==8)
        flag=validation("form-div9","form-table9");
    if($c==9)
        flag=validation("form-div10","form-table10");
    if($c==10)
        flag=validation("form-div11","form-table11");
    if($c==11)
        flag=validation("form-div12","form-table12");
    if($c==12)
        flag=validation("form-div13","form-table13");
    if($c==13)
        flag=validation("form-div14","form-table14");
    if($c==14)
        flag=validation("form-div15","form-table15");
    if($c==15)
        flag=validation("form-div16","form-table16");
    if($c==16)
        flag=validation("form-div17","form-table17");
    if($c==17)
        flag=validation("form-div18","form-table18");
    if($c==18)
        flag=validation("form-div19","form-table19");
    if($c==19)
        flag=validation("form-div20","form-table20");
    if($c==20)
        flag=validation("form-div21","form-table21");
    if($c==21)
        flag=validation("form-div22","form-table22");
    if($c==22)
        flag=validation("form-div23","form-table23");
    if($c==23)
        flag=validation("form-div24","form-table24");
    if($c==24)
        flag=validation("form-div25","form-table25");
    if($c==25)
        flag=validation("form-div26","form-table26");
    if($c==26)
        flag=validation("form-div27","form-table27");
    if($c==27)
        flag=validation("form-div28","form-table28");
    if($c==28)
        flag=validation("form-div29","form-table29");
    if($c==29)
        flag=validation("form-div30","form-table30");
    if($c==30)
        flag=validation("form-div31","form-table31");
    var res=true;
//    if(flag==true){
//    window.scrollTo(0,0);
//    if(document.psStateFormName.attributeTextField1.value!=""){
//    newAjaxCall();
//    res=choiceret;
//    }
//    if(res==true){
     var lastdivid;
     for(var k=0;k<boxes.length;k++){
     var ele=getDisplayElements(document.getElementById(tabClass[k].id));
     if(ele.length>0){
     lastdivid=boxes[k].id;
     }}
     boxes[$c].style.display="none";
     for(var k1=$c+1;k1<boxes.length;k1++){
     var ele=getDisplayElements(document.getElementById(tabClass[k1].id));
     if(boxes[k1].id==lastdivid){
     document.getElementById("NextIBID").style.display='none';
     document.getElementById("SaveIBID").style.marginLeft='195px';
     }
     if(ele.length>0){
     $c=k1;
     boxes[k1].style.display  = "block";
     break;}}
     if($c>=1){
     document.getElementById("PreviousIBID").style.display='block';
     document.getElementById("NextIBID").style.marginLeft='195px';
     document.getElementById("SaveIBID").style.marginLeft='322px';
     }
     if($c==boxes.length-1){
     document.getElementById("NextIBID").style.display='none';
     document.getElementById("SaveIBID").style.marginLeft='195px';
     }
     if(boxes[$c].id==lastdivid){
     document.getElementById("SaveIBID").style.marginLeft='195px';
      }
//  }
//    }
  return false;
}
 function prev(){
   window.scrollTo(0,0);
    var boxes="";
    var tabClass="";
    if(!document.getElementsByClassName){
    boxes = elemArray('div','box');
    tabClass=elemArray('table','tab');
    }else{
    boxes = document.getElementsByClassName("box");
    tabClass=document.getElementsByClassName("tab");
    }

    boxes[$c].style.display  = "none";
    for (var i=$c-1;i>=0;i--){
    var ele=getDisplayElements(document.getElementById(tabClass[i].id));
    if(ele.length>0){
    $c=i;
    boxes[i].style.display="block";
    break;
    }}
    if($c < 0)
    $c = (boxes.length-1);
    if($c<boxes.length-1){
    document.getElementById("NextIBID").style.display='block';
    document.getElementById("SaveIBID").style.marginLeft='322px';
   }
    if($c==0){
    document.getElementById("PreviousIBID").style.display='none';
    document.getElementById("NextIBID").style.marginLeft='10px';
    document.getElementById("SaveIBID").style.marginLeft='137px';
    }
    if($c==boxes.length-2) {
    if(document.getElementsByClassName("box").length==2){
    document.getElementById("NextIBID").style.marginLeft='10px';
    document.getElementById("SaveIBID").style.marginLeft='135px';
    }else{
    document.getElementById("NextIBID").style.marginLeft='195px';
    document.getElementById("SaveIBID").style.marginLeft='322px';
    }}
    if(document.getElementById("SaveIBID").style.marginLeft=="155px"){
    document.getElementById("SaveIBID").style.marginLeft='322px';
    }
    return false;
 }
    function save(){
    var flag;
    if($c==0)
    flag=validation("form-div1","form-table1");
    if($c==1)
    flag=validation("form-div2","form-table2");
    if($c==2)
    flag=validation("form-div3","form-table3");
    if($c==3)
    flag=validation("form-div4","form-table4");
    if($c==4)
    flag=validation("form-div5","form-table5");
    if($c==5)
    flag=validation("form-div6","form-table6");
    if($c==6)
    flag=validation("form-div7","form-table7");
    if($c==7)
    flag=validation("form-div8","form-table8");
    if($c==8)
    flag=validation("form-div9","form-table9");
    if($c==9)
    flag=validation("form-div10","form-table10");
    if($c==10)
    flag=validation("form-div11","form-table11");
    if($c==11)
    flag=validation("form-div12","form-table12");
    if($c==12)
    flag=validation("form-div13","form-table13");
    if($c==13)
    flag=validation("form-div14","form-table14");
    if($c==14)
    flag=validation("form-div15","form-table15");
    if($c==15)
    flag=validation("form-div16","form-table16");
    if($c==16)
    flag=validation("form-div17","form-table17");
    if($c==17)
    flag=validation("form-div18","form-table18");
    if($c==18)
    flag=validation("form-div19","form-table19");
    if($c==19)
    flag=validation("form-div20","form-table20");
    if($c==20)
    flag=validation("form-div21","form-table21");
    if($c==21)
    flag=validation("form-div22","form-table22");
    if($c==22)
    flag=validation("form-div23","form-table23");
    if($c==23)
    flag=validation("form-div24","form-table24");
    if($c==24)
    flag=validation("form-div25","form-table25");
    if($c==25)
    flag=validation("form-div26","form-table26");
    if($c==26)
    flag=validation("form-div27","form-table27");
    if($c==27)
    flag=validation("form-div28","form-table28");
    if($c==28)
    flag=validation("form-div29","form-table29");
    if($c==29)
    flag=validation("form-div30","form-table30");
    if($c==30)
    flag=validation("form-div31","form-table31");
    var res=true;
//    if(flag==true){
//    if(document.psStateFormName.attributeTextField1.value!=""){
//    newAjaxCall();
//    res=choiceret;
//    }
//    var tabClass="";var lasttableid="";
//    if(!document.getElementsByClassName){
//    tabClass=elemArray('table','tab');
//    }else{tabClass=document.getElementsByClassName("tab"); }
//  for(var i1=0;i1<tabClass.length;i1++){
//    var ele=getDisplayElements(document.getElementById(tabClass[i1].id));
//    if(ele.length>0){ lasttableid=tabClass[i1].id;}}
//   var formElms= getElementsByTagNames('input,select,textarea',document.getElementById(lasttableid));
//  for(var q1=0;q1<formElms.length; q1++){
//    var radioValue="";var resultVal1=false;
//    if(formElms[q1].type=="radio"  || formElms[q1].type=="checkbox"){
//    var radioName=formElms[q1].name;
//    for(var rad1=0;rad1<document.psStateFormName[radioName].length;rad1++){
//    if(document.psStateFormName[radioName][rad1].checked){
//    radioValue=document.psStateFormName[radioName][rad1].value;
//    resultVal1=true;
//    }}if(radioValue==""){resultVal1=false;
//    }else{resultVal1=true; break;
//    }}
//    else{if(formElms[q1].value!="" ){resultVal1=true;break;
//    }else if(formElms[q1].value==""){resultVal1=false; }}}
//    if(resultVal1==true){
//     document.getElementById("stateFormHiddenVarID").value="Finished";
//     document.psStateFormName.stateFormHiddenVar.value="Finished";
//    }

//     if(res==true){
        document.forms["psStateFormName"].submit();
//    }
//}
    return false;
}