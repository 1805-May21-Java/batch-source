document.getElementById("getUser").addEventListener("click", () => {
  fetch("https://randomuser.me/api/?results=1")
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    createTable(data);
  })
  .catch((error) => {
    console.log(error);
  });
});

document.getElementById("getUsers").addEventListener("click", () => {
  const number = document.querySelector("option:checked").value;
  fetch(`https://randomuser.me/api/?results=${number}`)
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    createTable(data);
  })
  .catch((error) => {
    console.log(error);
  });
});

function setUpTable(){
  const oldTable = document.getElementsByTagName("table")[0];
  if(oldTable)
    document.getElementsByTagName("body")[0].removeChild(oldTable);

  const table = document.createElement("table");
  const head = document.createElement("thead");
  const headRow = document.createElement("tr");
  const th1 = document.createElement("th");
  th1.innerHTML = "User Number";
  const th2 = document.createElement("th");
  th2.innerHTML = "Name";
  const th3 = document.createElement("th");
  th3.innerHTML = "Image";
  const th4 = document.createElement("th");
  th4.innerHTML = "Phone Number";
  const th5 = document.createElement("th");
  th5.innerHTML = "Email";
  headRow.appendChild(th1);
  headRow.appendChild(th2);
  headRow.appendChild(th3);
  headRow.appendChild(th4);
  headRow.appendChild(th5);
  head.appendChild(headRow);
  table.appendChild(head);
  const tableBody = document.createElement("tbody");
  table.appendChild(tableBody);
  document.getElementsByTagName("body")[0].appendChild(table);
  table.setAttribute("class", "table table-hover");
  head.setAttribute("class", "bg-dark text-white")
}

function createTable(users){
  setUpTable();
  const tableBody = document.getElementsByTagName("tbody")[0];
  let i = 1;
  for(let user of users.results){
    const userNumber = document.createElement("td");
    userNumber.innerHTML = i++;
    const userName = document.createElement("td");
    userName.innerHTML = `${capitalize(user.name.title)} ${capitalize(user.name.first)} ${capitalize(user.name.last)}`;
    const userImage = document.createElement("td");
    const image = document.createElement("img");
    image.setAttribute("src", user.picture.thumbnail);
    userImage.appendChild(image);
    const userPhone = document.createElement("td");
    userPhone.innerHTML = user.phone;
    const userEmail = document.createElement("td");
    userEmail.innerHTML = user.email;
    const row = document.createElement("tr");
    row.appendChild(userNumber);
    row.appendChild(userName);
    row.appendChild(userImage);
    row.appendChild(userPhone);
    row.appendChild(userEmail);
    tableBody.appendChild(row);
  }
}

function capitalize(str) {
  return str[0].toUpperCase() + str.slice(1);
}