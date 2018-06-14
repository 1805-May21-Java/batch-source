/**
 * 
 */

sendAjaxGet("http://localhost:8080/ERSProject1/session", populateUser);

function sendAjaxGet(url, func) {
	let xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url);
	xhr.send();
}

function populateUser(xhr) {
	let response = JSON.parse(xhr.response);
	if (response.username != "null") {
		document.getElementById("user").innerHTML = "You are logged in as: " + response.username;
	} else {
		window.location = "http://localhost:8080/ServletLoginDemo/login";
	}
}

