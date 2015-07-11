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
<title>Listar Tipos</title>
</head>
<body>

<!--
Barra Superior
-->
 <div id="menu-superior"  >
	
   <table cellpadding="3" cellspacing="0" border="0" onMouseDown="">
	<tr>
	<td colspan=10 height=35  width=300><a href="/ProjetoFinal/index02.html"> <img align=right src="/ProjetoFinal/img/iMarket-logo-2.0.png" width=60></a></td>
	<td width=60 align=center valign="middle" ><a class="ms-link" href="/ProjetoFinal/index02.html" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');">Home</a></td>
	<td width=180 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('i1');escondeDiv('f1');escondeDiv('s1');">Ingressos</a> </td>
	<td width=60 align=center valign="middle"><a class="ms-link" href="/ProjetoFinal/html/login.jsp" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');"> Login</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('s1');escondeDiv('f1');escondeDiv('i1');">Sess&otilde;es</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('f1');escondeDiv('s1');escondeDiv('i1');" > Filmes</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');"> Carrinho</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="/ProjetoFinal/html/frmcliente.html" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');"> Cliente</a> </td>
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
	 
	
</div>

<!-- 
Inicio da Pagina
 -->
  
<div id=cadastro>
<form action="/ProjetoFinal/ServletTipo" method="get">
		Informe a descrição do tipo <input type="text" name="descricao"> <br></br>
		<input type="hidden" name="acao" value="listar">
		<input type="submit">
	</form>

<c:if test="${tipos!=null }"></c:if>
<table border="1" >
    <tr> 
       <td> Descrição </td> <td> Preço </td> <td></td>
    </tr>
   <c:forEach var="tipos" items="${tipos}">
   		<tr>
   			<td>${tipos.descricao} </td> <td>${tipos.preco} </td><td><a href="/ProjetoFinal/ServletTipo?acao=remover&idTipo=${tipos.id }">Remover</a> 
   			
   		</tr>
   		  
   </c:forEach>
   </table>

</div>


</body>
</html>