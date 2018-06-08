// Question 1
// getting an element by a name returns an array, so get the first in the array
document.getElementsByName("google")[0].setAttribute("href", "http://www.google.com");
document.getElementsByName("twitter")[0].setAttribute("href", "http://www.twitter.com");
document.getElementsByName("slack")[0].setAttribute("href", "http://www.slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href", "http://www.javadocs.com");

// Question 2
//Get array of options, diable last one
let planets = document.getElementById("planet").children;
planets[planets.length - 1].setAttribute("disabled", true);

//Question 3
function alienText() {
    console.log(document.getElementById("planet").value);
    if (document.getElementById("planet").value !== "Earth") {
        // if not earth, reveal text
        document.getElementsByTagName("p")[5].removeAttribute("hidden");
    } else {
        //if earth, hide text again
        document.getElementsByTagName("p")[5].setAttribute("hidden", true);
    }
}
//set function to button
document.getElementById("form-sub").addEventListener("click", alienText);

// Question 4
function addRow() {
    
    let firstname = document.getElementById("firstname").value;
    //console.log(firstname);
    if(firstname.length < 2) {
        return;
    }
    let lastname = document.getElementById("lastname").value;
    //console.log(lastname);
    if(lastname.length < 2) {
        return;
    }
    let email = document.getElementById("email").value;
    //console.log(email);
    if(!isValidEmail(email)) {
        return;
    }

    let phone = document.getElementById("phone").value;
    //console.log(phone);
    //this assumes a 7 digit number with 3 digit area code
    if(isNaN(phone) || phone.length !== 10) {
        return;
    }

    let birthday = document.getElementById("bday").value;
    //console.log(birthday);
    if(bday === "") {
        return;
    }
    let planet = document.getElementById("planet").value;
    //console.log(planet);
    //there is a default, not check

    let gender = $("input[name='gender']:checked").val();
    console.log(gender);
    if(gender === undefined) {
        return;
    }

    let favoriteColor = document.getElementById("color").value;
    console.log(favoriteColor);
    //there is a default no check
    
    let activities = document.getElementsByClassName("activity");
    let chosenActivities = [];
    for(i = 0; i < activities.length; i++) {
        if(activities[i].checked) {
            chosenActivities.push(activities[i].value);
        }
    }

    let row = document.createElement("tr");
    row.setAttribute("scope", "row");

    let col1 = document.createElement("td");
    col1.innerHTML = firstname + " " + lastname;
    let col2 = document.createElement("td");
    col2.innerHTML = email;
    let col3 = document.createElement("td");
    col3.innerHTML = phone;
    let col4 = document.createElement("td");
    col4.innerHTML = birthday
    let col5 = document.createElement("td");
    col5.innerHTML = favoriteColor;
    let col6 = document.createElement("td");
    col6.innerHTML = gender;
    let col7 = document.createElement("td");
    col7.innerHTML = "<ul>"

    //let actList = document.createElement(ul);
    for(i = 0; i < chosenActivities.length; i++) {
        col7.innerHTML += "<li>" +chosenActivities[i] + "</li>";
    }
    col7.innerHTML += "</ul>";


    row.appendChild(col1);
    row.appendChild(col2);
    row.appendChild(col3);
    row.appendChild(col4);
    row.appendChild(col5);
    row.appendChild(col6);
    row.appendChild(col7);
    document.getElementsByTagName("tbody")[0].appendChild(row);

}
document.getElementById("form-sub").addEventListener("click", addRow);

function isValidEmail(str) {
    let a = str.lastIndexOf("@");
    let d = str.lastIndexOf(".");

    if ((a > -1 && d > -1) && (a<d) && (d-a > 1) && (str.length-d > 1)){
        return true;
    }
    return false;
}


// Question 5

function openDetails() {
    document.getElementsByTagName("details")[0].open = true;
}
function closeDetails() {
    document.getElementsByTagName("details")[0].open = false;
}

//event for when moused over
document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
//event for when removed from area
document.getElementsByTagName("details")[0].addEventListener("mouseout", closeDetails);


// Question 6
function printSpans() {
    let str = "";
    let spans = document.getElementsByTagName("span");
    for(i = 0; i < spans.length; i++) {
        str += spans[i].innerHTML;
    }
    console.log(str);
}

