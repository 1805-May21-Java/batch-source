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
    document.getElementById('pwd').disabled = true;
    document.getElementById('firstName').disabled = true;
    document.getElementById('lastName').disabled = true;
    document.getElementById('email').disabled = true;

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
    item.disabled = !item.disabled;
}

function sendNewSettings() {
    let pwd = (document.getElementById('pwd').disabled) ? null : document.getElementById('pwd').value;
    let firstName = (document.getElementById('firstName').disabled) ? null : document.getElementById('firstName').value;
    let lastName = (document.getElementById('lastName').disabled) ? null : document.getElementById('lastName').value;
    let email = (document.getElementById('email').disabled) ? null : document.getElementById('email').value;

    let e = { 'pwd': pwd, 'firstName': firstName, 'lastName': lastName, 'email': email };
    sendAjaxPost(settingurl, e, recieveOK, redir);

    document.getElementById('msg').innerHTML='';
}

function enterListener(key,fcn){
    if ( key.keyCode == 13 ) {
        fcn();
    }
}

document.onload = sendAjaxGet(infourl, getEmployeeInfo);
document.getElementById('pwd').onkeypress = (key)=>enterListener(key,sendNewSettings);
document.getElementById('firstName').onkeypress = (key)=>enterListener(key,sendNewSettings);
document.getElementById('lastName').onkeypress = (key)=>enterListener(key,sendNewSettings);
document.getElementById('email').onkeypress = (key)=>enterListener(key,sendNewSettings);
