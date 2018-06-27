function doSomething(){
    for(let i=0; i<5; i++){
        console.log(i);
    }
}

console.log("finally: " + i);
//get a compilation error because i was declared in block scope

let counter = 5;
counter = "a";

let x;
x = 9;
x = false;
x = "Hello";

let myNum: number;
myNum = 9;
myNum = false;
myNum = "Hello";

let message;
message = "abc";
let message2 = <string>message;
let message3 = message as string;

let num: number;
let boo: boolean;
let str: string;
let obj: object;

function myVoidFunction(){
    console.log("This function doesn't return anything")
}

const rickRoll = function(){
    while(true){
        console.log("never gonna give you up");
        console.log("never gonna let you down");
        console.log("never gonna run around and desert you");
        console.log("never gonna make you cry");
        console.log("never gonna say goodbye");
        console.log("never gonna tell a lie and hurt you");
    }
}

function neverTrue(value:any){
    if(typeof value === "string" && typeof value === "number"){
        value;
    }
}

let u: number[] = [1,4,5,"seven"];
let v: string[] = ["hello", "world", true];
let w: any[] = [false, "blue", 6];

let drawPoint1 = (x,y) => {
    //implementation goes here
}

let drawPoint2 = (point) => {
    //implementation goes here
}

drawPoint2({
    x: 3,
    y: 4
})

drawPoint2({
    name: "joe",
    age: 45,
    email: "joe@gmail.com"
})

let drawPoint3 = (point: {x: number, y: number}) =>{
    //implementation details
}

interface Point {
    x: number,
    y: number
}

let drawPoint4 = (point: Point) =>{
    // implementation
}

drawPoint4({
    x: 3,
    y: 4
})

drawPoint4({
    name: "joe",
    age: 45,
    email: "joe@gmail.com"
})

class AlsoPoint {

    x: number;
    y: number;

    constructor(private _x?:number, private _y?:number){
        this.x = _x;
        this.y = _y;
    }

    drawPoint = () => {
        console.log('x '+ this.x+", y "+this.y);
    }

    getX = () =>{
        return this.x;
    }

}

let myPoint: AlsoPoint = new AlsoPoint();
myPoint.drawPoint();