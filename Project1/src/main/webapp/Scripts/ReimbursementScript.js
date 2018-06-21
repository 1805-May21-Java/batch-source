const data = new Array ();
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

sendAjaxGet("http://localhost:8082/Project1/session", getReimbs)

function getReimbs(xhr)
{

    let reimbs = JSON.parse(xhr.response);

    table1 = document.getElementById("pendingBody");
    table2 = document.getElementById("resolvedBody");

    if(reimbs[0].isManager === 1)
    {
        document.getElementById("empIdDiv").removeAttribute("hidden");
    }

    for(i = 1; i< reimbs.length; i++)
    {
        data[i]=reimbs[i];
        if(reimbs[i].pending === 1)
        {
            row = document.createElement("tr");
            col1 = document.createElement("td");
            col2 = document.createElement("td");
            col3 = document.createElement("td");
            col4 = document.createElement("td");

            col1.innerHTML = reimbs[i].reason;
            col2.innerHTML = reimbs[i].amount;
            col3.innerHTML = reimbs[i].userId;

            row.appendChild(col1);
            row.appendChild(col2);
            row.appendChild(col3);

            if(((reimbs[i].userId !== reimbs[0].id) && reimbs[0].isManager === 1) || reimbs[0].managerId === 0)
            {
                let reimbId = reimbs[i].id;
                let userId = reimbs[0].id;
                col4.innerHTML = `<button class = 'btn btn-info' onclick='sendReimb(${reimbId}, ${userId})'>Approve</button>`;
            }

            row.appendChild(col4);
            table1.appendChild(row);
        }
        else if(reimbs[i].pending === 0)
        {
            row = document.createElement("tr");
            col1 = document.createElement("td");
            col2 = document.createElement("td");
            col3 = document.createElement("td");
            col4 = document.createElement("td");

            col1.innerHTML = reimbs[i].reason;
            col2.innerHTML = reimbs[i].amount;
            col3.innerHTML = reimbs[i].userId;
            col4.innerHTML = reimbs[i].resolvedBy;

            row.appendChild(col1);
            row.appendChild(col2);
            row.appendChild(col3);
            row.appendChild(col4);

            table2.appendChild(row);
        }

    }
}

form = document.getElementById('nav');
button = document.getElementById('dropdown');
pending = document.getElementById('pending');
resovled = document.getElementById('resolved');

function sendReimb(reimbId, userId)
{
    let url = "http://localhost:8082/Project1/sendReimb"

    function sendAjaxPost(url, func){
        let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
        xhr.onreadystatechange = function() {
            if(this.readyState == 4 && this.status ==200){
                func(this); //this refers to the XHR object
            }
        }
        xhr.open("POST", url);
        xhr.send(userId+","+reimbId);
    }

    sendAjaxPost(url,postFunction);
}
function postFunction()
{
}

function getEmpById()
{
    table3 = document.getElementById("idBody");

    for(i=1; i<data.length; i++)
    {
        if(data[i].userId+""=== document.getElementById("empId").value)
        {

            row = document.createElement("tr");
            col1 = document.createElement("td");
            col2 = document.createElement("td");
            col3 = document.createElement("td");

            col1.innerHTML = data[i].reason;
            col2.innerHTML = data[i].amount;
            col3.innerHTML = data[i].userId;

            row.appendChild(col1);
            row.appendChild(col2);
            row.appendChild(col3);

            table3.appendChild(row);
        }

    }

}
