let url = "http://localhost:8082/ERS/views"
	
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
    let views = JSON.parse(response);
    let eArr = views.eilist
    let table = document.getElementById("table");
    for(i in eArr){
    	row = document.createElement("tr");     
        
        row.innerHTML = `<td> ${eArr[i].userid} </td>
        <td> ${eArr[i].name} </td>
        <td> ${eArr[i].email} </td>
        <td> ${eArr[i].phone} </td>
        <td> ${eArr[i].street} </td>
        <td> ${eArr[i].city} </td>
        <td> ${eArr[i].state} </td>
        <td> <input type ="submit" href = "pempdir" name = "linkbutton" value = "${eArr[i].userid}"> </td>`;
        row.setAttribute("scope", "row")
        table.appendChild(row);	
    }
    
}