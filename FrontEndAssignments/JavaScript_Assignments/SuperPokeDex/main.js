const baseUrl = 'https://pokeapi.co/api/v2/pokemon/';
let typeColors = {
    normal: '#A8A77A',
    fire:  '#EE8130',
    water:  '#6390F0',
    electric:  '#F7D02C',
    grass:  '#7AC74C',
    ice :  '#96D9D6',
    fighting:  '#C22E28',
    poison:  '#A33EA1',
    ground:  '#E2BF65',
    flying:  '#A98FF3',
    psychic:  '#F95587',
    bug:  '#A6B91A',
    rock:  '#B6A136',
    ghost:  '#735797',
    dragon:  '#6F35FC',
    dark:  '#705746',
    steel:  '#B7B7CE',
    fairy:  '#D685AD',
};
    // get id
    // get name
    // get default and shiny front sprites
    // get types (labels)
    
    addSubmitListener();
    

function addSubmitListener() {
    document.getElementById('submit-btn').addEventListener('click', choosePokemon);


}

function choosePokemon() {

    console.log('event fired');
    //get input
    let pokemonName = document.getElementById('pokemon-name').value;
    // get the data
    sendAjaxGet(baseUrl + pokemonName, displayPokemon );


}


function sendAjaxGet(url, funk) {
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function() {
        if(this.status == 200 && this.readyState == 4) {
            document.getElementById("alert").innerHTML = '';
            funk(this);
        } else if(this.status == 404) {
            // display error message, wrong pokemon name
            document.getElementById("alert").innerHTML = "Missingno Pokemon Error.";
        }
    }
    xhr.open('GET', url);
    xhr.send();
}

function displayPokemon(xhr) {

    // todo clear previous data
    // parse response
    let response = JSON.parse(xhr.response);
    console.log(response);
    // insert id and name
    document.getElementById("poke-id").innerHTML = response.id;
    document.getElementById('poke-name').innerHTML = response.name.charAt(0).toUpperCase() + response.name.slice(1);

    //clear the tpyes
    document.getElementById('types').innerHTML = "";
    //insert the types
    let types = response.types;
    for(i = 0; i < types.length; i++) {
        let typeSpan = document.createElement('span');
        typeSpan.innerHTML = types[i].type.name;

        typeSpan.style.backgroundColor = typeColors[types[i].type.name];

        document.getElementById('types').appendChild(typeSpan);
    }

    // insert the sprites
    document.getElementById('default-sprite').setAttribute('src', response.sprites.front_default);
    document.getElementById('shiny-sprite').setAttribute('src', response.sprites.front_shiny);
}