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


sendAjaxGet("http://localhost:8082/ERSProject1/register", displayManagers);

function displayManagers(xhr){
	managers = JSON.parse(xhr.response);
	managersArr = managers.managers;
	select = document.getElementById("select");
	
	for(i in managersArr){
		nextOption = document.createElement("option");
		nextOption.innerHTML = `${managersArr[i].firstname} ${managersArr[i].lastname}`;
		nextOption.value = managersArr[i].id;
		select.appendChild(nextOption);
	}
	
}