baseurl = "http://localhost:8082/Reimbursement/SessServ";

document.onload = launch();

function launch() {
    sendAjaxGet(baseurl, displayUserInfo);
}

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    };
    xhr.open("GET", url);
    xhr.send();
}

function displayUserInfo(xhr){
    console.log(xhr.response);
    let resp = JSON.parse(xhr.response);
    console.log(resp);
    if (response.username != "null") {
        document.getElementById("Employee_Name").innerHTML = "Current User: " + response.name;
        document.getElementById("Employee_ID").innerHTML = response.EmployeeID;
        document.getElementById("Employee_Username").innerHTML = response.EmployeeUsername;
        document.getElementById("card-username").innerHTML = response.EmployeePassword;
    } else {
        window.location = "http://localhost:8082/Reimbursement/login-page";
    }
}