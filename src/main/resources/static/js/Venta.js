const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');
// select violento con diferentes campos
const selects = document.querySelectorAll('#formulario select');
const gruposSelect = document.querySelectorAll('.grupo-select');


const expresiones = {
    FechaVenta: /^\d{4}-\d{2}-\d{2}$/, // Formato de fecha yyyy-mm-dd
    FechaEntrega: /^\d{4}-\d{2}-\d{2}$/, // Formato de fecha yyyy-mm-dd
    Monto: /^\d{5,20}$/, // 5 a 20 numeros.
    Estado:/^[a-zA-ZÀ-ÿ\s]{5,10}$/, // Letras y espacios, pueden llevar acentos.
    comentarios:/^[a-zA-ZÀ-ÿ0-9.,;:_\s]{1,500}$/, // observacion dondepermite mayusculas,minusculas y espacios y ortografia. 
}

const campos = {
	FechaVenta: false,
    FechaEntrega: false,
    Monto: false,
    Estado: false,
    comentarios: false
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "FechaVenta":
			validarCampo(expresiones.FechaVenta, e.target, 'FechaVenta');
		break;
        case "FechaEntrega":
			validarCampo(expresiones.FechaEntrega, e.target, 'FechaEntrega');
		break;
        case "Monto":
			validarCampo(expresiones.Monto, e.target, 'Monto');
		break;
        case "Estado":
			validarCampo(expresiones.Estado, e.target, 'Estado');
		break;
        case "comentarios":
			validarCampo(expresiones.comentarios, e.target, 'comentarios');
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

//parte de opciones 
selects.forEach((select) => {
    select.addEventListener('change', validarFormulario2);
});


//parte del campo del texto mas grande
comentarios.addEventListener('keyup', validarFormulario);
comentarios.addEventListener('blur', validarFormulario);

formulario.addEventListener('submit', (e) => {
	e.preventDefault();

    const validacion = Object.values(campos).every((campo) => campo);

	if(validacion && campos.FechaEntrega && campos.FechaVenta && campos.Monto && campos.Estado && campos.comentarios ){
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