// Question 7 
function showEarthTime() {
    let time = new Date();
    document.getElementById("earth_time").innerHTML = time;//doubleDigits(time.getHours()) + ":" + doubleDigits(time.getMinutes()) + ":" + doubleDigits(time.getSeconds());
    //Set timeout to call this 30 times a second and update the time regularly
    window.setTimeout(showEarthTime, 1000 / 30);
}

document.getElementById("earth_time_check").addEventListener("click", showEarthTime);



// Question 8

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
    let info = JSON.parse(response);
    //console.log(info);
    let period = info.exoplanets[1].per;
    //console.log(period);


    let time = new Date();
    let milli = time.getTime();
    let seconds = milli/1000;
    let minutes = seconds/60;
    let hours = minutes/60;
    let days = hours/24;

    let acbTime = String(1970+days/period).split(".");
    let acbYear = acbTime[0];
    let acbDay = String(Number("0." + acbTime[1]) * period).split(".")[0];
    document.getElementById("acb_time").innerHTML = "Day " + acbDay + " of year " + acbYear;
}
document.getElementById("acb_time_check").addEventListener("click", showAlphaTime);

function showMarsTime() {
    //687
    let time = new Date();
    let milli = time.getTime();
    let seconds = milli/1000;
    let minutes = seconds/60;
    let hours = minutes/60;
    let days = hours/24;
    
    let marsTime = String(1970+days/687).split(".");
    let marsYear = marsTime[0];
    let marsDay = String(Number("0." + marsTime[1]) * 687).split(".")[0];
    //console.log(marsYear + " " + marsDay);
    document.getElementById("mars_time").innerHTML = "Day " + marsDay + " of year " + marsYear;
}

document.getElementById("mars_time_check").addEventListener("click", showMarsTime);

// Question 9
function changeColorInThreeSeconds() {
    window.setTimeout(changeColor, 3000);
}

document.getElementsByTagName("h1")[0].addEventListener("click", changeColorInThreeSeconds);

function changeColor() {
    let r = doubleDigits((Math.round(Math.random() * 150)).toString(16));
    let g = doubleDigits((Math.round(Math.random() * 150)).toString(16));
    let b = doubleDigits((Math.round(Math.random() * 150)).toString(16));
    let myColor = "#" + r + g + b;
    console.log(myColor);
    document.getElementsByTagName("body")[0].style.backgroundColor = myColor;
}

//makes sure that if the digit is less than 10, it will add a zero to the beginning of it
function doubleDigits(num) {
    if(String(num).length < 2) {
        return "0"+String(num);
    } 
    return num;
}

// Question 10
//there's no submit button, so just check every 30 frames a second once the DOM content loads 
document.addEventListener('DOMContentLoaded', checkMath);

function checkMath() {
    
    let x = document.getElementById("n1").value;
    let y = document.getElementById("n2").value;
    if(!isNaN(x) && !isNaN(y) && x !== "" && y !=="") {
        switch (document.getElementById("operation").value) {
        case "Add":
            document.getElementById("result").innerHTML = Number(x)+Number(y);
            break;
        case "Subtract":
            document.getElementById("result").innerHTML = Number(x)-Number(y);
            break;
        case "Divide":
            if(Number(y) === 0) {
                document.getElementById("result").innerHTML = "Can't Divide By Zero";
            } else {
                document.getElementById("result").innerHTML = Number(x)/Number(y);
            }
            break;
        case "Multiply":
            document.getElementById("result").innerHTML = Number(x)*Number(y);
            break;
        default:
        }
    } else {
        
        document.getElementById("result").innerHTML = "";
    }

    window.setTimeout(checkMath, 1000/30);
}

// Question 11
//This is a depth first tree traversal
function walkTheDom(node, func) {
    let kids = node.children;
    if(kids.length < 1) {
        func(node);
    } else {
        for(let i = 0; i < kids.length; i++) {
            walkTheDom(kids[i], func);
        }
        func(node);
    }
}

function printNode(node){
    console.log(node);
}

// call walkTheDom(document, printNode) to see the traversal