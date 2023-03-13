function limpiar(){
    window.confirm('Esta seguro de limpiar el formulario, los datos seran borrados')
}
function Registrar(){
    var nameUser=document.getElementById("nameUSE").value;
    var correo=document.getElementById("correo").value;
    var confirCorr=document.getElementById("ConfirC").value;
    var password1=document.getElementById("password").value;
    var password2=document.getElementById("password2").value;
    
    if(nameUser=="")
    alert("Por favor, ingresa un nombre")
    if(correo=="")
    alert("Escriba un correo")
    if(confirCorr=="")
    alert("No Confirmo el correo electronico")
    if(password1=="")
    alert("contraseña no valida")
    if (password2=="") {
        if(password2==password1)
        alert("La contraseña no conciden")
    }
    
}