/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import dtoAtividades.Formula;
import static dtoConcorrencia.Arrays.listaAtividades;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import persist.PersistenciaDao;

/**
 *
 * @author felipe
 */
public class Geral implements Serializable {

    static PersistenciaDao pers = new PersistenciaDao();

    public static String listaFormulas(int id) throws Exception, SQLException, ConstraintViolationException {
        String formula = "";
        List<Formula> lista = pers.listar(Formula.class);

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getIdFormula() == id) {
                formula = lista.get(i).getDescricao();
            }
        }
        return formula;
    }
    
        public static int buscaId(String codigo) {
        int id = 0;

        for (int i = 0; i < listaAtividades.size(); i++) {
            if (listaAtividades.get(i).getCodigo().equals(codigo)) {
                id = listaAtividades.get(i).getIdAtividade();
            }
        }
        return id;
    }

    public static void buscaAreaMae(int id) {

        for (int i = 0; i < listaAtividades.size(); i++) {
            if (listaAtividades.get(i).getIdAtividade() == id ) {
                if (listaAtividades.get(i).getIdAtividadeMae() == 0) {
                    System.out.println("Atividade1: " + listaAtividades.get(i).getDescricao());
                    System.out.println("Atv Mae1: " + listaAtividades.get(i).getIdAtividadeMae());
                    break;
                }
                else{
                    buscaAreaMae(listaAtividades.get(i).getIdAtividadeMae());
                }
            }
        }
    }

    public static void main(String[] args) {

        buscaAreaMae(100);
//        int b = 0;
//        for (int i = 0; i < listaAtividades.size(); i++) {
//            if (listaAtividades.get(i).getIdAtividadeMae() == 0) {
//                b++;
//                System.out.println(listaAtividades.get(i).getDescricao());
//            }
//        }
//        System.out.println(b);
    }
}