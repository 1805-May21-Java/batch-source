//1
function maxLength(array){
    let maxLength = 0;
    let index = 0;
    for(i = 0;i<array.length;i++){
        if(maxLength < array[i].length){
            maxLength = array[i].length;
            index = i;
        }
    }
    return index; 
}
//2
function reverseArray(array){
    let newArray = [];
    for(i = array.length-1;i >= 0;i--){
        newArray.push(array[i]);
    }
    return newArray;
}
//3
function countVowels(string){
    vowels = ["a","e","i","o","u","y"];
    counter = 0;
    for(i of string){
        if(vowels.indexOf(i)>-1){
            counter++;
        }
    }
    return counter;
}
//4
function removeScript(string){
    let newString;
    index = string.indexOf("Script");
    if(index>-1){
        newString = string.substring(0,index);
        newString += (string.substring(index+6));
    }else{
        newString = string;
        console.log(newString);
        return newString;
    }
    removeScript(newString);
}
//5
function isLeapYear(date){
    //every 4, not every 100 unless it's also a 400
    year = date.getFullYear();
    if(date%4 === 0){
        if(date%100 === 0){
            if(date%400 === 0){
                return true;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }else{
        return false;
    }
}
//6
function isValidEmail(string){
    //regex
    var re = /\w+@\w+\.\w+/;
    console.log(re.test(string));
}
//7
function removeChar(string,index){
    return string.substring(0,index)+string.substring(Math.min(index+1,string.length));
}
//8
function bubbleSort(numArray){
    for(index = 1;index<numArray.length;index++){
        for(j = index;j>0;j--){
            if(numArray[j-1]>numArray[j]){
                //switch indecies
                a = numArray[index-1];
                numArray[index-1] = numArray[index];
                numArray[index] = a;
            }else{
            j=0;
            }
        }
    }
    return numArray
}
//9
function isEven(someNum){
    return (someNum/2 == Math.round(someNum/2));
}
//10
function isPalidrome(someStr){
    arr = someStr.split('');
    return arr.join() == reverseArray(arr).join();
}
//11
function printShape(shape,height,character){
    switch(shape){
        case "square":
        for(i=0;i<height;i++){
            arr = ""
            for(j=0;j<height;j++){
                arr.push(character);
            }
            console.log(arr);
        }
        break;
        case "triangle":
        for(i=0;i<height;i++){
            arr=""
            for(j=0;j<=i;j++){
                arr+=(character);
            }
            console.log(arr);
        }
        case "diamond":
            for(i=0;i<height/2;i++){
                //rows
                arr="";
                for(k=i;k<=height;k++){
                    //spaces added to make it look like a diamond
                    arr+=" ";
                }
                for(j=0;j<=i;j+=0.5){
                    arr += character;
                }
                console.log(arr);
            }   
            for(i=height/2;i>0;i--){
                arr=""
                for(k=i;k<height+1;k++){
                    arr+=" ";
                }
                for(j=0;j<i;j+=0.5){
                    arr += character;
                }
                console.log(arr);
            }
    }
  
}
//12
function rotate(array,n){
    for(i=0;i<n;i++){
        array = rotateOnce(array);
    }

    function rotateOnce(array){
        let a = array[0];
        newArray = array.slice(1,array.length);
        newArray.push(a);
        return newArray
    }
    return array;
}
//13
function balance(string){
    //total must add to 0 when you add all the values
    let dict = {"(":1 ,")":-1,"[":100,"]":-100,"{":10000,"}":-10000 };
    let stack = string.split('');
    total = 0;
    //starts positive because you'd have to open something before you close it, and checks for sign switches
    previousValue = 5;
    for(char of string){
        value = dict[char];
        if( ( value > 0 && previousValue < 0) || (value < 0 && previousValue > 0)){
            //switched value
            if((value + previousValue) != 0){
                //pairs don't match, not balanced
                return false;
            }
        }
        previousValue = value
        total += value;    
    } 
    if(total === 0){
        return true;
    }else return false;
}