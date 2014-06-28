/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.dao;

import dtoDocentes.Docente;
import dtoDocentes.Nivel;
import java.util.List;
import persist.PersistenciaDao;

/**
 *
 * @author felipe
 */
public class DocenteDao implements GenericoDao{
    
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
        return persistencia.listar(Docente.class);
    }
    
}
