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
<title>Listar Ingressos</title>
</head>
<body>

 
<center><h3 >&Aacute;rea Restrita - Listar Ingressos</h3></center>

<fieldset id=area-restrita>
<form action="/ProjetoFinal/ServletIngresso" method="get" >
<input type="hidden" name="acao" value="listar"/>
<input type="hidden" name="destino" value="/html/ingressolista.jsp"/>
<table>
<tr>
<td>Clientes</td><td>
<select name="idcliente">
	<c:forEach var="clientes" items="${clientes}">
		<option value="${clientes.id}">${clientes.nome}</option>
	</c:forEach>
</select>

</td>
</tr>
</table>
	<input type="submit" value="Listar">
	
</form>

<c:if test="${clientes.id!=null }">
<table border="1" >
    <tr> 
      <td>Hora</td> <td>Filme</td> <td>Sala</td> <td> Cadeira </td> <td> Cliente </td> <td>Tipo</td>
    </tr>
   <c:forEach var="ingressos" items="${ingressos}">
   		<tr>
   		<td>${ingressos.sessao.horaIni }</td> <td>${ingressos.sessao.filme.nome }</td> <td>${ingressos.sessao.sala.nome }	<td>${ingressos.cadeira.nome} </td> <td>${ingressos.cliente.nome} </td><td>${ingressos.tipo.descricao }</td> 
   			
   		</tr>
   		  
   </c:forEach>
   </table>
   </c:if>
   
   <c:if test="${clientes.id==null }">
   <p>
   </p>
   </c:if>
</fieldset>

	<center>
        <a class=link href="/ProjetoFinal/html/adm/restrito.jsp">[ HOME ]</a>   <a  class=link href="/ProjetoFinal/Servlet?classe=FuncionarioControl&acao=sair&destino=index02.html">[ LOGOUT ]</a>
</center>






</body>
</html>