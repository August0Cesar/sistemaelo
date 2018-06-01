$(document).ready(
		function() {
		
$('#tot_criancas').val(0);
$('#tot_membros').val(0);
$('#tot_visitantes').val(0);

	function atualizaSoma() {
		var tot_criancas = $('#tot_criancas').val();
		var tot_membros = $('#tot_membros').val();
		var tot_visitantes = $('#tot_visitantes').val();
		var soma = parseInt(tot_criancas) + parseInt(tot_membros) + parseInt(tot_visitantes);
		return soma;
	};
	
$('#tot_criancas').focusout(function() {
	$('#tot_pessoas_celula').val(atualizaSoma());
});
$('#tot_membros').focusout(function() {
	$('#tot_pessoas_celula').val(atualizaSoma());
});
$('#tot_visitantes').focusout(function() {
	$('#tot_pessoas_celula').val(atualizaSoma());
});

$('#formSemanaCelula').submit(function() {
	let valorOferta = $('#ofertas').val();
	$('#ofertas').val(valorOferta.replace(',','.'));
});
$('#tot_pessoas_celula').focusout(function() {
	$('#tot_pessoas_celula').val(atualizaSoma());
});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
});