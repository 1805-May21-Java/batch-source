sendAjaxGet("http://localhost:8082/Project1/session", getUser)

function sendAjaxGet(url, func){
    let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status ==200){
            func(this); //this refers to the XHR object
        }
    }
    xhr.open("GET", url);
    xhr.send();
}

function getUser(xhr)
{
    let user = JSON.parse(xhr.response);
    document.getElementById('welcome').innerHTML = 'Welcome '+user[0].username;
    if(user[0].isManager === 1)
    {
        document.getElementById('managerOnly').removeAttribute('hidden')
    }
}
form = document.getElementById('nav');
function logout()
{
    form.action = "logout";
    form.submit();
}

function home()
{
    form.action = 'home';
    form.submit();
}

function reimb()
{
    form.action = 'reimb';
    form.submit();
}

function info()
{
    form.action = 'info';
    form.submit();
}
