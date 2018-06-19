var baseUrlString = "http://localhost:8082/Project1/request"
function getRequests(){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        //console.log(xhr.readyState);
        if (this.status == 200 && this.readyState == 4) {
            showRequests(this);
        }
    }
    xhr.open("GET", baseUrlString);
    xhr.send();
}

function showRequests(xhr){
    let response = JSON.parse(xhr.response).requests;

    console.log(response);
    for(let i=0; i<response.length; i++){
        let row = document.createElement("tr");
        row.setAttribute("scope", "row");

        let cell1 = document.createElement("td");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");
        let cell4 = document.createElement("td");

        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);


        cell1.innerHTML = response[i].requestId;
        cell2.innerHTML = response[i].amount;
        cell3.innerHTML = response[i].status==0?"Pending":(response[i].status==1?"Approved":"Denied");
        cell4.innerHTML = response[i].comments;

        document.getElementsByTagName("tbody")[0].appendChild(row);
    }
}

getRequests();