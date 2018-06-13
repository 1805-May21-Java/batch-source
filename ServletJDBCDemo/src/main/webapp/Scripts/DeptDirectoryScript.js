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

sendAjaxGet("http://localhost:8082/ServletJDBCDemo/department", displayDepartments)

function displayDepartments(xhr){
	departments = JSON.parse(xhr.response)
	departmentsArr = departments.departments;
	table = document.getElementById("table");
	
	for(i in departmentsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${departmentsArr[i].name} </td>
		<td> ${departmentsArr[i].monthlyBudget} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
	
}