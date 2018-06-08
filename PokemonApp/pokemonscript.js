let baseUrl = "https://pokeapi.co/api/v2/pokemon/"

function getPoke(kk) {
let input = kk;
    sendAjaxGet(baseUrl+ input +"/", displayPoke);
}

function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function() {
        if(this.status == 200 && this.readyState == 4) {
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

    function displayPoke(xhr){
        let response = xhr.response;
        let pokemon = JSON.parse(response);
        console.log(pokemon);

        document.getElementById("pictures").setAttribute("src", pokemon.sprites.front_shiny);
        document.getElementById("name").innerHTML = pokemon.name;

        document.getElementById("abilities").innerHTML = "Abilities: " +pokemon.abilities[0].ability.name + ", " + pokemon.abilities[1].ability.name;
        //document.getElementById("types").innerHTML = pokemon.types[0].type.name;
        document.getElementById("height").innerHTML = "Height: " + (pokemon.height)/10 + " meters";
        document.getElementById("weight").innerHTML = "Weight: " + (pokemon.weight)/10 + " kilos";
        
    }
    