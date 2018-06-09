//This function gets called once the page loads
document.addEventListener("DOMContentLoaded", function () {
    //Hides all menus
    hideAll();

    //links all buttons to their respective functions
    //using on click because I don't want a button to have more than one function at a time
    document.getElementById("credentials").onclick = showSignin;
    document.getElementById("goToCreate").onclick = showSignup;
    document.getElementById("goToLogin").onclick = showSignin;
    document.getElementById("goToProfile").onclick = showProfile;
    document.getElementById("goToMakeRequest").onclick = showMakeRequest;
    document.getElementById("goToViewRequests").onclick = showViewRequests;
    document.getElementById("login").onclick = attemptLogin;
    document.getElementById("create").onclick = attemptCreateAccount;

    if (sessionStorage.getItem("loggedIn") == null) {
        sessionStorage.setItem("loggedIn", false);
    } else if (sessionStorage.getItem("loggedIn") == "true") {
        document.getElementById("credentials").innerHTML = "Logout";
        document.getElementById("credentials").onclick = logout;
        let listItems = document.getElementsByClassName("nav-item");
        for (let item of listItems) {
            item.removeAttribute("hidden");
        }

        if (sessionStorage.getItem("currentPage") == "profile") {
            showProfile();
        } else if (sessionStorage.getItem("currentPage") == "makeRequest") {
            showMakeRequest();
        } else if (sessionStorage.getItem("currentPage") == "viewRequests") {
            showViewRequests();
        }
    } else {
        let listItems = document.getElementsByClassName("nav-item");
        for (let item of listItems) {
            item.setAttribute("hidden", true);
        }
    }
});

//This is called to clear the screen of mmenus
function hideAll() {
    document.getElementById("signinMenu").setAttribute("hidden", true);
    document.getElementById("signupMenu").setAttribute("hidden", true);
    document.getElementById("profileMenu").setAttribute("hidden", true);
    document.getElementById("makeRequestMenu").setAttribute("hidden", true);
    document.getElementById("viewRequestsMenu").setAttribute("hidden", true);
}

/*
Here are the functions that reveal specific menus.
I tried making one function that would take a string, but when you include
a parameter into a callback function assignment, it calls that function 
immediately.
*/
function showSignin() {
    hideAll();
    document.getElementById("signinMenu").removeAttribute("hidden");
    document.getElementById("currentTitle").innerHTML = "Login";
    $('html,body').scrollTop(0);
}

function showSignup() {
    hideAll();
    document.getElementById("signupMenu").removeAttribute("hidden");
    document.getElementById("currentTitle").innerHTML = "Create an Acccount";
    $('html,body').scrollTop(0);
}

function showProfile() {
    hideAll();
    document.getElementById("profileMenu").removeAttribute("hidden");
    document.getElementById("currentTitle").innerHTML = "Profile";
    $('html,body').scrollTop(0);
    sessionStorage.setItem("currentPage", "profile");
}

function showMakeRequest() {
    hideAll();
    document.getElementById("makeRequestMenu").removeAttribute("hidden");
    document.getElementById("currentTitle").innerHTML = "Make a Request";
    $('html,body').scrollTop(0);
    sessionStorage.setItem("currentPage", "makeRequest");
}

function showViewRequests() {
    hideAll();
    document.getElementById("viewRequestsMenu").removeAttribute("hidden");
    document.getElementById("currentTitle").innerHTML = "View Requests";
    $('html,body').scrollTop(0);
    sessionStorage.setItem("currentPage", "viewRequests");
}

function attemptLogin() {
    login();
}

function login() {
    document.getElementById("credentials").innerHTML = "Logout";
    document.getElementById("credentials").onclick = logout;
    sessionStorage.setItem("loggedIn", true);
    showProfile();
    let listItems = document.getElementsByClassName("nav-item");
    for (let item of listItems) {
        item.removeAttribute("hidden");
    }
}

function attemptCreateAccount() {
    createAccount();
}


function createAccount() {
    document.getElementById("credentials").innerHTML = "Logout";
    document.getElementById("credentials").onclick = logout;
    sessionStorage.setItem("loggedIn", true);
    showProfile();
    let listItems = document.getElementsByClassName("nav-item");
    for (let item of listItems) {
        item.removeAttribute("hidden");
    }
}


function logout() {
    hideAll();
    document.getElementById("currentTitle").innerHTML = "Expense Reimbursement System";
    document.getElementById("credentials").innerHTML = "Login/Signup"
    document.getElementById("credentials").onclick = showSignin;
    sessionStorage.setItem("loggedIn", false);

    let listItems = document.getElementsByClassName("nav-item");
    for (let item of listItems) {
        item.setAttribute("hidden", true);
    }
}
