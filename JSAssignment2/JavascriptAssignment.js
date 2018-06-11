/**
 * 1. Make each link direct the user to its respective website (see id)
 */

function setLinks() {
    var link = document.getElementsByName("google")[0];
    link.setAttribute("href", "http://www.google.com");
    link.innerHTML = "Google";
    link = document.getElementsByName("twitter")[0];
    link.setAttribute("href", "http://www.twitter.com");
    link.innerHTML = "Twitter";
    link = document.getElementsByName("slack")[0];
    link.setAttribute("href", "http://www.slack.com");
    link.innerHTML = "Slack";
    link = document.getElementsByName("javadocs")[0];
    link.setAttribute("href", "https://docs.oracle.com/en/java/");
    link.innerHTML = "Java Documentation";
}

/**
 * 2. Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
 */

function disablePluto() {
    var parent = document.getElementById("planet");
    var options = parent.childNodes;
    parent.removeChild(options[8]);
    parent.removeChild(options[7]);    
}

/**
 * 3. Define a function alienText() which  shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.
 */

function alienText() {
    let select = document.getElementById("planet");
    let main = document.getElementsByClassName("container")[0];
    let children = main.children;
    let child = children[11];
    let content = child.innerHTML;
    let newChild = document.createElement("p");
    newChild.innerHTML = content;
    newChild.style.visibility = "hidden";
    main.replaceChild(newChild, child);

    select.addEventListener("change", function() {
        let child = document.getElementsByClassName("container")[0].children[11];

        console.log("Event Fired");
        if (this.value === "Earth") {
            console.log("Earth");
            child.style.visibility = "hidden";
        } else {
            console.log("Not Earth");
            child.style.visibility = "visible";
        }
    });
}

 /**
4. When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.
*/

function storeInput() {
    let submit = document.getElementById("form-sub");
    submit.addEventListener("click", function() {
        let input = getAllFormInput();
        console.log(input);
        let valid = allFormInputValid(input);
        if (valid) {
            console.log("all valid");
            addRowToTable(input);
        } else {
            showErrorMessage();
        }
    });
}

function getAllFormInput() {
    let form = document.getElementsByClassName("form-group")[0];
    let inputs = form.getElementsByTagName("input");
    let info = {};
    info.activities = [];
    info.gender = "";
    for (var i = 0; i < inputs.length; i++) {
        let input = inputs[i];
        let inputId = input.getAttribute("id");
        switch (inputId) {
            case "firstname":
                info.firstname = input.value;
                break;
            case "lastname":
                info.lastname = input.value;
                break;
            case "email":
                info.email = input.value;
                break;
            case "phone":
                info.phone = input.value;
                break;
            case "bday":
                info.bday = input.value;
                break;
            case "color":
                info.color = input.value;
                break;
            default:
                if (input.getAttribute("name") == "gender" && input.checked == true) {
                    info.gender = input.value;
                } else if (input.className == "activity" && input.checked == true) {
                    info.activities.push(input.value);
                }
        }
    }
    let select = form.getElementsByTagName("select")[0];
    info.planet = select.value;

    return info;
}

function allFormInputValid(input) {
    
    for (i in input) {
        if (!input[i]) {
            console.log("empty fields")
            return false;
        }
    }
    
    if (!(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/.test(input.email))) {
        console.log("email incorrect");
        return false;
    }
   
    if (!(/(?<!\d)\d{10}(?!\d)$/.test(input.phone))) {
        console.log("phone incorrect");
        return false;
    }

    return true;
}

function addRowToTable(input) {
    let actString = "";
    for (i in input.activities) {
        actString += `<li>${input[i]}</li>`;
    }
    let row = document.createElement("tr");
    row.setAttribute("scope", "row");
    let rowString = 
        `<td>${input.firstname + " " + input.lastname}</td>
        <td>${input.email}</td>
        <td>${input.phone}</td>
        <td>${input.bday}</td>
        <td>${input.color}</td>
        <td>${input.gender}</td>
        <td><ul>${actString}</ul></td>`;
    
    row.innerHTML = rowString;
    let tableBody = document.getElementsByTagName("tbody")[0];

    tableBody.appendChild(row);
}

function showErrorMessage() {
    console.log("Input Not of Correct Form");
}

/*
5. Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.
*/

function openDetails() {
    let detailsElements = document.getElementsByTagName("details");

    for (let i = 0; i < detailsElements.length; i++) {
        detailsElements[i].addEventListener("mouseover", function() {
            this.open = true;
        });
        detailsElements[i].addEventListener("mouseleave", function() {
            this.open = false;
        });
    }
}


/*
6. Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
*/

function printSpans() {
    let spans = document.getElementsByTagName("span");
    let secret = "";
    for (let i = 0; i < spans.length; i++) {
        secret += spans[i].innerHTML;
    }
    console.log(secret);
}

/*
7. Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked. 
*/

function showCurrentTime() {
    let timeSpan = document.getElementById("earth_time");
    let timeBtn = document.getElementById("earth_time_check");
    timeBtn.addEventListener("click", function() {
        let dt = new Date();
        timeSpan.innerHTML = getFormattedDateString(dt);
    });
}

