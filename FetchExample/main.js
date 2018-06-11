function myFetch(url, func) {
    fetch(url)
        .then(function (response) {
            if (response.status !== 200) {
                console.log('Looks like there was a problem. Status Code: ' + response.status);
                return;
            }

            response.json().then(function (data) {
                func(data);
            });
        })
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}

function getRandomUser() {
    myFetch('https://randomuser.me/api/', showRandomUser);
}

function showRandomUser(obj) {
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
    for (i = 0; i < numRows; i++) {
        myFetch('https://randomuser.me/api/', addRow)
    }
}

function addRow(obj) {
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

