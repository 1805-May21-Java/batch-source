//local URLs
//let urlPopulateEmployee = "http://localhost:8082/Project1/PopulateEmployee";
//let urlGetAllReimbursements = "http://localhost:8082/Project1/GetAllReimbursements";
//let urlCreateReimbursement = "http://localhost:8082/Project1/CreateReimbursement";

//EC2 URLs
let urlGetAllReimbursements = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/GetAllReimbursements";
let urlPopulateEmployee = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/PopulateEmployee";
let urlCreateReimbursement = "http://ec2-18-191-251-160.us-east-2.compute.amazonaws.com:8080/CreateReimbursement";

//check if session saved, if so get it, if not retrieve
if(sessionStorage.getItem("employee")){
    getEmployeeOldSession(JSON.parse(sessionStorage.getItem("employee")));
    getOldEmployeeReimbursements(JSON.parse(sessionStorage.getItem("personalReimbursements")))
}else{
    sendAjax("GET",urlPopulateEmployee,getEmployeeNewSession);
    sendAjax("GET",urlGetAllReimbursements,getNewEmployeeReimbursements);
}

//where error message is displayed
let errorElement = document.getElementById("error");
errorElement.setAttribute("class","text-danger");

document.getElementById("submitButton").addEventListener("click",function(){
    let reimName = document.getElementById("name").value;
    let amount = document.getElementById("amount").value;
    let description = document.getElementById("description").value;

    //data validation
    if(!reimName){
        errorElement.setAttribute("class","text-danger");
        createErrorMessage("Must enter a name!");
    }else if(amount <= 0){
        errorElement.setAttribute("class","text-danger");
        createErrorMessage("Must enter a positive number!");
    }else{
        //if here, data is valid

        errorElement.innerText = "";
        let reimbursement = {
            name: reimName,
            reimbursementAmount: amount,
            status:0,
            description: description
        }
        errorElement.setAttribute("class","text-info");
        createErrorMessage("Adding reimbursement...");
        sendAjax("POST",urlCreateReimbursement,postReimbursement,JSON.stringify(reimbursement));
    }

   
    
    
});

function sendAjax(verb,url,func,contents){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && (xhr.status === 200 || xhr.status === 304)){
            func(xhr);
        }
    }
    xhr.open(verb,url);
    xhr.send(contents);
}

function getEmployeeNewSession(xhr){
	//stores the employee object for the session
	sessionStorage.setItem("employee",xhr.response);
    //Puts the name in a welcome message
    response = JSON.parse(xhr.response);
    
    document.getElementById("welcome").innerHTML="Welcome, "+response.name;
     if(response.employeeList.length > 0){
    	//is a manager
        unhide("managerTab");   
    }
}

function getEmployeeOldSession(response){

    document.getElementById("welcome").innerHTML="Welcome, "+response.name;
    if(response.employeeList.length > 0){
        //is a manager
        unhide("managerTab");   
    }
}

function getNewEmployeeReimbursements(xhr){
    //Empties the old table 
    let tableBody = document.getElementById("submittedBody");
    while(tableBody.firstChild){
        tableBody.removeChild(tableBody.firstChild);
    }
	//puts the reimbursements into the view submitted reimbursements table, hidden at first
    let response = JSON.parse(xhr.response).reimbursements;
     //stores all reimbursements associated with the employee
    sessionStorage.setItem("personalReimbursements",JSON.stringify(response));
    if(response){
		//don't do it if response is empty
	    for(reimbursement of response){
	        //appends one row
	        row = document.createElement("tr");
	        child1 = document.createElement("td");
	        child1.innerHTML = reimbursement.name;
	        row.appendChild(child1);
	        child2 = document.createElement("td");
	        child2.innerHTML = "$"+reimbursement.reimbursementAmount.toFixed(2);
	        row.appendChild(child2);
	        child3 = document.createElement("td");
	        child3.innerHTML = reimbursement.description;
	        row.appendChild(child3);
	        child4 = document.createElement("td");
	        child4.innerHTML = statusToMessage(reimbursement.status);
	        row.appendChild(child4);
	        
	        tableBody.appendChild(row);
	    }
	    
    }
}

function getOldEmployeeReimbursements(response){
	if(response){
        //don't do it if response is empty
        
        //empty old table
        let tableBody = document.getElementById("submittedBody");
        while(tableBody.firstChild){
            tableBody.removeChild(tableBody.firstChild);
    }

	    for(reimbursement of response){
	        //appends one row
	        row = document.createElement("tr");
	        child1 = document.createElement("td");
	        child1.innerHTML = reimbursement.name;
	        row.appendChild(child1);
	        child2 = document.createElement("td");
	        child2.innerHTML = "$"+reimbursement.reimbursementAmount.toFixed(2);
	        row.appendChild(child2);
	        child3 = document.createElement("td");
	        child3.innerHTML = reimbursement.description;
	        row.appendChild(child3);
	        child4 = document.createElement("td");
	        child4.innerHTML = statusToMessage(reimbursement.status);
	        row.appendChild(child4);
	        
	        document.getElementById("submittedBody").appendChild(row);
	    }
	}
}

function statusToMessage(status){
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

function postReimbursement(xhr){
    //displays success message
    errorElement.setAttribute("class","text-success")
    createErrorMessage("Reimbursement addded!");
    //updates session with new reimbursement
	sendAjax("GET",urlGetAllReimbursements,getNewEmployeeReimbursements);
}

function unhide(id){
    let tag = document.getElementById(id)
    if(tag.hidden){
       tag.removeAttribute("hidden");
    }else{
        tag.setAttribute("hidden",true);
    }
}

function createErrorMessage(message){
    errorElement.innerText=message;
}