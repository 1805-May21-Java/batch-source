let baseUrl = "https://pokeapi.co/api/v2/pokemon/";

function searchPokemon(){
    let input = document.getElementById("pokemon").value;
    input = input.toLowerCase();

    if(input.length == ''){
        document.getElementById("alert").innerHTML = "Invalid Pokémon";
    }else{
        document.getElementById("alert").innerHTML = "";
        sendAjaxGet(baseUrl+input+'/', displayPokemon);
    }    
}

function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));

    xhr.onreadystatechange = function(){
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }else if(this.status >= 400 && this.status < 600){
            document.getElementById("alert").innerHTML = "Invalid Pokémon";
            document.getElementById("name").innerHTML = '';
            document.getElementById("type").innerHTML = '';
            document.getElementById("moves").innerHTML = '';
            document.getElementById("icon").setAttribute("src", '')
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function displayPokemon(xhr){
    let response = xhr.response;
    let pokemon = JSON.parse(response);

    nameStr = pokemon.name;
    nameStr = nameStr.slice(0,1).toUpperCase() + nameStr.slice(1,-1) + nameStr.slice(-1);
    document.getElementById("name").innerHTML = nameStr;
    let types = pokemon.types;

    let typeStr ='Types: ';
    for(t of types){
        typeStr += t.type.name+', ';
    }
    typeStr = typeStr.slice(0, -2);
    document.getElementById("type").innerHTML = typeStr;

    let moves = pokemon.moves;

    let moveStr = 'Moves:   ';
    for(m of moves){
        moveStr += m.move.name+', ';
    }
    moveStr = moveStr.slice(0,-2);
    document.getElementById("moves").innerHTML = moveStr;

    document.getElementById("icon").setAttribute("src", pokemon.sprites.front_default)
}