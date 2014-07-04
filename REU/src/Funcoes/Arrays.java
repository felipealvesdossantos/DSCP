/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import dtoAtividades.Atividade;
import dtoAtividades.Formula;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import persist.PersistenciaDao;

/**
 *
 * @author felipe
 */
public class Arrays {

    public static List<Atividade> listaAtividades = listaAtv();
    public static List<Formula> listaFormulas = listaFor();
    public static final Map<Integer,Integer> mapaAreas = new HashMap<Integer, Integer>();

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
    
    public static void popularMapaAreas() {

        for (int i = 0; i < listaAtividades.size(); i++) {
            if (listaAtividades.get(i).getIdAtividadeMae() == 0) {
                mapaAreas.put(listaAtividades.get(i).getIdAtividade(), new Integer(0));
            }
        }
    }

    public static Map<Integer, Integer> getMapaAreas() {
        popularMapaAreas();
        return mapaAreas;
    }
    
    
}
