/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.dao;

import dtoDocentes.Usuario;
import persist.PersistenciaDao;
import java.util.List;

/**
 *
 * @author Geovane
 */
public class UsuarioDao implements GenericoDao {

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
        return persistencia.listar(Usuario.class);
    }
}