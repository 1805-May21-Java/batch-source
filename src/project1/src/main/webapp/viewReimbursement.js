window.onload = function () {
	sendAjaxGet("http://localhost:8080/project1/SessionServlet", getEmployee);
	sendAjaxGet("http://localhost:8080/project1/GetManagerServlet", setManagerList);
}

var table = document.getElementById("userTable");
var reimbursementSelect = document.getElementById("reimbursementSelect");
var employeeSelect = document.getElementById("employeeSelect");
var isManager = false;
var managerList = [];
var employeeList = [];
var employeeId;
var managerId;
var reimbursementList = [];
var displayList = [];
var tempList = [];


function sendAjaxGet(url, func) {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("GET", url);
	xhr.send();
}

function populateUser(xhr) {
	let response = JSON.parse(xhr.response);
	console.log(response[0]);

	if (response != "null") {
		clearTable();
		addToTable(response);
		reimbursementList = response;
	}
	
	sendAjaxGet("http://localhost:8080/project1/GetAllEmployees", setEmployeeList);
	// else {
	// 	window.location = "http://localhost:8080/project1/LoginServlet";
	// }
}

function setManagerList(xhr) {
	let response = JSON.parse(xhr.response);
	console.log(response);

	if (response != "null") {
		for (i = 0; i < response.length; i++) {
			if (employeeId == response[i].employeeId) {
				isManager = true;
				break;
			}
		}
		managerList = response;
		console.log("isManager is " + isManager);
		console.log("setManagerList " + managerList);

		// if (isManager) {
		sendAjaxGet("http://localhost:8080/project1/GetAllReimbursement", populateUser);
		// } else {
		// 	sendAjaxGet("http://localhost:8080/project1/GetReimbursementById", populateUser);
		// }
	}
}

function setEmployeeList(xhr) {
	let response = JSON.parse(xhr.response);
	console.log(response);

	if (response != "null") {
		employeeList = response;
		for (i = 0; i < response.length; i++) {
			console.log(response[i]);
			var option = document.createElement("option");
			option.value = response[i].employeeId;
			option.text = response[i].employeeName + " (" + response[i].username + ")";
			employeeSelect.add(option, null);
		}
		if (!isManager) {
			for (i = 0; i < employeeSelect.options.length; i++) {
				console.log("Enter is not manager for loop");
				console.log("employeeSelect value is: " + employeeSelect.options[i].value);
				if (Number.parseInt(employeeSelect.options[i].value) == employeeId) {
					employeeSelect.selectedIndex = i;
					break;
				}
			}
			employeeSelect.disabled = true;
			updateTable();
		}
	}
}

function getEmployee(xhr) {
	let response = JSON.parse(xhr.response);
	console.log(response.employeeId);

	if (response != "null") {
		employeeId = response.employeeId;
	}
}

