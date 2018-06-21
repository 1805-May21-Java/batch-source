var employee;

window.onload = function() {
	getEmployeeAJAX(id);
	getRequestsAJAX(id);
	
}

function getEmployeeAJAX() {
	let url = "http://localhost:8082/Project1/employeequery?id=" + id;
	
	let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
        if (this.status == 200 && this.readyState == 4) {
            setEmployee(this.response);
            setTitleInfo();
        }
	}
	xhr.open("GET", url);
	xhr.send();
}

function getRequestsAJAX() {
	let url = "http://localhost:8082/Project1/requestquery?employeeId=" + id;
	
	let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
        if (this.status == 200 && this.readyState == 4) {
            setRequestList(this.response);
            setTableInfo();
        }
	}
	xhr.open("GET", url);
	xhr.send();
}

function setEmployee(response) {
	let json = JSON.parse(response);
	employee = json.employees[0];
	console.log(employee);
}

function setRequestList(response) {
	let json = JSON.parse(response);
	requests = json.requests;
	console.log(requests);
}

function setTitleInfo() {
	document.getElementById("requestsTitle").innerHTML = employee.firstname + "'s Reimbursement Requests";
}

function setTableInfo() {
	let tbody = document.getElementById("employeeRequestsTable");
	for (let i = 0; i < requests.length; i++) {
		let newRow = document.createElement("tr");
		newRow.innerHTML = `<td>${requests[i].requestId}</td>`
			+ `<td>${requests[i].dateCreated}</td>`
			+ `<td>${interpretStatus(requests[i].status)}</td>`
			+ `<td><button class="btn btn-outline-info" id="view${i}">View</button></td>`;
		tbody.appendChild(newRow);
		document.getElementById("view"+i).addEventListener("click", function() {
			setDetailsInfo(i);
		});
	}
}

function setDetailsInfo(idx) {
	let r = requests[idx];
	document.getElementById("detailsRID").innerHTML = r.requestId;
	document.getElementById("detailsEID").innerHTML = r.employeeId;
	document.getElementById("detailsAmount").innerHTML = r.amount;
	document.getElementById("detailsCreated").innerHTML = r.dateCreated;
	document.getElementById("detailsStatus").innerHTML = interpretStatus(r.status);
	document.getElementById("detailsDetails").innerHTML = r.requestText;
}

function interpretStatus(s) {
	if (s == 0) return "Unresolved";
	if (s < 0) return "Denied";
	if (s > 0) return "Approved";
}