// document.getElementById('form-randomize').onclick = rndmuser;

let url = 'https://randomuser.me/api/?results=';

function rndmuser() {
    sendAjaxGet(url, getrndmuser);
}

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

function getrndmuser(xhr) {
    let resp = xhr.response;
    let info = JSON.parse(resp).results[0];

    let firstname = info.name.first;
    let lastname = info.name.last;
    let email = info.email;
    let phone = info.phone;
    let gender = info.gender;

    document.getElementById('firstname').value = firstname;
    document.getElementById('lastname').value = lastname;
    document.getElementById('email').value = email;
    document.getElementById('phone').value = phone;

    let t = document.getElementsByName('gender');
    for (i of t) {
        if (i.value == gender) {
            i.checked = true;
        } else {
            i.checked = false;
        }
    }
}

function submittotable() {

    let firstname = document.getElementById('firstname').value;
    let lastname = document.getElementById('lastname').value;
    let email = document.getElementById('email').value;
    let phone = document.getElementById('phone').value;
    if (!firstname || !lastname || !email || !phone) {
        return;
    }

    let t = document.getElementsByName('gender');
    let gender = '';
    for (i of t) {
        if (i.checked == true) {
            gender = i.value;
        }
    }

    let row = document.createElement('tr');
    row.setAttribute('scope', 'row');

    let c1 = document.createElement('td');
    let c2 = document.createElement('td');
    let c3 = document.createElement('td');
    let c4 = document.createElement('td');
    let c5 = document.createElement('td');

    c1.innerHTML = firstname;
    c2.innerHTML = lastname;
    c3.innerHTML = email;
    c4.innerHTML = phone;
    c5.innerHTML = gender;

    row.appendChild(c1);
    row.appendChild(c2);
    row.appendChild(c3);
    row.appendChild(c4);
    row.appendChild(c5);

    document.getElementsByTagName('tbody')[0].appendChild(row);

    clearForm();
}

function clearForm() {
    document.getElementById('firstname').value = '';
    document.getElementById('lastname').value = '';
    document.getElementById('email').value = '';
    document.getElementById('phone').value = '';
}

function getmultiple(xhr) {
    let resp = xhr.response;
    let info = JSON.parse(resp);

    info = info.results;

    console.log(info);

    for (let i = 0; i < info.length; i++) {
        console.log(info[i]);
        let infot = info[i];
        let firstname = infot.name.first;
        let lastname = infot.name.last;
        let email = infot.email;
        let phone = infot.phone;
        let gender = infot.gender;

        document.getElementById('firstname').value = firstname;
        document.getElementById('lastname').value = lastname;
        document.getElementById('email').value = email;
        document.getElementById('phone').value = phone;

        submittotable();
    }
}

function getrndmnumberusers() {

    let n = document.getElementById('nusers').value;
    n = Number(n);
    sendAjaxGet('https://randomuser.me/api/?results=10', getmultiple);
}