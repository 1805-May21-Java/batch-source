let baseUrl = "https://randomuser.me/api";

function randomize(){

        sendAjaxGet(baseUrl, displayProfile);
    }


function sendAjaxGet(url, func){
    let xhr = (new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function(){
        //console.log(xhr.readyState);
        if(this.status == 200 && this.readyState == 4){
            func(this);
        }
    }
    xhr.open("GET", url);
    xhr.send();
}
var infomation;
function displayProfile(xhr){
    let response = xhr.response;
    let info = JSON.parse(response);
    information = JSON.parse(response);
    console.log(info);

    document.getElementById("pictures").setAttribute("src", info.results[0].picture.large);
    document.getElementById("name").innerHTML = "Name: "+ info.results[0].name.first +" "+info.results[0].name.last;;
    document.getElementById("gender").innerHTML = "Gender: "+ info.results[0].gender;
    document.getElementById("phone").innerHTML = "Phone: "+ info.results[0].phone;
    document.getElementById("email").innerHTML = "Email: "+ info.results[0].email;
}