function maxLength(array) {
    var len = 0;
    var index = -1;
    for (i = 0; i < array.length; i++) {
        if (len < array[i].length) {
            len = array[i].length;
            index = i;
        }
    }
    return index;
}

function reverseArray(array) {
    for (i = 0; i < array.length / 2; i++) {
        elem = array[i];
        array[i] = array[array.length - i - 1];
        array[array.length - i - 1] = elem;
    }

    return array;
}

function vowelCount(str) {
    str = str.toLowerCase();
    function isVowel(char) {
        vowel = ['a', 'e', 'i', 'o', 'u'];
        for (a of vowel) {
            if (a == char) {
                return true;
            }
        }
        return false;
    }
    var count = 0;
    for (i = 0; i < str.length; i++) {
        if (isVowel(str[i])) {
            count++;
        }
    }

    return count;
}

function removeScript(string) {
    let i = string.search('Script');
    if (i == -1) {
        return string;
    }

    return string.replace('Script', '');
}

function isLeapYear(date) {
    var result;
    year = date.getYear();
    if (year % 4 != 0) {
        result = false;
    } else if (year % 100 != 0) {
        result = true;
    } else if (year % 400 != 0) {
        result = false
    } else {
        result = true;
    }
    return result
}

function isValidEmail(string) {
    let l = string.length;
    let index = 0;

    for (index = 0; index < l; index++) {
        if (string[index] == '@') {
            break;
        }
    }

    if (index == l) {
        return false;
    }

    for (; index < l; index++) {
        if (string[index] == '.') {
            break;
        }
    }

    if (index == l) {
        return false;
    }

    return true;
}

function removeChar(string, index) {
    let newStr = '';
    for (i = 0; i < string.length; i++) {
        if (i != index) {
            newStr += string[i];
        }
    }

    return newStr;
}

function bubbleSort(numArray) {
    do {
        swapped = false;
        for (i = 0; i < numArray.length - 1; i++) {
            if (numArray[i] > numArray[i + 1]) {
                swapped = true;
                temp = numArray[i];
                numArray[i] = numArray[i + 1];
                numArray[i + 1] = temp;
            }
        }
    } while (swapped);
    return numArray;
}

function isEven(n) {
    while (n > 1) {
        n -= 2;
    }

    if (n == 0) {
        return true;
    }

    return false;
}

function isPalindrome(string) {
    revString = "";
    for (j = string.length - 1; j >= 0; j--) {
        revString += string[j];
    }

    if (string == revString) {
        return true;
    }

    return false;
}

function printShape(shape, height, character) {
    function printSquare() {
        str = '';
        for (i = 0; i < height; i++) {
            for (j = 0; j < height; j++) {
                str += character;
            }
            str += '\n';
        }
        console.log(str);
    }

    function printTriangle() {
        str = '';

        width = 1;
        for (i = 0; i < height; i++) {
            for (j = 0; j < width; j++) {
                str += character;
            }
            width++;
            str += '\n';
        }

        console.log(str);
    }

    function printDiamond() {
        str = '';

        numChar = 1;

        for (i = 0; i < height/2; i++) {
            spaces = (height / 2) - (numChar/2);
            for (j = 0; j < spaces; j++) {
                str += '_';
            }

            for (j = 0; j < numChar; j++) {
                str += character;
            }

            for ( j = 0; j < spaces; j++ ) {
                str+='_';
            }

            str+='\n';
            numChar += 2;
        }

        numChar -= 2;

        for ( i = 0; i < (height/2)-1; i++ ) {
            numChar -= 2;
            spaces = (height / 2) - (numChar/2);
            for ( j = 0;j < spaces; j++ ) {
                str+='_';
            }

            for ( j = 0; j < numChar; j++ ) {
                str+= character;
            }

            for ( j = 0; j < spaces; j++ ) {
                str+='_';
            }
            str +='\n';
        }
        console.log(str);
    }

    if (shape == 'square') {
        printSquare();
    } else if (shape == 'triangle') {
        printTriangle();
    } else if (shape == 'diamond') {
        printDiamond();
    }
}

function rotate(array , n ) {
    function rotateOne(array) {
        temp = array[0];
        for ( let i = 0; i < array.length-1; i++ ) {
            array[i] = array[i+1];
        }

        array[array.length-1] = temp;
        return array;
    }

    for ( let i = 0; i < n; i++ ) {
        array = rotateOne(array);
    }

    return array;
}

function balanced(string) {
    var parenthesis = 0;
    var squiggle = 0;
    var squareB = 0;

    for ( let i = 0; i < string.length;i++ ) {
        switch(string[i]) {
            case '(':
            parenthesis++;
            break;
            case ')':
            parenthesis--;
            break;
            case '{':
            squiggle++;
            break;
            case '}':
            squiggle--;
            break;
            case '[':
            squareB++;
            break;
            case ']':
            squareB--;
            break;
        }
    }

    return parenthesis==0 && squiggle==0 && squareB==0;
}