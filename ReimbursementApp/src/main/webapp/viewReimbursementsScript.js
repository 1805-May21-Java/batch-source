//Getting Reimbursement info via an AJAX HTTP GET

baseUrl = "http://localhost:8082/ReimbursementApp/reimbursementSession";



function getReimbursements(){
	let tableDiv = document.getElementById("reimbursementTable");
	while(tableDiv.firstChild){
		tableDiv.removeChild(tableDiv.firstChild);
	}
    sendAjaxGet(baseUrl, displayReimbursements);
}

function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        //console.log(xhr.readyState);
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}


function displayReimbursements(xhr){
    let pending = JSON.parse(xhr.response);
    //console.log(pending);
    
    let newTable = document.createElement("table");
    newTable.setAttribute("class", "table text-center");
    //newTable.id = "table2";
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
    let reimbursementList = pending.viewList
    
    for(var x in reimbursementList){
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
    	revIdCell.innerHTML = reimbursementList[x].reviewer_id;
    	row.appendChild(ridCell);
    	row.appendChild(moneyCell);
    	row.appendChild(eidCell);
    	row.appendChild(statusCell);
    	row.appendChild(revIdCell);
    	newTable.appendChild(row);
    	
    }
    let lineBreak = document.createElement("br");
    document.getElementById("reimbursementTable").appendChild(lineBreak);
    document.getElementById("reimbursementTable").appendChild(newTable);
    
}

//was infoTable and on button in html
document.getElementById("viewTable").addEventListener("click", getReimbursements);

