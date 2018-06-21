console.log("hey");

function getApprovedRequests() {
	var x = document.getElementById('approvedTable');
    if (x.style.display === 'none') {
        x.style.display = 'table';
    } else {
        x.style.display = 'table';
    }
	sendAjaxGet("http://localhost:8082/Project1/ApprovedRequestsServlet", displayApprovedRequests)
}

function getPendingRequests() {
	var x = document.getElementById('pendingTable');
    if (x.style.display === 'none') {
        x.style.display = 'table';
    } else {
        x.style.display = 'table';
    }
	sendAjaxGet("http://localhost:8082/Project1/PendingRequestsServlet", displayPendingRequests)
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

function sendAjaxPost(url, func){
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status ==200){
            func(this);
        }
    }
    xhr.open("POST", url);
    xhr.send();
}

function displayApprovedRequests(xhr){
	requestsArr = JSON.parse(xhr.response)
	console.log(requestsArr);
	
	
	table = document.getElementById("approvedTable");
	
	for(i in requestsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${requestsArr[i].id} </td>
		<td> ${requestsArr[i].requestDate} </td>
		<td> $ ${requestsArr[i].amount} </td>
		<td> ${requestsArr[i].employeeId} </td>
		<td> ${requestsArr[i].description} </td>
		<td> ${requestsArr[i].managerApproved} </td>`;
		nextRow.setAttribute("scope","row");
		nextRow.setAttribute("class","table-primary");
		table.appendChild(nextRow);
	}
	
}

function displayPendingRequests(xhr){
	requests = JSON.parse(xhr.response)
	pendingRequestsArr = requests;
	console.log(requests);
	
	
	table = document.getElementById("pendingTable");
	
	for(i in requests){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${requests[i].id} </td>
		<td> ${requests[i].requestDate} </td>
		<td> $ ${requests[i].amount} </td>
		<td> ${requests[i].employeeId} </td>
		<td> ${requests[i].description} </td>
		<td> 
			<button value="${requests[i].id}" onclick="approveRequest(this.value)" class="btn btn-primary">Approve</button> 
		</td>`;
		nextRow.setAttribute("scope","row");
		nextRow.setAttribute("class","table-primary");
		table.appendChild(nextRow);
	}
	
}

function approveRequest(reqid) {
	let id = reqid;
	    sendAjaxPost("http://localhost:8082/Project1/ManagerApproveServlet"+"?id="+id, requestApproval);
	}

function requestApproval (xhr){
	console.log("DONE");
}