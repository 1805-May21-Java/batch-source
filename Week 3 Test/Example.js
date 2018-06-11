let baseUrl = "https://randomuser.me/api/"

function generateUser() {
    sendAjaxGet(baseUrl, displayUser);
}

function get20Users() {
    let input = "?results=20";

    sendAjaxGet(baseUrl+input, displayUser);
}

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest());
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayUser(xhr) {
    let response = xhr.response;
    let user = JSON.parse(response);

    document.getElementById("firstname").innerHTML = user.results.name.first; 
    document.getElementById("lastname").innerHTML = user.results.name.last; 
    document.getElementById("city").innerHTML = user.results.name.last; 
    document.getElementById("state").innerHTML = user.results.name.last; 
    document.getElementById("email").innerHTML = user.results.name.last; 

}