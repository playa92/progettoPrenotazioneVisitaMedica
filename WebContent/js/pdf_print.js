
// PDF-PRINT
$(document).ready(function(){
		
	// STAMPA RIEPILOGO
	$('#cmd').click(function() {
		  var options = {
		  };
		  var pdf = new jsPDF('l', 'pt', 'a4');		  
		  pdf.addHTML($("#content"), 15, 15, options, function() {
		  pdf.save('riepilogo.pdf'); 
		  });
	});
			
}); 

//AUTOMATIC PDF-PRINT
function automaticPrint(){
	
	// STAMPA QR CODE (automatico)
	 html2canvas($("#print"),{
	 onrendered:function(canvas){
		 
		 var img=canvas.toDataURL("image/png");
		 var doc = new jsPDF('p', 'pt', 'a4');
		 //TODO
		 doc.text("Recati allo sportello entro le ore DA GESTIRE",150,80);
		 doc.addImage(img,'JPEG',80,110);
		 doc.save('qr_code.pdf');
		}

	 });
}