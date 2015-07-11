package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConexao(){
		
	  try {

			Class.forName("com.mysql.jdbc.Driver");
//		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  try {   
			//return DriverManager.getConnection("jdbc:mysql://mysql1.hostingjava.it/main.php","useruntitled","projetofinal");
			return DriverManager.getConnection("jdbc:mysql://localhost/gvi","root","root");
		  //return DriverManager.getConnection("jdbc:mysql://s43.eatj.com/useruntitled","useruntitled","projetofinal");
		  
		//return DriverManager.getConnection("jdbc:postgresql://localhost/gvi","postgres","root");
		//return DriverManager.getConnection("jdbc:postgresql://localhost/gvi","postgres","Ej226123");
	} catch (SQLException e) {
		
		e.printStackTrace();
		return null;
	}
		
	}
}
