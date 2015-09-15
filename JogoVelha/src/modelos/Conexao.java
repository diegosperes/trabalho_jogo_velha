package modelos;

import java.sql.*;

public class Conexao {

	Connection conexao;

	public Conexao() {
		try {
			this.verificaBD();
			// String do driver e conexão do mysql.
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/jogovelha";

			// Conecta no banco de dados
			Class.forName(myDriver);
			this.conexao = DriverManager.getConnection(myUrl, "root", "");
			this.verificaTabela();

		} catch (Exception e) {
			System.err.println("Alguma exceção! Conexao");
			System.err.println(e.getMessage());
		}
	}

	private void verificaBD() throws SQLException {
		// Verifica se o banco de dados existe, se não cria.
		
		Connection con = null;
		
		try {
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://localhost/";

			Class.forName(myDriver);
			con = DriverManager.getConnection(myUrl, "root", "");
			
			String query = "CREATE DATABASE IF NOT EXISTS jogovelha;";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

		} catch (Exception e) {
			System.err.println("Alguma exceção! verificaDB");
			System.err.println(e.getMessage());
		} finally {
			if(con != null){
				con.close();
			}
		}
		
	}

	private void verificaTabela() {
		// verifica se existe a tabela, se não cria.

		try {
			String query = "SELECT * FROM information_schema.TABLES WHERE TABLE_NAME = 'jogadas' AND (TABLE_SCHEMA = 'jogovelha');";
			Statement st = this.conexao.createStatement();
			ResultSet resultado = st.executeQuery(query);

			resultado.last();
			if (resultado.getRow() == 0) {
				String query_tabela = "CREATE TABLE jogadas(jogada varchar(255), acao varchar(255));";
				Statement stmt = this.conexao.createStatement();
				stmt.executeUpdate(query_tabela);
			}

		} catch (Exception e) {
			System.err.println("Alguma exceção! verificaTabela");
			System.err.println(e.getMessage());
		}
	}

	public Connection getConexao() {
		return this.conexao;
	}
}
