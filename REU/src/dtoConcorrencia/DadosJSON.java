package dtoConcorrencia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric
 */
public class DadosJSON {
    
    private String nomeProfessor;
    private long idProfessor;
    public List<DadosAtividadeJSON> listaAtividades;
    private String idAtividade;
    private List<Integer> parametros;
    
    public DadosJSON() {
        this.listaAtividades = new ArrayList<DadosAtividadeJSON>();    
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(long idProfessor) {
        this.idProfessor = idProfessor;
    }

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

    public List<DadosAtividadeJSON> getListaAtividades() {
        return listaAtividades;
    }
}
