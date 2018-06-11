// // document.getElementById("form-sub").addEventListener("click",add);
//
// function add() {
//     let firstName = document.getElementById("firstname").value;
//     let aemail = document.getElementById("email").value;
//     let Phone = document.getElementById("phone").value;
//     let DOB = new Date();
//     DOB = document.getElementById("bday").value;
//     let favColor = document.getElementById("color");
//     let gender = document.getElementsByName("gender").value;
//
//     let row = document.createElement("tr");
//
//     //creating the cells to the appended to the table
//     let cell1 = document.createElement("td");
//     let cell2 = document.createElement("td");
//     let cell3 = document.createElement("td");
//     let cell4 = document.createElement("td");
//     let cell5 = document.createElement("td");
//     let cell6 = document.createElement("td");
//
//     row.appendChild(cell1);
//     row.appendChild(cell2);
//     row.appendChild(cell3);
//     row.appendChild(cell4);
//     row.appendChild(cell5);
//     row.appendChild(cell6);
//
//     cell1.innerHTML=firstName;
//     cell2.innerHTML=aemail;
//     cell3.innerHTML=Phone;
//     cell4.innerHTML=DOB;
//     cell5.innerHTML=favColor;
//     cell6.innerHTML=gender;
//
//     document.getElementsByTagName("tbody")[1].appendChild(row);
// }

//5.Create a function openDetails() which opens the details element. Invoke this function when the details’ summary is moused over. The details should be hidden when the mouse is removed from the summary.
document.getElementsByTagName('summary')[0].addEventListener('hover',openDetails);
function openDetails(){
     let x = document.createAttribute("open");
     let y = document.getElementsByTagName('details')[0];
     y.setAttribute(x);
}


//6.) Create a function that concatenates the inner HTML of all of the span elements and prints the results to the console.
function spanCombo() {
    var words = document.getElementsByTagName("span");
    let sentence = "";
    for(var i = 0; i<words.length; i++){
        sentence+=words[i].innerHTML;
    }
    return sentence;
}

console.log(spanCombo());