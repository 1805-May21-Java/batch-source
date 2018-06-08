//(1)
//set google equals to the first element whose name is google
google = document.getElementsByName("google")[0];
//set the appearance of the element to Google
google.innerHTML = "Google";
//set the attribute of this element's href to google.com
google.setAttribute("href", "http://www.google.com");
//repeat process for all other 3 websites
twitter = document.getElementsByName("twitter")[0];
twitter.innerHTML = "Twitter";
twitter.setAttribute("href", "http://www.twitter.com");
slack = document.getElementsByName("slack")[0];
slack.innerHTML = "Slack";
slack.setAttribute("href", "http://www.slack.com");
javadocs = document.getElementsByName("javadocs")[0];
javadocs.innerHTML = "Javadocs";
javadocs.setAttribute("href", "http://www.javadocs.com");


//(2)
//get the element containing the id planet with the drop down
residency = document.getElementById("planet");
//choose the option that contains pluto, and set disabled to true, so you can't select it
residency.options[3].disabled = true;

//(3)
//set the drop down select to add an event where when changing the options, run function alientext
residency.addEventListener("change", alienText);
function alienText() {
    //set a to be the value of the dropdown event
    let a = residency.value;
    //set the right paragraph element to be var hidden
    hidden = document.getElementsByTagName("p")[5];
    //so, if the value isn't earth, remove the hidden attribute
    if (a !== "Earth") {

        hidden.removeAttribute("hidden");
    }

}

//(4)
//this function is made to identify if an email is being inputed
//it earches for @ and . to see if they are in the email or not
function isValidEmail(string) {
    a = string.search('@');
    sa = string.substring(0, a);
    sb = string.substring(a + 1, string.length);
    b = sb.indexOf('.');
    if (a != -1 && b != -1) {
        return true;
    }
    return false;
}

//set the element where when you click the submit button, it runs function add
document.getElementById("form-sub").addEventListener("click", add);
function add() {
    //set all the required values of the columns for the table, and store them here
    let fname = document.getElementById("firstname").value;
    let lname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    //make sure for phone, a number is inputed
    document.getElementById("phone").setAttribute("type", "number");
    let phone = document.getElementById("phone").value;
    let birthday = document.getElementById("bday").value;
    let favcolor = document.getElementById("color").value;
    let gender;
    //do the for loop, so gender is always teh value of the checked one
    for (i = 0; i < 3; i++) {
        if (document.getElementsByName("gender")[i].checked === true) {
            gender = document.getElementsByName("gender")[i].value;
        }
    }
    //make sure gneder's first letter is capitalized
    let favactivity = [];
    gender = gender.substring(0, 1).toUpperCase() + gender.substring(1);
    count = 0;
    //similar to the gender, put the checked values inside in to an array
    for (i = 0; i < 4; i++) {

        if (document.getElementsByClassName("activity")[i].checked === true) {
            favactivity[count] = document.getElementsByClassName("activity")[i].nextSibling.nodeValue;
            count++;
        }
    }
    //no one part of the table can be null
    if ((fname && lname && email && phone && birthday && gender && favactivity) != "") {
        //email has to be emai, name needs tobe larger than 1 letter, phone needs to be 10 digits
        if (isValidEmail(email) == true && fname.length > 1 && lname.length > 1 && phone.length === 10) {
            //creating our table row, and the cells associated with that row
            let row = document.createElement("tr");
            let cell1 = document.createElement("td");
            let cell2 = document.createElement("td");
            let cell3 = document.createElement("td");
            let cell4 = document.createElement("td");
            let cell5 = document.createElement("td");
            let cell6 = document.createElement("td");
            let cell7 = document.createElement("td");
            let cell8;
            //append the ul tag in there with the td
            cell7.appendChild(document.createElement("ul"));
            for (i = 0; i < favactivity.length; i++) {
                //for each value inside the array favactivity, create a list, append it to cell7
                //print it out to the website
                cell8 = document.createElement("li");
                cell7.appendChild(cell8);
                cell8.innerHTML = "  " + favactivity[i];
            }
            //append the cells to that row
            row.appendChild(cell1);
            row.appendChild(cell2);
            row.appendChild(cell3);
            row.appendChild(cell4);
            row.appendChild(cell5);
            row.appendChild(cell6);
            row.appendChild(cell7);

            //assigning the input info to the cells
            cell1.innerHTML = fname + " " + lname;
            cell2.innerHTML = email;
            cell3.innerHTML = phone;
            cell4.innerHTML = birthday;
            cell5.innerHTML = favcolor;
            cell6.innerHTML = gender;


            //find our table and add our rows to it
            document.getElementsByTagName("table")[0].appendChild(row);
        }
    }

}

