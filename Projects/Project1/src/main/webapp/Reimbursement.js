let allEmpsUrl = "http://localhost:8080/Project1/api/employees"
let allReimburseUrl = "http://localhost:8080/Project1/api/reimbursements"

function init(){
	sendAjaxGet(allReimburseUrl, display)
}
	
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

function display(xhr)
{
	let reimbursements = JSON.parse(xhr.response)
	let table = document.getElementById("table");
	

	for(let reimbursement of reimbursements.reimbursements){
		tr = document.createElement("tr");
		tr.setAttribute('id', reimbursement.reimburseId);
		tr.innerHTML = `<td> ${reimbursement.reimburseId} </td>`;
		tr.innerHTML +=`<td> ${reimbursement.dateRequest}</td>`;
		tr.innerHTML +=`<td> ${reimbursement.dateApprove}</td>`;
		tr.innerHTML +=`<td> ${reimbursement.amount}</td>`;
		tr.innerHTML +=`<td> ${reimbursement.status}</td>`;
		
		getEmployeeName(reimbursement.requestBy, reimbursement.reimburseId);


		

		tr.setAttribute("scope","row");
		table.appendChild(tr);
	}
}

function getReimbursementsArr(xhr){
	let reimbursements = JSON.parse(xhr.response)
	reimbursementsArr = reimbursements;
}

function displayEmployeeName(xhr)
{
	let employee = JSON.parse(xhr.response)
	employee.empName;
}

function getEmployeeName(empId, rowId)
{
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() 
    {
        if(this.readyState == 4 && this.status ==200)
        {
           let response = JSON.parse(this.response);
          
	        	   let tr = document.getElementById(rowId);
//	        	   tr.innerHTML += `<td> ${response.empName} </td>`;
	        	   let td = document.createElement('td');
	        	   td.innerHTML = response.empName;
	        	   tr.appendChild(td);

        }
    }
    xhr.open("GET", "http://localhost:8080/Project1/api/employees?id="+empId);
    xhr.send();
}