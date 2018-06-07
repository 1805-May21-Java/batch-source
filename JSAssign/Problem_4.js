let Str =  "I am a string.";

function removeScript(arg){
    let s = arg;
    let x = s.replace(/String/gi,"");
    return x;
}

console.log(removeScript(Str));