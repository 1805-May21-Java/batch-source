let x = [1,2,3,4,5];

function rotate(arg,arg2){
    let t;
    let x = arg;
    console.log("Input array: "+arg);

    for(let i=arg2; i>0; i--){
        t=x[0];
        x[0]=x[4];
        x[4]=x[3];
        x[3]=x[2];
        x[2]=x[1];
        x[1]=t;
    }
    return x;
}

console.log(rotate(x,1));
console.log(rotate(x,1));
console.log(rotate(x,1));
console.log(rotate(x,1));