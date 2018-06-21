window.onload = function(){
	sendAjaxGet("http://localhost:8080/project1/SessionServlet", getEmployee);
}

var nameForm = document.getElementById("nameForm");
var usernameForm = document.getElementById("usernameForm");
var passwordForm = document.getElementById("passwordForm");
var confirmPasswordForm = document.getElementById("confirmPasswordForm");


function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status ==200){
			func(this);
		}
	};
	xhr.open("GET",url);
	xhr.send();
}

function getEmployee(xhr){
	let response = JSON.parse(xhr.response);
	console.log(response);
	
	if ( response != "null" ){
		nameForm.value = response.employeeName;
		usernameForm.value = response.username;
		passwordForm.value = response.password;
		confirmPasswordForm.value = response.password;
	}
}