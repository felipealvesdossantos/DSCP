/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package REU.persist.dao;

import REU.dto.Usuario;
import REU.persist.PersistenciaDao;
import java.util.List;

/**
 *
 * @author Geovane
 */
public class UsuarioDao implements GenericoDao{
    
    PersistenciaDao persistencia = new PersistenciaDao();
    
    @Override
    public void recebeDto(Object object) throws Exception{
            persistencia.salvar(object);
    }
    
    public List listarTodos() throws Exception{
        PersistenciaDao pdao = new PersistenciaDao();
        
        return pdao.listar(Usuario.class);
    }
}
