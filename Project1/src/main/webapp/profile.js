let sessionUrl = "http://localhost:8082/ERS/session";
let empl = null;

sendAjaxGet(sessionUrl, initProfilePage);

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject());

    xhr.onreadystatechange = function(){
        if(xhr.status >= 200 && xhr.status < 300 && xhr.readyState == 4){
            func(xhr);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function initProfilePage(xhr){
    empl = JSON.parse(xhr.responseText);
    
    let welcome = document.getElementById("welcome");
    welcome.innerHTML = "Welcome, " + empl.first + " " + empl.last + "!";
}