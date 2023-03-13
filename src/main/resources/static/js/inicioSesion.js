
function limpiar(){
    Swal.fire({
        title: 'Seguro',
        text: "Se borrara la información",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Eliminar'
      }).then((result) => {
        if (result.isConfirmed) {
          Swal.fire(
            'Eliminado',
            'Se elimino correctamente',
            'success'
           
          )
        }
      })
}

function Iniciar() {
    var usuario1=document.getElementById("email").value;
    var paswer=document.getElementById("pwd").value;

    if (usuario1=="admin@gmail.com" && paswer=="1234") {
        Swal.fire(
            'Correrto',
            'Bienvenido Administrador',
            'success'
          );
          
    window.location = "perfil administrador.html";
    return true;
    }
    if(usuario1=="emleado@gmail.com" && paswer=="1234"){
        Swal.fire(
            'Correrto',
            'Bienvenido Administrador',
            'success'
          );
    window.location="PedidosEmpleado.html";
    return true; 
    }
    if(usuario1=="cliente@gmail.com" && paswer=="1234"){
        Swal.fire(
            'Correrto',
            'Bienvenido Administrador',
            'success'
          );
        window.location="perfil cliente-servicio al cliente.html";
        return true;
    }else{
        Swal.fire(
            'incorrecto',
            'Verifique su correo o contraseña',
            'error'
          );
    }

}