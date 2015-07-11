<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="STYLESHEET" type="text/css" href="/ProjetoFinal/css/restrita.css">
	<script type="text/javascript" src="/ProjetoFinal/js/funcoes.js"></script>
	<link rel="shortcut icon" href="/ProjetoFinal/img/icone.ico"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Funcionario</title>
</head>
<body>

<fieldset id=area-restrita>
	<form action="/ProjetoFinal/Servlet" method="get">
		Informe a matricula do funcionario: <input type="text" name="matricula"> <br></br>
		<input type="hidden" name="acao" value="alterar">
		<input type="hidden" name="classe" value="FuncionarioControl">
		
		<input type="submit">
	</form>
	
<c:if test="${funcionario.id==null}">
<p>
</c:if>

<c:if test="${funcionario.id!=null}">
<table border="1" >
    <tr> 
       <td> Nome </td> <td> Matricula </td><td>Login</td> <td>Senha</td>
    </tr>
   
   		<tr>
   			<td>${funcionario.nome} </td> <td>${funcionario.matricula} </td> <td>${funcionario.login}</td><td>${funcionario.senha}</td>
   			
   		</tr> 
   		  
   
   </table>
</c:if>
</fieldset>
	
</body>
</html>