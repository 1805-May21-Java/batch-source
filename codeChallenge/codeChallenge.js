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
function searchPerson(){
	let baseurl="https://randomuser.me/api/?results=";
	let input = document.getElementById("name").value;
	console.log(input);
	if (input == "" | input < 0){
		document.getElementById("alert").innerHTML = "Invalid Input";
	} else {
		document.getElementById("alert").innerHTML = "";
		sendAjaxGet(baseurl + input, displayPerson);
	}
}function displayPerson(xhr){
	let response = xhr.response;
	let person = JSON.parse(response);
	console.log(response);
	console.log(person);
	if(person.count == 0){
		document.getElementById("alert").innerHTML = "Invalid input";
	} else {
	document.getElementById("name").innerHTML = person.results[0].name.title + person.results[0].name.first + person.results[0].name.last;
	document.getElementById("title").innerHTML = titleCase(person.results[0].name.title) + ".";
	document.getElementById("fname").innerHTML = titleCase(person.results[0].name.first);
	document.getElementById("lname").innerHTML = titleCase(person.results[0].name.last);
	document.getElementById("phone").innerHTML = "Phone Number: " + person.results[0].phone;
	document.getElementById("email").innerHTML = "Email address: " + person.results[0].email;
}}
function titleCase(str){
	str = str.toLowerCase();
	str = str.split(' ')
	for (var i = 0; i < str.length; i++){
		str[i] = str[i].charAt(0).toUpperCase() + str[i].slice(1);
	}
	return str.join(' ');
}
function addRow(xhr){
	let r = xhr.response;
	let obj = JSON.parse(r);
	let p = obj.results[0];
	let title = titleCase(p.name.title);
	let first = titleCase(p.name.first);
	let last = titleCase(p.name.last);
	let phone = p.phone;
	let email = p.email;
	let row = document.createElement("tr");
    row.setAttribute("scope", "row")
    let cell1 = document.createElement("td");
    cell1.innerHTML = title;
    let cell2 = document.createElement("td");
    cell2.innerHTML = first;
    let cell3 = document.createElement("td");
    cell3.innerHTML = last;
    let cell4 = document.createElement("td");
    cell4.innerHTML = phone;
    let cell5 = document.createElement("td");
    cell5.innerHTML = email;
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    document.getElementById("tbl").appendChild(row);
}
function createTable(){
	let numberOfRows = Number(document.getElementById("numRows").value)
	document.getElementById("tbl").innerHTML = "";
	let row = document.createElement("tr");
	row.setAttribute("scope", "row")
    let cell1 = document.createElement("th");
    cell1.innerHTML = "Title";
    let cell2 = document.createElement("th");
    cell2.innerHTML = "First Name";
    let cell3 = document.createElement("th");
    cell3.innerHTML = "Last Name";
    let cell4 = document.createElement("th");
    cell4.innerHTML = "Phone Number";
    let cell5 = document.createElement("th");
    cell5.innerHTML = "Email Address";
    row.appendChild(cell1);
    row.appendChild(cell2);
    row.appendChild(cell3);
    row.appendChild(cell4);
    row.appendChild(cell5);
    document.getElementById("tbl").appendChild(row);
    for(var i = 0; i < numberOfRows; i++){
    	sendAjaxGet('https://randomuser.me/api/', addRow)
    }
}