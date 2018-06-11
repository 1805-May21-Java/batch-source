let url = 'https://randomuser.me/api/';

document.getElementById("newperson").addEventListener("click",function(){
    sendAjaxGet(url, popTable);
});
document.getElementById("newpeople").addEventListener("click",function(){
    for(let i=20;i>0;i--){
        sendAjaxGet(url, popTable);
    }
});

function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));

    xhr.onreadystatechange = function(){
        if(this.status === 200 && this.readyState === 4){
            func(this);
        }else if(this.status >= 400 && this.status < 600){
            document.getElementById("alert").innerHTML = "Invalid Input";
        }
    };
    xhr.open("GET", url);
    xhr.send();
}

function popTable(xhr){
    let response = xhr.response;
    let person = JSON.parse(response);

    let name = person.results[0].name.first+" "+person.results[0].name.last;
    let phone = person.results[0].phone;
    let email = person.results[0].email;
    let country = person.results[0].nat;
    let city = person.results[0].location.city;

    console.log(name+phone+email+country+city);

    let table = document.getElementById("tab");
    let row = table.insertRow(1);

    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    let cell5 = row.insertCell(4);

    cell1.innerHTML = name;
    cell2.innerHTML = phone;
    cell3.innerHTML = email;
    cell4.innerHTML = `<img src="http://www.countryflags.io/${country.toLowerCase()}/flat/32.png">`;
    cell5.innerHTML = city;

}