/**
 * 
 */
package jogodavelhaEE.src.model.regras.primeiraJogada;

import jogodavelhaEE.src.model.RegrasGerais;
import jogodavelhaEE.src.model.util.OpcaoDeJogo;

/**
 * @author kaueh
 *
 */
public class Regras1 implements RegrasGerais {

	@Override
	public void RegraGeral(StringBuilder valor,boolean jogada,String opcaoJogada) {
		jogada = true;
		if(opcaoJogada.equals("X")&& opcaoJogada !=null){
			
			if (valor.toString().equals("%s"+opcaoJogada+"--*---*---") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcaoJogada+"--*-O-*---");
				jogada = false;
			} // 1*
			if (valor.toString().equals("-%s"+opcaoJogada+"-*---*---") && jogada) {
				valor.setLength(0);
				valor.append("-%s"+opcaoJogada+"-*-O-*---");
				jogada = false;
			} // 2*
			if (valor.toString().equals("--%s"+opcaoJogada+"*---*---") && jogada) {
				valor.setLength(0);
				valor.append("--%s"+opcaoJogada+"*-O-*---");
				jogada = false;
			} // 3*
			if (valor.toString().equals("---*%s"+opcaoJogada+"--*---") && jogada) {
				valor.setLength(0);
				valor.append("---*%s"+opcaoJogada+"O-*---");
				jogada = false;
			} // 4*
			if (valor.toString().equals("---*-%s"+opcaoJogada+"-*---") && jogada) {
				valor.setLength(0);
				valor.append("---*-%s"+opcaoJogada+"-*--O");
				jogada = false;
			} // 5*
			if (valor.toString().equals("---*--%s"+opcaoJogada+"*---") && jogada) {
				valor.setLength(0);
				valor.append("---*-O%s"+opcaoJogada+"*---");
				jogada = false;
			} // 6*
			if (valor.toString().equals("---*---*%s"+opcaoJogada+"--") && jogada) {
				valor.setLength(0);
				valor.append("---*-O-*%s"+opcaoJogada+"--");
				jogada = false;
			} // 7*
			if (valor.toString().equals("---*---*-%s"+opcaoJogada+"-") && jogada) {
				valor.setLength(0);
				valor.append("---*-O-*-%s"+opcaoJogada+"-");
				jogada = false;
			} // 8*
			if (valor.toString().equals("---*---*--%s"+opcaoJogada+"") && jogada) {
				valor.setLength(0);
				valor.append("---*-O-*--%s"+opcaoJogada+"");
				jogada = false;
			} //9*
		}else if(opcaoJogada.equals("O")&& opcaoJogada !=null){
				
				if (valor.toString().equals("%s"+opcaoJogada+"--*---*---") && jogada) {
					valor.setLength(0);
					valor.append("%s"+opcaoJogada+"--*-X-*---");
					jogada = false;
				} // 1*
				if (valor.toString().equals("-%s"+opcaoJogada+"-*---*---") && jogada) {
					valor.setLength(0);
					valor.append("-%s"+opcaoJogada+"-*-X-*---");
					jogada = false;
				} // 2*
				if (valor.toString().equals("--%s"+opcaoJogada+"*---*---") && jogada) {
					valor.setLength(0);
					valor.append("--%s"+opcaoJogada+"*-X-*---");
					jogada = false;
				} // 3*
				if (valor.toString().equals("---*%s"+opcaoJogada+"--*---") && jogada) {
					valor.setLength(0);
					valor.append("---*%s"+opcaoJogada+"X-*---");
					jogada = false;
				} // 4*
				if (valor.toString().equals("---*-%s"+opcaoJogada+"-*---") && jogada) {
					valor.setLength(0);
					valor.append("---*-%s"+opcaoJogada+"-*--X");
					jogada = false;
				} // 5*
				if (valor.toString().equals("---*--%s"+opcaoJogada+"*---") && jogada) {
					valor.setLength(0);
					valor.append("---*-X%s"+opcaoJogada+"*---");
					jogada = false;
				} // 6*
				if (valor.toString().equals("---*---*%s"+opcaoJogada+"--") && jogada) {
					valor.setLength(0);
					valor.append("---*-X-*%s"+opcaoJogada+"--");
					jogada = false;
				} // 7*
				if (valor.toString().equals("---*---*-%s"+opcaoJogada+"-") && jogada) {
					valor.setLength(0);
					valor.append("---*-X-*-%s"+opcaoJogada+"-");
					jogada = false;
				} // 8*
				if (valor.toString().equals("---*---*--%s"+opcaoJogada+"") && jogada) {
					valor.setLength(0);
					valor.append("---*-X-*--%s"+opcaoJogada+"");
					jogada = false;
				} //9*
			
		}

	}

	@Override
	public OpcaoDeJogo opcaoDeJogo(String opcao) {
		if(opcao =="x"){
			return OpcaoDeJogo.O;
		}
		return OpcaoDeJogo.X;
	}


}
