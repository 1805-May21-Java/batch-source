// 1: Longest String

function maxLength(array){
    index = 0;
    maxLength = 0;
    for(s in array){
        if(array[s].length > maxLength){
            index = s;
            maxLength = array[s].length;
        }
    }
    return index;
}

arr = ['hello', 'hi', 'threee'];

console.log("Input array: " + arr);
console.log("Result: " + maxLength(arr));

// 2: Reverse Array

function reverseArray(array){
    tempArr = array;
    for(i = 0; i < tempArr.length / 2; i++){
        temp = tempArr[i];
        tempArr[i] = tempArr[tempArr.length-i-1];
        tempArr[tempArr.length-i-1] = temp;
    }
    return tempArr;
}

arr = [3, null, '4', true];

console.log("Initial array: " + arr);
console.log("Reversed array: " + reverseArray(arr));

// 3: Count Vowels

function countVowels(string){
    vowels = 0;
    for(c of string){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U'){
            vowels++;
        }
    }
    return vowels;
}

s = 'vowel test';

console.log("Number of vowels in '" + s + "': " + countVowels(s));

// 4: Remove Script

function removeScript(string){
    newStr = '';
    waypoint = 0;
    for(index in string){
        if(string.substring(index, index - -6) == "Script"){ // wat
            newStr += string.substring(waypoint, index);
            waypoint = index - -6; // wat
        }
    }
    if(waypoint < string.length){
        newStr += string.substring(waypoint);
    }
    return newStr;
}

s = 'ScriptHellScripto WorScriptldScript';

console.log("Before 'Script' purge: " + s);
console.log("After 'Script' purge: " + removeScript(s));

// 5: Find Leap Year

function isLeapYear(date){
    year = date.getFullYear();
    if(year%4 == 0 && (year%100 == 0 && year%400 == 0)){
        return true;
    }
    return false;
}

d = new Date();
console.log(d.getFullYear() + " is a leap year: " + isLeapYear(d));
d.setFullYear(2300);
console.log(d.getFullYear() + " is a leap year: " + isLeapYear(d));
d.setFullYear(2800);
console.log(d.getFullYear() + " is a leap year: " + isLeapYear(d));

// 6: Email Validation

function isValidEmail(string){
    num = 0;
    ready = false;
    for(s of string){
        if(s == '@'){
            if(num == 0 && ready){
                num++;
                ready = false;
            }
            else{
                return false;
            }
        }
        else if(s == '.'){
            if(num == 1 && ready){
                num++;
                ready = false;
            }
            else{
                return false;
            }
        }
        else{
            ready = true;
        }
    }
    if(num == 2 && ready){
        return true;
    }
    else{
        return false;
    }
}

s = "valid@email.com";
console.log(s + " is a valid email: " + isValidEmail(s));
s = "inv@@@@@lid.email";
console.log(s + " is a valid email: " + isValidEmail(s));

// 7: Remove Character

function removeChar(string, index){
    newStr = string.substring(0, index) + string.substring(index + 1, string.length);
    return newStr;
}

s = "abcdefg";
num = 3;
console.log("Remove index " + num + " from " + s + ": " + removeChar(s, num));

// 8: ???????????????????????????

// 9: Bubble Sort

function bubbleSort(numArray){
    tempArr = numArray;

    for(i in numArray){
        for(j in tempArr){
            if(tempArr[j] > tempArr[j- -1]){ // wat
                temp = tempArr[j];
                tempArr[j] = tempArr[j- -1]; // wat
                tempArr[j- -1] = temp; // wat
            }
        }
    }
    return tempArr;
}

arr = [1,5,4,2,-10,6,4];
console.log("Unbubblesorted array: " + arr);
console.log("Bubblesorted array: " + bubbleSort(arr));

// 10: Even Number

function isEven(someNum){
    if(Number.isInteger(someNum/2)){
        return true;
    }
    return false;
}

num = 5;
console.log(num + " is even: " + isEven(num));
num = 10.4;
console.log(num + " is even: " + isEven(num));
num = 6;
console.log(num + " is even: " + isEven(num));

// 11: Palindrome

function isPalindrome(string){
    for(i = 0; i < string.length / 2; i++){
        if(string.charAt(i) != string.charAt(string.length - i - 1)){
            return false;
        }
    }
    return true;
}

s = "notpalindrome";
console.log(s + " is a palindrome: " + isPalindrome(s));
s = "racecar";
console.log(s + " is a palindrome: " + isPalindrome(s));
s = "hannah";
console.log(s + " is a palindrome: " + isPalindrome(s));

// 12: Shapes

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

printShape("Square", 5, "!");
printShape("Triangle", 5, "?");
printShape("Diamond", 7, "x");

// 13: Rotate Left

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

arr = [1,2,3,4,5,6,7];
console.log("Let's rotate this array: " + arr);
console.log("1 rotation: " + rotate(arr, 1));
console.log("2 rotations: " + rotate(arr, 1));
console.log("3 rotations: " + rotate(arr, 1));
console.log("4 rotations: " + rotate(arr, 1));

// 14: Balanced Brackets

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

s = "[[]]";
console.log(s + " is a balanced bracket: " + balanced(s));
s = "{}{}";
console.log(s + " is a balanced bracket: " + balanced(s));
s = "((())}";
console.log(s + " is a balanced bracket: " + balanced(s));
s = "([aa])";
console.log(s + " is a balanced bracket: " + balanced(s));