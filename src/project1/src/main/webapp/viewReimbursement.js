window.onload = function(){
	sendAjaxGet("http://localhost:8080/project1/GetReimbursementById", populateUser);
}

var table = document.getElementById("userTable");
var reimbursementSelect = document.getElementById("reimbursementSelect");
var isManager;

function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
		if(this.readyState == 4 && this.status ==200){
			func(this);
		}
	};
	xhr.open("GET",url);
	xhr.send();
}

function populateUser(xhr){
	let response = JSON.parse(xhr.response);
	console.log(response[0]);
	
	if ( response != "null" ){
		clearTable();
		addToTable(response);
	} 
	// else {
	// 	window.location = "http://localhost:8080/project1/LoginServlet";
	// }
}

function addToTable(response){
	let newRow;
	for(i = 0; i<response.length;i++){
		// if(table.rows.length > amountSelect.value){
		// 	break;
		// }
		newRow = table.insertRow(table.rows.length);
		newRow.insertCell(0).innerHTML = response[i].reimbursementId;
		newRow.insertCell(1).innerHTML = response[i].date;
		switch(response[i].status){
			case 0:
			newRow.insertCell(2).innerHTML = "Pending";
				break;
			case 1:
			newRow.insertCell(2).innerHTML = "Denied";
				break;
			case 2:
			newRow.insertCell(2).innerHTML = "Approved";
				break;
		}
		newRow.insertCell(3).innerHTML = response[i].reimbursementValue;
		newRow.insertCell(4).innerHTML = response[i].reimbursementReason;
		newRow.insertCell(5).innerHTML = response[i].managerId;
	};
}

function clearTable(){
	if(table.rows.length > 1){
		for(i = 1; table.rows.length > 1;){
			table.deleteRow(i);
		}
	}
}

reimbursementSelect.addEventListener("change", function(){
	console.log(reimbursementSelect.value);
	switch(reimbursementSelect.value){
		case "0":
		sendAjaxGet("http://localhost:8080/project1/GetReimbursementById", populateUser);
			break;
		case "1":
		sendAjaxGet("http://localhost:8080/project1/GetPendingReimbursementById", populateUser);
			break;
		case "2":
		sendAjaxGet("http://localhost:8080/project1/GetDeniedReimbursementById", populateUser);
			break;
		case "3":
		sendAjaxGet("http://localhost:8080/project1/GetApprovedReimbursementById", populateUser);
			break;
	}
	
});
