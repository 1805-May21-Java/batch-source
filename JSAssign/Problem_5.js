let year = 2018;

function isLeapYear(arg){
    let y = arg;
    if((y%4)===0){
        return true;
    }else
        return false;
}

console.log(isLeapYear(year));