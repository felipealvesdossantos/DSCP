/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.dao;

import dtoAtividades.Area;
import persist.PersistenciaDao;
import java.util.List;

/**
 *
 * @author Geovane
 */
public class AreaDao implements GenericoDao{
    
    PersistenciaDao persistencia = new PersistenciaDao();
    
    @Override
    public void recebeDto(Object object) throws Exception{
            persistencia.salvar(object);
    }
    
    public List listarTodos() throws Exception{
        PersistenciaDao pdao = new PersistenciaDao();
        
        return pdao.listar(Area.class);
    }
}