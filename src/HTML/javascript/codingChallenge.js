console.log("hi");
	
	var table = document.getElementById("userTable");
	var select = document.getElementById("amountSelect");
	
	
function sendAjaxGet(url, func) {
    let xhr = (new XMLHttpRequest || new ActiveXObject("Microsoft.HTTPRequest"));
    xhr.onreadystatechange = function () {
        if (this.status == 200 & this.readyState == 4) {
            func(this);
        }
    }

    xhr.open("GET", url);
    xhr.send();
}

function getUser(num) {
    let baseUrl = "https://randomuser.me/api/?results=" + num;
	
    sendAjaxGet(baseUrl, addUser);
}

function addUser(xhr) {
    let response = xhr.response;
    let info = JSON.parse(response);
	
	let newRow;
	
	for(i = 0; i<info.results.length;i++){
		if(table.rows.length > amountSelect.value){
			break;
		}
		newRow = table.insertRow(table.rows.length);
		newRow.insertCell(0).innerHTML = info.results[i].name.first + " " + info.results[i].name.last;
		newRow.insertCell(1).innerHTML = info.results[i].phone;
		newRow.insertCell(2).innerHTML = info.results[i].email;
	};
}

function onClickGenerate(){
	clearTable();
	getUser(select.value);
};

function clearTable(){
	if(table.rows.length > 1){
		for(i = 1; table.rows.length > 1;){
			table.deleteRow(i);
		}
	}
}

select.addEventListener("change", function(){
	if(table.rows.length > select.value){
		for(i = Number(select.value) + 1; table.rows.length > Number(select.value) + 1;){
			table.deleteRow(i);
		}
	} else {
		getUser(Number(select.value) - table.rows.length); 
	}
	
});