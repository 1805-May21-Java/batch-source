//local url's
//let urlGetAllReimbursements = "http://localhost:8082/Project1/GetAllReimbursements";
//let urlApproveDeny = "http://localhost:8082/Project1/ApproveDeny";
//let urlEmailValid = "http://localhost:8082/Project1/ValidInvalid";
//let urlNewEmployee = "http://localhost:8082/Project1/NewEmployee";

//EC2 url's
let urlGetAllReimbursements = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/GetAllReimbursements";
let urlApproveDeny = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/ApproveDeny";
let urlEmailValid = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/ValidInvalid";
let urlNewEmployee = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/NewEmployee";

sendAjax("GET",urlGetAllReimbursements,storeReimbursementsSession);
fillEmployeeList();

errorElement = document.getElementById("errorMessage");
errorElement.setAttribute("class","text-danger");

function sendAjax(verb,url,func,data){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            func(xhr);
        }
    }
    xhr.open(verb,url);
    xhr.send(JSON.stringify(data));
}

function getEmployeeNewSession(xhr){
    //Puts the name in a welcome message
    let response = JSON.parse(xhr.response);
    document.getElementById("welcome").innerHTML="Welcome, "+response.name;
}

function storeReimbursementsSession(xhr){
    //Stores the reimbursement string as a session object, then fills the table
	 sessionStorage.setItem("reimbursements",JSON.stringify(JSON.parse(xhr.response).reimbursements));
     //default show all
     sessionStorage.setItem("typeR",2);
     sessionStorage.setItem("typeE",-2)
     fillReimbursemnentTable(2,-2);
}

function fillEmployeeList(){
    //empties list of all but first element, which is all employees
    let firstDropdown = document.getElementById("employeeList");
    let firstElement = firstDropdown.firstElementChild;
    while(firstDropdown.firstChild){
        firstDropdown.removeChild(firstDropdown.firstChild);
    }
    firstDropdown.appendChild(firstElement)
    let employeeList = JSON.parse(sessionStorage.getItem("employee")).employeeList;
    for(let employee of employeeList){
        let nameElement = document.createElement("li");
        nameElement.setAttribute("class","dropdown-item");
        nameElement.innerText=employee.name;
        nameElement.addEventListener("click",function(){
            document.getElementById("employeeDropButton").innerText=employee.name;
            sessionStorage.setItem("typeE",employee.idNumber);
            fillReimbursemnentTable(sessionStorage.getItem("typeR"),employee.idNumber)
        })
        document.getElementById("employeeList").appendChild(nameElement);
    }
}

function fillReimbursemnentTable(status,employeeId){
    //fills table based on status and employee selected
	//status gets inputted, selects which status to show, 2 is default meaning all
    //puts the reimbursements into the view submitted reimbursements table, hidden at first
    let tableBody = document.getElementById("tableBody");
    let manag = JSON.parse(sessionStorage.getItem("employee")); 
   //clears table to build the new one based on selections
   while (tableBody.firstChild) {
    tableBody.removeChild(tableBody.firstChild);
}
    let response = JSON.parse(sessionStorage.getItem("reimbursements"));
    for(let reimbursement of response){
        //checks that the status sent and the employeeID sent match all reimbursements shown
    	//2 the default status, -2 the default employeeID
    	if((reimbursement.status == status || status == 2) && ( employeeId == -2 || reimbursement.employeeId == employeeId)){
            //appends one row, if the reimbursement is pending pending
            let row = document.createElement("tr");
            let child1 = document.createElement("td");
            child1.innerHTML = reimbursement.name;
            row.appendChild(child1);
            let child2 = document.createElement("td");
            child2.innerHTML = "$"+reimbursement.reimbursementAmount.toFixed(2);
            row.appendChild(child2);
            let child3 = document.createElement("td");
            child3.innerHTML = reimbursement.description;
            row.appendChild(child3);

            let empNameField = document.createElement("td");
            empNameField.innerText = getNameById(manag,reimbursement.employeeId);
            row.appendChild(empNameField);
            
            let child4 = document.createElement("td");


            let stat = document.createElement("td");
            stat.innerHTML = statusToMessage(reimbursement.status);
            row.appendChild(stat);
             
            if(reimbursement.status == 0){
                 //Gets a check or x to approve or deny
            	 let approve = document.createElement("img");
                 approve.setAttribute("src","res/check3.png");
                 approve.setAttribute("alt","Check");
                 approve.setAttribute("height","20");
                 let approveButton = document.createElement("button");
                 approveButton.setAttribute("class","btn btn-secondary");
                 approveButton.appendChild(approve);
                 child4.appendChild(approveButton);
                 row.appendChild(child4);
	            let deny = document.createElement("img");
	            deny.setAttribute("src","res/X.png");	
	            deny.setAttribute("alt","deny");
                deny.setAttribute("height","20");
                
	            let denyButton = document.createElement("button");
	            denyButton.setAttribute("style","margin-left:10px");
	            denyButton.setAttribute("class","btn btn-secondary");
	            denyButton.appendChild(deny);  
	            child4.appendChild(denyButton);
	            
	            //adds listeners to approve or deny
	            deny.addEventListener("click",function(){
	            	sendApproveDeny(reimbursement,-1);
	            });
	            approve.addEventListener("click",function(){
	            	sendApproveDeny(reimbursement,1);
	            });     
            }else{
                //creates two empty cells so name formatted properly
                row.appendChild(document.createElement("td"))
            }
            if(reimbursement.status == -1 || reimbursement.status == 1){
                let child7 = document.createElement("td");
                child7.innerHTML = manag.name;
                 row.appendChild(child7);
            }         
           tableBody.appendChild(row);
        }
    }
}


