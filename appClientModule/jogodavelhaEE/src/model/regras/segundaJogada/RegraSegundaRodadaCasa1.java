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
public class RegraSegundaRodadaCasa1 implements RegrasGerais {

	@Override
	public void RegraGeral(StringBuilder valor, boolean jogada, String opcaoJogada) {

		if (opcaoJogada.equals("X") && opcaoJogada != null) {
			if (valor.toString().equals("%s"+opcaoJogada+"%s"+opcaoJogada+"-*-O-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"%s"+opcaoJogada+"O*-O-*---");
				jogada = false;
			} // 1,1*
			if (valor.toString().equals("%s"+opcaoJogada+"-%s"+opcaoJogada+"*-O-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"O%s"+opcaoJogada+"*-O-*---");
				jogada = false;
			} // 1,2*
			if (valor.toString().equals("%s"+opcaoJogada+"--*%s"+opcaoJogada+"O-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*%s"+opcaoJogada+"O-*O--");
				jogada = false;
			} // 1,3*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-O%s"+opcaoJogada+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"O-*-O%s"+opcaoJogada+"*---");
				jogada = false;
			} // 1,4*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-O-*%s"+opcaoJogada+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*OO-*%s"+opcaoJogada+"--");
				jogada = false;
			} // 1,5*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-O-*-%s"+opcaoJogada+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*OO-*-%s"+opcaoJogada+"-");
				jogada = false;
			} // 1,6*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-O-*--%s"+opcaoJogada+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*-OO*--%s"+opcaoJogada+"");
				jogada = false;
			} // 1,7*

			
		} else if (opcaoJogada.equals("O") && opcaoJogada != null) {
			
			if (valor.toString().equals("%s"+opcaoJogada+"%s"+opcaoJogada+"-*-X-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"%s"+opcaoJogada+"X*-X-*---");
				jogada = false;
			} // 1,1*
			if (valor.toString().equals("%s"+opcaoJogada+"-%s"+opcaoJogada+"*-X-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"X%s"+opcaoJogada+"*-X-*---");
				jogada = false;
			} // 1,2*
			if (valor.toString().equals("%s"+opcaoJogada+"--*%s"+opcaoJogada+"X-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*%s"+opcaoJogada+"X-*X--");
				jogada = false;
			} // 1,3*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-X%s"+opcaoJogada+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"X-*-X%s"+opcaoJogada+"*---");
				jogada = false;
			} // 1,4*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-X-*%s"+opcaoJogada+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*XX-*%s"+opcaoJogada+"--");
				jogada = false;
			} // 1,5*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-X-*-%s"+opcaoJogada+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*XX-*-%s"+opcaoJogada+"-");
				jogada = false;
			} // 1,6*
			if (valor.toString().equals("%s"+opcaoJogada+"--*-X-*--%s"+opcaoJogada+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*-XX*--%s"+opcaoJogada+"");
				jogada = false;
			} // 1,7*


		}

	}

	@Override
	public OpcaoDeJogo opcaoDeJogo(String opcao) {
		if (opcao == "x") {
			return OpcaoDeJogo.O;
		}
		return OpcaoDeJogo.X;
	}

}
