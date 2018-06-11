var rowNum = 1;
document.getElementById("randomEntry").addEventListener("click", ()=>sendAjaxGet("https://randomuser.me/api/?format=json?nat=us", randomEntries));
document.getElementById("addRow").addEventListener("click", addRow);
document.getElementById("generateRows").addEventListener("click", generateRows);

function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject());

    xhr.onreadystatechange = function(){
        if(xhr.status >= 200 && xhr.status < 300 && xhr.readyState == 4){
            func(xhr);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function makeNamePretty(string){
    let newStr = "";
    for(c in string){
        if(c == 0){
            newStr += string[c].toUpperCase();
        }
        else{
            newStr += string[c].toLowerCase();
        }
    }
    return newStr;
}

function randomEntries(xhr){
    let rand = JSON.parse(xhr.responseText).results[0];

    document.getElementById("first").value = makeNamePretty(rand.name.first);
    document.getElementById("last").value = makeNamePretty(rand.name.last);
    document.getElementById("email").value = rand.email;
    document.getElementById("phone").value = rand.phone;
}

function addRow(){
    let tbody = document.getElementsByTagName("tbody")[0];
    
    let newRow = document.createElement("tr");
    let cell1 = document.createElement("th");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");

    cell1.setAttribute("scope", "row");

    cell1.innerHTML = rowNum;
    cell2.innerHTML = document.getElementById("first").value + " " + document.getElementById("last").value;
    cell3.innerHTML = document.getElementById("phone").value;
    cell4.innerHTML = document.getElementById("email").value;

    newRow.appendChild(cell1);
    newRow.appendChild(cell2);
    newRow.appendChild(cell3);
    newRow.appendChild(cell4);

    let nameRegex = /^[a-zA-Z]+[-']?[a-zA-Z]+\s[a-zA-Z]+[-']?[a-zA-Z]+$/;
    let emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(nameRegex.test(cell2.innerHTML) && cell3 && emailRegex.test(cell4.innerHTML)){
        tbody.appendChild(newRow);
        rowNum++;
    }
}

function randomRow(xhr){
    let rand = JSON.parse(xhr.responseText).results[0];
    let tbody = document.getElementsByTagName("tbody")[0];
    
    let newRow = document.createElement("tr");
    let cell1 = document.createElement("th");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");

    cell1.setAttribute("scope", "row");

    cell1.innerHTML = rowNum;
    cell2.innerHTML = makeNamePretty(rand.name.first) + " " + makeNamePretty(rand.name.last);
    cell3.innerHTML = rand.phone;
    cell4.innerHTML = rand.email;

    newRow.appendChild(cell1);
    newRow.appendChild(cell2);
    newRow.appendChild(cell3);
    newRow.appendChild(cell4);

    let emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if(cell2.innerHTML && cell3.innerHTML && emailRegex.test(cell4.innerHTML)){
        tbody.appendChild(newRow);
        rowNum++;
    }
    else{
        randomRow(xhr);
    }
}

function generateRows(){
    for(i = 0; i < document.getElementById("generateNum").value; i++){
        sendAjaxGet("https://randomuser.me/api/?format=json?nat=us", randomRow);
    }
}