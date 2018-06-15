document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("update").setAttribute("hidden", true);
    sendAjaxGet("http://localhost:8082/ERS_Project1/DisplayProfile", function (xhr) {
        let info = JSON.parse(xhr.response);
        //console.log(info);

        let firstName = info.firstName[0] + info.firstName.substr(1).toLowerCase();
        let lastName = info.lastName[0] + info.lastName.substr(1).toLowerCase();

        document.getElementById("name").innerHTML = `Welcome, ${firstName} ${lastName}`;
        document.getElementById("emplId").innerHTML = `Employee #${info.id}`;
        document.getElementById("email").innerHTML = `Email: ${info.email.toLowerCase()}`;
        
        if (info.staff.length > 0) {
            
            let point = document.getElementById("staff");
            point.innerHTML = "Staff:"
            let list = document.createElement("ul")
            //point.appendChild(temp);

            for(p of info.staff) {
                let temp = document.createElement("li");
                firstName = p.firstName[0] + p.firstName.substr(1).toLowerCase();
                lastName = p.lastName[0] + p.lastName.substr(1).toLowerCase();
                temp.innerHTML = `${firstName} ${lastName}`
                list.appendChild(temp);
            }
            point.appendChild(list);
        } else {
        	document.getElementById("goToManageRequests").setAttribute("hidden", true);
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