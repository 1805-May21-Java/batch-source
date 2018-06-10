
// 1. add links
document.getElementsByName("google")[0].setAttribute("href", "https://www.google.com");
document.getElementsByName("twitter")[0].setAttribute("href", "https://twitter.com");
document.getElementsByName("slack")[0].setAttribute("href", "https://slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href", "https://javadocs.com");


// 2. disable Pluto as a planet option
document.getElementById("planet")[3].disabled = true;


// 3. shows alien message if planet other than Earth is picked
document.getElementById("planet").addEventListener("change", alienText);

function alienText(params) {
    var hiddenElem = document.querySelectorAll("p[hidden]");
    if (hiddenElem[0]) { // check if hidden attribute still exists
        hiddenElem[0].removeAttribute("hidden");
    } 
}


// 4. get input values from form and add to table
document.getElementById("form-sub").addEventListener("click", add);

function isValidEmail(string) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(string);
}

// from https://www.w3resource.com/javascript/form/phone-no-validation.php
function isValidPhone(string) {
    var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    var tendigits = /^\d{10}$/
    return (phoneno.test(string)) || (tendigits.test(string));
}

function add() {
    // get all elements from form
    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bday = document.getElementById("bday").value;
    let planet = document.getElementById("planet").value;
    let color = document.getElementById("color").value;

    // check all radio buttons to find selected one
    let genders = document.getElementsByName("gender");
    var gender;
    for (var i=0; i<genders.length; i++) {
        if (genders[i].checked) {
            gender = genders[i].value;
        }
    }

    // check all checkboxes for selected ones
    let activities = document.getElementsByClassName("activity");
    var myActivity = [];
    for (var i=0; i<activities.length; i++) {
        if (activities[i].checked) {
            myActivity.push(activities[i].nextSibling.nodeValue);
        }
    }

    // validations, make sure all values are present
    if (firstname.length >= 2 && lastname.length >= 2 && isValidEmail(email) && isValidPhone(phone) && bday && planet && color && gender && myActivity) {
        console.log("good to go!");
        //create table row
        let row = document.createElement("tr");

        // create cells for the row
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

        // add input info into cells
        cell1.innerHTML = firstname + " " + lastname;
        cell2.innerHTML = email;
        cell3.innerHTML = phone;
        cell4.innerHTML = bday;
        cell5.innerHTML = color;
        cell6.innerHTML = gender;

        // insert all activities as unordered list
        str = "<ul>";
        for (var i=0; i<myActivity.length; i++) {
            str = str + "<li>" + myActivity[i] + "</li>"; 
        }
        str = str + "</ul>";
        cell7.innerHTML = str;


        // find table and add row
        document.getElementsByTagName("table")[0].appendChild(row);
    } 
}


// 5. open the details element on mouseover
document.getElementsByTagName("summary")[0].addEventListener("mouseover", openDetails); // when summary is moused over
document.getElementsByTagName("summary")[0].addEventListener("mouseout", closeDetails); // when mouse is removed from summary

function openDetails() {
    document.getElementsByTagName("details")[0].open = true;
}

function closeDetails() {
    document.getElementsByTagName("details")[0].open = false;
}


// 6. concatenate inner HTML
var spans = document.getElementsByTagName("span");
var str = "";
for (let i=0; i<spans.length; i++) {
    str += spans[i].innerHTML;
}
console.log(str);


// 7. display Earth time
document.getElementById("earth_time_check").addEventListener("click", displayEarthTime);

function displayEarthTime() {
    var time = new Date().toLocaleTimeString(); // convert timestamp into string
    document.getElementById("earth_time").innerHTML = time;
}


// 8. Mars and Alpha Centauri Bb times


// 9. set random background color
document.getElementsByTagName("h1")[0].addEventListener("click", pause);

function pause(){
    setTimeout(changeColor, 3000); // pause execution for 3 seconds
}

function changeColor() {
    let color = '#' + ((Math.random() + 0.2).toString(16) + "000000").substring(2,8); // the +0.2 keeps the colors from being pure black or too dark
    // toString(16) converts number to hex
    document.getElementsByTagName("body")[0].setAttribute("style","background-color:" + color);
}


// 10. perform calculator operations
var n1;
var n2;

// start calculation on any of these events
document.getElementById("operation").addEventListener("change", setOperation);
document.getElementById("n1").addEventListener("change", setOperation);
document.getElementById("n2").addEventListener("change", setOperation);

function setOperation() {
    let option = document.getElementById("operation").value;
    n1 = parseInt(document.getElementById("n1").value);
    n2 = parseInt(document.getElementById("n2").value);

    if (!isNaN(n1) && !isNaN(n2)) { // make sure n1 and n2 are numbers

        if (option == "Subtract") {
            document.getElementById("result").innerHTML = n1 - n2;
        } else if (option == "Add") {
            document.getElementById("result").innerHTML = n1 + n2;
        } else if (option == "Multiply") {
            document.getElementById("result").innerHTML = n1 * n2;
        } else {
            document.getElementById("result").innerHTML = n1 / n2;
        }
    }
}


// 11. traverse every node in the DOM
walkTheDom(document, func);

function walkTheDom(node, func) {
    func(node); // print out current node
    node = node.firstChild; // get next node
    while (node) { // do as long as more child nodes exist
        walkTheDom(node, func); // recursion!
        node = node.nextSibling; // move to next sibling node once there are no more child nodes
    }
}

// print out every node encountered
function func(node) {
    //console.log(node.nodeName);
}



