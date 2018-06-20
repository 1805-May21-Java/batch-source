let url = 'http://localhost:8080/ExpenseRequestSys/newemployee';

function sendAjaxPost(url, obj, redirfcn, errfcn) {
    xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
    xhr.onreadystatechange = function () {
        if (this.readyState == 4) {
            switch (this.status) {
                case 300:
                    redirfcn(this);
                    break;
                case 401:
                    errfcn(this);
                    break;
            }
        }
    }

    xhr.open('POST', url);
    let js = JSON.stringify(obj);
    xhr.send(js);
}

function redir(xhr) {
    let data = JSON.parse(xhr.response);
    window.location = data.url;
}

function err(xhr) {
    let data = JSON.parse(xhr.response);
    document.getElementById("err").innerHTML = data.error;
}

function submitNewEmployee() {
    let username = (document.getElementById('username').value || null);
    let pwd1 = (document.getElementById('pass1').value || null);
    let pwd2 = (document.getElementById('pass2').value || null);
    let firstname = (document.getElementById('firstname').value || null);
    let lastname = (document.getElementById('lastname').value || null);
    let email = (document.getElementById('email').value || null);
    let reportsTo = (document.getElementById('reportsto').value || null);

    if (pwd1 !== pwd2) {
        document.getElementById('err').innerHTML = "Passwords do not match";
        return;
    }



    sendAjaxPost(url, {
        "username": username, "pwd": pwd1, "firstName": firstname,
        "lastName": lastname, "email": email, "reportsTo": reportsTo
    }, redir, err);
}