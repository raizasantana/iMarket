function mostraDiv(id)
{
cam = document.getElementById(id);
cam.style.visibility = 'visible';

}

function escondeDiv(id){
	cam = document.getElementById(id);
	cam.style.visibility = 'hidden';
}


	

function valida_campos(Ncampo)

{   
		//de acordo com o campo a var recebe uma express�o regular que vai validar o campo 
			if(Ncampo=="senha")
				var er =/^\w{3,10}$/;
			
			if(Ncampo=="nome" || Ncampo=="login")
				var er=/[a-zA-Z]{3,}/;
			if(Ncampo=="email")
				  var er=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
				
			 b=document.getElementById(Ncampo).value;
			if(b != "")
			{ 
				if(!er.test(b))
				{	
					return erro(Ncampo);			
				}		
				//se Ncampo passar na ER, ent�o � feita a formata��o do campo CEP = xxxxx-xxx
				else
				{	
					return ok(Ncampo);					
				}
			}
			document.getElementById(Ncampo).style.background="#FFFFFF";
	 		document.getElementById('resposta'+Ncampo).innerHTML="";
			
} 
function informa(Ncampo)
{
var campo=document.getElementById('resposta'+Ncampo);
	if(Ncampo == 'nome')
	{
		campo.innerHTML="Informe um nome .";
	}
	if(Ncampo == 'descricao')
	{
		campo.innerHTML="Informe a descri��o do tipo de ingresso.";
	}
	if(Ncampo == 'qtdCadeiras')
	{
		campo.innerHTML="Informe a quantidade de cadeiras.";
	}
	if(Ncampo == 'qtdFileiras')
	{
		campo.innerHTML="Informe a quantidade de fileiras.";
	}
	if(Ncampo == 'preco')
	{
		campo.innerHTML="Informe o pre�o do ingresso.";
	}
	if(Ncampo == 'cpf')
	{
		campo.innerHTML="Somente numeros, 11 digitos";
	}	
	if(Ncampo == 'censura')
	{
		campo.innerHTML="Somente numeros, informe a idade m�nima.";
	}	
	if(Ncampo == 'duracao')
	{
		campo.innerHTML="Somente numeros, dura��o do filme em minutos.";
	}	
	if(Ncampo == 'login')
	{
		campo.innerHTML="Informe um login com minimo 3 caracteres.";
	}
	if(Ncampo == 'senha')
	{
		campo.innerHTML="Informe senha de 3 a 6 caracteres";
	}
	if(Ncampo == 'email'){
		campo.innerHTML="Informe o e-mail";
	}
	if(Ncampo == 'matricula' || Ncampo == 'dataIni' || Ncampo == 'dataFin' || Ncampo == 'data' || Ncampo == 'horaIni' || Ncampo == 'numero')
	{
		campo.innerHTML="Somente numeros.";
	}
	
}

//fun��o que restringe caracteres digitados. N�meros ou letras
function valida_digitos(Ncampo)
{
		 //caracteres permitidos
		 if(Ncampo=="nome" || Ncampo=="login" || Ncampo=="senha" || Ncampo=="email" || Ncampo=="descricao")
		 er=/[0-9]/;		 
		 if( Ncampo=="cpf" || Ncampo=="duracao" || Ncampo=="dataIni" || Ncampo=="dataFin" ||  Ncampo=="data" || Ncampo=="horaIni"  || Ncampo=="censura" || Ncampo == 'numero' || Ncampo=="preco" || Ncampo=="qtdFileiras" || Ncampo=="qtdCadeiras" || Ncampo=="matricula")
		 er=/[a-z]/;		 
		 digito=document.getElementById(Ncampo).value;
		 var tempor;
		 
		  for (var i=0;i<digito.length; i++) {
			tempor = digito.substring(i,i+1); 
			//se os digitos n�o forem iguais aos caracteres digitados na variavel digitos, s�o deletados
			  if (er.test(digito)) {
			  document.getElementById(Ncampo).value=digito.substring(0,digito.length-1);
			 
			 return false;
			  break;
    		}
   		}
 }
