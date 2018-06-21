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

sendAjaxGet("http://localhost:8082/ServletJDBCDemo/location", displayLocations)

function displayLocations(xhr){
	locations = JSON.parse(xhr.response)
	locationsArr = locations.locations;
	table = document.getElementById("table");
	
	for(i in locationsArr){
		nextRow = document.createElement("tr");
		nextRow.innerHTML = `<td> ${locationsArr[i].city} </td>
		<td> ${locationsArr[i].state} </td>
		<td> ${locationsArr[i].zipcode} </td>`;
		nextRow.setAttribute("scope","row");
		table.appendChild(nextRow);
	}
	
}