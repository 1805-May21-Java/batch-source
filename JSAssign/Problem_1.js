let Str = ["Howdy, Neighbor","Nowdy, yM Heighbor","Neighborino Howderino"];

function maxLength(){
    let x;
    for(let i = 0; i < arguments.length; i++){
        if((i>0)&&(arguments[i].length>arguments[i-1].length)){
            x=arguments[i];
        }else x=arguments[i];
    }
    return x;
}
console.log(maxLength(Str));
