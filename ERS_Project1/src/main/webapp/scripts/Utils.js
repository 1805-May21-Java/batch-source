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
    document.getElementById("email").value = person.email;
    document.getElementById("password").value = person.login.password;
    document.getElementById("confirmPassword").value = person.login.password;
}