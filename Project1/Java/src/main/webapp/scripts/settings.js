//local url's
//let urlEmailValid = "http://localhost:8082/Project1/ValidInvalid";
//let urlUpdateEmployee = "http://localhost:8082/Project1/UpdateEmployee";
////let urlPopulateEmployee = "http://localhost:8082/Project1/PopulateEmployee";

//EC2 url's
let urlEmailValid = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/ValidInvalid";
let urlUpdateEmployee = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/UpdateEmployee";
let urlPopulateEmployee = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/PopulateEmployee";

sendAjax("GET",urlEmailValid,checkValidEmail);
let employee = JSON.parse(sessionStorage.getItem("employee"));

//set up listeners
let emailButton = document.getElementById("changeEmail");
let passwordButton = document.getElementById("changePassword");
let nameButton = document.getElementById("changeName");

let emailField = document.getElementById("email");
let passwordField = document.getElementById("password");
let nameField = document.getElementById("name");

let emailText = document.createElement("input");
let passwordText = document.createElement("input");
let nameText = document.createElement("input");
emailButton.onclick = function(){
     emailText.setAttribute("value",emailField.innerHTML);
     emailText.setAttribute("type","email");
     emailText.setAttribute("class","form-control color-	secondary")
     emailField.innerHTML="";
     emailField.appendChild(emailText);
   //removes on click
     this.onclick = null;
}

passwordButton.onclick = function(){
     passwordText.setAttribute("value",passwordField.innerHTML);
     passwordText.setAttribute("type","password");
     passwordText.setAttribute("class","form-control")
     passwordField.innerHTML="";
     passwordField.appendChild(passwordText);
   //removes on click
     this.onclick = null;
}

nameButton.onclick = function(){
     nameText.setAttribute("value",nameField.innerHTML);
     nameText.setAttribute("type","text");
     nameText.setAttribute("class","form-control")
     nameField.innerHTML="";
     nameField.appendChild(nameText);
     //removes on click
     this.onclick = null;
}

//When submit pressed, saves new values
document.getElementById("save").addEventListener("click",function(){
  let nameValue;
  let emailValue;
  let passwordValue;
  
  nameValue = (nameText.value) ?  nameText.value : nameField.innerHTML;
  emailValue = (emailText.value) ? emailText.value : emailField.innerHTML;
  passwordValue = (passwordText.value) ? passwordText.value :  passwordField.innerHTML ;

  let changedEmployee = {
    name:nameValue,
    email:emailValue,
    password:passwordValue}
  	
    employee.name = changedEmployee.name;
    employee.email = changedEmployee.email;
    employee.password = changedEmployee.password;
  	sessionStorage.setItem("employee",JSON.stringify(employee));
    sendAjax("POST",urlUpdateEmployee,reload,JSON.stringify(changedEmployee));
});

//Reads employee, fills fields with current values
fillFields(employee);

function sendAjax(verb,url,func,data){
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(){
      if(xhr.readyState === 4 && xhr.status === 200){
          func(xhr);
      }
  }
  xhr.open(verb,url);
  xhr.send(data);
}

function reload(){
	location.reload();
}

function fillFields(response){
  emailField.innerHTML = response.email;
  nameField.innerHTML = response.name;
  passwordField.innerHTML = response.password;
  if(response.employeeList.length > 0){
    unhide("managerTab");   
  }
}

function checkValidEmail(xhr){
	let response = JSON.parse(xhr.response);
	  if(response.emailValid == "Invalid"){
      //user tried to enter invalid email, displays error message and refreshes correct information
      unhide("invalidEmail");
      sendAjax("GET",urlPopulateEmployee,updateSession);
	  }
}

function unhide(id){
  let tag = document.getElementById(id)
  tag.removeAttribute("hidden");
}

function updateSession(xhr){
  sessionStorage.setItem("employee",xhr.response);
  fillFields(JSON.parse(sessionStorage.getItem("employee")));
}