function ok(Ncampo)
{
	document.getElementById(Ncampo).style.background="#98EE84";
	document.getElementById('resposta'+Ncampo).innerHTML="";
	return true;
}

function erro(Ncampo)
{
	
	if(Ncampo == 'nome')
		resposta="Nome inv�lido";
	if(Ncampo=="cpf")
		resposta="N�mero de CPF inv�lido";
	if(Ncampo == 'login')
		resposta="Login inv�lido";
	if(Ncampo == 'senha')
		resposta="Senha invalida";
	if(Ncampo == 'email')
		resposta="Email inv�lido";
	
	document.getElementById('resposta'+Ncampo).innerHTML="informe " + Ncampo;
	document.getElementById(Ncampo).style.background="red";
	
	document.getElementById(Ncampo).focus();
	return false;
}
//fun��o que � chamada no submit, valida os campos em geral, veificandos se est�o vazios e os bot�es de radio e checkbox
function valida_enviar_Sessao(campo){
	
	
	a=document.getElementById(campo);
	b=document.getElementById;
	var conta=0;
	campos=new Array('data','horaIni');
	for(i=0;i<campos.length;i++)
	{	
				
		if(document.getElementById(campos[i]).value=="")
		{
			document.getElementById('resposta'+campos[i]).innerHTML="Informe "+campos[i];
			conta++;
		}
			
	}			
		if(conta==0)
			return true;
			else
			return false;
	
}	

function valida_enviar_Funcionario(campo){
	
	
	a=document.getElementById(campo);
	b=document.getElementById;
	var conta=0;
	campos=new Array('nome','matricula','login','senha');
	for(i=0;i<campos.length;i++)
	{	
				
		if(document.getElementById(campos[i]).value=="")
		{
			document.getElementById('resposta'+campos[i]).innerHTML="Informe "+campos[i];
			conta++;
		}
			
	}			
		if(conta==0)
			return true;
			else
			return false;
	
}
function valida_enviar_Tipo(campo){
	
	
	a=document.getElementById(campo);
	b=document.getElementById;
	var conta=0;
	campos=new Array('descricao','preco');
	for(i=0;i<campos.length;i++)
	{	
				
		if(document.getElementById(campos[i]).value=="")
		{
			document.getElementById('resposta'+campos[i]).innerHTML="Informe "+campos[i];
			conta++;
		}
			
	}			
		if(conta==0)
			return true;
			else
			return false;
	
}
	
//Fun��o que � chamada no submit do frmfilme, valida os campos em geral, veificandos se est�o vazios 
function valida_enviar_Filme(campo){
	a=document.getElementById(campo);
	b=document.getElementById;
	var conta=0;
	campos=new Array('nome','censura','duracao','sinopse','dataIni','dataFin');
	for(i=0;i<campos.length;i++)
	{	
		
		if(document.getElementById(campos[i]).value=="")
		{
			document.getElementById('resposta'+campos[i]).innerHTML="Informe "+campos[i];
			conta++;
		}
			
	}			
	
			if(conta==0)
			return true;
			else
			return false;
	
}	
	

//fun��o que � chamada no submit d frmcliete, valida os campos em geral, veificandos se est�o vazios 
function valida_enviar_Cliente(campo){
	
	
	a=document.getElementById(campo);
	b=document.getElementById;
	var conta=0;
	campos=new Array('nome','cpf','email','login','senha');
	for(i=0;i<campos.length;i++)
	{	
		
		if(campos[i]=='email')
		{
			var er=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/
			if(!er.test(document.getElementById(campos[i]).value))
			{
				document.getElementById('resposta'+campos[i]).innerHTML="Informe o e-mail correto";
				conta++;
			}
		}
		
		if(document.getElementById(campos[i]).value=="")
		{
			document.getElementById('resposta'+campos[i]).innerHTML="Informe "+campos[i];
			conta++;
		}
			
	}			
	
			if(conta==0)
			return true;
			else
			return false;
	
}	
	
