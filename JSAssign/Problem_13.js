let b = "([{}])";
let c = "(4(5}2}";

function balanced(arg){
    let x = 0;
    let a=0,b=0,c=0;
    while (x<arg.length){
        if(arg.charAt(x)==="("){
            a++;
        }else if(arg.charAt(x)==="["){
            b++
        }else if(arg.charAt(x)==="{"){
            c++;
        }else if(arg.charAt(x)===")"){
            a--;
        }else if(arg.charAt(x)==="]"){
            b--;
        }else if(arg.charAt(x)==="}"){
            c--;
        }
        x++;
    }
    return (Math.abs(a)+Math.abs(b)+Math.abs(c)) === 0;
}

console.log(balanced(b));
console.log(balanced(c));