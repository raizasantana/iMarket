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
<title>Listar Salas</title>
</head>
<body>

<center><h3 >&Aacute;rea Restrita - Listar Salas</h3></center>

<fieldset id=area-restrita>
<form action="/ProjetoFinal/ServletSala" method="get">
		Informe o nome da sala <input type="text" name="nome"> <br><br>
		<input type="hidden" name="acao" value="listar">
		<input type="submit" value="Listar">
	</form>

<c:if test="${salas.id!=null }">
<table border="1" >
    <tr> 
       <td> Nome </td> <td> Quantidade de Cadeiras </td> <td> Quantidade de Fileiras </td> 
    </tr>
   <c:forEach var="salas" items="${salas}">
   		<tr>
   			<td>${salas.nome} </td> <td><center>${salas.qtdCadeiras}</center> </td> <td><center>${salas.qtdFileiras}</center> </td> 
   			
   		</tr>
   		  
   </c:forEach>
   </table>
   </c:if>
   
   </fieldset>

	<center>
        <a class=link href="/ProjetoFinal/html/adm/restrito.jsp">[ HOME ]</a>   <a  class=link href="/ProjetoFinal/Servlet?classe=FuncionarioControl&acao=sair&destino=index02.html">[ LOGOUT ]</a>
</center>







<center><a href="/ProjetoFinal/index.jsp">Area aberta</a></center>
</body>
</html>