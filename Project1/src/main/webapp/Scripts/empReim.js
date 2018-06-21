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

sendAjaxGet("http://localhost:8082/Project1/empReim", displayReim)

function displayReim(xhr){
	reims = JSON.parse(xhr.response)
	console.log(reims);
	reimsArr = pendings.reimbursements;
	table = document.getElementById("empReim");
	
	for(i in reimsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${reimsArr[i].reimbursementId} </td>
		<td> ${reimArr[i].status} </td>
		<td> ${reimArr[i].description} </td>
		<td> ${reimArr[i].amount} </td>
		<td> ${pendingsArr[i].empId} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
}