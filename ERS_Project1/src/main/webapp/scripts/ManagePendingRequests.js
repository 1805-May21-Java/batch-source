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
                temp.innerHTML = "$" + request.amount;
                row.appendChild(temp);

                temp = document.createElement("td");
                let details = document.createElement("details");
                let summary = document.createElement("summary");
                summary.innerHTML = "Details";
                let reqInfo = document.createElement("p");
                summary.innerHTML = request.description;
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
                            <select class="form-control" name="${request.id}">
                                <option value="appprove">approve</option>
                                <option value="deny">deny</option>
                            </select>
                            <button class="btn myButton" type="submit">Reply</button>
                        </form>`;
                } else {
                    temp.innerHTML = request.status;
                }
                row.appendChild(temp);

                if (request.status != "PENDING") {
                    temp = document.createElement("td");
                    date = new Date(request.dateResolved);
                    temp.innerHTML = date.getMonth() + "-" + date.getDate() + "-" + date.getFullYear();
                    row.appendChild(temp);
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