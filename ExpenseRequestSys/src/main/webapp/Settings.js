let infourl = 'http://localhost:8080/ExpenseRequestSys/info';
let settingurl = 'http://localhost:8080/ExpenseRequestSys/settings';

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

function sendAjaxPost(url, obj, func, redir) {
    xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            switch (this.status) {
                case 200:
                    func(this);
                    break;
                case 300:
                    redir(this);
                    break;
            }
        }
    }

    xhr.open('POST', url);
    xhr.send(JSON.stringify(obj));
}

function redir(xhr) {
    let data = JSON.parse(xhr.response);
    window.location = data.url;
}

function recieveOK(xhr) {
    document.getElementById('pwd').readOnly = true;
    document.getElementById('firstName').readOnly = true;
    document.getElementById('lastName').readOnly = true;
    document.getElementById('email').readOnly = true;

    document.getElementById('msg').innerHTML='Changes Accepted';
}

function getEmployeeInfo(xhr) {
    let data = JSON.parse(xhr.response).result;

    document.getElementById('pwd').value = data.pwd;
    document.getElementById('firstName').value = data.firstName;
    document.getElementById('lastName').value = data.lastName;
    document.getElementById('email').value = data.email;
}

function toggleReadOnly(id) {
    let item = document.getElementById(id);
    if (item === null) {
        return;
    }
    item.readOnly = !item.readOnly;
}

function sendNewSettings() {
    let pwd = (document.getElementById('pwd').readOnly) ? null : document.getElementById('pwd').value;
    let firstName = (document.getElementById('firstName').readOnly) ? null : document.getElementById('firstName').value;
    let lastName = (document.getElementById('lastName').readOnly) ? null : document.getElementById('lastName').value;
    let email = (document.getElementById('email').readOnly) ? null : document.getElementById('email').value;

    let e = { 'pwd': pwd, 'firstName': firstName, 'lastName': lastName, 'email': email };
    sendAjaxPost(settingurl, e, recieveOK, redir);
}

document.onload = sendAjaxGet(infourl, getEmployeeInfo);