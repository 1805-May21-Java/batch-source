function doSomething() {
    for (let i = 0; i < 5; i++) {
        console.log(i);
    }
}

console.log("finally" + i);
// Get a compilation error because i was declared in a different scope

let counter = 5;
counter = "a";
// Get a compilation error because counter was initialized as a number and cannot be re-assigned as a string

let x;
x = 9;
x = false;
x = "Hello"
// We do not get compilation errors because "let x" with no initialization sets the type to "any" and that persists

let myNum: number;
myNum = 9;
myNum = false;
//' Get a compilation error because we explicitly set its type to "number"

let message;
message = "abc";
let message2 = <string>message;
let message3 = message as string;
// These new variables carry the value, but have been cast to a specific type as opposed to being "any"
let numb = <number>message;

let num: number;
let boo: boolean;
let str: string;
let obj: object;

function myVoidFunction() {
    console.log("This function doesn't return anything");
}

const rickRoll = function() {
    while(true) {
        console.log("you know");
    }
}

function neverTrue(value:any) {
    if (typeof value == "string" && typeof value === "number") {
        value;
    }
}

let u: number[] = [1,2,3, "seven"];
let v: string[] = ["hello", "world"];
v[1] = 4;
let w: any[] = [false, "blue", 3];

 
// How do we specify which data-types we want as arguments?
let drawPoint1 = (x, y) => {
    // implementation goes here
}

let drawPoint3 = (point: {x: number, y: number}) => {

}

interface Point {
    x: number,
    y: number
}

let drawPoint4 = (point: Point) => {
    // Implmentation
}

class AlsoPoint {

    private x:number = 0;
    private y:number = 0;

    // Only one constructor allowed for a class, but we can work around this by making some function parameters optional with "?"
    constructor(private _x?:number, private _y?:number) {
        this.x = _x;
        this.y = _y;
    }

    drawPoint = () => {
        console.log('x ' + this.x + ', y ' + this.y);
    }

    getX = () => {
        return this.x
    }

    getY() {
        return this.y;
    }
}

let myPoint:AlsoPoint = new AlsoPoint();
myPoint.drawPoint;