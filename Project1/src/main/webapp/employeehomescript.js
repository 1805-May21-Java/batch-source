console.log("hey0");

sendAjaxGet("http://localhost:8082/Project1/EmployeeHome", displayId)

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

function displayId(xhr){
	info = xhr.response
	console.log(info);
	document.getElementById("employeeid").innerHTML=info;
}

sendAjaxGet("http://localhost:8082/Project1/EmployeePendingServlet", displayPendingRequests)

/*function getPendingEmployeeRequests() {
	var x = document.getElementById('pendingTable');
    if (x.style.display === 'none') {
        x.style.display = 'table';
    } else {
        x.style.display = 'table';
    }
	sendAjaxGet("http://localhost:8082/Project1/EmployeePendingServlet", displayPendingRequests)
}*/

function displayPendingRequests(xhr){
	requests = JSON.parse(xhr.response)
	console.log(requests);
	
	table = document.getElementById("pendingTable");
	
	for(i in requests){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${requests[i].id} </td>
		<td> ${requests[i].requestDate} </td>
		<td> $ ${requests[i].amount} </td>
		<td> ${requests[i].description} </td>`;
		nextRow.setAttribute("scope","row");
		nextRow.setAttribute("class","table-primary");
		table.appendChild(nextRow);
	}
	
}

sendAjaxGet("http://localhost:8082/Project1/EmployeeApprovedServlet", displayApprovedRequests)

/*function getApprovedEmployeeRequests() {
	var x = document.getElementById('approvedTable');
    if (x.style.display === 'none') {
        x.style.display = 'table';
    } else {
        x.style.display = 'table';
    }
	sendAjaxGet("http://localhost:8082/Project1/EmployeeApprovedServlet", displayApprovedRequests)
}*/

function displayApprovedRequests(xhr){
	requestsArr = JSON.parse(xhr.response)
	console.log(requestsArr);
	
	table = document.getElementById("approvedTable");
	
	for(i in requestsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${requestsArr[i].id} </td>
		<td> ${requestsArr[i].requestDate} </td>
		<td> $ ${requestsArr[i].amount} </td>
		<td> ${requestsArr[i].description} </td>`;
		nextRow.setAttribute("scope","row");
		nextRow.setAttribute("class","table-primary");
		table.appendChild(nextRow);
	}
	
}