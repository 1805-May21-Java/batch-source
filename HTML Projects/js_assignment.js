// 1. Longest String
function maxLength(array) {
    var maxIndex = 0;
    var maxLen = 0;
    for (let i = 0; i < array.length; i++) {
        if (array[i].length > maxLen) {
            maxIndex = i;
            maxLen = array[i].length; 
        }
    }
   return maxIndex;
}

// 2. Reverse Array
function reverseArray(array) {
    var newArr = [];
    for (let i = array.length-1; i >= 0; i--) {
        newArr.push(array[i]);
    }
    return newArr;
}

// 3. Count Vowels
function vowelCount(string) {
    var vowels = ['a', 'e', 'i', 'o', 'u'];
    var count = 0;
    for (let i = 0; i < string.length; i++) {
        if (vowels.includes(string.charAt(i))) {
            count++;
        }
    }
    return count;
}

// 4. Remove Script
function removeScript(string) {
    while (string.includes("Script")) {
        string = string.replace("Script", "");
    }
    return string;
}

// 5. Find Leap Year
function isLeapYear(date) {
    var year = date.getFullYear();
    return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
}

// 6. Email Validation
function isValidEmail(string) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(string);
}

// 7. Remove Character
function removeChar(string, index) {
    return string.substring(0, index) + string.substring(index+1, string.length);
}

// 8. Bubble Sort
function bubbleSort(numArray) {
    for (let i = 0; i < numArray.length; i++) {
        for (let j = 0; j < numArray.length-i-1; j++) {
            if (numArray[j] > numArray[j+1]) {
                var temp = numArray[j+1];
                numArray[j+1] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
    return numArray;
}

// 9. Even Number
function isEven(someNum) {
    return (someNum / 2) == Math.round(someNum / 2);
}

// 10. Palindrome
function isPalindrome(someStr) {
    if (someStr.length == 1 || someStr.length == 0) {
        return true;
    } 
    if (someStr.charAt(0) == someStr.charAt(someStr.length-1)) {
        return isPalindrome(someStr.slice(1, someStr.length-1));
    } else {
        return false;
    }
}

// 11. Shapes
function printShape(shape, height, character) {
    switch (shape) {
        case "Square":
            for (let i = 0; i < height; i++) {
                console.log(character.repeat(height));
            }
            break;
        case "Triangle":
            for (let i=1; i<=height; i++) {
                console.log(character.repeat(i));
            }
            break;
        case "Diamond":
            for (let i=0; i<height; i+=2) {
                var str = "";
                str = str + " ".repeat(Math.floor(height/2-i)) + character.repeat(i+1) + " ".repeat(Math.floor(height/2-i));
                console.log(str);
            }
            break;
        default:
            console.log("Incorrect shape name");
            break;
    }
}

// 12. Rotate Left
function rotateArray(array, n) {
    rotation = n % array.length;
    for (let i=0; i<rotation; i++) {
        var temp = array[0];
        for (let j=0; j<array.length-1; j++) {
            array[j] = array[j+1];
        }
        array[array.length-1] = temp
    }
    return array;
}

// 13. Balanced Brackets
function balanced(string) {
    var arr = string.split('');
    var stack = [];

    for (var i=0; i<arr.length; i++) {
        if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
            stack.push(arr[i]);
        } else {
            if (stack.length == 0) {
                return false;
            }
            var last = stack.pop();
            if (!((last=='(' && arr[i]==')') || (last=='{' && arr[i]=='}') || (last=='[' && arr[i]==']'))) {
                return false;
            }
        }
    }
    if (stack.length == 0) {
        return true;
    } else {
        return false;
    }
}