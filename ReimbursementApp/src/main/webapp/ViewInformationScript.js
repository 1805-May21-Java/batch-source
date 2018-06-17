
baseUrl = "http://localhost:8082/ReimbursementApp/informationSession";
//get sessionJSON.response.user

function getInformation(){
	let table = document.getElementById("infoTable");
	while(table.firstChild){
		table.removeChild(table.firstChild);
	}
    sendAjaxGet(baseUrl, displayInformation);
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

function displayInformation(xhr){
    let pending = JSON.parse(xhr.response);
    //console.log(pending);
    
    let newTable = document.getElementById("infoTable");
    let headerRow = document.createElement("tr");
    let eidHeader = document.createElement("th");
    let nameHeader = document.createElement("th");
    let passwordHeader = document.createElement("th");
    let addressHeader = document.createElement("th");
    let emailHeader = document.createElement("th");
    let phoneHeader = document.createElement("th");
    
    headerRow.appendChild(eidHeader);
    headerRow.appendChild(nameHeader);
    headerRow.appendChild(passwordHeader);
    headerRow.appendChild(addressHeader);
    headerRow.appendChild(emailHeader);
    headerRow.appendChild(phoneHeader);
    eidHeader.innerHTML = "Employee ID";
    nameHeader.innerHTML = "Name";
    passwordHeader.innerHTML = "Password";
    addressHeader.innerHTML = "Address";
    emailHeader.innerHTML = "Email";
    phoneHeader.innerHTML = "Phone";
    newTable.appendChild(headerRow);
    let employeeInfo = pending.user
    
    //for(var x in reimbursementList){
    	let row = document.createElement("tr");
    	let eidCell = document.createElement("td");
    	let nameCell = document.createElement("td");
    	let passwordCell = document.createElement("td");
    	let addressCell = document.createElement("td");
    	let emailCell = document.createElement("td");
    	let phoneCell = document.createElement("td");
    	eidCell.innerHTML = employeeInfo.employee_id;
    	nameCell.innerHTML = employeeInfo.firstname + " " + employeeInfo.lastname;
    	passwordCell.innerHTML = employeeInfo.password;
    	addressCell.innerHTML = employeeInfo.address;
    	emailCell.innerHTML = employeeInfo.email;
    	phoneCell.innerHTML = employeeInfo.phone;
    	row.appendChild(eidCell);
    	row.appendChild(nameCell);
    	row.appendChild(passwordCell);
    	row.appendChild(addressCell);
    	row.appendChild(emailCell);
    	row.appendChild(phoneCell);
    	newTable.appendChild(row);
    	
    //}
    
}
