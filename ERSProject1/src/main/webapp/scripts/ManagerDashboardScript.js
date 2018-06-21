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
		document.getElementById("user").innerHTML = "You are logged in as: " + response.firstname + " " + response.lastname + "(Manager)";
		document.getElementById("card-name").innerHTML = response.firstname + " " + response.lastname;
		document.getElementById("card-email").innerHTML = "Email: " + response.email;
		document.getElementById("card-username").innerHTML = "Username: " + response.username;
	} else {
		window.location = "http://localhost:8082/ERSProject1/login";
	}
}

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
			// add approve/deny buttons
			let appButton = document.createElement("button");
			appButton.setAttribute("class", "btn");
			appButton.setAttribute("type", "submit");
			appButton.setAttribute("id", "app"+reqId);
			appButton.innerHTML = "Approve";

			let denyButton = document.createElement("button");
			denyButton.setAttribute("class", "btn");
			denyButton.setAttribute("type", "submit");
			denyButton.setAttribute("id", "deny"+reqId)
			denyButton.innerHTML = "Deny";

			// form for buttons
			let myForm = document.createElement("form");
			myForm.setAttribute("action", "request");
			myForm.setAttribute("method", "post");
			myForm.setAttribute("id", "myForm"+reqId)
			myForm.appendChild(appButton);
			myForm.appendChild(denyButton);

			// hidden elements to pass id to servlet
			let serviceInput = document.createElement("input");
			let valueInput = document.createElement("input");
			serviceInput.setAttribute("type", "text");
			serviceInput.setAttribute("name", "postAction");
			serviceInput.setAttribute("id", "service"+reqId);
			serviceInput.setAttribute("hidden", "true");
			valueInput.setAttribute("type", "text");
			valueInput.setAttribute("name", "postValue");
			valueInput.setAttribute("id", "value"+reqId);
			valueInput.setAttribute("hidden", "true");

			myForm.appendChild(serviceInput);
			myForm.appendChild(valueInput);
			cell8.appendChild(myForm);

			// approve or deny?
			appButton.addEventListener("click", function(){
				serviceInput.value = "approve";
				valueInput.value = reqId;
			});
			denyButton.addEventListener("click", function(){
				serviceInput.value = "deny";
				valueInput.value = reqId;
			});
		}
		
		nextRow.appendChild(cell1);
		nextRow.appendChild(cell2);
		nextRow.appendChild(cell3);
		nextRow.appendChild(cell4);
		nextRow.appendChild(cell5);
		nextRow.appendChild(cell6);
		nextRow.appendChild(cell7);
		nextRow.appendChild(cell8);
		table.appendChild(nextRow);
	}
	
}

sendAjaxGet("http://localhost:8082/ERSProject1/employee", displayEmployees);

function displayEmployees(xhr){
	employees = JSON.parse(xhr.response);
	employeesArr = employees.employees;
	table = document.getElementById("employee-table");
	
	for(i in employeesArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${employeesArr[i].id}
		<td> ${employeesArr[i].firstname} ${employeesArr[i].lastname} </td>
		<td> ${employeesArr[i].username} </td>
		<td> ${employeesArr[i].email} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
	
}