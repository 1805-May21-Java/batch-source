// // //console.log('Hello World')
// //
// // console.log("5: "+isNaN(5));
// //
// // console.log("Hello: "+isNaN("Hello"));
// //
// // console.log("false:" +isNaN(false));
// //
// // console.log("true:" +isNaN(true));
//
// function add(one=4,two=6) {
//   // console.log(one " + " two);
//   return one+two;
// }
//
// add2 = function (one,two) {
//   return one+two;
// }
//
// add3 = (one,two) =>{
//   return one+two;
// }
//
// function add4() {
//   let sum = 0;
//   for(i=0; i<arguments.length;i++){
//     sum+=arguments[i];
//   }
//   return sum;
// }
//
//
// let person = {name:'Veronica', age:'25'}
// for(x in person){
//   console.log(x+ ' is ' + person[x]);
// }
//
// let arr = ['green','yellow',true,25]
// for(x in arr){
//   console.log(x + ' is: ' + arr[x]);
// }
// //Will print out the values at arr[x]
// for(x of arr){
//   console.log(x)
// }
//
// function a() {
//   return{
//     name: 'JavaScript'
//   }
// }
// //Will return undefined
// function a2() {
//   return//JS puts an invisible semicolon here that makes it undefined
//   {
//     name: 'Javascript'
//   }
// }
// //Makes x console.log print undefined since it hoist the declaration but not the assignment
//  function a3() {
//    console.log(x);
//    var x=7;
//    console.log(x);
//  }
//
//
// //const
// const person1 = {name:"John", age:42};
// const person2 = {name:"Sam", age:50};
// console.log(person1);
// console.log(person2);
//
// //Cannot person1 = person2 because of the const assignment
//
// //will print false
// var score1 = 71;
// let pass = false;
// if(score1 > 60){
//    let pass = true;
// }
// console.log(pass);
//
// //will print true
// var score = 61;
// var pass1 = true;
// if(score > 60){
//   pass1 = false;
// }
// console.log(pass1);
//
//
// //We want to create a counter that is avaliable globally that can be incremented
// //from anywhere but not changed from anywhere
//
// let counter = 0;
//
// function addi(){
//   counter +=1;
//   console.log(counter);
// }
// function add(){
//   let counter = 0;
//   counter += 1;
//   console.log(counter);
// }
let add = (function(){
  let counter = 0;
  return function () {
    return counter+=1;
  }
})();

console.log(add());
console.log(add());
console.log(add());

function add4(){
  let sum = 0;
  for(i=0;i<arguments.length;i++){
    sum+=arguments[i];
  }
  return sum;
}
function add5(one,two) {
  console.log(`one = ${one} and two = ${two}` );
}
