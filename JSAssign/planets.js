//Question 1

document.getElementsByName("google")[0].setAttribute("href","http://google.com");
document.getElementsByName("twitter")[0].setAttribute("href","http://twitter.com");
document.getElementsByName("slack")[0].setAttribute("href","http://slack.com");
document.getElementsByName("javadocs")[0].setAttribute("href","http://javadocs.com");


//Question 2
let p = document.getElementById("planet");
p.removeChild(p.options[3]);

//Question 3

//Question 4
document.getElementById("form-sub").addEventListener("click", function(){
    let EmEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    let fname = document.getElementById("firstname").value;
    let lname = document.getElementById("lastname").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;
    let brthd = document.getElementById("bday").value;
    let color = document.getElementById("color").value;

    let genders = document.getElementsByName("gender");
    let g = "";
    for(let i=0;i<genders.length;i++){
        if(genders[i].checked){
            g = genders[i].value;
        }
    }

    let hobbies = document.getElementsByClassName("activity");
    let h = "";
    for(let i=0;i<hobbies.length;i++){
        if(hobbies[i].checked){
            h += hobbies[i].nextSibling.nodeValue;
        }
    }

    if (fname.length<2) {
        console.log("First Name must be filled out");
        return false;
    }else if(lname.length<2){
        console.log("Last Name must be filled out");
        return false;
    }else if(!EmEx.test(email)){
        console.log("Email address is not valid.");
        return false;
    }else if(((phone.length!==10))){
        console.log("Phone number is not valid.");
        return false;
    }else if (!brthd) {
        console.log("Birthday is not valid.");
        return false;
    } else if (!g) {
        console.log("Gender is not valid.");
        return false;
    }else if(h === undefined){
        console.log("No activities were selected.");
        return false;
    }

    console.log(fname+", "+lname+", "+g+", "+email+", "+phone+", "+brthd+", "+color+", "+h);

    let table = document.getElementsByClassName("table");
    console.log(table);
    let row = table.insertRow(0);

    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    let cell5 = row.insertCell(4);
    let cell6 = row.insertCell(5);
    let cell7 = row.insertCell(6);

    cell1.innerHTML = fname;
    cell2.innerHTML = email;
    cell3.innerHTML = phone;
    cell4.innerHTML = brthd;
    cell5.innerHTML = color;
    cell6.innerHTML = g;
    cell7.innerHTML = h;
});

//Question 5
let details = document.getElementsByTagName("details")[0];

details.addEventListener("mouseover",openDetails);

function openDetails(){
    if(!details.hasAttribute("open")) details.setAttribute("open",true);
}

//Question 6
function spanthis(){
    let s = "";
    let spans = document.getElementsByTagName("span");
    for(let i = 0; i<spans.length; i++){
        s+=spans[i].firstChild.nodeValue;
    }
    console.log(s);
}

spanthis();

//Question 7

//Question 8
let url="http://www.astropical.space/astrodb/api-exo.php?which=name&limit=proxima centauri b&format=json";
let xhr = new XMLHttpRequest();

if (window.XMLHttpRequest) {
    // code for modern browsers
    xhr = new XMLHttpRequest();
} else {
    // code for old IE browsers
    xhr = new ActiveXObject("Microsoft.xht");
}

xhr.onreadystatechange = function(){
    if (this.readyState === 4 && this.status === 200) {
        // Action to be performed when the document is read;
    }
};
xhr.open("GET", url, true);
xhr.send();

//Question 9
let clickthis = document.getElementsByTagName("h1")[0];
clickthis.addEventListener("click",changeback);

function changeback(){
    let c = Math.floor((Math.random() * 255) + 1);
    let d = Math.floor((Math.random() * 100) + 1);
    let e = Math.floor((Math.random() * 100) + 1);
    if (e<20) e+=50;
    document.body.style.backgroundColor = "hsl("+c+", "+d+"%, "+e+"%)";
}

//Question 10

let num1 = 0;

num1 = document.getElementById("n1").value;

    let num2 = 0;

    num2 = document.getElementById("n2").value;

let rslt = parseInt(document.getElementById("result"));
let expr = document.getElementById("operation");

let regx = /^(-?\d+\.\d+)$|^(-?\d+)$/;

if((regx.test(num1))&&(regx.test(num2))){
    let op;
    switch(expr) {
        case "Divide":
            rslt.innerHTML = num1/num2;
            break;
        case "Multiply":
            rslt.innerHTML = num1*num2;
            break;
        case "Add":
            rslt.innerHTML = num2+num1;
            break;
        case "Subtract":
            rslt.innerHTML = num1-num2;
            break;
        default:
            rslt.innerHTML = "You have not selected an operation.";
    }

}