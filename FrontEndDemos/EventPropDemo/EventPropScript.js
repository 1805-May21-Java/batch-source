let capturing = true;
let bubbling = false;

//all bubbling event propagation
document.getElementById("inner").addEventListener("click", function(){
    alert("INNER - bubbling");
}, bubbling);

document.getElementById("middle").addEventListener("click",function(){
    alert("MIDDLE - bubbling");
}, bubbling);

document.getElementById("outer").addEventListener("click",function(){
    alert("OUTER - bubbling");
}, bubbling);

//all of our event propagation is capturing
document.getElementById("inner").addEventListener("click", function(){
    alert("INNER - capturing");
}, capturing);

document.getElementById("middle").addEventListener("click",function(e){
    alert("MIDDLE - capturing");
    //e.stopPropagation();
    e.stopImmediatePropagation();
}, capturing);
document.getElementById("middle").addEventListener("click",function(e){
    alert("MIDDLE - capturing the second time");
}, capturing);

document.getElementById("outer").addEventListener("click",function(){
    alert("OUTER - capturing");
}, capturing);