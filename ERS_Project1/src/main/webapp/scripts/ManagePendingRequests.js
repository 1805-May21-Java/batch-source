document.addEventListener("DOMContentLoaded", function () {
    if (sessionStorage.getItem("option") == null) {
        sessionStorage.setItem("option", "all");
    }
    sendAjaxGet("http://localhost:8082/ERS_Project1/EmployeeRequests", function (xhr) {
        let info = JSON.parse(xhr.response);
        //console.log(info);
        let employees = info.staff;
        //console.log(employees);

        let table = document.getElementById("employeeTable");
        let resTable = document.getElementById("resolvedEmployeeTable");
        for (let employee of employees) {
            if (employee.requests.length > 0) {
                let option = document.createElement("option");
                option.value = "emp" + employee.id
                option.innerHTML = employee.firstName + " " + employee.lastName;
                document.getElementById("selectEmp").appendChild(option);
            }
            for (let request of employee.requests) {
                if (sessionStorage.getItem("option") != "all" && sessionStorage.getItem("option") != "emp" + employee.id) {
                    break;
                }
                let row = document.createElement("tr");

                let temp = document.createElement("td");
                temp.innerHTML = employee.firstName + " " + employee.lastName;
                row.appendChild(temp);

                temp = document.createElement("td");
                temp.innerHTML = "$" + request.amount.toFixed(2);
                row.appendChild(temp);

                temp = document.createElement("td");
                let details = document.createElement("details");
                let summary = document.createElement("summary");
                summary.innerHTML = "Details";
                let reqInfo = document.createElement("p");
                reqInfo.innerHTML = request.description;
                details.appendChild(summary);
                details.appendChild(reqInfo);
                temp.appendChild(details);
                row.appendChild(temp);

                temp = document.createElement("td");
                let date = new Date(request.dateRequested);
                temp.innerHTML = date.getMonth() + "-" + date.getDate() + "-" + date.getFullYear();
                row.appendChild(temp);


                temp = document.createElement("td");
                if (request.status == "PENDING") {
                    temp.innerHTML = `
                        <form class="form-group form-inline" action="Resolve" method="post">
                            <input name="reqId" value="${request.id}" hidden>
                            <input name="manager" value="${info.firstName} ${info.lastName}" hidden>
                            <select class="form-control" name="${request.id}">
                                <option value="approve">approve</option>
                                <option value="deny">deny</option>
                            </select>
                            <button class="btn myButton" type="submit">Reply</button>
                        </form>`;
                } else {
                    date = new Date(request.dateResolved);
                    temp.innerHTML = date.getMonth() + "-" + date.getDate() + "-" + date.getFullYear() + "<br>" + 
                    request.status + " BY<br>" + request.resolvedBy;
                }
                row.appendChild(temp);

                if (request.status != "PENDING") {
                    resTable.appendChild(row)
                } else {
                    table.appendChild(row);
                }


                
            }
        }

        document.getElementById("selectEmp").value = sessionStorage.getItem("option");
    });
});



function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 & this.readyState == 4) {
            func(this);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function saveOption() {
    sessionStorage.setItem("option", document.getElementById("selectEmp").value);
}