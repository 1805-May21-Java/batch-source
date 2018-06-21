var employee;

window.onload = function() {
	getEmployeeAJAX(id);
	
}

function getEmployeeAJAX() {
	let url = "http://localhost:8082/Project1/employeequery?id=" + id;
	
	let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
	xhr.onreadystatechange = function() {
		console.log(this.readyState);
        if (this.status == 200 && this.readyState == 4) {
            setEmployee(this.response);
            setWelcomeMessage();
        	setDashboardOptions();
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

function setWelcomeMessage() {
	document.getElementById("nameHere").innerHTML = employee.firstname + " " + employee.lastname;
	document.getElementById("idHere").innerHTML = "ID: " + employee.employeeId; 
}

function setDashboardOptions() {
	let isManager = employee.manager;
	console.log(employee.manager);
	
	let profile = document.getElementById("viewProfile");
	let myRequests = document.getElementById("viewRequests");
	profile.addEventListener("click", function() {
		window.location.href = 'http://localhost:8082/Project1/profile';
	});
	myRequests.addEventListener("click", function() {
		window.location.href = 'http://localhost:8082/Project1/requests';
	})
	
	if (isManager) {
		let container = document.getElementById("homeLinks");
		let directory = document.createElement("div");
		let manage = document.createElement("div");
		directory.className += " btn btn-outline-info homeLink";
		manage.className += " btn btn-outline-info homeLink";
		directory.innerHTML = "Employee Directory";
		manage.innerHTML = "Manage Requests";
		directory.addEventListener("click", function() {
			window.location.href = 'http://localhost:8082/Project1/directory';
		});
		manage.addEventListener("click", function() {
			window.location.href = 'http://localhost:8082/Project1/requestapproval';
		});
		
		container.appendChild(directory);
		container.appendChild(document.createElement("br"));
		container.appendChild(manage);
		container.appendChild(document.createElement("br"));
	}
}