//(5)
//set the element with detail tag as detail
detail = document.getElementsByTagName("details")[0]
//add the even listener for open and close details based on mouseover/mouseleave
detail.addEventListener("mouseover", openDetails);
detail.addEventListener("mouseleave", closeDetails);
function openDetails() {
    detail.open = true;
}
function closeDetails() {
    detail.open = false;
}

//(6)
//set the array made of all the tagname with span on it
let span = document.getElementsByTagName("span");
result = "";
function showspan() {
    for (i = 0; i < span.length; i++) {
        //add thier text into string result, and then print out result
        result += span[i].textContent;
    }
    console.log(result);
}

//(7)
//find the button id relates to earth time by id
let earthtime = document.getElementById("earth_time_check");
//add the event listener to it when click on the button
earthtime.addEventListener("click", displayearthtime);
//create the element span with the current times


function displayearthtime() {
    //reset the span content to empty each time we ran the function
    earth_time.innerHTML = "";
    earth_time = document.createElement("span");
    var time = new Date();
    //find the hour/minute/seconds of the current time, and put them in one string
    //var times = "Current Earth Time is: " + time.getHours() + ":" + time.getMinutes() + ":" + time.getSeconds();
    earth_time.innerHTML = time;
    earthtimes = document.getElementById("earth_time");
    //add it to the child function of header
    earthtimes.appendChild(earth_time);
}

//(8)
let marstime = document.getElementById("mars_time_check");
marstime.addEventListener("click", displaymarstime);

function displaymarstime() {
    //similar to finding the time for earth
    mars_time.innerHTML = "";
    mars_time = document.createElement("span");
    var time = new Date();
    starttime = new Date('1970-01-01T00:00:00');
    //find the time difference between the 2 time in miliseconds
    timediff = (time -starttime);
    count1 = 0;
    i = 0;
    //convert it into days, as the hours/minutes/seconds will be the same
    while(i < timediff){
        i += 86400000;
        count1++;
    }
    daydiff = count1 -1;
    count2 = 0;
    //convert it into years, the months doesn't matter
    j = 0;
    while(j < daydiff){
        j += 647;
        count2++;
    }
    yeardiff = count2 -1;
    // 1970 to it as it was the start year
    marsyear = 1970+yeardiff;
    dayleft = daydiff%647;
    //finally put them into a nice format to read
    var martime = "Current Mars Time is: " + marsyear+" year " + dayleft + " days " +
        time.getHours() +":"+time.getMinutes()+":"+time.getSeconds();
    mars_time.innerHTML = martime;
    martimes = document.getElementById("mars_time");
    martimes.appendChild(mars_time);
}

//set up the element for acbtime button
let acbtime = document.getElementById("acb_time_check");
//add a on click event for the button
acbtime.addEventListener("click", displayacbtime);
//find the right url
baseurl = "http://www.astropical.space/astrodb/api-exo.php?which=distance&limit=10&format=json";
function displayacbtime(){
    //activate the function as we are looking for no input
    sendAjaxGet(baseurl, displayacb);
}

