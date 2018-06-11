// 1. Make each link direct the user to its respective website (see id)

document.getElementsByTagName("a")[0].setAttribute("href", "google.com");
document.getElementsByTagName("a")[1].setAttribute("href", "twitter.com");
document.getElementsByTagName("a")[2].setAttribute("href", "slack.com");
document.getElementsByTagName("a")[3].setAttribute("href", "javadocs.com");


// 2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)

let planets = document.getElementById("planet");
planets.remove(3);


// 3. Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.

function alienText() {
    document.getElementsByTagName("p")[5].removeAttribute("hidden")
}


// 4. When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.

document.getElementById("form-sub").addEventListener("click", function () {
    var verify = true;
    if (document.getElementById("firstname").value.length < 2) {
        verify = false;
    }
    if (document.getElementById("lastname").value.length < 2) {
        verify = false;
    }
    if (!document.getElementById("email").value.includes('@')) {
        verify = false;
    }
    if (!document.getElementById("email").value.endsWith('.com') && !document.getElementById("email").innerText.endsWith('.net') && !document.getElementById("email").innerText.endsWith('.gov')) {
        verify = false;
    }
    if (!(/^[0-9]+$/.test(document.getElementById("phone").value))) {
        verify = false;
    }
    if (document.getElementById("bday").value.length = 0) {
        verify = false;
    }
    if (verify) {
        let firstname = document.getElementById("firstname").value;
        let lastname = document.getElementById("lastname").value;
        let email = document.getElementById("email").value;
        let phone = document.getElementById("phone").value;
        let birthday = document.getElementById("bday").value;
        let gender;
        for (i = 0; i < document.getElementsByName("gender").length; i++) {
            if (document.getElementsByName("gender")[i].checked) {
                gender = document.getElementsByName("gender")[i].value;
            }
        }
        let favoriteColor = document.getElementById("color").value;
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

        cell1.innerHTML = firstname + " " + lastname;
        cell2.innerHTML = email;
        cell3.innerHTML = phone;
        cell4.innerHTML = birthday;
        cell5.innerHTML = favoriteColor;
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


// 5. Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.

document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);

function openDetails() {
    document.getElementsByTagName("details")[0].setAttribute("open", "true");
}

document.getElementsByTagName("details")[0].addEventListener("mouseout", function () {
    document.getElementsByTagName("details")[0].removeAttribute("open");
});



// 6. Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.

function concatSpan() {
    var concat = "";
    for (k = 0; k < document.getElementsByTagName("span").length; k++) {
        concat += document.getElementsByTagName("span")[k].innerHTML;
    }
    console.log(concat);
}
concatSpan();

// 7. Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked. 

document.getElementById("earth_time_check").addEventListener("click", function () {
    document.getElementById("earth_time").innerHTML = new Date();
});

// 8. Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri b if the onset of January 1st, 1970 occured at the same time. Invoke the respective functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. Using an external api to get the orbital period for Alpha Centauri b. (try http://www.astropical.space/astrodb/apiref.php) Provide an implementation for getting this value using both AJAX and the fetch API.

document.getElementById("mars_time_check").addEventListener("click", function () {
    var mDate = new Date();
    var mTime = Math.floor(mDate / 687 * 365);
    mDate.setTime(mTime);
    document.getElementById("mars_time").innerHTML = new Date(mDate);
});
document.getElementById("acb_time_check").addEventListener("click", function () {
    var baseUrlString = "http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf&format=json";
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
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

// 9. Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to a random color. Make sure this color is never black so we can still read our black text! (there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)

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

// 10. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.

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

// 11. Define function walkTheDom(node, func)
// 	This function should traverse every node in the DOM. 
// 	Use recursion. On each node, calle func(node).

