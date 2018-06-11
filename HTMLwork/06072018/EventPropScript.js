//All bubbling event propogation
let capturing = true;
let bubbling = false;
document.getElementById("inner").addEventListener("click",function () {
    alert("INNER:bubbling");
},bubbling);

document.getElementById("middle").addEventListener("click",function () {
   alert("MIDDLE:bubbling")
},bubbling);

document.getElementById("outter").addEventListener("click",function () {
    alert("OUTTER:bubbling")
},bubbling);

document.getElementById("inner").addEventListener("click",function () {
    alert("INNER:capturing");
},capturing);

document.getElementById("middle").addEventListener("click",function (e) {
    alert("MIDDLE:capturing");
    e.stopImmediatePropagation();
},capturing);

document.getElementById("outter").addEventListener("click",function (e) {
    alert("OUTTER:capturing");
    e.stopImmediatePropagation();
},capturing);