let baseUrl = 'https://pokeapi.co/api/v2/';
let notfoundurl = '';

function searchpokemon() {
    let pokename = document.getElementById('pokename').value;

    if (pokename == '') {
        return;
    }

    sendAjaxGet(baseUrl + 'pokemon/' + pokename + '/', displayPokemon);

    document.getElementById('pokename').value = '';

}

function sendAjaxGet(url, func) {
    xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
    xhr.onreadystatechange = function () {
        if (this.status == 200 && this.readyState == 4) {
            func(this);
        } else if (this.status == 404 && this.readyState == 4) {
            pokeNotFound();
        }
    }

    xhr.open('GET', url);
    xhr.send();
}

function pokeNotFound() {
    let name = document.getElementById('outname');
    name.innerHTML = "Pokemon not found";

    let image = document.getElementById('pokeimg');
    image.setAttribute('src', 'https://cdn.bulbagarden.net/upload/0/0d/201Unown_Question_Dream.png');
    image.setAttribute('alt', '');
    image.setAttribute('width', '10%');
    image.setAttribute('height', '10%');

    let tlist = document.getElementById('typelist');
    tlist.innerHTML = '';

    document.getElementById('height').innerHTML = '';
    document.getElementById('weight').innerHTML = '';
    document.getElementById('id').innerHTML = '';
}

function displayPokemon(xhr) {
    let response = xhr.response;
    let pokemon = JSON.parse(response);
    
    let name = document.getElementById('outname');
    name.innerHTML = "Pokemon found: " + pokemon.name;

    let image = document.getElementById('pokeimg');
    image.setAttribute('src', pokemon.sprites.front_default);
    image.setAttribute('width', '50%');
    image.setAttribute('height', '50%');

    let tlist = document.getElementById('typelist');

    tlist.innerHTML = '';

    let tyarr = pokemon.types;
    //console.log(tyarr[0].type.name);

    for (let elem of tyarr) {
        let tyname = elem.type.name;
        let li = document.createElement('li');
        li.innerHTML = tyname;
        tlist.appendChild(li);
    }

    document.getElementById('height').innerHTML = pokemon.height / 10 + ' m';
    document.getElementById('weight').innerHTML = pokemon.weight / 10 + ' kg';
    document.getElementById('id').innerHTML = pokemon.id;
}