/**
 * 
 */
package jogodavelhaEE.src.model.regras.segundaJogada;

import jogodavelhaEE.src.model.RegrasGerais;
import jogodavelhaEE.src.model.util.OpcaoDeJogo;

/**
 * @author kaueh
 *
 */
public class RegraSegundaRodadaCasa3 implements RegrasGerais {

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#RegraGeral(java.lang.StringBuilder, boolean, java.lang.String)
	 */
	@Override
	public void RegraGeral(StringBuilder valor, boolean jogada, String opcao) {
		
		if (opcao.equals("X") && opcao !=null){
			if ( valor.toString().equals("--%s"+opcao+"*%s"+opcao+"O-*---") && jogada ) { valor.setLength(0); valor.append("-O%s"+opcao+"*%s"+opcao+"O-*---"); jogada = false;} //3,1*
			 if ( valor.toString().equals("--%s"+opcao+"*-O%s"+opcao+"*---") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*-O%s"+opcao+"*--O"); jogada = false;} //3,2*
			 if ( valor.toString().equals("--%s"+opcao+"*-O-*%s"+opcao+"--") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*OO-*%s"+opcao+"--"); jogada = false;} //3,3*
			 if ( valor.toString().equals("--%s"+opcao+"*-O-*-%s"+opcao+"-") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*OO-*-%s"+opcao+"-"); jogada = false;} //3,4*
			 if ( valor.toString().equals("--%s"+opcao+"*-O-*--%s"+opcao+"") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*-OO*--%s"+opcao+""); jogada = false;} //3,5*
			
		}else if (opcao.equals("O") && opcao !=null){
			
			if ( valor.toString().equals("--%s"+opcao+"*%s"+opcao+"X-*---") && jogada ) { valor.setLength(0); valor.append("-X%s"+opcao+"*%s"+opcao+"X-*---"); jogada = false;} //3,1*
			if ( valor.toString().equals("--%s"+opcao+"*-X%s"+opcao+"*---") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*-X%s"+opcao+"*--X"); jogada = false;} //3,2*
			if ( valor.toString().equals("--%s"+opcao+"*-X-*%s"+opcao+"--") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*XX-*%s"+opcao+"--"); jogada = false;} //3,3*
			if ( valor.toString().equals("--%s"+opcao+"*-X-*-%s"+opcao+"-") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*XX-*-%s"+opcao+"-"); jogada = false;} //3,4*
			if ( valor.toString().equals("--%s"+opcao+"*-X-*--%s"+opcao+"") && jogada ) { valor.setLength(0); valor.append("--%s"+opcao+"*-XX*--%s"+opcao+""); jogada = false;} //3,5*
		}

	}

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#opcaoDeJogo(java.lang.String)
	 */
	@Override
	public OpcaoDeJogo opcaoDeJogo(String opcao) {
		if (opcao == "x") {
			return OpcaoDeJogo.O;
		}
		return OpcaoDeJogo.X;
	}
}
