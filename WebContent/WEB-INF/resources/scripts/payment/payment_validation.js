function validation(){
            var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
            var zipReg = /^[0-9]+$/;
            var numbReg = /^[0-9]+$/;
            var expNumbReg = /^(0[1-9]|1[012])(\d{2})$/;
            var addrReg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,-]*$/;
            var charReg = /^[a-zA-Z][a-zA-Z\s]*$/;
            
            var cardNumber = document.secureRedirectForm.cardNumber.value;
            var expirationDate = document.secureRedirectForm.expirationDate.value;
            var cardCode = document.secureRedirectForm.cardCode.value;
               
            var billFirstName = document.secureRedirectForm.billFirstName.value;
            var billLastName = document.secureRedirectForm.billLastName.value;
            var billAddress = document.secureRedirectForm.billAddress.value;
            var billCity = document.secureRedirectForm.billCity.value;
            var billState = document.secureRedirectForm.billState.value;
            var billZip = document.secureRedirectForm.billZip.value;
         
            var shipFirstName = document.secureRedirectForm.shipFirstName.value;
            var shipLastName = document.secureRedirectForm.shipLastName.value;
            var shipAddress = document.secureRedirectForm.shipAddress.value;
            var shipCity = document.secureRedirectForm.shipCity.value;
            var shipState = document.secureRedirectForm.shipState.value;
            var shipZip = document.secureRedirectForm.shipZip.value;
            
            var result = true;
            if(numbReg.test(cardNumber)){
                document.getElementById("cardNumberID").removeAttribute("class");
            } else{
                document.getElementById("cardNumberID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(expNumbReg.test(expirationDate)){
                document.getElementById("expirationDateID").removeAttribute("class");
            } else{
                document.getElementById("expirationDateID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(numbReg.test(cardCode)){
                document.getElementById("cardCodeID").removeAttribute("class");
            } else{
                document.getElementById("cardCodeID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(reg.test(billFirstName)){
                document.getElementById("billFirstNameID").removeAttribute("class");
            } else{
                document.getElementById("billFirstNameID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(reg.test(billLastName)){
                document.getElementById("billLastNameID").removeAttribute("class");
            } else{
                document.getElementById("billLastNameID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(addrReg.test(billAddress)){
                document.getElementById("billAddressID").removeAttribute("class");
            } else{
                document.getElementById("billAddressID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(charReg.test(billCity)){
                document.getElementById("billCityID").removeAttribute("class");
            } else{
                document.getElementById("billCityID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(charReg.test(billState)){
                document.getElementById("billStateID").removeAttribute("class");
            } else{
                document.getElementById("billStateID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(zipReg.test(billZip)){
                document.getElementById("billZipID").removeAttribute("class");
            } else{
                document.getElementById("billZipID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(reg.test(shipFirstName)){
                document.getElementById("shipFirstNameID").removeAttribute("class");
            } else{
                document.getElementById("shipFirstNameID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(reg.test(shipLastName)){
                document.getElementById("shipLastNameID").removeAttribute("class");
            } else{
                document.getElementById("shipLastNameID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(addrReg.test(shipAddress)){
                document.getElementById("shipAddressID").removeAttribute("class");
            } else{
                document.getElementById("shipAddressID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(charReg.test(shipCity)){
                document.getElementById("shipCityID").removeAttribute("class");
            } else{
                document.getElementById("shipCityID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(charReg.test(shipState)){
                document.getElementById("shipStateID").removeAttribute("class");
            } else{
                document.getElementById("shipStateID").setAttribute("class","redTestDisplay");
            result=false;
            }
            
            if(zipReg.test(shipZip)){
                document.getElementById("shipZipID").removeAttribute("class");
            } else{
                document.getElementById("shipZipID").setAttribute("class","redTestDisplay");
            result=false;
            }
            var accountNumber = document.secureRedirectForm.cardNumber.value;            
            if(accountNumber !== ""){            	
            	getCreditCardType();            	
            	if(cardResult === "unknown"){
            		result=false;	
            	}; }
            return result;
        }
        
        
        function cardNumberValidation(){
        	var numbReg = /^[0-9]+$/;
            var cardNumber = document.secureRedirectForm.cardNumber.value;
            
            if(numbReg.test(cardNumber)){
                document.getElementById("cardNumberID").removeAttribute("class");
            } else{
                document.getElementById("cardNumberID").setAttribute("class","redTestDisplay");            
            }
            if(cardNumber === ""){
                document.getElementById("cardNumberID").removeAttribute("class");
            }; }
       
        function expirationDateValidation() {
            var expirationDate = document.secureRedirectForm.expirationDate.value;    
            if(expirationDate.length>=2 || expirationDate.charAt(0)>1){    
            var numbReg = /^(0[1-9]|1[012])(\d*)$/;
            if (numbReg.test(expirationDate)) {
            document.getElementById("expirationDateID").removeAttribute("class");
            } else {
            document.getElementById("expirationDateID").setAttribute("class", "redTestDisplay");
            };
            } else if(expirationDate.charAt(0)<=1){
            document.getElementById("expirationDateID").removeAttribute("class");   
            }; }

        
        function cardCodeValidation(){
        	var numbReg = /^[0-9]+$/;
            var cardCode = document.secureRedirectForm.cardCode.value;            
            if(numbReg.test(cardCode)){
                document.getElementById("cardCodeID").removeAttribute("class");
            } else{
                document.getElementById("cardCodeID").setAttribute("class","redTestDisplay");            
            }
            if(cardCode === ""){
                document.getElementById("cardCodeID").removeAttribute("class");
            }; }
        
        function billFirstNameValidation(){
            var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
            var billFirstName = document.secureRedirectForm.billFirstName.value;            
            if(reg.test(billFirstName)){
                document.getElementById("billFirstNameID").removeAttribute("class");
            } else{
                document.getElementById("billFirstNameID").setAttribute("class","redTestDisplay");            
            }
            if(billFirstName === ""){
                document.getElementById("billFirstNameID").removeAttribute("class");
            }; }
        
        function billLastNameValidation(){
            var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
            var billLastName = document.secureRedirectForm.billLastName.value;            
            if(reg.test(billLastName)){
                document.getElementById("billLastNameID").removeAttribute("class");
            } else{
                document.getElementById("billLastNameID").setAttribute("class","redTestDisplay");
            }
            if(billLastName === ""){
                document.getElementById("billLastNameID").removeAttribute("class");
            }; }
        
        function billAddressValidation(){
        	var addrReg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
            var billAddress = document.secureRedirectForm.billAddress.value;            
            if(addrReg.test(billAddress)){
                document.getElementById("billAddressID").removeAttribute("class");
            } else{
                document.getElementById("billAddressID").setAttribute("class","redTestDisplay");
            }
            if(billAddress === ""){
                document.getElementById("billAddressID").removeAttribute("class");
            }; }
        
        function billCityValidation(){
        	var charReg = /^[a-zA-Z][a-zA-Z\s]*$/;
            var billCity = document.secureRedirectForm.billCity.value;            
            if(charReg.test(billCity)){
                document.getElementById("billCityID").removeAttribute("class");
            } else{
                document.getElementById("billCityID").setAttribute("class","redTestDisplay");
            }
            if(billCity === ""){
                document.getElementById("billCityID").removeAttribute("class");
            }; }
        
        function billStateValidation(){
        	var charReg = /^[a-zA-Z][a-zA-Z\s]*$/;
            var billState = document.secureRedirectForm.billState.value;            
            if(charReg.test(billState)){
                document.getElementById("billStateID").removeAttribute("class");
            } else{
                document.getElementById("billStateID").setAttribute("class","redTestDisplay");
            }
            if(billState === ""){
                document.getElementById("billStateID").removeAttribute("class");
            }; }
        
        function billZipValidation(){
        	var zipReg = /^[0-9]+$/;
            var billZip = document.secureRedirectForm.billZip.value;            
            if(zipReg.test(billZip)){
                document.getElementById("billZipID").removeAttribute("class");
            } else{
                document.getElementById("billZipID").setAttribute("class","redTestDisplay");
            }
            if(billZip === ""){
                document.getElementById("billZipID").removeAttribute("class");
            }; }
        
        function shipFirstNameValidation(){
            var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
            var shipFirstName = document.secureRedirectForm.shipFirstName.value;            
            if(reg.test(shipFirstName)){
                document.getElementById("shipFirstNameID").removeAttribute("class");
            } else{
                document.getElementById("shipFirstNameID").setAttribute("class","redTestDisplay");            
            }
            if(shipFirstName === ""){
                document.getElementById("shipFirstNameID").removeAttribute("class");
            }; }
        
        function shipLastNameValidation(){
            var reg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
            var shipLastName = document.secureRedirectForm.shipLastName.value;            
            if(reg.test(shipLastName)){
                document.getElementById("shipLastNameID").removeAttribute("class");
            } else{
                document.getElementById("shipLastNameID").setAttribute("class","redTestDisplay");
            }
            if(shipLastName === ""){
                document.getElementById("shipLastNameID").removeAttribute("class");
            }; }
        
        function shipAddressValidation(){
        	var addrReg = /^[A-Za-z 0-9][A-Za-z 0-9 \-#()_.&;,]*$/;
            var shipAddress = document.secureRedirectForm.shipAddress.value;            
            if(addrReg.test(shipAddress)){
                document.getElementById("shipAddressID").removeAttribute("class");
            } else{
                document.getElementById("shipAddressID").setAttribute("class","redTestDisplay");
            }
            if(shipAddress === ""){
                document.getElementById("shipAddressID").removeAttribute("class");
            }; }
        
        function shipCityValidation(){
        	var charReg = /^[a-zA-Z][a-zA-Z\s]*$/;
            var shipCity = document.secureRedirectForm.shipCity.value;            
            if(charReg.test(shipCity)){
                document.getElementById("shipCityID").removeAttribute("class");
            } else{
                document.getElementById("shipCityID").setAttribute("class","redTestDisplay");
            }
            if(shipCity === ""){
                document.getElementById("shipCityID").removeAttribute("class");
            }; }
        
        function shipStateValidation(){
        	var charReg = /^[a-zA-Z][a-zA-Z\s]*$/;
            var shipState = document.secureRedirectForm.shipState.value;            
            if(charReg.test(shipState)){
                document.getElementById("shipStateID").removeAttribute("class");
            } else{
                document.getElementById("shipStateID").setAttribute("class","redTestDisplay");
            }
            if(shipState === ""){
                document.getElementById("shipStateID").removeAttribute("class");
            }; }
        
        function shipZipValidation(){
        	var zipReg = /^[0-9]+$/;
            var shipZip = document.secureRedirectForm.shipZip.value;            
            if(zipReg.test(shipZip)){
                document.getElementById("shipZipID").removeAttribute("class");
            } else{
                document.getElementById("shipZipID").setAttribute("class","redTestDisplay");
            }
            if(shipZip === ""){
                document.getElementById("shipZipID").removeAttribute("class");
            }; }
        
        function CheckFirstChar(key, txt) {
            if(key == 32 && txt.value.length<=0) {
            return false;
            }
            else if(txt.value.length>0) {
            if(txt.value.charCodeAt(0) == 32) {
            txt.value=txt.value.substring(1,txt.value.length);
            return true;
            }
            }
            return true;
            }
            
            function numeralsOnly(evt) {
                var charCode = (evt.which) ? evt.which : event.keyCode;
                if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
                return true;
                }
                   
            var cardResult;
            function getCreditCardType() {
            //start without knowing the credit card type
            var accountNumber = document.secureRedirectForm.cardNumber.value;        
            var sum = 0; 
        	var numdigits = accountNumber.length; 
        	var parity = numdigits % 2; 
        	for(var i=0; i < numdigits; i++) { 
        		var digit = parseInt(accountNumber.charAt(i)); 
        		if(i % 2 == parity) digit *= 2; 
        		if(digit > 9) digit -= 9; 
        		sum += digit; 
        		}    	
            var result = "unknown";

            //first check for MasterCard
            if (/^5[1-5][0-9]{14}/.test(accountNumber) && (sum % 10) == 0) {
                result = "mastercard";
            }

            //then check for Visa
            else if (/^4/.test(accountNumber) && (sum % 10) == 0) {
                result = "visa";
            }

          //then check for AmEx
            /* else if (/^3[47][0-9]{13}/.test(accountNumber) && (sum % 10) == 0) {
                result = "amex";
            } */
            
          //then check for Dis
            else if (/^6[0-9]{12}/.test(accountNumber) && (sum % 10) == 0) {
                result = "dis";
            }
            
            else{        	
            	alert("Invalid credit card number");        	
            }
            cardResult = result;
              return result;
            }
