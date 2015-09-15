/**
 * 
 */
package jogodavelhaEE.src.model.regras.terceiraJogada;

import jogodavelhaEE.src.model.RegrasGerais;
import jogodavelhaEE.src.model.util.OpcaoDeJogo;

/**
 * @author kaueh
 *
 */
public class Regra3 implements RegrasGerais {

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#RegraGeral(java.lang.StringBuilder, boolean, java.lang.String)
	 */
	@Override
	public void RegraGeral(StringBuilder valor, boolean jogada, String opcao) {
		if(opcao.equals("X") && opcao != null){
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"O*%s"+opcao+"O-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*%s"+opcao+"Q- Q--");
				jogada = false;
			} // 1,1,1
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"O*-O%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*-Q%s"+opcao+" Q--");
				jogada = false;
			} // 1,1,2
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"O*-O-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"O*OO-*%s"+opcao+"--");
				jogada = false;
			} // 1,1,3*
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"O*-O-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*-Q- Q%s"+opcao+"-");
				jogada = false;
			} // 1,1,4
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"O*-O-*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*-Q- Q-%s"+opcao+"");
				jogada = false;
			} // 1,1,5

			if (valor.toString().equals("%s"+opcao+"O%s"+opcao+"*%s"+opcao+"O-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*%s"+opcao+"Q-*-Q-");
				jogada = false;
			} // 1,2,1
			if (valor.toString().equals("%s"+opcao+"O%s"+opcao+"*-O%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*-Q%s"+opcao+"*-Q-");
				jogada = false;
			} // 1,2,2
			if (valor.toString().equals("%s"+opcao+"O%s"+opcao+"*-O-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*-Q-*%s"+opcao+"Q-");
				jogada = false;
			} // 1,2,3
			if (valor.toString().equals("%s"+opcao+"O%s"+opcao+"*-O-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"O%s"+opcao+"*-OO*-%s"+opcao+"-");
				jogada = false;
			} // 1,2,4*
			if (valor.toString().equals("%s"+opcao+"O%s"+opcao+"*-O-*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*-Q-*-Q%s"+opcao+"");
				jogada = false;
			} // 1,2,5

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*%s"+opcao+"O-*O--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*%s"+opcao+"Q-*Q--");
				jogada = false;
			} // 1,3,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*%s"+opcao+"O-*O--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"O%s"+opcao+"*%s"+opcao+"O-*O--");
				jogada = false;
			} // 1,3,2*
			
		}else if(opcao.equals("O") && opcao != null){
			
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"X*%s"+opcao+"X-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*%s"+opcao+"Q- Q--");
				jogada = false;
			} // 1,1,1
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"X*-X%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*-Q%s"+opcao+" Q--");
				jogada = false;
			} // 1,1,2
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"X*-X-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"X*XX-*%s"+opcao+"--");
				jogada = false;
			} // 1,1,3*
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"X*-X-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*-Q- Q%s"+opcao+"-");
				jogada = false;
			} // 1,1,4
			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"X*-X-*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*-Q- Q-%s"+opcao+"");
				jogada = false;
			} // 1,1,5

			if (valor.toString().equals("%s"+opcao+"X%s"+opcao+"*%s"+opcao+"X-*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*%s"+opcao+"Q-*-Q-");
				jogada = false;
			} // 1,2,1
			if (valor.toString().equals("%s"+opcao+"X%s"+opcao+"*-X%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*-Q%s"+opcao+"*-Q-");
				jogada = false;
			} // 1,2,2
			if (valor.toString().equals("%s"+opcao+"X%s"+opcao+"*-X-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*-Q-*%s"+opcao+"Q-");
				jogada = false;
			} // 1,2,3
			if (valor.toString().equals("%s"+opcao+"X%s"+opcao+"*-X-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"X%s"+opcao+"*-XX*-%s"+opcao+"-");
				jogada = false;
			} // 1,2,4*
			if (valor.toString().equals("%s"+opcao+"X%s"+opcao+"*-X-*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q%s"+opcao+"*-Q-*-Q%s"+opcao+"");
				jogada = false;
			} // 1,2,5

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*%s"+opcao+"X-*X--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"Q*%s"+opcao+"Q-*Q--");
				jogada = false;
			} // 1,3,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*%s"+opcao+"X-*X--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"X%s"+opcao+"*%s"+opcao+"X-*X--");
				jogada = false;
			} // 1,3,2*
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
