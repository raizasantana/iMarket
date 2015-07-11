<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"><title>Gerenciador de Venda de Ingressos</title>
</head>

<body>

<c:if test="${funcionario.id==null}"> 
<%
        String redirectURL = "/ProjetoFinal/html/login.jsp";
        response.sendRedirect(redirectURL);
%>
</c:if>
<c:if test="${funcionario.id!=null}"> 
<%
        String redirectURL = "/ProjetoFinal/html/adm/restrito.jsp";
        response.sendRedirect(redirectURL);
%>
</c:if>


</body>
</html>