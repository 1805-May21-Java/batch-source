document.getElementById("nameEdit").addEventListener("click", setNameEditable);

function setNameEditable() {
    document.getElementById("name").readonly = false;
}