//fun��o que � chamada no submit, valida os campos em geral, veificandos se est�o vazios e os bot�es de radio e checkbox
function valida_enviar_Sala(campo){
	
	
	a=document.getElementById(campo);
	b=document.getElementById;
	var conta=0;
	campos=new Array('nome','qtdCadeiras','qtdFileiras');
	for(i=0;i<campos.length;i++)
	{	
				
		if(document.getElementById(campos[i]).value=="")
		{
			document.getElementById('resposta'+campos[i]).innerHTML="Informe "+campos[i];
			conta++;
		}
			
	}			
		if(conta==0)
			return true;
			else
			return false;
	
}

//Fun��o que valida, data pelo formato xx/xx/xxxx e verifica se a data existe
function validar_Data(Ncampo){

var er = /^(([0-2]\d|[3][0-1])\/([0]\d|[1][0-2])\/[1-2][0-9]\d{2})$/;
b=document.getElementById(Ncampo).value;
document.getElementById(Ncampo).style.background="#FFFFFF";
document.getElementById('resposta'+Ncampo).innerHTML="";
if(b!=""){
if(er.test(b)){

var dia = b.substring(0,2);
var mes = b.substring(3,5);
var ano = b.substring(6,10);
	
	if(ano < 1900)
	{
		alert("O ano especificado n�o � valido");
		document.getElementById(Ncampo).style.background="red";
		document.getElementById(Ncampo).focus();
		return false;
	}
	
		if((mes==04 || mes==06 || mes==09 || mes==11) && (dia > 30)){
			document.getElementById(Ncampo).style.background="red";
			alert("O m�s especificado cont�m no m�ximo 30 dias");
			document.getElementById(Ncampo).focus();
			return false;
		} else
		{
		if(ano%4!=0 && mes==02 && dia>28){
			document.getElementById(Ncampo).style.background="red";
			alert("Data incorreta!! O m�s especificado cont�m no m�ximo 28 dias.");
			document.getElementById(Ncampo).focus();
			return false;
		} else{
		if(ano%4==0 && mes==02 && dia>29){
			document.getElementById(Ncampo).style.background="red";
			alert("Data incorreta!! O m�s especificado cont�m no m�ximo 29 dias");
			document.getElementById(Ncampo).focus();
			return false;
		} else{ 
		
		return ok(Ncampo);
		}}}} else {
			document.getElementById(Ncampo).style.background="red";
			
			document.getElementById('resposta'+Ncampo).innerHTML="Formato inv�lido de data";
			document.getElementById(Ncampo).focus();
			return false;
		}
		}
		document.getElementById(Ncampo).style.background="#FFFFFF";
		document.getElementById('resposta'+Ncampo).innerHTML="";
}

