<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/ProjetoFinal/js/funcoes.js"></script>
	<link rel="shortcut icon" href="/ProjetoFinal/img/icone.ico"/>
	<link rel="STYLESHEET" type="text/css" href="/ProjetoFinal/css/restrita.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Cadeira</title>
</head>
<body>

<center><h3 >&Aacute;rea Restrita - Registro de Cadeira</h3></center>


<fieldset id=area-restrita>

<form action="/ProjetoFinal/Servlet" method="get" onsubmit="return valida_enviar_Sala(this)">
<input type="hidden" name="classe" value="CadeiraControl">

<input type="hidden" name="acao" value="adicionar"/>
<input type="hidden" name="destino" value="/ProjetoFinal/index.jsp">
<table>

<tr>
<td>Nome</td><td><input type="text" name="nome" id=nome onkeyup="valida_digitos('nome')" onblur="valida_campos('nome')" onFocus="informa('nome')">
<div id=respostanome style="COLOR: red"></div></td>
</tr>
<tr>
<td>Numero</td><td><input type="text" name="numero" id=numero onkeyup="valida_digitos('numero')" onblur="valida_campos('numero')" onFocus="informa('numero')">
<div id=respostanumero style="COLOR: red"></div></td>
</tr>

<tr>
<td>Sala</td><td>

<select name="idsala">
	<c:forEach var="salas" items="${salas}">
		<option value="${salas.id}">${salas.nome}</option>
	</c:forEach>
</select>

</td>

</tr>
<tr>
<td><input type="checkbox" name="auto" > Cadastrar Todas </td>
</tr>




</table>
<br><br>
<input type="submit" value="Incluir"></input>

</form>
</fieldset>

<center>
        <a class=link href="/ProjetoFinal/html/adm/restrito.jsp">[ HOME ]</a>   <a  class=link href="/ProjetoFinal/Servlet?classe=FuncionarioControl&acao=sair&destino=index02.html">[ LOGOUT ]</a>
</center>
</body>
</html>