let pal = "racecar";
let npal = "JavaScript";

function isPalendrome(arg1, arg2){
    arg2 = arg1.length;
    for (let i=0; i<(arg2/2); ++i){
        if (arg1.charAt(i) !== arg1.charAt(arg2-i-1)){
            return false;
        }
    }
    return true;
}

console.log(isPalendrome(npal));
console.log(isPalendrome(pal));