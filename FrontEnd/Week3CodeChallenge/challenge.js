window.onload = function() {
    setGetUserListener();
    setGetTableListener();
}

function setGetUserListener() {
    let btn = document.getElementById("createInfoButton");

    btn.addEventListener("click", function() {
        getNewRandomUser();
    });
}

function getNewRandomUser() {
    let url = `https://randomuser.me/api`;
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function() {
        console.log(this.readyState);
        if (this.status == 200 && this.readyState == 4) {
            setRandomUser(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function setRandomUser(xhr) {
    let response = xhr.response;
    let json = JSON.parse(response);
    document.getElementById("fname").innerHTML = json.results[0].name.first;
    document.getElementById("lname").innerHTML = json.results[0].name.last;
    document.getElementById("phone").innerHTML = json.results[0].phone;
    document.getElementById("email").innerHTML = json.results[0].email;
}

function setGetTableListener() {
    let btn = document.getElementById("createTableButton");

    btn.addEventListener("click", function() {
        clearTableContents();
        getNewRandomUsers(20);
    });
}

function getNewRandomUsers(num) {
    let url = `https://randomuser.me/api/?results=${num}`;
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function() {
        console.log(this.readyState);
        if (this.status == 200 && this.readyState == 4) {
            setTableContents(this, num);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function setTableContents(xhr, num) {
    let json = JSON.parse(xhr.response);

    let table = document.getElementById("randomUserTable");

    for (let i = 0; i < num; i++) {
        let newRow = document.createElement("tr");
        let rowContents = `<td>${json.results[i].name.first} ${json.results[i].name.last}</td><td>${json.results[i].phone}</td><td>${json.results[i].email}</td>`;

        newRow.innerHTML = rowContents;
        
        table.appendChild(newRow);
    }
}

function clearTableContents() {
    let table = document.getElementById("randomUserTable");

    while (table.childElementCount > 1) {
        table.removeChild(table.lastChild);
    }
}