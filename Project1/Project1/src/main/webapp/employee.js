window.onload = function() {
	sendAjaxGet("http://localhost:8181/Project1/session", checkSession);
}

document.getElementById("pending-tab").addEventListener("click", getPendingRequests);
document.getElementById("resolved-tab").addEventListener("click", getResolvedRequests);
document.getElementById("viewInfo-tab").addEventListener("click", getEmployeeInfo);
document.getElementById("changePasswordButton").addEventListener("click", changePassword);

let employeeEmail;

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
	if(response.email === "null" || response.type !== "employee")
		window.location = "http://localhost:8181/Project1/login.html"
	else
		employeeEmail = response.email;
}

function getPendingRequests() {
	sendAjaxGet("http://localhost:8181/Project1/employee?type=pending", displayPendingRequests);
}

function displayPendingRequests(xhr) {
	const reimbursements = JSON.parse(xhr.response);
	const reimbursementsArr = reimbursements.reimbursements;
	console.log(reimbursementsArr)
	const oldTable = document.getElementById("pendingTable");
	if(oldTable)
		document.getElementById("viewAllPending").removeChild(oldTable);
	const table = document.createElement("table");
	const head = document.createElement("thead");
	const headRow = document.createElement("tr");
	const th1 = document.createElement("th");
	th1.innerHTML = "Amount";
	const th2 = document.createElement("th");
	th2.innerHTML = "Reason";
	const th3 = document.createElement("th");
	th3.innerHTML = "Requested At";
	const th4 = document.createElement("th");
	th4.innerHTML = "Receipt";
	headRow.appendChild(th1);
	headRow.appendChild(th2);
	headRow.appendChild(th3);
	headRow.appendChild(th4);
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
		nextRow.innerHTML = `<td> $${reimbursementsArr[i].amount} </td>
		<td> ${reimbursementsArr[i].reason} </td>
		<td> ${moment(reimbursementsArr[i].insertedAt).format('MMMM Do YYYY, h:mm:ss A')} </td>
		<td> <a href=https://s3.amazonaws.com/revature-project-1/${reimbursementsArr[i].key}>View receipt</a></td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);		
	}
}

function getResolvedRequests(){
	sendAjaxGet("http://localhost:8181/Project1/employee?type=resolved", displayResolvedRequests);
}

function displayResolvedRequests(xhr) {
	const reimbursements = JSON.parse(xhr.response);
	const reimbursementsArr = reimbursements.reimbursements;
	console.log(reimbursementsArr)
	const oldTable = document.getElementById("resolvedTable");
	if(oldTable)
		document.getElementById("viewAllResolved").removeChild(oldTable);
	const table = document.createElement("table");
	const head = document.createElement("thead");
	const headRow = document.createElement("tr");
	const th1 = document.createElement("th");
	th1.innerHTML = "Amount";
	const th2 = document.createElement("th");
	th2.innerHTML = "Reason";
	const th3 = document.createElement("th");
	th3.innerHTML = "Request At";
	const th4 = document.createElement("th");
	th4.innerHTML = "Outcome";
	const th5 = document.createElement("th");
	th5.innerHTML = "Resolved by";
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
	document.getElementById("viewAllResolved").appendChild(table);
	table.setAttribute("class", "table table-hover mt-4");
	head.setAttribute("class", "bg-dark text-white");
	table.setAttribute("id", "resolvedTable");

	for(let i in reimbursementsArr) {
		let nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> $${reimbursementsArr[i].amount} </td>
			<td> ${reimbursementsArr[i].reason} </td>
			<td> ${moment(reimbursementsArr[i].insertedAt).format('MMMM Do YYYY, h:mm:ss A')} </td>
			<td> ${reimbursementsArr[i].outcome} </td>
			<td> ${reimbursementsArr[i].resolvedBy} </td>
			<td> <a href=https://s3.amazonaws.com/revature-project-1/${reimbursementsArr[i].key}>View receipt</a></td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);		
	}
}

function sendAjaxPut(url){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.open("PUT", url);
    xhr.send();
}

function sendAjaxPut(url, func, content){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("PUT", url);
    xhr.send(content);
}

function changePassword() {
	const password = document.getElementById("password").value;
	sendAjaxPut("http://localhost:8181/Project1/employee", hideTab, password);
}

function hideTab(){
	window.location.assign("employee.html");
}

function getEmployeeInfo() {
	sendAjaxGet("http://localhost:8181/Project1/reimbursement", displayEmployee);
}

function displayEmployee(xhr){
	const employee = JSON.parse(xhr.response).employee;
	console.log(employee);
	const oldDiv= document.getElementById("infoContainer");
	if(oldDiv)
		document.getElementById("viewInfo").removeChild(oldDiv);
	let divContainer = document.createElement("div");
	const fullName = employee.firstName ? `${employee.firstName} ${employee.lastName}` : "N/A";
	const fullAdress = employee.streetAddress ? `${employee.streetAddress}, ${employee.city}, ${employee.state}, ${employee.zipcode}` : "N/A";
	divContainer.innerHTML = `
		<p><span class="font-weight-bold">Full Name: </span>${fullName}</p>
		<p><span class="font-weight-bold">Email address: </span>${employee.email}</p>
		<p><span class="font-weight-bold">Phone number: </span>${employee.phone}</p>
		<p><span class="font-weight-bold">Address: </span>${fullAdress}</p>
	`;
	divContainer.setAttribute("id", "infoContainer");
	divContainer.setAttribute("class", "mt-4");
	document.getElementById("viewInfo").appendChild(divContainer);
}