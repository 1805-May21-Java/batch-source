var baseUrlString = "http://localhost:8082/Project1/employee"
function getRequests() {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        //console.log(xhr.readyState);
        if (this.status == 200 && this.readyState == 4) {
            showEmployee(this);
        }
    }
    xhr.open("GET", baseUrlString);
    xhr.send();
}


function showEmployee(xhr) {
    let response = JSON.parse(xhr.response).employee;

    let nameField = document.getElementById("name");
    let userField = document.getElementById("username");
    let passField = document.getElementById("password");

    nameField.value = response.name;
    userField.value = response.username;
    passField.value = response.password;

    console.log(response);

}

getRequests();
function sendUpdate(){
    let url = "http://localhost:8082/Project1/employee";


    console.log("sending update");
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        //console.log(xhr.readyState);
        if (this.status == 200 && this.readyState == 4) {
        }
    }
    let name=document.getElementById("name").value;
    let uname=document.getElementById("username").value;
    let pword=document.getElementById("password").value;
    xhr.open("POST", url);
    xhr.send("name="+name+"&uname="+uname+"&pword="+pword);
}