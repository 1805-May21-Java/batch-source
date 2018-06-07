let str = "dude@dude.dude";
let noice = "Not an email";
let email = "truly@isan.email";

function isValidEmail(arg){
    let s = arg;
    let c = 0;
    for(let i=s.length; i>0; i--){
        if(s.charAt(i)==='.'){
            c++;
        }
        if((s.charAt(i)==='@')&&(c>0)){
            return true;
        }
    }
    return false;
}

console.log(isValidEmail(str));
console.log(isValidEmail(noice));
console.log(isValidEmail(email));