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
public class RegraSegundaRodadaCasa8 implements RegrasGerais {

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#RegraGeral(java.lang.StringBuilder, boolean, java.lang.String)
	 */
	@Override
	public void RegraGeral(StringBuilder valor, boolean jogada, String opcao) {
		if(opcao.equals("X") && opcao !=null){
			if ( valor.toString().equals("---*-O-*-%s"+opcao+"%s"+opcao+"") && jogada ) { valor.setLength(0); valor.append("---*-O-*O%s"+opcao+"%s"+opcao+""); jogada = false;} //8,1*
		}else if (opcao.equals("O") && opcao !=null){
			if ( valor.toString().equals("---*-X-*-%s"+opcao+"%s"+opcao+"") && jogada ) { valor.setLength(0); valor.append("---*-X-*X%s"+opcao+"%s"+opcao+""); jogada = false;} //8,1*
		}
	}

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#opcaoDeJogo(java.lang.String)
	 */
	@Override
	public OpcaoDeJogo opcaoDeJogo(String opcao) {
		// TODO Auto-generated method stub
		return null;
	}

}
