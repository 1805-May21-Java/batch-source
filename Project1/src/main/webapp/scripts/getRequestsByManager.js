var baseUrlString = "http://localhost:8082/Project1/request?Approve=true"
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
        let cell5 = document.createElement("td");
        let cell6 = document.createElement("td");

        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);
        row.appendChild(cell4);
        row.appendChild(cell5);
        row.appendChild(cell5);
        row.appendChild(cell6);

        let reqId = response[i].requestId;

        cell1.innerHTML = response[i].requestId;
        cell2.innerHTML = response[i].name;
        cell3.innerHTML = response[i].amount;
        cell4.innerHTML = response[i].status==0?"Pending":(response[i].status==1?"Approved":"Denied");
        cell5.innerHTML = response[i].comments;
        cell6.innerHTML = `<button type="button" id="approve" class="btn btn-success" onClick=setApprove(${reqId},1)>Approve</button>
        <button type="button" id="deny" class="btn btn-danger" onClick=setApprove(${reqId},2)>Deny</button>`;

        document.getElementsByTagName("tbody")[0].appendChild(row);
    }
}

getRequests();

function setApprove(reqId, status){

    let url = "http://localhost:8082/Project1/request";


    console.log(reqId);
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        //console.log(xhr.readyState);
        if (this.status == 200 && this.readyState == 4) {
        }
    }
    xhr.open("POST", url);
    xhr.send("requestId="+reqId+"&status="+status);
}
