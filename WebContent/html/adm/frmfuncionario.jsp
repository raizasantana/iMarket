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
<title>Registrar Funcionario</title>
</head>
<body>


<center><h3 >&Aacute;rea Restrita - Registro de Funcionario</h3></center>

<c:if test="${funcionario.id==null}"> <!-- Caso o funcionario queira se cadastrar -->



<fieldset id="area-restrita" onmousedown="escondeDiv('i1');escondeDiv('s1');escondeDiv('f1');escondeDiv('c1');">
<form action="/ProjetoFinal/Servlet" method="get" onsubmit="return valida_enviar_Funcionario(this)" id="frmcliente"  >
<input type="hidden" name="acao" value="adicionar"/>
<input type="hidden" name="destino" value="/html/adm/restrito.jsp"/>
<input type="hidden" name="classe" value="FuncionarioControl"/>
NOME<br>
<input type="text" name="nome" id=nome onkeyup="valida_digitos('nome')" onblur="valida_campos('nome')" onFocus="informa('nome')" maxlength="45" size="45">
<div id=respostanome style="COLOR: red"></div>
<br><br>MATRICULA<br>
<input type="text" name="matricula" id=matricula  onkeypress="valida_digitos('matricula')" onBlur="validar_campos('matricula')"  onFocus="informa('matricula')" maxlength="11" size="11">
<div id=respostamatricula style="COLOR: red"></div>
<br><br>LOGIN<br>
<input type="text" name="login" id=login onkeyup="valida_digitos('login')" onblur="valida_campos('login')" onFocus="informa('login')" maxlength="10 size="10>
<div id=respostalogin style="COLOR: red"></div>
<br>
<br>SENHA<br>
<input type="password" name="senha" id=senha onblur="valida_campos('senha')" onFocus="informa('senha')" maxlength="10 size="10>
<div id=respostasenha style="COLOR: red"></div>
<br><br>

<input type="submit" value="Registrar Funcionario" class=link ></input>
<input type="reset" value="Limpar Dados" class=link></input>

</form>
</fieldset>
</c:if>


<c:if test="${funcionario.id!=null}"> <!--  Caso o funcionario esteja alterando os dados -->
<fieldset id="area-restrita" onmousedown="escondeDiv('i1');escondeDiv('s1');escondeDiv('f1');escondeDiv('c1');">
<form action="/ProjetoFinal/Servlet" method="get" onsubmit="return valida_enviar_Funcionario(this)"  >
<input type="hidden" name="acao" value="atualizar"/>
<input type="hidden" name="classe" value="FuncionarioControl"/>
ID<br><input type="text" name="id" value="${funcionario.id}" readonly="readonly" size=2><br><br>
NOME<br>
<input type="text" name="nome2" id=nome2 value="${funcionario.nome}" onkeyup="valida_digitos('nome2')" onblur="valida_campos('nome2')" onFocus="informa('nome2')" maxlength="45" size="45">
<div id=respostanome style="COLOR: red"></div>
<br><br>MATRICULA<br>
<input type="text" name="matricula2" id=matricula2 value="${funcionario.matricula}" onkeyup="valida_digitos('matricula2')" onblur="valida_campos('matriculal2')" onFocus="informa('matricula2')" maxlength="45" size="45">
<div id=respostaemail style="COLOR: red"></div>
<br><br>LOGIN<br>
<input type="text" name="login2" id=login2 value="${funcionario.login}" onkeyup="valida_digitos('login2')" onblur="valida_campos('login2')" onFocus="informa('login2')" maxlength="10 size="10>
<div id=respostalogin style="COLOR: red"></div>
<br>

<br>SENHA<br>
<input type="password" name="senha2" id=senha2 value="${funcionario.senha}" onblur="valida_campos('senha2')" onFocus="informa('senha2')" maxlength="10 size="10>
<div id=respostasenha style="COLOR: red"></div>
<br><br>

<input type="submit" value="Alterar" class="botao" ></input>
<input type="reset" value="Limpar Dados" class="botao"></input>
<center>
<a class=link href="/ProjetoFinal/ServletCliente?acao=remover&idcliente=${funcionarioe.id}">Apagar Registro</a>
</center>
</form>
</fieldset>


</c:if>
</body>
</html>