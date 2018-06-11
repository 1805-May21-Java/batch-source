//Make each link direct the user to its respective website (see id)
document.getElementsByName("google")[0].setAttribute("href", "http://www.google.com");
document.getElementsByName("twitter")[0].setAttribute("href", "http://www.twitter.com");
document.getElementsByName("slack")[0].setAttribute("href", "https://revaturepro.slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href", "http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html?");

//Disable the Pluto Planet of Residency option. (Pluto isn’t a planet!!)
let options = document.getElementById("planet").options[3].disabled = true;

//Define a function alienText() which shows the hidden element displaying an alien message. When any planet other than Earth is selected, execute this function.

function alienText() {
    var obj = document.getElementById("planet");
    if (obj.options[obj.selectedIndex].text != 'Earth') {
        let pars = document.getElementsByTagName("p");
        pars[5].hidden = false;
    }
    else {
        let pars = document.getElementsByTagName("p");
        pars[5].hidden = true;
    }
}

document.getElementById("planet").addEventListener("click", alienText)

//When the submit button is pressed, get the values from all of the input into a new row in the table below.  Make sure no input is empty, check that first and last name are at least two letters each. Validate for valid phone number and email structure. This should continue to work for multiple entries and rows.
function getText() {
    let name = document.getElementById("firstname").value + " " + document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let bday = document.getElementById("bday").value;
    let genders = document.getElementsByName("gender");
    for (gen in genders) {
        if (genders[gen].checked) {
            gender = genders[gen].value;
        }
    }
    let favCol = document.getElementById("color").value;

    let activities = `<ul>`;
    var inputElements = document.getElementsByClassName("activity");
    for (var i = 0; i < inputElements.length; ++i) {
        console.log(i + ": " + inputElements[i].checked);
        if (inputElements[i].checked) {
            activities += `
            <li>${inputElements[i].value}</li>`;
        }
    }
    activities +=`
    </ul>`;
    console.log(activities);

    let row = document.createElement("tr");
    let nm = document.createElement("td");
    let mail = document.createElement("td");
    let phn = document.createElement("td");
    let birth = document.createElement("td");
    let col = document.createElement("td");
    let sex = document.createElement("td");
    let acts = document.createElement("td");
    
    
    row.appendChild(nm);
    row.appendChild(mail);
    row.appendChild(phn);
    row.appendChild(birth);
    row.appendChild(col);
    row.appendChild(sex);
    row.appendChild(acts);

    nm.innerHTML = name;
    mail.innerHTML = email;
    phn.innerHTML = phone;
    birth.innerHTML = bday;
    col.innerHTML = favCol;
    sex.innerHTML = gender;
    acts.innerHTML = activities;

    console.log(document.getElementsByTagName("table")[0]);

    document.getElementsByTagName("table")[0].appendChild(row);
}

document.getElementById("form-sub").addEventListener("click", getText);


//Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.
function openDetails(value) {
    document.getElementsByTagName("details")[0].open = value;
}

document.getElementsByTagName("details")[0].setAttribute("onmouseover", "openDetails(true)");
document.getElementsByTagName("details")[0].setAttribute("onmouseout", "openDetails(false)");


//Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
function concat(){
    let str = "";
    let spans = document.getElementsByTagName("span");
    for(string of spans){
        str += string.innerHTML;
    }
    console.log(str);
}

//Create a function that displays the current time on earth in the span with id “earth_time”. Invoke this function when “Earth time” button is clicked.
function earthTime() {
    var d = new Date();
    document.getElementById("earth_time").innerHTML = d;
}

document.getElementById("earth_time_check").addEventListener("click", earthTime);


//Create two other functions which calculates and displays the time passed on Mars and Alpha Centauri b if the onset of January 1st, 1970 occured at the same time. Invoke the respective functions when their time buttons are clicked. An orbital period for Mars is 687 Earth days. Using an external api to get the orbital period for Alpha Centauri b. (try http://www.astropical.space/astrodb/apiref.php) Provide an implementation for getting this value using both AJAX and the fetch API

function marsTime() {
    var d = new Date();
    var seconds = Math.round(d.getTime() / 1000)
    const secPerMarsYear = 59356800;
    const secPerDay = 86400;
    const secPerHour = 3600;
    const secPerMin = 60;
    var year = 1970;
    while(seconds > secPerMarsYear){
        year++;
        seconds -= secPerMarsYear;
    }
    var days = 0;
    while(seconds > secPerDay){
        days++;
        seconds -= secPerDay;
    }
    var hours = 0;
    while(seconds > secPerHour){
        hours++;
        seconds -= secPerHour;
    }
    var mins = 0;
    while(seconds > secPerMin){
        mins++;
        seconds -= secPerMin;
    }

    document.getElementById("mars_time").innerHTML = (year + ", day " + days + " " + hours + ":" + mins + ":" + seconds); 
}

function dateToSeconds(date){
    span= DateTime.Now.Subtract(new DateTime(1970,1,1,0,0,0));
    return span.TotalSeconds;
}

document.getElementById("mars_time_check").addEventListener("click", marsTime);




//Three seconds after a user clicks on the “Intergalactic Directory” heading, the background color should change to a random color. Make sure this color is never black so we can still read our black text! (there are other dark colors it could change to where we also couldn’t see the text but it’s enough to just accomodate for a black background)

function stateChange(newState) {
    setTimeout(function () {
        console.log("functional")
        var hue = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';
        while(hue == 'rgb(0,0,0)'){
            var hue = 'rgb(' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ',' + (Math.floor(Math.random() * 256)) + ')';            
        }
        console.log(hue);
        document.body.style.backgroundColor = hue;
                  }, 5000);
}


function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
      color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
  }

  document.getElementsByTagName("h1")[0].addEventListener("click", stateChange);


  function mathOnNumbers() {
      console.log("math On numbers");
      var num1 = document.getElementById("n1").value;
      var num2 = document.getElementById("n2").value;
      var sel = document.getElementById("operation");
      var oper = sel.options[sel.selectedIndex].value;
      var output;
      if(!isNaN(num1) && !isNaN(num2)){
        if(oper == 'Add'){
            output = num1 + num2;
        }
        else if(oper == 'Subtract'){
            output = num1 - num2;
        }
        else if(oper == 'Multiply') {
            output = num1 * num2;
        }
        else {
            output = num1/num2;
        }
      }
      else {
           document.getElementById("result").innerHTML = "";      
      }

      if(!isNaN(output)) {
          document.getElementById("result").innerHTML = output;
      } 
    //   else {
    //       document.getElementById("result".innerHTML = "";
    //   }
  }

  document.getElementById("n1").addEventListener("keyup", mathOnNumbers);
  document.getElementById("n1").addEventListener("keyup", mathOnNumbers);
  document.getElementById("operation").addEventListener("change", mathOnNumbers);




function walkTheDom(node, func){
    let children = node.childNodes;
    func(node);
    for(child of children){
        walkTheDom(child, func);
    }
}