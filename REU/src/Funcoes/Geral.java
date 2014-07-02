/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcoes;

import dtoAtividades.Formula;
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
}