let url = 'http://localhost:8080/ExpenseRequestSys/info';

function sendAjaxGet(url, func) {
    xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function getEmployeeInfo(xhr) {
    let data = JSON.parse(xhr.response).result;
    
    document.getElementById('myName').innerHTML = "Welcome " +
        data.firstName + " " + data.lastName;
}

document.onload = sendAjaxGet(url, getEmployeeInfo);