function maxLength(array){
    var max = -1;
    var index;
    for(x in array){
        if(array[x].length > max){
            index = x;
        }
    }
    return x;
}

function reverseArray(array){
    for(x = 0; x < array.length/2; x++){
        temp = array[array.length - 1 - x]; //xth from last element
        array[array.length - 1 - x] = array[x];
        array[x] = temp;
    }
}

function countVowels(txt){
    let count = 0;
    for(x of txt){
        if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u'){
            count++;
        }
    }
    return count;
}

function removeScript(txt){
    var x = txt.indexOf('Script');
    if(x == -1){
        return txt;
    }
    else if(x == 0){
        return txt.substring(7);
    }
    else {
        return (txt.substring(0,x) + txt.substring(x + 7));
    }
}

function isLeapYer(date) {
    var year = date.getFullYear();
    return (year % 4) == 0;
}

function isValidEmail(email) {
    atIndex = email.indexOf('@');
    if(atIndex == -1) {
        return false;
    }
    var sub = email.substring(atIndex);
    dotIndex = sub.indexOf('.');
    return dotIndex != -1;
}

function removeChar(txt, index){
    return txt.substring(0, index) + txt.substring(index+1);
}

function bubbleSort(numArray){
    var ret = numArray;
    for(x = 0; x < ret.length; x++) {
        for(y = 0; y < (ret.length - 1); y++) {
            if(ret[y] > ret[Number(y) + 1]){
                temp = ret[y];
                ret[y] = ret[(y + 1)];
                ret[(y + 1)] = temp;
            }
        }
    }
    return ret;
}

function isEven(num) {
    var str = String(num);
    var lastDigit =  str[str.length - 1];
    return (lastDigit == 0) || (lastDigit == 2) || (lastDigit == 4) || (lastDigit == 6) || (lastDigit == 8);
}

function isPalindrome(txt) {
    for(x = 0; x < txt.length/2; x++) {
        if(txt[x] != txt[txt.length - 1 - x]){
            return false;
        }
    }
    return true;
}

function printShape(shape, height, character) {
    var row = "";
    for(x = 0; x < height; x++){
        for(y = 0; y < height; y++){
            if(shape == 'Square'){
                row += character;
            }
            else if(shape == 'Triangle'){
                if((y <= x)){
                    row += character;
                }
                else{
                    row += " ";
                }
            }
            else {
                if(x < height/2){
                    if((y > (height/2 - x - 1)) && (y <= (height/2 + x))){
                        row += character;
                    }
                    else {
                        row += " ";
                    }
                }
                else if(x == height)
                {
                    row += character;
                }
                else {
                    if((y > (x - height/2)) && (y <= (height * 1.5 - x - 1))){
                        row += character;
                    }
                    else{
                        row += " ";
                    }
                }
            }
        }
        row += "\n";
    }    
    console.log(row);
}

function rotate(array, n){
    ret = array;
    for(i = 0; i < n; i++){
        temp = ret[0];
        for(x = 1; x < ret.length; x++){
            ret[Number(x) - 1] = ret[x];
        }
        ret[ret.length - 1] = temp;
    }
    return ret;
}


function balanced(txt){
    var types = []; //contains a list of the brackets yet to be closed, 'p' for parenthesis, 'b' for bracket
    for(x = 0; x < txt.length; x++){
        if(txt[x] == '(') {
            types.push('(');
        }
        else if(txt[x] =='['){
            types.push('[');
        }
        else if(txt[x] == '{') {
            types.push('{');
        }

        else if(txt[x] == ')'){
            //If there are no open delimiters or if the last open was a bracket and not a parenthesis, return false
            if((types.length == 0) || (types[Number(types.length) - 1] != '(')) {
                return false;
            }
            //Otherwise, remove the parenthesis you're closing from types
            types.pop();
        }

        else if(txt[x] == ']'){
            //If there are no open delimiters or if the last open was a bracket and not a parenthesis, return false
            if((types.length == 0) || (types[Number(types.length) - 1] != '[')) {
                return false;
            }
            //Otherwise, remove the parenthesis you're closing from types
            types.pop();
        }        
 
        else if(txt[x] == '}'){
            //If there are no open delimiters or if the last open was a bracket and not a parenthesis, return false
            if((types.length == 0) || (types[Number(types.length) - 1] != '{')) {
                return false;
            }
            //Otherwise, remove the parenthesis you're closing from types
            types.pop();
        }        
    }
    return (types.length == 0);
}