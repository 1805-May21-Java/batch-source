window.onload = function () {
    // 1. Make each link direct the user to its respective website 
    getLinks();
    // 2. Disable the Pluto Planet of Residency option.
    disablePluto();
    // 3. Define a function alienText() which shows the hidden element displaying an alien message. 
    //    When any planet other than Earth is selected, execute this function.
    alienText();

    // 4. When the submit button is pressed, get the values from all of the input into a new row in 
    // the table below.  Make sure no input is empty, check that first and last name are at least two 
    // letters each. Validate for valid phone number and email structure. This should continue to work 
    // for multiple entries and rows.
    addInputSubmitListener();

    // 5. Create a function openDetails() which opens the details element. Invoke this function when the 
    // details’ summary is moused over. The details should be hidden when the mouse is removed from the 
    // summary.
    openDetails();

    // 6. Create a function that concatenates the inner HTML of all of the span elements and prints the 
    // results to the console.
    getSpanMessage();

    // 7. Create a function that displays the current time on earth in the span with id “earth_time”.
    // Invoke this function when “Earth time” button is clicked. 
    displayEarthTime();
    // 8. Create two other functions which calculates and displays the time passed on Mars and Alpha 
    // Centauri Bb if the onset of January 1st, 1970 occured at the same time. Invoke the respective
    // functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. 
    // Using an external api to get the orbital period for Alpha Centauri Bb. 
    // (try http://www.astropical.space/astrodb/apiref.php) Provide an implementation for getting this 
    // value using both AJAX and the fetch API.
    displayMarsTime();
    displayAlphaCentauriBTime();

    // 9. Three seconds after a user clicks on the “Intergalactic Directory” heading, the background 
    // color should change to a random color. Make sure this color is never black so we can still read
    // our black text! (there are other dark colors it could change to where we also couldn’t see the
    // text but it’s enough to just accomodate for a black background)
    intergalacticColors();

    // 10. When inputs with id n1 and n2 have valid numerical input, perform the operation specified 
    // in the select. Display the result in the element with id result.
    performOperationListeners();

    // 11. Define function walkTheDom(node, func)
    // This function should traverse every node in the DOM. 
    // Use recursion. On each node, calle func(node).
    let node = document;
    walkTheDom(node, walkTheDom);


};

function getLinks() {
    //get all the links
    var links = document.getElementsByTagName('a');
    //for each link, set the href to the name wrapped with https and .com
    for (l of links) {
        //get the name from the name attribute
        name = l.name;
        //build the url
        l.setAttribute('href', `https://${name}.com`);
    }
}

function disablePluto() {
    //get the first form, then its children, then the planet selector, then the 4th option
    //then set the disabled option to true.
    document.getElementById('planet').options[3].setAttribute('disabled', true);
}

function alienText() {
    //get the planet select input
    let selector = document.getElementById('planet');
    // when it changes (a new option is chosen)
    selector.onchange = function () {
        //iterate through each option
        for (option of selector.children) {
            // if an option is selected
            if (option.selected) {
                // check if it is not Earth
                if(option.value != "Earth") {
                    // remove hidden attribute from alien message
                    document.querySelectorAll('p[hidden]')[0].removeAttribute('hidden');
                }
            }
        }
    }
}

function addInputSubmitListener() {
    //add event listener to submit button
    document.getElementById('form-sub').addEventListener('click',function(){
        var values = {};
        
        //get first name
        fname = document.getElementById('firstname').value;
        if(fname.length >= 2)
            values.firstname = fname;
        else {
            console.log("invalid first name")
            return;
        }
        //get last name
        lname = document.getElementById('lastname').value;
        if(lname.length >= 2)
            values.lastname = lname;
        else{
            console.log("invalid last name")
            return;
        }
        //get email
        email = document.getElementById('email').value;
        if(isValidEmail(email))
            values.email = email;
        else {
            console.log("invalid email")
            return;
        }
        //get phone number
        phone = document.getElementById('phone').value;
        if(isValidPhoneNumber(phone))
            values.phone = phone;
        else{
            console.log("invalid phone number")
            return;
        }
        //get birthday
        bday = document.getElementById('bday').value;
        if(bday.length > 0)
            values.bday = bday;
        else {
            console.log("date");
            return;
        }
        //get gender
        gender = '';
        options = document.getElementsByName("gender");
        for(op of options) { if(op.checked == true){gender = op.value.substring(0,1).toUpperCase() 
            + op.value.slice(1); } }
        if(!gender){
            console.log("choose a gender")
            return;
        }
        values.gender = gender;
        //get favorite color
        color = document.getElementById('color').value;
        if(!color){
            console.log("choose a color")
            return;
        }
        values.color = color;
        //get favorite activities
        activities = [];
        options = document.getElementsByClassName('activity');
        for(op of options) { if(op.checked == true){activities.push(op.value) } }
        if(activities.length < 1){
            console.log("choose at least 1 activity")
            return;
        };
        values.activities = activities;
        
        //insert into table
        table = document.getElementsByTagName('tbody')[0];
        tableRow = document.createElement('tr');
        tableDataFirstName = document.createElement('td');
            tableDataFirstName.innerHTML = values.firstname + ' ' + values.lastname;
            tableRow.appendChild(tableDataFirstName);
        tableDataEmail = document.createElement('td');
            tableDataEmail.innerHTML = values.email;
            tableRow.appendChild(tableDataEmail);
        tableDataPhone = document.createElement('td');
            tableDataPhone.innerHTML = values.phone;
            tableRow.appendChild(tableDataPhone);
        tableDataBday = document.createElement('td');
            tableDataBday.innerHTML = values.bday;
            tableRow.appendChild(tableDataBday);
        tableDataColor = document.createElement('td');
            tableDataColor.innerHTML = values.color;
            tableRow.appendChild(tableDataColor);
        tableDataGender = document.createElement('td');
            tableDataGender.innerHTML = values.gender;
            tableRow.appendChild(tableDataGender);
        tableDataActivities = document.createElement('td');
            list = document.createElement('ul');
            for(activity of values.activities) {
                item = document.createElement('li');
                item.innerHTML = activityList[activity];
                list.appendChild(item);
            }
            tableDataActivities.appendChild(list);
            tableRow.appendChild(tableDataActivities);
        
        // add new row to table
        table.appendChild(tableRow);

    });
}

