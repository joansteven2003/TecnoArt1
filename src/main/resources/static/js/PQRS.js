const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
// select violento con diferentes campos
const selects = document.querySelectorAll('#formulario select');
const gruposSelect = document.querySelectorAll('.grupo-select');

const expresiones = {
    Fecha: /^\d{4}-\d{2}-\d{2}$/, // Formato de fecha yyyy-mm-dd
    RespuestaPqrs: /^[a-zA-ZÀ-ÿ0-9.,;:_\s]{10,500}$/ // 7 a 14 numeros.
}

const campos = {
    Fecha: false,
    RespuestaPqrs: false
}

const validarFormulario = (e) => {
    switch (e.target.name) {
        case "Fecha":
            validarCampo(expresiones.Fecha, e.target, 'Fecha');
            break;

        case "RespuestaPqrs":
            validarCampo(expresiones.RespuestaPqrs, e.target, 'RespuestaPqrs');
            break;
    }
}
const validarFormulario2 = (e) => {
    const select = e.target;
    const grupoSelect = select.parentElement;

    if (select.value !== "") {
        grupoSelect.classList.remove('formulario__grupo-incorrecto');
        grupoSelect.classList.add('formulario__grupo-correcto');
        grupoSelect.querySelector('.formulario__input-error').classList.remove('formulario__input-error-activo');
        campos[select.name] = true;
    } else {
        grupoSelect.classList.add('formulario__grupo-incorrecto');
        grupoSelect.classList.remove('formulario__grupo-correcto');
        grupoSelect.querySelector('.formulario__input-error').classList.add('formulario__input-error-activo');
        campos[select.name] = false;
    }
}

const validarCampo = (expresion, input, campo) => {
    if (expresion.test(input.value)) {
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
        campos[campo] = true;
    } else {
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
        campos[campo] = false;
    }
}


inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
});

//parte de opciones 
    selects.forEach((select) => {
    select.addEventListener('change', validarFormulario2);
});

//parte del campo del texto mas grande
RespuestaPqrs.addEventListener('keyup', validarFormulario);
RespuestaPqrs.addEventListener('blur', validarFormulario);

formulario.addEventListener('submit', (e) => {


    const validacion = Object.values(campos).every((campo) => campo);

    if (validacion && campos.RespuestaPqrs && campos.Fecha) {

        document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
        setTimeout(() => {
            document.getElementById('formulario__mensaje-exito').classList.remove('formulario__mensaje-exito-activo');
        }, 3000);

        document.querySelectorAll('.formulario__grupo-correcto').forEach((icono) => {
            icono.classList.remove('formulario__grupo-correcto');
        });
    } else {
        e.preventDefault();
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
        setTimeout(() => {
            document.getElementById('formulario__mensaje').classList.remove('formulario__mensaje-activo');
        }, 2000);
    }
});