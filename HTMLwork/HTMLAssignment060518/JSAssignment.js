/*
* Programmer: Keandre Palmer
* Date: 06/05/2018
* */

//Longest String: Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.
let arr = ['A giant Condor stole my baby','Hell','What is today','Superfristicallalalisticexpaladocious'];
function maxlength(input){
  let count = 0;
  for(i=0;i<input.length;i++){
    if(input[i].length>count){
      count = i;
    }
  }
  return count;
}

//Reverse Array: Write a JavaScript function to reverse the elements of a given array.
function reverseArray(input) {
  let a =[];
  let count = 0;
  for(i=input.length;i>0;i--){
    a[count] = input[i-1];
    count++;
  }
  return a;
}

//	Write a JavaScript function to count the number of vowels in a given string.
function vowelCount(input){

}

/*
* Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present
* in the string return the string without "Script" otherwise return the original one.
* */
function removeScript(input){
  let res = input.replace("Script","");
  let pes = res.replace("script","");
  return pes;
}

//Create a JavaScript function that takes a date parameter and returns true if
// the year is a leap year in the Gregorian calendar.
//Doesn't work
function isLeapYear(date){
  return ((date.getFullYear() % 4 == 0) && (date.getFullYear() % 100 !=0)) || (date.getFullYear() % 400 == 0);
}

//Create a function that checks for a valid email format.

