function Borrar(){
    window.confirm('Esta seguro de limpiar el formulario, los datos seran borrados')
}
function Actualizar(){
    var Nombres=document.getElementById("Nombres").value;
    var Apellidos=document.getElementById("Apellidos").value;
    var Usuario=document.getElementById("Usuario").value;
    var Correo=document.getElementById("Correo").value;
    var CCorreo=document.getElementById("CCorreo").value;
    var Contraseña=document.getElementById("Contraseña").value;
    var Contraseña2=document.getElementById("Contraseña2").value;
    var Contraseña3=document.getElementById("Contraseña3").value;
    var Contraseña3=document.getElementById("Documento").value;
    var Contraseña3=document.getElementById("Nacimiento").value;
    var Contraseña3=document.getElementById("Edad").value;
    var Contraseña3=document.getElementById("Telefono").value;
    
    if(Nombres=="")
    alert("Por favor, ingrese sus nombres")
    if(Nombres=="")
    alert("Por favor, ingrese sus apellidos")
    if(Usuario=="")
    alert("Por favor, ingrese un usuario valido")
    if(Correo=="")
    alert("Por favor, ingrese un correo")
    if(CCorreo=="")
    alert("Por favor, confirmar el correo electronico")
    if(Contraseña=="")
    alert("Por favor, ingrese una contraseña")
    if(Contraseña2=="")
    alert("Por favor, ingrese una contraseña")
    if (Contraseña3=="") {
        if(Contraseña2==Contraseña3)
        alert("Las contraseñas no conciden")
    }
    if(Documento=="")
    alert("Por favor, ingrese un documento")
    if(Nacimiento=="")
    alert("Por favor, ingrese una fecha valida")
    if(Edad=="")
    alert("Por favor, ingrese su edad")
    if(Telefono=="")
    alert("Por favor, ingrese un telefono")
}