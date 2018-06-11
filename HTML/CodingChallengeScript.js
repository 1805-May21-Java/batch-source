let baseurl = "https://randomuser.me/api/";
document.getElementById("single").addEventListener("click", getUser);

function getUser() {
    sendAjaxGet(baseurl, displayUser);
}

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


function displayUser(xhr) {
    let response = xhr.response;
    let use = JSON.parse(response);
    document.getElementById("name").innerHTML = use.results[0].name.title + " " + use.results[0].name.first + " " + use.results[0].name.last;
    document.getElementById("phone").innerHTML = use.results[0].phone;
    document.getElementById("email").innerHTML = use.results[0].email;
}


function retrieveMultiple() {
    let url = baseurl + "?results=20";
    sendAjaxGet(url, updateTable);
}

function updateTable(xhr) {
    let response = xhr.response;
    let users = JSON.parse(response);

    for(use of users.results) {
        let row = document.createElement("tr");
        let name = use.name.title + " " + use.name.first + " " + use.name.last;
        let phone = use.phone;
        let email = use.email;
        let nm = document.createElement("td");
        nm.innerHTML = name;
        let phn = document.createElement("td");
        phn.innerHTML = phone;
        let mail = document.createElement("td");
        mail.innerHTML = email;
        row.appendChild(nm);
        row.appendChild(phn);
        row.appendChild(mail);
        document.getElementById("users").appendChild(row);
    }
}

document.getElementById("multiple").addEventListener("click", retrieveMultiple);