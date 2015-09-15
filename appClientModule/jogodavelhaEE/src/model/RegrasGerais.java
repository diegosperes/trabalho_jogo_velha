/**
 * 
 */
package jogodavelhaEE.src.model;

import jogodavelhaEE.src.model.util.OpcaoDeJogo;

/**
 * @author kaueh
 *
 */
public interface RegrasGerais {

	public void RegraGeral(StringBuilder valor, boolean jogada,String opcao);
	public OpcaoDeJogo opcaoDeJogo(String opcao);

}
