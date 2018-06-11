// 1 
// first create id then pass here
//document.querySelectorAll('h4').href.innerHtml ='https://www.google.com','https://www.twitter.com', 'https://www.slacek.com', 'https://www.javadocs.com'  ;
document.getElementById("google").href = "http://www.google.com"; //getElementById required
document.getElementById("twitter").href = "http://www.twitter.com";
document.getElementById("slack").href = "http://www.slack.com";
document.getElementById("javadocs").href = "http://www.javadocs.com";

// 2. disable pluto planet
document.getElementById('planet').options[3].disabled = true;

// 3. function alienText
function alienText(){
    //console.log("TEST....s")
    if(document.getElementById('planet').value !='Earth'){
        //paragraph 5
        document.getElementsByTagName('p')[5].removeAttribute("hidden");   
    } else{
        document.getElementsByTagName("p")[5].setAttribute("hidden",true);
    }
}
document.getElementById('planet').onchange = alienText; 

// 4. validating email
 function isValidemail(){
 var a =document.getElementById('email').value;
 if(a.indexOf('@')<=0){   // should not be index at 0.
    a.innerHTML = "invalid email";
 return false;
 } 
 a.addEventListener('click', isValidemail);

 }
 function validphone(){
  var phone = document.getElementById('phone').value;
  if(phone == ""){
    document.getElementById('email').innerHTML = ' fill in the number';
    return false;
  }
  if(NaN(phone)){
      document.getElementById('email').innerHTML = 'only numbers';
      return false;
  }
  if(phone.length<10){
      document.getElementById('email').innerHTML = 'ten digits needed';
  }
  if(phone.length>10){
      document.getElementById('email').innerHTML = 'number should not be more than 10';
  }
 } phone.addEventListener('click',validphone);



// 5. Open details
function openDetails(){
    document.getElementsByTagName('details')[0].open = true; // set as true
}
 function closeDetails(){
     document.getElementsByTagName('details')[0].open = false;// set as false
 } 
 // usin addeventlister for handiling event
  document.getElementsByTagName('details')[0].addEventListener('mouseover',openDetails);
  document.getElementsByTagName('summary')[0].addEventListener('mouseleave',closeDetails)


// 6. concatenate all span elements.
 
 function concatenateSpan(){
      var span = document.getElementsByTagName('span');
  
      let sum = '';
      for(i=0; i<span.length;i++){ // go through all span tags
        //console.log(span[i]);
         sum += span[i].innerHTML;// stores the result in sum after summing
      }
      console.log(sum);
 } 
 // 7. function to display current time.
 
    function currentTime(){
        document.getElementsById(" earth_time").innerHTML = new Date();// using new data constructor.
    }
       document.getElementById("earth_time_check").addEventListener("click", currentTime);
    
// 10. performing operati


   function calculationvalid(){
     document.getElementById('n1').value;
     document.getElementById('n2').value;
     document.getElementById('operation').innerHTML = operator;
     document.getElementById('result').innerHTML=result;
     document.getElementById('operation').addEventListener('change', calcutionValid);

       switch(operator){
           case('Add'):
           result = n1+n2;
          break;
          case('Substract'):
          result = n1-n2;
          break;
          case('Divide'):
          result = n1/n2;
          break ;
          case('Multiply'):
          result = n1*n2;
          break;
        
       }console.log(calculationvalid);
   }










       