window.onload = function(){
  // Part 1: Make each link direct the user to its respective website 
  document.querySelector(`a[name='google']`).href = "https://www.google.com";
  document.querySelector(`a[name='twitter']`).href = "https://www.twitter.com";
  document.querySelector(`a[name='slack']`).href = "https://www.slack.com";
  document.querySelector(`a[name='javadocs']`).href = "https://www.javadocs.com";

  // Part 2: Disable Pluto option
  document.getElementById("planet")[3].setAttribute("disabled", true);

  // Part 3: Display hidden text if planet other than Earth is selected
  document.getElementById("form-sub").addEventListener("click", alienText);

  // Part 4: Create a new row in table
  document.getElementById("form-sub").addEventListener("click", handleFormSubmit);

  // Part 5: Open/close the details element on mouseover/mouseout
  document.getElementsByTagName("details")[0].addEventListener("mouseover", openDetails);
  document.getElementsByTagName("details")[0].addEventListener("mouseout", closeDetails);

  // Part 6: Print the content of all the span elements
  printSpanElements();

  // Part 7: Display time on Earth
  document.getElementById("earth_time_check").addEventListener("click", displayEarthTime);

  // Part 8: Display time on Mars
  document.getElementById("mars_time_check").addEventListener("click", displayMarsTime);
  // Part 8: Display time on Alpha Centauri Bb
  document.getElementById("acb_time_check").addEventListener("click", displayAlphaCentauriTime);


  // Part 9: Change background color of heading
  document.getElementsByTagName("h1")[0].addEventListener("click", changeHeadingBackgroundColor);

  // Part 10: Perform specified calculations
  document.getElementById("n1").addEventListener("input", calculate);
  document.getElementById("n2").addEventListener("input", calculate);
  document.getElementById("operation").addEventListener("change", calculate);

  // Part 11: Define function that traverses every node in the DOM
  walkTheDom(document, (element) => {
    console.log(element);
  });
}

function alienText() {
  const selectedPlanet = document.getElementById("planet").querySelector("option:checked").value;
  if(selectedPlanet !== "Earth") {
    document.querySelector(`p[hidden]`).removeAttribute("hidden");
  }
}

function convertDate(date) { //convert YYYY-MM-DD to MM/DD/YYYY
  const arr = date.split("-");
  [arr[0], arr[2]] = [arr[2], arr[0]]; // switch year and day
  [arr[0], arr[1]] = [arr[1], arr[0]]; // switch month and day
  return arr.join("/");
}

function isValidEmail(str){
  const re = /[\w\.]+@\w+\.\w+/;
  return re.test(str);
}

function handleFormSubmit() {
  const firstName = document.getElementById("firstname").value;
  const lastName = document.getElementById("lastname").value;
  if(firstName.length < 2|| lastName.length < 2) {
    alert("first name and last name must be at least two characters.")
  } else {
    const email = document.getElementById("email").value;
    if(!isValidEmail(email)) {
      alert("Invalid email format.");
    } else {
      const phone = document.getElementById("phone").value;
      if(phone.toString().length !== 10) {
        alert("Phone number must consists of 10 numbers");
      } else {
        const bday = convertDate(document.getElementById("bday").value);
        const color = document.getElementById("color").value;
        const gender = document.querySelector(`input[name=gender]:checked`).value;
        const activities = [];
        document.querySelectorAll(`input[type=checkbox]:checked`).forEach((activity) => {
          activities.push(activity.nextSibling.nodeValue.trim());
        });
        if(!bday || !color || !gender || !activities.length) {
          alert("Input cannot be empty.");
        } else {
          const row = document.createElement("tr");
          row.setAttribute("scope", "row");
          const nameCell = document.createElement("td");
          nameCell.innerHTML = `${firstName} ${lastName}`;
          const emailCell = document.createElement("td");
          emailCell.innerHTML = email;
          const phoneCell = document.createElement("td");
          phoneCell.innerHTML = phone;
          const bdayCell = document.createElement("td");
          bdayCell.innerHTML = bday;
          const colorCell = document.createElement("td");
          colorCell.innerHTML = color;
          const genderCell = document.createElement("td");
          genderCell.innerHTML = gender;
          const activitiesCell = document.createElement("td");
          const activitiesList = document.createElement("ul");
          const activitiesItems = [];
          for(let i = 0; i < activities.length; i++) {
            let temp = document.createElement("li");
            temp.innerHTML = activities[i];
            activitiesItems.push(temp);
          }
        
          for(let activity of activitiesItems) {
            activitiesList.appendChild(activity);
          }
        
          activitiesCell.appendChild(activitiesList);
        
          row.appendChild(nameCell);
          row.appendChild(emailCell);
          row.appendChild(phoneCell);
          row.appendChild(bdayCell);
          row.appendChild(colorCell);
          row.appendChild(genderCell);
          row.appendChild(activitiesCell);
        
          document.getElementsByTagName("tbody")[0].appendChild(row);
        }
      }
    }
  }
}

