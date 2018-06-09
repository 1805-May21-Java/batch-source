//1. Making each link work
//Create four const variables for each of the links in Index.html
//in those variables I set the href attribute to a page matching the
//name attribute. .innerHTML was also used to give the name of the page.
const googleLink = document.getElementsByName("google")[0];
googleLink.setAttribute("href", "http://google.com");
googleLink.innerHTML = " Google  ";
const twitterLink = document.getElementsByName("twitter")[0];
twitterLink.setAttribute("href", "https://twitter.com");
twitterLink.innerHTML = " Twitter  ";
const slackLink = document.getElementsByName("slack")[0];
slackLink.setAttribute("href", "https://slack.com");
slackLink.innerHTML = " Slack   ";
const javadocsLink = document.getElementsByName("javadocs")[0];
javadocsLink.setAttribute("href", "https://javadocs.com");
javadocsLink.innerHTML = " Javadocs  ";

//2 Disabling Pluto option
//got the select tag with the id element and indexed to the last option which
//contained "Pluto" and set .disabled to true.
//Pluto is seen in the options, but cannot be selected.
document.getElementById("planet").options[3].disabled = true;

//3.
//Created two let variables to store the current value
//of the planet select tag and the paragraph where the hidden text is stored.
function alienText(){
    let selectVal = document.getElementById("planet").value;
    let pIndexed = document.getElementsByTagName("p")[5];
    //if current select value is not equal to "Earth"
    //then the hidden attribute is removed from pIndexed, showing the alien text.
    if(selectVal !== "Earth"){
        pIndexed.removeAttribute("hidden");
    }
    
}
//EventListener added to select tag with id "planet", calls alienText()
//whenever the current value is changed.
document.getElementById("planet").addEventListener("change", alienText);


//code from first JavaScript assignment
//will serve as a helper method for Question 4.
function isValidEmail(string){
    //Checking for "@"" and "."" characters, and repetitions of them.
    atCount = 0;
    dotCount = 0;
    for(i = 0; i < string.length; i++){
        if((dotCount === 1) && (atCount === 0)){
            return false;
        }
        if(string.charAt(i) === "@"){
            atCount+=1;
        }
        if(string.charAt(i) === "."){
            dotCount+=1;
        }
    }
    if((atCount > 1) || (dotCount > 1) ){
        return false;
    }else if(atCount === 0 || dotCount === 0){
        return false;
    }else{
        return true;
    }
}



//4. Adding new row to table via a button.
function addRow(){
    //Gets the values from the text input fields
    let firstName = document.getElementById("firstname").value;
    let lastName = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bday = document.getElementById("bday").value;
    //let bdayDate = new Date(bday);
    //checks if variables are empty inputs
    if((firstName === "") || (lastName === "") || (email === "") || (phone === "") || (bday === "")){
        return;
    }
    //checks if firstName and lastName are less than 2 characters
    if(firstName.length < 2 || lastName < 2){
        return;
    }
    //calls isValidEmail() to check if email is in valid format
    if(isValidEmail(email) === false){
        return;
    }
    //checks if phone number is too short
    if(phone.length < 10){
        return;
    }

    //retrieving values from labels
    //retrives from name "gender"
    let genderList = document.getElementsByName("gender");
    let chosenGender = "";
    //iterates through genderList to find the checked value
    for(x in genderList){
        if(genderList[x].checked === true){
            chosenGender = genderList[x].value
        }
    }
    //retrives from ID "color"
   let color = document.getElementById("color").value;

   //retrives from class "activity"
   let favoriteActivites = document.getElementsByClassName("activity");
   let selectedActivites = [];
   //iterates through favoriteActivities for checked values and
   //adds the text next to the input to the array selectedActivites
   for(y in favoriteActivites){
       if(favoriteActivites[y].checked === true){
            selectedActivites.push(favoriteActivites[y].nextSibling.nodeValue);
       }
   }

    //creating new table row
    let row = document.createElement("tr");

    //creating table cells with input values
    let nameColumn = document.createElement("td");
    let emailColumn = document.createElement("td");
    let phoneColumn = document.createElement("td");
    let bdayColumn = document.createElement("td");
    let favColorColumn = document.createElement("td");
    let genderColumn = document.createElement("td");
    let activityColumn = document.createElement("td");
    //creating and populating activityColumn
    let activityList = document.createElement("ul");
    //iterates through selectedActivites, creating an
    //element instance of list, fills it with its current value at x
    //and appends it to the unordered list activityList
    for(x in selectedActivites){
        let newActivity = document.createElement("li");
        newActivity.innerHTML = selectedActivites[x];
        activityList.appendChild(newActivity);
    }
    //Unordered list is populated and appends to activyColumn
    activityColumn.appendChild(activityList);

    //adding table cells to row
    row.appendChild(nameColumn);
    row.appendChild(emailColumn);
    row.appendChild(phoneColumn);
    row.appendChild(bdayColumn);
    row.appendChild(favColorColumn);
    row.appendChild(genderColumn);
    row.appendChild(activityColumn);

    //populating the rest of the table cells
    nameColumn.innerHTML = firstName + " " + lastName;
    emailColumn.innerHTML = email;
    phoneColumn.innerHTML = phone;
    bdayColumn.innerHTML = bday;
    favColorColumn.innerHTML = color;
    genderColumn.innerHTML = chosenGender;

    //adding the newly filled row to the first instance of a table in the html page
    document.getElementsByTagName("table")[0].appendChild(row);
}
//EventLister added to button with ID "form-sub" on click, which runs addRow()
document.getElementById("form-sub").addEventListener("click", addRow);



