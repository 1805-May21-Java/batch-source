let url = "https://randomapi.com/api/6de6abfedb24f889e0b5f675edc50deb?fmt=json";
let submitButton = document.getElementById("submitButton");
//Array to store field objects
let fieldArr = [];
//Add an event listiner that gathers data when user hits submit
submitButton.addEventListener("click", function () {
    //adds all the fields to the array
    fieldArr.push(document.getElementById("firstNameField").value);
    fieldArr.push(document.getElementById("lastNameField").value);
    fieldArr.push(document.getElementById("email").value);
    fieldArr.push(document.getElementById("phone").value);
    fieldArr.push(document.getElementById("maidenName").value)

    //creates row to add to table
    let row = document.createElement("tr");
    //puts all the field elements as td's, then appends it to the newly created tr
    for (field of fieldArr) {
        let cell = document.createElement("td");
        cell.innerHTML = field;
        row.appendChild(cell);
    }
    //appends tr to the table
    document.getElementById("tableBody").appendChild(row);
});

//populates table with random info when button clicked
let submitRandomButton = document.getElementById("submitButtonRandom");
submitRandomButton.addEventListener("click", function () {
    let numPeople = document.getElementById("numberPeople")
    for (num of numPeople) {
        if (num.selected) {
            sendAjax(url, fillTable, num.value);
        }
    }
});

//creates, opens, sends, and calls a function for xhr request
function sendAjax(url, func, numberRows) {
    let xhr = new XMLHttpRequest;
    xhr.onreadystatechange = function () {
        if (xhr.status == 200 && xhr.readyState == 4) {
            func(xhr, numberRows);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function fillTable(xhr, numRows) {
    //parses response
    response = (JSON.parse(xhr.response)).results[0];
    //inserts the number of rows the user selected
    for (let i = 0; i < numRows; i++) {
        //puts elements in order into an array
        randomFieldArr = []
        randomFieldArr.push(response[i].first);
        randomFieldArr.push(response[i].last);
        randomFieldArr.push(response[i].email);
        randomFieldArr.push(response[i].address);
        randomFieldArr.push(response[i].balance);
        //puts response into table
        row = document.createElement("tr");
        for (field of randomFieldArr) {
            cell = document.createElement("td");
            cell.innerHTML = field;
            row.appendChild(cell);
        }
        document.getElementById("otherTable").appendChild(row);
    }


}