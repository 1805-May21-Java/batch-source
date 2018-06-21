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

sendAjaxGet("http://localhost:8082/Project1/resolved", displayResolved)

function displayResolved(xhr){
	resolved = JSON.parse(xhr.response)
	console.log(resolved);
	resolvedArr = resolved.reimbursements;
	table = document.getElementById("resolved");
	
	for(i in resolvedArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${resolvedArr[i].reimbursementId} </td>
		<td> ${resolvedArr[i].status} </td>
		<td> ${resolvedArr[i].description} </td>
		<td> ${resolvedArr[i].amount} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
}