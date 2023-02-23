package controle;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Pessoa;

public class PessoaDAO {

	private Conexao con;

	public boolean inserir(Pessoa p) {

		con = Conexao.getInstancia();

		Connection c = con.conectar();
		try {
			String query = "INSERT INTO (cpf,nome,senha) VALUES (?, ?, ?);";
			PreparedStatement stm = c.prepareStatement(query);
			stm.setLong(1, 123);
			stm.setString(2, "pratica01");
			stm.setString(3, "senha");

			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return false;
	}

	public boolean atualizar(Pessoa p) {
		con = Conexao.getInstancia();

		Connection c = con.conectar();

		try {
			String query = "UPDATE pessoa SET nome = ?, senha = ? WHERE cpf = ?";
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean deletar(Pessoa p) {
		return false;
	}

	public ArrayList listarPessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<>();

		con = Conexao.getInstancia();

		Connection c = con.conectar();

		try {
			Statement stm = c.createStatement();
			String query = "SELECT * FROM Pessoa";
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Long cpf = rs.getLong("cpf");
				String nome = rs.getString("nome");
				String senha = rs.getString("senha");
				Pessoa p = new Pessoa();
				p.setCpf(cpf);
				p.setNome(nome);
				p.setSenha(senha);
				pessoas.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		con.fecharConexao();
		return null;

	}

}