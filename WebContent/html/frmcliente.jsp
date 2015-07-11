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
<title>Registrar Cliente</title>
</head>
<body>


<!--
Barra Superior
-->
 <div id="menu-superior"  >
	
   <table cellpadding="3" cellspacing="0" border="0" onMouseDown="">
	<tr>
	<td colspan=10 height=35  width=300><a href="/ProjetoFinal/index02.html"> <img align=right src="/ProjetoFinal/img/iMarket-logo-2.0.png" width=60></a></td>
	<td width=60 align=center valign="middle" ><a class="ms-link" href="/ProjetoFinal/index02.html" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');">Home</a></td>
	<td width=180 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('i1');escondeDiv('f1');escondeDiv('s1');escondeDiv('c1');">Ingressos</a> </td>
	<td width=60 align=center valign="middle"><a class="ms-link" href="/ProjetoFinal/html/login.jsp" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');"> Login</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('s1');escondeDiv('f1');escondeDiv('i1');escondeDiv('c1');">Sess&otilde;es</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');" > Filmes</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');escondeDiv('c1');"> Carrinho</a> </td>
	<td width=100 align=center valign="middle"><a class="ms-link" href="#" onMouseOver="mostraDiv('c1');escondeDiv('f1');escondeDiv('s1');escondeDiv('i1');"> Cliente</a> </td>
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
	 
	 <div id="c1" class="menu-cliente" >
		<div class="shadow">
	<a href="/ProjetoFinal/html/frmcliente.jsp" class="ms-link">Registrar Cliente</a><br>
	<a href="/ProjetoFinal/html/clientebusca.jsp?destino=/html/clientebusca.jsp" class="ms-link">Buscar Cliente</a>
	<a href="/ProjetoFinal/html/clientebusca2.jsp" class="ms-link">Alterar dados do  Cliente</a>
	 </div></div>
	 
	
</div>

<!-- 
Inicio da Pagina
 -->

<c:if test="${cliente.id==null}"> <!-- Caso o cliente queira se cadastrar -->

<fieldset id="cadastro" onmousedown="escondeDiv('i1');escondeDiv('s1');escondeDiv('f1');escondeDiv('c1');">
<legend> [ Novo Cadastro ] </legend>
<form action="/ProjetoFinal/ServletCliente" method="get" onsubmit="return valida_enviar_Cliente(this)" id="frmcliente"  >
<input type="hidden" name="acao" value="adicionar"/>
NOME<br>
<input type="text" name="nome" id=nome onkeyup="valida_digitos('nome')" onblur="valida_campos('nome')" onFocus="informa('nome')" maxlength="45" size="45">
<div id=respostanome style="COLOR: red"></div>
<br><br>CPF<br>
<input type="text" name="cpf" id=cpf  onkeypress="valida_digitos('cpf')" onBlur="validar_CPF('cpf')"  onFocus="informa('cpf')" maxlength="11" size="11">
<div id=respostacpf style="COLOR: red"></div>
<br><br>EMAIL<br>
<input type="text" name="email" id=email onkeyup="valida_digitos('email')" onblur="valida_campos('email')" onFocus="informa('email')" maxlength="45" size="45">
<div id=respostaemail style="COLOR: red"></div>
<br><br>LOGIN<br>
<input type="text" name="login" id=login onkeyup="valida_digitos('login')" onblur="valida_campos('login')" onFocus="informa('login')" maxlength="10 size="10>
<div id=respostalogin style="COLOR: red"></div>
<br>

<br>SENHA<br>
<input type="password" name="senha" id=senha onblur="valida_campos('senha')" onFocus="informa('senha')" maxlength="10 size="10>
<div id=respostasenha style="COLOR: red"></div>
<br><br>

<input type="submit" value="Registrar Cliente" class="botao" ></input>
<input type="reset" value="Limpar Dados" class="botao"></input>

</form>
</fieldset>
</c:if>
<c:if test="${cliente.id!=null}"> <!--  Caso o cliente esteja alterando os dados -->
<fieldset id="cadastro" onmousedown="escondeDiv('i1');escondeDiv('s1');escondeDiv('f1');escondeDiv('c1');">
<legend> [ Altere seus dados ] </legend>
<form action="/ProjetoFinal/ServletCliente" method="get" onsubmit="return valida_enviar_Cliente(this)" id="frmcliente"  >
<input type="hidden" name="acao" value="atualizar"/>
ID<br><input type="text" name="id" value="${cliente.id}" readonly="readonly" size=2><br><br>
NOME<br>
<input type="text" name="nome2" id=nome2 value="${cliente.nome}" onkeyup="valida_digitos('nome')" onblur="valida_campos('nome')" onFocus="informa('nome')" maxlength="45" size="45">
<div id=respostanome style="COLOR: red"></div>
<br><br>CPF<br>
<input type="text" name="cpf2" id=cpf2 value="${cliente.cpf}" onkeypress="valida_digitos('cpf')" onBlur="validar_CPF('cpf')"  onFocus="informa('cpf')" maxlength="11" size="11">
<div id=respostacpf style="COLOR: red"></div>
<br><br>EMAIL<br>
<input type="text" name="email2" id=email2 value="${cliente.email}" onkeyup="valida_digitos('email')" onblur="valida_campos('email')" onFocus="informa('email')" maxlength="45" size="45">
<div id=respostaemail style="COLOR: red"></div>
<br><br>LOGIN<br>
<input type="text" name="login2" id=login2 value="${cliente.login}" onkeyup="valida_digitos('login')" onblur="valida_campos('login')" onFocus="informa('login')" maxlength="10 size="10>
<div id=respostalogin style="COLOR: red"></div>
<br>

<br>SENHA<br>
<input type="password" name="senha2" id=senha2 value="${cliente.senha}" onblur="valida_campos('senha')" onFocus="informa('senha')" maxlength="10 size="10>
<div id=respostasenha style="COLOR: red"></div>
<br><br>

<input type="submit" value="Alterar" class="botao" ></input>
<input type="reset" value="Limpar Dados" class="botao"></input>
<a class=botao href="/ProjetoFinal/ServletCliente?acao=remover&idcliente=${cliente.id}">Apagar Registro</a>
</form>
</fieldset>


</c:if>
</body>
</html>