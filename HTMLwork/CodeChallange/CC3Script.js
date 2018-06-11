let baseUrl = "https://randomuser.me/api/?results=";
function submit() {
    let uname = document.getElementById("nameuser").value;
    let usernum = document.getElementById("cnumber").value;
    let uemail = document.getElementById("email").value;
    if((uname&&usernum&&uemail) !== ""){
            let nrow = document.createElement("tr");
            let row1 = document.createElement("td");
            let row2 = document.createElement("td");
            let row3 = document.createElement("td");

            nrow.appendChild(row1);
            nrow.appendChild(row2);
            nrow.appendChild(row3);

            row1.innerHTML = uname;
            row2.innerHTML = usernum;
            row3.innerHTML = uemail;
            document.getElementById("UserInfo").appendChild(nrow);
    }
    else {
        document.getElementById("notification").innerHTML = "Please Enter all information that is listed above";
    }
}

function findEmployees() {
    let enumb = document.getElementById("employeenum").value;
    sendAjaxGet(baseUrl+enumb,listEmployees);
}

function listEmployees(xhr) {
    let response = xhr.response;
    let employees = JSON.parse(response);
    console.log(employees);
    let listnum = document.getElementById("employeenum").value;
    for(i = 0; i<listnum; i++){
    let nrow = document.createElement("tr");
    let row1 = document.createElement("td");
    let row2 = document.createElement("td");
    let row3 = document.createElement("td");

    nrow.appendChild(row1);
    nrow.appendChild(row2);
    nrow.appendChild(row3);



        row1.innerHTML = employees.results[i].name.first;
        row2.innerHTML = employees.results[i].cell;
        row3.innerHTML = employees.results[i].email;
        document.getElementById("UserInfo").appendChild(nrow);
    }
}
function sendAjaxGet(url, func) {
    let xhr= (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if(this.status == 200&&this.readyState == 4){
            func(this);
        }
    };
    xhr.open("GET",url);
    xhr.send();
}
