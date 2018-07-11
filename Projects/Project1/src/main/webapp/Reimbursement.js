window.onload = function(){init();}


let allEmpsUrl = "http://localhost:8080/Project1/api/employees"
let allReimburseUrl = "http://localhost:8080/Project1/api/reimbursements"
let sessionUrl = "http://localhost:8080/Project1/api/session"
let sessionData;

function displayProfile()
{
	profile = document.getElementById("myprofileinfo");
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

function submitRequest()
{
	submitform=document.getElementById("submitform");
	submitform.innerHTML =`	<form action="reimbursement" method="post">
		<label>Create Reimbursement Request </label><br>
		<input type="hidden" name="request_by" id="request_by" ><br>
		<input type="hidden" name="approve_by" id="approve_by" ><br>
		<input type="text" name="amount" onchange="hiddenFormInit()" placeholder="Amount.."><br>
		<input type="text" name="description" placeholder="Description.."><br>
		<input type="text" name="url" placeholder="Invoice Url (optional).."><br>
		<input type="submit" name="submit">
	</form>`;


}
function displayEdit()
{
	profile = document.getElementById("editprofileinfo");
	profile.innerHTML = `<h1>Edit Profile</h1><table>
    <tbody>
    <tr>
		<td>
			<form action="EditServlet" method="post">
				
				<input type="text" name="fullName" value = "${sessionData.fullname}" id="fullName" placeholder="Full Name" ><br>
				<input type="hidden" name="userId" id="userId" placeholder="User ID"><br>
				<input type="text" name="userName" value = "${sessionData.username}" id="userName" placeholder="User Name"><br>
				<input type="password" name="userPassword" value = "${sessionData.userpassword}" id="userPassword" placeholder="User Password"><br>
				<input type="password" name="userPassword2" value = "${sessionData.userpassword}" id="userPassword2" placeholder="User Password"><br>
				<input type="text" name="userUrl" value = "${sessionData.userurl}" id="userUrl" placeholder="User Url"><br>
				<input type="date" name="birthdate" value = "${sessionData.birthdate}" placeholder="birthdate"><br>
				<input type="hidden" name="userManagerId" id="userManagerId" placeholder="manager id"><br>
				<input type="submit" name="submit" onclick="disabledIdInit()">
			</form>
		</td>
    </tr>
    
   
  </tbody>
</table>`;


}
function showMyEmployees(){
	sendAjaxGet(allReimburseUrl+"?manager_id="+sessionData.userid, displayMyEmployees)
}






function disabledIdInit()
{
	let input1 = document.getElementById("userId");
	input1.value = sessionData.userid;
	let input2 = document.getElementById("userManagerId");
	input2.value = sessionData.managerid;
}

function hiddenFormInit(){
	let input1 = document.getElementById("request_by");
	input1.value = sessionData.userid;
	let input2 = document.getElementById("approve_by");
	input2.value = sessionData.managerid;
}

function send_display_all_employees_body(){
	sendAjaxGet(allReimburseUrl, display_all_employees_body)
}

function showUnderManager(){
	sendAjaxGet(allReimburseUrl+"?manager_id="+sessionData.userid, displayMyEmployees)
}



function showMyReimbursements(){
	sendAjaxGet(allReimburseUrl+"?employee_id="+sessionData.userid, displayMyrequest)
}

function displayMyrequest(xhr)
{
	let reimbursements = JSON.parse(xhr.response)
	let table = document.getElementById("myrequest");
	table.innerHTML =``;
	for(let reimbursement of reimbursements.reimbursements){
		tr = document.createElement("tr");
		tr.setAttribute('class', 'edit');
		tr.setAttribute('id', reimbursement.reimburseId);
		
		tr.innerHTML = `<td class="text-center"> ${reimbursement.reimburseId}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateRequest}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateApprove}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.amount}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.status}</td>`;
			

		tr.setAttribute("scope","row");
		table.appendChild(tr);
	}
}







function send_display_my_employees_body(){
	sendAjaxGet(allReimburseUrl+"?manager_id="+sessionData.userid, display_my_employees_body)
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

function display_my_employees_body(xhr)
{
	let reimbursements = JSON.parse(xhr.response)
	let table = document.getElementById("my_employees_body");
	table.innerHTML =``;
	for(let reimbursement of reimbursements.reimbursements)
	{
		tr = document.createElement("tr");
		tr.setAttribute('class', 'edit');
		tr.setAttribute('id', reimbursement.reimburseId);
		
		tr.innerHTML = `<td class="text-center"> ${reimbursement.reimburseId}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateRequest}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateApprove}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.amount}</td>`;
			if(reimbursement.status=="Pending")
			{
				tr.innerHTML +=	`<td style="text-align:center;">
					<form action="approveddenied" method="post">
						<input type="hidden" name=reimburseId value=${reimbursement.reimburseId}>
						<select name="reimburseStatus">
						    <option value="Approved">Approve</option>
						    <option value="Denied">Deny</option>
						</select>
					<button type="submit" name="Submit" value="Submit" >Submit</button>
					</form>
				</td>`;
			}
			else{
				tr.innerHTML+=`
				<td style="text-align:center;">
					${reimbursement.status}
				</td>`;
			}
		tr.setAttribute("scope","row");		
		table.appendChild(tr);

	}
	
	
}
function display_all_employees_body(xhr)
{
	let reimbursements = JSON.parse(xhr.response)
	let table = document.getElementById("allofemployees");
	table.innerHTML =``;
	for(let reimbursement of reimbursements.reimbursements){
		tr = document.createElement("tr");
		tr.setAttribute('class', 'edit');
		tr.setAttribute('id', reimbursement.reimburseId);
		
		tr.innerHTML = `<td class="text-center"> ${reimbursement.reimburseId}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateRequest}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.dateApprove}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.amount}</td>`;
		tr.innerHTML +=`<td class="text-center"> ${reimbursement.status}</td>`;
			

		tr.setAttribute("scope","row");
		table.appendChild(tr);
	}
}
