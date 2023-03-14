const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
//traer los campor opcion
const opcion = document.getElementById('opcion');
const grupoOpcion = document.getElementById('grupo__opcion');

const expresiones = {
	Resultado: /^[a-zA-ZÀ-ÿ\s]{4,10}$/, // Letras y espacios, pueden llevar acentos.
    ResultadoEntrevis: /^[a-zA-ZÀ-ÿ\s]{4,10}$/, // Letras y espacios, pueden llevar acentos.
}

const campos = {
	Resultado: false,
    ResultadoEntrevis: false

}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "Resultado":
			validarCampo(expresiones.Resultado, e.target, 'Resultado');
		break;
        case "ResultadoEntrevis":
			validarCampo(expresiones.ResultadoEntrevis, e.target, 'ResultadoEntrevis');
		break;
        case "opcion":
            validarCampo2(opcion.value !== "", grupoOpcion, 'opcion');
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

formulario.addEventListener('submit', (e) => {
	e.preventDefault();

	if(campos.Resultado && campos.ResultadoEntrevis && opcion.value !== "" ){
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