// Set google link to google
document.getElementsByName('google')[0].setAttribute('href', 'http://www.google.com');

//Set twitter link to twitter
document.getElementsByName('twitter')[0].setAttribute('href', 'http://www.twitter.com');

//Set slack link to slack
document.getElementsByName('slack')[0].setAttribute('href', 'http://www.slack.com');

//Same for javadocs
document.getElementsByName('javadocs')[0].setAttribute('href', 'https://www.javadocs.com');

//Disable pluto
document.getElementById('planet').getElementsByTagName('option')[3].disabled = true;

//Set a click listener on the submit button
document.getElementById('form-sub').addEventListener('click', submitRes);

function submitRes() {
    firstname = document.getElementById('firstname').value;
    lastname = document.getElementById('lastname').value;
    email = document.getElementById('email').value;
    phone = document.getElementById('phone').value;
    birthday = document.getElementById('bday').value;
    planet = document.getElementById('planet').value;
    gender = (document.querySelector(`input[name='gender']:checked`) || {});
    color = document.getElementById('color').value;

    //Not done with activity
    activity = document.querySelectorAll(`input[class='activity']:checked`);

    if (gender) {
        gender = gender.nextSibling.data;
    }

    if (!firstname || !lastname || !email || !phone || !birthday || !gender) {
        return;
    }

    let phoneno = /^\d{10}$/;
    if (!(phone.match(phoneno))) {
        return;
    }

    let emailValid = /\S+@\S+\.\S+/
    if (!(email.match(emailValid))) {
        return;
    }

    let row = document.createElement('tr');
    row.setAttribute('scope', 'row');

    let c1 = document.createElement('td');
    let c2 = document.createElement('td');
    let c3 = document.createElement('td');
    let c4 = document.createElement('td');
    let c5 = document.createElement('td');
    let c6 = document.createElement('td');

    let actList = document.createElement('ul');
    for (let i = 0; i < activity.length; i++) {
        let temp = document.createElement('li');
        temp.innerHTML = activity[i].value;
        actList.appendChild(temp);
    }


    c1.innerHTML = firstname + '\n' + lastname;
    c2.innerHTML = email;
    c3.innerHTML = phone;
    c4.innerHTML = birthday;
    c5.innerHTML = color;
    c6.innerHTML = gender;

    row.appendChild(c1);
    row.appendChild(c2);
    row.appendChild(c3);
    row.appendChild(c4);
    row.appendChild(c5);
    row.appendChild(c6);
    row.appendChild(actList);

    document.getElementsByTagName('tbody')[0].appendChild(row);
}

let det = document.getElementsByTagName('details')[0];

det.addEventListener('mouseover', openDetails);
det.addEventListener('mouseout', closeDetails);

function openDetails(e) {
    det.open = true;
}

function closeDetails(e) {
    det.open = false;

}

function getSpans() {
    let sps = document.getElementsByTagName('span');
    for (i of sps) {
        console.log(i.innerHTML + " ");
    }
}

document.getElementById('earth_time_check').onclick = getEarthTime;

function getEarthTime() {
    let d = new Date();
    document.getElementById('earth_time').innerHTML = d;
}

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 & this.readyState == 4) {
            func(this);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function showAlphaTime() {
    let url = "http://www.astropical.space/astrodb/api-exo.php?which=distance&limit=2&format=json"
    sendAjaxGet(url, getAlphaTime);
}

function getAlphaTime(xhr) {
    let response = xhr.response;
    let atime = JSON.parse(response);
    let period = atime.exoplanets[1].per;

    let time = new Date();
    let milli = time.getTime();
    let seconds = milli / 1000;
    let minutes = seconds / 60;
    let hours = minutes / 60;
    let days = hours / 24;

    let acbTime = String(1970 + days / period).split(".");
    let acbYear = acbTime[0];
    let acbDay = String(Number("0." + acbTime[1]) * period).split(".")[0];
    document.getElementById("acb_time").innerHTML = "Day " + acbDay + " of year " + acbYear;
}
document.getElementById("acb_time_check").addEventListener("click", showAlphaTime);

function showMarsTime() {
    let time = new Date();
    let milli = time.getTime();
    let seconds = milli / 1000;
    let minutes = seconds / 60;
    let hours = minutes / 60;
    let days = hours / 24;

    let marsTime = String(1970 + days / 687).split(".");
    let marsYear = marsTime[0];
    let marsDay = String(Number("0." + marsTime[1]) * 687).split(".")[0];

    document.getElementById("mars_time").innerHTML = "Day " + marsDay + " of year " + marsYear;
}

document.getElementById("mars_time_check").addEventListener("click", showMarsTime);

function changeColorInThreeSeconds() {
    window.setTimeout(changeColor, 3000);
}

document.getElementsByTagName("h1")[0].addEventListener("click", changeColorInThreeSeconds);

function changeColor() {

    function checkColor(c) {
        if (String(c).length < 2) {
            return "0" + String(c);
        }
        return num;
    }

    let r = checkColor((200 + Math.round(Math.random() * 100)).toString(16));
    let g = checkColor((200 + Math.round(Math.random() * 100)).toString(16));
    let b = checkColor((200 + Math.round(Math.random() * 100)).toString(16));

    let myColor = "#" + r + g + b;
    document.getElementsByTagName("body")[0].style.backgroundColor = myColor;
}

//Set both text boxes with a key listener
document.getElementById('n1').onkeypress = (ev) => keyCheck(ev);
document.getElementById('n2').onkeypress = (ev) => keyCheck(ev);

//Check for the enter key
function keyCheck(ev) {
    if (ev.keyCode == 13) {
        checkMath();
    }
}

function checkMath() {

    let x = document.getElementById("n1").value;
    let y = document.getElementById("n2").value;
    //Check nulvalues
    if (isNaN(x) || isNaN(y) || x === '' || y === '') {
        document.getElementById('result').innerHTML = '';
        return;
    }

    x = Number(x);
    y = Number(y);

    let result = 0;
    switch (document.getElementById("operation").value) {
        case "Add":
            result = x + y;
            break;
        case "Subtract":
            result = x - y;
            break;
        case "Divide":
            if (Number(y) === 0) {
                document.getElementById("result").innerHTML = "Can't Divide By Zero";
                return;
            }
            result = x / y;
            break;
        case "Multiply":
            result = x * y;
            break;
        default:
    }

    document.getElementById('result').innerHTML = 'Result: ' + result;

}

function walkTheDom(node, func) {
    let kids = node.children;
    if (kids.length < 1) {
        func(node);
    } else {
        for (let i = 0; i < kids.length; i++) {
            walkTheDom(kids[i], func);
        }
        func(node);
    }
}

function printNode(node) {
    console.log(node.nodeName);
}
