console.log("heyooooo");

function viewEmployees() {
	var x = document.getElementById('employeesTable');
    if (x.style.display === 'none') {
        x.style.display = 'table';
    } else {
        x.style.display = 'table';
    }
	sendAjaxGet("http://localhost:8082/Project1/EmployeesServlet", displayEmployees)
}


function sendAjaxGet(url, func){
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status ==200){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayEmployees(xhr){
	employeesArr = JSON.parse(xhr.response)
	console.log(employeesArr);
	
	table = document.getElementById("employeesTable");
	
	for(i in employeesArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${employeesArr[i].id} </td>
		<td> ${employeesArr[i].email} </td>
		<td> ${employeesArr[i].firstName} </td>
		<td> ${employeesArr[i].lastName} </td>
		<td> ${employeesArr[i].phoneNumber} </td>
		<td> ${employeesArr[i].title} </td>
		<td> ${employeesArr[i].department} </td>
		<td> ${employeesArr[i].managerId} </td>
		<td>
		 <button value="${employeesArr[i].id}" onclick="viewSingleEmployee(this.value)" class="btn btn-primary">View</button> 
		</td>`;
		nextRow.setAttribute("scope","row");
		nextRow.setAttribute("class","table-primary");
		table.appendChild(nextRow);
	}
	
}

function viewSingleEmployee(reqid) {
	let id = reqid;
	sendAjaxGet("http://localhost:8082/Project1/ManagerViewSingleEmployee"+ "?id="+id, viewEmployee);
	}

function viewEmployee (xhr){
	requestsArr = JSON.parse(xhr.response)
	console.log(requestsArr);
	
		document.getElementById("empId").innerHTML=requestsArr[0].employeeId;
		
		var x = document.getElementById('pendingTable');
    	if (x.style.display === 'none') {
        x.style.display = 'table';
    	} else {
        x.style.display = 'table';
    	}
		
		table = document.getElementById("pendingTable");
	
		for(i in requestsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${requestsArr[i].id} </td>
		<td> ${requestsArr[i].requestDate} </td>
		<td> $ ${requestsArr[i].amount} </td>
		<td> ${requestsArr[i].description} </td>
		<td>
		 <button value="${requestsArr[i].id}" onclick="approveRequest(this.value)" class="btn btn-primary">Approve</button> 
		</td>`;
		nextRow.setAttribute("scope","row");
		nextRow.setAttribute("class","table-primary");
		table.appendChild(nextRow);
	}
}

function approveRequest(reqid) {
	let id = reqid;
	sendAjaxGet("http://localhost:8082/Project1/ManagerApproveServlet"+"?id="+id, requestApproval);
}

function requestApproval (xhr){
	console.log("Request Approved");
}



//function getPendingEmployeeRequests() {
//	var x = document.getElementById('pendingTable');
//    if (x.style.display === 'none') {
//        x.style.display = 'table';
//    } else {
//        x.style.display = 'table';
//    }
//	sendAjaxGet("http://localhost:8082/Project1/EmployeePendingServlet", displayPendingRequests)
//}
//
//function displayPendingRequests(xhr){
//	requests = JSON.parse(xhr.response)
//	console.log(requests);
//	
//	table = document.getElementById("pendingTable");
//	
//	for(i in requests){
//		nextRow = document.createElement("tr");
//		nextRow.innerHTML = `<td> ${requests[i].id} </td>
//		<td> ${requests[i].requestDate} </td>
//		<td> $ ${requests[i].amount} </td>`;
//		nextRow.setAttribute("scope","row");
//		nextRow.setAttribute("class","table-primary");
//		table.appendChild(nextRow);
//	}
//	
//}
//
//function getApprovedEmployeeRequests() {
//	var x = document.getElementById('approvedTable');
//    if (x.style.display === 'none') {
//        x.style.display = 'table';
//    } else {
//        x.style.display = 'table';
//    }
//	sendAjaxGet("http://localhost:8082/Project1/EmployeeApprovedServlet", displayApprovedRequests)
//}
//
//function displayApprovedRequests(xhr){
//	requestsArr = JSON.parse(xhr.response)
//	console.log(requestsArr);
//	
//	table = document.getElementById("approvedTable");
//	
//	for(i in requestsArr){
//		nextRow = document.createElement("tr");
//		nextRow.innerHTML = `<td> ${requestsArr[i].id} </td>
//		<td> ${requestsArr[i].requestDate} </td>
//		<td> $ ${requestsArr[i].amount} </td>`;
//		nextRow.setAttribute("scope","row");
//		nextRow.setAttribute("class","table-primary");
//		table.appendChild(nextRow);
//	}
//	
//}