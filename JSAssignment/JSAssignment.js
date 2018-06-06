var array1 = ["abcd", "hijglmn", "asacas", '1111111111']

function maxLength(array){
    k = array[0].length;
    for (i = 0; i < array1.length; i++){
        if (k < array[i].length){
            k = array[i].length
        }
    }
    return k
}

function reverseArray(array){
    for (i = array.length-1; i > 0; i--){
        for (j = 0; j < i; j++){
            s = array[j];
            array[j] = array[j+1];
            array[j+1] = s;
        }
    }
    return array;
}

s = "savioqhoqvnlvemiqevonivendoep";

function vowelCount(string){
    count = 0;
    for (i = 0; i < string.length; i++){
        if(string.charAt(i) == 'a' ||string.charAt(i) == 'e' ||string.charAt(i) == 'i' ||
        string.charAt(i) == 'o' ||string.charAt(i) == 'u'){
            count++;
        }
    }
    return count;
}

s1 = "telas helloscriptworld"

function removeScript(string){
    if (string.search("script") != -1){
        a = string.search("script");
        string = string.substring(0,a)+string.substring(a+6, string.length);
    }
    return string;
}

var d = new Date (2100, 11, 15)

function isLeapYear(date){
    a = date.getFullYear();
    if(a%100 != 0 && a%4 == 0){
        return true;
    }
    else if (a%400 == 0){
        return true;
    }
    return false;
}

var s2 = "helloworld@goal.com"

function isValidEmail(string){
    a = string.search('@');
    sa = string.substring(0, a);
    sb = string.substring(a+1, string.length);
    b = sb.indexOf('.');
    if (a != -1 && b != -1){
        return true;
    }
    return false;
}

function removeChar(string, index){
    string = string.substring(0, index-1)+string.substring(index, string.length);
    return string;
}

var num = [11,20,3,14,5,8,9,24];

function bubbleSort(numArray){
    count = 1;
    while (count != 0){
        count = 0;
        for (i = 0; i < numArray.length-1; i++){
            if (numArray[i] > numArray[i+1]){
               a = numArray[i];
               numArray[i] = numArray[i+1];
               numArray[i+1] = a;
               count++; 
            }
        }
    }
    return numArray;
}

function isEven(someNum){
    a = someNum/2;
    a = a+s;
    b = a.indexOf('.');
    if(b == -1){
        return true;
    }
    return false;
}

s3 = "helloolleh";

function isPalindrome(someString){
    if(isEven(someString.length)){
        a = someString.length/2;
        b = someString.length-1;
        for (i = 0; i < a; i++){
            if(someString.charAt(i) != someString.charAt(b-i)) {
                return false
            }
        }
        return true;
    }
    else{
        a = (someString.length-1)/2;
        b = someString.length-1;
        for (i = 0; i < a; i++){
            if(someString.charAt(i) != someString.charAt(b-i)) {
                return false
            }
        }
        return true;
    }
}

s4 = "square";
s5 = "@";
function printShape(shape, height, character){
    //if(isEven(height)){ return 0}
    var s = "";
    switch(shape){
        case "square":;
            for(i = 0; i < height; i++){
                s += character;
            }
            for(j = 0; j < height; j++){
                console.log(s+j);
            }
            break;
        case "triangle":
            for(i = 0; i < height; i++){
                s += character;  
                console.log(s);
            }
            break;
        case "diamond":
            s = "  ";
            s += character;
            console.log(s);
            for (i = 1; i < height; i++){
                if(i < height/2){
                    s = s.substring(1, s.length);
                    s += character;
                    s += character;
                }
                else{
                    s = " "+ s;
                    s = s.substring(0, s.length-2);
                }
                console.log(s);
            }
            break;
    }
}

array2 = [1,2,3,4,5,6,7];

function rotate(array, n){
    for (i = 0; i < n; i++){
        for (j = 0; j < array.length-1; j++){
            q = array[j];
            array[j] = array[j+1];
            array[j+1] = q;
        }
    }
    return array2;
}

s6 = "([]){}"

function balanced(string){
    count = 0;
    var s = [];
    for (i = 0; i < string.length; i++){
        if (string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{' || 
        string.charAt(i) == ')' || string.charAt(i) == ']' || string.charAt(i) == '}'){
            if(string.charAt(i) == '(' || string.charAt(i) == '[' || string.charAt(i) == '{'){
                count++;
                s[count-1] = string.charAt(i);
            }
            else if(string.charAt(i) == ')' || string.charAt(i) == ']' || string.charAt(i) == '}'){
                if (s[count-1] == '(' && (string.charAt(i) == ']' || string.charAt(i) == '}')){
                    return false;
                }
                if (s[count-1] == '[' && (string.charAt(i) == ')' || string.charAt(i) == '}')){
                    return false;
                }
                if (s[count-1] == '{' && (string.charAt(i) == ']' || string.charAt(i) == ')')){
                    return false;
                }
                count--;
            }
        }
    }
    if(count == 0){
        return true;
    }
    return false;
}
