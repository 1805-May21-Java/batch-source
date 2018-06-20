let url = 'http://localhost:8080/ExpenseRequestSys/allinfo';

function sendAjaxGet(url, func, redirfcn) {
    xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        } else if (this.status == 300 && this.readyState == 4) {
            redirfcn(this);
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function sendAjaxPost(url, obj, func, redirfcn, errfcn) {
    xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        } else if (this.status == 300 && this.readyState == 4) {
            redirfcn(this);
        } else if (this.status == 401 && this.readyState == 4) {
            errfcn(this);
        }
    }

    xhr.open('POST', url);
    xhr.send(JSON.stringify(obj));
}

function redir(xhr) {
    window.location = JSON.parse(xhr.response).url;
}

function errhndl(xhr) {
    document.getElementById('err').innerHTML = JSON.parse(xhr.response).error;
}

let empList = null;
let erList = null;

function getAllEmployees(xhr) {
    let data = JSON.parse(xhr.response);

    if (data == null) {
        return;
    }

    empList = data.employees;
    erList = data.expenses;

    for (let i = 0; i < empList.length; i++) {
        let ex = empList[i];

        let row = document.createElement('tr');
        row.setAttribute('scope', 'row');

        let username = document.createElement('td');
        username.innerHTML = ex.username;

        let name = document.createElement('td');
        name.innerHTML = ex.firstName + " " + ex.lastName;

        let email = document.createElement('td');
        email.innerHTML = ex.email;

        let manager = document.createElement('td');
        manager.innerHTML = ex.reportsTo;

        row.appendChild(username);
        row.appendChild(name);
        row.appendChild(email);
        row.appendChild(manager);

        row.setAttribute('onclick', "populateExpenseTable(this.getElementsByTagName('td')[0].innerHTML,this)");
        row.onmouseenter = function () { this.setAttribute('class', 'highlight') };
        row.onmouseleave = function () {
            if (this != currentEmployee) { this.setAttribute('class', '') }
        };
        document.getElementById("employeeTable").appendChild(row);
    }
}

let currentEmployee = null;
let currentExpense = null;

function filterExpenseTable() {
    if (erList == null || currentEmployee == null) {
        return;
    }

    document.getElementById('expenseTable').innerHTML = "";

    let filt = document.getElementById('filter').value;

    for (elem of erList) {
        if (elem.submitter == currentEmployee.getElementsByTagName('td')[0].innerHTML) {
            let ex = elem;

            if (filt == 'Pending' && ex.state != 'PENDING') {
                continue;
            }

            if (filt == 'Resolved' && ex.state == 'PENDING') {
                continue;
            }

            let row = document.createElement('tr');
            row.setAttribute('scope', 'row');

            let id = document.createElement('td');
            id.innerHTML = ex.requestId;

            let submitter = document.createElement('td');
            submitter.innerHTML = elem.submitter;

            let subdate = document.createElement('td');
            subdate.innerHTML = ex.submissionDate;

            let amount = document.createElement('td');
            amount.innerHTML = "$" + ex.amount.toFixed(2);

            let expense = document.createElement('td');
            expense.innerHTML = ex.expense;

            let state = document.createElement('td');
            state.innerHTML = ex.state;

            let manager = document.createElement('td');
            manager.innerHTML = ex.resolvingManager;

            row.appendChild(id);
            row.appendChild(submitter);
            row.appendChild(subdate);
            row.appendChild(amount);
            row.appendChild(expense);
            row.appendChild(state);
            row.appendChild(manager);

            row.onmouseenter = function () {
                this.setAttribute('class', 'highlight');
            }

            row.onmouseleave = function () {
                if (this != currentExpense) { this.setAttribute('class', '') }
            }

            row.setAttribute('onclick', 'addButtons(this)');

            document.getElementById('expenseTable').appendChild(row);
        }
    }

}

function populateExpenseTable(usr, elem) {
    clearButtons();
    if (erList == null) {
        return null;
    }

    if (currentEmployee != null) {
        currentEmployee.setAttribute('class', '');
    }

    currentEmployee = elem;
    currentEmployee.setAttribute('class', 'highlight');

    document.getElementById('expenseTable').innerHTML = "";

    filterExpenseTable(usr, elem);
}

function clearButtons() {
    document.getElementById('btn-local').innerHTML = "";
    document.getElementById('err').innerHTML = "";
}

function addButtons(elem) {
    clearButtons();
    if (currentExpense != null) {
        currentExpense.setAttribute('class', '');
    }

    currentExpense = elem;

    currentExpense.setAttribute('class', 'highlight');

    let approve = document.createElement('button');
    approve.setAttribute('class', "btn btn-primary");
    approve.innerHTML = "Approve";
    approve.onclick = approveRequest;

    let sp = document.createElement('span');
    sp.innerHTML=" ";

    let deny = document.createElement('button');
    deny.setAttribute('class', 'btn btn-default');
    deny.innerHTML = "Deny";
    deny.onclick = denyRequest;

    if (getExpense(currentExpense.getElementsByTagName('td')[0].innerHTML).state == "PENDING") {
        document.getElementById('btn-local').appendChild(approve);
        document.getElementById('btn-local').appendChild(sp);
        document.getElementById('btn-local').appendChild(deny);
    }
}

function getExpense(id) {
    id = Number(id);
    for (er of erList) {
        if (id == er.requestId) {
            return er;
        }
    }

    return null;
}

function approveRequest() {
    if (currentExpense == null) {
        return;
    }

    let er = getExpense(currentExpense.getElementsByTagName('td')[0].innerHTML);

    let toSend = {'requestId':er.requestId , 'submitter':er.submitter,
    		'submissionDate':er.submissionDate,'amount':er.amount,
    		'expense':er.expense,'state':'APPROVED', 
    		'resolvingManager':er.resolvingManager};
    
    sendAjaxPost(url, toSend, function () {
        window.location = "view";
    }, redir, errhndl);
}

function denyRequest() {
    if (currentExpense == null) {
        return;
    }

    let er = getExpense(currentExpense.getElementsByTagName('td')[0].innerHTML);

    let toSend = {'requestId':er.requestId , 'submitter':er.submitter,
    		'submissionDate':er.submissionDate,'amount':er.amount,
    		'expense':er.expense,'state':'DENIED', 
    		'resolvingManager':er.resolvingManager};
    
    sendAjaxPost(url, toSend, function () {
        window.location = "view";
    }, redir, errhndl);
}

document.onload = sendAjaxGet(url, getAllEmployees, redir);

document.getElementById('filter').onchange = filterExpenseTable;