let baseurl = "https://randomuser.me/api/";
document.getElementById("single").addEventListener("click", getUser);

function getUser() {
    sendAjaxGet(baseurl, displayUser);
}

function sendAjaxGet(url, func) {
    fetch(url)
    .then(
      function(response) {
        if (response.status !== 200) {
          console.log('Looks like there was a problem. Status Code: ' +
            response.status);
          return;
        }
  
        // Examine the text in the response
        response.json().then(function(data) {
          func(data);
        });
      }
    )
    .catch(function(err) {
      console.log('Fetch Error :-S', err);
    });
}


function displayUser(data) {
    let use = data;
    document.getElementById("name").innerHTML = use.results[0].name.title + " " + use.results[0].name.first + " " + use.results[0].name.last;
    document.getElementById("phone").innerHTML = use.results[0].phone;
    document.getElementById("email").innerHTML = use.results[0].email;
}


function retrieveMultiple() {
    let url = baseurl + "?results=20";
    sendAjaxGet(url, updateTable);
}

function updateTable(data) {
    let users = data;
    console.log(data);

    for(use of users.results) {
        let row = document.createElement("tr");
        let name = use.name.title + " " + use.name.first + " " + use.name.last;
        let phone = use.phone;
        let email = use.email;
        let nm = document.createElement("td");
        nm.innerHTML = name;
        let phn = document.createElement("td");
        phn.innerHTML = phone;
        let mail = document.createElement("td");
        mail.innerHTML = email;
        row.appendChild(nm);
        row.appendChild(phn);
        row.appendChild(mail);
        document.getElementById("users").appendChild(row);
    }
}

document.getElementById("multiple").addEventListener("click", retrieveMultiple);