let baseUrl = "http://api.apixu.com/v1/current.json?key=4f9095e1ed93462689a193305182003&q=";

function searchWeather() {
    let input = document.getElementById("zipcode").value;
    if(input.length !==5 | input<0){
        document.getElementById("alert").innerHTML = "Invalid Zipcode";
    }else{
        document.getElementById("alert").innerHTML = "";
        sendAjaxGet(baseUrl+input,displayWeather);
    }
}

function sendAjaxGet(url, func) {
    let xhr= (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if(this.status == 200&&this.readyState == 4){
            func(this);
        }
    };
    xhr.open("GET",url);
    xhr.send();
}

function displayWeather(xhr){
    let response = xhr.response;
    let weather = JSON.parse(response);
    console.log(weather);r
    document.getElementById("location").innerHTML = "Weather for "+weather.location.name+", "+weather.location.region;
    document.getElementById("icon").setAttribute("src","http:"+weather.current.condition.icon);

    document.getElementById("status").innerHTML = weather.current.condition.text;
    document.getElementById("temperature").innerHTML = weather.current.temp_f + "F (feels like "+weather.current.feelslike_f+")";
}