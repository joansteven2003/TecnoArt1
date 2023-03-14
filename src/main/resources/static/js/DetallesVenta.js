const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
const opcion = document.getElementById('opcion');
const grupoOpcion = document.getElementById('grupo__opcion');

const expresiones = {
    Tamano: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo
    Medida: /^[a-zA-Z0-9]{4,16}$/, // Letras y espacios, pueden llevar acentos.
    Servicio: /^\d{7,14}$/,
    valorUnitario: /^\d{1,14}$/, // 7 a 14 numeros.
    CantidadPedido: /^\d{1,14}$/, // 7 a 14 numeros.
    Material: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // aqui permite Letras y espacios de 4 a 10 caracteres
    comentarios: /^[a-zA-ZÀ-ÿ0-9.,;:_\s]{1,500}$/ // 7 a 14 numeros.
}

const campos = {
    Tamano: false,
    Medida: false,
    Servicio: false,
    valorUnitario: false,
    CantidadPedido: false,
    Material: false,
    comentarios: false
}

const validarFormulario = (e) => {
    switch (e.target.name) {
        case "Tamano":
            validarCampo(expresiones.Tamano, e.target, 'Tamano');
            break;
        case "Medida":
            validarCampo(expresiones.Medida, e.target, 'Medida');
            break;
        case "Servicio":
            validarCampo(expresiones.Servicio, e.target, 'Servicio');
            break;
        case "valorUnitario":
            validarCampo(expresiones.valorUnitario, e.target, 'valorUnitario')
            break;
        case "CantidadPedido":
            validarCampo(expresiones.CantidadPedido, e.target, 'CantidadPedido');
            break;
        case "Material":
            validarCampo(expresiones.Material, e.target, 'Material');
            break;
        case "comentarios":
            validarCampo(expresiones.comentarios, e.target, 'comentarios');
            break;

        case "opcion":
            validarCampo2(opcion.value !== "", grupoOpcion, 'opcion');
            break;
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

const validarCampo2 = (valor, grupo, campo) => {
    if (valor) {
        grupo.classList.remove('formulario__grupo-incorrecto');
        grupo.classList.add('formulario__grupo-correcto');
        document.querySelector(`#${campo} .formulario__validacion-estado.fa-check-circle`).classList.add('formulario__validacion-estado-activo');
        document.querySelector(`#${campo} .formulario__validacion-estado.fa-times-circle`).classList.remove('formulario__validacion-estado-activo');
        document.querySelector(`#${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
    } else {
        grupo.classList.add('formulario__grupo-incorrecto');
        grupo.classList.remove('formulario__grupo-correcto');
        document.querySelector(`#${campo} .formulario__validacion-estado.fa-times-circle`).classList.add('formulario__validacion-estado-activo');
        document.querySelector(`#${campo} .formulario__validacion-estado.fa-check-circle`).classList.remove('formulario__validacion-estado-activo');
        document.querySelector(`#${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
    }
}



inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
});
//parte del campo del texto mas grande
comentarios.addEventListener('keyup', validarFormulario);
comentarios.addEventListener('blur', validarFormulario);


//parte de opciones 
opcion.addEventListener('change', validarFormulario);

formulario.addEventListener('submit', (e) => {
    e.preventDefault();

    if (campos.Tamano && campos.Medida && campos.Servicio && campos.valorUnitario && campos.CantidadPedido && campos.Material && campos.comentarios && opcion.value !== "") {
        formulario.reset();

        document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
        setTimeout(() => {
            document.getElementById('formulario__mensaje-exito').classList.remove('formulario__mensaje-exito-activo');
        }, 3000);

        document.querySelectorAll('.formulario__grupo-correcto').forEach((icono) => {
            icono.classList.remove('formulario__grupo-correcto');
        });
    } else {
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
        setTimeout(() => {
            document.getElementById('formulario__mensaje').classList.remove('formulario__mensaje-activo');
        }, 2000);
    }
});