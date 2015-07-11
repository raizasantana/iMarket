package view;


import java.sql.SQLException;
import java.util.ArrayList;

import dao.FilmeDao;
import model.Filme;

public class PrincipalFilme {


	public static void main(String[] args) {
		
		Filme f = new Filme();
		
		//idfilme,nome,censura,sinopse,dataini,datafin,duracao
		f.setId(3);
		f.setNome("HP7");
		f.setCensura(15);
		f.setSinopse("Lord W. está chegando!!");
		f.setDataIni("25/09/2011");
		f.setDataFin("15/12/2011");
		f.setDuracao(168);
		
		
		FilmeDao fDao = new FilmeDao();
		
		try {
			fDao.adicionarFilme(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FilmeDao fDao2 = new FilmeDao();
		
		try {
			Filme fil = fDao2.getFilme(2);
			System.out.println(fil.getNome() + fil.getDuracao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FilmeDao fDao3 = new FilmeDao();
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		try {
			filmes = fDao3.getFilmes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i< filmes.size() ; i++)
			System.out.println(filmes.get(i).getNome());
		
		
		
		
		
		
		

	}

}
