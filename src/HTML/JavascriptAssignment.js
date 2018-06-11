//1.
var a = document.getElementsByName("google");
a[0].href = "https://www.google.com/";
a = document.getElementsByName("twitter");
a[0].href = "https://www.twitter.com/";
a = document.getElementsByName("slack");
a[0].href = "https://slack.com/";
a = document.getElementsByName("javadocs");
a[0].href = "http://www.oracle.com/technetwork/java/javase/documentation/index-jsp-135444.html?";

//2.
var planetSelect = document.getElementById("planet");
planetSelect.options[3].disabled = true;

//3.
planetSelect.onchange = function(){
	var message = document.getElementsByTagName("p")[5];
	message.removeAttribute("hidden");
	switch(planetSelect.selectedIndex){
		case 0:
			message.style.visibility = "hidden";
			break;
		default:
			message.style.visibility = "visible";
			break;
	}
};

//4.
let firstName = document.getElementById("firstname");
let lastName = document.getElementById("lastname");
let email = document.getElementById("email");
let phone = document.getElementById("phone");
let birthday = document.getElementById("bday");
let genderRadio = document.getElementsByName("gender");
let color = document.getElementById("color");
let activityCheckbox = document.getElementsByClassName("activity");
let table = document.getElementsByClassName("table")[0];

let submitButton = document.getElementById("form-sub");

var regEmail = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/
var regPhone = /^(\+\d{1,2}\s)?\(?\d{3}\)?[\s.-]\d{3}[\s.-]\d{4}$/;
submitButton.addEventListener("click", function(){
	if(firstName.value.length < 2 || lastName.value.length < 2 || !regEmail.test(email.value)|| !regPhone.test(phone.value) || birthday.value.length == 0 || (!genderRadio[0].checked && !genderRadio[1].checked && !genderRadio[2].checked) || (!activityCheckbox[0].checked && !activityCheckbox[1].checked && !activityCheckbox[2].checked && !activityCheckbox[3].checked)){
		alert("Form is incomplete");
	} else {
		let newRow = table.insertRow(table.rows.length);
		let checkedGender;
		if(genderRadio[0].checked){
			checkedGender = genderRadio[0].value;
		} else if (genderRadio[1].checked){
			checkedGender = genderRadio[1].value;
		} else if (genderRadio[2].checked){
			checkedGender = genderRadio[2].value;
		}
		let activitiesList = [];
		if(activityCheckbox[0].checked){
			activitiesList.push(activityCheckbox[0].value);
		}
		if(activityCheckbox[1].checked){
			activitiesList.push(activityCheckbox[1].value);
		}
		if(activityCheckbox[2].checked){
			activitiesList.push(activityCheckbox[2].value);
		}
		if(activityCheckbox[3].checked){
			activitiesList.push(activityCheckbox[3].value);
		}
		
		let ul = document.createElement("ul");
		newRow.insertCell(0).innerHTML = firstName.value;
		newRow.insertCell(1).innerHTML = email.value;
		newRow.insertCell(2).innerHTML = phone.value;
		newRow.insertCell(3).innerHTML = birthday.value;
		newRow.insertCell(4).innerHTML = color.value;
		newRow.insertCell(5).innerHTML = checkedGender;
		newRow.insertCell(6).appendChild(ul);
		for(i = 0; i<activitiesList.length; i++){
			var li = document.createElement("li");
			ul.appendChild(li);
			li.innerHTML = activitiesList[i];
		}
	}
	
});

//5.
let details = document.getElementsByTagName("details")[0];
details.addEventListener("mouseover", openDetails);
function openDetails() {
    details.setAttribute("open", "true");
}
details.addEventListener("mouseout", function () {
    details.removeAttribute("open");
});

//6.
let spanElements = document.getElementsByTagName("span");
let spanContent ="";
for(i = 0; i< spanElements.length;i++){
	spanContent += spanElements[i].innerHTML;
}
console.log(spanContent);

//7.
let earthTimeCheck = document.getElementById("earth_time_check");
let earthTime = document.getElementById("earth_time");
earthTimeCheck.addEventListener("click", function () {
    earthTime.innerHTML = new Date();
});

//8.
let marsTimeCheck = document.getElementById("mars_time_check");
let marsTime = document.getElementById("mars_time");
let acbTimeCheck = document.getElementById("acb_time_check");
let acbTime = document.getElementById("acb_time");
marsTimeCheck.addEventListener("click", function(){
	marsTime.innerHTML = new Date(new Date / 687 * 365);
});
var baseURL = "http://www.astropical.space/astrodb/api-exo.php?which=name&limit=Cen&format=json";

acbTimeCheck.addEventListener("click", function(){
	let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            setAcbTime(this);
        }
    }
    xhr.open("GET", baseURL);
    xhr.send();
});
function setAcbTime(xhr) {
    let response = xhr.response;
    let acb = JSON.parse(response);
	console.log(acb);
    let acbPeriod = acb.exoplanets[0].per;
    acbTime.innerHTML = new Date(new Date() / acbPeriod);
}

//9.
function getRandomColor() {
  var letters = '0123456789ABCDEF';
  var color = '#';
  for (var i = 0; i < 6; i++) {
    color += letters[Math.floor(Math.random() * 16)];
  }
  return color;
}

let header = document.getElementsByTagName("h1")[0];

header.addEventListener("click", function(){
	setTimeout(setBackground,3000);
	//document.body.style.background = getRandomColor();
});

/*
header.onClick = setTimeout(setBackground,3000);
*/
function setBackground(){
	document.body.style.background = getRandomColor();
}

//10.
let n1 = document.getElementById("n1");
let n2 = document.getElementById("n2");
let operation = document.getElementById("operation");
let result = document.getElementById("result");
n1.setAttribute("type", "number");
n2.setAttribute("type", "number");

n1.addEventListener("change",function(){
	if(n2.value.length != 0){
		updateResult();
	}
});

n2.addEventListener("change",function(){
	if(n1.value.length != 0){
		updateResult();
	}
});

operation.onchange = function(){
	if(n1.value.length != 0 && n2.value.length !=0){
		updateResult();
	}
};

function updateResult(){
	switch(operation.selectedIndex){
	case 0:
		result.innerHTML = Number.parseFloat(n1.value) + Number.parseFloat(n2.value);
		break;
	case 1:
		result.innerHTML = Number.parseFloat(n1.value) - Number.parseFloat(n2.value);
		break;
	case 2:
		result.innerHTML = Number.parseFloat(n1.value) / Number.parseFloat(n2.value);
		break;
	case 3:
		result.innerHTML = Number.parseFloat(n1.value) * Number.parseFloat(n2.value);
		break;
	}
}

//11.
function walkTheDom(node, func){
	for(childNode of node.children){
		thisIsAFunc(childNode);
		walkTheDom(childNode, thisIsAFunc);
	}
}

function thisIsAFunc(node){
	console.log(node);
}