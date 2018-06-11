
url = "https://randomuser.me/api/"

let submit_1 = document.getElementById("submit_1")
let submit_2 = document.getElementById("submit_2")

//submit_1.addEventListener("click", grabEmployees)
submit_1.addEventListener("click", newFetch)
submit_2.addEventListener("click", grabEmployees)

function grabEmployees(num) {
    if (this.id == "submit_1") {
        getAjax(url, gotResult)
    }
    else {
        let select = document.getElementsByTagName("select")
        let options = select[0]
        let how_many = 0;
        for (option of options) {
            if (option.selected == true) {
                how_many = option.value
                break;
            }
        }
        getAjax(url + "?results=" + how_many, gotResults)
    }

}

function getAjax(url, func) {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = () => {
        if (xhr.readyState == 4 & xhr.status == 200) {
            func(xhr)
        }
    }
    xhr.open("GET", url)
    xhr.send()
}

function gotResult(xhr) {
    let response = JSON.parse(xhr.response)

    let name = capFirst(response.results[0].name.title) + " " + capFirst(response.results[0].name.first) + " " + capFirst(response.results[0].name.last)
    let phone = response.results[0].phone;
    let email = response.results[0].email

    document.getElementById("name").innerHTML = name
    document.getElementById("phone").innerHTML = phone
    document.getElementById("email").innerHTML = email
}

function gotResults(xhr) {
    let table = document.getElementById("mul")
    let tbody = document.getElementById("populate")
    let newTbody = document.createElement("tbody")
    newTbody.id = "populate"
    table.replaceChild(newTbody, tbody)

    let responses = JSON.parse(xhr.response)
    count = 1;

    for (response of responses.results) {
        let name = capFirst(response.name.title) + " " + capFirst(response.name.first) + " " + capFirst(response.name.last)
        let phone = response.phone;
        let email = response.email

        let row = document.createElement("tr")

        let data0 = document.createElement("td")
        let data1 = document.createElement("td")
        let data2 = document.createElement("td")
        let data3 = document.createElement("td")

        data0.innerHTML = count
        data1.innerHTML = name
        data2.innerHTML = phone
        data3.innerHTML = email

        row.appendChild(data0)
        row.appendChild(data1)
        row.appendChild(data2)
        row.appendChild(data3)

        document.getElementById("populate").appendChild(row)
        count++
    }

}

function newFetch() {
    fetch(url)
        .then((response) => response.json())
        .then(function (response) {
            let results = response.results;

            let name = capFirst(results[0].name.title) + " " + capFirst(results[0].name.first) + " " + capFirst(results[0].name.last)
            let phone = results[0].phone;
            let email = results[0].email

            document.getElementById("name").innerHTML = name
            document.getElementById("phone").innerHTML = phone
            document.getElementById("email").innerHTML = email
        })
}

function capFirst(string) {
    string = string.split(" ")
    let newString = "";
    for (str of string) {
        newString += str[0].toUpperCase() + str.substring(1) + " "
    }
    return newString.substring(0, newString.length - 1)
}