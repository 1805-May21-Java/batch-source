// Redirect Click Here links

document.getElementsByName("google")[0].setAttribute("href", "http://google.com");
document.getElementsByName("twitter")[0].setAttribute("href", "http://twitter.com");
document.getElementsByName("slack")[0].setAttribute("href", "http://slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href", "https://docs.oracle.com/javase/8/");

// Remove Pluto from residence dropdown
for(x of document.getElementById("planet").children){
    if(x.value == "Pluto"){
        x.remove();
    }
}

// Show alien text whenever anything but Earth is selected
function alienText(){
    // Get the element of the alien text
    p = document.getElementsByTagName("p")[0];
    for(x of document.getElementsByTagName("p")){
        if(x.value = "Beep boop"){
            p = x;
        }
    }

    // Set hidden attribute if Earth is selected, remove it otherwise
    if(document.getElementById("planet").value != "Earth"){
        p.removeAttribute("hidden");
    }
    else{
        p.setAttribute("hidden", true);
    }
}

document.getElementById("planet").addEventListener("change", alienText);

// Submit new row to the table

document.getElementById("form-sub").addEventListener("click", addRow);

// Email validation via regex
function validateEmail(string){
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(string).toLowerCase());
}

// Phone number validation via regex that supports all commonly used forms
function validatePhone(string){
    var phoneno = /^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$/im;
    return phoneno.test(string);
}

// Name validation to ensure both first and last name are alphabetical and at least 2 letters long
function validateName(string){
    var namere = /^[a-zA-Z]+[-']?[a-zA-Z]+\s[a-zA-Z]+[-']?[a-zA-Z]+$/;
    return namere.test(string);
}

// Takes a default date string and reformats it to MM/dd/yyyy
function reformatDate(string){
    stringArr = string.split("-");
    return (stringArr[1] + "/" + stringArr[2] + "/" + stringArr[0]);
}

// Applies validations to all necessary fields and adds row to the HTML table if all entries pass validation
function addRow(){
    let row = document.createElement("tr");
    let cell1 = document.createElement("td");
    let cell2 = document.createElement("td");
    let cell3 = document.createElement("td");
    let cell4 = document.createElement("td");
    let cell5 = document.createElement("td");
    let cell6 = document.createElement("td");
    let cell7 = document.createElement("td");

    ul = document.createElement("ul");
    cell7.appendChild(ul);

    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    row.appendChild(cell6);
    row.appendChild(cell7);

    // Get input data from fields
    cell1.innerHTML=document.getElementById("firstname").value;
    cell1.innerHTML+=" " + document.getElementById("lastname").value;
    cell2.innerHTML=document.getElementById("email").value;
    cell3.innerHTML=document.getElementById("phone").value;
    cell4.innerHTML=reformatDate(document.getElementById("bday").value);
    cell5.innerHTML=document.getElementById("color").value;
    for(x of document.getElementsByName("gender")){
        if(x.checked){
            cell6.innerHTML=x.nextSibling.nodeValue;
        }
    }
    for(x of document.getElementsByClassName("activity")){
        if(x.checked){
            newLi = document.createElement("li");
            newLi.innerHTML = x.nextSibling.nodeValue;
            ul.appendChild(newLi);
        }
    }

    // If row is valid, add it
    if(validateName(cell1.innerHTML) && validateEmail(cell2.innerHTML) && validatePhone(cell3.innerHTML) && cell4.innerHTML && cell6.innerHTML){
        document.getElementsByTagName("tbody")[0].appendChild(row);
    }
}

// Intergalactic Bob Ross is the almighty creator of our world

function bobRoss(){
    spanArr = document.getElementsByTagName("span");
    str = "";
    for(x of spanArr){
        str += x.innerHTML;
    }
    console.log(str);
}

// May your clouds be fluffy, and your mistakes be happy accidents
bobRoss();

// Earth time

document.getElementById("earth_time_check").addEventListener("click", earthDate);

// Toggle Earth time in the earth_time element
function earthDate(){
    let earth_time = document.getElementById("earth_time");

    // If the time is already there, toggle it off
    if(earth_time.innerHTML){
        earth_time.innerHTML = "";
    }
    // Otherwise, show it
    else{
        now = new Date();
        var pad = "00";
        var str = "" + now.getHours();
        var hours = pad.substring(0, pad.length - str.length) + str;
        str = "" + now.getMinutes();
        var mins = pad.substring(0, pad.length - str.length) + str;
        earth_time.innerHTML = hours + ":" + mins;
    }
}

// Time to get more times

