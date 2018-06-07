let Str = "Howdy, neighbour.";

function funct (arg1){
    let s = arg1;
    let x="";
    for(let i=arg1.length; i>0; i--){
        x+=s.charAt(i);
    }
    return x;
}

console.log(funct(Str));