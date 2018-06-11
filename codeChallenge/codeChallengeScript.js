baseUrl = "https://randomuser.me/api/?format=json";



function getUser(){
    //console.log("Button works");
    sendAjaxGet(baseUrl, displayUser)
}

//Gets info from Random user generator site
function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        //console.log(xhr.readyState);
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

//Displays the random user data in the table in div container with id "problem1".
function displayUser(xhr){
    let response = xhr.response;
    let userInfo = JSON.parse(response);
    //console.log(userInfo.results[0]);
    //Getting data from JSON parse
    let firstname = userInfo.results[0].name.first;
    let lastname = userInfo.results[0].name.last;
    let username = userInfo.results[0].login.username;
    let password = userInfo.results[0].login.password;
    let dob = userInfo.results[0].dob;
    let phone = userInfo.results[0].cell;
    let email = userInfo.results[0].email;

    document.getElementById("firstName").innerHTML = firstname;
    document.getElementById("lastName").innerHTML = lastname;
    document.getElementById("username").innerHTML = username;
    document.getElementById("password").innerHTML = password;
    document.getElementById("dob").innerHTML = dob;
    document.getElementById("phone").innerHTML = phone;
    document.getElementById("email").innerHTML = email;

    //use this for problem two
    /*
    let row  = document.createElement("tr");
    let firstnameTd = document.createElement("td");
    let lastnameTd = document.createElement("td");
    let usernameTd = document.createElement("td");
    let passwordTd = document.createElement("td");
    let dobTd = document.createElement("td");
    let phoneTd = document.createElement("td");
    let emailTd = document.createElement("td");

    //adding table cells to row
    row.appendChild(firstnameTd);
    row.appendChild(lastnameTd);
    row.appendChild(usernameTd);
    row.appendChild(passwordTd);
    row.appendChild(dobTd);
    row.appendChild(phoneTd);
    row.appendChild(emailTd);
    */
}

function getUsers(){
    let problem2 = document.getElementById("problem2");
    while(problem2.firstChild){
        problem2.removeChild(problem2.firstChild);
    }
    let table = document.createElement("table");
    table.setAttribute("class", "table text-center");
    table.id = "table2";
    let headerRow = document.createElement("tr");
    let firstname = document.createElement("th");
    let lastname = document.createElement("th");
    let username = document.createElement("th");
    let password = document.createElement("th");
    let dob = document.createElement("th");
    let phone = document.createElement("th");
    let email = document.createElement("th");
    //table.appendChild(headerRow);
    headerRow.appendChild(firstname);
    headerRow.appendChild(lastname);
    headerRow.appendChild(username);
    headerRow.appendChild(password);
    headerRow.appendChild(dob);
    headerRow.appendChild(phone);
    headerRow.appendChild(email);
    table.appendChild(headerRow);
    document.getElementById("problem2").appendChild(table);
    sendAjaxGet(baseUrl, displayUsers);

}

function displayUsers(xhr){
    let response = xhr.response;
    let userInfo = JSON.parse(response);
    //console.log(userInfo.results[0]);
    //Getting data from JSON parse
    let firstname = userInfo.results[0].name.first;
    let lastname = userInfo.results[0].name.last;
    let username = userInfo.results[0].login.username;
    let password = userInfo.results[0].login.password;
    let dob = userInfo.results[0].dob;
    let phone = userInfo.results[0].cell;
    let email = userInfo.results[0].email;

    let row  = document.createElement("tr");
    let firstnameTd = document.createElement("td");
    let lastnameTd = document.createElement("td");
    let usernameTd = document.createElement("td");
    let passwordTd = document.createElement("td");
    let dobTd = document.createElement("td");
    let phoneTd = document.createElement("td");
    let emailTd = document.createElement("td");

    //adding table cells to row
    row.appendChild(firstnameTd);
    row.appendChild(lastnameTd);
    row.appendChild(usernameTd);
    row.appendChild(passwordTd);
    row.appendChild(dobTd);
    row.appendChild(phoneTd);
    row.appendChild(emailTd);

    firstnameTd.innerHTML = firstname;
    lastnameTd.innerHTML = lastname;
    usernameTd.innerHTML = username;
    passwordTd.innerHTML = password;
    dobTd.innerHTML = dob;
    phoneTd.innerHTML = phone;
    emailTd.innerHTML = email;
    document.getElementById("table2").appendChild(row);
}
