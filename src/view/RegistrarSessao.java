package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import util.ConverteData;

import dao.FilmeDao;
import dao.SalaDao;
import dao.SessaoDao;
import model.Filme;
import model.Sala;
import model.Sessao;

public class RegistrarSessao {

	public static void main(String[] args) throws Exception {
		
		Sessao s = new Sessao();
		Sala sa = new Sala();
		Filme fi = new Filme();
		Scanner teclado = new Scanner(System.in);		
		
		//Seguindo o Diagrama de Use Case [LISTANDO AS SALAS DISPONIVEIS]
		SalaDao sDao = new SalaDao();
		ArrayList<Sala> salas = new ArrayList<Sala>();
		
		try {
			salas = sDao.getSalas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(" / Salas Disponíveis / ");
		for(int i = 0; i < salas.size(); i++)
			System.out.println("Id: " + salas.get(i).getId() + " | Nome: " + salas.get(i).getNome() + " | Capacidade máx.: " + salas.get(i).getQtdCadeiras() );
		
		System.out.println("\nInforme o Id da sala desejada: ");
		try {
			sa = sDao.getSala(teclado.nextInt());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//Add a sala à sessão:		
		s.setSala(sa);
		System.out.println("Sala escolhida: " + sa.getNome());
		
		
		//LISTANDO OS FILMES DISPONIVEIS
		FilmeDao fDao = new FilmeDao();
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		try {
			filmes = fDao.getFilmes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("\n / Filmes Disponiveis /  ");
		for(int i = 0 ; i < filmes.size(); i++)
			System.out.println("Id: " + filmes.get(i).getId() + " | Nome: " + filmes.get(i).getNome());
		
		System.out.println("\nInforme o Id do filme desejado:");
		
		try {
			fi = fDao.getFilme(teclado.nextInt());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Add o filme à sessao
		s.setFilme(fi);
		System.out.println("Filme Escolhido: " + s.getFilme().getNome());
		
		//Add o restante dos dados da sessão
		
		System.out.println("Informe a data da sessão: ");
		s.setData(ConverteData.strToDate(teclado.next()));
		
		System.out.println("Informe a hora da sessão: ");
		s.setHoraIni(teclado.next());
		
		System.out.println("Informe o id da sessão: ");
		s.setId(teclado.nextInt());
		
		System.out.println("/ Sessão Montada /");
		System.out.println("ID: " + s.getId());
		System.out.println("SALA: " + s.getSala().getNome());
		System.out.println("FILME: " + s.getFilme().getNome());
		System.out.println("DATA: " + s.getData());
		System.out.println("HORA: " + s.getHoraIni());
		
		SessaoDao sessaoDao = new SessaoDao();
		
		try {
			sessaoDao.adicionarSessao(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

	}

}
