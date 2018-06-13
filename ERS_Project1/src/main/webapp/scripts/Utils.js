function myFetch(url, func) {
    fetch(url)
        .then(function (response) {
            if (response.status !== 200) {
                console.log('Looks like there was a problem. Status Code: ' + response.status);
                return;
            }

            response.json().then(function (data) {
                func(data);
            });
        })
        .catch(function (err) {
            console.log('Fetch Error :-S', err);
        });
}



function createRandomUser() {
    myFetch('https://randomuser.me/api/', fillForm);
}

function fillForm(obj) {
    let person = obj.results[0];

    document.getElementById("firstName").value = person.name.first;
    document.getElementById("lastName").value = person.name.last;
    document.getElementById("newEmail").value = person.email;
    document.getElementById("createPassword").value = person.login.password;
    document.getElementById("confirmPassword").value = person.login.password;
}


function isValidEmail(str) {
    let a = str.lastIndexOf("@");
    let d = str.lastIndexOf(".");

    if ((a > -1 && d > -1) && (a<d) && (d-a > 1) && (str.length-d > 1)){
        return true;
    }
    return false;
}