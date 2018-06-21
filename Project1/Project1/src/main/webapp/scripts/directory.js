var employee;
var empList;

window.onload = function() {
	getEmployeeAJAX(id);
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
            setEmployeeList(this.response);
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

function setEmployeeList(response) {
	let json = JSON.parse(response);
	empList = json.employees;
	console.log(empList);
}

function setTableInfo() {
	let tbody = document.getElementById("employeeDirectoryTable");
	for (let i = 0; i < empList.length; i++) {
		let newRow = document.createElement("tr");
		newRow.innerHTML = `<td>${empList[i].employeeId}</td>`
			+ `<td>${empList[i].firstname}</td>`
			+ `<td>${empList[i].lastname}</td>`
			+ `<td>${empList[i].dob}</td>`
			+ `<td>${empList[i].phone}</td>`
			+ `<td>${empList[i].email}</td>`
			+ `<td>${empList[i].username}</td>`
			+ `<td><button class="btn btn-outline-info" id="view${i}">View Requests</button></td>`;
		tbody.appendChild(newRow);
		document.getElementById("view"+i).addEventListener("click", function() {
			goToProfilePage(empList[i].employeeId);
		});
	}
}

function goToProfilePage(eid) {
	window.location.href=`./requests?eid=${eid}`;
}
