form = document.getElementById('nav');
function logout()
{
    form.action = "logout";
    form.submit();
}

function home()
{
    location.href="/home";
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
