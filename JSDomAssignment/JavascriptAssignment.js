
//1
document.getElementsByName("google")[0].setAttribute("href", "google.com");
document.getElementsByName("twitter")[0].setAttribute("href", "twitter.com");
document.getElementsByName("slack")[0].setAttribute("href", "slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href", "javadocs.com");

//2
document.getElementById("planet").children[3].setAttribute("disabled", true);

//3
function alienText() {
    document.getElementsByTagName("p")[5].removeAttribute("hidden")
}

document.getElementById("planet").addEventListener("click", function () {
    if (document.getElementById("planet").value != "Earth") alienText();
    else {
        document.getElementsByTagName("p")[5].setAttribute("hidden", "hidden");
    }
});

//4
document.getElementById("form-sub").addEventListener("click", function () {
    var allGood = true;
    if (document.getElementById("firstname").value.length < 2) {
        allGood = false;
    }
    if (document.getElementById("lastname").value.length < 2) {
        allGood = false;
    }
    if (!document.getElementById("email").value.includes('@')) {
        allGood = false;
    }
    if (!document.getElementById("email").value.endsWith('.com') && !document.getElementById("email").innerText.endsWith('.net') && !document.getElementById("email").innerText.endsWith('.gov')) {
        allGood = false;
    }
    if (!(/^[0-9]+$/.test(document.getElementById("phone").value))) {
        allGood = false;
    }
    if (document.getElementById("bday").value.length = 0) {
        allGood = false;
    }
    if (allGood) {
        let fname = document.getElementById("firstname").value;
        let lname = document.getElementById("lastname").value;
        let email = document.getElementById("email").value;
        let phone = document.getElementById("phone").value;
        let bday = document.getElementById("bday").value;
        let gender;
        for (i = 0; i < document.getElementsByName("gender").length; i++) {
            if (document.getElementsByName("gender")[i].checked) {
                gender = document.getElementsByName("gender")[i].value;
            }
        }
        let favColor = document.getElementById("color").value;
        let activities = [];
        for (j = 0; j < document.getElementsByClassName("activity").length; j++) {
            if (document.getElementsByClassName("activity")[j].checked) {
                activities.push(document.getElementsByClassName("activity")[j].value);
            }
        }
        let row = document.createElement("tr");
        row.setAttribute("scope", "row");

        let cell1 = document.createElement("td");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");
        let cell4 = document.createElement("td");
        let cell5 = document.createElement("td");
        let cell6 = document.createElement("td");
        let cell7 = document.createElement("td");

        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);
        row.appendChild(cell5);
        row.appendChild(cell6);
        row.appendChild(cell7);

        cell1.innerHTML = fname + " " + lname;
        cell2.innerHTML = email;
        cell3.innerHTML = phone;
        cell4.innerHTML = bday;
        cell5.innerHTML = favColor;
        cell6.innerHTML = gender;
        let listString = `<ul>`;
        for (act of activities) {
            listString += `
            <li>${act.nextSibling.nodevalue}</li>`;
        }
        listString += `</ul>`;
        cell7.innerHTML = listString;

        document.getElementsByTagName("tbody")[0].appendChild(row);

    }



});

//5

document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
function openDetails() {
    document.getElementsByTagName("details")[0].setAttribute("open", "true");
}
document.getElementsByTagName("details")[0].addEventListener("mouseout", function () {
    document.getElementsByTagName("details")[0].removeAttribute("open");
});

//6
function concatSpan() {
    var bigString = "";
    for (k = 0; k < document.getElementsByTagName("span").length; k++) {
        bigString += document.getElementsByTagName("span")[k].innerHTML;
    }
    console.log(bigString);
}

//7
document.getElementById("earth_time_check").addEventListener("click", function () {
    document.getElementById("earth_time").innerHTML = new Date();
});

//8
document.getElementById("mars_time_check").addEventListener("click", function () {
    var marsDate = new Date();
    var marsTime = Math.floor(marsDate / 687 * 365);
    marsDate.setTime(marsTime);
    document.getElementById("mars_time").innerHTML = new Date(marsDate);
});
document.getElementById("acb_time_check").addEventListener("click", function () {
    var baseUrlString = "http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf&format=json";
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        //console.log(xhr.readyState);
        if (this.status == 200 && this.readyState == 4) {
            getAcbTime(this);
        }
    }
    xhr.open("GET", baseUrlString);
    xhr.send();
});
function getAcbTime(xhr) {
    let response = xhr.response;
    let acbResponse = JSON.parse(response);
    let acbPeriod = acbResponse.exoplanets[1].per;
    let curDate = (Math.floor((new Date()) / acbPeriod));
    document.getElementById("acb_time").innerHTML = new Date(curDate);
}

//9
function getRandomColor() {
    var letters = '23456789ABCD';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 12)];
    }
    return color;
}
document.getElementsByTagName("h1")[0].addEventListener("click", function () {
    let start = new Date();
    let waitTil = new Date(start.getTime() + 3000);
    while ((new Date()).getTime() < waitTil) { }
    document.body.style.background = getRandomColor();
});

//10
let n1 = 0, n2 = 0;
document.getElementById("n1").addEventListener("input", function () {
    if ((/^[0-9]+$/.test(document.getElementById("n1").value))) {
        n1 = document.getElementById("n1").value;
    }
    else {
        n1 = 0;
    }
    setResult();
});
document.getElementById("n2").addEventListener("input", function () {
    if ((/^[0-9]+$/.test(document.getElementById("n2").value))) {
        n2 = document.getElementById("n2").value;
    }
    else {
        n2 = 0;
    }
    setResult();
});

function setResult(){
    switch(document.getElementById("operation").value){
        case "Add": 
            document.getElementById("result").innerHTML = Number(n1)+Number(n2);
            break;
        case "Subtract": 
            document.getElementById("result").innerHTML = n1-n2;
            break;
        case "Multiply": 
            document.getElementById("result").innerHTML = n1*n2;
            break;
        case "Divide": 
            document.getElementById("result").innerHTML = n1/n2;
            break;

    }
}

//11
function walkTheDom(node, func){
    for(child of node.children){
        func(child);
        walkTheDom(child,func);
    }
}

function func(child){
    console.log(child);
}