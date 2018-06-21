let url = "http://localhost:8082/ERS/mpending"
	
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
    let epending = JSON.parse(response);
    let eArr = epending.mriplist
    let table = document.getElementById("table");
    let count = 0;
    for(i in eArr){
    	row = document.createElement("tr");     
        row.innerHTML = `<td> ${eArr[i].reimbursementid} </td>
        <td> ${eArr[i].reqname} </td>
        <td> ${eArr[i].requesterid} </td>
        <td> ${eArr[i].reason} </td>	
        <td> ${eArr[i].totalcost} </td>
        <td> ${eArr[i].billDate} </td>
        <td><input type="checkbox" name="myTextEditBox" value = "${eArr[i].reimbursementid}"/></td>`;
        row.setAttribute("scope", "row");
        table.appendChild(row);
    }
}