document.getElementById("mars_time_check").addEventListener("click", marsDate);
document.getElementById("acb_time_check").addEventListener("click", ()=>{sendAjaxGet("http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf%20Cen%20B%20b&format=json",acbDate)});

// Send the get request to the url via AJAX XHR
function sendAjaxGet(url, func){
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        if(xhr.status == 200 && xhr.readyState == 4){
            func(xhr);
        }
    }

    xhr.open("GET",url);
    xhr.send();
}

// Shows years, days, and time passed on Mars since 1970, assuming
// Mars days are the same as Earth days and a Mars year is 687 Earth days
function marsDate(){
    let mars_time = document.getElementById("mars_time");

    // If time is already there, toggle it off
    if(mars_time.innerHTML){
        mars_time.innerHTML = "";
    }
    // Otherwise, show it
    else{
        var now = new Date();
        var pad = "00";
        var str = "" + now.getHours();
        var hours = pad.substring(0, pad.length - str.length) + str;
        str = "" + now.getMinutes();
        var mins = pad.substring(0, pad.length - str.length) + str;

        var totalDays = Math.floor(Date.now()/1000/60/60/24);
        var years = Math.floor(totalDays/687);
        var days = totalDays%687;
        mars_time.innerText = years + " years, " + days + " days, " + hours + ":" + mins + " (since 1/1/1970 on Earth)";
    }
}

// Shows years, days, and time passed on Alpha Centauri Bb since 1970, assuming
// ACB days are the same as Earth days and the length of a year is the given value from the JSON element
function acbDate(xhr){
    let acb_time = document.getElementById("acb_time");

    // If time is already there, toggle it off
    if(acb_time.innerHTML){
        acb_time.innerHTML = "";
    }
    // Otherwise, show it
    else{
        var now = Number(Date.now());
        var acb = JSON.parse(xhr.responseText);
        var acb_year = Number(acb.exoplanets[0].per);

        var totalDays = now/1000/60/60/24;
        var years = Math.floor(totalDays/acb_year);
        var days = totalDays%acb_year;

        var pad = "00";
        var str = "" + Math.floor((days%1) * 24);
        var hours = pad.substring(0, pad.length - str.length) + str;
        str = "" + Math.floor((((days%1) * 24)%1) * 60);
        var mins = pad.substring(0, pad.length - str.length) + str;

        acb_time.innerText = years + " years, " + Math.floor(days) + " days, " + hours + ":" + mins + " (since 1/1/1970 on Earth)";
    }
}

// Three seconds to liftoff (random color background)

document.getElementsByTagName("h1")[0].addEventListener("click", ()=>setTimeout(changeBGColor, 3000));

// Change background color to a random color
function changeBGColor(){
    // Random hexcode for a color
    let color = "#" + Math.floor(Math.random() * 16777215).toString(16);

    // Choose a new color while the color is sufficiently dark
    while(color.charAt(1)<2 && color.charAt(3)<2 && color.charAt(5)<2){
        color = "#" + Math.floor(Math.random() * 16777215).toString(16);
    }

    head = document.getElementsByTagName("head")[0];
    style = document.createElement("style");
    style.innerHTML = "body{\nbackground-color: " + color + "\n}";
    head.appendChild(style);
}

// Calculator

document.getElementById("operation").addEventListener("change", calculate);
document.getElementById("n1").addEventListener("change", calculate);
document.getElementById("n2").addEventListener("change", calculate);

// Checks the input in n1 and n2 fields, calculates the result based on the inputs and operation
function calculate(){
    let regex = /^[0-9]*[.]?[0-9]+$/;
    let n1 = document.getElementById("n1").value;
    let n2 = document.getElementById("n2").value;
    if(regex.test(n1) && regex.test(n2)){
        let operation = document.getElementById("operation").value;
        let result = document.getElementById("result");
        if(operation == "Add"){
            result.innerHTML = n1 - -n2;
        }
        else if(operation == "Subtract"){
            result.innerHTML = n1 - n2;
        }
        else if(operation == "Multiply"){
            result.innerHTML = n1 * n2;
        }
        else if(operation == "Divide"){
            result.innerHTML = n1 / n2;
        }
    }
}

// Walk the DOM

// Calls a private, recursive function which executes func at every node, depth first
let walkTheDom = function walk(node, func, i){
    i++;
    for(child of node.children){
        func(i);
        walk(child, func, i);
    }
}

// Could be anything we want to happen at each node
// Specifically, this logs the depth of the node in the html tree structure
function nodeFunc(i){
    console.log(i);
}

walkTheDom(document.getElementsByTagName("html")[0], nodeFunc, 0);