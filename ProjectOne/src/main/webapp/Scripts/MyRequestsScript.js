baseurl = "http://localhost:8082/ProjectOne/"
console.log("DONT SHOW UP");

sendAjaxGet((baseurl + "session"), getRequests)

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


function getRequests(xhr) {
    let response = xhr.response;
    let id = JSON.parse(response);

    let url = baseurl + "/rir?id=" + id.id;

    sendAjaxGet(url, displayData);
}


function displayData(xhr){
    let response = xhr.response;
    let requests = JSON.parse(response);

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
