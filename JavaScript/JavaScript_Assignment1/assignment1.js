// 1. Longest String
console.log("Problem 1");
function maxLength(stringArray){
  let longestString = stringArray[0];
  let index = 0;
  for(let i = 1; i < stringArray.length; i++) {
    if(stringArray[i].length > longestString.length) {
      longestString = stringArray[i];
      index = i;
    }
  }
  return index;
}

console.log(maxLength(['a', 'aa', 'aaa', 'aaaa']));  // 3
console.log(maxLength(['aa', 'aaaaaaa', 'a', 'aaaaaa'])); // 1





// 2. Reverse Array
console.log("\n\nProblem 2");
function reverseArray(arr){
  const reversed = [];
  for(let i = arr.length - 1; i >= 0; i--) {
    reversed.push(arr[i]);
  }
  return reversed;
}

console.log(reverseArray([1,2,3,4,5])); // [5,4,3,2,1]






// 3. Vowel Count
console.log("\n\nProblem 3");
function vowelCount(str) {
  function isVowel(char) {
    return char === "a" || char === "e" || char === "i" || char === "o" || char === "u";
  }
  let sum = 0;
  for(let i = 0; i < str.length; i++) {
    if(isVowel(str[i].toLowerCase()))
      sum++;
  }
  return sum;
}

console.log(vowelCount("Hello, world!")); // 3
console.log(vowelCount("asEdOIjju")) // 5






// 4. Remove Script
console.log("\n\nProblem 4");
function removeScript(str){
  if(str.includes("Script")){
    const index = str.indexOf("Script");
    return str.slice(0, index) + str.slice(index + "Script".length);
  }
  return str;
}

console.log(removeScript("Hello, world!")); // Hello, world!
console.log(removeScript("helloScriptworld")); // helloworld






// 5. Find leap year
console.log("\n\nProblem 5");
function isLeapYear(date){
  const year = new Date(date).getFullYear();
  if(year % 400 === 0)
    return true;
  if(year % 100 === 0)
    return false;
  return year % 4 === 0;
}
console.log(isLeapYear('2000-05-10')); //true
console.log(isLeapYear('1900-05-10')); //false
console.log(isLeapYear('2016-05-10')); //true




// 6. Email validation
console.log("\n\nProblem 6");
function isValidEmail(str){
  const re = /[\w\.]+@\w+\.\w+/;
  return re.test(str);
}

console.log(isValidEmail("bob.mcgee@gmail.com")); // true
console.log(isValidEmail("sdkajsdkd.com")); // true



// 7. Remove character
console.log("\n\nProblem 7");
function removeChar(str, index) {
  return str.slice(0, index) + str.slice(index + 1);
}
console.log(removeChar("Hello, world!", 5)); // Hello world!
console.log(removeChar("abcdefg", 2)); // abdefg





// 8. Bubble sort
console.log("\n\nProblem 8");
function bubbleSort(numArray) {
  for(let i = 0; i < numArray.length; i++){
    for(let j = i + 1; j < numArray.length; j++) {
      if(numArray[i] > numArray[j])
        [numArray[i], numArray[j]] = [numArray[j], numArray[i]];
    }
  }
  return numArray;
}

console.log(bubbleSort([3,1,7,6,-1,8,4])); // [-1,1,3,4,6,7,8]




// 9. Even number
console.log("\n\nProblem 9");
function isEven(someNum) {
  return 2 * Math.floor(someNum / 2) === someNum;
}

console.log(isEven(77)); // false
console.log(isEven(88)); // true
console.log(isEven(1337)); // false
console.log(isEven(1010)); // true






// 10. Palindrome
console.log("\n\nProblem 10");
function isPalindrome(someStr) {
  for(let i = 0; i < Math.floor(someStr.length) / 2; i++) {
    if(someStr[i] !== someStr[someStr.length - 1 - i])
      return false;
  }
  return true;
}
console.log(isPalindrome("radar")); // true
console.log(isPalindrome("racecar")); // true
console.log(isPalindrome("abba")); // true
console.log(isPalindrome("hello, world!")); // false





// 11. Shapes
console.log("\n\nProblem 11");
function printShape(shape, height, character) {
  switch(shape){
    case "Square":
      for(let i = 0; i < height; i++) {
        let row = "";
        for(let j = 0; j < height; j++) {
          row += character;
        }
        console.log(row);
      }
      break;
    case "Triangle":
      for(let i = 1; i <= height; i++) {
        let row = "";
        for(let j = 1; j <= i; j++)  {
          row += character;
        }
        console.log(row);
      }
      break;
    case "Diamond":
      let midpoint = Math.floor(height / 2) + 1;
      let numSpaces = midpoint - 1;
      let numChars = 1;
      for(let i = 0; i < midpoint; i++) {
        let row = "";
        for(let j = 0; j < numSpaces; j++) {
          row += " ";
        }
        for(let k = 0; k < numChars; k++) {
          row += character;
        }
        numChars += 2;
        numSpaces--;
        console.log(row);
      }
      midpoint--;
      numSpaces = 0;
      numChars -= 4;
      for(let i = 0; i < midpoint; i++) {
        let row = " ";
        for(let j = 0; j < numSpaces; j++) {
          row += " ";
        }
        for(let k = 0; k < numChars; k++) {
          row += character;
        }
        numChars -= 2;
        numSpaces++;
        console.log(row);
      }
      break;
    default:
      console.log("Invalid shape");
  }
}

printShape("Square", 3, "%");
// %%%
// %%%
// %%%
console.log();
printShape("Triangle", 3, "$");
// $
// $$
// $$$
console.log();
printShape("Diamond", 5, "*");
//   *
//  ***
// *****
//  ***
//   *




// 12. Rotate Left
console.log("\n\nProblem 12");
function rotate(arr, n) {
  function rotateOnce(tempArr) {
    let temp = tempArr[0];
    for(let i = 1; i < tempArr.length; i++) {
      [[tempArr[i - 1], tempArr[i]]] = [[tempArr[i], tempArr[i - 1]]];
    }
    return tempArr;
  }

  let num = 0;
  while(num < n) {
    arr = rotateOnce(arr);
    num++;
  }
  return arr;
}


console.log(rotate([1,2,3,4,5], 1)); // [2,3,4,5,1]
console.log(rotate([1,2,3,4,5], 6)); // [2,3,4,5,1]
console.log(rotate([1,2,3,4,5], 3)); // [4,5,1,2,3]


// 13. Balanced Brackets
console.log("\n\nProblem 13");
function balanced(str) {
  const stack = [];
  for(let char of str){
    if(char === "(" || char === "{" || char === "[") {
      stack.push(char);
    } else {
      if(char === ")" && stack.pop() !== "("){
        return false;
      }
      if(char === "}" && stack.pop() !== "{"){
        return false;
      }
      if(char === "]" && stack.pop() !== "["){
        return false;
      }
    }
  }
  return stack.length === 0;
}

console.log(balanced("()")); // true
console.log(balanced("()()")); // true
console.log(balanced("(())")); // true
console.log(balanced("({[]})")); // true
console.log(balanced("(")); // false
console.log(balanced(")")); // false
console.log(balanced("(()i")); // false
console.log(balanced("([)]")); // false