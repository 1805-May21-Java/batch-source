

//1. Longest String
function maxLength(array){
    var maxCount = 0;
    var maxIndex;
    for(x in array){
        let count = array[x].length;
        if(count > maxCount){
            maxIndex = x;
            maxCount = count;
        }
    }
    return maxIndex;
}

//2.Reverse Array
function reverseArray(array){
    //must declare tmp to be an empty array.
    var tmp = [];
    while(array.length != 0){
        tmp.push(array.pop());
    }
    array = tmp;
    return array;
}

//3. Count Vowels
function vowelCount(string){
    const vowels = ['A','a', 'E', 'e', 'I', 'i', 'O', 'o', 'U','u'];
    let count = 0;
    for(x in string){
        //checks if character at index is a value in array vowels.
        if(vowels.includes(string.charAt(x))){
            count+=1;
        }
    }
    return count;
}

//4. Remove Script (remove "Script" if present in string)
function removeScript(string){
    const scriptIndex = string.search("Script");
    if(scriptIndex == -1){
        return string;
    }else{
        stringArray = string.split("Script");
        let newArray = new String();
        for(x in stringArray){
            newArray+=stringArray[x];
        }
        return newArray;
    }
}

//5. Find Leap Year
//Included a default value in the parameter to access Date() methods.
function isLeapYear(date = new Date()){
    let year = date.getFullYear();
    if((year % 4) == 0){
        return true;
    }else{
        return false;
    }
}

//6. Email Validation
function isValidEmail(string){
    //Checking for "@"" and "."" characters, and repetitions of them.
    atCount = 0;
    dotCount = 0;
    for(i = 0; i < string.length; i++){
        if((dotCount === 1) && (atCount === 0)){
            return false;
        }
        if(string.charAt(i) === "@"){
            atCount+=1;
        }
        if(string.charAt(i) === "."){
            dotCount+=1;
        }
    }
    if((atCount > 1) || (dotCount > 1) ){
        return false;
    }else if(atCount === 0 || dotCount === 0){
        return false;
    }else{
        return true;
    }
}

//7. Remove Character
function removeChar(string, index){
    firstHalf = string.slice(0, index);
    secondHalf = string.slice(index+1);
    string = firstHalf + secondHalf;
    return string;
}

//8. Bubble Sort
function bubbleSort(numArray){
    let arrayLength = numArray.length;
    for(i = 0; i < arrayLength - 1; i++){
        if(numArray[i] > numArray[i+1]){
            let temp = numArray[i];
            numArray[i] = numArray[i+1];
            numArray[i+1] = temp;
        }
    }

    for(j = 0; j < arrayLength - 1; j++){
        if(numArray[j] > numArray[j+1]){
            bubbleSort(numArray);
        }
    }
    return numArray;
}

//9. Even Number
function isEven(someNum){
    //used Math.floor to round down possible decimals
    let remainder = Math.floor(someNum / 2);
    let originalNumber = remainder * 2;
    if(originalNumber === someNum){
        return true;
    }else{
        return false;
    }
}

//10. Palindrome
function isPalindrome(someStr){
    let strArray = someStr.split("");
    let reverseStr = "";

    for(i=strArray.length-1; i >= 0; i--){
        reverseStr += strArray[i];
    }
    
    if(reverseStr === someStr){
        return true;
    }else{
        return false;
    }
}

//11. Shapes
function printShape(shape, height, character){

    switch(shape){
        case "Square":
            let square = ""
            for(i = 0; i < height; i++){
                square += character + character + character + "\n";
            }
            console.log(square);
            break;
        case "Triangle":
            let triangle = ""
            let triangleLine = "";
            for(i = 0; i < height; i++){
                triangleLine += character;
                triangle += triangleLine + "\n";
            }
            console.log(triangle);
            break;
        case "Diamond":
            let diamondLine = "";
            let diamond = "";
            count = 0;
            //resetDiamond = false;
            for(i = 0; i < height; i++){
                count += 1;
                if(count === 1 || count === 5){
                    diamondLine = "  " + character + "\n";
                }else if(count === 2 || count === 4){
                    diamondLine = " " + character + character + character + "\n";
                }else if(count === 3){
                    diamondLine = character+character+character+character+character + "\n";
                    count = 0;
                }
                diamond += diamondLine;
            }
            console.log(diamond);
            break;
        default:
            console.log("Not a valid shape for this program.");
    }

}

//12. Rotate Left
function rotate(array, n){
    if(n <= 0){
        return array;
    }else{
        let leftmost = array[0];
        array = array.slice(1).concat(leftmost);
        return rotate(array, n - 1);
    }
}

//13. Balanced Brackets
function balanced(string){

    //if length is odd, then it will always be an unbalanced.
    if(string.length % 2 === 1){
        return false;
    }

    //will be iterating through only half of the string
    halved = string.length / 2;
    brackets = ["(", "{", "[", "]", "}", ")"];

    //if statements check for open and closing bracket enclosing pair
    //else if statements checks for single pair of open and closed brackets
    //both if and else if statements return false if condition is true.
    for(i=0; i < halved ; i++){
        if((brackets.includes(string.charAt(i))) === false){
            return false;
        }

        if(string.charAt(i) === "("){
            if(string.charAt((string.length-1) - i) !== ")" ){
                return false;
            }
        }else if(string.charAt(i) === ")"){
            if(string.charAt(i - 1) !== "(" ){
                return false;
            }
        }

        if(string.charAt(i) === "{"){
            if(string.charAt((string.length-1) - i) !== "}"){
                return false;
            }
        }else if(string.charAt(i) === "}"){
            if(string.charAt(i - 1) !== "{" ){
                return false;
            }
        }

        if(string.charAt(i) === "["){
            if(string.charAt((string.length-1) - i) !== "]"){
                return false;
            }
        } else if(string.charAt(i) === "]"){
            if(string.charAt(i - 1) !== "[" ){
                return false;
            }
        }

    }
    //string is confirmed to be balanced and returns true.
    return true;
}


