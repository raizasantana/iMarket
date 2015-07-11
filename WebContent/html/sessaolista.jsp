<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="STYLESHEET" type="text/css" href="/ProjetoFinal/css/estilocss.css">
	<script type="text/javascript" src="/ProjetoFinal/js/funcoes.js"></script>
	<link rel="shortcut icon" href="/ProjetoFinal/img/icone.ico"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Sessões</title>
</head>
<body>

<!--
Barra Superior
-->
 <div id="menu-superior"  >
	
   <table cellpadding="3" cellspacing="0" border="0" onMouseDown="">
	<tr>
	<td colspan=10 height=35  width=300><a href="/ProjetoFinal/index02.html"> <img align=right src="/ProjetoFinal/img/iMarket-logo-2.0.png" width=60></a></td>
	<td width=60 align=center valign="middle" ><a class="ms-link" href="/ProjetoFinal/index02.html" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');">Home</a></td>
	<td width=180 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('i1');escondeDiv('f1');escondeDiv('s1');escondeDiv('c1');">Ingressos</a> </td>
	<td width=60 align=center valign="middle"><a class="ms-link" href="/ProjetoFinal/html/login.jsp" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');"> Login</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('s1');escondeDiv('f1');escondeDiv('i1');escondeDiv('c1');">Sess&otilde;es</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');" > Filmes</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');"> Carrinho</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('c1');escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');"> Cliente</a> </td>
	</tr>

   </table>
 
  <div id="s1" class="menu-sessao">
	<div class="shadow">
  <a href="/ProjetoFinal/ServletFilme?acao=listarcombo&destino=/html/sessaolista.jsp" class="ms-link">Listar Sess&otilde;es</a>
   </div>
 </div>

	<div id="f1" class="menu-filme"  >
		<div class="shadow">
	<a href="/ProjetoFinal/Servlet?classe=FilmeControl&acao=listar&nome=&destino=/html/filmelista.jsp" class="ms-link">Listar Filmes</a>
	 </div></div>

	<div id="i1" class="menu-ingresso" >
		<div class="shadow">
	<a href="/ProjetoFinal/Servlet?classe=FilmeControl&acao=listar&nome=&destino=/html/filmelista.jsp" class="ms-link">Registrar Ingresso</a><br>
	<a href="/ProjetoFinal/html/ingressolista2.jsp" class="ms-link">Listar Ingressos</a>
	 </div></div>
	 
	 <div id="c1" class="menu-cliente" >
		<div class="shadow">
	<a href="/ProjetoFinal/html/frmcliente.jsp" class="ms-link">Registrar Cliente</a><br>
	<a href="/ProjetoFinal/html/clientebusca.jsp?destino=/html/clientebusca.jsp" class="ms-link">Buscar Cliente</a>
	<a href="/ProjetoFinal/html/clientebusca2.jsp" class="ms-link">Alterar dados do  Cliente</a>
	 </div></div>
	 
	
</div>

<!-- 
Inicio da Pagina
 -->
 
 <div id=cadastro>

<form action="/ProjetoFinal/ServletSessao" method="get">
		
		Selecione um filme:<br>
<select name="idfilme">
 	<c:forEach var="filmes" items="${filmes}">
		<option value="${filmes.id}">${filmes.nome}</option>
	</c:forEach>
</select><br />
	<input type="submit" name="acao" value="listar">
	</form>




<c:if test="${sessaos!=null }">
<table border="1" >
    <tr> 
       <td>Hora </td> <td> Data </td><td>Filme</td><td>Sala</td> <td></td>
    </tr>
   <c:forEach var="sessaos" items="${sessaos}">
   		<tr>
   			<td>${sessaos.horaIni} </td> <td>${sessaos.data} </td> <td>${sessaos.filme.nome }</td><td>${sessaos.sala.nome}</td>
   			<td> <a href="/ProjetoFinal/Servlet?classe=CadeiraControl&acao=listarstatus&idsessao=${sessaos.id}&destino=/html/cadeiralivre.jsp">Cadeiras </a></td>
   		</tr>
   		  
   </c:forEach>
   </table>
</c:if>
</div>
<center><a href="/ProjetoFinal/index.jsp">Area aberta</a></center>

</body>
</html>










