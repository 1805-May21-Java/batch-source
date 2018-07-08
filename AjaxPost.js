function sendAjaxGet(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status ==200){
			func(this);
		}
	};
	xhr.open("GET",url);
	xhr.send();
}

sendAjaxGet("http://localhost:8082/AjaxPostDemo/TestServlet", getFunc);

function getFunc(xhr){
    console.log("GET /TestServlet "+xhr.response)
}


let myObject = {a:"hello",b:"world"};

function sendAjaxPost(url, func){
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status ==200){
			func(this);
		}
	};
	xhr.open("POST",url);
	xhr.send(JSON.stringify(myObject));
}

sendAjaxPost("http://localhost:8082/AjaxPostDemo/TestServlet", postFunc);

function postFunc(xhr){
    console.log("POST /TestServlet");
    console.log(xhr);
}