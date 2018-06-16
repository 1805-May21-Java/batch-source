let sessionUrl = "http://localhost:8082/ERS/session";
let profileUrl = "http://localhost:8082/ERS/profile";
let reimbUrl = "http://localhost:8082/ERS/reimbursement"
let myReimbTable = document.getElementById("myReimbTable");
let myReimbImage = document.getElementById("myReimbImage");
let reimbRequest = document.getElementById("reimbRequestForm");
let empl = null;

window.onload = ()=>sendAjaxGet(reimbUrl, loadData);
document.getElementById("showReimbsButton").addEventListener("click", toggleMyReimbTable);
document.getElementById("reimbFormButton").addEventListener("click", toggleReimbRequestForm);
sendAjaxGet(sessionUrl, initProfilePage);

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

function sendAjaxPost(url, func, contents){
    let xhr = (new XMLHttpRequest() || new ActiveXObject());

    xhr.open("POST", url);
    xhr.send(contents);
}

function initProfilePage(xhr){
    empl = JSON.parse(xhr.responseText);
    
    let welcome = document.getElementById("welcome");
    welcome.innerHTML = "Welcome, " + empl.first + " " + empl.last + "!";
    if(empl.manager){
        document.getElementById("nav-manager-tab").removeAttribute("hidden");
    }
}

function toggleMyReimbTable(){
    myReimbImage.setAttribute("hidden", "true");
    reimbRequest.setAttribute("hidden", "true");
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
    if(reimbRequest.hasAttribute("hidden")){
        reimbRequest.removeAttribute("hidden");
        document.getElementById("reimbFormButton").innerHTML = "Cancel Reimbursement Request Submission";
    }
    else{
        reimbRequest.setAttribute("hidden", "true");
        document.getElementById("reimbFormButton").innerHTML = "Submit a Reimbursement Request";
    }
}

function loadData(xhr){
    reimbs = JSON.parse(xhr.ResponseText);
    myReimbs = reimbs[0];
    yourReimbs = reimbs[1];

    for(r in myReimbs){
        let newRow = document.createElement("tr");

        let cell1 = document.createElement(th);
        let cell2 = document.createElement(td);
        let cell3 = document.createElement(td);
        let cell4 = document.createElement(td);
        let cell5 = document.createElement(td);
        let cell6 = document.createElement(td);
        let cell7 = document.createElement(td);

        cell1.setAttribute("scope", "row");

        cell1.innerHTML = r.requestID;
        cell2.innerHTML = r.dateOfRequest;
        cell3.innerHTML = r.amountRequest;
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

        viewButton.setAttribute("class", "btn btn-small btn-primary");
        removeButton.setAttribute("class", "btn btn-small btn-danger");
        
        viewButton.addEventListener("click", ()=>showReimbImage(r.picURL));
        removeButton.addEventListener("click", ()=>sendAjaxPost(profileUrl, "RemoveReimb " + String(r.requestID)));
    }
}

function showReimbImage(URL){
    myReimbTable.setAttribute("hidden", "true");
    myReimbImage.setAttribute("src", URL);
    myReimbImage.removeAttribute("hidden");
}