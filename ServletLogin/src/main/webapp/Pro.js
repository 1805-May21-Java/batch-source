baseurl = "http://localhost:8082/ServletLogin/session";

document.onload= funt();

function funt(){
    func(baseurl,funct);
}

function func(url,f) {
    let xhr= (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if(this.status == 200&&this.readyState == 4){
            f(this);
        }
    };
    xhr.open("GET",url);
    xhr.send();
}

function funct(xhr) {
    let response = xhr.response;
    let Job = JSON.parse(response);
    let thing = document.getElementById("user");
    thing.innerHTML = Job.username;
}



