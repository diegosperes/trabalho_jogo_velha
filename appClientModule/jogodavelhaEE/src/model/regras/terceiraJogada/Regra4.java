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
public class Regra4 implements RegrasGerais {

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#RegraGeral(java.lang.StringBuilder, boolean, java.lang.String)
	 */
	@Override
	public void RegraGeral(StringBuilder valor, boolean jogada, String opcao) {
		if(opcao.equals("X") && opcao!= null){
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"O%s"+opcao+"*O--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-Q*%s"+opcao+"Q%s"+opcao+"*Q--");
				jogada = false;
			} // 1,3,3
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"O%s"+opcao+"*O%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-Q*%s"+opcao+"Q%s"+opcao+"*Q%s"+opcao+"-");
				jogada = false;
			} // 1,3,4
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"O-*O-%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-Q*%s"+opcao+"Q-*Q-%s"+opcao+"");
				jogada = false;
			} // 1,3,5

			if (valor.toString().equals("%s"+opcao+"Ox*-O%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*%s"+opcao+"Q%s"+opcao+"*-Q-");
				jogada = false;
			} // 1,4,1
			if (valor.toString().equals("%s"+opcao+"O-*%s"+opcao+"O%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*%s"+opcao+"Q%s"+opcao+"*-Q-");
				jogada = false;
			} // 1,4,2
			if (valor.toString().equals("%s"+opcao+"O-*-O%s"+opcao+"*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*-Q%s"+opcao+"*%s"+opcao+"Q-");
				jogada = false;
			} // 1,4,3
			if (valor.toString().equals("%s"+opcao+"O-*-O%s"+opcao+"*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"O-*-O%s"+opcao+"*O%s"+opcao+"-");
				jogada = false;
			} // 1,4,4*
			if (valor.toString().equals("%s"+opcao+"O-*-O%s"+opcao+"*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*-Q%s"+opcao+"*-Q%s"+opcao+"");
				jogada = false;
			} // 1,4,5

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*OO-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"-*QQQ*%s"+opcao+"--");
				jogada = false;
			} // 1,5,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*OO-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-%s"+opcao+"*QQQ*%s"+opcao+"--");
				jogada = false;
			} // 1,5,2
			if (valor.toString().equals("%s"+opcao+"--*OO%s"+opcao+"*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*OO%s"+opcao+"*%s"+opcao+"O-");
				jogada = false;
			} // 1,5,3*
			if (valor.toString().equals("%s"+opcao+"--*OO-*%s"+opcao+"%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"%s"+opcao+"-");
				jogada = false;
			} // 1,5,4
			if (valor.toString().equals("%s"+opcao+"--*OO-*%s"+opcao+"-%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"-%s"+opcao+"");
				jogada = false;
			} // 1,5,5
			
		}else if(opcao.equals("O") && opcao != null){
			
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"X%s"+opcao+"*X--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-Q*%s"+opcao+"Q%s"+opcao+"*Q--");
				jogada = false;
			} // 1,3,3
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"X%s"+opcao+"*X%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-Q*%s"+opcao+"Q%s"+opcao+"*Q%s"+opcao+"-");
				jogada = false;
			} // 1,3,4
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"X-*X-%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-Q*%s"+opcao+"Q-*Q-%s"+opcao+"");
				jogada = false;
			} // 1,3,5

			if (valor.toString().equals("%s"+opcao+"Xx*-X%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*%s"+opcao+"Q%s"+opcao+"*-Q-");
				jogada = false;
			} // 1,4,1
			if (valor.toString().equals("%s"+opcao+"X-*%s"+opcao+"X%s"+opcao+"*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*%s"+opcao+"Q%s"+opcao+"*-Q-");
				jogada = false;
			} // 1,4,2
			if (valor.toString().equals("%s"+opcao+"X-*-X%s"+opcao+"*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*-Q%s"+opcao+"*%s"+opcao+"Q-");
				jogada = false;
			} // 1,4,3
			if (valor.toString().equals("%s"+opcao+"X-*-X%s"+opcao+"*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"X-*-X%s"+opcao+"*X%s"+opcao+"-");
				jogada = false;
			} // 1,4,4*
			if (valor.toString().equals("%s"+opcao+"X-*-X%s"+opcao+"*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"Q-*-Q%s"+opcao+"*-Q%s"+opcao+"");
				jogada = false;
			} // 1,4,5

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*XX-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"-*QQQ*%s"+opcao+"--");
				jogada = false;
			} // 1,5,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*XX-*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-%s"+opcao+"*QQQ*%s"+opcao+"--");
				jogada = false;
			} // 1,5,2
			if (valor.toString().equals("%s"+opcao+"--*XX%s"+opcao+"*%s"+opcao+"--") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*XX%s"+opcao+"*%s"+opcao+"X-");
				jogada = false;
			} // 1,5,3*
			if (valor.toString().equals("%s"+opcao+"--*XX-*%s"+opcao+"%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"%s"+opcao+"-");
				jogada = false;
			} // 1,5,4
			if (valor.toString().equals("%s"+opcao+"--*XX-*%s"+opcao+"-%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"-%s"+opcao+"");
				jogada = false;
			} // 1,5,5
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
