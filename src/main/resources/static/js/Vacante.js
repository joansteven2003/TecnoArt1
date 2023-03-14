const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
//traer los campor opcion
const opcion = document.getElementById('opcion');
const grupoOpcion = document.getElementById('grupo__opcion');

const expresiones = {
    horaInicial: /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/, //permite la hora de HH:mm
    horaFinal: /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/, //permite la hora de HH:mm
    LugarTrabajo: /^[a-zA-Z0-9._#-]{4,25}$/, // Letras, numeros, guion y guion_bajo
    Salario: /^\d{5,20}$/, // 5 a 20 numeros.
    Educacion: /^[a-zA-ZÀ-ÿ\s]{5,20}$/, // Letras y espacios, pueden llevar acentos.
    comentarios: /^[a-zA-ZÀ-ÿ0-9.,;:_\s]{1,500}$/, // observacion dondepermite mayusculas,minusculas y espacios y ortografia. 
}

const campos = {
	horaInicial: false,
    horaFinal: false,
    LugarTrabajo: false,
    Salario: false,
    Educacion: false,
    comentarios: false
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "horaInicial":
			validarCampo(expresiones.horaInicial, e.target, 'horaInicial');
		break;
        case "horaFinal":
			validarCampo(expresiones.horaFinal, e.target, 'horaFinal');
		break;
        case "LugarTrabajo":
			validarCampo(expresiones.LugarTrabajo, e.target, 'LugarTrabajo');
		break;
        case "Salario":
			validarCampo(expresiones.Salario, e.target, 'Salario');
		break;

        case "Educacion":
			validarCampo(expresiones.Educacion, e.target, 'Educacion');
		break;
        case "opcion":
            validarCampo2(opcion.value !== "", grupoOpcion, 'opcion');
            break;
        case "comentarios":
			validarCampo(expresiones.comentarios, e.target, 'comentarios');
		break;

        
		
	}
}

const validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value)){
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

// validar campo de select pero de solo 1 
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

//parte de opciones 
opcion.addEventListener('change', validarFormulario);

//parte del campo del texto mas grande
comentarios.addEventListener('keyup', validarFormulario);
comentarios.addEventListener('blur', validarFormulario);

formulario.addEventListener('submit', (e) => {
	e.preventDefault();

	if(campos.horaInicial && campos.horaFinal && campos.Salario && campos.LugarTrabajo && campos.Educacion && opcion.value !== "" && campos.comentarios ){
		formulario.reset();

		document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
		setTimeout(() => {
			document.getElementById('formulario__mensaje-exito').classList.remove('formulario__mensaje-exito-activo');
		}, 3000);

		document.querySelectorAll('.formulario__grupo-correcto').forEach((icono) => {
			icono.classList.remove('formulario__grupo-correcto');
		});
	} else {
        console.log(campos);
		document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
        setTimeout(() => {
			document.getElementById('formulario__mensaje').classList.remove('formulario__mensaje-activo');
		}, 2000);

	}
});