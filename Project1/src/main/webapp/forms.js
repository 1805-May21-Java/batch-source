let messagesAndErrors = document.getElementById("messagesAndErrors");
let infoUrl = "http://localhost:8082/ERS/info";

window.onload = sendAjaxGet(infoUrl, loadMessagesAndErrors);

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject());

    xhr.onreadystatechange = function(){
        if(xhr.status >= 200 && xhr.status < 300 && xhr.readyState == 4){
            func(xhr, url);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function sendAjaxPost(url, str) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject());

    xhr.open("POST", url);
    xhr.send(str);
}

function loadMessagesAndErrors(xhr, url){
    let messageArr = JSON.parse(xhr.responseText).messages;
    let errorArr = JSON.parse(xhr.responseText).errors;

    while(messagesAndErrors.children[0]){
        messagesAndErrors.children[0].remove();
    }
    for(m of messageArr){
        if(m.type){
            newMessage = document.createElement("p");
            newMessage.innerHTML = "<img src=\"https://www.freeiconspng.com/uploads/light-bulb-lit-19.png\" width=20 height=20> " + m.message;
            messagesAndErrors.appendChild(newMessage);
            m.type = false;
        }
    }
    for(e of errorArr){
        if(e.type){
            newError = document.createElement("p");
            newError.innerHTML = "<img src=\"https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Achtung.svg/220px-Achtung.svg.png\" width=20 height=20> " + e.message;
            messagesAndErrors.appendChild(newError);
            e.type = false;
        }
    }

    let obj = {errors: errorArr, messages: messageArr};
    let obJSON = JSON.stringify(obj);

    sendAjaxPost(url, obJSON);
}