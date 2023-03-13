var contador;
function Calificar(item){
    console.log(item);
    contador=item.id[0];//captura el primer carapter
    let nombre= item.id.substring(1); //captura todos menos el primer caracter
    for(let i=0;i<5;i++){
        if (i<contador) {
            document.getElementById((i+1)+nombre).style.color="orange";
        }else{
            document.getElementById((i+1)+nombre).style.color="black";
        }
    }
}
function calificacion(){
    alert("Gracias por calificar el servicio usted nos dio "+contador+" estrellas");
}
