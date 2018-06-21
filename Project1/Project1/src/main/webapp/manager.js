window.onload = function() {
	sendAjaxGet("http://localhost:8181/Project1/session", checkSession);
}

document.getElementById("pending-tab").addEventListener("click", getPendingRequests);
document.getElementById("resolved-tab").addEventListener("click", getResolvedRequests);
document.getElementById("viewEmployees-tab").addEventListener("click", getAllEmployees);
document.getElementById("getReimbursementRequests").addEventListener("click", getEmployeeRequests)

function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}


function checkSession(xhr) {
	const response = JSON.parse(xhr.response);
	if(response.email === "null" || response.type !== "manager")
		window.location = "http://localhost:8181/Project1/login.html"
}

function getPendingRequests() {
	sendAjaxGet("http://localhost:8181/Project1/manager?type=pending", displayPendingRequests);
}

function displayPendingRequests(xhr) {
	const reimbursements = JSON.parse(xhr.response);
	const reimbursementsArr = reimbursements.reimbursements;

	const oldTable = document.getElementById("pendingTable");
	if(oldTable)
		document.getElementById("viewAllPending").removeChild(oldTable);
	const table = document.createElement("table");
	const head = document.createElement("thead");
	const headRow = document.createElement("tr");
	const th1 = document.createElement("th");
	th1.innerHTML = "Requested By";
	const th2 = document.createElement("th");
	th2.innerHTML = "Amount";
	const th3 = document.createElement("th");
	th3.innerHTML = "Reason";
	const th4 = document.createElement("th");
	th4.innerHTML = "Requested At";
	const th5 = document.createElement("th");
	th5.innerHTML = "Receipt";
	const th6 = document.createElement("th");
	headRow.appendChild(th1);
	headRow.appendChild(th2);
	headRow.appendChild(th3);
	headRow.appendChild(th4);
	headRow.appendChild(th5);
	headRow.appendChild(th6);
	head.appendChild(headRow);
	table.appendChild(head);
	const tableBody = document.createElement("tbody");
	table.appendChild(tableBody);
	document.getElementById("viewAllPending").append(table);
	table.setAttribute("class", "table table-hover mt-4");
	head.setAttribute("class", "bg-dark text-white");
	table.setAttribute("id", "pendingTable");
	
	for(let i in reimbursementsArr) {
		let nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${reimbursementsArr[i].requestedBy} </td>
		<td> $${reimbursementsArr[i].amount} </td>
		<td> ${reimbursementsArr[i].reason} </td>
		<td> ${moment(reimbursementsArr[i].insertedAt).format('MMMM Do YYYY, h:mm:ss A')} </td>
		<td><a href=https://s3.amazonaws.com/revature-project-1/${reimbursementsArr[i].key}>View receipt</a></td>
		<td><button class="btn btn-primary" onclick=approve(${reimbursementsArr[i].id})>Approve</button>
		    <button class="btn btn-danger" onclick=deny(${reimbursementsArr[i].id})>Deny</button></td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);		
	}
}

function sendAjaxPut(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("PUT", url);
    xhr.send();
}

function approve(id) {
	sendAjaxPut("http://localhost:8181/Project1/manager?id=" + id + "&action=approve", displayPendingRequests);
}

function deny(id) {
	sendAjaxPut("http://localhost:8181/Project1/manager?id=" + id + "&action=deny", displayPendingRequests);
}

function getResolvedRequests(){
	sendAjaxGet("http://localhost:8181/Project1/manager?type=resolved", displayResolvedRequests);
}

function displayResolvedRequests(xhr) {
	const reimbursements = JSON.parse(xhr.response);
	const reimbursementsArr = reimbursements.reimbursements;
	const oldTable = document.getElementById("resolvedTable");
	if(oldTable)
		document.getElementById("viewAllResolved").removeChild(oldTable);
	const table = document.createElement("table");
	const head = document.createElement("thead");
	const headRow = document.createElement("tr");
	const th1 = document.createElement("th");
	th1.innerHTML = "Requested By";
	const th2 = document.createElement("th");
	th2.innerHTML = "Amount";
	const th3 = document.createElement("th");
	th3.innerHTML = "Reason";
	const th4 = document.createElement("th");
	th4.innerHTML = "Requested At";
	const th5 = document.createElement("th");
	th5.innerHTML = "Outcome";
	const th6 = document.createElement("th");
	th6.innerHTML = "Resolved By";
	const th7 = document.createElement("th");
	th7.innerHTML = "Receipt";
	headRow.appendChild(th1);
	headRow.appendChild(th2);
	headRow.appendChild(th3);
	headRow.appendChild(th4);
	headRow.appendChild(th5);
	headRow.appendChild(th6);
	headRow.appendChild(th7);
	head.appendChild(headRow);
	table.appendChild(head);
	const tableBody = document.createElement("tbody");
	table.appendChild(tableBody);
	document.getElementById("viewAllResolved").append(table);

	table.setAttribute("class", "table table-hover mt-4");
	head.setAttribute("class", "bg-dark text-white");
	table.setAttribute("id", "resolvedTable");

	for(let i in reimbursementsArr) {
		let nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${reimbursementsArr[i].requestedBy} </td>
		<td> $${reimbursementsArr[i].amount} </td>
		<td> ${reimbursementsArr[i].reason} </td>
		<td> ${moment(reimbursementsArr[i].insertedAt).format('MMMM Do YYYY, h:mm:ss A')}</td>
		<td> ${reimbursementsArr[i].outcome} </td>
		<td> ${reimbursementsArr[i].resolvedBy} </td>
		<td> <a href=https://s3.amazonaws.com/revature-project-1/${reimbursementsArr[i].key}>View receipt</a></td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);		
	}
}


