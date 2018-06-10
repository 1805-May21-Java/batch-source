// Longest String
function maxLength(array) {
    var max = 0;
    for (i = 1; i < array.length; i++) {
        if(array[i].length > array[max].length)
            max = i;
    }
    return i;
}

// reverse array
function reverseArray(array) {
    var array2 = [];
    for ( i = 0; i < array.length; i++) {
        array2.push(array[array.length - 1 - i]);
    }
    return array2;
}

// count vowels
function vowelCount(string) {
    var count = 0;

    for(i = 0; i < string.length; i++) {
        if(string[i] == 'a' || string[i] == 'e' || string[i] == 'i' ||  string[i] == 'o' ||  string[i] == 'u' ) {
            count++;
        }
    }

    return count;
}

// Remove Script
function removeScript(string) {

    while(string.indexOf('Script') >= 0) {
        string = string.replace('Script', '')
    }
    return string;
 }


// check if leap year
// expects a date object
function isLeapYear(date) {
    var year = date.getFullYear();
    if(year % 4) {
        return false;
    } else if (year % 100) {
        return true;
    } else if (year % 400) {
        return false;
    } else 
        return true;
}

// check if valid email address
function isValidEmail(string) {
    var re = /^[\w._]+@\w+[.]\w{2,3}$/g;
    if (string.match(re)) {
        return true;
    }
    return false;
}

// Remove Character
function removeChar(string, index) {
    return string.slice(0, index) + string.slice(index + 1);
}

// Bubble Sort
function bubbleSort(numArray) {
    for(i = 0; i < numArray.length; i++) {
        for(j = 0; j < numArray.length; j++) {
            if(numArray[j] > numArray[j+1]) {
                let temp = numArray[j];
                numArray[j] = numArray[j+1];
                numArray[j+1] = temp;
            }

        }
    }
    return numArray;
}

// Even Number
function isEven(someNum) {
 if(Math.floor(someNum / 2) * 2 == someNum) 
        return true;
    return false;
}

// Palindrome
function isPalindrome(someStr) {
    return(someStr == someStr.split('').reverse().join(''));
}

// Shapes
function printShape(shape, height, character) {
    shape = shape.toLowerCase();
    switch (shape) {
        case 'square':
            for(i = 0; i < height; i++) {
                console.log(character.repeat(height));
            }
            break;
        case 'triangle':
            for(i = 0; i < height; i++) {
                console.log(character.repeat(i + 1));
            }
            break;
        case 'diamond':
            var i = 1, j = height/2, k = 0;
            var space = " ";
            while( k < height) {
                console.log(space.repeat(j) + character.repeat(i) + space.repeat(j));
            
                if(k + 1 < height/2) {
                    i+= 2;
                    j--;
                } else {
                    i-=2;
                    j++;
                }

                k++;
            }
            break;
        default:
            break;
    }
}

// Rotate array
function rotate(array, n) {
    for(i = 0; i < n; i++) {
        array.push(array.shift());
    }
    return array;
}

// Balance Brackets
function balanced(string) {
    if(string.length % 2)
        return false;
    stringArr = string.split("");
    while(stringArr.length != 0) {
        console.log(stringArr.length);
        var a = stringArr.shift();
        var b = stringArr.pop();
        switch(a) {
            case '(':
            console.log('(')
                if (b != ')') return false;
                break
            case '[':
                console.log('[')
                if (b != ']') return false;
                break;
            case '{': 
            console.log('{')
                if (b != '}') return false;
                break;
            default:
                return false;
        }
    }

    return true;
}