let pass = document.querySelector("#password");
let passval = document.querySelector("#validatepassword");
let button = document.querySelector("button");
button.disabled = true; /* Disables our submit button so we cannot submit our form */
pass.addEventListener("change", validatePassword); /* After a change, runs the validate password function */
passval.addEventListener("change", validatePassword);

function validatePassword() { /* Checks to see if the password and the passval are the same */

    if(document.getElementById("password").value != document.getElementById("validatepassword").value) {
        button.disabled = true; /* Keeps submit button disabled */
    } else {
        button.disabled = false;/* Re enables the submit button */
    }
}