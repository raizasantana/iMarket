
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
<title>Listar Cadeiras</title>
</head>
<body>
 
<center><h3 >&Aacute;rea Restrita - Listar Cadeiras</h3></center>

<fieldset id=area-restrita>
<form action="/ProjetoFinal/ServletCadeira" method="get" >
		
		Selecione uma sala:<select name="idSala">
	<c:forEach var="salas" items="${salas}">
		<option value="${salas.id}">${salas.nome}</option>
	</c:forEach>
</select><br>
<input type="hidden" name="acao" value="listar">
	<input type="submit" name="acao" value="Enviar Consulta">
	</form>
	
</fieldset>	
	
	<center>
        <a class=link href="/ProjetoFinal/html/adm/restrito.jsp">[ HOME ]</a>   <a  class=link href="/ProjetoFinal/Servlet?classe=FuncionarioControl&acao=sair&destino=index02.html">[ LOGOUT ]</a>
</center>

<br><br><br>
<%/*
<table border="1" >
    <tr> 
       <td>Nome </td> 
    </tr>
   <c:forEach var="cadeiras" items="${cadeiras} " >
   		<tr>
   			<td>${cadeiras.nome} </td>
   			
   		</tr>
   		  
   </c:forEach>
   </table>
   
   */
  %>
  
  
  <table border="1" >
     <tr>   
 
 <c:forEach var="cadeiras" items="${cadeiras}" varStatus="cont">
 <td>    



<center> 
     <p align="center"><a href="/ProjetoFinal/index02.html">${cadeiras.nome}${cadeiras.numero} <br><img src=/ProjetoFinal/img/cadeiraocupada.png> </a></p>
</center>
 

</td>

  <c:if test="${cont.count % (cadeiras.sala.qtdCadeiras/cadeiras.sala.qtdFileiras) == 0}">
         <%out.print("</tr><tr>"); %> 
         </c:if>    
</c:forEach>
</tr>   
</table>
  



</body>
</html>