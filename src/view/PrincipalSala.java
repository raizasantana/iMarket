package view;

import java.sql.SQLException;

import dao.SalaDao;
import model.Sala;

public class PrincipalSala {

	public static void main(String[] args) {
	
		Sala s = new Sala();
		
		s.setId(3);
		s.setNome("London");
		s.setQtdCadeiras(50);
		
		SalaDao sDao = new SalaDao();
		
		try {
			sDao.adicionarSala(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
