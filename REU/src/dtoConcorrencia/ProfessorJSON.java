package dtoConcorrencia;

import Funcoes.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author eric
 */
public class ProfessorJSON {
    
    private String nomeProfessor;
    private long idProfessor;
    public List<DadosAtividadeJSON> listaAtividades;
    public Map<Integer, Integer> pontosAreas = new HashMap<Integer, Integer>();
//    private String idAtividade;
//    private List<Integer> parametros;
    
    public ProfessorJSON() {
        this.listaAtividades = new ArrayList<DadosAtividadeJSON>();
        pontosAreas = Arrays.mapaAreas;
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

//    public String getIdAtividade() {
//        return idAtividade;
//    }
//
//    public void setIdAtividade(String idAtividade) {
//        this.idAtividade = idAtividade;
//    }
//
//    public List<Integer> getParametros() {
//        return parametros;
//    }
//
//    public void setParametros(List<Integer> parametros) {
//        this.parametros = parametros;
//    }

    public List<DadosAtividadeJSON> getListaAtividades() {
        return listaAtividades;
    }
}
