let baseURL= "https://randomuser.me/api/?nat=FR";

function getUser() {
    sendAjaxGet(baseURL, displayUser);
}

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function() {
        if(this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayUser(xhr){
    let response = xhr.response;
    let user = JSON.parse(response);

    //console.log(response);

    document.getElementById("username").innerHTML = user.results[0].name.title + " " + user.results[0].name.first + " " + user.results[0].name.last;
    document.getElementById("userphone").innerHTML = "Phone: " + user.results[0].phone;
    document.getElementById("useremail").innerHTML = "Email: " + user.results[0].email;
    
}

//AJAX call for table get
let tableURL = "https://randomuser.me/api/?nat=NZ&results=";
function getTable() {
    console.log(tableURL+"20");
    sendAjaxGetTable(tableURL+"20", displayTable)
}


function sendAjaxGetTable(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function() {
        if(this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayTable(xhr) {
    let response = xhr.response;
    let table = JSON.parse(response);
    console.log(table);

    for(i = 0; i < 20; i++) {
    let name = table.results[i].name.title + " " + table.results[i].name.first + " " + table.results[0].name.last;
    let phone =  table.results[i].phone;
    let email =  table.results[i].email;

    document.getElementById("usertable").setAttribute("style", "visibility: visible");

    let row = document.createElement("tr");
    row.setAttribute("scope", "row");

    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);

    cell1.innerHTML = name;
    cell2.innerHTML = phone;
    cell3.innerHTML = email;

    document.getElementsByTagName("tbody")[0].appendChild(row);
    }



}