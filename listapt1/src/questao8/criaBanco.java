package questao8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class criaBanco {
	private Connection conexao;
	private static criaBanco instancia;
	private final String DATABASE = "danganronpa";
	private final String USER = "root";
	private final String PSW = "aluno";
	
	private criaBanco() {}
	
	public static criaBanco getInstancia() {
		if(instancia == null) {
			instancia = new criaBanco();
		}
	return instancia;
	}
	
	public Connection conectar() {
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ DATABASE + "?serverTimeZone=UTC",USER,PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	return conexao;
	
	}
	public boolean fecharConexao() {
		
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	public static void main(String[] args) {
	
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/"+ DATABASE + "?serverTimeZone=UTC",USER,PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		 
	}

}
