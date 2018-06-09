//JavaScript assignment 2
//1. Make each link direct the user to its respective website
//(see id)
document.getElementById("google").href = "http://www.google.com"; //getElementById required
document.getElementById("twitter").href = "http://www.twitter.com";
document.getElementById("slack").href = "http://www.slack.com";
document.getElementById("javadocs").href = "http://www.javadocs.com";
//2. Disable the Pluto Planet of Residency option.
//(Pluto isn’t a planet!!)
document.getElementById("planet").options[3].disabled = true;
//3. Define a function alienText() which shows the hidden element
//displaying an alien message.
//When any planet other than Earth is selected,
//execute this function.
function alienText(){
	if(document.getElementById("planet").value !== "Earth") {
        document.getElementsByTagName("p")[5].removeAttribute("hidden");
    } else {
        document.getElementsByTagName("p")[5].setAttribute("hidden", true);
    }
}
//4. When the submit button is pressed,
//get the values from all of the input into a new row
//in the table below.
//Make sure no input is empty, check that first and last nam
//are at least two letters each.
//Validate for valid phone number and email structure.
//This should continue to work for multiple entries and rows.
document.getElementById("form-sub").addEventListener("click", newRow);
document.getElementById("form-sub").addEventListener("click", alienText); //two listeners for two things
function newRow(){
	let fname = document.getElementById("firstname").value; //going by the bare minimum
    let lname = document.getElementById("lastname").value; //first and last name
    let phone = document.getElementById("phone").value; //phone number
    let email = document.getElementById("email").value; //email ONLY
    let bday = document.getElementById("bday").value;
    let planetRes = document.getElementById("planet").value;
    let color = document.getElementById("color").value;
    let gender = $("input[name='gender']:checked").val();
    if(gender === undefined) {
        return;
    }
    let activity = document.getElementsByClassName("activity");
    let pickedActs = [];
    for(i = 0; i < activity.length; i++){
        if(activity[i].checked) {
            pickedActs.push(activity[i].value);
        }
    }
    let row = document.createElement("tr");
    row.setAttribute("scope", "row")
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
    document.getElementsByTagName("tbody")[0].appendChild(row);
    if((fname && lname && phone && email && gender && activity) != "") // NO EMPTY STRINGS
    {
    	if(fname.length > 2 && lname.length > 2){ //first and last names must be longer than two characters
    		if(!isNaN(phone) && phone.length === 10){ // phone MUST be 10 numbers, (xxx)-xxx-xxxx
    			if(isValidEmail(email)){ //yet another function below
    	cell1.innerHTML = fname;
    	cell2.innerHTML = email;
    	cell3.innerHTML = phone;
    	cell4.innerHTML = bday;
    	cell5.innerHTML = color;
        cell6.innerHTML = gender;
        cell7.innerHTML = "<ul>"; //this one needs to be made into a list
        for(var i = 0; i < pickedActs.length; i++){
            cell7.innerHTML += "<li>" + pickedActs[i] + "</li>";
        }
        cell7.innerHTML += "</ul>";
    	document.getElementById("submission").appendChild(row);
    			}
    		}
    	}
	}
}
function isValidEmail(string){ //reusing my old isValidEmail function, as it works here
    if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(string)){
        return (true)
    } else {
        return (false)
    }
}
//5. Create a function openDetails() which opens the details element.
// Invoke this function when the details’ summary is moused over.
//The details should be hidden when the mouse is removed
//from the summary.
function openDetails(){
	var x = document.getElementById("myDetails");
	x.open = true;
} // this one really is easier with two functions, one for opening and one for closing
function closeDetails(){
	var x = document.getElementById("myDetails");
	x.open = false;
}
//6. Create a function that concatenates the inner HTML of all
//of the span elements and prints the results to the console.
function concatInnerHTML(){
	let string = ""; //initialize empty string
	let allSpans = document.getElementsByTagName("span");
	for(var i = 0; i < allSpans.length; i++){
		string += allSpans[i].innerHTML;
	}
	console.log(string); //span items are in fuchsia
}
//7. Create a function that displays the current time on earth
//in the span with id “earth_time”.
//Invoke this function when “Earth time” button is clicked. 
function displayEarthTime(){
	let time = new Date(); //it's one of those date functions, argh
	document.getElementById("earth_time").innerHTML = time
	window.setTimeout(displayEarthTime, 1000/30);
}
document.getElementById("earth_time_check").addEventListener("click", displayEarthTime);
//8. Create two other functions which calculates and displays
//the time passed on Mars and Alpha Centauri b if the onset of
//January 1st, 1970 occured at the same time.
//Invoke the respective functions when their time buttons are clicked.
//An orbital period for Mars is 687 Earth days.
//Using an external api to get the orbital period for Alpha Centauri
// b. (try http://www.astropical.space/astrodb/apiref.php)
//Provide an implementation for getting this value using
//both AJAX and the fetch API.
function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}
function marsTime(){
    let time = new Date(); //looked up a nice way to get some time function in
    let milli = time.getTime();
    let seconds = milli/1000;
    let minutes = seconds/60;
    let hours = minutes/60;
    let days = hours/24;
    let marsTime = String(1970+days/687).split("."); //this one definitely required a lookup
    let marsYear = marsTime[0];
    let marsDay = String(Number("0." + marsTime[1]) * 687).split(".")[0];
    document.getElementById("mars_time").innerHTML = marsDay + " : " + marsYear;
}
document.getElementById("mars_time_check").addEventListener("click", marsTime)
function setCentauriTime(){
    let baseurl = "http://www.astropical.space/astrodb/api-exo.php?which=distance&limit=2&format=json";
    sendAjaxGet(baseurl, getCentauriTime) //defined below
}
function getCentauriTime(xhr){
    let time = new Date();
    let milli = time.getTime();
    let seconds = milli/1000;
    let minutes = seconds/60;
    let hours = minutes/60;
    let days = hours/24;
    let resp = xhr.response;
    let info = JSON.parse(resp);
    let period = info.exoplanets[1].per
    let centauriTime = String(1970+days/period).split(".");
    let centauriYear = centauriTime[0];
    let centauriDay = String(Number("0." + centauriTime[1]) * period).split(".")[0];
    document.getElementById("acb_time").innerHTML = centauriDay + " : " + centauriYear
}
document.getElementById("acb_time_check").addEventListener("click", setCentauriTime);
//9. Three seconds after a user clicks on the
//“Intergalactic Directory” heading, the background color
// should change to a random color. 
//Make sure this color is never black so we can still
//read our black text! (there are other dark colors
//it could change to where we also couldn’t see the
//text but it’s enough to just accomodate for a black background)
function backgroundChange(){
	var x = Math.floor(Math.random() * 256);
    var y = Math.floor(Math.random() * 256);
    var z = Math.floor(Math.random() * 256);
    var bgc = "rgb(" + x + "," + y + "," + z + ")";
    if (bgc != "rgb(0,0,0)"){
        document.body.style.background = bgc;
    }
}
//10. When inputs with id n1 and n2 have valid numerical input,
//perform the operation specified in the select.
//Display the result in the element with id result.
document.addEventListener("change", validNumerical);
function validNumerical() {
    var n1 = document.getElementById("n1");
    var n2 = document.getElementById("n2");
    if(!isNaN(n1) && !isNaN(n2) && n1 !== "" && n2 !== ""){
        switch(document.getElementById("operation").value){
            case "Add":
                document.getElementById("result").innerHTML = Number(n1)+Number(n2);
                break;
            case "Subtract":
                document.getElementById("result").innerHTML = Number(n1)-Number(n2);
                break;
            case "Divide":
                if(Number(n2) === 0) {
                    document.getElementById("result").innerHTML = "ERR: DIVIDE BY ZERO";
                } else {
                document.getElementById("result").innerHTML = Number(n1)/Number(n2);
                }
                break;
            case "Multiply":
                document.getElementById("result").innerHTML = Number(n1)*Number(n2);
                break;
            default:
        }
    } else {
        document.getElementById("result").innerHTML = "";
    }
    window.setTimeout(validNumerical, 1000);
}
//11. Define function walkTheDom(node, func)
//This function should traverse every node in the DOM. 
//Use recursion. On each node, call func(node).
function walkTheDom(node, func){
    console.log(node.nodeName);
    if(node.firstElementChild !== undefined){
        if(node.firstElementChild !== null){
            func(node.firstElementChild); // another recursive call?
        }
    }
}
var nodes = document.getElementsByTagName("html")[0]; // setup
checkFirstChild = false; // higher scope variable for checking first child
function func(node){
    //obviously need this function
    //first check for falsys
    if(node.firstElementChild !== undefined && node.firstElementChild !== null && checkFirstChild === false){
        console.log(node.nodeName); //print them
        func(node.firstElementChild); //keep it recursively going
    } // next chck sibling nodes when done with child nodes
    if(node.nextElementSibling !== undefined && node.nextElementSibling !== null){
        if(checkFirstChild === false){ //yes, another check
            console.log(node.nodeName);
        }//checkFirstChild is now false after this, on sibling
        checkFirstChild = false;
        func(node.nextElementSibling); //more recursive calls
        //otherwise go back to parent
    } else {
        checkFirstChild = true; // make this true
        func(node.parentNode); //another recursive call
    }
}