sendAjaxGet("http://localhost:8082/project1/SessionServlet", populateUser);

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

function populateUser(xhr){
	let response = JSON.parse(xhr.response);
	if ( response.username != "null" ){
		document.getElementById("welcome").innerHTML = "Welcome, "+ response.username + ".";
	} else {
		window.location = "http://localhost:8082/project1/LoginServlet";
	}
}