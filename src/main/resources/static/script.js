let pass = document.querySelector("#password");
let passval = document.querySelector("#validatepassword");
let button = document.querySelector("button");
console.log(pass);
console.log(passval)
button.disabled = true;
pass.addEventListener("change", validatePassword);
passval.addEventListener("change", validatePassword);

function validatePassword() {
    console.log("are we getting here")
    if(document.getElementById("password").value != document.getElementById("validatepassword").value) {
        button.disabled = true;
    } else {
        console.log("they should be equal")
        button.disabled = false;
    }
}