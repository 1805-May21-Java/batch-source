/*
Christian Budhi
*/


// Question 1
function maxLength(arr) {
    let maxLength=0;
    let index = 0;
    for(i = 0; i < arr.length; i++) {
        if(arr[i].length > maxLength) {
            maxLength = arr[i].length;
            index = i;
        }
    }
    return index;
}




// Question 2
function reverseArray(arr) {
    let newArr =[];
    for (i = 0; i < arr.length ; i++) {
        newArr.push(arr[arr.length-1-i]);
    }
    return newArr;
}

// Question 4
function vowelCount(str) {
    let numVowels = 0;
    for (i = 0; i < str.length; i++) {
        var q = str.charAt(i)
        q = q.toUpperCase();
        if(q === 'A' || q === 'E' || q === 'I' || q ==='O' || q ==='U') {
            numVowels++;
        }
    }
    return numVowels;
}

// Question 4
function removeScript(str) {
    let arr = str.split("Script");
    let newString = "";
    for (i = 0; i < arr.length; i++) {
        newString += arr[i];
    }
    return newString;
}

// Question 5
function isLeapYear(d) {
    let year = d.getFullYear();
    if((year%4 === 0 && !year%100) || year%400) {
        return true; 
    }
    return false;
}

// Question 6
function isValidEmail(str) {
    let a = str.lastIndexOf("@");
    let d = str.lastIndexOf(".");

    if ((a > -1 && d > -1) && (a<d) && (d-a > 1) && (str.length-d > 1)){
        return true;
    }
    return false;
}

// Question 7
function removeCharacter(str, index) {
    if(index < 0 || index >= str.length) {
        return str;
    }

    if(index === str.length-1) {
        return str.substr(0, str.length-1);
    }

    return str.substr(0, index)+ str.substr(index+1);
}

// Question 8
function bubbleSort(arr) {
    let change = false;
    do {
        change = false;
        for(i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                let temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                change = true;
            }
        }
    } while(change);
    return arr;
}

// Question 9
function isEven(num) {
    return num/2 === Math.round(num/2);
}

// Question 10
function isPalindrome(str) {
    for (i = 0; i < str.length/2; i++) {
        if(str[i] !== str[str.length-1-i]){
            return false;
        } 
    }
    return true;
}

// Question 11
function printShape(shape, height, ch) {
    let row = "";
    switch(shape) {
    case "Square":
        for(i = 0; i < height; i++) {
            row+= ch;
        }

        for(i= 0; i < height; i++) {
            console.log(row);
        }
        break;
    case "Triangle":
        for(i = 0; i < height; i++) {
            for(j = 0; j < i+1; j++) {
                row+=ch;
            }
            console.log(row);
            row="";
        }
        break;
    case "Diamond":
        for(i = 0; i < Math.round(height/2); i++) {
            for(j = 0; j < Math.round(height/2)-1-i; j++) {
                row+= " ";
            }
            for (k = 0; k < i*2+1; k++) {
                row += ch;
            }
            console.log(row);
            row = "";
        }

        for (i = Math.round(height/2) - 2; i >= 0; i --) {
            for(j = 0; j < Math.round(height/2)-1-i; j++) {
                row+= " ";
            }
            for (k = 0; k < i*2+1; k++) {
                row += ch;
            }
            console.log(row);
            row = "";
        }
        
        break;
    default:
        console.log("Wat")
    }
}


function rotate(arr, n) {
    for (i = 0; i < n; i++) {
        let temp = arr.shift();
        arr.push(temp);
    }
    return arr;
}


function balanced(str) {
    myStack = [];
    let top;
    for(i = 0; i < str.length; i++) {
        if (str.charAt(i) === "(" || str.charAt(i) === "[" || str.charAt(i) === "{") {
            myStack.push(str.charAt(i));
        }

        if(str.charAt(i) === ")" ) {
            top = myStack.pop()
            if(top !== "(") {
                return false;
            } 
        }

        if(str.charAt(i) === "]") {
            top = myStack.pop()
            if(top !== "[") {
                return false;
            }
        }

        if(str.charAt(i) === "}") {
            top = myStack.pop()
            if(top !== "{") {
                return false;
            }

        }
    }
    return true;
}


