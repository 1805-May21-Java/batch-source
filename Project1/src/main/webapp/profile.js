let sessionUrl = "http://localhost:8082/ERS/session";
let reimbUrl = "http://localhost:8082/ERS/reimbursement"
let empl = null;

window.onload = ()=>sendAjaxGet(reimbUrl, loadData);
document.getElementById("showReimbsButton").addEventListener("click", toggleMyReimbTable);
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

function initProfilePage(xhr){
    empl = JSON.parse(xhr.responseText);
    
    let welcome = document.getElementById("welcome");
    welcome.innerHTML = "Welcome, " + empl.first + " " + empl.last + "!";
    if(empl.manager){
        document.getElementById("nav-manager-tab").removeAttribute("hidden");
    }
}

function toggleMyReimbTable(){
    if(document.getElementById("myReimbTable").hasAttribute("hidden")){
        document.getElementById("myReimbTable").removeAttribute("hidden");
        document.getElementById("showReimbsButton").innerHTML = "Hide Reimbursement Requests";
    }
    else{
        document.getElementById("myReimbTable").setAttribute("hidden", "true");
        document.getElementById("showReimbsButton").innerHTML = "View Reimbursement Requests";
    }
}

function loadData(xhr){
    reimbs = JSON.parse(xhr.ResponseText);
    myReimbs = reimbs[0];
    yourReimbs = reimbs[1];

    for(r of myReimbs){
        let newRow = document.createElement("tr");

        let cell1 = document.createElement(th);
        let cell2 = document.createElement(td);
        let cell3 = document.createElement(td);
        let cell4 = document.createElement(td);
        let cell5 = document.createElement(td);
        let cell6 = document.createElement(td);
        let cell7 = document.createElement(td);

        cell1.setAttribute("scope", "row");

        cell1.innerHTML = r
    }
}