package questao8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ex8 {

public static void main(String[] args) {

	
Connection conexao;
final String USER = "root";
final String PSW = "aluno";


try {
conexao = DriverManager.getConnection("jdbc:mysql://localhost/", USER, PSW);

Statement stm = conexao.createStatement();

String WSQL = "create database Safira;";
stm.executeUpdate(WSQL);


WSQL = "use pessoa;";
stm.executeUpdate(WSQL);

WSQL = "create table Pessoa (safira_id BIGINT(12) NOT NULL, nome VARCHAR(45) NOT NULL, password VARCHAR(45) NOT NULL, PRIMARY KEY (safira_id));";
stm.executeUpdate(WSQL);


} catch (SQLException e) {
e.printStackTrace();
}

}

}