function sendApproveDeny(reimbursement,change){
    //adds a lisinter, gets passed in a reimbursement JSON and if the action was to approve or deny it.
    //Change receives -1 to deny, 1 to approve

    //changes status from pending to approve or deny
    reimbursement.status = change;

    //display loading message
    let err = document.getElementById("errorMessageReimb");
    err.setAttribute("class","text-info");
    err.innerText = "Resolving Request..."
    //sends off changed reimbursement to servlet
    sendAjax("POST", urlApproveDeny, postSend, reimbursement);
}

function statusToMessage(status){
    //turns the statues codes into status words
    switch(status){
        case -1:
            return "Denied"
            break;
        case 0:
            return "Pending"
            break;
        case 1:
            return "Approved"
            break;
        default:
            return "Unknown";
    }
}

dropButton = document.getElementById("dropdownButton");

//set all employees button
document.getElementById("allEmp").addEventListener("click",function(){
    document.getElementById("employeeDropButton").innerText="All Employees"
    sessionStorage.setItem("typeE",-2);
    fillReimbursemnentTable(sessionStorage.getItem("typeR"),-2);
})
//set onselect listeners
document.getElementById("all").addEventListener("click",function(){
    //change text to all
    dropButton.innerText="All Reimbursements"
    sessionStorage.setItem("typeR",2);
    //2 means all
    fillReimbursemnentTable(2,sessionStorage.getItem("typeE"));
});
document.getElementById("pending").addEventListener("click",function(){
    //change text to pending
    dropButton.innerText="Pending Reimbursements"
    sessionStorage.setItem("typeR",0);
    //0 means pending
    fillReimbursemnentTable(0,sessionStorage.getItem("typeE"));
});
document.getElementById("denied").addEventListener("click",function(){
    //change text to denied
    dropButton.innerText="Denied Reimbursements"
    sessionStorage.setItem("typeR",-1);
    //-1 means denied
    fillReimbursemnentTable(-1,sessionStorage.getItem("typeE"));
});
document.getElementById("approved").addEventListener("click",function(){
    //change text to approved
    dropButton.innerText="Approved Reimbursements"
    sessionStorage.setItem("typeR",1);
    //1 means approved
    fillReimbursemnentTable(1,sessionStorage.getItem("typeE"));
});

function postSend(){
    location.reload();
}

document.getElementById("registerButton").addEventListener("click",function(){
    document.getElementById("register").removeAttribute("hidden");
});

let employee;
//on click, validates data and if good then add a new user
document.getElementById("newEmployeeButton").addEventListener("click",function(){
    let empName = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    /^w+@w+.w+$/.test(email);
    //data validation
    if(!empName){
        errorElement.setAttribute("class","text-danger");
        createErrorMessage("Must enter a name!");
    }else if(!/^\w+@\w+\.\w+$/.test(email)){
        errorElement.setAttribute("class","text-danger");
        createErrorMessage("Must enter a valid email address!");
    }else if(!password){
        errorElement.setAttribute("class","text-danger");
        createErrorMessage("Must enter a password!")
    }else{
        //if here, data is valid

        let employee = {
            name: empName,
            email: email,
            password: password
        }
        errorElement.setAttribute("class","text-info");
        createErrorMessage("Adding employee...");
        sendAjax("POST",urlNewEmployee,postGetEmployee,employee);
    }
});

//displays error in creating employee
function createErrorMessage(message){
    errorElement.innerText = message;
}

function postGetEmployee(){
    sendAjax("GET",urlEmailValid,showResultMessage);
}

function showResultMessage(xhr){
    let response = JSON.parse(xhr.response);
    if(response.emailValid == "Invalid"){
        //user tried to enter invalid email, displays error message and refreshes correct information
        errorElement.setAttribute("class","text-danger");
        createErrorMessage("Email taken!  Please enter a new one");
    }else{

        let manager = JSON.parse(sessionStorage.getItem("employee"));

        //add a success message
        errorElement.setAttribute("class","text-success");
        createErrorMessage("Employee added");

        //updates manager object with new employee, refresh employee list
        manager.employeeList.push(employee);
        sessionStorage.setItem("employee",JSON.stringify(manager));
        fillEmployeeList();
    }
}

function getNameById(manager,id){
	for(employ of manager.employeeList){
		if(id == employ.idNumber){
			return employ.name
		}
	}
}