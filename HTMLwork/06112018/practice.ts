// function doSometing(){
//     for(let i=0;i<5;i++){
//         console.log(i);
//     }
// }

// console.log("finally: " + i);
//
// let counter = 5;
// counter = "a";

// let x;
//
// x = 9;
// x= false;
// x= "west";

let myNum: number;

myNum = 9;
let message;
message = "abc";
let message2 = <string>message;
let message3 = message as string;

let num: number;
let boo: boolean;
let str: string;
let obj: object;

function myVoidFunction() {
    console.log("This function is uselesssssssssssssssssssssssssssssssssssssssssssssssssss")
}

function rickRoll() {
    console.log("Never gonna give you up");
    console.log("Never gonna let you down");
    console.log("Never gonna run around and desert you");
}

function NeverTrue(value:any){
    if(typeof value === "string" && typeof value === "number"){
        value
    }
}
let u: number[] = [1,4,5,"seven"];
let v: string[] = ["hello","goodbye", true];