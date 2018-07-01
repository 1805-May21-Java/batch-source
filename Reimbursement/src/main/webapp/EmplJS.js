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
    let resp = xhr.response;
    let user = JSON.parse(resp);
    console.log(user);

    document.getElementById("TitleName").innerHTML = user.employee.empName;
    document.getElementById("EmployeeName").innerHTML = user.employee.empName;
    document.getElementById("EmployeeID").innerHTML = user.employee.e_Id;
    document.getElementById("EmployeeUsername").innerHTML = user.employee.uName;
    document.getElementById("EmployeeJob").innerHTML = user.employee.ePosition;
}