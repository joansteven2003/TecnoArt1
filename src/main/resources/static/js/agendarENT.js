function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className =
            x.previousElementSibling.className.replace("w3-black", "w3-red");
    } else {
        x.className = x.className.replace(" w3-show", "");
        x.previousElementSibling.className =
            x.previousElementSibling.className.replace("w3-red", "w3-black");
    }
}
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}

function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}
// Deshabilitar envíos de formularios si hay campos inválidos
(function () {
    'use strict';
    window.addEventListener('load', function () {
        // Obtener los formularios a los que queremos agregar estilos de validación
        var forms = document.getElementsByClassName('needs-validation');
        // Bucle sobre ellas y evitar la presentación
        var validation = Array.prototype.filter.call(forms, function (form) {
            form.addEventListener('submit', function (event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();
function Limpiar(){
    window.confirm('¿Esta seguro que quiere eliminar los datos?');
    /*var lugar= window.getElementById("lugar").value;
    var Cedu=window.getElementById("cedula").value;
    var Nombre=window.getElementById("nombre").value;
    var fecha=window.getElementById("Fecha").value;
    var hora=window.getElementById("hora").value;*/

}