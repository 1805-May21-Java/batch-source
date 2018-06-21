//local url's
//let urlLogin  = "http://localhost:8082/Project1/Login";

//remoteurl's
let urlLogin = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/Login";

sendAjax("GET",urlLogin,checkPreviousLogin);

function sendAjax(verb,url,func){
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(){
      if(xhr.readyState === 4 && xhr.status === 200){
          func(xhr);
      }
  }
  xhr.open(verb,url);
  xhr.send();
}
  
  function checkPreviousLogin(xhr){
   //checks to see if user had incorrect login
    let response = JSON.parse(xhr.response);
    if(response.credentials == "incorrect"){
      document.getElementById("incorrectCredentialsMessage").removeAttribute("hidden");
    }
  }