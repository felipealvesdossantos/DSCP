package dtoConcorrencia;

import java.util.List;

/**
 *
 * @author eric
 */
public class DadosAtividadeJSON {
    private String codAtividade;
    private List<Integer> parametros;

    public String getCodAtividade() {
        return codAtividade;
    }

    public void setCodAtividade(String codAtividade) {
        this.codAtividade = codAtividade;
    }

    public List<Integer> getParametros() {
        return parametros;
    }

    public void setParametros(List<Integer> parametros) {
        this.parametros = parametros;
    }
}
