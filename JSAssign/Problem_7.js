let str = "Hey now, brown cow.";

function removeChar(arg1,arg2){
    let s;
    s = arg1.slice(0,arg2)+arg1.slice(arg2+1,arg1.length);
    return s;
}

console.log(removeChar(str,5));