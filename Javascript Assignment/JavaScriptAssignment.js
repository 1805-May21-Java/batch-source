//1. Longest String
var maxLength = function(arr){
    var count = [];
    for(var i =0; i < arr.length; i++){
        count.push(arr[i].length);
    }
    var max = Math.max(...count);
    var index = count.indexOf(max);
    return arr[index];
    //put in the console:
    //maxLength(["55", "this", "yesterday", "wonderful string", "ip", "more"])
    //outputs wonderful string
};
//2. Reverse Array
function reverseArray(array){
    return array.reverse();
    //put in the console:
    //reverseArray(["this", "array", "will", "be", "reversed"])
    //outputs (5) ["reversed", "be", "will", "array", "this"]
}
//3. Count Vowels
function vowelCount(string){
    var vowel = string.match(/[aeiou]/gi);
    return vowel === null ? 0 : vowel.length;
}
/*
vowelCount("yellow")
2
vowelCount("cyst")
0
vowelCount("there are how many vowels in this string")
11
vowelCount("this works")
2
vowelCount("hey when is this due again")
9
vowelCount("run")
1
*/
//4. Remove Script
function removeScript(string){
    var rem = string.replace(/Script/g, '');
    console.log(rem);
} //this function removes any instance of Script, case sensitive and singular
/*
removeScript("There is a Script here")
There is a  here
removeScript("There is a here")
There is a here
removeScript("Why Script when you can Script scripts?")
Why  when you can  scripts?
*/
//5. Find Leap Year
function isLeapYear(date) {
    d = date.getFullYear();
    if(d % 100 != 0 && d % 4 == 0){
        return true;
    }
    else if (d % 400 == 0) {
        return true;
    }
    return false;
}  //this function required me to input things for the date, below.
year = new Date();
year.setFullYear(2016);
console.log(year.getFullYear() + ": " + isLeapYear(year));
year.setFullYear(2017);
console.log(year.getFullYear() + ": " + isLeapYear(year));
year.setFullYear(2018);
console.log(year.getFullYear() + ": " + isLeapYear(year));
year.setFullYear(2019);
console.log(year.getFullYear() + ": " + isLeapYear(year));
year.setFullYear(2020);
console.log(year.getFullYear() + ": " + isLeapYear(year));
//6. Email Validation
function isValidEmail(string){
    if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(string)){
        return (true)
    }
    else{
        return (false)
    }
} //this one requires a rather odd regular expression to work
//sample output below.
/*
isValidEmail("email@email.com")
true
isValidEmail("email@emailcom")
false
isValidEmail("emailemail.com")
false
isValidEmail("email@@email.com")
false
isValidEmail("email@email.ru")
true
isValidEmail("email@em.ail.ru")
true
isValidEmail("ema$il@email.ru")
false
isValidEmail("email@ema*il.com")
false
*/
//7. Remove Character
function removeChar(string, index){
    if(index > string.length - 1)
        return string;
    var news = string.slice(0, index) + string.slice(index + 1);
    return news;
}
/*
removeChar("yellow", 4)
"yellw"
removeChar("yellow", 6)
"yellow"
removeChar("yellow", 8)
"yellow"
removeChar("yellow", 0)
"ellow"
removeChar("yellow", 1)
"yllow"
removeChar("yellow", 2)
"yelow"
*/
//8. Bubble Sort
function bubbleSort(numArray){
    var swap;
    do{
        swap = false;
        for (var i = 0; i < numArray.length - 1; i++) {
            if(numArray[i] > numArray[i+1]) {
                var temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
                swap = true;
            }
        }
    } while (swap);
    return numArray;
    /*
    bubbleSort([4, 56, 3, 2, 6, 8, 9])
    (7) [2, 3, 4, 6, 8, 9, 56]
    */
}
//9. Even Number
function isEven(someNum) { //using bitwise and ternary operator
    return (someNum & 1) ? false : true;
}
/*
isEven(2)
true
isEven(1)
false
isEven(3)
false
isEven(10)
true
isEven(15)
false
isEven(3045897348934570534)
true
isEven(30458973489)
false
*/
//10. Palindrome
function isPalindrome(someStr) {
    var len = Math.floor(someStr.length / 2);
    for (var i = 0; i < len; i++)
        if (someStr[i] !== someStr[someStr.length - i - 1])
            return false;
    return true;
} //note this function does not return the right value if punctuation and spacing are concerned.
/*
isPalindrome("this")
false
isPalindrome("youoy")
true
isPalindrome("goog")
true
isPalindrome("natural")
false
isPalindrome("bun")
false
isPalindrome("Mr. Owl Ate My Metal Worm")
false
isPalindrome("mr owl ate my metal worm")
false
isPalindrome("mrowlatemymetalworm")
true
*/
//11. Shapes
function printShape(shape, height, character){
    switch(shape){
        case "square":
            for (var i = 0; i < height; i++) {
                var sq = ""
                for (var j = 0; j < height; j++) {
                    sq += character;
                }
                console.log(sq);
            }
            break;
        case "triangle":
            for(var i = 0; i < height; i++){
                tr = "";
                for(var j = 0; j < i - -1; j++){
                    tr += character;
                }
                console.log(tr);
            }
            break;
        case "diamond":
            for(var i = 0; i < height; i++) {
                di = "";
                for(var j = 0; j < height; j++){
                    if(Math.abs(j - Math.abs((height - 1) / 2)) > (height - 1) / 2 - Math.abs((height - 1) / 2 - i)) {
                        di += " ";
                    } //long procedure involving Math.abs function
                    else {
                        di += character;
                    }
                }
                console.log(di);
            }
            break;
        default:
            console.log("Please rerun the function again.")
            break;
    }
}
/*
printShape("square", 7, '%')
7JavaScriptAssignment.js:185 %%%%%%%
undefined
printShape("triangle", 7, '^')
JavaScriptAssignment.js:194 ^
JavaScriptAssignment.js:194 ^^
JavaScriptAssignment.js:194 ^^^
JavaScriptAssignment.js:194 ^^^^
JavaScriptAssignment.js:194 ^^^^^
JavaScriptAssignment.js:194 ^^^^^^
JavaScriptAssignment.js:194 ^^^^^^^
undefined
printShape("default", 7, '^')
JavaScriptAssignment.js:212 Please rerun the function again.
undefined
printShape("diamond", 7, '@')
JavaScriptAssignment.js:208    @   
JavaScriptAssignment.js:208   @@@  
JavaScriptAssignment.js:208  @@@@@ 
JavaScriptAssignment.js:208 @@@@@@@
JavaScriptAssignment.js:208  @@@@@ 
JavaScriptAssignment.js:208   @@@  
JavaScriptAssignment.js:208    @   
*/
//12. Rotate Left
function rotate(array, n) {
    temp = array;
    for (var i = 0; i < n; i++) {
        r = temp[0];
        for(j = 0; j < temp.length - 1; j++) {
            temp[j] = temp[j - -1];
        }
        temp[temp.length - 1] = r;
    }
    return temp;
}
/*
rotate([1,2,3,4,5], 1)
(5) [2, 3, 4, 5, 1]
rotate([1,2,3,4,5], 6)
(5) [2, 3, 4, 5, 1]
rotate([1,2,3,4,5], 3)
(5) [4, 5, 1, 2, 3]
*/
//13. Balanced Brackets
function balanced(string) {
    for(i = 0; i < string.length/2; i++){
        str = string.charAt(i);
        if(str == '('){
            if(string.charAt(string.length - i - 1) != ')')
                return false;
            
        }
        else if(str == ')'){
            if(string.charAt(string.length - i - 1) != '(')
                return false;
                        
        }
        else if(str == '['){
            if(string.charAt(string.length - i - 1) != ']')
                return false;
                     
        }
        else if(str == ']'){
            if(string.charAt(string.length - i - 1) != '[')
                return false;
                       
        }
        else if(str == '{'){
            if(string.charAt(string.length - i - 1) != '}')
                return false;
                        
        }
        else if(str == '}'){
            if(string.charAt(string.length - i - 1) != '{')
                return false;
                        
        }
        else
            return false;        
    }
    return true;
}
/*
balanced("()")
true
balanced("()()")
true
balanced("(())")
true
balanced("({[]})")
true
balanced("(")
false
balanced(")")
false
balanced("(()")
false
balanced("([)]")
false
*/