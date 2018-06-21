//document.getElementById("pending-tab").addEventListener("click", callDisplayRequests);

//function callDisplayRequests() {
//	console.log("back to pending");
//	sendAjaxGet("http://localhost:8082/ERSProject1/request", displayRequests);
//	// sendAjaxPost?
//}

function sendAjaxPost(url, contents){
    let xhr = (new XMLHttpRequest() || new ActiveXObject());
    xhr.open("POST", url);
    xhr.send(contents);
}

function sendAjaxGet(url, func){
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status ==200){
            func(this); //this refers to the XHR object
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

// get current user from session
sendAjaxGet("http://localhost:8082/ERSProject1/session", displayCurrentUser);

function displayCurrentUser(xhr){
	let response = JSON.parse(xhr.response);
	if (response.username != "null") {
		document.getElementById("user").innerHTML = "You are logged in as: " + response.firstname + " " + response.lastname;
		document.getElementById("card-name").innerHTML = response.firstname + " " + response.lastname;
		document.getElementById("card-email").innerHTML = "Email: " + response.email;
		document.getElementById("card-username").innerHTML = "Username: " + response.username;
	} else {
		window.location = "http://localhost:8082/ERSProject1/login";
	}
}

// display all requests by employee
// TODO: change this to pending requests only
sendAjaxGet("http://localhost:8082/ERSProject1/request", displayRequests);

function displayRequests(xhr){
	requests = JSON.parse(xhr.response)
	requestsArr = requests.requests;
	table = document.getElementById("table");
	
	for(i in requestsArr){
		console.log(requestsArr[i]);
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${requestsArr[i].id} </td>
		<td> ${requestsArr[i].title} </td>
		<td> ${requestsArr[i].amount} </td>
		<td> ${requestsArr[i].dateCreated} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
	
}

//// display current user's information
//sendAjaxGet("http://localhost:8082/ERSProject1/session", displayProfile);
//
//function displayProfile(xhr) {
//	let response = JSON.parse(xhr.response);
//	if (response.id != "null") {
//		document.getElementById("user").innerHTML = "You are logged in as: " + response.firstname + " " + response.lastname;
//	} else {
//		window.location = "http://localhost:8082/ERSProject1/login";
//	}
//}

//sendAjaxGet("http://localhost:8082/ERSProject1/employee", displayEmployees);
//
//function displayEmployees(xhr){
//	employees = JSON.parse(xhr.response);
//	employeesArr = employees.employees;
//	table = document.getElementById("table");
//	
//	for(i in employeesArr){
//		nextRow = document.createElement("tr");
//		nextRow.innerHTML = `<td> ${employeesArr[i].firstname} </td>
//		<td> ${employeesArr[i].username} </td>
//		<td> ${employeesArr[i].reportsto} </td>`;
//		nextRow.setAttribute("scope","row");
//		table.appendChild(nextRow);
//	}
//	
//}