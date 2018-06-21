baseurl = "http://localhost:8082/ProjectOne/rir"

sendAjaxGet(baseurl, displayData)

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));

    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
        else if(this.status > 400 && this.status < 600) {
            document.getElementById("alert").innerHTML = "Error connecting to the server";
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayData(xhr){
    let response = xhr.response;
    let requests = JSON.parse(response);
    console.log("Resetting tables");
    resetTables();

    for(request of requests.requests){
        if(request.pending){
             pendingDisplay(request);
         }
         else {
             approvedDisplay(request);
         }
    }
}

function pendingDisplay(json) {
    let row = document.createElement("tr");
    let id = document.createElement("td");
    let desc = document.createElement("td");
    let val = document.createElement("td");

    row.appendChild(id);
    row.appendChild(desc);
    row.appendChild(val);

    row.setAttribute("onclick", "approveRequest(this);");
    row.setAttribute("id", json.requestId)

    id.innerHTML = json.requestId;
    desc.innerHTML = json.description;
    val.innerHTML = json.value;

    document.getElementById("pending").appendChild(row);
}


function approvedDisplay(json) {
    let row = document.createElement("tr");
    let id = document.createElement("td");
    let desc = document.createElement("td");
    let val = document.createElement("td");
    let approver = document.createElement("td");

    row.appendChild(id);
    row.appendChild(desc);
    row.appendChild(val);
    row.appendChild(approver)

    id.innerHTML = json.requestId;
    desc.innerHTML = json.description;
    val.innerHTML = json.value;
    approver.innerHTML = json.approver.firstName + " " + json.approver.lastName;

    document.getElementById("approved").appendChild(row);
}


function approveRequest(element) {
    let id = element.getAttribute("id");
    let result = confirm("Are you sure you want to approve request " + id);
    let url = "http://localhost:8082/ProjectOne/approve?id=" + id;

    if(result){
        sendAjaxPost(url);
    }

    updateDisplay();
}

function sendAjaxPost(url) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    console.log(url);

    xhr.open("POST", url);
    xhr.send();
}

document.getElementById("search").addEventListener("click", updateDisplay);

function updateDisplay() {
    let id = document.getElementById("employeeId").value;
    let url;
    if(id != ""){
        url = baseurl + "?id=" + id;
    }
    else {
        url = baseurl;
    }

    resetTables();
    sendAjaxGet(url, displayData);
}

function resetTables() {
    for (var i = document.getElementById("pending").rows.length; i > 1; i--) {
        document.getElementById("pending").deleteRow(i - 1);
    } 
    for (var i = document.getElementById("approved").rows.length; i > 1; i--) {
        document.getElementById("approved").deleteRow(i - 1);
    } 
}