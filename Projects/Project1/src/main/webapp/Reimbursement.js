window.onload = function(){init();}


let allEmpsUrl = "http://localhost:8080/Project1/api/employees"
let allReimburseUrl = "http://localhost:8080/Project1/api/reimbursements"
let sessionUrl = "http://localhost:8080/Project1/api/session"
let sessionData;

function displayProfile()
{
	profile = document.getElementById("profile");
	profile.innerHTML = `<h1>Profile</h1><table>
    <tbody>
    <tr>
      <td>Name:</td>
      <td>${sessionData.fullname}</td>
    </tr>
     <tr>
      <td>User:</td>
      <td>${sessionData.username}</td>
    </tr>
    <tr>
      <td>User ID:</td>
      <td>${sessionData.userid}</td>
    </tr>
     <tr>
      <td>Birthdate:</td>
      <td>${sessionData.birthdate}</td>
    </tr>
     <tr>
      
      <td><img src="${sessionData.userurl}"></td>
    </tr>
    
   
  </tbody>
</table>`;


}







function hiddenFormInit(){
	let input1 = document.getElementById("request_by");
	input1.value = sessionData.userid;
	let input2 = document.getElementById("approve_by");
	input2.value = sessionData.managerid;
}

function showAllReimbursements(){
	sendAjaxGet(allReimburseUrl, display)
}

function showMyReimbursements(){
	sendAjaxGet(allReimburseUrl+"?employee_id="+sessionData.userid, display)
}

function showMyEmployeesReimbursements(){
	sendAjaxGet(allReimburseUrl+"?manager_id="+sessionData.userid, displayEmps)
}
	

function init(){
	sendAjaxGet(sessionUrl, getSession)
}

function getSession(xhr)
{
	sessionData = JSON.parse(xhr.response)
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
	let table = document.getElementById("mytbody");

	for(let reimbursement of reimbursements.reimbursements){
		tr = document.createElement("tr");
		tr.setAttribute('class', 'edit');
		tr.setAttribute('id', reimbursement.reimburseId);
		
		tr.innerHTML = `<td class="text-center"> ${reimbursement.reimburseId}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateRequest}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateApprove}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.amount}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.status}</td>`;
		
		getEmployeeName(reimbursement.requestBy, reimbursement.reimburseId);

		tr.setAttribute("scope","row");
		table.appendChild(tr);
	}
}

function displayEmps(xhr)
{
	let reimbursements = JSON.parse(xhr.response)
	let table = document.getElementById("mytbody");

	for(let reimbursement of reimbursements.reimbursements){
		tr = document.createElement("tr");
		tr.setAttribute('class', 'edit');
		tr.setAttribute('id', reimbursement.reimburseId);
		
		tr.innerHTML = `<td class="text-center"> ${reimbursement.reimburseId}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateRequest}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateApprove}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.amount}</td>`;
		tr.innerHTML +=`<td class="text-center"> 
			<form action="ApprovedDenied" method="post">
				<input type="hidden" name=reimburseId value=${reimbursement.reimburseId}>
				<select name="reimburseStatus">
				    <option value="Approved">Approve</option>
				    <option value="Denied">Deny</option>
				</select>
				<input type="submit" name="Submit" >
			</form>
	
		
		</td>`;

		
		
		getEmployeeName(reimbursement.requestBy, reimbursement.reimburseId);

		tr.setAttribute("scope","row");
		
		table.appendChild(tr);
	}
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
	        	   tr.innerHTML += `<td class="text-center"> ${response.empName} </td>`;
//	        	   let td = document.createElement('td');
//	        	   td.innerHTML = response.empName;
//	        	   tr.appendChild(td);
        }
    }
    xhr.open("GET", "http://localhost:8080/Project1/api/employees?id="+empId);
    xhr.send();
}