function getEmployeeRequests() {
	const employeeEmail = document.getElementById("employeeEmail").value;
	sendAjaxGet("http://localhost:8181/Project1/employee?employeeEmail=" + employeeEmail, displayAllRequestsForUser);
}

function displayAllRequestsForUser(xhr) {
	const reimbursements = JSON.parse(xhr.response);
	const reimbursementsArr = reimbursements.reimbursements;
	const oldTable = document.getElementById("allTable");
	if(oldTable)
		document.getElementById("viewSingleEmployee").removeChild(oldTable);
	const table = document.createElement("table");
	const head = document.createElement("thead");
	const headRow = document.createElement("tr");
	const th1 = document.createElement("th");
	th1.innerHTML = "Requested By";
	const th2 = document.createElement("th");
	th2.innerHTML = "Amount";
	const th3 = document.createElement("th");
	th3.innerHTML = "Reason";
	const th4 = document.createElement("th");
	th4.innerHTML = "Requested At";
	const th5 = document.createElement("th");
	th5.innerHTML = "Status";
	const th6 = document.createElement("th");
	th6.innerHTML = "Receipt";
	headRow.appendChild(th1);
	headRow.appendChild(th2);
	headRow.appendChild(th3);
	headRow.appendChild(th4);
	headRow.appendChild(th5);
	headRow.appendChild(th6);
	head.appendChild(headRow);
	table.appendChild(head);
	const tableBody = document.createElement("tbody");
	table.appendChild(tableBody);
	document.getElementById("viewSingleEmployee").append(table);
	table.setAttribute("class", "table table-hover mt-4");
	head.setAttribute("class", "bg-dark text-white");
	table.setAttribute("id", "allTable");

	for(let i in reimbursementsArr) {
		let nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${reimbursementsArr[i].requestedBy} </td>
		<td> $${reimbursementsArr[i].amount}</td>
		<td> ${reimbursementsArr[i].reason} </td>
		<td> ${moment(reimbursementsArr[i].insertedAt).format('MMMM Do YYYY, h:mm:ss A')}</td>
		<td> ${reimbursementsArr[i].status} </td>
		<td> <a href=https://s3.amazonaws.com/revature-project-1/${reimbursementsArr[i].key}>View receipt</a></td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);		
	}
}

function getAllEmployees() {
	sendAjaxGet("http://localhost:8181/Project1/manager?type=all", displayEmployees);
}

function displayEmployees(xhr){
	const employees = JSON.parse(xhr.response);
	console.log(employees);
	const employeesArr = employees.employees;
	const oldTable = document.getElementById("allEmployees");
	if(oldTable)
		document.getElementById("viewEmployees").removeChild(oldTable);
	const table = document.createElement("table");
	const head = document.createElement("thead");
	const headRow = document.createElement("tr");
	const th1 = document.createElement("th");
	th1.innerHTML = "Full Name";
	const th2 = document.createElement("th");
	th2.innerHTML = "Email address";
	const th3 = document.createElement("th");
	th3.innerHTML = "Phone Number";
	const th4 = document.createElement("th");
	th4.innerHTML = "Address";
	headRow.appendChild(th1);
	headRow.appendChild(th2);
	headRow.appendChild(th3);
	headRow.appendChild(th4);
	
	head.appendChild(headRow);
	table.appendChild(head);
	const tableBody = document.createElement("tbody");
	table.appendChild(tableBody);
	document.getElementById("viewEmployees").append(table);
	table.setAttribute("class", "table table-hover mt-4");
	head.setAttribute("class", "bg-dark text-white");
	table.setAttribute("id", "allEmployees");

	for(let i in employeesArr) {
		let nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${employeesArr[i].firstName} ${employeesArr[i].lastName} </td>
		<td> ${employeesArr[i].email} </td>
		<td> ${employeesArr[i].phone} </td>
		<td> ${employeesArr[i].streetAddress}, ${employeesArr[i].city}, ${employeesArr[i].state}, ${employeesArr[i].zipcode} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);		
	}
}