url = "https://randomuser.me/api/"

function begin() {
    sendAjaxGet(url, generateUser);
}

function sendAjaxGet(url, func) {
    let xhr = new XMLHttpRequest;

    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function generateUser(xhr) {
    let response = xhr.response;
    let users = JSON.parse(response);
    console.log(users);

    let fname = users.results[0].name.first;
    fname = fname.slice(0, 1).toUpperCase() + fname.slice(1, -1) + fname.slice(-1);
    let lname = users.results[0].name.last;
    lname = lname.slice(0, 1).toUpperCase() + lname.slice(1, -1) + lname.slice(-1);

    document.getElementById("fname").innerHTML = fname;
    document.getElementById("lname").innerHTML = lname;
    document.getElementById("phone").innerHTML = users.results[0].cell;
    document.getElementById("email").innerHTML = users.results[0].email;
    document.getElementById("gender").innerHTML = users.results[0].gender;
    document.getElementById("photo").setAttribute("src", users.results[0].picture.thumbnail);

    let row = document.createElement("tr");

    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);

    cell1.innerHTML = fname +' '+lname;
    cell2.innerHTML = users.results[0].cell;
    cell3.innerHTML = users.results[0].email;
    cell4.innerHTML = users.results[0].gender;

    document.getElementById("users").appendChild(row);

}

function generateTable() { 

    for(i=0;i<20;i++){
        begin();
    }
}