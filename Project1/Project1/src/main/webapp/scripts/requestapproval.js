var employee;
var reqList;
var empList;
var manager;
var requester;

window.onload = function() {
	getEmployeeAJAX();
	getEmployeesAJAX();
	
}

function getEmployeeAJAX() {
	let url = "http://localhost:8082/Project1/employeequery?id=" + id;
	
	let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
        if (this.status == 200 && this.readyState == 4) {
            setEmployee(this.response);
        }
	}
	xhr.open("GET", url);
	xhr.send();
}

function getEmployeesAJAX() {
let url = "http://localhost:8082/Project1/employeequery";
	
	let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
        if (this.status == 200 && this.readyState == 4) {
        	console.log(JSON.parse(this.response));
            setEmployeeList(this.response);
            getRequestsAJAX();
        }
	}
	xhr.open("GET", url);
	xhr.send();
}

function getRequestsAJAX() {
	let url = "http://localhost:8082/Project1/requestquery";
	
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
	reqList = json.requests;
	console.log(reqList);
}

function setEmployeeList(response) {
	console.log("Set Employees")
	let json = JSON.parse(response);
	empList = json.employees;
	console.log(empList);
}

function setTableInfo() {
	let tbody = document.getElementById("allRequestsTable");
	for (let i = 0; i < reqList.length; i++) {
		let newRow = document.createElement("tr");
		let req = reqList[i];
		let manager;
		let requester = getRequester(req);
		if (Number(req.status) != 0) {
			manager = getManager(req);
		}
		rowString = `<td>${req.requestId}</td>`
			+ `<td>${req.amount}</td>`
			+ `<td>${requester.firstname + " " + requester.lastname}</td>`
			+ `<td>${req.dateCreated}</td>`
			+ `<td>${interpretStatus(req.status)}</td>`;
		if (Number(req.status) != 0) {
			rowString += `<td>${req.dateAddressed}</td>`;
			rowString += `<td>${manager.firstname + " " + manager.lastname}</td>`;
		} else {
			rowString += '<td>None</td>';
			rowString += '<td>None</td>';
		}
		rowString += `<td><button class="btn btn-outline-info" id="view${i}">View Request</button></td>`;
		newRow.innerHTML = rowString;
		tbody.appendChild(newRow);
		document.getElementById("view"+i).addEventListener("click", function() {
			setDetailsInfo(i, manager, requester);
		});
	}
}

function getRequester(req) {
	for(let i = 0; i < empList.length; i++) {
		if (empList[i].employeeId == req.employeeId){
			return empList[i];
		}
	}
}

function getManager(req) {
	for (let i = 0; i < empList.length; i++) {
		if (empList[i].employeeId == req.managerId) {
			return empList[i];
		}
	}
}

function setDetailsInfo(idx, man, req) {
	document.getElementById("actions").innerHTML = "";
	let r = reqList[idx];
	document.getElementById("detailsRID").innerHTML = r.requestId;
	document.getElementById("detailsEID").innerHTML = r.employeeId;
	document.getElementById("detailsEName").innerHTML = req.firstname + " " + req.lastname;
	document.getElementById("detailsAmount").innerHTML = r.amount;
	document.getElementById("detailsCreated").innerHTML = r.dateCreated;
	document.getElementById("detailsStatus").innerHTML = interpretStatus(r.status);
	if (r.status != 0) {
		document.getElementById("detailsResolved").innerHTML = r.dateAddressed;
		document.getElementById("detailsMID").innerHTML = r.managerId;
		document.getElementById("detailsRName").innerHTML = man.firstname + " " + man.lastname;
	} else {
		document.getElementById("detailsResolved").innerHTML = "None";
		document.getElementById("detailsMID").innerHTML = "None";
		document.getElementById("detailsRName").innerHTML = "None";
		document.getElementById("actions").innerHTML = `<form action="requestapproval" method="post">`
			+ `<input name="rid" value="${r.requestId}" hidden>`
			+ `<input class="btn btn-outline-success" name="approve" type="submit" value="Approve">`
			+ `<input class="btn btn-outline-danger" name="deny" type="submit" value="Deny"></form>`;
	}
	document.getElementById("detailsDetails").innerHTML = r.requestText;
	
}

function interpretStatus(s) {
	if (s == 0) return "Unresolved";
	if (s < 0) return "Denied";
	if (s > 0) return "Approved";
}