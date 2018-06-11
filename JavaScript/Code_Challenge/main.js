document.getElementById("callApi").addEventListener("click", makeApiCall);
document.getElementById("createTable").addEventListener("click", createTable);

let users; 

function setUpTable(){
  const oldTable = document.getElementsByTagName("table")[0];
  if(oldTable)
    document.getElementsByTagName("body")[0].removeChild(oldTable);

  const table = document.createElement("table");
  const head = document.createElement("thead");
  const headRow = document.createElement("tr");
  const th1 = document.createElement("th");
  th1.innerHTML = "Name";
  const th2 = document.createElement("th");
  th2.innerHTML = "Phone";
  const th3 = document.createElement("th");
  th3.innerHTML = "Email";
  const th4 = document.createElement("th");
  th4.innerHTML = "User Number";
  headRow.appendChild(th4);
  headRow.appendChild(th1);
  headRow.appendChild(th2);
  headRow.appendChild(th3);
  head.appendChild(headRow);
  table.appendChild(head);
  const tableBody = document.createElement("tbody");
  table.appendChild(tableBody);
  document.getElementsByTagName("body")[0].appendChild(table);

  table.setAttribute("class", "table");
}

function createTable(){
  if(!users) {
    alert("Must click get user button first.");
  } else {
    setUpTable();
    const tableBody = document.getElementsByTagName("tbody")[0];
    for(let i = 0; i < users.results.length; i++) {
      const user =  users.results[i];
      const userNumber = document.createElement("td");
      userNumber.innerHTML = i + 1;
      const userName = document.createElement("td");
      userName.innerHTML = `${capitalize(user.name.title)} ${capitalize(user.name.first)} ${capitalize(user.name.last)}`;
      const userPhone = document.createElement("td");
      userPhone.innerHTML = user.phone;
      const userEmail = document.createElement("td");
      userEmail.innerHTML = user.email;
      const row = document.createElement("tr");
      row.appendChild(userNumber);
      row.appendChild(userName);
      row.appendChild(userPhone);
      row.appendChild(userEmail);
      tableBody.appendChild(row);
    }
  }
}

function getUsers(xhr) {
  users = JSON.parse(xhr.response);
}

function makeApiCall() {
  const number = document.querySelector("option:checked").value;
  sendAjaxCall(`https://randomuser.me/api/?results=${number}`, getUsers)
}

function sendAjaxCall(url, func){
  const xhr = new XMLHttpRequest();
  xhr.open("GET", url);
  xhr.send();
  xhr.onreadystatechange = function() {
    if(this.status === 200 && this.readyState === 4) {
      func(this);
    }
  }
}

function capitalize(str) {
  return str[0].toUpperCase() + str.slice(1);
}