
baseUrl = "http://localhost:8082/ReimbursementApp/allEmployeesSession";


function getAllEmployees(){
	let table = document.getElementById("allEmployees");
	while(table.firstChild){
		table.removeChild(table.firstChild);
	}
    sendAjaxGet(baseUrl, displayAllEmployees);
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

function displayAllEmployees(xhr){
	let pending = JSON.parse(xhr.response);
    //console.log(pending);
    
    let newTable = document.getElementById("allEmployees");
    let headerRow = document.createElement("tr");
    let eidHeader = document.createElement("th");
    let nameHeader = document.createElement("th");
    //let passwordHeader = document.createElement("th");
    let addressHeader = document.createElement("th");
    let emailHeader = document.createElement("th");
    let phoneHeader = document.createElement("th");
    let isManagerHeader = document.createElement("th");
    
    headerRow.appendChild(eidHeader);
    headerRow.appendChild(nameHeader);
    //headerRow.appendChild(passwordHeader);
    headerRow.appendChild(addressHeader);
    headerRow.appendChild(emailHeader);
    headerRow.appendChild(phoneHeader);
    headerRow.appendChild(isManagerHeader)
    eidHeader.innerHTML = "Employee ID";
    nameHeader.innerHTML = "Name";
    //passwordHeader.innerHTML = "Password";
    addressHeader.innerHTML = "Address";
    emailHeader.innerHTML = "Email";
    phoneHeader.innerHTML = "Phone";
    isManagerHeader.innerHTML = "Manager"
    newTable.appendChild(headerRow);
    let employeeInfo = pending.allEmployees
    
    for(var x in employeeInfo){
    	let row = document.createElement("tr");
    	let eidCell = document.createElement("td");
    	let nameCell = document.createElement("td");
    	//let passwordCell = document.createElement("td");
    	let addressCell = document.createElement("td");
    	let emailCell = document.createElement("td");
    	let phoneCell = document.createElement("td");
    	let isManagerCell = document.createElement("td");
    	eidCell.innerHTML = employeeInfo[x].employee_id;
    	nameCell.innerHTML = employeeInfo[x].firstname + " " + employeeInfo[x].lastname;
    	//passwordCell.innerHTML = employeeInfo[x].password;
    	addressCell.innerHTML = employeeInfo[x].address;
    	emailCell.innerHTML = employeeInfo[x].email;
    	phoneCell.innerHTML = employeeInfo[x].phone;
    	if(employeeInfo[x].isManager === "0"){
    		isManagerCell.innerHTML = "No";
    	}else{
    		isManagerCell.innerHTML = "Yes";
    	}
    	row.appendChild(eidCell);
    	row.appendChild(nameCell);
    	//row.appendChild(passwordCell);
    	row.appendChild(addressCell);
    	row.appendChild(emailCell);
    	row.appendChild(phoneCell);
    	row.appendChild(isManagerCell);
    	newTable.appendChild(row);
    	
    }
}