function openDetails() {
  document.getElementsByTagName("details")[0].setAttribute("open", true);
}

function closeDetails() {
  document.getElementsByTagName("details")[0].removeAttribute("open");
}

function printSpanElements() {
  console.log(Array.from(document.getElementsByTagName("span")).map(element => element.innerHTML).join(""));
}

function displayEarthTime() {
  document.getElementById("earth_time").innerHTML = `It is currently ${new Date().toLocaleTimeString()} on Earth.`;
}

function displayMarsTime() {
  // 86400000 milliseconds in a day
  // 1 earth year is 687 days on mars
  const days = new Date().valueOf() / 86400000;
  const marsTime = (1970 + days / 687).toString().split(".");
  const marsDay = (Number(`0.${marsTime[1]}`) * 687).toString().split(".")[0];
  document.getElementById("mars_time").innerHTML = `It is day ${marsDay} of year ${marsTime[0]} on Mars.`;
}

function sendAjaxGet(url, func) {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
    if (this.status == 200 && this.readyState == 4) {
      func(this);
    }
  }
  xhr.open("GET", url);
  xhr.send();
}

function getAlphaCentauriTime(xhr) {
  const response = JSON.parse(xhr.response);
  const period = response.exoplanets[1].per;
  const days =new Date().valueOf() / 86400000; // 86400000 milliseconds in a day
  const alphaTime = (1970 + days/period).toString().split(".");
  const alphaDay = (Number(`0.${alphaTime[1]}`) * period).toString().split(".")[0];
  document.getElementById("acb_time").innerHTML = `It is day ${alphaDay} of year ${alphaTime[0]} on Alpha Centauri Bb.`;
}

function displayAlphaCentauriTime() {
  const url = "http://www.astropical.space/astrodb/api-exo.php?which=distance&limit=2&format=json"
  sendAjaxGet(url, getAlphaCentauriTime);
}

function changeHeadingBackgroundColor() {
  setTimeout(() => {
    let randomColor = 0x000000;
    while(parseInt(randomColor, 16) < 0x333333) { // makes sure the color isn't too dark
      randomColor = Math.floor(Math.random() * 16777215).toString(16);
    }
    document.getElementsByTagName("h1")[0].style["background-color"] = `#${randomColor}`;
  }, 3000);

}

function calculate(){
  function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
  }
  const operation = document.getElementById("operation").querySelector("option:checked").value;
  const first = parseInt(document.getElementById("n1").value);
  const second = parseInt(document.getElementById("n2").value);
  const result = document.getElementById("result");
  if(isNumeric(first) && isNumeric(second)) {
    switch(operation) {
      case "Add": 
        result.innerHTML = first + second;
        break;
      case "Subtract":
        result.innerHTML = first - second;
        break;
      case "Divide":
        if(second === 0)
          result.innerHTML = "Cannot divide by 0."
        else
          result.innerHTML = first / second;
        break;
      case "Multiply":
        result.innerHTML = first * second;
        break;
      default:
        result.innerHTML = "Invalid operation."
    }
  }
}

function walkTheDom(node, func) {
  func(node);
  node = node.firstChild;
  while (node) {
      walkTheDom(node, func);
      node = node.nextSibling;
  }
}
