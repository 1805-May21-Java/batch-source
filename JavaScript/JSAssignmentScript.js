//Longest String - Write a JavaScript to find the longest string from an given array of strings and returns the string’s array index.
function maxLength(array){
    var len = 0;
    var pos = 0;
    for(i=0; i<array.length; i++){
        if(array[i].length > len){
            len = array[i].length;
            pos = i;
        }
    }
    return pos;
}

//Reverse Array - Write a JavaScript function to reverse the elements of a given array.
function reverseArray(array){
    var tempArray = [];
    for(i=array.length-1; i>=0; --i){
        tempArray = tempArray.concat(array[i]);
    }
    return tempArray;
}

//Count Vowels - Write a JavaScript function to count the number of vowels in a given string.
function vowelCount(string){
    const vowels = ['a', 'e', 'i', 'o', 'u'];
    var vowelNum = 0;
    for(i=0; i<string.length; i++){
        if(vowels.includes(string[i])){
            vowelNum += 1;
        }
    }
    return vowelNum;
}

//Remove Script -  Write a JavaScript function to check if a string "Script" is present in a given string. If "Script" is present in the string return the string without "Script" otherwise return the original one.
function removeScript(string){
    string = string.replace('Script', '')
    return string;
}

//Find Leap Year - Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
function isLeapYear(date){
    if(date.getFullYear()%4 == 0){
        return true;
    }
    return false;
}

//Email Validation - Create a function that checks for a valid email format.
function isValidEmail(string){
    if(string.includes('@') && string.includes('.')){
        return true;
    }
    return false;
}

//Remove Character - Write a JavaScript function to remove a character at the specified position of a given string and return the new string.
function removeChar(string, index){
    return(string.replace(string[index], ''));
}

//Bubble Sort - Use the bubble sort algorithm to sort the array. You'll need to look this up! Return the sorted array.
function bubleSort(numArray){
    for(i=0; i<numArray.length-1; i++){
        console.log(numArray[i]);
        for(j=0; j<numArray.length-i-1; j++){
            if(numArray[j]>numArray[j+1]){
                let temp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = temp;
            }
        }
    }
    return numArray;
}

//Even Number - Return true if even, false if odd. Do not use % operator.
function isEven(someNum){
    if((someNum/2).toString().slice(-1) == 5){
        return false;
    }else{
        return true;
    }
}

// Palindrome - Return true if someStr is a palindrome, otherwise return false.
function isPalindrome(someStr){
    let palindrome = '';
    for(i=someStr.length-1; i>=0; i--){
        palindrome = palindrome.concat(someStr.charAt(i));
    }
    if(someStr == palindrome){
        return true;
    }else{
        return false;
    }
}

// Shapes - shape is a String and is either "Square", "Triangle", "Diamond". Height is a Number and is the height of the shape. Assume the number is odd. Character is a String that represents the contents of the shape. Assume this String contains just one character. Use a switch statement to determine which shape was passed in. Use the console.log function to print the desired shape.
function printShape(shape, height, character){
    switch(shape.toLowerCase()){
        case "square":
            for(i=0; i<height; i++){
                character = character.concat(character.charAt(0));
            }
            for(i=0; i<height; i++){
                console.log(character);
                console.log(" ")
            }
            break;
        case "triangle":
            for(i=0; i<height; i++){
                console.log(character);
                character = character.concat(character.charAt(0));
            }
            break;
        case "diamond":
            let space = ""  
            for(i=0; i<height/2-.5; i++){
                space += " ";
            }
            let newCharacter = character;
            console.log(space+newCharacter);
            for(i=0; i<height/2-.5; i++){
               space = space.slice(0, -1);
               newCharacter = newCharacter+character+character;
               console.log(space+newCharacter);
            }
            for(i=0; i<height/2-.5; i++){
                space += " ";
                newCharacter = newCharacter.slice(0, -2)
                console.log(space+newCharacter);
            }
            break;
        default:
            console.log("Not a valid option.");
            break;
    }
}

// Rotate Left - Given array, rotate left n times and return array
function rotate(array, n){
    let first;
    for(i=0; i<n; i++){
        first = array.shift();
        array = array.concat(first);
    }
    return(array);
}

// Balanced Brackets - 
function balanced(string){
    let openBrackets = ['(','[','{']
    let closeBrackets = [')',']','}'];
    let openFound = [];

    for(i=0; i<string.length; i++){
        for(j=0; j<openBrackets.length; j++){
            if(string[i] == openBrackets[j]){
                openFound = openFound.concat(string[i]);
            }
            if(string[i] == closeBrackets[j]){
                let close = closeBrackets.indexOf(string[i]);
                let open = openBrackets.indexOf(openFound.slice(-1).toString())
                if(close != open){
                    return false;
                }else{
                    openFound.pop()
                }

            }
                
        }
    }
    if(openFound[0]){
        return false;
    }
    return true;
}