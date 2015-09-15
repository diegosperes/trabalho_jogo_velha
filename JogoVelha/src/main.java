import java.util.Scanner;

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
		
		boolean jogada = true;
		
		 if ( valor.toString().equals("X--*---*---") && jogada ) { valor.setLength(0); valor.append("X--*-O-*---"); jogada = false;} //1*		 
		 if ( valor.toString().equals("-X-*---*---") && jogada ) { valor.setLength(0); valor.append("-X-*-O-*---"); jogada = false;} //2*
		 if ( valor.toString().equals("--X*---*---") && jogada ) { valor.setLength(0); valor.append("--X*-O-*---"); jogada = false;} //3*
		 if ( valor.toString().equals("---*X--*---") && jogada ) { valor.setLength(0); valor.append("---*XO-*---"); jogada = false;} //4*
		 if ( valor.toString().equals("---*-X-*---") && jogada ) { valor.setLength(0); valor.append("---*-X-*--O"); jogada = false;} //5*
		 if ( valor.toString().equals("---*--X*---") && jogada ) { valor.setLength(0); valor.append("---*-OX*---"); jogada = false;} //6*
		 if ( valor.toString().equals("---*---*X--") && jogada ) { valor.setLength(0); valor.append("---*-O-*X--"); jogada = false;} //7*
		 if ( valor.toString().equals("---*---*-X-") && jogada ) { valor.setLength(0); valor.append("---*-O-*-X-"); jogada = false;} //8*
		 if ( valor.toString().equals("---*---*--X") && jogada ) { valor.setLength(0); valor.append("---*-O-*--X"); jogada = false;} //9*

		 // Respostas para as segunda e terceira jogadas

		 if ( valor.toString().equals("XX-*-O-*---") && jogada ) { valor.setLength(0); valor.append("XXO*-O-*---"); jogada = false;} //1,1*
		 if ( valor.toString().equals("X-X*-O-*---") && jogada ) { valor.setLength(0); valor.append("XOX*-O-*---"); jogada = false;} //1,2*
		 if ( valor.toString().equals("X--*XO-*---") && jogada ) { valor.setLength(0); valor.append("X--*XO-*O--"); jogada = false;} //1,3*
		 if ( valor.toString().equals("X--*-OX*---") && jogada ) { valor.setLength(0); valor.append("XO-*-OX*---"); jogada = false;} //1,4*
		 if ( valor.toString().equals("X--*-O-*X--") && jogada ) { valor.setLength(0); valor.append("X--*OO-*X--"); jogada = false;} //1,5*
		 if ( valor.toString().equals("X--*-O-*-X-") && jogada ) { valor.setLength(0); valor.append("X--*OO-*-X-"); jogada = false;} //1,6*
		 if ( valor.toString().equals("X--*-O-*--X") && jogada ) { valor.setLength(0); valor.append("X--*-OO*--X"); jogada = false;} //1,7*

		 if ( valor.toString().equals("XXO*XO-*---") && jogada ) { valor.setLength(0); valor.append("XXQ*XQ- Q--"); jogada = false;} //1,1,1
		 if ( valor.toString().equals("XXO*-OX*---") && jogada ) { valor.setLength(0); valor.append("XXQ*-QX Q--"); jogada = false;} //1,1,2
		 if ( valor.toString().equals("XXO*-O-*X--") && jogada ) { valor.setLength(0); valor.append("XXO*OO-*X--"); jogada = false;} //1,1,3*
		 if ( valor.toString().equals("XXO*-O-*-X-") && jogada ) { valor.setLength(0); valor.append("XXQ*-Q- QX-"); jogada = false;} //1,1,4
		 if ( valor.toString().equals("XXO*-O-*--X") && jogada ) { valor.setLength(0); valor.append("XXQ*-Q- Q-X"); jogada = false;} //1,1,5

		 if ( valor.toString().equals("XOX*XO-*---") && jogada ) { valor.setLength(0); valor.append("XQX*XQ-*-Q-"); jogada = false;} //1,2,1
		 if ( valor.toString().equals("XOX*-OX*---") && jogada ) { valor.setLength(0); valor.append("XQX*-QX*-Q-"); jogada = false;} //1,2,2
		 if ( valor.toString().equals("XOX*-O-*X--") && jogada ) { valor.setLength(0); valor.append("XQX*-Q-*XQ-"); jogada = false;} //1,2,3
		 if ( valor.toString().equals("XOX*-O-*-X-") && jogada ) { valor.setLength(0); valor.append("XOX*-OO*-X-"); jogada = false;} //1,2,4*
		 if ( valor.toString().equals("XOX*-O-*--X") && jogada ) { valor.setLength(0); valor.append("XQX*-Q-*-QX"); jogada = false;} //1,2,5

		 if ( valor.toString().equals("XX-*XO-*O--") && jogada ) { valor.setLength(0); valor.append("XXQ*XQ-*Q--"); jogada = false;} //1,3,1
		 if ( valor.toString().equals("X-X*XO-*O--") && jogada ) { valor.setLength(0); valor.append("XOX*XO-*O--"); jogada = false;} //1,3,2*
		 if ( valor.toString().equals("X--*XOX*O--") && jogada ) { valor.setLength(0); valor.append("X-Q*XQX*Q--"); jogada = false;} //1,3,3
		 if ( valor.toString().equals("X--*XOX*OX-") && jogada ) { valor.setLength(0); valor.append("X-Q*XQX*QX-"); jogada = false;} //1,3,4
		 if ( valor.toString().equals("X--*XO-*O-X") && jogada ) { valor.setLength(0); valor.append("X-Q*XQ-*Q-X"); jogada = false;} //1,3,5

		 if ( valor.toString().equals("XOx*-OX*---") && jogada ) { valor.setLength(0); valor.append("XQ-*XQX*-Q-"); jogada = false;} //1,4,1
		 if ( valor.toString().equals("XO-*XOX*---") && jogada ) { valor.setLength(0); valor.append("XQ-*XQX*-Q-"); jogada = false;} //1,4,2
		 if ( valor.toString().equals("XO-*-OX*X--") && jogada ) { valor.setLength(0); valor.append("XQ-*-QX*XQ-"); jogada = false;} //1,4,3
		 if ( valor.toString().equals("XO-*-OX*-X-") && jogada ) { valor.setLength(0); valor.append("XO-*-OX*OX-"); jogada = false;} //1,4,4*
		 if ( valor.toString().equals("XO-*-OX*--X") && jogada ) { valor.setLength(0); valor.append("XQ-*-QX*-QX"); jogada = false;} //1,4,5

		 if ( valor.toString().equals("XX-*OO-*X--") && jogada ) { valor.setLength(0); valor.append("XX-*QQQ*X--"); jogada = false;} //1,5,1
		 if ( valor.toString().equals("X-X*OO-*X--") && jogada ) { valor.setLength(0); valor.append("X-X*QQQ*X--"); jogada = false;} //1,5,2
		 if ( valor.toString().equals("X--*OOX*X--") && jogada ) { valor.setLength(0); valor.append("X--*OOX*XO-"); jogada = false;} //1,5,3*
		 if ( valor.toString().equals("X--*OO-*XX-") && jogada ) { valor.setLength(0); valor.append("X--*QQQ*XX-"); jogada = false;} //1,5,4
		 if ( valor.toString().equals("X--*OO-*X-X") && jogada ) { valor.setLength(0); valor.append("X--*QQQ*X-X"); jogada = false;} //1,5,5

		 if ( valor.toString().equals("XX-*OO-*-X-") && jogada ) { valor.setLength(0); valor.append("XX-*QQQ*-X-"); jogada = false;} //1,6,1
		 if ( valor.toString().equals("X-X*OO-*-X-") && jogada ) { valor.setLength(0); valor.append("X-X*QQQ*-X-"); jogada = false;} //1,6,2
		 if ( valor.toString().equals("X--*OOX*-X-") && jogada ) { valor.setLength(0); valor.append("X-O*OOX*-X-"); jogada = false;} //1,6,3*
		 if ( valor.toString().equals("X--*OO-*XX-") && jogada ) { valor.setLength(0); valor.append("X--*QQQ*XX-"); jogada = false;} //1,6,4
		 if ( valor.toString().equals("X--*OO-*-XX") && jogada ) { valor.setLength(0); valor.append("X--*QQQ*-XX"); jogada = false;} //1,6,5

		 if ( valor.toString().equals("XX-*-OO*--X") && jogada ) { valor.setLength(0); valor.append("XX-*QQQ*--X"); jogada = false;} //1,7,1
		 if ( valor.toString().equals("X-X*-OO*--X") && jogada ) { valor.setLength(0); valor.append("X-X*QQQ*--X"); jogada = false;} //1,7,2
		 if ( valor.toString().equals("X--*XOO*--X") && jogada ) { valor.setLength(0); valor.append("X--*XOO*O-X"); jogada = false;} //1,7,3*
		 if ( valor.toString().equals("X--*-OO*X-X") && jogada ) { valor.setLength(0); valor.append("X--*QQQ*X-X"); jogada = false;} //1,7,4
		 if ( valor.toString().equals("X--*-OO*-XX") && jogada ) { valor.setLength(0); valor.append("X--*QQQ*-XX"); jogada = false;} //1,7,5

		 if ( valor.toString().equals("-XX*-O-*---") && jogada ) { valor.setLength(0); valor.append("OXX*-O-*---"); jogada = false;} //2,1*
		 if ( valor.toString().equals("-X-*XO-*---") && jogada ) { valor.setLength(0); valor.append("OX-*XO-*---"); jogada = false;} //2,2*
		 if ( valor.toString().equals("-X-*-OX*---") && jogada ) { valor.setLength(0); valor.append("-XO*-OX*---"); jogada = false;} //2,3*
		 if ( valor.toString().equals("-X-*-O-*X--") && jogada ) { valor.setLength(0); valor.append("-X-*-OO*X--"); jogada = false;} //2,4*
		 if ( valor.toString().equals("-X-*-O-*-X-") && jogada ) { valor.setLength(0); valor.append("-X-*-O-*-XO"); jogada = false;} //2,5*
		 if ( valor.toString().equals("-X-*-O-*--X") && jogada ) { valor.setLength(0); valor.append("-X-*OO-*--X"); jogada = false;} //2,6*

		 if ( valor.toString().equals("OXX*XO-*---") && jogada ) { valor.setLength(0); valor.append("QXX*XQ-*--Q"); jogada = false;} //2,1,1
		 if ( valor.toString().equals("OXX*-OX*---") && jogada ) { valor.setLength(0); valor.append("QXX*-QX*--Q"); jogada = false;} //2,1,2
		 if ( valor.toString().equals("OXX*-O-*X--") && jogada ) { valor.setLength(0); valor.append("QXX*-Q-*X-Q"); jogada = false;} //2,1,3
		 if ( valor.toString().equals("OXX*-O-*-X-") && jogada ) { valor.setLength(0); valor.append("QXX*-Q-*-XQ"); jogada = false;} //2,1,4
		 if ( valor.toString().equals("OXX*-O-*--X") && jogada ) { valor.setLength(0); valor.append("OXX*-OO*--X"); jogada = false;} //2,1,5*

		 if ( valor.toString().equals("OXX*XO-*---") && jogada ) { valor.setLength(0); valor.append("QXX*XQ-*--Q"); jogada = false;} //2,2,1
		 if ( valor.toString().equals("OX-*XOX*---") && jogada ) { valor.setLength(0); valor.append("QX-*XQX*--Q"); jogada = false;} //2,2,2
		 if ( valor.toString().equals("OX-*XO-*X--") && jogada ) { valor.setLength(0); valor.append("QX-*XQ-*X-Q"); jogada = false;} //2,2,3
		 if ( valor.toString().equals("OX-*XO-*-X-") && jogada ) { valor.setLength(0); valor.append("QX-*XQ-*-XQ"); jogada = false;} //2,2,4
		 if ( valor.toString().equals("OX-*XO-*--X") && jogada ) { valor.setLength(0); valor.append("OXO*XO-*--X"); jogada = false;} //2,2,5*

		 if ( valor.toString().equals("XXO*-OX*---") && jogada ) { valor.setLength(0); valor.append("XXQ*-QX*Q--"); jogada = false;} //2,3,1
		 if ( valor.toString().equals("-XO*XOX*---") && jogada ) { valor.setLength(0); valor.append("-XQ*XQX*Q--"); jogada = false;} //2,3,2
		 if ( valor.toString().equals("-XO*-OX*X--") && jogada ) { valor.setLength(0); valor.append("-XO*-OX*X-O"); jogada = false;} //2,3,3*
		 if ( valor.toString().equals("-XO*-OX*-X-") && jogada ) { valor.setLength(0); valor.append("-XQ*-QX*QX-"); jogada = false;} //2,3,4
		 if ( valor.toString().equals("-XO*-OX*--X") && jogada ) { valor.setLength(0); valor.append("-XQ*-QX*Q-X"); jogada = false;} //2,3,5

		 if ( valor.toString().equals("XX-*-OO*X--") && jogada ) { valor.setLength(0); valor.append("XX-*QQQ*X--"); jogada = false;} //2,4,1
		 if ( valor.toString().equals("-XX*-OO*X--") && jogada ) { valor.setLength(0); valor.append("-XX*QQQ*X--"); jogada = false;} //2,4,2
		 if ( valor.toString().equals("-X-*XOO*X--") && jogada ) { valor.setLength(0); valor.append("OX-*XOO*X--"); jogada = false;} //2,4,3*
		 if ( valor.toString().equals("-X-*-OO*XX-") && jogada ) { valor.setLength(0); valor.append("-X-*QQQ*XX-"); jogada = false;} //2,4,4
		 if ( valor.toString().equals("-X-*-OO*X-X") && jogada ) { valor.setLength(0); valor.append("-X-*QQQ*X-X"); jogada = false;} //2,4,5

		 if ( valor.toString().equals("XX-*-O-*-XO") && jogada ) { valor.setLength(0); valor.append("XXO*-O-*-XO"); jogada = false;} //2,5,1*
		 if ( valor.toString().equals("-XX*-O-*-XO") && jogada ) { valor.setLength(0); valor.append("QXX*-Q-*-XQ"); jogada = false;} //2,5,2
		 if ( valor.toString().equals("-X-*XO-*-XO") && jogada ) { valor.setLength(0); valor.append("QX-*XQ-*-XQ"); jogada = false;} //2,5,3
		 if ( valor.toString().equals("-X-*-OX*-XO") && jogada ) { valor.setLength(0); valor.append("QX-*-QX*-XQ"); jogada = false;} //2,5,4
		 if ( valor.toString().equals("-X-*-O-*XXO") && jogada ) { valor.setLength(0); valor.append("QX-*-Q-*XXQ"); jogada = false;} //2,5,5

		 if ( valor.toString().equals("XX-*OO-*--X") && jogada ) { valor.setLength(0); valor.append("XX-*QQQ*--X"); jogada = false;} //2,6,1
		 if ( valor.toString().equals("-XX*OO-*--X") && jogada ) { valor.setLength(0); valor.append("-XX*QQQ*--X"); jogada = false;} //2,6,2
		 if ( valor.toString().equals("-X-*OOX*--X") && jogada ) { valor.setLength(0); valor.append("-XO*OOX*--X"); jogada = false;} //2,6,3*
		 if ( valor.toString().equals("-X-*OO-*X-X") && jogada ) { valor.setLength(0); valor.append("-X-*QQQ*X-X"); jogada = false;} //2,6,4
		 if ( valor.toString().equals("-X-*OO-*-XX") && jogada ) { valor.setLength(0); valor.append("-X-*QQQ*-XX"); jogada = false;} //2,6,5

		 if ( valor.toString().equals("--X*XO-*---") && jogada ) { valor.setLength(0); valor.append("-OX*XO-*---"); jogada = false;} //3,1*
		 if ( valor.toString().equals("--X*-OX*---") && jogada ) { valor.setLength(0); valor.append("--X*-OX*--O"); jogada = false;} //3,2*
		 if ( valor.toString().equals("--X*-O-*X--") && jogada ) { valor.setLength(0); valor.append("--X*OO-*X--"); jogada = false;} //3,3*
		 if ( valor.toString().equals("--X*-O-*-X-") && jogada ) { valor.setLength(0); valor.append("--X*OO-*-X-"); jogada = false;} //3,4*
		 if ( valor.toString().equals("--X*-O-*--X") && jogada ) { valor.setLength(0); valor.append("--X*-OO*--X"); jogada = false;} //3,5*

		 if ( valor.toString().equals("XOX*XO-*---") && jogada ) { valor.setLength(0); valor.append("XQX*XQ-*-Q-"); jogada = false;} //3,1,1
		 if ( valor.toString().equals("-OX*XOX*---") && jogada ) { valor.setLength(0); valor.append("-QX*XQX*-Q-"); jogada = false;} //3,1,2
		 if ( valor.toString().equals("-OX*XO-*X--") && jogada ) { valor.setLength(0); valor.append("-QX*XQ-*XQ-"); jogada = false;} //3,1,3
		 if ( valor.toString().equals("-OX*XO-*-X-") && jogada ) { valor.setLength(0); valor.append("OOX*XO-*-X-"); jogada = false;} //3,1,4*
		 if ( valor.toString().equals("-OX*XO-*--X") && jogada ) { valor.setLength(0); valor.append("-QX*XQ-*-QX"); jogada = false;} //3,1,5

		 if ( valor.toString().equals("X-X*-OX*--O") && jogada ) { valor.setLength(0); valor.append("XOX*-OX*--O"); jogada = false;} //3,2,1*
		 if ( valor.toString().equals("-XX*-OX*--O") && jogada ) { valor.setLength(0); valor.append("QXX*-QX*--Q"); jogada = false;} //3,2,2
		 if ( valor.toString().equals("--X*XOX*--O") && jogada ) { valor.setLength(0); valor.append("Q-X*XQX*--Q"); jogada = false;} //3,2,3
		 if ( valor.toString().equals("--X*-OX*X-O") && jogada ) { valor.setLength(0); valor.append("Q-X*-QX*X-Q"); jogada = false;} //3,2,4
		 if ( valor.toString().equals("--X*-OX*-XO") && jogada ) { valor.setLength(0); valor.append("Q-X*-QX*-XQ"); jogada = false;} //3,2,5

		 if ( valor.toString().equals("X-X*-O-*X--") && jogada ) { valor.setLength(0); valor.append("X-X*QQQ*X--"); jogada = false;} //3,3,1
		 if ( valor.toString().equals("-XX*OO-*X--") && jogada ) { valor.setLength(0); valor.append("-xX*QQQ*X--"); jogada = false;} //3,3,2
		 if ( valor.toString().equals("--X*OOX*X--") && jogada ) { valor.setLength(0); valor.append("--X*OOX*X-O"); jogada = false;} //3,3,3*
		 if ( valor.toString().equals("--X*OO-*XX-") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*XX-"); jogada = false;} //3,3,4
		 if ( valor.toString().equals("--X*OO-*X-X") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*X-X"); jogada = false;} //3,3,5

		 if ( valor.toString().equals("X-X*OO-*-X-") && jogada ) { valor.setLength(0); valor.append("X-X*QQQ*-X-"); jogada = false;} //3,4,1
		 if ( valor.toString().equals("-XX*OO-*-X-") && jogada ) { valor.setLength(0); valor.append("-XX*QQQ*-X-"); jogada = false;} //3,4,2
		 if ( valor.toString().equals("--X*OOX*-X-") && jogada ) { valor.setLength(0); valor.append("--X*OOX*-XO"); jogada = false;} //3,4,3*
		 if ( valor.toString().equals("--X*OO-*XX-") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*XX-"); jogada = false;} //3,4,4
		 if ( valor.toString().equals("--X*OO-*-XX") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*-XX"); jogada = false;} //3,4,5

		 if ( valor.toString().equals("X-X*-OO*--X") && jogada ) { valor.setLength(0); valor.append("X-X*QQQ*--X"); jogada = false;} //3,5,1
		 if ( valor.toString().equals("-XX*-OO*--X") && jogada ) { valor.setLength(0); valor.append("-XX*QQQ*--X"); jogada = false;} //3,5,2
		 if ( valor.toString().equals("--X*XOO*--X") && jogada ) { valor.setLength(0); valor.append("--X*XOO*-OX"); jogada = false;} //3,5,3*
		 if ( valor.toString().equals("--X*-OO*X-X") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*X-X"); jogada = false;} //3,5,4
		 if ( valor.toString().equals("--X*-OO*-XX") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*-XX"); jogada = false;} //3,5,5

		 if ( valor.toString().equals("---*XOX*---") && jogada ) { valor.setLength(0); valor.append("--O*XOX*---"); jogada = false;} //4,1*
		 if ( valor.toString().equals("---*XO-*X--") && jogada ) { valor.setLength(0); valor.append("O--*XO-*X--"); jogada = false;} //4,2*
		 if ( valor.toString().equals("---*XO-*-X-") && jogada ) { valor.setLength(0); valor.append("---*XO-*OX-"); jogada = false;} //4,3*
		 if ( valor.toString().equals("---*XO-*--X") && jogada ) { valor.setLength(0); valor.append("-O-*XO-*--X"); jogada = false;} //4,4*

		 if ( valor.toString().equals("X-O*XOX*---") && jogada ) { valor.setLength(0); valor.append("X-Q*XQX*Q--"); jogada = false;} //4,1,1
		 if ( valor.toString().equals("-XO*XOX*---") && jogada ) { valor.setLength(0); valor.append("-XQ*XQX*Q--"); jogada = false;} //4,1,2
		 if ( valor.toString().equals("--O*XOX*X--") && jogada ) { valor.setLength(0); valor.append("O-O*XOX*X--"); jogada = false;} //4,1,3*
		 if ( valor.toString().equals("--O*XOX*-X-") && jogada ) { valor.setLength(0); valor.append("--Q*XQX*QX-"); jogada = false;} //4,1,4
		 if ( valor.toString().equals("--O*XOX*--X") && jogada ) { valor.setLength(0); valor.append("--Q*XQX*Q-X"); jogada = false;} //4,1,5

		 if ( valor.toString().equals("OX-*XO-*X--") && jogada ) { valor.setLength(0); valor.append("QX-*XQ-*X-Q"); jogada = false;} //4,2,1
		 if ( valor.toString().equals("O-X*XO-*X--") && jogada ) { valor.setLength(0); valor.append("Q-X*XQ-*X-Q"); jogada = false;} //4,2,2
		 if ( valor.toString().equals("O--*XOX*X--") && jogada ) { valor.setLength(0); valor.append("Q--*XQX*X-Q"); jogada = false;} //4,2,3
		 if ( valor.toString().equals("O--*XO-*XX-") && jogada ) { valor.setLength(0); valor.append("Q--*XQ-*XXQ"); jogada = false;} //4,2,4
		 if ( valor.toString().equals("O--*XO-*X-X") && jogada ) { valor.setLength(0); valor.append("O--*XO-*XOX"); jogada = false;} //4,2,5*

		 if ( valor.toString().equals("X--*XO-*OX-") && jogada ) { valor.setLength(0); valor.append("X-Q*XQ-*QX-"); jogada = false;} //4,3,1
		 if ( valor.toString().equals("-X-*XO-*OX-") && jogada ) { valor.setLength(0); valor.append("-XQ*XQ-*QX-"); jogada = false;} //4,3,2
		 if ( valor.toString().equals("--X*XO-*OX-") && jogada ) { valor.setLength(0); valor.append("--X*XO-*OXO"); jogada = false;} //4,3,3*
		 if ( valor.toString().equals("---*XOX*OX-") && jogada ) { valor.setLength(0); valor.append("--Q*XQX*QX-"); jogada = false;} //4,3,4
		 if ( valor.toString().equals("---*XO-*OXX") && jogada ) { valor.setLength(0); valor.append("--Q*XQ-*QXX"); jogada = false;} //4,3,5

		 if ( valor.toString().equals("XO-*XO-*--X") && jogada ) { valor.setLength(0); valor.append("XQ-*XQ-*-QX"); jogada = false;} //4,4,1
		 if ( valor.toString().equals("-OX*XO-*--X") && jogada ) { valor.setLength(0); valor.append("-QX*XQ-*-QX"); jogada = false;} //4,4,2
		 if ( valor.toString().equals("-O-*XOX*--X") && jogada ) { valor.setLength(0); valor.append("-Q-*XQX*-QX"); jogada = false;} //4,4,3
		 if ( valor.toString().equals("-O-*XO-*X-X") && jogada ) { valor.setLength(0); valor.append("-Q-*XQ-*XQX"); jogada = false;} //4,4,4
		 if ( valor.toString().equals("-O-*XO-*-XX") && jogada ) { valor.setLength(0); valor.append("-O-*XO-*OXX"); jogada = false;} //4,4,5*

		 if ( valor.toString().equals("X--*-X-*--O") && jogada ) { valor.setLength(0); valor.append("X--*-X-*O-O"); jogada = false;} //5,1*
		 if ( valor.toString().equals("-X-*-X-*--O") && jogada ) { valor.setLength(0); valor.append("-X-*-X-*-OO"); jogada = false;} //5,2*
		 if ( valor.toString().equals("--X*-X-*--O") && jogada ) { valor.setLength(0); valor.append("--X*-X-*O-O"); jogada = false;} //5,3*
		 if ( valor.toString().equals("---*XX-*--O") && jogada ) { valor.setLength(0); valor.append("---*XXO*--O"); jogada = false;} //5,4*
		 if ( valor.toString().equals("---*-XX*--O") && jogada ) { valor.setLength(0); valor.append("---*OXX*--O"); jogada = false;} //5,5*
		 if ( valor.toString().equals("---*-X-*X-O") && jogada ) { valor.setLength(0); valor.append("--O*-X-*X-O"); jogada = false;} //5,6*
		 if ( valor.toString().equals("---*-X-*-XO") && jogada ) { valor.setLength(0); valor.append("-O-*-X-*-XO"); jogada = false;} //5,7*
		

		 if ( valor.toString().equals("XX-*-X-*O-O") && jogada ) { valor.setLength(0); valor.append("XX-*-X-*QQQ"); jogada = false;} //5,1,1
		 if ( valor.toString().equals("X-X*-X-*O-O") && jogada ) { valor.setLength(0); valor.append("X-X*-X-*QQQ"); jogada = false;} //5,1,2
		 if ( valor.toString().equals("X--*XX-*O-O") && jogada ) { valor.setLength(0); valor.append("X--*XX-*QQQ"); jogada = false;} //5,1,3
		 if ( valor.toString().equals("X--*-XX*O-O") && jogada ) { valor.setLength(0); valor.append("X--*-XX*QQQ"); jogada = false;} //5,1,4
		 if ( valor.toString().equals("X--*-X-*OXO") && jogada ) { valor.setLength(0); valor.append("XO-*-X-*OXO"); jogada = false;} //5,1,5*

		 if ( valor.toString().equals("XX-*-X-*-OO") && jogada ) { valor.setLength(0); valor.append("XX-*-X-*QQQ"); jogada = false;} //5,2,1
		 if ( valor.toString().equals("-XX*-X-*-OO") && jogada ) { valor.setLength(0); valor.append("-XX*-X-*QQQ"); jogada = false;} //5,2,2
		 if ( valor.toString().equals("-X-*XX-*-OO") && jogada ) { valor.setLength(0); valor.append("-X-*XX-*QQQ"); jogada = false;} //5,2,3
		 if ( valor.toString().equals("-X-*-XX*-OO") && jogada ) { valor.setLength(0); valor.append("-X-*-XX*QQQ"); jogada = false;} //5,2,4
		 if ( valor.toString().equals("-X-*-X-*XOO") && jogada ) { valor.setLength(0); valor.append("-XO*-X-*XOO"); jogada = false;} //5,2,5*

		 if ( valor.toString().equals("X-X*-X-*O-O") && jogada ) { valor.setLength(0); valor.append("X-X*-X-*QQQ"); jogada = false;} //5,3,1
		 if ( valor.toString().equals("-XX*-X-*O-O") && jogada ) { valor.setLength(0); valor.append("-XX*-X-*QQQ"); jogada = false;} //5,3,2
		 if ( valor.toString().equals("--X*XX-*O-O") && jogada ) { valor.setLength(0); valor.append("--X*XX-*QQQ"); jogada = false;} //5,3,3
		 if ( valor.toString().equals("--X*-XX*O-O") && jogada ) { valor.setLength(0); valor.append("--X*-XX*QQQ"); jogada = false;} //5,3,4
		 if ( valor.toString().equals("--X*-X-*OXO") && jogada ) { valor.setLength(0); valor.append("-OX*-X-*OXO"); jogada = false;} //5,3,5*

		 if ( valor.toString().equals("X--*XXO*--O") && jogada ) { valor.setLength(0); valor.append("X-Q*XXQ*--Q"); jogada = false;} //5,4,1
		 if ( valor.toString().equals("-X-*XXO*--O") && jogada ) { valor.setLength(0); valor.append("-XQ*XXQ*--Q"); jogada = false;} //5,4,2
		 if ( valor.toString().equals("--X*XXO*--O") && jogada ) { valor.setLength(0); valor.append("--X*XXO*O-O"); jogada = false;} //5,4,3*
		 if ( valor.toString().equals("---*XXO*X-O") && jogada ) { valor.setLength(0); valor.append("--Q*XXQ*X-Q"); jogada = false;} //5,4,4
		 if ( valor.toString().equals("---*XXO*-XO") && jogada ) { valor.setLength(0); valor.append("--Q*XXQ*-XQ"); jogada = false;} //5,4,5

		 if ( valor.toString().equals("X--*OXX*--O") && jogada ) { valor.setLength(0); valor.append("X--*OXX*O-O"); jogada = false;} //5,5,1*
		 if ( valor.toString().equals("-X-*OXX*--O") && jogada ) { valor.setLength(0); valor.append("-X-*OXX*-OO"); jogada = false;} //5,5,2*
		 if ( valor.toString().equals("--X*OXX*--O") && jogada ) { valor.setLength(0); valor.append("--X*OXX*O-O"); jogada = false;} //5,5,3*
		 if ( valor.toString().equals("---*OXX*X-O") && jogada ) { valor.setLength(0); valor.append("--O*OXX*X-O"); jogada = false;} //5,5,4*
		 if ( valor.toString().equals("---*OXX*-XO") && jogada ) { valor.setLength(0); valor.append("-O-*OXX*-XO"); jogada = false;} //5,5,5*

		 if ( valor.toString().equals("X-O*-X-*X-O") && jogada ) { valor.setLength(0); valor.append("X-Q*-XQ*X-Q"); jogada = false;} //5,6,1
		 if ( valor.toString().equals("-XO*-X-*X-O") && jogada ) { valor.setLength(0); valor.append("-XQ*-XQ*X-Q"); jogada = false;} //5,6,2
		 if ( valor.toString().equals("--O*XX-*X-O") && jogada ) { valor.setLength(0); valor.append("--Q*XXQ*X-Q"); jogada = false;} //5,6,3
		 if ( valor.toString().equals("--O*-XX*X-O") && jogada ) { valor.setLength(0); valor.append("--O*OXX*X-O"); jogada = false;} //5,6,4*
		 if ( valor.toString().equals("--O*-X-*XXO") && jogada ) { valor.setLength(0); valor.append("--Q*-XQ*XXQ"); jogada = false;} //5,6,5

		 if ( valor.toString().equals("XO-*-X-*-XO") && jogada ) { valor.setLength(0); valor.append("XOO*-X-*-XO"); jogada = false;} //5,7,1*
		 if ( valor.toString().equals("-OX*-X-*-XO") && jogada ) { valor.setLength(0); valor.append("-OX*-X-*OXO"); jogada = false;} //5,7,2*
		 if ( valor.toString().equals("-O-*XX-*-XO") && jogada ) { valor.setLength(0); valor.append("-O-*XXO*-XO"); jogada = false;} //5,7,3*
		 if ( valor.toString().equals("-O-*-XX*-XO") && jogada ) { valor.setLength(0); valor.append("-O-*OXX*-XO"); jogada = false;} //5,7,4*
		 if ( valor.toString().equals("-O-*-X-*XXO") && jogada ) { valor.setLength(0); valor.append("-OO*-X-*XXO"); jogada = false;} //5,7,5*

		 if ( valor.toString().equals("---*-OX*X--") && jogada ) { valor.setLength(0); valor.append("-O-*-OX*X--"); jogada = false;} //6,1*
		 if ( valor.toString().equals("---*-OX*-X-") && jogada ) { valor.setLength(0); valor.append("---*-OX*-XO"); jogada = false;} //6,2*
		 if ( valor.toString().equals("---*-OX*--X") && jogada ) { valor.setLength(0); valor.append("--O*-OX*--X"); jogada = false;} //6,3*

		 if ( valor.toString().equals("XO-*-OX*X--") && jogada ) { valor.setLength(0); valor.append("XQ-*-QX*XQ-"); jogada = false;} //6,1,1
		 if ( valor.toString().equals("-OX*-OX*X--") && jogada ) { valor.setLength(0); valor.append("-QX*-QX*XQ-"); jogada = false;} //6,1,2
		 if ( valor.toString().equals("-O-*XOX*X--") && jogada ) { valor.setLength(0); valor.append("-Q-*XQX*XQ-"); jogada = false;} //6,1,3
		 if ( valor.toString().equals("-O-*-OX*XX-") && jogada ) { valor.setLength(0); valor.append("-O-*-OX*XXO"); jogada = false;} //6,1,4*
		 if ( valor.toString().equals("-O-*-OX*X-X") && jogada ) { valor.setLength(0); valor.append("-Q-*-QX*XQX"); jogada = false;} //6,1,5

		 if ( valor.toString().equals("X--*-OX*-XO") && jogada ) { valor.setLength(0); valor.append("X--*-OX*OXO"); jogada = false;} //6,2,1*
		 if ( valor.toString().equals("-X-*-OX*-XO") && jogada ) { valor.setLength(0); valor.append("QX-*-QX*-XQ"); jogada = false;} //6,2,2
		 if ( valor.toString().equals("--X*-OX*-XO") && jogada ) { valor.setLength(0); valor.append("Q-X*-QX*-XQ"); jogada = false;} //6,2,3
		 if ( valor.toString().equals("---*XOX*-XO") && jogada ) { valor.setLength(0); valor.append("Q--*XQX*-XQ"); jogada = false;} //6,2,4
		 if ( valor.toString().equals("---*-OX*XXO") && jogada ) { valor.setLength(0); valor.append("Q--*-QX*XXQ"); jogada = false;} //6,2,5

		 if ( valor.toString().equals("X-O*-OX*--X") && jogada ) { valor.setLength(0); valor.append("X-Q*-QX*Q-X"); jogada = false;} //6,3,1
		 if ( valor.toString().equals("-XO*-OX*--X") && jogada ) { valor.setLength(0); valor.append("-XQ*-QX*Q-X"); jogada = false;} //6,3,2
		 if ( valor.toString().equals("--O*XOX*--X") && jogada ) { valor.setLength(0); valor.append("--Q*XQX*Q-X"); jogada = false;} //6,3,3
		 if ( valor.toString().equals("--O*-OX*X-X") && jogada ) { valor.setLength(0); valor.append("--O*-OX*XOX"); jogada = false;} //6,3,4*
		 if ( valor.toString().equals("--O*-OX*-XX") && jogada ) { valor.setLength(0); valor.append("--Q*-QX*QXX"); jogada = false;} //6,3,5

		 if ( valor.toString().equals("---*-O-*XX-") && jogada ) { valor.setLength(0); valor.append("---*-O-*XXO"); jogada = false;} //7,1*
		 if ( valor.toString().equals("---*-O-*X-X") && jogada ) { valor.setLength(0); valor.append("---*-O-*XOX"); jogada = false;} //7,2*

		 if ( valor.toString().equals("X--*-O-*XXO") && jogada ) { valor.setLength(0); valor.append("X--*OO-*XXO"); jogada = false;} //7,1,1*
		 if ( valor.toString().equals("-X-*-O-*XXO") && jogada ) { valor.setLength(0); valor.append("QX-*-Q-*XXQ"); jogada = false;} //7,1,2
		 if ( valor.toString().equals("--X*-O-*XXO") && jogada ) { valor.setLength(0); valor.append("Q-X*-Q-*XXQ"); jogada = false;} //7,1,3
		 if ( valor.toString().equals("---*XO-*XXO") && jogada ) { valor.setLength(0); valor.append("Q--*XQ-*XXQ"); jogada = false;} //7,1,4
		 if ( valor.toString().equals("---*-OX*XXO") && jogada ) { valor.setLength(0); valor.append("Q--*-QX*XXQ"); jogada = false;} //7,1,5

		 if ( valor.toString().equals("X--*-O-*XOX") && jogada ) { valor.setLength(0); valor.append("XQ-*-Q-*XQX"); jogada = false;} //7,2,1
		 if ( valor.toString().equals("-X-*-O-*XOX") && jogada ) { valor.setLength(0); valor.append("-X-*-OO*XOX"); jogada = false;} //7,2,2*
		 if ( valor.toString().equals("--X*-O-*XOX") && jogada ) { valor.setLength(0); valor.append("-QX*-Q-*XQX"); jogada = false;} //7,2,3
		 if ( valor.toString().equals("---*XO-*XOX") && jogada ) { valor.setLength(0); valor.append("-Q-*XQ-*XQX"); jogada = false;} //7,2,4
		 if ( valor.toString().equals("---*-OX*XOX") && jogada ) { valor.setLength(0); valor.append("-Q-*-QX*XQX"); jogada = false;} //7,2,5

		 if ( valor.toString().equals("---*-O-*-XX") && jogada ) { valor.setLength(0); valor.append("---*-O-*OXX"); jogada = false;} //8,1*

		 if ( valor.toString().equals("X--*-O-*OXX") && jogada ) { valor.setLength(0); valor.append("X-Q*-Q-*QXX"); jogada = false;} //8,1,1
		 if ( valor.toString().equals("-X-*-O-*OXX") && jogada ) { valor.setLength(0); valor.append("-XQ*-Q-*QXX"); jogada = false;} //8,1,2
		 if ( valor.toString().equals("--X*-O-*OXX") && jogada ) { valor.setLength(0); valor.append("--X*-OO*OXX"); jogada = false;} //8,1,3*
		 if ( valor.toString().equals("---*XO-*OXX") && jogada ) { valor.setLength(0); valor.append("--Q*XQ-*QXX"); jogada = false;} //8,1,4
		 if ( valor.toString().equals("---*-OX*OXX") && jogada ) { valor.setLength(0); valor.append("--Q*-QX*QXX"); jogada = false;} //8,1,5

		 // Respostas para as quarta e quinta jogadas

		 // Respostas para 1,1,3*
		 if ( valor.toString().equals("XXO*OOX*X--") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*X-O"); jogada = false;}//*
		 if ( valor.toString().equals("XXO*OO-*XX-") && jogada ) { valor.setLength(0); valor.append("XXO*QQQ*XX-"); jogada = false;}
		 if ( valor.toString().equals("XXO*OO-*X-X") && jogada ) { valor.setLength(0); valor.append("XXO*QQQ*X-X"); jogada = false;}

		 if ( valor.toString().equals("XXO*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*XXO"); jogada = false;}

		 // Respostas para 1,2,4*
		 if ( valor.toString().equals("XOX*XOO*-X-") && jogada ) { valor.setLength(0); valor.append("XOX*XOO*OX-"); jogada = false;}//*
		 if ( valor.toString().equals("XOX*-OO*XX-") && jogada ) { valor.setLength(0); valor.append("XOX*QQQ*XX-"); jogada = false;}
		 if ( valor.toString().equals("XOX*-OO*-XX") && jogada ) { valor.setLength(0); valor.append("XOX*QQQ*-XX"); jogada = false;}

		 if ( valor.toString().equals("XOX*XOO*OXX") && jogada ) { valor.setLength(0); valor.append("XOX*XOO*OXX"); jogada = false;}

		 //Respostas para 1,3,2*
		 if ( valor.toString().equals("XOX*XOX*O--") && jogada ) { valor.setLength(0); valor.append("XQX*XQX*OQ-"); jogada = false;}
		 if ( valor.toString().equals("XOX*XO-*OX-") && jogada ) { valor.setLength(0); valor.append("XOX*XO-*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("XOX*XO-*O-X") && jogada ) { valor.setLength(0); valor.append("XQX*XQ-*OQX"); jogada = false;}

		 if ( valor.toString().equals("XOX*XOX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XOX*OXO"); jogada = false;}

		 //Respostas para 1,4,4*
		 if ( valor.toString().equals("XOX*-OX*OX-") && jogada ) { valor.setLength(0); valor.append("XOX*-OX*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("XO-*XOX*OX-") && jogada ) { valor.setLength(0); valor.append("XOQ*XQX*QX-"); jogada = false;}
		 if ( valor.toString().equals("XO-*-OX*OXX") && jogada ) { valor.setLength(0); valor.append("XOQ*-QX*QXX"); jogada = false;}

		 if ( valor.toString().equals("XOX*XOX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XOX*OXO"); jogada = false;}

		 //Respostas para 1,5,3*
		 if ( valor.toString().equals("XX-*OOX*XO-") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*XO-"); jogada = false;}
		 if ( valor.toString().equals("X-X*OOX*XO-") && jogada ) { valor.setLength(0); valor.append("XQX*OQX*XQ-"); jogada = false;}//*
		 if ( valor.toString().equals("X--*OOX*XOX") && jogada ) { valor.setLength(0); valor.append("XQ-*OQX*XQX"); jogada = false;}//*

		 if ( valor.toString().equals("XXO*OOX*XOX") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*XOX"); jogada = false;}

		 //Respostas para 1,6,3*
		 if ( valor.toString().equals("XXO*OOX*-X-") && jogada ) { valor.setLength(0); valor.append("XXQ*OQX*QX-"); jogada = false;}
		 if ( valor.toString().equals("X-O*OOX*XX-") && jogada ) { valor.setLength(0); valor.append("X-O*OOX*XXO"); jogada = false;}//*
		 if ( valor.toString().equals("X-O*OOX*-XX") && jogada ) { valor.setLength(0); valor.append("X-Q*OQX*QXX"); jogada = false;}

		 if ( valor.toString().equals("XXO*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*XXO"); jogada = false;}

		 //Respostas para 1,7,3*
		 if ( valor.toString().equals("XX-*XOO*O-X") && jogada ) { valor.setLength(0); valor.append("XXQ*XQO*Q-X"); jogada = false;}
		 if ( valor.toString().equals("X-X*XOO*O-X") && jogada ) { valor.setLength(0); valor.append("XOX*XOO*O-X"); jogada = false;}//*
		 if ( valor.toString().equals("X--*XOO*OXX") && jogada ) { valor.setLength(0); valor.append("X-Q*XQO*QXX"); jogada = false;}

		 if ( valor.toString().equals("XOX*XOO*OXX") && jogada ) { valor.setLength(0); valor.append("XOX*XOO*OXX"); jogada = false;}

		 //Respostas para 2,1,5*
		 if ( valor.toString().equals("OXX*XOO*--X") && jogada ) { valor.setLength(0); valor.append("OXX*XOO*O-X"); jogada = false;}//*
		 if ( valor.toString().equals("OXX*-OO*X-X") && jogada ) { valor.setLength(0); valor.append("OXX*QQQ*X-X"); jogada = false;}
		 if ( valor.toString().equals("OXX*-OO*-XX") && jogada ) { valor.setLength(0); valor.append("OXX*QQQ*-XX"); jogada = false;}

		 if ( valor.toString().equals("OXX*XOO*OXX") && jogada ) { valor.setLength(0); valor.append("OXX*XOO*OXX"); jogada = false;}

		 //Respostas para 2,2,5*
		 if ( valor.toString().equals("OXO*XOX*--X") && jogada ) { valor.setLength(0); valor.append("OXQ*XQX*Q-X"); jogada = false;}
		 if ( valor.toString().equals("OXO*XO-*X-X") && jogada ) { valor.setLength(0); valor.append("OXO*XO-*XOX"); jogada = false;}//*
		 if ( valor.toString().equals("OXO*XO-*-XX") && jogada ) { valor.setLength(0); valor.append("OXQ*XQ-*QXX"); jogada = false;}

		 if ( valor.toString().equals("OXO*XOX*XOX") && jogada ) { valor.setLength(0); valor.append("OXO*XOX*XOX"); jogada = false;}

		 //Respostas para 2,3,3*
		 if ( valor.toString().equals("XXO*-OX*X-O") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*X-O"); jogada = false;}//*
		 if ( valor.toString().equals("-XO*XOX*X-O") && jogada ) { valor.setLength(0); valor.append("QXO*XQX*X-Q"); jogada = false;}
		 if ( valor.toString().equals("-XO*-OX*XXO") && jogada ) { valor.setLength(0); valor.append("QXO*-QX*XXQ"); jogada = false;}

		 if ( valor.toString().equals("XXO*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*X-O"); jogada = false;}

		 //Respostas para 2,4,3*
		 if ( valor.toString().equals("OXX*XOO*X--") && jogada ) { valor.setLength(0); valor.append("QXX*XQO*X-Q"); jogada = false;}
		 if ( valor.toString().equals("OX-*XOO*XX-") && jogada ) { valor.setLength(0); valor.append("QX-*XQO*XXQ"); jogada = false;}
		 if ( valor.toString().equals("OX-*XOO*X-X") && jogada ) { valor.setLength(0); valor.append("OX-*XOO*XOX"); jogada = false;}//*

		 if ( valor.toString().equals("OXX*XOO*XOX") && jogada ) { valor.setLength(0); valor.append("OXX*XOO*XOX"); jogada = false;}

		 //Respostas para 2,5,1*
		 if ( valor.toString().equals("XXO*XO-*-XO") && jogada ) { valor.setLength(0); valor.append("XXQ*XQ-*QXO"); jogada = false;}
		 if ( valor.toString().equals("XXO*-OX*-XO") && jogada ) { valor.setLength(0); valor.append("XXQ*-QX*QXO"); jogada = false;}
		 if ( valor.toString().equals("XXO*-O-*XXO") && jogada ) { valor.setLength(0); valor.append("XXQ*-OQ*XXQ"); jogada = false;}

		 //Respostas para 2,6,3*
		 if ( valor.toString().equals("XXO*OOX*--X") && jogada ) { valor.setLength(0); valor.append("XXQ*OQX*Q-X"); jogada = false;}
		 if ( valor.toString().equals("-XO*OOX*X-X") && jogada ) { valor.setLength(0); valor.append("-XO*OOX*XOX"); jogada = false;}//*
		 if ( valor.toString().equals("-XO*OOX*-XX") && jogada ) { valor.setLength(0); valor.append("-XQ*OQX*QXX"); jogada = false;}

		 if ( valor.toString().equals("XXO*OOX*X-X") && jogada ) { valor.setLength(0); valor.append("-XO*OOX*XOX"); jogada = false;}

		 //Respostas para 3,1,4*
		 if ( valor.toString().equals("OOX*XOX*-X-") && jogada ) { valor.setLength(0); valor.append("QOX*XQX*-XQ"); jogada = false;}
		 if ( valor.toString().equals("OOX*XO-*XX-") && jogada ) { valor.setLength(0); valor.append("QOX*XQ-*XXQ"); jogada = false;}
		 if ( valor.toString().equals("OOX*XO-*-XX") && jogada ) { valor.setLength(0); valor.append("OOX*XO-*OXX"); jogada = false;}//*

		 if ( valor.toString().equals("OOX*XOX*OXX") && jogada ) { valor.setLength(0); valor.append("OOX*XOX*OXX"); jogada = false;}

		 //Respostas para 3,2,1*
		 if ( valor.toString().equals("XOX*XOX*--O") && jogada ) { valor.setLength(0); valor.append("XQX*XQX*-QO"); jogada = false;}
		 if ( valor.toString().equals("XOX*-OX*X-O") && jogada ) { valor.setLength(0); valor.append("XQX*-QX*XQO"); jogada = false;}
		 if ( valor.toString().equals("XOX*-OX*-XO") && jogada ) { valor.setLength(0); valor.append("XOX*-OX*OXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOX*XOX*-XO") && jogada ) { valor.setLength(0); valor.append("XOX*XOX*OXO"); jogada = false;}

		 //Respostas para 3,3,3*
		 if ( valor.toString().equals("X-X*OOX*X-O") && jogada ) { valor.setLength(0); valor.append("XOX*OOX*X-O"); jogada = false;}//*
		 if ( valor.toString().equals("-XX*OOX*X-O") && jogada ) { valor.setLength(0); valor.append("QXX*OQX*X-Q"); jogada = false;}
		 if ( valor.toString().equals("--X*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("Q-X*OQX*XXQ"); jogada = false;}

		 if ( valor.toString().equals("XOX*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("XOX*OOX*XXO"); jogada = false;}

		 //Respostas para 3,4,3*
		 if ( valor.toString().equals("X-X*OOX*-XO") && jogada ) { valor.setLength(0); valor.append("XOX*OOX*-XO"); jogada = false;}//*
		 if ( valor.toString().equals("-XX*OOX*-XO") && jogada ) { valor.setLength(0); valor.append("QXX*OQX*-XQ"); jogada = false;}
		 if ( valor.toString().equals("--X*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("Q-X*OQX*XXQ"); jogada = false;}

		 if ( valor.toString().equals("XOX*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("XOX*OOX*XXO"); jogada = false;}

		 //Resposta para 3,5,3*
		 if ( valor.toString().equals("X-X*XOO*-OX") && jogada ) { valor.setLength(0); valor.append("XQX*XQO*-QX"); jogada = false;}
		 if ( valor.toString().equals("-XX*XOO*-OX") && jogada ) { valor.setLength(0); valor.append("OXX*XOO*-OX"); jogada = false;}//*
		 if ( valor.toString().equals("--X*XOO*XOX") && jogada ) { valor.setLength(0); valor.append("-QX*XQO*XQX"); jogada = false;}

		 if ( valor.toString().equals("OXX*XOO*XOX") && jogada ) { valor.setLength(0); valor.append("OXX*XOO*XOX"); jogada = false;}

		 //Resposta para 4,1,3*
		 if ( valor.toString().equals("OXO*XOX*X--") && jogada ) { valor.setLength(0); valor.append("QXO*XQX*X-Q"); jogada = false;}
		 if ( valor.toString().equals("O-O*XOX*XX-") && jogada ) { valor.setLength(0); valor.append("Q-O*XQX*XXQ"); jogada = false;}
		 if ( valor.toString().equals("O-O*XOX*X-X") && jogada ) { valor.setLength(0); valor.append("QQQ*XOX*X-X"); jogada = false;}

		 //Respostas para 4,2,5*
		 if ( valor.toString().equals("OX-*XO-*XOX") && jogada ) { valor.setLength(0); valor.append("OXO*XO-*XOX"); jogada = false;}//*
		 if ( valor.toString().equals("O-X*XO-*XOX") && jogada ) { valor.setLength(0); valor.append("OQX*XQ-*XQX"); jogada = false;}
		 if ( valor.toString().equals("O--*XOX*XOX") && jogada ) { valor.setLength(0); valor.append("OQ-*XQX*XQX"); jogada = false;}

		 if ( valor.toString().equals("OXO*XOX*XOX") && jogada ) { valor.setLength(0); valor.append("OXO*XOX*XOX"); jogada = false;}

		 //Respostas para 4,3,3*
		 if ( valor.toString().equals("X-X*XO-*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XO-*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-XX*XO-*OXO") && jogada ) { valor.setLength(0); valor.append("QXX*XQ-*OXQ"); jogada = false;}
		 if ( valor.toString().equals("--X*XOX*OXO") && jogada ) { valor.setLength(0); valor.append("Q-X*XQX*OXQ"); jogada = false;}

		 if ( valor.toString().equals("XOX*XOX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XOX*OXO"); jogada = false;}

		 //Respostas para 4,4,5*
		 if ( valor.toString().equals("XO-*XO-*OXX") && jogada ) { valor.setLength(0); valor.append("XOQ*XQ-*QXX"); jogada = false;}
		 if ( valor.toString().equals("-OX*XO-*OXX") && jogada ) { valor.setLength(0); valor.append("-OX*XOO*OXX"); jogada = false;}//*
		 if ( valor.toString().equals("-O-*XOX*OXX") && jogada ) { valor.setLength(0); valor.append("-OQ*XQX*QXX"); jogada = false;}

		 if ( valor.toString().equals("XOX*XOO*OXX") && jogada ) { valor.setLength(0); valor.append("XOX*XOO*OXX"); jogada = false;}

		 //Resposta para 5,1,5*
		 if ( valor.toString().equals("XOX*-X-*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OX-*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("XO-*XX-*OXO") && jogada ) { valor.setLength(0); valor.append("XO-*XXO*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("XO-*-XX*OXO") && jogada ) { valor.setLength(0); valor.append("XO-*OXX*OXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*XXO*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XXO*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XO-*OXX*OXO"); jogada = false;}

		 //Respostas para 5,2,5*
		 if ( valor.toString().equals("XXO*-X-*XOO") && jogada ) { valor.setLength(0); valor.append("XXQ*-XQ*XOQ"); jogada = false;}
		 if ( valor.toString().equals("-XO*XX-*XOO") && jogada ) { valor.setLength(0); valor.append("-XQ*XXQ*XOQ"); jogada = false;}
		 if ( valor.toString().equals("-XO*-XX*XOO") && jogada ) { valor.setLength(0); valor.append("-XO*OXX*XOO"); jogada = false;}//*

		 if ( valor.toString().equals("XXO*OXX*XOO") && jogada ) { valor.setLength(0); valor.append("XXO*OXX*XOO"); jogada = false;}

		 //Respostas para 5,3,5*
		 if ( valor.toString().equals("XOX*-X-*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OX-*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-OX*XX-*OXO") && jogada ) { valor.setLength(0); valor.append("-OX*XXO*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-OX*-XX*OXO") && jogada ) { valor.setLength(0); valor.append("-OX*OXX*OXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*XXO*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XXO*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}

		 //Respostas para 5,4,3*
		 if ( valor.toString().equals("X-X*XXO*O-O") && jogada ) { valor.setLength(0); valor.append("X-X*XXO*QQQ"); jogada = false;}
		 if ( valor.toString().equals("-XX*XXO*O-O") && jogada ) { valor.setLength(0); valor.append("-XX*XXO*QQQ"); jogada = false;}
		 if ( valor.toString().equals("--X*XXO*OXO") && jogada ) { valor.setLength(0); valor.append("-OX*XXO*OXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOX*XXO*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XXO*OXO"); jogada = false;}

		 //Respostas para 5,5,1*
		 if ( valor.toString().equals("XX-*OXX*O-O") && jogada ) { valor.setLength(0); valor.append("X--*OXX*QQQ"); jogada = false;}
		 if ( valor.toString().equals("X-X*OXX*O-O") && jogada ) { valor.setLength(0); valor.append("X--*OXX*QQQ"); jogada = false;}
		 if ( valor.toString().equals("X--*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XO-*OXX*OXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}

		 //Resposta para 5,5,2*
		 if ( valor.toString().equals("XX-*OXX*-OO") && jogada ) { valor.setLength(0); valor.append("XX-*OXX*QQQ"); jogada = false;}
		 if ( valor.toString().equals("-XX*OXX*-OO") && jogada ) { valor.setLength(0); valor.append("-XX*OXX*QQQ"); jogada = false;}
		 if ( valor.toString().equals("-X-*OXX*XOO") && jogada ) { valor.setLength(0); valor.append("-XO*OXX*XOO"); jogada = false;}//*

		 if ( valor.toString().equals("XXO*OXX*XOO") && jogada ) { valor.setLength(0); valor.append("XXO*OXX*XOO"); jogada = false;}

		 //Respostas para 5,5,3*
		 if ( valor.toString().equals("X-X*OXX*O-O") && jogada ) { valor.setLength(0); valor.append("X-X*OXX*QQQ"); jogada = false;}
		 if ( valor.toString().equals("-XX*OXX*O-O") && jogada ) { valor.setLength(0); valor.append("-XX*OXX*QQQ"); jogada = false;}
		 if ( valor.toString().equals("--X*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("Q-X*QXX*QXO"); jogada = false;}

		 //Respostas para 5,5,4*
		 if ( valor.toString().equals("X-O*OXX*X-O") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*X-O"); jogada = false;}//*
		 if ( valor.toString().equals("-XO*OXX*X-O") && jogada ) { valor.setLength(0); valor.append("-XO*OXX*XOO"); jogada = false;}//*
		 if ( valor.toString().equals("--O*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("-OO*OXX*XXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*XXO"); jogada = false;}
		 if ( valor.toString().equals("XXO*OXX*XOO") && jogada ) { valor.setLength(0); valor.append("XXO*OXX*XOO"); jogada = false;}
		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*XXO"); jogada = false;}

		 //Resposta para 5,5,5*
		 if ( valor.toString().equals("XO-*OXX*-XO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*-XO"); jogada = false;}//*
		 if ( valor.toString().equals("-OX*OXX*-XO") && jogada ) { valor.setLength(0); valor.append("-OX*OXX*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-O-*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("-OO*OXX*XXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*XXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*XXO"); jogada = false;}

		 //Repostas para 5,6,4*
		 if ( valor.toString().equals("X-O*OXX*X-O") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*X-O"); jogada = false;}//*
		 if ( valor.toString().equals("-XO*OXX*X-O") && jogada ) { valor.setLength(0); valor.append("-XO*OXX*XOO"); jogada = false;}//*
		 if ( valor.toString().equals("--O*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("-OO*OXX*XXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*XXO"); jogada = false;}
		 if ( valor.toString().equals("XXO*OXX*XOO") && jogada ) { valor.setLength(0); valor.append("XXO*OXX*XOO"); jogada = false;}
		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("-OO*OXX*XXO"); jogada = false;}

		 //Repostas para 5,7,1*
		 if ( valor.toString().equals("XOO*XX-*-XO") && jogada ) { valor.setLength(0); valor.append("XOQ*XXQ*-XQ"); jogada = false;}
		 if ( valor.toString().equals("XOO*-XX*-XO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*-XO"); jogada = false;}//*
		 if ( valor.toString().equals("XOO*-X-*XXO") && jogada ) { valor.setLength(0); valor.append("XOQ*-XQ*XXQ"); jogada = false;}

		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*XXO"); jogada = false;}

		 //Repostas para 5,7,2*
		 if ( valor.toString().equals("XOX*-X-*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OX-*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-OX*XX-*OXO") && jogada ) { valor.setLength(0); valor.append("-OX*XXO*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-OX*-XX*OXO") && jogada ) { valor.setLength(0); valor.append("-OX*OXX*OXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*XXO*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XXO*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}

		 //Repostas para 5,7,3*
		 if ( valor.toString().equals("XO-*XXO*-XO") && jogada ) { valor.setLength(0); valor.append("XOQ*XXQ*-XQ"); jogada = false;}
		 if ( valor.toString().equals("-OX*XXO*-XO") && jogada ) { valor.setLength(0); valor.append("-OX*XXO*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-O-*XXO*XXO") && jogada ) { valor.setLength(0); valor.append("-OQ*XXQ*XXQ"); jogada = false;}

		 if ( valor.toString().equals("XOX*XXO*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XXO*OXO"); jogada = false;}

		 //Repostas para 5,7,4*
		 if ( valor.toString().equals("XO-*OXX*-XO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*-XO"); jogada = false;}//*
		 if ( valor.toString().equals("-OX*OXX*-XO") && jogada ) { valor.setLength(0); valor.append("-OX*OXX*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("-O-*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("-OO*OXX*XXO"); jogada = false;}//*

		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOX*OXX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*OXX*OXO"); jogada = false;}
		 if ( valor.toString().equals("XOO*OXX*XXO") && jogada ) { valor.setLength(0); valor.append("XOO*OXX*XXO"); jogada = false;}

		 //Repostas para 5,7,5*
		 if ( valor.toString().equals("XOO*-X-*XXO") && jogada ) { valor.setLength(0); valor.append("XOQ*-XQ*XXQ"); jogada = false;}
		 if ( valor.toString().equals("-OO*XX-*XXO") && jogada ) { valor.setLength(0); valor.append("QQQ*XX-*XXO"); jogada = false;}
		 if ( valor.toString().equals("-OO*-XX*XXO") && jogada ) { valor.setLength(0); valor.append("QQQ*-XX*XXO"); jogada = false;}

		 //Respostas para 6,1,4*
		 if ( valor.toString().equals("XO-*-OX*XXO") && jogada ) { valor.setLength(0); valor.append("XO-*OOX*XXO"); jogada = false;}//*
		 if ( valor.toString().equals("-OX*-OX*XXO") && jogada ) { valor.setLength(0); valor.append("QOX*-QX*XXQ"); jogada = false;}
		 if ( valor.toString().equals("-O-*XOX*XXO") && jogada ) { valor.setLength(0); valor.append("QO-*XQX*XXQ"); jogada = false;}

		 if ( valor.toString().equals("XOX*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("XOX*OOX*XXO"); jogada = false;}

		 //Respostas para 6,2,1*
		 if ( valor.toString().equals("XXO*-QX*OXO") && jogada ) { valor.setLength(0); valor.append("XXQ*-QX*QXO"); jogada = false;}
		 if ( valor.toString().equals("X-X*-OX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*-OX*OXO"); jogada = false;}//*
		 if ( valor.toString().equals("X-O*XQX*OXO") && jogada ) { valor.setLength(0); valor.append("X-Q*XQX*QXO"); jogada = false;}

		 if ( valor.toString().equals("XOX*XOX*OXO") && jogada ) { valor.setLength(0); valor.append("XOX*XOX*OXO"); jogada = false;}

		 //Respostas par 6,3,4*
		 if ( valor.toString().equals("X-O*-OX*XOX") && jogada ) { valor.setLength(0); valor.append("XQO*-QX*XQX"); jogada = false;}
		 if ( valor.toString().equals("-XO*-OX*XOX") && jogada ) { valor.setLength(0); valor.append("OXO*-OX*XOX"); jogada = false;}//*
		 if ( valor.toString().equals("--O*XOX*XOX") && jogada ) { valor.setLength(0); valor.append("-QO*XQX*XQX"); jogada = false;}

		 if ( valor.toString().equals("OXO*XOX*XOX") && jogada ) { valor.setLength(0); valor.append("OXO*XOX*XOX"); jogada = false;}

		 //Respostas para 7,1,1*
		 if ( valor.toString().equals("XX-*OO-*XXO") && jogada ) { valor.setLength(0); valor.append("XX-*QQQ*XXO"); jogada = false;}
		 if ( valor.toString().equals("X-X*OO-*XXO") && jogada ) { valor.setLength(0); valor.append("X-X*QQQ*XXO"); jogada = false;}
		 if ( valor.toString().equals("X--*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("X-O*OOX*XXO"); jogada = false;}//*

		 if ( valor.toString().equals("XXO*OOX*XXO") && jogada ) { valor.setLength(0); valor.append("XXO*OOX*XXO"); jogada = false;}

		 //Respostas para 7,2,2*
		 if ( valor.toString().equals("XX-*-OO*XOX") && jogada ) { valor.setLength(0); valor.append("XX-*QQQ*XOX"); jogada = false;}
		 if ( valor.toString().equals("-XX*-OO*XOX") && jogada ) { valor.setLength(0); valor.append("-XX*QQQ*XOX"); jogada = false;}
		 if ( valor.toString().equals("-X-*XOO*XOX") && jogada ) { valor.setLength(0); valor.append("OX-*XOO*XOX"); jogada = false;}//*

		 if ( valor.toString().equals("OXX*XOO*XOX") && jogada ) { valor.setLength(0); valor.append("OXX*XOO*XOX"); jogada = false;}

		 //Respostas para 8,1,3*
		 if ( valor.toString().equals("X-X*-OO*OXX") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*OXX"); jogada = false;}
		 if ( valor.toString().equals("-XX*-OO*OXX") && jogada ) { valor.setLength(0); valor.append("--X*QQQ*OXX"); jogada = false;}
		 if ( valor.toString().equals("--X*XOO*OXX") && jogada ) { valor.setLength(0); valor.append("O-X*XOO*OXX"); jogada = false;}//*

		 if ( valor.toString().equals("OXX*XOO*OXX") && jogada ) { valor.setLength(0); valor.append("OXX*XOO*OXX"); jogada = false;}

	}
}