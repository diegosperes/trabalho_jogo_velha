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
public class RegraSegundaRodadaCasa6 implements RegrasGerais {

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#RegraGeral(java.lang.StringBuilder, boolean, java.lang.String)
	 */
	@Override
	public void RegraGeral(StringBuilder valor, boolean jogada, String opcao) {
		if(opcao.equals("X") && opcao !=null){
			if ( valor.toString().equals("---*-O%s"+opcao+"*%s"+opcao+"--") && jogada ) { valor.setLength(0); valor.append("-O-*-O%s"+opcao+"*%s"+opcao+"--"); jogada = false;} //6,1*
			 if ( valor.toString().equals("---*-O%s"+opcao+"*-%s"+opcao+"-") && jogada ) { valor.setLength(0); valor.append("---*-O%s"+opcao+"*-%s"+opcao+"O"); jogada = false;} //6,2*
			 if ( valor.toString().equals("---*-O%s"+opcao+"*--%s"+opcao+"") && jogada ) { valor.setLength(0); valor.append("--O*-O%s"+opcao+"*--%s"+opcao+""); jogada = false;} //6,3*
		}else if (opcao.equals("O") && opcao !=null){
			if ( valor.toString().equals("---*-X%s"+opcao+"*%s"+opcao+"--") && jogada ) { valor.setLength(0); valor.append("-X-*-X%s"+opcao+"*%s"+opcao+"--"); jogada = false;} //6,1*
			 if ( valor.toString().equals("---*-X%s"+opcao+"*-%s"+opcao+"-") && jogada ) { valor.setLength(0); valor.append("---*-X%s"+opcao+"*-%s"+opcao+"X"); jogada = false;} //6,2*
			 if ( valor.toString().equals("---*-X%s"+opcao+"*--%s"+opcao+"") && jogada ) { valor.setLength(0); valor.append("--X*-X%s"+opcao+"*--%s"+opcao+""); jogada = false;} //6,3*
			
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
