document.getElementById("new_person_button").addEventListener("click", function () {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    let baseUrl = "https://randomuser.me/api/"
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            getPerson(this);
        }
    }
    xhr.open("GET", baseUrl);
    xhr.send();
});

function getPerson(xhr) {
    let response = JSON.parse(xhr.response).results[0];
    let name = response.name.first + " " + response.name.last;
    let phone = response.phone;
    let email = response.email;
    let picture = response.picture.medium;
    let location = response.location.street + ", " + response.location.city + ", " + response.location.state;

    let row2 = document.createElement("tr");
    let c1 = document.createElement("td");
    let c2 = document.createElement("td");
    let c3 = document.createElement("td");
    let c4 = document.createElement("td");
    let c5 = document.createElement("td");
    console.log(name);
    console.log(email);
    console.log(phone);
    console.log(location);
    console.log(picture);
    row2.appendChild(c1);
    row2.appendChild(c2);
    row2.appendChild(c3);
    row2.appendChild(c4);
    row2.appendChild(c5);

    let img = document.createElement("img");
    img.setAttribute("src", picture);
    c1.appendChild(img);
    c2.innerHTML = name;
    c3.innerHTML = email;
    c4.innerHTML = phone;
    c5.innerHTML = location;

    document.getElementsByTagName("tbody")[0].appendChild(row2);
}

document.getElementById("new_person_tables").addEventListener("click", function () {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    let baseUrl = "https://randomuser.me/api/?results=20"
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            getManyPerson(this);
        }
    }
    xhr.open("GET", baseUrl);
    xhr.send();
});

function getManyPerson(xhr) {
    let response = JSON.parse(xhr.response).results;

    for (let i = 0; i < 20; i++) {
        let name = response[i].name.first + " " + response[i].name.last;
        let phone = response[i].phone;
        let email = response[i].email;
        let picture = response[i].picture.medium;
        let location = response[i].location.street + ", " + response[i].location.city + ", " + response[i].location.state;

        let row2 = document.createElement("tr");
        let c1 = document.createElement("td");
        let c2 = document.createElement("td");
        let c3 = document.createElement("td");
        let c4 = document.createElement("td");
        let c5 = document.createElement("td");
        
        let img = document.createElement("img");
        img.setAttribute("src", picture);
        c1.appendChild(img);
        row2.appendChild(c1);
        row2.appendChild(c2);
        row2.appendChild(c3);
        row2.appendChild(c4);
        row2.appendChild(c5);

        c2.innerHTML = name;
        c3.innerHTML = email;
        c4.innerHTML = phone;
        c5.innerHTML = location;

        document.getElementsByTagName("tbody")[1].appendChild(row2);
    }


}