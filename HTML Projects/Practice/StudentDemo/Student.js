document.getElementById("addStudent").addEventListener("click", add);

let idCount = 1000;

function add() {

    let name = document.getElementById("name").value;
    let major = document.getElementById("major").value;

    if ((name && major) != "") {
        // create table row
        let row = document.createElement("tr");

        // create cells for the row
        let cell1 = document.createElement("td");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");

        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);

        // add input info into cells
        cell1.innerHTML = idCount++;
        cell2.innerHTML = name;
        cell3.innerHTML = major;

        // find table and add row
        document.getElementById("students").appendChild(row);
    }
}

//document.getElementsByTagName("body")[0].style.backgroundColor = "lightblue";
document.getElementsByTagName("body")[0].setAttribute("style", "background-color:lightblue");

link = document.createElement("a");
link.innerHTML = "click here";
link.setAttribute("href", "http://google.com");

document.getElementsByTagName("body")[0].appendChild(link);