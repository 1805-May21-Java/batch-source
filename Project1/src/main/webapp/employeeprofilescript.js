console.log("howdy");

sendAjaxGet("http://localhost:8082/Project1/EmployeeProfileServlet", displayInfo)

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

function displayInfo(xhr){
	employee = JSON.parse(xhr.response)
	console.log(employee);
	
	document.getElementById("employeeId").innerHTML=employee.id;
	//document.getElementById("employeeEmail").innerHTML=employee.email;
	document.getElementById("employeeEmail").setAttribute("value", employee.email);
	//document.getElementById("firstName").innerHTML=employee.firstName;
	document.getElementById("firstName").setAttribute("value", employee.firstName);
	//document.getElementById("lastName").innerHTML=employee.lastName;
	document.getElementById("lastName").setAttribute("value", employee.lastName);
	//document.getElementById("employeePhone").innerHTML=employee.phoneNumber;
	document.getElementById("employeePhone").setAttribute("value", employee.phoneNumber);
	
	document.getElementById("employeeTitle").innerHTML=employee.title;
	document.getElementById("employeeDepartment").innerHTML=employee.department;
	document.getElementById("managerId").innerHTML=employee.managerId;
	
	//document.getElementById("password").setAttribute("value", employee.password);
	
	

}