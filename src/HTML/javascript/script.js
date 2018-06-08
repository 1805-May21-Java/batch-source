/*console.log("5: "+ isNaN(5));
console.log("hello: " + isNaN("hello"));
console.log("false: " + isNaN(false));
console.log("true: " + isNaN(true));
console.log("null: " + isNaN(null));
console.log("undefined: " + isNaN(undefined));

function add1(one,two){
	return one + two;
}

add2 = function(one, two){
	return one+two;
}

add3 = (one, two) => {
	return one+two;
}
*/
//1.
var fruits = ["Banana", "Orange", "Apple", "Mango"];
function maxLength(arr){
	var length = 0;
	var index = 0;
	for (i = 0; i < arr.length; i++){
		if(arr[i].length > length){
			index = i;
			length = arr[i].length;
		}
	}
	return arr[index];
}

//2.
function reverseArray(array){

	let temp = [];
	for(i = array.length - 1; i>=0; i--){
		temp.push(array[i]);
	}
	return temp;
	
	//return array.reverse();
}

//3.
function vowelCount(string){
	let count = 0;
	let vowels = ["a", "e", "i", "o", "u"];
	for (i = 0; i < string.length; i++){
		if(vowels.includes(string.charAt(i))){
			count+=1;
		}
	}
	return count;
}

//4.
function removeString(string){
	let removeString = /String/;
		return string.replace(removeString, '');
}

//5.
function leapYear(year){
	if(year%4 == 0){
		if(year%100 != 0){
			return true;
		} else if(year%400 != 0){
			return false
		}
		return true;
	} return false;
}

//6.
function validEmail(email){
	var reg = /(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])/
	return reg.test(email);
}

//7.
function removeCharacter(string, index) {
    return string.substr(0, index - 1)+ string.substr(index);
}
//8.
function swap(array, i, j) {
  var temp = array[i];
  array[i] = array[j];
  array[j] = temp;
}

function bubbleSort(array){
	var swapped;
	do{
		swapped = false;
		for(i = 0; i < array.length;i++){
			if(array[i] !== undefined && array[i + 1] !== undefined && array[i] > array[i + 1]){
				swap(array, i, i+1);
				swapped = true;
			}
		}
	} while(swapped);
	return array;
}

//9.
function isEven(number){
	let half = number/2;
	if(half == Math.ceil(half)){
		return true;
	} else return false;
}
//10.
function palindrome(string){
	var reverse = string.split("").reverse().join("");
	if(reverse == string){
		return true;
	} else return false;
}

//11.
function printShape(shape, height, character){
	let lineOut;
	let array = [];
	switch(shape.toLowerCase()){
		case "square":
			for(i = 0; i < height; i++){
				lineOut = "";
				for(j = 0; j < height; j++){
					lineOut += character;
				}
				console.log(lineOut + "\n");
			}
			break;
		case "triangle":
			for(i = 0; i < height; i++){
				lineOut = "";
				for(j = 0; j <= i; j++){
					lineOut += character;
				}
				console.log(lineOut + "\n");
			}
			break;
		case "diamond":
			let closestOdd = height;
			let half = Math.ceil(height/2);
			let spaceCount = 0;
			let characterCount = 0;
			let array = [];
			if(height%2==0){
				closestOdd = height - 1;
			}
			for(i = 1; i <= half; i++){
				lineOut = "";
				characterCount = 2*i -1;
				spaceCount = (closestOdd - characterCount) / 2;
				for(j = 0; j < spaceCount; j++){
					lineOut += " ";
				}
				for(k = 0; k < characterCount; k++){
					lineOut += character;
				}
				
				array.push(lineOut);
			}
			for(i = 0; i < array.length;i++){
				console.log(array[i]);
			}
			if(height%2==0){	
				for(i = array.length-1; i >= 0;i--){
					console.log(array[i]);
				}
			} else {	
				for(i = array.length-2; i >= 0;i--){
					console.log(array[i]);
				}
			}
			break;
		default:
			return "Not a valid shape"
			break;
	}
}

//12.
function shiftLeft(array, n){
	let left;
	for(i = 0; i < n; i++){
		left = array[0];
		for(j = 0; j < array.length - 1; j++){
			array[j] = array[j+1];
		}
		array[array.length - 1] = left;
	}
	console.log(array);
	
}

//13.
function balance(string){
		function halfCheck(char1, char2){
			switch(char1){
				case "(":
					if(char2 == ")"){
						return true;
					} else return false;
					break;
				case "{":
					if(char2 == "}"){
						return true;
					} else return false;
					break;
				case "[":
					if(char2 == "]"){
						return true;
					} else return false;
					break;
				case ")":
					if(char2 == "("){
						return true;
					} else return false;
					break;
				case "}":
					if(char2 == "{"){
						return true;
					} else return false;
					break;
				case "]":
					if(char2 == "["){
						return true;
					} else return false;
					break;
			}
		}
	if(string.length%2 == 0){
		let half1 = string.substr(0,string.length/2);
		let half2 = string.substr(string.length/2).split("").reverse().join("");
		//console.log(half1);
		//console.log(half2);
		for(i = 0; i < half1.length; i++){
			if(!halfCheck(half1.charAt(i), half2.charAt(i))){
				return false
			}
		}
		return true;
	} else return false;
}