window.onload = function() {
    // listen for button to generate a single user
    addUserGeneratorLisenter();



};

function addUserGeneratorLisenter() {
    let buttonOneUser = document.getElementById('generateUser');
    buttonOneUser.addEventListener('click', makeUserRequest);
    let buttonMultiUser = document.getElementById('generateMultiUsers');
    buttonMultiUser.addEventListener('click', makeUsersRequest);

}
// Request a single user
function makeUserRequest() {
    let baseUrl = 'https://randomuser.me/api/';
    //make request for one user and parse response
    makeRequest(baseUrl, function(xhr) {
        let results = JSON.parse(xhr.response);

        console.log(results.results);
        //get information from results
        let firstName = results.results[0].name.first;
        let lastName = results.results[0].name.last;
        firstName = firstName.charAt(0).toUpperCase() + firstName.substring(1, firstName.length)
        lastName = lastName.charAt(0).toUpperCase() + lastName.substring(1, lastName.length);  
        let phoneNumber = results.results[0].phone;
        let emailAddress =  results.results[0].email;
        //display the results
        document.getElementById('userName').innerHTML = `Name: ${firstName} ${lastName}`;
        document.getElementById('userPhone').innerHTML = `Phone: ${phoneNumber}`;
        document.getElementById('userEmail').innerHTML = `Email: ${emailAddress}`;
    });
}

// Request multiple users
function makeUsersRequest() {
    let baseUrl = 'https://randomuser.me/api/?results=';
    let numResults = document.getElementById('numberOfRowsSelect').value;
    //make the request based on numResults
    makeRequest(baseUrl + numResults, function(xhr) {
        let results = JSON.parse(xhr.response);
        //get the table element
        let table = document.getElementById('userTable');

        
        for(var i = 0; i < numResults; i++) {
           
            tableRow = document.createElement('tr');
            tableNum = document.createElement('td');
            tableName = document.createElement('td');
            tablePhone = document.createElement('td');
            tableEmail = document.createElement('td');
            let firstName = results.results[i].name.first;
            let lastName = results.results[i].name.last;
            firstName = firstName.charAt(0).toUpperCase() + firstName.substring(1, firstName.length)
            lastName = lastName.charAt(0).toUpperCase() + lastName.substring(1, lastName.length);  
            let phoneNumber = results.results[i].phone;
            let emailAddress =  results.results[i].email;

            tableNum.innerHTML = i + 1;
            tableName.innerHTML = `${firstName} ${lastName}`;
            tablePhone.innerHTML = phoneNumber;
            tableEmail.innerHTML = emailAddress;

            tableRow.appendChild(tableNum);
            tableRow.appendChild(tableName);
            tableRow.appendChild(tablePhone);
            tableRow.appendChild(tableEmail);

            table.appendChild(tableRow);
        }

    });

}

function makeRequest(url, func) {    
    let xhr = new XMLHttpRequest() || new ActiveXObject('Microsoft.XMLHTTP');
    xhr.onreadystatechange = function() {
        if(xhr.readyState == 4 && xhr.status == 200) {
            func(this);
        }
    }
    xhr.open('GET', url);
    xhr.send();
}
