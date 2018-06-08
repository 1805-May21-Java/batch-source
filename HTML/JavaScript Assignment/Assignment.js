
//1. Longest String
function maxLength(array){
    let length= 0;
    let index = 0;
    for(i = 0; i< array.length; i++){

        if(array[i].length > length){
            length = arr[i].length;
            index = i;
        }
    }
    return index;
}

//2. Reverse Array
function reverseArray(array){
    let reversed = array.reverse();
    return reversed;
}

//3. Count Vowels
function countVowels(string){
    let count = 0;
    for(i = 0; i < string.length; i++){
        if(string.charAt(i) == 'a' || string.charAt(i) == 'A'){
            count++;
        }
        if(string.charAt(i) == 'e' || string.charAt(i) == 'E'){
        count++;
        } if(string.charAt(i) == 'i' || string.charAt(i) == 'I'){
            count++;
        } if(string.charAt(i) == 'o' || string.charAt(i) == 'O'){
            count++;
        } if(string.charAt(i) == 'u' || string.charAt(i) == 'U'){
            count++;
        }
    }
    return count;
}

//4. Remove Script
function removeScript(string){
    while(string.includes("Script")){
       string = string.replace("Script", "");
    }
    return string;
}

//5. Find Leap Year
function isLeapYear(date){
    return ((date.getFullYear() % 4 == 0) && (date.getFullYear() % 100 !=0)) || (date.getFullYear() % 400 == 0);
}

//6. Email Validation
function isValidEmail(string){
    return /[^\s@]+@[^\s@]+\.[^\s@]+/.test(string);
}

//7.Remove Character
function removeChar(string, index){
    return string.slice(0,index) + string.slice(index+1, string.length);
}

//8. Bubble Sort
function bubbleSort(numArray){
    var temp;

    for(i = 0; i < numArray.length; i++){
        for(j = 1; j < (numArray.length); j++){
            if(numArray[j-1] > numArray[j]){
                temp = numArray[j-1];
                numArray[j-1] = numArray[j];
                numArray[j] = temp;
            }
        }
    }
}

//9. Even Number
function isEven(someNum){
    let num = parseInt(someNum);
    if(((parseInt(someNum/2))*2) == parseInt(someNum)){
        return true;
    }else{
        return false;
    }
}

//10. Palindrome
function isPalindrome(someStr){
    let temp="";
    for(i = someStr.length; i > -1; i--){
        temp = temp.concat(someStr.charAt(i));
    }
    console.log(someStr);
    console.log(temp);  
    if(someStr == temp){
        return true;
    }else{
        return false;
    }

}

//11. Shapes
function printShape(shape, height, character){
    let temp ="";

    switch(shape){
        case "Triangle":{
            for(i = 1; i <=height; i++){
                for(j = i; j > 0 ; j--){
                    temp += character;
                }
                temp += '\n';
            }
            console.log(temp);
            break;
        }
        case "Square":{
            for(i = 0; i<height; i++){
                for(j = 0; j<height; j++ ){
                    temp += character;
                }
                temp +='\n';
            }
            console.log(temp);
            break;
        }
        case "Diamond":{
            for(i = 1; i<= height; i +=2){  
                for(j = 0; j < height-i/2; j++){
                    temp +=" ";
                }
                for(k = 0; k < i; k++){
                    temp += character;
                }
                temp += '\n';
            }
            for(i = height-2; i > 0; i -=2){
                for(j = 0; j < height-i/2; j++){
                    temp += " ";
                }
                for(k = 0; k < i; k++){
                    temp += character;
                }
                temp += "\n";
            }
            console.log(temp);
            break;
        }
    }
}
    
//12. Rotate Left
function rotate(arr, n){   
    if(n <= 0){
        return arr;
    }else{
        for(i = 0; i < n ; i++){
            let temp = arr.shift();
        arr = arr.concat(temp);
        }
    }
    return arr;
}


//Balanced Brackets
function balanced(string){
    strArr = string.split("");
    if(strArr.length <= 1){
        return false;
    }
    let match, ch;
    let stack = [];
  
    let openingBrackets = ['[', '{', '('];
    let closingBrackets = [']', '}', ')'];
  
    for (let i = 0; i < strArr.length; i++) {
      ch = strArr[i];
  
      if (closingBrackets.indexOf(ch) > -1) {
        match = openingBrackets[closingBrackets.indexOf(ch)];
        if (stack.length == 0 || (stack.pop() != match)){
          return false;
        }
      } else {
        stack.push(ch);
      }
    }
  
    return (stack.length == 0);
}

