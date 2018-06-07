let x = [1, 3, 33, 55, 9, 9, 2, 5, 5 ,80];

function bubbleSort(arg){
    let l = arg.length;
    let t = 0;
    let n = arg;


    for(let i = 0; i < l; i++){
        for(let j = 1; j < (l -i); j++){
            if(n[j-1] > n[j]){
                t = n[j-1];
                n[j-1] = n[j];
                n[j] = t;

            }
        }
    }
    return n;
}

console.log(bubbleSort(x));