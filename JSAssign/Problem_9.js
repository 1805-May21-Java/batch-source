let num = 2005;
let num2 = 202;

function isEven(arg){
    let n = arg;
    let t = n;
    while(t>1){
        t-=2;
    }
    if(t===1){
        return false;
    }else return true;
}

console.log(isEven(num));
console.log(isEven(num2));