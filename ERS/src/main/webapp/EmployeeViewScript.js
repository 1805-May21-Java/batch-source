let url = "http://localhost:8082/ERS/view"
	
function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        //console.log(xhr.readyState);
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

sendAjaxGet(url, displayEPending);

function displayEPending(xhr){
	let response = xhr.response;
    let eview = JSON.parse(response);
    let eArr = eview.views;
    document.getElementById("Name").innerHTML = "Name: " + eArr.name;
    document.getElementById("Username").innerHTML = "Username: " + eArr.username;
    document.getElementById("Email").innerHTML = "Email: " + eArr.email;
    document.getElementById("Birthday").innerHTML = "Birthday: " + eArr.birthday;
    document.getElementById("Phonenumber").innerHTML = "Phonenumber: " +  eArr.phone;
    document.getElementById("Location1").innerHTML = "Location: " + eArr.street;
    document.getElementById("Location2").innerHTML = eArr.city + ", " + eArr.state + " " + eArr.zipcode;
}