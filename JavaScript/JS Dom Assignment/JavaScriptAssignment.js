/**
 * Make each link direct the user to its respective website (see id)
 */

// Grabs all the <a> elements and puts them in an array links
let links = document.getElementsByTagName("a");
// For each link in the links array, set the href to that website and set the text viewed to the name of the website
for (link of links) {
    link.href = `https://${link.name}.com`
    link.innerHTML = link.name;
}

/**
 * Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
 */
// Grabs all the option elements from the tag with id "planet" and puts them in an array links
let options = document.getElementById("planet").getElementsByTagName("option");

// Loops through to find the one that says "Pluto", and then removes it
for (option of options) {
    if (option.innerHTML == "Pluto") {
        option.disabled = true;
        break;
    }
}

/**
 * Define a function alienText() which shows the hidden element displaying an alien message.
 * When any planet other than Earth is selected, execute this function.
 */

document.getElementById("planet").onclick = () => {
    let paras = document.getElementsByTagName("p");
    let alien;
    let selectedO
    for (para of paras) {
        if (para.innerHTML == "Beep boop") {
            alien = para;
            break;
        }
    }
    for (option of options) {
        if (option.selected == true) {
            selectedO = option;
            break;
        }
    }
    if (selectedO.innerHTML == "Earth") {
        alien.hidden = true;
    }
    else {
        alien.hidden = false;
    }
}

/**
 * When the submit button is pressed, get the values from all of the input into a new row in the table below.  
 * Make sure no input is empty, check that first and last name are at least two letters each. 
 * Validate for valid phone number and email structure. This should continue to work for multiple entries and rows
 */
document.getElementById("form-sub").onclick = () => {
    let allGood = true;

    let first = document.getElementById("firstname").value
    let last = document.getElementById("lastname").value
    let email = document.getElementById("email").value
    let phone = document.getElementById("phone").value
    let bday = document.getElementById("bday").value
    let color = document.getElementById("color").value
    let gender;
    let activites = [];

    for (g of document.getElementsByName("gender")) {
        if (g.checked == true) {
            gender = g.value
        }
    }

    for (activity of document.getElementsByClassName("activity")) {
        if (activity.checked == true) {
            if (activity.value == "basket") {
                activites.push("underwater basket weaving")
            }
            else {
                activites.push(activity.value)
            }
        }
    }

    let alerts = [];

    if (first.length < 2 | first == "" | first.trim().length == 0) {
        alerts.push("First Name")
        allGood = false;
    }

    if (last.length < 2 | last == " " | last.trim().length == 0) {
        alerts.push("Last Name")
        allGood = false;
    }

    if (isValidEmail(email) == false) {
        alerts.push("Email")
        allGood = false;
    }

    if (phone.length < 10) {
        alerts.push("Phone")
        allGood = false;
    }
    else if (phone * 1 == NaN) {
        alerts.push("Phone")
        allGood = false;
    }

    if (bday.trim().length == 0) {
        alerts.push("Birthday")
        allGood = false;
    }

    if (gender == undefined) {
        alerts.push("Gender")
        allGood = false;
    }

    if (allGood) {
        let name_data = document.createElement("td")
        name_data.innerHTML = first + " " + last
        let email_data = document.createElement("td")
        email_data.innerHTML = email
        let phone_data = document.createElement("td")
        phone_data.innerHTML = phone
        let bday_data = document.createElement("td")
        bday_data.innerHTML = bday
        let gender_data = document.createElement("td")
        gender_data.innerHTML = gender
        let color_data = document.createElement("td")
        color_data.innerHTML = color

        let activities_data = document.createElement("td")
        let newUl = document.createElement("ul")
        for (activity of activites) {
            let newLi = document.createElement("li")
            newLi.innerHTML = activity
            newUl.appendChild(newLi)
        }
        activities_data.appendChild(newUl)

        let newRow = document.createElement("tr")
        newRow.appendChild(name_data)
        newRow.appendChild(email_data)
        newRow.appendChild(phone_data)
        newRow.appendChild(bday_data)
        newRow.appendChild(gender_data)
        newRow.appendChild(color_data)
        newRow.appendChild(activities_data)

        let theTable = document.getElementsByTagName("table")
        theTable[0].appendChild(newRow)
    }
    else {
        for (al of alerts) {
            alert("Error with " + al)
        }
    }
}

/**
 * Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. 
 * The details should be hidden when the mouse is removed from the summary.
*/
let details = document.getElementsByTagName("details")
details[0].addEventListener("mouseover", openDetails);
details[0].addEventListener("mouseout", closeDetails)

function openDetails() {
    details[0].open = true
}

function closeDetails() {
    details[0].open = false
}

/**
 * Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
 */

