const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
	Recidencia: /^[a-zA-Z0-9._#-]{4,25}$/, // Letras, numeros, guion y guion_bajo
	NombreCompleto: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
	password: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/, /*
	asegura que la cadena contiene al menos un dígito.
	asegura que la cadena contiene al menos una letra minúscula.
	asegura que la cadena contiene al menos una letra mayúscula.
	asegura que la cadena contiene al menos una letra.
	asegura que la cadena tiene una longitud mínima de 8 caracteres.
	*/
	email: /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/,
	Documento: /^\d{8,14}$/, // 7 a 14 numeros.
    Telefono: /^\d{10,14}$/ // 7 a 14 numeros.
}

const campos = {
	Recidencia: false,
	NombreCompleto: false,
	password: false,
	email: false,
    Documento: false,
	Telefono: false
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "Recidencia":
			validarCampo(expresiones.Recidencia, e.target, 'Recidencia');
		break;
		case "NombreCompleto":
			validarCampo(expresiones.NombreCompleto, e.target, 'NombreCompleto');
		break;
		case "password":
			validarCampo(expresiones.password, e.target, 'password');
			validarPassword2();
		break;
		case "password2":
			validarPassword2();
		break;
		case "email":
			validarCampo(expresiones.email, e.target, 'email');
		break;
        case "Documento":
			validarCampo(expresiones.Documento, e.target, 'Documento');
		break;
		case "Telefono":
			validarCampo(expresiones.Telefono, e.target, 'Telefono');
		break;
	}
}

const validarCampo = (expresion, input, campo) => {
	if(expresion.test(input.value)){
		mostrarEstadoCampo(campo, 'correcto');
		campos[campo] = true;
	} else {
		mostrarEstadoCampo(campo, 'incorrecto');
		campos[campo] = false;
	}
}

const mostrarEstadoCampo = (campo, estado) => {
	const grupoCampo = document.getElementById(`grupo__${campo}`);
	const icono = grupoCampo.querySelector(`i`);
	const mensajeError = grupoCampo.querySelector(`.formulario__input-error`);

	if (estado === 'correcto') {
		grupoCampo.classList.remove('formulario__grupo-incorrecto');
		grupoCampo.classList.add('formulario__grupo-correcto');
		icono.classList.remove('fa-times-circle');
		icono.classList.add('fa-check-circle');
		mensajeError.classList.remove('formulario__input-error-activo');
	} else {
		grupoCampo.classList.remove('formulario__grupo-correcto');
		grupoCampo.classList.add('formulario__grupo-incorrecto');
		icono.classList.remove('fa-check-circle');
		icono.classList.add('fa-times-circle');
		mensajeError.classList.add('formulario__input-error-activo');
	}
}

	const validarPassword2 = () => {
    	const inputPassword1 = document.getElementById('password');
    	const inputPassword2 = document.getElementById('password2');

    	if (inputPassword1.value !== inputPassword2.value) {
    		mostrarEstadoCampo('password2', 'incorrecto');
    		campos['password'] = false;
    	} else {
    		mostrarEstadoCampo('password2', 'correcto');
    		campos['password'] = true;
    	}
    }

inputs.forEach((input) => {
	input.addEventListener('keyup', validarFormulario);
	input.addEventListener('blur', validarFormulario);
});

formulario.addEventListener('submit', (e) => {

	const terminos = document.getElementById('terminos');
	if(campos.Recidencia && campos.NombreCompleto && campos.password && campos.email && campos.Telefono && campos.Documento && terminos.checked ){

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