//5. Open details
//openDetails opens the details tag while mouse is hovered over
function openDetails(){
    let detailsTag = document.getElementsByTagName("details")[0];
    detailsTag.open = true;

}
//closeDetails closes the details tag when mouse leaves details hover space
function closeDetails(){
    let detailsTag = document.getElementsByTagName("details")[0];
    detailsTag.open = false;
 //   detailsTag.setAttribute("hidden");
}

//Opening details element
document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
//Closing details element
document.getElementsByTagName("summary")[0].addEventListener("mouseleave", closeDetails);

//6. Concatenating all span tags
function concatenateSpan(){
    //a collection of all span tags, plus the length
    let allSpans = document.getElementsByTagName("span");
    let result = ""
    //iterating through the length of allSpans and concatenating to string result
    for(i=0; i < allSpans.length; i++){
        result += allSpans[i].textContent;
    }
    console.log(result);
}

//7. Display time on Earth.
function earthTime(){
    //added new Date() to the innerHTLM property of the tag with ID "earth_time"
    document.getElementById("earth_time").innerHTML = new Date();
}
//Added even listener that will give the current time when you click button labeled "Earth time"
document.getElementById("earth_time_check").addEventListener("click", earthTime);

//8. Mars and Proxima Centuri b time
//Gets the number of years and days from Mars to Earth.
function displayMarsTime(){
    //Mars days which is equivalent to one Earth day.
    let marsDays = 687;
    //Gets time from Date() in miliseconds
    let dateTime = new Date().getTime();
    //converting from miliseconds to days and years.
    let seconds = dateTime / 1000;
    let minutes = seconds / 60;
    let hours = minutes / 60;
    let days = hours / 24;
    //Gets the number of mars years.
    let marsYears = days / marsDays;
    //gets the number of Mars days from Earth days
    let daysLeft = days%marsDays;
    //Element with ID "mars_time"'s innerHTML is set to a string containing the equivalent Mars years and days
    //from Earth date.
    document.getElementById("mars_time").innerHTML = "Mars years is: " + Math.floor(marsYears) + 
    " ,and days is: " + Math.floor(daysLeft) + " from Earth time.";
}
//Added event listener to button "mars_time_check", which will run displayMarsTime on click.
document.getElementById("mars_time_check").addEventListener("click", displayMarsTime);


//url from external apis link.
baseurl = "http://www.astropical.space/astrodb/";
//Api link that will return JSON containing Alpha Centauri B object
acburl = "api-exo.php?which=distance&limit=10&format=json"


//centauriTime will run the sendAjaxGet method, providing it the url it needs to retrieve the desired information
//on Alpha Centauri B.
function centauriTime(){
    baseacb = baseurl + acburl;
    sendAjaxGet(baseacb, displayACBTime);

}
//Added eventListner to button "acb_time_check" which will execute centauriTime() on click.
document.getElementById("acb_time_check").addEventListener("click", centauriTime);

