let baseURL = "http://api.open-notify.org/iss-now.json";
let inputURL = "http://api.open-notify.org/iss-pass.json?lat=LAT&lon=LON";

function getISSLocation() {
    sendAjaxGet(baseURL, displayLocation);
}

function findISSLocation() {
    let lat = document.getElementById("latitude").value;
    let lon = document.getElementById("longitude").value;

    inputURL = inputURL.replace("LAT", lat);
    inputURL = inputURL.replace("LON", lon);
    sendAjaxGet(inputURL, displayPassTime);
}


function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        //console.log(xhr.readyState);
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayLocation(xhr) {
    let response = xhr.response;
    let location = JSON.parse(response);

    document.getElementById("location").innerHTML = "Current Location is " + location.iss_position.latitude + "°, " + location.iss_position.longitude + "°";
}

function convertUNIXTimestampToTime (input) {
    var time = new Date(input);
    return time.toLocaleString();
    }

function displayPassTime(xhr) {
    let response = xhr.response;
    let passTime = JSON.parse(response);
    console.log(passTime);
    let idCount = 1;
    for (var pass in passTime.response) {
        console.log();
        let row = document.createElement("tr");
        let cell1 = document.createElement("td");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");
        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);

        cell1.innerHTML = idCount++;
        cell2.innerHTML = convertUNIXTimestampToTime(passTime.response[pass].risetime);
        cell3.innerHTML = (passTime.response[pass].duration);

        document.getElementById("passTimes").appendChild(row);
    }
    
}