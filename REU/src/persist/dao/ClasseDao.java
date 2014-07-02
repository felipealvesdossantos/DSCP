/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package persist.dao;

import dtoDocentes.Classe;
import java.util.List;
import persist.PersistenciaDao;

/**
 *
 * @author GAOliveira
 */
public class ClasseDao {
    
    PersistenciaDao persistencia = new PersistenciaDao();
    
    public void recebeDto(Object object) throws Exception{
            persistencia.salvar(object);
    }
    
    public List listarTodos() throws Exception{
        PersistenciaDao pdao = new PersistenciaDao();
        
        return pdao.listar(Classe.class);
    }
    
     public static void excluir(Classe classe) throws Exception{
        PersistenciaDao persistenciaDao = new PersistenciaDao();
        persistenciaDao.excluir(classe);

    }
    
}
