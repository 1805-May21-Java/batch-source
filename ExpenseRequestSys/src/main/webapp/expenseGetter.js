let url = 'http://localhost:8080/ExpenseRequestSys/expenses';

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

function init() {
    let exArr = null;
    function getAllExpenses(xhr) {
        exArr = JSON.parse(xhr.response).result;
        filterChange();
    }

    function filterChange() {
        if (exArr == null) {
            return;
        }
        let filt = document.getElementById('filter').value;
        document.getElementsByTagName('tbody')[0].innerHTML = '';

        for (let i = 0; i < exArr.length; i++) {
            let ex = exArr[i];

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
            row.appendChild(subdate);
            row.appendChild(amount);
            row.appendChild(expense);
            row.appendChild(state);
            row.appendChild(manager);

            document.getElementsByTagName('tbody')[0].appendChild(row);
        }
    }
    sendAjaxGet(url, getAllExpenses);

    document.getElementById('filter').onchange = filterChange;
}

init();

document.onload = init;

