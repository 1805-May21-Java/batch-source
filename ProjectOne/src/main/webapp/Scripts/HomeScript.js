sendAjaxGet("session", getEmployeeData)

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));

    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
        else if(this.status > 400 && this.status < 600) {
            document.getElementById("alert").innerHTML = "Error connecting to the server";
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function getEmployeeData(xhr) {
	let response = xhr.response;
    let id = JSON.parse(response);
	
	let url = "employee?id=" + id.id;
	sendAjaxGet(url, displayData);
}

function displayData(xhr){
	let response = xhr.response;
	let emp = JSON.parse(response);
	console.log(emp.employees.manager);
	let employee = emp.employees;
	
	document.getElementById("empID").innerHTML = employee.id;
	document.getElementById("name").innerHTML = employee.firstName + " " + employee.lastName;
	document.getElementById("email").innerHTML = employee.email;
}