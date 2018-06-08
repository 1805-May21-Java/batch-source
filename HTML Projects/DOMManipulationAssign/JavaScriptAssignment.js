
// 1. add links
document.getElementsByName("google")[0].setAttribute("href", "https://www.google.com");
document.getElementsByName("twitter")[0].setAttribute("href", "https://twitter.com");
document.getElementsByName("slack")[0].setAttribute("href", "https://slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href", "https://javadocs.com");


// 2. disable Pluto as a planet option
document.getElementById("planet")[3].disabled = true;


// 3. shows alien message if planet other than Earth is picked
document.getElementById("planet").addEventListener("change", alienText);

function alienText(params) {
    var hiddenElem = document.querySelectorAll("p[hidden]");
    if (hiddenElem[0]) { // check if hidden attribute still exists
        hiddenElem[0].removeAttribute("hidden");
    } 
    //else {
    //     // option is 'Earth' by default, so returning to it should
    //     // always require a chnage back to hidden
    //     if (document.getElementById()) {
            
    //     }
    //     console.log(document.getElementById("planet").options);
    // }

}


// 4. get input values from form and add to table
document.getElementById("form-sub").addEventListener("click", add);

function add() {
    
}

// 6. concatenate inner HTML
var spans = document.getElementsByTagName("span");
var str = "";
for (let i=0; i<spans.length; i++) {
    str += spans[i].innerHTML;
}
console.log(str);
