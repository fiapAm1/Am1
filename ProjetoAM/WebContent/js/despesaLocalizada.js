function localizar(){
	var registro = jQuery('#radio_Registro').val();
//	jQuery.getJSON('localizarDespesa',{'codigoLancamento': registro}, function(json){
//		alert("Tipo de Despesa: " + json.users.jSonTipoDespesa);
//		alert("Valor da Despesa: " + json.users.jSonValorDespesa);
//		alert("Observação: " + json.users.jSonObservacaoDespesa);
//	});
	jQuery.ajax({
		type: 'post',
	    data: 'codigoLancamento='+registro,
	    url:'pages/localizarDespesa.action',
	    success: function(json){
	    	$('#select_TipoDespesa').val(json);
	    	$('#select_TipoDespesa').disabled = true;
	    	$('#textfield_Valor').val(json);
	    	$('#textarea_Observacao').val(json);
	    }
	});
}

//jQuery(function(){
//	jQuery.ajax({
//		type: 'post',
//	    data: 'codigoLancamento='+tipo+'&valor='+valor,
//	    url:'ponte/tipobusca.jsp',
//	    success: function(retorno){
//	    	$('#corpo').html(retorno);  
//	    }
//	});
//});
