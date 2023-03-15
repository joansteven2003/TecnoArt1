const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
// select violento con diferentes campos
const selects = document.querySelectorAll('#formulario select');
const gruposSelect = document.querySelectorAll('.grupo-select');

const expresiones = {
	Estrellas: /^\d{1,1}$/ //1 a 1 numeros.
}

const campos = {
    Estrellas:false
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "Estrellas":
			validarCampo(expresiones.Estrellas, e.target, 'Estrellas');
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

    

inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

//parte de opciones
    selects.forEach((select) => {
    select.addEventListener('change', validarFormulario2);
});


formulario.addEventListener('submit', (e) => {
	e.preventDefault();

	const validacion = Object.values(campos).every((campo) => campo);

	if(campos.Estrellas && validacion){
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