function sendAjaxGet(url, func){
    //basic sendAjax function to send out the needed data
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        //console.log(xhr.readyState);
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayacb(xhr){
    //after receiving the xhr, set up the date difference between now and 1970
    acb_time.innerHTML = "";
    acb_time = document.createElement("span");
    var time = new Date();
    starttime = new Date('1970-01-01T00:00:00');
    let response = xhr.response;
    let acb = JSON.parse(response);
    //set acb as the response, and look for the period in exoplanets array in the acb
    let period = acb.exoplanets[1].per;
    
    timediff = (time -starttime);
    //find the time difference, and convert into seconds/minutes... etc
    //the left over in the form of decimals can be found using %
    seconddiff = Math.floor(timediff/1000);
    minutediff = Math.floor(seconddiff/60);
    secondleft = Math.floor(seconddiff%60);
    hourdiff = Math.floor(minutediff/60);
    minuteleft = Math.floor(minutediff%60);
    daydiff = Math.floor(hourdiff/24);
    hourleft = Math.floor(hourdiff%24);
    //convert it into years, the months doesn't matter
    //add 1970
    yeardiff = Math.floor(daydiff/period);
    dayleft = Math.floor(daydiff%period);
    acbyear = 1970+yeardiff;
    var acbtime = "Current Alpha Centarui Bb Time is: " + acbyear+" year " + dayleft + " days " +
        hourleft +":"+minuteleft+":"+secondleft;
    acb_time.innerHTML = acbtime;
    acbtimes = document.getElementById("acb_time");
    acbtimes.appendChild(acb_time);

}


//(9)
//set up the event to activate changeBColor function when clicked on the heading
color = document.getElementsByTagName("h1")[0];
color.addEventListener("click", changeBColor);
function changeBColor(){
    var r;
    var g;
    var b;
    //set the element that represents the body tag
    body = document.getElementsByTagName("body")[0];
    //keep randoming number until they are black
    do {
        r = Math.floor(Math.random() * 256);
        g = Math.floor(Math.random() * 256);
        b = Math.floor(Math.random() * 256);
    } while (r == 0 && g == 0 && b == 0)
    //apply them into a rgb function
    bcolor = "rgb("+r+","+g+","+b+")";
    //change the color into the new color
    body.style.backgroundColor = bcolor;
}

//(10)
//find element n1 and n2 and set them into n1 and n2
n1 = document.getElementById("n1");
n1.setAttribute("type", "number");
n2 = document.getElementById("n2");
n2.setAttribute("type", "number");
//add the event listener when hcaning option for the drop down, do function calculation
calculate = document.getElementById("operation");
calculate.addEventListener("change", calculation);
function calculation(){
    a = calculate.value;
    //based on the value of drop down, perform the event with switch statement
    var answer;
    switch (a){
        //do the basic arithmatics, and print them out on the element with id result
        case ("Add"):
            answer = n1.value + n2.value;
            document.getElementById("result").innerHTML = answer;
            break;
        case ("Subtract"):
            answer = n1.value - n2.value;
            document.getElementById("result").innerHTML = answer;
            break;
        case ("Multiply"):
            answer = n1.value * n2.value;
            document.getElementById("result").innerHTML = answer;
            break;
        case ("Divide"):
            if(n2.value !== 0){
                answer = n1.value / n2.value;
                document.getElementById("result").innerHTML = answer;
            }
            break;
    }   
}

//(11)
//set the begin nodes to html
var nodes = document.getElementsByTagName("html")[0];

//add a check for if the function has checked for childnode before
checkFirstChild = false;

function func (node){
    //make sure childnode hasn't been checked before, and go to the child node
    if(node.firstElementChild !== undefined && node.firstElementChild !== null && checkFirstChild === false){
        console.log(node.nodeName);
        func(node.firstElementChild);
    }
    //if no child node or child node has been checked, check sibling nodes
    if(node.nextElementSibling !== undefined && node.nextElementSibling !== null){
        if(checkFirstChild === false){
            console.log(node.nodeName);
        }
        //turn checked child to false now as it is now on a sibling node now
        checkFirstChild = false;
        func(node.nextElementSibling);
    //if no sibling and no child, go back to the parent, and turn checked child to true
    } else {
        checkFirstChild = true;
        func(node.parentNode);
    }
}

//the start functiont to get both func and node;
function walkTheDom(node, func){
    console.log(node.nodeName);
    if (node.firstElementChild !== undefined){
        if(node.firstElementChild !== null){
            func(node.firstElementChild);
        }
        
    }
    
}

//window.onload = function ()