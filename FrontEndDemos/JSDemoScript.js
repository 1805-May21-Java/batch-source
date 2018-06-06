// console.log("hello world");

/*
console.log("5: "+isNaN(5));
console.log("hello: "+isNaN("hello"));
console.log("false: "+ isNaN(false));
console.log("true: "+isNaN(true));
console.log("null: "+isNaN(null));
console.log("undefined: "+isNaN(undefined));
console.log("date: "+ isNaN(new Date()));
console.log("empty string: "+isNaN(""));
console.log("NaN: "+isNaN(NaN));
*/

// three ways to declare functions
function add1(one = 4, two = 6){
    console.log(one + " + " + two);
    return one+two;
}

add2 = function(one, two){
    return one+two;
}

//using arrow notation (ES6)
add3 = (one, two) => {
    return one+two;
}

function add4(){
    let sum = 0;
    for(i=0; i<arguments.length; i++){
        sum+=arguments[i];
    }
    return sum;
}

function add5(one, two){
    console.log(`one = ${one} and two = ${two}`);
}

/*
let person = {name:'Veronica', age:'25'};
for(x in person){
    console.log(x + ' is: ' + person[x]);
}

let arr = ['green', 'yellow', true, 25];
for(x in arr){
    console.log(x + ' is: ' + arr[x]);
}

for(x of arr){
    console.log(x);
}
*/

//semi colon injection
function a1() {
    return {
        name: 'JavaScript'
    };
};

function a2() {
    return 
    {
        name: 'JavaScript'
    };
};

// const 
const person1 = {name:"John", age: 42};
const person2 = {name:"Sam", age:50};
// console.log(person1);
// console.log(person2);
person1.name = "Sam"
person1.age = 50;
// console.log(person1);
// console.log(person2);

// var vs. let
// var score = 70;
// var pass = false;
// if(score>60){
//     var pass = true;
// }
// console.log(pass);

// var score = 70;
// let pass = false;
// if(score>60){
//     let pass = true;
//     console.log("inside of block scope: "+pass);
// }
// console.log("outside of block scope: "+pass);


// hoisting
function hoistTest1(){
    var x;
    x = 6;
    console.log(x);
}

function hoistTest2(){
    var x;
    console.log(x);
    x = 6;
}

function hoistTest3(){
    console.log(x);
    var x;
    x = 6;
}

function hoistTest4(){
    x = 6;
    console.log(x);
    var x;
}

function hoistTest5(){
    console.log(x);
    x = 6;
}

// if we replaced these declations with 
// the let keyword, hoisting would not occur
// this function hoisted with var but not let
function letTest(){
    console.log(x);
    let x;
    x = 6;
}


/**
 * We want to create a counter that can be incremented
 * from anywhere but whose value cannot be changed from anywhere
 */

//  let counter = 0;

//  function add(){
//      counter +=1;
//      console.log(counter);
//  }

// function add(){
//     let counter = 0;
//     counter += 1;
//     console.log(counter);
// }

// function add(){
//     let counter = 0;
//     function plus(){
//         counter += 1;
//     }
//     plus();
//     console.log(counter);
//     return counter;
// }

let add = (function(){
    let counter = 0;
    return function(){ 
        return counter+=1;
    }
})();

console.log(add())
console.log(add())
console.log(add())