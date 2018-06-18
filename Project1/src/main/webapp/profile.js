let sessionUrl = "http://localhost:8082/ERS/session";
let profileUrl = "http://localhost:8082/ERS/profile";
let reimbUrl = "http://localhost:8082/ERS/reimbursement"
let myReimbTable = document.getElementById("myReimbTable");
let myReimbImage = document.getElementById("myReimbImage");
let reimbRequest = document.getElementById("reimbRequestForm");
let empl = null;

window.onload = loadData();
document.getElementById("showReimbsButton").addEventListener("click", toggleMyReimbTable);
document.getElementById("reimbFormButton").addEventListener("click", toggleReimbRequestForm);
document.getElementById("logoutButton").addEventListener("click", logout);
document.getElementById("editInfo").addEventListener("click", togglePersonalInfo);

function loadData(){
    sendAjaxGet(sessionUrl, initProfilePage);
    sendAjaxGet(reimbUrl, loadReimbs);
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
    }

    document.getElementById("emplID").innerHTML = empl.id;
    document.getElementById("emplFirst").innerHTML = empl.first;
    document.getElementById("emplLast").innerHTML = empl.last;
    document.getElementById("emplEmail").innerHTML = empl.email;
    document.getElementById("emplBday").innerHTML = empl.bday;

    document.getElementById("logoutText").value = "";
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
    yourReimbs = reimbs[1];

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
        let removeButton = document.createElement("button");
        let hiddenRemoveInput = document.createElement("input");
        let removeForm = document.createElement("form");
        let reimbID = r.id;
        let picURL = r.picURL;

        viewButton.setAttribute("class", "btn btn-small btn-primary");
        viewButton.addEventListener("click", ()=>showReimbImage(picURL));
        viewButton.innerHTML = "View Image";
        viewButton.setAttribute("style", "margin-right: 10px");

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

        cell8.appendChild(viewButton);
        cell8.appendChild(removeForm);

        newRow.appendChild(cell1);
        newRow.appendChild(cell2);
        newRow.appendChild(cell3);
        newRow.appendChild(cell4);
        newRow.appendChild(cell5);
        newRow.appendChild(cell6);
        newRow.appendChild(cell7);
        newRow.appendChild(cell8);

        document.getElementById("myReimbs").appendChild(newRow);
        document.getElementById("remove" + reimbID).addEventListener("click", function(){
            hiddenRemoveInput.value = reimbID;
        });
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