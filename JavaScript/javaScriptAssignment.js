var x = ["one", "two", "three"]

function maxLength(arr){
    let holdString="";
    let holdIndex;
    for(i in arr){
        if(arr[i].length>holdString.length){
            holdString=arr[i];
            holdIndex=i;
        }
    }
    return holdIndex;
}

function reverseArray(arr){
    let reverse=[];
    let count=0;
    for(i=arr.length-1;i>=0;i--){
        reverse[count]=arr[i];
        count++;
    }
    return reverse;
}

function vowlCount(string){
    const vowls=['a','e','i','o','u'];
    let count=0;
    for(l of string){
        for(v of vowls){
            if(l==v){
                count++;
                break;
            }
        }
    }
    return count;
}

function removeScript(str){
    const index=str.indexOf("Script");
    if(index==-1){
        return str;
    }
    else if(index==0){
        return str.substring(6)
    }
    else{
        return str.substring(0,index)+str.substring(index+6);
    }
}

function isLeap(date){
    if(date.getFullYear()%4!=0){
        return false;
    }
    else if(date.getFullYear()%100!=0){
        return false;
    }
    else if(date.getFullYear()%400!=0){
        return false;
    }
    else{
        return true;
    }
}

function isValidEmail(email){
    if(email[0]=="@"||email[0]=="."||!email.includes("@")||!email.includes(".")||/\s/g.test(email)){
        return false;
    }
    else if(email.indexOf(".")==email.length-1){
        return false;
    }
    else if(email.substring(email.indexOf("@"), email.indexOf("."))==false){
        return false;
    }
    else{
        return true;
    }
}

function removeChar(str,index){
    if(str.length==1){
        return "";
    }
    else{
        return str.substring(0,index)+str.substring(index+1);
    }
}

function bubbleSort(array){
    var allGood=true;
    var hold;
    for(n=0; n<array.length;n++){
        if(n<array.length-1 && array[n+1]<array[n]){
            hold=array[n];
            array[n]=array[n+1];
            array[n+1]=hold;

            allGood=false;
        }
    }
    if(!allGood){
        console.log("Here")
        bubbleSort(array);
    }
    return array;
    
}

function isEven(num){
    num+="";
    var even=false;
    var evens=[0,2,4,6,8];
    for(e of evens){
        if(num.charAt(num.length-1)==e){
            even=true;
            break;
        }
    }
    return even;
}

function isPalindrone(str){
    const half=Math.floor(str.length/2);
    var itIs=true;
    for(var i=0;i<half;i++){
        if(str.charAt(i)!=str.charAt(str.length-(1+i))){
            itIs=false;
            break;
        }
    }
    return itIs;
}

function shape(shape, height, character){
    switch(shape){
        case "square":
            for(var i=1;i<height;i++){
                character+=character;
            }
            for(var i=0;i<height;i++){
                console.log(character);
            }
        break;
        case "triangle":
            for(var i=0;i<height;i++){
                console.log(character);
                character+=character.charAt(0);
            }
        break;
        case "diamond":
            var half=height/2-0.5
            var spaces=Array(half+1).join(" ,").split(",");
            spaces.pop();
            console.log(spaces.join("")+character+spaces.join(""))
            for(var i=0;i<half;i++){
                spaces.push(character);
                spaces.shift();
                console.log(spaces.join("")+character+spaces.reverse().join(""));
                spaces.reverse();
            }
            for(var i=0;i<half;i++){
                spaces.push(" ");
                spaces.shift();
                console.log(spaces.reverse().join("")+character+spaces.reverse().join(""))    
            }
            //  ****0****
    }
}

function rotate(array, n){
    while(n>0){
        array.push(array.shift());
        n--;
    }
    return array;
}

function balanced(str){
    var forward=str.split("");
    var backward=str.split("").reverse();
    var isBalanced=true;

    console.log(forward)
    console.log(backward)

    for(var i=0;i<str.length/2;i++){
        switch(forward[i]){
            case "(":
                if(backward[i]!=")"){
                    isBalanced=false;
                }
                break;
            case "[":
                if(backward[i]!="]"){
                    isBalanced=false
                }
                break;
            case "{":
                if(backward[i]!="}"){
                    isBalanced=false;
                }
                break;
            case ")":
                isBalanced=false;
                break;
            case "]":
                isBalanced=false;
                break;
            case "}":
                isBalanced=false;
            break;
        }
        if(!isBalanced){
            break;
        }
    }
    return isBalanced;
}