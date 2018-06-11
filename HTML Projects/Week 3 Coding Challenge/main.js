baseURL = "https://randomuser.me/api/";

document.getElementById("fill-form").addEventListener("click", fillForm);
document.getElementById("fill-table").addEventListener("click", fillTable);

function fillForm () {
    //console.log("success");
    sendAjaxGet(baseURL, processData);
}

function fillTable() {
    for (let i=0; i<20; i++) {
        sendAjaxGet(baseURL, processTable);
    }
}


function sendAjaxGet(url, func){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function processData(xhr) {
    let response = xhr.response;
    let data = JSON.parse(response).results[0];
    console.log(data);
    document.getElementById("first").setAttribute("value", data.name.first);
    document.getElementById("last").setAttribute("value", data.name.last);
    document.getElementById("phone").setAttribute("value", data.phone);
    document.getElementById("email").setAttribute("value", data.email);
}

function processTable(xhr) {
    let response = xhr.response;
    let data = JSON.parse(response).results[0];

    var row = document.createElement("tr");
    var cell1 = document.createElement("td");
    var cell2 = document.createElement("td");
    var cell3 = document.createElement("td");

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);

    cell1.innerHTML = data.name.first + " " + data.name.last;
    cell2.innerHTML = data.phone;
    cell3.innerHTML = data.email;

    document.getElementsByTagName("table")[0].appendChild(row);

}