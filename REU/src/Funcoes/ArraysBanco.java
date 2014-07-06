package Funcoes;

import dtoAtividades.Atividade;
import dtoAtividades.Formula;
import dtoConcorrencia.LeitorJSON;
import dtoConcorrencia.ProfessorJSON;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import persist.PersistenciaDao;

/**
 * Classe que contém as variáveis globais que armazenam os dados do banco.
 * Ela também armazena uma ArrayList com o JSON que foi lido.
 * 
 * @author felipe
 */
public class ArraysBanco {

    /* Armazena todas as atividades do banco */
    public static List<Atividade> listaAtividades = listaAtv();
    /* Armazena todas as fórmulas do banco */
    public static List<Formula> listaFormulas = listaFor();
    public static List<Integer> listaIdAreas = new ArrayList<Integer>();
    
    /* Faz um mapa de todas as áreas existentes no banco.
       O mapa contém o idAtividade como chave e um int como valor */
    public static final Map<Integer,Integer> mapaAreas = new HashMap<Integer, Integer>();
    /* Armazena todo o conteúdo do JSON lido */
    public static List<ProfessorJSON> jsonLido;
    
    static Atividade atv = new Atividade();

    /* Popula a listaAtividades */
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
    
    /* Popula a listaFormulas */
    public static List listaFor() {
        List<Atividade> lista = null;

        try {
            PersistenciaDao pers = new PersistenciaDao();
            lista = pers.listar(Formula.class);
        } catch (Exception ex) {
            System.out.println("Erros ao buscar lista de Formulas: " + ex.getMessage());
        }
        return lista;
    }
    
    /* Popula o mapaAreas */
    public static void popularMapaAreas() {

        for (int i = 0; i < listaAtividades.size(); i++) {
            if (listaAtividades.get(i).getIdAtividadeMae() == 0) {
                mapaAreas.put(listaAtividades.get(i).getIdAtividade(), new Integer(0));
                listaIdAreas.add(listaAtividades.get(i).getIdAtividade());
            }
        }
    }

    /* Retorna o mapaAreas */
    public static Map<Integer, Integer> getMapaAreas() {
        popularMapaAreas();
        return mapaAreas;
    }
        
    /* Popula o jsonLido */
    public static List populaJsonLido(String arquivoJson) {
        List<ProfessorJSON> lista = new ArrayList<ProfessorJSON>();
        LeitorJSON leitor = new LeitorJSON(new File(arquivoJson));
        lista = leitor.getListaProfessoresJSON();
        return lista;
    }

    /*
     Busca uma atividade em especifico atraves do seu codigo
     */
    public static Atividade buscaAtividade(String codigo) {
        int id = 0;
        Atividade atv = null;

        for (int i = 0; i < ArraysBanco.listaAtividades.size(); i++) {
            if (ArraysBanco.listaAtividades.get(i).getCodigo().equals(codigo)) {
                id = ArraysBanco.listaAtividades.get(i).getIdAtividade();
                atv = ArraysBanco.listaAtividades.get(i);
            }
        }
        return atv;
    }

    /*
     Busca uma formula em especifica atraves do seu id
     */
    public static String buscaFormula(int id) {
        String formula = "";

        for (int i = 0; i < ArraysBanco.listaFormulas.size(); i++) {
            if (ArraysBanco.listaFormulas.get(i).getIdFormula() == id) {
                formula = ArraysBanco.listaFormulas.get(i).getDescricao();
            }
        }
        return formula;
    }

    /*
     Busca uma area mae recursivamente atraves do id de uma atividade
     */
    public static Atividade buscaAreaMae(int id) {

        for (int i = 0; i < ArraysBanco.listaAtividades.size(); i++) {
            if (ArraysBanco.listaAtividades.get(i).getIdAtividade() == id) {

                if (ArraysBanco.listaAtividades.get(i).getIdAtividadeMae() == 0) {
                    atv = ArraysBanco.listaAtividades.get(i);
                    break;
                } else {
                    buscaAreaMae(ArraysBanco.listaAtividades.get(i).getIdAtividadeMae());
                }
            }
        }
        return atv;
    }
}
