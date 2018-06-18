let menu = "profile";
function changeMenu(str) {
    switch (str) {
        case "profile":
            document.getElementById("profileContent").removeAttribute("hidden");
            document.getElementById("updateContent").setAttribute("hidden", true);
            document.getElementById("changePassword").setAttribute("hidden", true);
            break;
        case "update":
            document.getElementById("profileContent").setAttribute("hidden", true);
            document.getElementById("updateContent").removeAttribute("hidden");
            document.getElementById("changePassword").setAttribute("hidden", true);
            break;
        case "password":
            document.getElementById("profileContent").setAttribute("hidden", true);
            document.getElementById("updateContent").setAttribute("hidden", true);
            document.getElementById("changePassword").removeAttribute("hidden");
            break;
        default:

    }
}

document.addEventListener("DOMContentLoaded", function () {
    sessionStorage.setItem("option", "all");
    changeMenu(menu);
    document.getElementById("goToManageRequests").setAttribute("hidden", true);

    document.getElementById("warning").setAttribute("hidden", true);
    sendAjaxGet("http://localhost:8082/ERS_Project1/Warning", function (xhr) {
        let info = JSON.parse(xhr.response);
        if (info.warning !== null) {
            document.getElementById("warning").removeAttribute("hidden");
            document.getElementById("warningMessage").innerHTML = info.warning;
        }
    });

    document.getElementById("update").setAttribute("hidden", true);
    sendAjaxGet("http://localhost:8082/ERS_Project1/DisplayProfile", function (xhr) {
        let info = JSON.parse(xhr.response);
        //console.log(info);

        document.getElementById("id").value = info.id;
        document.getElementById("pwdId").value = info.id;
        let firstName = info.firstName[0] + info.firstName.substr(1).toLowerCase();
        document.getElementById("firstName").value = firstName;
        let lastName = info.lastName[0] + info.lastName.substr(1).toLowerCase();
        document.getElementById("lastName").value = lastName;

        document.getElementById("name").innerHTML = `Welcome, ${firstName} ${lastName}`;
        document.getElementById("emplId").innerHTML = `Employee #${info.id}`;
        document.getElementById("email").innerHTML = `Email: ${info.email.toLowerCase()}`;
        document.getElementById("upEmail").value = info.email.toLowerCase();

        if (info.staff.length > 0) {
            document.getElementById("goToManageRequests").removeAttribute("hidden");
            let point = document.getElementById("staff");

            let staff = document.createElement("details");
            let summary = document.createElement("summary");
            summary.innerHTML = "Staff";
            staff.appendChild(summary);


            let list = document.createElement("ul")
            //point.appendChild(temp);

            for (p of info.staff) {
                let temp = document.createElement("li");
                firstName = p.firstName[0] + p.firstName.substr(1).toLowerCase();
                lastName = p.lastName[0] + p.lastName.substr(1).toLowerCase();
                temp.innerHTML = `${firstName} ${lastName}`
                list.appendChild(temp);
            }
            staff.appendChild(list);
            point.appendChild(staff);
        }
        document.getElementById("update").removeAttribute("hidden");
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