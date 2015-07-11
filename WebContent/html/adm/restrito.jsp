<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="STYLESHEET" type="text/css" href="/ProjetoFinal/css/restrita.css">
<script type="text/javascript" src="/ProjetoFinal/js/funcoes.js"></script>
<link rel="shortcut icon" href="/ProjetoFinal/img/icone.ico"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iMarket</title>
</head>
<body >

<div class=cabecalho>
<img src="/ProjetoFinal/img/iMarket-logo-2.0.png" width="100" align="right">
<br>
<center><h1>&Aacute;rea Restrita </h1></center>
</div>

<div class=caixa>
<div class=tabela>
<table >
	<tr>
		<td><img src="/ProjetoFinal/img/cadeiras.png" width="100" align="right" onclick="mostraDiv('cadeira');escondeDiv('cliente');escondeDiv('filme');escondeDiv('ingresso');escondeDiv('sessao');escondeDiv('sala');escondeDiv('tipo');escondeDiv('funcionario');"></td>
		<td><img src="/ProjetoFinal/img/cliente.png" width="100" align="right" onclick="mostraDiv('cliente');escondeDiv('ingresso');escondeDiv('filme');escondeDiv('sessao');escondeDiv('sala');escondeDiv('tipo');escondeDiv('funcionario');"></td>
		<td><img src="/ProjetoFinal/img/ingresso.png" width="100"	align="right" onclick="mostraDiv('ingresso');escondeDiv('filme');escondeDiv('sessao');escondeDiv('sala');escondeDiv('tipo');escondeDiv('funcionario');"></td>
		<td><img src="/ProjetoFinal/img/tipo.png" width="100"	align="right" onclick="mostraDiv('tipo');escondeDiv('filme');escondeDiv('sessao');escondeDiv('sala');escondeDiv('ingresso');escondeDiv('funcionario');"></td>
	</tr>

	<tr>
		<td><img src="/ProjetoFinal/img/filme.png" width="100" align="right" onclick="mostraDiv('filme');escondeDiv('sessao');escondeDiv('sala');escondeDiv('tipo');escondeDiv('funcionario');"></td>
		<td><img src="/ProjetoFinal/img/sessao.png" width="100" 	align="right" onclick="mostraDiv('sessao');escondeDiv('sala');escondeDiv('tipo');escondeDiv('funcionario');"></td>
		<td><img src="/ProjetoFinal/img/sala.png" width="100" align="right" onclick="mostraDiv('sala');escondeDiv('sessao');escondeDiv('tipo');escondeDiv('funcionario');"></td>
		<td><img src="/ProjetoFinal/img/funcionario.png" width="100" align="right" onclick="mostraDiv('funcionario');escondeDiv('sessao');escondeDiv('sala');"></td>
	</tr>

</table>
</div>

<div class=menu id=cadeira>
<a class=link2 href="/ProjetoFinal/ServletCadeira?acao=listarcombos&destino=/html/adm/frmcadeira.jsp">Registrar Cadeira</a><br>
<a class=link2 href="/ProjetoFinal/ServletSala?acao=listarcombo&destino=/html/adm/cadeiralista.jsp">Listar Cadeiras</a>
</div>

<div class=menu id=cliente>
<a class=link2 href="/ProjetoFinal/html/adm/clientelista.jsp">Listar Clientes</a><br>
<a class=link2 href="/ProjetoFinal/html/adm/clientebusca.jsp">Buscar Cliente</a>
</div>

<div class=menu id=ingresso>
<a class=link2 href="/ProjetoFinal/ServletCliente?acao=listarcombo&destino=/html/adm/ingressolista.jsp">Listar Ingressos</a><br>
<a class=link2 href="/ProjetoFinal/html/ingressolista2.jsp">Mostrar Ingresso</a>
</div>

<div class=menu id=filme>
<a class=link2 href="/ProjetoFinal/html/adm/frmfilme.html">Registrar Filme</a><br/>
<a class=link2 href="/ProjetoFinal/ServletFilme?acao=listar&nome=">Listar Filmes</a>
</div>

<div class=menu id=sala>
<a class=link2 href="/ProjetoFinal/html/adm/frmsala.html" >Registrar Sala</a><br/>
<a class=link2 href="/ProjetoFinal/html/adm/salalista.jsp">Listar Salas</a>
</div>

<div class=menu id=sessao>
<a class=link2 href="/ProjetoFinal/ServletSessao?acao=iniciar&destino=/html/adm/frmsessao.jsp" >Registrar Sessão</a><br/>
<a class=link2 href="/ProjetoFinal/ServletFilme?acao=listarcombo&destino=/html/sessaolista.jsp">Listar Sessões</a>
</div>

<div class=menu id=tipo>
<a class=link2 href="/ProjetoFinal/html/adm/frmtipo.html" >Registrar Tipo</a><br/>
<a class=link2 href="/ProjetoFinal/html/tipolista.jsp">Listar Tipo</a>
</div>

<div class=menu id=funcionario>
<a class=link2 href="/ProjetoFinal/html/adm/frmfuncionario.jsp" >Registrar Funcionario</a>  <a class=link2 href="/ProjetoFinal/html/adm/funcionariolista.jsp">Listar Funcionario</a><br/>
<a class=link2 href="/ProjetoFinal/html/adm/funcionariobusca2.jsp">Alterar Funcionario</a> <a class=link2 href="/ProjetoFinal/html/adm/funcionariobusca.jsp">Buscar Funcionario</a>
</div>
</div>

<div class=rodape>
 <a class=link href="/ProjetoFinal/html/adm/restrito.jsp">[ HOME ]</a>   <a  class=link href="/ProjetoFinal/Servlet?classe=FuncionarioControl&acao=sair&destino=index02.html">[ LOGOUT ]</a>
</div>

</body>
</html>