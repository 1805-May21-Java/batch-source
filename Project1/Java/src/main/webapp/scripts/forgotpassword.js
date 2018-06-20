let url = "http://localhost:8082/Project1/EmailServlet";
let errorElement = document.getElementById("errorMessage");

document.getElementById("emailButton").addEventListener("click",function(){
    let email = {email:  document.getElementById("email").value}
    sendAjax("POST",url,postEmail,document.getElementById("email").value);
})


function sendAjax(verb,url,func,data){
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        if(xhr.readyState === 4 && xhr.status === 200){
            func(xhr);
        }
    }
    xhr.open(verb,url);
    xhr.send(JSON.stringify(data));
}

function postEmail(){
	 sendAjax("GET","http://localhost:8082/Project1/ValidInvalid",showResultMessage);
}

function showResultMessage(xhr){
	    let response = JSON.parse(xhr.response);
	    if(response.emailValid == "Invalid"){
	        //user tried to enter invalid email, displays error message and refreshes correct information
	        errorElement.setAttribute("class","text-danger");
            errorElement.innerText = "Email does not exist";
	    }else{
	        //add a success message
	        errorElement.setAttribute("class","text-success");
	        errorElement.innerText = "Email sent!";
	    }
}