//1
//gets the element by their value then sets href to the correct URL
document.getElementsByName("google")[0].setAttribute("href","https://www.google.com");
document.getElementsByName("twitter")[0].setAttribute("href","https://www.twitter.com");
document.getElementsByName("slack")[0].setAttribute("href","https://www.slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href","https://www.javadocs.com");

//2
//Selects by the ID planet, finds the child with the label pluto, then removes the 3rd index
document.getElementById("planet").children[3].setAttribute("disabled",true);

//3
//Adds an event listener to find the value of form-sub on clicking submit, sees if the value is earth, if so unhides
//If Earth selected, hides in case non-Earth was previously selected
document.getElementById("form-sub").addEventListener("click",function(){
    if(document.getElementById("planet").value != "Earth"){
        alienText();
    }else{
        document.getElementsByTagName("p")[5].setAttribute("hidden","hidden");
    }
})

function alienText(){
    document.getElementsByTagName("p")[5].removeAttribute("hidden");
}

//4 
//selects all fields, the checks each, then adds it to a new row
document.getElementById("form-sub").addEventListener("click",addInput);

function addInput(){

    firstName = document.getElementById("firstname").value;
    lastName = document.getElementById("lastname").value;

    if(firstName.length < 2 && lastName.length < 2){
        return;
    }

    email = document.getElementById("email").value;
    //regex checking for email
    if(! /\w+@\w+\.\w+/.test(email)){
        console.log("invalid email");
       return;
    }
    console.log(email);

    phone = document.getElementById("phone").value;
    //regex check for phone
    if(! /\d{3}-?\d{3}-?\d{4}/.test(phone)){
        console.log("invalid phone");
        return;
    }
    birthday = document.getElementById("bday").value;
    if(birthday == ""){
        console.log("invalid birthday");
        return;
    }
    planet = document.getElementById("planet").value;
    
    genderBox = document.getElementsByName("gender");
    let gender = "";
    for(box of genderBox){
        if(box.checked){
            gender = box.value;
        }
    }
    if(gender == ""){
        console.log("empty gender");
        return;
    }
    color = document.getElementById("color").value;
    activities = document.getElementsByClassName("activity");

    let row = document.createElement("tr");
    row.setAttribute("scope","row");

    let child1 = document.createElement("td")
    child1.innerHTML = firstname.value+" "+lastname.value;
    let child2 = document.createElement("td");
    child2.innerHTML = email;
    let child3 = document.createElement("td");
    child3.innerHTML = phone;
    let child4 = document.createElement("td");
    child4.innerHTML = birthday;
    let child5 = document.createElement("td");
    child5.innerHTML = color;
    let child6 = document.createElement("td");
    child6.innerHTML = gender;
    let child7 = document.createElement("td");
    child7.innerHTML += "<ul>"
    for(activity of activities){
        if(activity.checked){
                child7.innerHTML += `<li>${activity.nextSibling.nodeValue}</li>`;
        }
    }
    row.appendChild(child1);
    row.appendChild(child2);
    row.appendChild(child3);
    row.appendChild(child4);
    row.appendChild(child5);
    row.appendChild(child6);
    row.appendChild(child7);
    document.getElementsByTagName("tbody")[0].appendChild(row);

    }
//5
//create a function that adds a mouseover event listener when it mouses over to open
//and closes when mouseout.
detailElement = document.getElementsByTagName("details")[0];
detailElement.addEventListener("mouseover",function(){
    openDetails(this);
});
detailElement.addEventListener("mouseout",function(){
    closeDetails(this);
});

function openDetails(view){
    view.open=true;
}

function closeDetails(view){
    view.open=false;
}

//6
//Gets all span elements, then loops through all spans adding the text inside all of them 
allSpans = document.getElementsByTagName("span");
let string = "";
for(span of allSpans){
    string += span.innerHTML;
}
console.log(string);
//7
//Uses the date object to return the local time in an onclick function
earthTimeButton = document.getElementById("earth_time_check");
earthTimeButton.addEventListener("click",function(){
     document.getElementById("earth_time").innerHTML = (new Date()).toLocaleTimeString();
});

//8
marsTimeButton = document.getElementById("mars_time_check");
marsTimeButton.addEventListener("click",function(){
    //divide by the number of milliseconds in 687 earth days, the int result is how many mars years have passed
    //and the mod is how many days
    exactYears = Date.now()/(687*24*3600*1000);
    document.getElementById("mars_time").innerHTML = (Math.round(exactYears)+" Mars years and "+
    ((exactYears - (Math.floor(exactYears)))*687).toFixed(2)+" Earth days");
})

//Does an ajex call to the site
url = "http://www.astropical.space/astrodb/api-exo.php?which=name&limit=&format=json";
alphaTimeButton = document.getElementById("acb_time_check");
alphaTimeButton.addEventListener("click",function(){
   sendAjaxGet(url, getTime)
});

function sendAjaxGet(url, func){
    
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));

    xhr.onreadystatechange = function(){
        if(xhr.status == 200 && xhr.readyState == 4){
            func(xhr);
        }
    }
    xhr.open("GET",url);
    xhr.send();
    
}

function getTime(xhr){
    //turns response into a JSON object
    let response = JSON.parse(xhr.response);
    response.exoplanets.forEach(function (planet){
        if(planet.name == "alf Cen B b"){
            //selects the specific planet of alf Cen B b, gets the period
            let period = planet.per;
            let exactYears = Date.now()/(period*24*3600*1000);
            console.log(exactYears);
            document.getElementById("acb_time").innerHTML = (Math.round(exactYears)+" Alpha Centauri B years and "+
    ((exactYears - (Math.floor(exactYears)))*period).toFixed(2)+" Earth days");
        }
});
}
//9
//On click, timeout for 3000 milliseconds then do what's inside the timeout function
let heading = document.getElementsByTagName("h1")[0];
heading.addEventListener("click",function(){
    setTimeout(function () {
        //the early numbers are the opaque ones, so by doing it to the 14th instead of the 16th and adding 1000 I won't get the early dark numbers
        let num = Math.floor(Math.random() * Math.pow(14,6)+1000).toString(16);
        heading.style.backgroundColor = "#"+num;
}, 3000);
  });
//10
//First, change input types for the two numbers to make sure there's valid input
//Checks divide for second value being 0, if so does not display a result
let field1 = document.getElementById("n1");
let field2 = document.getElementById("n2");
 field1.setAttribute("type","number");
 field2.setAttribute("type","number");
 field2.addEventListener("keyup",function(){

function calculator(){}
    let selector = document.getElementById("operation");
    let resultField = document.getElementById("result");
    switch (selector.value){
       
        case "Add":
            resultField.innerHTML = Number(field1.value) + Number(field2.value);
        break;
        case "Subtract":
            resultField.innerHTML = field1.value - field2.value;
        case "Multiply":
            resultField.innerHTML = field1.value * field2.value;
        case "Divide":
            if(field2.value == 0){
                resultField.innerHTML = "";
            }else{
                resultField.innerHTML = field1.value / field2.value;
            }
 }
});
//11
//finds the uppermost element, document, by getting the parent of documentElement
rootElement = document.documentElement.parentNode;
console.log(rootElement.children)
goDown(rootElement);

function goDown(node){
    //recursive function that logs the current node, then calls itself for any child nodes 
    let children = node.childNodes;
    for(childNode of children){
        console.log(childNode.nodeName)
        goDown(childNode);
    }
}