//Fun��o que valida o cpf
function validar_CPF(Ncampo)   
{   	
		erro = new String;   
  		cpf=document.getElementById(Ncampo);
        if (cpf.value.length == 14)   
   		 {     
				cpf.value = cpf.value.replace('.', '');   
				cpf.value = cpf.value.replace('.', '');   
				cpf.value = cpf.value.replace('-', ''); 
	  
				var nonNumbers = /\D/;   
				
				if (nonNumbers.test(cpf.value))   
				{   
						erro = "A verificacao de CPF suporta apenas n�meros!";   
				}   
				else   
				{   
						if (cpf.value == "00000000000" ||   
								cpf.value == "11111111111" ||   
								cpf.value == "22222222222" ||   
								cpf.value == "33333333333" ||   
								cpf.value == "44444444444" ||   
								cpf.value == "55555555555" ||   
								cpf.value == "66666666666" ||   
								cpf.value == "77777777777" ||   
								cpf.value == "88888888888" ||   
								cpf.value == "99999999999") {   
								   
								erro = "N�mero de CPF inv�lido !";   
								
						}   
						
						
						var a = [];   
						var b = new Number;   
						var c = 11;   
	  
						for (i=0; i<11; i++){   
								a[i] = cpf.value.charAt(i);   
								if (i < 9) b += (a[i] * --c);   
						}   
		   
						if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11-x }   
						b = 0;   
						c = 11;   
		   
						for (y=0; y<10; y++) b += (a[y] * c--);   
		   
						if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11-x; }   
		   
						if ((cpf.value.charAt(9) != a[9]) || (cpf.value.charAt(10) != a[10])) {   
							erro = "N�mero de CPF inv�lido.";  
							
						}   
				}   
		}   
		else   
		{   
			if(cpf.value.length == 0)  
			{
				document.getElementById('resposta'+Ncampo).innerHTML="";
				document.getElementById(Ncampo).style.background="#FFFFFF"; 
				return false;   
			}
			else   
				erro = "N�mero de CPF inv�lido.";   
		}   
		if (erro.length > 0) {   
				alert(erro);   

				if (cpf.value.length == 11)   
				{     
					str = cpf.value;
					str2 = cpf.value.substring(0,3);
					str3 = cpf.value.substring(3,6);
					str4 = cpf.value.substring(6,9);
					str5 = cpf.value.substring(9,12);
					result=str.replace(str,str2+'.');
					result2=str.replace(str,str3+'.');
					result3=str.replace(str,str4+'-');
					document.getElementById(Ncampo).value = result + result2 + result3 + str5;
					document.getElementById(Ncampo).style.background="red";
					document.getElementById(Ncampo).focus(); 
					return false;   
				}				
			
				document.getElementById(Ncampo).value = cpf.value;
				document.getElementById(Ncampo).style.background="red";
				document.getElementById(Ncampo).focus(); 
				return false;   
		}     
		document.getElementById(Ncampo).style.background="#98EE84";
		document.getElementById('resposta'+Ncampo).innerHTML="";
		str = cpf.value;
		str2 = cpf.value.substring(0,3);
		str3 = cpf.value.substring(3,6);
		str4 = cpf.value.substring(6,9);
		str5 = cpf.value.substring(9,12);
		result=str.replace(str,str2+'.');
		result2=str.replace(str,str3+'.');
		result3=str.replace(str,str4+'-');
		document.getElementById(Ncampo).value = result + result2 + result3 + str5;
		return true;       
} 

//validar hh/mm/ss
function validar_hora(campo){
	hora = document.getElementById(campo);
	var conta=0;
	
	if(hora.value.length == 0){
		document.getElementById('resposta'+Ncampo).innerHTML="";
		document.getElementById(Ncampo).style.background="#FFFFFF"; 
		return false; 
	}
	else{
			if(hora.value.length > 8){
				hora.style.background="red";
				hora.focus();
				alert("Hora invalida!");
				return false;
			}
	
	else{
		if(hora.value.length == 8){
			h1 = hora.value.charAt[0];
			h2 = hora.value.charAt[1];
			m1 = hora.value.charAt[3];
			m2 = hora.value.charAt[4];
			s1 = hora.value.charAt[6];
			s2 = hora.value.charAt[7];
			
				if ((h1 > 2) || (m1 >6) || (s1>6)){
					hora.style.background="red";
					hora.focus();
					alert("Hora invalida!");
					return false;
				} else 
					return true;
				
		}
		
		if(hora.value.length == 6){
			h1 = hora.value.charAt[0];
			h2 = hora.value.charAt[1];
			m1 = hora.value.charAt[2];
			m2 = hora.value.charAt[3];
			s1 = hora.value.charAt[4];
			s2 = hora.value.charAt[5];
				
				if ((h1 > 2) || (m1 > 6) || (s1>6)){
					hora.style.background="red";
					hora.focus();
					alert("Hora invalida!");
					return false;
				}
				else 
					return true;
				
		}
	}
	}
	
	if(conta != 0){
		alert("Hora invalida!");
		return false;
	} else return true;
}
	
