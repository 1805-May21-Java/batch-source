person = document.getElementById("randomperson");
person.addEventListener("click", addPerson);
people = document.getElementById("randompeople");
people.addEventListener("click", addPeople);
let baseurl = "https://randomuser.me/api/"

function addPerson() {
    sendAjaxGet(baseurl, showperson);
}
function addPeople() {
    table.innerHTML ="";
    let choice = document.getElementById("choice").value;
    table = document.createElement("table");
    table.setAttribute("class", "table table-striped table-bordered table-hover table-sm");
    let header = "<tr><th>Name</th><th>Phonenumber</th><th>Email</th><th>Street</th><th>City</th><th>State</th><th>Postcode</th></tr>";
    table.innerHTML = header;
    document.getElementById("table").appendChild(table);
    for(i = 0; i < choice; i++){
        sendAjaxGet(baseurl, showpeople);
    }
    
}


function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        //console.log(xhr.readyState);
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function showperson(xhr) {
    let response = xhr.response;
    let person = JSON.parse(response);
    fname = person.results[0].name.first;
    fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
    lname = person.results[0].name.first;
    lname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
    document.getElementById("one").innerHTML = "Hi, my name is: " + fname + " " +
        lname;
    document.getElementById("two").innerHTML = "My phone number is: " + person.results[0].phone +
        ", and my email is: " + person.results[0].email;
    document.getElementById("three").innerHTML = "I live in: " + person.results[0].location.street +
        " " + person.results[0].location.city + "," + person.results[0].location.state + " " +
        person.results[0].location.postcode;

}

function showpeople(xhr) {
    
    let response = xhr.response;
    let people = JSON.parse(response);
    row = document.createElement("tr");
    cell1 = document.createElement("td");
    cell2 = document.createElement("td");
    cell3 = document.createElement("td");
    cell4 = document.createElement("td");
    cell5 = document.createElement("td");
    cell6 = document.createElement("td");
    cell7 = document.createElement("td");

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);
    table.appendChild(row);

    fname = people.results[0].name.first;
    fname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
    lname = people.results[0].name.first;
    lname = fname.substring(0, 1).toUpperCase() + fname.substring(1);
    cell1.innerHTML = fname + " " + lname;
    cell2.innerHTML = people.results[0].phone;
    cell3.innerHTML = people.results[0].email;
    cell4.innerHTML = people.results[0].location.street;
    cell5.innerHTML = people.results[0].location.city;
    cell6.innerHTML = people.results[0].location.state;
    cell7.innerHTML = people.results[0].location.postcode
    
}