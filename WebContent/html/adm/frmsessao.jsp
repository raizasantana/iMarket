<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="/ProjetoFinal/js/funcoes.js"></script>
	<link rel="shortcut icon" href="/ProjetoFinal/img/icone.ico"/>
	<link rel="STYLESHEET" type="text/css" href="/ProjetoFinal/css/restrita.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Sessão</title>
</head>
<body>


<center><h3 >&Aacute;rea Restrita - Registro de Sess&atilde;o</h3></center>

<fieldset id=area-restrita>
<form action="/ProjetoFinal/ServletSessao" method="get" onsubmit="return valida_enviar_Sessao(this)">
Selecione a sala:<br>
<select name="idSala">
	<c:forEach var="salas" items="${salas}">
		<option value="${salas.id}">${salas.nome}</option>
	</c:forEach>
</select><br />


Selecione o filme:<br>
<select name="idFilme">
	<c:forEach var="filmes" items="${filmes}">
		<option value="${filmes.id}">${filmes.nome}</option>
	</c:forEach>
</select> <br>
<table>
<tr><td>Informe a data da sessão(dd/mm/aaaa):<br><input type="text" name="data" id=data onkeyup="valida_digitos('data')" onBlur="validar_Data('data')" onFocus="informa('data')"><div id=respostadata style="COLOR: red"></div></td></tr>
<tr><td>Informe a hora da sessão(hh:mm:ss):<br><input type="text" name="horaIni" id=horaIni onkeyup="valida_digitos('horaIni')" onBlur="validar_hora('horaIni')" onFocus="informa('horaIni')"><div id=respostahoraIni style="COLOR: red"></div> </td></tr>
</table>

	<input type="submit" name="acao" value="Registrar" >	
	</form>

<br />
</fieldset>
<center>
        <a class=link href="/ProjetoFinal/html/adm/restrito.jsp">[ HOME ]</a>   <a  class=link href="/ProjetoFinal/Servlet?classe=FuncionarioControl&acao=sair&destino=index02.html">[ LOGOUT ]</a>
</center>
</body>
</html>