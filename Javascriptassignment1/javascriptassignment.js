// 1. Longest String 
// Define function: maxLength(array)
// Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.
 
var arr = ["Bananas", "Apples", "Watermelons", "Kiwis", "Oranges"];
function maxLength(array){
    let max = "";
    for (i=0; i<array.length; i++) {
        if (array[i] > max) {
            max = array[i];
        }
    }
    console.log(max);
}

maxLength(arr);

// 2.      Reverse Array
// Define function: reverseArray(array)
// Write a JavaScript function to reverse the elements of a given array.
 function reverseArray(array){
     console.log(array.reverse());
 }

 reverseArray(arr);

// 3.     Count Vowels 
// 	Define function: vowelCount(string)
// 	 Write a JavaScript function to count the number of vowels in a given string.
var animal = "mississippi"; 
var animalArray = animal.split("");

function checkVowel(animalArray) {
    var array = animal.split("");
    var vowelCount = [];
    for (i=0; i<array.length; i++) {
        if (array[i].includes("a")) {
            vowelCount.push(array[i]);
        } else if (array[i].includes("e")) {
            vowelCount.push(array[i]);
        } else if (array[i].includes("i")) {
            vowelCount.push(array[i]);
        } else if (array[i].includes("o")) {
            vowelCount.push(array[i]);
        } else if (array[i].includes("u")) {
            vowelCount.push(array[i]);
        }
    } console.log(vowelCount);
}

checkVowel(animalArray);

// 4.      Remove Script
// Define function: removeScript(string)
// Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string return the string without "Script" otherwise return the original one.
 
function removeScript(string) {
    var array = string.split(" ");
    for (i=0; i <array.length; i++) {
        if (array[i].includes("script")) {
            array.splice(i,1);
        }
    } console.log(array.join(" "));

}

removeScript("Check out this cool script that I like to call script");

// 5.      Find Leap Year
// Define function: isLeapYear(date)
// Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
var year = 2012;
function isLeapYear(year)
{
  return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
}

console.log(year + " is a Leap Year: " + isLeapYear(year));

// 6.      Email Validation 
// Define function: isValidEmail(string)
// Create a function that checks for a valid email format.
var email = "email@test.com"
function isValidEmail(email) { 
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

console.log(email + " is a valid email address: " + isValidEmail(email));

// 7.     Remove Character
// 	Define function: removeChar(string, index)
// Write a JavaScript function to remove a character at the specified position of a given string and return the new string.

function removeChar(string, index) {
    var array = string.split("");
    array.splice(index,1);
    
    console.log(array.join(""));
} 

removeChar("Alexandria", 7);


// 9.       Bubble Sort
// Define function: bubbleSort(numArray)
// Use the bubble sort algorithm to sort the array. You'll need to look this up!
// Return the sorted array.

function bubbleSort(numArray){
    var swapped;
    do {swapped = false;
        for (var i=0; i < numArray.length-1; i++) {
            if (numArray[i] > numArray[i+1]) {
                var temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
                swapped = true;
            }}} while (swapped);
            console.log(numArray);
};
var numArray = [8,6,5,90,1,5,88,4,2];
bubbleSort(numArray);

// 10.    Even Number
// Define function: isEven(someNum)
// Return true if even, false if odd.
// Do not use % operator.
 
function isEven(num){
    var check = num/2;
    var stringCheck = check.toString();
    if (stringCheck.includes(".")) {
        console.log(num + " is false");
    } else {console.log(num + " is even");}
}

isEven(1078);

// 11.   Palindrome
// Define function: isPalindrome(someStr)
// Return true if someStr is a palindrome, otherwise return false.
 
function isPalindrome(someStr) {
    var someArray = someStr.split("");
    someArrayFlipped = someArray.reverse();
    someStrFlipped = someArrayFlipped.join("");
    if (someStr.toLowerCase() == someStrFlipped.toLowerCase()) {
        return true;
    } else { return false;}
}

// 12.   Shapes
// Define function: printShape(shape, height, character)
// shape is a String and is either "Square", "Triangle", "Diamond".
// height is a Number and is the height of the shape. Assume the number is odd.
// character is a String that represents the contents of the shape.
// Assume this String contains just one character.
// Use a switch statement to determine which shape was passed in.
// Use the console.log function to print the desired shape.
// Example for printShape("Square", 3, "%");
// %%%
// %%%
// %%%
// Example for printShape("Triangle", 3, "$");
// $
// $$
// $$$
// Example for printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *		

function printShape(shape, height, symbol) {
    if (shape == "Square") {
        for (i = 0; i < height; i++) {
            for (j = 0; j < height; j++) {
                document.write(symbol);
            }
            document.writeln('<br />');
        }
    } else if (shape == "Triangle") {
        var i, j;
        for(i=1; i <= height; i++) {
           for(j=1; j<=i; j++) {
              document.write(symbol);
         }
         document.write('<br/>');
    }
    } else if (shape == "Diamond") {
        var doubleheight = height*2;
        for(i=0; i<doubleheight; i++){
            if (i < height){
                for(j=0; j<i; j++){
                    document.write(symbol);
                }
            }
            if (i >= height){
                for(j=doubleheight; j>i; j--){
                    document.write(symbol);
                }
            }
            document.write('<br>');
        }
    }
}

printShape("Triangle", 5, "*"); 

// 13.   Rotate Left
// Define function: rotate(array, n)
// Given array, rotate left n times and return array
// Examples
// f([1,2,3,4,5], 1) = [2,3,4,5,1]
// f([1,2,3,4,5], 6) = [2,3,4,5,1]
// f([1,2,3,4,5], 3) = [4,5,1,2,3]

var array = [1,2,3,4,5,6,7,8]
function rotate(array, num) {
    for(i=1; i<=num; i++) {
        array.push(array.shift());
    }
    return array;
}

console.log(rotate(array,4));

// 14. Balanced Brackets
//  	Define function: balanced(string)

// A bracket is any one of the following: (, ), {, }, [, or ]
 
// The following are balanced brackets:
// ()
// ()()
// (())
// ({[]})
 
// The following are NOT balanced brackets
// (
// )
// (()
// ([)]
 
// Create a function which takes a string of brackets and returns true if balanced and false if not balanced
 
function balanced(string) {
    strArray = string.split("");
    stack = [];
    for (var i = 0; i < string.length; i++) {
        var c = strArray[i];
        if (c == "(" || c == "[" || c == "{") {
            stack.push(c);
        } else if (c == ")") {
            if (stack.length == 0) return false;
            var top = stack.pop();
            if (top != "(") return false;
        } else if (c == "]") {
            if (stack.length == 0) return false;
            var top = stack.pop();
            if (top != "[") return false;
        } else if (c == "}"){
            if (stack.length == 0) return false;
            var top = stack.pop();
            if (top != "{") return false;
        } else {
            return false;
        }
    }
    return !(stack.length > 0);
}

