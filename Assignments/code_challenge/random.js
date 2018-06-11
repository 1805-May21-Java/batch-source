let baseUrl = "https://randomuser.me/api";

function randomize(){

        sendAjaxGet(baseUrl, displayProfile);
    }

function randomizeInput(input){

    sendAjaxGet(baseUrl+"/?results="+input, displayTable);
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
function displayTable(xhr){
    let response = xhr.response;
    let info = JSON.parse(response);
    console.log(info);
    information = info;
    
    for(let i=0, length = info.results.length; i<length;i++)
    {

        let picture =info.results[i].picture.thumbnail;
        let name    = info.results[i].name.first +" "+info.results[i].name.last;;
        let gender  = info.results[i].gender;
        let phone = info.results[i].phone;
        let email = info.results[i].email;

        let tr = document.createElement("tr");
        tr.className+="table-primary";
        tr.setAttribute("scope", "row");
        let td1 = document.createElement("td");
        td1.innerHTML="<img src=\""+picture+"\" >";
        let td2 = document.createElement("td");
        td2.innerHTML=name;
        let td3 = document.createElement("td");
        td3.innerHTML=gender;
        let td4 = document.createElement("td");
        td4.innerHTML=phone;
        let td5 = document.createElement("td");
        td5.innerHTML=email;
    
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        tr.appendChild(td4);
        tr.appendChild(td5);
    
        document.getElementsByTagName("tbody")[0].appendChild(tr);
    }

}