window.onload = function () {
    getAllCharacters();
}

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

function sendAjaxGetSync(url, func) {
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 & this.readyState == 4) {
            func(this);
        }
    }

    xhr.open("GET", url, false);
    xhr.send();
}

var page;
function getAllCharacters() {
    for (page = 1; page <= 9; page++) {
        sendAjaxGetSync("https://swapi.co/api/people/?page=" + page, fillDropDown);
    }
}

function fillDropDown(xhr) {
    let response = xhr.response;
    let info = JSON.parse(response);
    console.log(info);


    for (i = 0; i < info.results.length; i++) {
        //info[i].name
        //console.log(info);
        console.log(i + (page - 1) * 10);
        document.getElementById("characters").innerHTML += `
        <option value="${i + (page - 1) * 10}">${info.results[i].name}</option>
        `;


    }
}

function showChosenCharacter() {
    //console.log(document.getElementById("characters").value);
    let num = document.getElementById("characters").value;
    //console.log(num);
    getSpecificCharacter(Number(num) + 1);
}



function getSpecificCharacter(num) {
    let baseUrl = "https://swapi.co/api/people/";
    sendAjaxGet(baseUrl + num, displayCharacter);
}

function getCharacter() {
    let baseUrl = "https://swapi.co/api/people/"
    let num = Math.floor(Math.random() * 88) + 1;
    sendAjaxGet(baseUrl + num, displayCharacter);
}



function displayCharacter(xhr) {
    let response = xhr.response;
    let info = JSON.parse(response);
    console.log(info);

    document.getElementById("name").innerHTML = "<b>Name</b> : " + info.name;
    if (info.height == "unknown") {
        document.getElementById("height").innerHTML = "<b>Height</b> : " + info.height
    } else {
        document.getElementById("height").innerHTML = "<b>Height</b> : " + info.height + " cm";
    }

    if (info.mass == "unknown") {
        document.getElementById("mass").innerHTML = "<b>Mass</b> : " + info.mass;
    } else {
        document.getElementById("mass").innerHTML = "<b>Mass</b> : " + info.mass + " kg";
    }
    document.getElementById("birth").innerHTML = "<b>Birth Year</b> : " + info.birth_year;
    document.getElementById("gender").innerHTML = "<b>Gender</b> : " + info.gender;
    getSpecies(info.species);
    getHomeworld(info.homeworld);
    //let films = [];
    document.getElementById("films").innerHTML = "";
    for (i = 0; i < info.films.length; i++) {
        getFilms(info.films[i]);
    }
    console.log(films);
}

function getFilms(url) {
    sendAjaxGet(url, displayFilm);
    document.getElementById("filmheader").removeAttribute("hidden");
}


function displayFilm(xhr) {
    let response = xhr.response;
    let info = JSON.parse(response);

    let item = document.createElement("li");
    item.innerHTML = info.title;
    document.getElementById("films").appendChild(item);
    // console.log(info.title);
    // return info.title;
}

function getSpecies(url) {
    sendAjaxGet(url, displaySpecies);
}

function displaySpecies(xhr) {
    let response = xhr.response;
    let info = JSON.parse(response);

    document.getElementById("species").innerHTML = "<b>Species</b> : " + info.name;
}

function getHomeworld(url) {
    sendAjaxGet(url, displayHomeworld);
}


function displayHomeworld(xhr) {
    let response = xhr.response;
    let info = JSON.parse(response);

    document.getElementById("homeworld").innerHTML = "<b>HomeWorld</b> : " + info.name;
}