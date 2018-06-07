// 1 Longest String
/**
 * Write a JavaScript function to find the longest string from any given array of strings and returns the string's array index.
 */

function maxLength(array) {
    var max = 0;
    var maxIdx;
    for (i in array) {
        if (array[i].length > max) {
            max = i.length;
            maxIdx = i;
        }
    }
    return maxIdx;
}

/**
 * 2. Reverse Array
 * Write a JavaScript function to reverse the elements of a given array.
 */
function reverseArray(array) {
    var output = [];
    for (var i = array.length-1; i >= 0; i--) {
        output.push(array[i]);
    }
    return output;
}

/**
 * 3. Count Vowels
 * Write a JavaScript function to count the number of vowels in a given string.
 */
function vowelCount(string) {
    var arr = string.split("");
    var vowels = "aeiou".split("");
    var count = 0;
    for (i of arr) {
        for (v of vowels) {
            if (i === v) count++;
        }
    }
    return count;
}

/**
 * 4. Remove Script
 * Write a JavaScript function to check if a string "Script" is present in a given string. If Script is present int he string return the string without "Script" otherwise return the original one.
 */
function removeScript(string) {
    var arr = string.split(" ");
    for (i in arr) {
        if (arr[i] === "Script") {
            arr[i] = "";
        }
    }
    return arr.join(" ");
}

/**
 * 5. Find Leap Year
 * Create a JavaScript function that takes a date parameter and returns true if the year is a leap year in the Gregorian calendar.
 */
function isLeapYear(date) {
    var year = date.getFullYear();
    return (year % 4) === 0;
}

/**
 * 6. Email validation
 * Create a function that checks for a vaid email format.
 */
function isValidEmail(string) {
    return /^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/.test(string);
}

/**
 * 7. Remove Character
 * Write a JavaScript function to remove a character at the specified position of a given string and return the new string.
 */
function removeChar(string, index) {
    var array = string.split("");
    array[index] = "";
    return array.join("");
}

/**
 * 9. Bubble Sort
 * Use the bubble sort arlgorithm to sort the array. You'll need to look this up! Return the sorted array.
 */
function bubbleSort(numArray) {
    for (var i = numArray.length-1; i >= 0; i--) {
        var maxIdx = 0;
        for (var j = 0; j <= i; j++) {
            if (numArray[j] > numArray[maxIdx]) maxIdx = j;
        }
        var temp = numArray[i];
        numArray[i] = numArray[maxIdx];
        numArray[maxIdx] = temp;
    }
    return numArray;
}

/**
 * 10. Even Number
 * Return true if even, false if odd. Do not use the % operator.
 */
function isEven(someNum) {
    return (1 & someNum) == 0; 
}

/**
 * 11. Palindrome
 * Return true if someStr is a palindrome, otherwise return false.
 */
function isPalindrome(someStr) {
    var i = 0;
    var j = someStr.length-1;
    
    while (i < j) {
        if (someStr[i] != someStr[j]) return false;
        i++;
        j--;
    }
    return true;
}

/**
 * 12. Shapes
 * Define function: printShape(shape, height, character)
 * Shape is a String and is either Square, Triangle, Diamond. Height is a Number and is the height of the shape. Assume the number is odd.
 * Character is a STring that represnets the contents of teh shape. Assume this String contains just one character. Use a switch statement to determine which shape was passed in. Use the console.log function to print the desired shape.
 * 
 */
function printShape(shape, height, character) {
    switch (shape) {
        case "Square":
            var str = "";
            for (var s = 0; s < height; s++) {
                str = str.concat(character);
            }
            var output = "";
            for (var i = 0; i < height; i++, output = output.concat("\n")) {
                output = output.concat(str);
            }
            console.log(output);
            break;
        
        case "Triangle":
            var str = "";
            var output = "";
            for (var i = 0; i < height; i++, output = output.concat("\n")) {
                str = str.concat(character);
                output = output.concat(str);
            }
            console.log(output);
            break;
        
        case "Diamond":
            var out = "";
            var hmo = (height-1)/2;
            for (var i = hmo; i >= 0; i--, out = out.concat("\n")) {
                out = out.concat(makeOddString(height, character, i));
            }
            for (var i = 1; i <= hmo; i++, out = out.concat("\n")) {
                out = out.concat(makeOddString(height, character, i));
            }
            console.log(out);
            break;
            
    }
}

function makeOddString(length, character, numBlank) {
    var out = "";
    for (var i = 0; i < numBlank; i++) {
        out = out.concat(" ");
    }
    for (var i = 0; i < (length - (numBlank*2)); i++) {
        out = out.concat(character);
    }
    for (var i = 0; i < numBlank; i++) {
        out = out.concat(" ");
    }
    return out;
}


/**
 * 13. Rotate Left
 * Given an array, rotate left n times and return array.
 */
function rotate(array, n) {
    var move = n % (array.length);
    var arrRight = array.slice(0, move);
    var arrLeft = array.slice(move);
    return arrLeft.concat(arrRight);
}

/**
 * 14. Balanced Brackets
 * A bracket is any one of the following: (, ), {, }, [, ]
 * 
 * The following are balanced brackets:
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
