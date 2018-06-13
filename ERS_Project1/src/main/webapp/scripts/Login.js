document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("warning").setAttribute("hidden", true);
    sendAjaxGet("http://localhost:8082/ERS_Project1/Warning", function (xhr) {
        let info = JSON.parse(xhr.response);
        if (info.warning !== null) {
            document.getElementById("warning").removeAttribute("hidden");
            document.getElementById("warningMessage").innerHTML = info.warning;
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

