package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jogada {
	
	private Connection conexao;

	public Jogada() {
		Conexao conecao = new Conexao();
		this.conexao = conecao.getConexao();
	}
	
	public String getJogada(String jogada) {
		String acao = "";

		try {
			// Query de consulta das jogadas
			String query = "SELECT acao FROM jogadas WHERE jogada='" + jogada + "'";

			// Realiza a consulta ao banco
			Statement st = this.conexao.createStatement();
			ResultSet resultado = st.executeQuery(query);

			// Atribui o primeiro resultado
			if(resultado.next()){
				resultado.first();
				acao = resultado.getString("acao");
			}

			st.close();

		} catch (Exception e) {
			System.err.println("Alguma exceção! getJogada");
			System.err.println(e.getMessage());
		}

		return acao;
	}
	
	public void setJogada(String jogada, String acao) {

		try {
			// Query de consulta das jogadas
			String query = "INSERT INTO jogadas (jogada, acao) VALUES (?, ?);";

			// Realiza a consulta ao banco
			PreparedStatement stmt = this.conexao.prepareStatement(query);
			stmt.setString (1, jogada);
			stmt.setString (2, acao);
			stmt.execute();

		} catch (Exception e) {
			System.err.println("Alguma exceção! setJogada");
			System.err.println(e.getMessage());
		}

	}
}
