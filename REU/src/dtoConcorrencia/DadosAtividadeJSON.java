package dtoConcorrencia;

import java.util.List;

/**
 *
 * @author eric
 */
public class DadosAtividadeJSON {
    private String idAtividade;
    private List<Integer> parametros;

    public String getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(String idAtividade) {
        this.idAtividade = idAtividade;
    }

    public List<Integer> getParametros() {
        return parametros;
    }

    public void setParametros(List<Integer> parametros) {
        this.parametros = parametros;
    }
}
