let sessionUrl = "http://localhost:8082/ERS/session";
let profileUrl = "http://localhost:8082/ERS/profile";
let reimbUrl = "http://localhost:8082/ERS/reimbursement"
let myReimbTable = document.getElementById("myReimbTable");
let myReimbImage = document.getElementById("myReimbImage");
let reimbRequest = document.getElementById("reimbRequestForm");

let emplReimbTable = document.getElementById("emplReimbTable");
let newEmplForm = document.getElementById("newEmplForm");
let existingEmplForm = document.getElementById("existingEmplForm");
let myReimbImage2 = document.getElementById("myReimbImage2");

let empl = null;

window.onload = loadData();
document.getElementById("showReimbsButton").addEventListener("click", toggleMyReimbTable);
document.getElementById("reimbFormButton").addEventListener("click", toggleReimbRequestForm);
document.getElementById("logoutButton").addEventListener("click", logout);
document.getElementById("editInfo").addEventListener("click", togglePersonalInfo);
document.getElementById("showEmplReimbsButton").addEventListener("click", toggleEmplReimbTable);
document.getElementById("addNewEmplButton").addEventListener("click", toggleNewEmplForm);
document.getElementById("addExistingEmplButton").addEventListener("click", toggleExistingEmplForm);

document.getElementById("empls").addEventListener("change", ()=>sendAjaxGet(reimbUrl, loadReimbs2));
document.getElementById("personalEmpls").addEventListener("change", changePersonalInfo);

function loadData(){
    sendAjaxGet(sessionUrl, initProfilePage);
    sendAjaxGet(reimbUrl, loadReimbs);
    sendAjaxGet(reimbUrl, loadReimbs2);
}

