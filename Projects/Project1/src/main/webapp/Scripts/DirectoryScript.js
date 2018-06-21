function sendAjaxGet(url, func){
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status ==200){
            func(this); //this refers to the XHR object
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

sendAjaxGet("http://localhost:8082/ServletJDBCDemo/employee", displayEmployees)

function displayEmployees(xhr){
	employees = JSON.parse(xhr.response)
	employeesArr = employees.employees;
	table = document.getElementById("table");
	
	for(i in employeesArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${employeesArr[i].name} </td>
		<td> ${employeesArr[i].location.city} </td>
		<td> ${employeesArr[i].department.name} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
	
}