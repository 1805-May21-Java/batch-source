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

sendAjaxGet("http://localhost:8082/Project1/employees", displayPending)

function displayPending(xhr){
	pendings = JSON.parse(xhr.response)
	console.log(pendings);
	pendingsArr = pendings.employees;
	table = document.getElementById("employees");
	
	for(i in pendingsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${pendingsArr[i].empId} </td>
		<td> ${pendingsArr[i].username} </td>
		<td> ${pendingsArr[i].fName} </td>
		<td> ${pendingsArr[i].lName} </td>
		<td> ${pendingsArr[i].address} </td>
		<td> ${pendingsArr[i].city} </td>
		<td> ${pendingsArr[i].state} </td>
		<td> ${pendingsArr[i].zipcode} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
}