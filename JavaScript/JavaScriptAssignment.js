//1) Make each link direct the user to its respective website (see id)
document.getElementsByName('google')[0].innerHTML = 'Google';
document.getElementsByName('google')[0].setAttribute("href", "http://www.google.com/");
document.getElementsByName('twitter')[0].innerHTML = 'Twitter';
document.getElementsByName('twitter')[0].setAttribute("href", "http://www.twitter.com/");
document.getElementsByName('slack')[0].innerHTML = 'Slack';
document.getElementsByName('slack')[0].setAttribute("href", "http://www.slack.com/");
document.getElementsByName('javadocs')[0].innerHTML = 'JavaDocs';
document.getElementsByName('javadocs')[0].setAttribute("href", "http://www.javadocs.com/");

//2) Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
document.getElementById('planet')[3].disabled = true;

//3) Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.
function alienText() {
    if (document.getElementById("planet").value != "Earth") {
        document.getElementsByTagName('p')[5].hidden = false;
    } else {
        document.getElementsByTagName('p')[5].hidden = true;
    }
}
document.getElementById("planet").addEventListener("click", alienText);

//4) When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.
document.getElementById("form-sub").addEventListener("click", add);
function add() {
    let fname = document.getElementById("firstname").value;
    if (fname.length < 2) {
        window.alert("First name is too short. Please try again.")
        return;
    }
    let lname = document.getElementById("lastname").value;
    if (lname < 2) {
        window.alert("Last name is too short. Please try again.")
        return;
    }
    let email = document.getElementById("email").value;
    if (email.includes(".") == false || email.includes("@") == false) {
        window.alert("Invalid email. Please try again.")
        return;
    }
    let phone = document.getElementById("phone").value;
    if (isNaN(phone) || phone.length < 10) {
        window.alert("Invalid phone number. Please Try again.")
        return;
    }
    let bday = document.getElementById("bday").value;
    let color = document.getElementById("color").value;
    let gender = $("input[name='gender']:checked").val();

    let activities = document.getElementsByClassName("activity");
    let choices = [];
    for (i = 0; i < activities.length; i++) {
        if (activities[i].checked) {
            choices.push(activities[i].nextSibling.nodeValue);
        }
    }

    let row = document.createElement("tr");

    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    let cell7 = document.createElement("td");
    let acts = document.createElement("ul");
    for (i = 0; i < choices.length; i++) {
        let item = document.createElement("li");
        item.innerHTML = choices[i];
        acts.appendChild(item);
    }

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    cell7.appendChild(acts);
    row.appendChild(cell7);

    cell1.innerHTML = fname + ' ' + lname;
    cell2.innerHTML = email;
    cell3.innerHTML = phone;
    cell4.innerHTML = bday;
    cell5.innerHTML = color;
    cell6.innerHTML = gender;

    document.getElementsByTagName("table")[0].appendChild(row);
}

//5) Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.
document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
document.getElementsByTagName("details")[0].addEventListener("mouseout", closeDetails);
function openDetails() {
    document.getElementsByTagName("details")[0].open = true;
}
function closeDetails() {
    document.getElementsByTagName("details")[0].open = false;
}

//6) Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
function span() {
    span = document.getElementsByTagName("span");
    str = '';
    for (i = 0; i < span.length; i++) {
        str += span[i].innerHTML;
    }
    console.log(str);
}

//7) Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked.
document.getElementById("earth_time_check").addEventListener("click", earthTime);
function earthTime() {
    let t = new Date();

    let hour;
    let am_pm;
    if (t.getHours() > 12) {
        hour = t.getHours() - 12;
        am_pm = 'PM';
    } else {
        hour = t.getHours();
        am_pm = 'AM';
    }

    let minute;
    if (t.getMinutes() < 10) {
        minute = '0' + t.getMinutes();
    } else {
        minute = t.getMinutes();
    }

    document.getElementById("earth_time").innerHTML = hour + ':' + minute + ' ' + am_pm;
}

