function showsignupform()
{
	myform = document.getElementById("signupform");
	myform.removeAttribute("hidden");
	signinform = document.getElementById("signinform");
	signinform.setAttribute("hidden", "true");
}