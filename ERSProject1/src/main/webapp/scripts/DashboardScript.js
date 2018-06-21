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

	for(req of requestsArr){
		
		let reqId = req.id;
		nextRow = document.createElement("tr");
		nextRow.setAttribute("style", "background-color:lightgreen");
		let cell1 = document.createElement("th");
		let cell2 = document.createElement("td");
		let cell3 = document.createElement("td");
		let cell4 = document.createElement("td");
		let cell5 = document.createElement("td");
		let cell6 = document.createElement("td");
		let cell7 = document.createElement("td");
		let cell8 = document.createElement("td");
		cell1.setAttribute("scope", "row");
		cell1.innerHTML = reqId;
		cell2.innerHTML = req.title;
		cell3.innerHTML = "$" + req.amount.toFixed(2);
		cell4.innerHTML = req.comments;
		cell5.innerHTML = req.dateCreated;
		cell6.innerHTML = req.dateApproved;
		cell7.innerHTML = req.managerName;

		// pending requests
		if(req.dateApproved == null) {
			nextRow.setAttribute("style", "background-color:lightsalmon");
		}
		
		nextRow.appendChild(cell1);
		nextRow.appendChild(cell2);
		nextRow.appendChild(cell3);
		nextRow.appendChild(cell4);
		nextRow.appendChild(cell5);
		nextRow.appendChild(cell6);
		nextRow.appendChild(cell7);
		table.appendChild(nextRow);
	}
	
	// for(i in requestsArr){
	// 	console.log(requestsArr[i]);
	// 	nextRow = document.createElement("tr");
	// 	nextRow.innerHTML = `<td> ${requestsArr[i].id} </td>
	// 	<td> ${requestsArr[i].title} </td>
	// 	<td> ${requestsArr[i].amount} </td>
	// 	<td> ${requestsArr[i].dateCreated} </td>`;
	// 	nextRow.setAttribute("scope","row");
	// 	table.appendChild(nextRow);
	// }
	
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

