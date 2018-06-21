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
            setProfileInfo();
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

function setProfileInfo() {
	document.getElementById("profileTitle").innerHTML = employee.firstname + "'s Information";
	document.getElementById("profileUsername").innerHTML = employee.username;
	document.getElementById("profileEmployeeId").innerHTML = employee.employeeId;
	document.getElementById("profileFirstname").innerHTML = employee.firstname;
	document.getElementById("profileLastname").innerHTML = employee.lastname;
	document.getElementById("profileBirthday").innerHTML = employee.dob;
	document.getElementById("profilePhone").innerHTML = pad(employee.phone, 10);
	document.getElementById("profileEmail").innerHTML = employee.email;
}

function pad(num, size) {
    var s = num+"";
    while (s.length < size) s = "0" + s;
    return s;
}
