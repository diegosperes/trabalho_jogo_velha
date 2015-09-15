package scripts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import modelos.Jogada;

public class PopulaMySQL {

	static Jogada jogada = new Jogada();
	
	public static void main(String[] args) throws IOException {
		String path = "../";
		String arquivo_jogada = path + "jogada_database.txt";
		String arquivo_acao = path + "acao_database.txt";

		BufferedReader reader_jogada = null;
		BufferedReader reader_acao = null;

		try {
			reader_jogada = new BufferedReader(new FileReader(arquivo_jogada));
			String linha_jogada = null;

			reader_acao = new BufferedReader(new FileReader(arquivo_acao));
			String linha_acao = null;
			
			while (((linha_jogada = reader_jogada.readLine()) != null) && ((linha_acao = reader_acao.readLine()) != null)) {
				jogada.setJogada(linha_jogada, linha_acao);
			}
			
			System.out.println("Executado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader_jogada != null) {
				reader_jogada.close();
			}
			if (reader_acao != null) {
				reader_acao.close();
			}
		}
	}

}
