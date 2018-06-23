
baseUrl = "http://localhost:8082/ReimbursementApp/pendingAllSession";
userUrl = "http://localhost:8082/ReimbursementApp/userSession";

userId = "";

function start(){
	getUserInfo();
	getPendingReimbursements();
}


function getPendingReimbursements(){
	let table = document.getElementById("allRequest");
	while(table.firstChild){
		table.removeChild(table.firstChild);
	}
    sendAjaxGet(baseUrl, displayPendingReimbursements);
}

function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayPendingReimbursements(xhr){
    let pending = JSON.parse(xhr.response);
    //console.log(pending);
    
    let newTable = document.getElementById("allRequest");
   
    let headerRow = document.createElement("tr");
    let ridHeader = document.createElement("th");
    let moneyHeader = document.createElement("th");
    let eidHeader = document.createElement("th");
    let statusHeader = document.createElement("th");
    let revIdHeader = document.createElement("th");
    headerRow.appendChild(ridHeader);
    headerRow.appendChild(moneyHeader);
    headerRow.appendChild(eidHeader);
    headerRow.appendChild(statusHeader);
    headerRow.appendChild(revIdHeader);
    ridHeader.innerHTML = "Reimbursement ID";
    moneyHeader.innerHTML = "Money";
    eidHeader.innerHTML = "Employee ID";
    statusHeader.innerHTML = "Status";
    revIdHeader.innerHTML = "Reviewer ID";
    newTable.appendChild(headerRow);
    let reimbursementList = pending.allReimbursements
    
    for(var x in reimbursementList){
    	if(reimbursementList[x].status === "Pending"){
    		
    		if(reimbursementList[x].employee_id === userId){continue};
    		let row = document.createElement("tr");
    		let ridCell = document.createElement("td");
    		let moneyCell = document.createElement("td");
    		let eidCell = document.createElement("td");
    		let statusCell = document.createElement("td");
    		let revIdCell = document.createElement("td");
    		ridCell.innerHTML = reimbursementList[x].reimbursement_id;
    		moneyCell.innerHTML = "$"+reimbursementList[x].money;
    		eidCell.innerHTML = reimbursementList[x].employee_id;
    		statusCell.innerHTML = reimbursementList[x].status;
    		revIdCell.innerHTML = "N/A";
    		row.appendChild(ridCell);
    		row.appendChild(moneyCell);
    		row.appendChild(eidCell);
    		row.appendChild(statusCell);
    		row.appendChild(revIdCell);
    		newTable.appendChild(row);
    		}
    }
}


function getUserInfo(){
    sendAjaxGet(userUrl, displayUserInfo);
}

function displayUserInfo(xhr){
	let pending = JSON.parse(xhr.response);
	console.log(pending.user.employee_id);
	userId = pending.user.employee_id;
}








