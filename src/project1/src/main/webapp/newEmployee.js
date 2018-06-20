window.onload = function(){
	sendAjaxGet("http://localhost:8080/project1/GetManagerServlet", populateUser);
}

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
	console.log(response[0]);
	var option = document.createElement("option");
	var managerSelect = document.getElementById("managerSelect");
	if ( response != "null" ){
		for(i = 0; i<response.length; i++){
			option.value=response[i].employeeId;
			option.text=response[i].employeeName;
			managerSelect.add(option,null);
		}
	} 
	// else {
	// 	window.location = "http://localhost:8080/project1/LoginServlet";
	// }
}