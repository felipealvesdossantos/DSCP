/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dtoConcorrencia;

import dtoAtividades.Atividade;
import dtoAtividades.Formula;
import java.util.ArrayList;
import java.util.List;
import persist.PersistenciaDao;

/**
 *
 * @author felipe
 */
public class Arrays {

    public static List<Atividade> listaAtividade = listaAtv();
    public static ArrayList<Integer> listaAreaMae = new ArrayList<Integer>();
    public static List<Formula> listaFormulas = criarListaFormulas();

    /*
        Sugestão de uso:
        HashMap em vez de ArrayList na listaAreaMae.
        Ex.:
            Map<Integer, Integer> mapaAreas = new HashMap<Integer, Integer>();
            Neste caso, o primeiro Integer seria a chave (o id da area, por exemplo),
            e o segundo Integer seria a variável que vai acumular os pontos da área.
    
            
            Para adicionar pontos na area mãe, basta chamar algo do tipo:
            public static void adicionaPontosArea(int idArea, int pontos) {
                if (mapaAreas.containsKey(id) {
                        mapaAreas.put(idArea, mapaAreas.get(idArea) + pontos);
                } else {
                    System.out.println("Erro ao buscar no HashMap: id da area: "+id);
            }
         
         Possivelmente, usar HashMap na lista de Atividades pode melhorar consideravelmente a performance.
         Enquanto na ArrayList é necessario percorrer toda a lista até chegar na atividade que queremos,
         no HashMap essa busca é feita de forma muito mais direta. É uma abordagem a se pensar.
    */
    public static List listaAtv() {
        List<Atividade> lista = null;

        try {
            PersistenciaDao pers = new PersistenciaDao();
            lista = pers.listar(Atividade.class);
        } catch (Exception ex) {
            System.out.println("Erros ao buscar lista de Atividades: " + ex.getMessage());
        }
        return lista;
    }
    
    public static List criarListaFormulas() {
        List<Atividade> lista = null;

        try {
            PersistenciaDao pers = new PersistenciaDao();
            lista = pers.listar(Formula.class);
        } catch (Exception ex) {
            System.out.println("Erro ao buscar lista de Formulas: " + ex.getMessage());
        }
        return lista;
    }

    public static int buscaId(String codigo) {
        int id = 0;

        for (int i = 0; i < listaAtividade.size(); i++) {
            if (listaAtividade.get(i).getCodigo().equals(codigo)) {
                id = listaAtividade.get(i).getIdAtividade();
            }
        }
        return id;
    }

    public static int id(int codigoMae) {
        int idMae = 0;
        for (int i = 0; i < listaAtividade.size(); i++) {
            if (listaAtividade.get(i).getIdAtividadeMae() == codigoMae) {
                idMae = listaAtividade.get(i).getIdAtividade();
            }
        }
        return idMae;
    }

    public static void buscaAreaMae(int id) {
        for (int i = 0; i < listaAtividade.size(); i++) {
            if (listaAtividade.get(i).getIdAtividade() == id && listaAtividade.get(i).getIdAtividadeMae() != 0) {
                //System.out.println("Atv: " + listaAtividade.get(i).getIdAtividadeMae());
                buscaAreaMae(id(listaAtividade.get(i).getIdAtividadeMae()));
            } else{
                System.out.println("Atv: " + listaAtividade.get(i).getIdAtividadeMae());
                break;
            }

        }

    }

    public static void main(String[] args) {
        
        buscaAreaMae(48);
//        int b = 0;
//        for (int i = 0; i < listaAtividade.size(); i++) {
//            if (listaAtividade.get(i).getIdAtividadeMae() == 0) {
//                b++;
//                System.out.println(listaAtividade.get(i).getDescricao());
//            }
//        }
//        System.out.println(b);
    }
}
