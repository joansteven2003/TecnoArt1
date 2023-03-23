const formulario = document.getElementById('formulario');
const inputs = document.querySelectorAll('#formulario input');

const expresiones = {
    institucion: /^[a-zA-ZÀ-ÿ\s]{5,20}$/, // Letras y espacios, pueden llevar acentos.
    Titulo:/^[a-zA-ZÀ-ÿ\s]{5,20}$/, // Letras y espacios, pueden llevar acentos.
    fecha_grado: /^\d{4}-\d{2}-\d{2}$/, // Formato de fecha yyyy-mm-dd
    Empresa: /^[a-zA-ZÀ-ÿ\s]{4,20}$/, // Letras y espacios, pueden llevar acentos.
    Puesto: /^[a-zA-ZÀ-ÿ\s]{5,20}$/, // Letras y espacios, pueden llevar acentos.
    fecha_inicio: /^\d{4}-\d{2}-\d{2}$/, // Letras y espacios, pueden llevar acentos.
    fecha_fin: /^\d{4}-\d{2}-\d{2}$/, // Letras y espacios, pueden llevar acentos.
    DescripcionT: /^[a-zA-ZÀ-ÿ0-9.,;:_\s]{10,500}$/, // observacion dondepermite mayusculas,minusculas y espacios y ortografia.
    habilidades: /^[a-zA-ZÀ-ÿ0-9.,;:_\s]{10,200}$/, // observacion dondepermite mayusculas,minusculas y espacios y ortografia.
    referencias: /^[a-zA-ZÀ-ÿ0-9.,;:_\s]{10,200}$/, // observacion dondepermite mayusculas,minusculas y espacios y ortografia.


}

const campos = {
	institucion: false,
    Titulo: false,
    fecha_grado: false,
    Empresa: false,
    Puesto: false,
    fecha_inicio: false,
    fecha_fin: false,
    DescripcionT: false,
    habilidades: false,
    referencias: false
}

const validarFormulario = (e) => {
	switch (e.target.name) {
		case "institucion":
			validarCampo(expresiones.institucion, e.target, 'institucion');
		break;
        case "Titulo":
			validarCampo(expresiones.Titulo, e.target, 'Titulo');
		break;
        case "fecha_grado":
			validarCampo(expresiones.fecha_grado, e.target, 'fecha_grado');
		break;
        case "Empresa":
			validarCampo(expresiones.Empresa, e.target, 'Empresa');
		break;

        case "Puesto":
			validarCampo(expresiones.Puesto, e.target, 'Puesto');
		break;

        case "fecha_inicio":
            validarCampo(expresiones.fecha_inicio, e.target, 'fecha_inicio');
        break;

        case "fecha_fin":
            validarCampo(expresiones.fecha_fin, e.target, 'fecha_fin');
        break;

        case "DescripcionT":
			validarCampo(expresiones.DescripcionT, e.target, 'DescripcionT');
		break;

		case "habilidades":
        validarCampo(expresiones.habilidades, e.target, 'habilidades');
        break;

        case "referencias":
        validarCampo(expresiones.referencias, e.target, 'referencias');
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

//parte del campo del texto mas grande
DescripcionT.addEventListener('keyup', validarFormulario);
DescripcionT.addEventListener('blur', validarFormulario);
//parte del campo del texto mas grande
habilidades.addEventListener('keyup', validarFormulario);
habilidades.addEventListener('blur', validarFormulario);

//parte del campo del texto mas grande
referencias.addEventListener('keyup', validarFormulario);
referencias.addEventListener('blur', validarFormulario);

formulario.addEventListener('submit', (e) => {


	if(campos.institucion && campos.Titulo && campos.fecha_grado && campos.Empresa && campos.Puesto && campos.fecha_inicio && campos.fecha_fin && campos.DescripcionT && campos.habilidades && campos.referencias){

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