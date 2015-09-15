/**
 * 
 */
package jogodavelhaEE.src.model.regras.terceiraJogada.casa1;

import jogodavelhaEE.src.model.RegrasGerais;
import jogodavelhaEE.src.model.util.OpcaoDeJogo;

/**
 * @author kaueh
 *
 */
public class Regra5 implements RegrasGerais {

	/* (non-Javadoc)
	 * @see jogodavelhaEE.src.model.RegrasGerais#RegraGeral(java.lang.StringBuilder, boolean, java.lang.String)
	 */
	@Override
	public void RegraGeral(StringBuilder valor, boolean jogada, String opcao) {
		if(opcao.equals("X") && opcao != null){

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*OO-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"-*QQQ*-%s"+opcao+"-");
				jogada = false;
			} // 1,6,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*OO-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-%s"+opcao+"*QQQ*-%s"+opcao+"-");
				jogada = false;
			} // 1,6,2
			if (valor.toString().equals("%s"+opcao+"--*OO%s"+opcao+"*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-O*OO%s"+opcao+"*-%s"+opcao+"-");
				jogada = false;
			} // 1,6,3*
			if (valor.toString().equals("%s"+opcao+"--*OO-*%s"+opcao+"%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"%s"+opcao+"-");
				jogada = false;
			} // 1,6,4
			if (valor.toString().equals("%s"+opcao+"--*OO-*-%s"+opcao+"%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*-%s"+opcao+"%s"+opcao+"");
				jogada = false;
			} // 1,6,5

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*-OO*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"-*QQQ*--%s"+opcao+"");
				jogada = false;
			} // 1,7,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*-OO*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-%s"+opcao+"*QQQ*--%s"+opcao+"");
				jogada = false;
			} // 1,7,2
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"OO*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*%s"+opcao+"OO*O-%s"+opcao+"");
				jogada = false;
			} // 1,7,3*
			if (valor.toString().equals("%s"+opcao+"--*-OO*%s"+opcao+"-%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"-%s"+opcao+"");
				jogada = false;
			} // 1,7,4
			if (valor.toString().equals("%s"+opcao+"--*-OO*-%s"+opcao+"%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*-%s"+opcao+"%s"+opcao+"");
				jogada = false;
			} // 1,7,5
			
		}else if(opcao.equals("O")&& opcao != null){
			

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*XX-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"-*QQQ*-%s"+opcao+"-");
				jogada = false;
			} // 1,6,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*XX-*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-%s"+opcao+"*QQQ*-%s"+opcao+"-");
				jogada = false;
			} // 1,6,2
			if (valor.toString().equals("%s"+opcao+"--*XX%s"+opcao+"*-%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-X*XX%s"+opcao+"*-%s"+opcao+"-");
				jogada = false;
			} // 1,6,3*
			if (valor.toString().equals("%s"+opcao+"--*XX-*%s"+opcao+"%s"+opcao+"-") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"%s"+opcao+"-");
				jogada = false;
			} // 1,6,4
			if (valor.toString().equals("%s"+opcao+"--*XX-*-%s"+opcao+"%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*-%s"+opcao+"%s"+opcao+"");
				jogada = false;
			} // 1,6,5

			if (valor.toString().equals("%s"+opcao+"%s"+opcao+"-*-XX*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"%s"+opcao+"-*QQQ*--%s"+opcao+"");
				jogada = false;
			} // 1,7,1
			if (valor.toString().equals("%s"+opcao+"-%s"+opcao+"*-XX*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"-%s"+opcao+"*QQQ*--%s"+opcao+"");
				jogada = false;
			} // 1,7,2
			if (valor.toString().equals("%s"+opcao+"--*%s"+opcao+"XX*--%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*%s"+opcao+"XX*X-%s"+opcao+"");
				jogada = false;
			} // 1,7,3*
			if (valor.toString().equals("%s"+opcao+"--*-XX*%s"+opcao+"-%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*%s"+opcao+"-%s"+opcao+"");
				jogada = false;
			} // 1,7,4
			if (valor.toString().equals("%s"+opcao+"--*-XX*-%s"+opcao+"%s"+opcao+"") && jogada) {
				valor.setLength(0);
				valor.append("%s"+opcao+"--*QQQ*-%s"+opcao+"%s"+opcao+"");
				jogada = false;
			} // 1,7,5

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
