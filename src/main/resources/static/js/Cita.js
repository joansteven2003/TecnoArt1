const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
	direccion: /^[a-zA-Z0-9._#-]{4,25}$/, // Letras, numeros, guion y guion_bajo
    correo: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
    Documento: /^\d{7,10}$/, // 7 a 10 numeros.
	Nombre: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
    fecha: /^\d{4}-\d{2}-\d{2}$/, // Formato de fecha yyyy-mm-dd
    hora: /^([01]?[0-9]|2[0-3]):[0-5][0-9]$/
}

const campos = {
	direccion: false,
    correo: false,
    Documento: false,
	Nombre: false,
    fecha:false,
    hora:false
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "direccion":
			validarCampo(expresiones.direccion, e.target, 'direccion');
		break;
        case "correo":
			validarCampo(expresiones.correo, e.target, 'correo');
		break;
        case "Documento":
			validarCampo(expresiones.Documento, e.target, 'Documento');
		break;
        case "Nombre":
			validarCampo(expresiones.Nombre, e.target, 'Nombre');
		break;

        case "fecha":
			validarCampo(expresiones.fecha, e.target, 'fecha');
		break;

        case "hora":
			validarCampo(expresiones.hora, e.target, 'hora');
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

inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

formulario.addEventListener('submit', (e) => {


	if(campos.direccion && campos.correo && campos.Documento && campos.Nombre  && campos.fecha &&  campos.hora ){

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