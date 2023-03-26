var Alert = new CustomAlert();

function CustomAlert(){
  this.render = function(){
      //Show Modal
      let popUpBox = document.getElementById('popUpBox');
      popUpBox.style.display = "block";
      //Close Modal
      document.getElementById('closeModal').innerHTML = '<button  style="background-color: #E4E9F7;"  onclick="Alert.ok()">Continuemos</button>';
  }
  
this.ok = function(){
  document.getElementById('popUpBox').style.display = "none";
  document.getElementById('popUpOverlay').style.display = "none";
}
}