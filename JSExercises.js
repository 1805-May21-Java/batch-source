/*
1.      Longest String
Define function: maxLength(array)
Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.

*/
function maxLength(array) {
    let longest = '';

    for (var i=0; i < array.length; i++) {
        if(array[i].length > longest) {
            longest = array[i].length;   
        }    
    }
    return longest;
}

/*
2.      Reverse Array
Define function: reverseArray(array)
Write a JavaScript function to reverse the elements of a given array.
*/

function reverseArray(array) {
    let rArr = new Array;
    rArr = array.reverse();
    return rArr;
}

/* 
3.     Count Vowels 
	Define function: vowelCount(string)
	 Write a JavaScript function to count the number of vowels in a given string.
*/

function vowelCount(string) {
    var vowels = 0;
    var myString = string.toString();

    for(var i = 0; i <= myString.length - 1; i++) {
        if (myString.charAt(i) == "a" || myString.charAt(i) == "e" || myString.charAt(i) == "i" || myString.charAt(i) == "o" || myString.charAt(i) == "u") {
            vowels += 1;
        }
    }
    return vowels;
}
     
/*
4.      Remove Script
Define function: removeScript(string)
Write a JavaScript function to check if a string "Script" is present in a given string. 
If "Script" is present in the string return the string without "Script" otherwise return the original one.
*/

function removeScript(string) {
    var newString = string.replace('Script','');

    return newString;
}
/*
5.      Find Leap Year
Define function: isLeapYear(date)
Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
*/

function isLeapYear(date) {
    let answer;
    if (date % 4 == 0) {
        answer = true;
    }
    else { 
        answer = false;
    }
    return answer;
}

/*
6.      Email Validation 
Define function: isValidEmail(string)
Create a function that checks for a valid email format.
*/

function isValidEmail(string) {
    let answer;
    if (string.includes('@') && string.includes('.com')) {
        answer = true;
    }
    else {
        answer = false;
    }
    return answer;
}

/*
7.     Remove Character
	Define function: removeChar(string, index)
Write a JavaScript function to remove a character at the specified position of a given string and return the new string.
*/
function removeChar(string, index) {
    let newString;
    let x = null;
    newString = string.replace(string.charAt(index, x));
    return newString;
}

/*
9.       Bubble Sort
Define function: bubbleSort(numArray)
Use the bubble sort algorithm to sort the array. You'll need to look this up!
Return the sorted array.
*/
function bubbleSort(numArray) {
    var temp;

    for(var i = 0; i < numArray.length; i++) {
        for(var j = 0; j < numArray.length; j++) {
            if(numArray[i] < numArray[j]) {
                temp = numArray[i];
                numArray[i] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    return numArray;
}

/*
10.    Even Number
Define function: isEven(someNum)
Return true if even, false if odd.
Do not use % operator.
*/

function isEven(someNum){
    let answer;
    if(Number.isInteger(someNum/2)){
        answer = true;
    } else{
        answer = false;
    }
    return answer;
}
/*
11.   Palindrome
Define function: isPalindrome(someStr)
Return true if someStr is a palindrome, otherwise return false.
*/

function isPalindrome(someStr) {
    let answer;
    let lowercase = someStr.toLowerCase();
    var test = lowercase.split('').reverse().join('');

    if (test == someStr) {
        answer = true;
    } else {
        answer = false;
    }
    return answer;
}

/*
12.   Shapes
Define function: printShape(shape, height, character)
shape is a String and is either "Square", "Triangle", "Diamond".
height is a Number and is the height of the shape. Assume the number is odd.
character is a String that represents the contents of the shape.
Assume this String contains just one character.
Use a switch statement to determine which shape was passed in.
Use the console.log function to print the desired shape.
Example for printShape("Square", 3, "%");
%%%
%%%
%%%
Example for printShape("Triangle", 3, "$");
$
$$
$$$
Example for printShape("Diamond", 5, "*");
  *
 ***
*****
 ***
  *				
*/  

function printShape(shape, height, character){
    switch(shape){
        case "Square":
        for(i = 0; i < height; i++){
            s = "";
            for(j = 0; j < height; j++){
                s += character;
            }
            console.log(s);
        }
        break;
        case "Triangle":
        for(i = 0; i < height; i++){
            s = "";
            for(j = 0; j < i - -1; j++){
                s += character;
            }
            console.log(s);
        }
        break;
        case "Diamond":
        for(i = 0; i < height; i++){
            s = "";
            for(j = 0; j < height; j++){
                if(Math.abs(j - Math.abs((height - 1) / 2)) > (height - 1) / 2 - Math.abs((height - 1) / 2 - i)){
                    s += " ";
                }
                else{
                    s += character;
                }
            }
            console.log(s);
        }
        break;
    }
}

/*
13.   Rotate Left
Define function: rotate(array, n)
Given array, rotate left n times and return array
Examples
f([1,2,3,4,5], 1) = [2,3,4,5,1]
f([1,2,3,4,5], 6) = [2,3,4,5,1]
f([1,2,3,4,5], 3) = [4,5,1,2,3]
*/

function rotate(array, n){
    tempArr = array;
    for(i = 0; i < n; i++){
        temp = tempArr[0];
        for(j = 0; j < tempArr.length - 1; j++){
            tempArr[j] = tempArr[j- -1];
        }
        tempArr[tempArr.length-1] = temp;
    }
    return tempArr;
}

/*
14.   Balanced Brackets
 	Define function: balanced(string)

A bracket is any one of the following: (, ), {, }, [, or ]
 
The following are balanced brackets:
()
()()
(())
({[]})
 
The following are NOT balanced brackets
(
)
(()i
([)]
 
Create a function which takes a string of brackets and returns true if balanced and false if not balanced
*/

function balanced(string){
    for(i = 0; i < string.length / 2; i++){
        s = string.charAt(i);
        if(s == '('){
            if(string.charAt(string.length - i - 1) != ')'){
                return false;
            }
        }
        else if(s == ')'){
            if(string.charAt(string.length - i - 1) != '('){
                return false;
            }
        }
        else if(s == '['){
            if(string.charAt(string.length - i - 1) != ']'){
                return false;
            }
        }
        else if(s == ']'){
            if(string.charAt(string.length - i - 1) != '['){
                return false;
            }
        }
        else if(s == '{'){
            if(string.charAt(string.length - i - 1) != '}'){
                return false;
            }
        }
        else if(s == '}'){
            if(string.charAt(string.length - i - 1) != '{'){
                return false;
            }
        }
        else{
            return false;
        }
    }
    return true;
}


