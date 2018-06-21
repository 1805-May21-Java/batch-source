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

sendAjaxGet("http://localhost:8082/Project1/mngpending", displayPending)

function displayPending(xhr){
	pendings = JSON.parse(xhr.response)
	console.log(pendings);
	pendingsArr = pendings.reimbursements;
	table = document.getElementById("pending");
	
	for(i in pendingsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${pendingsArr[i].reimbursementId} </td>
		<td> ${pendingsArr[i].description} </td>
		<td> ${pendingsArr[i].amount} </td>
		<td> ${pendingsArr[i].empId} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
}