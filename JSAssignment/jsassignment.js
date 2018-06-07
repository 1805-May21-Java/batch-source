function maxLength(array) {
    var longestString = "";
    var index = 0;
    for (i = 0; i < array.length; i++) {
        if (array[i].length > longestString.length) {
            longestString = array[i];
            index = i;
        }
    }
    return index;
}

function reverseArray(array2) {
    var len = array2.length;
    var tempArr = [];
    for (i = len; i > 0; i--) {
        tempArr.push(array2[i - 1]);
    }
    return tempArr;
}

function countVowels(string) {
    var count = 0;
    for (i = 0; i < string.length; i++) {
        if (string[i] == 'a') count++;
        if (string[i] == 'e') count++;
        if (string[i] == 'i') count++;
        if (string[i] == 'o') count++;
        if (string[i] == 'u') count++;
    }
    return count;
}

function removeScript(string) {
    var index = string.indexOf('Script');
    if (index == -1) {
        return string;
    }
    var tempString = "";
    tempString += string.subtring(0, index);
    tempString += string.subtring(index + 6, string.length);
    return tempString;
}

function isLeapYear(date) {
    var leapYear = false;
    if (date.getFullYear() % 4 == 0) leapYear = true;
    if (date.getFullYear() % 100 == 0) leapYear = false;
    if (date.getFullYear() % 400 == 0) leapYear = true;
    return leapYear;
}

function emailValidation(string) {
    if (!string.includes('@')) {
        console.log("No @ symbol")
        return false;
    }
    if (!string.endsWith('.com') && !string.endsWith('.net') && !string.endsWith('.gov')) {
        console.log("No ending")
        return false;
    }
    return true;
}

function removeChar(string, index) {
    var tempStr = "";
    tempStr += string.substring(0, index - 1);
    tempStr += string.substring(index, string.length);
    return tempStr;
}

function bubbleSort(numArray) {
    for (i = 0; i < numArray.length - 1; i++) {
        for (j = 0; j < numArray.length - i - 1; j++) {
            if (numArray[j] > numArray[j + 1]) {
                var temp = numArray[j];
                numArray[j] = numArray[j + 1];
                numArray[j + 1] = temp;
            }
        }
    }
    return numArray;
}

function evenCheck(someNum) {
    return (someNum / 2 == Math.round(someNum / 2));
}

function isPalindrome(somestring) {
    for (i = 0; i < somestring.length / 2; i++) {
        if (!(somestring[i] == somestring[somestring.length - 1 - i])) {
            return false;
        }
    }
    return true;
}

function shapes(shape, height, character) {
    switch (shape) {
        case "Square":
            let output = "";
            for (i = 0; i < height; i++) {
                output += character;
            }
            let output3="";
            for (i = 0; i < height; i++) {
                output3 += output+"\n";
            }
            console.log(output3);
            break;
        case "Triangle":
            let output2 = "";
            for (i = 0; i < height; i++) {
                output2 += character;
                console.log(output2);
            }
            break;
        case "Diamond":
            var y, w, shape = '';

            for (y = 0; y < height * 2 - 1; y+=2) {
                w = y < height ? y : height * 2 - y - 2;
                shape += Array(height - w).join(' ') + Array(w + 1).join(character+' ') + character+'\n';
            }
            console.log(shape);
            break;
    }
}

function rotateLeft(array, n){
    for(i=0;i<n;i++){
        array = rotate(array);
    }
    console.log(array);
}

function rotate(array){
    let tempNum=array[0];
    for(k=0;k<array.length-1;k++){
        array[k] = array[k+1];
    }
    array[array.length-1]=tempNum;
    return array;
}

function balanced(bracketString){
    var stack = [];
    for(l=0;l<bracketString.length;l++){
        if(bracketString[l] =="(" || bracketString[l] == "[" || bracketString[l]=="{"){
            stack.push(bracketString[l]);
        } else{
            console.log(bracketString[l]);
            console.log(stack[stack.length-1]);
            if((bracketString[l]==")" && stack[stack.length-1]=="(") || 
                    (bracketString[l]=="]" && stack[stack.length-1]=="[") ||
                    (bracketString[l]=="}" && stack[stack.length-1]=="{")){
                stack.pop();
            } else{
                return false;
            }

        }

    }
    return true;
}