document.getElementById("new_person_button").addEventListener("click", function () {
    fetch("https://randomuser.me/api/")
        .then(function (response) { return response.json(); })
        .then(function (json) {
            let data = json.results[0];
            let name = data.name.first + " " + data.name.last;
            let phone = data.phone;
            let email = data.email;
            let picture = data.picture.medium;
            let location = data.location.street + ", " + data.location.city + ", " + data.location.state;

            let row2 = document.createElement("tr");
            let c1 = document.createElement("td");
            let c2 = document.createElement("td");
            let c3 = document.createElement("td");
            let c4 = document.createElement("td");
            let c5 = document.createElement("td");

            row2.appendChild(c1);
            row2.appendChild(c2);
            row2.appendChild(c3);
            row2.appendChild(c4);
            row2.appendChild(c5);

            let img = document.createElement("img");
            img.setAttribute("src", picture);
            c1.appendChild(img);
            c2.innerHTML = name;
            c3.innerHTML = email;
            c4.innerHTML = phone;
            c5.innerHTML = location;

            document.getElementsByTagName("tbody")[0].appendChild(row2);
        });
});

document.getElementById("new_person_tables").addEventListener("click", function () {
    fetch("https://randomuser.me/api/?results=20").
        then(function (response) { return response.json(); })
        .then(function (json) {

            for (let i = 0; i < 20; i++) {
                let data = json.results[i];
                let name = data.name.first + " " + data.name.last;
                let phone = data.phone;
                let email = data.email;
                let picture = data.picture.medium;
                let location = data.location.street + ", " + data.location.city + ", " + data.location.state;

                let row2 = document.createElement("tr");
                let c1 = document.createElement("td");
                let c2 = document.createElement("td");
                let c3 = document.createElement("td");
                let c4 = document.createElement("td");
                let c5 = document.createElement("td");

                row2.appendChild(c1);
                row2.appendChild(c2);
                row2.appendChild(c3);
                row2.appendChild(c4);
                row2.appendChild(c5);

                let img = document.createElement("img");
                img.setAttribute("src", picture);
                c1.appendChild(img);
                c2.innerHTML = name;
                c3.innerHTML = email;
                c4.innerHTML = phone;
                c5.innerHTML = location;

                document.getElementsByTagName("tbody")[1].appendChild(row2);
            }
        });
});