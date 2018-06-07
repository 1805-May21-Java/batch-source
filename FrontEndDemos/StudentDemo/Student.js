document.getElementById("addStudent").addEventListener("click", add);

let idCount = 1000;

function add() {
    // console.log("add students button clicked");

    if ((name && major) != "") {
        let name = document.getElementById("name").value;
        let major = document.getElementById("major").value;

        // console.log(`name is: ${name}
        // major is: ${major}`)

        //creating our table row
        let row = document.createElement("tr");

        //creating the cells to be appended to the the row
        let cell1 = document.createElement("td");
        let cell2 = document.createElement("td");
        let cell3 = document.createElement("td");

        //appending cells to the row
        row.appendChild(cell1);
        row.appendChild(cell2);
        row.appendChild(cell3);

        //adding our input info into our cells
        cell1.innerHTML = idCount++;
        cell2.innerHTML = name;
        cell3.innerHTML = major;

        //find our table, add our row onto it
        document.getElementById("students").appendChild(row);
    }

}

//document.getElementsByTagName("body")[0].style.backgroundColor = "lightblue";
document.getElementsByTagName("body")[0].setAttribute("style","background-color:lightblue");

link = document.createElement("a");
link.innerHTML = "click here";
link.setAttribute("href", "http://google.com");

document.getElementsByTagName("body")[0].appendChild(link);