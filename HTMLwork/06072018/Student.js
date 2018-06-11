document.getElementById("addStudent").addEventListener("click",add);

let Idcount = 1000;

function add() {
        if((name&&major)!="") {
            // console.log("Add student button clicked");
            let name = document.getElementById("name").value;
            let major = document.getElementById("major").value;
            // console.log(`name is: ${name}
            // major is: ${major}`)

            //creating our table row
            let row = document.createElement("tr");

            //creating the cells to the appended to the table
            let cell1 = document.createElement("td");
            let cell2 = document.createElement("td");
            let cell3 = document.createElement("td");

            //appending the cells to the row
            row.appendChild(cell1);
            row.appendChild(cell2);
            row.appendChild(cell3);

            cell1.innerHTML = Idcount++;
            cell2.innerHTML = name;
            cell3.innerHTML = major;

            //append row to table
            document.getElementById("Students").appendChild(row);
        }
}

// document.getElementsByTagName("body")[0].style.backgroundColor= "lightblue";
document.getElementsByTagName("body")[0].setAttribute("style","background-color:offwhite");
link = document.createElement("a");
link.innerHTML = "click here";
link.setAttribute("href","http://google.com");

document.getElementsByTagName("body")[0].appendChild(link);

//Reverse a number
function revNum(n){
    let o = n.toString();
    let r = o.split("").reverse().join("");
    return r;
}

//Capitalizes first letter in a String and returns the word
function firsttoUp(str){
    let ustr = str.charAt(0).toUpperCase()+ str.slice(1);
    return ustr;
}

function isPrime(num){
    let sqrt = Math.sqrt(num);
    for(let i=2; i<=sqrt;i++){
        if(num%i==0){
            return false;
        }
    }
    return true;
}

console.log(revNum(145));
console.log(firsttoUp("meep-morp"));