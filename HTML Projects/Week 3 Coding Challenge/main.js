var baseURL = "https://randomuser.me/api/";

document.getElementById("fill-form").addEventListener("click", fillForm);
document.getElementById("fill-table").addEventListener("click", fillTable);


// function fillForm () {
//     //console.log("success");
//     //sendAjaxGet(baseURL, processData);
//     fetch();
// }

function fillForm() {
    fetch(baseURL)
    .then((response) => response.json())
    .then(function(data) {
        let user = data.results[0];
        console.log(user);
        document.getElementById("first").setAttribute("value", user.name.first);
        document.getElementById("last").setAttribute("value", user.name.last);
        document.getElementById("phone").setAttribute("value", user.phone);
        document.getElementById("email").setAttribute("value", user.email);
    })
    .catch(function(error) {
        console.log(error);
    });
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



function fillTable() {
    // for (let i=0; i<20; i++) {
    //     sendAjaxGet(baseURL, processTable);
    // }
    var numResults = 20;
    var resultsURL = baseURL + "?results=" + numResults;
    sendAjaxGet(resultsURL, processTable);
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

// function processData(xhr) {
//     let response = xhr.response;
//     let data = JSON.parse(response).results[0];
//     console.log(data);
//     document.getElementById("first").setAttribute("value", data.name.first);
//     document.getElementById("last").setAttribute("value", data.name.last);
//     document.getElementById("phone").setAttribute("value", data.phone);
//     document.getElementById("email").setAttribute("value", data.email);
// }

function processTable(xhr) {
    let response = xhr.response;
    let data = JSON.parse(response).results;

    console.log(data);

    var count = 0;

    for (var person in data) {

        var row = document.createElement("tr");
        count += 1;
        var cell0 = document.createElement("td");
        var cell1 = document.createElement("td");
        var cell2 = document.createElement("td");
        var cell3 = document.createElement("td");

        row.appendChild(cell0);
        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);

        cell0.innerHTML = count;
        cell1.innerHTML = data[person].name.first + " " + data[person].name.last;
        cell2.innerHTML = data[person].phone;
        cell3.innerHTML = data[person].email;

        document.getElementsByTagName("table")[0].appendChild(row);
    }

}