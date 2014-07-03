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

    public static List<Atividade> listaAtividades = listaAtv();
    public static List<Formula> listaFormulas = listaFor();
    public static ArrayList<Integer> listaAreaMae = new ArrayList<Integer>();

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
}
