package views;

import java.util.Scanner;

import modelos.Jogada;

class main{
	
	static Scanner scanner = new Scanner(System.in); // Objeto que recebe a entrada do teclado
	static StringBuilder valor = new StringBuilder("");
	static boolean executa;
	
	 public static void main(String[] args){
		
		executaJogo();
		
		while(executa) {
			
			System.out.print("\r\n");
			
			imprimiTabuleiro();
			
			System.out.print("\r\n\r\nJogo atual: \r\n\r\n");
			
			imprimiJogo();
			
			recebeJogada();
			
			inteligenciaArtificial();
			
			verificaJogo();
			
		}
		
		if (!executa) {
			System.out.println("\r\nTermino de jogo!\r\n");
			imprimiJogo();
		}
		
		System.exit(0);
		
	}
	
	// Verifica se o programa foi executado acidentalmente ou não. -> "Deseja executar o jogo? (sim ou nao)
	public static void executaJogo() {
		
		valor.setLength(0);
		System.out.println("Deseja executar o jogo? (sim ou nao)");
		valor.append(scanner.nextLine());
		
		if(valor.toString().equals("sim")){
			valor.setLength(0);
			valor.append("---*---*---");
			executa = true;
		} else if(valor.toString().equals("nao")) {
			executa = false;
		} else {
			System.out.println("\r\nOpcao invalida, favor escolher uma opcao valida.\r\n");
			executaJogo();
		}
	}
	
	// Imprime o exemplo dos comandos utilizados no jogo.
	public static void imprimiTabuleiro() {
									  
		String tabuleiro = "123*456*789";
		
		System.out.println("Exemplo do tabuleiro com suas devidas posicoes.\r\n");
		
		for(int i = 0; i < tabuleiro.length(); i++) {
			if (tabuleiro.charAt(i) != '*') {
				System.out.print(tabuleiro.charAt(i));
				if (i != 2 && i != 6 && i != 10) {
					System.out.print(" |");
				}
			} else {
				System.out.println("\r\n___________");
			}
		}
		
	}
	
	
	// Imprime o jogo atual montando o tabuleiro do jogo.
	public static void imprimiJogo() {
		
		if (!valor.toString().equals("nao")) {
			for(int i = 0; i < valor.length(); i++) {
				if (valor.charAt(i) != '*' && valor.charAt(i) != ' ') {
					System.out.print(" ");
					if (valor.charAt(i) == '-') { 
						System.out.print(" ");
					} else {
						System.out.print(valor.charAt(i));
					}
					if (i != 2 && i != 6 && i != 10) {
						System.out.print(" |");
					}
				} else {
					System.out.println("\r\n___________");
				}
			}
		}
		System.out.print("\r\n");
	}
	
	// Recebe e verifica a jogada, verifica jogada repetida e fora do intervalo dos comandos estabelecidos.
	public static void recebeJogada() {
		boolean jogada_valida = false;
		String jogada;
		int _jogada;
		
		System.out.print("\r\nEscolha a sua jogada: ");
		
		jogada = scanner.nextLine();
		jogada = jogada.trim(); //.trim = tira o espaço do começo e do final da palavra
		
		if (jogada.equals("1") || jogada.equals("2") || jogada.equals("3") || jogada.equals("4") || jogada.equals("5") ||
			jogada.equals("6") || jogada.equals("7") || jogada.equals("8") || jogada.equals("9") ) {
			
			_jogada = Integer.parseInt(jogada);
			
			if (_jogada <= 3) {
				_jogada = _jogada - 1;
				
			} else if(_jogada > 6 && _jogada <= 9) {
				_jogada = _jogada + 1;
			} 
			
			if(valor.charAt(_jogada) == '-') {
				valor.setCharAt(_jogada, 'X');
				jogada_valida = true;
			} 
		}
		
		if (!jogada_valida) {
			System.out.println("\r\nMovimento invalido, favor tentar novamente.");
			recebeJogada();
		}
		
	}
	
	// Verifica se o jogo terminou, para sair do loop while.
	public static void verificaJogo() {
		
		if (valor.indexOf("-") == -1 || valor.indexOf("Q") != -1) { // indexOf = procura uma ocorrencia de uma string
			executa = false;
		}
		
	}
	
	public static void inteligenciaArtificial() {
		 Jogada jogada = new Jogada(); 
		 valor.setLength(0);
		 valor.append(jogada.getJogada(valor.toString()));		 
	}
}