document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("goToManageRequests").setAttribute("hidden", true);
    sendAjaxGet("http://localhost:8082/ERS_Project1/DisplayMyRequests", function (xhr) {
        let info = JSON.parse(xhr.response);
        document.getElementById("empId").value = info.id;
        if(info.staff.length > 0) {
            document.getElementById("goToManageRequests").removeAttribute("hidden");
        }
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