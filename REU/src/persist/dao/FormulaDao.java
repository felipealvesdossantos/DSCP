/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.dao;

import dtoAtividades.Formula;
import dtoDocentes.Usuario;
import java.util.List;
import persist.PersistenciaDao;

/**
 *
 * @author felipe
 */
public class FormulaDao implements GenericoDao{

     @Override
    public void insert(Object object) throws Exception {
        PersistenciaDao persistencia = new PersistenciaDao();
        persistencia.salvar(object);
    }

    @Override
    public void update(Object object) throws Exception {
        PersistenciaDao persistencia = new PersistenciaDao();
        persistencia.alterar(object);
    }

    @Override
    public void delete(Object object) throws Exception {
        PersistenciaDao persistencia = new PersistenciaDao();
        persistencia.excluir(object);
    }

    @Override
    public List list() throws Exception {
        PersistenciaDao persistencia = new PersistenciaDao();
        return persistencia.listar(Formula.class);
    }
    
}
