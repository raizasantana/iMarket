package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Cadeira;
import model.Cliente;
import model.Filme;
import model.Ingresso;
import model.Sessao;
import model.Tipo;
import model.TipoInteira;
import model.TipoMeia;

import dao.CadeiraDao;
import dao.ClienteDao;
import dao.FilmeDao;
import dao.SessaoDao;
import dao.TipoDao;

public class ComprarIngresso {

	public static void main(String[] args) {
		
		//Variaveis
		int idfilme,idsessao,idcadeira,idtipo,qtd;
		
		String cpf;
		
		ArrayList<Ingresso> ings = new ArrayList<Ingresso>();
		
		ArrayList<Tipo> tipos = new ArrayList<Tipo>();
		TipoDao tDao = new TipoDao();
		Tipo tipo = new Tipo();
		
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		FilmeDao fDao = new FilmeDao();
		Sessao ss = new Sessao();
		SessaoDao ssDao = new SessaoDao();
		ArrayList<Sessao> sessoes = new ArrayList<Sessao>();
		
		ArrayList<Cadeira> cadeiras = new ArrayList<Cadeira>();
		CadeiraDao cadDao = new CadeiraDao();
		Cadeira cad = new Cadeira();
		
		Cliente cli = new Cliente();
		ClienteDao cliDao = new ClienteDao();
		
		
		Scanner teclado = new Scanner(System.in);	
		
		//Inicio do Processo
		System.out.println("/ Comprar Ingresso / \n\n Escolha um filme:");
		
		//Listando os filmes
		System.out.println(" / Filmes Disponíveis /\n");
		try {
			filmes = fDao.getFilmes();
			for(int i=0; i< filmes.size(); i++)
				System.out.println("Titulo: " + filmes.get(i).getNome() + " Id: " + filmes.get(i).getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Escolhendo o filme
		System.out.println("\nDigite o Id do filme desejado: ");
		idfilme = teclado.nextInt();
		
		
		//Pegando as sessões do filme escolhido
		try {
			sessoes = ssDao.getSessoesFilme(idfilme);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Listando as sessoes disponiveis
		System.out.println("\n Sessões Disponíneis para o filme "); 
			for(int i=0; i < sessoes.size(); i++)
		System.out.println(" | Id: " + sessoes.get(i).getId() + " | Horario: " + sessoes.get(i).getHoraIni() + " | Data: " + sessoes.get(i).getData() + " | Sala : " + sessoes.get(i).getSala().getId() + " " + sessoes.get(i).getSala().getNome());
		
			//Escolhendo a sessao
			System.out.println("\n Informe o id a sessão que deseja assistir: ");
			idsessao = teclado.nextInt();
			
			try {
				tipos = tDao.getTipos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Escolhendo o tipo de ingresso
			System.out.println("Escolha o tipo do ingresso: ");
			for(int i = 0; i< tipos.size();i++)
				System.out.println("Id: " + tipos.get(i).getId() + " Tipo: " + tipos.get(i).getDescricao() + "Preço: " + tipos.get(i).getPreco());
			
			System.out.println("Informe o id do tipo de ingresso escolhido:");
			idtipo = teclado.nextInt();
			
			try {
				tipo = tDao.getTipo(idtipo);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Verificando a quantidade de ingressos
			System.out.println("Informe a quantidade de ingressos que deseja comprar:");
			qtd = teclado.nextInt();
			
			
			//Vendo o preço dos ingressos [POLIMORFISMO]
			
			if(idtipo == 1){ //Meia
				TipoMeia tm = new TipoMeia();
				tipo = tm;
				
			}
			else{ //Inteira
				TipoInteira ti = new TipoInteira();
				tipo = ti;

			
			}
			
			//Pegando a sessão escolhida [PARA MOSTRAR AS CADEIRAS]
			try {
				ss = ssDao.getSessao(idsessao);
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				
			
			//Escolhendo as cadeiras da sessão
			
			for(int i=0; i < qtd; i++){
				
				//Preparando as cadeiras da sessão
				try {
					cadeiras = cadDao.getDisponiveis(ss);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				//Mostrando as cadeiras disponiveis
				System.out.println("\nCadeiras Disponíveis:");
				for(int j= 0; j < cadeiras.size();j++)
					System.out.println("Id Sessao: " + cadeiras.get(i).getId() + " Nome: " + cadeiras.get(i).getNome());

			System.out.println("\n Informe o id da cadeira desejada");
			idcadeira = teclado.nextInt();			
			
			//try {
			//	cadDao.reservarCadeira(idcadeira);
			//} catch (SQLException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
			//Pegando a cadeira
			try {
				cad = cadDao.getCadeira(idcadeira);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Montar os ingressos
			
			Ingresso ing = new Ingresso();
			ing.setId(i);
			ing.setSessao(ss);
			ing.setTipo(tipo);
			ing.setCadeira(cad);
		
			
			ings.add(ing);
			}//for
			
		//Identificando o cliente
			System.out.println("\nEntre com o numero do cpf do cliente: ");
			cpf = teclado.next();
			
			try {
				cli = cliDao.getCliente(cpf);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(cli.getNome());
			
			
			
			
	
			//Emitindo a nota fiscal
			System.out.println("\n\n");
			System.out.println("| iMarket |");
			System.out.println("Nota Fiscal");
			System.out.println("---------------------------------------------------");
			System.out.println("Filme: " + ss.getFilme().getNome());
			System.out.println(" Sala: " + ss.getSala().getNome());
			//System.out.println(" Tipo: "+ ing.);
			
	
			
			
			
			
			
			
			
		
		
		

	}

}