function concatInner() {
    let span = document.getElementsByTagName("span")
    let concat = "";
    for (s of span) {
        concat += s.innerHTML
    }
}

/**
 * Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked
 */

let earth_time_button = document.getElementById("earth_time_check")
earth_time_button.addEventListener("click", getEarthTime)

function getEarthTime() {
    let today = new Date()
    let hour = today.getHours()
    let min = today.getMinutes()
    document.getElementById("earth_time").innerHTML = hour + ":" + min
}

/**
 * Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri Bb if the onset of January 1st, 1970 occured at the same time. 
 * Invoke the respective functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. 
 * Using an external api to get the orbital period for Alpha Centauri Bb. (try http://www.astropical.space/astrodb/apiref.php) 
 * Provide an implementation for getting this value using both AJAX and the fetch API.
 */

let acbUrl = "http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf cen b b&format=json";
let alp_cen_bb_button = document.getElementById("acb_time_check")
alp_cen_bb_button.addEventListener("click", getPeriod2)

function getACBB() {
    sendAjaxGet(acbUrl, getPeriod)
}

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest());
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function getPeriod(xhr) {
    let response = xhr.response;
    response = JSON.parse(response);
    let mul = parseInt(365 * response.exoplanets[0].per)
    document.getElementById("acb_time").innerHTML = mul + (new Date().getTime())
}

function getPeriod2() {
    fetch(acbUrl)
        .then((response) => response.json())
        .then(function (response) {
            let mul = parseInt(365 * response.exoplanets[0].per)
            document.getElementById("acb_time").innerHTML = mul + (new Date().getTime())
        });
}

document.getElementById("mars_time_check").addEventListener("click", getMars)
function getMars() {
    document.getElementById("mars_time").innerHTML = 687 + (new Date().getTime())
}

/**
 * Three seconds after a user clicks on the “Intergalactic Directory” heading, the 	background color should change to a random color. 
 * Make sure this color is never black so we can still read our black text! 
 * (there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)
 */

let h4s = document.getElementsByTagName("h4")
let intergalactic_dir;
for (var i=0;i<h4s.length;i++){
    if(h4s[i].innerHTML=="Welcome to the Intergalactic Directory."){
        intergalactic_dir=h4s[i];
        break;
    }
}

console.log(intergalactic_dir)

intergalactic_dir.addEventListener("click", callChangeColor)

function callChangeColor(){
    setTimeout(changeColor, 3000)
}

function changeColor(){
    document.body.style.background=document.body.style.backgroundColor = 'rgb(' + getNum() + ',' + getNum() + ',' + getNum() + ')';
}

function getNum(){
    return Math.floor((Math.random() * 256) + 0);
}

/**
 * When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. 
 * Display the result in the element with id result.
 */

let n1=document.getElementById("n1")
let n2=document.getElementById("n2")
let selector=document.getElementById("operation")

n1.addEventListener("input",doMath)
n2.addEventListener("input", doMath)
selector.addEventListener("change", doMath)

function doMath(){
    if(n1.value!="" & n1.value*1!=NaN & n2.value!="" & n2.value*1!=NaN){
        let operation
        for(option of selector){
            if(option.selected==true){
                operation=option.value
            }
        }
        console.log(operation)
        switch(operation){
            case "Add":
            document.getElementById("result").innerHTML=(n1.value*1)+(n2.value*1)
            break
            case "Subtract":
            document.getElementById("result").innerHTML=(n1.value*1)-(n2.value*1)
            break
            case "Multiply":
            document.getElementById("result").innerHTML=(n1.value*1)*(n2.value*1)
            break
            case "Divide":
            if(n2.value*1==0){
                document.getElementById("result").innerHTML="Cannot divide by 0"
            }
            else{
                document.getElementById("result").innerHTML=(n1.value*1)/(n2.value*1)
            }
        }
    }
}

/**
 * Define function walkTheDom(node, func)
	This function should traverse every node in the DOM. 
	Use recursion. On each node, calle func(node)
 */

 function walkTheDom(node, func){
     console.log(node)
     let children=node.childNodes
     if(children.length>0){
         children.forEach((child)=>{
             func(child, walkTheDom)
         })
     }
 }

 function walkTheDOM(node, func){
     console.log(node)
     let children=node.childNodes
     if(children.length>0){
         children.forEach((child)=>{
             func(child, walkTheDOM)
         })
     }
 }

function isValidEmail(email) {
    if (email.last < 4) {
        return false
    }
    else if (email[0] == "@" || email[0] == "." || !email.includes("@") || !email.includes(".") || /\s/g.test(email)) {
        return false;
    }
    else if (email.indexOf(".") == email.length - 1) {
        return false;
    }
    else if (email.substring(email.indexOf("@"), email.indexOf(".")) == false) {
        return false;
    }
    else {
        return true;
    }
}
