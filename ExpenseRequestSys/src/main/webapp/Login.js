let url = 'http://localhost:8080/ExpenseRequestSys/login';

function sendAjaxPost(url, obj, redirfcn, errfcn) {
	xhr = (new XMLHttpRequest() || new ActiveXObject('Microsoft.HTTPRequest'));
	xhr.onreadystatechange = function() {
		if (this.readyState == 4) {
			switch (this.status) {
			case 300:
				redirfcn(this);
				break;
			case 401:
				errfcn(this);
				break;
			}
		}
	}

	xhr.open('POST', url);
	let js = JSON.stringify(obj);
	xhr.send(js);
}

function redir(xhr) {
	window.location.reload(true);
}

function err(xhr) {
	let data = JSON.parse(xhr.response);
	document.getElementById("error").innerHTML = data.error;
}

function submitLogin() {
	let username = (document.getElementById('username').value || null);
	let pwd = (document.getElementById('password').value || null);

	sendAjaxPost(url, {
		"username" : username,
		"pwd" : pwd
	}, redir, err);
}