function openDetails() {
    details = document.getElementsByTagName('details')[0];
    details.addEventListener('mouseenter', function() {
        details.setAttribute('open', true);
    });
    details.addEventListener('mouseleave', function() {
        details.removeAttribute('open');
    });
}

function getSpanMessage() {
    spans = document.getElementsByTagName('span');
    spanArr = [];
    for(span of spans) {
        spanArr.push(span.innerHTML);
    }
    console.log(spanArr.join(''));
}

function displayEarthTime() {
    document.getElementById('earth_time_check').addEventListener('click', function() {
        var date = new Date();
        var options = {hour: '2-digit', minute: '2-digit', second: '2-digit'};
        var earthTime = new Intl.DateTimeFormat('en-US', options).format;
        var timeString = earthTime(date);
        document.getElementById('earth_time').innerHTML = timeString;
    }); 
}

function displayMarsTime() {
    document.getElementById('mars_time_check').addEventListener('click', function() {
        var timestamp = Date.now();
        var options = {hour: '2-digit', minute: '2-digit', second: '2-digit'};
        var earthTime = new Intl.DateTimeFormat('en-US', options).format;
        var timeString = earthTime(new Date()); 
        var numEarthDays = timestamp / 1000 / 60 / 60/ 24;
        var numMarsYears = Math.floor(numEarthDays / 687);
        var numMarsDays = Math.floor(numEarthDays % 687);
        document.getElementById('mars_time').innerHTML = `${numMarsYears} years, ${numMarsDays} days, ${timeString}`;
    });
}

function displayAlphaCentauriBTime() {
    document.getElementById('acb_time_check').addEventListener('click', function() {

        var xhr = new XMLHttpRequest() || new ActiveXObject('Mircrosoft.HTTPRequest');

        xhr.onreadystatechange = function() {
            if(this.status == 200 && this.readyState == 4) {
                let results = JSON.parse(xhr.response);
                let period = results.exoplanets[1].per;

                let timestamp = Date.now();; 
                let numEarthDays = timestamp / 1000 / 60 / 60/ 24;
                let numACBYears = numEarthDays /period;
                console.log(numEarthDays);
                console.log(numEarthDays / period);
                let numACBDays = Math.floor(numEarthDays % period);
                let numACBHours = numEarthDays % period % 1 * 24 ;

                
                document.getElementById('acb_time').innerHTML = `${numACBYears} Alpha Centaruri Bb years`
            } 
        }

        xhr.open('GET', 'http://www.astropical.space/astrodb/api-exo.php?which=distance&limit=2&format=json');
        xhr.send();

        console.log('request sent');

        
    })
}

function intergalacticColors() {

    let header = document.getElementsByTagName('h1')[0];
    header.addEventListener('click', function() {
        console.log('click');
        setTimeout( setColor,3000);
        console.log('after');
        
    });
}

function setColor() {
    let header = document.getElementsByTagName('h1')[0];
    let num = Math.floor(Math.random() * 16777216);
    num = Number(num).toString(16);
    let pad = '000000';
    let hex = '#' + pad.substring(0, pad.length - num.length) + num;

    if(hex.charAt(1) < 2 || hex.charAt(3) < 2 || hex.charAt(5) < 2) {
        setColor();
        return;
    }

    header.style.backgroundColor = hex;
}

function performOperationListeners() {
    
    document.getElementById('n1').addEventListener('keypress', getValues);
    document.getElementById('n2').addEventListener('keypress', getValues);
    document.getElementById('operation').addEventListener('change', getValues);
}

function getValues(e) {
    if(!e.key ||  e.key == 'Enter') {
        // get the value from the inputs
        let n1 = document.getElementById('n1').value;
        let n2 = document.getElementById('n2').value;
        // check if it is a number
        let reg = /^[0-9]*[.]?[0-9]+$/;
        if(reg.test(n1) && reg.test(n2)) {
            // calculate stuff
            calculate(n1, n2);   
        }
    }
}

function calculate(n1, n2) {
    let op = document.getElementById('operation');
    let value = op.value;
    let result = 0;
    switch(value) {
        case 'Add' : result = n1 - -n2;
        break;
        case 'Subtract' : result = n1 - n2;
        break;
        case 'Multiply' : result = n1 * n2;
        break;
        case 'Divide' : result = n1 / n2;
        break;
    }

    document.getElementById('result').innerHTML = result;

}

function walkTheDom(node, func) {
    
    for(node of node.childNodes) {
        walkTheDom(node, func);
    }
}


// check if valid email address
function isValidEmail(string) {
    var re = /^[\w._]+@\w+[.]\w{2,3}$/;
    if (string.match(re)) {
        return true;
    }
    return false;
}

//check if valid phone number
function isValidPhoneNumber(number) {
    var re = /^[0-9]{3}[-]*[0-9]{3}[-]*[0-9]{4}$/;
    if(number.match(re)) {
        return true;
    }
    return false;
}

var activityList = {
    hiking: 'hiking',
    stamp : 'stamp collecting',
    birding: 'birding',
    basket: 'underwater basket weaving'
}