function addToTable(response) {
	let newRow;
	let tempId;
	console.log(response);
	for (i = 0; i < response.length; i++) {
		// if(table.rows.length > amountSelect.value){
		// 	break;
		// }
		newRow = table.insertRow(table.rows.length);
		newRow.insertCell(0).innerHTML = response[i].reimbursementId;
		newRow.insertCell(1).innerHTML = response[i].date;
		switch (response[i].status) {
			case 0:
				newRow.insertCell(2).innerHTML = "Pending";
				break;
			case 1:
				newRow.insertCell(2).innerHTML = "Denied";
				break;
			case 2:
				newRow.insertCell(2).innerHTML = "Approved";
				break;
		}
		newRow.insertCell(3).innerHTML = "$" + response[i].reimbursementValue;
		newRow.insertCell(4).innerHTML = response[i].reimbursementReason;
		if (response[i].status != 0) {
			for (manager of managerList) {
				if (manager.employeeId == response[i].managerId) {
					newRow.insertCell(5).innerHTML = manager.employeeName;
					break;
				}
			}
		} else {
			newRow.insertCell(5).innerHTML = "";
		}
		// newRow.cells.item(5).value = reponse[i].managerId;
		var approveButton = document.createElement("button");
		approveButton.setAttribute("class", "btn btn-success");
		tempId = response[i].reimbursementId;
		approveButton.value = response[i].reimbursementId;
		approveButton.type = "submit";
		approveButton.innerHTML = "Approve";
		approveButton.addEventListener("click", function () {
			console.log("ReimbursementList is: " + reimbursementList);
			console.log("ROw index is: " + this.parentNode.parentNode.rowIndex);
			console.log(reimbursementList[this.parentNode.parentNode.rowIndex - 1]);
			console.log(getReportsTo(reimbursementList[this.parentNode.parentNode.rowIndex - 1].employeeId))
			if (getReportsTo(reimbursementList[this.parentNode.parentNode.rowIndex - 1].employeeId) != employeeId && employeeId != 0) {
				window.location.replace("PermissionDenied.html");
			} else {
				sendAjaxPost("http://localhost:8080/project1/UpdateRequestServlet", { reimbursementId: this.value, status: 2, managerId: employeeId }, postFunction)
			}
		});
		var denyButton = document.createElement("button");
		denyButton.setAttribute("class", "btn btn-danger");
		denyButton.value = response[i].reimbursementId;
		denyButton.type = "submit";
		denyButton.innerHTML = "Deny";
		denyButton.addEventListener("click", function () {
			console.log(reimbursementList[this.parentNode.parentNode.rowIndex - 1].managerId);
			if (getReportsTo(reimbursementList[this.parentNode.parentNode.rowIndex - 1].employeeId) != employeeId && employeeId != 0) {
				window.location.replace("PermissionDenied.html");
			} else {
				sendAjaxPost("http://localhost:8080/project1/UpdateRequestServlet", { reimbursementId: this.value, status: 1, managerId: employeeId }, postFunction)
			}
		});
		if (response[i].status == 0) {
			newRow.insertCell(6).appendChild(approveButton);
			newRow.cells.item(6).appendChild(denyButton);
		}
	};
}

function getReportsTo(id){
	for(employee of employeeList){
		if(employee.employeeId == id){
			return employee.reportsTo;
		}
	}

}

function clearTable() {
	if (table.rows.length > 1) {
		for (i = 1; table.rows.length > 1;) {
			table.deleteRow(i);
		}
	}
}

reimbursementSelect.addEventListener("change", function () {
	updateTable()
});

function updateTable() {
	displayList = [];
	tempList = [];
	switch (reimbursementSelect.value) {
		case "0":
			tempList = reimbursementList;
			filterEmployee();
			break;
		case "1":
			filterStatus(0);
			filterEmployee();
			break;
		case "2":
			filterStatus(1);
			filterEmployee();
			break;
		case "3":
			filterStatus(2);
			filterEmployee();
			break;
	}

	clearTable();
	addToTable(displayList);
}

employeeSelect.addEventListener("change", function () {
	updateTable();
});

function filterStatus(status) {
	for (reimbursement of reimbursementList) {
		if (reimbursement.status == status) {
			tempList.push(reimbursement);
		}
	}
}

function filterEmployee() {
	if (employeeSelect.value != -1) {
		for (reimbursement of tempList) {
			if (reimbursement.employeeId == Number.parseInt(employeeSelect.value)) {
				displayList.push(reimbursement);
			}
		}
	} else {
		displayList = tempList;
	}
}

function sendAjaxPost(url, data, func) {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			func(this);
		}
	};
	xhr.open("POST", url);
	// xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
	xhr.setRequestHeader("Access-Control-Allow-Origin", "text/plain")
	xhr.send(JSON.stringify(data));
}

function postFunction(xhr) {
	// let response = JSON.parse(xhr.response);

	// window.location.replace("PermissionDenied.html");

	window.location.reload();

}