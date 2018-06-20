
  let typeToColor = {normal:"#C6C6A7",fighting:"#C03028",flying:"#A890F0",poison:"#A040A0",ground:"#E0C068",
    rock:"#B8A038",bug:"#A8B820",ghost:"#705898",steel:"#B8B8D0",fire:"#F08030",water:"#6890F0",grass:"#78C850",
    electric:"#F8D030",psychic:"#F85888",ice:"#98D8D8",dragon:"#7038F8",dark:"#705848",fairy:"#EE99AC"};

  
//Setting up fields and listeners
let date = new Date();
let pokemonNumber = date.getDate()+date.getMonth()*30;
let pokeURL ="https://pokeapi.co/api/v2/pokemon/"+pokemonNumber;




submitNumber = document.getElementById("goToButton");
goTo = document.getElementById("goTo");
submitNumber.addEventListener("click",function(){
    
        document.getElementById("errorMessage").innerHTML = ""
        pokeURL = "https://pokeapi.co/api/v2/pokemon/"+goTo.value.toLowerCase();
        sendAjax(pokeURL,getPokemon);
       
})

//gets data from database
sendAjax(pokeURL,getPokemon);

function sendAjax(url,func){

    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    document.getElementById("name").innerHTML = "Loading..."
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            func(xhr);
        }else if(this.status == 404){
            document.getElementById("errorMessage").innerHTML = "Please enter either a number between 1 and 802"+
            " or a valid lowercase pokemon name"
            document.getElementById("name").innerHTML = ":(";
            let image = document.getElementById("pkmnImage");
            image.setAttribute("src","MissingNo.png");


        }
    };

    xhr.open("GET",url);
    xhr.send();

}

function getPokemon(xhr){
  //sets up fields with values from database
    let response = JSON.parse(xhr.response);
    nameHeader = document.getElementById("name");
    pokemonNumber = response.id;
    let pokeName = response.name;
    nameHeader.innerHTML = pokeName.charAt(0).toUpperCase() + pokeName.substr(1);
    let image = document.getElementById("pkmnImage");
    image.setAttribute("src",response.sprites.front_default);
    document.body.style.backgroundColor = typeToColor[response.types[0].type.name];
    document.getElementById("height").innerHTML = "Height: "+response.height/10+" m";
    document.getElementById("weight").innerHTML = "Weight: "+response.weight/10+" kg";
    document.getElementById("number").innerHTML = "#"+pokemonNumber;
   
    nextButton = document.getElementById("next")
    previousButton = document.getElementById("prev")

    previousButton.innerHTML = "#"+(Number(response.id)-1);
    nextButton.innerHTML = "#"+(Number(response.id)+1);

    //set new onClick based on new numbers
    previousButton.onclick = function(){
        pokemonNumber --;
        pokeURL = "https://pokeapi.co/api/v2/pokemon/"+pokemonNumber;
        sendAjax(pokeURL,getPokemon);
    };
    nextButton.onclick = function(){
        pokemonNumber ++;
        pokeURL = "https://pokeapi.co/api/v2/pokemon/"+pokemonNumber;
        sendAjax(pokeURL,getPokemon);
    };
}