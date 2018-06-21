function sendAjaxGet(url, func){
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status ==200){
            func(this); //this refers to the XHR object
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

sendAjaxGet("http://localhost:8082/Project1/profile", displayUser)

function displayUser(xhr){
	user = JSON.parse(xhr.response)
	console.log(user);
	status = user.employee.manager;
	
	document.getElementById("fname").innerHTML = user.employee.fName;
	document.getElementById("lname").innerHTML = user.employee.lName;
	document.getElementById("username").innerHTML = user.employee.username;
	document.getElementById("password").innerHTML = user.employee.password;
	document.getElementById("address").innerHTML = user.employee.address;
	document.getElementById("city").innerHTML = user.employee.city;
	document.getElementById("state").innerHTML = user.employee.state;
	document.getElementById("zipcode").innerHTML = user.employee.zipcode;
	
	if(status == 0){
		document.getElementById("status").innerHTML = "Employee";
	}else{
		document.getElementById("status").innerHTML = "Manager";
	}
}	