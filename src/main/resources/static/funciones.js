function eliminarDis(codigo_dis){
	swal({
  title: "Borrar Distribuidor",
  text: "Al borrar este distribuidor no lo podras recuperar!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminarDis/"+codigo_dis,
		success: function(res) {
			console.log(res);
		},
	});
    swal("Distribuidor borrado", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/listarDis"
	}
});
  } else {
    swal("Distribuidor no borrado");
  }
});
}

function eliminarProd(codigo_prod){
	swal({
  title: "Borrar Producto",
  text: "Al borrar este producto no lo podras recuperar!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminarProd/"+codigo_prod,
		success: function(res) {
			console.log(res);
		},
	});
    swal("Producto borrado", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/listarProd"
	}
});
  } else {
    swal("Producto no borrado");
  }
});
}

function eliminarCanal(codigo_canal){
	swal({
  title: "Borrar Canal",
  text: "Al borrar este canal no lo podras recuperar!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
	$.ajax({
		url:"/eliminarCanal/"+codigo_canal,
		success: function(res) {
			console.log(res);
		},
	});
    swal("Producto Canal", {
      icon: "success",
    }).then((ok)=>{
	if(ok){
		location.href="/listarCanal"
	}
});
  } else {
    swal("Canal no borrado");
  }
});
}