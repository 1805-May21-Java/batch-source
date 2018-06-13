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

    document.getElementsByName("firstName").value = person.name.first;
    document.getElementsByName("lastName").value = person.name.last;
    document.getElementByName("email").value = person.email;
    document.getElementByName("password").value = person.login.password;
    document.getElementByName("confirmPassword").value = person.login.password;
}