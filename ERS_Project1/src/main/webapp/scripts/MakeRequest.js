document.addEventListener("DOMContentLoaded", function () {
    sendAjaxGet("http://localhost:8082/ERS_Project1/DisplayMyRequests", function (xhr) {
        let info = JSON.parse(xhr.response);
        console.log(info);
        document.getElementById("empId").value = info.id;
        console.log (document.getElementsByName("empId")[0].value);
        if(info.staff.length < 1) {
            document.getElementById("goToManageRequests").setAttribute("hidden", true);
            
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