//8) Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri Bb if the onset of January 1st, 1970 occured at the same time. Invoke the respective functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. Using an external api to get the orbital period for Alpha Centauri Bb. (try http://www.astropical.space/astrodb/apiref.php) Provide an implementation for getting this value using both AJAX and the fetch API.
document.getElementById("mars_time_check").addEventListener("click", marsTime);
function marsTime() {
    let t = new Date();
    let days = (((t.getTime() / 1000) / 60) / 60) / 24;
    let time = String(1970 + days / 687).split(".");
    let mars_year = time[0];
    let mars_day = String(Number("0." + time[1]) * 687).split(".")[0];

    document.getElementById("mars_time").innerHTML = "Day " + mars_day + " of year " + mars_year;
}

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayTime(xhr) {
    let response = xhr.response;
    let time = JSON.parse(response);
    let acb_day = time.exoplanets[1].per;

    let t = new Date();
    let days = (((t.getTime() / 1000) / 60) / 60) / 24;
    let rel_year = String(1970 + days / acb_day).split(".");
    let acb_year = rel_year[0];
    let acb = String(Number("0." + rel_year[1]) * acb_day).split(".")[0];

    document.getElementById("acb_time").innerHTML = "Day " + acb + " of year " + acb_year;
}

document.getElementById("acb_time_check").addEventListener("click", acbTime);
function acbTime() {
    let url = "http://www.astropical.space/astrodb/api-exo.php?which=distance&limit=2&format=json";
    sendAjaxGet(url, displayTime);
}

//9) Three seconds after a user clicks on the “Intergalactic Directory” heading, the 	background color should change to a random color. Make sure this color is never black so we can still read our black text! (there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)
document.getElementsByTagName("h1")[0].addEventListener("click", changeBackground);

function changeBackground() {
    window.setTimeout(selectColor, 3000);
}

function selectColor() {
    let r = makeDouble((150 + Math.round(Math.random() * 100)).toString(16));
    let g = makeDouble((150 + Math.round(Math.random() * 100)).toString(16));
    let b = makeDouble((150 + Math.round(Math.random() * 100)).toString(16));
    let color = "#" + r + g + b;
    document.getElementsByTagName("body")[0].style.backgroundColor = color;
}

function makeDouble(num) {
    if (String(num).length < 2) {
        return "0" + String(num);
    }
    return num;
}

//10) When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.
document.addEventListener('DOMContentLoaded', checkMath);
function checkMath() {

    let n1 = document.getElementById("n1").value;
    let n2 = document.getElementById("n2").value;
    if (!isNaN(n1) && !isNaN(n2) && n1 !== "" && n2 !== "") {
        switch (document.getElementById("operation").value) {
            case "Add":
                document.getElementById("result").innerHTML = Number(n1) + Number(n2);
                break;
            case "Subtract":
                document.getElementById("result").innerHTML = Number(n1) - Number(n2);
                break;
            case "Divide":
                if (Number(n2) == 0) {
                    document.getElementById("result").innerHTML = "Cannot Divide By Zero";
                } else {
                    document.getElementById("result").innerHTML = Number(n1) / Number(n2);
                }
                break;
            case "Multiply":
                document.getElementById("result").innerHTML = Number(n1) * Number(n2);
                break;
            default:
                document.getElementById("result").innerHTML = "";
                break;
        }
    } else {
        document.getElementById("result").innerHTML = "";
    }
    window.setTimeout(checkMath, 1000 / 100);
}

//11) Define function walkTheDom(node, func) This function should traverse every node in the DOM. Use recursion. On each node, calle func(node).
function walkTheDom(node, func) {
    let children = node.children;
    if (children.length < 1) {
        func(node);
    } else {
        for (let i = 0; i < children.length; i++) {
            walkTheDom(children[i], func);
        }
        func(node);
    }
}

function print(node) {
    console.log(node.nodeName);
}