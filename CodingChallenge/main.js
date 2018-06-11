function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 & this.readyState == 4) {
            func(this);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function getRandomUser() {
    sendAjaxGet('https://randomuser.me/api/', showRandomUser);
}

function showRandomUser(xhr) {
    let response = xhr.response;
    let obj = JSON.parse(response);
    let person = obj.results[0];

    let name = person.name.first + " " + person.name.last;
    let phone = person.phone;
    let email = person.email;

    document.getElementById("name").value = name;
    document.getElementById("phone").value = phone;
    document.getElementById("email").value = email;
}

function populateTable() {
    let numRows = Number(document.getElementById("numberRows").value);
   
    document.getElementById("myTable").innerHTML = "";
    let r = document.createElement("tr");
    let nm = document.createElement("th");
    nm.innerHTML = "name";
    let pn = document.createElement("th");
    pn.innerHTML = "Phone";
    let em = document.createElement("th");
    em.innerHTML = "Email";

    r.appendChild(nm);
    r.appendChild(pn);
    r.appendChild(em);

    document.getElementById("myTable").appendChild(r);
    for(i = 0; i < numRows; i++) {
        sendAjaxGet('https://randomuser.me/api/', addRow)
    }
}

function addRow(xhr) {
    let response = xhr.response;
    let obj = JSON.parse(response);
    let person = obj.results[0];

    let name = person.name.first + " " + person.name.last;
    let phone = person.phone;
    let email = person.email;

    let r = document.createElement("tr");
    let nm = document.createElement("td");
    nm.innerHTML = name;
    let pn = document.createElement("td");
    pn.innerHTML = phone;
    let em = document.createElement("td");
    em.innerHTML = email;

    r.appendChild(nm);
    r.appendChild(pn);
    r.appendChild(em);

    document.getElementById("myTable").appendChild(r);
}

