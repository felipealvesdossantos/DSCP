/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persist.dao;

import dtoAtividades.Atividade;
import java.util.List;
import persist.PersistenciaDao;

/**
 *
 * @author Geovane
 */
public class AtividadeDao implements GenericoDao{
    
    PersistenciaDao persistencia = new PersistenciaDao();
    
    @Override
    public void recebeDto(Object object) throws Exception{
            persistencia.salvar(object);
    }
    
    public List listarTodos() throws Exception{
        PersistenciaDao pdao = new PersistenciaDao();
        
        return pdao.listar(Atividade.class);
    }
}