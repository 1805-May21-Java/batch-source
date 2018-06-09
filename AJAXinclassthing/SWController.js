

function sendAjaxGet(url, func){
	let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
	xhr.onreadystatechange = function(){
		if(this.status == 200 && this.readyState == 4){
			func(this);
		}
	}
	xhr.open("GET", url);
	xhr.send();
}
function searchPerson(){
	let baseurl="https://swapi.co/api/people/?search=";
	let input = document.getElementById("name").value;
	console.log(input);
	if (input == "" | input < 0){
		document.getElementById("alert").innerHTML = "Invalid Input";
	} else {
		document.getElementById("alert").innerHTML = "";
		sendAjaxGet(baseurl + input, displayPerson);
	}
}function displayPerson(xhr){
	let response = xhr.response;
	let person = JSON.parse(response);
	console.log(response);
	console.log(person);
	if(person.count == 0){
		document.getElementById("alert").innerHTML = "Invalid input";
	} else {
	document.getElementById("charName").innerHTML = person.results[0].name;
	document.getElementById("height").innerHTML = "Height: " + person.results[0].height;
	document.getElementById("mass").innerHTML = "Mass: " + person.results[0].mass;
	document.getElementById("hair_color").innerHTML = "Hair color: " + person.results[0].hair_color;
	document.getElementById("skin_color").innerHTML = "Skin color: " + person.results[0].skin_color;
	document.getElementById("eye_color").innerHTML = "Eye color: " + person.results[0].eye_color;
	document.getElementById("birth_year").innerHTML = "Birth year: " + person.results[0].birth_year;
	document.getElementById("gender").innerHTML = "Gender: " + person.results[0].gender;
}}
function searchPlanet(){
	let baseurl="https://swapi.co/api/planets/?search=";
	let input = document.getElementById("p_name").value;
	console.log(input);
	if (input == "" | input < 0){
		document.getElementById("alert").innerHTML = "Invalid Input";
	} else {
		document.getElementById("alert").innerHTML = "";
		sendAjaxGet(baseurl + input, displayPlanet);
	}
}function displayPlanet(xhr){
	let response = xhr.response;
	let planet = JSON.parse(response);
	console.log(response);
	console.log(planet);
	if(planet.count == 0){
		document.getElementById("alert").innerHTML = "Invalid input";
	} else {
	document.getElementById("planName").innerHTML = planet.results[0].name;
	document.getElementById("rotPeriod").innerHTML = "Rotation Period: " + planet.results[0].rotation_period;
	document.getElementById("orbPeriod").innerHTML = "Orbital Period: " + planet.results[0].orbital_period;
	document.getElementById("diameter").innerHTML = "Diameter: " + planet.results[0].diameter;
	document.getElementById("climate").innerHTML = "Climate: " + planet.results[0].climate;
	document.getElementById("gravity").innerHTML = "Gravity: " + planet.results[0].gravity;
	document.getElementById("terrain").innerHTML = "Terrain: " + planet.results[0].terrain;
	document.getElementById("surWater").innerHTML = "Surface Water: " + planet.results[0].surface_water;
	document.getElementById("population").innerHTML = "Population: " + planet.results[0].population;
}}
function searchStarship(){
	let baseurl="https://swapi.co/api/starships/?search=";
	let input = document.getElementById("s_name").value;
	console.log(input);
	if (input == "" | input < 0){
		document.getElementById("alert").innerHTML = "Invalid Input";
	} else {
		document.getElementById("alert").innerHTML = "";
		sendAjaxGet(baseurl + input, displayStarship);
	}
}function displayStarship(xhr){
	let response = xhr.response;
	let starship = JSON.parse(response);
	console.log(response);
	console.log(starship);
	if(starship.count == 0){
		document.getElementById("alert").innerHTML = "Invalid input";
	} else {
	document.getElementById("starName").innerHTML = starship.results[0].name;
	document.getElementById("model").innerHTML = "Model: " + starship.results[0].model;
	document.getElementById("manu").innerHTML = "Manufacturer: " + starship.results[0].manufacturer;
	document.getElementById("cost").innerHTML = "Cost in credits: " + starship.results[0].cost_in_credits;
	document.getElementById("length").innerHTML = "Length: " + starship.results[0].length;
	document.getElementById("atmoSpeed").innerHTML = "Max Atmosphering Speed: " + starship.results[0].max_atmosphering_speed;
	document.getElementById("crew").innerHTML = "Crew: " + starship.results[0].crew;
	document.getElementById("passengers").innerHTML = "Passengers: " + starship.results[0].passengers;
	document.getElementById("cargo").innerHTML = "Cargo Capacity: " + starship.results[0].cargo_capacity;
	document.getElementById("consumables").innerHTML = "Consumables: " + starship.results[0].consumables;
	document.getElementById("hyperdrive").innerHTML = "Hyperdrive Rating: " + starship.results[0].hyperdrive_rating;
	document.getElementById("mglt").innerHTML = "MGLT: " + starship.results[0].MGLT;
	document.getElementById("starshipClass").innerHTML = "Starship Class: " + starship.results[0].starship_class;
}}
