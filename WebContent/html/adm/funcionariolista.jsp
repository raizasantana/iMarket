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
<title>Funcionarios</title>
</head>
<body>

<center><h3 >&Aacute;rea Restrita - Listar Funcionarios</h3></center>

<fieldset id=area-restrita>
<form action="/ProjetoFinal/Servlet" method="get">
		Informe o nome do funcionario <input type="text" name="nome"> 
		<input type="hidden" name="acao" value="listar">
		<input type="hidden" name="classe" value="FuncionarioControl">
		
		<input type="submit">
	</form>

<c:if test="${funcionarios!=null }">

<table border="1" >
    <tr> 
       <td>ID</td> <td> Nome </td> <td> Matricula </td><td>Login</td> <td>Senha</td>
    </tr>
   <c:forEach var="funcionarios" items="${funcionarios}">
   		<tr>
   			<td>${funcionarios.id }</td> <td>${funcionarios.nome} </td> <td>${funcionarios.matricula} </td> <td>${funcionarios.login}</td><td>${funcionarios.senha}</td>
   			
   		</tr> 
   		  
   </c:forEach>
   </table>


</c:if>

</fieldset>

	<center>
        <a class=link href="/ProjetoFinal/html/adm/restrito.jsp">[ HOME ]</a>   <a  class=link href="/ProjetoFinal/Servlet?classe=FuncionarioControl&acao=sair&destino=index02.html">[ LOGOUT ]</a>
</center>

</body>
</html>