function getFormattedDateString(dt) {
    return `${dt.getUTCDate()}/${dt.getUTCMonth() + 1}/${dt.getUTCFullYear()}:  ${dt.getUTCHours()}h ${dt.getUTCMinutes()}m ${dt.getUTCSeconds()}s`;
}

/*
8. Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri b if the onset of January 1st, 1970 occured at the same time. Invoke the respective functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. Using an external api to get the orbital period for Alpha Centauri b. (try http://www.astropical.space/astrodb/apiref.php) Provide an implementation for getting this value using both AJAX and the fetch API.
*/

function showNonEarthTimes() {
    let marsBtn = document.getElementById("mars_time_check");
    let marsSpan = document.getElementById("mars_time");
    let acBbBtn = document.getElementById("acb_time_check");
    let acBbSpan = document.getElementById("acb_time");

    marsBtn.addEventListener("click", function() {
        let marsMultiplier = 365.25 / 687;
        let earthDate = new Date();
        let earthTime = earthDate.getTime();
        let marsTime = earthTime * marsMultiplier;
        let marsDate = new Date(marsTime);
        marsSpan.innerHTML = getFormattedDateString(marsDate);
    });

    acBbBtn.addEventListener("click", function() {
        let acBbMultiplier = 365.25 / acBbOrbitalPeriodAJAX;
        let earthDate = new Date();
        let earthTime = earthDate.getTime();
        let acBbTime = earthTime * acBbMultiplier;
        console.log(acBbMultiplier);
        let acBbDate = new Date(acBbTime);
        acBbSpan.innerHTML = getFormattedDateString(acBbDate);
    });
}

function getacBbOrbitalPeriodAJAX() {
    let url = `http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf Cen&format=json`;
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function() {
        if (this.status == 200 && this.readyState == 4) {
            setacBbOrbitalPeriod(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function setacBbOrbitalPeriod(xhr) {
    let response = JSON.parse(xhr.response);
    let orbitalPeriod = response.exoplanets[0].per;
    acBbOrbitalPeriodAJAX = Number(orbitalPeriod);
    console.log(acBbOrbitalPeriodAJAX);
}

function getacBbOrbitalPeriodFetch() {
    let url = `http://www.astropical.space/astrodb/api-exo.php?which=name&limit=alf Cen&format=json`;
    fetch(url).then(function(response) {
        return response.json();
    }).then(function(json) {
        let oPStr = json.exoplanets[0].per;
        acBbOrbitalPeriodFetch = Number(oPStr);
        console.log(acBbOrbitalPeriodFetch);
    });
}

/*
9. Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to a random color. Make sure this color is never black so we can still read our black text! (there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)
*/

function bgColorOnTitleClick() {
    let title = document.getElementsByTagName("h1")[0];

    title.addEventListener("click", changeBackgroundToRandom);
}

function changeBackgroundToRandom() {
    let r = Math.floor(Math.random() * 127) + 128;
    let g = Math.floor(Math.random() * 127) + 128;
    let b = Math.floor(Math.random() * 127) + 128;

    let colorDec = r*256*256 + g*256 + b;
    let colorStr = colorDec.toString(16);
    let hexCode =`#${colorStr}`;
    console.log(hexCode);

    setTimeout(function() {
        document.body.style.backgroundColor = hexCode;
    }, 3000);
}

/*
10. When inputs with id n1 and n2 have valid numerical input, perform the operation specified in the select. Display the result in the element with id result.
*/

function calcListeners() {

    let first = document.getElementById("n1");
    let second = document.getElementById("n2");
    let operation = document.getElementById("operation");

    first.addEventListener("change", function() {
        FIRSTINPUT = this.value;
        checkShowResult();
    });

    second.addEventListener("change", function() {
        SECONDINPUT = this.value;
        checkShowResult();
    });

    operation.addEventListener("change", function() {
        OPERATION = this.value;
        checkShowResult();
    });
}

function checkShowResult() {
    let result = document.getElementById("result");
    
    if (isValidNumber(FIRSTINPUT) && isValidNumber(SECONDINPUT) && isValidOperation()) {
        result.innerHTML = calculate();
    } else {
        result.innerHTML = "0";
    }
}

function isValidNumber(input) {
    let num = Number(input);

    return (!(isNaN(num))) && isFinite(num);
}

function isValidOperation() {
    return !(OPERATION == "Divide" && Number(SECONDINPUT) === 0);
}

function calculate() {
    let num1 = Number(FIRSTINPUT);
    let num2 = Number(SECONDINPUT);

    switch (OPERATION) {
        case "Add":
            return num1 + num2;
            break;
        case "Subtract":
            return num1 - num2;
            break;
        case "Multiply":
            return num1 * num2;
            break;
        case "Divide":
            return num1 / num2;
            break;
        default:
            return 0;
    }
}

/*
11. Define function walkTheDom(node, func). This function should traverse every node in the DOM. Use recursion. On each node, calle func(node).
*/

function walkTheDom(node, func) {
    func(node);
    let children = node.childNodes;
    for (let i = 0; i < children.length; i++) {
        walkTheDom(children[i], func);
    }
}

function testWalk(node) {
    console.log(node.nodeName);
}