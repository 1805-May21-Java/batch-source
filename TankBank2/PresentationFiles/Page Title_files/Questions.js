//1
function hi(){
    console.log("Hi");
}
function maxLength(array){
    let maxLength = 0;
    let index = 0;
    for(i = 0;i<array.length;i++){
        if(maxLength < array[i].length){
            maxLength = array[i].length;
            index = i;
        }
    }
    return index; 
}