//function will parse the XmlHttpRespose into a JSON object and get the number of years and days
//from Alpha Centauri B to Earth.
function displayACBTime(xhr){
    let response = xhr.response;
    let planets = JSON.parse(response);
    //console.log(planets);
    let alfCenDays = 0;
    //iterates through planets JSON object's exoplanet property array
    //finds index containing name "alf Cen B b" and sets alfCenDays to the indexed value's .per value
    //which is the number of days equivalent to an Earth day.
    for(x in planets.exoplanets){
        if(planets.exoplanets[x].name === "alf Cen B b"){
            //console.log(planets.exoplanets[x]);
            alfCenDays = planets.exoplanets[x].per;
        }
    }
    //Gets time from Date() in miliseconds
    let dateTime = new Date().getTime();
    //converts from milisecods all the way to days and years.
    let seconds = dateTime / 1000;
    let minutes = seconds / 60;
    let hours = minutes / 60;
    let days = hours / 24;
    //gets number of Alpha Centauri B years.
    let acbYears = days / alfCenDays;
    //let acbYears1970 = acbYears - 1970
    //let acbYear1970 = 1970+acbYears;
    //Gets number of Alpha Centauri B days from Earth days.
    let daysLeft = days%alfCenDays;
    //Element with ID "acb_time"'s innerHTML is set to a string containing the equivalent Alpha Centauri years and days
    //from Earth date.
    document.getElementById("acb_time").innerHTML = "Alpha Centauri B years is: " + Math.floor(acbYears) + 
    " ,and days is: " + Math.floor(daysLeft);
    
    
}

//helper method sendAjaxGet opens an XmlHttpRequest to retrive JSON object containing information on planets
//that include Alpha Centauri B. The method also executes function func on XMLHttpRequest object xhr.
function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    //checks that on each state change that if xhr.status is ok to retrive information
    //anf readyState is DONE, it executes function in argument func.
    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    //Opens connection to retrieve information.
    xhr.open("GET", url);
    //passes newly retrived information.
    xhr.send();
}




//9. Change Background color after clicking Intergalactic Directory header
function changeBackground(){

    //Generates random red, green, and blue values
    var r = Math.floor(Math.random() * 256);
    var g = Math.floor(Math.random() * 256);
    var b = Math.floor(Math.random() * 256);
    var rbgColor = "rgb(" + r + "," + g + "," + b + ")";

    //if rgb value result in a Black color then another
    //rgb value is generated.
    if(rbgColor === "rgb(0,0,0)"){
        r = Math.floor(Math.random() * 256);
        g = Math.floor(Math.random() * 256);
        b = Math.floor(Math.random() * 256);
        rbgColor = "rgb(" + x + "," + y + "," + z + ")";
    }
    //the html body's backgroundColor value is set to the bgColor value
    document.body.style.backgroundColor = rbgColor;

    
}
//Added eventListener to the first h1 header in the html, 
//which will run changeBackground() upon clicking on the h1 header
document.getElementsByTagName("h1")[0].addEventListener("click", changeBackground);

//10. Calculator
//INCOMPLETE
//function that calculates values at inputs with IDs n1 and n2
function calculate(){
    //Retrieves value of select tag with ID "operator", as well as the n1 and n2 inputs
    let operator = document.getElementById("operation").value;
    let n1 = document.getElementById("n1");
    let n2 = document.getElementById("n2");
    let result = document.getElementById("result");
    //Switch statement on operator, case statements are the option value textm
    //and calculates n1 and n2 based on the value of operator.
    switch(operator){
        case("Add"):
            result.innerHTML = Number(n1.value) + Number(n2.value);
            break;
        case("Subtract"):
            result.innerHTML = Number(n1.value) - Number(n2.value);
            break;
        case("Divide"):
            result.innerHTML = Number(n1.value) / Number(n2.value);
            break;
        case("Multiply"):
            result.innerHTML = Number(n1.value) * Number(n2.value);
            break;
    }

}
//Added eventListener to select tag "operation" on change, which will then
//run calculate().
document.getElementById("operation").addEventListener("change", calculate);

//11. Walk the DOM
//walkTheDom(node, func) iterates through the entire html page, beginning on tag html
//traversing all the way to the last element, and running the function func on each Node.
function walkTheDom(node, func){
    //function is executed on the node
   func(node);
   
   //the node then points to the node's firstElementChild
   node = node.firstElementChild;
   //While the node is valid, WalktheDom is executed on the node,
   //afterwards node points to its next Element sibling node.
   while(node !== undefined){
       //if the node is null, the function returns.
       if(node === null){
           return;
      }
       walkTheDom(node, domFunc);
       node = node.nextElementSibling;
   }
}
//function domFunc prints the node at each iteration
//as well as counter domCount which will indicate how many times walkTheDom has been executing.
let domCount = 0;
function domFunc(node){
    domCount++;
    console.log(domCount);
    console.log(node);
}

//walkTheDom(node, func) is executed when the html page loads.
//beginning at the root node, the html tag.
window.onload = function(){
    //"*" is the root node in the DOM
    walkTheDom(document.getElementsByTagName("*")[0], domFunc);
}


