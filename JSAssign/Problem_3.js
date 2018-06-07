let Str = "Here come Dat Boi.";

function o(arg1){
    let s = arg1;
    let c=0;
    for(let i=arg1.length; i>0; i--){
        if(s.charAt(i)===('a'))c++;
        if(s.charAt(i)===('e'))c++;
        if(s.charAt(i)===('i'))c++;
        if(s.charAt(i)===('o'))c++;
        if(s.charAt(i)===('u'))c++;
    }
    return c;
}

console.log("The string has "+o(Str)+" vowels.");