function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject());

    xhr.onreadystatechange = function(){
        if(xhr.status >= 200 && xhr.status < 300 && xhr.readyState == 4){
            func(xhr);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function sendAjaxPost(url, contents){
    let xhr = (new XMLHttpRequest() || new ActiveXObject());

    xhr.open("POST", url);
    xhr.send(contents);
}

function initProfilePage(xhr){
    empl = JSON.parse(xhr.responseText);
    
    let welcome = document.getElementById("welcome");
    welcome.innerHTML += "Welcome, " + empl.first + " " + empl.last + "!";
    if(empl.manager){
        document.getElementById("nav-manager-tab").removeAttribute("hidden");
        document.getElementById("personalEmplDiv").removeAttribute("hidden");
    }

    document.getElementById("emplID").innerHTML = empl.id;
    document.getElementById("emplFirst").innerHTML = empl.first;
    document.getElementById("emplLast").innerHTML = empl.last;
    document.getElementById("emplEmail").innerHTML = empl.email;
    document.getElementById("emplBday").innerHTML = empl.bday;

    document.getElementById("logoutText").value = "";

    for(e of empl.minions){
        let option = document.createElement("option");
        let option2 = document.createElement("option");

        option.setAttribute("value", e.id);
        option.innerHTML = e.first + " " + e.last;

        option2.setAttribute("value", e.id);
        option2.innerHTML = e.first + " " + e.last;

        document.getElementById("empls").appendChild(option);
        document.getElementById("personalEmpls").appendChild(option2);
    }
}

function toggleMyReimbTable(){
    myReimbImage.setAttribute("hidden", "true");
    reimbRequest.setAttribute("hidden", "true");
    document.getElementById("reimbFormButton").innerHTML = "Submit a Reimbursement Request";
    if(myReimbTable.hasAttribute("hidden")){
        myReimbTable.removeAttribute("hidden");
        document.getElementById("showReimbsButton").innerHTML = "Hide Reimbursement Requests";
    }
    else{
        myReimbTable.setAttribute("hidden", "true");
        document.getElementById("showReimbsButton").innerHTML = "View Reimbursement Requests";
    }
}

function toggleReimbRequestForm(){
    myReimbImage.setAttribute("hidden", "true");
    myReimbTable.setAttribute("hidden", "true");
    document.getElementById("showReimbsButton").innerHTML = "View Reimbursement Requests";
    if(reimbRequest.hasAttribute("hidden")){
        reimbRequest.removeAttribute("hidden");
        document.getElementById("reimbFormButton").innerHTML = "Cancel Reimbursement Request Submission";
    }
    else{
        reimbRequest.setAttribute("hidden", "true");
        document.getElementById("reimbFormButton").innerHTML = "Submit a Reimbursement Request";
    }
}

function togglePersonalInfo(){
    if(document.getElementById("inEmplFirst").hasAttribute("hidden")){
        if(empl.manager){
            document.getElementById("personalEmplDiv").setAttribute("hidden", "true");
        }

        if(empl.first){
            document.getElementById("inEmplFirst").setAttribute("placeholder", empl.first);
        }
        if(empl.last){
            document.getElementById("inEmplLast").setAttribute("placeholder", empl.last);
        }
        if(empl.email){
            document.getElementById("inEmplEmail").setAttribute("placeholder", empl.email);
        }

        document.getElementById("emplFirst").setAttribute("hidden", "true");
        document.getElementById("emplLast").setAttribute("hidden", "true");
        document.getElementById("emplEmail").setAttribute("hidden", "true");
        document.getElementById("emplBday").setAttribute("hidden", "true");
        document.getElementById("inEmplFirst").removeAttribute("hidden");
        document.getElementById("inEmplLast").removeAttribute("hidden");
        document.getElementById("inEmplEmail").removeAttribute("hidden");
        document.getElementById("inEmplBday").removeAttribute("hidden");

        document.getElementById("personalSaveButton").removeAttribute("hidden");
        document.getElementById("editInfo").innerHTML = "Cancel Edit";
    }
    else{
        if(empl.manager){
            document.getElementById("personalEmplDiv").removeAttribute("hidden");
        }

        document.getElementById("inEmplFirst").setAttribute("hidden", "true");
        document.getElementById("inEmplLast").setAttribute("hidden", "true");
        document.getElementById("inEmplEmail").setAttribute("hidden", "true");
        document.getElementById("inEmplBday").setAttribute("hidden", "true");
        document.getElementById("emplFirst").removeAttribute("hidden");
        document.getElementById("emplLast").removeAttribute("hidden");
        document.getElementById("emplEmail").removeAttribute("hidden");
        document.getElementById("emplBday").removeAttribute("hidden");
        document.getElementById("personalSaveButton").setAttribute("hidden", "true");

        document.getElementById("inEmplBday").value = null;
        document.getElementById("editInfo").innerHTML = "Edit Personal Info";
    }
}

function loadReimbs(xhr){
    reimbs = JSON.parse(xhr.responseText);
    myReimbs = reimbs[0];

    while(document.getElementById("myReimbs").firstChild){
        document.getElementById("myReimbs").firstChild.remove();
    }

    for(r of myReimbs){
        let newRow = document.createElement("tr");

        let cell1 = document.createElement("th");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");
        let cell4 = document.createElement("td");
        let cell5 = document.createElement("td");
        let cell6 = document.createElement("td");
        let cell7 = document.createElement("td");
        let cell8 = document.createElement("td");

        cell1.setAttribute("scope", "row");

        cell1.innerHTML = r.id;
        cell2.innerHTML = r.dateOfRequest;
        cell3.innerHTML = "$" + r.amountRequest.toFixed(2);
        cell4.innerHTML = r.description;
        cell5.innerHTML = r.status;
        if(r.approveID){
            cell6.innerHTML = r.approveID;
        }
        if(r.dateOfApprove){
            cell7.innerHTML = r.dateOfApprove;
        }
        
        let viewButton = document.createElement("button");
        let picURL = r.picURL;

        viewButton.setAttribute("class", "btn btn-small btn-primary");
        viewButton.addEventListener("click", ()=>showReimbImage(picURL));
        viewButton.innerHTML = "View Image";
        viewButton.setAttribute("style", "margin-right: 10px");

        cell8.appendChild(viewButton);

        if(r.status == "Pending"){
            let removeButton = document.createElement("button");
            let hiddenRemoveInput = document.createElement("input");
            let removeForm = document.createElement("form");
            let reimbID = r.id;

            removeButton.setAttribute("class", "btn btn-small btn-danger");
            removeButton.setAttribute("type", "submit");
            removeButton.setAttribute("id", "remove" + reimbID);
            removeButton.innerHTML = "Remove Request";

            hiddenRemoveInput.setAttribute("id", "removeInput" + reimbID);
            hiddenRemoveInput.setAttribute("type", "text");
            hiddenRemoveInput.setAttribute("name", "removeReimb");
            hiddenRemoveInput.setAttribute("hidden", "true");

            removeForm.setAttribute("id", "removeForm" + reimbID);
            removeForm.setAttribute("action", "profile");
            removeForm.setAttribute("method", "post");

            removeForm.appendChild(hiddenRemoveInput);
            removeForm.appendChild(removeButton);
            
            cell8.appendChild(removeForm);

            removeButton.addEventListener("click", function(){
                hiddenRemoveInput.value = reimbID;
            });
        }


        newRow.appendChild(cell1);
        newRow.appendChild(cell2);
        newRow.appendChild(cell3);
        newRow.appendChild(cell4);
        newRow.appendChild(cell5);
        newRow.appendChild(cell6);
        newRow.appendChild(cell7);
        newRow.appendChild(cell8);

        document.getElementById("myReimbs").appendChild(newRow);
    }
}

function loadReimbs2(xhr){
    reimbs = JSON.parse(xhr.responseText);
    yourReimbs = reimbs[1];

    while(document.getElementById("emplReimbs").firstChild){
        document.getElementById("emplReimbs").firstChild.remove();
    }

    for(x of yourReimbs){
        let newRow = document.createElement("tr");

        let cell1 = document.createElement("th");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");
        let cell4 = document.createElement("td");
        let cell5 = document.createElement("td");
        let cell6 = document.createElement("td");
        let cell7 = document.createElement("td");
        let cell8 = document.createElement("td");
        let cell9 = document.createElement("td");

        cell1.setAttribute("scope", "row");

        cell1.innerHTML = x.id;

        for(e of empl.minions){
            if(x.requestID == e.id){
                cell2.innerHTML = e.first + " " + e.last;
            }
        }

        // cell2.innerHTML = x.requestID;
        cell3.innerHTML = x.dateOfRequest;
        cell4.innerHTML = "$" + x.amountRequest.toFixed(2);
        cell5.innerHTML = x.description;
        cell6.innerHTML = x.status;
        if(x.approveID){
            cell7.innerHTML = x.approveID;
        }
        if(x.dateOfApprove){
            cell8.innerHTML = x.dateOfApprove;
        }
        
        let viewButton = document.createElement("button");
        let picURL2 = x.picURL;

        viewButton.setAttribute("class", "btn btn-small btn-primary");
        viewButton.addEventListener("click", ()=>showReimbImage2(picURL2));
        viewButton.innerHTML = "View Image";
        viewButton.setAttribute("style", "margin-right: 10px");

        cell9.appendChild(viewButton);

        if(x.status == "Pending"){
            let approveButton = document.createElement("button");
            let denyButton = document.createElement("button");
            let hiddenActionInput = document.createElement("input");
            let hiddenActionInput2 = document.createElement("input");
            let actionForm = document.createElement("form");
            let reimbID2 = x.id;

            approveButton.setAttribute("class", "btn btn-small btn-success");
            approveButton.setAttribute("type", "submit");
            approveButton.setAttribute("id", "approve" + reimbID2);
            approveButton.innerHTML = "Approve";

            denyButton.setAttribute("class", "btn btn-small btn-danger");
            denyButton.setAttribute("type", "submit");
            denyButton.setAttribute("id", "deny" + reimbID2);
            denyButton.innerHTML = "Deny";

            hiddenActionInput.setAttribute("id", "action" + reimbID2);
            hiddenActionInput.setAttribute("type", "text");
            hiddenActionInput.setAttribute("name", "reimbAction");
            hiddenActionInput.setAttribute("hidden", "true");
            
            hiddenActionInput2.setAttribute("id", "value" + reimbID2);
            hiddenActionInput2.setAttribute("type", "text");
            hiddenActionInput2.setAttribute("name", "reimbValue");
            hiddenActionInput2.setAttribute("hidden", "true");

            actionForm.setAttribute("id", "actionForm" + reimbID2);
            actionForm.setAttribute("action", "profile");
            actionForm.setAttribute("method", "post");

            actionForm.appendChild(hiddenActionInput);
            actionForm.appendChild(hiddenActionInput2);
            actionForm.appendChild(approveButton);
            actionForm.appendChild(denyButton);

            cell9.appendChild(actionForm);

            approveButton.addEventListener("click", function(){
                hiddenActionInput.value = "approve";
                hiddenActionInput2.value = reimbID2;
            });
            denyButton.addEventListener("click", function(){
                hiddenActionInput.value = "deny";
                hiddenActionInput2.value = reimbID2;
            });
        }

        newRow.appendChild(cell1);
        newRow.appendChild(cell2);
        newRow.appendChild(cell3);
        newRow.appendChild(cell4);
        newRow.appendChild(cell5);
        newRow.appendChild(cell6);
        newRow.appendChild(cell7);
        newRow.appendChild(cell8);
        newRow.appendChild(cell9);

        if(x.requestID == document.getElementById("empls").value || document.getElementById("empls").value == 0){
            document.getElementById("emplReimbs").appendChild(newRow);
        }
    }
}

function logout(){
    document.getElementById("logoutText").value = "logout";
}

function showReimbImage(URL){
    document.getElementById("reimbFormButton").innerHTML = "Submit a Reimbursement Request";
    document.getElementById("showReimbsButton").innerHTML = "View Reimbursement Requests";
    
    myReimbTable.setAttribute("hidden", "true");
    myReimbImage.setAttribute("src", URL);
    
    myReimbImage.setAttribute("alt", "No Image Provided");
    myReimbImage.removeAttribute("hidden");
}

function showReimbImage2(URL){
    document.getElementById("showEmplReimbsButton").innerHTML = "View Employee Reimbursement Requests";
    document.getElementById("addNewEmplButton").innerHTML = "Add New Employee";
    document.getElementById("addExistingEmplButton").innerHTML = "Add Existing Employee";
    
    emplReimbTable.setAttribute("hidden", "true");
    myReimbImage2.setAttribute("src", URL);
    
    myReimbImage2.setAttribute("alt", "No Image Provided");
    myReimbImage2.removeAttribute("hidden");
}

function toggleEmplReimbTable(){
    newEmplForm.setAttribute("hidden", "true");
    existingEmplForm.setAttribute("hidden", "true");
    myReimbImage2.setAttribute("hidden", "true");

    document.getElementById("addNewEmplButton").innerHTML = "Add New Employee";
    document.getElementById("addExistingEmplButton").innerHTML = "Add Existing Employee";
    document.getElementById("showEmplReimbsButton").innerHTML = "View Employee Reimbursement Requests";
    if(emplReimbTable.hasAttribute("hidden")){
        emplReimbTable.removeAttribute("hidden");
        document.getElementById("showEmplReimbsButton").innerHTML = "Hide Employee Reimbursement Requests";
    }
    else{
        emplReimbTable.setAttribute("hidden", "true");
        document.getElementById("showEmplReimbsButton").innerHTML = "View Employee Reimbursement Requests";
    }
}

function toggleNewEmplForm(){
    emplReimbTable.setAttribute("hidden", "true");
    existingEmplForm.setAttribute("hidden", "true");
    myReimbImage2.setAttribute("hidden", "true");
    
    document.getElementById("newEmail").value = null;
    document.getElementById("showEmplReimbsButton").innerHTML = "View Employee Reimbursement Requests";
    document.getElementById("addExistingEmplButton").innerHTML = "Add Existing Employee";
    document.getElementById("addNewEmplButton").innerHTML = "Add New Employee";
    if(newEmplForm.hasAttribute("hidden")){
        newEmplForm.removeAttribute("hidden");
        document.getElementById("addNewEmplButton").innerHTML = "Cancel New Employee Process";
    }
    else{
        newEmplForm.setAttribute("hidden", "true");
        document.getElementById("addNewEmplButton").innerHTML = "Add New Employee";
    }
}

function toggleExistingEmplForm(){
    emplReimbTable.setAttribute("hidden", "true");
    newEmplForm.setAttribute("hidden", "true");
    myReimbImage2.setAttribute("hidden", "true");

    document.getElementById("existingID").value = null;
    document.getElementById("showEmplReimbsButton").innerHTML = "View Employee Reimbursement Requests";
    document.getElementById("addNewEmplButton").innerHTML = "Add New Employee";
    document.getElementById("addExistingEmplButton").innerHTML = "Add Existing Employee";
    if(existingEmplForm.hasAttribute("hidden")){
        existingEmplForm.removeAttribute("hidden");
        document.getElementById("addExistingEmplButton").innerHTML = "Cancel Existing Employee Process";
    }
    else{
        existingEmplForm.setAttribute("hidden", "true");
        document.getElementById("addExistingEmplButton").innerHTML = "Add Existing Employee";
    }
}

function changePersonalInfo(){
    let personal = empl;

    if(document.getElementById("personalEmpls").value != 0){
        for(e of empl.minions){
            if(document.getElementById("personalEmpls").value == e.id){
                personal = e;
            }
        }

        document.getElementById("editInfo").setAttribute("hidden", "true");
    }
    else{
        document.getElementById("editInfo").removeAttribute("hidden");
    }

    document.getElementById("emplID").innerHTML = personal.id;
    document.getElementById("emplFirst").innerHTML = personal.first;
    document.getElementById("emplLast").innerHTML = personal.last;
    document.getElementById("emplEmail").innerHTML = personal.email;
    document.getElementById("emplBday").innerHTML = personal.bday;
}