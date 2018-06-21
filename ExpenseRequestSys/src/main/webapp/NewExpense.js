let newexpurl = 'http://localhost:8080/ExpenseRequestSys/newexpense';
let expurl = 'http://localhost:8080/ExpenseRequestSys/myexpenses';


function sendAjaxPost(url, obj, func, redir, errfcn) {
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
                case 401:
                    errfcn(this);
                    break;
            }
        }
    }

    xhr.open('POST', url);
    xhr.send(JSON.stringify(obj));
}

function errhandle(xhr) {
    document.getElementById('amounterr').innerHTML = "";
    document.getElementById('expenseerr').innerHTML = "";
    document.getElementById('msg').innerHTML = "";

    let errmsg = JSON.parse(xhr.response);
    document.getElementById(errmsg.location).innerHTML = errmsg.err;
}

function redir(xhr) {
    let url = JSON.parse(xhr.response).url;
    window.location = url;
}

function recieveOK(xhr) {
    window.location = expurl
}

function sendNewExpense() {
    let amount = document.getElementById('amount').value;
    let expense = (document.getElementById('expense').value || null);

    ex = { 'amount': amount, 'expense': expense };

    sendAjaxPost(newexpurl, ex, recieveOK, redir, errhandle);
}

function enterListener(key, fcn) {
    if (key.keyCode == 13) {
        fcn();
    }
}

document.getElementById('amount').onkeypress = (key) => enterListener(key, sendNewExpense);
document.getElementById('expense').onkeypress = (key) => enterListener(key, sendNewExpense);